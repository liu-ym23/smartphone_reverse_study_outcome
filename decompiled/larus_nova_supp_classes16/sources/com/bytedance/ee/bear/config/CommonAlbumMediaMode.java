package com.bytedance.ee.bear.config;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/config/CommonAlbumMediaMode;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE_ONLY", "VIDEO_ONLY", "ALL", "docs-document-sdk-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CommonAlbumMediaMode extends Enum<CommonAlbumMediaMode> {
    public static final CommonAlbumMediaMode ALL = null;
    public static final CommonAlbumMediaMode IMAGE_ONLY = null;
    public static final CommonAlbumMediaMode VIDEO_ONLY = null;
    public static final /* synthetic */ CommonAlbumMediaMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CommonAlbumMediaMode> getEntries() {
        return b;
    }

    static {
        CommonAlbumMediaMode r0 = new CommonAlbumMediaMode("IMAGE_ONLY", 0);
        IMAGE_ONLY = r0;
        CommonAlbumMediaMode r1 = new CommonAlbumMediaMode("VIDEO_ONLY", 1);
        VIDEO_ONLY = r1;
        CommonAlbumMediaMode r3 = new CommonAlbumMediaMode("ALL", 2);
        ALL = r3;
        CommonAlbumMediaMode[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static CommonAlbumMediaMode[] values() {
        return (CommonAlbumMediaMode[]) a.clone();
    }

    public static CommonAlbumMediaMode valueOf(String r1) {
        return (CommonAlbumMediaMode) a.a(CommonAlbumMediaMode.class, r1);
    }

    public CommonAlbumMediaMode(String r1, int r2) {
        super(r1, r2);
    }
}
