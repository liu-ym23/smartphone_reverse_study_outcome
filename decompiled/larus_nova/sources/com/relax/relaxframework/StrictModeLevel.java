package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/relax/relaxframework/StrictModeLevel;", "", "", "value", "J", "getValue", "()J", "Silent", "Error", "Fatal", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum StrictModeLevel extends Enum<StrictModeLevel> {
    public static final StrictModeLevel Error = null;
    public static final StrictModeLevel Fatal = null;
    public static final StrictModeLevel Silent = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StrictModeLevel[] f404961a = null;
    private final long value;

    public static StrictModeLevel valueOf(String r100) {
        return (StrictModeLevel) r27.a.a(StrictModeLevel.class, r100);
    }

    public static StrictModeLevel[] values() {
        return (StrictModeLevel[]) f404961a.clone();
    }

    static {
        StrictModeLevel r100 = new StrictModeLevel("Silent", 0, 0);
        Silent = r100;
        StrictModeLevel r101 = new StrictModeLevel("Error", 1, 1);
        Error = r101;
        StrictModeLevel r102 = new StrictModeLevel("Fatal", 2, 2);
        Fatal = r102;
        f404961a = new StrictModeLevel[]{r100, r101, r102};
    }

    public final long getValue() {
        return this.value;
    }

    public StrictModeLevel(String r100, int r101, long r102) {
        super(r100, r101);
        this.value = r102;
    }
}
