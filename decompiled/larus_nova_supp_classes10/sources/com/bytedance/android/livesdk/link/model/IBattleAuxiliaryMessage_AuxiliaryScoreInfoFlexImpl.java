package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.data.AuxiliaryScoreInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0010\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0017\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\u0013R\u001b\u0010\u001a\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0019\u0010\u0013R\u001b\u0010\u001d\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u001c\u0010\u0013¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleAuxiliaryMessage_AuxiliaryScoreInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/t0$a;", "Lpy/k;", "auxiliaryImg", "Lpy/k;", "getAuxiliaryImg", "()Lpy/k;", "setAuxiliaryImg", "(Lpy/k;)V", "", "anchorScore$delegate", "Ljava/lang/Object;", "getAnchorScore", "()Ljava/lang/String;", "anchorScore", "", "index$delegate", "getIndex", "()J", "index", "giftId$delegate", "getGiftId", "giftId", "auxiliaryType$delegate", "getAuxiliaryType", "auxiliaryType", "anchorScoreInt$delegate", "getAnchorScoreInt", "anchorScoreInt", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleAuxiliaryMessage_AuxiliaryScoreInfoFlexImpl extends FlexModelBase<t0.a> implements t0.a, vh7.h {

    @SerializedName("anchor_score")
    protected String _$$anchorScore;

    @SerializedName("anchor_score_int")
    protected long _$$anchorScoreInt;

    @SerializedName("auxiliary_type")
    protected long _$$auxiliaryType;

    @SerializedName("gift_id")
    protected long _$$giftId;

    @SerializedName("index")
    protected long _$$index;

    @SerializedName("auxiliary_img")
    protected py.k auxiliaryImg;

    public IBattleAuxiliaryMessage_AuxiliaryScoreInfoFlexImpl() {
        super(t0.a.class);
        this._$$anchorScore = "";
        this.auxiliaryImg = (py.k) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(py.k.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.t0.a
    public final String getAnchorScore() {
        return this._$$anchorScore;
    }

    @Override // com.bytedance.android.livesdk.link.model.t0.a
    public final long getAnchorScoreInt() {
        return this._$$anchorScoreInt;
    }

    @Override // com.bytedance.android.livesdk.link.model.t0.a
    public py.k getAuxiliaryImg() {
        return this.auxiliaryImg;
    }

    @Override // com.bytedance.android.livesdk.link.model.t0.a
    public final long getAuxiliaryType() {
        return this._$$auxiliaryType;
    }

    @Override // com.bytedance.android.livesdk.link.model.t0.a
    public final long getGiftId() {
        return this._$$giftId;
    }

    @Override // com.bytedance.android.livesdk.link.model.t0.a
    public final long getIndex() {
        return this._$$index;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
    public IBattleAuxiliaryMessage_AuxiliaryScoreInfoFlexImpl(am3.g r5) {
        super(t0.a.class);
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L14;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        this._$$anchorScoreInt = r5.j();
        goto L3
    L9:
        this._$$auxiliaryType = r5.j();
        goto L3
    L10:
        this._$$giftId = r5.j();
        goto L3
    L11:
        this._$$index = r5.j();
        goto L3
    L12:
        this.auxiliaryImg = vh7.f.a(r5, py.k.class);
        goto L3
    L13:
        this._$$anchorScore = am3.h.c(r5);
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L14:
        r5.d(r0);
        setThreadSafe(true);
        if (this._$$anchorScore != null) goto L18;
        this._$$anchorScore = "";
    L18:
        if (this.auxiliaryImg != null) goto L37;
        this.auxiliaryImg = (py.k) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(py.k.class);
        return;
    }

    public void setAuxiliaryImg(py.k r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.auxiliaryImg = r2;
    }
}
