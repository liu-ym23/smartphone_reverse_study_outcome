package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.data.AudienceApplyBattleTeamTaskInfo.BattleOpenTeamTaskInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001f\u0010 R\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0012\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u001b\u0010\u0015\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000eR\u001b\u0010\u0018\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u000eR\u001b\u0010\u001b\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u001a\u0010\u000eR\u001b\u0010\u001e\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\f\u001a\u0004\b\u001d\u0010\u000e¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IAudienceApplyBattleTeamTaskInfo_BattleOpenTeamTaskInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/y$a;", "Lpy/k;", "userAvatar", "Lpy/k;", "getUserAvatar", "()Lpy/k;", "setUserAvatar", "(Lpy/k;)V", "", "anchorId$delegate", "Ljava/lang/Object;", "getAnchorId", "()Ljava/lang/String;", "anchorId", "roomId$delegate", "getRoomId", "roomId", "userId$delegate", "getUserId", "userId", "nickname$delegate", "getNickname", "nickname", "anchorOpenId$delegate", "getAnchorOpenId", "anchorOpenId", "userOpenId$delegate", "getUserOpenId", "userOpenId", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IAudienceApplyBattleTeamTaskInfo_BattleOpenTeamTaskInfoFlexImpl extends FlexModelBase<y.a> implements y.a, vh7.h {

    @SerializedName("anchor_id")
    protected String _$$anchorId;

    @SerializedName("anchor_open_id")
    protected String _$$anchorOpenId;

    @SerializedName("nickname")
    protected String _$$nickname;

    @SerializedName("room_id")
    protected String _$$roomId;

    @SerializedName("user_id")
    protected String _$$userId;

    @SerializedName("user_open_id")
    protected String _$$userOpenId;

    @SerializedName("user_avatar")
    protected py.k userAvatar;

    public IAudienceApplyBattleTeamTaskInfo_BattleOpenTeamTaskInfoFlexImpl() {
        super(y.a.class);
        this._$$anchorId = "";
        this._$$roomId = "";
        this._$$userId = "";
        this._$$nickname = "";
        this.userAvatar = (py.k) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(py.k.class);
        this._$$anchorOpenId = "";
        this._$$userOpenId = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.y.a
    public final String getAnchorId() {
        return this._$$anchorId;
    }

    @Override // com.bytedance.android.livesdk.link.model.y.a
    public final String getAnchorOpenId() {
        return this._$$anchorOpenId;
    }

    @Override // com.bytedance.android.livesdk.link.model.y.a
    public final String getNickname() {
        return this._$$nickname;
    }

    @Override // com.bytedance.android.livesdk.link.model.y.a
    public final String getRoomId() {
        return this._$$roomId;
    }

    @Override // com.bytedance.android.livesdk.link.model.y.a
    public py.k getUserAvatar() {
        return this.userAvatar;
    }

    @Override // com.bytedance.android.livesdk.link.model.y.a
    public final String getUserId() {
        return this._$$userId;
    }

    @Override // com.bytedance.android.livesdk.link.model.y.a
    public final String getUserOpenId() {
        return this._$$userOpenId;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    public IAudienceApplyBattleTeamTaskInfo_BattleOpenTeamTaskInfoFlexImpl(am3.g r6) {
        super(y.a.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L27;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$anchorId = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$roomId = am3.h.c(r6);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this._$$userId = am3.h.c(r6);
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this._$$nickname = am3.h.c(r6);
        goto L3
    L14:
        if (r2 != 5) goto L16;
        this.userAvatar = vh7.f.a(r6, py.k.class);
        goto L3
    L16:
        if (r2 != 5000) goto L18;
        this._$$anchorOpenId = am3.h.c(r6);
        goto L3
    L18:
        if (r2 != 5001) goto L19;
        this._$$userOpenId = am3.h.c(r6);
        goto L3
    L19:
        am3.h.d(r3, r6);
        goto L3
    L27:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$anchorId != null) goto L31;
        this._$$anchorId = "";
    L31:
        if (this._$$roomId != null) goto L34;
        this._$$roomId = "";
    L34:
        if (this._$$userId != null) goto L37;
        this._$$userId = "";
    L37:
        if (this._$$nickname != null) goto L40;
        this._$$nickname = "";
    L40:
        if (this.userAvatar != null) goto L43;
        this.userAvatar = (py.k) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(py.k.class);
    L43:
        if (this._$$anchorOpenId != null) goto L46;
        this._$$anchorOpenId = "";
    L46:
        if (this._$$userOpenId != null) goto L73;
        this._$$userOpenId = "";
        return;
    }

    public void setUserAvatar(py.k r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.userAvatar = r2;
    }
}
