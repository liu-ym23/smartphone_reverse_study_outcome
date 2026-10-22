package com.larus.common.venue.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/common/venue/api/AssistantBizScene;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "EcomPrePurchase", "Travel", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AssistantBizScene extends Enum<AssistantBizScene> {
    public static final AssistantBizScene EcomPrePurchase = null;
    public static final AssistantBizScene Travel = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AssistantBizScene[] f326462a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f326463b = null;
    private final int value;

    public static EnumEntries<AssistantBizScene> getEntries() {
        return f326463b;
    }

    static {
        AssistantBizScene r100 = new AssistantBizScene("EcomPrePurchase", 0, 1);
        EcomPrePurchase = r100;
        AssistantBizScene r101 = new AssistantBizScene("Travel", 1, 2);
        Travel = r101;
        AssistantBizScene[] r102 = {r100, r101};
        f326462a = r102;
        f326463b = EnumEntriesKt.enumEntries(r102);
    }

    public static AssistantBizScene[] values() {
        return (AssistantBizScene[]) f326462a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static AssistantBizScene valueOf(String r100) {
        return (AssistantBizScene) a.a(AssistantBizScene.class, r100);
    }

    public AssistantBizScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
