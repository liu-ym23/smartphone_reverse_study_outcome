package com.bytedance.ug.sdk.luckydog.base.container.backtopage;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ug/sdk/luckydog/base/container/backtopage/PageEntryType;", "", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "HOST_TAB", "SDK_PAGE", "X_TAB", "MULTI_TAB", "luckydog_release"}, k = 1, mv = {1, 4, 0})
public final enum PageEntryType extends Enum<PageEntryType> {
    public static final PageEntryType HOST_TAB = null;
    public static final PageEntryType MULTI_TAB = null;
    public static final PageEntryType SDK_PAGE = null;
    public static final PageEntryType X_TAB = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PageEntryType[] f271725a = null;
    private final String desc;

    static {
        PageEntryType r100 = new PageEntryType("HOST_TAB", 0, "hostTab");
        HOST_TAB = r100;
        PageEntryType r101 = new PageEntryType("SDK_PAGE", 1, "sdkPage");
        SDK_PAGE = r101;
        PageEntryType r102 = new PageEntryType("X_TAB", 2, "xTab");
        X_TAB = r102;
        PageEntryType r103 = new PageEntryType("MULTI_TAB", 3, "multiTab");
        MULTI_TAB = r103;
        f271725a = new PageEntryType[]{r100, r101, r102, r103};
    }

    public static PageEntryType valueOf(String r100) {
        return (PageEntryType) a.a(PageEntryType.class, r100);
    }

    public static PageEntryType[] values() {
        return (PageEntryType[]) f271725a.clone();
    }

    public final String getDesc() {
        return this.desc;
    }

    public PageEntryType(String r100, int r101, String r102) {
        super(r100, r101);
        this.desc = r102;
    }
}
