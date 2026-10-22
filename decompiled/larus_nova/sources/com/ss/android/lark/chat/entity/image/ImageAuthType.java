package com.ss.android.lark.chat.entity.image;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/chat/entity/image/ImageAuthType;", "", "<init>", "(Ljava/lang/String;I)V", "PREVIEW_AUTH", "SHARE_AUTH", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ImageAuthType extends Enum<ImageAuthType> {
    public static final ImageAuthType PREVIEW_AUTH = null;
    public static final ImageAuthType SHARE_AUTH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ImageAuthType[] f415204a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f415205b = null;

    public static EnumEntries<ImageAuthType> getEntries() {
        return f415205b;
    }

    static {
        ImageAuthType r100 = new ImageAuthType("PREVIEW_AUTH", 0);
        PREVIEW_AUTH = r100;
        ImageAuthType r101 = new ImageAuthType("SHARE_AUTH", 1);
        SHARE_AUTH = r101;
        ImageAuthType[] r102 = {r100, r101};
        f415204a = r102;
        f415205b = EnumEntriesKt.enumEntries(r102);
    }

    public static ImageAuthType[] values() {
        return (ImageAuthType[]) f415204a.clone();
    }

    public static ImageAuthType valueOf(String r100) {
        return (ImageAuthType) r27.a.a(ImageAuthType.class, r100);
    }

    public ImageAuthType(String r100, int r101) {
        super(r100, r101);
    }
}
