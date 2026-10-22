package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.data.InteractRewardPunishConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/InteractRewardPunishConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/fa;", "Lcom/bytedance/android/livesdk/link/model/da;", "<set-?>", "rewardEffect$delegate", "Ljava/lang/Object;", "getRewardEffect", "()Lcom/bytedance/android/livesdk/link/model/da;", "setRewardEffect", "(Lcom/bytedance/android/livesdk/link/model/da;)V", "rewardEffect", "punishEffect$delegate", "getPunishEffect", "setPunishEffect", "punishEffect", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractRewardPunishConfigFlexImpl extends FlexModelBase<fa> implements fa, vh7.h {

    @SerializedName("punish_effect")
    protected da _$$punishEffect;

    @SerializedName("reward_effect")
    protected da _$$rewardEffect;

    public InteractRewardPunishConfigFlexImpl() {
        super(fa.class);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.livesdk.link.model.da, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.android.livesdk.link.model.da, java.lang.Object] */
    public InteractRewardPunishConfigFlexImpl(am3.g r6) {
        super(fa.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$rewardEffect = vh7.f.a(r6, da.class);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this._$$punishEffect = vh7.f.a(r6, da.class);
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.link.model.fa
    public final da getPunishEffect() {
        return this._$$punishEffect;
    }

    @Override // com.bytedance.android.livesdk.link.model.fa
    public final da getRewardEffect() {
        return this._$$rewardEffect;
    }

    @Override // com.bytedance.android.livesdk.link.model.fa
    public final void setPunishEffect(da r1) {
        this._$$punishEffect = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.fa
    public final void setRewardEffect(da r1) {
        this._$$rewardEffect = r1;
    }
}
