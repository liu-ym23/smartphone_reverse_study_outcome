package com.bytedance.ee.space.sync;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/space/sync/PushAction$ESubType;", "", "data", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getData", "()Ljava/lang/String;", "DELETE", "SECRET_UPDATE", "Companion", "contentmanager-space-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PushAction$ESubType extends Enum<PushAction$ESubType> {
    public static final a Companion = null;
    public static final PushAction$ESubType DELETE = null;
    public static final String KEY_NAME = "subtype";
    public static final PushAction$ESubType SECRET_UPDATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PushAction$ESubType[] f243066a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f243067b = null;
    private final String data;

    public static EnumEntries<PushAction$ESubType> getEntries() {
        return f243067b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ee.space.sync.PushAction$ESubType$a] */
    static {
        PushAction$ESubType r100 = new PushAction$ESubType("DELETE", 0, "DELETE");
        DELETE = r100;
        PushAction$ESubType r101 = new PushAction$ESubType("SECRET_UPDATE", 1, "SEC_UPDATE");
        SECRET_UPDATE = r101;
        PushAction$ESubType[] r102 = {r100, r101};
        f243066a = r102;
        f243067b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static PushAction$ESubType[] values() {
        return (PushAction$ESubType[]) f243066a.clone();
    }

    public final String getData() {
        return this.data;
    }

    public static PushAction$ESubType valueOf(String r100) {
        return (PushAction$ESubType) r27.a.a(PushAction$ESubType.class, r100);
    }

    public PushAction$ESubType(String r100, int r101, String r102) {
        super(r100, r101);
        this.data = r102;
    }
}
