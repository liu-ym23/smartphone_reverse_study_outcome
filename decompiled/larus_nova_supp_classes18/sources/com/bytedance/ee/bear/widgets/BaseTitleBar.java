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
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.badge.UDBadgeView;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class BaseTitleBar extends LinearLayout {
    public static final /* synthetic */ int w = 0;
    public View.OnClickListener a;
    public final List<a> b;
    public TextView c;
    public LinearLayout d;
    public ViewGroup e;
    public LinearLayout f;
    public RelativeLayout g;
    public TextView h;
    public TextView i;
    public View j;
    public boolean k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public boolean p;
    public ImageView q;
    public final int r;
    public boolean s;
    public LayoutInflater t;
    public int u;
    public boolean v;

    public static class CreateActionViewException extends Exception {
        public CreateActionViewException(String r1, k r2) {
            super(r1);
        }
    }

    public interface a {
        String getId();

        void performAction(View r1);
    }

    public static class b implements a {
        public String a;
        public BadgeStyle b;
        public int c;
        public boolean d;
        public Boolean e;

        @Override // com.bytedance.ee.bear.widgets.BaseTitleBar.a
        public void performAction(View r1) {
        }

        @Override // com.bytedance.ee.bear.widgets.BaseTitleBar.a
        public String getId() {
            if (TextUtils.isEmpty(this.a) == false) goto L6;
            this.a = String.format(Locale.US, "Action#%d", new Object[]{Integer.valueOf(View.generateViewId())});
        L6:
            return this.a;
        }

        public b() {
            this.d = true;
        }
    }

    public static class c extends b {
        public final int f;
        public final Drawable g;
        public final CharSequence h;
        public final ColorStateList i;
        public boolean j;

        public c(int r2) {
            this.i = null;
            this.j = false;
            this.f = r2;
        }

        public c(Drawable r2) {
            this.i = null;
            this.j = false;
            this.g = r2;
        }

        public c(Drawable r2, ColorStateList r3) {
            this.i = null;
            this.j = false;
            this.g = r2;
            this.i = r3;
        }

        public c(Drawable r2, CharSequence r3) {
            this.i = null;
            this.j = false;
            this.g = r2;
            this.h = r3;
        }
    }

    public static class d extends c {
        public final int k;

        public d(Drawable r1, int r2, CharSequence r3) {
            super(r1, r3);
            this.k = r2;
        }
    }

    public static class e extends b {
        public final CharSequence f;
        public final int g;
        public final int h;
        public final ColorStateList i;

        public e(CharSequence r2) {
            this.g = -1;
            this.h = 17;
            this.i = null;
            this.f = r2;
        }

        public e(CharSequence r2, int r3) {
            this.g = -1;
            this.h = 17;
            this.i = null;
            this.f = r2;
            this.g = r3;
        }

        public e(CharSequence r2, ColorStateList r3) {
            this.g = -1;
            this.h = 17;
            this.i = null;
            this.f = r2;
            this.i = r3;
        }
    }

    public static class f extends b {
        public final View f;

        public f(View r1) {
            this.f = r1;
        }
    }

    public int getImageMenuLayout() {
        return 2131568221;
    }

    public final void f() {
        this.e.removeAllViews();
    }

    public final void g() {
        this.f.removeAllViews();
        ((ArrayList) this.b).clear();
    }

    public View getCustomTitleView() {
        if (this.g.getChildCount() != 0) goto L7;
        return null;
    L7:
        return this.g.getChildAt(0);
    }

    public Drawable getLeftDrawable() {
        return this.c.getCompoundDrawables()[0];
    }

    public ColorStateList getLeftIconTint() {
        return this.q.getImageTintList();
    }

    public boolean getLeftIconVisibility() {
        if (this.q.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int getLeftVisibleIconCount() {
        int r1 = 0;
        if (this.d.getVisibility() == 0) goto L6;
        return 0;
    L6:
        if (this.e.getVisibility() != 0) goto L8;
        boolean r0 = true;
    L9:
        int r3 = this.e.getChildCount();
        if (r0 == false) goto L20;
        if (r3 <= 0) goto L20;
        int r2 = 0;
        int r4 = 0;
    L13:
        if (r2 >= r3) goto L22;
        View r5 = this.e.getChildAt(r2);
        if (r5 == null) goto L19;
        if (r5.getVisibility() != 0) goto L19;
        r4 = r4 + 1;
    L19:
        r2 = r2 + 1;
    L22:
        if (this.q.getVisibility() != 0) goto L25;
        r1 = 1;
    L25:
        return r4 + r1;
    L20:
        r4 = 0;
        goto L22
    L8:
        r0 = false;
        goto L9
    }

    public TextView getRightText() {
        if (((ArrayList) this.b).size() <= 0) goto L8;
        a r0 = (a) ListProtector.get(this.b, 0);
        if (r0 == null) goto L8;
        View r1 = d(r0.getId());
    L10:
        if ((r1 instanceof TextView) == true) goto L12;
        return null;
    L12:
        return (TextView) r1;
    L8:
        r1 = null;
        goto L10
    }

    public int getRightVisibleIconCount() {
        int r1 = 0;
        if (this.f.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        int r2 = this.f.getChildCount();
        if (r0 == false) goto L23;
        if (r2 <= 0) goto L24;
        int r3 = 0;
    L10:
        if (r1 >= r2) goto L18;
        View r4 = this.f.getChildAt(r1);
        if (r4 == null) goto L16;
        if (r4.getVisibility() != 0) goto L16;
        r3 = r3 + 1;
    L16:
        r1 = r1 + 1;
        goto L10
    L18:
        return r3;
    L24:
        return 0;
    L23:
        return 0;
    L5:
        r0 = false;
        goto L6
    }

    public static int getStatusBarHeight() {
        Resources r0 = Resources.getSystem();
        int r1 = r0.getIdentifier("status_bar_height", "dimen", "android");
        if (r1 > 0) goto L7;
        return 0;
    L7:
        return r0.getDimensionPixelSize(r1);
    }

    public void b() {
        int r0 = (int) getResources().getDimension(2131168456);
        int r1 = (int) getResources().getDimension(2131168455);
        int r2 = (int) getResources().getDimension(2131168454);
        int r3 = getLeftVisibleIconCount();
        int r4 = getRightVisibleIconCount();
        if (this.o == false) goto L9;
        if (r3 <= 0) goto L6;
        int r5 = r0;
    L7:
        if (r4 > 0) goto L21;
    L20:
        r0 = r2;
    L21:
        LinearLayout.LayoutParams r6 = (LinearLayout.LayoutParams) this.g.getLayoutParams();
        if (r6 == null) goto L24;
        ((ViewGroup.MarginLayoutParams) r6).rightMargin = r0;
        ((ViewGroup.MarginLayoutParams) r6).leftMargin = r5;
        ((ViewGroup.MarginLayoutParams) r6).topMargin = 0;
        ((ViewGroup.MarginLayoutParams) r6).bottomMargin = 0;
    L24:
        this.g.setLayoutParams(r6);
        return;
    L6:
        r5 = r2;
        goto L7
    L9:
        if (r3 != 0) goto L15;
        if (this.p == true) goto L16;
        r0 = r1;
    L17:
        if (r4 != 0) goto L19;
        r5 = r0;
        r0 = r1;
        goto L21
    L19:
        r5 = r0;
    L16:
        r0 = 0;
        goto L17
    L15:
        if (r3 != 1) goto L17;
        goto L16
    }

    public RelativeLayout getCenterLayout() {
        return this.g;
    }

    public View.OnClickListener getLeftExtraClickListener() {
        return this.a;
    }

    public ImageView getLeftImage() {
        return this.q;
    }

    public LinearLayout getLeftLayout() {
        return this.d;
    }

    public TextView getLeftText() {
        return this.c;
    }

    public LinearLayout getRightLayout() {
        return this.f;
    }

    public BaseTitleBar(Context r3) {
        this(r3, null, 0);
    }

    private void setDefaultTextStyle(TextView r3) {
        r3.setTextColor(getResources().getColor(2131106622));
        r3.setSingleLine();
        r3.setGravity(16);
        r3.setEllipsize(TextUtils.TruncateAt.END);
    }

    public final View d(String r11) {
        ViewGroup[] r1 = {this.e, this.f};
        int r2 = 0;
    L3:
        if (r2 >= 2) goto L13;
        ViewGroup r4 = r1[r2];
        int r5 = r4.getChildCount();
        int r6 = 0;
    L5:
        if (r6 >= r5) goto L12;
        View r7 = r4.getChildAt(r6);
        Object r8 = r7.getTag();
        if ((r8 instanceof a) == false) goto L11;
        if (((a) r8).getId().equals(r11) == false) goto L11;
        return r7;
    L11:
        r6 = r6 + 1;
        goto L5
    L12:
        r2 = r2 + 1;
        goto L3
    L13:
        return null;
    }

    public final int e(View r3) {
        int r0 = this.m;
        if (r3 != null) goto L5;
        return r0;
    L5:
        if (r3.getVisibility() != 8) goto L7;
        int r4 = this.m;
    L9:
        return r4;
    L7:
        r4 = r3.getMeasuredWidth();
        goto L9
    }

    public final void h(float r5) {
        this.f.setPadding(np5.b.a(0.0f), np5.b.a(0.0f), np5.b.a(r5), np5.b.a(0.0f));
    }

    public void j(int r6) {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r1 >= this.e.getChildCount()) goto L7;
        l((ImageView) this.e.getChildAt(r1).findViewById(2131393182), r6);
        r1 = r1 + 1;
    L7:
        if (r0 >= this.f.getChildCount()) goto L15;
        View r2 = this.f.getChildAt(r0);
        ImageView r3 = (ImageView) r2.findViewById(2131393182);
        if ((r2.getTag() instanceof c) == true) goto L11;
    L13:
        l(r3, r6);
    L14:
        r0 = r0 + 1;
        goto L7
    L11:
        if (((c) r2.getTag()).j == false) goto L13;
    }

    public void setActionIconTint(int r1) {
        this.u = r1;
        j(r1);
    }

    public void setCenterClickListener(View.OnClickListener r2) {
        this.g.setOnClickListener(r2);
    }

    public void setCenterViewVisible(int r2) {
        this.g.setVisibility(r2);
    }

    public void setCustomLeftView(View r4) {
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-2, -1);
        this.d.removeAllViews();
        this.d.addView(r4, r0);
    }

    public void setCustomRightView(View r4) {
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-2, -1);
        this.f.removeAllViews();
        this.f.setPadding(0, 0, 0, 0);
        this.f.addView(r4, r0);
    }

    public void setCustomTitleView(View r4) {
        this.g.removeAllViews();
        if (r4 == null) goto L6;
        RelativeLayout.LayoutParams r0 = new RelativeLayout.LayoutParams(-1, -2);
        r0.addRule(14, -1);
        this.g.addView(r4, r0);
        return;
    }

    public void setDivider(int r2) {
        this.j.setBackgroundResource(r2);
    }

    public void setDividerColor(int r2) {
        this.j.setBackgroundColor(r2);
    }

    public void setDividerHeight(int r2) {
        this.j.getLayoutParams().height = r2;
    }

    public void setDividerVisible(boolean r2) {
        View r0 = this.j;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public void setHeight(int r2) {
        this.n = r2;
        setMeasuredDimension(getMeasuredWidth(), this.n);
    }

    public void setImmersive(boolean r1) {
        this.k = r1;
        if (r1 == false) goto L5;
        this.l = getStatusBarHeight();
        return;
    L5:
        this.l = 0;
    }

    public void setIsCenterAlways(boolean r1) {
        this.o = r1;
        invalidate();
    }

    public void setLeftClickListener(final View.OnClickListener r3) {
        this.d.setOnClickListener(new h(this, r3));
    }

    public void setLeftExtraClickListener(View.OnClickListener r1) {
        this.a = r1;
    }

    public void setLeftIconVisibility(boolean r4) {
        ImageView r0 = this.q;
        if (r4 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        LinearLayout.LayoutParams r1 = (LinearLayout.LayoutParams) this.q.getLayoutParams();
        if (r4 == false) goto L9;
        int r5 = 0;
    L10:
        this.d.setPadding(r5, 0, 0, 0);
        return;
    L9:
        r5 = r1.getMarginStart();
        goto L10
    L5:
        r2 = 8;
        goto L6
    }

    public void setLeftImageResource(int r3) {
        np5.a.a(this.q, r3, this.r);
    }

    public void setLeftImageResourceWithoutTint(int r2) {
        this.q.setImageResource(r2);
        ImageViewCompat.setImageTintList(this.q, null);
    }

    public void setLeftImageTint(int r2) {
        l(this.q, r2);
    }

    public void setLeftText(CharSequence r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.c.setText(r2);
    }

    public void setLeftTextBackground(int r2) {
        this.c.setBackgroundResource(r2);
    }

    public void setLeftTextColor(int r2) {
        this.c.setTextColor(r2);
    }

    public void setLeftTextSize(float r2) {
        this.c.setTextSize(r2);
    }

    public void setLeftVisible(boolean r2) {
        LinearLayout r0 = this.d;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public void setMainTitleBackground(int r2) {
        this.h.setBackgroundResource(r2);
    }

    public void setMainTitleColor(int r2) {
        this.h.setTextColor(r2);
    }

    public void setMainTitleSize(float r2) {
        this.h.setTextSize(r2);
    }

    public void setMainTitleVisible(boolean r2) {
        TextView r0 = this.h;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public void setNeedReturnBack(boolean r1) {
        this.v = r1;
    }

    public void setRightVisible(boolean r2) {
        LinearLayout r0 = this.f;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public void setSkipCenterMarginWhenLeftAligned(boolean r1) {
        this.p = r1;
        b();
    }

    public void setSubTitle(CharSequence r3) {
        if (this.i.getVisibility() == 0) goto L5;
        this.i.setVisibility(0);
    L5:
        this.i.setText(r3);
    }

    public void setSubTitleBackground(int r2) {
        this.i.setBackgroundResource(r2);
    }

    public void setSubTitleColor(int r2) {
        this.i.setTextColor(r2);
    }

    public void setSubTitleSize(float r2) {
        this.i.setTextSize(r2);
    }

    public void setSubTitleVisible(boolean r2) {
        TextView r0 = this.i;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public void setSupportAutoRemoveBadgePoint(boolean r1) {
        this.s = r1;
    }

    public void setTitle(int r2) {
        setTitle(getResources().getString(r2));
    }

    public void setTitleMaxEms(int r2) {
        this.h.setMaxEms(r2);
    }

    public void setTitleRightViewBottom(View r4) {
        RelativeLayout.LayoutParams r0 = new RelativeLayout.LayoutParams(-2, -2);
        r0.addRule(1, this.h.getId());
        r0.addRule(8, this.h.getId());
        this.g.addView(r4, r0);
    }

    public void setLeftText(int r2) {
        this.c.setText(r2);
    }

    public void setLeftTextColor(ColorStateList r2) {
        this.c.setTextColor(r2);
    }

    public void setSubTitle(int r2) {
        setSubTitle(getResources().getString(r2));
    }

    public void setTitle(CharSequence r2) {
        i(r2, false);
    }

    public BaseTitleBar(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public final View a(b r3, boolean r4) {
        if (r3 != null) goto L5;
        return null;
    L5:
        View r1 = d(r3.getId());
        if (r1 == null) goto L19;
        return r1;
    L19:
        View r2 = c(r3, r4);     // Catch: CreateActionViewException -> L16
        if (r4 == false) goto L11;
        ((ArrayList) this.b).add(r3);     // Catch: CreateActionViewException -> L16
        this.f.addView(r2);     // Catch: CreateActionViewException -> L16
    L12:
        int r5 = this.u;     // Catch: CreateActionViewException -> L16
        if (r5 == 0) goto L15;
        j(r5);     // Catch: CreateActionViewException -> L16
    L15:
        return r2;
    L11:
        this.e.addView(r2);     // Catch: CreateActionViewException -> L16
    L16:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.d("BaseTitleBar", e);
        return null;
    }

    public final View c(b r14, boolean r15) throws CreateActionViewException {
        int r8 = 0;
        if ((r14 instanceof d) == false) goto L41;
        d r0 = (d) r14;
        LayoutInflater r11 = this.t;
        int r12 = getImageMenuLayout();
        if (r15 == false) goto L7;
        ViewGroup r16 = this.f;
    L8:
        View r17 = r11.inflate(r12, r16, false);
        r17.findViewById(2131393182).setVisibility(8);
        LottieAnimationView r7 = (LKUILottieAnimationView) r17.findViewById(2131393185);
        r7.setVisibility(0);
        r7.setAnimation(r0.k);
        TextView r6 = (TextView) r17.findViewById(2131393184);
        if (TextUtils.isEmpty(r0.h) == false) goto L11;
        r6.setVisibility(8);
    L12:
        View r5 = r17.findViewById(2131393181);
        UDBadgeView r4 = r17.findViewById(2131393179);
        int r9 = r0.c;
        BadgeStyle r1 = r0.b;
        if (r1 != null) goto L16;
        r5.setVisibility(8);
        r4.setVisibility(8);
    L103:
        if (r17 == null) goto L110;
        r17.setTag(r14);
        r17.setEnabled(r14.d);
        Boolean r2 = r14.e;
        if (r2 == null) goto L107;
        r17.setSelected(r2.booleanValue());
    L107:
        r17.setContentDescription(r14.getId());
        r17.setOnClickListener(new k(this, r14));
        return r17;
    L110:
        throw new CreateActionViewException("action:" + r14, null);
    L16:
        if (r1 != BadgeStyle.point) goto L22;
        r4.setVisibility(8);
        if (r9 > 0) goto L21;
        r8 = 8;
    L21:
        r5.setVisibility(r8);
        goto L103
    L22:
        BadgeStyle r10 = BadgeStyle.num;
        if (r1 != r10) goto L25;
    L33:
        r5.setVisibility(8);
        if (r9 <= 0) goto L39;
        if (r1 != r10) goto L37;
        r4.setBadgeColorRes(2131102080);
    L38:
        r4.setVisibility(0);
        r4.setText(String.valueOf(Math.min(r9, 999)));
        r4.a();
        goto L103
    L37:
        r4.setBadgeColorRes(2131102416);
        goto L38
    L39:
        r4.setVisibility(8);
        goto L103
    L25:
        if (r1 == BadgeStyle.mute) goto L33;
        if (r1 != BadgeStyle.text) goto L103;
        r5.setVisibility(8);
        if (TextUtils.isEmpty(null) == true) goto L32;
        r4.setBadgeColorRes(2131102080);
        r4.setVisibility(0);
        r4.setText(null);
        r4.a();
        goto L103
    L32:
        r4.setVisibility(8);
        goto L103
    L11:
        r6.setText(r0.h);
        r6.setVisibility(0);
        goto L12
    L7:
        r16 = this.e;
        goto L8
    L41:
        if ((r14 instanceof c) == false) goto L90;
        final c r3 = (c) r14;
        LayoutInflater r13 = this.t;
        int r18 = getImageMenuLayout();
        if (r15 == false) goto L45;
        ViewGroup r19 = this.f;
    L46:
        r17 = r13.inflate(r18, r19, false);
        final AppCompatImageView r20 = r17.findViewById(2131393182);
        Drawable r110 = r3.g;
        if (r110 == null) goto L49;
        r20.setImageDrawable(r110);
    L51:
        if (r3.i == null) goto L53;
        r20.post(new j(r20, r3));
    L53:
        TextView r21 = (TextView) r17.findViewById(2131393184);
        if (TextUtils.isEmpty(r3.h) == false) goto L56;
        r21.setVisibility(8);
    L61:
        View r22 = r17.findViewById(2131393181);
        UDBadgeView r23 = r17.findViewById(2131393179);
        int r24 = r3.c;
        BadgeStyle r25 = r3.b;
        if (r25 != null) goto L65;
        r22.setVisibility(8);
        r23.setVisibility(8);
        goto L103
    L65:
        if (r25 != BadgeStyle.point) goto L71;
        r23.setVisibility(8);
        if (r24 > 0) goto L70;
        r8 = 8;
    L70:
        r22.setVisibility(r8);
        goto L103
    L71:
        BadgeStyle r26 = BadgeStyle.num;
        if (r25 != r26) goto L74;
    L82:
        r22.setVisibility(8);
        if (r24 <= 0) goto L88;
        if (r25 != r26) goto L86;
        r23.setBadgeColorRes(2131102080);
    L87:
        r23.setVisibility(0);
        r23.setText(String.valueOf(Math.min(r24, 999)));
        r23.a();
        goto L103
    L86:
        r23.setBadgeColorRes(2131102416);
        goto L87
    L88:
        r23.setVisibility(8);
        goto L103
    L74:
        if (r25 == BadgeStyle.mute) goto L82;
        if (r25 != BadgeStyle.text) goto L103;
        r22.setVisibility(8);
        if (TextUtils.isEmpty(null) == true) goto L81;
        r23.setBadgeColorRes(2131102080);
        r23.setVisibility(0);
        r23.setText(null);
        r23.a();
        goto L103
    L81:
        r23.setVisibility(8);
        goto L103
    L56:
        r21.setText(r3.h);
        ColorStateList r27 = r3.i;
        if (r27 == null) goto L59;
        r21.setTextColor(r27);
    L60:
        r21.setVisibility(0);
        goto L61
    L59:
        r21.setTextColor(getResources().getColorStateList(2131101927));
        goto L60
    L49:
        r20.setImageResource(r3.f);
        goto L51
    L45:
        r19 = this.e;
        goto L46
    L90:
        if ((r14 instanceof e) == false) goto L100;
        e r111 = (e) r14;
        TextView r28 = new TextView(getContext());
        setDefaultTextStyle(r28);
        r28.setText(r111.f);
        r28.setTextSize(r111.h);
        ColorStateList r29 = r111.i;
        if (r29 == null) goto L95;
        r28.setTextColor(r29);
    L98:
        int r112 = (int) getResources().getDimension(2131169532);
        r28.setPadding(r112, 0, r112, 0);
        r17 = r28;
        goto L103
    L95:
        if (r111.g == (-1)) goto L97;
        r28.setTextColor(getResources().getColorStateList(r111.g));
        goto L98
    L97:
        r28.setTextColor(getResources().getColorStateList(2131109412));
        goto L98
    L100:
        if ((r14 instanceof f) == false) goto L102;
        r17 = ((f) r14).f;
        goto L103
    L102:
        r17 = null;
        goto L103
    }

    public final void i(CharSequence r5, boolean r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r6 == false) goto L6;
        this.g.removeAllViews();
        this.g.addView(this.h);
        this.g.addView(this.i);
    L6:
        int r7 = r5.toString().indexOf("\n");
        if (r7 <= 0) goto L9;
        CharSequence r1 = r5.subSequence(0, r7);
        CharSequence r8 = r5.subSequence(r7 + 1, r5.length());
        this.h.setText(r1);
        this.i.setText(r8);
        this.i.setVisibility(0);
        return;
    L9:
        int r9 = r5.toString().indexOf("\t");
        if (r9 <= 0) goto L12;
        CharSequence r2 = r5.subSequence(0, r9);
        String r10 = " " + r5.subSequence(r9 + 1, r5.length());
        this.h.setText(r2);
        this.i.setText(r10);
        this.i.setVisibility(0);
        return;
    L12:
        this.h.setText(r5);
        this.i.setVisibility(8);
    }

    public final boolean k(String r2, Drawable r3) {
        View r4 = d(r2);
        if (r3 == null) goto L9;
        if (r4 == null) goto L11;
        AppCompatImageView r5 = r4.findViewById(2131393182);
        if (r5 == null) goto L12;
        r5.setBackgroundDrawable(null);
        r5.setImageDrawable(null);
        r5.setImageDrawable(r3);
        return true;
    L12:
        return false;
    L11:
        return false;
    L9:
        return false;
    }

    public final void l(ImageView r2, int r3) {
        if (r2 == null) goto L8;
        if (r3 != 0) goto L5;
        ColorStateList r4 = null;
    L6:
        r2.setImageTintList(r4);
        return;
    L5:
        r4 = getResources().getColorStateList(r3);
        goto L6
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r9, int r10) {
        if (View.MeasureSpec.getMode(r10) == 1073741824) goto L5;
        int r11 = this.n;
        int r0 = this.l + r11;
        r10 = View.MeasureSpec.makeMeasureSpec(r11, 1073741824);
    L6:
        int r2 = View.MeasureSpec.getSize(r9);
        measureChild(this.d, r9, r10);
        measureChild(this.f, r9, r10);
        int r3 = this.d.getMeasuredWidth();
        int r4 = this.f.getMeasuredWidth();
        LinearLayout.LayoutParams r5 = (LinearLayout.LayoutParams) this.g.getLayoutParams();
        int r6 = 0;
        if (r5 == null) goto L10;
        r6 = 0 + (((ViewGroup.MarginLayoutParams) r5).leftMargin + ((ViewGroup.MarginLayoutParams) r5).rightMargin);
    L10:
        if (this.o == false) goto L14;
        if (r3 <= r4) goto L13;
        this.g.measure(View.MeasureSpec.makeMeasureSpec((r2 - (r3 * 2)) - r6, 1073741824), r10);
    L15:
        measureChild(this.j, r9, r10);
        setMeasuredDimension(r2, r0);
        return;
    L13:
        this.g.measure(View.MeasureSpec.makeMeasureSpec((r2 - (r4 * 2)) - r6, 1073741824), r10);
        goto L15
    L14:
        this.g.measure(View.MeasureSpec.makeMeasureSpec(((r2 - e(this.d)) - e(this.f)) - r6, 1073741824), r10);
        goto L15
    L5:
        r0 = View.MeasureSpec.getSize(r10) + this.l;
        goto L6
    }

    public BaseTitleBar(Context r12, AttributeSet r13, int r14) {
        super(r12, r13, r14);
        this.b = new ArrayList();
        this.o = true;
        this.p = false;
        this.u = 0;
        this.v = false;
        Resources r1 = r12.getResources();
        TypedArray r15 = r12.obtainStyledAttributes(r13, new int[]{2130975130, 2130975131, 2130975132, 2130975133, 2130975134, 2130975135, 2130975136, 2130975137, 2130975138, 2130975139});
        String r3 = r15.getString(8);
        int r4 = r15.getColor(4, r1.getColor(2131100548));
        int r2 = r15.getColor(9, r1.getColor(2131106622));
        int r5 = r15.getResourceId(2, 2131254998);
        int r7 = r15.getResourceId(3, 2131101927);
        this.r = r7;
        boolean r8 = r15.getBoolean(6, true);
        float r9 = r15.getDimension(5, np5.b.a(Float.valueOf(1).floatValue()));
        String r10 = r15.getString(7);
        boolean r16 = r15.getBoolean(0, true);
        r15.recycle();
        this.t = LayoutInflater.from(r12);
        if (this.k == false) goto L5;
        this.l = getStatusBarHeight();
    L6:
        this.m = np5.b.a(Float.valueOf(10).floatValue());
        this.n = r12.getResources().getDimensionPixelSize(2131169536);
        setTag("BaseTitleBar");
        setOrientation(0);
        setGravity(16);
        setBackgroundColor(r4);
        LinearLayout r0 = (LinearLayout) this.t.inflate(2131568227, this, false);
        r0.setOnClickListener(new i(this));
        this.q = (ImageView) r0.findViewById(2131388808);
        this.c = (TextView) r0.findViewById(2131388821);
        setLeftText(r10);
        this.e = (ViewGroup) r0.findViewById(2131388818);
        this.d = r0;
        this.g = new RelativeLayout(r12);
        this.f = new LinearLayout(r12);
        this.j = new View(r12);
        TextView r6 = new TextView(r12);
        this.h = r6;
        r6.setId(2131388809);
        this.i = new TextView(r12);
        RelativeLayout.LayoutParams r11 = new RelativeLayout.LayoutParams(-2, -2);
        r11.addRule(13, -1);
        this.g.setGravity(16);
        this.g.addView(this.h, r11);
        RelativeLayout.LayoutParams r17 = new RelativeLayout.LayoutParams(-2, -2);
        r17.addRule(3, this.h.getId());
        r17.addRule(14);
        this.g.addView(this.i, r17);
        setDefaultTextStyle(this.h);
        setDefaultTextStyle(this.i);
        this.h.setTextSize(18.0f);
        this.h.setTextColor(r2);
        this.h.setGravity(17);
        this.h.getPaint().setFakeBoldText(r16);
        this.i.setTextSize(12.0f);
        this.i.setTextColor(r2);
        this.i.setGravity(17);
        this.i.getPaint().setFakeBoldText(r16);
        this.f.setGravity(17);
        this.j.setBackgroundColor(r12.getResources().getColor(2131103353));
        addView(this.d, -2, -1);
        addView(this.g, -2, -1);
        addView(this.f, -2, -1);
        addView(this.j, new LinearLayout.LayoutParams(-1, (int) r9));
        setTitle(r3);
        np5.a.a(this.q, r5, r7);
        setDividerVisible(r8);
        return;
    L5:
        this.l = 0;
        goto L6
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        LinearLayout r8 = this.d;
        r8.layout(0, this.l, r8.getMeasuredWidth(), this.d.getMeasuredHeight() + this.l);
        this.f.layout(getWidth() - this.f.getMeasuredWidth(), this.l, getWidth(), this.f.getMeasuredHeight() + this.l);
        int r9 = this.d.getMeasuredWidth();
        int r10 = this.f.getMeasuredWidth();
        LinearLayout.LayoutParams r11 = (LinearLayout.LayoutParams) this.g.getLayoutParams();
        if (r11 == null) goto L5;
        int r12 = ((ViewGroup.MarginLayoutParams) r11).leftMargin;
        int r13 = ((ViewGroup.MarginLayoutParams) r11).rightMargin;
    L7:
        if (this.o == false) goto L11;
        if (r9 <= r10) goto L10;
        this.g.layout(r12 + r9, this.l, (getWidth() - r9) - r13, getMeasuredHeight());
    L12:
        KeyEvent.Callback r14 = getCustomTitleView();
        if ((r14 instanceof v) == true) goto L16;
    L23:
        this.j.layout(0, getMeasuredHeight() - this.j.getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight());
        return;
    L16:
        if (this.o == true) goto L18;
        ((v) r14).a(0);
        goto L23
    L18:
        ViewGroup.LayoutParams r15 = getLayoutParams();
        if ((r15 instanceof ViewGroup.MarginLayoutParams) == false) goto L21;
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
        int r17 = r16.leftMargin;
        int r18 = r16.rightMargin;
    L22:
        v r19 = (v) r14;
        r19.a((r18 - r17) / 2);
        goto L23
    L21:
        r18 = 0;
        r17 = 0;
        goto L22
    L10:
        this.g.layout(r12 + r10, this.l, (getWidth() - r10) - r13, getMeasuredHeight());
        goto L12
    L11:
        this.g.layout(e(this.d) + r12, this.l, (getWidth() - e(this.f)) - r13, getMeasuredHeight());
        goto L12
    L5:
        r13 = 0;
        r12 = 0;
        goto L7
    }
}
