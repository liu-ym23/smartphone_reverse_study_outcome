package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\u001e\u0010\t\u001a\u00060\u0003j\u0002`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/u4;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/l0;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/ChannelId;", "getChannelId", "()J", "getChannelId$annotations", "()V", "channelId", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface u4 extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.l0>, com.bytedance.android.livesdk.link.model.bridge.l0 {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "channel_id")
    long getChannelId();

    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "reply_status")
    /* synthetic */ long getReplyStatus();

    @FieldName(name = "toast")
    /* synthetic */ String getToast();

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r1);
}
