package com.larus.camera.impl.ui.component.generalonly;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextSwitcher;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.camera.api.params.CaptureMode;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.camera.impl.utils.CameraData;
import com.larus.camera.impl.widget.CaptureFocusFrame;
import com.larus.nova.R;
import com.larus.platform.api.IFlowChatThemeConfigProvider;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;

/* JADX INFO: loaded from: classes26.dex */
public final class q extends com.larus.camera.impl.ui.arch.b implements com.larus.camera.impl.ui.component.capture.a {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f322113t = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f322114m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public xx8.h f322115n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Set<String> f322116o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<String> f322117p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CaptureFocusFrame f322118q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f322119r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f322120s;

    public static final class a {
    }

    static {
    }

    public q() {
        super(com.larus.camera.impl.ui.arch.c.f321812c, 1);
        this.f322114m = LazyKt.lazy(new n(this));
        this.f322116o = new LinkedHashSet();
        this.f322117p = fx8.a.f479110a;
        this.f322119r = 8;
        this.f322120s = 8;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void m() {
        CameraCaptureViewModel r100 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.f321801e.getValue()).a();
        if (r100 == null) goto L9;
        CameraData r101 = r100.getCameraData();
        if (r101 == null) goto L9;
        boolean r102 = true;
        if (r101.getEnableCaptureTips() != true) goto L9;
    L11:
        if (r102 == false) goto L15;
        IFlowChatThemeConfigProvider r103 = (IFlowChatThemeConfigProvider) ServiceManager.get().getService(IFlowChatThemeConfigProvider.class);
        if (r103 == null) goto L21;
        r103.a(new m(this), AdaptThemeFeatureKey.CHAT_CAMERA_TIPS);
    L21:
        CameraCaptureViewModel r104 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.f321801e.getValue()).a();
        if (r104 == null) goto L35;
        String r105 = r104.getCameraData().getCaptureMode();
        List<CaptureMode> r106 = r104.getCaptureModeList();
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r108 = r106.iterator();
    L26:
        if (r108.hasNext() == false) goto L28;
        r107.add(((CaptureMode) r108.next()).getMode());
        goto L26
    L28:
        FLogger.f375446a.i("CaptureCameraTipsComponent", "[setupFocusFrame] current:" + r105 + ", modeList:" + r107);
        if (r104.getCameraData().getEnableFocusFrame() == false) goto L35;
        if (Intrinsics.areEqual(r105, "CAPTURE_MODE_PHOTO") == false) goto L33;
    L34:
        this.f322118q = new CaptureFocusFrame(getContext(), null);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r104.getCaptureModeStatus(), new CaptureCameraTipsComponent$setupFocusFrame$1(this, null)), k());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r104.getOnOrientationChanged(), new CaptureCameraTipsComponent$setupFocusFrame$2(this, null)), k());
        goto L35
    L33:
        if (r107.contains("CAPTURE_MODE_PHOTO") == true) goto L34;
    L35:
        CameraCaptureViewModel r109 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.f321801e.getValue()).a();
        if (r109 == null) goto L41;
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r109.getRecordingState(), new CaptureCameraTipsComponent$setupObserver$1(this, null)), k());
        return;
    L41:
        return;
    L15:
        View r110 = h(R.id.camera_recorder_tips);
        if (r110 == null) goto L18;
        e1.o(r110);
    L18:
        e1.o(q());
        if (r100 == null) goto L21;
        r100.recordCameraTipsType(null);
    L9:
        r102 = false;
        goto L11
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void n() {
        FLogger.f375446a.i("CaptureCameraTipsComponent", "onViewDestroyed");
        xx8.h r100 = this.f322115n;
        if (r100 != null) goto L13;
        return;
    L13:
        Handler r101 = r100.f565350e;     // Catch: Exception -> L9
        if (r101 == null) goto L11;
        r101.removeCallbacksAndMessages(null);     // Catch: Exception -> L9
    L11:
        r100.f565346a = null;
        r100.f565350e = null;
        return;
    L9:
        e = move-exception;
        FLogger.f375446a.e("TextViewSwitcherAdapter", "onDestroy e=" + e);
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e);
        goto L11
    }

    public final TextSwitcher q() {
        return (TextSwitcher) this.f322114m.getValue();
    }

    @Override // com.larus.camera.impl.ui.component.capture.a
    public final List<String> d() {
        return this.f322117p;
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [com.larus.camera.impl.ui.component.generalonly.p] */
    public static final void p(final q r100) {
        final CameraCaptureViewModel r101 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) r100.f321801e.getValue()).a();
        if (r101 == null) goto L63;
        List<String> r102 = r101.getCameraData().getTips();
        List<String> r103 = r102;
        if (r103 != null) goto L8;
    L11:
        boolean r104 = true;
    L12:
        String r105 = null;
        if (r104 == false) goto L15;
        e1.o(r100.q());
        r101.recordCameraTipsType(null);
        return;
    L15:
        e1.x(r100.q());
        r101.recordCameraTipsType(r101.getCameraData().getTipsShowOrder());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r101.getAlbumThumbListStateChanged(), new CaptureCameraTipsComponent$setupTipsSwitcher$1(r100, null)), r100.k());
        r100.q().setFactory(new o(r100));
        r100.f322115n = new xx8.h(r100.q(), r102, new p(r100, r101));
        r101.autoRecordCameraTipsCount();
        Integer r106 = r101.getCameraData().getTipsShowOrder();
        int r107 = CameraTabTipsShowOrder.ORDER.getType();
        if (r106 != null) goto L19;
    L26:
        int r108 = CameraTabTipsShowOrder.RANDOM.getType();
        if (r106 != null) goto L30;
    L46:
        xx8.h r109 = r100.f322115n;
        if (r109 == null) goto L49;
        r105 = r109.a(r100.getContext());
    L49:
        xx8.h r110 = r100.f322115n;
        if (r110 == null) goto L52;
        r110.b();
    L52:
        if (r105 != null) goto L54;
        return;
    L54:
        if ((!StringsKt.isBlank(r105)) == true) goto L56;
        return;
    L56:
        if (r100.f322116o.add(r105) == false) goto L62;
        r101.showCameraItemMobOnCapture("intro_text", r105);
        return;
    L62:
        return;
    L30:
        if (r106.intValue() != r108) goto L46;
        xx8.h r111 = r100.f322115n;
        if (r111 == null) goto L43;
        Context r112 = r100.getContext();
        Intrinsics.checkNotNullParameter(r112, PerfLog.PARAM_KEY_CONTEXT_ID);
        r105 = (String) ListProtector.get(r111.f565347b, ((Number) ListProtector.get((List) r111.f565352g.getValue(), r111.f565349d % r111.f565347b.size())).intValue());
        TextSwitcher r113 = r111.f565346a;
        if (r113 == null) goto L36;
        r113.setText(r105);
    L36:
        TextSwitcher r114 = r111.f565346a;
        if (r114 == null) goto L39;
        r114.setInAnimation(r112, R.anim.larus_fade_in_slide_in_bottom);
    L39:
        TextSwitcher r115 = r111.f565346a;
        if (r115 == null) goto L42;
        r115.setOutAnimation(r112, R.anim.larus_fade_out_slide_out_top);
    L42:
        r111.f565349d++;
    L43:
        xx8.h r116 = r100.f322115n;
        if (r116 == null) goto L52;
        r116.c();
        goto L52
    L19:
        if (r106.intValue() != r107) goto L26;
        xx8.h r117 = r100.f322115n;
        if (r117 == null) goto L23;
        r105 = r117.a(r100.getContext());
    L23:
        xx8.h r118 = r100.f322115n;
        if (r118 == null) goto L52;
        r118.b();
        goto L52
    L8:
        if (r103.isEmpty() == true) goto L11;
        r104 = false;
        goto L12
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final CameraContainer.b f(int r100) {
        CameraContainer.b r101 = super.f(r100);
        ((FrameLayout.LayoutParams) r101).width = -1;
        ((FrameLayout.LayoutParams) r101).height = -1;
        return r101;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final View g(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return r100.inflate(R.layout.larus_layout_camera_tips_component, r101, false);
    }
}
