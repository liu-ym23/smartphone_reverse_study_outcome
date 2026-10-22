package com.bytedance.android.shopping.feed.repository.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/feed/repository/api/ReqFeedbackPanelDataViewType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "VIDEO_INNER_FLOW", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ReqFeedbackPanelDataViewType extends Enum<ReqFeedbackPanelDataViewType> {
    public static final ReqFeedbackPanelDataViewType VIDEO_INNER_FLOW = null;
    public static final /* synthetic */ ReqFeedbackPanelDataViewType[] a = null;
    private final String type;

    static {
        ReqFeedbackPanelDataViewType r1 = new ReqFeedbackPanelDataViewType();
        VIDEO_INNER_FLOW = r1;
        a = new ReqFeedbackPanelDataViewType[]{r1};
    }

    public static ReqFeedbackPanelDataViewType valueOf(String r1) {
        return (ReqFeedbackPanelDataViewType) a.a(ReqFeedbackPanelDataViewType.class, r1);
    }

    public static ReqFeedbackPanelDataViewType[] values() {
        return (ReqFeedbackPanelDataViewType[]) a.clone();
    }

    public ReqFeedbackPanelDataViewType() {
        super("VIDEO_INNER_FLOW", 0);
        this.type = "video_inner_flow";
    }

    public final String getType() {
        return this.type;
    }
}
