package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.api.battle.RivalsRecommendResponse.TopTip")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ITopTipFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/ITopTip;", "Lpy/k;", "topImg", "Lpy/k;", "getTopImg", "()Lpy/k;", "setTopImg", "(Lpy/k;)V", "", "topContent$delegate", "Ljava/lang/Object;", "getTopContent", "()Ljava/lang/String;", "topContent", "", "topTipType$delegate", "getTopTipType", "()I", "topTipType", "schemeUrl$delegate", "getSchemeUrl", "schemeUrl", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ITopTipFlexImpl extends FlexModelBase<ITopTip> implements ITopTip, vh7.h {

    @SerializedName("scheme_url")
    protected String _$$schemeUrl;

    @SerializedName("content")
    protected String _$$topContent;

    @SerializedName("top_tip_type")
    protected int _$$topTipType;

    @SerializedName("img")
    protected py.k topImg;

    public ITopTipFlexImpl() {
        super(ITopTip.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.ITopTip
    public final String getSchemeUrl() {
        return this._$$schemeUrl;
    }

    @Override // com.bytedance.android.livesdk.link.model.ITopTip
    public final String getTopContent() {
        return this._$$topContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.ITopTip
    public py.k getTopImg() {
        return this.topImg;
    }

    @Override // com.bytedance.android.livesdk.link.model.ITopTip
    public final int getTopTipType() {
        return this._$$topTipType;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    public ITopTipFlexImpl(am3.g r6) {
        super(ITopTip.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L18;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$topContent = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.topImg = vh7.f.a(r6, py.k.class);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this._$$topTipType = r6.i();
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this._$$schemeUrl = am3.h.c(r6);
        goto L3
    L13:
        am3.h.d(r3, r6);
        goto L3
    L18:
        r6.d(r0);
        setThreadSafe(true);
    }

    public void setTopImg(py.k r1) {
        this.topImg = r1;
    }
}
