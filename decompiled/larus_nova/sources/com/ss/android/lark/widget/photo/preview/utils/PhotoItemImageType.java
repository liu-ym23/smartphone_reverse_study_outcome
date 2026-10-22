package com.ss.android.lark.widget.photo.preview.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/widget/photo/preview/utils/PhotoItemImageType;", "", "<init>", "(Ljava/lang/String;I)V", "Thumbnail", "Middle", "Origin", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PhotoItemImageType extends Enum<PhotoItemImageType> {
    public static final PhotoItemImageType Middle = null;
    public static final PhotoItemImageType Origin = null;
    public static final PhotoItemImageType Thumbnail = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PhotoItemImageType[] f447134a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f447135b = null;

    public static EnumEntries<PhotoItemImageType> getEntries() {
        return f447135b;
    }

    static {
        PhotoItemImageType r100 = new PhotoItemImageType("Thumbnail", 0);
        Thumbnail = r100;
        PhotoItemImageType r101 = new PhotoItemImageType("Middle", 1);
        Middle = r101;
        PhotoItemImageType r102 = new PhotoItemImageType("Origin", 2);
        Origin = r102;
        PhotoItemImageType[] r103 = {r100, r101, r102};
        f447134a = r103;
        f447135b = EnumEntriesKt.enumEntries(r103);
    }

    public static PhotoItemImageType[] values() {
        return (PhotoItemImageType[]) f447134a.clone();
    }

    public static PhotoItemImageType valueOf(String r100) {
        return (PhotoItemImageType) r27.a.a(PhotoItemImageType.class, r100);
    }

    public PhotoItemImageType(String r100, int r101) {
        super(r100, r101);
    }
}
