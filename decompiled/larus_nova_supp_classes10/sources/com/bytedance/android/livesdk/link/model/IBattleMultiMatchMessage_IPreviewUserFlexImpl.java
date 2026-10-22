package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.im.BattleMultiMatchMessage.PreviewUser")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleMultiMatchMessage_IPreviewUserFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/w1$c;", "Lpy/k;", "avatar", "Lpy/k;", "getAvatar", "()Lpy/k;", "setAvatar", "(Lpy/k;)V", "", "nickName$delegate", "Ljava/lang/Object;", "getNickName", "()Ljava/lang/String;", "nickName", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleMultiMatchMessage_IPreviewUserFlexImpl extends FlexModelBase<w1.c> implements w1.c, vh7.h {

    @SerializedName("nickname")
    protected String _$$nickName;

    @SerializedName("avatar")
    protected py.k avatar;

    public IBattleMultiMatchMessage_IPreviewUserFlexImpl() {
        super(w1.c.class);
        this._$$nickName = "";
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    public IBattleMultiMatchMessage_IPreviewUserFlexImpl(am3.g r6) {
        super(w1.c.class);
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
        this.avatar = vh7.f.a(r6, py.k.class);
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

    @Override // com.bytedance.android.livesdk.link.model.w1.c
    public py.k getAvatar() {
        return this.avatar;
    }

    @Override // com.bytedance.android.livesdk.link.model.w1.c
    public final String getNickName() {
        return this._$$nickName;
    }

    public void setAvatar(py.k r1) {
        this.avatar = r1;
    }
}
