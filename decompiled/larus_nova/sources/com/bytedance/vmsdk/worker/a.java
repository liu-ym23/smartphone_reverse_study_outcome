package com.bytedance.vmsdk.worker;

import com.bytedance.vmsdk.jsbridge.JSModuleManager;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JsWorker.EngineType f272521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f272522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f272523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f272524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f272525e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final JSModuleManager f272526f;

    /* JADX INFO: renamed from: com.bytedance.vmsdk.worker.a$a, reason: collision with other inner class name */
    public static final class C3813a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public JsWorker.EngineType f272527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f272528b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f272529c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f272530d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f272531e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public JSModuleManager f272532f;

        public C3813a() {
            this.f272527a = JsWorker.EngineType.QUICKJS;
            this.f272528b = JsWorker.DEFAULT_BIZ_NAME;
            this.f272529c = null;
            this.f272530d = false;
            this.f272531e = false;
            this.f272532f = null;
        }
    }

    public a(C3813a r100) {
        this.f272521a = r100.f272527a;
        this.f272522b = r100.f272528b;
        this.f272523c = r100.f272529c;
        this.f272525e = r100.f272530d;
        this.f272524d = r100.f272531e;
        this.f272526f = r100.f272532f;
    }
}
