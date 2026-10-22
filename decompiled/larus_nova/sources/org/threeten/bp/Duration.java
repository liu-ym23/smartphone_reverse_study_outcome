package org.threeten.bp;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdk.announcement.AnnouncementViewModel;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.ttm.player.C;
import com.ttnet.org.chromium.base.TimeUtils;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Marker;
import org.threeten.bp.format.DateTimeParseException;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.e;
import org.threeten.bp.temporal.i;
import zwc.d;

/* JADX INFO: loaded from: classes41.dex */
public final class Duration implements e, Comparable<Duration>, Serializable {
    public static final Duration ZERO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BigInteger f526239a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f526240b = null;
    private static final long serialVersionUID = 3078945930695997490L;
    private final int nanos;
    private final long seconds;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f526241a = null;

        static {
            int[] r100 = new int[ChronoUnit.values().length];
            f526241a = r100;
            r100[ChronoUnit.NANOS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f526241a[ChronoUnit.MICROS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f526241a[ChronoUnit.MILLIS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f526241a[ChronoUnit.SECONDS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    @Override // org.threeten.bp.temporal.e
    public List<i> getUnits() {
        return Collections.unmodifiableList(Arrays.asList(new ChronoUnit[]{ChronoUnit.SECONDS, ChronoUnit.NANOS}));
    }

    static {
        ZERO = new Duration(0, 0);
        f526239a = BigInteger.valueOf(C.NANOS_PER_SECOND);
        f526240b = PatternProtector.compile("([-+]?)P(?:([-+]?[0-9]+)D)?(T(?:([-+]?[0-9]+)H)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)(?:[.,]([0-9]{0,9}))?S)?)?", 2);
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 1, this);
    }

    public int hashCode() {
        long r100 = this.seconds;
        return ((int) (r100 ^ (r100 >>> 32))) + (this.nanos * 51);
    }

    public boolean isNegative() {
        if (this.seconds >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isZero() {
        if ((this.seconds | ((long) this.nanos)) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public Duration negated() {
        return multipliedBy(-1);
    }

    public long toDays() {
        return this.seconds / 86400;
    }

    public long toHours() {
        return this.seconds / TimeUtils.SECONDS_PER_HOUR;
    }

    public long toMillis() {
        return d.f(d.h(this.seconds, 1000), this.nanos / 1000000);
    }

    public long toMinutes() {
        return this.seconds / 60;
    }

    public long toNanos() {
        return d.f(d.h(this.seconds, 1000000000), this.nanos);
    }

    public String toString() {
        if (this != ZERO) goto L6;
        return "PT0S";
    L6:
        long r100 = this.seconds;
        long r101 = r100 / TimeUtils.SECONDS_PER_HOUR;
        int r102 = (int) ((r100 % TimeUtils.SECONDS_PER_HOUR) / 60);
        int r103 = (int) (r100 % 60);
        StringBuilder r104 = new StringBuilder(24);
        r104.append("PT");
        if (r101 == 0) goto L9;
        r104.append(r101);
        r104.append('H');
    L9:
        if (r102 == 0) goto L11;
        r104.append(r102);
        r104.append('M');
    L11:
        if (r103 == 0) goto L13;
    L18:
        if (r103 < 0) goto L20;
    L25:
        r104.append(r103);
    L27:
        if (this.nanos <= 0) goto L36;
        int r105 = r104.length();
        if (r103 >= 0) goto L31;
        r104.append(2000000000 - this.nanos);
    L33:
        if (r104.charAt(r104.length() - 1) != '0') goto L35;
        r104.setLength(r104.length() - 1);
        goto L33
    L35:
        r104.setCharAt(r105, '.');
        goto L36
    L31:
        r104.append(this.nanos + 1000000000);
    L36:
        r104.append('S');
        return r104.toString();
    L20:
        if (this.nanos <= 0) goto L25;
        if (r103 != (-1)) goto L24;
        r104.append("-0");
        goto L27
    L24:
        r104.append(r103 + 1);
        goto L27
    L13:
        if (this.nanos != 0) goto L18;
        if (r104.length() <= 2) goto L18;
        return r104.toString();
    }

    public Duration abs() {
        if (isNegative() == false) goto L6;
        return negated();
    L6:
        return this;
    }

    public int getNano() {
        return this.nanos;
    }

    public long getSeconds() {
        return this.seconds;
    }

    public static Duration b(BigDecimal r100) {
        BigInteger r101 = r100.movePointRight(9).toBigIntegerExact();
        BigInteger[] r102 = r101.divideAndRemainder(f526239a);
        if (r102[0].bitLength() > 63) goto L7;
        return ofSeconds(r102[0].longValue(), r102[1].intValue());
    L7:
        throw new ArithmeticException("Exceeds capacity of Duration: " + r101);
    }

    public static Duration from(e r100) {
        d.d(r100, "amount");
        Duration r101 = ZERO;
        Iterator<i> r102 = r100.getUnits().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        i r103 = r102.next();
        r101 = r101.plus(r100.get(r103), r103);
        goto L4
    L6:
        return r101;
    }

    public static Duration ofDays(long r100) {
        return a(d.h(r100, 86400), 0);
    }

    public static Duration ofHours(long r100) {
        return a(d.h(r100, AnnouncementViewModel.HOUR_DURATION), 0);
    }

    public static Duration ofMillis(long r100) {
        long r101 = r100 / 1000;
        int r102 = (int) (r100 % 1000);
        if (r102 >= 0) goto L6;
        r102 = r102 + 1000;
        r101 = r101 - 1;
    L6:
        return a(r101, r102 * 1000000);
    }

    public static Duration ofMinutes(long r100) {
        return a(d.h(r100, 60), 0);
    }

    public static Duration ofNanos(long r100) {
        long r101 = r100 / C.NANOS_PER_SECOND;
        int r102 = (int) (r100 % C.NANOS_PER_SECOND);
        if (r102 >= 0) goto L6;
        r102 = r102 + 1000000000;
        r101 = r101 - 1;
    L6:
        return a(r101, r102);
    }

    public static Duration ofSeconds(long r100) {
        return a(r100, 0);
    }

    public static Duration parse(CharSequence r110) {
        d.d(r110, "text");
        Matcher r100 = f526240b.matcher(r110);
        if (r100.matches() == false) goto L42;
        if (ExifInterface.GPS_DIRECTION_TRUE.equals(r100.group(3)) == true) goto L42;
        int r101 = 1;
        boolean r102 = "-".equals(r100.group(1));
        String r103 = r100.group(2);
        String r104 = r100.group(4);
        String r105 = r100.group(5);
        String r106 = r100.group(6);
        String r107 = r100.group(7);
        if (r103 != null) goto L11;
        if (r104 != null) goto L11;
        if (r105 != null) goto L11;
        if (r106 == null) goto L42;
    L11:
        long r108 = c(r110, r103, 86400, "days");
        long r109 = c(r110, r104, AnnouncementViewModel.HOUR_DURATION, "hours");
        long r111 = c(r110, r105, 60, DocumentType.MINUTES_NAME);
        long r112 = c(r110, r106, 1, "seconds");
        if (r106 != null) goto L14;
    L16:
        boolean r113 = false;
    L17:
        if (r113 == false) goto L20;
        r101 = -1;
    L20:
        if (r107 != null) goto L22;
    L32:
        int r114 = 0;
    L43:
        long r115 = d.f(r108, d.f(r109, d.f(r111, r112)));     // Catch: ArithmeticException -> L38
        if (r102 == false) goto L37;
        return ofSeconds(r115, r114).negated();
    L37:
        return ofSeconds(r115, r114);
    L38:
        e = move-exception;
        throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: overflow", r110, 0).initCause(e));
    L22:
        if (r107.length() == 0) goto L32;
        r114 = CastIntegerProtector.parseInt(r107.concat("000000000").substring(0, 9)) * r101;
        goto L43
    L26:
        e = move-exception;
        throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: fraction", r110, 0).initCause(e));
    L29:
        e = move-exception;
        throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: fraction", r110, 0).initCause(e));
    L14:
        if (r106.charAt(0) != '-') goto L16;
        r113 = true;
    L42:
        throw new DateTimeParseException("Text cannot be parsed to a Duration", r110, 0);
    }

    public static Duration readExternal(DataInput r100) throws IOException {
        return ofSeconds(r100.readLong(), r100.readInt());
    }

    @Override // org.threeten.bp.temporal.e
    public org.threeten.bp.temporal.a addTo(org.threeten.bp.temporal.a r100) {
        long r101 = this.seconds;
        if (r101 == 0) goto L5;
        r100 = r100.plus(r101, ChronoUnit.SECONDS);
    L5:
        int r102 = this.nanos;
        if (r102 != 0) goto L8;
        return r100;
    L8:
        return r100.plus(r102, ChronoUnit.NANOS);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Duration r100) {
        int r101 = d.a(this.seconds, r100.seconds);
        if (r101 == 0) goto L6;
        return r101;
    L6:
        return this.nanos - r100.nanos;
    }

    public Duration dividedBy(long r100) {
        if (r100 == 0) goto L10;
        if (r100 != 1) goto L8;
        return this;
    L8:
        return b(BigDecimal.valueOf(this.seconds).add(BigDecimal.valueOf(this.nanos, 9)).divide(BigDecimal.valueOf(r100), RoundingMode.DOWN));
    L10:
        throw new ArithmeticException("Cannot divide by zero");
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Duration) == false) goto L14;
        Duration r101 = (Duration) r100;
        if (this.seconds == r101.seconds) goto L10;
    L12:
        return false;
    L10:
        if (this.nanos != r101.nanos) goto L12;
        return true;
    L14:
        return false;
    }

    @Override // org.threeten.bp.temporal.e
    public long get(i r100) {
        if (r100 != ChronoUnit.SECONDS) goto L7;
        return this.seconds;
    L7:
        if (r100 != ChronoUnit.NANOS) goto L11;
        return this.nanos;
    L11:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r100);
    }

    public Duration minus(Duration r100) {
        long r101 = r100.getSeconds();
        int r102 = r100.getNano();
        if (r101 != Long.MIN_VALUE) goto L7;
        return d(Long.MAX_VALUE, -r102).d(1, 0);
    L7:
        return d(-r101, -r102);
    }

    public Duration minusDays(long r100) {
        if (r100 != Long.MIN_VALUE) goto L6;
        return plusDays(Long.MAX_VALUE).plusDays(1);
    L6:
        return plusDays(-r100);
    }

    public Duration minusHours(long r100) {
        if (r100 != Long.MIN_VALUE) goto L6;
        return plusHours(Long.MAX_VALUE).plusHours(1);
    L6:
        return plusHours(-r100);
    }

    public Duration minusMillis(long r100) {
        if (r100 != Long.MIN_VALUE) goto L6;
        return plusMillis(Long.MAX_VALUE).plusMillis(1);
    L6:
        return plusMillis(-r100);
    }

    public Duration minusMinutes(long r100) {
        if (r100 != Long.MIN_VALUE) goto L6;
        return plusMinutes(Long.MAX_VALUE).plusMinutes(1);
    L6:
        return plusMinutes(-r100);
    }

    public Duration minusNanos(long r100) {
        if (r100 != Long.MIN_VALUE) goto L6;
        return plusNanos(Long.MAX_VALUE).plusNanos(1);
    L6:
        return plusNanos(-r100);
    }

    public Duration minusSeconds(long r100) {
        if (r100 != Long.MIN_VALUE) goto L6;
        return plusSeconds(Long.MAX_VALUE).plusSeconds(1);
    L6:
        return plusSeconds(-r100);
    }

    public Duration multipliedBy(long r100) {
        if (r100 != 0) goto L7;
        return ZERO;
    L7:
        if (r100 != 1) goto L10;
        return this;
    L10:
        return b(BigDecimal.valueOf(this.seconds).add(BigDecimal.valueOf(this.nanos, 9)).multiply(BigDecimal.valueOf(r100)));
    }

    public Duration plus(Duration r100) {
        return d(r100.getSeconds(), r100.getNano());
    }

    public Duration plusDays(long r100) {
        return d(d.h(r100, 86400), 0);
    }

    public Duration plusHours(long r100) {
        return d(d.h(r100, AnnouncementViewModel.HOUR_DURATION), 0);
    }

    public Duration plusMillis(long r100) {
        return d(r100 / 1000, (r100 % 1000) * 1000000);
    }

    public Duration plusMinutes(long r100) {
        return d(d.h(r100, 60), 0);
    }

    public Duration plusNanos(long r100) {
        return d(0, r100);
    }

    public Duration plusSeconds(long r100) {
        return d(r100, 0);
    }

    @Override // org.threeten.bp.temporal.e
    public org.threeten.bp.temporal.a subtractFrom(org.threeten.bp.temporal.a r100) {
        long r101 = this.seconds;
        if (r101 == 0) goto L5;
        r100 = r100.minus(r101, ChronoUnit.SECONDS);
    L5:
        int r102 = this.nanos;
        if (r102 != 0) goto L8;
        return r100;
    L8:
        return r100.minus(r102, ChronoUnit.NANOS);
    }

    public Duration withNanos(int r100) {
        ChronoField.NANO_OF_SECOND.checkValidIntValue(r100);
        return a(this.seconds, r100);
    }

    public Duration withSeconds(long r100) {
        return a(r100, this.nanos);
    }

    public void writeExternal(DataOutput r100) throws IOException {
        r100.writeLong(this.seconds);
        r100.writeInt(this.nanos);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Duration r100) {
        return compareTo2(r100);
    }

    public Duration(long r100, int r101) {
        this.seconds = r100;
        this.nanos = r101;
    }

    public static Duration a(long r100, int r101) {
        if ((((long) r101) | r100) != 0) goto L7;
        return ZERO;
    L7:
        return new Duration(r100, r101);
    }

    public static Duration between(org.threeten.bp.temporal.a r110, org.threeten.bp.temporal.a r111) {
        ChronoUnit r100 = ChronoUnit.SECONDS;
        long r101 = r110.until(r111, r100);
        ChronoField r102 = ChronoField.NANO_OF_SECOND;
        long r103 = 0;
        if (r110.isSupported(r102) == false) goto L23;
        if (r111.isSupported(r102) == false) goto L23;
        long r104 = r110.getLong(r102);     // Catch: Throwable -> L25
        long r105 = r111.getLong(r102) - r104;
        if (r101 > 0) goto L10;
    L12:
        if (r101 < 0) goto L14;
    L16:
        if (r101 == 0) goto L18;
    L21:
        r103 = r105;
        goto L23
    L18:
        if (r105 == 0) goto L21;
        r101 = r110.until(r111.with(r102, r104), r100);     // Catch: Throwable -> L24
        goto L21
    L14:
        if (r105 <= 0) goto L16;
        r105 = r105 - C.NANOS_PER_SECOND;
        goto L21
    L10:
        if (r105 >= 0) goto L12;
        r105 = r105 + C.NANOS_PER_SECOND;
    L23:
        return ofSeconds(r101, r103);
    }

    public static Duration of(long r100, i r101) {
        return ZERO.plus(r100, r101);
    }

    public static Duration ofSeconds(long r100, long r101) {
        long r102 = 1000000000;
        return a(d.f(r100, d.c(r101, C.NANOS_PER_SECOND)), (int) (((r101 % r102) + r102) % r102));
    }

    public final Duration d(long r100, long r101) {
        if ((r100 | r101) != 0) goto L5;
        return this;
    L5:
        long r102 = d.f(d.f(this.seconds, r100), r101 / C.NANOS_PER_SECOND);
        long r103 = r101 % C.NANOS_PER_SECOND;
        return ofSeconds(r102, ((long) this.nanos) + r103);
    }

    public Duration minus(long r100, i r101) {
        if (r100 != Long.MIN_VALUE) goto L6;
        return plus(Long.MAX_VALUE, r101).plus(1, r101);
    L6:
        return plus(-r100, r101);
    }

    public Duration plus(long r100, i r101) {
        d.d(r101, Scraps.INNER_UNIT);
        if (r101 != ChronoUnit.DAYS) goto L7;
        return d(d.h(r100, 86400), 0);
    L7:
        if (r101.isDurationEstimated() == true) goto L34;
        if (r100 != 0) goto L12;
        return this;
    L12:
        if ((r101 instanceof ChronoUnit) == false) goto L31;
        int r102 = a.f526241a[((ChronoUnit) r101).ordinal()];
        if (r102 == 1) goto L30;
        if (r102 == 2) goto L28;
        if (r102 == 3) goto L26;
        if (r102 == 4) goto L24;
        return plusSeconds(d.i(r101.getDuration().seconds, r100));
    L24:
        return plusSeconds(r100);
    L26:
        return plusMillis(r100);
    L28:
        return plusSeconds((r100 / C.NANOS_PER_SECOND) * 1000).plusNanos((r100 % C.NANOS_PER_SECOND) * 1000);
    L30:
        return plusNanos(r100);
    L31:
        Duration r103 = r101.getDuration().multipliedBy(r100);
        return plusSeconds(r103.getSeconds()).plusNanos(r103.getNano());
    L34:
        throw new DateTimeException("Unit must not have an estimated duration");
    }

    public static long c(CharSequence r100, String r101, int r102, String r103) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            java.lang.String r0 = "Text cannot be parsed to a Duration: "
            if (r5 != 0) goto L7
            r4 = 0
            return r4
        L7:
            r1 = 0
            java.lang.String r2 = "+"
            boolean r2 = r5.startsWith(r2)     // Catch: java.lang.ArithmeticException -> L1e java.lang.NumberFormatException -> L31
            if (r2 == 0) goto L15
            r2 = 1
            java.lang.String r5 = r5.substring(r2)     // Catch: java.lang.ArithmeticException -> L1e java.lang.NumberFormatException -> L31
        L15:
            long r2 = com.bytedance.mt.protector.impl.string2number.CastLongProtector.parseLong(r5)     // Catch: java.lang.ArithmeticException -> L1e java.lang.NumberFormatException -> L31
            long r4 = zwc.d.h(r2, r6)     // Catch: java.lang.ArithmeticException -> L1e java.lang.NumberFormatException -> L31
            return r4
        L1e:
            r5 = move-exception
            org.threeten.bp.format.DateTimeParseException r6 = new org.threeten.bp.format.DateTimeParseException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r7 = r0.concat(r7)
            r6.<init>(r7, r4, r1)
            java.lang.Throwable r4 = r6.initCause(r5)
            org.threeten.bp.format.DateTimeParseException r4 = (org.threeten.bp.format.DateTimeParseException) r4
            throw r4
        L31:
            r5 = move-exception
            org.threeten.bp.format.DateTimeParseException r6 = new org.threeten.bp.format.DateTimeParseException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r7 = r0.concat(r7)
            r6.<init>(r7, r4, r1)
            java.lang.Throwable r4 = r6.initCause(r5)
            org.threeten.bp.format.DateTimeParseException r4 = (org.threeten.bp.format.DateTimeParseException) r4
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.Duration.c(java.lang.CharSequence, java.lang.String, int, java.lang.String):long");
    }
}
