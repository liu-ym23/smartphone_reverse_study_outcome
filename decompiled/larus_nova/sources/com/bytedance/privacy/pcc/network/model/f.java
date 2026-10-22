package com.bytedance.privacy.pcc.network.model;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes21.dex */
public class f {

    @SerializedName("service_pod_desc")
    private String servicePodDesc;

    @SerializedName("service_pod_evidence")
    private String servicePodEvidence;

    @SerializedName("service_pod_evidence_time")
    private long servicePodEvidenceTime;

    @SerializedName("service_pod_id")
    private String servicePodId;

    @SerializedName("service_pod_tlog")
    private JsonObject servicePodTlog;

    public f() {
    }
}
