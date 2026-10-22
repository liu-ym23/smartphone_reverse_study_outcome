package com.bytedance.ee.space.sync;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/space/sync/PushAction$EType;", "", "data", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getData", "()Ljava/lang/String;", "REGISTER_LIST", "UNREGISTER_LIST", "Companion", "contentmanager-space-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PushAction$EType extends Enum<PushAction$EType> {
    public static final a Companion = null;
    public static final String KEY_NAME = "type";
    public static final PushAction$EType REGISTER_LIST = null;
    public static final PushAction$EType UNREGISTER_LIST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PushAction$EType[] f243068a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f243069b = null;
    private final String data;

    public static EnumEntries<PushAction$EType> getEntries() {
        return f243069b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ee.space.sync.PushAction$EType$a] */
    static {
        PushAction$EType r100 = new PushAction$EType("REGISTER_LIST", 0, "registerList");
        REGISTER_LIST = r100;
        PushAction$EType r101 = new PushAction$EType("UNREGISTER_LIST", 1, "unRegisterList");
        UNREGISTER_LIST = r101;
        PushAction$EType[] r102 = {r100, r101};
        f243068a = r102;
        f243069b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static PushAction$EType[] values() {
        return (PushAction$EType[]) f243068a.clone();
    }

    public final String getData() {
        return this.data;
    }

    public static PushAction$EType valueOf(String r100) {
        return (PushAction$EType) r27.a.a(PushAction$EType.class, r100);
    }

    public PushAction$EType(String r100, int r101, String r102) {
        super(r100, r101);
        this.data = r102;
    }
}
