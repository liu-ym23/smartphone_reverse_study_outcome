package com.larus.im.internal.legacy;

import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.MsgFeedbackType;
import com.larus.im.bean.message.UpdateMessageLocalOption;
import com.larus.im.bean.thread.ThreadMessageDirection;
import com.larus.im.internal.jni.bean.OmniConversationType;
import com.larus.im.service.IMessageService;

/* JADX INFO: loaded from: classes4.dex */
public final class c5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f348735a = 0;

    /* JADX INFO: loaded from: classes29.dex */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f348736a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f348737b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f348738c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f348739d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ int[] f348740e = null;

        static {
            int[] r100 = new int[MessageStatus.values().length];
            r100[MessageStatus.MessageStatus_AVAILABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L47
        L96:
            r100[MessageStatus.MessageStatus_INVISIBLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L48
        L108:
            r100[MessageStatus.MessageStatus_NOT_EXIST.ordinal()] = 3;     // Catch: NoSuchFieldError -> L49
        L116:
            r100[MessageStatus.MessageStatus_DELETED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L50
        L118:
            r100[MessageStatus.MessageStatus_EDITED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L51
        L130:
            r100[MessageStatus.MessageStatus_BEFOREEDIT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L52
        L136:
            r100[MessageStatus.MessageStatus_REGEN_ROOT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L53
        L86:
            r100[MessageStatus.MessageStatus_UNSELECTED.ordinal()] = 8;     // Catch: NoSuchFieldError -> L54
        L98:
            r100[MessageStatus.MessageStatus_REGENATED.ordinal()] = 9;     // Catch: NoSuchFieldError -> L55
        L100:
            r100[MessageStatus.MessageStatus_NOTCOMPLIANT.ordinal()] = 10;     // Catch: NoSuchFieldError -> L56
        L20:
            f348736a = r100;
            int[] r101 = new int[IMessageService.RegenDirection.values().length];
            r101[IMessageService.RegenDirection.PREVIOUS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L57
        L128:
            r101[IMessageService.RegenDirection.NEXT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L58
        L23:
            f348737b = r101;
            int[] r102 = new int[MsgFeedbackType.values().length];
            r102[MsgFeedbackType.MsgFeedbackTypeDefault.ordinal()] = 1;     // Catch: NoSuchFieldError -> L59
        L82:
            r102[MsgFeedbackType.MsgFeedbackTypeLike.ordinal()] = 2;     // Catch: NoSuchFieldError -> L60
        L90:
            r102[MsgFeedbackType.MsgFeedbackTypeDislike.ordinal()] = 3;     // Catch: NoSuchFieldError -> L61
        L102:
            r102[MsgFeedbackType.MsgFeedbackTypeBetter.ordinal()] = 4;     // Catch: NoSuchFieldError -> L62
        L110:
            r102[MsgFeedbackType.MsgFeedbackTypeAlmost.ordinal()] = 5;     // Catch: NoSuchFieldError -> L63
        L122:
            r102[MsgFeedbackType.MsgFeedbackTypeBothBad.ordinal()] = 6;     // Catch: NoSuchFieldError -> L64
        L132:
            r102[MsgFeedbackType.MsgFeedbackTypeForm.ordinal()] = 7;     // Catch: NoSuchFieldError -> L65
        L31:
            f348738c = r102;
            int[] r103 = new int[UpdateMessageLocalOption.values().length];
            r103[UpdateMessageLocalOption.CONTENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L66
        L84:
            r103[UpdateMessageLocalOption.LOCAL_STATUS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L67
        L92:
            r103[UpdateMessageLocalOption.LOCAL_MESSAGE_STATUS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L68
        L104:
            r103[UpdateMessageLocalOption.REPLACE_BIZ_EXT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L69
        L112:
            r103[UpdateMessageLocalOption.REPLACE_EXT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L70
        L124:
            r103[UpdateMessageLocalOption.MERGE_BIZ_EXT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L71
        L134:
            r103[UpdateMessageLocalOption.MERGE_EXT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L72
        L138:
            r103[UpdateMessageLocalOption.CREATE_TIME.ordinal()] = 8;     // Catch: NoSuchFieldError -> L73
        L40:
            f348739d = r103;
            int[] r104 = new int[ThreadMessageDirection.values().length];
            r104[ThreadMessageDirection.UN_KNOW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L74
        L106:
            r104[ThreadMessageDirection.OLDER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L75
        L114:
            r104[ThreadMessageDirection.NEWER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L76
        L126:
            r104[ThreadMessageDirection.LATEST.ordinal()] = 4;     // Catch: NoSuchFieldError -> L77
        L45:
            f348740e = r104;
        }
    }

    static {
    }

    public static OmniConversationType a(int r100) {
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L15;
        if (r100 == 3) goto L14;
        return OmniConversationType.CONVERSATION_TYPE_UNKNOWN;
    L14:
        return OmniConversationType.ONE_TO_BOT_CHAT;
    L15:
        return OmniConversationType.GROUP_CHAT;
    L12:
        return OmniConversationType.ONE_TO_ONE_CHAT;
    }
}
