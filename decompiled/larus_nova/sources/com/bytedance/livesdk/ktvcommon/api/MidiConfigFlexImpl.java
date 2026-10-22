package com.bytedance.livesdk.ktvcommon.api;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@ProtoMessage("webcast.api.ktv.GetMidiConfigResponse.MidiConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nRG\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f2\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/bytedance/livesdk/ktvcommon/api/MidiConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/livesdk/ktvcommon/api/i;", "", "<set-?>", "scoreReportingDurationThreshold$delegate", "Ljava/lang/Object;", "getScoreReportingDurationThreshold", "()Ljava/lang/Long;", "setScoreReportingDurationThreshold", "(Ljava/lang/Long;)V", "scoreReportingDurationThreshold", "", "", "Lcom/bytedance/livesdk/ktvcommon/api/j;", "rateFeedback$delegate", "getRateFeedback", "()Ljava/util/Map;", "setRateFeedback", "(Ljava/util/Map;)V", "rateFeedback", "scoreReportingThresholdSungPercent$delegate", "getScoreReportingThresholdSungPercent", "scoreReportingThresholdSungPercent", "<init>", "()V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MidiConfigFlexImpl extends FlexModelBase<i> implements i, vh7.h {

    @SerializedName("rate_feedback")
    protected Map<String, ? extends j> _$$rateFeedback;

    @SerializedName("score_reporting_duration_threshold")
    protected Long _$$scoreReportingDurationThreshold;

    @SerializedName("score_reporting_threshold_sung_percent")
    protected Long _$$scoreReportingThresholdSungPercent;

    public MidiConfigFlexImpl() {
        super(i.class);
    }

    @Override // com.bytedance.livesdk.ktvcommon.api.i
    public final Map<String, j> getRateFeedback() {
        return this._$$rateFeedback;
    }

    @Override // com.bytedance.livesdk.ktvcommon.api.i
    public final Long getScoreReportingDurationThreshold() {
        return this._$$scoreReportingDurationThreshold;
    }

    @Override // com.bytedance.livesdk.ktvcommon.api.i
    public final Long getScoreReportingThresholdSungPercent() {
        return this._$$scoreReportingThresholdSungPercent;
    }

    public MidiConfigFlexImpl(am3.g r110) {
        super(i.class);
        this._$$rateFeedback = new HashMap();
        setThreadSafe(false);
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L30;
        am3.g.a r102 = decodeExtensionFields(r101, r110);
        if (r101 != 1) goto L8;
        this._$$scoreReportingDurationThreshold = Long.valueOf(r110.j());
        goto L3
    L8:
        if (r101 != 2) goto L10;
        long r103 = r110.c();
        String r104 = null;
        Object r105 = null;
    L14:
        int r106 = r110.f();
        if (r106 == (-1)) goto L21;
        if (r106 != 1) goto L17;
        r104 = am3.h.c(r110);
        goto L14
    L17:
        if (r106 != 2) goto L18;
        r105 = vh7.f.a(r110, j.class);
        goto L14
    L18:
        am3.h.e(r110);
        goto L14
    L21:
        r110.d(r103);
        Map<String, ? extends j> r107 = this._$$rateFeedback;
        if (r104 == null) goto L28;
        if (r105 == null) goto L26;
        r107.put(r104, r105);
        goto L3
    L26:
        throw new IllegalStateException("Value must not be null");
    L28:
        throw new IllegalStateException("Key must not be null");
    L10:
        if (r101 != 3) goto L11;
        this._$$scoreReportingThresholdSungPercent = Long.valueOf(r110.j());
        goto L3
    L11:
        am3.h.d(r102, r110);
        goto L3
    L30:
        r110.d(r100);
        setThreadSafe(true);
    }

    @Override // com.bytedance.livesdk.ktvcommon.api.i
    public final void setRateFeedback(Map<String, ? extends j> r100) {
        this._$$rateFeedback = r100;
    }

    @Override // com.bytedance.livesdk.ktvcommon.api.i
    public final void setScoreReportingDurationThreshold(Long r100) {
        this._$$scoreReportingDurationThreshold = r100;
    }
}
