package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.ImageViewCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.badge.UDBadgeView;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes18.dex */
public class BaseTitleBar extends LinearLayout {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f240025w = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View.OnClickListener f240026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a> f240027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f240028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinearLayout f240029d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewGroup f240030e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearLayout f240031f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RelativeLayout f240032g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f240033h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f240034i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f240035j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f240036k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f240037l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f240038m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f240039n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f240040o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f240041p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ImageView f240042q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f240043r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f240044s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public LayoutInflater f240045t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f240046u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f240047v;

    public static class CreateActionViewException extends Exception {
        public CreateActionViewException(String r100, k r101) {
            super(r100);
        }
    }

    public interface a {
        String getId();

        void performAction(View r100);
    }

    public static class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f240048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public BadgeStyle f240049b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f240050c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f240051d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Boolean f240052e;

        @Override // com.bytedance.ee.bear.widgets.BaseTitleBar.a
        public void performAction(View r100) {
        }

        @Override // com.bytedance.ee.bear.widgets.BaseTitleBar.a
        public String getId() {
            if (TextUtils.isEmpty(this.f240048a) == false) goto L6;
            this.f240048a = String.format(Locale.US, "Action#%d", new Object[]{Integer.valueOf(View.generateViewId())});
        L6:
            return this.f240048a;
        }

