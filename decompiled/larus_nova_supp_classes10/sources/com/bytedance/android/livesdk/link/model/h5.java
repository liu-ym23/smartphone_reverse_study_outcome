package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/h5;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/v0;", "Lcom/bytedance/android/livesdk/link/model/j7;", "getOpenGameConfig", "()Lcom/bytedance/android/livesdk/link/model/j7;", "getOpenGameConfig$annotations", "()V", "openGameConfig", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface h5 extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.v0>, com.bytedance.android.livesdk.link.model.bridge.v0 {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "open_game_config")
    /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.x1 getOpenGameConfig();

    @FieldName(name = "open_game_config")
    j7 getOpenGameConfig();
}
