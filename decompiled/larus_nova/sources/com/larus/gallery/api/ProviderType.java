package com.larus.gallery.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/gallery/api/ProviderType;", "", "<init>", "(Ljava/lang/String;I)V", "TOP", "BOTTOM", "RIGHT_SIDE", "RIGHT_BOTTOM", "NON_UI", "gallery_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ProviderType extends Enum<ProviderType> {
    public static final ProviderType BOTTOM = null;
    public static final ProviderType NON_UI = null;
    public static final ProviderType RIGHT_BOTTOM = null;
    public static final ProviderType RIGHT_SIDE = null;
    public static final ProviderType TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ProviderType[] f343815a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f343816b = null;

    public static EnumEntries<ProviderType> getEntries() {
        return f343816b;
    }

    static {
        ProviderType r100 = new ProviderType("TOP", 0);
        TOP = r100;
        ProviderType r101 = new ProviderType("BOTTOM", 1);
        BOTTOM = r101;
        ProviderType r102 = new ProviderType("RIGHT_SIDE", 2);
        RIGHT_SIDE = r102;
        ProviderType r103 = new ProviderType("RIGHT_BOTTOM", 3);
        RIGHT_BOTTOM = r103;
        ProviderType r104 = new ProviderType("NON_UI", 4);
        NON_UI = r104;
        ProviderType[] r105 = {r100, r101, r102, r103, r104};
        f343815a = r105;
        f343816b = EnumEntriesKt.enumEntries(r105);
    }

    public static ProviderType[] values() {
        return (ProviderType[]) f343815a.clone();
    }

    public static ProviderType valueOf(String r100) {
        return (ProviderType) r27.a.a(ProviderType.class, r100);
    }

    public ProviderType(String r100, int r101) {
        super(r100, r101);
    }
}
