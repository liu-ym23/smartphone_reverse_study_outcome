package com.larus.bmhome.chat.layout.holder.progressloading;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/bmhome/chat/layout/holder/progressloading/LoadingType;", "", "<init>", "(Ljava/lang/String;I)V", "COMMON_LOADING", "TEXT_PROGRESS_LOADING", "IMAGE_SCROLL_LOADING", "SINGLE_IMAGE_LOADING", "IMAGE4_LOADING", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LoadingType extends Enum<LoadingType> {
    public static final LoadingType COMMON_LOADING = null;
    public static final LoadingType IMAGE4_LOADING = null;
    public static final LoadingType IMAGE_SCROLL_LOADING = null;
    public static final LoadingType SINGLE_IMAGE_LOADING = null;
    public static final LoadingType TEXT_PROGRESS_LOADING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoadingType[] f304028a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f304029b = null;

    public static EnumEntries<LoadingType> getEntries() {
        return f304029b;
    }

    static {
        LoadingType r100 = new LoadingType("COMMON_LOADING", 0);
        COMMON_LOADING = r100;
        LoadingType r101 = new LoadingType("TEXT_PROGRESS_LOADING", 1);
        TEXT_PROGRESS_LOADING = r101;
        LoadingType r102 = new LoadingType("IMAGE_SCROLL_LOADING", 2);
        IMAGE_SCROLL_LOADING = r102;
        LoadingType r103 = new LoadingType("SINGLE_IMAGE_LOADING", 3);
        SINGLE_IMAGE_LOADING = r103;
        LoadingType r104 = new LoadingType("IMAGE4_LOADING", 4);
        IMAGE4_LOADING = r104;
        LoadingType[] r105 = {r100, r101, r102, r103, r104};
        f304028a = r105;
        f304029b = EnumEntriesKt.enumEntries(r105);
    }

    public static LoadingType[] values() {
        return (LoadingType[]) f304028a.clone();
    }

    public static LoadingType valueOf(String r100) {
        return (LoadingType) r27.a.a(LoadingType.class, r100);
    }

    public LoadingType(String r100, int r101) {
        super(r100, r101);
    }
}
