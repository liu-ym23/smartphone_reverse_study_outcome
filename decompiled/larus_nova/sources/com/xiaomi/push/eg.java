package com.xiaomi.push;

import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class eg implements ee {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ee f463435a;

    /* JADX INFO: renamed from: com.xiaomi.push.eg$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static eg f463436a;

        static {
            f463436a = new eg(null);
        }

        public static /* synthetic */ eg a() {
            return f463436a;
        }
    }

    public static eg a() {
        return a.a();
    }

    private eg() {
    }

    public /* synthetic */ eg(AnonymousClass1 r100) {
        this();
    }

    @Override // com.xiaomi.push.ee
    public void a(ed r100) {
        ee r101 = this.f463435a;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // com.xiaomi.push.ee
    public void a(String r100, Map<String, Object> r101) {
        ee r102 = this.f463435a;
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }
}
