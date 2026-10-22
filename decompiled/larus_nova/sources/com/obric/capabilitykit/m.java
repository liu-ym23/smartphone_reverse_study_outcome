package com.obric.capabilitykit;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/obric/capabilitykit/entity/ActionType;", "", "", "action", "Ljava/lang/String;", "getAction", "()Ljava/lang/String;", "Companion", "capabilitykit_release"}, k = 1, mv = {1, 7, 1})
public final enum m extends Enum<m> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f396254b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m f396255c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m f396256d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ m[] f396257e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f396258a;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a {
        public a() {
        }
    }

    static {
        m r100 = new m("INDEX", 0, "index");
        f396255c = r100;
        m r101 = new m("DELETE", 1, "delete");
        f396256d = r101;
        f396257e = new m[]{r100, r101};
        f396254b = new a();
    }

    public m(String r100, int r101, String r102) {
        super(r100, r101);
        this.f396258a = r102;
    }

    public static m valueOf(String r100) {
        return (m) r27.a.a(m.class, r100);
    }

    public static m[] values() {
        return (m[]) f396257e.clone();
    }

    public final String b() {
        return this.f396258a;
    }
}
