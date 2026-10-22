package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/relax/relaxframework/PagePhase;", "", "", "value", "I", "getValue", "()I", "EnterForeground", "EnterBackground", "Destroy", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum PagePhase extends Enum<PagePhase> {
    public static final PagePhase Destroy = null;
    public static final PagePhase EnterBackground = null;
    public static final PagePhase EnterForeground = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PagePhase[] f404840a = null;
    private final int value;

    public static PagePhase valueOf(String r100) {
        return (PagePhase) r27.a.a(PagePhase.class, r100);
    }

    public static PagePhase[] values() {
        return (PagePhase[]) f404840a.clone();
    }

    static {
        PagePhase r100 = new PagePhase("EnterForeground", 0, 1);
        EnterForeground = r100;
        PagePhase r101 = new PagePhase("EnterBackground", 1, 2);
        EnterBackground = r101;
        PagePhase r102 = new PagePhase("Destroy", 2, 3);
        Destroy = r102;
        f404840a = new PagePhase[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public PagePhase(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
