package com.larus.photopicker.v2.impl.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/photopicker/v2/impl/model/MediaViewType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "ITEM", "HEADER", "FOOTER", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MediaViewType extends Enum<MediaViewType> {
    public static final MediaViewType FOOTER = null;
    public static final MediaViewType HEADER = null;
    public static final MediaViewType ITEM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MediaViewType[] f364546a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f364547b = null;
    private final int type;

    public static EnumEntries<MediaViewType> getEntries() {
        return f364547b;
    }

    static {
        MediaViewType r100 = new MediaViewType("ITEM", 0, 0);
        ITEM = r100;
        MediaViewType r101 = new MediaViewType("HEADER", 1, 1001);
        HEADER = r101;
        MediaViewType r102 = new MediaViewType("FOOTER", 2, 1002);
        FOOTER = r102;
        MediaViewType[] r103 = {r100, r101, r102};
        f364546a = r103;
        f364547b = EnumEntriesKt.enumEntries(r103);
    }

    public static MediaViewType[] values() {
        return (MediaViewType[]) f364546a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static MediaViewType valueOf(String r100) {
        return (MediaViewType) a.a(MediaViewType.class, r100);
    }

    public MediaViewType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
