package com.bytedance.assem.arch.core;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/assem/arch/core/AssembleMode;", "", "IMMEDIATE", "LAZY", "assem_release"}, k = 1, mv = {1, 4, 0})
public final enum AssembleMode extends Enum<AssembleMode> {
    public static final AssembleMode IMMEDIATE = null;
    public static final AssembleMode LAZY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AssembleMode[] f192881a = null;

    static {
        AssembleMode r100 = new AssembleMode("IMMEDIATE", 0);
        IMMEDIATE = r100;
        AssembleMode r101 = new AssembleMode("LAZY", 1);
        LAZY = r101;
        f192881a = new AssembleMode[]{r100, r101};
    }

    public static AssembleMode valueOf(String r100) {
        return (AssembleMode) r27.a.a(AssembleMode.class, r100);
    }

    public static AssembleMode[] values() {
        return (AssembleMode[]) f192881a.clone();
    }

    public AssembleMode(String r100, int r101) {
        super(r100, r101);
    }
}
