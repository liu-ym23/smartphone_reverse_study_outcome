package com.bytedance.android.livesdk.link.model.bridge;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\"\u0010\u0010\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0011\u0010\u0004¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/x1;", "Lvh7/c;", "", "getGameAppId", "()Ljava/lang/String;", "getGameAppId$annotations", "()V", "gameAppId", "getGameExtra", "getGameExtra$annotations", "gameExtra", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getIconImage", "()Lpy/k;", "getIconImage$annotations", "iconImage", "getGameTitle", "getGameTitle$annotations", "gameTitle", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface x1 extends vh7.c<x1> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "app_id")
    String getGameAppId();

    @FieldName(name = "app_extra")
    String getGameExtra();

    @FieldName(name = "game_title")
    String getGameTitle();

    @FieldName(name = "icon_image")
    py.k getIconImage();
}
