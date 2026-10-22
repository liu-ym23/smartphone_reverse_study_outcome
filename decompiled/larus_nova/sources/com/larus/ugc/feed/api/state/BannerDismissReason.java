package com.larus.ugc.feed.api.state;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/ugc/feed/api/state/BannerDismissReason;", "", "<init>", "(Ljava/lang/String;I)V", "CLICK_ACTION", "CLICK_DISMISS", "AUTO_DISMISS", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BannerDismissReason extends Enum<BannerDismissReason> {
    public static final BannerDismissReason AUTO_DISMISS = null;
    public static final BannerDismissReason CLICK_ACTION = null;
    public static final BannerDismissReason CLICK_DISMISS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BannerDismissReason[] f374378a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f374379b = null;

    public static EnumEntries<BannerDismissReason> getEntries() {
        return f374379b;
    }

    static {
        BannerDismissReason r100 = new BannerDismissReason("CLICK_ACTION", 0);
        CLICK_ACTION = r100;
        BannerDismissReason r101 = new BannerDismissReason("CLICK_DISMISS", 1);
        CLICK_DISMISS = r101;
        BannerDismissReason r102 = new BannerDismissReason("AUTO_DISMISS", 2);
        AUTO_DISMISS = r102;
        BannerDismissReason[] r103 = {r100, r101, r102};
        f374378a = r103;
        f374379b = EnumEntriesKt.enumEntries(r103);
    }

    public static BannerDismissReason[] values() {
        return (BannerDismissReason[]) f374378a.clone();
    }

    public static BannerDismissReason valueOf(String r100) {
        return (BannerDismissReason) a.a(BannerDismissReason.class, r100);
    }

    public BannerDismissReason(String r100, int r101) {
        super(r100, r101);
    }
}
