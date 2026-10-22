package com.larus.xbridge.custom;

import com.ivy.ivykit.api.bridge.core.IvyBridgeMethod;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class s implements tj9.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IvyBridgeMethod.a f379787a;

    @Override // tj9.c
    public final void a() {
        IvyBridgeMethod.a r100 = this.f379787a;
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("code", 0);
        r100.invoke(r101);
    }

    @Override // tj9.c
    public final void b() {
        IvyBridgeMethod.a r100 = this.f379787a;
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("code", 1);
        r100.invoke(r101);
    }

    public s(ux7.d.C7943d r100) {
        this.f379787a = r100;
    }
}
