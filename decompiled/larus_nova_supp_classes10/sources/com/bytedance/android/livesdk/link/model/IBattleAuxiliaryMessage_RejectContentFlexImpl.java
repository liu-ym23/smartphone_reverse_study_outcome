package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.im.BattleAuxiliaryMessage.RejectContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleAuxiliaryMessage_RejectContentFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/t0$e;", "", "rejectContent$delegate", "Ljava/lang/Object;", "getRejectContent", "()Ljava/lang/String;", "rejectContent", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleAuxiliaryMessage_RejectContentFlexImpl extends FlexModelBase<t0.e> implements t0.e, vh7.h {

    @SerializedName("reject_content")
    protected String _$$rejectContent;

    public IBattleAuxiliaryMessage_RejectContentFlexImpl() {
        super(t0.e.class);
        this._$$rejectContent = "";
    }

    public IBattleAuxiliaryMessage_RejectContentFlexImpl(am3.g r6) {
        super(t0.e.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L9;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L7;
        this._$$rejectContent = am3.h.c(r6);
        goto L3
    L7:
        am3.h.d(r3, r6);
        goto L3
    L9:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$rejectContent != null) goto L19;
        this._$$rejectContent = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.t0.e
    public final String getRejectContent() {
        return this._$$rejectContent;
    }
}
