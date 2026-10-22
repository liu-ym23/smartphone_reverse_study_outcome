package com.larus.photopicker.v2.impl.ui;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/photopicker/v2/impl/ui/ClickType;", "", "<init>", "(Ljava/lang/String;I)V", "ITEM", "SELECT", "ADD_MORE_PHOTO", "ON_FIRST_IMAGE_LOAD_SUCCESS", "ON_FIRST_IMAGE_LOAD_FAILURE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ClickType extends Enum<ClickType> {
    public static final ClickType ADD_MORE_PHOTO = null;
    public static final ClickType ITEM = null;
    public static final ClickType ON_FIRST_IMAGE_LOAD_FAILURE = null;
    public static final ClickType ON_FIRST_IMAGE_LOAD_SUCCESS = null;
    public static final ClickType SELECT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ClickType[] f364613a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f364614b = null;

    public static EnumEntries<ClickType> getEntries() {
        return f364614b;
    }

    static {
        ClickType r100 = new ClickType("ITEM", 0);
        ITEM = r100;
        ClickType r101 = new ClickType("SELECT", 1);
        SELECT = r101;
        ClickType r102 = new ClickType("ADD_MORE_PHOTO", 2);
        ADD_MORE_PHOTO = r102;
        ClickType r103 = new ClickType("ON_FIRST_IMAGE_LOAD_SUCCESS", 3);
        ON_FIRST_IMAGE_LOAD_SUCCESS = r103;
        ClickType r104 = new ClickType("ON_FIRST_IMAGE_LOAD_FAILURE", 4);
        ON_FIRST_IMAGE_LOAD_FAILURE = r104;
        ClickType[] r105 = {r100, r101, r102, r103, r104};
        f364613a = r105;
        f364614b = EnumEntriesKt.enumEntries(r105);
    }

    public static ClickType[] values() {
        return (ClickType[]) f364613a.clone();
    }

    public static ClickType valueOf(String r100) {
        return (ClickType) a.a(ClickType.class, r100);
    }

    public ClickType(String r100, int r101) {
        super(r100, r101);
    }
}
