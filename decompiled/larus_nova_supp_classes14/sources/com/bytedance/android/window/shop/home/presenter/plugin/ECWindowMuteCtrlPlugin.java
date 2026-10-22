package com.bytedance.android.window.shop.home.presenter.plugin;

import com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin;
import com.bytedance.android.window.shop.home.tab.tabplugin.c;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowMuteCtrlPlugin extends ECWindowJsbPlugin {
    public final ECWindowViewModel b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin
    public final List<c> c() {
        return CollectionsKt.listOf(new c("ecom.window.video.mute.event", new ECWindowMuteCtrlPlugin$createJsbActions$1(this)));
    }

    public ECWindowMuteCtrlPlugin(ECWindowViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        this.b = r2;
    }
}
