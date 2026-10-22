package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.im.LinkerSwitchChannelCancelContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\f\u0010\rR+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkerSwitchChannelCancelContentFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/n6;", "Lcom/bytedance/android/livesdk/link/model/x5;", "<set-?>", "cancelContent$delegate", "Ljava/lang/Object;", "getCancelContent", "()Lcom/bytedance/android/livesdk/link/model/x5;", "setCancelContent", "(Lcom/bytedance/android/livesdk/link/model/x5;)V", "cancelContent", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkerSwitchChannelCancelContentFlexImpl extends FlexModelBase<n6> implements n6, vh7.h {

    @SerializedName("content")
    protected x5 _$$cancelContent;

    public ILinkerSwitchChannelCancelContentFlexImpl() {
        super(n6.class);
        this._$$cancelContent = $defaultValue_cancelContent$();
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.livesdk.link.model.x5, java.lang.Object] */
    public ILinkerSwitchChannelCancelContentFlexImpl(am3.g r6) {
        super(n6.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L9;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L7;
        this._$$cancelContent = vh7.f.a(r6, x5.class);
        goto L3
    L7:
        am3.h.d(r3, r6);
        goto L3
    L9:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$cancelContent != null) goto L19;
        this._$$cancelContent = $defaultValue_cancelContent$();
        return;
    }

    public final x5 $defaultValue_cancelContent$() {
        return (x5) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(x5.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.n6
    public final x5 getCancelContent() {
        return this._$$cancelContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.n6
    public final void setCancelContent(x5 r1) {
        this._$$cancelContent = r1;
    }
}
