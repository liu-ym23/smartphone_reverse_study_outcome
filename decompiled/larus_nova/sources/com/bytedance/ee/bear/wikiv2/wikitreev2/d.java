package com.bytedance.ee.bear.wikiv2.wikitreev2;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f241439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f241440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f241441c;

    public d(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "spaceId");
        Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.WIKI_TOKEN);
        this.f241439a = r100;
        this.f241440b = r101;
        this.f241441c = r102;
    }
}
