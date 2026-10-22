package com.obric.oui.orecyclerview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes34.dex */
public class RecyclerViewAccessibilityDelegate extends AccessibilityDelegateCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f401747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ItemDelegate f401748b;

    public static class ItemDelegate extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RecyclerViewAccessibilityDelegate f401749a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<View, AccessibilityDelegateCompat> f401750b;

        public ItemDelegate(RecyclerViewAccessibilityDelegate r100) {
            this.f401750b = new WeakHashMap();
            this.f401749a = r100;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View r100) {
            AccessibilityDelegateCompat r101 = (AccessibilityDelegateCompat) ((WeakHashMap) this.f401750b).get(r100);
            if (r101 == null) goto L7;
            return r101.getAccessibilityNodeProvider(r100);
        L7:
            return super.getAccessibilityNodeProvider(r100);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final boolean dispatchPopulateAccessibilityEvent(View r100, AccessibilityEvent r101) {
            AccessibilityDelegateCompat r102 = (AccessibilityDelegateCompat) ((WeakHashMap) this.f401750b).get(r100);
            if (r102 == null) goto L7;
            return r102.dispatchPopulateAccessibilityEvent(r100, r101);
        L7:
            return super.dispatchPopulateAccessibilityEvent(r100, r101);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityEvent(View r100, AccessibilityEvent r101) {
            AccessibilityDelegateCompat r102 = (AccessibilityDelegateCompat) ((WeakHashMap) this.f401750b).get(r100);
            if (r102 == null) goto L5;
            r102.onInitializeAccessibilityEvent(r100, r101);
            return;
        L5:
            super.onInitializeAccessibilityEvent(r100, r101);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
            RecyclerView r102 = this.f401749a.f401747a;
            if (r102.f401631u == true) goto L5;
        L10:
            boolean r103 = true;
        L11:
            if (r103 == false) goto L13;
        L18:
            super.onInitializeAccessibilityNodeInfo(r100, r101);
            return;
        L13:
            if (this.f401749a.f401747a.getLayoutManager() == null) goto L18;
            this.f401749a.f401747a.getLayoutManager().Q(r100, r101);
            AccessibilityDelegateCompat r104 = (AccessibilityDelegateCompat) ((WeakHashMap) this.f401750b).get(r100);
            if (r104 == null) goto L17;
            r104.onInitializeAccessibilityNodeInfo(r100, r101);
            return;
        L17:
            super.onInitializeAccessibilityNodeInfo(r100, r101);
            return;
        L5:
            if (r102.C == true) goto L10;
            if (r102.f401607d.g() == true) goto L10;
            r103 = false;
            goto L11
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onPopulateAccessibilityEvent(View r100, AccessibilityEvent r101) {
            AccessibilityDelegateCompat r102 = (AccessibilityDelegateCompat) ((WeakHashMap) this.f401750b).get(r100);
            if (r102 == null) goto L5;
            r102.onPopulateAccessibilityEvent(r100, r101);
            return;
        L5:
            super.onPopulateAccessibilityEvent(r100, r101);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void sendAccessibilityEvent(View r100, int r101) {
            AccessibilityDelegateCompat r102 = (AccessibilityDelegateCompat) ((WeakHashMap) this.f401750b).get(r100);
            if (r102 == null) goto L5;
            r102.sendAccessibilityEvent(r100, r101);
            return;
        L5:
            super.sendAccessibilityEvent(r100, r101);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void sendAccessibilityEventUnchecked(View r100, AccessibilityEvent r101) {
            AccessibilityDelegateCompat r102 = (AccessibilityDelegateCompat) ((WeakHashMap) this.f401750b).get(r100);
            if (r102 == null) goto L5;
            r102.sendAccessibilityEventUnchecked(r100, r101);
            return;
        L5:
            super.sendAccessibilityEventUnchecked(r100, r101);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final boolean onRequestSendAccessibilityEvent(ViewGroup r100, View r101, AccessibilityEvent r102) {
            AccessibilityDelegateCompat r103 = (AccessibilityDelegateCompat) ((WeakHashMap) this.f401750b).get(r100);
            if (r103 == null) goto L7;
            return r103.onRequestSendAccessibilityEvent(r100, r101, r102);
        L7:
            return super.onRequestSendAccessibilityEvent(r100, r101, r102);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final boolean performAccessibilityAction(View r100, int r101, Bundle r102) {
            RecyclerView r103 = this.f401749a.f401747a;
            if (r103.f401631u == true) goto L5;
        L10:
            boolean r104 = true;
        L11:
            if (r104 == true) goto L25;
            if (this.f401749a.f401747a.getLayoutManager() == null) goto L25;
            AccessibilityDelegateCompat r105 = (AccessibilityDelegateCompat) ((WeakHashMap) this.f401750b).get(r100);
            if (r105 == null) goto L20;
            if (r105.performAccessibilityAction(r100, r101, r102) == false) goto L22;
            return true;
        L22:
            RecyclerView.q r106 = this.f401749a.f401747a.getLayoutManager().f401662b.f401603b;
            return false;
        L20:
            if (super.performAccessibilityAction(r100, r101, r102) == false) goto L22;
            return true;
        L25:
            return super.performAccessibilityAction(r100, r101, r102);
        L5:
            if (r103.C == true) goto L10;
            if (r103.f401607d.g() == true) goto L10;
            r104 = false;
            goto L11
        }
    }

    public RecyclerViewAccessibilityDelegate(RecyclerView r100) {
        this.f401747a = r100;
        ItemDelegate r101 = this.f401748b;
        if (r101 == null) goto L5;
        this.f401748b = r101;
        return;
    L5:
        this.f401748b = new ItemDelegate(this);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityEvent(View r100, AccessibilityEvent r101) {
        super.onInitializeAccessibilityEvent(r100, r101);
        if ((r100 instanceof RecyclerView) == false) goto L18;
        RecyclerView r102 = this.f401747a;
        if (r102.f401631u == true) goto L7;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == true) goto L19;
        RecyclerView r104 = (RecyclerView) r100;
        if (r104.getLayoutManager() == null) goto L20;
        r104.getLayoutManager().O(r101);
        return;
    L20:
        return;
    L19:
        return;
    L7:
        if (r102.C == true) goto L12;
        if (r102.f401607d.g() == true) goto L12;
        r103 = false;
        goto L13
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
        super.onInitializeAccessibilityNodeInfo(r100, r101);
        RecyclerView r102 = this.f401747a;
        if (r102.f401631u == true) goto L5;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == false) goto L13;
        return;
    L13:
        if (this.f401747a.getLayoutManager() == null) goto L17;
        RecyclerView.k r104 = this.f401747a.getLayoutManager();
        RecyclerView r105 = r104.f401662b;
        r104.P(r105.f401603b, r105.L0, r101);
        return;
    L17:
        return;
    L5:
        if (r102.C == true) goto L10;
        if (r102.f401607d.g() == true) goto L10;
        r103 = false;
        goto L11
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final boolean performAccessibilityAction(View r100, int r110, Bundle r111) {
        if (super.performAccessibilityAction(r100, r110, r111) == false) goto L5;
        return true;
    L5:
        RecyclerView r101 = this.f401747a;
        if (r101.f401631u == true) goto L8;
    L13:
        boolean r102 = true;
    L14:
        if (r102 == false) goto L16;
    L48:
        return false;
    L16:
        if (this.f401747a.getLayoutManager() == null) goto L48;
        RecyclerView.k r103 = this.f401747a.getLayoutManager();
        RecyclerView.q r104 = r103.f401662b.f401603b;
        int r105 = r103.f401673m;
        int r106 = r103.f401672l;
        Rect r107 = new Rect();
        if (r103.f401662b.getMatrix().isIdentity() == false) goto L23;
        if (r103.f401662b.getGlobalVisibleRect(r107) == false) goto L23;
        r105 = r107.height();
        r106 = r107.width();
    L23:
        if (r110 == 4096) goto L35;
        if (r110 == 8192) goto L28;
        int r108 = 0;
        int r109 = 0;
    L43:
        if (r109 != 0) goto L46;
        if (r108 != 0) goto L46;
        return false;
    L46:
        r103.f401662b.X(r108, r109, null, Integer.MIN_VALUE, true);
        return true;
    L28:
        if (r103.f401662b.canScrollVertically(-1) == false) goto L30;
        int r112 = -((r105 - r103.E()) - r103.B());
    L32:
        if (r103.f401662b.canScrollHorizontally(-1) == false) goto L42;
        int r113 = -((r106 - r103.C()) - r103.D());
    L41:
        r109 = r112;
        r108 = r113;
    L42:
        r109 = r112;
        r108 = 0;
        goto L43
    L30:
        r112 = 0;
        goto L32
    L35:
        if (r103.f401662b.canScrollVertically(1) == false) goto L37;
        r112 = (r105 - r103.E()) - r103.B();
    L39:
        if (r103.f401662b.canScrollHorizontally(1) == false) goto L42;
        r113 = (r106 - r103.C()) - r103.D();
        goto L41
    L37:
        r112 = 0;
        goto L39
    L8:
        if (r101.C == true) goto L13;
        if (r101.f401607d.g() == true) goto L13;
        r102 = false;
        goto L14
    }
}
