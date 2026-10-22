package com.google.protobuf.util;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.common.math.LongMath;
import com.google.common.math.c;
import com.google.protobuf.Duration;
import com.google.protobuf.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes23.dex */
public final class Timestamps {
    private static final Comparator<Timestamp> COMPARATOR = null;
    public static final Timestamp MAX_VALUE = null;
    static final long MICROS_PER_SECOND = 1000000;
    static final long MILLIS_PER_SECOND = 1000;
    public static final Timestamp MIN_VALUE = null;
    static final long NANOS_PER_MICROSECOND = 1000;
    static final long NANOS_PER_MILLISECOND = 1000000;
    static final long NANOS_PER_SECOND = 1000000000;
    static final long TIMESTAMP_SECONDS_MAX = 253402300799L;
    static final long TIMESTAMP_SECONDS_MIN = -62135596800L;
    private static final ThreadLocal<SimpleDateFormat> timestampFormat = null;

    private Timestamps() {
    }

    public static boolean isValid(long r100, int r101) {
        if (r100 >= (-62135596800L)) goto L5;
    L13:
        return false;
    L5:
        if (r100 > 253402300799L) goto L13;
        if (r101 < 0) goto L13;
        if (r101 >= 1000000000) goto L13;
        return true;
    }

    private static SimpleDateFormat createTimestampFormat() {
        SimpleDateFormat r100 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
        GregorianCalendar r101 = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        r101.setGregorianChange(new Date(Long.MIN_VALUE));
        r100.setCalendar(r101);
        return r100;
    }

    static {
        MIN_VALUE = Timestamp.newBuilder().setSeconds(-62135596800L).setNanos(0).build();
        MAX_VALUE = Timestamp.newBuilder().setSeconds(253402300799L).setNanos(999999999).build();
        timestampFormat = new AnonymousClass1();
        COMPARATOR = new AnonymousClass2();
    }

    public static /* synthetic */ SimpleDateFormat access$000() {
        return createTimestampFormat();
    }

    public static Comparator<Timestamp> comparator() {
        return COMPARATOR;
    }

    public static Timestamp checkValid(Timestamp r100) {
        long r101 = r100.getSeconds();
        int r102 = r100.getNanos();
        if (isValid(r101, r102) == false) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException(String.format("Timestamp is not valid. See proto definition for valid values. Seconds (%s) must be in range [-62,135,596,800, +253,402,300,799]. Nanos (%s) must be in range [0, +999,999,999].", new Object[]{Long.valueOf(r101), Integer.valueOf(r102)}));
    }

    public static String formatNanos(int r110) {
        long r100 = r110;
        if ((r100 % 1000000) != 0) goto L7;
        return String.format(Locale.ENGLISH, "%1$03d", new Object[]{Long.valueOf(r100 / 1000000)});
    L7:
        if ((r100 % 1000) != 0) goto L11;
        return String.format(Locale.ENGLISH, "%1$06d", new Object[]{Long.valueOf(r100 / 1000)});
    L11:
        return String.format(Locale.ENGLISH, "%1$09d", new Object[]{Integer.valueOf(r110)});
    }

    public static Timestamp fromMicros(long r100) {
        return normalizedTimestamp(r100 / 1000000, (int) ((r100 % 1000000) * 1000));
    }

    public static Timestamp fromMillis(long r100) {
        return normalizedTimestamp(r100 / 1000, (int) ((r100 % 1000) * 1000000));
    }

    public static Timestamp fromNanos(long r100) {
        return normalizedTimestamp(r100 / 1000000000, (int) (r100 % 1000000000));
    }

    public static Timestamp fromSeconds(long r100) {
        return normalizedTimestamp(r100, 0);
    }

    public static boolean isValid(Timestamp r100) {
        return isValid(r100.getSeconds(), r100.getNanos());
    }

