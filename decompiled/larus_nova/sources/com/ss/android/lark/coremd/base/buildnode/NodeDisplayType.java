package com.ss.android.lark.coremd.base.buildnode;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/coremd/base/buildnode/NodeDisplayType;", "", "<init>", "(Ljava/lang/String;I)V", "Inline", "Block", "InlineBlock", "NonContainerBlock", "core-md_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum NodeDisplayType extends Enum<NodeDisplayType> {
    public static final NodeDisplayType Block = null;
    public static final NodeDisplayType Inline = null;
    public static final NodeDisplayType InlineBlock = null;
    public static final NodeDisplayType NonContainerBlock = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NodeDisplayType[] f419524a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f419525b = null;

    public static EnumEntries<NodeDisplayType> getEntries() {
        return f419525b;
    }

    static {
        NodeDisplayType r100 = new NodeDisplayType("Inline", 0);
        Inline = r100;
        NodeDisplayType r101 = new NodeDisplayType("Block", 1);
        Block = r101;
        NodeDisplayType r102 = new NodeDisplayType("InlineBlock", 2);
        InlineBlock = r102;
        NodeDisplayType r103 = new NodeDisplayType("NonContainerBlock", 3);
        NonContainerBlock = r103;
        NodeDisplayType[] r104 = {r100, r101, r102, r103};
        f419524a = r104;
        f419525b = EnumEntriesKt.enumEntries(r104);
    }

    public static NodeDisplayType[] values() {
        return (NodeDisplayType[]) f419524a.clone();
    }

    public static NodeDisplayType valueOf(String r100) {
        return (NodeDisplayType) a.a(NodeDisplayType.class, r100);
    }

    public NodeDisplayType(String r100, int r101) {
        super(r100, r101);
    }
}
