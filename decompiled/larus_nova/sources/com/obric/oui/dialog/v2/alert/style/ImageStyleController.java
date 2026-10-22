package com.obric.oui.dialog.v2.alert.style;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.image.OImageAppIcon;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import pla.d;
import zla.f;
import zla.h;

/* JADX INFO: loaded from: classes34.dex */
public final class ImageStyleController implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f400764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f400765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable f400766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f400767d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f400768e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f400769f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f400770g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f400771h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f400772i;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/obric/oui/dialog/v2/alert/style/ImageStyleController$ImageStyle;", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ImageStyle {
    }

    public static final class a {
    }

    public static final class b extends FrameLayout {
        public b(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100);
        }

        @Override // android.widget.FrameLayout, android.view.View
        public final void onMeasure(int r100, int r101) {
            super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r100) / 2, 1073741824));
        }
    }

    static {
    }

    public final View d() {
        View r100 = this.f400772i;
        if (r100 == null) goto L6;
        return r100;
    L6:
        if (this.f400765b == 0) goto L8;
    L10:
        ImageView r101 = new ImageView(this.f400764a);
    L11:
        r101.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Drawable r102 = this.f400766c;
        if (r102 == null) goto L14;
        r101.setImageDrawable(r102);
    L14:
        return r101;
    L8:
        if (this.f400770g == false) goto L10;
        OImageAppIcon r103 = new OImageAppIcon(this.f400764a, null, 6, 0);
        r103.setClipToMask(this.f400771h);
        r101 = r103;
        goto L11
    }

    @Override // zla.h
    public final void b(AbstractDialog r100) {
        Intrinsics.checkNotNullParameter(this, "this");
        Intrinsics.checkNotNullParameter(r100, "dialog");
    }

    @Override // zla.h
    public final void c(zla.a r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        h.a.a(this, r100);
    }

    public ImageStyleController(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f400764a = r100;
        this.f400765b = r101;
    }

    @Override // zla.h
    public final void a(Context r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dialogContainer");
        int r102 = this.f400765b;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        FrameLayout r103 = r101.getBannerSlot();
    L9:
        r103.setVisibility(0);
        int r104 = -2;
        if (this.f400765b != 0) goto L19;
        Integer r105 = this.f400768e;
        if (r105 == null) goto L14;
        Intrinsics.checkNotNull(r105);
        int r106 = r105.intValue();
    L15:
        Integer r107 = this.f400767d;
        if (r107 == null) goto L18;
        Intrinsics.checkNotNull(r107);
        r104 = r107.intValue();
    L18:
        FrameLayout.LayoutParams r108 = new FrameLayout.LayoutParams(r106, r104);
        r108.gravity = 1;
        r108.topMargin = d.c(r100, 4);
        r108.bottomMargin = d.c(r100, 16);
        r103.addView(d(), r108);
        return;
    L14:
        r106 = -2;
        goto L15
    L19:
        Integer r109 = this.f400768e;
        if (r109 == null) goto L22;
        Intrinsics.checkNotNull(r109);
        int r110 = r109.intValue();
    L23:
        Integer r111 = this.f400767d;
        if (r111 == null) goto L26;
        Intrinsics.checkNotNull(r111);
        r104 = r111.intValue();
    L26:
        FrameLayout.LayoutParams r112 = new FrameLayout.LayoutParams(r110, r104);
        if (this.f400769f == false) goto L29;
        FrameLayout r113 = new FrameLayout(r100);
    L30:
        r113.addView(d(), new FrameLayout.LayoutParams(-1, -1));
        r103.addView(r113, r112);
        return;
    L29:
        r113 = new b(r100);
        goto L30
    L22:
        r110 = -1;
        goto L23
    L7:
        throw new IllegalArgumentException(Intrinsics.stringPlus("Unsupported style: ", Integer.valueOf(this.f400765b)));
    L8:
        r103 = r101.getIconSlot();
        goto L9
    }
}
