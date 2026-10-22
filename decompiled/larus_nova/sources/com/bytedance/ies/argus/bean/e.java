package com.bytedance.ies.argus.bean;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f246019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f246020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f246021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f246022d;

    public static final class a {
    }

    static {
    }

    public e(Integer r100) {
        this.f246019a = r100;
        boolean r101 = false;
        if (r100 != null) goto L6;
    L7:
        if (r100 != null) goto L10;
    L12:
        boolean r102 = false;
    L14:
        this.f246020b = r102;
        if (r100 != null) goto L18;
    L20:
        boolean r103 = false;
    L21:
        this.f246021c = r103;
        if (r100 != null) goto L25;
    L27:
        this.f246022d = r101;
        return;
    L25:
        if (r100.intValue() != 1) goto L27;
        r101 = true;
        goto L27
    L18:
        if (r100.intValue() != 2) goto L20;
        r103 = true;
        goto L21
    L10:
        if (r100.intValue() != 1) goto L12;
    L13:
        r102 = true;
        goto L14
    L6:
        if (r100.intValue() == 2) goto L13;
        goto L7
    }
}
