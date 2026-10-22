package com.bytedance.ies.bullet.service.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/LoaderName;", "", "ResourceLoader", "Forest", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum LoaderName extends Enum<LoaderName> {
    public static final LoaderName Forest = null;
    public static final LoaderName ResourceLoader = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoaderName[] f247773a = null;

    public static LoaderName valueOf(String r100) {
        return (LoaderName) r27.a.a(LoaderName.class, r100);
    }

    public static LoaderName[] values() {
        return (LoaderName[]) f247773a.clone();
    }

    static {
        LoaderName r100 = new LoaderName("ResourceLoader", 0);
        ResourceLoader = r100;
        LoaderName r101 = new LoaderName("Forest", 1);
        Forest = r101;
        f247773a = new LoaderName[]{r100, r101};
    }

    public LoaderName(String r100, int r101) {
        super(r100, r101);
    }
}
