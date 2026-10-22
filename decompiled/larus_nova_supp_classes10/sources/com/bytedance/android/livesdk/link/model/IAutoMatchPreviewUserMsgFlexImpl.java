package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.im.BattleAutoMatchMessage.PreviewUser")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IAutoMatchPreviewUserMsgFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/i0;", "", "<set-?>", "nickName$delegate", "Ljava/lang/Object;", "getNickName", "()Ljava/lang/String;", "setNickName", "(Ljava/lang/String;)V", "nickName", "Lpy/k;", "avatar$delegate", "getAvatar", "()Lpy/k;", "setAvatar", "(Lpy/k;)V", "avatar", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IAutoMatchPreviewUserMsgFlexImpl extends FlexModelBase<i0> implements i0, vh7.h {

    @SerializedName("avatar")
    protected py.k _$$avatar;

    @SerializedName("nickname")
    protected String _$$nickName;

    public IAutoMatchPreviewUserMsgFlexImpl() {
        super(i0.class);
        this._$$nickName = "";
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    public IAutoMatchPreviewUserMsgFlexImpl(am3.g r6) {
        super(i0.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$nickName = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this._$$avatar = vh7.f.a(r6, py.k.class);
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$nickName != null) goto L25;
        this._$$nickName = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.i0
    public final py.k getAvatar() {
        return this._$$avatar;
    }

    @Override // com.bytedance.android.livesdk.link.model.i0
    public final String getNickName() {
        return this._$$nickName;
    }

    @Override // com.bytedance.android.livesdk.link.model.i0
    public final void setAvatar(py.k r1) {
        this._$$avatar = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.i0
    public final void setNickName(String r1) {
        this._$$nickName = r1;
    }
}
