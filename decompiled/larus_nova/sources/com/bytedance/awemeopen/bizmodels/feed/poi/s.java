package com.bytedance.awemeopen.bizmodels.feed.poi;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/poi/s;", "", "", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Lt14/a;", "urlModel", "Lt14/a;", "getUrlModel", "()Lt14/a;", "setUrlModel", "(Lt14/a;)V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class s {

    @SerializedName("service_type")
    private Integer type;

    @SerializedName("icon")
    private t14.a urlModel;

    public s() {
        this.type = null;
        this.urlModel = null;
    }

    public final Integer getType() {
        return this.type;
    }
}
