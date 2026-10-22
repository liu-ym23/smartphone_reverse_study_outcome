package com.bytedance.locallife.dito.core;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/locallife/dito/core/DitoScrollConfig;", "", "DEFAULT", "HEADER", "FOOTER", "HEADER_FOOTER", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final enum DitoScrollConfig extends Enum<DitoScrollConfig> {
    public static final DitoScrollConfig DEFAULT = null;
    public static final DitoScrollConfig FOOTER = null;
    public static final DitoScrollConfig HEADER = null;
    public static final DitoScrollConfig HEADER_FOOTER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DitoScrollConfig[] f257861a = null;

    public static DitoScrollConfig valueOf(String r100) {
        return (DitoScrollConfig) r27.a.a(DitoScrollConfig.class, r100);
    }

    public static DitoScrollConfig[] values() {
        return (DitoScrollConfig[]) f257861a.clone();
    }

    static {
        DitoScrollConfig r100 = new DitoScrollConfig("DEFAULT", 0);
        DEFAULT = r100;
        DitoScrollConfig r101 = new DitoScrollConfig("HEADER", 1);
        HEADER = r101;
        DitoScrollConfig r102 = new DitoScrollConfig("FOOTER", 2);
        FOOTER = r102;
        DitoScrollConfig r103 = new DitoScrollConfig("HEADER_FOOTER", 3);
        HEADER_FOOTER = r103;
        f257861a = new DitoScrollConfig[]{r100, r101, r102, r103};
    }

    public DitoScrollConfig(String r100, int r101) {
        super(r100, r101);
    }
}
