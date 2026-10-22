package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R*\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R*\u0010\u000e\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000b\u0010\u0005\"\u0004\b\f\u0010\u0007R$\u0010\u0015\u001a\u0004\u0018\u00010\u000f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\t\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R.\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u00188&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\t\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/x7;", "Lvh7/c;", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getResultImg", "()Lpy/k;", "setResultImg", "(Lpy/k;)V", "getResultImg$annotations", "()V", "resultImg", "getEnergyImg", "setEnergyImg", "getEnergyImg$annotations", "energyImg", "", "getResultStr", "()Ljava/lang/String;", "setResultStr", "(Ljava/lang/String;)V", "getResultStr$annotations", "resultStr", "", "Lcom/bytedance/android/livesdk/link/model/m7;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getDescriptions", "()Ljava/util/List;", "getDescriptions$annotations", "descriptions", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface x7 extends vh7.c<x7> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "descriptions")
    List<m7> getDescriptions();

    @FieldName(name = "bg_img")
    py.k getEnergyImg();

    @FieldName(name = "result_img")
    py.k getResultImg();

    @FieldName(name = "result_str")
    String getResultStr();

    @FieldName(name = "bg_img#setter")
    void setEnergyImg(py.k r1);

    @FieldName(name = "result_img#setter")
    void setResultImg(py.k r1);

    @FieldName(name = "result_str#setter")
    void setResultStr(String r1);
}
