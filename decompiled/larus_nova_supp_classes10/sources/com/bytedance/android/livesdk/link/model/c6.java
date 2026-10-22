package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u000e\u0010\u0004R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00118&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/c6;", "Lvh7/c;", "", "getInit_param", "()Ljava/lang/String;", "getInit_param$annotations", "()V", "init_param", "getOpen_id", "getOpen_id$annotations", "open_id", "getGame_extra", "getGame_extra$annotations", "game_extra", "getGameAppId", "getGameAppId$annotations", "gameAppId", "Lcom/bytedance/android/livesdk/link/model/bridge/v0;", "getBizExtra", "()Lcom/bytedance/android/livesdk/link/model/bridge/v0;", "getBizExtra$annotations", "bizExtra", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface c6 extends vh7.c<c6> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "link_biz_extra")
    com.bytedance.android.livesdk.link.model.bridge.v0 getBizExtra();

    @FieldName(name = "game_app_id")
    String getGameAppId();

    @FieldName(name = "game_extra")
    String getGame_extra();

    @FieldName(name = "init_param")
    String getInit_param();

    @FieldName(name = "open_id")
    String getOpen_id();
}
