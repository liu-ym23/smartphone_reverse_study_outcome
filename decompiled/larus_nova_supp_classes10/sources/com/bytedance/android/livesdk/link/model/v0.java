package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\u0010\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0016\u0010\b\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001b\u001a\u00020\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/v0;", "Lvh7/c;", "", "getPanelType", "()I", "setPanelType", "(I)V", "getPanelType$annotations", "()V", "panelType", "", "getStartLightningEffect", "()Z", "setStartLightningEffect", "(Z)V", "getStartLightningEffect$annotations", "startLightningEffect", "", "getTargetValue", "()Ljava/lang/String;", "setTargetValue", "(Ljava/lang/String;)V", "getTargetValue$annotations", "targetValue", "getExpandTimePerRound", "setExpandTimePerRound", "getExpandTimePerRound$annotations", "expandTimePerRound", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface v0 extends vh7.c<v0> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "expand_time_per_round")
    String getExpandTimePerRound();

    @FieldName(name = "panel_type")
    int getPanelType();

    @FieldName(name = "start_lightning_effect")
    boolean getStartLightningEffect();

    @FieldName(name = "target_value")
    String getTargetValue();

    @FieldName(name = "expand_time_per_round#setter")
    void setExpandTimePerRound(String r1);

    @FieldName(name = "panel_type#setter")
    void setPanelType(int r1);

    @FieldName(name = "start_lightning_effect#setter")
    void setStartLightningEffect(boolean r1);

    @FieldName(name = "target_value#setter")
    void setTargetValue(String r1);
}
