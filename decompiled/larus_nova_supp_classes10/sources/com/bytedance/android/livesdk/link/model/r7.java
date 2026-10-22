package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0011\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0014\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0012\u0010\nR\u001a\u0010\u0019\u001a\u00020\u00158&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001c\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001a\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/r7;", "Lvh7/c;", "Lcom/bytedance/android/livesdk/link/model/s7;", "getMatcher", "()Lcom/bytedance/android/livesdk/link/model/s7;", "getMatcher$annotations", "()V", "matcher", "", "getMatchReason", "()Ljava/lang/String;", "getMatchReason$annotations", "matchReason", "", "getWaitSeconds", "()J", "getWaitSeconds$annotations", "waitSeconds", "getSignExtra", "getSignExtra$annotations", "signExtra", "Lcom/bytedance/android/livesdk/link/model/aa;", "getVoteSetting", "()Lcom/bytedance/android/livesdk/link/model/aa;", "getVoteSetting$annotations", "voteSetting", "getBattleAttachedInfo", "getBattleAttachedInfo$annotations", "battleAttachedInfo", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface r7 extends vh7.c<r7> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "battle_attached_info")
    String getBattleAttachedInfo();

    @FieldName(name = "match_reason")
    String getMatchReason();

    @FieldName(name = "matcher_r")
    s7 getMatcher();

    @FieldName(name = "sign_extra")
    String getSignExtra();

    @FieldName(name = "vote_data")
    aa getVoteSetting();

    @FieldName(name = "wait_seconds")
    long getWaitSeconds();
}
