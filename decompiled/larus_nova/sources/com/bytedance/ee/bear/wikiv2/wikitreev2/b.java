package com.bytedance.ee.bear.wikiv2.wikitreev2;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f241376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f241377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f241378c;

    public b(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "spaceId");
        Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.WIKI_TOKEN);
        this.f241376a = r100;
        this.f241377b = r101;
        this.f241378c = r102;
    }
}
