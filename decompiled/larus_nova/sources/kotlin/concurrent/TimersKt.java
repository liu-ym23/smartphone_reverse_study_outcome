package kotlin.concurrent;

import com.bytedance.apm.constant.UploadTypeInf;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001aM\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001aO\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a\u001a\u0010\u0010\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001\u001aM\u0010\u0010\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001aO\u0010\u0010\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a'\u0010\u0011\u001a\u00020\f2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a3\u0010\u0012\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00072\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a;\u0010\u0012\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a3\u0010\u0012\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a;\u0010\u0012\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a;\u0010\u0015\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a;\u0010\u0015\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0016"}, d2 = {"fixedRateTimer", "Ljava/util/Timer;", "name", "", "daemon", "", "startAt", "Ljava/util/Date;", "period", "", "action", "Lkotlin/Function1;", "Ljava/util/TimerTask;", "", "Lkotlin/ExtensionFunctionType;", "initialDelay", UploadTypeInf.TIMER, "timerTask", MonitorConstants.SCHEDULE, "time", "delay", "scheduleAtFixedRate", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class TimersKt {

    /* JADX INFO: renamed from: kotlin.concurrent.TimersKt$timerTask$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 176)
    public static final class AnonymousClass1 extends TimerTask {
        final /* synthetic */ Function1<TimerTask, Unit> $action;

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            kotlin_concurrent_TimersKt$timerTask$1_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void kotlin_concurrent_TimersKt$timerTask$1__run$___twin___() {
            this.$action.invoke(this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super TimerTask, Unit> r100) {
            this.$action = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void kotlin_concurrent_TimersKt$timerTask$1_com_larus_apm_impl_protector_RunnableLancet_run(AnonymousClass1 r100) {
            r100.kotlin_concurrent_TimersKt$timerTask$1__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    private static final TimerTask timerTask(Function1<? super TimerTask, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return new AnonymousClass1(r100);
    }

    public static final Timer timer(String r100, boolean r101) {
        if (r100 != null) goto L5;
        return new PthreadTimer("rent/TimersKt", r101);
    L5:
        return new PthreadTimer(r100, r101);
    }

    private static final TimerTask schedule(Timer r100, Date r101, Function1<? super TimerTask, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "time");
        Intrinsics.checkNotNullParameter(r102, "action");
        AnonymousClass1 r103 = new AnonymousClass1(r102);
        r100.schedule(r103, r101);
        return r103;
    }

    private static final TimerTask schedule(Timer r100, long r101, Function1<? super TimerTask, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "action");
        AnonymousClass1 r103 = new AnonymousClass1(r102);
        r100.schedule(r103, r101);
        return r103;
    }

    private static final TimerTask schedule(Timer r100, Date r101, long r102, Function1<? super TimerTask, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "time");
        Intrinsics.checkNotNullParameter(r103, "action");
        AnonymousClass1 r104 = new AnonymousClass1(r103);
        r100.schedule(r104, r101, r102);
        return r104;
    }

    private static final TimerTask scheduleAtFixedRate(Timer r100, Date r101, long r102, Function1<? super TimerTask, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "time");
        Intrinsics.checkNotNullParameter(r103, "action");
        AnonymousClass1 r104 = new AnonymousClass1(r103);
        r100.scheduleAtFixedRate(r104, r101, r102);
        return r104;
    }

    private static final TimerTask schedule(Timer r100, long r101, long r110, Function1<? super TimerTask, Unit> r111) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r111, "action");
        AnonymousClass1 r102 = new AnonymousClass1(r111);
        r100.schedule(r102, r101, r110);
        return r102;
    }

    private static final TimerTask scheduleAtFixedRate(Timer r100, long r101, long r110, Function1<? super TimerTask, Unit> r111) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r111, "action");
        AnonymousClass1 r102 = new AnonymousClass1(r111);
        r100.scheduleAtFixedRate(r102, r101, r110);
        return r102;
    }

    private static final Timer fixedRateTimer(String r100, boolean r101, Date r102, long r103, Function1<? super TimerTask, Unit> r104) {
        Intrinsics.checkNotNullParameter(r102, "startAt");
        Intrinsics.checkNotNullParameter(r104, "action");
        Timer r105 = timer(r100, r101);
        r105.scheduleAtFixedRate(new AnonymousClass1(r104), r102, r103);
        return r105;
    }

    private static final Timer timer(String r100, boolean r101, Date r102, long r103, Function1<? super TimerTask, Unit> r104) {
        Intrinsics.checkNotNullParameter(r102, "startAt");
        Intrinsics.checkNotNullParameter(r104, "action");
        Timer r105 = timer(r100, r101);
        r105.schedule(new AnonymousClass1(r104), r102, r103);
        return r105;
    }

    private static final Timer fixedRateTimer(String r100, boolean r101, long r102, long r110, Function1<? super TimerTask, Unit> r111) {
        Intrinsics.checkNotNullParameter(r111, "action");
        Timer r103 = timer(r100, r101);
        r103.scheduleAtFixedRate(new AnonymousClass1(r111), r102, r110);
        return r103;
    }

    private static final Timer timer(String r100, boolean r101, long r102, long r110, Function1<? super TimerTask, Unit> r111) {
        Intrinsics.checkNotNullParameter(r111, "action");
        Timer r103 = timer(r100, r101);
        r103.schedule(new AnonymousClass1(r111), r102, r110);
        return r103;
    }

    public static /* synthetic */ Timer fixedRateTimer$default(String r100, boolean r101, long r102, long r110, Function1 r111, int r112, Object r113) {
        if ((r112 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r112 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r112 & 4) == 0) goto L11;
        r102 = 0;
    L11:
        Intrinsics.checkNotNullParameter(r111, "action");
        Timer r103 = timer(r100, r101);
        AnonymousClass1 r104 = new AnonymousClass1(r111);
        r103.scheduleAtFixedRate(r104, r102, r110);
        return r103;
    }

    public static /* synthetic */ Timer timer$default(String r100, boolean r101, long r102, long r110, Function1 r111, int r112, Object r113) {
        if ((r112 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r112 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r112 & 4) == 0) goto L11;
        r102 = 0;
    L11:
        Intrinsics.checkNotNullParameter(r111, "action");
        Timer r103 = timer(r100, r101);
        AnonymousClass1 r104 = new AnonymousClass1(r111);
        r103.schedule(r104, r102, r110);
        return r103;
    }

    public static /* synthetic */ Timer fixedRateTimer$default(String r100, boolean r101, Date r102, long r103, Function1 r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r101 = false;
    L8:
        Intrinsics.checkNotNullParameter(r102, "startAt");
        Intrinsics.checkNotNullParameter(r104, "action");
        Timer r107 = timer(r100, r101);
        r107.scheduleAtFixedRate(new AnonymousClass1(r104), r102, r103);
        return r107;
    }

    public static /* synthetic */ Timer timer$default(String r100, boolean r101, Date r102, long r103, Function1 r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r101 = false;
    L8:
        Intrinsics.checkNotNullParameter(r102, "startAt");
        Intrinsics.checkNotNullParameter(r104, "action");
        Timer r107 = timer(r100, r101);
        r107.schedule(new AnonymousClass1(r104), r102, r103);
        return r107;
    }
}
