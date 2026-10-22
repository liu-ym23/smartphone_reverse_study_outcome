package com.larus.gallery.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/gallery/api/DisplayGravity;", "", "<init>", "(Ljava/lang/String;I)V", "CENTER", "TOP", "gallery_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DisplayGravity extends Enum<DisplayGravity> {
    public static final DisplayGravity CENTER = null;
    public static final DisplayGravity TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DisplayGravity[] f343792a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f343793b = null;

    public static EnumEntries<DisplayGravity> getEntries() {
        return f343793b;
    }

    static {
        DisplayGravity r100 = new DisplayGravity("CENTER", 0);
        CENTER = r100;
        DisplayGravity r101 = new DisplayGravity("TOP", 1);
        TOP = r101;
        DisplayGravity[] r102 = {r100, r101};
        f343792a = r102;
        f343793b = EnumEntriesKt.enumEntries(r102);
    }

    public static DisplayGravity[] values() {
        return (DisplayGravity[]) f343792a.clone();
    }

    public static DisplayGravity valueOf(String r100) {
        return (DisplayGravity) r27.a.a(DisplayGravity.class, r100);
    }

    public DisplayGravity(String r100, int r101) {
        super(r100, r101);
    }
}
