package com.bytedance.ee.bear.config;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/config/CommonAlbumMediaMode;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE_ONLY", "VIDEO_ONLY", AccountType.ALL, "docs-document-sdk-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CommonAlbumMediaMode extends Enum<CommonAlbumMediaMode> {
    public static final CommonAlbumMediaMode ALL = null;
    public static final CommonAlbumMediaMode IMAGE_ONLY = null;
    public static final CommonAlbumMediaMode VIDEO_ONLY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CommonAlbumMediaMode[] f216702a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f216703b = null;

    public static EnumEntries<CommonAlbumMediaMode> getEntries() {
        return f216703b;
    }

    static {
        CommonAlbumMediaMode r100 = new CommonAlbumMediaMode("IMAGE_ONLY", 0);
        IMAGE_ONLY = r100;
        CommonAlbumMediaMode r101 = new CommonAlbumMediaMode("VIDEO_ONLY", 1);
        VIDEO_ONLY = r101;
        CommonAlbumMediaMode r102 = new CommonAlbumMediaMode(AccountType.ALL, 2);
        ALL = r102;
        CommonAlbumMediaMode[] r103 = {r100, r101, r102};
        f216702a = r103;
        f216703b = EnumEntriesKt.enumEntries(r103);
    }

    public static CommonAlbumMediaMode[] values() {
        return (CommonAlbumMediaMode[]) f216702a.clone();
    }

    public static CommonAlbumMediaMode valueOf(String r100) {
        return (CommonAlbumMediaMode) a.a(CommonAlbumMediaMode.class, r100);
    }

    public CommonAlbumMediaMode(String r100, int r101) {
        super(r100, r101);
    }
}
