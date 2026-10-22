package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/relax/relaxframework/ScrollOrientation;", "", "", "value", "I", "getValue", "()I", "Vertical", "Horizontal", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ScrollOrientation extends Enum<ScrollOrientation> {
    public static final ScrollOrientation Horizontal = null;
    public static final ScrollOrientation Vertical = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ScrollOrientation[] f404951a = null;
    private final int value;

    public static ScrollOrientation valueOf(String r100) {
        return (ScrollOrientation) r27.a.a(ScrollOrientation.class, r100);
    }

    public static ScrollOrientation[] values() {
        return (ScrollOrientation[]) f404951a.clone();
    }

    static {
        ScrollOrientation r100 = new ScrollOrientation("Vertical", 0, 0);
        Vertical = r100;
        ScrollOrientation r101 = new ScrollOrientation("Horizontal", 1, 1);
        Horizontal = r101;
        f404951a = new ScrollOrientation[]{r100, r101};
    }

    public final int getValue() {
        return this.value;
    }

    public ScrollOrientation(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
