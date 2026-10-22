package com.bytedance.android.shopping.store.tabkit.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.ec.store.utils.h;
import com.bytedance.android.shopping.extensions.b;
import com.bytedance.android.shopping.extensions.f;
import com.bytedance.android.shopping.store.tabkit.TabKitFragment;
import com.bytedance.android.shopping.store.tabkit.TabKitViewModel;
import com.bytedance.android.shopping.store.tabkit.e;
import com.bytedance.android.shopping.store.tabkit.model.k;
import com.bytedance.android.shopping.store.tabkit.model.l;
import com.bytedance.android.shopping.store.tabkit.model.w;
import com.bytedance.android.shopping.store.tabkit.model.x;
import com.bytedance.android.shopping.store.utils.ECImageHelper;
import com.bytedance.android.shopping.store.utils.o;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rk3.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010&\u001a\u00020%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u0012\b\b\u0002\u0010)\u001a\u00020\u0003¢\u0006\u0004\b*\u0010+J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005R\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\rR\u0017\u0010\u001d\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\"\u0010$\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006,"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/view/ABSTabItemView;", "Lcom/bytedance/android/shopping/store/tabkit/view/BaseTabItemView;", "Lrk3/c;", "", "getResourceId", "", "isClick", "", "setUpBadge", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "d", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "getIconView", "()Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "iconView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "getTitleTV", "()Landroid/widget/TextView;", "titleTV", "g", "getBubbleView", "bubbleView", "Landroid/view/View;", "h", "Landroid/view/View;", "getContainer", "()Landroid/view/View;", "container", "i", "Z", "getEnableBadge", "()Z", "setEnableBadge", "(Z)V", "enableBadge", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ABSTabItemView extends BaseTabItemView implements c {
    public final ECDraweeView d;
    public final TextView e;
    public final RedDotView f;
    public final ECDraweeView g;
    public final View h;
    public boolean i;

    public ABSTabItemView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ABSTabItemView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public void d() {
    }

    public int getResourceId() {
        return 2131560981;
    }

    public final boolean c() {
        if (this.f.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return true;
    L8:
        if (this.g.getVisibility() != 0) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        r1 = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    @Override // rk3.c
    public TabKitFragment getTabkitFragment() {
        return c.a.a(this);
    }

    public TabKitViewModel getViewModel() {
        TabKitFragment r0 = getTabkitFragment();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d;
    }

    public final ECDraweeView getBubbleView() {
        return this.g;
    }

    public final View getContainer() {
        return this.h;
    }

    public final boolean getEnableBadge() {
        return this.i;
    }

    public final ECDraweeView getIconView() {
        return this.d;
    }

    public final TextView getTitleTV() {
        return this.e;
    }

    public final void setEnableBadge(boolean r1) {
        this.i = r1;
    }

    /* JADX WARN: Type inference failed for: r7v21, types: [android.view.View, com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView, java.lang.Object] */
    public final void setUpBadge(boolean r7) {
        if (this.i == false) goto L105;
        boolean r0 = true;
        if (r7 == true) goto L100;
        k r8 = getTab();
        int r1 = 0;
        ECUrlModel r2 = null;
        if (r8 == null) goto L21;
        Intrinsics.checkNotNullParameter(r8, "$this$needShowBadge");
        q r3 = q.a;
        r3.getBoolean(e.j(r8), false);
        x r4 = r8.o();
        if (r4 == null) goto L13;
        l r5 = r4.a();
        if (r5 == null) goto L13;
        Integer r6 = r5.getType();
    L14:
        if (r6 != null) goto L16;
    L18:
        boolean r9 = false;
    L19:
        if (r9 != true) goto L21;
        boolean r10 = true;
    L22:
        if (r10 == false) goto L106;
        x r11 = getTabStyleConfig();
        if (r11 == null) goto L28;
        l r12 = r11.a();
        if (r12 == null) goto L28;
        Integer r13 = r12.getType();
    L29:
        if (r13 != null) goto L32;
    L68:
        String r14 = "";
        if (r13 != null) goto L72;
    L74:
        if (r13 != null) goto L77;
    L86:
        if (r13 != null) goto L89;
        return;
    L89:
        if (r13.intValue() != 4) goto L111;
        this.f.setVisibility(0);
        RedDotView r15 = this.f;
        x r16 = getTabStyleConfig();
        if (r16 == null) goto L98;
        l r17 = r16.a();
        if (r17 == null) goto L98;
        String r18 = r17.c();
        if (r18 == null) goto L98;
        r14 = r18;
    L98:
        r15.setTextStyle(r14);
        return;
    L111:
        return;
    L77:
        if (r13.intValue() != 3) goto L86;
        this.f.setVisibility(0);
        RedDotView r19 = this.f;
        x r20 = getTabStyleConfig();
        if (r20 == null) goto L85;
        l r21 = r20.a();
        if (r21 == null) goto L85;
        Integer r22 = r21.b();
        if (r22 == null) goto L85;
        r1 = r22.intValue();
    L85:
        r19.setNumberStyle(r1);
        return;
    L72:
        if (r13.intValue() != 1) goto L74;
        this.f.setVisibility(0);
        AppCompatTextView r23 = this.f;
        r23.setText("");
        ViewGroup.LayoutParams r24 = r23.getLayoutParams();
        r24.height = b.b(6);
        r24.width = b.b(6);
        r23.setBackgroundResource(2131234847);
        r23.setPadding(0, 0, 0, 0);
        r23.requestLayout();
        return;
    L32:
        if (r13.intValue() != 2) goto L68;
        this.g.setVisibility(0);
        d();
        Lazy r25 = ECImageHelper.a;
        ?? r26 = this.g;
        x r27 = getTabStyleConfig();
        if (r27 == null) goto L38;
        l r28 = r27.a();
        if (r28 == null) goto L38;
        ECUrlModel r29 = r28.a();
    L39:
        Intrinsics.checkNotNullParameter(r26, "ecDraweeView");
        if (r29 != null) goto L42;
    L51:
        int r30 = h.a;
        if (hk3.e.a() != 0) goto L55;
        r0 = false;
    L55:
        if (r0 == false) goto L62;
        ECDraweeView r31 = this.g;
        x r32 = getTabStyleConfig();
        if (r32 == null) goto L61;
        l r33 = r32.a();
        if (r33 == null) goto L61;
        r2 = r33.a();
    L61:
        e.h(r31, r2);
        return;
    L62:
        h0 r34 = h0.a;
        ECDraweeView r35 = this.g;
        x r36 = getTabStyleConfig();
        if (r36 == null) goto L67;
        l r37 = r36.a();
        if (r37 == null) goto L67;
        r2 = r37.a();
    L67:
        e.g(r35, r2);
        return;
    L42:
        if (r29.getWidth() <= 0) goto L51;
        if (r29.getHeight() <= 0) goto L51;
        r26.setAdjustMode(0);
        int r38 = o.a(Integer.valueOf(r29.getWidth()));
        int r39 = o.a(Integer.valueOf(r29.getHeight()));
        Intrinsics.checkNotNullParameter(r26, "$this$setWidthHeight");
        ViewGroup.LayoutParams r40 = r26.getLayoutParams();
        if (r40 == null) goto L48;
        r40.height = r39;
    L48:
        if (r40 == null) goto L50;
        r40.width = r38;
    L50:
        r26.setLayoutParams(r40);
    L38:
        r29 = null;
    L28:
        r13 = null;
        goto L29
    L106:
        return;
    L16:
        if (r3.getBoolean(e.j(r8), false) == true) goto L18;
        r9 = true;
    L13:
        r6 = null;
    L21:
        r10 = false;
        goto L22
    L100:
        if (c() == false) goto L113;
        this.f.setVisibility(8);
        this.g.setVisibility(8);
        k r41 = getTab();
        if (r41 == null) goto L114;
        Intrinsics.checkNotNullParameter(r41, "$this$recordBadgeShow");
        q.a.c(e.j(r41), true);
        return;
    L114:
        return;
    L113:
        return;
    }

    @Override // com.bytedance.android.shopping.store.tabkit.view.BaseTabItemView
    public void a(boolean r6, boolean r7) {
        if (isSelected() == false) goto L5;
        f.e(this.e, 600);
    L6:
        w r8 = getTabStyle();
        com.bytedance.android.shopping.store.tabkit.model.o r0 = getTabBarStyle();
        ECDraweeView r1 = this.d;
        Intrinsics.checkNotNullParameter(r1, "iconView");
        Integer r2 = null;
        if (r8 == null) goto L11;
        Integer r3 = r8.c();
        if (r3 == null) goto L11;
    L14:
        Integer r4 = Integer.valueOf(b.b(r3));
    L16:
        int r5 = 0;
        if (r4 == null) goto L19;
        int r9 = r4.intValue();
    L20:
        if (r8 == null) goto L24;
        Integer r10 = r8.d();
        if (r10 == null) goto L24;
    L27:
        r2 = Integer.valueOf(b.b(r10));
    L28:
        if (r2 == null) goto L30;
        r5 = r2.intValue();
    L30:
        e.c(r9, r5, r1);
        setUpBadge(r7);
        return;
    L24:
        if (r0 == null) goto L28;
        r10 = r0.d();
        if (r10 == null) goto L28;
    L19:
        r9 = 0;
    L11:
        if (r0 == null) goto L15;
        r3 = r0.c();
        if (r3 != null) goto L14;
    L15:
        r4 = null;
        goto L16
    L5:
        f.e(this.e, 400);
        goto L6
    }

    public ABSTabItemView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.i = true;
        ShoppingAsyncInflater.e.getClass();
        this.h = ShoppingAsyncInflater.a.a(r2).aU(getResourceId(), this, true);
        this.e = (TextView) findViewById(2131388071);
        this.d = (ECDraweeView) findViewById(2131388068);
        this.g = (ECDraweeView) findViewById(2131388069);
        this.f = (RedDotView) findViewById(2131388070);
    }

    public /* synthetic */ ABSTabItemView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
