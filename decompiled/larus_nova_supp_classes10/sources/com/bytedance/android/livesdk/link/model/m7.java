package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0014\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\u0004\"\u0004\b\u0012\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/m7;", "Lvh7/c;", "", "getPointDesc", "()Ljava/lang/String;", "setPointDesc", "(Ljava/lang/String;)V", "getPointDesc$annotations", "()V", "pointDesc", "", "getPoint", "()Ljava/lang/Long;", "setPoint", "(Ljava/lang/Long;)V", "getPoint$annotations", "point", "getPointStr", "setPointStr", "getPointStr$annotations", "pointStr", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface m7 extends vh7.c<m7> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "point")
    Long getPoint();

    @FieldName(name = "point_desc")
    String getPointDesc();

    @FieldName(name = "point_str")
    String getPointStr();

    @FieldName(name = "point#setter")
    void setPoint(Long r1);

    @FieldName(name = "point_desc#setter")
    void setPointDesc(String r1);

    @FieldName(name = "point_str#setter")
    void setPointStr(String r1);
}
