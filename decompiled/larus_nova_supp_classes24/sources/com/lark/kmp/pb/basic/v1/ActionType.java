package com.lark.kmp.pb.basic.v1;

import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.o0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b)\b\u0086\u0081\u0002\u0018\u0000 ,2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001,B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+¨\u0006-"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/ActionType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_ACTION", "CREATE_P2P_CHAT", "INVITE_SAME_CHAT", "SEND_URGENT", "SEND_MESSAGE", "MAKE_PHONE_CALL", "CRATE_P2P_CRYPTO_CHAT", "VIEW_PERSONAL_STATUS", "INVITE_SAME_CRYPTO_CHAT", "SHARE_MESSAGE_SELECT_USER", "VOIP_CALL", "CREATE_SINGLE_VIDEOCHAT", "INVITE_VIDEO_CHAT", "SHARE_VIDEO_CHAT", "INVITE_EVENT", "SHARE_EVENT", "TRANSFER_EVENT", "CCM_SEND_MESSAGE", "CCM_BOT_MESSAGE", "CCM_FEED_MESSAGE", "DOC_SHARE_OR_CREATE", "SHARE_NAME_CARD", "CALENDAR_PRIVATE_CHECK", "ADD_CONTACT", "JOIN_CHAT_VIA_SHARE", "INVITE_SAME_CROSS_TENANT_CHAT", "BLOCK", "COOPERATION", "ALLOW_SETTING_AS_PUBLIC_GROUP", "PRIVATE_CHAT", "PRIVATE_P2P_CHAT", "PRIVATE_SEND_PRIVATE_MESSAGE", "CREATE_PRIVATE_CHAT_AND_INVITE", "TASK_ADD_MEMBER", "CHECK_BLOCK", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum ActionType extends Enum<ActionType> implements o0 {
    public static final ProtoAdapter<ActionType> ADAPTER = null;
    public static final ActionType ADD_CONTACT = null;
    public static final ActionType ALLOW_SETTING_AS_PUBLIC_GROUP = null;
    public static final ActionType BLOCK = null;
    public static final ActionType CALENDAR_PRIVATE_CHECK = null;
    public static final ActionType CCM_BOT_MESSAGE = null;
    public static final ActionType CCM_FEED_MESSAGE = null;
    public static final ActionType CCM_SEND_MESSAGE = null;
    public static final ActionType CHECK_BLOCK = null;
    public static final ActionType COOPERATION = null;
    public static final ActionType CRATE_P2P_CRYPTO_CHAT = null;
    public static final ActionType CREATE_P2P_CHAT = null;
    public static final ActionType CREATE_PRIVATE_CHAT_AND_INVITE = null;
    public static final ActionType CREATE_SINGLE_VIDEOCHAT = null;
    public static final b Companion = null;
    public static final ActionType DOC_SHARE_OR_CREATE = null;
    public static final ActionType INVITE_EVENT = null;
    public static final ActionType INVITE_SAME_CHAT = null;
    public static final ActionType INVITE_SAME_CROSS_TENANT_CHAT = null;
    public static final ActionType INVITE_SAME_CRYPTO_CHAT = null;
    public static final ActionType INVITE_VIDEO_CHAT = null;
    public static final ActionType JOIN_CHAT_VIA_SHARE = null;
    public static final ActionType MAKE_PHONE_CALL = null;
    public static final ActionType PRIVATE_CHAT = null;
    public static final ActionType PRIVATE_P2P_CHAT = null;
    public static final ActionType PRIVATE_SEND_PRIVATE_MESSAGE = null;
    public static final ActionType SEND_MESSAGE = null;
    public static final ActionType SEND_URGENT = null;
    public static final ActionType SHARE_EVENT = null;
    public static final ActionType SHARE_MESSAGE_SELECT_USER = null;
    public static final ActionType SHARE_NAME_CARD = null;
    public static final ActionType SHARE_VIDEO_CHAT = null;
    public static final ActionType TASK_ADD_MEMBER = null;
    public static final ActionType TRANSFER_EVENT = null;
    public static final ActionType UNKNOWN_ACTION = null;
    public static final ActionType VIEW_PERSONAL_STATUS = null;
    public static final ActionType VOIP_CALL = null;
    public static final /* synthetic */ ActionType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class b {
        public b() {
        }

        @JvmStatic
        public static ActionType a(int r0) {
            switch(r0) {
                case 0: goto L39;
                case 1: goto L74;
                case 2: goto L73;
                case 3: goto L72;
                case 4: goto L71;
                case 5: goto L70;
                case 6: goto L69;
                case 7: goto L68;
                case 8: goto L67;
                case 9: goto L66;
                case 10: goto L65;
                case 11: goto L64;
                case 12: goto L63;
                case 13: goto L62;
                case 14: goto L61;
                case 15: goto L60;
                case 16: goto L59;
                case 17: goto L58;
                case 18: goto L57;
                case 19: goto L56;
                case 20: goto L55;
                case 21: goto L54;
                case 22: goto L53;
                case 23: goto L52;
                case 24: goto L51;
                case 25: goto L50;
                case 26: goto L3;
                case 27: goto L3;
                case 28: goto L3;
                case 29: goto L3;
                case 30: goto L49;
                case 31: goto L48;
                case 32: goto L47;
                case 33: goto L3;
                case 34: goto L3;
                case 35: goto L46;
                case 36: goto L45;
                case 37: goto L44;
                case 38: goto L43;
                case 39: goto L42;
                case 40: goto L41;
                default: goto L3;
            };
        L3:
            return null;
        L41:
            return ActionType.CHECK_BLOCK;
        L42:
            return ActionType.TASK_ADD_MEMBER;
        L43:
            return ActionType.CREATE_PRIVATE_CHAT_AND_INVITE;
        L44:
            return ActionType.PRIVATE_SEND_PRIVATE_MESSAGE;
        L45:
            return ActionType.PRIVATE_P2P_CHAT;
        L46:
            return ActionType.PRIVATE_CHAT;
        L47:
            return ActionType.ALLOW_SETTING_AS_PUBLIC_GROUP;
        L48:
            return ActionType.COOPERATION;
        L49:
            return ActionType.BLOCK;
        L50:
            return ActionType.INVITE_SAME_CROSS_TENANT_CHAT;
        L51:
            return ActionType.JOIN_CHAT_VIA_SHARE;
        L52:
            return ActionType.ADD_CONTACT;
        L53:
            return ActionType.CALENDAR_PRIVATE_CHECK;
        L54:
            return ActionType.SHARE_NAME_CARD;
        L55:
            return ActionType.DOC_SHARE_OR_CREATE;
        L56:
            return ActionType.SHARE_MESSAGE_SELECT_USER;
        L57:
            return ActionType.INVITE_SAME_CRYPTO_CHAT;
        L58:
            return ActionType.CCM_FEED_MESSAGE;
        L59:
            return ActionType.CCM_BOT_MESSAGE;
        L60:
            return ActionType.CCM_SEND_MESSAGE;
        L61:
            return ActionType.TRANSFER_EVENT;
        L62:
            return ActionType.SHARE_EVENT;
        L63:
            return ActionType.INVITE_EVENT;
        L64:
            return ActionType.SHARE_VIDEO_CHAT;
        L65:
            return ActionType.INVITE_VIDEO_CHAT;
        L66:
            return ActionType.CREATE_SINGLE_VIDEOCHAT;
        L67:
            return ActionType.VOIP_CALL;
        L68:
            return ActionType.VIEW_PERSONAL_STATUS;
        L69:
            return ActionType.CRATE_P2P_CRYPTO_CHAT;
        L70:
            return ActionType.MAKE_PHONE_CALL;
        L71:
            return ActionType.SEND_MESSAGE;
        L72:
            return ActionType.SEND_URGENT;
        L73:
            return ActionType.INVITE_SAME_CHAT;
        L74:
            return ActionType.CREATE_P2P_CHAT;
        L39:
            return ActionType.UNKNOWN_ACTION;
        }
    }

    @JvmStatic
    public static final ActionType fromValue(int r1) {
        Companion.getClass();
        return b.a(r1);
    }

    public static EnumEntries<ActionType> getEntries() {
        return b;
    }

    static {
        final ActionType r0 = new ActionType("UNKNOWN_ACTION", 0, 0);
        UNKNOWN_ACTION = r0;
        ActionType r1 = new ActionType("CREATE_P2P_CHAT", 1, 1);
        CREATE_P2P_CHAT = r1;
        ActionType r3 = new ActionType("INVITE_SAME_CHAT", 2, 2);
        INVITE_SAME_CHAT = r3;
        ActionType r5 = new ActionType("SEND_URGENT", 3, 3);
        SEND_URGENT = r5;
        ActionType r7 = new ActionType("SEND_MESSAGE", 4, 4);
        SEND_MESSAGE = r7;
        ActionType r9 = new ActionType("MAKE_PHONE_CALL", 5, 5);
        MAKE_PHONE_CALL = r9;
        ActionType r11 = new ActionType("CRATE_P2P_CRYPTO_CHAT", 6, 6);
        CRATE_P2P_CRYPTO_CHAT = r11;
        ActionType r13 = new ActionType("VIEW_PERSONAL_STATUS", 7, 7);
        VIEW_PERSONAL_STATUS = r13;
        ActionType r14 = new ActionType("INVITE_SAME_CRYPTO_CHAT", 8, 18);
        INVITE_SAME_CRYPTO_CHAT = r14;
        ActionType r15 = new ActionType("SHARE_MESSAGE_SELECT_USER", 9, 19);
        SHARE_MESSAGE_SELECT_USER = r15;
        ActionType r8 = new ActionType("VOIP_CALL", 10, 8);
        VOIP_CALL = r8;
        ActionType r2 = new ActionType("CREATE_SINGLE_VIDEOCHAT", 11, 9);
        CREATE_SINGLE_VIDEOCHAT = r2;
        ActionType r6 = new ActionType("INVITE_VIDEO_CHAT", 12, 10);
        INVITE_VIDEO_CHAT = r6;
        ActionType r4 = new ActionType("SHARE_VIDEO_CHAT", 13, 11);
        SHARE_VIDEO_CHAT = r4;
        ActionType r10 = new ActionType("INVITE_EVENT", 14, 12);
        INVITE_EVENT = r10;
        ActionType r12 = new ActionType("SHARE_EVENT", 15, 13);
        SHARE_EVENT = r12;
        ActionType r16 = new ActionType("TRANSFER_EVENT", 16, 14);
        TRANSFER_EVENT = r16;
        ActionType r17 = new ActionType("CCM_SEND_MESSAGE", 17, 15);
        CCM_SEND_MESSAGE = r17;
        ActionType r19 = new ActionType("CCM_BOT_MESSAGE", 18, 16);
        CCM_BOT_MESSAGE = r19;
        ActionType r20 = new ActionType("CCM_FEED_MESSAGE", 19, 17);
        CCM_FEED_MESSAGE = r20;
        ActionType r21 = new ActionType("DOC_SHARE_OR_CREATE", 20, 20);
        DOC_SHARE_OR_CREATE = r21;
        ActionType r110 = new ActionType("SHARE_NAME_CARD", 21, 21);
        SHARE_NAME_CARD = r110;
        ActionType r22 = new ActionType("CALENDAR_PRIVATE_CHECK", 22, 22);
        CALENDAR_PRIVATE_CHECK = r22;
        ActionType r111 = new ActionType("ADD_CONTACT", 23, 23);
        ADD_CONTACT = r111;
        ActionType r112 = new ActionType("JOIN_CHAT_VIA_SHARE", 24, 24);
        JOIN_CHAT_VIA_SHARE = r112;
        ActionType r23 = new ActionType("INVITE_SAME_CROSS_TENANT_CHAT", 25, 25);
        INVITE_SAME_CROSS_TENANT_CHAT = r23;
        ActionType r113 = new ActionType("BLOCK", 26, 30);
        BLOCK = r113;
        ActionType r24 = new ActionType("COOPERATION", 27, 31);
        COOPERATION = r24;
        ActionType r25 = new ActionType("ALLOW_SETTING_AS_PUBLIC_GROUP", 28, 32);
        ALLOW_SETTING_AS_PUBLIC_GROUP = r25;
        ActionType r114 = new ActionType("PRIVATE_CHAT", 29, 35);
        PRIVATE_CHAT = r114;
        ActionType r26 = new ActionType("PRIVATE_P2P_CHAT", 30, 36);
        PRIVATE_P2P_CHAT = r26;
        ActionType r27 = new ActionType("PRIVATE_SEND_PRIVATE_MESSAGE", 31, 37);
        PRIVATE_SEND_PRIVATE_MESSAGE = r27;
        ActionType r29 = new ActionType("CREATE_PRIVATE_CHAT_AND_INVITE", 32, 38);
        CREATE_PRIVATE_CHAT_AND_INVITE = r29;
        ActionType r30 = new ActionType("TASK_ADD_MEMBER", 33, 39);
        TASK_ADD_MEMBER = r30;
        ActionType r31 = new ActionType("CHECK_BLOCK", 34, 40);
        CHECK_BLOCK = r31;
        ActionType[] r32 = {r0, r1, r3, r5, r7, r9, r11, r13, r14, r15, r8, r2, r6, r4, r10, r12, r16, r17, r19, r20, r21, r110, r22, r111, r112, r23, r113, r24, r25, r114, r26, r27, r29, r30, r31};
        a = r32;
        b = EnumEntriesKt.enumEntries(r32);
        Companion = new b();
        final KClass r33 = Reflection.getOrCreateKotlinClass(ActionType.class);
        final Syntax r34 = Syntax.PROTO_2;
        ADAPTER = new a(r33, r34, r0);
    }

    public static ActionType[] values() {
        return (ActionType[]) a.clone();
    }

    @Override // com.lark.wire.o0
    public int getValue() {
        return this.value;
    }

    public static ActionType valueOf(String r1) {
        return (ActionType) r27.a.a(ActionType.class, r1);
    }

    public ActionType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
