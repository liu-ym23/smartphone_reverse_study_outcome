package com.larus.camera.impl.ui.component.capture;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.camera.api.params.CaptureMode;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.base.BaseCameraViewModel;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.camera.impl.widget.TabPickerView;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;

/* JADX INFO: loaded from: classes26.dex */
public final class CaptureTabComponent extends com.larus.camera.impl.ui.arch.b implements com.larus.camera.impl.ui.component.capture.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f321861m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f321862n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f321863o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<String> f321864p;

    public static final class a extends com.larus.camera.impl.widget.q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CaptureTabComponent f321865a;

        @Override // com.larus.camera.impl.widget.q, com.larus.camera.impl.widget.p
        public final void a() {
            CameraCaptureViewModel r100 = (CameraCaptureViewModel) com.larus.camera.impl.ui.arch.b.e(this.f321865a).a();
            if (r100 != null) goto L5;
            return;
        L5:
            List<String> r101 = fx8.a.f479110a;
            if (fx8.a.f479110a.contains(r100.getCurrentCaptureMode()) == false) goto L9;
            r100.tryChangeAlbumThumbListState(true);
            r100.clickCameraButtonOnCapturePage("above_album_icon_arrow", "drag_open_album");
            r100.clickUploadEntrance("camera_album_thumbnail_click", "camera_album_thumbnail_click");
            return;
        }

        public a(CaptureTabComponent r100) {
            this.f321865a = r100;
        }
    }

    public CaptureTabComponent() {
        super(com.larus.camera.impl.ui.arch.c.f321812c, 1);
        this.f321861m = LazyKt.lazy(new z1(this));
        this.f321862n = LazyKt.lazy(new a2(this));
        this.f321863o = LazyKt.lazy(new b2(this));
        this.f321864p = fx8.a.f479115f;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void m() {
        final CameraCaptureViewModel r100 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.f321801e.getValue()).a();
        if (r100 != null) goto L5;
        return;
    L5:
        BaseCameraViewModel.tryAdaptBottomLine$default(r100, (ConstraintLayout) h(R.id.container), 0, null, 6, null);
        r100.resetCamera();
        CaptureMode r101 = r100.initCaptureMode();
        TabPickerView r102 = p();
        List<CaptureMode> r103 = r100.getCaptureModeList();
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L7:
        if (r105.hasNext() == false) goto L9;
        CaptureMode r106 = (CaptureMode) r105.next();
        r104.add(new TabPickerView.a(r106.getTabName(), Intrinsics.areEqual(r106.getMode(), r101.getMode())));
        goto L7
    L9:
        r102.setTabList(r104);
        r102.setOnTabPickedListener(new y1(r100));
        Unit r107 = Unit.INSTANCE;
        if (com.larus.camera.impl.utils.k.a() == false) goto L12;
        com.larus.utils.e1.o(h(R.id.capture_tips));
    L13:
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r100.getOnOrientationChanged(), new CaptureTabComponent$onViewCreated$2(this, null)), k());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r100.getSurfaceFlingAction(), new CaptureTabComponent$onViewCreated$3(r100, this, null)), k());
        if (p().getTabCount() <= 0) goto L16;
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r100.getAlbumThumbListStateChanged(), new CaptureTabComponent$onViewCreated$4(this, null)), k());
        com.larus.utils.e1.x(p());
        return;
    L16:
        com.larus.utils.e1.o(p());
        return;
    L12:
        com.larus.utils.e1.x(h(R.id.capture_tips));
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r100.getCaptureModeStatus(), new CaptureTabComponent$onViewCreated$1(r100, this, null)), k());
        goto L13
    }

    public final TabPickerView p() {
        return (TabPickerView) this.f321861m.getValue();
    }

    @Override // com.larus.camera.impl.ui.component.capture.a
    public final List<String> d() {
        return this.f321864p;
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
        return r100.inflate(R.layout.larus_layout_view_tab_component, r101, false);
    }
}
