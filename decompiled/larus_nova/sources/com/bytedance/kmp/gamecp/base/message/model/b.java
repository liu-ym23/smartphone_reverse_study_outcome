package com.bytedance.kmp.gamecp.base.message.model;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import vh7.e;

/* JADX INFO: loaded from: classes19.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0013\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R*\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00058&X§\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\u0011\u001a\u00020\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0018\u001a\u0004\u0018\u00010\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\t\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001c\u001a\u00020\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\t\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR$\u0010 \u001a\u0004\u0018\u00010\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001f\u0010\t\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R\"\u0010$\u001a\u00020\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b#\u0010\t\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u000fR$\u0010+\u001a\u0004\u0018\u00010%8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b*\u0010\t\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R&\u00103\u001a\u00060,j\u0002`-8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b2\u0010\t\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R&\u00107\u001a\u00060,j\u0002`-8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b6\u0010\t\u001a\u0004\b4\u0010/\"\u0004\b5\u00101R$\u0010;\u001a\u0004\u0018\u00010\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b:\u0010\t\u001a\u0004\b8\u0010\u0014\"\u0004\b9\u0010\u0016R\"\u0010?\u001a\u00020\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b>\u0010\t\u001a\u0004\b<\u0010\r\"\u0004\b=\u0010\u000f¨\u0006@"}, d2 = {"Lcom/bytedance/kmp/gamecp/base/message/model/b;", "Lvh7/c;", "Lyh6/c;", "", "Lcom/bytedance/kmp/gamecp/base/message/model/c;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getMemberList", "()Ljava/util/List;", "getMemberList$annotations", "()V", "memberList", "", "getTeamSize", "()I", "setTeamSize", "(I)V", "getTeamSize$annotations", "teamSize", "", "getPlayId", "()Ljava/lang/String;", "setPlayId", "(Ljava/lang/String;)V", "getPlayId$annotations", "playId", "getStatus", "setStatus", "getStatus$annotations", "status", "getToast", "setToast", "getToast$annotations", "toast", "getTeamMemberNum", "setTeamMemberNum", "getTeamMemberNum$annotations", "teamMemberNum", "Lcom/bytedance/kmp/gamecp/base/message/model/d;", "getPopup", "()Lcom/bytedance/kmp/gamecp/base/message/model/d;", "setPopup", "(Lcom/bytedance/kmp/gamecp/base/message/model/d;)V", "getPopup$annotations", "popup", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getAnchorId", "()J", "setAnchorId", "(J)V", "getAnchorId$annotations", "anchorId", "getRoomIdLong", "setRoomIdLong", "getRoomIdLong$annotations", "roomIdLong", "getPromoteGameId", "setPromoteGameId", "getPromoteGameId$annotations", "promoteGameId", "getTeamJoinMode", "setTeamJoinMode", "getTeamJoinMode$annotations", "teamJoinMode", "kmp-gamecp-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface b extends vh7.c<b>, yh6.c {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "anchor_id")
    long getAnchorId();

    @Override // yh6.c
    /* synthetic */ m0 getCommonData();

    @FieldName(name = "members")
    List<c> getMemberList();

    @FieldName(name = InstantPlayContext.PLAY_ID)
    String getPlayId();

    @FieldName(name = "popup")
    d getPopup();

    @FieldName(name = "promote_game_id")
    String getPromoteGameId();

    @FieldName(name = "room_id")
    long getRoomIdLong();

    @FieldName(name = "status")
    int getStatus();

    @FieldName(name = "team_join_mode")
    int getTeamJoinMode();

    @FieldName(name = "team_members_num")
    int getTeamMemberNum();

    @FieldName(name = "team_size")
    int getTeamSize();

    @FieldName(name = "toast")
    String getToast();

    @FieldName(name = "anchor_id#setter")
    void setAnchorId(long r100);

    /* synthetic */ void setCommonData(m0 r100);

    @FieldName(name = "play_id#setter")
    void setPlayId(String r100);

    @FieldName(name = "popup#setter")
    void setPopup(d r100);

    @FieldName(name = "promote_game_id#setter")
    void setPromoteGameId(String r100);

    @FieldName(name = "room_id#setter")
    void setRoomIdLong(long r100);

    @FieldName(name = "status#setter")
    void setStatus(int r100);

    @FieldName(name = "team_join_mode#setter")
    void setTeamJoinMode(int r100);

    @FieldName(name = "team_members_num#setter")
    void setTeamMemberNum(int r100);

    @FieldName(name = "team_size#setter")
    void setTeamSize(int r100);

    @FieldName(name = "toast#setter")
    void setToast(String r100);
}
