package com.bytedance.android.window.shop.home.tab.tabplugin.subtabs;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin;
import com.bytedance.android.window.shop.home.tab.tabplugin.c;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowReceiveExitJsbPlugin extends ECWindowJsbPlugin {
    public final String b;
    public final Activity c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin
    public final List<c> c() {
        return CollectionsKt.listOf(new c("ecom.window.close_window", new ECWindowReceiveExitJsbPlugin$createJsbActions$1(this)));
    }

    public ECWindowReceiveExitJsbPlugin(String r2, FragmentActivity r3) {
        Intrinsics.checkNotNullParameter(r2, "secAuthorId");
        Intrinsics.checkNotNullParameter(r3, "activity");
        this.b = r2;
        this.c = r3;
    }
}
