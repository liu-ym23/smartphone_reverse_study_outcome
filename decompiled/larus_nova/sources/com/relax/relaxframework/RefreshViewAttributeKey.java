package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/relax/relaxframework/RefreshViewAttributeKey;", "", "", "value", "I", "getValue", "()I", "EnableRefresh", "EnableLoadmore", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum RefreshViewAttributeKey extends Enum<RefreshViewAttributeKey> {
    public static final RefreshViewAttributeKey EnableLoadmore = null;
    public static final RefreshViewAttributeKey EnableRefresh = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RefreshViewAttributeKey[] f404868a = null;
    private final int value;

    public static RefreshViewAttributeKey valueOf(String r100) {
        return (RefreshViewAttributeKey) r27.a.a(RefreshViewAttributeKey.class, r100);
    }

    public static RefreshViewAttributeKey[] values() {
        return (RefreshViewAttributeKey[]) f404868a.clone();
    }

    static {
        RefreshViewAttributeKey r100 = new RefreshViewAttributeKey("EnableRefresh", 0, 20275);
        EnableRefresh = r100;
        RefreshViewAttributeKey r101 = new RefreshViewAttributeKey("EnableLoadmore", 1, 20276);
        EnableLoadmore = r101;
        f404868a = new RefreshViewAttributeKey[]{r100, r101};
    }

    public final int getValue() {
        return this.value;
    }

    public RefreshViewAttributeKey(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
