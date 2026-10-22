package com.bytedance.android.shopping.store.tabkit.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.hybrid.card.api.ECLynxCardErrorType;
import com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle;
import com.bytedance.android.ec.hybrid.card.api.d;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.hybrid.card.util.k;
import com.bytedance.android.shopping.store.tabkit.TabKitViewModel;
import com.bytedance.android.shopping.store.tabkit.container.TabKitFoldFragment;
import com.bytedance.android.shopping.store.utils.g;
import com.bytedance.lynx.service.model.b;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R'\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00020\tj\b\u0012\u0004\u0012\u00020\u0002`\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/view/HybridTabLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/ec/hybrid/card/api/IECLynxCardLifeCycle;", "Lcom/bytedance/android/ec/hybrid/card/impl/ECLynxCard;", "a", "Lcom/bytedance/android/ec/hybrid/card/impl/ECLynxCard;", "getLynxCard", "()Lcom/bytedance/android/ec/hybrid/card/impl/ECLynxCard;", "lynxCard", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "getListener", "()Ljava/util/ArrayList;", "listener", "Lcom/bytedance/android/shopping/store/tabkit/view/ECTabKitView;", "tabKitView", "Lcom/bytedance/android/shopping/store/tabkit/view/ECTabKitView;", "getTabKitView", "()Lcom/bytedance/android/shopping/store/tabkit/view/ECTabKitView;", "setTabKitView", "(Lcom/bytedance/android/shopping/store/tabkit/view/ECTabKitView;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HybridTabLayout extends FrameLayout implements IECLynxCardLifeCycle {
    public final ECLynxCard a;
    public final ArrayList<IECLynxCardLifeCycle> b;
    public final HashMap<String, Object> c;
    public final HashMap<String, Object> d;

    public final void createViewDuration(long r1) {
    }

    public final void onCreateKitViewEnd(long r1) {
    }

    public final void onDestroy() {
    }

    public final void onLoadStart() {
    }

    public final void onPreCreateView(boolean r1) {
    }

    public final void onRealSuccess() {
    }

    public final void onReceivedError(b r1) {
    }

    public final void onRuntimeReady() {
    }

    public final void onTimingSetup(Map<String, ? extends Object> r1) {
    }

    public final void onTimingSetupPref(k r1) {
    }

    public final void onTimingUpdatePref(k r1) {
    }

    public final void onTransDataTime(long r1, long r3) {
    }

    public final void setTabKitView(ECTabKitView r1) {
    }

    public final ECTabKitView getTabKitView() {
        View r0 = this.a.b();
        LynxBaseUI r2 = null;
        if ((r0 instanceof LynxView) == true) goto L5;
        r0 = null;
    L5:
        LynxView r1 = (LynxView) r0;
        if (r1 == null) goto L8;
        LynxBaseUI r3 = r1.findUIByIdSelector("tabbar");
    L10:
        if ((r3 instanceof ECTabKitView) == false) goto L14;
        r2 = r3;
    L14:
        return (ECTabKitView) r2;
    L8:
        r3 = null;
        goto L10
    }

    public final void onFirstScreen() {
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((IECLynxCardLifeCycle) r0.next()).onFirstScreen();
        goto L4
    }

    public final void onLoadSuccess() {
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((IECLynxCardLifeCycle) r0.next()).onLoadSuccess();
        goto L4
    L6:
        getLayoutParams().height = -2;
        requestLayout();
    }

    public final ArrayList<IECLynxCardLifeCycle> getListener() {
        return this.b;
    }

    public final ECLynxCard getLynxCard() {
        return this.a;
    }

    public HybridTabLayout(Context r2) {
        this(r2, null);
    }

    public final void useCache(@IECLynxCardLifeCycle.ECLynxCardCacheType String r2) {
        Intrinsics.checkNotNullParameter(r2, "cache");
        Intrinsics.checkNotNullParameter(r2, "cache");
    }

    public HybridTabLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = new ECLynxCard();
        this.b = new ArrayList();
        HashMap<String, Object> r4 = new HashMap();
        this.c = r4;
        HashMap<String, Object> r5 = new HashMap();
        r5.put("meta_info", r4);
        Unit r6 = Unit.INSTANCE;
        this.d = r5;
    }

    public final void a(TabKitViewModel r4, Pair<Integer, Integer> r5) {
        Intrinsics.checkNotNullParameter(r4, "tabKitViewModel");
        if (r4.isFoldPage() == true) goto L5;
        return;
    L5:
        if (r5 != null) goto L13;
        Context r6 = getContext();
        if ((r6 instanceof Activity) == true) goto L9;
        r6 = null;
    L9:
        Activity r7 = (Activity) r6;
        if (r7 == null) goto L12;
        int r0 = TabKitFoldFragment.f;
        TabKitFoldFragment.a.a(r7);
    L12:
        r5 = null;
    L13:
        if (r5 == null) goto L22;
        LinkedHashMap r1 = new LinkedHashMap();
        g.a(r1, "ec_split_screen_width", com.bytedance.android.shopping.extensions.b.f((Number) r5.getFirst()));
        String r8 = r4.getFoldType();
        if (r8 != null) goto L17;
        r8 = "";
    L17:
        g.a(r1, "split_screen_type", r8);
        g.a(r1, "is_split", Boolean.TRUE);
        this.a.s(r1);
        this.a.c(((Number) r5.getFirst()).intValue(), ((Number) r5.getSecond()).intValue());
        ViewGroup.LayoutParams r9 = getLayoutParams();
        if (r9 == null) goto L20;
        r9.width = ((Number) r5.getFirst()).intValue();
    L20:
        requestLayout();
        return;
    }

    public final void b(com.bytedance.android.shopping.store.tabkit.model.k r3, com.bytedance.android.shopping.store.tabkit.model.k r4) {
        Intrinsics.checkNotNullParameter(r3, "targetHomeTab");
        Intrinsics.checkNotNullParameter(r4, "targetTab");
        HashMap<String, Object> r0 = this.c;
        r0.put("bottom_tab_data", GsonProtectorUtils.toJson(new Gson(), r3));
        r0.put("tab_data", GsonProtectorUtils.toJson(new Gson(), r4));
        ECLynxCard r5 = this.a;
        int r6 = d.e;
        r5.e(d.a.a(this.d), false);
    }

    public final void onLoadFailed(ECLynxCardErrorType r3, Integer r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(r3, "type");
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((IECLynxCardLifeCycle) r0.next()).onLoadFailed(r3, r4, r5);
        goto L4
    }
}
