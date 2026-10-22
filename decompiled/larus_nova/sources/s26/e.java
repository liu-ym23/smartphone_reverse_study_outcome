package s26;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, q26.c> f540310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f540311b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConcurrentHashMap<String, q26.c> f540312a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f540313b;

        public a() {
            this.f540312a = new ConcurrentHashMap();
            this.f540313b = "default_bid";
        }
    }

    public e() {
        this.f540310a = new ConcurrentHashMap();
    }

    public e(a r100) {
        this();
        this.f540311b = r100.f540313b;
        this.f540310a.putAll(r100.f540312a);
    }

    public final void a(String r100, q26.c r101) {
        Intrinsics.checkNotNullParameter(r100, "clazzName");
        Intrinsics.checkNotNullParameter(r101, "serviceInst");
        q26.c r102 = this.f540310a.get(r100);
        if (r102 == null) goto L5;
        r102.onUnRegister();
    L5:
        String r103 = this.f540311b;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bid");
        r103 = null;
    L8:
        r101.onRegister(r103);
        this.f540310a.put(r100, r101);
    }
}
