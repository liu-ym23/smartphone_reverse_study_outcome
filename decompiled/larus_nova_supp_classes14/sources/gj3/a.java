package gj3;

import com.bytedance.android.shopping.store.live.SwitchLiveTabSource;
import com.bytedance.android.shopping.store.live.event.ShopLiveState;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String b(ECStoreViewModel r1) {
        Intrinsics.checkNotNullParameter(r1, "viewModel");
        if (r1.enableLiveTab() == true) goto L7;
        return "live_cell";
    L7:
        if (r1.getSlideByAuto() == true) goto L9;
        r1.setSwitchLiveTabSource(SwitchLiveTabSource.CLICK_LIVE_PREVIEW);
    L9:
        SwitchLiveTabSource r2 = r1.getSwitchLiveTabSource();
        if (r2 == null) goto L14;
        String r3 = r2.getMethod();
        if (r3 == null) goto L14;
        return r3;
    L14:
        return SwitchLiveTabSource.CLICK_TAB.getMethod();
    }

    public static boolean a(ECStoreViewModel r2, String r3, Function0 r4) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "schema");
        Intrinsics.checkNotNullParameter(r4, "enterLiveTab");
        if (r2.enableLiveTab() == true) goto L6;
        return false;
    L6:
        r2.setLiveSchema(r3);
        if (r2.getSwitchLiveTabSource() != SwitchLiveTabSource.CLICK_TAB) goto L16;
        ShopLiveState r5 = (ShopLiveState) r2.getLiveState().getValue();
        if (r5 == null) goto L11;
        ShopLiveState.PlayState r6 = r5.a;
    L13:
        if (r6 == ShopLiveState.PlayState.ERROR) goto L16;
        r2.getLiveState().setValue(new ShopLiveState(ShopLiveState.PlayState.ENTER_LIVE, ShopLiveState.LiveScene.LIVE_TAB));
    L18:
        dm.a.a("live_tab").i("openLiveRoom,handle enter live tab,source:" + r2.getSwitchLiveTabSource());
        return true;
    L11:
        r6 = null;
    L16:
        if (r2.getSwitchLiveTabSource() != SwitchLiveTabSource.CLICK_LIVE_PREVIEW) goto L18;
        r4.invoke();
        goto L18
    }
}
