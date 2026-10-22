package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.api.battle.ReserveRecord")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b.\u0010/R\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00118VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R7\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001b\u0010\"\u001a\u00020\u00118VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0013\u001a\u0004\b!\u0010\u0015R\u001d\u0010'\u001a\u0004\u0018\u00010#8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0013\u001a\u0004\b%\u0010&R\u001d\u0010*\u001a\u0004\u0018\u00010#8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0013\u001a\u0004\b)\u0010&R\u001b\u0010-\u001a\u00020\u00118VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0013\u001a\u0004\b,\u0010\u0015¨\u00060"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IReserveRecordFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/o8;", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "setRoom", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;)V", "", "reserveId$delegate", "Ljava/lang/Object;", "getReserveId", "()Ljava/lang/String;", "reserveId", "", "Lcom/bytedance/android/livesdk/link/model/IBattleRivalTag;", "<set-?>", "tags$delegate", "getTags", "()Ljava/util/List;", "setTags", "(Ljava/util/List;)V", "tags", "descText$delegate", "getDescText", "descText", "Lcom/bytedance/android/livesdk/link/model/IButtonFlexImpl;", "inviteBtn$delegate", "getInviteBtn", "()Lcom/bytedance/android/livesdk/link/model/IButtonFlexImpl;", "inviteBtn", "replyBtn$delegate", "getReplyBtn", "replyBtn", "battleAttachedInfo$delegate", "getBattleAttachedInfo", "battleAttachedInfo", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IReserveRecordFlexImpl extends FlexModelBase<o8> implements o8, vh7.h {

    @SerializedName("battle_attached_info")
    protected String _$$battleAttachedInfo;

    @SerializedName("desc_text")
    protected String _$$descText;

    @SerializedName("invite_button")
    protected IButtonFlexImpl _$$inviteBtn;

    @SerializedName("reply_button")
    protected IButtonFlexImpl _$$replyBtn;

    @SerializedName("reserve_id")
    protected String _$$reserveId;

    @SerializedName("tags")
    protected List<? extends IBattleRivalTag> _$$tags;

    @SerializedName("room")
    protected IRoom room;

    @SerializedName("user")
    protected IBaseUser user;

    public IReserveRecordFlexImpl() {
        super(o8.class);
        this._$$reserveId = "";
        this.user = (IBaseUser) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(IBaseUser.class);
        this.room = (IRoom) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(IRoom.class);
        this._$$tags = $defaultValue_tags$();
        this._$$descText = "";
        this._$$battleAttachedInfo = "";
    }

    public final List<IBattleRivalTag> $defaultValue_tags$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.livesdk.link.model.o8
    public /* bridge */ /* synthetic */ o3 getInviteBtn() {
        return getInviteBtn();
    }

    @Override // com.bytedance.android.livesdk.link.model.o8
    public /* bridge */ /* synthetic */ o3 getReplyBtn() {
        return getReplyBtn();
    }

    @Override // com.bytedance.android.livesdk.link.model.o8
    public final String getBattleAttachedInfo() {
        return this._$$battleAttachedInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.o8
    public final String getDescText() {
        return this._$$descText;
    }

    @Override // com.bytedance.android.livesdk.link.model.o8
    public final String getReserveId() {
        return this._$$reserveId;
    }

    @Override // com.bytedance.android.livesdk.link.model.o8
    public IRoom getRoom() {
        return this.room;
    }

    @Override // com.bytedance.android.livesdk.link.model.o8
    public final List<IBattleRivalTag> getTags() {
        return this._$$tags;
    }

    @Override // com.bytedance.android.livesdk.link.model.o8
    public IBaseUser getUser() {
        return this.user;
    }

    @Override // com.bytedance.android.livesdk.link.model.o8
    public final IButtonFlexImpl getInviteBtn() {
        return this._$$inviteBtn;
    }

    @Override // com.bytedance.android.livesdk.link.model.o8
    public final IButtonFlexImpl getReplyBtn() {
        return this._$$replyBtn;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.bytedance.android.livesdkapi.depend.model.live.IRoom, java.lang.Object] */
    public IReserveRecordFlexImpl(am3.g r5) {
        super(o8.class);
        this._$$tags = new ArrayList();
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L16;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            default: goto L7;
        };
    L8:
        this._$$battleAttachedInfo = am3.h.c(r5);
        goto L3
    L9:
        this._$$replyBtn = new IButtonFlexImpl(r5);
        goto L3
    L10:
        this._$$inviteBtn = new IButtonFlexImpl(r5);
        goto L3
    L11:
        this._$$descText = am3.h.c(r5);
        goto L3
    L12:
        this._$$tags.add(vh7.f.a(r5, IBattleRivalTag.class));
        goto L3
    L13:
        this.room = vh7.f.a(r5, IRoom.class);
        goto L3
    L14:
        this.user = vh7.f.a(r5, IBaseUser.class);
        goto L3
    L15:
        this._$$reserveId = am3.h.c(r5);
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L16:
        r5.d(r0);
        setThreadSafe(true);
        if (this._$$reserveId != null) goto L20;
        this._$$reserveId = "";
    L20:
        if (this.user != null) goto L23;
        this.user = (IBaseUser) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(IBaseUser.class);
    L23:
        if (this.room != null) goto L26;
        this.room = (IRoom) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(IRoom.class);
    L26:
        if (this._$$tags.isEmpty() == false) goto L29;
        this._$$tags = $defaultValue_tags$();
    L29:
        if (this._$$descText != null) goto L32;
        this._$$descText = "";
    L32:
        if (this._$$battleAttachedInfo != null) goto L55;
        this._$$battleAttachedInfo = "";
        return;
    }

    public void setRoom(IRoom r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.room = r2;
    }

    @Override // com.bytedance.android.livesdk.link.model.o8
    public final void setTags(List<? extends IBattleRivalTag> r1) {
        this._$$tags = r1;
    }

    public void setUser(IBaseUser r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.user = r2;
    }
}
