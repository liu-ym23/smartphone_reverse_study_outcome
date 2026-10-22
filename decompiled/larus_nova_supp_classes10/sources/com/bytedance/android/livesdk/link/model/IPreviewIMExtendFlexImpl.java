package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.data.PreviewExposeData.PreviewIMExtend")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0012\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u001b\u0010\u0015\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IPreviewIMExtendFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/IPreviewIMExtend;", "Lpy/k;", "icon", "Lpy/k;", "getIcon", "()Lpy/k;", "setIcon", "(Lpy/k;)V", "", "mainTitle$delegate", "Ljava/lang/Object;", "getMainTitle", "()Ljava/lang/String;", "mainTitle", "subTitle$delegate", "getSubTitle", "subTitle", "extra$delegate", "getExtra", "extra", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IPreviewIMExtendFlexImpl extends FlexModelBase<IPreviewIMExtend> implements IPreviewIMExtend, vh7.h {

    @SerializedName("extra")
    protected String _$$extra;

    @SerializedName("main_title")
    protected String _$$mainTitle;

    @SerializedName("sub_title")
    protected String _$$subTitle;

    @SerializedName("icon")
    protected py.k icon;

    public IPreviewIMExtendFlexImpl() {
        super(IPreviewIMExtend.class);
        this._$$mainTitle = "";
        this._$$subTitle = "";
        this._$$extra = "";
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, py.k] */
    public IPreviewIMExtendFlexImpl(am3.g r6) {
        super(IPreviewIMExtend.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L18;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 2) goto L8;
        this.icon = vh7.f.a(r6, py.k.class);
        goto L3
    L8:
        if (r2 != 3) goto L10;
        this._$$mainTitle = am3.h.c(r6);
        goto L3
    L10:
        if (r2 != 4) goto L12;
        this._$$subTitle = am3.h.c(r6);
        goto L3
    L12:
        if (r2 != 5) goto L13;
        this._$$extra = am3.h.c(r6);
        goto L3
    L13:
        am3.h.d(r3, r6);
        goto L3
    L18:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$mainTitle != null) goto L22;
        this._$$mainTitle = "";
    L22:
        if (this._$$subTitle != null) goto L25;
        this._$$subTitle = "";
    L25:
        if (this._$$extra != null) goto L43;
        this._$$extra = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.IPreviewIMExtend
    public final String getExtra() {
        return this._$$extra;
    }

    @Override // com.bytedance.android.livesdk.link.model.IPreviewIMExtend
    public py.k getIcon() {
        return this.icon;
    }

    @Override // com.bytedance.android.livesdk.link.model.IPreviewIMExtend
    public final String getMainTitle() {
        return this._$$mainTitle;
    }

    @Override // com.bytedance.android.livesdk.link.model.IPreviewIMExtend
    public final String getSubTitle() {
        return this._$$subTitle;
    }

    public void setIcon(py.k r1) {
        this.icon = r1;
    }
}
