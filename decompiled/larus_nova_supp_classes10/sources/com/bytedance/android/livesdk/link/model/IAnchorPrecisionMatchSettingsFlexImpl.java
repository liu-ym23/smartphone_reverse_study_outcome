package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.data.PrecisionMatchSettings")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IAnchorPrecisionMatchSettingsFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/w;", "", "acceptPrecisionMatch$delegate", "Ljava/lang/Object;", "getAcceptPrecisionMatch", "()Z", "acceptPrecisionMatch", "", "precisionMatchPreferGender$delegate", "getPrecisionMatchPreferGender", "()J", "precisionMatchPreferGender", "precisionMatchFrequency$delegate", "getPrecisionMatchFrequency", "precisionMatchFrequency", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IAnchorPrecisionMatchSettingsFlexImpl extends FlexModelBase<w> implements w, vh7.h {

    @SerializedName("accept_precision_match")
    protected boolean _$$acceptPrecisionMatch;

    @SerializedName("precision_match_frequency")
    protected long _$$precisionMatchFrequency;

    @SerializedName("precision_match_prefer_gender")
    protected long _$$precisionMatchPreferGender;

    public IAnchorPrecisionMatchSettingsFlexImpl() {
        super(w.class);
        this._$$acceptPrecisionMatch = false;
    }

    @Override // com.bytedance.android.livesdk.link.model.w
    public final boolean getAcceptPrecisionMatch() {
        return this._$$acceptPrecisionMatch;
    }

    @Override // com.bytedance.android.livesdk.link.model.w
    public final long getPrecisionMatchFrequency() {
        return this._$$precisionMatchFrequency;
    }

    @Override // com.bytedance.android.livesdk.link.model.w
    public final long getPrecisionMatchPreferGender() {
        return this._$$precisionMatchPreferGender;
    }

    public IAnchorPrecisionMatchSettingsFlexImpl(am3.g r8) {
        super(w.class);
        setThreadSafe(false);
        long r1 = r8.c();
        int r3 = 0;
    L3:
        int r4 = r8.f();
        if (r4 == (-1)) goto L15;
        am3.g.a r5 = decodeExtensionFields(r4, r8);
        if (r4 != 1) goto L8;
        this._$$acceptPrecisionMatch = am3.h.a(r8);
        r3 = r3 | 1;
        goto L3
    L8:
        if (r4 != 2) goto L10;
        this._$$precisionMatchPreferGender = r8.j();
        r3 = r3 | 2;
        goto L3
    L10:
        if (r4 != 3) goto L11;
        this._$$precisionMatchFrequency = r8.j();
        r3 = r3 | 4;
        goto L3
    L11:
        am3.h.d(r5, r8);
        goto L3
    L15:
        r8.d(r1);
        setThreadSafe(true);
        if ((r3 & 1) != 0) goto L31;
        this._$$acceptPrecisionMatch = false;
        return;
    }
}
