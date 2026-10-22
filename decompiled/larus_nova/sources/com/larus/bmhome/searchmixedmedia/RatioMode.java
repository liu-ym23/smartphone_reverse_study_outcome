package com.larus.bmhome.searchmixedmedia;

import com.ss.android.lark.banner.export.entity.BannerBizName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/searchmixedmedia/RatioMode;", "", "<init>", "(Ljava/lang/String;I)V", "FIXED", BannerBizName.DYNAMIC, "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RatioMode extends Enum<RatioMode> {
    public static final RatioMode DYNAMIC = null;
    public static final RatioMode FIXED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RatioMode[] f313798a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f313799b = null;

    public static EnumEntries<RatioMode> getEntries() {
        return f313799b;
    }

    static {
        RatioMode r100 = new RatioMode("FIXED", 0);
        FIXED = r100;
        RatioMode r101 = new RatioMode(BannerBizName.DYNAMIC, 1);
        DYNAMIC = r101;
        RatioMode[] r102 = {r100, r101};
        f313798a = r102;
        f313799b = EnumEntriesKt.enumEntries(r102);
    }

    public static RatioMode[] values() {
        return (RatioMode[]) f313798a.clone();
    }

    public static RatioMode valueOf(String r100) {
        return (RatioMode) a.a(RatioMode.class, r100);
    }

    public RatioMode(String r100, int r101) {
        super(r100, r101);
    }
}
