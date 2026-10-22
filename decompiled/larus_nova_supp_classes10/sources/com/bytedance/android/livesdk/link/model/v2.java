package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0014\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\r\u0010\nR\u001a\u0010\u0012\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0010\u0010\nR\u001a\u0010\u0015\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0013\u0010\nR\u001a\u0010\u0018\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0016\u0010\nR\u001a\u0010\u001b\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u0019\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/v2;", "Lvh7/c;", "", "getPkSetUid", "()Ljava/lang/String;", "getPkSetUid$annotations", "()V", "pkSetUid", "", "getPkValueType", "()J", "getPkValueType$annotations", "pkValueType", "getPkLikeRate", "getPkLikeRate$annotations", "pkLikeRate", "getPkGiftRate", "getPkGiftRate$annotations", "pkGiftRate", "getPkUVRate", "getPkUVRate$annotations", "pkUVRate", "getPkTicketRate", "getPkTicketRate$annotations", "pkTicketRate", "getPkVIPRate", "getPkVIPRate$annotations", "pkVIPRate", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface v2 extends vh7.c<v2> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "gift_2_pk_rate")
    long getPkGiftRate();

    @FieldName(name = "pk_2_like_rate")
    long getPkLikeRate();

    @FieldName(name = "set_open_uid")
    String getPkSetUid();

    @FieldName(name = "ticket_2_pk_rate")
    long getPkTicketRate();

    @FieldName(name = "gift_uv_2_pk_rate")
    long getPkUVRate();

    @FieldName(name = "subscribe_pk_rate")
    long getPkVIPRate();

    @FieldName(name = "pk_value_type")
    long getPkValueType();
}
