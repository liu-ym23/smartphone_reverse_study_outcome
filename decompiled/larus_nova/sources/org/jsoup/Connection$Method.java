package org.jsoup;

import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum Connection$Method extends Enum<Connection$Method> {
    public static final Connection$Method DELETE = null;
    public static final Connection$Method GET = null;
    public static final Connection$Method HEAD = null;
    public static final Connection$Method OPTIONS = null;
    public static final Connection$Method PATCH = null;
    public static final Connection$Method POST = null;
    public static final Connection$Method PUT = null;
    public static final Connection$Method TRACE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Connection$Method[] f525889a = null;
    private final boolean hasBody;

    static {
        Connection$Method r100 = new Connection$Method("GET", 0, false);
        GET = r100;
        Connection$Method r101 = new Connection$Method("POST", 1, true);
        POST = r101;
        Connection$Method r102 = new Connection$Method("PUT", 2, true);
        PUT = r102;
        Connection$Method r103 = new Connection$Method("DELETE", 3, false);
        DELETE = r103;
        Connection$Method r104 = new Connection$Method("PATCH", 4, true);
        PATCH = r104;
        Connection$Method r105 = new Connection$Method("HEAD", 5, false);
        HEAD = r105;
        Connection$Method r110 = new Connection$Method("OPTIONS", 6, false);
        OPTIONS = r110;
        Connection$Method r111 = new Connection$Method("TRACE", 7, false);
        TRACE = r111;
        f525889a = new Connection$Method[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static Connection$Method[] values() {
        return (Connection$Method[]) f525889a.clone();
    }

    public final boolean hasBody() {
        return this.hasBody;
    }

    public static Connection$Method valueOf(String r100) {
        return (Connection$Method) a.a(Connection$Method.class, r100);
    }

    public Connection$Method(String r100, int r101, boolean r102) {
        super(r100, r101);
        this.hasBody = r102;
    }
}
