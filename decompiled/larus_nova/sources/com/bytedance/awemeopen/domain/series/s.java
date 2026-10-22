package com.bytedance.awemeopen.domain.series;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/awemeopen/domain/series/s;", "Ln14/a;", "", "logId", "Ljava/lang/String;", "getLogId", "()Ljava/lang/String;", "setLogId", "(Ljava/lang/String;)V", "extra", "getExtra", "setExtra", "Lcom/bytedance/awemeopen/domain/series/n;", "priceDetail", "Lcom/bytedance/awemeopen/domain/series/n;", "getPriceDetail", "()Lcom/bytedance/awemeopen/domain/series/n;", "setPriceDetail", "(Lcom/bytedance/awemeopen/domain/series/n;)V", "<init>", "()V", "ao_domain_release"}, k = 1, mv = {1, 7, 1})
public final class s extends n14.a {

    @SerializedName("extra")
    private String extra;

    @SerializedName("log_id")
    private String logId;

    @SerializedName("price_details")
    private n priceDetail;

    public s() {
        this.logId = "";
        this.extra = "";
    }
}
