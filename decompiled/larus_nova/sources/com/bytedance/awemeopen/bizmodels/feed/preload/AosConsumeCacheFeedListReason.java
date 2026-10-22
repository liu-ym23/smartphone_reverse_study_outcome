package com.bytedance.awemeopen.bizmodels.feed.preload;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/preload/AosConsumeCacheFeedListReason;", "", "", "reason", "Ljava/lang/String;", "getReason", "()Ljava/lang/String;", "SDK_USER_CHANGED_DISCARD", "RECOMMEND_PAGE_CONSUME", "RECOMMEND_PACK_CONSUME", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final enum AosConsumeCacheFeedListReason extends Enum<AosConsumeCacheFeedListReason> {
    public static final AosConsumeCacheFeedListReason RECOMMEND_PACK_CONSUME = null;
    public static final AosConsumeCacheFeedListReason RECOMMEND_PAGE_CONSUME = null;
    public static final AosConsumeCacheFeedListReason SDK_USER_CHANGED_DISCARD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AosConsumeCacheFeedListReason[] f198195a = null;
    private final String reason;

    public static AosConsumeCacheFeedListReason valueOf(String r100) {
        return (AosConsumeCacheFeedListReason) a.a(AosConsumeCacheFeedListReason.class, r100);
    }

    public static AosConsumeCacheFeedListReason[] values() {
        return (AosConsumeCacheFeedListReason[]) f198195a.clone();
    }

    static {
        AosConsumeCacheFeedListReason r100 = new AosConsumeCacheFeedListReason("SDK_USER_CHANGED_DISCARD", 0, "sdk_user_changed_discard");
        SDK_USER_CHANGED_DISCARD = r100;
        AosConsumeCacheFeedListReason r101 = new AosConsumeCacheFeedListReason("RECOMMEND_PAGE_CONSUME", 1, "recommend_page_consume");
        RECOMMEND_PAGE_CONSUME = r101;
        AosConsumeCacheFeedListReason r102 = new AosConsumeCacheFeedListReason("RECOMMEND_PACK_CONSUME", 2, "recommend_pack_consume");
        RECOMMEND_PACK_CONSUME = r102;
        f198195a = new AosConsumeCacheFeedListReason[]{r100, r101, r102};
    }

    public final String getReason() {
        return this.reason;
    }

    public AosConsumeCacheFeedListReason(String r100, int r101, String r102) {
        super(r100, r101);
        this.reason = r102;
    }
}
