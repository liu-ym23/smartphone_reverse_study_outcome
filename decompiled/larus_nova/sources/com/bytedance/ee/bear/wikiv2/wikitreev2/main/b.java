package com.bytedance.ee.bear.wikiv2.wikitreev2.main;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f241524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f241525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f241526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f241527d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f241528e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f241529f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f241530g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final WikNodePerm f241531h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f241532i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Bundle f241533j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f241534k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f241535l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f241536m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f241537n;

    public final Context getContext() {
        return this.f241525b;
    }

    public b(Fragment r100, Context r101, String r102, String r103, String r104, boolean r105, String r106, WikNodePerm r107, int r110, Bundle r111, boolean r112, boolean r113, String r114, int r115) {
        Intrinsics.checkNotNullParameter(r104, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r114, "objToken");
        this.f241524a = r100;
        this.f241525b = r101;
        this.f241526c = r102;
        this.f241527d = r103;
        this.f241528e = r104;
        this.f241529f = r105;
        this.f241530g = r106;
        this.f241531h = r107;
        this.f241532i = r110;
        this.f241533j = r111;
        this.f241534k = r112;
        this.f241535l = r113;
        this.f241536m = r114;
        this.f241537n = r115;
    }
}
