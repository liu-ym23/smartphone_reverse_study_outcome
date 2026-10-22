package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R$\u0010\n\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R*\u0010\u0012\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0011\u0010\t\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0016\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0015\u0010\t\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/j8;", "Lvh7/c;", "Lcom/bytedance/android/livesdk/link/model/b0;", "Lcom/bytedance/android/livesdk/link/model/k8;", "getConfig", "()Lcom/bytedance/android/livesdk/link/model/k8;", "setConfig", "(Lcom/bytedance/android/livesdk/link/model/k8;)V", "getConfig$annotations", "()V", "config", "Lcom/bytedance/android/live/base/model/message/a5;", "Lcom/bytedance/android/live/base/model/message/ITextKt;", "get_matchText", "()Lcom/bytedance/android/live/base/model/message/a5;", "set_matchText", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "get_matchText$annotations", "_matchText", "get_newAnchorMatchText", "set_newAnchorMatchText", "get_newAnchorMatchText$annotations", "_newAnchorMatchText", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface j8 extends vh7.c<j8>, b0 {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    /* synthetic */ long getAccelerateLimit();

    /* synthetic */ c0 getConfig();

    @FieldName(name = "config")
    k8 getConfig();

    /* synthetic */ long getDefaultWaitLimit();

    /* synthetic */ String getMainTitle();

    /* synthetic */ String getSubTitle();

    /* synthetic */ long getWaitSec();

    @FieldName(name = "match_text")
    com.bytedance.android.live.base.model.message.a5 get_matchText();

    @FieldName(name = "new_anchor_match_text")
    com.bytedance.android.live.base.model.message.a5 get_newAnchorMatchText();

    /* synthetic */ void setAccelerateLimit(long r1);

    @FieldName(name = "config#setter")
    void setConfig(k8 r1);

    /* synthetic */ void setDefaultWaitLimit(long r1);

    /* synthetic */ void setMainTitle(String r1);

    /* synthetic */ void setSubTitle(String r1);

    /* synthetic */ void setWaitSec(long r1);

    @FieldName(name = "match_text#setter")
    void set_matchText(com.bytedance.android.live.base.model.message.a5 r1);

    @FieldName(name = "new_anchor_match_text#setter")
    void set_newAnchorMatchText(com.bytedance.android.live.base.model.message.a5 r1);
}
