package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0010\u0010\u0004R.\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/z;", "Lvh7/c;", "", "getSchemaUrl", "()Ljava/lang/String;", "getSchemaUrl$annotations", "()V", "schemaUrl", "getContent", "getContent$annotations", "content", "", "getRemainSeconds", "()J", "getRemainSeconds$annotations", "remainSeconds", "getUserId", "getUserId$annotations", "userId", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getPunishedLinkmicIdStrList", "()Ljava/util/List;", "getPunishedLinkmicIdStrList$annotations", "punishedLinkmicIdStrList", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface z extends vh7.c<z> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "content")
    String getContent();

    @FieldName(name = "punished_linkmic_id_str_list")
    List<String> getPunishedLinkmicIdStrList();

    @FieldName(name = "remain_seconds")
    long getRemainSeconds();

    @FieldName(name = "schema_url")
    String getSchemaUrl();

    @FieldName(name = "user_open_id")
    String getUserId();
}
