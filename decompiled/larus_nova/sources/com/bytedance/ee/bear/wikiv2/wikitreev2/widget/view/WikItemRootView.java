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
import com.larus.nova.R;
import com.oubowu.stickyitemdecoration.StickyHeadContainer;
import java.util.Locale;

/* JADX INFO: loaded from: classes18.dex */
public class WikItemRootView extends WikItemDirView {
    public static final /* synthetic */ int C = 0;
    public boolean A;
    public WikiItemViewContainer B;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Drawable f242244x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public AppCompatImageView f242245y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View.OnClickListener f242246z;

    public class a extends com.bytedance.ee.bear.widgets.t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WikItemRootView f242247c;

        public a(WikItemRootView r100) {
            this.f242247c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            View.OnClickListener r101 = this.f242247c.f242246z;
            if (r101 == null) goto L6;
            r101.onClick(r100);
            return;
        }
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public float getItemHeightInDp() {
        return 44.0f;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public int getLayout() {
        return R.layout.wiki_tree_root_item_v2;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemDirView, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public void e() {
        super.e();
        this.B = (WikiItemViewContainer) findViewById(R.id.container);
        setLayoutParams(new ViewGroup.LayoutParams(-1, com.bytedance.ee.util.ui.n.c(getItemHeightInDp())));
        this.B.setOnClickListener(new l(this));
        this.f242244x = com.bytedance.ee.util.ui.n.k(getContext(), R.drawable.wiki_tree_divider);
        AppCompatImageView r100 = (AppCompatImageView) findViewById(R.id.add);
        this.f242245y = r100;
        r100.setOnClickListener(new a(this));
        boolean r101 = TextUtils.equals(((com.bytedance.ee.bear.contract.i0) org.koin.java.a.a(com.bytedance.ee.bear.contract.i0.class)).a(), Locale.ENGLISH.getLanguage());
        FrameLayout.LayoutParams r102 = (FrameLayout.LayoutParams) this.f242225d.getLayoutParams();
        r102.topMargin = y9c.d.a(r101 ? 1 : 0);
        this.f242225d.setLayoutParams(r102);
        FrameLayout.LayoutParams r103 = (FrameLayout.LayoutParams) this.f242224c.getLayoutParams();
        r103.topMargin = y9c.d.a(r101 ? 1 : 0);
        this.f242225d.setLayoutParams(r103);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemDirView, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public final void f() {
        super.f();
        this.A = false;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public int getTitleColor() {
        return getResources().getColor(R.color.text_caption);
    }

    public WikItemRootView(Context r100) {
        super(r100);
        this.A = false;
    }

    public void k(int r100) {
        if (r100 < 1) goto L5;
        setLayoutParams(new ViewGroup.LayoutParams(-1, com.bytedance.ee.util.ui.n.d(12) + com.bytedance.ee.util.ui.n.c(getItemHeightInDp())));
        setPadding(0, com.bytedance.ee.util.ui.n.d(12), 0, 0);
        return;
    L5:
        if (r100 != 0) goto L9;
        setLayoutParams(new ViewGroup.LayoutParams(-1, com.bytedance.ee.util.ui.n.c(getItemHeightInDp())));
        setPadding(0, 0, 0, 0);
        return;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        if (this.f242239r == false) goto L5;
        return;
    L5:
        if (this.f242217u == true) goto L9;
        r100.save();
        this.f242244x.setBounds(getLeft(), getBottom() - this.f242244x.getIntrinsicHeight(), getRight(), getBottom());
        r100.restore();
        this.f242244x.draw(r100);
        return;
    }

    public void setCreateButtonVisible(boolean r100) {
        this.A = r100;
        if (qc5.a.f() == false) goto L10;
        AppCompatImageView r101 = this.f242245y;
        if (r100 == false) goto L7;
        int r102 = 0;
    L8:
        r101.setVisibility(r102);
        return;
    L7:
        r102 = 8;
        goto L8
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemDirView
    public void setExpand(boolean r100) {
        this.f242217u = r100;
        if (r100 == false) goto L5;
        int r101 = R.drawable.ud_icon_down_bold_outlined;
    L6:
        this.f242225d.setImageResource(kac.a.b(r101));
        com.bytedance.ee.util.ui.l.c(this.f242225d, R.color.icon_n2);
        return;
    L5:
        r101 = R.drawable.ud_icon_right_bold_outlined;
        goto L6
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemDirView, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public void setFocus(boolean r100) {
        super.setFocus(r100);
        if ((getParent() instanceof StickyHeadContainer) == false) goto L21;
        int r101 = 0;
        if (r100 == false) goto L7;
        int r102 = R.drawable.wiki_item_select_bg;
    L8:
        setBackgroundResource(r102);
        if (this.f242246z != null) goto L11;
        return;
    L11:
        if (this.A == true) goto L13;
        return;
    L13:
        if (qc5.a.f() == false) goto L15;
        this.f242245y.setVisibility(0);
        return;
    L15:
        AppCompatImageView r103 = this.f242245y;
        if (r100 == true) goto L19;
        r101 = 8;
    L19:
        r103.setVisibility(r101);
        return;
    L7:
        r102 = 0;
        goto L8
    }

    public void setOnAddClickListener(View.OnClickListener r100) {
        this.f242246z = r100;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public void setScrollManager(com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.a r100) {
        super.setScrollManager(r100);
        WikiItemViewContainer r101 = this.B;
        if (r101 == null) goto L6;
        r101.setScrollManager(r100);
        return;
    }

    public WikItemRootView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.A = false;
    }

    public WikItemRootView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.A = false;
    }

    public WikItemRootView(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102, r103);
        this.A = false;
    }
}
