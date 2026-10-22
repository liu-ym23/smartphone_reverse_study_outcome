package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.im.LinkMicArmies.UserArmies.UserArmy")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R+\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR+\u0010\u0015\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\u0014R/\u0010\u001c\u001a\u0004\u0018\u00010\u00162\b\u0010\n\u001a\u0004\u0018\u00010\u00168V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkMicArmiesMessage_IUserArmies_IUserArmyFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/w4$b$b;", "", "userId$delegate", "Ljava/lang/Object;", "getUserId", "()Ljava/lang/String;", "userId", "", "<set-?>", "score$delegate", "getScore", "()J", "setScore", "(J)V", "score", "nickname$delegate", "getNickname", "setNickname", "(Ljava/lang/String;)V", "nickname", "Lpy/k;", "avatar$delegate", "getAvatar", "()Lpy/k;", "setAvatar", "(Lpy/k;)V", "avatar", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkMicArmiesMessage_IUserArmies_IUserArmyFlexImpl extends FlexModelBase<w4.b.InterfaceC0057b> implements w4.b.InterfaceC0057b, vh7.h {

    @SerializedName("avatar_thumb")
    protected py.k _$$avatar;

    @SerializedName("nickname")
    protected String _$$nickname;

    @SerializedName("score")
    protected long _$$score;

    @SerializedName("open_id")
    protected String _$$userId;

    public ILinkMicArmiesMessage_IUserArmies_IUserArmyFlexImpl() {
        super(w4.b.InterfaceC0057b.class);
        this._$$nickname = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.w4.b.InterfaceC0057b
    public final py.k getAvatar() {
        return this._$$avatar;
    }

    @Override // com.bytedance.android.livesdk.link.model.w4.b.InterfaceC0057b
    public final String getNickname() {
        return this._$$nickname;
    }

    @Override // com.bytedance.android.livesdk.link.model.w4.b.InterfaceC0057b
    public final long getScore() {
        return this._$$score;
    }

    @Override // com.bytedance.android.livesdk.link.model.w4.b.InterfaceC0057b
    public final String getUserId() {
        return this._$$userId;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
    public ILinkMicArmiesMessage_IUserArmies_IUserArmyFlexImpl(am3.g r6) {
        super(w4.b.InterfaceC0057b.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L18;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 2) goto L8;
        this._$$score = r6.j();
        goto L3
    L8:
        if (r2 != 3) goto L10;
        this._$$nickname = am3.h.c(r6);
        goto L3
    L10:
        if (r2 != 4) goto L12;
        this._$$avatar = vh7.f.a(r6, py.k.class);
        goto L3
    L12:
        if (r2 != 5000) goto L13;
        this._$$userId = am3.h.c(r6);
        goto L3
    L13:
        am3.h.d(r3, r6);
        goto L3
    L18:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$nickname != null) goto L37;
        this._$$nickname = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.w4.b.InterfaceC0057b
    public final void setAvatar(py.k r1) {
        this._$$avatar = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.w4.b.InterfaceC0057b
    public final void setNickname(String r1) {
        this._$$nickname = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.w4.b.InterfaceC0057b
    public final void setScore(long r1) {
        this._$$score = r1;
    }
}
