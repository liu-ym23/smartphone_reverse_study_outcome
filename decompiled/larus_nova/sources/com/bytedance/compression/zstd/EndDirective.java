package com.bytedance.compression.zstd;

import com.alibaba.gaiax.model.GXAnimation;

/* JADX INFO: loaded from: classes15.dex */
public final enum EndDirective extends Enum<EndDirective> {
    public static final EndDirective CONTINUE = null;
    public static final EndDirective END = null;
    public static final EndDirective FLUSH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EndDirective[] f203091a = null;
    private final int value;

    static {
        EndDirective r100 = new EndDirective("CONTINUE", 0, 0);
        CONTINUE = r100;
        EndDirective r101 = new EndDirective("FLUSH", 1, 1);
        FLUSH = r101;
        EndDirective r102 = new EndDirective(GXAnimation.STATE_END, 2, 2);
        END = r102;
        f203091a = new EndDirective[]{r100, r101, r102};
    }

    public static EndDirective[] values() {
        return (EndDirective[]) f203091a.clone();
    }

    public int value() {
        return this.value;
    }

    public static EndDirective valueOf(String r100) {
        return (EndDirective) r27.a.a(EndDirective.class, r100);
    }

    public EndDirective(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
