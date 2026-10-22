package com.ss.android.lark.biz.officesdk.im.mediapreview;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/biz/officesdk/im/mediapreview/GalleryType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "Image", "Video", "officesdk-im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum GalleryType extends Enum<GalleryType> {
    public static final GalleryType Image = null;
    public static final GalleryType Video = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GalleryType[] f410601a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410602b = null;
    private final int type;

    public static EnumEntries<GalleryType> getEntries() {
        return f410602b;
    }

    static {
        GalleryType r100 = new GalleryType("Image", 0, 1);
        Image = r100;
        GalleryType r101 = new GalleryType("Video", 1, 2);
        Video = r101;
        GalleryType[] r102 = {r100, r101};
        f410601a = r102;
        f410602b = EnumEntriesKt.enumEntries(r102);
    }

    public static GalleryType[] values() {
        return (GalleryType[]) f410601a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static GalleryType valueOf(String r100) {
        return (GalleryType) a.a(GalleryType.class, r100);
    }

    public GalleryType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
