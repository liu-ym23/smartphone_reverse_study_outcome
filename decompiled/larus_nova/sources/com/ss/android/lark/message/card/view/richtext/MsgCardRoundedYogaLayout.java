package com.ss.android.lark.message.card.view.richtext;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.android.YogaLayout;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;

/* JADX INFO: loaded from: classes36.dex */
public class MsgCardRoundedYogaLayout extends YogaLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f431941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f431942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f431943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f431944d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f431945e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f431946f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f431947g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f431948h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f431949i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f431950j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f431951k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f431952l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f431953m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ImageView f431954n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f431955o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f431956p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public YogaNode f431957q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f431958r;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f431959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f431960b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f431961c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f431962d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Integer f431963e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Float f431964f;

        public a() {
        }
    }

    public class b extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f431965a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f431966b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MsgCardRoundedYogaLayout f431967c;

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            float r102 = this.f431967c.f431947g;
            if (r102 != 0.0f) goto L5;
            r101.setRect(0, 10, this.f431965a, this.f431966b);
            return;
        L5:
            r101.setRoundRect(0, 10, this.f431965a, this.f431966b, r102);
        }

        public b(MsgCardRoundedYogaLayout r100, int r101, int r102) {
            this.f431967c = r100;
            this.f431965a = r101;
            this.f431966b = r102;
        }
    }

    private int getDefaultBgColor() {
        if (this.f431953m == false) goto L7;
        return 0;
    L7:
        if (this.f431952l == false) goto L10;
        return this.f431942b;
    L10:
        return this.f431944d;
    }

    public final void b() {
        if (this.f431942b == 0) goto L5;
    L14:
        boolean r100 = true;
    L15:
        if (r100 == true) goto L17;
        return;
    L17:
        GradientDrawable r101 = a(getDefaultBgColor(), this.f431946f, this.f431945e);
        GradientDrawable r102 = a(this.f431943c, this.f431946f, this.f431945e);
        GradientDrawable r103 = a(this.f431944d, this.f431946f, this.f431945e);
        StateListDrawable r104 = new StateListDrawable();
        if (this.f431953m == false) goto L21;
        r102.setColor(getResources().getColor(R.color.transparent));
    L21:
        if (this.f431943c == 0) goto L23;
        r104.addState(new int[]{R.attr.state_pressed}, r102);
        r104.addState(new int[]{R.attr.state_focused}, r102);
        r104.addState(new int[]{-16842910}, r103);
    L23:
        r104.addState(new int[0], r101);
        setBackground(r104);
        return;
    L5:
        if (this.f431943c != 0) goto L14;
        if (this.f431944d != 0) goto L14;
        if (this.f431945e != 0) goto L11;
    L13:
        r100 = false;
        goto L15
    L11:
        if (this.f431946f <= 0) goto L13;
        goto L13
    }

    public void c() {
        this.f431957q.setMargin(YogaEdge.RIGHT, UIUtils.dp2px(this.f431941a, 6.0f));
        this.f431957q.setWidth(this.f431955o);
        this.f431957q.setHeight(this.f431956p);
        this.f431954n.setVisibility(0);
        RotateAnimation r100 = new RotateAnimation(0.0f, 360.0f, 0, this.f431955o / 2.0f, 0, this.f431956p / 2.0f);
        r100.setDuration(1000);
        r100.setFillAfter(true);
        r100.setInterpolator(new LinearInterpolator());
        r100.setRepeatMode(1);
        r100.setRepeatCount(-1);
        this.f431954n.setAnimation(r100);
    }

    public MsgCardRoundedYogaLayout(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public void setBackgroundColor(int r100) {
        this.f431942b = r100;
        b();
    }

    public void setCustomizations(a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Integer r101 = r100.f431959a;
        if (r101 == null) goto L7;
        this.f431942b = r101.intValue();
    L7:
        Integer r102 = r100.f431960b;
        if (r102 == null) goto L10;
        this.f431943c = r102.intValue();
    L10:
        Integer r103 = r100.f431961c;
        if (r103 == null) goto L13;
        this.f431944d = r103.intValue();
    L13:
        Integer r104 = r100.f431963e;
        if (r104 == null) goto L16;
        this.f431946f = r104.intValue();
    L16:
        Integer r105 = r100.f431962d;
        if (r105 == null) goto L19;
        this.f431945e = r105.intValue();
    L19:
        Float r106 = r100.f431964f;
        if (r106 == null) goto L22;
        this.f431947g = r106.floatValue();
    L22:
        b();
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        this.f431952l = r100;
    }

    public void setLoadingIcon(int r100) {
        this.f431954n.setImageResource(r100);
    }

    public void setTintColorForLoadingIcon(int r100) {
        int r101 = UDColorUtils.getColor(this.f431941a, r100);
        Drawable r102 = UDIconUtils.getIconDrawable(this.f431941a, com.larus.nova.R.drawable.ud_icon_loading_outlined, r101);
        this.f431954n.setImageDrawable(r102);
    }

    public MsgCardRoundedYogaLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public MsgCardRoundedYogaLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f431942b = 0;
        this.f431943c = 0;
        this.f431944d = 0;
        this.f431945e = 0;
        this.f431946f = 0;
        this.f431947g = 0.0f;
        this.f431948h = 0.0f;
        this.f431949i = 0.0f;
        this.f431950j = 0.0f;
        this.f431951k = 0.0f;
        this.f431952l = true;
        this.f431953m = false;
        this.f431941a = r100;
        this.f431958r = UIUtils.dp2px(r100, 13.0f);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.enabled, com.larus.nova.R.attr.fb_borderColor, com.larus.nova.R.attr.fb_borderWidth, com.larus.nova.R.attr.fb_defaultColor, com.larus.nova.R.attr.fb_disabledColor, com.larus.nova.R.attr.fb_ghost, com.larus.nova.R.attr.fb_pressedColor, com.larus.nova.R.attr.fb_radius, com.larus.nova.R.attr.fb_radiusBottomLeft, com.larus.nova.R.attr.fb_radiusBottomRight, com.larus.nova.R.attr.fb_radiusTopLeft, com.larus.nova.R.attr.fb_radiusTopRight}, r102, 0);
        this.f431942b = r103.getColor(3, this.f431942b);
        this.f431943c = r103.getColor(6, this.f431943c);
        this.f431944d = r103.getColor(4, this.f431944d);
        boolean r104 = r103.getBoolean(0, isEnabled());
        this.f431952l = r104;
        super.setEnabled(r104);
        this.f431945e = r103.getColor(1, this.f431945e);
        this.f431946f = (int) r103.getDimension(2, this.f431946f);
        float r105 = r103.getDimension(7, this.f431947g);
        this.f431947g = r105;
        this.f431948h = r103.getDimension(10, r105);
        this.f431949i = r103.getDimension(11, this.f431947g);
        this.f431950j = r103.getDimension(8, this.f431947g);
        this.f431951k = r103.getDimension(9, this.f431947g);
        this.f431953m = r103.getBoolean(5, this.f431953m);
        r103.recycle();
        this.f431954n = new ImageView(r100);
        this.f431954n.setImageDrawable(UDIconUtils.getIconDrawable(r100, com.larus.nova.R.drawable.ud_icon_loading_outlined, UDColorUtils.getColor(r100, com.larus.nova.R.color.primary_fill_default)));
        addView(this.f431954n);
        this.f431957q = getYogaNodeForView(this.f431954n);
        int r106 = UIUtils.dp2px(r100, 13.0f);
        this.f431956p = r106;
        this.f431955o = r106;
        this.f431957q.setMargin(YogaEdge.RIGHT, 0.0f);
        this.f431957q.setWidth(0.0f);
        this.f431957q.setHeight(0.0f);
        this.f431954n.setVisibility(8);
        b();
    }

    public final GradientDrawable a(int r100, int r101, int r102) {
        GradientDrawable r103 = new GradientDrawable();
        r103.setColor(r100);
        if (r101 <= 0) goto L6;
        if (r102 == 0) goto L6;
        r103.setStroke(r101, r102);
    L6:
        float r104 = this.f431947g;
        if (r104 <= 0.0f) goto L9;
        r103.setCornerRadius(r104);
    L10:
        return r103;
    L9:
        float r105 = this.f431948h;
        float r106 = this.f431949i;
        float r107 = this.f431951k;
        float r108 = this.f431950j;
        r103.setCornerRadii(new float[]{r105, r105, r106, r106, r107, r107, r108, r108});
        goto L10
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        setOutlineProvider(new b(this, r100, r101));
    }
}
