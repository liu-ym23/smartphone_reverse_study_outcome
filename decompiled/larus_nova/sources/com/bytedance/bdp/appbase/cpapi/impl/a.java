package com.bytedance.bdp.appbase.cpapi.impl;

import com.bytedance.bdp.appbase.context.BdpAppContext;
import com.bytedance.bdp.appbase.cpapi.contextservice.base.b;
import com.bytedance.bdp.appbase.cpapi.impl.common.prehandler.c;
import com.bytedance.bdp.appbase.cpapi.impl.common.prehandler.d;
import com.bytedance.bdp.appbase.cpapi.impl.common.prehandler.e;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BdpAppContext f200783a;

    @Override // com.bytedance.bdp.appbase.cpapi.contextservice.base.b, com.bytedance.bdp.appbase.cpapi.contextservice.base.c
    public String getType() {
        return "CP_API";
    }

    @Override // com.bytedance.bdp.appbase.cpapi.contextservice.base.b
    public final BdpAppContext getAppContext() {
        return this.f200783a;
    }

    public a(BdpAppContext r100) {
        this.f200783a = r100;
        new c(this);
        new e(this);
        new d(this);
        new com.bytedance.bdp.appbase.cpapi.impl.common.prehandler.b(this);
        new com.bytedance.bdp.appbase.cpapi.impl.common.prehandler.a(this);
    }
}
