package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.hover;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.ECLiveCardPanelType;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import uk2.a;
import uk2.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECExplainCardLiveDialogHoverManager implements b {
    public final List<String> a;
    public final List<String> b;
    public final Set<a> c;
    public final ECExplainCardLiveDialogHoverManager$fragmentLifecycleCallback$1 d;
    public final FragmentManager e;

    @Override // uk2.b
    public final void clear() {
        dm.a.a("LiveHover").i("Clear fragmentLifecycleCallback");
        FragmentManager r0 = this.e;
        if (r0 == null) goto L5;
        r0.unregisterFragmentLifecycleCallbacks(this.d);
    L5:
        ((ArrayList) this.b).clear();
        this.c.clear();
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks, com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.hover.ECExplainCardLiveDialogHoverManager$fragmentLifecycleCallback$1] */
    public ECExplainCardLiveDialogHoverManager(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        ECLiveABUtils r0 = ECLiveABUtils.INSTANCE;
        if ((!r0.getEC_LIVE_CARD_ADAPTATION_WHITE_LIST().isEmpty()) == false) goto L5;
        List<String> r1 = r0.getEC_LIVE_CARD_ADAPTATION_WHITE_LIST();
    L6:
        this.a = r1;
        this.b = new ArrayList();
        this.c = new LinkedHashSet();
        ?? r2 = new ECExplainCardLiveDialogHoverManager$fragmentLifecycleCallback$1(this);
        this.d = r2;
        FragmentManager r3 = null;
        if ((r10 instanceof FragmentActivity) == true) goto L9;
        r10 = null;
    L9:
        FragmentActivity r11 = (FragmentActivity) r10;
        if (r11 == null) goto L12;
        r3 = r11.getSupportFragmentManager();
    L12:
        this.e = r3;
        dm.a.a("LiveHover").i("Register fragmentLifecycleCallback");
        if (r3 == null) goto L16;
        r3.registerFragmentLifecycleCallbacks(r2, false);
        return;
    L16:
        return;
    L5:
        r1 = CollectionsKt.listOf(new String[]{"NewLiveProfileDialogFragment", "AnchorV4Fragment", "LivePromotionListFragment", "SkuFragment", "SkuPanelOptimizeFragment", "SkuYataFragment", "BuyNowFragment", "BuyNowHalfScreenDialogFragment"});
        goto L6
    }

    public static final ECLiveCardPanelType a(ECExplainCardLiveDialogHoverManager r0, Fragment r1) {
        r0.getClass();
        String r2 = Reflection.getOrCreateKotlinClass(r1.getClass()).getSimpleName();
        if (r2 == null) goto L27;
        switch(r2.hashCode()) {
            case -1807828061: goto L24;
            case -1253443897: goto L21;
            case -1227194112: goto L18;
            case -979616147: goto L15;
            case -686543500: goto L12;
            case 601195138: goto L9;
            default: goto L27;
        };
    L9:
        if (r2.equals("SkuYataFragment") == false) goto L27;
    L28:
        return ECLiveCardPanelType.SKU;
    L12:
        if (r2.equals("SkuPanelOptimizeFragment") == false) goto L27;
    L15:
        if (r2.equals("SkuFragment") == false) goto L27;
    L18:
        if (r2.equals("BuyNowFragment") == false) goto L27;
    L29:
        return ECLiveCardPanelType.ORDER;
    L21:
        if (r2.equals("BuyNowHalfScreenDialogFragment") == false) goto L27;
    L24:
        if (r2.equals("AnchorV4Fragment") == false) goto L27;
        return ECLiveCardPanelType.GOODS_DETAIL;
    L27:
        return ECLiveCardPanelType.OTHERS;
    }

    public static final String b(ECExplainCardLiveDialogHoverManager r1, Fragment r2) {
        r1.getClass();
        return Reflection.getOrCreateKotlinClass(r2.getClass()).getSimpleName() + '@' + r2.hashCode();
    }
}
