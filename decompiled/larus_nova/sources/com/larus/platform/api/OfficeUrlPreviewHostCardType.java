package com.larus.platform.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/platform/api/OfficeUrlPreviewHostCardType;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "COMPACT", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeUrlPreviewHostCardType extends Enum<OfficeUrlPreviewHostCardType> {
    public static final OfficeUrlPreviewHostCardType COMPACT = null;
    public static final OfficeUrlPreviewHostCardType DEFAULT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeUrlPreviewHostCardType[] f364830a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f364831b = null;

    public static EnumEntries<OfficeUrlPreviewHostCardType> getEntries() {
        return f364831b;
    }

    static {
        OfficeUrlPreviewHostCardType r100 = new OfficeUrlPreviewHostCardType("DEFAULT", 0);
        DEFAULT = r100;
        OfficeUrlPreviewHostCardType r101 = new OfficeUrlPreviewHostCardType("COMPACT", 1);
        COMPACT = r101;
        OfficeUrlPreviewHostCardType[] r102 = {r100, r101};
        f364830a = r102;
        f364831b = EnumEntriesKt.enumEntries(r102);
    }

    public static OfficeUrlPreviewHostCardType[] values() {
        return (OfficeUrlPreviewHostCardType[]) f364830a.clone();
    }

    public static OfficeUrlPreviewHostCardType valueOf(String r100) {
        return (OfficeUrlPreviewHostCardType) r27.a.a(OfficeUrlPreviewHostCardType.class, r100);
    }

    public OfficeUrlPreviewHostCardType(String r100, int r101) {
        super(r100, r101);
    }
}
