package com.larus.canvas.feature.component.logic.provider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.canvas.impl.databinding.LarusLayoutCanvasGenerateTopProviderBinding;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.i0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b0 extends com.larus.gallery.api.t<ky8.a> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j f323427f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LarusLayoutCanvasGenerateTopProviderBinding f323428g;

    @Override // com.larus.gallery.api.t
    public final boolean n() {
        return false;
    }

    public b0(j r100) {
        Intrinsics.checkNotNullParameter(r100, "galleryContext");
        this.f323427f = r100;
    }

    @Override // com.larus.gallery.api.t
    public final View p(ViewGroup r100) {
        View r101 = LayoutInflater.from(getContext()).inflate(R.layout.larus_layout_canvas_generate_top_provider, r100, false);
        int r102 = R.id.back;
        ImageView r103 = (ImageView) ViewBindings.findChildViewById(r101, R.id.back);
        if (r103 == null) goto L39;
        r102 = R.id.background;
        if (((ImageView) ViewBindings.findChildViewById(r101, R.id.background)) == null) goto L39;
        r102 = R.id.indicator;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r101, R.id.indicator);
        if (r104 == null) goto L39;
        r102 = R.id.titleBar;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r101, R.id.titleBar)) == null) goto L39;
        this.f323428g = new LarusLayoutCanvasGenerateTopProviderBinding((FrameLayout) r101, r103, r104);
        ViewGroup.LayoutParams r105 = r103.getLayoutParams();
        if (r105 == null) goto L37;
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
        i0 r107 = i0.f375410a;
        r107.getClass();
        r106.topMargin = i0.g();
        r103.setLayoutParams(r106);
        LarusLayoutCanvasGenerateTopProviderBinding r108 = this.f323428g;
        if (r108 == null) goto L21;
        TextView r109 = r108.f323787c;
        if (r109 == null) goto L21;
        ViewGroup.LayoutParams r110 = r109.getLayoutParams();
        if (r110 == null) goto L20;
        ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) r110;
        r107.getClass();
        r111.topMargin = i0.g();
        r109.setLayoutParams(r111);
        goto L21
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L21:
        LarusLayoutCanvasGenerateTopProviderBinding r112 = this.f323428g;
        if (r112 == null) goto L24;
        ImageView r113 = r112.f323786b;
    L25:
        e1.d(r113, new a0(this));
        if (this.f323427f.f323443b <= 1) goto L32;
        LarusLayoutCanvasGenerateTopProviderBinding r114 = this.f323428g;
        if (r114 == null) goto L32;
        TextView r115 = r114.f323787c;
        if (r115 == null) goto L32;
        StringBuilder r116 = new StringBuilder();
        r116.append(this.f323427f.f323442a + 1);
        r116.append('/');
        r116.append(this.f323427f.f323443b);
        r115.setText(r116.toString());
    L32:
        LarusLayoutCanvasGenerateTopProviderBinding r117 = this.f323428g;
        if (r117 != null) goto L35;
        return null;
    L35:
        return r117.f323785a;
    L24:
        r113 = null;
        goto L25
    L37:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L39:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r102)));
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.Object, ky8.a] */
    @Override // com.larus.gallery.api.t
    public final void w(ky8.a r100, int r101) {
        ky8.a r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "data");
        this.f343898d = r102;
        if (this.f323427f.f323443b <= 1) goto L10;
        LarusLayoutCanvasGenerateTopProviderBinding r103 = this.f323428g;
        if (r103 == null) goto L11;
        TextView r104 = r103.f323787c;
        if (r104 == null) goto L12;
        StringBuilder r105 = new StringBuilder();
        r105.append(r101 + 1);
        r105.append('/');
        r105.append(this.f323427f.f323443b);
        r104.setText(r105.toString());
        return;
    L12:
        return;
    L11:
        return;
    }
}
