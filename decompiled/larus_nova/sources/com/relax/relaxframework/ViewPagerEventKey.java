package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/relax/relaxframework/ViewPagerEventKey;", "", "", "value", "I", "getValue", "()I", "Change", "OffsetChange", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ViewPagerEventKey extends Enum<ViewPagerEventKey> {
    public static final ViewPagerEventKey Change = null;
    public static final ViewPagerEventKey OffsetChange = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ViewPagerEventKey[] f404990a = null;
    private final int value;

    public static ViewPagerEventKey valueOf(String r100) {
        return (ViewPagerEventKey) r27.a.a(ViewPagerEventKey.class, r100);
    }

    public static ViewPagerEventKey[] values() {
        return (ViewPagerEventKey[]) f404990a.clone();
    }

    static {
        ViewPagerEventKey r100 = new ViewPagerEventKey("Change", 0, 30066);
        Change = r100;
        ViewPagerEventKey r101 = new ViewPagerEventKey("OffsetChange", 1, 30068);
        OffsetChange = r101;
        f404990a = new ViewPagerEventKey[]{r100, r101};
    }

    public final int getValue() {
        return this.value;
    }

    public ViewPagerEventKey(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
