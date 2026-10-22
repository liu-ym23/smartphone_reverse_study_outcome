package com.obric.oui.segmentedtab;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0001\rB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/segmentedtab/OSegmentTabView;", "Lcom/obric/oui/segmentedtab/OTouchAnimView;", "", "originIconAlpha", "", "setOriginIconAlpha", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OSegmentTabView extends OTouchAnimView {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static int f402704l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static Typeface f402705m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static Typeface f402706n;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f402707e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f402708f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f402709g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f402710h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f402711i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ImageView f402712j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f402713k;

    public static final class a {
        public static OSegmentTabView a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            TextView r101 = null;
            View r102 = RelativeLayout.inflate(r100, R.layout.o_layout_tab_segment, null);
            if (r102 == null) goto L11;
            OSegmentTabView r103 = (OSegmentTabView) r102;
            TextView r104 = (TextView) r103.findViewById(R.id.tv_tab_title);
            r103.f402711i = r104;
            if (r104 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("tabTitle");
        L8:
            OSegmentTabView.f402705m = r101.getTypeface();
            r103.f402712j = (ImageView) r103.findViewById(R.id.tv_tab_icon);
            return r103;
        L7:
            r101 = r104;
            goto L8
        L11:
            throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.segmentedtab.OSegmentTabView");
        }
    }

    static {
    }

    public OSegmentTabView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OSegmentTabView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.obric.oui.segmentedtab.OTouchAnimView
    public final boolean a() {
        return !this.f402713k;
    }

    public final void d(boolean r100) {
        wma.b.a(this.f402707e, Intrinsics.stringPlus("updateSelectState, isSelected: ", Boolean.valueOf(r100)));
        this.f402713k = r100;
        setSelected(r100);
        ImageView r101 = null;
        if (r100 == true) goto L5;
        cancelAnim();
        TextView r102 = this.f402711i;
        if (r102 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("tabTitle");
        r102 = null;
    L25:
        r102.setTextColor(this.f402709g);
        TextView r103 = this.f402711i;
        if (r103 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("tabTitle");
        r103 = null;
    L28:
        Typeface r104 = f402705m;
        if (r104 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("DEFAULT_TYPE_FACE");
        r104 = null;
    L31:
        r103.setTypeface(r104);
    L33:
        if (r100 == true) goto L35;
        cancelAnim();
        ImageView r105 = this.f402712j;
        if (r105 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L46:
        r101.setImageAlpha(this.f402710h);
        return;
    L45:
        r101 = r105;
        goto L46
    L35:
        if (b() == true) goto L49;
        ImageView r106 = this.f402712j;
        if (r106 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L41:
        r101.setImageAlpha(this.f402710h);
        return;
    L40:
        r101 = r106;
        goto L41
    L49:
        return;
    L5:
        if (b() == true) goto L33;
        TextView r107 = this.f402711i;
        if (r107 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("tabTitle");
        r107 = null;
    L10:
        r107.setTextColor(this.f402708f);
        TextView r108 = this.f402711i;
        if (r108 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("tabTitle");
        r108 = null;
    L13:
        Typeface r109 = f402705m;
        if (r109 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("DEFAULT_TYPE_FACE");
        r109 = null;
    L16:
        Intrinsics.checkNotNullParameter(r109, "typeface");
        if (f402706n == null) goto L19;
    L21:
        r108.setTypeface(f402706n);
        goto L33
    L19:
        if (Build.VERSION.SDK_INT < 28) goto L21;
        f402706n = Typeface.create(r109, 500, false);
        goto L21
    }

    public final void setOriginIconAlpha(int r100) {
        this.f402710h = r100;
    }

    @Override // com.obric.oui.segmentedtab.OTouchAnimView
    public final void c(float r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "scene");
        wma.b.a(this.f402707e, "onTouchAnimUpdate, scene: " + r111 + ", animFraction: " + r110);
        if (Intrinsics.areEqual(r111, "press_anim") == false) goto L6;
        int r100 = this.f402709g;
    L12:
        ImageView r101 = null;
        if (r100 == 0) goto L41;
        int r102 = (r100 >> 24) & 255;
        int r112 = RangesKt.coerceIn((int) (r102 * (1 - (r110 * 0.5f))), 0, 255);
        int r103 = ((r100 >> 16) & 255) << 16;
        int r104 = (r100 & 255) | ((r103 | (r112 << 24)) | (((r100 >> 8) & 255) << 8));
        TextView r105 = this.f402711i;
        if (r105 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("tabTitle");
        r105 = null;
    L18:
        r105.setTextColor(r104);
        TextView r106 = this.f402711i;
        if (r106 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("tabTitle");
        r106 = null;
    L22:
        if (this.f402713k == true) goto L24;
    L37:
        Typeface r107 = f402705m;
        if (r107 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("DEFAULT_TYPE_FACE");
        r107 = null;
    L40:
        r106.setTypeface(r107);
        wma.b.a(this.f402707e, "updateTextColorOnPress, scene: " + r111 + ", fraction: " + r110 + ", newTextAlpha: " + r112 + ", originTextAlpha: " + r102);
        goto L41
    L24:
        if (r110 != 0.0f) goto L26;
        boolean r108 = true;
    L27:
        if (r108 == false) goto L37;
        Typeface r109 = f402705m;
        if (r109 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("DEFAULT_TYPE_FACE");
        r109 = null;
    L31:
        Intrinsics.checkNotNullParameter(r109, "typeface");
        if (f402706n == null) goto L34;
    L36:
        r107 = f402706n;
        goto L40
    L34:
        if (Build.VERSION.SDK_INT < 28) goto L36;
        f402706n = Typeface.create(r109, 500, false);
        goto L36
    L26:
        r108 = false;
    L41:
        int r113 = RangesKt.coerceIn((int) (this.f402710h * (1 - (0.5f * r110))), 0, 255);
        ImageView r114 = this.f402712j;
        if (r114 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L45:
        r101.setImageAlpha(r113);
        wma.b.a(this.f402707e, "updateIconAlphaOnPress, scene: " + r111 + ", fraction: " + r110 + ", alpha: " + r113 + ", originIconAlpha: " + this.f402710h);
        return;
    L44:
        r101 = r114;
        goto L45
    L6:
        if (Intrinsics.areEqual(r111, "release_anim") == true) goto L8;
        r100 = 0;
        goto L12
    L8:
        if (this.f402713k == false) goto L10;
        r100 = this.f402708f;
        goto L12
    L10:
        r100 = this.f402709g;
        goto L12
    }

    public OSegmentTabView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        int r103 = f402704l;
        f402704l = r103 + 1;
        this.f402707e = Intrinsics.stringPlus("OSegmentTabView_", Integer.valueOf(r103));
    }

    public /* synthetic */ OSegmentTabView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
