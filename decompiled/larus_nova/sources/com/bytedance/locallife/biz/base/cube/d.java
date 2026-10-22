package com.bytedance.locallife.biz.base.cube;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class d implements fp6.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f256534a = null;

    static {
        f256534a = new d();
    }

    public d() {
    }

    public final Application a() {
        Context r100 = HostServiceUtilsKt.E().getApplicationContext();
        if ((r100 instanceof Application) == true) goto L7;
        return null;
    L7:
        return (Application) r100;
    }

    public final Activity b() {
        return HostServiceUtilsKt.E().getCurrentActivity();
    }
}
