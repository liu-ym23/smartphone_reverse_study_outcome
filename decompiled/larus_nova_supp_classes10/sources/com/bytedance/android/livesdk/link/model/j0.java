package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001a\u0010\f\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0004R$\u0010\u0010\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\r\u0010\u0004\"\u0004\b\u000e\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\b\u001a\u0004\b\u0011\u0010\u0004¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/j0;", "Lvh7/c;", "", "getReason", "()Ljava/lang/String;", "setReason", "(Ljava/lang/String;)V", "getReason$annotations", "()V", "reason", "getUrl", "getUrl$annotations", "url", "getUserId", "setUserId", "getUserId$annotations", "userId", "getSchemaUrl", "getSchemaUrl$annotations", "schemaUrl", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface j0 extends vh7.c<j0> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "reason")
    String getReason();

    @FieldName(name = "schema_url")
    String getSchemaUrl();

    @FieldName(name = "url")
    String getUrl();

    @FieldName(name = "open_id")
    String getUserId();

    @FieldName(name = "reason#setter")
    void setReason(String r1);

    @FieldName(name = "open_id#setter")
    void setUserId(String r1);
}
