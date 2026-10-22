package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.data.InteractEffectInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/InteractEffectInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/da;", "", "<set-?>", "resourceId$delegate", "Ljava/lang/Object;", "getResourceId", "()Ljava/lang/String;", "setResourceId", "(Ljava/lang/String;)V", "resourceId", "Lpy/k;", "icon$delegate", "getIcon", "()Lpy/k;", "setIcon", "(Lpy/k;)V", "icon", "effectId$delegate", "getEffectId", "setEffectId", "effectId", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractEffectInfoFlexImpl extends FlexModelBase<da> implements da, vh7.h {

    @SerializedName("effect_id")
    protected String _$$effectId;

    @SerializedName("icon")
    protected py.k _$$icon;

    @SerializedName("resource_id")
    protected String _$$resourceId;

    public InteractEffectInfoFlexImpl() {
        super(da.class);
        this._$$resourceId = "";
        this._$$icon = $defaultValue_icon$();
        this._$$effectId = "";
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
    public InteractEffectInfoFlexImpl(am3.g r6) {
        super(da.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L15;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$resourceId = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$icon = vh7.f.a(r6, py.k.class);
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this._$$effectId = am3.h.c(r6);
        goto L3
    L11:
        am3.h.d(r3, r6);
        goto L3
    L15:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$resourceId != null) goto L19;
        this._$$resourceId = "";
    L19:
        if (this._$$icon != null) goto L22;
        this._$$icon = $defaultValue_icon$();
    L22:
        if (this._$$effectId != null) goto L37;
        this._$$effectId = "";
        return;
    }

    public final py.k $defaultValue_icon$() {
        return (py.k) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(py.k.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.da
    public final String getEffectId() {
        return this._$$effectId;
    }

    @Override // com.bytedance.android.livesdk.link.model.da
    public final py.k getIcon() {
        return this._$$icon;
    }

    @Override // com.bytedance.android.livesdk.link.model.da
    public final String getResourceId() {
        return this._$$resourceId;
    }

    @Override // com.bytedance.android.livesdk.link.model.da
    public final void setEffectId(String r1) {
        this._$$effectId = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.da
    public final void setIcon(py.k r1) {
        this._$$icon = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.da
    public final void setResourceId(String r1) {
        this._$$resourceId = r1;
    }
}
