package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.data.BattleArmy.RankUser")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\nR/\u0010\u001d\u001a\u0004\u0018\u00010\u00172\b\u0010\u0004\u001a\u0004\u0018\u00010\u00178V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IMvpListInfo_IMvpExtraFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/h7$b;", "", "<set-?>", "userId$delegate", "Ljava/lang/Object;", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "userId", "", "score$delegate", "getScore", "()J", "setScore", "(J)V", "score", "nickname$delegate", "getNickname", "setNickname", "nickname", "Lpy/k;", "avatar$delegate", "getAvatar", "()Lpy/k;", "setAvatar", "(Lpy/k;)V", "avatar", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IMvpListInfo_IMvpExtraFlexImpl extends FlexModelBase<h7.b> implements h7.b, vh7.h {

    @SerializedName("avatar_thumb")
    protected py.k _$$avatar;

    @SerializedName("nickname")
    protected String _$$nickname;

    @SerializedName("score")
    protected long _$$score;

    @SerializedName("open_id")
    protected String _$$userId;

    public IMvpListInfo_IMvpExtraFlexImpl() {
        super(h7.b.class);
        this._$$nickname = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.h7.b
    public final py.k getAvatar() {
        return this._$$avatar;
    }

    @Override // com.bytedance.android.livesdk.link.model.h7.b
    public final String getNickname() {
        return this._$$nickname;
    }

    @Override // com.bytedance.android.livesdk.link.model.h7.b
    public final long getScore() {
        return this._$$score;
    }

    @Override // com.bytedance.android.livesdk.link.model.h7.b
    public final String getUserId() {
        return this._$$userId;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    public IMvpListInfo_IMvpExtraFlexImpl(am3.g r6) {
        super(h7.b.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L18;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 2) goto L8;
        this._$$nickname = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 3) goto L10;
        this._$$avatar = vh7.f.a(r6, py.k.class);
        goto L3
    L10:
        if (r2 != 4) goto L12;
        this._$$score = r6.j();
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

    @Override // com.bytedance.android.livesdk.link.model.h7.b
    public final void setAvatar(py.k r1) {
        this._$$avatar = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.h7.b
    public final void setNickname(String r1) {
        this._$$nickname = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.h7.b
    public final void setScore(long r1) {
        this._$$score = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.h7.b
    public final void setUserId(String r1) {
        this._$$userId = r1;
    }
}
