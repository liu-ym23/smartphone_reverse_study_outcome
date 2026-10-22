package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.im.BattleSeasonPKResultMessage.PKResultPointsDescription")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R/\u0010\u0016\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IPKResultPointsDescriptionFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/m7;", "", "<set-?>", "pointDesc$delegate", "Ljava/lang/Object;", "getPointDesc", "()Ljava/lang/String;", "setPointDesc", "(Ljava/lang/String;)V", "pointDesc", "", "point$delegate", "getPoint", "()Ljava/lang/Long;", "setPoint", "(Ljava/lang/Long;)V", "point", "pointStr$delegate", "getPointStr", "setPointStr", "pointStr", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IPKResultPointsDescriptionFlexImpl extends FlexModelBase<m7> implements m7, vh7.h {

    @SerializedName("point")
    protected Long _$$point;

    @SerializedName("point_desc")
    protected String _$$pointDesc;

    @SerializedName("point_str")
    protected String _$$pointStr;

    public IPKResultPointsDescriptionFlexImpl() {
        super(m7.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.m7
    public final Long getPoint() {
        return this._$$point;
    }

    @Override // com.bytedance.android.livesdk.link.model.m7
    public final String getPointDesc() {
        return this._$$pointDesc;
    }

    @Override // com.bytedance.android.livesdk.link.model.m7
    public final String getPointStr() {
        return this._$$pointStr;
    }

    public IPKResultPointsDescriptionFlexImpl(am3.g r6) {
        super(m7.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L15;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$pointDesc = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$point = Long.valueOf(r6.j());
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this._$$pointStr = am3.h.c(r6);
        goto L3
    L11:
        am3.h.d(r3, r6);
        goto L3
    L15:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.link.model.m7
    public final void setPoint(Long r1) {
        this._$$point = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.m7
    public final void setPointDesc(String r1) {
        this._$$pointDesc = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.m7
    public final void setPointStr(String r1) {
        this._$$pointStr = r1;
    }
}