        public b() {
            this.f240051d = true;
        }
    }

    public static class c extends b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f240053f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Drawable f240054g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final CharSequence f240055h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final ColorStateList f240056i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f240057j;

        public c(int r100) {
            this.f240056i = null;
            this.f240057j = false;
            this.f240053f = r100;
        }

        public c(Drawable r100) {
            this.f240056i = null;
            this.f240057j = false;
            this.f240054g = r100;
        }

        public c(Drawable r100, ColorStateList r101) {
            this.f240056i = null;
            this.f240057j = false;
            this.f240054g = r100;
            this.f240056i = r101;
        }

        public c(Drawable r100, CharSequence r101) {
            this.f240056i = null;
            this.f240057j = false;
            this.f240054g = r100;
            this.f240055h = r101;
        }
    }

    public static class d extends c {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f240058k;

        public d(Drawable r100, int r101, CharSequence r102) {
            super(r100, r102);
            this.f240058k = r101;
        }
    }

    public static class e extends b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final CharSequence f240059f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f240060g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f240061h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final ColorStateList f240062i;

        public e(CharSequence r100) {
            this.f240060g = -1;
            this.f240061h = 17;
            this.f240062i = null;
            this.f240059f = r100;
        }

        public e(CharSequence r100, int r101) {
            this.f240060g = -1;
            this.f240061h = 17;
            this.f240062i = null;
            this.f240059f = r100;
            this.f240060g = r101;
        }

        public e(CharSequence r100, ColorStateList r101) {
            this.f240060g = -1;
            this.f240061h = 17;
            this.f240062i = null;
            this.f240059f = r100;
            this.f240062i = r101;
        }
    }

    public static class f extends b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final View f240063f;

        public f(View r100) {
            this.f240063f = r100;
        }
    }

    public int getImageMenuLayout() {
        return R.layout.widget_image_menu;
    }

    public final void f() {
        this.f240030e.removeAllViews();
    }

    public final void g() {
        this.f240031f.removeAllViews();
        ((ArrayList) this.f240027b).clear();
    }

    public View getCustomTitleView() {
        if (this.f240032g.getChildCount() != 0) goto L7;
        return null;
    L7:
        return this.f240032g.getChildAt(0);
    }

    public Drawable getLeftDrawable() {
        return this.f240028c.getCompoundDrawables()[0];
    }

    public ColorStateList getLeftIconTint() {
        return this.f240042q.getImageTintList();
    }

    public boolean getLeftIconVisibility() {
        if (this.f240042q.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int getLeftVisibleIconCount() {
        int r100 = 0;
        if (this.f240029d.getVisibility() == 0) goto L6;
        return 0;
    L6:
        if (this.f240030e.getVisibility() != 0) goto L8;
        boolean r101 = true;
    L9:
        int r102 = this.f240030e.getChildCount();
        if (r101 == false) goto L20;
        if (r102 <= 0) goto L20;
        int r103 = 0;
        int r104 = 0;
    L13:
        if (r103 >= r102) goto L22;
        View r105 = this.f240030e.getChildAt(r103);
        if (r105 == null) goto L19;
        if (r105.getVisibility() != 0) goto L19;
        r104 = r104 + 1;
    L19:
        r103 = r103 + 1;
    L22:
        if (this.f240042q.getVisibility() != 0) goto L25;
        r100 = 1;
    L25:
        return r104 + r100;
    L20:
        r104 = 0;
        goto L22
    L8:
        r101 = false;
        goto L9
    }

    public TextView getRightText() {
        if (((ArrayList) this.f240027b).size() <= 0) goto L8;
        a r100 = (a) ListProtector.get(this.f240027b, 0);
        if (r100 == null) goto L8;
        View r101 = d(r100.getId());
    L10:
        if ((r101 instanceof TextView) == true) goto L12;
        return null;
    L12:
        return (TextView) r101;
    L8:
        r101 = null;
        goto L10
    }

    public int getRightVisibleIconCount() {
        int r100 = 0;
        if (this.f240031f.getVisibility() != 0) goto L5;
        boolean r101 = true;
    L6:
        int r102 = this.f240031f.getChildCount();
        if (r101 == false) goto L23;
        if (r102 <= 0) goto L24;
        int r103 = 0;
    L10:
        if (r100 >= r102) goto L18;
        View r104 = this.f240031f.getChildAt(r100);
        if (r104 == null) goto L16;
        if (r104.getVisibility() != 0) goto L16;
        r103 = r103 + 1;
    L16:
        r100 = r100 + 1;
        goto L10
    L18:
        return r103;
    L24:
        return 0;
    L23:
        return 0;
    L5:
        r101 = false;
        goto L6
    }

    public static int getStatusBarHeight() {
        Resources r100 = Resources.getSystem();
        int r101 = r100.getIdentifier("status_bar_height", "dimen", "android");
        if (r101 > 0) goto L7;
        return 0;
    L7:
        return r100.getDimensionPixelSize(r101);
    }

    public void b() {
        int r100 = (int) getResources().getDimension(R.dimen.title_center_layout_margin_small);
        int r101 = (int) getResources().getDimension(R.dimen.title_center_layout_margin_mid);
        int r102 = (int) getResources().getDimension(R.dimen.title_center_layout_margin_large);
        int r103 = getLeftVisibleIconCount();
        int r104 = getRightVisibleIconCount();
        if (this.f240040o == false) goto L9;
        if (r103 <= 0) goto L6;
        int r105 = r100;
    L7:
        if (r104 > 0) goto L21;
    L20:
        r100 = r102;
    L21:
        LinearLayout.LayoutParams r106 = (LinearLayout.LayoutParams) this.f240032g.getLayoutParams();
        if (r106 == null) goto L24;
        ((ViewGroup.MarginLayoutParams) r106).rightMargin = r100;
        ((ViewGroup.MarginLayoutParams) r106).leftMargin = r105;
        ((ViewGroup.MarginLayoutParams) r106).topMargin = 0;
        ((ViewGroup.MarginLayoutParams) r106).bottomMargin = 0;
    L24:
        this.f240032g.setLayoutParams(r106);
        return;
    L6:
        r105 = r102;
        goto L7
    L9:
        if (r103 != 0) goto L15;
        if (this.f240041p == true) goto L16;
        r100 = r101;
    L17:
        if (r104 != 0) goto L19;
        r105 = r100;
        r100 = r101;
        goto L21
    L19:
        r105 = r100;
    L16:
        r100 = 0;
        goto L17
    L15:
        if (r103 != 1) goto L17;
        goto L16
    }

    public RelativeLayout getCenterLayout() {
        return this.f240032g;
    }

    public View.OnClickListener getLeftExtraClickListener() {
        return this.f240026a;
    }

    public ImageView getLeftImage() {
        return this.f240042q;
    }

    public LinearLayout getLeftLayout() {
        return this.f240029d;
    }

    public TextView getLeftText() {
        return this.f240028c;
    }

    public LinearLayout getRightLayout() {
        return this.f240031f;
    }

    public BaseTitleBar(Context r100) {
        this(r100, null, 0);
    }

    private void setDefaultTextStyle(TextView r100) {
        r100.setTextColor(getResources().getColor(R.color.text_title));
        r100.setSingleLine();
        r100.setGravity(16);
        r100.setEllipsize(TextUtils.TruncateAt.END);
    }

    public final View d(String r110) {
        ViewGroup[] r100 = {this.f240030e, this.f240031f};
        int r101 = 0;
    L3:
        if (r101 >= 2) goto L13;
        ViewGroup r102 = r100[r101];
        int r103 = r102.getChildCount();
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L12;
        View r105 = r102.getChildAt(r104);
        Object r106 = r105.getTag();
        if ((r106 instanceof a) == false) goto L11;
        if (((a) r106).getId().equals(r110) == false) goto L11;
        return r105;
    L11:
        r104 = r104 + 1;
        goto L5
    L12:
        r101 = r101 + 1;
        goto L3
    L13:
        return null;
    }

    public final int e(View r100) {
        int r101 = this.f240038m;
        if (r100 != null) goto L5;
        return r101;
    L5:
        if (r100.getVisibility() != 8) goto L7;
        int r102 = this.f240038m;
    L9:
        return r102;
    L7:
        r102 = r100.getMeasuredWidth();
        goto L9
    }

    public final void h(float r100) {
        this.f240031f.setPadding(np5.b.a(0.0f), np5.b.a(0.0f), np5.b.a(r100), np5.b.a(0.0f));
    }

    public void j(int r100) {
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r102 >= this.f240030e.getChildCount()) goto L7;
        l((ImageView) this.f240030e.getChildAt(r102).findViewById(R.id.widgetTitleMenuImg), r100);
        r102 = r102 + 1;
    L7:
        if (r101 >= this.f240031f.getChildCount()) goto L15;
        View r103 = this.f240031f.getChildAt(r101);
        ImageView r104 = (ImageView) r103.findViewById(R.id.widgetTitleMenuImg);
        if ((r103.getTag() instanceof c) == true) goto L11;
    L13:
        l(r104, r100);
    L14:
        r101 = r101 + 1;
        goto L7
    L11:
        if (((c) r103.getTag()).f240057j == false) goto L13;
    }

    public void setActionIconTint(int r100) {
        this.f240046u = r100;
        j(r100);
    }

    public void setCenterClickListener(View.OnClickListener r100) {
        this.f240032g.setOnClickListener(r100);
    }

    public void setCenterViewVisible(int r100) {
        this.f240032g.setVisibility(r100);
    }

    public void setCustomLeftView(View r100) {
        LinearLayout.LayoutParams r101 = new LinearLayout.LayoutParams(-2, -1);
        this.f240029d.removeAllViews();
        this.f240029d.addView(r100, r101);
    }

    public void setCustomRightView(View r100) {
        LinearLayout.LayoutParams r101 = new LinearLayout.LayoutParams(-2, -1);
        this.f240031f.removeAllViews();
        this.f240031f.setPadding(0, 0, 0, 0);
        this.f240031f.addView(r100, r101);
    }

    public void setCustomTitleView(View r100) {
        this.f240032g.removeAllViews();
        if (r100 == null) goto L6;
        RelativeLayout.LayoutParams r101 = new RelativeLayout.LayoutParams(-1, -2);
        r101.addRule(14, -1);
        this.f240032g.addView(r100, r101);
        return;
    }

    public void setDivider(int r100) {
        this.f240035j.setBackgroundResource(r100);
    }

    public void setDividerColor(int r100) {
        this.f240035j.setBackgroundColor(r100);
    }

    public void setDividerHeight(int r100) {
        this.f240035j.getLayoutParams().height = r100;
    }

    public void setDividerVisible(boolean r100) {
        View r101 = this.f240035j;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public void setHeight(int r100) {
        this.f240039n = r100;
        setMeasuredDimension(getMeasuredWidth(), this.f240039n);
    }

    public void setImmersive(boolean r100) {
        this.f240036k = r100;
        if (r100 == false) goto L5;
        this.f240037l = getStatusBarHeight();
        return;
    L5:
        this.f240037l = 0;
    }

    public void setIsCenterAlways(boolean r100) {
        this.f240040o = r100;
        invalidate();
    }

    public void setLeftClickListener(final View.OnClickListener r100) {
        this.f240029d.setOnClickListener(new h(this, r100));
    }

    public void setLeftExtraClickListener(View.OnClickListener r100) {
        this.f240026a = r100;
    }

    public void setLeftIconVisibility(boolean r100) {
        ImageView r101 = this.f240042q;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        LinearLayout.LayoutParams r103 = (LinearLayout.LayoutParams) this.f240042q.getLayoutParams();
        if (r100 == false) goto L9;
        int r104 = 0;
    L10:
        this.f240029d.setPadding(r104, 0, 0, 0);
        return;
    L9:
        r104 = r103.getMarginStart();
        goto L10
    L5:
        r102 = 8;
        goto L6
    }

    public void setLeftImageResource(int r100) {
        np5.a.a(this.f240042q, r100, this.f240043r);
    }

    public void setLeftImageResourceWithoutTint(int r100) {
        this.f240042q.setImageResource(r100);
        ImageViewCompat.setImageTintList(this.f240042q, null);
    }

    public void setLeftImageTint(int r100) {
        l(this.f240042q, r100);
    }

    public void setLeftText(CharSequence r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f240028c.setText(r100);
    }

    public void setLeftTextBackground(int r100) {
        this.f240028c.setBackgroundResource(r100);
    }

    public void setLeftTextColor(int r100) {
        this.f240028c.setTextColor(r100);
    }

    public void setLeftTextSize(float r100) {
        this.f240028c.setTextSize(r100);
    }

    public void setLeftVisible(boolean r100) {
        LinearLayout r101 = this.f240029d;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public void setMainTitleBackground(int r100) {
        this.f240033h.setBackgroundResource(r100);
    }

    public void setMainTitleColor(int r100) {
        this.f240033h.setTextColor(r100);
    }

    public void setMainTitleSize(float r100) {
        this.f240033h.setTextSize(r100);
    }

    public void setMainTitleVisible(boolean r100) {
        TextView r101 = this.f240033h;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public void setNeedReturnBack(boolean r100) {
        this.f240047v = r100;
    }

    public void setRightVisible(boolean r100) {
        LinearLayout r101 = this.f240031f;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public void setSkipCenterMarginWhenLeftAligned(boolean r100) {
        this.f240041p = r100;
        b();
    }

    public void setSubTitle(CharSequence r100) {
        if (this.f240034i.getVisibility() == 0) goto L5;
        this.f240034i.setVisibility(0);
    L5:
        this.f240034i.setText(r100);
    }

    public void setSubTitleBackground(int r100) {
        this.f240034i.setBackgroundResource(r100);
    }

    public void setSubTitleColor(int r100) {
        this.f240034i.setTextColor(r100);
    }

    public void setSubTitleSize(float r100) {
        this.f240034i.setTextSize(r100);
    }

    public void setSubTitleVisible(boolean r100) {
        TextView r101 = this.f240034i;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public void setSupportAutoRemoveBadgePoint(boolean r100) {
        this.f240044s = r100;
    }

    public void setTitle(int r100) {
        setTitle(getResources().getString(r100));
    }

    public void setTitleMaxEms(int r100) {
        this.f240033h.setMaxEms(r100);
    }

    public void setTitleRightViewBottom(View r100) {
        RelativeLayout.LayoutParams r101 = new RelativeLayout.LayoutParams(-2, -2);
        r101.addRule(1, this.f240033h.getId());
        r101.addRule(8, this.f240033h.getId());
        this.f240032g.addView(r100, r101);
    }

    public void setLeftText(int r100) {
        this.f240028c.setText(r100);
    }

    public void setLeftTextColor(ColorStateList r100) {
        this.f240028c.setTextColor(r100);
    }

    public void setSubTitle(int r100) {
        setSubTitle(getResources().getString(r100));
    }

    public void setTitle(CharSequence r100) {
        i(r100, false);
    }

    public BaseTitleBar(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public final View a(b r100, boolean r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        View r102 = d(r100.getId());
        if (r102 == null) goto L19;
        return r102;
    L19:
        View r103 = c(r100, r101);     // Catch: CreateActionViewException -> L16
        if (r101 == false) goto L11;
        ((ArrayList) this.f240027b).add(r100);     // Catch: CreateActionViewException -> L16
        this.f240031f.addView(r103);     // Catch: CreateActionViewException -> L16
    L12:
        int r104 = this.f240046u;     // Catch: CreateActionViewException -> L16
        if (r104 == 0) goto L15;
        j(r104);     // Catch: CreateActionViewException -> L16
    L15:
        return r103;
    L11:
        this.f240030e.addView(r103);     // Catch: CreateActionViewException -> L16
    L16:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.d("BaseTitleBar", e);
        return null;
    }

    public final View c(b r110, boolean r111) throws CreateActionViewException {
        int r100 = 0;
        if ((r110 instanceof d) == false) goto L41;
        d r101 = (d) r110;
        LayoutInflater r112 = this.f240045t;
        int r113 = getImageMenuLayout();
        if (r111 == false) goto L7;
        ViewGroup r114 = this.f240031f;
    L8:
        View r115 = r112.inflate(r113, r114, false);
        r115.findViewById(R.id.widgetTitleMenuImg).setVisibility(8);
        LKUILottieAnimationView r102 = (LKUILottieAnimationView) r115.findViewById(R.id.widgetTitleMenuLottie);
        r102.setVisibility(0);
        r102.setAnimation(r101.f240058k);
        TextView r103 = (TextView) r115.findViewById(R.id.widgetTitleMenuImgText);
        if (TextUtils.isEmpty(r101.f240055h) == false) goto L11;
        r103.setVisibility(8);
    L12:
        View r104 = r115.findViewById(R.id.widgetTitleMenuBadgePoint);
        UDBadgeView r105 = (UDBadgeView) r115.findViewById(R.id.widgetTitleMenuBadgeNumFrame);
        int r106 = r101.f240050c;
        BadgeStyle r107 = r101.f240049b;
        if (r107 != null) goto L16;
        r104.setVisibility(8);
        r105.setVisibility(8);
    L103:
        if (r115 == null) goto L110;
        r115.setTag(r110);
        r115.setEnabled(r110.f240051d);
        Boolean r108 = r110.f240052e;
        if (r108 == null) goto L107;
        r115.setSelected(r108.booleanValue());
    L107:
        r115.setContentDescription(r110.getId());
        r115.setOnClickListener(new k(this, r110));
        return r115;
    L110:
        throw new CreateActionViewException("action:" + r110, null);
    L16:
        if (r107 != BadgeStyle.point) goto L22;
        r105.setVisibility(8);
        if (r106 > 0) goto L21;
        r100 = 8;
    L21:
        r104.setVisibility(r100);
        goto L103
    L22:
        BadgeStyle r109 = BadgeStyle.num;
        if (r107 != r109) goto L25;
    L33:
        r104.setVisibility(8);
        if (r106 <= 0) goto L39;
        if (r107 != r109) goto L37;
        r105.setBadgeColorRes(R.color.function_danger_500);
    L38:
        r105.setVisibility(0);
        r105.setText(String.valueOf(Math.min(r106, 999)));
        r105.a();
        goto L103
    L37:
        r105.setBadgeColorRes(R.color.icon_disable);
        goto L38
    L39:
        r105.setVisibility(8);
        goto L103
    L25:
        if (r107 == BadgeStyle.mute) goto L33;
        if (r107 != BadgeStyle.text) goto L103;
        r104.setVisibility(8);
        if (TextUtils.isEmpty(null) == true) goto L32;
        r105.setBadgeColorRes(R.color.function_danger_500);
        r105.setVisibility(0);
        r105.setText(null);
        r105.a();
        goto L103
    L32:
        r105.setVisibility(8);
        goto L103
    L11:
        r103.setText(r101.f240055h);
        r103.setVisibility(0);
        goto L12
    L7:
        r114 = this.f240030e;
        goto L8
    L41:
        if ((r110 instanceof c) == false) goto L90;
        final c r116 = (c) r110;
        LayoutInflater r117 = this.f240045t;
        int r118 = getImageMenuLayout();
        if (r111 == false) goto L45;
        ViewGroup r119 = this.f240031f;
    L46:
        r115 = r117.inflate(r118, r119, false);
        final AppCompatImageView r120 = (AppCompatImageView) r115.findViewById(R.id.widgetTitleMenuImg);
        Drawable r121 = r116.f240054g;
        if (r121 == null) goto L49;
        r120.setImageDrawable(r121);
    L51:
        if (r116.f240056i == null) goto L53;
        r120.post(new j(r120, r116));
    L53:
        TextView r122 = (TextView) r115.findViewById(R.id.widgetTitleMenuImgText);
        if (TextUtils.isEmpty(r116.f240055h) == false) goto L56;
        r122.setVisibility(8);
    L61:
        View r123 = r115.findViewById(R.id.widgetTitleMenuBadgePoint);
        UDBadgeView r124 = (UDBadgeView) r115.findViewById(R.id.widgetTitleMenuBadgeNumFrame);
        int r125 = r116.f240050c;
        BadgeStyle r126 = r116.f240049b;
        if (r126 != null) goto L65;
        r123.setVisibility(8);
        r124.setVisibility(8);
        goto L103
    L65:
        if (r126 != BadgeStyle.point) goto L71;
        r124.setVisibility(8);
        if (r125 > 0) goto L70;
        r100 = 8;
    L70:
        r123.setVisibility(r100);
        goto L103
    L71:
        BadgeStyle r127 = BadgeStyle.num;
        if (r126 != r127) goto L74;
    L82:
        r123.setVisibility(8);
        if (r125 <= 0) goto L88;
        if (r126 != r127) goto L86;
        r124.setBadgeColorRes(R.color.function_danger_500);
    L87:
        r124.setVisibility(0);
        r124.setText(String.valueOf(Math.min(r125, 999)));
        r124.a();
        goto L103
    L86:
        r124.setBadgeColorRes(R.color.icon_disable);
        goto L87
    L88:
        r124.setVisibility(8);
        goto L103
    L74:
        if (r126 == BadgeStyle.mute) goto L82;
        if (r126 != BadgeStyle.text) goto L103;
        r123.setVisibility(8);
        if (TextUtils.isEmpty(null) == true) goto L81;
        r124.setBadgeColorRes(R.color.function_danger_500);
        r124.setVisibility(0);
        r124.setText(null);
        r124.a();
        goto L103
    L81:
        r124.setVisibility(8);
        goto L103
    L56:
        r122.setText(r116.f240055h);
        ColorStateList r128 = r116.f240056i;
        if (r128 == null) goto L59;
        r122.setTextColor(r128);
    L60:
        r122.setVisibility(0);
        goto L61
    L59:
        r122.setTextColor(getResources().getColorStateList(R.color.facade_selector_icon_n1_v2));
        goto L60
    L49:
        r120.setImageResource(r116.f240053f);
        goto L51
    L45:
        r119 = this.f240030e;
        goto L46
    L90:
        if ((r110 instanceof e) == false) goto L100;
        e r129 = (e) r110;
        TextView r130 = new TextView(getContext());
        setDefaultTextStyle(r130);
        r130.setText(r129.f240059f);
        r130.setTextSize(r129.f240061h);
        ColorStateList r131 = r129.f240062i;
        if (r131 == null) goto L95;
        r130.setTextColor(r131);
    L98:
        int r132 = (int) getResources().getDimension(R.dimen.widget_menu_half_margin);
        r130.setPadding(r132, 0, r132, 0);
        r115 = r130;
        goto L103
    L95:
        if (r129.f240060g == (-1)) goto L97;
        r130.setTextColor(getResources().getColorStateList(r129.f240060g));
        goto L98
    L97:
        r130.setTextColor(getResources().getColorStateList(R.color.widget_black_c2_c3_selector));
        goto L98
    L100:
        if ((r110 instanceof f) == false) goto L102;
        r115 = ((f) r110).f240063f;
        goto L103
    L102:
        r115 = null;
        goto L103
    }

    public final void i(CharSequence r100, boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 == false) goto L6;
        this.f240032g.removeAllViews();
        this.f240032g.addView(this.f240033h);
        this.f240032g.addView(this.f240034i);
    L6:
        int r102 = r100.toString().indexOf("\n");
        if (r102 <= 0) goto L9;
        CharSequence r103 = r100.subSequence(0, r102);
        CharSequence r104 = r100.subSequence(r102 + 1, r100.length());
        this.f240033h.setText(r103);
        this.f240034i.setText(r104);
        this.f240034i.setVisibility(0);
        return;
    L9:
        int r105 = r100.toString().indexOf("\t");
        if (r105 <= 0) goto L12;
        CharSequence r106 = r100.subSequence(0, r105);
        String r107 = " " + r100.subSequence(r105 + 1, r100.length());
        this.f240033h.setText(r106);
        this.f240034i.setText(r107);
        this.f240034i.setVisibility(0);
        return;
    L12:
        this.f240033h.setText(r100);
        this.f240034i.setVisibility(8);
    }

    public final boolean k(String r100, Drawable r101) {
        View r102 = d(r100);
        if (r101 == null) goto L9;
        if (r102 == null) goto L11;
        AppCompatImageView r103 = (AppCompatImageView) r102.findViewById(R.id.widgetTitleMenuImg);
        if (r103 == null) goto L12;
        r103.setBackgroundDrawable(null);
        r103.setImageDrawable(null);
        r103.setImageDrawable(r101);
        return true;
    L12:
        return false;
    L11:
        return false;
    L9:
        return false;
    }

    public final void l(ImageView r100, int r101) {
        if (r100 == null) goto L8;
        if (r101 != 0) goto L5;
        ColorStateList r102 = null;
    L6:
        r100.setImageTintList(r102);
        return;
    L5:
        r102 = getResources().getColorStateList(r101);
        goto L6
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r100, int r110) {
        if (View.MeasureSpec.getMode(r110) == 1073741824) goto L5;
        int r111 = this.f240039n;
        int r101 = this.f240037l + r111;
        r110 = View.MeasureSpec.makeMeasureSpec(r111, 1073741824);
    L6:
        int r102 = View.MeasureSpec.getSize(r100);
        measureChild(this.f240029d, r100, r110);
        measureChild(this.f240031f, r100, r110);
        int r103 = this.f240029d.getMeasuredWidth();
        int r104 = this.f240031f.getMeasuredWidth();
        LinearLayout.LayoutParams r105 = (LinearLayout.LayoutParams) this.f240032g.getLayoutParams();
        int r106 = 0;
        if (r105 == null) goto L10;
        r106 = 0 + (((ViewGroup.MarginLayoutParams) r105).leftMargin + ((ViewGroup.MarginLayoutParams) r105).rightMargin);
    L10:
        if (this.f240040o == false) goto L14;
        if (r103 <= r104) goto L13;
        this.f240032g.measure(View.MeasureSpec.makeMeasureSpec((r102 - (r103 * 2)) - r106, 1073741824), r110);
    L15:
        measureChild(this.f240035j, r100, r110);
        setMeasuredDimension(r102, r101);
        return;
    L13:
        this.f240032g.measure(View.MeasureSpec.makeMeasureSpec((r102 - (r104 * 2)) - r106, 1073741824), r110);
        goto L15
    L14:
        this.f240032g.measure(View.MeasureSpec.makeMeasureSpec(((r102 - e(this.f240029d)) - e(this.f240031f)) - r106, 1073741824), r110);
        goto L15
    L5:
        r101 = View.MeasureSpec.getSize(r110) + this.f240037l;
        goto L6
    }

    public BaseTitleBar(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        this.f240027b = new ArrayList();
        this.f240040o = true;
        this.f240041p = false;
        this.f240046u = 0;
        this.f240047v = false;
        Resources r100 = r110.getResources();
        TypedArray r113 = r110.obtainStyledAttributes(r111, new int[]{R.attr.widget_widgets_tb_action_fakeBoldText, R.attr.widget_widgets_tb_action_padding, R.attr.widget_widgets_tb_back_icon, R.attr.widget_widgets_tb_back_tint, R.attr.widget_widgets_tb_background, R.attr.widget_widgets_tb_divider_height, R.attr.widget_widgets_tb_divider_visible, R.attr.widget_widgets_tb_left_title, R.attr.widget_widgets_tb_title, R.attr.widget_widgets_tb_title_color});
        String r101 = r113.getString(8);
        int r102 = r113.getColor(4, r100.getColor(R.color.bg_body));
        int r103 = r113.getColor(9, r100.getColor(R.color.text_title));
        int r104 = r113.getResourceId(2, R.drawable.ud_icon_left_outlined);
        int r105 = r113.getResourceId(3, R.color.facade_selector_icon_n1_v2);
        this.f240043r = r105;
        boolean r106 = r113.getBoolean(6, true);
        float r107 = r113.getDimension(5, np5.b.a(Float.valueOf(1).floatValue()));
        String r114 = r113.getString(7);
        boolean r115 = r113.getBoolean(0, true);
        r113.recycle();
        this.f240045t = LayoutInflater.from(r110);
        if (this.f240036k == false) goto L5;
        this.f240037l = getStatusBarHeight();
    L6:
        this.f240038m = np5.b.a(Float.valueOf(10).floatValue());
        this.f240039n = r110.getResources().getDimensionPixelSize(R.dimen.widget_widgets_title_height);
        setTag("BaseTitleBar");
        setOrientation(0);
        setGravity(16);
        setBackgroundColor(r102);
        LinearLayout r108 = (LinearLayout) this.f240045t.inflate(R.layout.widget_title_bar_left, this, false);
        r108.setOnClickListener(new i(this));
        this.f240042q = (ImageView) r108.findViewById(R.id.title_bar_back);
        this.f240028c = (TextView) r108.findViewById(R.id.title_bar_left_title);
        setLeftText(r114);
        this.f240030e = (ViewGroup) r108.findViewById(R.id.title_bar_left_actions);
        this.f240029d = r108;
        this.f240032g = new RelativeLayout(r110);
        this.f240031f = new LinearLayout(r110);
        this.f240035j = new View(r110);
        TextView r109 = new TextView(r110);
        this.f240033h = r109;
        r109.setId(R.id.title_bar_center_text);
        this.f240034i = new TextView(r110);
        RelativeLayout.LayoutParams r116 = new RelativeLayout.LayoutParams(-2, -2);
        r116.addRule(13, -1);
        this.f240032g.setGravity(16);
        this.f240032g.addView(this.f240033h, r116);
        RelativeLayout.LayoutParams r117 = new RelativeLayout.LayoutParams(-2, -2);
        r117.addRule(3, this.f240033h.getId());
        r117.addRule(14);
        this.f240032g.addView(this.f240034i, r117);
        setDefaultTextStyle(this.f240033h);
        setDefaultTextStyle(this.f240034i);
        this.f240033h.setTextSize(18.0f);
        this.f240033h.setTextColor(r103);
        this.f240033h.setGravity(17);
        this.f240033h.getPaint().setFakeBoldText(r115);
        this.f240034i.setTextSize(12.0f);
        this.f240034i.setTextColor(r103);
        this.f240034i.setGravity(17);
        this.f240034i.getPaint().setFakeBoldText(r115);
        this.f240031f.setGravity(17);
        this.f240035j.setBackgroundColor(r110.getResources().getColor(R.color.line_divider_default));
        addView(this.f240029d, -2, -1);
        addView(this.f240032g, -2, -1);
        addView(this.f240031f, -2, -1);
        addView(this.f240035j, new LinearLayout.LayoutParams(-1, (int) r107));
        setTitle(r101);
        np5.a.a(this.f240042q, r104, r105);
        setDividerVisible(r106);
        return;
    L5:
        this.f240037l = 0;
        goto L6
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        LinearLayout r105 = this.f240029d;
        r105.layout(0, this.f240037l, r105.getMeasuredWidth(), this.f240029d.getMeasuredHeight() + this.f240037l);
        this.f240031f.layout(getWidth() - this.f240031f.getMeasuredWidth(), this.f240037l, getWidth(), this.f240031f.getMeasuredHeight() + this.f240037l);
        int r106 = this.f240029d.getMeasuredWidth();
        int r107 = this.f240031f.getMeasuredWidth();
        LinearLayout.LayoutParams r108 = (LinearLayout.LayoutParams) this.f240032g.getLayoutParams();
        if (r108 == null) goto L5;
        int r109 = ((ViewGroup.MarginLayoutParams) r108).leftMargin;
        int r110 = ((ViewGroup.MarginLayoutParams) r108).rightMargin;
    L7:
        if (this.f240040o == false) goto L11;
        if (r106 <= r107) goto L10;
        this.f240032g.layout(r109 + r106, this.f240037l, (getWidth() - r106) - r110, getMeasuredHeight());
    L12:
        KeyEvent.Callback r111 = getCustomTitleView();
        if ((r111 instanceof v) == true) goto L16;
    L23:
        this.f240035j.layout(0, getMeasuredHeight() - this.f240035j.getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight());
        return;
    L16:
        if (this.f240040o == true) goto L18;
        ((v) r111).a(0);
        goto L23
    L18:
        ViewGroup.LayoutParams r112 = getLayoutParams();
        if ((r112 instanceof ViewGroup.MarginLayoutParams) == false) goto L21;
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r112;
        int r114 = r113.leftMargin;
        int r115 = r113.rightMargin;
    L22:
        v r116 = (v) r111;
        r116.a((r115 - r114) / 2);
        goto L23
    L21:
        r115 = 0;
        r114 = 0;
        goto L22
    L10:
        this.f240032g.layout(r109 + r107, this.f240037l, (getWidth() - r107) - r110, getMeasuredHeight());
        goto L12
    L11:
        this.f240032g.layout(e(this.f240029d) + r109, this.f240037l, (getWidth() - e(this.f240031f)) - r110, getMeasuredHeight());
        goto L12
    L5:
        r110 = 0;
        r109 = 0;
        goto L7
    }
}
