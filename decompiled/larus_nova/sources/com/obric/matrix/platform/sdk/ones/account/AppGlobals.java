package com.obric.matrix.platform.sdk.ones.account;

import android.app.Application;
import android.content.Context;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes5.dex */
public final class AppGlobals {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f396899a = null;

    static {
        f396899a = LazyKt.lazy(AppGlobals$app$2.INSTANCE);
    }

    public static Context a() {
        return ((Application) f396899a.getValue()).getApplicationContext();
    }
}
