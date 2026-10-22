package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.im.PkActivePush")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0015\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\fR\u001b\u0010\u001a\u001a\u00020\u00168VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001d\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001c\u0010\f¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IPkActivePushFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/r7;", "Lcom/bytedance/android/livesdk/link/model/IPkActivePushMatcherFlexImpl;", "matcher$delegate", "Ljava/lang/Object;", "getMatcher", "()Lcom/bytedance/android/livesdk/link/model/IPkActivePushMatcherFlexImpl;", "matcher", "", "matchReason$delegate", "getMatchReason", "()Ljava/lang/String;", "matchReason", "", "waitSeconds$delegate", "getWaitSeconds", "()J", "waitSeconds", "signExtra$delegate", "getSignExtra", "signExtra", "Lcom/bytedance/android/livesdk/link/model/IVoteSettingFlexImpl;", "voteSetting$delegate", "getVoteSetting", "()Lcom/bytedance/android/livesdk/link/model/IVoteSettingFlexImpl;", "voteSetting", "battleAttachedInfo$delegate", "getBattleAttachedInfo", "battleAttachedInfo", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IPkActivePushFlexImpl extends FlexModelBase<r7> implements r7, vh7.h {

    @SerializedName("battle_attached_info")
    protected String _$$battleAttachedInfo;

    @SerializedName("match_reason")
    protected String _$$matchReason;

    @SerializedName("matcher_r")
    protected IPkActivePushMatcherFlexImpl _$$matcher;

    @SerializedName("sign_extra")
    protected String _$$signExtra;

    @SerializedName("vote_data")
    protected IVoteSettingFlexImpl _$$voteSetting;

    @SerializedName("wait_seconds")
    protected long _$$waitSeconds;

    public IPkActivePushFlexImpl() {
        super(r7.class);
        this._$$matchReason = "";
        this._$$signExtra = "";
        this._$$voteSetting = $defaultValue_voteSetting$();
        this._$$battleAttachedInfo = "";
    }

    public final IVoteSettingFlexImpl $defaultValue_voteSetting$() {
        return (IVoteSettingFlexImpl) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(IVoteSettingFlexImpl.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.r7
    public /* bridge */ /* synthetic */ s7 getMatcher() {
        return getMatcher();
    }

    @Override // com.bytedance.android.livesdk.link.model.r7
    public /* bridge */ /* synthetic */ aa getVoteSetting() {
        return getVoteSetting();
    }

    @Override // com.bytedance.android.livesdk.link.model.r7
    public final String getBattleAttachedInfo() {
        return this._$$battleAttachedInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.r7
    public final String getMatchReason() {
        return this._$$matchReason;
    }

    @Override // com.bytedance.android.livesdk.link.model.r7
    public final String getSignExtra() {
        return this._$$signExtra;
    }

    @Override // com.bytedance.android.livesdk.link.model.r7
    public final long getWaitSeconds() {
        return this._$$waitSeconds;
    }

    @Override // com.bytedance.android.livesdk.link.model.r7
    public final IPkActivePushMatcherFlexImpl getMatcher() {
        return this._$$matcher;
    }

    @Override // com.bytedance.android.livesdk.link.model.r7
    public final IVoteSettingFlexImpl getVoteSetting() {
        return this._$$voteSetting;
    }

    public IPkActivePushFlexImpl(am3.g r6) {
        super(r7.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L24;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$matcher = new IPkActivePushMatcherFlexImpl(r6);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$matchReason = am3.h.c(r6);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this._$$waitSeconds = r6.j();
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this._$$signExtra = am3.h.c(r6);
        goto L3
    L14:
        if (r2 != 5) goto L16;
        this._$$voteSetting = new IVoteSettingFlexImpl(r6);
        goto L3
    L16:
        if (r2 != 19) goto L17;
        this._$$battleAttachedInfo = am3.h.c(r6);
        goto L3
    L17:
        am3.h.d(r3, r6);
        goto L3
    L24:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$matchReason != null) goto L28;
        this._$$matchReason = "";
    L28:
        if (this._$$signExtra != null) goto L31;
        this._$$signExtra = "";
    L31:
        if (this._$$voteSetting != null) goto L34;
        this._$$voteSetting = $defaultValue_voteSetting$();
    L34:
        if (this._$$battleAttachedInfo != null) goto L58;
        this._$$battleAttachedInfo = "";
        return;
    }
}
