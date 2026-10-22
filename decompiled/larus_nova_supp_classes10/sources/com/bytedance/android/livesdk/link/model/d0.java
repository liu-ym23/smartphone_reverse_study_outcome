package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/d0;", "Lvh7/c;", "", "getInviteLimitSec", "()J", "setInviteLimitSec", "(J)V", "getInviteLimitSec$annotations", "()V", "inviteLimitSec", "getPkAutoMatchIndex", "setPkAutoMatchIndex", "getPkAutoMatchIndex$annotations", "pkAutoMatchIndex", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface d0 extends vh7.c<d0> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "invite_limit_sec")
    long getInviteLimitSec();

    @FieldName(name = "pk_auto_match_index")
    long getPkAutoMatchIndex();

    @FieldName(name = "invite_limit_sec#setter")
    void setInviteLimitSec(long r1);

    @FieldName(name = "pk_auto_match_index#setter")
    void setPkAutoMatchIndex(long r1);
}
