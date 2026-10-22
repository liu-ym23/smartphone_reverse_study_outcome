package com.bytedance.ee.bear.wikiv2.browser.plugin;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class v0 extends sa5.e {
    public static final /* synthetic */ int b = 0;
    public WikiViewModel a;

    public static final class a {
    }

    static {
    }

    public v0(Fragment r2, final Fragment r3, final ce5.a r4) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "viewModelStoreOwner");
        Intrinsics.checkNotNullParameter(r4, "userComponentAbility");
        r2.getLifecycle().addObserver(new WikiTreeMenuExtensionV2$1(this, r3, r4));
    }
}
