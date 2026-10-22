package com.larus.im.internal.rtcsdk.impl;

import android.view.View;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.ButtonColorBean;
import com.larus.audio.call.plugins.CommonVideoAutoTestPlugin;
import com.ss.bytertc.engine.RTCEngine;
import com.ss.bytertc.engine.VideoCanvas;
import com.ss.bytertc.engine.data.ReturnStatus;
import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.data.VideoBufferType;
import com.ss.bytertc.engine.data.VideoCodecType;
import com.ss.bytertc.engine.data.VideoFrameData;
import com.ss.bytertc.engine.data.VideoPictureType;
import com.ss.bytertc.engine.data.VideoPixelFormat;
import com.ss.bytertc.engine.data.VideoRotation;
import com.ss.bytertc.engine.data.ZoomConfigType;
import com.ss.bytertc.engine.data.ZoomDirectionType;
import com.ss.bytertc.engine.mediaio.RTCEncodedVideoFrame;
import com.ss.bytertc.engine.type.TorchState;
import com.ss.bytertc.engine.video.VideoPreprocessorConfig;
import java.nio.ByteBuffer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes30.dex */
public final class m1 implements ff9.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s1 f349948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<ff9.i, Unit> f349949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f349950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f349951d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function1<? super Long, Unit> f349952e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f349953f;

    public static final class a {
    }

    static {
    }

    @Override // ff9.v
    public final void d() {
        RTCEngine r100 = this.f349948a.a(false);
        if (r100 != null) goto L5;
        fe9.a.f476620a.f("FlowRTCVideoServiceImpl", "stopVideoCapture called, engine == null");
        return;
    L5:
        Intrinsics.checkNotNullParameter(r100, "$this$configEngine");
        fe9.a.f476620a.e("FlowRTCVideoServiceImpl", "stopVideoCapture called");
        r100.stopVideoCapture();
        Unit r101 = Unit.INSTANCE;
    }

    @Override // ff9.v
    public final void g() {
        RTCEngine r100 = this.f349948a.a(false);
        if (r100 == null) goto L5;
        r100.setVideoDigitalZoomConfig(ZoomConfigType.ZOOM_FOCUS_OFFSET, 0.08f);
    L5:
        RTCEngine r101 = this.f349948a.a(false);
        if (r101 == null) goto L9;
        r101.setVideoDigitalZoomControl(ZoomDirectionType.CAMERA_ZOOM_IN);
        return;
    }

    @Override // ff9.v
    public final boolean isCameraTorchSupported() {
        Boolean r100 = Boolean.FALSE;
        if ((2 & 2) == 0) goto L5;
        boolean r101 = true;
    L6:
        RTCEngine r102 = this.f349948a.a(r101);
        if (r102 != null) goto L9;
        fe9.a.f476620a.f("FlowRTCVideoServiceImpl", "checkCameraTorchSupported called, engine == null");
    L10:
        boolean r103 = r100.booleanValue();
        fe9.a.f476620a.e("FlowRTCVideoServiceImpl", "isCameraTorchSupported =" + r103);
        return r103;
    L9:
        Intrinsics.checkNotNullParameter(r102, "$this$configEngine");
        r100 = Boolean.valueOf(r102.isCameraTorchSupported());
        goto L10
    L5:
        r101 = false;
        goto L6
    }

    @Override // ff9.v
    public final void k() {
        RTCEngine r100 = this.f349948a.a(false);
        if (r100 == null) goto L5;
        r100.setVideoDigitalZoomConfig(ZoomConfigType.ZOOM_FOCUS_OFFSET, 0.08f);
    L5:
        RTCEngine r101 = this.f349948a.a(false);
        if (r101 == null) goto L9;
        r101.setVideoDigitalZoomControl(ZoomDirectionType.CAMERA_ZOOM_OUT);
        return;
    }

    @Override // ff9.v
    public final void l() {
        RTCEngine r100 = this.f349948a.a(false);
        if (r100 == null) goto L6;
        r100.setVideoDigitalZoomControl(ZoomDirectionType.CAMERA_RESET);
        return;
    }

    @Override // ff9.v
    public final void o() {
        RTCEngine r100 = this.f349948a.a(false);
        if (r100 != null) goto L5;
        fe9.a.f476620a.f("FlowRTCVideoServiceImpl", "clearCanvas called, engine == null");
        return;
    L5:
        Intrinsics.checkNotNullParameter(r100, "$this$configEngine");
        fe9.a.f476620a.e("FlowRTCVideoServiceImpl", "clearCanvas called");
        r100.setLocalVideoCanvas(StreamIndex.STREAM_INDEX_MAIN, new VideoCanvas());
        Unit r101 = Unit.INSTANCE;
    }

    @Override // ff9.v
    public final void p() {
        fe9.a.f476620a.e("FlowRTCVideoServiceImpl", "[registerVideoCallProcessor]");
        v.f350031a.getClass();
        RTCEngine r100 = v.f350041k;
        Integer r101 = null;
        if (r100 == null) goto L5;
        Integer r102 = Integer.valueOf(r100.registerLocalVideoProcessor(null, null));
    L6:
        RTCEngine r103 = v.f350041k;
        if (r103 == null) goto L9;
        w1 r104 = v.f350045o;
        VideoPreprocessorConfig r105 = new VideoPreprocessorConfig();
        r105.requiredPixelFormat = VideoPixelFormat.I420;
        r105.streamIndex = StreamIndex.STREAM_INDEX_MAIN;
        Unit r106 = Unit.INSTANCE;
        r101 = Integer.valueOf(r103.registerLocalVideoProcessor(r104, r105));
    L9:
        if (r102 != null) goto L12;
    L17:
        fe9.h.f476628a.b("FlowRTCEngineManager", "registerVideoCallProcessor failed, result1: " + r102 + ", result2: " + r101);
        return;
    L12:
        if (r102.intValue() != 0) goto L17;
        if (r101 == null) goto L17;
        if (r101.intValue() != 0) goto L17;
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // ff9.v
    public final void release() {
        fe9.a r100 = fe9.a.f476620a;
        r100.e("FlowRTCVideoServiceImpl", "release video service: clear external encoded video handler and callbacks");
        ((w1) this.f349950c.getValue()).f350056a = null;
        RTCEngine r101 = this.f349948a.a(false);
        if (r101 != null) goto L5;
        r100.f("FlowRTCVideoServiceImpl", "release called, engine == null");
    L6:
        this.f349951d = null;
        this.f349952e = null;
        return;
    L5:
        Intrinsics.checkNotNullParameter(r101, "$this$configEngine");
        r101.setExternalVideoEncoderEventHandler(null);
        Unit r102 = Unit.INSTANCE;
        goto L6
    }

    @Override // ff9.v
    public final boolean b(final boolean r100) {
        return ((Boolean) m(this, "switchCamera", Boolean.FALSE, new g1(r100))).booleanValue();
    }

    @Override // ff9.v
    public final boolean c(boolean r100) {
        Boolean r101 = Boolean.FALSE;
        boolean r102 = true;
        RTCEngine r103 = this.f349948a.a(true);
        if (r103 != null) goto L5;
        fe9.a.f476620a.f("FlowRTCVideoServiceImpl", "switchTorchStatus".concat(" called, engine == null"));
    L15:
        return r101.booleanValue();
    L5:
        Intrinsics.checkNotNullParameter(r103, "$this$configEngine");
        if (r100 == false) goto L8;
        TorchState r104 = TorchState.TORCH_STATE_ON;
    L10:
        if (r103.setCameraTorch(r104) == ReturnStatus.RETURN_STATUS_SUCCESS.value()) goto L13;
        r102 = false;
    L13:
        r101 = Boolean.valueOf(r102);
        goto L15
    L8:
        r104 = TorchState.TORCH_STATE_OFF;
        goto L10
    }

    @Override // ff9.v
    public final void h(final tf9.b r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        VideoRotation r101 = VideoRotation.fromId(r100.f545782f);
        if (r101 != null) goto L5;
        r101 = VideoRotation.VIDEO_ROTATION_90;
    L5:
        final VideoFrameData r102 = new VideoFrameData();
        r102.bufferType = VideoBufferType.GL_TEXTURE;
        r102.pixelFormat = VideoPixelFormat.TEXTURE_2D;
        r102.eglContext = r100.f545777a;
        r102.textureId = r100.f545778b;
        r102.textureMatrix = r100.f545779c;
        r102.seiData = null;
        r102.roiData = null;
        r102.rotation = r101;
        r102.width = r100.f545780d;
        r102.height = r100.f545781e;
        r102.timestampUs = r100.f545783g;
        a("pushVideoFrame", false, new i1(r102, r100));
        if (r100.f545784h == false) goto L9;
        this.f349949b.invoke(ff9.i.s.f476747a);
        return;
    }

    @Override // ff9.v
    public final int j(tf9.a r110) {
        Intrinsics.checkNotNullParameter(r110, "frame");
        fe9.a r100 = fe9.a.f476620a;
        r100.e("FlowRTCVideoServiceImpl", "sendEncodedVideoFrame called, timestampUs=" + r110.f545769c + ", frameType=" + r110.f545774h + ", codec=" + r110.f545773g + ", dataSize=" + r110.f545767a.length + ", codecConfigSize=" + r110.f545768b.length + ", width=" + r110.f545770d + ", height=" + r110.f545771e + ", rotation=" + r110.f545772f);
        Intrinsics.checkNotNullParameter(r110, "<this>");
        ByteBuffer r101 = ByteBuffer.allocateDirect(r110.f545767a.length + r110.f545768b.length);
        r101.put(r110.f545768b);
        r101.put(r110.f545767a);
        r101.position(0);
        int r102 = ff9.w.f476778a[r110.f545774h.ordinal()];
        if (r102 == 1) goto L8;
        if (r102 != 2) goto L7;
        VideoPictureType r103 = VideoPictureType.VIDEO_PICTURE_TYPE_P;
    L9:
        VideoPictureType r111 = r103;
        long r104 = r110.f545769c;
        int r112 = r110.f545770d;
        int r113 = r110.f545771e;
        int r105 = ff9.w.f476779b[r110.f545773g.ordinal()];
        ByteBuffer r114 = null;
        if (r105 == 1) goto L23;
        if (r105 != 2) goto L13;
        VideoCodecType r106 = VideoCodecType.VIDEO_CODEC_TYPE_BYTEVC1;
    L24:
        VideoCodecType r115 = r106;
        VideoRotation r107 = VideoRotation.fromId(r110.f545772f);
        if (r107 != null) goto L27;
        r107 = VideoRotation.VIDEO_ROTATION_90;
    L27:
        final RTCEncodedVideoFrame r116 = new RTCEncodedVideoFrame(r101, r104, r104, r112, r113, r115, r111, r107);
        byte[] r108 = r110.f545775i;
        if (r108 == null) goto L30;
        r114 = com.flow.kmp.common.util.b.g(r108);
    L30:
        r116.seiData = r114;
    L31:
        if (r116 != null) goto L34;
        r100.e("FlowRTCVideoServiceImpl", "sendEncodedVideoFrame unsupported codec: " + r110.f545773g);
        return -1;
    L34:
        final Ref.IntRef r109 = new Ref.IntRef();
        a("sendEncodedVideoFrame", false, new j1(r109, r116));
        return r109.element;
    L13:
        if (r105 != 3) goto L15;
        r106 = VideoCodecType.VIDEO_CODEC_TYPE_UNKNOWN;
        goto L24
    L15:
        if (r105 != 4) goto L20;
        r106 = VideoCodecType.fromId(3);
        if (r106 != null) goto L24;
        r116 = null;
        goto L31
    L20:
        throw new NoWhenBranchMatchedException();
    L23:
        r106 = VideoCodecType.VIDEO_CODEC_TYPE_H264;
        goto L24
    L7:
        throw new NoWhenBranchMatchedException();
    L8:
        r103 = VideoPictureType.VIDEO_PICTURE_TYPE_I;
        goto L9
    }

    @Override // ff9.v
    public final void q(CommonVideoAutoTestPlugin.a r100) {
        fe9.a.f476620a.e("FlowRTCVideoServiceImpl", "[setVideoProcessor] start setVideoProcessor(" + r100 + ')');
        ((w1) this.f349950c.getValue()).f350056a = r100;
    }

    public m1(d1 r100, h0 r101) {
        Intrinsics.checkNotNullParameter(r100, "rtcEngineProvider");
        Intrinsics.checkNotNullParameter(r101, "notifier");
        this.f349948a = r100;
        this.f349949b = r101;
        this.f349950c = LazyKt.lazy(new e1());
        this.f349953f = LazyKt.lazy(new f1(this));
    }

    @Override // ff9.v
    public final void f(final float r100, final float r101) {
        a(ButtonColorBean.StateFocus, true, new k1(r100, r101));
    }

    @Override // ff9.v
    public final void i(final View r100, boolean r101) {
        if (r100 == null) goto L5;
        a("configEngine", true, new l1(r100));
    L5:
        b(r101);
        RTCEngine r102 = this.f349948a.a(true);
        if (r102 != null) goto L8;
        fe9.a.f476620a.f("FlowRTCVideoServiceImpl", "startVideoCapture".concat(" called, engine == null"));
        return;
    L8:
        Intrinsics.checkNotNullParameter(r102, "$this$configEngine");
        int r103 = r102.startVideoCapture();
        fe9.a.f476620a.e("FlowRTCVideoServiceImpl", "startVideoCapture called, result=" + r103);
        Unit r104 = Unit.INSTANCE;
    }

    public final void a(String r100, boolean r101, Function1<? super RTCEngine, Unit> r102) {
        RTCEngine r103 = this.f349948a.a(r101);
        if (r103 != null) goto L6;
        fe9.a.f476620a.f("FlowRTCVideoServiceImpl", r100.concat(" called, engine == null"));
        return;
    L6:
        r102.invoke(r103);
    }

    @Override // ff9.v
    public final void e(final boolean r100, final Function0<Unit> r101, final Function1<? super Long, Unit> r102) {
        Intrinsics.checkNotNullParameter(r101, "onKeyFrameRequested");
        Intrinsics.checkNotNullParameter(r102, "onTargetBitrateUpdated");
        a("startVideoWithExternalCapture", true, new h1(r100, this, r101, r102));
    }

    public static Object m(m1 r100, String r101, Object r102, Function1 r103) {
        RTCEngine r104 = r100.f349948a.a(true);
        if (r104 != null) goto L6;
        fe9.a.f476620a.f("FlowRTCVideoServiceImpl", r101.concat(" called, engine == null"));
        return r102;
    L6:
        return r103.invoke(r104);
    }
}
