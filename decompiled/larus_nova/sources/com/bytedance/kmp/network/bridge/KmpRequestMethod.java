package com.bytedance.kmp.network.bridge;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/kmp/network/bridge/KmpRequestMethod;", "", "", "typeName", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "GET", "POST", "HEAD", "PUT", "DELETE", "PATCH", "OPTIONS", "network_service_release"}, k = 1, mv = {1, 7, 0})
public final enum KmpRequestMethod extends Enum<KmpRequestMethod> {
    public static final KmpRequestMethod DELETE = null;
    public static final KmpRequestMethod GET = null;
    public static final KmpRequestMethod HEAD = null;
    public static final KmpRequestMethod OPTIONS = null;
    public static final KmpRequestMethod PATCH = null;
    public static final KmpRequestMethod POST = null;
    public static final KmpRequestMethod PUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KmpRequestMethod[] f252484a = null;
    private final String typeName;

    public static KmpRequestMethod valueOf(String r100) {
        return (KmpRequestMethod) r27.a.a(KmpRequestMethod.class, r100);
    }

    public static KmpRequestMethod[] values() {
        return (KmpRequestMethod[]) f252484a.clone();
    }

    static {
        KmpRequestMethod r100 = new KmpRequestMethod("GET", 0, "GET");
        GET = r100;
        KmpRequestMethod r101 = new KmpRequestMethod("POST", 1, "POST");
        POST = r101;
        KmpRequestMethod r102 = new KmpRequestMethod("HEAD", 2, "HEAD");
        HEAD = r102;
        KmpRequestMethod r103 = new KmpRequestMethod("PUT", 3, "PUT");
        PUT = r103;
        KmpRequestMethod r104 = new KmpRequestMethod("DELETE", 4, "DELETE");
        DELETE = r104;
        KmpRequestMethod r105 = new KmpRequestMethod("PATCH", 5, "PATCH");
        PATCH = r105;
        KmpRequestMethod r110 = new KmpRequestMethod("OPTIONS", 6, "OPTIONS");
        OPTIONS = r110;
        f252484a = new KmpRequestMethod[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public KmpRequestMethod(String r100, int r101, String r102) {
        super(r100, r101);
        this.typeName = r102;
    }
}
