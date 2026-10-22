package com.ss.android.lark.chat.cot.detail.blueprint;

import com.ss.android.lark.blueprint.u;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/chat/cot/detail/blueprint/CotDetailCellKeys$Layouts;", "Lcom/ss/android/lark/blueprint/ILayoutType;", "", "<init>", "(Ljava/lang/String;I)V", "SINGLE", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CotDetailCellKeys$Layouts extends Enum<CotDetailCellKeys$Layouts> implements u {
    public static final CotDetailCellKeys$Layouts SINGLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CotDetailCellKeys$Layouts[] f414853a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f414854b = null;

    public static EnumEntries<CotDetailCellKeys$Layouts> getEntries() {
        return f414854b;
    }

    static {
        CotDetailCellKeys$Layouts r100 = new CotDetailCellKeys$Layouts();
        SINGLE = r100;
        CotDetailCellKeys$Layouts[] r101 = {r100};
        f414853a = r101;
        f414854b = EnumEntriesKt.enumEntries(r101);
    }

    public CotDetailCellKeys$Layouts() {
        super("SINGLE", 0);
    }

    public static CotDetailCellKeys$Layouts[] values() {
        return (CotDetailCellKeys$Layouts[]) f414853a.clone();
    }

    public static CotDetailCellKeys$Layouts valueOf(String r100) {
        return (CotDetailCellKeys$Layouts) r27.a.a(CotDetailCellKeys$Layouts.class, r100);
    }
}
