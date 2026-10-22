package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u000b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\t\u0010\u0005R\u001a\u0010\u000e\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0007\u001a\u0004\b\f\u0010\u0005R\u001a\u0010\u0011\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u000f\u0010\u0005R\u001a\u0010\u0014\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0007\u001a\u0004\b\u0012\u0010\u0005R\u001a\u0010\u0019\u001a\u00020\u00158&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0007\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001c\u001a\u00020\u00158&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0007\u001a\u0004\b\u001a\u0010\u0017R\u001e\u0010\"\u001a\u00060\u001dj\u0002`\u001e8&X§\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0007\u001a\u0004\b\u001f\u0010 R\u001a\u0010%\u001a\u00020\u00158&X§\u0004¢\u0006\f\u0012\u0004\b$\u0010\u0007\u001a\u0004\b#\u0010\u0017R\u001a\u0010*\u001a\u00020&8&X§\u0004¢\u0006\f\u0012\u0004\b)\u0010\u0007\u001a\u0004\b'\u0010(R*\u00101\u001a\u0012\u0012\u0004\u0012\u00020,0+j\b\u0012\u0004\u0012\u00020,`-8&X§\u0004¢\u0006\f\u0012\u0004\b0\u0010\u0007\u001a\u0004\b.\u0010/R\u001a\u00104\u001a\u00020\u00158&X§\u0004¢\u0006\f\u0012\u0004\b3\u0010\u0007\u001a\u0004\b2\u0010\u0017R\u001a\u00107\u001a\u00020\u00158&X§\u0004¢\u0006\f\u0012\u0004\b6\u0010\u0007\u001a\u0004\b5\u0010\u0017¨\u00068"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/i2;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/w;", "", "getFromUserId", "()J", "getFromUserId$annotations", "()V", "fromUserId", "getFromRoomId", "getFromRoomId$annotations", "fromRoomId", "getToUserId", "getToUserId$annotations", "toUserId", "getToRoomId", "getToRoomId$annotations", "toRoomId", "getWaitSec", "getWaitSec$annotations", "waitSec", "", "getClientAttachedInfo", "()Ljava/lang/String;", "getClientAttachedInfo$annotations", "clientAttachedInfo", "getReserveId", "getReserveId$annotations", "reserveId", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomKt;", "getInviteRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getInviteRoom$annotations", "inviteRoom", "getTips", "getTips$annotations", "tips", "Lcom/bytedance/android/livesdk/link/model/j2;", "getOption", "()Lcom/bytedance/android/livesdk/link/model/j2;", "getOption$annotations", "option", "", "Lcom/bytedance/android/livesdk/link/model/IBattleRivalTag;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getTags", "()Ljava/util/List;", "getTags$annotations", "tags", "getFromOpenId", "getFromOpenId$annotations", "fromOpenId", "getToOpenId", "getToOpenId$annotations", "toOpenId", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface i2 extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.w>, com.bytedance.android.livesdk.link.model.bridge.w {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "client_attached_info")
    String getClientAttachedInfo();

    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "from_open_id")
    String getFromOpenId();

    @FieldName(name = "from_room_id")
    long getFromRoomId();

    @FieldName(name = "from_user_id")
    long getFromUserId();

    @FieldName(name = "invite_room")
    IRoom getInviteRoom();

    @FieldName(name = "option")
    j2 getOption();

    @FieldName(name = "reserve_id")
    String getReserveId();

    @FieldName(name = "tags")
    List<IBattleRivalTag> getTags();

    @FieldName(name = "tips")
    String getTips();

    @FieldName(name = "to_open_id")
    String getToOpenId();

    @FieldName(name = "to_room_id")
    long getToRoomId();

    @FieldName(name = "to_user_id")
    long getToUserId();

    @FieldName(name = "wait_sec")
    long getWaitSec();

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r1);
}
