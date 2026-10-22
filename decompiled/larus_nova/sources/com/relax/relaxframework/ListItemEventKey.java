package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/relax/relaxframework/ListItemEventKey;", "", "", "value", "I", "getValue", "()I", "NodeAppear", "NodeDisappear", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ListItemEventKey extends Enum<ListItemEventKey> {
    public static final ListItemEventKey NodeAppear = null;
    public static final ListItemEventKey NodeDisappear = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ListItemEventKey[] f404773a = null;
    private final int value;

    public static ListItemEventKey valueOf(String r100) {
        return (ListItemEventKey) r27.a.a(ListItemEventKey.class, r100);
    }

    public static ListItemEventKey[] values() {
        return (ListItemEventKey[]) f404773a.clone();
    }

    static {
        ListItemEventKey r100 = new ListItemEventKey("NodeAppear", 0, 30013);
        NodeAppear = r100;
        ListItemEventKey r101 = new ListItemEventKey("NodeDisappear", 1, 30014);
        NodeDisappear = r101;
        f404773a = new ListItemEventKey[]{r100, r101};
    }

    public final int getValue() {
        return this.value;
    }

    public ListItemEventKey(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
