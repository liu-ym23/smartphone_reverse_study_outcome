package com.larus.bmhome.chat.layout.holder.progressloading;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/chat/layout/holder/progressloading/ImageLoadingDrawPartType;", "", "<init>", "(Ljava/lang/String;I)V", "LEFT_TOP_PART", "RIGHT_TOP_PART", "LEFT_BOTTOM_PART", "RIGHT_BOTTOM_PART", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ImageLoadingDrawPartType extends Enum<ImageLoadingDrawPartType> {
    public static final ImageLoadingDrawPartType LEFT_BOTTOM_PART = null;
    public static final ImageLoadingDrawPartType LEFT_TOP_PART = null;
    public static final ImageLoadingDrawPartType RIGHT_BOTTOM_PART = null;
    public static final ImageLoadingDrawPartType RIGHT_TOP_PART = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ImageLoadingDrawPartType[] f304019a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f304020b = null;

    public static EnumEntries<ImageLoadingDrawPartType> getEntries() {
        return f304020b;
    }

    static {
        ImageLoadingDrawPartType r100 = new ImageLoadingDrawPartType("LEFT_TOP_PART", 0);
        LEFT_TOP_PART = r100;
        ImageLoadingDrawPartType r101 = new ImageLoadingDrawPartType("RIGHT_TOP_PART", 1);
        RIGHT_TOP_PART = r101;
        ImageLoadingDrawPartType r102 = new ImageLoadingDrawPartType("LEFT_BOTTOM_PART", 2);
        LEFT_BOTTOM_PART = r102;
        ImageLoadingDrawPartType r103 = new ImageLoadingDrawPartType("RIGHT_BOTTOM_PART", 3);
        RIGHT_BOTTOM_PART = r103;
        ImageLoadingDrawPartType[] r104 = {r100, r101, r102, r103};
        f304019a = r104;
        f304020b = EnumEntriesKt.enumEntries(r104);
    }

    public static ImageLoadingDrawPartType[] values() {
        return (ImageLoadingDrawPartType[]) f304019a.clone();
    }

    public static ImageLoadingDrawPartType valueOf(String r100) {
        return (ImageLoadingDrawPartType) r27.a.a(ImageLoadingDrawPartType.class, r100);
    }

    public ImageLoadingDrawPartType(String r100, int r101) {
        super(r100, r101);
    }
}
