package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.oubowu.stickyitemdecoration.StickyHeadContainer;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class WikItemRootView extends WikItemDirView {
    public static final /* synthetic */ int C = 0;
    public boolean A;
    public WikiItemViewContainer B;
    public Drawable x;
    public AppCompatImageView y;
    public View.OnClickListener z;

    public class a extends com.bytedance.ee.bear.widgets.t {
        public final /* synthetic */ WikItemRootView c;

        public a(WikItemRootView r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r2) {
            View.OnClickListener r0 = this.c.z;
            if (r0 == null) goto L6;
            r0.onClick(r2);
            return;
        }
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public float getItemHeightInDp() {
        return 44.0f;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public int getLayout() {
        return 2131568276;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemDirView, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public void e() {
        super.e();
        this.B = (WikiItemViewContainer) findViewById(2131367728);
        setLayoutParams(new ViewGroup.LayoutParams(-1, com.bytedance.ee.util.ui.n.c(getItemHeightInDp())));
        this.B.setOnClickListener(new l(this));
        this.x = com.bytedance.ee.util.ui.n.k(getContext(), 2131256614);
        AppCompatImageView r0 = findViewById(2131362207);
        this.y = r0;
        r0.setOnClickListener(new a(this));
        boolean r1 = TextUtils.equals(((com.bytedance.ee.bear.contract.i0) org.koin.java.a.a(com.bytedance.ee.bear.contract.i0.class)).a(), Locale.ENGLISH.getLanguage());
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) this.d.getLayoutParams();
        r2.topMargin = y9c.d.a(r1 ? 1 : 0);
        this.d.setLayoutParams(r2);
        FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) this.c.getLayoutParams();
        r3.topMargin = y9c.d.a(r1 ? 1 : 0);
        this.d.setLayoutParams(r3);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemDirView, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public final void f() {
        super.f();
        this.A = false;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public int getTitleColor() {
        return getResources().getColor(2131106607);
    }

    public WikItemRootView(Context r1) {
        super(r1);
        this.A = false;
    }

    public void k(int r6) {
        if (r6 < 1) goto L5;
        setLayoutParams(new ViewGroup.LayoutParams(-1, com.bytedance.ee.util.ui.n.d(12) + com.bytedance.ee.util.ui.n.c(getItemHeightInDp())));
        setPadding(0, com.bytedance.ee.util.ui.n.d(12), 0, 0);
        return;
    L5:
        if (r6 != 0) goto L9;
        setLayoutParams(new ViewGroup.LayoutParams(-1, com.bytedance.ee.util.ui.n.c(getItemHeightInDp())));
        setPadding(0, 0, 0, 0);
        return;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r6) {
        super.onDraw(r6);
        if (this.r == false) goto L5;
        return;
    L5:
        if (this.u == true) goto L9;
        r6.save();
        this.x.setBounds(getLeft(), getBottom() - this.x.getIntrinsicHeight(), getRight(), getBottom());
        r6.restore();
        this.x.draw(r6);
        return;
    }

    public void setCreateButtonVisible(boolean r2) {
        this.A = r2;
        if (qc5.a.f() == false) goto L10;
        AppCompatImageView r0 = this.y;
        if (r2 == false) goto L7;
        int r3 = 0;
    L8:
        r0.setVisibility(r3);
        return;
    L7:
        r3 = 8;
        goto L8
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemDirView
    public void setExpand(boolean r2) {
        this.u = r2;
        if (r2 == false) goto L5;
        int r3 = 2131254256;
    L6:
        this.d.setImageResource(kac.a.b(r3));
        com.bytedance.ee.util.ui.l.c(this.d, 2131102419);
        return;
    L5:
        r3 = 2131255563;
        goto L6
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemDirView, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public void setFocus(boolean r3) {
        super.setFocus(r3);
        if ((getParent() instanceof StickyHeadContainer) == false) goto L21;
        int r0 = 0;
        if (r3 == false) goto L7;
        int r1 = 2131256610;
    L8:
        setBackgroundResource(r1);
        if (this.z != null) goto L11;
        return;
    L11:
        if (this.A == true) goto L13;
        return;
    L13:
        if (qc5.a.f() == false) goto L15;
        this.y.setVisibility(0);
        return;
    L15:
        AppCompatImageView r2 = this.y;
        if (r3 == true) goto L19;
        r0 = 8;
    L19:
        r2.setVisibility(r0);
        return;
    L7:
        r1 = 0;
        goto L8
    }

    public void setOnAddClickListener(View.OnClickListener r1) {
        this.z = r1;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public void setScrollManager(com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.a r2) {
        super.setScrollManager(r2);
        WikiItemViewContainer r0 = this.B;
        if (r0 == null) goto L6;
        r0.setScrollManager(r2);
        return;
    }

    public WikItemRootView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.A = false;
    }

    public WikItemRootView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.A = false;
    }

    public WikItemRootView(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        this.A = false;
    }
}
