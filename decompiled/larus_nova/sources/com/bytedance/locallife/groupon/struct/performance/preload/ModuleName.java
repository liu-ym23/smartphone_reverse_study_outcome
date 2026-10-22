package com.bytedance.locallife.groupon.struct.performance.preload;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/performance/preload/ModuleName;", "", "DIAMOND", "FEEDS", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum ModuleName extends Enum<ModuleName> {
    public static final ModuleName DIAMOND = null;
    public static final ModuleName FEEDS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ModuleName[] f258846a = null;

    public static ModuleName valueOf(String r100) {
        return (ModuleName) a.a(ModuleName.class, r100);
    }

    public static ModuleName[] values() {
        return (ModuleName[]) f258846a.clone();
    }

    static {
        ModuleName r100 = new ModuleName("DIAMOND", 0);
        DIAMOND = r100;
        ModuleName r101 = new ModuleName("FEEDS", 1);
        FEEDS = r101;
        f258846a = new ModuleName[]{r100, r101};
    }

    public ModuleName(String r100, int r101) {
        super(r100, r101);
    }
}
