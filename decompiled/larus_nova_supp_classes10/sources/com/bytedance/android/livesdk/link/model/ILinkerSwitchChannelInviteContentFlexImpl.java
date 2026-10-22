package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.im.LinkerSwitchChannelInviteContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\f\u0010\rR+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkerSwitchChannelInviteContentFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/o6;", "Lcom/bytedance/android/livesdk/link/model/e6;", "<set-?>", "inviteContent$delegate", "Ljava/lang/Object;", "getInviteContent", "()Lcom/bytedance/android/livesdk/link/model/e6;", "setInviteContent", "(Lcom/bytedance/android/livesdk/link/model/e6;)V", "inviteContent", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkerSwitchChannelInviteContentFlexImpl extends FlexModelBase<o6> implements o6, vh7.h {

    @SerializedName("content")
    protected e6 _$$inviteContent;

    public ILinkerSwitchChannelInviteContentFlexImpl() {
        super(o6.class);
        this._$$inviteContent = $defaultValue_inviteContent$();
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.livesdk.link.model.e6, java.lang.Object] */
    public ILinkerSwitchChannelInviteContentFlexImpl(am3.g r6) {
        super(o6.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L9;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L7;
        this._$$inviteContent = vh7.f.a(r6, e6.class);
        goto L3
    L7:
        am3.h.d(r3, r6);
        goto L3
    L9:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$inviteContent != null) goto L19;
        this._$$inviteContent = $defaultValue_inviteContent$();
        return;
    }

    public final e6 $defaultValue_inviteContent$() {
        return (e6) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(e6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.o6
    public final e6 getInviteContent() {
        return this._$$inviteContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.o6
    public final void setInviteContent(e6 r1) {
        this._$$inviteContent = r1;
    }
}
