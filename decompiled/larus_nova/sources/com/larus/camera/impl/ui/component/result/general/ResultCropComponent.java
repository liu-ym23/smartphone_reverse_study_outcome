package com.larus.camera.impl.ui.component.result.general;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBindings;
import com.bytedance.awemeopen.apps.photo.pinch.PinchEnterMethod;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.larus.bmhome.view.crop.ImageCropView;
import com.larus.camera.impl.databinding.LarusLayoutViewCropComponentBinding;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;

/* JADX INFO: loaded from: classes26.dex */
public final class ResultCropComponent extends com.larus.camera.impl.ui.arch.b {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LarusLayoutViewCropComponentBinding f322142m;

    public static final class a implements ImageCropView.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CameraResultViewModel f322143a;

        @Override // com.larus.bmhome.view.crop.ImageCropView.a
        public final void a() {
            CameraResultViewModel.onSingleFunctionEditButtonShow$default(this.f322143a, "modify_range", "picture_crop", "camera_confirm", null, 8, null);
            this.f322143a.clickButton("modify_range", "picture_crop", BitableAnalytic.ProgressInputType.DRAG);
        }

        @Override // com.larus.bmhome.view.crop.ImageCropView.a
        public final void b() {
            this.f322143a.clickButton("modify_range", "picture_crop", PinchEnterMethod.PINCH);
        }

        @Override // com.larus.bmhome.view.crop.ImageCropView.a
        public final void c() {
            this.f322143a.setCropRegionChanged(true);
        }

        public a(CameraResultViewModel r100) {
            this.f322143a = r100;
        }
    }

    public ResultCropComponent() {
        super(com.larus.camera.impl.ui.arch.c.f321812c, 1);
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void m() {
        final CameraResultViewModel r100 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.f321801e.getValue()).a();
        if (r100 != null) goto L5;
        return;
    L5:
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r100.isInCropMode(), new ResultCropComponent$onViewCreated$1(this, r100, null)), k());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r100.m8549getBitmapToCrop(), new ResultCropComponent$onViewCreated$2(this, null)), k());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r100.getRotation(), new ResultCropComponent$onViewCreated$3(this, null)), k());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r100.getCropRegionChanged(), new ResultCropComponent$onViewCreated$4(this, null)), k());
        r100.onCropComponentReady();
        LarusLayoutViewCropComponentBinding r101 = this.f322142m;
        if (r101 == null) goto L10;
        Button r102 = r101.f321516b;
        if (r102 == null) goto L10;
        com.larus.utils.e1.d(r102, new i(this, r100));
    L10:
        LarusLayoutViewCropComponentBinding r103 = this.f322142m;
        if (r103 == null) goto L15;
        ImageCropView r104 = r103.f321517c;
        if (r104 == null) goto L15;
        r104.setClipRegionChangedListener(new a(r100));
    L15:
        CameraResultViewModel.onSingleFunctionEditButtonShow$default(r100, "modify_range", "picture_crop", "camera_confirm", null, 8, null);
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
        View r102 = r100.inflate(R.layout.larus_layout_view_crop_component, r101, false);
        int r103 = R.id.bottom_line;
        if (((Guideline) ViewBindings.findChildViewById(r102, R.id.bottom_line)) == null) goto L15;
        r103 = R.id.btn_finish_crop;
        Button r104 = (Button) ViewBindings.findChildViewById(r102, R.id.btn_finish_crop);
        if (r104 == null) goto L15;
        ConstraintLayout r105 = (ConstraintLayout) r102;
        ImageCropView r106 = (ImageCropView) ViewBindings.findChildViewById(r102, R.id.preview_clip_image);
        if (r106 != null) goto L9;
        r103 = R.id.preview_clip_image;
        goto L15
    L9:
        if (((Guideline) ViewBindings.findChildViewById(r102, R.id.top_line)) == null) goto L12;
        this.f322142m = new LarusLayoutViewCropComponentBinding(r105, r104, r106);
        return r105;
    L12:
        r103 = R.id.top_line;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
