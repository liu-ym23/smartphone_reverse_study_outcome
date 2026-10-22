package com.ss.android.lark.biz.officesdk.im.mediapreview;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/biz/officesdk/im/mediapreview/GalleryItemType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "Lark", "Doubao", "officesdk-im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum GalleryItemType extends Enum<GalleryItemType> {
    public static final GalleryItemType Doubao = null;
    public static final GalleryItemType Lark = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GalleryItemType[] f410597a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410598b = null;
    private final int type;

    public static EnumEntries<GalleryItemType> getEntries() {
        return f410598b;
    }

    static {
        GalleryItemType r100 = new GalleryItemType("Lark", 0, 1);
        Lark = r100;
        GalleryItemType r101 = new GalleryItemType("Doubao", 1, 2);
        Doubao = r101;
        GalleryItemType[] r102 = {r100, r101};
        f410597a = r102;
        f410598b = EnumEntriesKt.enumEntries(r102);
    }

    public static GalleryItemType[] values() {
        return (GalleryItemType[]) f410597a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static GalleryItemType valueOf(String r100) {
        return (GalleryItemType) a.a(GalleryItemType.class, r100);
    }

    public GalleryItemType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
