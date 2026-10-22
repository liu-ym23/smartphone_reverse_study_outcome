package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.api.battle.Content")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IContentFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/z3;", "Lpy/k;", "image", "Lpy/k;", "getImage", "()Lpy/k;", "setImage", "(Lpy/k;)V", "", "type$delegate", "Ljava/lang/Object;", "getType", "()Ljava/lang/Integer;", LocationMonitorConst.TYPE, "", "text$delegate", "getText", "()Ljava/lang/String;", "text", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IContentFlexImpl extends FlexModelBase<z3> implements z3, vh7.h {

    @SerializedName("text")
    protected String _$$text;

    @SerializedName(LocationMonitorConst.TYPE)
    protected Integer _$$type;

    @SerializedName("image")
    protected py.k image;

    public IContentFlexImpl() {
        super(z3.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.z3
    public py.k getImage() {
        return this.image;
    }

    @Override // com.bytedance.android.livesdk.link.model.z3
    public final String getText() {
        return this._$$text;
    }

    @Override // com.bytedance.android.livesdk.link.model.z3
    public final Integer getType() {
        return this._$$type;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    public IContentFlexImpl(am3.g r6) {
        super(z3.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L15;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$type = Integer.valueOf(r6.i());
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$text = am3.h.c(r6);
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this.image = vh7.f.a(r6, py.k.class);
        goto L3
    L11:
        am3.h.d(r3, r6);
        goto L3
    L15:
        r6.d(r0);
        setThreadSafe(true);
    }

    public void setImage(py.k r1) {
        this.image = r1;
    }
}
