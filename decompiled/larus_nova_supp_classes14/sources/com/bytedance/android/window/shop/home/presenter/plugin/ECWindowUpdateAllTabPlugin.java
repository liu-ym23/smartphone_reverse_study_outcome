package com.bytedance.android.window.shop.home.presenter.plugin;

import com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin;
import com.bytedance.android.window.shop.home.tab.tabplugin.c;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowUpdateAllTabPlugin extends ECWindowJsbPlugin {
    public static final /* synthetic */ int c = 0;
    public final Function0<String> b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin
    public final List<c> c() {
        return CollectionsKt.listOf(new c("ecom.window.refresh_all_tab", new ECWindowUpdateAllTabPlugin$createJsbActions$1(this)));
    }

    public ECWindowUpdateAllTabPlugin(Function0<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "getSecAuthorId");
        this.b = r2;
    }
}
