package com.obric.matrix.push.common.cross_process;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.alipay.sdk.m.p.e;
import com.obric.matrix.sdk.push.cross_process.MessageServiceV2;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import jka.b;
import jka.c;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class CrossProcessService implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f397014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f397015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, ICrossProcessInterface> f397016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, ServiceConnection> f397017d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<String, b> f397018e;

    public CrossProcessService(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        this.f397014a = r100;
        this.f397015b = "CrossProcessService";
        this.f397016c = new ConcurrentHashMap();
        this.f397017d = new ConcurrentHashMap();
        this.f397018e = new ConcurrentHashMap();
    }

    public final void d(MessageServiceV2.a r100) {
        Intrinsics.checkNotNullParameter(r100, e.f25671s);
        kka.b.a(this.f397015b, "register cross process method: " + r100);
        this.f397018e.put(".action.MESSAGE_EVENT", r100);
    }

    public final void b(String r100, ArrayList r101, jka.a r102) {
        Intrinsics.checkNotNullParameter("com.obric.matrix", "targetPkg");
        Intrinsics.checkNotNullParameter(r100, e.f25671s);
        kka.b.a(this.f397015b, "try invoke " + r100 + " method");
        ICrossProcessInterface r103 = this.f397016c.get("com.obric.matrix");
        if (r103 == null) goto L5;
        kka.b.a(this.f397015b, "binder of  com.obric.matrix is not null , invoke internal");
        c(r103, r100, r101, r102);
        Unit r104 = Unit.INSTANCE;
    L6:
        if (r104 != null) goto L9;
        kka.b.a(this.f397015b, "binder of  com.obric.matrix is null , bind target service");
        a r105 = new a(this, r100, r101, r102);
        Intent r106 = new Intent();
        r106.setPackage("com.obric.matrix");
        r106.setAction("com.obric.matrix.action.CROSS_PROCESS");
        r106.putExtra("origin_package_name", this.f397014a.getPackageName());
        r106.putExtra("is_from_on_bind", false);
        kka.b.a(this.f397015b, "bind com.obric.matrix's CrossProcessService");
        this.f397014a.bindService(r106, r105, 1);
        return;
    L9:
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // jka.c
    public final void a(String r100, String r101, List<Object> r102, ICrossProcessCallbackInterface r103) {
        Intrinsics.checkNotNullParameter(r100, e.f25671s);
        Intrinsics.checkNotNullParameter(r101, "originPkgName");
        kka.b.a(this.f397015b, r100 + " be invoked");
        b r104 = this.f397018e.get(r100);
        if (r104 == null) goto L6;
        r104.a(r101, r102);
        return;
    }

    public final void c(ICrossProcessInterface r100, final String r101, ArrayList<Object> r102, final jka.a r103) {
        kka.b.a(this.f397015b, "invoke " + r101 + " method internal");
        r100.invoke(r101, this.f397014a.getPackageName(), r102, new CrossProcessService$invokeInternal$1(this, r101, r103));     // Catch: Exception -> L5
        return;
    L5:
        String r104 = this.f397015b;
        String r105 = "invoke " + r101 + " method internal error";
        Intrinsics.checkNotNullParameter(r104, "tag");
        Intrinsics.checkNotNullParameter(r105, "msg");
        String r106 = kka.b.c(r104, r105);
        Intrinsics.checkNotNullParameter("MATRIX_PUSH", "tag");
        Intrinsics.checkNotNullParameter(r106, "msg");
        if (r103 == null) goto L11;
        r103.onCallback(null);
        return;
    }
}
