package com.bytedance.ies.xbridge;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ies/xbridge/ConverterDir;", "", "INPUT", "OUTPUT", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ConverterDir extends Enum<ConverterDir> {
    public static final ConverterDir INPUT = null;
    public static final ConverterDir OUTPUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ConverterDir[] f249433a = null;

    public static ConverterDir valueOf(String r100) {
        return (ConverterDir) r27.a.a(ConverterDir.class, r100);
    }

    public static ConverterDir[] values() {
        return (ConverterDir[]) f249433a.clone();
    }

    static {
        ConverterDir r100 = new ConverterDir("INPUT", 0);
        INPUT = r100;
        ConverterDir r101 = new ConverterDir("OUTPUT", 1);
        OUTPUT = r101;
        f249433a = new ConverterDir[]{r100, r101};
    }

    public ConverterDir(String r100, int r101) {
        super(r100, r101);
    }
}
