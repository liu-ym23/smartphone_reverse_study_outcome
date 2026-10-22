package kotlin.time;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0005\u001a3\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\b0\u0003H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\n\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u000b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\f\u001a7\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b*\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\b0\u0003H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a7\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b*\u00020\u000b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\b0\u0003H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"measureTime", "Lkotlin/time/Duration;", "block", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)J", "measureTimedValue", "Lkotlin/time/TimedValue;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/time/TimeSource;", "(Lkotlin/time/TimeSource;Lkotlin/jvm/functions/Function0;)J", "Lkotlin/time/TimeSource$Monotonic;", "(Lkotlin/time/TimeSource$Monotonic;Lkotlin/jvm/functions/Function0;)J", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class MeasureTimeKt {
    public static final long measureTime(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        long r101 = TimeSource.Monotonic.INSTANCE.m10932markNowz9LOYto();
        r100.invoke();
        return TimeSource.Monotonic.ValueTimeMark.m10937elapsedNowUwyO8pc(r101);
    }

    public static final <T> TimedValue<T> measureTimedValue(Function0<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        long r101 = TimeSource.Monotonic.INSTANCE.m10932markNowz9LOYto();
        return new TimedValue(r100.invoke(), TimeSource.Monotonic.ValueTimeMark.m10937elapsedNowUwyO8pc(r101), null);
    }

    public static final long measureTime(TimeSource.Monotonic r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "block");
        long r102 = r100.m10932markNowz9LOYto();
        r101.invoke();
        return TimeSource.Monotonic.ValueTimeMark.m10937elapsedNowUwyO8pc(r102);
    }

    public static final <T> TimedValue<T> measureTimedValue(TimeSource.Monotonic r100, Function0<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "block");
        long r102 = r100.m10932markNowz9LOYto();
        return new TimedValue(r101.invoke(), TimeSource.Monotonic.ValueTimeMark.m10937elapsedNowUwyO8pc(r102), null);
    }

    public static final long measureTime(TimeSource r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "block");
        TimeMark r102 = r100.markNow();
        r101.invoke();
        return r102.mo10783elapsedNowUwyO8pc();
    }

    public static final <T> TimedValue<T> measureTimedValue(TimeSource r100, Function0<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "block");
        TimeMark r102 = r100.markNow();
        return new TimedValue(r101.invoke(), r102.mo10783elapsedNowUwyO8pc(), null);
    }
}
