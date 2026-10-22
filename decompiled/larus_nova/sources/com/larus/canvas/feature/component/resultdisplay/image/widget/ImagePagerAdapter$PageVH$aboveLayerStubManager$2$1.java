package com.larus.canvas.feature.component.resultdisplay.image.widget;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.canvas.impl.databinding.LarusCanvasPageImageAboveLayerBinding;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ImagePagerAdapter$PageVH$aboveLayerStubManager$2$1 extends FunctionReferenceImpl implements Function1<View, LarusCanvasPageImageAboveLayerBinding> {
    public static final ImagePagerAdapter$PageVH$aboveLayerStubManager$2$1 INSTANCE = null;

    static {
        INSTANCE = new ImagePagerAdapter$PageVH$aboveLayerStubManager$2$1();
    }

    public ImagePagerAdapter$PageVH$aboveLayerStubManager$2$1() {
        super(1, LarusCanvasPageImageAboveLayerBinding.class, "bind", "bind(Landroid/view/View;)Lcom/larus/canvas/impl/databinding/LarusCanvasPageImageAboveLayerBinding;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final LarusCanvasPageImageAboveLayerBinding invoke2(View r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        int r101 = R.id.center_icon;
        if (((ImageView) ViewBindings.findChildViewById(r100, R.id.center_icon)) == null) goto L13;
        r101 = R.id.center_ll;
        LinearLayout r102 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.center_ll);
        if (r102 == null) goto L13;
        r101 = R.id.center_text;
        if (((TextView) ViewBindings.findChildViewById(r100, R.id.center_text)) == null) goto L13;
        r101 = R.id.loading;
        ProgressBar r103 = (ProgressBar) ViewBindings.findChildViewById(r100, R.id.loading);
        if (r103 == null) goto L13;
        return new LarusCanvasPageImageAboveLayerBinding((ConstraintLayout) r100, r102, r103);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ LarusCanvasPageImageAboveLayerBinding invoke(View r100) {
        return invoke2(r100);
    }
}
