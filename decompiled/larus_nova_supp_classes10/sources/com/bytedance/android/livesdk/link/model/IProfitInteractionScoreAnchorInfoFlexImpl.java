package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.im.ProfitInteractionScoreAnchorInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\r\u001a\u0004\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IProfitInteractionScoreAnchorInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/b8;", "", "scoreStr$delegate", "Ljava/lang/Object;", "getScoreStr", "()Ljava/lang/String;", "scoreStr", "Lcom/bytedance/android/livesdk/link/model/IProfitInteractionSettingFlexImpl;", "setting$delegate", "getSetting", "()Lcom/bytedance/android/livesdk/link/model/IProfitInteractionSettingFlexImpl;", "setting", "", "reachScoreThreshold$delegate", "getReachScoreThreshold", "()Z", "reachScoreThreshold", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IProfitInteractionScoreAnchorInfoFlexImpl extends FlexModelBase<b8> implements b8, vh7.h {

    @SerializedName("reach_score_display_threshold")
    protected boolean _$$reachScoreThreshold;

    @SerializedName("score")
    protected String _$$scoreStr;

    @SerializedName("interaction_setting")
    protected IProfitInteractionSettingFlexImpl _$$setting;

    public IProfitInteractionScoreAnchorInfoFlexImpl() {
        super(b8.class);
        this._$$scoreStr = "";
        this._$$reachScoreThreshold = false;
    }

    public IProfitInteractionScoreAnchorInfoFlexImpl(am3.g r8) {
        super(b8.class);
        setThreadSafe(false);
        long r1 = r8.c();
        boolean r3 = false;
    L3:
        int r4 = r8.f();
        if (r4 == (-1)) goto L15;
        am3.g.a r5 = decodeExtensionFields(r4, r8);
        if (r4 != 1) goto L8;
        this._$$scoreStr = am3.h.c(r8);
        goto L3
    L8:
        if (r4 != 2) goto L10;
        this._$$setting = new IProfitInteractionSettingFlexImpl(r8);
        goto L3
    L10:
        if (r4 != 3) goto L11;
        this._$$reachScoreThreshold = am3.h.a(r8);
        r3 = r3 | true;
        goto L3
    L11:
        am3.h.d(r5, r8);
        goto L3
    L15:
        r8.d(r1);
        setThreadSafe(true);
        if (this._$$scoreStr != null) goto L19;
        this._$$scoreStr = "";
    L19:
        if ((r3 & true) == true) goto L34;
        this._$$reachScoreThreshold = false;
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.b8
    public /* bridge */ /* synthetic */ e8 getSetting() {
        return getSetting();
    }

    @Override // com.bytedance.android.livesdk.link.model.b8
    public final boolean getReachScoreThreshold() {
        return this._$$reachScoreThreshold;
    }

    @Override // com.bytedance.android.livesdk.link.model.b8
    public final String getScoreStr() {
        return this._$$scoreStr;
    }

    @Override // com.bytedance.android.livesdk.link.model.b8
    public final IProfitInteractionSettingFlexImpl getSetting() {
        return this._$$setting;
    }
}
