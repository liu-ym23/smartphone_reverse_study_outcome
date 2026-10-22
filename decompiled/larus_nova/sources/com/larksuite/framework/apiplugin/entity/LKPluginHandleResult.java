package com.larksuite.framework.apiplugin.entity;

/* JADX INFO: loaded from: classes24.dex */
public class LKPluginHandleResult extends LKBasePluginResult {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final LKPluginHandleResult f285532g = null;

    public static class a extends LKBasePluginResult.b<a> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f285533e;

        public a() {
            this.f285533e = false;
        }
    }

    static {
        f285532g = new LKPluginHandleResult(new a());
    }

    public LKPluginHandleResult(a r100) {
        super(r100.f285533e, r100.f285525a, r100.f285526b, r100.f285527c, r100.f285528d);
    }
}
