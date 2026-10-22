package com.obric.common.oea.foundation.animation.constants;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/common/oea/foundation/animation/constants/RunMode;", "", "PARALLEL", "SERIAL", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum RunMode extends Enum<RunMode> {
    public static final RunMode PARALLEL = null;
    public static final RunMode SERIAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RunMode[] f396385a = null;

    static {
        RunMode r100 = new RunMode("PARALLEL", 0);
        PARALLEL = r100;
        RunMode r101 = new RunMode("SERIAL", 1);
        SERIAL = r101;
        f396385a = new RunMode[]{r100, r101};
    }

    public static RunMode valueOf(String r100) {
        return (RunMode) a.a(RunMode.class, r100);
    }

    public static RunMode[] values() {
        return (RunMode[]) f396385a.clone();
    }

    public RunMode(String r100, int r101) {
        super(r100, r101);
    }
}
