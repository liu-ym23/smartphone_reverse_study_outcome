package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.api.linkmic.TipBar")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0015\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IRivalsTipBarFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/z8;", "Lcom/bytedance/android/livesdk/link/model/IPkBarActionLinkmicFlexImpl;", "action$delegate", "Ljava/lang/Object;", "getAction", "()Lcom/bytedance/android/livesdk/link/model/IPkBarActionLinkmicFlexImpl;", "action", "", "infoContent$delegate", "getInfoContent", "()Ljava/lang/String;", "infoContent", "", "countDown$delegate", "getCountDown", "()J", "countDown", "schemaUrl$delegate", "getSchemaUrl", "schemaUrl", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IRivalsTipBarFlexImpl extends FlexModelBase<z8> implements z8, vh7.h {

    @SerializedName("action")
    protected IPkBarActionLinkmicFlexImpl _$$action;

    @SerializedName("countdown")
    protected long _$$countDown;

    @SerializedName("info_content_tpl")
    protected String _$$infoContent;

    @SerializedName("scheme_url")
    protected String _$$schemaUrl;

    public IRivalsTipBarFlexImpl() {
        super(z8.class);
        this._$$infoContent = "";
        this._$$schemaUrl = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.z8
    public /* bridge */ /* synthetic */ u7 getAction() {
        return getAction();
    }

    @Override // com.bytedance.android.livesdk.link.model.z8
    public final long getCountDown() {
        return this._$$countDown;
    }

    @Override // com.bytedance.android.livesdk.link.model.z8
    public final String getInfoContent() {
        return this._$$infoContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.z8
    public final String getSchemaUrl() {
        return this._$$schemaUrl;
    }

    @Override // com.bytedance.android.livesdk.link.model.z8
    public final IPkBarActionLinkmicFlexImpl getAction() {
        return this._$$action;
    }

    public IRivalsTipBarFlexImpl(am3.g r6) {
        super(z8.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L18;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$infoContent = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$countDown = r6.j();
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this._$$action = new IPkBarActionLinkmicFlexImpl(r6);
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this._$$schemaUrl = am3.h.c(r6);
        goto L3
    L13:
        am3.h.d(r3, r6);
        goto L3
    L18:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$infoContent != null) goto L22;
        this._$$infoContent = "";
    L22:
        if (this._$$schemaUrl != null) goto L40;
        this._$$schemaUrl = "";
        return;
    }
}
