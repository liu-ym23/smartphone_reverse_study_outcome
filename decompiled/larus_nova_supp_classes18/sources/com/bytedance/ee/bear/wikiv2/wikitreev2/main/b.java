package com.bytedance.ee.bear.wikiv2.wikitreev2.main;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public final Fragment a;
    public final Context b;
    public final String c;
    public final String d;
    public final String e;
    public final boolean f;
    public final String g;
    public final WikNodePerm h;
    public final int i;
    public final Bundle j;
    public final boolean k;
    public final boolean l;
    public final String m;
    public final int n;

    public final Context getContext() {
        return this.b;
    }

    public b(Fragment r2, Context r3, String r4, String r5, String r6, boolean r7, String r8, WikNodePerm r9, int r10, Bundle r11, boolean r12, boolean r13, String r14, int r15) {
        Intrinsics.checkNotNullParameter(r6, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r14, "objToken");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
        this.m = r14;
        this.n = r15;
    }
}
