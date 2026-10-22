package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.api.battle.PropInfoNotifyResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0006\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IPropInfoNotifyResponseFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/IPropInfoNotifyResponse;", "", "isNotify$delegate", "Ljava/lang/Object;", "isNotify", "()Z", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IPropInfoNotifyResponseFlexImpl extends FlexModelBase<IPropInfoNotifyResponse> implements IPropInfoNotifyResponse, vh7.h {

    @SerializedName("is_notify")
    protected boolean _$$isNotify;

    public IPropInfoNotifyResponseFlexImpl() {
        super(IPropInfoNotifyResponse.class);
        this._$$isNotify = false;
    }

    public IPropInfoNotifyResponseFlexImpl(am3.g r8) {
        super(IPropInfoNotifyResponse.class);
        setThreadSafe(false);
        long r1 = r8.c();
        boolean r3 = false;
    L3:
        int r4 = r8.f();
        if (r4 == (-1)) goto L9;
        am3.g.a r5 = decodeExtensionFields(r4, r8);
        if (r4 != 1) goto L7;
        this._$$isNotify = am3.h.a(r8);
        r3 = r3 | true;
        goto L3
    L7:
        am3.h.d(r5, r8);
        goto L3
    L9:
        r8.d(r1);
        setThreadSafe(true);
        if ((r3 & true) == true) goto L19;
        this._$$isNotify = false;
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.IPropInfoNotifyResponse
    public final boolean isNotify() {
        return this._$$isNotify;
    }
}
