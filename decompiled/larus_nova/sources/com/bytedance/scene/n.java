package com.bytedance.scene;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes19.dex */
public final class n {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f268740e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicInteger f268741f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f268742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f268743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, n> f268744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Object, Object> f268745d;

    public static class a implements b {
        public a() {
        }

        @Override // com.bytedance.scene.n.b
        public final n N80() {
            return new n(null, "Scene #" + n.f268741f.getAndIncrement());
        }
    }

    public interface b {
        n N80();
    }

    public interface c {
        void onUnRegister();
    }

    static {
        f268740e = new a();
        f268741f = new AtomicInteger(0);
    }

    public final <T> T a(Object r100) {
        T r101 = (T) ((HashMap) this.f268745d).get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        n r102 = this.f268742a;
        if (r102 != null) goto L8;
        return null;
    L8:
        return (T) r102.a(r100);
    }

    public n(n r100, String r101) {
        this.f268744c = new HashMap();
        this.f268745d = new HashMap();
        this.f268742a = r100;
        this.f268743b = r101;
    }
}
