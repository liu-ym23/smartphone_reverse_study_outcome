package com.ss.android.lark.intent.export.entity.donate;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/donate/DonateType;", "", "<init>", "(Ljava/lang/String;I)V", "Chat", "Chatter", PreloadConfigModel.VERSION_CHECK_TYPE_DOC, "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DonateType extends Enum<DonateType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DonateType[] $VALUES = null;
    public static final DonateType Chat = null;
    public static final DonateType Chatter = null;
    public static final DonateType DOC = null;

    private static final /* synthetic */ DonateType[] $values() {
        return new DonateType[]{Chat, Chatter, DOC};
    }

    public static EnumEntries<DonateType> getEntries() {
        return $ENTRIES;
    }

    static {
        Chat = new DonateType("Chat", 0);
        Chatter = new DonateType("Chatter", 1);
        DOC = new DonateType(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 2);
        DonateType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static DonateType[] values() {
        return (DonateType[]) $VALUES.clone();
    }

    public static DonateType valueOf(String r100) {
        return (DonateType) a.a(DonateType.class, r100);
    }

    private DonateType(String r100, int r101) {
        super(r100, r101);
    }
}
