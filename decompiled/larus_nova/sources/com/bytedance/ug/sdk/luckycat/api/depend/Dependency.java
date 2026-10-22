package com.bytedance.ug.sdk.luckycat.api.depend;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ug/sdk/luckycat/api/depend/Dependency;", "", "DOG", "CAT", "LYNX", "luckycat_container_release"}, k = 1, mv = {1, 4, 0})
public final enum Dependency extends Enum<Dependency> {
    public static final Dependency CAT = null;
    public static final Dependency DOG = null;
    public static final Dependency LYNX = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Dependency[] f271066a = null;

    static {
        Dependency r100 = new Dependency("DOG", 0);
        DOG = r100;
        Dependency r101 = new Dependency("CAT", 1);
        CAT = r101;
        Dependency r102 = new Dependency("LYNX", 2);
        LYNX = r102;
        f271066a = new Dependency[]{r100, r101, r102};
    }

    public static Dependency valueOf(String r100) {
        return (Dependency) r27.a.a(Dependency.class, r100);
    }

    public static Dependency[] values() {
        return (Dependency[]) f271066a.clone();
    }

    public Dependency(String r100, int r101) {
        super(r100, r101);
    }
}
