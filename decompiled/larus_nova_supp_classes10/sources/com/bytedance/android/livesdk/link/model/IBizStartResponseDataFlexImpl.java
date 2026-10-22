package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.api.battle.BizStartResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBizStartResponseDataFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/l3;", "", "bizExtra$delegate", "Ljava/lang/Object;", "getBizExtra", "()Ljava/lang/String;", "bizExtra", "", "pushType$delegate", "getPushType", "()I", "pushType", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBizStartResponseDataFlexImpl extends FlexModelBase<l3> implements l3, vh7.h {

    @SerializedName("biz_extra")
    protected String _$$bizExtra;

    @SerializedName("push_type")
    protected int _$$pushType;

    public IBizStartResponseDataFlexImpl() {
        super(l3.class);
        this._$$bizExtra = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.l3
    public final String getBizExtra() {
        return this._$$bizExtra;
    }

    @Override // com.bytedance.android.livesdk.link.model.l3
    public final int getPushType() {
        return this._$$pushType;
    }

    public IBizStartResponseDataFlexImpl(am3.g r6) {
        super(l3.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$bizExtra = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this._$$pushType = r6.i();
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$bizExtra != null) goto L25;
        this._$$bizExtra = "";
        return;
    }
}
