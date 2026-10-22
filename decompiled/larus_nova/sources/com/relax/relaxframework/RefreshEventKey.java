package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/relax/relaxframework/RefreshEventKey;", "", "", "value", "I", "getValue", "()I", "RefreshStartRefresh", "RefreshStartLoadmore", "RefreshHeaderReleased", "RefreshFooterReleased", "RefreshHeaderOffset", "RefreshFooterOffset", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum RefreshEventKey extends Enum<RefreshEventKey> {
    public static final RefreshEventKey RefreshFooterOffset = null;
    public static final RefreshEventKey RefreshFooterReleased = null;
    public static final RefreshEventKey RefreshHeaderOffset = null;
    public static final RefreshEventKey RefreshHeaderReleased = null;
    public static final RefreshEventKey RefreshStartLoadmore = null;
    public static final RefreshEventKey RefreshStartRefresh = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RefreshEventKey[] f404866a = null;
    private final int value;

    public static RefreshEventKey valueOf(String r100) {
        return (RefreshEventKey) r27.a.a(RefreshEventKey.class, r100);
    }

    public static RefreshEventKey[] values() {
        return (RefreshEventKey[]) f404866a.clone();
    }

    static {
        RefreshEventKey r100 = new RefreshEventKey("RefreshStartRefresh", 0, 30069);
        RefreshStartRefresh = r100;
        RefreshEventKey r101 = new RefreshEventKey("RefreshStartLoadmore", 1, 30070);
        RefreshStartLoadmore = r101;
        RefreshEventKey r102 = new RefreshEventKey("RefreshHeaderReleased", 2, 30072);
        RefreshHeaderReleased = r102;
        RefreshEventKey r103 = new RefreshEventKey("RefreshFooterReleased", 3, 30073);
        RefreshFooterReleased = r103;
        RefreshEventKey r104 = new RefreshEventKey("RefreshHeaderOffset", 4, 30071);
        RefreshHeaderOffset = r104;
        RefreshEventKey r105 = new RefreshEventKey("RefreshFooterOffset", 5, 30116);
        RefreshFooterOffset = r105;
        f404866a = new RefreshEventKey[]{r100, r101, r102, r103, r104, r105};
    }

    public final int getValue() {
        return this.value;
    }

    public RefreshEventKey(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
