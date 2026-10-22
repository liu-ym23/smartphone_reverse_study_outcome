package com.ss.android.lark.flow.chat.message.block.sharegroup;

import android.content.Context;
import android.widget.TextView;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.ShareGroupChatContent;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.statistics.chat.ChatHitPointNew;
import java.util.Map;

/* JADX INFO: loaded from: classes36.dex */
public final class e {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f422461a = null;

        static {
            int[] r100 = new int[ShareGroupChatContent.GroupState.values().length];
            f422461a = r100;
            r100[ShareGroupChatContent.GroupState.ALREADY_IN_GROUP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L28:
            f422461a[ShareGroupChatContent.GroupState.NEED_APPLY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L34:
            f422461a[ShareGroupChatContent.GroupState.SHARE_EXPIRED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L46:
            f422461a[ShareGroupChatContent.GroupState.PENDING_APPROVAL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L30:
            f422461a[ShareGroupChatContent.GroupState.INVITER_LEFT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L36:
            f422461a[ShareGroupChatContent.GroupState.GROUP_DISBANDED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L40:
            f422461a[ShareGroupChatContent.GroupState.SHARING_DISABLED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L42:
            f422461a[ShareGroupChatContent.GroupState.NO_EXTERNAL_COMMUNICATION_AUTHORITY.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L26:
            f422461a[ShareGroupChatContent.GroupState.GROUP_IS_FULL.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L32:
            f422461a[ShareGroupChatContent.GroupState.EXTERNAL_USERS_CANNOT_OPERATE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L38:
            f422461a[ShareGroupChatContent.GroupState.SHARE_CARD_CERTIFIED_REFUSE.ordinal()] = 11;     // Catch: NoSuchFieldError -> L25
            return;
        }
    }

    public static void b(ShareGroupChatContent.GroupState r110, TextView r111, TextView r112) {
        if (r111 != null) goto L4;
        return;
    L4:
        Context r100 = r111.getContext();
        int r113 = a.f422461a[r110.ordinal()];
        int r101 = R.color.line_border_component;
        boolean r102 = true;
        int r103 = R.color.ud_button_blue_text;
        int r104 = R.string.Lark_Group_ApplyToEnter;
        int r105 = R.string.Lark_Groups_GroupCard;
        switch(r113) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            case 11: goto L7;
            default: goto L6;
        };
    L6:
        int r114 = R.color.flow_ud_primary_50;
        int r106 = R.color.flow_ud_static_white;
        boolean r107 = true;
        boolean r108 = true;
        int r109 = R.color.ud_button_blue_stroke;
        int r115 = R.color.ud_button_blue_text;
        int r116 = R.string.Lark_Legacy_JoinGroupChat;
        int r117 = R.string.Lark_Groups_GroupCard;
    L22:
        if (r112 == null) goto L24;
        r112.setText(r117);
    L24:
        if (r102 == false) goto L34;
        if (r115 == 0) goto L34;
        r111.setVisibility(0);
        r111.setText(r116);
        r111.setEnabled(r107);
        if (r108 == false) goto L31;
        r111.setTextColor(UDColorUtils.getColor(r100, r106));
        r111.setBackgroundColor(UDColorUtils.getColor(r100, r114));
        if ((r111 instanceof UDButton) == false) goto L36;
        ((UDButton) r111).setStrokeWidth(0);
        return;
    L36:
        return;
    L31:
        r111.setTextColor(UDColorUtils.getColor(r100, r115));
        r111.setBackgroundColor(0);
        if ((r111 instanceof UDButton) == false) goto L38;
        UDButton r118 = (UDButton) r111;
        r118.setStrokeColor(UDColorUtils.getColor(r100, r109));
        r118.setStrokeWidth(UIUtils.dp2px(r100, 1.0f));
        return;
    L38:
        return;
    L34:
        r111.setVisibility(4);
        return;
    L7:
        int r119 = R.string.Lark_Groups_CantJoinGroup;
    L16:
        r102 = false;
        r104 = 0;
    L17:
        r103 = R.color.text_disable;
        r105 = r119;
        boolean r120 = false;
    L21:
        r107 = r120;
        r116 = r104;
        r117 = r105;
        r114 = 0;
        r109 = r101;
        r115 = r103;
        r106 = 0;
        r108 = false;
        goto L22
    L8:
        r119 = R.string.Lark_Group_ContactAdminButton;
        goto L16
    L9:
        r119 = R.string.Lark_Legacy_GroupMemberOutOfRange;
        goto L16
    L10:
        r119 = R.string.Lark_Group_UnableJoinExternalGroup;
        goto L16
    L11:
        r119 = R.string.Lark_Group_InvitationDisabledButton;
        goto L16
    L12:
        r119 = R.string.Lark_Group_DisbandedButton;
        goto L16
    L13:
        r119 = R.string.Lark_Group_InviterLeftButton;
        goto L16
    L14:
        r119 = R.string.Lark_Group_PendingApprovalButton;
        goto L17
    L15:
        r119 = R.string.Lark_Legacy_EventShareExpired;
        goto L16
    L18:
        r101 = R.color.ud_button_blue_stroke;
    L20:
        r120 = true;
        goto L21
    L19:
        r105 = R.string.Lark_Legacy_EnterGroupChat;
        r104 = R.string.Lark_Legacy_Open;
        r103 = R.color.text_title;
        goto L20
    }

    public static void a(Chat r100, Message r101, boolean r102, String r103) {
        Map r104 = ChatParamUtils.g(r101);
        if (r102 == false) goto L5;
        String r105 = "true";
    L6:
        r104.put("is_toast_remind", r105);
        if (r102 == false) goto L10;
        if (r103 == null) goto L10;
        r104.put("toast_remind", r103);
    L10:
        ChatHitPointNew.f(r100, "group_card_button_share", "none", r104);
        return;
    L5:
        r105 = "false";
        goto L6
    }
}
