package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.api.battle.RivalsRecommendResponse.RankSeasonInfo.ScoreInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00158VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IScoreInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/d9;", "Lcom/bytedance/android/live/base/model/message/a5;", "desc", "Lcom/bytedance/android/live/base/model/message/a5;", "getDesc", "()Lcom/bytedance/android/live/base/model/message/a5;", "setDesc", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "", "progress$delegate", "Ljava/lang/Object;", "getProgress", "()D", "progress", "", "showProgress$delegate", "getShowProgress", "()Z", "showProgress", "", "barColor$delegate", "getBarColor", "()Ljava/lang/String;", "barColor", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IScoreInfoFlexImpl extends FlexModelBase<d9> implements d9, vh7.h {

    @SerializedName("bar_color")
    protected String _$$barColor;

    @SerializedName("progress")
    protected double _$$progress;

    @SerializedName("show_progress")
    protected boolean _$$showProgress;

    @SerializedName("desc")
    protected com.bytedance.android.live.base.model.message.a5 desc;

    public IScoreInfoFlexImpl() {
        super(d9.class);
        this.desc = (com.bytedance.android.live.base.model.message.a5) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(com.bytedance.android.live.base.model.message.a5.class);
        this._$$showProgress = false;
        this._$$barColor = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.d9
    public final String getBarColor() {
        return this._$$barColor;
    }

    @Override // com.bytedance.android.livesdk.link.model.d9
    public com.bytedance.android.live.base.model.message.a5 getDesc() {
        return this.desc;
    }

    @Override // com.bytedance.android.livesdk.link.model.d9
    public final double getProgress() {
        return this._$$progress;
    }

    @Override // com.bytedance.android.livesdk.link.model.d9
    public final boolean getShowProgress() {
        return this._$$showProgress;
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [com.bytedance.android.live.base.model.message.a5, java.lang.Object] */
    public IScoreInfoFlexImpl(am3.g r9) {
        super(d9.class);
        setThreadSafe(false);
        long r1 = r9.c();
        int r3 = 0;
    L3:
        int r4 = r9.f();
        if (r4 == (-1)) goto L17;
        am3.g.a r5 = decodeExtensionFields(r4, r9);
        if (r4 != 1) goto L7;
        this._$$progress = Double.longBitsToDouble(r9.h());
        r3 = r3 | 1;
        goto L3
    L7:
        if (r4 != 2) goto L9;
        this.desc = vh7.f.a(r9, com.bytedance.android.live.base.model.message.a5.class);
        goto L3
    L9:
        if (r4 != 3) goto L11;
        this._$$showProgress = am3.h.a(r9);
        r3 = r3 | 2;
        goto L3
    L11:
        if (r4 != 4) goto L12;
        this._$$barColor = am3.h.c(r9);
        goto L3
    L12:
        am3.h.d(r5, r9);
        goto L3
    L17:
        r9.d(r1);
        setThreadSafe(true);
        if (this.desc != null) goto L21;
        this.desc = (com.bytedance.android.live.base.model.message.a5) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(com.bytedance.android.live.base.model.message.a5.class);
    L21:
        if ((r3 & 2) != 0) goto L24;
        this._$$showProgress = false;
    L24:
        if (this._$$barColor != null) goto L42;
        this._$$barColor = "";
        return;
    }

    public void setDesc(com.bytedance.android.live.base.model.message.a5 r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.desc = r2;
    }
}
