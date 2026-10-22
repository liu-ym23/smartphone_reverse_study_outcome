package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.api.battle.BattleInviteResult.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleInviteResultFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/n1;", "", "toast$delegate", "Ljava/lang/Object;", "getToast", "()Ljava/lang/String;", "toast", "eventTrackingInfo$delegate", "getEventTrackingInfo", "eventTrackingInfo", "notInviteReason$delegate", "getNotInviteReason", "notInviteReason", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleInviteResultFlexImpl extends FlexModelBase<n1> implements n1, vh7.h {

    @SerializedName("event_tracking_info")
    protected String _$$eventTrackingInfo;

    @SerializedName("not_invite_reason")
    protected String _$$notInviteReason;

    @SerializedName("toast")
    protected String _$$toast;

    public IBattleInviteResultFlexImpl() {
        super(n1.class);
        this._$$toast = "";
    }

    public IBattleInviteResultFlexImpl(am3.g r6) {
        super(n1.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L15;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$toast = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$eventTrackingInfo = am3.h.c(r6);
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this._$$notInviteReason = am3.h.c(r6);
        goto L3
    L11:
        am3.h.d(r3, r6);
        goto L3
    L15:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$toast != null) goto L31;
        this._$$toast = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.n1
    public final String getEventTrackingInfo() {
        return this._$$eventTrackingInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.n1
    public final String getNotInviteReason() {
        return this._$$notInviteReason;
    }

    @Override // com.bytedance.android.livesdk.link.model.n1
    public final String getToast() {
        return this._$$toast;
    }
}
