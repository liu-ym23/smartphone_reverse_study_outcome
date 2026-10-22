package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.data.AudienceApplyBattleTeamTaskInfo.PopupAnchorInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0012\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IAudienceApplyBattleTeamTaskInfo_PopupAnchorInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/y$d;", "Lpy/k;", "anchorAvatar", "Lpy/k;", "getAnchorAvatar", "()Lpy/k;", "setAnchorAvatar", "(Lpy/k;)V", "", "anchorId$delegate", "Ljava/lang/Object;", "getAnchorId", "()Ljava/lang/String;", "anchorId", "roomId$delegate", "getRoomId", "roomId", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IAudienceApplyBattleTeamTaskInfo_PopupAnchorInfoFlexImpl extends FlexModelBase<y.d> implements y.d, vh7.h {

    @SerializedName("anchor_id")
    protected String _$$anchorId;

    @SerializedName("room_id")
    protected String _$$roomId;

    @SerializedName("anchor_avatar")
    protected py.k anchorAvatar;

    public IAudienceApplyBattleTeamTaskInfo_PopupAnchorInfoFlexImpl() {
        super(y.d.class);
        this._$$anchorId = "";
        this._$$roomId = "";
        this.anchorAvatar = (py.k) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(py.k.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.y.d
    public py.k getAnchorAvatar() {
        return this.anchorAvatar;
    }

    @Override // com.bytedance.android.livesdk.link.model.y.d
    public final String getAnchorId() {
        return this._$$anchorId;
    }

    @Override // com.bytedance.android.livesdk.link.model.y.d
    public final String getRoomId() {
        return this._$$roomId;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    public IAudienceApplyBattleTeamTaskInfo_PopupAnchorInfoFlexImpl(am3.g r6) {
        super(y.d.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L15;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$anchorId = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$roomId = am3.h.c(r6);
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this.anchorAvatar = vh7.f.a(r6, py.k.class);
        goto L3
    L11:
        am3.h.d(r3, r6);
        goto L3
    L15:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$anchorId != null) goto L19;
        this._$$anchorId = "";
    L19:
        if (this._$$roomId != null) goto L22;
        this._$$roomId = "";
    L22:
        if (this.anchorAvatar != null) goto L37;
        this.anchorAvatar = (py.k) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(py.k.class);
        return;
    }

    public void setAnchorAvatar(py.k r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.anchorAvatar = r2;
    }
}
