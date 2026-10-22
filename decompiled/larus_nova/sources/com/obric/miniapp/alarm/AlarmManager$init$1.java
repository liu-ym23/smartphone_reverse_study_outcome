package com.obric.miniapp.alarm;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Messenger;
import androidx.work.WorkManager;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.c1;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.alarm.AlarmManager$init$1", f = "AlarmManager.kt", i = {}, l = {57, 72}, m = "invokeSuspend", n = {}, s = {})
public final class AlarmManager$init$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: renamed from: com.obric.miniapp.alarm.AlarmManager$init$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1<T> f397393a = null;

        static {
            f397393a = new AnonymousClass1();
        }

        public AnonymousClass1() {
        }

        public final Object a(a r100, Continuation<? super Unit> r101) {
            if ((r101 instanceof AlarmManager$init$1$1$emit$1) == false) goto L7;
            AlarmManager$init$1$1$emit$1 r102 = (AlarmManager$init$1$1$emit$1) r101;
            int r103 = r102.label;
            if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
            r102.label = r103 - Integer.MIN_VALUE;
        L8:
            Object r104 = r102.result;
            Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r106 = r102.label;
            if (r106 == 0) goto L14;
            if (r106 != 1) goto L13;
            r100 = (a) r102.L$0;
            ResultKt.throwOnFailure(r104);
        L17:
            Lazy r107 = m0.f397474a;
            Intrinsics.checkNotNullParameter(r100, "alarm");
            ((WorkManager) m0.f397476c.getValue()).cancelUniqueWork("alarm_" + r100.f397416a);
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r104);
            AlarmManager.f397387a.getClass();
            b r108 = AlarmManager.i();
            r102.L$0 = r100;
            r102.label = 1;
            if (r108.insert(r100, r102) != r105) goto L17;
            return r105;
        L7:
            r102 = new AlarmManager$init$1$1$emit$1(this, r101);
            goto L8
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
            return a((a) r100, r101);
        }
    }

    public AlarmManager$init$1(Continuation<? super AlarmManager$init$1> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AlarmManager$init$1(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AlarmManager$init$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L10;
        if (r101 == 1) goto L9;
        if (r101 != 2) goto L8;
        ResultKt.throwOnFailure(r110);
    L29:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r110);
    L24:
        AlarmManager.f397387a.getClass();
        SharedPreferences.Editor r102 = AlarmManager.j().edit();
        r102.clear();
        r102.putBoolean("removed", true);
        r102.apply();
        FLogger.f375446a.i("AlarmManager", "Version transfer finished.");
    L25:
        ((WorkManager) m0.f397476c.getValue()).cancelUniqueWork("AlarmManager-AlarmWorker");
        AlarmManager r103 = AlarmManager.f397387a;
        this.label = 2;
        if (r103.m(this) != r100) goto L29;
        return r100;
    L10:
        ResultKt.throwOnFailure(r110);
        Lazy r104 = AlarmTtsNotificationDispatcher.f397395a;
        yka.a r105 = yka.a.f568288b;
        AppHost.Companion r106 = AppHost.f326268a;
        Application r107 = r106.getApplication();
        Messenger r108 = new Messenger(new Handler(Looper.getMainLooper(), new p()));
        Intrinsics.checkNotNullParameter(r107, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r108, "messenger");
        zka.q r109 = yka.a.f568289c;
        if (r109.f572734e.c(r109.f572730a) == false) goto L13;
        zka.m r111 = r109.f572731b;
    L14:
        if (r111 == null) goto L16;
        r111.a(r107, r108);
    L16:
        BuildersKt.launch$default(AlarmTtsNotificationDispatcher.f397399e, null, null, new AlarmTtsNotificationDispatcher$startWork$2(null), 3, null);
        if (Build.VERSION.SDK_INT < 26) goto L19;
        b0.f397430a.getClass();
        b0.a.a().c();
    L19:
        AlarmManager.f397387a.getClass();
        if (AlarmManager.j().contains("removed") == true) goto L25;
        FLogger.f375446a.i("AlarmManager", "Start version transfer...");
        c1 r112 = new c1(new AlarmManager$loadAlarmsV0$1(AlarmManager.j().getInt("alarm_count", 0), new PolarisFileWrapper(r106.getApplication().getCacheDir(), "alarm_extra_info"), null));
        FlowCollector r113 = AnonymousClass1.f397393a;
        this.label = 1;
        if (r112.collect(r113, this) != r100) goto L24;
        return r100;
    L13:
        r111 = null;
        goto L14
    }
}
