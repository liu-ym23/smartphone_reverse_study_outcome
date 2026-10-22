package com.bytedance.ee.bear.wikiv2.wikitreev2;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public final String a;
    public final String b;
    public final boolean c;

    public b(String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "spaceId");
        Intrinsics.checkNotNullParameter(r3, WikiFolderPushPlugin.WIKI_TOKEN);
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
