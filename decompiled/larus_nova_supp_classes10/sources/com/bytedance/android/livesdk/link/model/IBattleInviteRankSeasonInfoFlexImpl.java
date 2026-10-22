package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.data.BattleLinkerInviteMessageExtra.RankSeasonInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001b\u0010\u0012\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleInviteRankSeasonInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/m1;", "Lpy/k;", "rankAFrame", "Lpy/k;", "getRankAFrame", "()Lpy/k;", "setRankAFrame", "(Lpy/k;)V", "rankBadge", "getRankBadge", "setRankBadge", "", "rankDetail$delegate", "Ljava/lang/Object;", "getRankDetail", "()Ljava/lang/String;", "rankDetail", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleInviteRankSeasonInfoFlexImpl extends FlexModelBase<m1> implements m1, vh7.h {

    @SerializedName("rank_detail")
    protected String _$$rankDetail;

    @SerializedName("avatar_frame")
    protected py.k rankAFrame;

    @SerializedName("rank_badge")
    protected py.k rankBadge;

    public IBattleInviteRankSeasonInfoFlexImpl() {
        super(m1.class);
        this.rankAFrame = (py.k) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(py.k.class);
        this.rankBadge = (py.k) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(py.k.class);
        this._$$rankDetail = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.m1
    public py.k getRankAFrame() {
        return this.rankAFrame;
    }

    @Override // com.bytedance.android.livesdk.link.model.m1
    public py.k getRankBadge() {
        return this.rankBadge;
    }

    @Override // com.bytedance.android.livesdk.link.model.m1
    public final String getRankDetail() {
        return this._$$rankDetail;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    public IBattleInviteRankSeasonInfoFlexImpl(am3.g r6) {
        super(m1.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L15;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$rankDetail = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.rankBadge = vh7.f.a(r6, py.k.class);
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this.rankAFrame = vh7.f.a(r6, py.k.class);
        goto L3
    L11:
        am3.h.d(r3, r6);
        goto L3
    L15:
        r6.d(r0);
        setThreadSafe(true);
        if (this.rankAFrame != null) goto L19;
        this.rankAFrame = (py.k) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(py.k.class);
    L19:
        if (this.rankBadge != null) goto L22;
        this.rankBadge = (py.k) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(py.k.class);
    L22:
        if (this._$$rankDetail != null) goto L37;
        this._$$rankDetail = "";
        return;
    }

    public void setRankAFrame(py.k r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.rankAFrame = r2;
    }

    public void setRankBadge(py.k r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.rankBadge = r2;
    }
}
