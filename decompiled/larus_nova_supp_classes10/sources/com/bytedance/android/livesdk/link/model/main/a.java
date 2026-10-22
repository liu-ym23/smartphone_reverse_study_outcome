package com.bytedance.android.livesdk.link.model.main;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdk.link.model.j0;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ForMain
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/main/a;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/j0;", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a extends e<j0>, j0 {
    /* synthetic */ e castTo(Class r1);

    /* synthetic */ e castToOrNull(Class r1);

    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "reason")
    /* synthetic */ String getReason();

    @FieldName(name = "schema_url")
    /* synthetic */ String getSchemaUrl();

    @FieldName(name = "url")
    /* synthetic */ String getUrl();

    @FieldName(name = "open_id")
    /* synthetic */ String getUserId();

    @FieldName(name = "reason#setter")
    /* synthetic */ void setReason(String r1);

    @FieldName(name = "open_id#setter")
    /* synthetic */ void setUserId(String r1);
}
