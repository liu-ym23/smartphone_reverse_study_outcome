package com.larus.dora.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/api/DoraEnableScope;", "", "<init>", "(Ljava/lang/String;I)V", "G1", "G2", "G_SERIES", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraEnableScope extends Enum<DoraEnableScope> {
    public static final DoraEnableScope G1 = null;
    public static final DoraEnableScope G2 = null;
    public static final DoraEnableScope G_SERIES = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraEnableScope[] f331710a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f331711b = null;

    public static EnumEntries<DoraEnableScope> getEntries() {
        return f331711b;
    }

    static {
        DoraEnableScope r100 = new DoraEnableScope("G1", 0);
        G1 = r100;
        DoraEnableScope r101 = new DoraEnableScope("G2", 1);
        G2 = r101;
        DoraEnableScope r102 = new DoraEnableScope("G_SERIES", 2);
        G_SERIES = r102;
        DoraEnableScope[] r103 = {r100, r101, r102};
        f331710a = r103;
        f331711b = EnumEntriesKt.enumEntries(r103);
    }

    public static DoraEnableScope[] values() {
        return (DoraEnableScope[]) f331710a.clone();
    }

    public static DoraEnableScope valueOf(String r100) {
        return (DoraEnableScope) a.a(DoraEnableScope.class, r100);
    }

    public DoraEnableScope(String r100, int r101) {
        super(r100, r101);
    }
}
