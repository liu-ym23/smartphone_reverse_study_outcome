package com.bytedance.applog.map.api;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/applog/map/api/IdSource;", "", "", "toString", "Auto", "NxET", "BTM", "Custom", "map-api_release"}, k = 1, mv = {1, 6, 0})
public final enum IdSource extends Enum<IdSource> {
    public static final IdSource Auto = null;
    public static final IdSource BTM = null;
    public static final IdSource Custom = null;
    public static final IdSource NxET = null;
    public static final /* synthetic */ IdSource[] a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[IdSource.values().length];
            r0[IdSource.Auto.ordinal()] = 1;
            r0[IdSource.NxET.ordinal()] = 2;
            r0[IdSource.BTM.ordinal()] = 3;
            r0[IdSource.Custom.ordinal()] = 4;
            a = r0;
        }
    }

    public static IdSource valueOf(String r1) {
        return (IdSource) r27.a.a(IdSource.class, r1);
    }

    public static IdSource[] values() {
        return (IdSource[]) a.clone();
    }

    static {
        IdSource r0 = new IdSource("Auto", 0);
        Auto = r0;
        IdSource r1 = new IdSource("NxET", 1);
        NxET = r1;
        IdSource r3 = new IdSource("BTM", 2);
        BTM = r3;
        IdSource r5 = new IdSource("Custom", 3);
        Custom = r5;
        a = new IdSource[]{r0, r1, r3, r5};
    }

    @Override // java.lang.Enum
    public String toString() {
        int r0 = a.a[ordinal()];
        if (r0 != 1) goto L5;
        return "auto";
    L5:
        if (r0 != 2) goto L7;
        return "nxet";
    L7:
        if (r0 != 3) goto L9;
        return "btm";
    L9:
        if (r0 != 4) goto L12;
        return "custom";
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public IdSource(String r1, int r2) {
        super(r1, r2);
    }
}
