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
@ProtoMessage("webcast.api.battle.RivalsSearchResponse.AnchorInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bV\u0010WR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u001b\u0010\u0017\u001a\u00020\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001a\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0019\u0010\u000eR\u001b\u0010\u001d\u001a\u00020\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u001c\u0010\u0016R\u001b\u0010 \u001a\u00020\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u001f\u0010\u0016R\u001b\u0010#\u001a\u00020\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\f\u001a\u0004\b\"\u0010\u0016R\u001b\u0010&\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\f\u001a\u0004\b%\u0010\u000eR\u001b\u0010)\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\f\u001a\u0004\b(\u0010\u000eR\u001b\u0010,\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\f\u001a\u0004\b+\u0010\u000eR#\u00102\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010-8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\f\u001a\u0004\b0\u00101R\u001b\u00107\u001a\u0002038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\f\u001a\u0004\b5\u00106R\u001d\u0010<\u001a\u0004\u0018\u0001088VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\f\u001a\u0004\b:\u0010;R\u001b\u0010A\u001a\u00020=8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\f\u001a\u0004\b?\u0010@R\u001b\u0010D\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\f\u001a\u0004\bC\u0010\u000eR\u001d\u0010I\u001a\u0004\u0018\u00010E8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bF\u0010\f\u001a\u0004\bG\u0010HR\u001b\u0010L\u001a\u00020\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\f\u001a\u0004\bK\u0010\u0016R\u001b\u0010O\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\f\u001a\u0004\bN\u0010\u000eR\u001b\u0010R\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bP\u0010\f\u001a\u0004\bQ\u0010\u000eR\u001b\u0010U\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bS\u0010\f\u001a\u0004\bT\u0010\u000e¨\u0006X"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IRivalsSearchAnchorInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/x8;", "Lpy/k;", "avatarThumb", "Lpy/k;", "getAvatarThumb", "()Lpy/k;", "setAvatarThumb", "(Lpy/k;)V", "", "userId$delegate", "Ljava/lang/Object;", "getUserId", "()Ljava/lang/String;", "userId", "secUid$delegate", "getSecUid", "secUid", "", "roomId$delegate", "getRoomId", "()J", "roomId", "nickName$delegate", "getNickName", "nickName", "shortId$delegate", "getShortId", "shortId", "fansNum$delegate", "getFansNum", "fansNum", "linkStatus$delegate", "getLinkStatus", "linkStatus", "statusReason$delegate", "getStatusReason", "statusReason", "customVerify$delegate", "getCustomVerify", "customVerify", "displayId$delegate", "getDisplayId", "displayId", "", "Lcom/bytedance/android/livesdk/link/model/IBattleRivalTagFlexImpl;", "tags$delegate", "getTags", "()Ljava/util/List;", "tags", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room$delegate", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "Lcom/bytedance/android/livesdk/link/model/IBattleActivityUserFlexImpl;", "activityUser$delegate", "getActivityUser", "()Lcom/bytedance/android/livesdk/link/model/IBattleActivityUserFlexImpl;", "activityUser", "", "followType$delegate", "getFollowType", "()I", "followType", "signExtra$delegate", "getSignExtra", "signExtra", "Lcom/bytedance/android/livesdk/link/model/IRivalExtraInfoFlexImpl;", "rivalExtraInfo$delegate", "getRivalExtraInfo", "()Lcom/bytedance/android/livesdk/link/model/IRivalExtraInfoFlexImpl;", "rivalExtraInfo", "gender$delegate", "getGender", "gender", "linkText$delegate", "getLinkText", "linkText", "battleAttachedInfo$delegate", "getBattleAttachedInfo", "battleAttachedInfo", "roomStatusDesc$delegate", "getRoomStatusDesc", "roomStatusDesc", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IRivalsSearchAnchorInfoFlexImpl extends FlexModelBase<x8> implements x8, vh7.h {

    @SerializedName("activity_user")
    protected IBattleActivityUserFlexImpl _$$activityUser;

    @SerializedName("battle_attached_info")
    protected String _$$battleAttachedInfo;

    @SerializedName("custom_verify")
    protected String _$$customVerify;

    @SerializedName("display_id")
    protected String _$$displayId;

    @SerializedName("fans_num")
    protected long _$$fansNum;

    @SerializedName("follow_type")
    protected int _$$followType;

    @SerializedName("gender")
    protected long _$$gender;

    @SerializedName("link_status")
    protected long _$$linkStatus;

    @SerializedName("link_text")
    protected String _$$linkText;

    @SerializedName("nick_name")
    protected String _$$nickName;

    @SerializedName("extra_info")
    protected IRivalExtraInfoFlexImpl _$$rivalExtraInfo;

    @SerializedName("room")
    protected IRoom _$$room;

    @SerializedName("room_id")
    protected long _$$roomId;

    @SerializedName("room_status_desc")
    protected String _$$roomStatusDesc;

    @SerializedName("sec_user_id")
    protected String _$$secUid;

    @SerializedName("short_id")
    protected long _$$shortId;

    @SerializedName("sign_extra")
    protected String _$$signExtra;

    @SerializedName("status_reason")
    protected String _$$statusReason;

    @SerializedName("tags")
    protected List<IBattleRivalTagFlexImpl> _$$tags;

    @SerializedName("open_id")
    protected String _$$userId;

    @SerializedName("avatar_thumb")
    protected py.k avatarThumb;

    public IRivalsSearchAnchorInfoFlexImpl() {
        super(x8.class);
        this._$$userId = "";
        this._$$nickName = "";
        this._$$statusReason = "";
        this._$$customVerify = "";
        this._$$displayId = "";
        this._$$room = $defaultValue_room$();
        this._$$signExtra = "";
        this._$$linkText = "";
        this._$$battleAttachedInfo = "";
        this._$$roomStatusDesc = "";
    }

    public final IRoom $defaultValue_room$() {
        return vh7.f.c(IRoom.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.x8
    public /* bridge */ /* synthetic */ n0 getActivityUser() {
        return getActivityUser();
    }

    @Override // com.bytedance.android.livesdk.link.model.x8
    public /* bridge */ /* synthetic */ IRivalExtraInfo getRivalExtraInfo() {
        return getRivalExtraInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.x8
    public py.k getAvatarThumb() {
        return this.avatarThumb;
    }

    @Override // com.bytedance.android.livesdk.link.model.x8
    public final String getBattleAttachedInfo() {
        return this._$$battleAttachedInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.x8
    public final String getCustomVerify() {
        return this._$$customVerify;
    }

    @Override // com.bytedance.android.livesdk.link.model.x8
    public final String getDisplayId() {
        return this._$$displayId;
    }

    @Override // com.bytedance.android.livesdk.link.model.x8
    public final long getFansNum() {
        return this._$$fansNum;
    }

    @Override // com.bytedance.android.livesdk.link.model.x8
    public final int getFollowType() {
        return this._$$followType;
    }

    @Override // com.bytedance.android.livesdk.link.model.x8
    public final long getGender() {
        return this._$$gender;
    }

    @Override // com.bytedance.android.livesdk.link.model.x8
    public final long getLinkStatus() {
        return this._$$linkStatus;
    }

    @Override // com.bytedance.android.livesdk.link.model.x8
    public final String getLinkText() {
        return this._$$linkText;
    }

    @Override // com.bytedance.android.livesdk.link.model.x8
    public final String getNickName() {
        return this._$$nickName;
    }

    @Override // com.bytedance.android.livesdk.link.model.x8
    public final IRoom getRoom() {
        return this._$$room;
    }

    @Override // com.bytedance.android.livesdk.link.model.x8
    public final long getRoomId() {
        return this._$$roomId;
    }

    @Override // com.bytedance.android.livesdk.link.model.x8
    public final String getRoomStatusDesc() {
        return this._$$roomStatusDesc;
    }

    @Override // com.bytedance.android.livesdk.link.model.x8
    public final String getSecUid() {
        return this._$$secUid;
    }

    @Override // com.bytedance.android.livesdk.link.model.x8
    public final long getShortId() {
        return this._$$shortId;
    }

    @Override // com.bytedance.android.livesdk.link.model.x8
    public final String getSignExtra() {
        return this._$$signExtra;
    }

    @Override // com.bytedance.android.livesdk.link.model.x8
    public final String getStatusReason() {
        return this._$$statusReason;
    }

    @Override // com.bytedance.android.livesdk.link.model.x8
    public final List<IBattleRivalTagFlexImpl> getTags() {
        return this._$$tags;
    }

    @Override // com.bytedance.android.livesdk.link.model.x8
    public final String getUserId() {
        return this._$$userId;
    }

    @Override // com.bytedance.android.livesdk.link.model.x8
    public final IBattleActivityUserFlexImpl getActivityUser() {
        return this._$$activityUser;
    }

    @Override // com.bytedance.android.livesdk.link.model.x8
    public final IRivalExtraInfoFlexImpl getRivalExtraInfo() {
        return this._$$rivalExtraInfo;
    }

    /* JADX WARN: Type inference failed for: r2v13, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.livesdkapi.depend.model.live.IRoom, java.lang.Object] */
    public IRivalsSearchAnchorInfoFlexImpl(am3.g r6) {
        super(x8.class);
        this._$$tags = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L35;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 23) goto L8;
        this._$$battleAttachedInfo = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 24) goto L10;
        this._$$roomStatusDesc = am3.h.c(r6);
        goto L3
    L10:
        if (r2 != 5000) goto L11;
        this._$$userId = am3.h.c(r6);
        goto L3
    L11:
        switch(r2) {
            case 2: goto L31;
            case 3: goto L30;
            case 4: goto L29;
            case 5: goto L28;
            case 6: goto L27;
            case 7: goto L26;
            case 8: goto L25;
            case 9: goto L24;
            case 10: goto L23;
            case 11: goto L22;
            default: goto L12;
        };
    L22:
        this._$$tags.add(new IBattleRivalTagFlexImpl(r6));
        goto L3
    L23:
        this._$$displayId = am3.h.c(r6);
        goto L3
    L24:
        this._$$linkStatus = r6.j();
        goto L3
    L25:
        this._$$customVerify = am3.h.c(r6);
        goto L3
    L26:
        this._$$fansNum = r6.j();
        goto L3
    L27:
        this._$$shortId = r6.j();
        goto L3
    L28:
        this._$$nickName = am3.h.c(r6);
        goto L3
    L29:
        this.avatarThumb = vh7.f.a(r6, py.k.class);
        goto L3
    L30:
        this._$$roomId = r6.j();
        goto L3
    L31:
        this._$$secUid = am3.h.c(r6);
        goto L3
    L12:
        switch(r2) {
            case 14: goto L21;
            case 15: goto L20;
            case 16: goto L19;
            case 17: goto L18;
            case 18: goto L17;
            case 19: goto L16;
            case 20: goto L15;
            case 21: goto L14;
            default: goto L13;
        };
    L14:
        this._$$statusReason = am3.h.c(r6);
        goto L3
    L15:
        this._$$gender = r6.j();
        goto L3
    L16:
        this._$$linkText = am3.h.c(r6);
        goto L3
    L17:
        this._$$rivalExtraInfo = new IRivalExtraInfoFlexImpl(r6);
        goto L3
    L18:
        this._$$followType = r6.i();
        goto L3
    L19:
        this._$$signExtra = am3.h.c(r6);
        goto L3
    L20:
        this._$$activityUser = new IBattleActivityUserFlexImpl(r6);
        goto L3
    L21:
        this._$$room = vh7.f.a(r6, IRoom.class);
        goto L3
    L13:
        am3.h.d(r3, r6);
        goto L3
    L35:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$userId != null) goto L39;
        this._$$userId = "";
    L39:
        if (this._$$nickName != null) goto L42;
        this._$$nickName = "";
    L42:
        if (this._$$statusReason != null) goto L45;
        this._$$statusReason = "";
    L45:
        if (this._$$customVerify != null) goto L48;
        this._$$customVerify = "";
    L48:
        if (this._$$displayId != null) goto L51;
        this._$$displayId = "";
    L51:
        if (this._$$room != null) goto L54;
        this._$$room = $defaultValue_room$();
    L54:
        if (this._$$signExtra != null) goto L57;
        this._$$signExtra = "";
    L57:
        if (this._$$linkText != null) goto L60;
        this._$$linkText = "";
    L60:
        if (this._$$battleAttachedInfo != null) goto L63;
        this._$$battleAttachedInfo = "";
    L63:
        if (this._$$roomStatusDesc != null) goto L116;
        this._$$roomStatusDesc = "";
        return;
    }

    public void setAvatarThumb(py.k r1) {
        this.avatarThumb = r1;
    }
}
