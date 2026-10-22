package com.ss.android.lark.biz.officesdk.im.mediapreview;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/biz/officesdk/im/mediapreview/GalleryImageType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "Thumbnail", "Middle", "Origin", "officesdk-im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum GalleryImageType extends Enum<GalleryImageType> {
    public static final GalleryImageType Middle = null;
    public static final GalleryImageType Origin = null;
    public static final GalleryImageType Thumbnail = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GalleryImageType[] f410595a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410596b = null;
    private final int type;

    public static EnumEntries<GalleryImageType> getEntries() {
        return f410596b;
    }

    static {
        GalleryImageType r100 = new GalleryImageType("Thumbnail", 0, 1);
        Thumbnail = r100;
        GalleryImageType r101 = new GalleryImageType("Middle", 1, 2);
        Middle = r101;
        GalleryImageType r102 = new GalleryImageType("Origin", 2, 3);
        Origin = r102;
        GalleryImageType[] r103 = {r100, r101, r102};
        f410595a = r103;
        f410596b = EnumEntriesKt.enumEntries(r103);
    }

    public static GalleryImageType[] values() {
        return (GalleryImageType[]) f410595a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static GalleryImageType valueOf(String r100) {
        return (GalleryImageType) a.a(GalleryImageType.class, r100);
    }

    public GalleryImageType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
