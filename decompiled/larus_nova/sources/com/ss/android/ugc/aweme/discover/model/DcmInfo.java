package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R$\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/DcmInfo;", "Ljava/io/Serializable;", "()V", "dcm", "", "getDcm", "()Ljava/lang/String;", "dcmExtra", "", "", "getDcmExtra", "()Ljava/util/Map;", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DcmInfo implements Serializable {

    @SerializedName("dcm")
    private final String dcm;

    @SerializedName("dcm_extra")
    private final Map<String, Object> dcmExtra;

    public DcmInfo() {
    }

    public final String getDcm() {
        return this.dcm;
    }

    public final Map<String, Object> getDcmExtra() {
        return this.dcmExtra;
    }
}
