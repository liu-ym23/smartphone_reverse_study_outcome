package com.ss.android.lark.chat.preview.components;

import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.larus.nova.R;
import com.ss.android.lark.chat.preview.entity.component.property.UDLoadingProperty;
import com.ss.android.lark.export.entity.preview.Style;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class z extends q6c.e<UDLoadingProperty, ImageView, r6c.a> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Style f416234f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final y f416235g;

    @Override // q6c.a
    public final String i() {
        return "android.widget.ImageView";
    }

    @Override // q6c.e
    public final boolean j() {
        return false;
    }

    @Override // q6c.e, s6c.b
    public final View a(RectF r100) {
        Intrinsics.checkNotNullParameter(r100, "size");
        Dp r101 = this.f531875a;
        if (r101 == 0) goto L6;
        ImageView r102 = new ImageView(r101.getContext());
        r102.setScaleType(ImageView.ScaleType.CENTER);
        return r102;
    L6:
        Intrinsics.checkNotNullParameter(r100, "size");
        return null;
    }

    public void update(ImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Style r101 = this.f416234f;
        CircularProgressDrawable r102 = null;
        if (r101 == null) goto L5;
        ThemeColor r103 = r101.getTextColorV2();
    L6:
        if (r103 == null) goto L8;
        ThemeColor r104 = this.f416234f.getTextColorV2();
        Intrinsics.checkNotNull(r104);
        int r105 = com.ss.android.lark.export.entity.preview.a.a(r104, r100.getContext(), null);
    L9:
        Style r106 = this.f416234f;
        if (r106 == null) goto L12;
        float r107 = r106.getWidth();
    L13:
        float r108 = 0.1f * r107;
        float r109 = 2;
        float r110 = ((r107 * 0.8f) - (r109 * r108)) / r109;
        Drawable r111 = r100.getDrawable();
        if ((r111 instanceof CircularProgressDrawable) == false) goto L16;
        r102 = (CircularProgressDrawable) r111;
    L16:
        if (r102 != null) goto L18;
        r102 = new CircularProgressDrawable(r100.getContext());
    L18:
        r102.setStyle(1);
        r102.setStrokeWidth(UIHelper.dp2px(r108));
        r102.setColorSchemeColors(new int[]{r105});
        r102.setCenterRadius(UIHelper.dp2px(r110));
        r102.setStrokeCap(Paint.Cap.ROUND);
        r100.setImageDrawable(r102);
        r100.removeOnAttachStateChangeListener(this.f416235g);
        r100.addOnAttachStateChangeListener(this.f416235g);
        if (r100.isAttachedToWindow() == true) goto L21;
        return;
    L21:
        if (r102.isRunning() == true) goto L25;
        r102.start();
        return;
    L25:
        return;
    L12:
        r107 = 0.0f;
        goto L13
    L8:
        r105 = UIHelper.getColor(R.color.primary_fill_default);
        goto L9
    L5:
        r103 = null;
        goto L6
    }

    @Override // q6c.e
    public /* bridge */ /* synthetic */ void update(View r100) {
        update((ImageView) r100);
    }

    public z(UDLoadingProperty r100, Style r101, vcb.d r102) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        Intrinsics.checkNotNullParameter(r102, "dependency");
        super(r100, r101, r102);
        this.f416234f = r101;
        this.f416235g = new y();
    }
}
