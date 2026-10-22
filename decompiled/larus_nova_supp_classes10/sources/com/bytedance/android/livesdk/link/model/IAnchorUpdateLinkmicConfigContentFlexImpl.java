package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.im.AnchorUpdateLinkmicConfigContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IAnchorUpdateLinkmicConfigContentFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/x;", "", "forbidInviteByGeneral$delegate", "Ljava/lang/Object;", "getForbidInviteByGeneral", "()Z", "forbidInviteByGeneral", "forbidApplyFromOther$delegate", "getForbidApplyFromOther", "forbidApplyFromOther", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IAnchorUpdateLinkmicConfigContentFlexImpl extends FlexModelBase<x> implements x, vh7.h {

    @SerializedName("forbid_apply_from_other")
    protected boolean _$$forbidApplyFromOther;

    @SerializedName("forbid_invite_by_general")
    protected boolean _$$forbidInviteByGeneral;

    public IAnchorUpdateLinkmicConfigContentFlexImpl() {
        super(x.class);
        this._$$forbidInviteByGeneral = false;
        this._$$forbidApplyFromOther = false;
    }

    public IAnchorUpdateLinkmicConfigContentFlexImpl(am3.g r9) {
        super(x.class);
        setThreadSafe(false);
        long r1 = r9.c();
        int r3 = 0;
    L3:
        int r4 = r9.f();
        if (r4 == (-1)) goto L11;
        am3.g.a r5 = decodeExtensionFields(r4, r9);
        if (r4 != 1) goto L7;
        this._$$forbidInviteByGeneral = am3.h.a(r9);
        r3 = r3 | 1;
        goto L3
    L7:
        if (r4 != 2) goto L8;
        this._$$forbidApplyFromOther = am3.h.a(r9);
        r3 = r3 | 2;
        goto L3
    L8:
        am3.h.d(r5, r9);
        goto L3
    L11:
        r9.d(r1);
        setThreadSafe(true);
        if ((r3 & 1) != 0) goto L15;
        this._$$forbidInviteByGeneral = false;
    L15:
        if ((r3 & 2) != 0) goto L27;
        this._$$forbidApplyFromOther = false;
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.x
    public final boolean getForbidApplyFromOther() {
        return this._$$forbidApplyFromOther;
    }

    @Override // com.bytedance.android.livesdk.link.model.x
    public final boolean getForbidInviteByGeneral() {
        return this._$$forbidInviteByGeneral;
    }
}
