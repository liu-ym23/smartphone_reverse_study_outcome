package com.bytedance.creativex.mediaimport.repository.api;

import android.net.Uri;
import android.provider.MediaStore;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/creativex/mediaimport/repository/api/MediaType;", "", "contentUri", "Landroid/net/Uri;", "<init>", "(Ljava/lang/String;ILandroid/net/Uri;)V", "getContentUri", "()Landroid/net/Uri;", "IMAGE", "VIDEO", "feature-media-import-repository_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MediaType extends Enum<MediaType> {
    public static final MediaType IMAGE = null;
    public static final MediaType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MediaType[] f203613a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f203614b = null;
    private final Uri contentUri;

    public static EnumEntries<MediaType> getEntries() {
        return f203614b;
    }

    static {
        MediaType r100 = new MediaType("IMAGE", 0, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        IMAGE = r100;
        MediaType r101 = new MediaType("VIDEO", 1, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
        VIDEO = r101;
        MediaType[] r102 = {r100, r101};
        f203613a = r102;
        f203614b = EnumEntriesKt.enumEntries(r102);
    }

    public static MediaType[] values() {
        return (MediaType[]) f203613a.clone();
    }

    public final Uri getContentUri() {
        return this.contentUri;
    }

    public static MediaType valueOf(String r100) {
        return (MediaType) r27.a.a(MediaType.class, r100);
    }

    public MediaType(String r100, int r101, Uri r102) {
        super(r100, r101);
        this.contentUri = r102;
    }
}
