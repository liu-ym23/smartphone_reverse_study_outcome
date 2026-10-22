package kotlin.time;

import com.bytedance.crash.dumper.Scraps;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b*\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001d\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010&\u001a\u0015\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0010\u001a\u0015\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0010\u001a\u0015\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0010\u001a\u0015\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0010\u001a\u0010\u0010/\u001a\u00020\u00012\u0006\u0010*\u001a\u00020\u0001H\u0002\u001a\u0010\u00100\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u0001H\u0002\u001a\u001d\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0002¢\u0006\u0002\u00106\u001a\u0010\u00107\u001a\u00020\u00012\u0006\u00102\u001a\u000203H\u0002\u001a)\u00108\u001a\u00020\u0005*\u0002032\u0006\u00109\u001a\u00020\u00052\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u0002050;H\u0082\b\u001a)\u0010=\u001a\u000203*\u0002032\u0006\u00109\u001a\u00020\u00052\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u0002050;H\u0082\b\u001a\u001c\u0010>\u001a\u00020\u0007*\u00020\b2\u0006\u0010?\u001a\u00020\u0007H\u0087\n¢\u0006\u0004\b@\u0010A\u001a\u001c\u0010>\u001a\u00020\u0007*\u00020\u00052\u0006\u0010?\u001a\u00020\u0007H\u0087\n¢\u0006\u0004\bB\u0010C\u001a\u0019\u0010D\u001a\u00020\u0007*\u00020\b2\u0006\u0010E\u001a\u00020FH\u0007¢\u0006\u0002\u0010G\u001a\u0019\u0010D\u001a\u00020\u0007*\u00020\u00052\u0006\u0010E\u001a\u00020FH\u0007¢\u0006\u0002\u0010H\u001a\u0019\u0010D\u001a\u00020\u0007*\u00020\u00012\u0006\u0010E\u001a\u00020FH\u0007¢\u0006\u0002\u0010I\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u001e\u0010\u0006\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u001e\u0010\u0006\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\r\u001a\u0004\b\u000b\u0010\u000e\"\u001e\u0010\u0006\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u000f\u001a\u0004\b\u000b\u0010\u0010\"\u001e\u0010\u0011\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\f\"\u001e\u0010\u0011\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000e\"\u001e\u0010\u0011\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0010\"\u001e\u0010\u0014\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\f\"\u001e\u0010\u0014\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000e\"\u001e\u0010\u0014\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0010\"\u001e\u0010\u0017\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\n\u001a\u0004\b\u0019\u0010\f\"\u001e\u0010\u0017\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000e\"\u001e\u0010\u0017\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0010\"\u001e\u0010\u001a\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\n\u001a\u0004\b\u001c\u0010\f\"\u001e\u0010\u001a\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u000e\"\u001e\u0010\u001a\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001c\u0010\u0010\"\u001e\u0010\u001d\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\n\u001a\u0004\b\u001f\u0010\f\"\u001e\u0010\u001d\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\u000e\"\u001e\u0010\u001d\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001f\u0010\u0010\"\u001e\u0010 \u001a\u00020\u0007*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\n\u001a\u0004\b\"\u0010\f\"\u001e\u0010 \u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\r\u001a\u0004\b\"\u0010\u000e\"\u001e\u0010 \u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u000f\u001a\u0004\b\"\u0010\u0010¨\u0006J"}, d2 = {"MAX_MILLIS", "", "MAX_NANOS", "MAX_NANOS_IN_MILLIS", "NANOS_IN_MILLIS", "", "days", "Lkotlin/time/Duration;", "", "getDays$annotations", "(D)V", "getDays", "(D)J", "(I)V", "(I)J", "(J)V", "(J)J", "hours", "getHours$annotations", "getHours", "microseconds", "getMicroseconds$annotations", "getMicroseconds", "milliseconds", "getMilliseconds$annotations", "getMilliseconds", DocumentType.MINUTES_NAME, "getMinutes$annotations", "getMinutes", "nanoseconds", "getNanoseconds$annotations", "getNanoseconds", "seconds", "getSeconds$annotations", "getSeconds", "durationOf", "normalValue", "unitDiscriminator", "(JI)J", "durationOfMillis", "normalMillis", "durationOfMillisNormalized", "millis", "durationOfNanos", "normalNanos", "durationOfNanosNormalized", "nanos", "millisToNanos", "nanosToMillis", "parseDuration", "value", "", "strictIso", "", "(Ljava/lang/String;Z)J", "parseOverLongIsoComponent", "skipWhile", "startIndex", "predicate", "Lkotlin/Function1;", "", "substringWhile", "times", "duration", "times-kIfJnKk", "(DJ)J", "times-mvk6XK0", "(IJ)J", "toDuration", Scraps.INNER_UNIT, "Lkotlin/time/DurationUnit;", "(DLkotlin/time/DurationUnit;)J", "(ILkotlin/time/DurationUnit;)J", "(JLkotlin/time/DurationUnit;)J", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class DurationKt {
    public static final long MAX_MILLIS = 4611686018427387903L;
    public static final long MAX_NANOS = 4611686018426999999L;
    private static final long MAX_NANOS_IN_MILLIS = 4611686018426L;
    public static final int NANOS_IN_MILLIS = 1000000;

    @Deprecated(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getDays$annotations(double r100) {
    }

    @Deprecated(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getDays$annotations(int r100) {
    }

    @Deprecated(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getDays$annotations(long r100) {
    }

    @Deprecated(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getHours$annotations(double r100) {
    }

    @Deprecated(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getHours$annotations(int r100) {
    }

    @Deprecated(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getHours$annotations(long r100) {
    }

    @Deprecated(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getMicroseconds$annotations(double r100) {
    }

    @Deprecated(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getMicroseconds$annotations(int r100) {
    }

    @Deprecated(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getMicroseconds$annotations(long r100) {
    }

    @Deprecated(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getMilliseconds$annotations(double r100) {
    }

    @Deprecated(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getMilliseconds$annotations(int r100) {
    }

    @Deprecated(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getMilliseconds$annotations(long r100) {
    }

    @Deprecated(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getMinutes$annotations(double r100) {
    }

    @Deprecated(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getMinutes$annotations(int r100) {
    }

    @Deprecated(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getMinutes$annotations(long r100) {
    }

    @Deprecated(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getNanoseconds$annotations(double r100) {
    }

    @Deprecated(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getNanoseconds$annotations(int r100) {
    }

    @Deprecated(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getNanoseconds$annotations(long r100) {
    }

    @Deprecated(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getSeconds$annotations(double r100) {
    }

    @Deprecated(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getSeconds$annotations(int r100) {
    }

    @Deprecated(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getSeconds$annotations(long r100) {
    }

    private static final long millisToNanos(long r100) {
        return r100 * ((long) 1000000);
    }

    public static final /* synthetic */ long access$durationOfMillis(long r100) {
        return durationOfMillis(r100);
    }

    public static final /* synthetic */ long access$durationOfMillisNormalized(long r100) {
        return durationOfMillisNormalized(r100);
    }

    public static final /* synthetic */ long access$durationOfNanos(long r100) {
        return durationOfNanos(r100);
    }

    public static final /* synthetic */ long access$durationOfNanosNormalized(long r100) {
        return durationOfNanosNormalized(r100);
    }

    public static final /* synthetic */ long access$millisToNanos(long r100) {
        return millisToNanos(r100);
    }

    public static final /* synthetic */ long access$nanosToMillis(long r100) {
        return nanosToMillis(r100);
    }

    private static final long durationOfMillis(long r100) {
        return Duration.m10793constructorimpl((r100 << 1) + 1);
    }

    private static final long durationOfMillisNormalized(long r100) {
        boolean r101 = false;
        if ((-4611686018426L) <= r100) goto L5;
    L7:
        if (r101 == false) goto L10;
        return durationOfNanos(millisToNanos(r100));
    L10:
        return durationOfMillis(RangesKt.coerceIn(r100, -4611686018427387903L, 4611686018427387903L));
    L5:
        if (r100 >= 4611686018427L) goto L7;
        r101 = true;
        goto L7
    }

    private static final long durationOfNanos(long r100) {
        return Duration.m10793constructorimpl(r100 << 1);
    }

    private static final long durationOfNanosNormalized(long r100) {
        boolean r101 = false;
        if ((-4611686018426999999L) <= r100) goto L5;
    L7:
        if (r101 == false) goto L10;
        return durationOfNanos(r100);
    L10:
        return durationOfMillis(nanosToMillis(r100));
    L5:
        if (r100 >= 4611686018427000000L) goto L7;
        r101 = true;
        goto L7
    }

    public static final /* synthetic */ long getDays(double r100) {
        return toDuration(r100, DurationUnit.DAYS);
    }

    public static final /* synthetic */ long getHours(double r100) {
        return toDuration(r100, DurationUnit.HOURS);
    }

    public static final /* synthetic */ long getMicroseconds(double r100) {
        return toDuration(r100, DurationUnit.MICROSECONDS);
    }

    public static final /* synthetic */ long getMilliseconds(double r100) {
        return toDuration(r100, DurationUnit.MILLISECONDS);
    }

    public static final /* synthetic */ long getMinutes(double r100) {
        return toDuration(r100, DurationUnit.MINUTES);
    }

    public static final /* synthetic */ long getNanoseconds(double r100) {
        return toDuration(r100, DurationUnit.NANOSECONDS);
    }

    public static final /* synthetic */ long getSeconds(double r100) {
        return toDuration(r100, DurationUnit.SECONDS);
    }

    private static final long nanosToMillis(long r100) {
        return r100 / ((long) 1000000);
    }

    private static final long parseOverLongIsoComponent(String r100) {
        int r101 = r100.length();
        if (r101 > 0) goto L5;
    L7:
        int r102 = 0;
    L9:
        if ((r101 - r102) <= 16) goto L33;
        Iterable r103 = new IntRange(r102, StringsKt.getLastIndex(r100));
        if ((r103 instanceof Collection) == true) goto L13;
    L15:
        Iterator r104 = r103.iterator();
    L17:
        if (r104.hasNext() == false) goto L14;
        char r105 = r100.charAt(((IntIterator) r104).nextInt());
        if ('0' <= r105) goto L21;
    L23:
        boolean r106 = false;
    L24:
        if (r106 == true) goto L17;
        boolean r107 = false;
    L26:
        if (r107 == false) goto L33;
        if (r100.charAt(0) != '-') goto L30;
        return Long.MIN_VALUE;
    L30:
        return Long.MAX_VALUE;
    L21:
        if (r105 >= ':') goto L23;
        r106 = true;
    L14:
        r107 = true;
        goto L26
    L13:
        if (((Collection) r103).isEmpty() == false) goto L15;
    L33:
        if (StringsKt.startsWith$default(r100, Marker.ANY_NON_NULL_MARKER, false, 2, null) == false) goto L36;
        r100 = StringsKt.drop(r100, 1);
    L36:
        return CastLongProtector.parseLong(r100);
    L5:
        if (StringsKt.contains$default("+-", r100.charAt(0), false, 2, null) == false) goto L7;
        r102 = 1;
        goto L9
    }

    public static final /* synthetic */ long getDays(int r100) {
        return toDuration(r100, DurationUnit.DAYS);
    }

    public static final /* synthetic */ long getHours(int r100) {
        return toDuration(r100, DurationUnit.HOURS);
    }

    public static final /* synthetic */ long getMicroseconds(int r100) {
        return toDuration(r100, DurationUnit.MICROSECONDS);
    }

    public static final /* synthetic */ long getMilliseconds(int r100) {
        return toDuration(r100, DurationUnit.MILLISECONDS);
    }

    public static final /* synthetic */ long getMinutes(int r100) {
        return toDuration(r100, DurationUnit.MINUTES);
    }

    public static final /* synthetic */ long getNanoseconds(int r100) {
        return toDuration(r100, DurationUnit.NANOSECONDS);
    }

    public static final /* synthetic */ long getSeconds(int r100) {
        return toDuration(r100, DurationUnit.SECONDS);
    }

    public static final /* synthetic */ long getDays(long r100) {
        return toDuration(r100, DurationUnit.DAYS);
    }

    public static final /* synthetic */ long getHours(long r100) {
        return toDuration(r100, DurationUnit.HOURS);
    }

    public static final /* synthetic */ long getMicroseconds(long r100) {
        return toDuration(r100, DurationUnit.MICROSECONDS);
    }

    public static final /* synthetic */ long getMilliseconds(long r100) {
        return toDuration(r100, DurationUnit.MILLISECONDS);
    }

    public static final /* synthetic */ long getMinutes(long r100) {
        return toDuration(r100, DurationUnit.MINUTES);
    }

    public static final /* synthetic */ long getNanoseconds(long r100) {
        return toDuration(r100, DurationUnit.NANOSECONDS);
    }

    public static final /* synthetic */ long getSeconds(long r100) {
        return toDuration(r100, DurationUnit.SECONDS);
    }

    public static final /* synthetic */ long access$durationOf(long r100, int r101) {
        return durationOf(r100, r101);
    }

    public static final /* synthetic */ long access$parseDuration(String r100, boolean r101) {
        return parseDuration(r100, r101);
    }

    private static final long durationOf(long r100, int r101) {
        return Duration.m10793constructorimpl((r100 << 1) + ((long) r101));
    }

    private static final long parseDuration(String r210, boolean r211) {
        int r100 = r210.length();
        if (r100 == 0) goto L170;
        Duration.Companion r101 = Duration.Companion;
        long r102 = r101.m10896getZEROUwyO8pc();
        char r103 = r210.charAt(0);
        if (r103 != '+') goto L7;
    L6:
        int r110 = 1;
    L10:
        if (r110 <= 0) goto L12;
        boolean r111 = true;
    L14:
        if (r111 == true) goto L16;
    L18:
        boolean r112 = false;
    L20:
        if (r100 <= r110) goto L168;
        char r104 = ':';
        char r105 = '0';
        if (r210.charAt(r110) != 'P') goto L84;
        int r113 = r110 + 1;
        if (r113 == r100) goto L83;
        DurationUnit r106 = null;
        boolean r107 = false;
    L26:
        if (r113 >= r100) goto L162;
        if (r210.charAt(r113) == 'T') goto L29;
        int r108 = r113;
    L37:
        if (r108 >= r210.length()) goto L53;
        char r109 = r210.charAt(r108);
        if (r105 > r109) goto L42;
        if (r109 >= r104) goto L42;
        boolean r114 = true;
    L43:
        if (r114 == true) goto L49;
        if (StringsKt.contains$default("+-.", r109, false, 2, null) == true) goto L49;
        boolean r115 = false;
    L50:
        if (r115 == false) goto L53;
        r108 = r108 + 1;
        r105 = '0';
        r104 = ':';
    L49:
        r115 = true;
    L42:
        r114 = false;
    L53:
        Intrinsics.checkNotNull(r210, "null cannot be cast to non-null type java.lang.String");
        String r116 = r210.substring(r113, r108);
        if (r116.length() != 0) goto L56;
        boolean r117 = true;
    L57:
        if (r117 == true) goto L81;
        int r118 = r113 + r116.length();
        if (r118 >= 0) goto L61;
    L63:
        boolean r119 = false;
    L64:
        if (r119 == false) goto L79;
        char r120 = r210.charAt(r118);
        r113 = r118 + 1;
        DurationUnit r121 = DurationUnitKt__DurationUnitKt.durationUnitByIsoChar(r120, r107);
        if (r106 != null) goto L68;
    L72:
        int r122 = StringsKt.indexOf$default(r116, '.', 0, false, 6, null);
        if (r121 != DurationUnit.SECONDS) goto L76;
        if (r122 <= 0) goto L76;
        Intrinsics.checkNotNull(r116, "null cannot be cast to non-null type java.lang.String");
        long r123 = Duration.m10829plusLRDsOJo(r102, toDuration(parseOverLongIsoComponent(r116.substring(0, r122)), r121));
        Intrinsics.checkNotNull(r116, "null cannot be cast to non-null type java.lang.String");
        r102 = Duration.m10829plusLRDsOJo(r123, toDuration(CastDoubleProtector.parseDouble(r116.substring(r122)), r121));
    L77:
        r107 = r107;
        r106 = r121;
        r105 = '0';
        r104 = ':';
    L76:
        r102 = Duration.m10829plusLRDsOJo(r102, toDuration(parseOverLongIsoComponent(r116), r121));
        goto L77
    L68:
        if (r106.compareTo(r121) > 0) goto L72;
        throw new IllegalArgumentException("Unexpected order of duration components");
    L79:
        throw new IllegalArgumentException("Missing unit for value ".concat(r116));
    L61:
        if (r118 >= r210.length()) goto L63;
        r119 = true;
        goto L64
    L81:
        throw new IllegalArgumentException();
    L56:
        r117 = false;
        goto L57
    L29:
        if (r107 == true) goto L34;
        r113 = r113 + 1;
        if (r113 == r100) goto L34;
        r107 = true;
    L34:
        throw new IllegalArgumentException();
    L162:
        if (r112 == true) goto L164;
        return r102;
    L164:
        return Duration.m10846unaryMinusUwyO8pc(r102);
    L83:
        throw new IllegalArgumentException();
    L84:
        if (r211 == true) goto L166;
        if (StringsKt.regionMatches(r210, r110, "Infinity", 0, Math.max(r100 - r110, 8), true) == false) goto L88;
        r102 = r101.m10894getINFINITEUwyO8pc();
        goto L162
    L88:
        boolean r124 = !r111;
        if (r111 == true) goto L91;
    L99:
        DurationUnit r125 = null;
        boolean r126 = false;
    L100:
        if (r110 >= r100) goto L162;
        if (r126 == false) goto L111;
        if (r124 == false) goto L111;
    L104:
        if (r110 >= r210.length()) goto L111;
        if (r210.charAt(r110) != ' ') goto L108;
        boolean r127 = true;
    L109:
        if (r127 == false) goto L111;
        r110 = r110 + 1;
        goto L104
    L108:
        r127 = false;
    L111:
        int r128 = r110;
    L113:
        if (r128 >= r210.length()) goto L128;
        char r129 = r210.charAt(r128);
        if ('0' > r129) goto L118;
        if (r129 >= ':') goto L118;
        boolean r130 = true;
    L119:
        if (r130 == false) goto L121;
    L124:
        boolean r131 = true;
    L125:
        if (r131 == false) goto L128;
        r128 = r128 + 1;
        goto L113
    L121:
        if (r129 == '.') goto L124;
        r131 = false;
    L118:
        r130 = false;
    L128:
        Intrinsics.checkNotNull(r210, "null cannot be cast to non-null type java.lang.String");
        String r132 = r210.substring(r110, r128);
        if (r132.length() != 0) goto L131;
        boolean r133 = true;
    L132:
        if (r133 == true) goto L161;
        int r134 = r110 + r132.length();
        int r135 = r134;
    L135:
        if (r135 >= r210.length()) goto L144;
        char r136 = r210.charAt(r135);
        if ('a' <= r136) goto L139;
    L141:
        boolean r137 = false;
    L142:
        if (r137 == false) goto L144;
        r135 = r135 + 1;
        goto L135
    L139:
        if (r136 >= '{') goto L141;
        r137 = true;
    L144:
        Intrinsics.checkNotNull(r210, "null cannot be cast to non-null type java.lang.String");
        String r138 = r210.substring(r134, r135);
        r110 = r134 + r138.length();
        DurationUnit r139 = DurationUnitKt__DurationUnitKt.durationUnitByShortName(r138);
        if (r125 != null) goto L147;
    L151:
        int r140 = StringsKt.indexOf$default(r132, '.', 0, false, 6, null);
        if (r140 <= 0) goto L158;
        Intrinsics.checkNotNull(r132, "null cannot be cast to non-null type java.lang.String");
        long r141 = Duration.m10829plusLRDsOJo(r102, toDuration(CastLongProtector.parseLong(r132.substring(0, r140)), r139));
        Intrinsics.checkNotNull(r132, "null cannot be cast to non-null type java.lang.String");
        r102 = Duration.m10829plusLRDsOJo(r141, toDuration(CastDoubleProtector.parseDouble(r132.substring(r140)), r139));
        if (r110 >= r100) goto L159;
        throw new IllegalArgumentException("Fractional component must be last");
    L159:
        r125 = r139;
        r126 = true;
        goto L100
    L158:
        r102 = Duration.m10829plusLRDsOJo(r102, toDuration(CastLongProtector.parseLong(r132), r139));
        goto L159
    L147:
        if (r125.compareTo(r139) > 0) goto L151;
        throw new IllegalArgumentException("Unexpected order of duration components");
    L161:
        throw new IllegalArgumentException();
    L131:
        r133 = false;
        goto L132
    L91:
        if (r210.charAt(r110) != '(') goto L99;
        if (StringsKt.last(r210) != ')') goto L99;
        r110 = r110 + 1;
        r100 = r100 - 1;
        if (r110 == r100) goto L98;
        r124 = true;
        goto L99
    L98:
        throw new IllegalArgumentException("No components");
    L166:
        throw new IllegalArgumentException();
    L168:
        throw new IllegalArgumentException("No components");
    L16:
        if (StringsKt.startsWith$default(r210, '-', false, 2, null) == false) goto L18;
        r112 = true;
        goto L20
    L12:
        r111 = false;
        goto L14
    L7:
        if (r103 == '-') goto L6;
        r110 = 0;
        goto L10
    L170:
        throw new IllegalArgumentException("The string is empty");
    }

    /* JADX INFO: renamed from: times-kIfJnKk, reason: not valid java name */
    private static final long m10919timeskIfJnKk(double r100, long r101) {
        return Duration.m10830timesUwyO8pc(r101, r100);
    }

    /* JADX INFO: renamed from: times-mvk6XK0, reason: not valid java name */
    private static final long m10920timesmvk6XK0(int r100, long r101) {
        return Duration.m10831timesUwyO8pc(r101, r100);
    }

    public static final long toDuration(double r100, DurationUnit r101) {
        Intrinsics.checkNotNullParameter(r101, Scraps.INNER_UNIT);
        double r102 = DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(r100, r101, DurationUnit.NANOSECONDS);
        boolean r103 = true;
        if ((!Double.isNaN(r102)) == false) goto L15;
        long r104 = MathKt.roundToLong(r102);
        if ((-4611686018426999999L) <= r104) goto L7;
    L9:
        r103 = false;
    L10:
        if (r103 == false) goto L13;
        return durationOfNanos(r104);
    L13:
        return durationOfMillisNormalized(MathKt.roundToLong(DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(r100, r101, DurationUnit.MILLISECONDS)));
    L7:
        if (r104 >= 4611686018427000000L) goto L9;
    L15:
        throw new IllegalArgumentException("Duration value cannot be NaN.".toString());
    }

    public static final long toDuration(long r100, DurationUnit r101) {
        Intrinsics.checkNotNullParameter(r101, Scraps.INNER_UNIT);
        DurationUnit r102 = DurationUnit.NANOSECONDS;
        long r103 = DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(MAX_NANOS, r102, r101);
        boolean r104 = false;
        if ((-r103) <= r100) goto L5;
    L7:
        if (r104 == false) goto L11;
        return durationOfNanos(DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(r100, r101, r102));
    L11:
        return durationOfMillis(RangesKt.coerceIn(DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(r100, r101, DurationUnit.MILLISECONDS), -4611686018427387903L, 4611686018427387903L));
    L5:
        if (r100 > r103) goto L7;
        r104 = true;
        goto L7
    }

    public static final long toDuration(int r100, DurationUnit r101) {
        Intrinsics.checkNotNullParameter(r101, Scraps.INNER_UNIT);
        if (r101.compareTo(DurationUnit.SECONDS) > 0) goto L6;
        return durationOfNanos(DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(r100, r101, DurationUnit.NANOSECONDS));
    L6:
        return toDuration(r100, r101);
    }

    private static final int skipWhile(String r100, int r101, Function1<? super Character, Boolean> r102) {
    L3:
        if (r101 >= r100.length()) goto L7;
        if (r102.invoke(Character.valueOf(r100.charAt(r101))).booleanValue() == false) goto L7;
        r101 = r101 + 1;
    L7:
        return r101;
    }

    private static final String substringWhile(String r100, int r101, Function1<? super Character, Boolean> r102) {
        int r103 = r101;
    L4:
        if (r103 >= r100.length()) goto L8;
        if (r102.invoke(Character.valueOf(r100.charAt(r103))).booleanValue() == false) goto L8;
        r103 = r103 + 1;
    L8:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type java.lang.String");
        return r100.substring(r101, r103);
    }
}
