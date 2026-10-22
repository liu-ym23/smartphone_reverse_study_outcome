package com.bytedance.ee.bear.wikiv2.wikitreev2.scroll;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fBY\u00126\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0003\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\nH\u0016J \u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002RA\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/scroll/WikiTreeItemTouchListener;", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "filter", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikItemLeafView;", "view", "", "callback", "", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "getFilter", "()Lkotlin/jvm/functions/Function2;", "getCallback", "onInterceptTouchEvent", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroid/view/MotionEvent;", "onTouchEvent", "onRequestDisallowInterceptTouchEvent", "disallowIntercept", "isClickInAddArea", "x", "", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Landroid/view/View;", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiTreeItemTouchListener implements RecyclerView.OnItemTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<Integer, WikItemLeafView, Boolean> f241668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<Integer, WikItemLeafView, Unit> f241669b;

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final void onRequestDisallowInterceptTouchEvent(boolean r100) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WikiTreeItemTouchListener(Function2<? super Integer, ? super WikItemLeafView, Boolean> r100, Function2<? super Integer, ? super WikItemLeafView, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "filter");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f241668a = r100;
        this.f241669b = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final boolean onInterceptTouchEvent(RecyclerView r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "rv");
        Intrinsics.checkNotNullParameter(r101, "e");
        if (r101.getAction() != 0) goto L13;
        View r102 = r100.findChildViewUnder(r101.getX(), r101.getY());
        if (r102 == null) goto L13;
        int r103 = r100.getChildAdapterPosition(r102);
        if ((r102 instanceof WikItemLeafView) == false) goto L13;
        if (a(r101.getX(), r102, r100) == false) goto L13;
        if (this.f241668a.invoke(Integer.valueOf(r103), (WikItemLeafView) r102).booleanValue() == false) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final void onTouchEvent(RecyclerView r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "rv");
        Intrinsics.checkNotNullParameter(r101, "e");
        if (r101.getAction() != 1) goto L15;
        View r102 = r100.findChildViewUnder(r101.getX(), r101.getY());
        if (r102 == null) goto L16;
        boolean r103 = a(r101.getX(), r102, r100);
        int r104 = r100.getChildAdapterPosition(r102);
        if (r103 == false) goto L17;
        if (r104 >= 0) goto L10;
        return;
    L10:
        if ((r102 instanceof WikItemLeafView) == true) goto L12;
        return;
    L12:
        if (this.f241668a.invoke(Integer.valueOf(r104), (WikItemLeafView) r102).booleanValue() == false) goto L20;
        this.f241669b.invoke(Integer.valueOf(r104), (WikItemLeafView) r102);
        return;
    L20:
        return;
    L17:
        return;
    L16:
        return;
    }

    public static boolean a(float r100, View r101, RecyclerView r102) {
    L13:
        e = move-exception;
        tt5.a.d("WikiTreeItemTouchListener", "isClickInAddAreaV2 err " + e.getMessage());
        return false;
    L4:
        if ((r101 instanceof WikItemLeafView) == false) goto L12;
        SwipeMenuLayout r103 = (SwipeMenuLayout) r101.findViewById(R.id.swipe_menu_layout);     // Catch: Exception -> L13
        ViewParent r104 = r102.getParent();     // Catch: Exception -> L13
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.view.ViewGroup");     // Catch: Exception -> L13
        ViewGroup r105 = (ViewGroup) r104;     // Catch: Exception -> L13
        int r106 = r105.getRight();     // Catch: Exception -> L13
        int r107 = r105.getScrollX();     // Catch: Exception -> L13
        Rect r108 = new Rect((((r106 - r103.getScrollX()) + r107) - n.d(20)) - n.d(8), r101.getTop(), (r106 - r103.getScrollX()) + r107, r101.getBottom());     // Catch: Exception -> L13
        if (r100 <= r108.left) goto L12;
        if (r100 >= r108.right) goto L12;
        return true;
    L12:
        return false;
    }
}
