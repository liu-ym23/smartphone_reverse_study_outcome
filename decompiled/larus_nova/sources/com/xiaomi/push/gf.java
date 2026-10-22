package com.xiaomi.push;

import com.alibaba.gaiax.model.GXAnimation;

/* JADX INFO: loaded from: classes41.dex */
public final enum gf extends Enum<gf> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final gf f463672a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final /* synthetic */ gf[] f614a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final gf f463673b = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final int f615a;

    static {
        gf r100 = new gf(GXAnimation.STATE_START, 0, 0);
        f463672a = r100;
        gf r101 = new gf("BIND", 1, 1);
        f463673b = r101;
        f614a = new gf[]{r100, r101};
    }

    public static gf[] values() {
        return (gf[]) f614a.clone();
    }

    public int a() {
        return this.f615a;
    }

    public static gf valueOf(String r100) {
        return (gf) r27.a.a(gf.class, r100);
    }

    private gf(String r100, int r101, int r102) {
        super(r100, r101);
        this.f615a = r102;
    }
}
