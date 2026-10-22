package com.larksuite.component.card.component.image;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larksuite/component/card/component/image/CropType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "LEFT_TOP", "STRETCH", "CROP_CENTER", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CropType extends Enum<CropType> {
    public static final CropType CROP_CENTER = null;
    public static final CropType LEFT_TOP = null;
    public static final CropType STRETCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CropType[] f283375a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f283376b = null;

    public static EnumEntries<CropType> getEntries() {
        return f283376b;
    }

    static {
        CropType r100 = new CropType("LEFT_TOP", 0);
        LEFT_TOP = r100;
        CropType r101 = new CropType("STRETCH", 1);
        STRETCH = r101;
        CropType r102 = new CropType("CROP_CENTER", 2);
        CROP_CENTER = r102;
        CropType[] r103 = {r100, r101, r102};
        f283375a = r103;
        f283376b = EnumEntriesKt.enumEntries(r103);
    }

    public static CropType[] values() {
        return (CropType[]) f283375a.clone();
    }

    public static CropType valueOf(String r100) {
        return (CropType) r27.a.a(CropType.class, r100);
    }

    public CropType(String r100, int r101) {
        super(r100, r101);
    }
}
