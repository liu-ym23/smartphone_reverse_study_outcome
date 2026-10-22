package com.ss.android.lark.chat.cot.detail.blueprint;

import com.ss.android.lark.blueprint.v;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/chat/cot/detail/blueprint/CotDetailCellKeys$Slots;", "Lcom/ss/android/lark/blueprint/ISlotId;", "", "<init>", "(Ljava/lang/String;I)V", "CONTENT", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CotDetailCellKeys$Slots extends Enum<CotDetailCellKeys$Slots> implements v {
    public static final CotDetailCellKeys$Slots CONTENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CotDetailCellKeys$Slots[] f414855a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f414856b = null;

    public static EnumEntries<CotDetailCellKeys$Slots> getEntries() {
        return f414856b;
    }

    static {
        CotDetailCellKeys$Slots r100 = new CotDetailCellKeys$Slots();
        CONTENT = r100;
        CotDetailCellKeys$Slots[] r101 = {r100};
        f414855a = r101;
        f414856b = EnumEntriesKt.enumEntries(r101);
    }

    public CotDetailCellKeys$Slots() {
        super("CONTENT", 0);
    }

    public static CotDetailCellKeys$Slots[] values() {
        return (CotDetailCellKeys$Slots[]) f414855a.clone();
    }

    public static CotDetailCellKeys$Slots valueOf(String r100) {
        return (CotDetailCellKeys$Slots) r27.a.a(CotDetailCellKeys$Slots.class, r100);
    }
}
