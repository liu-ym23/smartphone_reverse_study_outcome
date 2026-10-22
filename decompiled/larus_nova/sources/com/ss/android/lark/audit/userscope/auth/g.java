package com.ss.android.lark.audit.userscope.auth;

import com.ss.android.lark.log.Log;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes34.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g<T> f409546a = null;

    static {
        f409546a = new g();
    }

    public g() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Log.e("AuditPerm_DataService", "pullPermissionData error. " + ((Throwable) r100).getMessage());
    }
}
