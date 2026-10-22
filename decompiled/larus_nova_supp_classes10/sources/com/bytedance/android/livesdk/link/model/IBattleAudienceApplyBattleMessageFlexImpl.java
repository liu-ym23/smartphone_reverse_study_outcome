package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.im.BattleAudienceApplyBattleMessage")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001f\u0010 R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u001d\u0010\u0015\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000eR\u001d\u0010\u0018\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u000eR\u001d\u0010\u001b\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u001a\u0010\u000eR\u001d\u0010\u001e\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\f\u001a\u0004\b\u001d\u0010\u000e¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleAudienceApplyBattleMessageFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/q0;", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "", "anchorId$delegate", "Ljava/lang/Object;", "getAnchorId", "()Ljava/lang/String;", "anchorId", "roomId$delegate", "getRoomId", "roomId", "desc$delegate", "getDesc", "desc", "subDesc$delegate", "getSubDesc", "subDesc", "title$delegate", "getTitle", "title", "anchorOpenId$delegate", "getAnchorOpenId", "anchorOpenId", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleAudienceApplyBattleMessageFlexImpl extends FlexModelBase<q0> implements q0, vh7.h {

    @SerializedName("anchor_id")
    protected String _$$anchorId;

    @SerializedName("anchor_open_id")
    protected String _$$anchorOpenId;

    @SerializedName("desc")
    protected String _$$desc;

    @SerializedName("room_id")
    protected String _$$roomId;

    @SerializedName("sub_desc")
    protected String _$$subDesc;

    @SerializedName("title")
    protected String _$$title;

    @SerializedName("user")
    protected IBaseUser user;

    public IBattleAudienceApplyBattleMessageFlexImpl() {
        super(q0.class);
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
    public IBattleAudienceApplyBattleMessageFlexImpl(am3.g r6) {
        super(q0.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L16;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 5000) goto L7;
        this._$$anchorOpenId = am3.h.c(r6);
        goto L3
    L7:
        switch(r2) {
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            default: goto L8;
        };
    L9:
        this._$$title = am3.h.c(r6);
        goto L3
    L10:
        this._$$subDesc = am3.h.c(r6);
        goto L3
    L11:
        this._$$desc = am3.h.c(r6);
        goto L3
    L12:
        this.user = vh7.f.a(r6, IBaseUser.class);
        goto L3
    L13:
        this._$$roomId = am3.h.c(r6);
        goto L3
    L14:
        this._$$anchorId = am3.h.c(r6);
        goto L3
    L8:
        am3.h.d(r3, r6);
        goto L3
    L16:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.link.model.q0
    public final String getAnchorId() {
        return this._$$anchorId;
    }

    @Override // com.bytedance.android.livesdk.link.model.q0
    public final String getAnchorOpenId() {
        return this._$$anchorOpenId;
    }

    @Override // com.bytedance.android.livesdk.link.model.q0
    public final String getDesc() {
        return this._$$desc;
    }

    @Override // com.bytedance.android.livesdk.link.model.q0
    public final String getRoomId() {
        return this._$$roomId;
    }

    @Override // com.bytedance.android.livesdk.link.model.q0
    public final String getSubDesc() {
        return this._$$subDesc;
    }

    @Override // com.bytedance.android.livesdk.link.model.q0
    public final String getTitle() {
        return this._$$title;
    }

    @Override // com.bytedance.android.livesdk.link.model.q0
    public IBaseUser getUser() {
        return this.user;
    }

    public void setUser(IBaseUser r1) {
        this.user = r1;
    }
}
