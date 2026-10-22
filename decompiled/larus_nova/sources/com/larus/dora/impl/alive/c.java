package com.larus.dora.impl.alive;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.GradientDrawable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.dora.impl.databinding.LarusDoraKeepAliveItemLayoutBinding;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class c extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LarusDoraKeepAliveItemLayoutBinding f331998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f331999b;

    public c(LarusDoraKeepAliveItemLayoutBinding r100, float r101) {
        this.f331998a = r100;
        this.f331999b = r101;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        super.onFailure(r100, r101);
        g49.d.c("DoraKeepAliveAdapter", "onFailure: " + r100, r101);
        SimpleDraweeView r102 = this.f331998a.f332773b;
        GradientDrawable r103 = new GradientDrawable();
        r103.setCornerRadius(this.f331999b);
        int r104 = j0.f375426a;
        r103.setColor(j0.a(R.color.larus_base_1_overlay));
        r102.setBackground(r103);
        e1.x(this.f331998a.f332774c);
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        Intrinsics.checkNotNullParameter(r100, "id");
        g49.d.d("DoraKeepAliveAdapter", "onFinalImageSet: " + r100 + ", " + ((ImageInfo) r101));
    }
}
