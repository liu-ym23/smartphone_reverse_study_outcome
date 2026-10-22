package com.bytedance.android.shopping.yata.biz.popup.behavior;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0003\u000b\f\rB\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/yata/biz/popup/behavior/SheetBaseBehavior;", "Landroid/view/View;", "V", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "b", "State", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class SheetBaseBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public static final /* synthetic */ int g = 0;
    public boolean a;
    public b b;
    public boolean c;
    public boolean d;
    public final d e;
    public final c f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/yata/biz/popup/behavior/SheetBaseBehavior$State;", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface State {
    }

    public static final class a {
    }

    public interface b {
        void a(View r1, int r2);

        void b(View r1);
    }

    public static final class c {
        public c() {
        }
    }

    public static final class d {
        public final /* synthetic */ SheetBaseBehavior a;

        public d(SheetBaseBehavior r1) {
            this.a = r1;
        }
    }

    static {
    }

    public void setPeekHeight(int r1) {
    }

    public void setState(int r1) {
    }

    public SheetBaseBehavior() {
        this.a = true;
        this.e = new d(this);
        this.f = new c();
    }

    public final String a(ViewGroup r7) {
        Intrinsics.checkNotNullParameter(r7, "parent");
        Resources r0 = r7.getResources();
        if (r7.getId() == (-1)) goto L8;
        if (r0 == null) goto L8;
        String r1 = r0.getResourceEntryName(r7.getId());
        if ((!Intrinsics.areEqual("commerce_design_bottom_sheet", r1)) == false) goto L8;
        return r1;
    L8:
        int r2 = r7.getChildCount();
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L19;
        View r4 = r7.getChildAt(r3);
        if ((r4 instanceof ViewGroup) == true) goto L13;
        if (r4.getId() != (-1)) goto L16;
        r3 = r3 + 1;
        goto L9
    L16:
        Intrinsics.checkNotNull(r0);
        return r0.getResourceEntryName(r4.getId());
    L13:
        return a((ViewGroup) r4);
    L19:
        return "";
    }

    public final View findScrollingChild(View r9) {
        if (r9 != null) goto L6;
        return null;
    L6:
        if (ViewCompat.isNestedScrollingEnabled(r9) == false) goto L8;
        return r9;
    L8:
        int r2 = 0;
        if ((r9 instanceof ViewPager) == false) goto L36;
        ViewPager r10 = (ViewPager) r9;
        int r1 = r10.getCurrentItem();
        int r3 = r10.getChildCount();
    L11:
        if (r2 >= r3) goto L26;
        View r4 = r10.getChildAt(r2);
        ViewPager.LayoutParams r5 = r4.getLayoutParams();
        if (r5 == null) goto L25;
        ViewPager.LayoutParams r6 = r5;
        Field r7 = r6.getClass().getDeclaredField("position");     // Catch: Throwable -> L44
        r7.setAccessible(true);     // Catch: Throwable -> L44
        Object r8 = r7.get(r6);     // Catch: Throwable -> L44
        if (r6.isDecor == true) goto L23;
        if ((r8 instanceof Integer) == false) goto L23;
        if (r1 != ((Integer) r8).intValue()) goto L23;
    L27:
        if (r4 != null) goto L29;
        return null;
    L29:
        View r11 = findScrollingChild(r4);
        if (r11 != null) goto L32;
        return null;
    L32:
        if (r11.getVisibility() == 0) goto L34;
        return null;
    L34:
        return r11;
    L23:
        r2 = r2 + 1;
        goto L11
    L25:
        throw new NullPointerException("null cannot be cast to non-null type androidx.viewpager.widget.ViewPager.LayoutParams");
    L26:
        r4 = null;
        goto L27
    L36:
        if ((r9 instanceof ViewGroup) == false) goto L43;
        ViewGroup r12 = (ViewGroup) r9;
        int r13 = r12.getChildCount();
    L38:
        if (r2 >= r13) goto L43;
        View r14 = findScrollingChild(r12.getChildAt(r2));
        if (r14 != null) goto L41;
        r2 = r2 + 1;
        goto L38
    L41:
        return r14;
    L43:
        return null;
    }

    public SheetBaseBehavior(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = true;
        this.e = new d(this);
        this.f = new c();
    }
}
