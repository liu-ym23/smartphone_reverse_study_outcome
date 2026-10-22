package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/relax/relaxframework/ListEventSource;", "", "", "value", "I", "getValue", "()I", "Diff", "Layout", "Scroll", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ListEventSource extends Enum<ListEventSource> {
    public static final ListEventSource Diff = null;
    public static final ListEventSource Layout = null;
    public static final ListEventSource Scroll = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ListEventSource[] f404770a = null;
    private final int value;

    public static ListEventSource valueOf(String r100) {
        return (ListEventSource) r27.a.a(ListEventSource.class, r100);
    }

    public static ListEventSource[] values() {
        return (ListEventSource[]) f404770a.clone();
    }

    static {
        ListEventSource r100 = new ListEventSource("Diff", 0, 0);
        Diff = r100;
        ListEventSource r101 = new ListEventSource("Layout", 1, 1);
        Layout = r101;
        ListEventSource r102 = new ListEventSource("Scroll", 2, 2);
        Scroll = r102;
        f404770a = new ListEventSource[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public ListEventSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
