package com.ss.android.lark.biz.officesdk.im.preview;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/biz/officesdk/im/preview/UrlPreviewCardType;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "COMPACT", "officesdk-im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UrlPreviewCardType extends Enum<UrlPreviewCardType> {
    public static final UrlPreviewCardType COMPACT = null;
    public static final UrlPreviewCardType DEFAULT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UrlPreviewCardType[] f410611a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410612b = null;

    public static EnumEntries<UrlPreviewCardType> getEntries() {
        return f410612b;
    }

    static {
        UrlPreviewCardType r100 = new UrlPreviewCardType("DEFAULT", 0);
        DEFAULT = r100;
        UrlPreviewCardType r101 = new UrlPreviewCardType("COMPACT", 1);
        COMPACT = r101;
        UrlPreviewCardType[] r102 = {r100, r101};
        f410611a = r102;
        f410612b = EnumEntriesKt.enumEntries(r102);
    }

    public static UrlPreviewCardType[] values() {
        return (UrlPreviewCardType[]) f410611a.clone();
    }

    public static UrlPreviewCardType valueOf(String r100) {
        return (UrlPreviewCardType) a.a(UrlPreviewCardType.class, r100);
    }

    public UrlPreviewCardType(String r100, int r101) {
        super(r100, r101);
    }
}
