package com.bytedance.android.window.shop.widget.childcategory;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.core.widget.f;
import com.bytedance.android.window.shop.repository.tab.entity.WindowChildCategoryVO;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0004\u0015\b\u0016\u0017B\u0019\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002R$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/window/shop/widget/childcategory/HorizontalWeightedGroupView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "Landroid/view/View;", "views", "", "setConstraintChild", "Lcom/bytedance/android/window/shop/widget/childcategory/HorizontalWeightedGroupView$d;", "b", "Lcom/bytedance/android/window/shop/widget/childcategory/HorizontalWeightedGroupView$d;", "getOnSelectionChangedListener", "()Lcom/bytedance/android/window/shop/widget/childcategory/HorizontalWeightedGroupView$d;", "setOnSelectionChangedListener", "(Lcom/bytedance/android/window/shop/widget/childcategory/HorizontalWeightedGroupView$d;)V", "onSelectionChangedListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "c", "d", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HorizontalWeightedGroupView extends ConstraintLayout {
    public final int a;
    public d b;
    public final Map<WindowChildCategoryVO.ChildCategoryVO, a> c;

    public static final class a extends FrameLayout {
        public static final int f = 0;
        public static final int g = 0;
        public static final int h = 0;
        public final AppCompatTextView a;
        public final AppCompatTextView b;
        public final AppCompatTextView c;
        public final int d;
        public final View e;

        /* JADX INFO: renamed from: com.bytedance.android.window.shop.widget.childcategory.HorizontalWeightedGroupView$a$a, reason: collision with other inner class name */
        public static final class C0043a {
        }

        public static final class b implements Runnable {
            public final /* synthetic */ a a;
            public final /* synthetic */ int b;

            public b(a r1, int r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.c(this.b, false);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        static {
            f = ViewCompat.generateViewId();
            g = ViewCompat.generateViewId();
            h = ViewCompat.generateViewId();
        }

        public a(Context r7) {
            Intrinsics.checkNotNullParameter(r7, "ctx");
            super(r7);
            AppCompatTextView r8 = d(f);
            int r0 = com.bytedance.android.ec.hybrid.list.util.c.a;
            r8.setPadding(0, 0, com.bytedance.android.ec.hybrid.list.util.c.d(2), 0);
            Unit r1 = Unit.INSTANCE;
            this.a = r8;
            AppCompatTextView r2 = d(g);
            this.b = r2;
            AppCompatTextView r3 = d(h);
            r3.setPadding(com.bytedance.android.ec.hybrid.list.util.c.d(2), 0, 0, 0);
            this.c = r3;
            this.d = RangesKt.coerceAtLeast(com.bytedance.android.ec.hybrid.list.util.c.d(Double.valueOf(0.5d)), 1);
            View r4 = new View(getContext());
            this.e = r4;
            FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(-2, -2);
            r5.gravity = 17;
            addView(r4, new FrameLayout.LayoutParams(-1, -1));
            LinearLayout r6 = new LinearLayout(getContext());
            r6.addView(r8);
            r6.addView(r2);
            r6.addView(r3);
            addView(r6, r5);
        }

        public final void a(WindowChildCategoryVO.ChildCategoryVO r3) {
            Intrinsics.checkNotNullParameter(r3, "vo");
            if (r3.getSelected() == false) goto L5;
            WindowChildCategoryVO.ChildCategoryItemVO r4 = r3.getSelectedItem();
        L6:
            b(this.a, r4.getPrefix());
            b(this.b, r4.getTitle());
            b(this.c, r4.getSuffix());
            c(r4.getBgColor(), true);
            return;
        L5:
            r4 = r3.getUnselectedItem();
            goto L6
        }

        public final AppCompatTextView d(int r3) {
            AppCompatTextView r0 = new AppCompatTextView(getContext());
            r0.setId(r3);
            r0.setMaxLines(1);
            r0.setTextSize(1, 12.0f);
            return r0;
        }

        public static void b(AppCompatTextView r1, WindowChildCategoryVO.ChildCategoryTextVO r2) {
            if (r2 == null) goto L4;
            String r0 = r2.getText();
        L5:
            if (r0 != null) goto L7;
            r0 = "";
        L7:
            r1.setText(r0);
            if (r2 == null) goto L10;
            int r3 = r2.getTextColor();
        L11:
            r1.setTextColor(r3);
            return;
        L10:
            r3 = 0;
            goto L11
        L4:
            r0 = null;
            goto L5
        }

        public final void c(int r4, boolean r5) {
            if (this.e.getHeight() <= 0) goto L5;
            View r6 = this.e;
            GradientDrawable r0 = new GradientDrawable();
            r0.setStroke(this.d, -119723);
            r0.setCornerRadius(getHeight() / 2.0f);
            r0.setColor(r4);
            Unit r7 = Unit.INSTANCE;
            r6.setBackground(r0);
            return;
        L5:
            if (r5 == false) goto L9;
            this.e.post(new b(this, r4));
            return;
        }
    }

    public static final class b {
    }

    public static final class c extends TextView {
        public c(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            super(r2);
        }
    }

    public interface d {
        void a(WindowChildCategoryVO.ChildCategoryVO r1);
    }

    static {
    }

    public final d getOnSelectionChangedListener() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setConstraintChild(List<? extends View> r9) {
        if (r9.size() <= 1) goto L15;
        ArrayList r0 = new ArrayList();
        Iterator r1 = r9.iterator();
        int r4 = 0;
    L6:
        if (r1.hasNext() == false) goto L14;
        Object r5 = r1.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        r0.add((View) r5);
        if (r4 == (r9.size() - 1)) goto L13;
        c r7 = new c(getContext());
        r7.setId(ViewCompat.generateViewId());
        Unit r8 = Unit.INSTANCE;
        r0.add(r7);
    L13:
        r4 = r6;
        goto L6
    L14:
        r9 = r0;
    L15:
        Iterator r2 = r9.iterator();
        int r3 = 0;
    L17:
        if (r2.hasNext() == false) goto L33;
        Object r10 = r2.next();
        int r11 = r3 + 1;
        if (r3 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        View r12 = (View) r10;
        View r13 = (View) CollectionsKt.getOrNull(r9, r3 - 1);
        View r14 = (View) CollectionsKt.getOrNull(r9, r11);
        ConstraintLayout.LayoutParams r15 = new ConstraintLayout.LayoutParams(0, -1);
        if (r13 != null) goto L24;
        r15.leftToLeft = 0;
    L25:
        if (r14 != null) goto L27;
        r15.rightToRight = 0;
    L28:
        r15.topToTop = 0;
        r15.bottomToBottom = 0;
        if ((r12 instanceof c) == false) goto L31;
        ((ViewGroup.MarginLayoutParams) r15).width = this.a;
    L32:
        addView(r12, r15);
        r3 = r11;
        goto L17
    L31:
        r15.horizontalWeight = 1.0f;
        goto L32
    L27:
        r15.rightToLeft = r14.getId();
        goto L28
    L24:
        r15.leftToRight = r13.getId();
        goto L25
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(List<WindowChildCategoryVO.ChildCategoryVO> r8) {
        Intrinsics.checkNotNullParameter(r8, "subCategoryVOList");
        List r0 = com.bytedance.commerce.base.view.b.a(this);
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if ((r3 instanceof a) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        List r4 = CollectionsKt.toMutableList(r1);
        removeAllViews();
        ((LinkedHashMap) this.c).clear();
        List<WindowChildCategoryVO.ChildCategoryVO> r9 = r8;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r10 = r9.iterator();
    L10:
        if (r10.hasNext() == false) goto L16;
        final WindowChildCategoryVO.ChildCategoryVO r6 = (WindowChildCategoryVO.ChildCategoryVO) r10.next();
        if (r4.isEmpty() == false) goto L14;
        final a r7 = new a(getContext());
    L15:
        final HorizontalWeightedGroupView$bindData$1$1$1 r11 = new HorizontalWeightedGroupView$bindData$1$1$1(this);
        r7.getClass();
        Intrinsics.checkNotNullParameter(r6, "vo");
        Intrinsics.checkNotNullParameter(r11, "changedCallback");
        r7.a(r6);
        f.b(r7, 1000L, "window_child_category", new HorizontalWeightedGroupView$ChildCategoryView$bind$1(r7, r6, r11));
        r7.setId(ViewCompat.generateViewId());
        this.c.put(r6, r7);
        r5.add(r7);
        goto L10
    L14:
        r7 = (a) ListProtector.remove(r4, 0);
        goto L15
    L16:
        setConstraintChild(r5);
    }

    public final void setOnSelectionChangedListener(d r1) {
        this.b = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HorizontalWeightedGroupView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        setBackgroundColor(-1);
        int r4 = com.bytedance.android.ec.hybrid.list.util.c.a;
        this.a = com.bytedance.android.ec.hybrid.list.util.c.d(7);
        this.c = new LinkedHashMap();
    }
}
