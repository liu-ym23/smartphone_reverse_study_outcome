package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.api.battle.RivalsRecommendResponse.RankSeasonInfo.RankInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001b\u0010\u0012\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0015\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IRankInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/g8;", "Lpy/k;", "rankBadge", "Lpy/k;", "getRankBadge", "()Lpy/k;", "setRankBadge", "(Lpy/k;)V", "rankTag", "getRankTag", "setRankTag", "", "rankDetail$delegate", "Ljava/lang/Object;", "getRankDetail", "()Ljava/lang/String;", "rankDetail", "rankIndex$delegate", "getRankIndex", "rankIndex", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IRankInfoFlexImpl extends FlexModelBase<g8> implements g8, vh7.h {

    @SerializedName("cur_rank_detail")
    protected String _$$rankDetail;

    @SerializedName("rank_index")
    protected String _$$rankIndex;

    @SerializedName("rank_badge")
    protected py.k rankBadge;

    @SerializedName("rank_tag_img")
    protected py.k rankTag;

    public IRankInfoFlexImpl() {
        super(g8.class);
        this._$$rankDetail = "";
        this.rankBadge = (py.k) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(py.k.class);
        this._$$rankIndex = "";
        this.rankTag = (py.k) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(py.k.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.g8
    public py.k getRankBadge() {
        return this.rankBadge;
    }

    @Override // com.bytedance.android.livesdk.link.model.g8
    public final String getRankDetail() {
        return this._$$rankDetail;
    }

    @Override // com.bytedance.android.livesdk.link.model.g8
    public final String getRankIndex() {
        return this._$$rankIndex;
    }

    @Override // com.bytedance.android.livesdk.link.model.g8
    public py.k getRankTag() {
        return this.rankTag;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, py.k] */
    public IRankInfoFlexImpl(am3.g r6) {
        super(g8.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L18;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$rankDetail = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.rankBadge = vh7.f.a(r6, py.k.class);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this._$$rankIndex = am3.h.c(r6);
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this.rankTag = vh7.f.a(r6, py.k.class);
        goto L3
    L13:
        am3.h.d(r3, r6);
        goto L3
    L18:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$rankDetail != null) goto L22;
        this._$$rankDetail = "";
    L22:
        if (this.rankBadge != null) goto L25;
        this.rankBadge = (py.k) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(py.k.class);
    L25:
        if (this._$$rankIndex != null) goto L28;
        this._$$rankIndex = "";
    L28:
        if (this.rankTag != null) goto L46;
        this.rankTag = (py.k) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(py.k.class);
        return;
    }

    public void setRankBadge(py.k r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.rankBadge = r2;
    }

    public void setRankTag(py.k r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.rankTag = r2;
    }
}
