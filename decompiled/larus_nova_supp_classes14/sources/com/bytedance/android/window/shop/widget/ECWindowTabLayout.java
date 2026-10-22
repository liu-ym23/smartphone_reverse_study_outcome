package com.bytedance.android.window.shop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.res.ResourcesCompat;
import com.bytedance.android.ui.base.widget.tablayout.ECTabLayout;
import com.bytedance.android.window.shop.repository.tab.entity.WindowProductCategoryVODeprecated;
import com.bytedance.android.window.shop.repository.tab.entity.i0;
import com.bytedance.android.window.shop.widget.category.TextCategoryView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0010B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/window/shop/widget/ECWindowTabLayout;", "Lcom/bytedance/android/ui/base/widget/tablayout/ECTabLayout;", "tabLayout", "", "setTabWidth", "", "getScreenWidth", "color", "setSelectedTabIndicatorColor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowTabLayout extends ECTabLayout {
    public final List<ClickSeparatedTabSelectListener> a;
    public final Map<com.bytedance.android.window.shop.c, ECTabLayout.Tab> b;
    public final c c;
    public final b d;

    public static final class a {
    }

    public static final class b extends ClickSeparatedTabSelectListener {
        public final /* synthetic */ ECWindowTabLayout b;

        public b(ECWindowTabLayout r1) {
            this.b = r1;
        }

        @Override // com.bytedance.android.window.shop.widget.ClickSeparatedTabSelectListener
        public final void b(ECTabLayout.Tab r5, ClickSeparatedTabSelectListener.ActionType r6) {
            Intrinsics.checkNotNullParameter(r6, "actionType");
            ArrayList r0 = (ArrayList) this.b.a;
            Integer r1 = Integer.valueOf(r0.indexOf(this));
            if (r1.intValue() < 0) goto L5;
            boolean r2 = true;
        L6:
            if (r2 == true) goto L9;
            r1 = null;
        L9:
            if (r1 == null) goto L13;
            int r3 = r1.intValue() + 1;
            int r4 = r0.size();
        L11:
            if (r3 >= r4) goto L15;
            ((ClickSeparatedTabSelectListener) ListProtector.get(r0, r3)).a(r5, r6);
            r3 = r3 + 1;
            goto L11
        L15:
            return;
        L13:
            return;
        L5:
            r2 = false;
            goto L6
        }
    }

    public static final class c extends ClickSeparatedTabSelectListener {
        public final /* synthetic */ ECWindowTabLayout b;

        public c(ECWindowTabLayout r1) {
            this.b = r1;
        }

        @Override // com.bytedance.android.window.shop.widget.ClickSeparatedTabSelectListener
        public final void b(ECTabLayout.Tab r3, ClickSeparatedTabSelectListener.ActionType r4) {
            Intrinsics.checkNotNullParameter(r4, "actionType");
            Iterator r0 = ((ArrayList) this.b.a).iterator();
            if (r0.hasNext() == false) goto L6;
            ((ClickSeparatedTabSelectListener) r0.next()).b(r3, r4);
            return;
        }
    }

    static {
    }

    public ECWindowTabLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECWindowTabLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final int getScreenWidth() {
        Resources r0 = getResources();
        return WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).widthPixels;
    }

    private final void setTabWidth(ECTabLayout r9) {
        int r0 = r9.getTabCount();
        if (r0 > 0) goto L5;
        return;
    L5:
        int r2 = getScreenWidth() - (th.a.f(r9.getContext()).getDimensionPixelSize(2131166475) * 2);
        float r1 = com.bytedance.android.ec.core.utils.q.a(8);
        int r4 = 0;
    L6:
        if (r4 >= r0) goto L23;
        ECTabLayout.Tab r5 = r9.getTabAt(r4);
        View r6 = r9.getChildAt(0);
        if ((r6 instanceof LinearLayout) == true) goto L10;
        r6 = null;
    L10:
        LinearLayout r7 = (LinearLayout) r6;
        if (r7 == null) goto L20;
        ViewGroup.LayoutParams r8 = r7.getChildAt(r4).getLayoutParams();
        if (r8 == null) goto L22;
        LinearLayout.LayoutParams r10 = (LinearLayout.LayoutParams) r8;
        r10.width = (int) ((r2 / r0) - r1);
        if (r5 == null) goto L20;
        View r11 = r5.getCustomView();
        if (r11 == null) goto L20;
        r11.setLayoutParams(r10);
        goto L20
    L22:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L20:
        r4 = r4 + 1;
        goto L6
    }

    @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout
    public final void addOnTabSelectedListener(ECTabLayout.BaseOnTabSelectedListener<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if ((r2 instanceof ClickSeparatedTabSelectListener) == false) goto L5;
        this.a.add(r2);
        return;
    L5:
        super.addOnTabSelectedListener(r2);
    }

    public final void b(com.bytedance.android.window.shop.repository.tab.entity.x r13) {
        Iterator<T> r0 = r13.k.j.iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L28;
        Object r3 = r0.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        WindowProductCategoryVODeprecated.a r5 = (WindowProductCategoryVODeprecated.a) r3;
        ECTabLayout.Tab r6 = getTabAt(r2);
        if (r6 == null) goto L27;
        int r7 = r13.j;
        AppCompatTextView r8 = null;
        if ((r5 instanceof WindowProductCategoryVODeprecated.c) == false) goto L19;
        WindowProductCategoryVODeprecated.c r9 = (WindowProductCategoryVODeprecated.c) r5;
        AppCompatTextView r10 = new com.bytedance.android.window.shop.widget.category.b(r9, getContext(), null);
        int r11 = getHeight() - getPaddingTop();
        if (r10.getDp(Integer.valueOf(r9.e.getHeight())) <= r11) goto L16;
        if (r11 == 0) goto L16;
        ViewGroup.LayoutParams r12 = new ViewGroup.LayoutParams((r10.getDp(Integer.valueOf(r9.e.getWidth())) * r11) / r10.getDp(Integer.valueOf(r9.e.getHeight())), r11);
    L17:
        r10.setLayoutParams(r12);
    L21:
        r8 = r10;
    L22:
        if (r8 == null) goto L26;
        if (r2 != r7) goto L25;
        r8.u();
        goto L26
    L25:
        r8.w();
    L26:
        r6.setCustomView(r8);
    L16:
        r12 = new ViewGroup.LayoutParams(r10.getDp(Integer.valueOf(r9.e.getWidth())), r10.getDp(Integer.valueOf(r9.e.getHeight())));
        goto L17
    L19:
        if ((r5 instanceof WindowProductCategoryVODeprecated.d) == false) goto L22;
        r10 = new TextCategoryView((WindowProductCategoryVODeprecated.d) r5, getContext(), null, new TextCategoryView.a(16.0f, null));
        r10.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r10.setPadding(0, com.bytedance.android.shopping.extensions.b.b(2), 0, 0);
    L27:
        r2 = r4;
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v6, types: [android.widget.ImageView, com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView, com.bytedance.android.window.shop.widget.category.b] */
    public final void c(i0 r12) {
        Iterator<T> r0 = r12.k.j.iterator();
        int r2 = 0;
    L3:
        com.bytedance.android.window.shop.widget.category.c r4 = 0;
        if (r0.hasNext() == false) goto L32;
        Object r3 = r0.next();
        int r5 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        WindowProductCategoryVODeprecated.a r6 = (WindowProductCategoryVODeprecated.a) r3;
        ECTabLayout.Tab r7 = newTab();
        r7.setTag(r6.a);
        Unit r8 = Unit.INSTANCE;
        addTab(r7, r2);
        ECTabLayout.Tab r9 = getTabAt(r2);
        if (r9 == null) goto L31;
        int r10 = r12.j;
        if ((r6 instanceof WindowProductCategoryVODeprecated.c) == false) goto L21;
        WindowProductCategoryVODeprecated.c r11 = (WindowProductCategoryVODeprecated.c) r6;
        ?? r13 = new com.bytedance.android.window.shop.widget.category.b(r11, getContext(), null);
        int r14 = getHeight() - getPaddingTop();
        if (r13.getDp(Integer.valueOf(r11.e.getHeight())) > r14) goto L15;
    L18:
        ViewGroup.LayoutParams r15 = new ViewGroup.LayoutParams(r13.getDp(Integer.valueOf(r11.e.getWidth())), r13.getDp(Integer.valueOf(r11.e.getHeight())));
    L19:
        r13.setLayoutParams(r15);
        r4 = r13;
    L23:
        if (r4 == 0) goto L30;
        if (r2 != r10) goto L29;
        ECTabLayout.Tab r16 = getTabAt(r2);
        if (r16 == null) goto L28;
        r16.select();
    L28:
        r4.u();
        goto L30
    L29:
        r4.w();
    L30:
        r9.setCustomView(r4);
        goto L31
    L15:
        if (r13.getDp(Integer.valueOf(r11.e.getHeight())) <= 0) goto L18;
        if (r14 == 0) goto L18;
        r15 = new ViewGroup.LayoutParams((r13.getDp(Integer.valueOf(r11.e.getWidth())) * r14) / r13.getDp(Integer.valueOf(r11.e.getHeight())), r14);
        goto L19
    L21:
        if ((r6 instanceof WindowProductCategoryVODeprecated.d) == false) goto L23;
        com.bytedance.android.window.shop.widget.category.c r17 = new com.bytedance.android.window.shop.widget.category.c((WindowProductCategoryVODeprecated.d) r6, getContext());
        r17.setLayoutParams(new ViewGroup.LayoutParams(-2, com.bytedance.android.shopping.extensions.b.b(24)));
        r4 = r17;
    L31:
        r2 = r5;
        goto L3
    L32:
        int r18 = getTabCount();
        int r1 = 0;
        int r19 = 0;
    L33:
        if (r1 >= r18) goto L45;
        ECTabLayout.Tab r20 = getTabAt(r1);
        if (r20 == null) goto L37;
        View r21 = r20.getCustomView();
    L38:
        if (r21 == null) goto L40;
        r21.measure(0, 0);
    L40:
        if (r21 == null) goto L42;
        int r22 = r21.getMeasuredWidth();
    L43:
        r19 = r19 + r22;
        r1 = r1 + 1;
        goto L33
    L42:
        r22 = 0;
        goto L43
    L37:
        r21 = null;
        goto L38
    L45:
        if (r19 <= (getScreenWidth() - com.bytedance.android.shopping.extensions.b.b(14))) goto L47;
        setTabMode(0);
        return;
    L47:
        setTabMode(1);
        setTabWidth(this);
    }

    @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout
    public void setSelectedTabIndicatorColor(int r1) {
        super.setSelectedTabIndicatorColor(r1);
    }

    public static final /* synthetic */ void a(ECWindowTabLayout r0, c r1) {
        super.addOnTabSelectedListener(r1);
    }

    public ECWindowTabLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        post(new e(this));
        setSelectedTabIndicator(2131248174);
        setTabRippleColor(null);
        addOnTabSelectedListener(new d());
        this.a = new ArrayList();
        this.b = new LinkedHashMap();
        ResourcesCompat.getColor(getResources(), 2131101823, null);
        this.c = new c(this);
        this.d = new b(this);
    }

    @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout
    public final void addTab(ECTabLayout.Tab r2, int r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "tab");
        super.addTab(r2, r3, r4);
        c r5 = this.c;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r2, "tab");
        ECTabLayout.TabView r6 = r2.view;
        if (r6 == null) goto L7;
        r6.setOnClickListener(new com.bytedance.android.window.shop.widget.a(r5, r2));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    }

    public /* synthetic */ ECWindowTabLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
