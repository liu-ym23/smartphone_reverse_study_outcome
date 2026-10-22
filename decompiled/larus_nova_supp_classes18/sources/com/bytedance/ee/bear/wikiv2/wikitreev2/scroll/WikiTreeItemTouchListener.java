package com.bytedance.ee.bear.wikiv2.wikitreev2.scroll;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView;
import com.bytedance.ee.util.ui.n;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fBY\u00126\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0003\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\nH\u0016J \u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002RA\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/scroll/WikiTreeItemTouchListener;", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "filter", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikItemLeafView;", "view", "", "callback", "", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "getFilter", "()Lkotlin/jvm/functions/Function2;", "getCallback", "onInterceptTouchEvent", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroid/view/MotionEvent;", "onTouchEvent", "onRequestDisallowInterceptTouchEvent", "disallowIntercept", "isClickInAddArea", "x", "", "child", "Landroid/view/View;", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiTreeItemTouchListener implements RecyclerView.OnItemTouchListener {
    public final Function2<Integer, WikItemLeafView, Boolean> a;
    public final Function2<Integer, WikItemLeafView, Unit> b;

    public static final class a {
    }

    static {
    }

    public final void onRequestDisallowInterceptTouchEvent(boolean r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WikiTreeItemTouchListener(Function2<? super Integer, ? super WikItemLeafView, Boolean> r2, Function2<? super Integer, ? super WikItemLeafView, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "filter");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.a = r2;
        this.b = r3;
    }

    public final boolean onInterceptTouchEvent(RecyclerView r4, MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r4, "rv");
        Intrinsics.checkNotNullParameter(r5, "e");
        if (r5.getAction() != 0) goto L13;
        View r0 = r4.findChildViewUnder(r5.getX(), r5.getY());
        if (r0 == null) goto L13;
        int r1 = r4.getChildAdapterPosition(r0);
        if ((r0 instanceof WikItemLeafView) == false) goto L13;
        if (a(r5.getX(), r0, r4) == false) goto L13;
        if (((Boolean) this.a.invoke(Integer.valueOf(r1), r0)).booleanValue() == false) goto L13;
        return true;
    L13:
        return false;
    }

    public final void onTouchEvent(RecyclerView r3, MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r3, "rv");
        Intrinsics.checkNotNullParameter(r4, "e");
        if (r4.getAction() != 1) goto L15;
        View r0 = r3.findChildViewUnder(r4.getX(), r4.getY());
        if (r0 == null) goto L16;
        boolean r5 = a(r4.getX(), r0, r3);
        int r6 = r3.getChildAdapterPosition(r0);
        if (r5 == false) goto L17;
        if (r6 >= 0) goto L10;
        return;
    L10:
        if ((r0 instanceof WikItemLeafView) == true) goto L12;
        return;
    L12:
        if (((Boolean) this.a.invoke(Integer.valueOf(r6), r0)).booleanValue() == false) goto L20;
        this.b.invoke(Integer.valueOf(r6), r0);
        return;
    L20:
        return;
    L17:
        return;
    L16:
        return;
    }

    public static boolean a(float r6, View r7, RecyclerView r8) {
    L13:
        e = move-exception;
        tt5.a.d("WikiTreeItemTouchListener", "isClickInAddAreaV2 err " + e.getMessage());
        return false;
    L4:
        if ((r7 instanceof WikItemLeafView) == false) goto L12;
        SwipeMenuLayout r1 = r7.findViewById(2131387820);     // Catch: Exception -> L13
        ViewParent r9 = r8.getParent();     // Catch: Exception -> L13
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type android.view.ViewGroup");     // Catch: Exception -> L13
        ViewGroup r10 = (ViewGroup) r9;     // Catch: Exception -> L13
        int r2 = r10.getRight();     // Catch: Exception -> L13
        int r11 = r10.getScrollX();     // Catch: Exception -> L13
        Rect r3 = new Rect((((r2 - r1.getScrollX()) + r11) - n.d(20)) - n.d(8), r7.getTop(), (r2 - r1.getScrollX()) + r11, r7.getBottom());     // Catch: Exception -> L13
        if (r6 <= r3.left) goto L12;
        if (r6 >= r3.right) goto L12;
        return true;
    L12:
        return false;
    }
}
