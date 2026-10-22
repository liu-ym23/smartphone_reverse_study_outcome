package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001\u000eR\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\r\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IListUserLinkmicContent;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/m1;", "", "getRole", "()I", "getRole$annotations", "()V", "role", "", "getFanTicket", "()Ljava/lang/String;", "getFanTicket$annotations", "fanTicket", "IAnchorAuthRole", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IListUserLinkmicContent extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.m1>, com.bytedance.android.livesdk.link.model.bridge.m1 {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IListUserLinkmicContent$IAnchorAuthRole;", "", "AnchorAuthRoleGeneral", "AnchorAuthRoleOrganizer", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum IAnchorAuthRole extends Enum<IAnchorAuthRole> {
        public static final IAnchorAuthRole AnchorAuthRoleGeneral = null;
        public static final IAnchorAuthRole AnchorAuthRoleOrganizer = null;
        public static final /* synthetic */ IAnchorAuthRole[] a = null;

        static {
            IAnchorAuthRole r1 = new IAnchorAuthRole("AnchorAuthRoleGeneral", 0);
            AnchorAuthRoleGeneral = r1;
            IAnchorAuthRole r2 = new IAnchorAuthRole("AnchorAuthRoleOrganizer", 1);
            AnchorAuthRoleOrganizer = r2;
            a = new IAnchorAuthRole[]{r1, r2};
        }

        public static IAnchorAuthRole valueOf(String r1) {
            return (IAnchorAuthRole) r27.a.a(IAnchorAuthRole.class, r1);
        }

        public static IAnchorAuthRole[] values() {
            return (IAnchorAuthRole[]) a.clone();
        }

        public IAnchorAuthRole(String r1, int r2) {
            super(r1, r2);
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.m1
    /* synthetic */ vh7.e castTo(Class r1);

    @Override // com.bytedance.android.livesdk.link.model.bridge.m1
    /* synthetic */ vh7.e castToOrNull(Class r1);

    @Override // com.bytedance.android.livesdk.link.model.bridge.m1
    @FieldName(name = "anchor_auth_role")
    /* synthetic */ int getAnchorAuthRole();

    @Override // com.bytedance.android.livesdk.link.model.bridge.m1
    @FieldName(name = "anchor_linkmic_id_info")
    /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.j getAnchorLinkMicIdInfo();

    @FieldName(name = "fan_ticket")
    String getFanTicket();

    /* synthetic */ Object getFlexInstance();

    @Override // com.bytedance.android.livesdk.link.model.bridge.m1
    @FieldName(name = "game_name")
    /* synthetic */ String getGameName();

    @Override // com.bytedance.android.livesdk.link.model.bridge.m1
    @FieldName(name = "host_back_color")
    /* synthetic */ String getHostLabelBackgroundColor();

    @Override // com.bytedance.android.livesdk.link.model.bridge.m1
    @FieldName(name = "host_name")
    /* synthetic */ String getHostLabelName();

    @Override // com.bytedance.android.livesdk.link.model.bridge.m1
    @FieldName(name = "host_name_color")
    /* synthetic */ String getHostLabelNameColor();

    @Override // com.bytedance.android.livesdk.link.model.bridge.m1
    @FieldName(name = "host_switch")
    /* synthetic */ boolean getHostSwitch();

    @Override // com.bytedance.android.livesdk.link.model.bridge.m1
    @FieldName(name = "live_room_mode")
    /* synthetic */ long getLiveRoomMode();

    @FieldName(name = "pk_user_role")
    int getRole();

    @Override // com.bytedance.android.livesdk.link.model.bridge.m1
    @FieldName(name = "virtual_tool")
    /* synthetic */ String getVirtualTool();
}
