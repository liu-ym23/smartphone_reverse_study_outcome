package kotlin.time;

import androidx.collection.SieveCacheKt;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larus.dora.impl.ota.g2.j0;
import com.ss.android.lark.passport.signinsdk_api.entity.EnvConst$GEO;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087@\u0018\u0000 ¦\u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002¦\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010D\u001a\u00020\u00002\u0006\u0010E\u001a\u00020\u00032\u0006\u0010F\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\bG\u0010HJ\u0018\u0010I\u001a\u00020\t2\u0006\u0010J\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\bK\u0010LJ\u001b\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u000fH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\bO\u0010PJ\u001b\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\tH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\bO\u0010QJ\u0018\u0010M\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\bR\u0010SJ\u001a\u0010T\u001a\u00020U2\b\u0010J\u001a\u0004\u0018\u00010VHÖ\u0003¢\u0006\u0004\bW\u0010XJ\u0010\u0010Y\u001a\u00020\tHÖ\u0001¢\u0006\u0004\bZ\u0010\rJ\r\u0010[\u001a\u00020U¢\u0006\u0004\b\\\u0010]J\u000f\u0010^\u001a\u00020UH\u0002¢\u0006\u0004\b_\u0010]J\u000f\u0010`\u001a\u00020UH\u0002¢\u0006\u0004\ba\u0010]J\r\u0010b\u001a\u00020U¢\u0006\u0004\bc\u0010]J\r\u0010d\u001a\u00020U¢\u0006\u0004\be\u0010]J\r\u0010f\u001a\u00020U¢\u0006\u0004\bg\u0010]J\u0018\u0010h\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\bi\u0010jJ\u0018\u0010k\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\bl\u0010jJ\u001b\u0010m\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u000fH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\bn\u0010PJ\u001b\u0010m\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\tH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\bn\u0010QJ\u009d\u0001\u0010o\u001a\u0002Hp\"\u0004\b\u0000\u0010p2u\u0010q\u001aq\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(u\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(v\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(w\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(y\u0012\u0004\u0012\u0002Hp0rH\u0086\bø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bz\u0010{J\u0088\u0001\u0010o\u001a\u0002Hp\"\u0004\b\u0000\u0010p2`\u0010q\u001a\\\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(v\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(w\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(y\u0012\u0004\u0012\u0002Hp0|H\u0086\bø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bz\u0010}Js\u0010o\u001a\u0002Hp\"\u0004\b\u0000\u0010p2K\u0010q\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(w\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(y\u0012\u0004\u0012\u0002Hp0~H\u0086\bø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bz\u0010\u007fJ`\u0010o\u001a\u0002Hp\"\u0004\b\u0000\u0010p27\u0010q\u001a3\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(y\u0012\u0004\u0012\u0002Hp0\u0080\u0001H\u0086\bø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0005\bz\u0010\u0081\u0001J\u0019\u0010\u0082\u0001\u001a\u00020\u000f2\u0007\u0010\u0083\u0001\u001a\u00020=¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u0019\u0010\u0086\u0001\u001a\u00020\t2\u0007\u0010\u0083\u0001\u001a\u00020=¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u0011\u0010\u0089\u0001\u001a\u00030\u008a\u0001¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u0019\u0010\u008d\u0001\u001a\u00020\u00032\u0007\u0010\u0083\u0001\u001a\u00020=¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\u0011\u0010\u0090\u0001\u001a\u00020\u0003H\u0007¢\u0006\u0005\b\u0091\u0001\u0010\u0005J\u0011\u0010\u0092\u0001\u001a\u00020\u0003H\u0007¢\u0006\u0005\b\u0093\u0001\u0010\u0005J\u0013\u0010\u0094\u0001\u001a\u00030\u008a\u0001H\u0016¢\u0006\u0006\b\u0095\u0001\u0010\u008c\u0001J%\u0010\u0094\u0001\u001a\u00030\u008a\u00012\u0007\u0010\u0083\u0001\u001a\u00020=2\t\b\u0002\u0010\u0096\u0001\u001a\u00020\t¢\u0006\u0006\b\u0095\u0001\u0010\u0097\u0001J\u001e\u0010\u0098\u0001\u001a\u00020\u00002\u0007\u0010\u0083\u0001\u001a\u00020=H\u0000ø\u0001\u0000¢\u0006\u0006\b\u0099\u0001\u0010\u008f\u0001J\u0015\u0010\u009a\u0001\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0005\b\u009b\u0001\u0010\u0005JK\u0010\u009c\u0001\u001a\u00030\u009d\u0001*\b0\u009e\u0001j\u0003`\u009f\u00012\u0007\u0010 \u0001\u001a\u00020\t2\u0007\u0010¡\u0001\u001a\u00020\t2\u0007\u0010¢\u0001\u001a\u00020\t2\b\u0010\u0083\u0001\u001a\u00030\u008a\u00012\u0007\u0010£\u0001\u001a\u00020UH\u0002¢\u0006\u0006\b¤\u0001\u0010¥\u0001R\u0014\u0010\u0006\u001a\u00020\u00008Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u001a\u0010\b\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\u0012R\u001a\u0010\u001c\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\u0012R\u001a\u0010\u001f\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\u0012R\u001a\u0010\"\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\u0012R\u0011\u0010%\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b&\u0010\u0005R\u0011\u0010'\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b(\u0010\u0005R\u0011\u0010)\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b*\u0010\u0005R\u0011\u0010+\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b,\u0010\u0005R\u0011\u0010-\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b.\u0010\u0005R\u0011\u0010/\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b0\u0010\u0005R\u0011\u00101\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b2\u0010\u0005R\u001a\u00103\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b4\u0010\u000b\u001a\u0004\b5\u0010\rR\u001a\u00106\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b7\u0010\u000b\u001a\u0004\b8\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00109\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b:\u0010\u000b\u001a\u0004\b;\u0010\rR\u0014\u0010<\u001a\u00020=8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0015\u0010@\u001a\u00020\t8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\rR\u0014\u0010B\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010\u0005\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u009920\u0001¨\u0006§\u0001"}, d2 = {"Lkotlin/time/Duration;", "", "rawValue", "", "constructor-impl", "(J)J", "absoluteValue", "getAbsoluteValue-UwyO8pc", "hoursComponent", "", "getHoursComponent$annotations", "()V", "getHoursComponent-impl", "(J)I", "inDays", "", "getInDays$annotations", "getInDays-impl", "(J)D", "inHours", "getInHours$annotations", "getInHours-impl", "inMicroseconds", "getInMicroseconds$annotations", "getInMicroseconds-impl", "inMilliseconds", "getInMilliseconds$annotations", "getInMilliseconds-impl", "inMinutes", "getInMinutes$annotations", "getInMinutes-impl", "inNanoseconds", "getInNanoseconds$annotations", "getInNanoseconds-impl", "inSeconds", "getInSeconds$annotations", "getInSeconds-impl", "inWholeDays", "getInWholeDays-impl", "inWholeHours", "getInWholeHours-impl", "inWholeMicroseconds", "getInWholeMicroseconds-impl", "inWholeMilliseconds", "getInWholeMilliseconds-impl", "inWholeMinutes", "getInWholeMinutes-impl", "inWholeNanoseconds", "getInWholeNanoseconds-impl", "inWholeSeconds", "getInWholeSeconds-impl", "minutesComponent", "getMinutesComponent$annotations", "getMinutesComponent-impl", "nanosecondsComponent", "getNanosecondsComponent$annotations", "getNanosecondsComponent-impl", "secondsComponent", "getSecondsComponent$annotations", "getSecondsComponent-impl", "storageUnit", "Lkotlin/time/DurationUnit;", "getStorageUnit-impl", "(J)Lkotlin/time/DurationUnit;", "unitDiscriminator", "getUnitDiscriminator-impl", "value", "getValue-impl", "addValuesMixedRanges", "thisMillis", "otherNanos", "addValuesMixedRanges-UwyO8pc", "(JJJ)J", "compareTo", "other", "compareTo-LRDsOJo", "(JJ)I", "div", "scale", "div-UwyO8pc", "(JD)J", "(JI)J", "div-LRDsOJo", "(JJ)D", "equals", "", "", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "isFinite", "isFinite-impl", "(J)Z", "isInMillis", "isInMillis-impl", "isInNanos", "isInNanos-impl", "isInfinite", "isInfinite-impl", "isNegative", "isNegative-impl", "isPositive", "isPositive-impl", "minus", "minus-LRDsOJo", "(JJ)J", "plus", "plus-LRDsOJo", "times", "times-UwyO8pc", "toComponents", ExifInterface.GPS_DIRECTION_TRUE, "action", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "days", "hours", DocumentType.MINUTES_NAME, "seconds", "nanoseconds", "toComponents-impl", "(JLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "Lkotlin/Function4;", "(JLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(JLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "toDouble", Scraps.INNER_UNIT, "toDouble-impl", "(JLkotlin/time/DurationUnit;)D", "toInt", "toInt-impl", "(JLkotlin/time/DurationUnit;)I", "toIsoString", "", "toIsoString-impl", "(J)Ljava/lang/String;", "toLong", "toLong-impl", "(JLkotlin/time/DurationUnit;)J", "toLongMilliseconds", "toLongMilliseconds-impl", "toLongNanoseconds", "toLongNanoseconds-impl", "toString", "toString-impl", "decimals", "(JLkotlin/time/DurationUnit;I)Ljava/lang/String;", "truncateTo", "truncateTo-UwyO8pc$kotlin_stdlib", "unaryMinus", "unaryMinus-UwyO8pc", "appendFractional", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", "appendFractional-impl", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
public final class Duration implements Comparable<Duration> {
    public static final Companion Companion = null;
    private static final long INFINITE = 0;
    private static final long NEG_INFINITE = 0;
    private static final long ZERO = 0;
    private final long rawValue;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-H\u0007J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b/\u0010\u0011J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b/\u0010\u0014J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b/\u0010\u0017J\u001a\u0010\u0018\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b0\u0010\u0011J\u001a\u0010\u0018\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b0\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b0\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b1\u0010\u0011J\u001a\u0010\u001b\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b1\u0010\u0014J\u001a\u0010\u001b\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b1\u0010\u0017J\u001a\u0010\u001e\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b2\u0010\u0011J\u001a\u0010\u001e\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u0010\u0014J\u001a\u0010\u001e\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u0010\u0017J\u001a\u0010!\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b3\u0010\u0011J\u001a\u0010!\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b3\u0010\u0014J\u001a\u0010!\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b3\u0010\u0017J\u001a\u0010$\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b4\u0010\u0011J\u001a\u0010$\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b4\u0010\u0014J\u001a\u0010$\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b4\u0010\u0017J\u0018\u00105\u001a\u00020\u00042\u0006\u0010+\u001a\u000206ø\u0001\u0000¢\u0006\u0004\b7\u00108J\u0018\u00109\u001a\u00020\u00042\u0006\u0010+\u001a\u000206ø\u0001\u0000¢\u0006\u0004\b:\u00108J\u0018\u0010;\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u000206ø\u0001\u0000¢\u0006\u0002\b<J\u0018\u0010=\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u000206ø\u0001\u0000¢\u0006\u0002\b>J\u001a\u0010'\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b?\u0010\u0011J\u001a\u0010'\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b?\u0010\u0014J\u001a\u0010'\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b?\u0010\u0017R\u0016\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0016\u0010\n\u001a\u00020\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\"\u0010\f\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\f\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u000e\u0010\u0013\u001a\u0004\b\u0010\u0010\u0014R\"\u0010\f\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u000e\u0010\u0016\u001a\u0004\b\u0010\u0010\u0017R\"\u0010\u0018\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011R\"\u0010\u0018\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0014R\"\u0010\u0018\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0017R\"\u0010\u001b\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011R\"\u0010\u001b\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u0014R\"\u0010\u001b\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0017R\"\u0010\u001e\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001f\u0010\u000f\u001a\u0004\b \u0010\u0011R\"\u0010\u001e\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001f\u0010\u0013\u001a\u0004\b \u0010\u0014R\"\u0010\u001e\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0017R\"\u0010!\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\"\u0010\u000f\u001a\u0004\b#\u0010\u0011R\"\u0010!\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\"\u0010\u0013\u001a\u0004\b#\u0010\u0014R\"\u0010!\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\"\u0010\u0016\u001a\u0004\b#\u0010\u0017R\"\u0010$\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b%\u0010\u000f\u001a\u0004\b&\u0010\u0011R\"\u0010$\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b%\u0010\u0013\u001a\u0004\b&\u0010\u0014R\"\u0010$\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010\u0017R\"\u0010'\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b(\u0010\u000f\u001a\u0004\b)\u0010\u0011R\"\u0010'\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b(\u0010\u0013\u001a\u0004\b)\u0010\u0014R\"\u0010'\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010\u0017\u0082\u0002\u0004\n\u0002\b!¨\u0006@"}, d2 = {"Lkotlin/time/Duration$Companion;", "", "()V", "INFINITE", "Lkotlin/time/Duration;", "getINFINITE-UwyO8pc", "()J", "J", "NEG_INFINITE", "getNEG_INFINITE-UwyO8pc$kotlin_stdlib", "ZERO", "getZERO-UwyO8pc", "days", "", "getDays-UwyO8pc$annotations", "(D)V", "getDays-UwyO8pc", "(D)J", "", "(I)V", "(I)J", "", "(J)V", "(J)J", "hours", "getHours-UwyO8pc$annotations", "getHours-UwyO8pc", "microseconds", "getMicroseconds-UwyO8pc$annotations", "getMicroseconds-UwyO8pc", "milliseconds", "getMilliseconds-UwyO8pc$annotations", "getMilliseconds-UwyO8pc", DocumentType.MINUTES_NAME, "getMinutes-UwyO8pc$annotations", "getMinutes-UwyO8pc", "nanoseconds", "getNanoseconds-UwyO8pc$annotations", "getNanoseconds-UwyO8pc", "seconds", "getSeconds-UwyO8pc$annotations", "getSeconds-UwyO8pc", "convert", "value", "sourceUnit", "Lkotlin/time/DurationUnit;", "targetUnit", "days-UwyO8pc", "hours-UwyO8pc", "microseconds-UwyO8pc", "milliseconds-UwyO8pc", "minutes-UwyO8pc", "nanoseconds-UwyO8pc", "parse", "", "parse-UwyO8pc", "(Ljava/lang/String;)J", "parseIsoString", "parseIsoString-UwyO8pc", "parseIsoStringOrNull", "parseIsoStringOrNull-FghU774", "parseOrNull", "parseOrNull-FghU774", "seconds-UwyO8pc", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m10852getDaysUwyO8pc$annotations(double r100) {
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m10853getDaysUwyO8pc$annotations(int r100) {
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m10854getDaysUwyO8pc$annotations(long r100) {
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m10858getHoursUwyO8pc$annotations(double r100) {
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m10859getHoursUwyO8pc$annotations(int r100) {
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m10860getHoursUwyO8pc$annotations(long r100) {
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m10864getMicrosecondsUwyO8pc$annotations(double r100) {
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m10865getMicrosecondsUwyO8pc$annotations(int r100) {
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m10866getMicrosecondsUwyO8pc$annotations(long r100) {
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m10870getMillisecondsUwyO8pc$annotations(double r100) {
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m10871getMillisecondsUwyO8pc$annotations(int r100) {
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m10872getMillisecondsUwyO8pc$annotations(long r100) {
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m10876getMinutesUwyO8pc$annotations(double r100) {
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m10877getMinutesUwyO8pc$annotations(int r100) {
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m10878getMinutesUwyO8pc$annotations(long r100) {
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m10882getNanosecondsUwyO8pc$annotations(double r100) {
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m10883getNanosecondsUwyO8pc$annotations(int r100) {
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m10884getNanosecondsUwyO8pc$annotations(long r100) {
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m10888getSecondsUwyO8pc$annotations(double r100) {
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m10889getSecondsUwyO8pc$annotations(int r100) {
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m10890getSecondsUwyO8pc$annotations(long r100) {
        }

        /* JADX INFO: renamed from: getINFINITE-UwyO8pc, reason: not valid java name */
        public final long m10894getINFINITEUwyO8pc() {
            return Duration.access$getINFINITE$cp();
        }

        /* JADX INFO: renamed from: getNEG_INFINITE-UwyO8pc$kotlin_stdlib, reason: not valid java name */
        public final long m10895getNEG_INFINITEUwyO8pc$kotlin_stdlib() {
            return Duration.access$getNEG_INFINITE$cp();
        }

        /* JADX INFO: renamed from: getZERO-UwyO8pc, reason: not valid java name */
        public final long m10896getZEROUwyO8pc() {
            return Duration.access$getZERO$cp();
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc, reason: not valid java name */
        private final long m10849getDaysUwyO8pc(double r100) {
            return DurationKt.toDuration(r100, DurationUnit.DAYS);
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc, reason: not valid java name */
        private final long m10855getHoursUwyO8pc(double r100) {
            return DurationKt.toDuration(r100, DurationUnit.HOURS);
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc, reason: not valid java name */
        private final long m10861getMicrosecondsUwyO8pc(double r100) {
            return DurationKt.toDuration(r100, DurationUnit.MICROSECONDS);
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc, reason: not valid java name */
        private final long m10867getMillisecondsUwyO8pc(double r100) {
            return DurationKt.toDuration(r100, DurationUnit.MILLISECONDS);
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc, reason: not valid java name */
        private final long m10873getMinutesUwyO8pc(double r100) {
            return DurationKt.toDuration(r100, DurationUnit.MINUTES);
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc, reason: not valid java name */
        private final long m10879getNanosecondsUwyO8pc(double r100) {
            return DurationKt.toDuration(r100, DurationUnit.NANOSECONDS);
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc, reason: not valid java name */
        private final long m10885getSecondsUwyO8pc(double r100) {
            return DurationKt.toDuration(r100, DurationUnit.SECONDS);
        }

        @Deprecated(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: days-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m10891daysUwyO8pc(double r100) {
            return DurationKt.toDuration(r100, DurationUnit.DAYS);
        }

        @Deprecated(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: hours-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m10897hoursUwyO8pc(double r100) {
            return DurationKt.toDuration(r100, DurationUnit.HOURS);
        }

        @Deprecated(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: microseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m10900microsecondsUwyO8pc(double r100) {
            return DurationKt.toDuration(r100, DurationUnit.MICROSECONDS);
        }

        @Deprecated(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: milliseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m10903millisecondsUwyO8pc(double r100) {
            return DurationKt.toDuration(r100, DurationUnit.MILLISECONDS);
        }

        @Deprecated(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: minutes-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m10906minutesUwyO8pc(double r100) {
            return DurationKt.toDuration(r100, DurationUnit.MINUTES);
        }

        @Deprecated(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: nanoseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m10909nanosecondsUwyO8pc(double r100) {
            return DurationKt.toDuration(r100, DurationUnit.NANOSECONDS);
        }

        /* JADX INFO: renamed from: parse-UwyO8pc, reason: not valid java name */
        public final long m10912parseUwyO8pc(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            return DurationKt.access$parseDuration(r100, false);
        L5:
            e = move-exception;
            throw new IllegalArgumentException("Invalid duration string format: '" + r100 + "'.", e);
        }

        /* JADX INFO: renamed from: parseIsoString-UwyO8pc, reason: not valid java name */
        public final long m10913parseIsoStringUwyO8pc(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            return DurationKt.access$parseDuration(r100, true);
        L5:
            e = move-exception;
            throw new IllegalArgumentException("Invalid ISO duration string format: '" + r100 + "'.", e);
        }

        /* JADX INFO: renamed from: parseIsoStringOrNull-FghU774, reason: not valid java name */
        public final Duration m10914parseIsoStringOrNullFghU774(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            return Duration.m10791boximpl(DurationKt.access$parseDuration(r100, true));
        L5:
            return null;
        }

        /* JADX INFO: renamed from: parseOrNull-FghU774, reason: not valid java name */
        public final Duration m10915parseOrNullFghU774(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            return Duration.m10791boximpl(DurationKt.access$parseDuration(r100, false));
        L5:
            return null;
        }

        @Deprecated(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: seconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m10916secondsUwyO8pc(double r100) {
            return DurationKt.toDuration(r100, DurationUnit.SECONDS);
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc, reason: not valid java name */
        private final long m10850getDaysUwyO8pc(int r100) {
            return DurationKt.toDuration(r100, DurationUnit.DAYS);
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc, reason: not valid java name */
        private final long m10856getHoursUwyO8pc(int r100) {
            return DurationKt.toDuration(r100, DurationUnit.HOURS);
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc, reason: not valid java name */
        private final long m10862getMicrosecondsUwyO8pc(int r100) {
            return DurationKt.toDuration(r100, DurationUnit.MICROSECONDS);
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc, reason: not valid java name */
        private final long m10868getMillisecondsUwyO8pc(int r100) {
            return DurationKt.toDuration(r100, DurationUnit.MILLISECONDS);
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc, reason: not valid java name */
        private final long m10874getMinutesUwyO8pc(int r100) {
            return DurationKt.toDuration(r100, DurationUnit.MINUTES);
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc, reason: not valid java name */
        private final long m10880getNanosecondsUwyO8pc(int r100) {
            return DurationKt.toDuration(r100, DurationUnit.NANOSECONDS);
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc, reason: not valid java name */
        private final long m10886getSecondsUwyO8pc(int r100) {
            return DurationKt.toDuration(r100, DurationUnit.SECONDS);
        }

        @Deprecated(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: days-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m10892daysUwyO8pc(int r100) {
            return DurationKt.toDuration(r100, DurationUnit.DAYS);
        }

        @Deprecated(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: hours-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m10898hoursUwyO8pc(int r100) {
            return DurationKt.toDuration(r100, DurationUnit.HOURS);
        }

        @Deprecated(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: microseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m10901microsecondsUwyO8pc(int r100) {
            return DurationKt.toDuration(r100, DurationUnit.MICROSECONDS);
        }

        @Deprecated(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: milliseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m10904millisecondsUwyO8pc(int r100) {
            return DurationKt.toDuration(r100, DurationUnit.MILLISECONDS);
        }

        @Deprecated(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: minutes-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m10907minutesUwyO8pc(int r100) {
            return DurationKt.toDuration(r100, DurationUnit.MINUTES);
        }

        @Deprecated(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: nanoseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m10910nanosecondsUwyO8pc(int r100) {
            return DurationKt.toDuration(r100, DurationUnit.NANOSECONDS);
        }

        @Deprecated(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: seconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m10917secondsUwyO8pc(int r100) {
            return DurationKt.toDuration(r100, DurationUnit.SECONDS);
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc, reason: not valid java name */
        private final long m10851getDaysUwyO8pc(long r100) {
            return DurationKt.toDuration(r100, DurationUnit.DAYS);
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc, reason: not valid java name */
        private final long m10857getHoursUwyO8pc(long r100) {
            return DurationKt.toDuration(r100, DurationUnit.HOURS);
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc, reason: not valid java name */
        private final long m10863getMicrosecondsUwyO8pc(long r100) {
            return DurationKt.toDuration(r100, DurationUnit.MICROSECONDS);
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc, reason: not valid java name */
        private final long m10869getMillisecondsUwyO8pc(long r100) {
            return DurationKt.toDuration(r100, DurationUnit.MILLISECONDS);
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc, reason: not valid java name */
        private final long m10875getMinutesUwyO8pc(long r100) {
            return DurationKt.toDuration(r100, DurationUnit.MINUTES);
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc, reason: not valid java name */
        private final long m10881getNanosecondsUwyO8pc(long r100) {
            return DurationKt.toDuration(r100, DurationUnit.NANOSECONDS);
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc, reason: not valid java name */
        private final long m10887getSecondsUwyO8pc(long r100) {
            return DurationKt.toDuration(r100, DurationUnit.SECONDS);
        }

        @Deprecated(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: days-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m10893daysUwyO8pc(long r100) {
            return DurationKt.toDuration(r100, DurationUnit.DAYS);
        }

        @Deprecated(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: hours-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m10899hoursUwyO8pc(long r100) {
            return DurationKt.toDuration(r100, DurationUnit.HOURS);
        }

        @Deprecated(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: microseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m10902microsecondsUwyO8pc(long r100) {
            return DurationKt.toDuration(r100, DurationUnit.MICROSECONDS);
        }

        @Deprecated(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: milliseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m10905millisecondsUwyO8pc(long r100) {
            return DurationKt.toDuration(r100, DurationUnit.MILLISECONDS);
        }

        @Deprecated(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: minutes-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m10908minutesUwyO8pc(long r100) {
            return DurationKt.toDuration(r100, DurationUnit.MINUTES);
        }

        @Deprecated(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: nanoseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m10911nanosecondsUwyO8pc(long r100) {
            return DurationKt.toDuration(r100, DurationUnit.NANOSECONDS);
        }

        @Deprecated(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        /* JADX INFO: renamed from: seconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m10918secondsUwyO8pc(long r100) {
            return DurationKt.toDuration(r100, DurationUnit.SECONDS);
        }

        public final double convert(double r100, DurationUnit r101, DurationUnit r102) {
            Intrinsics.checkNotNullParameter(r101, "sourceUnit");
            Intrinsics.checkNotNullParameter(r102, "targetUnit");
            return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(r100, r101, r102);
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Duration m10791boximpl(long r100) {
        return new Duration(r100);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m10797equalsimpl(long r100, Object r101) {
        if ((r101 instanceof Duration) == true) goto L6;
        return false;
    L6:
        if (r100 == ((Duration) r101).m10848unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m10798equalsimpl0(long r100, long r101) {
        if (r100 != r101) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ void getHoursComponent$annotations() {
    }

    @Deprecated(message = "Use inWholeDays property instead or convert toDouble(DAYS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.DAYS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getInDays$annotations() {
    }

    @Deprecated(message = "Use inWholeHours property instead or convert toDouble(HOURS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.HOURS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getInHours$annotations() {
    }

    @Deprecated(message = "Use inWholeMicroseconds property instead or convert toDouble(MICROSECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MICROSECONDS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getInMicroseconds$annotations() {
    }

    @Deprecated(message = "Use inWholeMilliseconds property instead or convert toDouble(MILLISECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MILLISECONDS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getInMilliseconds$annotations() {
    }

    @Deprecated(message = "Use inWholeMinutes property instead or convert toDouble(MINUTES) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MINUTES)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getInMinutes$annotations() {
    }

    @Deprecated(message = "Use inWholeNanoseconds property instead or convert toDouble(NANOSECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.NANOSECONDS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getInNanoseconds$annotations() {
    }

    @Deprecated(message = "Use inWholeSeconds property instead or convert toDouble(SECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.SECONDS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getInSeconds$annotations() {
    }

    public static /* synthetic */ void getMinutesComponent$annotations() {
    }

    public static /* synthetic */ void getNanosecondsComponent$annotations() {
    }

    public static /* synthetic */ void getSecondsComponent$annotations() {
    }

    /* JADX INFO: renamed from: getUnitDiscriminator-impl, reason: not valid java name */
    private static final int m10819getUnitDiscriminatorimpl(long r100) {
        return ((int) r100) & 1;
    }

    /* JADX INFO: renamed from: getValue-impl, reason: not valid java name */
    private static final long m10820getValueimpl(long r100) {
        return r100 >> 1;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m10821hashCodeimpl(long r100) {
        return (int) (r100 ^ (r100 >>> 32));
    }

    /* JADX INFO: renamed from: isInMillis-impl, reason: not valid java name */
    private static final boolean m10823isInMillisimpl(long r100) {
        if ((((int) r100) & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    /* JADX INFO: renamed from: isInNanos-impl, reason: not valid java name */
    private static final boolean m10824isInNanosimpl(long r100) {
        if ((((int) r100) & 1) == 0) goto L7;
        return false;
    L7:
        return true;
    }

    /* JADX INFO: renamed from: isNegative-impl, reason: not valid java name */
    public static final boolean m10826isNegativeimpl(long r100) {
        if (r100 >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isPositive-impl, reason: not valid java name */
    public static final boolean m10827isPositiveimpl(long r100) {
        if (r100 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(Object r100) {
        return m10797equalsimpl(this.rawValue, r100);
    }

    public int hashCode() {
        return m10821hashCodeimpl(this.rawValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m10848unboximpl() {
        return this.rawValue;
    }

    static {
        Companion = new Companion(null);
        ZERO = m10793constructorimpl(0);
        INFINITE = DurationKt.access$durationOfMillis(4611686018427387903L);
        NEG_INFINITE = DurationKt.access$durationOfMillis(-4611686018427387903L);
    }

    public String toString() {
        return m10842toStringimpl(this.rawValue);
    }

    public static final /* synthetic */ long access$getINFINITE$cp() {
        return INFINITE;
    }

    public static final /* synthetic */ long access$getNEG_INFINITE$cp() {
        return NEG_INFINITE;
    }

    public static final /* synthetic */ long access$getZERO$cp() {
        return ZERO;
    }

    private /* synthetic */ Duration(long r100) {
        this.rawValue = r100;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m10793constructorimpl(long r100) {
        if (DurationJvmKt.getDurationAssertionsEnabled() == false) goto L35;
        boolean r101 = true;
        if (m10824isInNanosimpl(r100) == false) goto L16;
        long r102 = m10820getValueimpl(r100);
        if ((-4611686018426999999L) <= r102) goto L9;
    L11:
        r101 = false;
    L12:
        if (r101 == true) goto L35;
        throw new AssertionError(m10820getValueimpl(r100) + " ns is out of nanoseconds range");
    L9:
        if (r102 >= 4611686018427000000L) goto L11;
    L16:
        long r103 = m10820getValueimpl(r100);
        if ((-4611686018427387903L) <= r103) goto L19;
    L21:
        boolean r104 = false;
    L22:
        if (r104 == false) goto L34;
        long r105 = m10820getValueimpl(r100);
        if ((-4611686018426L) <= r105) goto L26;
    L28:
        r101 = false;
    L29:
        if (r101 == false) goto L35;
        throw new AssertionError(m10820getValueimpl(r100) + " ms is denormalized");
    L26:
        if (r105 >= 4611686018427L) goto L28;
    L34:
        throw new AssertionError(m10820getValueimpl(r100) + " ms is out of milliseconds range");
    L19:
        if (r103 >= SieveCacheKt.NodeVisitedBit) goto L21;
        r104 = true;
    L35:
        return r100;
    }

    /* JADX INFO: renamed from: getAbsoluteValue-UwyO8pc, reason: not valid java name */
    public static final long m10799getAbsoluteValueUwyO8pc(long r100) {
        if (m10826isNegativeimpl(r100) == true) goto L5;
        return r100;
    L5:
        return m10846unaryMinusUwyO8pc(r100);
    }

    /* JADX INFO: renamed from: getHoursComponent-impl, reason: not valid java name */
    public static final int m10800getHoursComponentimpl(long r100) {
        if (m10825isInfiniteimpl(r100) == false) goto L6;
        return 0;
    L6:
        return (int) (m10809getInWholeHoursimpl(r100) % ((long) 24));
    }

    /* JADX INFO: renamed from: getInDays-impl, reason: not valid java name */
    public static final /* synthetic */ double m10801getInDaysimpl(long r100) {
        return m10836toDoubleimpl(r100, DurationUnit.DAYS);
    }

    /* JADX INFO: renamed from: getInHours-impl, reason: not valid java name */
    public static final /* synthetic */ double m10802getInHoursimpl(long r100) {
        return m10836toDoubleimpl(r100, DurationUnit.HOURS);
    }

    /* JADX INFO: renamed from: getInMicroseconds-impl, reason: not valid java name */
    public static final /* synthetic */ double m10803getInMicrosecondsimpl(long r100) {
        return m10836toDoubleimpl(r100, DurationUnit.MICROSECONDS);
    }

    /* JADX INFO: renamed from: getInMilliseconds-impl, reason: not valid java name */
    public static final /* synthetic */ double m10804getInMillisecondsimpl(long r100) {
        return m10836toDoubleimpl(r100, DurationUnit.MILLISECONDS);
    }

    /* JADX INFO: renamed from: getInMinutes-impl, reason: not valid java name */
    public static final /* synthetic */ double m10805getInMinutesimpl(long r100) {
        return m10836toDoubleimpl(r100, DurationUnit.MINUTES);
    }

    /* JADX INFO: renamed from: getInNanoseconds-impl, reason: not valid java name */
    public static final /* synthetic */ double m10806getInNanosecondsimpl(long r100) {
        return m10836toDoubleimpl(r100, DurationUnit.NANOSECONDS);
    }

    /* JADX INFO: renamed from: getInSeconds-impl, reason: not valid java name */
    public static final /* synthetic */ double m10807getInSecondsimpl(long r100) {
        return m10836toDoubleimpl(r100, DurationUnit.SECONDS);
    }

    /* JADX INFO: renamed from: getInWholeDays-impl, reason: not valid java name */
    public static final long m10808getInWholeDaysimpl(long r100) {
        return m10839toLongimpl(r100, DurationUnit.DAYS);
    }

    /* JADX INFO: renamed from: getInWholeHours-impl, reason: not valid java name */
    public static final long m10809getInWholeHoursimpl(long r100) {
        return m10839toLongimpl(r100, DurationUnit.HOURS);
    }

    /* JADX INFO: renamed from: getInWholeMicroseconds-impl, reason: not valid java name */
    public static final long m10810getInWholeMicrosecondsimpl(long r100) {
        return m10839toLongimpl(r100, DurationUnit.MICROSECONDS);
    }

    /* JADX INFO: renamed from: getInWholeMilliseconds-impl, reason: not valid java name */
    public static final long m10811getInWholeMillisecondsimpl(long r100) {
        if (m10823isInMillisimpl(r100) == false) goto L8;
        if (m10822isFiniteimpl(r100) == false) goto L8;
        return m10820getValueimpl(r100);
    L8:
        return m10839toLongimpl(r100, DurationUnit.MILLISECONDS);
    }

    /* JADX INFO: renamed from: getInWholeMinutes-impl, reason: not valid java name */
    public static final long m10812getInWholeMinutesimpl(long r100) {
        return m10839toLongimpl(r100, DurationUnit.MINUTES);
    }

    /* JADX INFO: renamed from: getInWholeNanoseconds-impl, reason: not valid java name */
    public static final long m10813getInWholeNanosecondsimpl(long r100) {
        long r101 = m10820getValueimpl(r100);
        if (m10824isInNanosimpl(r100) == false) goto L6;
        return r101;
    L6:
        if (r101 <= 9223372036854L) goto L9;
        return Long.MAX_VALUE;
    L9:
        if (r101 >= (-9223372036854L)) goto L12;
        return Long.MIN_VALUE;
    L12:
        return DurationKt.access$millisToNanos(r101);
    }

    /* JADX INFO: renamed from: getInWholeSeconds-impl, reason: not valid java name */
    public static final long m10814getInWholeSecondsimpl(long r100) {
        return m10839toLongimpl(r100, DurationUnit.SECONDS);
    }

    /* JADX INFO: renamed from: getMinutesComponent-impl, reason: not valid java name */
    public static final int m10815getMinutesComponentimpl(long r100) {
        if (m10825isInfiniteimpl(r100) == false) goto L6;
        return 0;
    L6:
        return (int) (m10812getInWholeMinutesimpl(r100) % ((long) 60));
    }

    /* JADX INFO: renamed from: getNanosecondsComponent-impl, reason: not valid java name */
    public static final int m10816getNanosecondsComponentimpl(long r100) {
        if (m10825isInfiniteimpl(r100) == false) goto L6;
        return 0;
    L6:
        if (m10823isInMillisimpl(r100) == false) goto L8;
        long r101 = DurationKt.access$millisToNanos(m10820getValueimpl(r100) % ((long) 1000));
    L10:
        return (int) r101;
    L8:
        r101 = m10820getValueimpl(r100) % ((long) 1000000000);
        goto L10
    }

    /* JADX INFO: renamed from: getSecondsComponent-impl, reason: not valid java name */
    public static final int m10817getSecondsComponentimpl(long r100) {
        if (m10825isInfiniteimpl(r100) == false) goto L6;
        return 0;
    L6:
        return (int) (m10814getInWholeSecondsimpl(r100) % ((long) 60));
    }

    /* JADX INFO: renamed from: getStorageUnit-impl, reason: not valid java name */
    private static final DurationUnit m10818getStorageUnitimpl(long r100) {
        if (m10824isInNanosimpl(r100) == false) goto L6;
        return DurationUnit.NANOSECONDS;
    L6:
        return DurationUnit.MILLISECONDS;
    }

    /* JADX INFO: renamed from: isFinite-impl, reason: not valid java name */
    public static final boolean m10822isFiniteimpl(long r100) {
        return !m10825isInfiniteimpl(r100);
    }

    /* JADX INFO: renamed from: isInfinite-impl, reason: not valid java name */
    public static final boolean m10825isInfiniteimpl(long r100) {
        if (r100 != INFINITE) goto L5;
    L8:
        return true;
    L5:
        if (r100 == NEG_INFINITE) goto L8;
        return false;
    }

    /* JADX INFO: renamed from: toIsoString-impl, reason: not valid java name */
    public static final String m10838toIsoStringimpl(long r110) {
        StringBuilder r100 = new StringBuilder();
        if (m10826isNegativeimpl(r110) == false) goto L5;
        r100.append('-');
    L5:
        r100.append("PT");
        long r101 = m10799getAbsoluteValueUwyO8pc(r110);
        long r102 = m10809getInWholeHoursimpl(r101);
        int r103 = m10815getMinutesComponentimpl(r101);
        int r104 = m10817getSecondsComponentimpl(r101);
        int r105 = m10816getNanosecondsComponentimpl(r101);
        if (m10825isInfiniteimpl(r110) == false) goto L8;
        r102 = 9999999999999L;
    L8:
        boolean r106 = true;
        if (r102 == 0) goto L11;
        boolean r107 = true;
    L12:
        if (r104 != 0) goto L16;
        if (r105 != 0) goto L16;
        boolean r108 = false;
    L17:
        if (r103 != 0) goto L22;
        if (r108 == false) goto L21;
        if (r107 == true) goto L22;
    L21:
        r106 = false;
    L22:
        if (r107 == false) goto L24;
        r100.append(r102);
        r100.append('H');
    L24:
        if (r106 == false) goto L26;
        r100.append(r103);
        r100.append('M');
    L26:
        if (r108 == true) goto L29;
        if (r107 == true) goto L31;
        if (r106 == false) goto L29;
    L31:
        return r100.toString();
    L29:
        m10790appendFractionalimpl(r110, r100, r104, r105, 9, ExifInterface.LATITUDE_SOUTH, true);
    L16:
        r108 = true;
        goto L17
    L11:
        r107 = false;
        goto L12
    }

    @Deprecated(message = "Use inWholeMilliseconds property instead.", replaceWith = @ReplaceWith(expression = "this.inWholeMilliseconds", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    /* JADX INFO: renamed from: toLongMilliseconds-impl, reason: not valid java name */
    public static final /* synthetic */ long m10840toLongMillisecondsimpl(long r100) {
        return m10811getInWholeMillisecondsimpl(r100);
    }

    @Deprecated(message = "Use inWholeNanoseconds property instead.", replaceWith = @ReplaceWith(expression = "this.inWholeNanoseconds", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    /* JADX INFO: renamed from: toLongNanoseconds-impl, reason: not valid java name */
    public static final /* synthetic */ long m10841toLongNanosecondsimpl(long r100) {
        return m10813getInWholeNanosecondsimpl(r100);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m10842toStringimpl(long r110) {
        if (r110 != 0) goto L6;
        return "0s";
    L6:
        if (r110 != INFINITE) goto L9;
        return "Infinity";
    L9:
        if (r110 != NEG_INFINITE) goto L11;
        return "-Infinity";
    L11:
        boolean r100 = m10826isNegativeimpl(r110);
        StringBuilder r111 = new StringBuilder();
        if (r100 == false) goto L14;
        r111.append('-');
    L14:
        long r101 = m10799getAbsoluteValueUwyO8pc(r110);
        long r102 = m10808getInWholeDaysimpl(r101);
        int r103 = m10800getHoursComponentimpl(r101);
        int r104 = m10815getMinutesComponentimpl(r101);
        int r105 = m10817getSecondsComponentimpl(r101);
        int r112 = m10816getNanosecondsComponentimpl(r101);
        int r106 = 0;
        if (r102 == 0) goto L17;
        boolean r107 = true;
    L18:
        if (r103 == 0) goto L20;
        boolean r108 = true;
    L21:
        if (r104 == 0) goto L23;
        boolean r109 = true;
    L24:
        if (r105 != 0) goto L28;
        if (r112 != 0) goto L28;
        boolean r113 = false;
    L29:
        if (r107 == false) goto L32;
        r111.append(r102);
        r111.append(Directory.UNIX_ID);
        r106 = 1;
    L32:
        if (r108 == true) goto L36;
        if (r107 == false) goto L40;
        if (r109 == true) goto L36;
        if (r113 == true) goto L36;
    L40:
        if (r109 == true) goto L44;
        if (r113 == false) goto L48;
        if (r108 == true) goto L44;
        if (r107 == true) goto L44;
    L48:
        if (r113 == false) goto L66;
        int r114 = r106 + 1;
        if (r106 <= 0) goto L52;
        r111.append(' ');
    L52:
        if (r105 != 0) goto L64;
        if (r107 == true) goto L64;
        if (r108 == true) goto L64;
        if (r109 == true) goto L64;
        if (r112 < 1000000) goto L61;
        m10790appendFractionalimpl(r110, r111, r112 / 1000000, r112 % 1000000, 6, "ms", false);
    L65:
        r106 = r114;
        goto L66
    L61:
        if (r112 < 1000) goto L63;
        m10790appendFractionalimpl(r110, r111, r112 / 1000, r112 % 1000, 3, EnvConst$GEO.US, false);
        goto L65
    L63:
        r111.append(r112);
        r111.append("ns");
    L64:
        m10790appendFractionalimpl(r110, r111, r105, r112, 9, "s", false);
    L66:
        if (r100 == false) goto L70;
        if (r106 <= 1) goto L70;
        r111.insert(1, '(').append(')');
    L70:
        return r111.toString();
    L44:
        int r115 = r106 + 1;
        if (r106 <= 0) goto L47;
        r111.append(' ');
    L47:
        r111.append(r104);
        r111.append('m');
        r106 = r115;
    L36:
        int r116 = r106 + 1;
        if (r106 <= 0) goto L39;
        r111.append(' ');
    L39:
        r111.append(r103);
        r111.append('h');
        r106 = r116;
    L28:
        r113 = true;
        goto L29
    L23:
        r109 = false;
        goto L24
    L20:
        r108 = false;
        goto L21
    L17:
        r107 = false;
        goto L18
    }

    /* JADX INFO: renamed from: unaryMinus-UwyO8pc, reason: not valid java name */
    public static final long m10846unaryMinusUwyO8pc(long r100) {
        return DurationKt.access$durationOf(-m10820getValueimpl(r100), ((int) r100) & 1);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Duration r100) {
        return m10847compareToLRDsOJo(r100.m10848unboximpl());
    }

    /* JADX INFO: renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public int m10847compareToLRDsOJo(long r100) {
        return m10792compareToLRDsOJo(this.rawValue, r100);
    }

    /* JADX INFO: renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public static int m10792compareToLRDsOJo(long r100, long r101) {
        long r102 = r100 ^ r101;
        if (r102 < 0) goto L12;
        if ((((int) r102) & 1) == 0) goto L12;
        int r103 = (((int) r100) & 1) - (((int) r101) & 1);
        if (m10826isNegativeimpl(r100) == true) goto L10;
        return r103;
    L10:
        return -r103;
    L12:
        return Intrinsics.compare(r100, r101);
    }

    /* JADX INFO: renamed from: div-LRDsOJo, reason: not valid java name */
    public static final double m10794divLRDsOJo(long r100, long r101) {
        DurationUnit r102 = (DurationUnit) ComparisonsKt.maxOf(m10818getStorageUnitimpl(r100), m10818getStorageUnitimpl(r101));
        return m10836toDoubleimpl(r100, r102) / m10836toDoubleimpl(r101, r102);
    }

    /* JADX INFO: renamed from: div-UwyO8pc, reason: not valid java name */
    public static final long m10796divUwyO8pc(long r100, int r101) {
        if (r101 != 0) goto L13;
        if (m10827isPositiveimpl(r100) == false) goto L7;
        return INFINITE;
    L7:
        if (m10826isNegativeimpl(r100) == false) goto L11;
        return NEG_INFINITE;
    L11:
        throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
    L13:
        if (m10824isInNanosimpl(r100) == false) goto L17;
        return DurationKt.access$durationOfNanos(m10820getValueimpl(r100) / ((long) r101));
    L17:
        if (m10825isInfiniteimpl(r100) == true) goto L19;
        long r102 = r101;
        long r103 = m10820getValueimpl(r100) / r102;
        boolean r104 = false;
        if ((-4611686018426L) <= r103) goto L23;
    L25:
        if (r104 == false) goto L29;
        return DurationKt.access$durationOfNanos(DurationKt.access$millisToNanos(r103) + (DurationKt.access$millisToNanos(m10820getValueimpl(r100) - (r103 * r102)) / r102));
    L29:
        return DurationKt.access$durationOfMillis(r103);
    L23:
        if (r103 >= 4611686018427L) goto L25;
        r104 = true;
        goto L25
    L19:
        return m10831timesUwyO8pc(r100, MathKt.getSign(r101));
    }

    /* JADX INFO: renamed from: minus-LRDsOJo, reason: not valid java name */
    public static final long m10828minusLRDsOJo(long r100, long r101) {
        return m10829plusLRDsOJo(r100, m10846unaryMinusUwyO8pc(r101));
    }

    /* JADX INFO: renamed from: plus-LRDsOJo, reason: not valid java name */
    public static final long m10829plusLRDsOJo(long r100, long r101) {
        if (m10825isInfiniteimpl(r100) == false) goto L13;
        if (m10822isFiniteimpl(r101) == false) goto L7;
    L11:
        return r100;
    L7:
        if ((r101 ^ r100) >= 0) goto L11;
        throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
    L13:
        if (m10825isInfiniteimpl(r101) == false) goto L16;
        return r101;
    L16:
        if ((((int) r100) & 1) != (((int) r101) & 1)) goto L22;
        long r102 = m10820getValueimpl(r100) + m10820getValueimpl(r101);
        if (m10824isInNanosimpl(r100) == false) goto L27;
        return DurationKt.access$durationOfNanosNormalized(r102);
    L27:
        return DurationKt.access$durationOfMillisNormalized(r102);
    L22:
        if (m10823isInMillisimpl(r100) == false) goto L25;
        return m10789addValuesMixedRangesUwyO8pc(r100, m10820getValueimpl(r100), m10820getValueimpl(r101));
    L25:
        return m10789addValuesMixedRangesUwyO8pc(r100, m10820getValueimpl(r101), m10820getValueimpl(r100));
    }

    /* JADX INFO: renamed from: times-UwyO8pc, reason: not valid java name */
    public static final long m10831timesUwyO8pc(long r110, int r111) {
        if (m10825isInfiniteimpl(r110) == false) goto L11;
        if (r111 == 0) goto L10;
        if (r111 <= 0) goto L8;
        return r110;
    L8:
        return m10846unaryMinusUwyO8pc(r110);
    L10:
        throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
    L11:
        if (r111 == 0) goto L13;
        long r100 = m10820getValueimpl(r110);
        long r101 = r111;
        long r102 = r100 * r101;
        if (m10824isInNanosimpl(r110) == false) goto L36;
        boolean r112 = false;
        if ((-2147483647L) <= r100) goto L19;
    L21:
        if (r112 == false) goto L24;
        return DurationKt.access$durationOfNanos(r102);
    L24:
        if ((r102 / r101) == r100) goto L45;
        long r113 = DurationKt.access$nanosToMillis(r100);
        long r114 = r113 * r101;
        long r103 = DurationKt.access$nanosToMillis((r100 - DurationKt.access$millisToNanos(r113)) * r101) + r114;
        if ((r114 / r101) != r113) goto L32;
        if ((r103 ^ r114) < 0) goto L32;
        return DurationKt.access$durationOfMillis(RangesKt.coerceIn(r103, new LongRange(-4611686018427387903L, 4611686018427387903L)));
    L32:
        if ((MathKt.getSign(r100) * MathKt.getSign(r111)) <= 0) goto L48;
        return INFINITE;
    L48:
        return NEG_INFINITE;
    L45:
        return DurationKt.access$durationOfNanosNormalized(r102);
    L19:
        if (r100 >= j0.G2_OTA_SPACE_RESERVE_BYTES) goto L21;
        r112 = true;
        goto L21
    L36:
        if ((r102 / r101) != r100) goto L39;
        return DurationKt.access$durationOfMillis(RangesKt.coerceIn(r102, new LongRange(-4611686018427387903L, 4611686018427387903L)));
    L39:
        if ((MathKt.getSign(r100) * MathKt.getSign(r111)) <= 0) goto L42;
        return INFINITE;
    L42:
        return NEG_INFINITE;
    L13:
        return ZERO;
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m10835toComponentsimpl(long r100, Function5<? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> r110) {
        Intrinsics.checkNotNullParameter(r110, "action");
        return r110.invoke(Long.valueOf(m10808getInWholeDaysimpl(r100)), Integer.valueOf(m10800getHoursComponentimpl(r100)), Integer.valueOf(m10815getMinutesComponentimpl(r100)), Integer.valueOf(m10817getSecondsComponentimpl(r100)), Integer.valueOf(m10816getNanosecondsComponentimpl(r100)));
    }

    /* JADX INFO: renamed from: toDouble-impl, reason: not valid java name */
    public static final double m10836toDoubleimpl(long r100, DurationUnit r101) {
        Intrinsics.checkNotNullParameter(r101, Scraps.INNER_UNIT);
        if (r100 != INFINITE) goto L6;
        return Double.POSITIVE_INFINITY;
    L6:
        if (r100 != NEG_INFINITE) goto L9;
        return Double.NEGATIVE_INFINITY;
    L9:
        return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(m10820getValueimpl(r100), m10818getStorageUnitimpl(r100), r101);
    }

    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    public static final int m10837toIntimpl(long r100, DurationUnit r101) {
        Intrinsics.checkNotNullParameter(r101, Scraps.INNER_UNIT);
        return (int) RangesKt.coerceIn(m10839toLongimpl(r100, r101), SieveCacheKt.NodeMetaAndPreviousMask, SieveCacheKt.NodeLinkMask);
    }

    /* JADX INFO: renamed from: toLong-impl, reason: not valid java name */
    public static final long m10839toLongimpl(long r100, DurationUnit r101) {
        Intrinsics.checkNotNullParameter(r101, Scraps.INNER_UNIT);
        if (r100 != INFINITE) goto L6;
        return Long.MAX_VALUE;
    L6:
        if (r100 != NEG_INFINITE) goto L9;
        return Long.MIN_VALUE;
    L9:
        return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(m10820getValueimpl(r100), m10818getStorageUnitimpl(r100), r101);
    }

    /* JADX INFO: renamed from: truncateTo-UwyO8pc$kotlin_stdlib, reason: not valid java name */
    public static final long m10845truncateToUwyO8pc$kotlin_stdlib(long r100, DurationUnit r101) {
        Intrinsics.checkNotNullParameter(r101, Scraps.INNER_UNIT);
        DurationUnit r102 = m10818getStorageUnitimpl(r100);
        if (r101.compareTo(r102) > 0) goto L5;
        return r100;
    L5:
        if (m10825isInfiniteimpl(r100) == true) goto L10;
        long r103 = DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(1, r101, r102);
        return DurationKt.toDuration(m10820getValueimpl(r100) - (m10820getValueimpl(r100) % r103), r102);
    L10:
        return r100;
    }

    /* JADX INFO: renamed from: div-UwyO8pc, reason: not valid java name */
    public static final long m10795divUwyO8pc(long r100, double r101) {
        int r102 = MathKt.roundToInt(r101);
        if (r102 != r101) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L10;
        if (r102 == 0) goto L10;
        return m10796divUwyO8pc(r100, r102);
    L10:
        DurationUnit r104 = m10818getStorageUnitimpl(r100);
        return DurationKt.toDuration(m10836toDoubleimpl(r100, r104) / r101, r104);
    L5:
        r103 = false;
        goto L6
    }

    /* JADX INFO: renamed from: times-UwyO8pc, reason: not valid java name */
    public static final long m10830timesUwyO8pc(long r100, double r101) {
        int r102 = MathKt.roundToInt(r101);
        if (r102 != r101) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L8;
        DurationUnit r104 = m10818getStorageUnitimpl(r100);
        return DurationKt.toDuration(m10836toDoubleimpl(r100, r104) * r101, r104);
    L8:
        return m10831timesUwyO8pc(r100, r102);
    L5:
        r103 = false;
        goto L6
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m10834toComponentsimpl(long r100, Function4<? super Long, ? super Integer, ? super Integer, ? super Integer, ? extends T> r101) {
        Intrinsics.checkNotNullParameter(r101, "action");
        return r101.invoke(Long.valueOf(m10809getInWholeHoursimpl(r100)), Integer.valueOf(m10815getMinutesComponentimpl(r100)), Integer.valueOf(m10817getSecondsComponentimpl(r100)), Integer.valueOf(m10816getNanosecondsComponentimpl(r100)));
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m10833toComponentsimpl(long r100, Function3<? super Long, ? super Integer, ? super Integer, ? extends T> r101) {
        Intrinsics.checkNotNullParameter(r101, "action");
        return r101.invoke(Long.valueOf(m10812getInWholeMinutesimpl(r100)), Integer.valueOf(m10817getSecondsComponentimpl(r100)), Integer.valueOf(m10816getNanosecondsComponentimpl(r100)));
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m10832toComponentsimpl(long r100, Function2<? super Long, ? super Integer, ? extends T> r101) {
        Intrinsics.checkNotNullParameter(r101, "action");
        return r101.invoke(Long.valueOf(m10814getInWholeSecondsimpl(r100)), Integer.valueOf(m10816getNanosecondsComponentimpl(r100)));
    }

    /* JADX INFO: renamed from: addValuesMixedRanges-UwyO8pc, reason: not valid java name */
    private static final long m10789addValuesMixedRangesUwyO8pc(long r100, long r101, long r110) {
        long r102 = DurationKt.access$nanosToMillis(r110);
        long r103 = r101 + r102;
        boolean r104 = false;
        if ((-4611686018426L) <= r103) goto L5;
    L7:
        if (r104 == false) goto L10;
        long r111 = r110 - DurationKt.access$millisToNanos(r102);
        return DurationKt.access$durationOfNanos(DurationKt.access$millisToNanos(r103) + r111);
    L10:
        return DurationKt.access$durationOfMillis(RangesKt.coerceIn(r103, -4611686018427387903L, 4611686018427387903L));
    L5:
        if (r103 >= 4611686018427L) goto L7;
        r104 = true;
        goto L7
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static final String m10843toStringimpl(long r100, DurationUnit r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, Scraps.INNER_UNIT);
        if (r102 < 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L14;
        double r104 = m10836toDoubleimpl(r100, r101);
        if (Double.isInfinite(r104) == false) goto L12;
        return String.valueOf(r104);
    L12:
        return DurationJvmKt.formatToExactDecimals(r104, RangesKt.coerceAtMost(r102, 12)) + DurationUnitKt__DurationUnitKt.shortName(r101);
    L14:
        throw new IllegalArgumentException(("decimals must be not negative, but was " + r102).toString());
    L5:
        r103 = false;
        goto L6
    }

    /* JADX INFO: renamed from: toString-impl$default, reason: not valid java name */
    public static /* synthetic */ String m10844toStringimpl$default(long r100, DurationUnit r101, int r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = 0;
    L6:
        return m10843toStringimpl(r100, r101, r102);
    }

    /* JADX INFO: renamed from: appendFractional-impl, reason: not valid java name */
    private static final void m10790appendFractionalimpl(long r100, StringBuilder r101, int r102, int r103, int r104, String r105, boolean r110) {
        r101.append(r102);
        if (r103 == 0) goto L20;
        r101.append('.');
        String r106 = StringsKt.padStart(String.valueOf(r103), r104, '0');
        int r107 = -1;
        int r108 = r106.length() - 1;
        if (r108 < 0) goto L15;
    L6:
        int r109 = r108 - 1;
        if (r106.charAt(r108) == '0') goto L9;
        boolean r111 = true;
    L10:
        if (r111 == true) goto L11;
        if (r109 < 0) goto L15;
        r108 = r109;
        goto L6
    L11:
        r107 = r108;
        goto L15
    L9:
        r111 = false;
    L15:
        int r112 = r107 + 1;
        if (r110 == true) goto L19;
        if (r112 >= 3) goto L19;
        r101.append(r106, 0, r112);
    L19:
        r101.append(r106, 0, ((r112 + 2) / 3) * 3);
    L20:
        r101.append(r105);
    }
}
