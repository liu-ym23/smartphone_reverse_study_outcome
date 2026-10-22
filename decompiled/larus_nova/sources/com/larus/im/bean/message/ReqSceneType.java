package com.larus.im.bean.message;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/im/bean/message/ReqSceneType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ReqSceneType_Default", "ReqSceneType_Vui", "ReqSceneType_OAPI", "ReqSceneType_Inner", "ReqSceneType_VuiV3", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReqSceneType extends Enum<ReqSceneType> {
    public static final ReqSceneType ReqSceneType_Default = null;
    public static final ReqSceneType ReqSceneType_Inner = null;
    public static final ReqSceneType ReqSceneType_OAPI = null;
    public static final ReqSceneType ReqSceneType_Vui = null;
    public static final ReqSceneType ReqSceneType_VuiV3 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReqSceneType[] f346701a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f346702b = null;
    private final int value;

    public static EnumEntries<ReqSceneType> getEntries() {
        return f346702b;
    }

    static {
        ReqSceneType r100 = new ReqSceneType("ReqSceneType_Default", 0, 0);
        ReqSceneType_Default = r100;
        ReqSceneType r101 = new ReqSceneType("ReqSceneType_Vui", 1, 1);
        ReqSceneType_Vui = r101;
        ReqSceneType r102 = new ReqSceneType("ReqSceneType_OAPI", 2, 2);
        ReqSceneType_OAPI = r102;
        ReqSceneType r103 = new ReqSceneType("ReqSceneType_Inner", 3, 3);
        ReqSceneType_Inner = r103;
        ReqSceneType r104 = new ReqSceneType("ReqSceneType_VuiV3", 4, 4);
        ReqSceneType_VuiV3 = r104;
        ReqSceneType[] r105 = {r100, r101, r102, r103, r104};
        f346701a = r105;
        f346702b = EnumEntriesKt.enumEntries(r105);
    }

    public static ReqSceneType[] values() {
        return (ReqSceneType[]) f346701a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ReqSceneType valueOf(String r100) {
        return (ReqSceneType) r27.a.a(ReqSceneType.class, r100);
    }

    public ReqSceneType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
