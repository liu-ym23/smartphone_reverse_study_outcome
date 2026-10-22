package com.ss.android.lark.appsetting.api.service;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.appsetting.api.e;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public final class c implements yva.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ yva.a f408952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f408953b;

    @Override // yva.a
    public final void onError(ErrorResult r100) {
        yva.a r101 = this.f408952a;
        if (r101 == null) goto L5;
        r101.onError(r100);
    L5:
        Iterator<d.b> r102 = this.f408953b.f408955b.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        r102.next().onError(r100);
        goto L7
    }

    public c(d r100, opb.d r101) {
        this.f408953b = r100;
        this.f408952a = r101;
    }

    @Override // yva.a
    public final void a(Map<String, String> r100, boolean r101) {
        yva.a r102 = this.f408952a;
        if (r102 == null) goto L5;
        r102.a(r100, r101);
    L5:
        e.a.f408951a.e(r100, r101, "");
        Iterator<d.b> r103 = this.f408953b.f408955b.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        r103.next().a();
        goto L7
    }
}
