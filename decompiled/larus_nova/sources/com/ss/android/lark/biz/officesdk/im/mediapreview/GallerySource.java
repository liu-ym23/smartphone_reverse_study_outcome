package com.ss.android.lark.biz.officesdk.im.mediapreview;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/biz/officesdk/im/mediapreview/GallerySource;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "Chat", "ReplayThread", "MergeForward", "officesdk-im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum GallerySource extends Enum<GallerySource> {
    public static final GallerySource Chat = null;
    public static final GallerySource DEFAULT = null;
    public static final GallerySource MergeForward = null;
    public static final GallerySource ReplayThread = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GallerySource[] f410599a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410600b = null;

    public static EnumEntries<GallerySource> getEntries() {
        return f410600b;
    }

    static {
        GallerySource r100 = new GallerySource("DEFAULT", 0);
        DEFAULT = r100;
        GallerySource r101 = new GallerySource("Chat", 1);
        Chat = r101;
        GallerySource r102 = new GallerySource("ReplayThread", 2);
        ReplayThread = r102;
        GallerySource r103 = new GallerySource("MergeForward", 3);
        MergeForward = r103;
        GallerySource[] r104 = {r100, r101, r102, r103};
        f410599a = r104;
        f410600b = EnumEntriesKt.enumEntries(r104);
    }

    public static GallerySource[] values() {
        return (GallerySource[]) f410599a.clone();
    }

    public static GallerySource valueOf(String r100) {
        return (GallerySource) a.a(GallerySource.class, r100);
    }

    public GallerySource(String r100, int r101) {
        super(r100, r101);
    }
}
