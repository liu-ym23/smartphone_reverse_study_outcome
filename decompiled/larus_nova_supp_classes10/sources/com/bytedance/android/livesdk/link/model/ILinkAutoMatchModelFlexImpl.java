package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.api.battle.BattleAutoMatchResult.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bD\u0010ER$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00118VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R7\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR;\u0010$\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u00172\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u00178V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b!\u0010\u0013\u001a\u0004\b\"\u0010\u001c\"\u0004\b#\u0010\u001eR\u001b\u0010)\u001a\u00020%8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0013\u001a\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020*8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0013\u001a\u0004\b,\u0010-R\u001b\u00101\u001a\u00020\u00118VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0013\u001a\u0004\b0\u0010\u0015R\u001b\u00104\u001a\u00020%8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u0013\u001a\u0004\b3\u0010(R\u001b\u00107\u001a\u00020*8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u0013\u001a\u0004\b6\u0010-R\u001b\u0010:\u001a\u00020%8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u0013\u001a\u0004\b9\u0010(R+\u0010?\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00118V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b;\u0010\u0013\u001a\u0004\b<\u0010\u0015\"\u0004\b=\u0010>R+\u0010C\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00118V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b@\u0010\u0013\u001a\u0004\bA\u0010\u0015\"\u0004\bB\u0010>¨\u0006F"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkAutoMatchModelFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/r4;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "rivalRoom", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getRivalRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "setRivalRoom", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;)V", "Lpy/k;", "defaultAvatar", "Lpy/k;", "getDefaultAvatar", "()Lpy/k;", "setDefaultAvatar", "(Lpy/k;)V", "", "rivalUserId$delegate", "Ljava/lang/Object;", "getRivalUserId", "()Ljava/lang/String;", "rivalUserId", "", "Lcom/bytedance/android/livesdk/link/model/h0;", "<set-?>", "previewUserList$delegate", "getPreviewUserList", "()Ljava/util/List;", "setPreviewUserList", "(Ljava/util/List;)V", "previewUserList", "Lcom/bytedance/android/livesdk/link/model/r4$b;", "rivals$delegate", "getRivals", "setRivals", "rivals", "", "matchStrategy$delegate", "getMatchStrategy", "()J", "matchStrategy", "", "showNewTips$delegate", "getShowNewTips", "()Z", "showNewTips", "defaultContent$delegate", "getDefaultContent", "defaultContent", "expectTime$delegate", "getExpectTime", "expectTime", "canHighWay$delegate", "getCanHighWay", "canHighWay", "maxWaitTime$delegate", "getMaxWaitTime", "maxWaitTime", "signExtra$delegate", "getSignExtra", "setSignExtra", "(Ljava/lang/String;)V", "signExtra", "battleAttachedInfo$delegate", "getBattleAttachedInfo", "setBattleAttachedInfo", "battleAttachedInfo", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkAutoMatchModelFlexImpl extends FlexModelBase<r4> implements r4, vh7.h {

    @SerializedName("battle_attached_info")
    protected String _$$battleAttachedInfo;

    @SerializedName("can_high_way")
    protected boolean _$$canHighWay;

    @SerializedName("default_content")
    protected String _$$defaultContent;

    @SerializedName("expect_time")
    protected long _$$expectTime;

    @SerializedName("effect_match_path")
    protected long _$$matchStrategy;

    @SerializedName("max_wait_time")
    protected long _$$maxWaitTime;

    @SerializedName("preview_user_list")
    protected List<? extends h0> _$$previewUserList;

    @SerializedName("rival_open_id")
    protected String _$$rivalUserId;

    @SerializedName("rivals")
    protected List<? extends r4.b> _$$rivals;

    @SerializedName("show_tips")
    protected boolean _$$showNewTips;

    @SerializedName("sign_extra")
    protected String _$$signExtra;

    @SerializedName("default_avatar")
    protected py.k defaultAvatar;

    @SerializedName("rival_room")
    protected IRoom rivalRoom;

    public ILinkAutoMatchModelFlexImpl() {
        super(r4.class);
        this._$$previewUserList = $defaultValue_previewUserList$();
        this._$$showNewTips = false;
        this._$$defaultContent = "";
        this._$$canHighWay = false;
        this._$$signExtra = "";
        this._$$battleAttachedInfo = "";
    }

    public final List<h0> $defaultValue_previewUserList$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.livesdk.link.model.r4, af2.e
    public final String getBattleAttachedInfo() {
        return this._$$battleAttachedInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.r4
    public final boolean getCanHighWay() {
        return this._$$canHighWay;
    }

    @Override // com.bytedance.android.livesdk.link.model.r4
    public py.k getDefaultAvatar() {
        return this.defaultAvatar;
    }

    @Override // com.bytedance.android.livesdk.link.model.r4
    public final String getDefaultContent() {
        return this._$$defaultContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.r4, af2.e
    public final long getExpectTime() {
        return this._$$expectTime;
    }

    @Override // com.bytedance.android.livesdk.link.model.r4
    public final long getMatchStrategy() {
        return this._$$matchStrategy;
    }

    @Override // com.bytedance.android.livesdk.link.model.r4
    public final long getMaxWaitTime() {
        return this._$$maxWaitTime;
    }

    @Override // com.bytedance.android.livesdk.link.model.r4
    public final List<h0> getPreviewUserList() {
        return this._$$previewUserList;
    }

    @Override // com.bytedance.android.livesdk.link.model.r4, af2.e
    public IRoom getRivalRoom() {
        return this.rivalRoom;
    }

    @Override // com.bytedance.android.livesdk.link.model.r4
    public final String getRivalUserId() {
        return this._$$rivalUserId;
    }

    @Override // com.bytedance.android.livesdk.link.model.r4
    public final List<r4.b> getRivals() {
        return this._$$rivals;
    }

    @Override // com.bytedance.android.livesdk.link.model.r4
    public final boolean getShowNewTips() {
        return this._$$showNewTips;
    }

    @Override // com.bytedance.android.livesdk.link.model.r4
    public final String getSignExtra() {
        return this._$$signExtra;
    }

    /* JADX WARN: Type inference failed for: r4v13, types: [com.bytedance.android.livesdkapi.depend.model.live.IRoom, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v15, types: [java.lang.Object, py.k] */
    public ILinkAutoMatchModelFlexImpl(am3.g r8) {
        super(r4.class);
        this._$$previewUserList = new ArrayList();
        this._$$rivals = new ArrayList();
        setThreadSafe(false);
        long r1 = r8.c();
        int r3 = 0;
    L3:
        int r4 = r8.f();
        if (r4 == (-1)) goto L39;
        am3.g.a r5 = decodeExtensionFields(r4, r8);
        if (r4 != 1) goto L8;
        this._$$defaultContent = am3.h.c(r8);
        goto L3
    L8:
        if (r4 != 2) goto L10;
        this.defaultAvatar = vh7.f.a(r8, py.k.class);
        goto L3
    L10:
        if (r4 != 4) goto L12;
        this.rivalRoom = vh7.f.a(r8, IRoom.class);
        goto L3
    L12:
        if (r4 == 5) goto L34;
        if (r4 != 6) goto L16;
        this._$$expectTime = r8.j();
        r3 = r3 | 4;
        goto L3
    L16:
        if (r4 != 19) goto L18;
        this._$$battleAttachedInfo = am3.h.c(r8);
        goto L3
    L18:
        if (r4 != 5000) goto L20;
        this._$$rivalUserId = am3.h.c(r8);
        goto L3
    L20:
        if (r4 != 21) goto L22;
        this._$$matchStrategy = r8.j();
        r3 = r3 | 1;
        goto L3
    L22:
        if (r4 != 22) goto L23;
        this._$$showNewTips = am3.h.a(r8);
        r3 = r3 | 2;
        goto L3
    L23:
        switch(r4) {
            case 8: goto L28;
            case 9: goto L27;
            case 10: goto L26;
            case 11: goto L25;
            default: goto L24;
        };
    L25:
        List r6 = this._$$rivals;
        Class r7 = r4.b.class;
    L35:
        r6.add(vh7.f.a(r8, r7));
        goto L3
    L26:
        this._$$signExtra = am3.h.c(r8);
        goto L3
    L27:
        this._$$maxWaitTime = r8.j();
        r3 = r3 | 16;
        goto L3
    L28:
        this._$$canHighWay = am3.h.a(r8);
        r3 = r3 | 8;
        goto L3
    L24:
        am3.h.d(r5, r8);
        goto L3
    L34:
        r6 = this._$$previewUserList;
        r7 = h0.class;
        goto L35
    L39:
        r8.d(r1);
        setThreadSafe(true);
        if (this._$$previewUserList.isEmpty() == false) goto L43;
        this._$$previewUserList = $defaultValue_previewUserList$();
    L43:
        if ((r3 & 2) != 0) goto L46;
        this._$$showNewTips = false;
    L46:
        if (this._$$defaultContent != null) goto L49;
        this._$$defaultContent = "";
    L49:
        if ((r3 & 8) != 0) goto L52;
        this._$$canHighWay = false;
    L52:
        if (this._$$signExtra != null) goto L55;
        this._$$signExtra = "";
    L55:
        if (this._$$battleAttachedInfo != null) goto L95;
        this._$$battleAttachedInfo = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.r4
    public final void setBattleAttachedInfo(String r1) {
        this._$$battleAttachedInfo = r1;
    }

    public void setDefaultAvatar(py.k r1) {
        this.defaultAvatar = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.r4
    public final void setPreviewUserList(List<? extends h0> r1) {
        this._$$previewUserList = r1;
    }

    public void setRivalRoom(IRoom r1) {
        this.rivalRoom = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.r4
    public final void setRivals(List<? extends r4.b> r1) {
        this._$$rivals = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.r4
    public final void setSignExtra(String r1) {
        this._$$signExtra = r1;
    }
}
