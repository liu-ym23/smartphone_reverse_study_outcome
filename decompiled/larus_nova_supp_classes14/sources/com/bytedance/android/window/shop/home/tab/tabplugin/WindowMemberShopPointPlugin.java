package com.bytedance.android.window.shop.home.tab.tabplugin;

import android.content.Context;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowMemberShopPointPlugin extends ECWindowJsbPlugin {
    public final Lazy b;
    public final List<String> c;
    public final Set<String> d;
    public final Set<String> e;
    public final Context f;
    public final ECWindowViewModel g;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin
    public final List<c> c() {
        return CollectionsKt.listOf(new c("IESLiveKit_ecom_pendant_close_event", new WindowMemberShopPointPlugin$createJsbActions$1(this)));
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin
    public final void e() {
        Map<String, Object> r0 = this.g.getShopParam().getQueryParams();
        if (r0 != null) goto L5;
        return;
    L5:
        IEShoppingService r1 = (IEShoppingService) this.b.getValue();
        if (r1 != null) goto L8;
        return;
    L8:
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator<T> r3 = this.d.iterator();
    L9:
        Object r5 = "";
        if (r3.hasNext() == false) goto L16;
        Object r4 = r3.next();
        Object r6 = r0.get((String) r4);
        if (r6 == null) goto L15;
        r5 = r6;
    L15:
        r2.put(r4, r5);
        goto L9
    L16:
        Iterator<T> r7 = this.e.iterator();
    L17:
        JSONObject r8 = null;
        if (r7.hasNext() == false) goto L31;
        Object r9 = r7.next();
        Object r10 = r0.get((String) r9);
        if ((r10 instanceof String) == true) goto L22;
        r10 = null;
    L22:
        String r11 = (String) r10;
        if (r11 != null) goto L33;
        r11 = "";
    L33:
        r8 = new JSONObject(r11);     // Catch: Exception -> L27
    L28:
        if (r8 != null) goto L30;
        r8 = new JSONObject();
    L30:
        r2.put(r9, r8);
        goto L17
    L31:
        r2.put("log_extra", MapsKt.mapOf(new Pair[]{TuplesKt.to("page_name", "store_page"), TuplesKt.to("source_page", this.g.getShopParam().getEntranceLocation()), TuplesKt.to("author_id", this.g.getShopParam().getAuthorId())}));
        ((ArrayList) this.c).add(r1.showTaskBanner(this.f, r2, null));
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin
    public final void f() {
        Iterator r0 = ((ArrayList) this.c).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        String r1 = (String) r0.next();
        IEShoppingService r2 = (IEShoppingService) this.b.getValue();
        if (r2 == null) goto L4;
        r2.hideTaskBanner(r1);
        goto L4
    }

    public WindowMemberShopPointPlugin(Context r2, ECWindowViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        this.f = r2;
        this.g = r3;
        this.b = LazyKt.lazy(WindowMemberShopPointPlugin$shoppingService$2.INSTANCE);
        this.c = new ArrayList();
        this.d = SetsKt.setOf(new String[]{"task_enter_from", "task_type"});
        this.e = SetsKt.setOf(new String[]{"frame", "task_request_params", "extra"});
    }
}
