package com.bytedance.android.window.shop.home.presenter.plugin;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.android.ttcjpaysdk.base.ktextension.SharedPrefExtKt;
import com.bytedance.android.ec.window.base.shop.ECWindowBubblePrompt;
import com.bytedance.android.ec.window.base.shop.WindowFansClubBubbleConfig;
import com.bytedance.android.ec.window.base.shop.WindowFansClubInfo;
import com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin;
import com.bytedance.android.window.shop.home.tab.tabplugin.c;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.ies.utility.SharedPrefHelper;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowFansClubPlugin extends ECWindowJsbPlugin {
    public static final List<String> i = null;
    public final Lazy b;
    public boolean c;
    public long d;
    public final Activity e;
    public final ECWindowViewModel f;
    public final Function1<Boolean, Unit> g;
    public final View h;

    public static final class a {
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin
    public final List<c> c() {
        return CollectionsKt.listOf(new c[]{new c("ecom.coupon.component_close", new ECWindowFansClubPlugin$createJsbActions$1(this)), new c("ecom.window.redpacket_open", new ECWindowFansClubPlugin$createJsbActions$2(this))});
    }

    static {
        i = CollectionsKt.listOf("redpacket_batch_id");
    }

    public final void i() {
        if (this.c == false) goto L5;
        return;
    L5:
        this.g.invoke(Boolean.TRUE);
    }

    public final void h() {
        if ((System.currentTimeMillis() - this.d) >= 3000) goto L5;
        return;
    L5:
        this.d = System.currentTimeMillis();
        if (((SharedPrefHelper) this.b.getValue()).f("window_join_fans_club_prompt_shown", false) == false) goto L8;
        i();
        return;
    L8:
        SharedPrefExtKt.edit(((SharedPrefHelper) this.b.getValue()).a, ECWindowFansClubPlugin$showFollowedJoinFansClubPrompt$1.INSTANCE);
        final WindowFansClubBubbleConfig r0 = new WindowFansClubBubbleConfig("#FF393B44", "#FFFFFFFF", "加购物粉丝团领红包", null, null, null, null, 120, null);
        ECWindowBubblePrompt r1 = new ECWindowBubblePrompt(this.e);
        WindowFansClubInfo r2 = this.f.getShopParam().getFansClubInfo();
        if (r2 == null) goto L11;
        String r3 = r2.getFansClubUrl();
    L12:
        r1.b(r3, r0, this.h, new ECWindowFansClubPlugin$showPrompt$$inlined$also$lambda$1(this, r0));
        r1.a(this.h);
        return;
    L11:
        r3 = null;
        goto L12
    }

    public ECWindowFansClubPlugin(FragmentActivity r2, ECWindowViewModel r3, Function1 r4, View r5) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        Intrinsics.checkNotNullParameter(r4, "viewVisibilitySwitch");
        Intrinsics.checkNotNullParameter(r5, "target");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.b = LazyKt.lazy(new ECWindowFansClubPlugin$pref$2(this));
    }
}
