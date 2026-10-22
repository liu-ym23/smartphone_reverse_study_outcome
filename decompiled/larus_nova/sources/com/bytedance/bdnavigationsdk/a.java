package com.bytedance.bdnavigationsdk;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f199985a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Context f199986b;

    static {
        f199985a = new a();
    }

    public a() {
    }

    public final Context getContext() {
        if (f199986b == null) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L10;
        Context r101 = f199986b;
        Intrinsics.checkNotNull(r101);
        return r101;
    L10:
        throw new IllegalStateException("BDNAAppContext 没有初始化".toString());
    L5:
        r100 = false;
        goto L6
    }
}