    public static Timestamp parse(String r110) throws ParseException {
        int r100 = r110.indexOf(84);
        if (r100 == (-1)) goto L36;
        int r101 = r110.indexOf(90, r100);
        if (r101 != (-1)) goto L7;
        r101 = r110.indexOf(43, r100);
    L7:
        if (r101 != (-1)) goto L9;
        r101 = r110.indexOf(45, r100);
    L9:
        if (r101 == (-1)) goto L34;
        String r102 = r110.substring(0, r101);
        int r103 = r102.indexOf(46);
        if (r103 == (-1)) goto L13;
        String r104 = r102.substring(0, r103);
        String r105 = r102.substring(r103 + 1);
        r102 = r104;
    L14:
        long r106 = timestampFormat.get().parse(r102).getTime() / 1000;
        if (r105.isEmpty() == false) goto L17;
        int r107 = 0;
    L19:
        if (r110.charAt(r101) == 'Z') goto L21;
        long r108 = parseTimezoneOffset(r110.substring(r101 + 1));
        if (r110.charAt(r101) != '+') goto L28;
        r106 = r106 - r108;
    L37:
        return normalizedTimestamp(r106, r107);
    L32:
        throw new ParseException("Failed to parse timestamp: timestamp is out of range.", 0);
    L28:
        r106 = r106 + r108;
        goto L37
    L21:
        if (r110.length() == (r101 + 1)) goto L37;
        throw new ParseException("Failed to parse timestamp: invalid trailing data \"" + r110.substring(r101) + "\"", 0);
    L17:
        r107 = parseNanos(r105);
        goto L19
    L13:
        r105 = "";
        goto L14
    L34:
        throw new ParseException("Failed to parse timestamp: missing valid timezone offset.", 0);
    L36:
        throw new ParseException("Failed to parse timestamp: invalid timestamp \"" + r110 + "\"", 0);
    }

    public static int parseNanos(String r100) throws ParseException {
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r101 >= 9) goto L15;
        r102 = r102 * 10;
        if (r101 >= r100.length()) goto L14;
        if (r100.charAt(r101) < '0') goto L13;
        if (r100.charAt(r101) > '9') goto L13;
        r102 = r102 + (r100.charAt(r101) - '0');
    L13:
        throw new ParseException("Invalid nanoseconds.", 0);
    L14:
        r101 = r101 + 1;
        goto L4
    L15:
        return r102;
    }

    private static long parseTimezoneOffset(String r100) throws ParseException {
        int r101 = r100.indexOf(58);
        if (r101 == (-1)) goto L7;
        String r102 = r100.substring(0, r101);
        String r103 = r100.substring(r101 + 1);
        return ((CastLongProtector.parseLong(r102) * 60) + CastLongProtector.parseLong(r103)) * 60;
    L7:
        throw new ParseException("Invalid offset value: ".concat(r100), 0);
    }

    public static long toMicros(Timestamp r100) {
        checkValid(r100);
        return LongMath.a(LongMath.b(r100.getSeconds(), 1000000), ((long) r100.getNanos()) / 1000);
    }

    public static long toMillis(Timestamp r100) {
        checkValid(r100);
        return LongMath.a(LongMath.b(r100.getSeconds(), 1000), ((long) r100.getNanos()) / 1000000);
    }

    public static long toNanos(Timestamp r100) {
        checkValid(r100);
        return LongMath.a(LongMath.b(r100.getSeconds(), 1000000000), r100.getNanos());
    }

    public static long toSeconds(Timestamp r100) {
        return checkValid(r100).getSeconds();
    }

    public static String toString(Timestamp r100) {
        checkValid(r100);
        long r101 = r100.getSeconds();
        int r102 = r100.getNanos();
        StringBuilder r103 = new StringBuilder();
        Date r104 = new Date(r101 * 1000);
        r103.append(timestampFormat.get().format(r104));
        if (r102 == 0) goto L5;
        r103.append(".");
        r103.append(formatNanos(r102));
    L5:
        r103.append("Z");
        return r103.toString();
    }

    public static Timestamp add(Timestamp r100, Duration r101) {
        checkValid(r100);
        Durations.checkValid(r101);
        return normalizedTimestamp(LongMath.a(r100.getSeconds(), r101.getSeconds()), c.a(r100.getNanos(), r101.getNanos()));
    }

    public static Duration between(Timestamp r100, Timestamp r101) {
        checkValid(r100);
        checkValid(r101);
        return Durations.normalizedDuration(LongMath.c(r101.getSeconds(), r100.getSeconds()), c.b(r101.getNanos(), r100.getNanos()));
    }

    public static int compare(Timestamp r100, Timestamp r101) {
        return COMPARATOR.compare(r100, r101);
    }

    public static Timestamp normalizedTimestamp(long r100, int r101) {
        long r102 = r101;
        if (r102 > (-1000000000)) goto L5;
    L6:
        r100 = LongMath.a(r100, r102 / 1000000000);
        r101 = (int) (r102 % 1000000000);
    L7:
        if (r101 >= 0) goto L10;
        r101 = (int) (((long) r101) + 1000000000);
        r100 = LongMath.c(r100, 1);
    L10:
        return checkValid(Timestamp.newBuilder().setSeconds(r100).setNanos(r101).build());
    L5:
        if (r102 < 1000000000) goto L7;
        goto L6
    }

    public static Timestamp subtract(Timestamp r100, Duration r101) {
        checkValid(r100);
        Durations.checkValid(r101);
        return normalizedTimestamp(LongMath.c(r100.getSeconds(), r101.getSeconds()), c.b(r100.getNanos(), r101.getNanos()));
    }
}
