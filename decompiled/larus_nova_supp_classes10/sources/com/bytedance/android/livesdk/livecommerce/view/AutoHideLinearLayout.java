package com.bytedance.android.livesdk.livecommerce.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB\u001b\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\n\u0010\u000eB#\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\n\u0010\u0011J!\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/view/AutoHideLinearLayout;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "", "Landroid/view/View;", "viewArray", "", "setHideGroup", "([Landroid/view/View;)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AutoHideLinearLayout extends LinearLayoutCompat {
    public final Map<String, List<View>> a;

    public AutoHideLinearLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = new LinkedHashMap();
    }

    public final List<View> d(View r4) {
        Object r0 = r4.getTag(2131370497);
        if ((r0 instanceof String) == true) goto L5;
        r0 = null;
    L5:
        String r1 = (String) r0;
        if (r1 != null) goto L8;
        List<View> r5 = CollectionsKt.listOf(r4);
    L12:
        Iterator<T> r2 = r5.iterator();
    L14:
        if (r2.hasNext() == false) goto L16;
        ((View) r2.next()).layout(0, 0, 0, 0);
        goto L14
    L16:
        return r5;
    L8:
        List<View> r3 = (List) ((LinkedHashMap) this.a).get(r1);
        if (r3 != null) goto L11;
        r5 = CollectionsKt.listOf(r4);
        goto L12
    L11:
        r5 = r3;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onViewRemoved(View r4) {
        super/*android.view.ViewGroup*/.onViewRemoved(r4);
        Object r0 = null;
        if (r4 == null) goto L5;
        Object r1 = r4.getTag(2131370497);
    L7:
        if ((r1 instanceof String) == false) goto L10;
        r0 = r1;
    L10:
        String r2 = (String) r0;
        if (r2 != null) goto L13;
        return;
    L13:
        List<View> r3 = this.a.get(r2);
        if (r3 != null) goto L16;
        return;
    L16:
        r3.remove(r4);
        if (r3.isEmpty() == false) goto L20;
        this.a.remove(r2);
        return;
    L20:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final void setHideGroup(View... r6) {
        Intrinsics.checkNotNullParameter(r6, "viewArray");
        String r0 = UUID.randomUUID().toString();
        int r1 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r6[r2].setTag(2131370497, r0);
        r2 = r2 + 1;
        goto L3
    L5:
        this.a.put(r0, ArraysKt.toMutableList(r6));
    }

    public AutoHideLinearLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = new LinkedHashMap();
    }

    public AutoHideLinearLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onLayout(boolean r13, int r14, int r15, int r16, int r17) {
        super.onLayout(r13, r14, r15, r16, r17);
        LinkedHashSet r8 = new LinkedHashSet();
        if (getOrientation() != 0) goto L14;
        int r10 = getChildCount() - 1;
    L5:
        if (r10 < 0) goto L22;
        View r11 = getChildAt(r10);
        if (r11.getVisibility() == 8) goto L13;
        if (r8.contains(r11) == true) goto L13;
        if (e(r11, r13, r14, r15, r16, r17) == false) goto L32;
        r8.addAll(d(r11));
        goto L13
    L32:
        return;
    L13:
        r10 = r10 - 1;
        goto L5
    L22:
        return;
    L14:
        int r12 = getChildCount() - 1;
    L15:
        if (r12 < 0) goto L34;
        View r18 = getChildAt(r12);
        if (r18.getVisibility() == 8) goto L21;
        if (e(r18, r13, r14, r15, r16, r17) == false) goto L33;
        r8.addAll(d(r18));
        goto L21
    L33:
        return;
    L21:
        r12 = r12 - 1;
        goto L15
    }

    public boolean e(View r3, boolean r4, int r5, int r6, int r7, int r8) {
        Intrinsics.checkNotNullParameter(r3, "child");
        if (getOrientation() != 0) goto L16;
        int r9 = r3.getMeasuredWidth();
        ViewGroup.LayoutParams r10 = r3.getLayoutParams();
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        int r11 = MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) r10);
    L8:
        int r12 = r9 + r11;
        ViewGroup.LayoutParams r13 = r3.getLayoutParams();
        if ((r13 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        int r14 = MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) r13);
    L13:
        if ((r3.getLeft() + (r12 + r14)) <= r7) goto L35;
        return true;
    L35:
        return false;
    L11:
        r14 = 0;
        goto L13
    L7:
        r11 = 0;
        goto L8
    L16:
        int r15 = r3.getMeasuredHeight();
        ViewGroup.LayoutParams r16 = r3.getLayoutParams();
        ViewGroup.LayoutParams r1 = null;
        if ((r16 instanceof ViewGroup.MarginLayoutParams) == true) goto L19;
        r16 = null;
    L19:
        ViewGroup.MarginLayoutParams r17 = (ViewGroup.MarginLayoutParams) r16;
        if (r17 == null) goto L22;
        int r18 = r17.topMargin;
    L23:
        int r19 = r15 + r18;
        ViewGroup.LayoutParams r20 = r3.getLayoutParams();
        if ((r20 instanceof ViewGroup.MarginLayoutParams) == false) goto L27;
        r1 = r20;
    L27:
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
        if (r2 == null) goto L30;
        int r21 = r2.bottomMargin;
    L32:
        if ((r3.getTop() + (r19 + r21)) <= r8) goto L36;
        return true;
    L36:
        return false;
    L30:
        r21 = 0;
        goto L32
    L22:
        r18 = 0;
        goto L23
    }
}
