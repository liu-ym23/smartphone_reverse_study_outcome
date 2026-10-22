package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.data.BanUser")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001b\u0010\u000e\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\bR/\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0011\u0010\nR\u001b\u0010\u0015\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBanUserFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/j0;", "", "<set-?>", "reason$delegate", "Ljava/lang/Object;", "getReason", "()Ljava/lang/String;", "setReason", "(Ljava/lang/String;)V", "reason", "url$delegate", "getUrl", "url", "userId$delegate", "getUserId", "setUserId", "userId", "schemaUrl$delegate", "getSchemaUrl", "schemaUrl", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBanUserFlexImpl extends FlexModelBase<j0> implements j0, vh7.h {

    @SerializedName("reason")
    protected String _$$reason;

    @SerializedName("schema_url")
    protected String _$$schemaUrl;

    @SerializedName("url")
    protected String _$$url;

    @SerializedName("open_id")
    protected String _$$userId;

    public IBanUserFlexImpl() {
        super(j0.class);
        this._$$reason = "";
        this._$$url = "";
        this._$$schemaUrl = "";
    }

    public IBanUserFlexImpl(am3.g r6) {
        super(j0.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L18;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 2) goto L8;
        this._$$reason = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 3) goto L10;
        this._$$url = am3.h.c(r6);
        goto L3
    L10:
        if (r2 != 6) goto L12;
        this._$$schemaUrl = am3.h.c(r6);
        goto L3
    L12:
        if (r2 != 5000) goto L13;
        this._$$userId = am3.h.c(r6);
        goto L3
    L13:
        am3.h.d(r3, r6);
        goto L3
    L18:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$reason != null) goto L22;
        this._$$reason = "";
    L22:
        if (this._$$url != null) goto L25;
        this._$$url = "";
    L25:
        if (this._$$schemaUrl != null) goto L43;
        this._$$schemaUrl = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.j0
    public final String getReason() {
        return this._$$reason;
    }

    @Override // com.bytedance.android.livesdk.link.model.j0
    public final String getSchemaUrl() {
        return this._$$schemaUrl;
    }

    @Override // com.bytedance.android.livesdk.link.model.j0
    public final String getUrl() {
        return this._$$url;
    }

    @Override // com.bytedance.android.livesdk.link.model.j0
    public final String getUserId() {
        return this._$$userId;
    }

    @Override // com.bytedance.android.livesdk.link.model.j0
    public final void setReason(String r1) {
        this._$$reason = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.j0
    public final void setUserId(String r1) {
        this._$$userId = r1;
    }
}
