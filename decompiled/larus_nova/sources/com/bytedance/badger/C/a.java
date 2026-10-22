package com.bytedance.badger.C;

/* JADX INFO: loaded from: classes3.dex */
public final enum a extends Enum {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f199018b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f199019c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f199020d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f199021e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f199022a;

    static {
        f199018b = new a("NOT_COMPENSATE", 0, 0);
        f199019c = new a("NON_FOREGROUND_COMPENSATE", 1, 1);
        f199020d = new a("NO_NET_COMPENSATE", 2, 2);
        f199021e = new a("NO_DEVICE_FP1", 3, 3);
    }

    public a(String r100, int r101, int r102) {
        super(r100, r101);
        this.f199022a = r102;
    }

    public int a() {
        return this.f199022a;
    }
}
