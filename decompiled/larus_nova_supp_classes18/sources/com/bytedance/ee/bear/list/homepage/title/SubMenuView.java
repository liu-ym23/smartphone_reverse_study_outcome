package com.bytedance.ee.bear.list.homepage.title;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import bd5.j;
import bd5.k;
import bd5.m;
import com.bytedance.ee.util.ui.l;
import wc5.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SubMenuView extends RelativeLayout implements f {
    public TextView a;
    public AppCompatImageView b;
    public AppCompatImageView c;
    public AppCompatImageView d;
    public f.a e;
    public FilterState f;
    public boolean g;
    public boolean h;

    public static final enum FilterState extends Enum<FilterState> {
        public static final FilterState CHECKED = null;
        public static final FilterState DEFAULT = null;
        public static final /* synthetic */ FilterState[] a = null;

        static {
            FilterState r0 = new FilterState("CHECKED", 0);
            CHECKED = r0;
            FilterState r1 = new FilterState("DEFAULT", 1);
            DEFAULT = r1;
            a = new FilterState[]{r0, r1};
        }

        public static FilterState[] values() {
            return (FilterState[]) a.clone();
        }

        public static FilterState valueOf(String r1) {
            return (FilterState) r27.a.a(FilterState.class, r1);
        }

        public FilterState(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Override // wc5.f
    public void setTitle(String r1) {
    }

    public final void c() {
        AppCompatImageView r0 = this.b;
        if (r0 == null) goto L6;
        r0.setVisibility(8);
        return;
    }

    public View getSortView() {
        return this.a;
    }

    public SubMenuView(Context r2) {
        this(r2, null);
    }

    @Override // wc5.f
    public final void a(String r2) {
        this.a.setText(r2);
    }

    @Override // wc5.f
    public final void b(boolean r3) {
        this.g = r3;
        l.c(this.c, 2131102419);
        AppCompatImageView r0 = this.c;
        Resources r1 = getResources();
        if (r3 == false) goto L5;
        int r4 = 2131254229;
    L6:
        r0.setImageDrawable(r1.getDrawable(r4));
        return;
    L5:
        r4 = 2131253870;
        goto L6
    }

    @Override // wc5.f
    public void setFilterState(FilterState r4) {
        this.f = r4;
        this.b.setImageResource(2131254759);
        int r1 = 2131102416;
        if (r4 == FilterState.CHECKED) goto L5;
        this.b.setBackgroundDrawable(null);
        if (this.h == true) goto L17;
        r1 = 2131102419;
    L17:
        l.c(this.b, r1);
        return;
    L5:
        if (this.h == true) goto L8;
        r1 = 2131106273;
    L8:
        this.b.setBackgroundDrawable(getResources().getDrawable(2131243705));
        if (this.h == false) goto L11;
        int r5 = 2131106270;
    L12:
        l.b(this.b, r5);
        goto L17
    L11:
        r5 = 2131106271;
        goto L12
    }

    @Override // wc5.f
    public void setOffline(boolean r1) {
        this.h = r1;
        setFilterState(this.f);
    }

    @Override // wc5.f
    public void setViewDelegate(f.a r1) {
        this.e = r1;
    }

    public SubMenuView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public SubMenuView(Context r7, AttributeSet r8, int r9) {
        super(r7, r8, r9);
        this.f = FilterState.DEFAULT;
        AppCompatImageView r10 = new AppCompatImageView(r7);
        this.c = r10;
        r10.setId(2131376276);
        this.c.setImageDrawable(r7.getResources().getDrawable(2131253870));
        l.c(this.c, 2131102419);
        int r11 = r7.getResources().getDimensionPixelSize(2131168329);
        RelativeLayout.LayoutParams r2 = new RelativeLayout.LayoutParams(r11, r11);
        r2.rightMargin = r7.getResources().getDimensionPixelSize(2131168321);
        r2.addRule(21);
        r2.addRule(15);
        addView(this.c, r2);
        int r3 = r7.getResources().getDimensionPixelSize(2131168326);
        this.c.setPadding(r3, r3, r3, r3);
        this.c.setOnClickListener(new m(this));
        AppCompatImageView r4 = new AppCompatImageView(r7);
        this.b = r4;
        r4.setId(2131376241);
        this.b.setImageResource(2131254759);
        l.c(this.b, 2131102419);
        int r1 = r7.getResources().getDimensionPixelSize(2131168329);
        RelativeLayout.LayoutParams r5 = new RelativeLayout.LayoutParams(r1, r1);
        r5.addRule(15);
        r5.addRule(16, 2131376276);
        r5.rightMargin = r7.getResources().getDimensionPixelSize(2131168327);
        addView(this.b, r5);
        int r12 = r7.getResources().getDimensionPixelSize(2131168326);
        this.b.setPadding(r12, r12, r12, r12);
        this.b.setOnClickListener(new bd5.l(this));
        TextView r13 = new TextView(r7);
        this.a = r13;
        r13.setId(2131391489);
        this.a.setMaxLines(1);
        this.a.setMaxEms(16);
        this.a.setEllipsize(TextUtils.TruncateAt.END);
        this.a.setTextColor(r7.getResources().getColor(2131106607));
        this.a.setTextSize(2, 14.0f);
        l.b(this.a, 2131106607);
        RelativeLayout.LayoutParams r14 = new RelativeLayout.LayoutParams(-2, -2);
        r14.leftMargin = r7.getResources().getDimensionPixelSize(2131168315);
        r14.topMargin = r7.getResources().getDimensionPixelSize(2131168302);
        r14.bottomMargin = r7.getResources().getDimensionPixelSize(2131168302);
        r14.addRule(9);
        addView(this.a, r14);
        this.a.setGravity(48);
        this.a.setOnClickListener(new j(this));
        AppCompatImageView r15 = new AppCompatImageView(r7);
        this.d = r15;
        r15.setImageResource(2131254261);
        l.c(this.d, 2131102419);
        this.d.setOnClickListener(new k(this));
        RelativeLayout.LayoutParams r16 = new RelativeLayout.LayoutParams(-2, -2);
        r16.width = r7.getResources().getDimensionPixelSize(2131168304);
        r16.height = r7.getResources().getDimensionPixelSize(2131168304);
        r16.topMargin = r7.getResources().getDimensionPixelSize(2131168315);
        r16.leftMargin = r7.getResources().getDimensionPixelSize(2131168340);
        r16.rightMargin = r7.getResources().getDimensionPixelSize(2131168315);
        r16.addRule(1, 2131391489);
        addView(this.d, r16);
    }
}
