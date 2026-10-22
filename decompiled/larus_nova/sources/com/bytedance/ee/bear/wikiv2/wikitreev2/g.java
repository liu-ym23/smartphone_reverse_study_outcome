package com.bytedance.ee.bear.wikiv2.wikitreev2;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f241445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f241446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f241447c;

    public g(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "spaceId");
        Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r102, "title");
        this.f241445a = r100;
        this.f241446b = r101;
        this.f241447c = r102;
    }
}
