package com.bytedance.live.livelink.kmp.impl.core.link;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/live/livelink/kmp/impl/core/link/FailCategory;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "LINK_BIZ", "LINK_RTC", "live-link-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum FailCategory extends Enum<FailCategory> {
    public static final FailCategory LINK_BIZ = null;
    public static final FailCategory LINK_RTC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FailCategory[] f255402a = null;
    private final String value;

    static {
        FailCategory r100 = new FailCategory("LINK_BIZ", 0, "link_biz");
        LINK_BIZ = r100;
        FailCategory r101 = new FailCategory("LINK_RTC", 1, "link_rtc");
        LINK_RTC = r101;
        f255402a = new FailCategory[]{r100, r101};
    }

    public static FailCategory valueOf(String r100) {
        return (FailCategory) r27.a.a(FailCategory.class, r100);
    }

    public static FailCategory[] values() {
        return (FailCategory[]) f255402a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public FailCategory(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
