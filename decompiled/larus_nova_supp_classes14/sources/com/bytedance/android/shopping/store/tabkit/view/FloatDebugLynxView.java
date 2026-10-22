package com.bytedance.android.shopping.store.tabkit.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ec.hybrid.card.api.ECLynxCardErrorType;
import com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.hybrid.card.util.k;
import com.bytedance.lynx.service.model.b;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R'\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00020\tj\b\u0012\u0004\u0012\u00020\u0002`\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/view/FloatDebugLynxView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/ec/hybrid/card/api/IECLynxCardLifeCycle;", "Lcom/bytedance/android/ec/hybrid/card/impl/ECLynxCard;", "a", "Lcom/bytedance/android/ec/hybrid/card/impl/ECLynxCard;", "getLynxCard", "()Lcom/bytedance/android/ec/hybrid/card/impl/ECLynxCard;", "lynxCard", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "getListener", "()Ljava/util/ArrayList;", "listener", "Lcom/bytedance/android/shopping/store/tabkit/view/ECTabKitView;", "tabKitView", "Lcom/bytedance/android/shopping/store/tabkit/view/ECTabKitView;", "getTabKitView", "()Lcom/bytedance/android/shopping/store/tabkit/view/ECTabKitView;", "setTabKitView", "(Lcom/bytedance/android/shopping/store/tabkit/view/ECTabKitView;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FloatDebugLynxView extends FrameLayout implements IECLynxCardLifeCycle {
    public final ECLynxCard a;
    public final ArrayList<IECLynxCardLifeCycle> b;

    public final void createViewDuration(long r1) {
    }

    public final void onCreateKitViewEnd(long r1) {
    }

    public final void onDestroy() {
    }

    public final void onFirstScreen() {
    }

    public final void onLoadStart() {
    }

    public final void onLoadSuccess() {
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

    public final ArrayList<IECLynxCardLifeCycle> getListener() {
        return this.b;
    }

    public final ECLynxCard getLynxCard() {
        return this.a;
    }

    public FloatDebugLynxView(Context r2) {
        this(r2, null);
    }

    public final void useCache(@IECLynxCardLifeCycle.ECLynxCardCacheType String r2) {
        Intrinsics.checkNotNullParameter(r2, "cache");
        Intrinsics.checkNotNullParameter(r2, "cache");
    }

    public FloatDebugLynxView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = new ECLynxCard();
        this.b = new ArrayList();
    }

    public final void onLoadFailed(ECLynxCardErrorType r1, Integer r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "type");
        Intrinsics.checkNotNullParameter(r1, "type");
    }
}
