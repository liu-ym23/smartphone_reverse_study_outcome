package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/relax/relaxframework/FeatureList;", "", "", "value", "I", "getValue", "()I", "PagePhaseListener", "RendererDestroyElement", "RequestFrameCommitCallback", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum FeatureList extends Enum<FeatureList> {
    public static final FeatureList PagePhaseListener = null;
    public static final FeatureList RendererDestroyElement = null;
    public static final FeatureList RequestFrameCommitCallback = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FeatureList[] f404718a = null;
    private final int value;

    public static FeatureList valueOf(String r100) {
        return (FeatureList) r27.a.a(FeatureList.class, r100);
    }

    public static FeatureList[] values() {
        return (FeatureList[]) f404718a.clone();
    }

    static {
        FeatureList r100 = new FeatureList("PagePhaseListener", 0, 1);
        PagePhaseListener = r100;
        FeatureList r101 = new FeatureList("RendererDestroyElement", 1, 2);
        RendererDestroyElement = r101;
        FeatureList r102 = new FeatureList("RequestFrameCommitCallback", 2, 3);
        RequestFrameCommitCallback = r102;
        f404718a = new FeatureList[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public FeatureList(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
