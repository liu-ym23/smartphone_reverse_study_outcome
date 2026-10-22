package com.bytedance.ee.bear.dependency;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/dependency/LoadingLayoutScope;", "", "<init>", "(Ljava/lang/String;I)V", "CONTENT", "FULL_CONTAINER", "framework-container-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LoadingLayoutScope extends Enum<LoadingLayoutScope> {
    public static final LoadingLayoutScope CONTENT = null;
    public static final LoadingLayoutScope FULL_CONTAINER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoadingLayoutScope[] f217591a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f217592b = null;

    public static EnumEntries<LoadingLayoutScope> getEntries() {
        return f217592b;
    }

    static {
        LoadingLayoutScope r100 = new LoadingLayoutScope("CONTENT", 0);
        CONTENT = r100;
        LoadingLayoutScope r101 = new LoadingLayoutScope("FULL_CONTAINER", 1);
        FULL_CONTAINER = r101;
        LoadingLayoutScope[] r102 = {r100, r101};
        f217591a = r102;
        f217592b = EnumEntriesKt.enumEntries(r102);
    }

    public static LoadingLayoutScope[] values() {
        return (LoadingLayoutScope[]) f217591a.clone();
    }

    public static LoadingLayoutScope valueOf(String r100) {
        return (LoadingLayoutScope) a.a(LoadingLayoutScope.class, r100);
    }

    public LoadingLayoutScope(String r100, int r101) {
        super(r100, r101);
    }
}
