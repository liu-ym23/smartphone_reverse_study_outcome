package com.bytedance.livesdk.ktvcommon.api;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@ProtoMessage("webcast.api.ktv.GetMidiConfigResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\f\u0010\rR/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/livesdk/ktvcommon/api/IGetMidiConfigResponseFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/livesdk/ktvcommon/api/a;", "Lcom/bytedance/livesdk/ktvcommon/api/i;", "<set-?>", "ktvMidiConfig$delegate", "Ljava/lang/Object;", "getKtvMidiConfig", "()Lcom/bytedance/livesdk/ktvcommon/api/i;", "setKtvMidiConfig", "(Lcom/bytedance/livesdk/ktvcommon/api/i;)V", "ktvMidiConfig", "<init>", "()V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IGetMidiConfigResponseFlexImpl extends FlexModelBase<a> implements a, vh7.h {

    @SerializedName("ktv_midi_config")
    protected i _$$ktvMidiConfig;

    public IGetMidiConfigResponseFlexImpl() {
        super(a.class);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.livesdk.ktvcommon.api.i, java.lang.Object] */
    public IGetMidiConfigResponseFlexImpl(am3.g r100) {
        super(a.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L7;
        this._$$ktvMidiConfig = vh7.f.a(r100, i.class);
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L9:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.livesdk.ktvcommon.api.a
    public final i getKtvMidiConfig() {
        return this._$$ktvMidiConfig;
    }

    @Override // com.bytedance.livesdk.ktvcommon.api.a
    public final void setKtvMidiConfig(i r100) {
        this._$$ktvMidiConfig = r100;
    }
}
