package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.ScrollSwipeMenuLayout;
import com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.WikiScrollTextView;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class WikItemLeafView extends FrameLayout implements com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.d {
    public static final /* synthetic */ int s = 0;
    public LinearLayout a;
    public FrameLayout b;
    public BearLottieView c;
    public ImageView d;
    public LinearLayout e;
    public FrameLayout f;
    public ImageView g;
    public ImageView h;
    public TextView i;
    public WikiItemBackgroundView j;
    public com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout k;
    public ImageView l;
    public ImageView m;
    public e n;
    public com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.d.a o;
    public com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.d.b p;
    public com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.a q;
    public boolean r;

    public class a implements View.OnClickListener {
        public final /* synthetic */ WikItemLeafView a;

        public a(WikItemLeafView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            if (com.bytedance.ee.util.ui.h.a(400) == true) goto L5;
            return;
        L5:
            e r4 = this.a.n;
            if (r4 == null) goto L9;
            r4.a();
            return;
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ WikItemLeafView a;

        public b(WikItemLeafView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.d.a r0 = this.a.o;
            if (r0 == null) goto L6;
            r0.a(r3.getId(), r3);
            return;
        }
    }

    public class c implements View.OnClickListener {
        public final /* synthetic */ WikItemLeafView a;

        public c(WikItemLeafView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.d.a r0 = this.a.o;
            if (r0 == null) goto L6;
            r0.a(r3.getId(), r3);
            return;
        }
    }

    public class d implements com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout.d {
        public final /* synthetic */ WikItemLeafView a;

        public d(WikItemLeafView r1) {
            this.a = r1;
        }

        public final void a(com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout r1, boolean r2) {
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.d.b r3 = this.a.p;
            if (r3 == null) goto L6;
            r3.a(r2);
            return;
        }
    }

    public interface e {
        void a();
    }

    public void d() {
        setMenuClickEnable(false);
        setItemEnable(false);
        setItemClickListener(null);
    }

    public void f() {
        setFocus(false);
        setItemClickListener(null);
        setSwipeMenuClickListener(null);
        setUserSwipeMenuListener(null);
        setSwipeMenuEnable(false);
        setMenuClickEnable(true);
        setItemEnable(true);
        i(2131387821, true);
        i(2131387817, true);
    }

    public float getItemHeightInDp() {
        return 48.0f;
    }

    public int getPressedGravityType() {
        return 16;
    }

    public int getPressedInnerMarginStart() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.d
    public final void a() {
        this.k.b();
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.d
    public final void b() {
        this.k.e();
    }

    public int getLayout() {
        int r0 = com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.a.f;
        return 2131568273;
    }

    public int getPressedContainerHeight() {
        return this.a.getMeasuredHeight();
    }

    public int getPressedContainerWidth() {
        return this.a.getMeasuredWidth();
    }

    public String getTitle() {
        return this.i.getText().toString();
    }

    public final void j() {
        boolean r1 = true;
        if (this.l.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (this.m.getVisibility() == 0) goto L10;
        r1 = false;
    L10:
        if (r0 == false) goto L14;
        if (r1 == false) goto L14;
        this.l.setBackgroundResource(2131235320);
        this.m.setBackgroundResource(2131235321);
        return;
    L14:
        if (r0 == false) goto L17;
        if (r1 == true) goto L17;
        this.l.setBackgroundResource(2131235311);
        return;
    L17:
        if (r0 == true) goto L23;
        if (r1 == false) goto L24;
        this.m.setBackgroundResource(2131235311);
        return;
    L24:
        return;
    L23:
        return;
    L5:
        r0 = false;
        goto L7
    }

    public void e() {
        LayoutInflater.from(getContext()).inflate(getLayout(), this);
        this.b = (FrameLayout) findViewById(2131374270);
        this.a = (LinearLayout) findViewById(2131367728);
        this.c = findViewById(2131378977);
        this.d = (ImageView) findViewById(2131375226);
        this.e = (LinearLayout) findViewById(2131367794);
        this.f = (FrameLayout) findViewById(2131374739);
        ImageView r0 = (ImageView) findViewById(2131374718);
        this.g = r0;
        r0.setImageResource(kac.a.b(2131254431));
        this.h = (ImageView) findViewById(2131386366);
        this.i = (TextView) findViewById(2131388772);
        this.j = (WikiItemBackgroundView) findViewById(2131363806);
        this.k = findViewById(2131387820);
        this.l = (ImageView) findViewById(2131387821);
        this.m = (ImageView) findViewById(2131387817);
        setFocus(false);
        this.d.setImageDrawable(null);
        this.c.setVisibility(8);
        this.k.setSwipeEnable(false);
        j();
        this.e.setOnClickListener(new a(this));
        this.l.setOnClickListener(new b(this));
        this.m.setOnClickListener(new c(this));
        this.k.setOnUserSwipeMenuListener(new d(this));
    }

    public int getTitleColor() {
        return getResources().getColor(2131106622);
    }

    public WikiItemBackgroundView getBackgroundView() {
        return this.j;
    }

    public ImageView getIndicatorView() {
        return this.d;
    }

    public ImageView getItemIcon() {
        return this.g;
    }

    public WikItemLeafView(Context r2) {
        this(r2, null);
    }

    public void c(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.b r2) {
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.c.a(r2, this, this.e);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        com.bytedance.ee.util.ui.m.a(new j(this));
    }

    public void setFocus(boolean r1) {
        this.r = r1;
    }

    public void setIcon(Triple<Integer, Integer, Integer> r6) {
        FrameLayout r0 = this.f;
        int r1 = 0;
        if (r6 == null) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        if (r6 == null) goto L19;
        Integer r2 = (Integer) r6.getFirst();
        Integer r4 = (Integer) r6.getSecond();
        Integer r7 = (Integer) r6.getThird();
        ImageView r5 = this.h;
        if (r4 != null) goto L11;
    L13:
        r1 = 8;
    L14:
        r5.setVisibility(r1);
        this.g.setImageResource(r2.intValue());
        if (r7.intValue() != 0) goto L17;
        this.g.setImageTintList(null);
        return;
    L17:
        com.bytedance.ee.util.ui.l.c(this.g, r7.intValue());
        return;
    L11:
        if (r4.intValue() == 0) goto L13;
    L19:
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public void setIconPadding(int r2) {
        this.f.setPadding(r2, r2, r2, r2);
    }

    public void setIconVisible(boolean r2) {
        FrameLayout r0 = this.f;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public void setItemClickListener(e r1) {
        this.n = r1;
    }

    public void setItemEnable(boolean r2) {
        if (r2 == false) goto L4;
        this.a.setAlpha(1.0f);
        return;
    L4:
        this.a.setAlpha(0.3f);
    }

    public void setMenuClickEnable(boolean r2) {
        h(2131387821, r2);
        h(2131387817, r2);
    }

    public void setScrollManager(com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.a r3) {
        this.q = r3;
        com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout r0 = this.k;
        if ((r0 instanceof ScrollSwipeMenuLayout) == false) goto L5;
        ((ScrollSwipeMenuLayout) r0).setScrollManager(r3);
    L5:
        setLayoutParams(new ViewGroup.LayoutParams(-2, com.bytedance.ee.util.ui.n.c(getItemHeightInDp())));
    }

    public void setSwipeMenuClickListener(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.d.a r1) {
        this.o = r1;
    }

    public void setSwipeMenuEnable(boolean r2) {
        this.k.setSwipeEnable(r2);
    }

    public void setTitle(String r3) {
        TextView r0 = this.i;
        boolean r1 = TextUtils.isEmpty(r3);
        CharSequence r4 = r3;
        if (r1 == false) goto L6;
        r4 = getResources().getText(2131888360);
    L6:
        r0.setText(r4);
    }

    public void setTitleStyle(Typeface r2) {
        int r0 = h18.e.a;
        Typeface r3 = h18.e.b(getContext(), r2.getStyle());
        this.i.setTypeface(r3);
    }

    public void setUserSwipeMenuListener(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.d.b r1) {
        this.p = r1;
    }

    public WikItemLeafView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public final void g(int r2, int r3) {
        if (r2 > 0) goto L5;
        return;
    L5:
        if (r3 > 8) goto L7;
        int r4 = (r2 - 1) * 12;
    L11:
        this.b.setPadding(com.bytedance.ee.util.ui.n.d(r4 + 0), 0, 0, 0);
        int r5 = com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.a.f;
        Object r6 = this.i;
        int r7 = this.b.getPaddingLeft();
        Intrinsics.checkNotNullParameter(r6, "title");
        if ((r6 instanceof WikiScrollTextView) == false) goto L15;
        WikiScrollTextView r8 = (WikiScrollTextView) r6;
        r8.getClass();
        r8.a = r7 + com.bytedance.ee.util.ui.n.d(44);
        return;
    L15:
        return;
    L7:
        int r9 = 12 - ((r3 - 8) * 3);
        if (r9 >= 6) goto L10;
        r9 = 6;
    L10:
        r4 = ((r2 - 1) * r9) + 12;
        goto L11
    }

    public final void h(int r7, boolean r8) {
        int r0 = getResources().getColor(2131106521);
        if (r7 != 2131387821) goto L8;
        if (r8 == false) goto L6;
        this.l.setImageTintList(ColorStateList.valueOf(r0));
        this.l.setAlpha(1.0f);
        this.l.setClickable(true);
        return;
    L6:
        this.l.setImageTintList(ColorStateList.valueOf(r0));
        this.l.setAlpha(0.5f);
        this.l.setClickable(false);
        return;
    L8:
        if (r7 != 2131387817) goto L15;
        if (r8 == false) goto L11;
        this.m.setImageTintList(ColorStateList.valueOf(r0));
        this.m.setAlpha(1.0f);
        this.m.setClickable(true);
        return;
    L11:
        this.m.setImageTintList(ColorStateList.valueOf(r0));
        this.m.setAlpha(0.5f);
        this.m.setClickable(false);
        return;
    }

    public void i(int r4, boolean r5) {
        if (r4 != 2131387821) goto L9;
        ImageView r6 = this.l;
        if (r5 == false) goto L7;
        r6.setVisibility(0);
    L14:
        j();
        return;
    L7:
        r6.setVisibility(8);
        goto L14
    L9:
        if (r4 != 2131387817) goto L14;
        ImageView r7 = this.m;
        if (r5 == false) goto L13;
        r7.setVisibility(0);
        goto L14
    L13:
        r7.setVisibility(8);
        goto L14
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r2, int r3) {
        super.onMeasure(r2, r3);
        int r4 = getMeasuredWidth();
        com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.a r5 = this.q;
        if (r5 == null) goto L8;
        int r6 = r5.a(getContext(), this);
        if (r4 >= r6) goto L9;
        setMeasuredDimension(r6, getMeasuredHeight());
        return;
    L9:
        return;
    }

    public WikItemLeafView(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public WikItemLeafView(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        this.r = false;
        e();
    }
}
