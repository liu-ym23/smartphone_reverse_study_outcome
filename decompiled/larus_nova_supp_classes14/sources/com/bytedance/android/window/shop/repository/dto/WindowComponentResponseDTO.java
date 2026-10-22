package com.bytedance.android.window.shop.repository.dto;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/WindowComponentResponseDTO;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "Ljava/io/Serializable;", "", "Lcom/bytedance/android/ec/window/base/repository/dto/s;", "components", "Ljava/util/List;", "getComponents", "()Ljava/util/List;", "", "", "logExtra", "Ljava/util/Map;", "getLogExtra", "()Ljava/util/Map;", "extraSchema", "Ljava/lang/String;", "getExtraSchema", "()Ljava/lang/String;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowComponentResponseDTO extends CommerceBaseResponse {

    @SerializedName("components")
    private final List<com.bytedance.android.ec.window.base.repository.dto.s> components;

    @SerializedName("extra_schema")
    private final String extraSchema;

    @SerializedName("log_extra")
    private final Map<String, String> logExtra;

    public WindowComponentResponseDTO() {
    }

    public final List<com.bytedance.android.ec.window.base.repository.dto.s> getComponents() {
        return this.components;
    }

    public final String getExtraSchema() {
        return this.extraSchema;
    }

    public final Map<String, String> getLogExtra() {
        return this.logExtra;
    }
}
