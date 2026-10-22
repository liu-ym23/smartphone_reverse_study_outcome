package com.bytedance.android.window.shop.home.presenter.plugin;

import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.window.shop.home.tab.presenter.ECWindowLynxMonitorHolder;
import com.bytedance.android.window.shop.home.tab.presenter.c0;
import com.bytedance.android.window.shop.home.tab.tabplugin.e;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.widget.ECShopRecyclerView;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import yn.d;
import yn.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowSoundChangedNotifierPlugin implements e, o {
    public final Lazy a;
    public final Lazy b;
    public final ECWindowViewModel c;
    public final ECHybridListEngine d;
    public final ECShopRecyclerView e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.e
    public final void a() {
        d r0 = this.c.getLiveManager();
        r0.getClass();
        Intrinsics.checkNotNullParameter(this, "callback");
        r0.l.add(this);
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.e
    public final void b() {
        d r0 = this.c.getLiveManager();
        r0.getClass();
        Intrinsics.checkNotNullParameter(this, "callback");
        r0.l.remove(this);
    }

    public final void c(boolean r6) {
        ECHybridListEngine r0 = this.d;
        if (r0 == null) goto L7;
        ECHybridRecyclerView r1 = r0.b;
        if (r1 == null) goto L7;
        List<ECWindowLynxMonitorHolder> r2 = c0.d(r1);
    L9:
        if (r2 == null) goto L20;
        Iterator<T> r3 = r2.iterator();
    L12:
        if (r3.hasNext() == false) goto L20;
        ECWindowLynxMonitorHolder r4 = (ECWindowLynxMonitorHolder) r3.next();
        if (r6 == false) goto L16;
        JSONObject r5 = (JSONObject) this.a.getValue();
    L17:
        r4.getClass();
        Intrinsics.checkNotNullParameter("ecom.window.video.sound_status", "eventName");
        ECLynxCard r7 = ((ECLynxCardHolder) r4).t;
        if (r7 == null) goto L12;
        r7.o("ecom.window.video.sound_status", r5);
        goto L12
    L16:
        r5 = (JSONObject) this.b.getValue();
    L20:
        ECShopRecyclerView r8 = this.e;
        if (r8 == null) goto L32;
        List<ECLynxCard> r9 = c0.e(r8);
        if (r9 == null) goto L41;
        Iterator<T> r10 = r9.iterator();
    L26:
        if (r10.hasNext() == false) goto L42;
        ECLynxCard r11 = (ECLynxCard) r10.next();
        if (r6 == false) goto L30;
        Object r12 = this.a.getValue();
    L31:
        r11.o("ecom.window.video.sound_status", (JSONObject) r12);
        goto L26
    L30:
        r12 = this.b.getValue();
        goto L31
    L42:
        return;
    L41:
        return;
    L32:
        return;
    L7:
        r2 = null;
        goto L9
    }

    public ECWindowSoundChangedNotifierPlugin(ECWindowViewModel r2, ECHybridListEngine r3, ECShopRecyclerView r4) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.a = LazyKt.lazy(new ECWindowSoundChangedNotifierPlugin$muteJson$2(this));
        this.b = LazyKt.lazy(new ECWindowSoundChangedNotifierPlugin$unMuteJson$2(this));
    }
}
