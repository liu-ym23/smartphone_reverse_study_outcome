package com.bytedance.ee.bear.wikiv2.wikitreev2;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f241442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f241443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f241444c;

    public f(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "spaceId");
        Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.WIKI_TOKEN);
        this.f241442a = r100;
        this.f241443b = r101;
        this.f241444c = r102;
    }
}
