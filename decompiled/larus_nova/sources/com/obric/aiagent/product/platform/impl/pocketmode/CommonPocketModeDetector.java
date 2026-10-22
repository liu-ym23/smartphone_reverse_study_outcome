package com.obric.aiagent.product.platform.impl.pocketmode;

import android.app.KeyguardManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.platform.api.vibratefeedback.FeedbackType;
import faceverify.w;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CommonPocketModeDetector implements com.obric.aiagent.product.platform.api.pocketmode.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile int f385019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<Sensor> f385020b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy<SensorManager> f385021c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<KeyguardManager> f385022d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static CompletableDeferred<Boolean> f385023e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f385024f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f385025g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f385026h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f385027i;

    public static final class a implements SensorEventListener {
        public a() {
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, w.BLOB_ELEM_TYPE_SENSOR);
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            boolean r101 = false;
            Float r102 = ArraysKt.getOrNull(r100.values, 0);
            if (r102 == null) goto L16;
            float r103 = r102.floatValue();
            int r104 = CommonPocketModeDetector.f385019a;
            if (r103 >= 5.0f) goto L7;
            int r105 = 1;
        L8:
            CommonPocketModeDetector.f385019a = r105;
            ILogDepend.f384986a.i("CommonPocketModeDetector", "onSensorChanged is sensor covered = " + CommonPocketModeDetector.f385019a);
            CompletableDeferred<Boolean> r106 = CommonPocketModeDetector.f385023e;
            if (r106 != null) goto L11;
        L14:
            Handler r107 = iaa.h.f488968a;
            r107.removeCallbacks(CommonPocketModeDetector.f385024f);
            r107.post(new iaa.h.a(new f()));
            return;
        L11:
            if (CommonPocketModeDetector.f385019a != 0) goto L13;
            r101 = true;
        L13:
            r106.complete(Boolean.valueOf(r101));
            goto L14
        L7:
            r105 = 0;
            goto L8
        L16:
            ILogDepend.f384986a.w("CommonPocketModeDetector", "onSensorChanged: empty values");
            Handler r108 = iaa.h.f488968a;
            r108.removeCallbacks(CommonPocketModeDetector.f385024f);
            r108.post(new iaa.h.a(new f()));
        }
    }

    public static final class b {
        public static Sensor a() {
            return CommonPocketModeDetector.f385020b.getValue();
        }

        public static SensorManager b() {
            return CommonPocketModeDetector.f385021c.getValue();
        }

        public b() {
        }
    }

    public CommonPocketModeDetector() {
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.a
    public final void b() {
        f385027i = false;
        if (f385022d.getValue().isKeyguardLocked() == true) goto L5;
        f385023e = CompletableDeferredKt.CompletableDeferred(Boolean.TRUE);
        f385027i = true;
        return;
    L5:
        if (e() == false) goto L7;
    L18:
        f385023e = CompletableDeferredKt.CompletableDeferred(Boolean.TRUE);
        f385027i = true;
        ILogDepend.f384986a.i("CommonPocketModeDetector", "checkAsync() key guard locked, pocket mode not enable");
        return;
    L7:
        if (h() == false) goto L18;
        CompletableDeferred<Boolean> r100 = f385023e;
        if (r100 == null) goto L12;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L12:
        f385023e = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        f385019a = -1;
        Handler r101 = iaa.h.f488968a;
        d r102 = f385024f;
        r101.removeCallbacks(r102);
        if (b.a() != null) goto L17;
        ILogDepend.f384986a.w("CommonPocketModeDetector", "startSelfCheck: proximity sensor is null, treat as uncovered");
        f385019a = 0;
        CompletableDeferred<Boolean> r103 = f385023e;
        if (r103 == null) goto L21;
        r103.complete(Boolean.TRUE);
        return;
    L21:
        return;
    L17:
        r101.post(new iaa.h.a(new e()));
        r101.postDelayed(r102, 200);
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.a
    public final Object d(Continuation<? super Boolean> r100) {
        return a(this, r100);
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.obric.aiagent.product.platform.impl.pocketmode.d] */
    static {
        new b();
        f385019a = -1;
        f385020b = LazyKt.lazy(new com.obric.aiagent.product.platform.impl.pocketmode.a());
        f385021c = LazyKt.lazy(new com.obric.aiagent.product.platform.impl.pocketmode.b());
        f385022d = LazyKt.lazy(new c());
        f385024f = new d();
        f385025g = new a();
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.a
    public final boolean c() {
        ILogDepend.f384986a.i("CommonPocketModeDetector", "isCheckPassed, checkPass = " + f385027i + ", selfCheckResult = " + f385019a + ", isPocketModeEnabled = " + h() + ", isPocketModeManuallyDismissed = " + e());
        boolean r100 = true;
        if (f385027i == true) goto L9;
        if (f385019a != 1) goto L9;
        r100 = false;
    L9:
        f385019a = -1;
        return r100;
    L11:
        th = move-exception;
        f385019a = -1;
        throw th;
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.a
    public void init() {
        ILogDepend.f384986a.i("CommonPocketModeDetector", "call init()");
    }

    public static /* synthetic */ Object a(CommonPocketModeDetector r100, Continuation<? super Boolean> r101) {
        if ((r101 instanceof CommonPocketModeDetector$awaitCheckPassed$1) == false) goto L7;
        CommonPocketModeDetector$awaitCheckPassed$1 r102 = (CommonPocketModeDetector$awaitCheckPassed$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        Boolean r107 = null;
        if (r106 == 0) goto L17;
        if (r106 != 1) goto L16;
        ResultKt.throwOnFailure(r104);     // Catch: CancellationException -> L13
    L28:
        r107 = (Boolean) r104;     // Catch: CancellationException -> L13
    L31:
        if (r107 != null) goto L34;
        ILogDepend.f384986a.w("CommonPocketModeDetector", "awaitCheckPassed: timeout, return true");
        return Boxing.boxBoolean(true);
    L34:
        ILogDepend.f384986a.i("CommonPocketModeDetector", "awaitCheckPassed: result = " + r107);
        return r107;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r104);
        ILogDepend.Companion r108 = ILogDepend.f384986a;
        StringBuilder r109 = new StringBuilder("awaitCheckPassed start, checkDeferred.isCompleted = ");
        CompletableDeferred<Boolean> r110 = f385023e;
        if (r110 == null) goto L20;
        Boolean r111 = Boxing.boxBoolean(r110.isCompleted());
    L21:
        r109.append(r111);
        r109.append(", checkPass = ");
        r109.append(f385027i);
        r109.append(", selfCheckResult = ");
        r109.append(f385019a);
        r108.i("CommonPocketModeDetector", r109.toString());
        CompletableDeferred<Boolean> r112 = f385023e;
        if (r112 == null) goto L24;
        CommonPocketModeDetector$awaitCheckPassed$result$1 r113 = new CommonPocketModeDetector$awaitCheckPassed$result$1(r112, null);     // Catch: CancellationException -> L13
        r102.label = 1;     // Catch: CancellationException -> L13
        r104 = TimeoutKt.c(100, r113, r102);     // Catch: CancellationException -> L13
        if (r104 != r105) goto L28;
        return r105;
    L24:
        return Boxing.boxBoolean(true);
    L20:
        r111 = null;
    L13:
        e = move-exception;
        ILogDepend.f384986a.w("CommonPocketModeDetector", "awaitCheckPassed: deferred cancelled", e);
    L7:
        r102 = new CommonPocketModeDetector$awaitCheckPassed$1(r100, r101);
        goto L8
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.a
    public final void f(boolean r100, boolean r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r102, "showToastAction");
        ILogDepend.f384986a.i("CommonPocketModeDetector", "onUserActionBlocked() needVibrate:" + r100 + ", isAppBackground:" + r101);
        if (r100 == false) goto L5;
        Lazy r103 = caa.h.f22975a;
        caa.h.b(FeedbackType.WARNING.getTypeName());
    L5:
        if (r101 == false) goto L7;
        g();
        return;
    L7:
        r102.invoke();
    }
}
