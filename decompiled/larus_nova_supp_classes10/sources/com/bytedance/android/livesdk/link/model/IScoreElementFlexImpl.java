package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.data.CustomConfig.ScoreElement")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IScoreElementFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/c9;", "", "<set-?>", "valueKind$delegate", "Ljava/lang/Object;", "getValueKind", "()J", "setValueKind", "(J)V", "valueKind", "", "valueName$delegate", "getValueName", "()Ljava/lang/String;", "setValueName", "(Ljava/lang/String;)V", "valueName", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IScoreElementFlexImpl extends FlexModelBase<c9> implements c9, vh7.h {

    @SerializedName("value_kind")
    protected long _$$valueKind;

    @SerializedName("value_name")
    protected String _$$valueName;

    public IScoreElementFlexImpl() {
        super(c9.class);
        this._$$valueName = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.c9
    public final long getValueKind() {
        return this._$$valueKind;
    }

    @Override // com.bytedance.android.livesdk.link.model.c9
    public final String getValueName() {
        return this._$$valueName;
    }

    public IScoreElementFlexImpl(am3.g r6) {
        super(c9.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$valueKind = r6.j();
        goto L3
    L8:
        if (r2 != 4) goto L9;
        this._$$valueName = am3.h.c(r6);
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$valueName != null) goto L25;
        this._$$valueName = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.c9
    public final void setValueKind(long r1) {
        this._$$valueKind = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.c9
    public final void setValueName(String r1) {
        this._$$valueName = r1;
    }
}
