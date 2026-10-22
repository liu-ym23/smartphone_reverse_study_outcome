package com.bytedance.ee.bear.bitable.card.view.page;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/page/RecordSubscribeStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNSUBSCRIBED", "SUBSCRIBED", "UNSUPPORTED", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RecordSubscribeStatus extends Enum<RecordSubscribeStatus> {
    public static final RecordSubscribeStatus SUBSCRIBED = null;
    public static final RecordSubscribeStatus UNSUBSCRIBED = null;
    public static final RecordSubscribeStatus UNSUPPORTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RecordSubscribeStatus[] f208565a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f208566b = null;
    private final int value;

    public static EnumEntries<RecordSubscribeStatus> getEntries() {
        return f208566b;
    }

    static {
        RecordSubscribeStatus r100 = new RecordSubscribeStatus("UNSUBSCRIBED", 0, 0);
        UNSUBSCRIBED = r100;
        RecordSubscribeStatus r101 = new RecordSubscribeStatus("SUBSCRIBED", 1, 1);
        SUBSCRIBED = r101;
        RecordSubscribeStatus r102 = new RecordSubscribeStatus("UNSUPPORTED", 2, 2);
        UNSUPPORTED = r102;
        RecordSubscribeStatus[] r103 = {r100, r101, r102};
        f208565a = r103;
        f208566b = EnumEntriesKt.enumEntries(r103);
    }

    public static RecordSubscribeStatus[] values() {
        return (RecordSubscribeStatus[]) f208565a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static RecordSubscribeStatus valueOf(String r100) {
        return (RecordSubscribeStatus) r27.a.a(RecordSubscribeStatus.class, r100);
    }

    public RecordSubscribeStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
