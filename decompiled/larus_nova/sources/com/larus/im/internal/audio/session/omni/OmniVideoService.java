package com.larus.im.internal.audio.session.omni;

import android.view.View;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.ButtonColorBean;
import com.larus.audio.call.plugins.CommonVideoAutoTestPlugin;
import com.larus.im.internal.jni.bean.OMNIAVVideoFramePixelFormat;
import com.larus.im.internal.jni.model.OmniAVEncodedVideoFrameData;
import com.larus.im.internal.jni.model.OmniAVVideoFrameData;
import com.larus.im.internal.jni.session.NativeMediaSession;
import com.larus.im.internal.jni.session.observer.OmniAVVideoFrameProcessor;
import com.larus.im.service.audio.vlm.EncodedVideoCodecType;
import com.larus.im.service.audio.vlm.EncodedVideoFrameType;
import java.util.concurrent.CancellationException;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes29.dex */
public final class OmniVideoService implements com.larus.im.service.audio.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReentrantLock f347273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompletableJob f347274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CoroutineScope f347275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public NativeMediaSession f347276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CompletableDeferred<NativeMediaSession> f347277e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final x0 f347278f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final OmniAVVideoFrameProcessor f347279g;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f347280a = null;

        static {
            int[] r100 = new int[EncodedVideoCodecType.values().length];
            r100[EncodedVideoCodecType.UNKNOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[EncodedVideoCodecType.H264.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[EncodedVideoCodecType.H265.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[EncodedVideoCodecType.MJPEG.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f347280a = r100;
        }
    }

    public static final class c extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public c(CoroutineExceptionHandler.Key r100) {
            super(r100);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public final void handleException(CoroutineContext r100, Throwable r101) {
            fe9.a.f476620a.c("OmniVideoService", "native video call failed, " + r101.getMessage(), r101);
        }
    }

    static {
    }

    @Override // com.larus.im.service.audio.z
    public final void g() {
        fe9.a.f476620a.a("OmniVideoService", "zoomIn");
        e("zoomIn", new j1());
    }

    @Override // com.larus.im.service.audio.z
    public final boolean isCameraTorchSupported() {
        fe9.a.f476620a.a("OmniVideoService", "isCameraTorchSupported");
        ReentrantLock r100 = this.f347273a;
        r100.lock();
        r100.unlock();
        return false;
    }

    @Override // com.larus.im.service.audio.z
    public final void k() {
        fe9.a.f476620a.a("OmniVideoService", "zoomOut");
        e("zoomOut", new f1());
    }

    @Override // com.larus.im.service.audio.z
    public final void l() {
        fe9.a.f476620a.a("OmniVideoService", "resetScaleAndMove");
        e("resetScaleAndMove", new k1());
    }

    @Override // com.larus.im.service.audio.z
    public final void o() {
        fe9.a.f476620a.a("OmniVideoService", "clearCanvas");
        e("clearCanvas", new z0());
    }

    @Override // com.larus.im.service.audio.z
    public final void p() {
        fe9.a.f476620a.a("OmniVideoService", "registerVideoCallProcessor");
        e("registerVideoCallProcessor", new y0(this));
    }

    @Override // com.larus.im.service.audio.z
    public final void s() {
        e("publishVideo", new d1(this));
    }

    @Override // com.larus.im.service.audio.z
    public final void u() {
        e("unpublishVideo", new c1(this));
    }

    @Override // com.larus.im.service.audio.z
    public final void v() {
        fe9.a.f476620a.a("OmniVideoService", "stopVideoRecorder");
        d("stopVideoRecorder");
        e("stopVideoRecorder", new g1());
    }

    public OmniVideoService() {
        this.f347273a = new ReentrantLock();
        CompletableJob r100 = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.f347274b = r100;
        this.f347275c = CoroutineScopeKt.CoroutineScope(r100.plus(com.flow.kmp.common.thread.c.a("flow-omni#video")).plus(new c(CoroutineExceptionHandler.Key)));
        this.f347277e = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        x0 r101 = new x0(null);
        this.f347278f = r101;
        OmniAVVideoFrameProcessor r102 = new OmniAVVideoFrameProcessor(r101);
        r102.setSourceType(1);
        this.f347279g = r102;
    }

    @Override // com.larus.im.service.audio.z
    public final boolean b(final boolean r100) {
        fe9.a.f476620a.a("OmniVideoService", "switchCamera " + r100);
        d("switchCamera");
        e("switchCamera", new h1(r100, this));
        return true;
    }

    @Override // com.larus.im.service.audio.z
    public final boolean c(final boolean r100) {
        fe9.a.f476620a.a("OmniVideoService", "switchTorchStatus " + r100);
        e("switchTorchStatus", new a1(r100, this));
        return true;
    }

    public final void d(String r100) {
        ReentrantLock r101 = this.f347273a;
        r101.lock();
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L6
        r101.unlock();
        fe9.a.f476620a.a("OmniVideoService", "camera torch support invalidated reason=".concat(r100));
        return;
    L6:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    @Override // com.larus.im.service.audio.z
    public final void h(tf9.b r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        NativeMediaSession r101 = i("pushVideoFrame");
        if (r101 != null) goto L5;
        return;
    L5:
        OmniAVVideoFrameData r102 = w0.a(r100, "OmniVideoService", "pushVideoFrame", OMNIAVVideoFramePixelFormat.PixelFormatRGBA.getValue());
        if (r102 != null) goto L9;
        return;
    L9:
        if (r100.f545784h == false) goto L18;
        com.larus.im.internal.delegate.w.a r103 = com.larus.im.internal.delegate.w.j().f348361f;
        if (r103 == null) goto L13;
        boolean r104 = r103.f348308u;
    L15:
        if ((!r104) == true) goto L18;
        fe9.a.f476620a.a("OmniVideoService", "skip publishVideo on first frame by settings, isFirstFrame=" + r100.f545784h);
    L20:
        r101.pushExternalVideoFrame(r102);
        return;
    L13:
        r104 = true;
    L18:
        if (r100.f545784h == false) goto L20;
        int r105 = r101.publishVideo(true);
        fe9.a.f476620a.a("OmniVideoService", "publishVideo on first frame, result=" + r105);
        m("publishVideo", r105);
        goto L20
    }

    public final NativeMediaSession i(String r100) {
        ReentrantLock r101 = this.f347273a;
        r101.lock();
        NativeMediaSession r102 = this.f347276d;     // Catch: Throwable -> L8
        r101.unlock();
        if (r102 != null) goto L7;
        fe9.a.f476620a.f("OmniVideoService", r100.concat(" ignored, native session is not ready"));
    L7:
        return r102;
    L8:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    public final void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        ReentrantLock r101 = this.f347273a;
        r101.lock();
        this.f347276d = null;     // Catch: Throwable -> L6
        CompletableDeferred<NativeMediaSession> r102 = this.f347277e;     // Catch: Throwable -> L6
        r101.unlock();
        r102.completeExceptionally(new CancellationException("video service released: " + r100));
        this.f347274b.cancel(new CancellationException("video service released: " + r100));
        return;
    L6:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    @Override // com.larus.im.service.audio.z
    public final void q(CommonVideoAutoTestPlugin.a r100) {
        fe9.a.f476620a.a("OmniVideoService", "setVideoProcessor");
        this.f347278f.f347397b = r100;
    }

    @Override // com.larus.im.service.audio.z
    public final int r(tf9.a r210) {
        Intrinsics.checkNotNullParameter(r210, "param");
        NativeMediaSession r100 = i("pushEncodedVideoFrame");
        if (r100 != null) goto L5;
        return -1;
    L5:
        byte[] r101 = r210.f545768b;
        if (r101.length != 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        byte[] r103 = r210.f545767a;
    L12:
        byte[] r110 = r103;
        EncodedVideoCodecType r104 = r210.f545773g;
        int r105 = b.f347280a[r104.ordinal()];
        if (r105 != 1) goto L15;
        int r111 = -1;
    L26:
        int r112 = r210.f545770d;
        int r113 = r210.f545771e;
        int r106 = r210.f545772f;
        if (r210.f545774h != EncodedVideoFrameType.KEY) goto L29;
        boolean r114 = true;
    L30:
        int r107 = r100.pushExternalEncodedVideoFrame(new OmniAVEncodedVideoFrameData(r110, r111, r112, r113, r114, r210.f545769c, r210.f545776j, r106, r210.f545775i));
        m("pushEncodedVideoFrame", r107);
        return r107;
    L29:
        r114 = false;
        goto L30
    L15:
        if (r105 != 2) goto L17;
        r111 = 1;
        goto L26
    L17:
        if (r105 != 3) goto L19;
        r111 = 2;
        goto L26
    L19:
        if (r105 != 4) goto L22;
        r111 = 3;
        goto L26
    L22:
        throw new NoWhenBranchMatchedException();
    L11:
        r103 = ArraysKt.plus(r101, r210.f545767a);
        goto L12
    L8:
        r102 = false;
        goto L9
    }

    @Override // com.larus.im.service.audio.z
    public final void t(boolean r100) {
        fe9.a.f476620a.a("OmniVideoService", "startVideoWithExternalCapture, encoded=" + r100);
        d("startVideoWithExternalCapture");
        e("startVideoWithExternalCapture", new b1(this));
    }

    public static void m(String r100, int r101) {
        if (r101 == 0) goto L5;
        fe9.a.f476620a.f("OmniVideoService", r100 + " failed, ret=" + r101);
        return;
    }

    public final void e(String r100, Function1<? super NativeMediaSession, Unit> r101) {
        BuildersKt.launch$default(this.f347275c, null, null, new OmniVideoService$launchNativeCall$1(this, r100, r101, null), 3, null);
    }

    @Override // com.larus.im.service.audio.z
    public final void f(final float r100, final float r101) {
        fe9.a.f476620a.a("OmniVideoService", "focus " + r100 + ' ' + r101);
        e(ButtonColorBean.StateFocus, new i1(r100, r101));
    }

    @Override // com.larus.im.service.audio.z
    public final void w(final View r100, final boolean r101) {
        fe9.a r102 = fe9.a.f476620a;
        StringBuilder r103 = new StringBuilder("startVideoRecorder ");
        r103.append(r101);
        r103.append(", view: ");
        if (r100 == null) goto L5;
        String r104 = r100.toString();
    L6:
        r103.append(r104);
        r102.a("OmniVideoService", r103.toString());
        d("startVideoRecorder");
        e("startVideoRecorder", new e1(r100, r101, this));
        return;
    L5:
        r104 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [T, com.larus.im.internal.jni.session.NativeMediaSession] */
    public static final Object a(OmniVideoService r100, String r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof OmniVideoService$sessionOrNull$1) == false) goto L7;
        OmniVideoService$sessionOrNull$1 r103 = (OmniVideoService$sessionOrNull$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        NativeMediaSession r108 = null;
        if (r107 == 0) goto L18;
        if (r107 != 1) goto L17;
        r101 = (String) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L14
    L31:
        NativeMediaSession r109 = (NativeMediaSession) r105;     // Catch: Throwable -> L14
    L33:
        Object r110 = Result.m9449constructorimpl(r109);     // Catch: Throwable -> L14
    L37:
        if (Result.m9455isFailureimpl(r110) == false) goto L39;
        r110 = null;
    L39:
        NativeMediaSession r111 = (NativeMediaSession) r110;
    L40:
        if (r111 == null) goto L49;
        ReentrantLock r112 = r100.f347273a;
        r112.lock();
        if (Intrinsics.areEqual(r100.f347276d, r111) == false) goto L45;
        r108 = r111;
    L45:
        r112.unlock();
    L46:
        th = move-exception;
        r112.unlock();
        throw th;
    L49:
        r106 = r108;
        if (r106 != null) goto L52;
        fe9.a.f476620a.f("OmniVideoService", r101 + " ignored, native session is not ready");
    L52:
        return r106;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r105);
        Ref.ObjectRef r113 = new Ref.ObjectRef();
        ReentrantLock r114 = r100.f347273a;
        r114.lock();
        ?? r115 = r100.f347276d;     // Catch: Throwable -> L53
        r113.element = r115;     // Catch: Throwable -> L53
        if (r115 != 0) goto L23;
        CompletableDeferred<NativeMediaSession> r116 = r100.f347277e;     // Catch: Throwable -> L53
    L24:
        r114.unlock();
        r111 = (NativeMediaSession) r113.element;
        if (r111 != null) goto L40;
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L14
        if (r116 == null) goto L32;
        r103.L$0 = r101;     // Catch: Throwable -> L14
        r103.label = 1;     // Catch: Throwable -> L14
        r105 = r116.await(r103);     // Catch: Throwable -> L14
        if (r105 != r106) goto L31;
    L32:
        r109 = null;
        goto L33
    L23:
        r116 = null;
    L53:
        th = move-exception;
        r114.unlock();
        throw th;
    L14:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r103 = new OmniVideoService$sessionOrNull$1(r100, r102);
        goto L8
    }
}
