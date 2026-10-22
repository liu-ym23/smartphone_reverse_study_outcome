package com.bytedance.android.shopping.order.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/order/dto/SurveyRequest;", "Ljava/io/Serializable;", "()V", "content", "", "", "getContent", "()Ljava/util/List;", "setContent", "(Ljava/util/List;)V", "id", "", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "status", "getStatus", "setStatus", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SurveyRequest implements Serializable {

    @SerializedName("content")
    private List<String> content;

    @SerializedName("id")
    private Long id;

    @SerializedName("status")
    private Long status;

    public SurveyRequest() {
    }

    public final List<String> getContent() {
        return this.content;
    }

    public final Long getId() {
        return this.id;
    }

    public final Long getStatus() {
        return this.status;
    }

    public final void setContent(List<String> r1) {
        this.content = r1;
    }

    public final void setId(Long r1) {
        this.id = r1;
    }

    public final void setStatus(Long r1) {
        this.status = r1;
    }
}
