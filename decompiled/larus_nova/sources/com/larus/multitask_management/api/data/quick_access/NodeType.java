package com.larus.multitask_management.api.data.quick_access;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.Serializable;
import ll9.n;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0087\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/larus/multitask_management/api/data/quick_access/NodeType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "DOUBAO_APPS", "DOCUMENT", "PPT", "WEB_PAGE", "SHEET", "FILE", "FOLDER", "Companion", "multitask_management_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable(with = n.class)
public final enum NodeType extends Enum<NodeType> {
    public static final a Companion = null;
    public static final NodeType DOCUMENT = null;
    public static final NodeType DOUBAO_APPS = null;
    public static final NodeType FILE = null;
    public static final NodeType FOLDER = null;
    public static final NodeType PPT = null;
    public static final NodeType SHEET = null;
    public static final NodeType UNKNOWN = null;
    public static final NodeType WEB_PAGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NodeType[] f359387a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f359388b = null;
    private final int value;

    public static EnumEntries<NodeType> getEntries() {
        return f359388b;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.larus.multitask_management.api.data.quick_access.NodeType$a] */
    static {
        NodeType r100 = new NodeType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        NodeType r101 = new NodeType("DOUBAO_APPS", 1, 2);
        DOUBAO_APPS = r101;
        NodeType r102 = new NodeType("DOCUMENT", 2, 3);
        DOCUMENT = r102;
        NodeType r103 = new NodeType("PPT", 3, 4);
        PPT = r103;
        NodeType r104 = new NodeType("WEB_PAGE", 4, 5);
        WEB_PAGE = r104;
        NodeType r110 = new NodeType("SHEET", 5, 6);
        SHEET = r110;
        NodeType r111 = new NodeType("FILE", 6, 7);
        FILE = r111;
        NodeType r112 = new NodeType("FOLDER", 7, 8);
        FOLDER = r112;
        NodeType[] r113 = {r100, r101, r102, r103, r104, r110, r111, r112};
        f359387a = r113;
        f359388b = EnumEntriesKt.enumEntries(r113);
        Companion = new a();
    }

    public static NodeType[] values() {
        return (NodeType[]) f359387a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static NodeType valueOf(String r100) {
        return (NodeType) r27.a.a(NodeType.class, r100);
    }

    public NodeType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
