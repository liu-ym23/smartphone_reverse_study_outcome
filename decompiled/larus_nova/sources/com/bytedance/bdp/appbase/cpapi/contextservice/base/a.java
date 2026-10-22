package com.bytedance.bdp.appbase.cpapi.contextservice.base;

import com.bytedance.bdp.appbase.context.BdpAppContext;

/* JADX INFO: loaded from: classes11.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BdpAppContext f200781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f200782b;

    /* JADX INFO: renamed from: com.bytedance.bdp.appbase.cpapi.contextservice.base.a$a, reason: collision with other inner class name */
    public static final class C2893a {
    }

    static {
    }

    public final BdpAppContext getContext() {
        return this.f200781a;
    }

    public a(b r100) {
        this.f200782b = r100;
        this.f200781a = r100.getAppContext();
    }
}
