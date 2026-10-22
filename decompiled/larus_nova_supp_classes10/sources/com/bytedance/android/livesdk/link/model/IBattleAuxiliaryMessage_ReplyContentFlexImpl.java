package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.im.BattleAuxiliaryMessage.ReplyContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R'\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleAuxiliaryMessage_ReplyContentFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/t0$f;", "", "replyContent$delegate", "Ljava/lang/Object;", "getReplyContent", "()Ljava/lang/String;", "replyContent", "", "", "Lcom/bytedance/android/livesdk/link/model/IBattleAuxiliaryMessage_AuxiliaryScoreInfoFlexImpl;", "auxiliaryScoreInfo$delegate", "getAuxiliaryScoreInfo", "()Ljava/util/Map;", "auxiliaryScoreInfo", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleAuxiliaryMessage_ReplyContentFlexImpl extends FlexModelBase<t0.f> implements t0.f, vh7.h {

    @SerializedName("anchor_auxiliary_score_info")
    protected Map<Long, IBattleAuxiliaryMessage_AuxiliaryScoreInfoFlexImpl> _$$auxiliaryScoreInfo;

    @SerializedName("reply_string")
    protected String _$$replyContent;

    public IBattleAuxiliaryMessage_ReplyContentFlexImpl() {
        super(t0.f.class);
        this._$$replyContent = "";
        this._$$auxiliaryScoreInfo = $defaultValue_auxiliaryScoreInfo$();
    }

    public final Map<Long, IBattleAuxiliaryMessage_AuxiliaryScoreInfoFlexImpl> $defaultValue_auxiliaryScoreInfo$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.b();
    }

    @Override // com.bytedance.android.livesdk.link.model.t0.f
    public final Map<Long, IBattleAuxiliaryMessage_AuxiliaryScoreInfoFlexImpl> getAuxiliaryScoreInfo() {
        return this._$$auxiliaryScoreInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.t0.f
    public final String getReplyContent() {
        return this._$$replyContent;
    }

    public IBattleAuxiliaryMessage_ReplyContentFlexImpl(am3.g r12) {
        super(t0.f.class);
        this._$$auxiliaryScoreInfo = new HashMap();
        setThreadSafe(false);
        long r0 = r12.c();
    L3:
        int r2 = r12.f();
        if (r2 == (-1)) goto L27;
        am3.g.a r5 = decodeExtensionFields(r2, r12);
        if (r2 != 1) goto L8;
        this._$$replyContent = am3.h.c(r12);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        long r7 = r12.c();
        Long r3 = null;
        IBattleAuxiliaryMessage_AuxiliaryScoreInfoFlexImpl r6 = null;
    L11:
        int r9 = r12.f();
        if (r9 == (-1)) goto L18;
        if (r9 != 1) goto L14;
        r3 = Long.valueOf(r12.j());
        goto L11
    L14:
        if (r9 != 2) goto L15;
        r6 = new IBattleAuxiliaryMessage_AuxiliaryScoreInfoFlexImpl(r12);
        goto L11
    L15:
        am3.h.e(r12);
        goto L11
    L18:
        r12.d(r7);
        Map<Long, IBattleAuxiliaryMessage_AuxiliaryScoreInfoFlexImpl> r4 = this._$$auxiliaryScoreInfo;
        if (r3 == null) goto L25;
        if (r6 == null) goto L23;
        r4.put(r3, r6);
        goto L3
    L23:
        throw new IllegalStateException("Value must not be null");
    L25:
        throw new IllegalStateException("Key must not be null");
    L9:
        am3.h.d(r5, r12);
        goto L3
    L27:
        r12.d(r0);
        setThreadSafe(true);
        if (this._$$replyContent != null) goto L31;
        this._$$replyContent = "";
    L31:
        if (this._$$auxiliaryScoreInfo != null) goto L54;
        this._$$auxiliaryScoreInfo = $defaultValue_auxiliaryScoreInfo$();
        return;
    }
}
