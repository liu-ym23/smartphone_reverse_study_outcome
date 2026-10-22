package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/relax/relaxframework/NativeNodeType;", "", "", "value", "I", "getValue", "()I", "UINode", "LayoutNode", "ShadowNode", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum NativeNodeType extends Enum<NativeNodeType> {
    public static final NativeNodeType LayoutNode = null;
    public static final NativeNodeType ShadowNode = null;
    public static final NativeNodeType UINode = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NativeNodeType[] f404829a = null;
    private final int value;

    public static NativeNodeType valueOf(String r100) {
        return (NativeNodeType) r27.a.a(NativeNodeType.class, r100);
    }

    public static NativeNodeType[] values() {
        return (NativeNodeType[]) f404829a.clone();
    }

    static {
        NativeNodeType r100 = new NativeNodeType("UINode", 0, 1);
        UINode = r100;
        NativeNodeType r101 = new NativeNodeType("LayoutNode", 1, 2);
        LayoutNode = r101;
        NativeNodeType r102 = new NativeNodeType("ShadowNode", 2, 4);
        ShadowNode = r102;
        f404829a = new NativeNodeType[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public NativeNodeType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
