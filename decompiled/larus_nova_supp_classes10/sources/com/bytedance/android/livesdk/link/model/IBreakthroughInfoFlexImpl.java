package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.data.BreakthroughInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0015\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBreakthroughInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/n3;", "", "mvpAnchorId$delegate", "Ljava/lang/Object;", "getMvpAnchorId", "()Ljava/lang/String;", "mvpAnchorId", "", "stage$delegate", "getStage", "()J", "stage", "", "state$delegate", "getState", "()I", BaseCoreViewModel.CORE_TAG_STATE, "totalScore$delegate", "getTotalScore", "totalScore", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBreakthroughInfoFlexImpl extends FlexModelBase<n3> implements n3, vh7.h {

    @SerializedName("mvp_anchor_open_id")
    protected String _$$mvpAnchorId;

    @SerializedName("stage")
    protected long _$$stage;

    @SerializedName(BaseCoreViewModel.CORE_TAG_STATE)
    protected int _$$state;

    @SerializedName("total_score")
    protected long _$$totalScore;

    public IBreakthroughInfoFlexImpl() {
        super(n3.class);
        this._$$state = $defaultValue_state$();
    }

    public final int $defaultValue_state$() {
        return -1;
    }

    @Override // com.bytedance.android.livesdk.link.model.n3
    public final String getMvpAnchorId() {
        return this._$$mvpAnchorId;
    }

    @Override // com.bytedance.android.livesdk.link.model.n3
    public final long getStage() {
        return this._$$stage;
    }

    @Override // com.bytedance.android.livesdk.link.model.n3
    public final int getState() {
        return this._$$state;
    }

    @Override // com.bytedance.android.livesdk.link.model.n3
    public final long getTotalScore() {
        return this._$$totalScore;
    }

    public IBreakthroughInfoFlexImpl(am3.g r8) {
        super(n3.class);
        int r0 = 0;
        setThreadSafe(false);
        long r1 = r8.c();
    L3:
        int r3 = r8.f();
        if (r3 == (-1)) goto L17;
        am3.g.a r4 = decodeExtensionFields(r3, r8);
        if (r3 != 1) goto L7;
        this._$$stage = r8.j();
        r0 = r0 | 1;
        goto L3
    L7:
        if (r3 != 2) goto L9;
        this._$$totalScore = r8.j();
        r0 = r0 | 4;
        goto L3
    L9:
        if (r3 != 4) goto L11;
        this._$$state = r8.i();
        r0 = r0 | 2;
        goto L3
    L11:
        if (r3 != 5000) goto L12;
        this._$$mvpAnchorId = am3.h.c(r8);
        goto L3
    L12:
        am3.h.d(r4, r8);
        goto L3
    L17:
        r8.d(r1);
        setThreadSafe(true);
        if ((r0 & 2) != 0) goto L36;
        this._$$state = $defaultValue_state$();
        return;
    }
}
