package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.data.BattleTitleConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001f\u0010 R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\r\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001b\u0010\u0015\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0018\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014R\u001b\u0010\u001b\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014R\u001b\u0010\u001e\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0014¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleTitleConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/h3;", "Lpy/k;", "newIcon", "Lpy/k;", "getNewIcon", "()Lpy/k;", "setNewIcon", "(Lpy/k;)V", "preIcon", "getPreIcon", "setPreIcon", "iconBackImg", "getIconBackImg", "setIconBackImg", "", "content$delegate", "Ljava/lang/Object;", "getContent", "()Ljava/lang/String;", "content", "scheme$delegate", "getScheme", "scheme", "schemeHotsoon$delegate", "getSchemeHotsoon", "schemeHotsoon", "schemeSaas$delegate", "getSchemeSaas", "schemeSaas", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleTitleConfigFlexImpl extends FlexModelBase<h3> implements h3, vh7.h {

    @SerializedName("content")
    protected String _$$content;

    @SerializedName("scheme")
    protected String _$$scheme;

    @SerializedName("hotsoon_scheme")
    protected String _$$schemeHotsoon;

    @SerializedName("open_scheme")
    protected String _$$schemeSaas;

    @SerializedName("icon_back_img")
    protected py.k iconBackImg;

    @SerializedName("new_icon")
    protected py.k newIcon;

    @SerializedName("pre_icon")
    protected py.k preIcon;

    public IBattleTitleConfigFlexImpl() {
        super(h3.class);
        this._$$content = "";
        this._$$scheme = "";
        this._$$schemeHotsoon = "";
        this._$$schemeSaas = "";
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object, py.k] */
    public IBattleTitleConfigFlexImpl(am3.g r6) {
        super(h3.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L27;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 2) goto L8;
        this._$$content = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 3) goto L10;
        this._$$scheme = am3.h.c(r6);
        goto L3
    L10:
        if (r2 != 4) goto L12;
        this._$$schemeHotsoon = am3.h.c(r6);
        goto L3
    L12:
        if (r2 != 7) goto L14;
        this.newIcon = vh7.f.a(r6, py.k.class);
        goto L3
    L14:
        if (r2 != 8) goto L16;
        this.preIcon = vh7.f.a(r6, py.k.class);
        goto L3
    L16:
        if (r2 != 9) goto L18;
        this.iconBackImg = vh7.f.a(r6, py.k.class);
        goto L3
    L18:
        if (r2 != 12) goto L19;
        this._$$schemeSaas = am3.h.c(r6);
        goto L3
    L19:
        am3.h.d(r3, r6);
        goto L3
    L27:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$content != null) goto L31;
        this._$$content = "";
    L31:
        if (this._$$scheme != null) goto L34;
        this._$$scheme = "";
    L34:
        if (this._$$schemeHotsoon != null) goto L37;
        this._$$schemeHotsoon = "";
    L37:
        if (this._$$schemeSaas != null) goto L64;
        this._$$schemeSaas = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.h3
    public final String getContent() {
        return this._$$content;
    }

    @Override // com.bytedance.android.livesdk.link.model.h3
    public py.k getIconBackImg() {
        return this.iconBackImg;
    }

    @Override // com.bytedance.android.livesdk.link.model.h3
    public py.k getNewIcon() {
        return this.newIcon;
    }

    @Override // com.bytedance.android.livesdk.link.model.h3
    public py.k getPreIcon() {
        return this.preIcon;
    }

    @Override // com.bytedance.android.livesdk.link.model.h3
    public final String getScheme() {
        return this._$$scheme;
    }

    @Override // com.bytedance.android.livesdk.link.model.h3
    public final String getSchemeHotsoon() {
        return this._$$schemeHotsoon;
    }

    @Override // com.bytedance.android.livesdk.link.model.h3
    public final String getSchemeSaas() {
        return this._$$schemeSaas;
    }

    public void setIconBackImg(py.k r1) {
        this.iconBackImg = r1;
    }

    public void setNewIcon(py.k r1) {
        this.newIcon = r1;
    }

    public void setPreIcon(py.k r1) {
        this.preIcon = r1;
    }
}
