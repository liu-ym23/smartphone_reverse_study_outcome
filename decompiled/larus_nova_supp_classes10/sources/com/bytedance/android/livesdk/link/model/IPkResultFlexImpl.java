package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.im.BattleSeasonPKResultMessage.PKResult")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR/\u0010\u0016\u001a\u0004\u0018\u00010\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R#\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IPkResultFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/x7;", "Lpy/k;", "<set-?>", "resultImg$delegate", "Ljava/lang/Object;", "getResultImg", "()Lpy/k;", "setResultImg", "(Lpy/k;)V", "resultImg", "energyImg$delegate", "getEnergyImg", "setEnergyImg", "energyImg", "", "resultStr$delegate", "getResultStr", "()Ljava/lang/String;", "setResultStr", "(Ljava/lang/String;)V", "resultStr", "", "Lcom/bytedance/android/livesdk/link/model/IPKResultPointsDescriptionFlexImpl;", "descriptions$delegate", "getDescriptions", "()Ljava/util/List;", "descriptions", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IPkResultFlexImpl extends FlexModelBase<x7> implements x7, vh7.h {

    @SerializedName("descriptions")
    protected List<IPKResultPointsDescriptionFlexImpl> _$$descriptions;

    @SerializedName("bg_img")
    protected py.k _$$energyImg;

    @SerializedName("result_img")
    protected py.k _$$resultImg;

    @SerializedName("result_str")
    protected String _$$resultStr;

    public IPkResultFlexImpl() {
        super(x7.class);
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, py.k] */
    public IPkResultFlexImpl(am3.g r6) {
        super(x7.class);
        this._$$descriptions = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L18;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$resultImg = vh7.f.a(r6, py.k.class);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$energyImg = vh7.f.a(r6, py.k.class);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this._$$resultStr = am3.h.c(r6);
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this._$$descriptions.add(new IPKResultPointsDescriptionFlexImpl(r6));
        goto L3
    L13:
        am3.h.d(r3, r6);
        goto L3
    L18:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.link.model.x7
    public final List<IPKResultPointsDescriptionFlexImpl> getDescriptions() {
        return this._$$descriptions;
    }

    @Override // com.bytedance.android.livesdk.link.model.x7
    public final py.k getEnergyImg() {
        return this._$$energyImg;
    }

    @Override // com.bytedance.android.livesdk.link.model.x7
    public final py.k getResultImg() {
        return this._$$resultImg;
    }

    @Override // com.bytedance.android.livesdk.link.model.x7
    public final String getResultStr() {
        return this._$$resultStr;
    }

    @Override // com.bytedance.android.livesdk.link.model.x7
    public final void setEnergyImg(py.k r1) {
        this._$$energyImg = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.x7
    public final void setResultImg(py.k r1) {
        this._$$resultImg = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.x7
    public final void setResultStr(String r1) {
        this._$$resultStr = r1;
    }
}
