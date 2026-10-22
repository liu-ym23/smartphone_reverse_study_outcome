package com.bytedance.ee.bear.bitable.homepage.recommend.report;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/recommend/report/LoadFrom;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CACHE", "NETWORK", "TIMEOUT", "TIMEOUT_CACHE", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LoadFrom extends Enum<LoadFrom> {
    public static final LoadFrom CACHE = null;
    public static final LoadFrom NETWORK = null;
    public static final LoadFrom TIMEOUT = null;
    public static final LoadFrom TIMEOUT_CACHE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoadFrom[] f213052a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f213053b = null;
    private final String value;

    public static EnumEntries<LoadFrom> getEntries() {
        return f213053b;
    }

    static {
        LoadFrom r100 = new LoadFrom("CACHE", 0, "cache");
        CACHE = r100;
        LoadFrom r101 = new LoadFrom("NETWORK", 1, "network");
        NETWORK = r101;
        LoadFrom r102 = new LoadFrom("TIMEOUT", 2, "timeout");
        TIMEOUT = r102;
        LoadFrom r103 = new LoadFrom("TIMEOUT_CACHE", 3, "timeout_cache");
        TIMEOUT_CACHE = r103;
        LoadFrom[] r104 = {r100, r101, r102, r103};
        f213052a = r104;
        f213053b = EnumEntriesKt.enumEntries(r104);
    }

    public static LoadFrom[] values() {
        return (LoadFrom[]) f213052a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static LoadFrom valueOf(String r100) {
        return (LoadFrom) a.a(LoadFrom.class, r100);
    }

    public LoadFrom(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
