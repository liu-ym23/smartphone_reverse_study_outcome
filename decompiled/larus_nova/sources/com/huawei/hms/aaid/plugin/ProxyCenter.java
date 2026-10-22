package com.huawei.hms.aaid.plugin;

/* JADX INFO: loaded from: classes23.dex */
public class ProxyCenter {
    private PushProxy proxy;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static ProxyCenter f276832a;

        static {
            f276832a = new ProxyCenter();
        }

        public static /* synthetic */ ProxyCenter a() {
            return f276832a;
        }
    }

    public ProxyCenter() {
    }

    private static ProxyCenter getInstance() {
        return a.a();
    }

    public static PushProxy getProxy() {
        return getInstance().proxy;
    }

    public static void register(PushProxy r100) {
        getInstance().proxy = r100;
    }
}
