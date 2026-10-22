package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/relax/relaxframework/RefreshMode;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "None", "Page", "Fold", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum RefreshMode extends Enum<RefreshMode> {
    public static final RefreshMode Fold = null;
    public static final RefreshMode None = null;
    public static final RefreshMode Page = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RefreshMode[] f404867a = null;
    private final String value;

    public static RefreshMode valueOf(String r100) {
        return (RefreshMode) r27.a.a(RefreshMode.class, r100);
    }

    public static RefreshMode[] values() {
        return (RefreshMode[]) f404867a.clone();
    }

    static {
        RefreshMode r100 = new RefreshMode("None", 0, "none");
        None = r100;
        RefreshMode r101 = new RefreshMode("Page", 1, "page");
        Page = r101;
        RefreshMode r102 = new RefreshMode("Fold", 2, "fold");
        Fold = r102;
        f404867a = new RefreshMode[]{r100, r101, r102};
    }

    public final String getValue() {
        return this.value;
    }

    public RefreshMode(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
