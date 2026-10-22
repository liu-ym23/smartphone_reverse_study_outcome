package com.larus.photopicker.v2.impl.viewmodel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/photopicker/v2/impl/viewmodel/UnSelectableToastType;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "VIDEO_LIMIT", "IMAGE_LIMIT", "VIDEO_DURATION", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UnSelectableToastType extends Enum<UnSelectableToastType> {
    public static final UnSelectableToastType DEFAULT = null;
    public static final UnSelectableToastType IMAGE_LIMIT = null;
    public static final UnSelectableToastType VIDEO_DURATION = null;
    public static final UnSelectableToastType VIDEO_LIMIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UnSelectableToastType[] f364694a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f364695b = null;

    public static EnumEntries<UnSelectableToastType> getEntries() {
        return f364695b;
    }

    static {
        UnSelectableToastType r100 = new UnSelectableToastType("DEFAULT", 0);
        DEFAULT = r100;
        UnSelectableToastType r101 = new UnSelectableToastType("VIDEO_LIMIT", 1);
        VIDEO_LIMIT = r101;
        UnSelectableToastType r102 = new UnSelectableToastType("IMAGE_LIMIT", 2);
        IMAGE_LIMIT = r102;
        UnSelectableToastType r103 = new UnSelectableToastType("VIDEO_DURATION", 3);
        VIDEO_DURATION = r103;
        UnSelectableToastType[] r104 = {r100, r101, r102, r103};
        f364694a = r104;
        f364695b = EnumEntriesKt.enumEntries(r104);
    }

    public static UnSelectableToastType[] values() {
        return (UnSelectableToastType[]) f364694a.clone();
    }

    public static UnSelectableToastType valueOf(String r100) {
        return (UnSelectableToastType) r27.a.a(UnSelectableToastType.class, r100);
    }

    public UnSelectableToastType(String r100, int r101) {
        super(r100, r101);
    }
}
