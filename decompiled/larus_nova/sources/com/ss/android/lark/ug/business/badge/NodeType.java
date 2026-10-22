package com.ss.android.lark.ug.business.badge;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/ug/business/badge/NodeType;", "", "key", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "SETTING", "ABOUT_LARK", "USER_AGREEMENT", "PRIVACY_POLICY", "ug-reach-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum NodeType extends Enum<NodeType> {
    public static final NodeType ABOUT_LARK = null;
    public static final NodeType PRIVACY_POLICY = null;
    public static final NodeType SETTING = null;
    public static final NodeType USER_AGREEMENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NodeType[] f444417a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f444418b = null;
    private final String key;

    public static EnumEntries<NodeType> getEntries() {
        return f444418b;
    }

    static {
        NodeType r100 = new NodeType("SETTING", 0, "RP_VIRTUAL_SETTING");
        SETTING = r100;
        NodeType r101 = new NodeType("ABOUT_LARK", 1, "RP_VIRTUAL_SETTING_ABOUT");
        ABOUT_LARK = r101;
        NodeType r102 = new NodeType("USER_AGREEMENT", 2, "RP_USER_AGREEMENT_BADGE");
        USER_AGREEMENT = r102;
        NodeType r103 = new NodeType("PRIVACY_POLICY", 3, "RP_USER_PRIVACY_BADGE");
        PRIVACY_POLICY = r103;
        NodeType[] r104 = {r100, r101, r102, r103};
        f444417a = r104;
        f444418b = EnumEntriesKt.enumEntries(r104);
    }

    public static NodeType[] values() {
        return (NodeType[]) f444417a.clone();
    }

    public final String getKey() {
        return this.key;
    }

    public static NodeType valueOf(String r100) {
        return (NodeType) r27.a.a(NodeType.class, r100);
    }

    public NodeType(String r100, int r101, String r102) {
        super(r100, r101);
        this.key = r102;
    }
}
