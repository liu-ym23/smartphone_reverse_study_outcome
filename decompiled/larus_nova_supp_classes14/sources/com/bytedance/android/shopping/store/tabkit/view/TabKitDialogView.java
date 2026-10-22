package com.bytedance.android.shopping.store.tabkit.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.android.ec.hybrid.card.api.ECLynxCardErrorType;
import com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.hybrid.card.util.k;
import com.bytedance.android.shopping.store.tabkit.TabKitPresenter;
import com.bytedance.android.shopping.store.tabkit.TabKitViewModel;
import com.bytedance.android.shopping.store.tabkit.bridge.c;
import com.bytedance.android.shopping.store.tabkit.f;
import com.bytedance.android.shopping.store.tabkit.model.i;
import com.bytedance.lynx.service.model.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/view/TabKitDialogView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/ec/hybrid/card/api/IECLynxCardLifeCycle;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/bytedance/android/ec/hybrid/card/impl/ECLynxCard;", "a", "Lcom/bytedance/android/ec/hybrid/card/impl/ECLynxCard;", "getLynxCard", "()Lcom/bytedance/android/ec/hybrid/card/impl/ECLynxCard;", "lynxCard", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabKitDialogView extends FrameLayout implements IECLynxCardLifeCycle, LifecycleObserver {
    public final ECLynxCard a;
    public f b;
    public i c;

    public TabKitDialogView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public TabKitDialogView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

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

    public final void a() {
        this.a.release();
        f r0 = this.b;
        if (r0 == null) goto L30;
        TabKitPresenter r1 = r0.Mc();
        if (r1 == null) goto L31;
        FrameLayout r2 = r1.u;
        if (r2 == null) goto L37;
        r2.removeView(this);
        i r3 = this.c;
        if (r3 == null) goto L18;
        f r4 = this.b;
        if (r4 == null) goto L18;
        TabKitViewModel r5 = r4.getTabKitViewModel();
        if (r5 == null) goto L18;
        c r6 = r5.getJsEventStub();
        if (r6 == null) goto L18;
        Intrinsics.checkNotNullParameter(r3, "popupDynamicConfig");
        r6.a("ecTabKit.popupDidDismiss", com.bytedance.android.ec.hybrid.list.util.k.b(r3));
    L18:
        i r7 = this.c;
        if (r7 == null) goto L32;
        String r8 = r7.b();
        if (r8 == null) goto L33;
        f r9 = this.b;
        if (r9 == null) goto L34;
        TabKitViewModel r10 = r9.getTabKitViewModel();
        if (r10 == null) goto L35;
        HashMap<String, ArrayList<TabKitDialogView>> r11 = r10.getDialogsMap();
        if (r11 == null) goto L36;
        ArrayList<TabKitDialogView> r12 = r11.remove(r8);
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L37:
        return;
    L31:
        return;
    }

    public final ECLynxCard getLynxCard() {
        return this.a;
    }

    public final void useCache(@IECLynxCardLifeCycle.ECLynxCardCacheType String r2) {
        Intrinsics.checkNotNullParameter(r2, "cache");
        Intrinsics.checkNotNullParameter(r2, "cache");
    }

    public TabKitDialogView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new ECLynxCard();
    }

    public final void onLoadFailed(ECLynxCardErrorType r1, Integer r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "type");
        Intrinsics.checkNotNullParameter(r1, "type");
        a();
    }

    public /* synthetic */ TabKitDialogView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
