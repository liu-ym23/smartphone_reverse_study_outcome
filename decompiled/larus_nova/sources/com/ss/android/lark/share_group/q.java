package com.ss.android.lark.share_group;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.chat.api.service.IChatService;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.ShareGroupChatContent;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.statistics.chat.ChatHitPointNew;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public final class q {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f440567a = null;

        static {
            int[] r100 = new int[ShareGroupChatContent.GroupState.values().length];
            f440567a = r100;
            r100[ShareGroupChatContent.GroupState.ALREADY_IN_GROUP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L28:
            f440567a[ShareGroupChatContent.GroupState.NEED_APPLY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L34:
            f440567a[ShareGroupChatContent.GroupState.SHARE_EXPIRED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L46:
            f440567a[ShareGroupChatContent.GroupState.PENDING_APPROVAL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L30:
            f440567a[ShareGroupChatContent.GroupState.INVITER_LEFT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L36:
            f440567a[ShareGroupChatContent.GroupState.GROUP_DISBANDED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L40:
            f440567a[ShareGroupChatContent.GroupState.SHARING_DISABLED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L42:
            f440567a[ShareGroupChatContent.GroupState.NO_EXTERNAL_COMMUNICATION_AUTHORITY.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L26:
            f440567a[ShareGroupChatContent.GroupState.GROUP_IS_FULL.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L32:
            f440567a[ShareGroupChatContent.GroupState.EXTERNAL_USERS_CANNOT_OPERATE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L38:
            f440567a[ShareGroupChatContent.GroupState.SHARE_CARD_CERTIFIED_REFUSE.ordinal()] = 11;     // Catch: NoSuchFieldError -> L25
            return;
        }
    }

    public static void c(ShareGroupChatContent.GroupState r100, TextView r101, TextView r102) {
        if (r101 != null) goto L4;
        return;
    L4:
        Context r103 = r101.getContext();
        int r104 = a.f440567a[r100.ordinal()];
        int r105 = R.color.text_disable;
        int r106 = R.color.line_border_component;
        boolean r107 = true;
        int r108 = R.string.Lark_Group_ApplyToEnter;
        switch(r104) {
            case 1: goto L17;
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
        r108 = R.string.Lark_Legacy_JoinGroupChat;
        goto L18
    L7:
        int r109 = R.string.Lark_Groups_CantJoinGroup;
    L16:
        r107 = false;
        boolean r110 = false;
        int r111 = 0;
    L19:
        if (r102 == null) goto L21;
        r102.setText(r109);
    L21:
        if (r107 == false) goto L26;
        if (r105 == 0) goto L26;
        r101.setVisibility(0);
        r101.setText(r111);
        r101.setTextColor(UDColorUtils.getColor(r103, r105));
        r101.setEnabled(r110);
        if ((r101 instanceof UDButton) == false) goto L28;
        ((UDButton) r101).setStrokeColor(UDColorUtils.getColor(r103, r106));
        return;
    L28:
        return;
    L26:
        r101.setVisibility(4);
        return;
    L8:
        r109 = R.string.Lark_Group_ContactAdminButton;
        goto L16
    L9:
        r109 = R.string.Lark_Legacy_GroupMemberOutOfRange;
        goto L16
    L10:
        r109 = R.string.Lark_Group_UnableJoinExternalGroup;
        goto L16
    L11:
        r109 = R.string.Lark_Group_InvitationDisabledButton;
        goto L16
    L12:
        r109 = R.string.Lark_Group_DisbandedButton;
        goto L16
    L13:
        r109 = R.string.Lark_Group_InviterLeftButton;
        goto L16
    L14:
        r109 = R.string.Lark_Group_PendingApprovalButton;
        r110 = false;
        r111 = R.string.Lark_Group_ApplyToEnter;
        goto L19
    L15:
        r109 = R.string.Lark_Legacy_EventShareExpired;
        goto L16
    L17:
        r109 = R.string.Lark_Legacy_EnterGroupChat;
        r105 = R.color.text_title;
        r110 = true;
        r111 = R.string.Lark_Legacy_Open;
    L18:
        r106 = R.color.ud_button_blue_stroke;
        r105 = R.color.ud_button_blue_text;
        r109 = R.string.Lark_Groups_GroupCard;
        r111 = r108;
        r110 = true;
        goto L19
    }

    public static void a(final Context r100, IChatService r101, View r102, final Message r103) {
        final Chat r104 = ((ShareGroupChatContent) r103.getContent()).getChat();
        if (r101.checkLoginUserExistedInLocalChat(r104) == false) goto L5;
        r102.setOnClickListener(new l(r104, r100));
        return;
    L5:
        r102.setOnClickListener(new m(r100, r103, r104));
    }

    public static void b(Chat r100, Message r101, boolean r102, String r103) {
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
