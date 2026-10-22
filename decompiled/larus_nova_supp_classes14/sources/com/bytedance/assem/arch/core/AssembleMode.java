package com.bytedance.assem.arch.core;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/assem/arch/core/AssembleMode;", "", "IMMEDIATE", "LAZY", "assem_release"}, k = 1, mv = {1, 4, 0})
public final enum AssembleMode extends Enum<AssembleMode> {
    public static final AssembleMode IMMEDIATE = null;
    public static final AssembleMode LAZY = null;
    public static final /* synthetic */ AssembleMode[] a = null;

    static {
        AssembleMode r1 = new AssembleMode("IMMEDIATE", 0);
        IMMEDIATE = r1;
        AssembleMode r2 = new AssembleMode("LAZY", 1);
        LAZY = r2;
        a = new AssembleMode[]{r1, r2};
    }

    public static AssembleMode valueOf(String r1) {
        return (AssembleMode) r27.a.a(AssembleMode.class, r1);
    }

    public static AssembleMode[] values() {
        return (AssembleMode[]) a.clone();
    }

    public AssembleMode(String r1, int r2) {
        super(r1, r2);
    }
}
