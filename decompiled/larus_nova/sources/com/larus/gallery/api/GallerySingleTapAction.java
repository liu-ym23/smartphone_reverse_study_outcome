package com.larus.gallery.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/gallery/api/GallerySingleTapAction;", "", "<init>", "(Ljava/lang/String;I)V", "TOGGLE_CHROME", "TOGGLE_VIDEO_PLAYBACK", "gallery_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum GallerySingleTapAction extends Enum<GallerySingleTapAction> {
    public static final GallerySingleTapAction TOGGLE_CHROME = null;
    public static final GallerySingleTapAction TOGGLE_VIDEO_PLAYBACK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GallerySingleTapAction[] f343810a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f343811b = null;

    public static EnumEntries<GallerySingleTapAction> getEntries() {
        return f343811b;
    }

    static {
        GallerySingleTapAction r100 = new GallerySingleTapAction("TOGGLE_CHROME", 0);
        TOGGLE_CHROME = r100;
        GallerySingleTapAction r101 = new GallerySingleTapAction("TOGGLE_VIDEO_PLAYBACK", 1);
        TOGGLE_VIDEO_PLAYBACK = r101;
        GallerySingleTapAction[] r102 = {r100, r101};
        f343810a = r102;
        f343811b = EnumEntriesKt.enumEntries(r102);
    }

    public static GallerySingleTapAction[] values() {
        return (GallerySingleTapAction[]) f343810a.clone();
    }

    public static GallerySingleTapAction valueOf(String r100) {
        return (GallerySingleTapAction) r27.a.a(GallerySingleTapAction.class, r100);
    }

    public GallerySingleTapAction(String r100, int r101) {
        super(r100, r101);
    }
}
