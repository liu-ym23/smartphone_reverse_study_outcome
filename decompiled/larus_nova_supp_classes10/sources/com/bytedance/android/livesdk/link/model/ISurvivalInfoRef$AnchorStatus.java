package com.bytedance.android.livesdk.link.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"com/bytedance/android/livesdk/link/model/ISurvivalInfoRef$AnchorStatus", "", "Lcom/bytedance/android/livesdk/link/model/ISurvivalInfoRef$AnchorStatus;", "Default", "Out", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ISurvivalInfoRef$AnchorStatus extends Enum<ISurvivalInfoRef$AnchorStatus> {
    public static final ISurvivalInfoRef$AnchorStatus Default = null;
    public static final ISurvivalInfoRef$AnchorStatus Out = null;
    public static final /* synthetic */ ISurvivalInfoRef$AnchorStatus[] a = null;

    static {
        ISurvivalInfoRef$AnchorStatus r1 = new ISurvivalInfoRef$AnchorStatus("Default", 0);
        Default = r1;
        ISurvivalInfoRef$AnchorStatus r2 = new ISurvivalInfoRef$AnchorStatus("Out", 1);
        Out = r2;
        a = new ISurvivalInfoRef$AnchorStatus[]{r1, r2};
    }

    public static ISurvivalInfoRef$AnchorStatus valueOf(String r1) {
        return (ISurvivalInfoRef$AnchorStatus) r27.a.a(ISurvivalInfoRef$AnchorStatus.class, r1);
    }

    public static ISurvivalInfoRef$AnchorStatus[] values() {
        return (ISurvivalInfoRef$AnchorStatus[]) a.clone();
    }

    public ISurvivalInfoRef$AnchorStatus(String r1, int r2) {
        super(r1, r2);
    }
}
