package com.ss.android.lark.feed.app.entity;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import com.bytedance.ee.bear.drive.biz.cache.manual.model.ManualOfflineSyncData;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.api.extension.message.IMessageResourcePreloadTask;
import com.ss.android.lark.utils.UIHelper;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Deprecated(message = "use FeedFolder or FeedFolderCompat now", replaceWith = @ReplaceWith(expression = "FeedFolder", imports = {}))
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087\u0081\u0002\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001(B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010%\u001a\u00020&J\b\u0010'\u001a\u00020&H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$¨\u0006)"}, d2 = {"Lcom/ss/android/lark/feed/app/entity/FeedFilter;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "INBOX", "AT_ME", "UNREAD", "DELAYED", PreloadConfigModel.VERSION_CHECK_TYPE_DOC, "P2P_CHAT", "GROUP_CHAT", "BOT", "HELP_DESK", "TOPIC_GROUP", "DONE", "CRYPTO_CHAT", "MESSAGE", "MUTE", "GROUP", "TEAM", "TAG", "FLAG", "THREAD", "SHORTCUTS", ManualOfflineSyncData.DRIVE_TYPE, "UNREAD_OVER_DAYS", "CALENDAR_GROUP", "INSTANT_MEETING_GROUP", "COLLAPSED", "EXPIRED_FOLD", "MARK_AS_DELETED", "MESSAGE_WITHOUT_DOUBAO", "tabType", "", "toString", "Companion", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FeedFilter extends Enum<FeedFilter> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ FeedFilter[] $VALUES = null;
    public static final FeedFilter AT_ME = null;
    public static final FeedFilter BOT = null;
    public static final FeedFilter BOX = null;
    public static final FeedFilter CALENDAR_GROUP = null;
    public static final FeedFilter COLLAPSED = null;
    public static final FeedFilter CRYPTO_CHAT = null;
    public static final Companion Companion = null;

    @Deprecated(message = "deleted")
    public static final FeedFilter DELAYED = null;
    public static final FeedFilter DOC = null;
    public static final FeedFilter DONE = null;
    public static final FeedFilter EXPIRED_FOLD = null;
    public static final FeedFilter FLAG = null;
    public static final FeedFilter GROUP = null;
    public static final FeedFilter GROUP_CHAT = null;
    public static final FeedFilter HELP_DESK = null;
    public static final FeedFilter INBOX = null;
    public static final FeedFilter INSTANT_MEETING_GROUP = null;
    public static final FeedFilter MARK_AS_DELETED = null;
    public static final FeedFilter MESSAGE = null;
    public static final FeedFilter MESSAGE_WITHOUT_DOUBAO = null;
    public static final FeedFilter MUTE = null;
    public static final FeedFilter P2P_CHAT = null;
    public static final FeedFilter SHORTCUTS = null;
    public static final FeedFilter TAG = null;
    public static final FeedFilter TEAM = null;
    public static final FeedFilter THREAD = null;
    public static final FeedFilter TOPIC_GROUP = null;
    public static final FeedFilter UNKNOWN = null;
    public static final FeedFilter UNREAD = null;
    public static final FeedFilter UNREAD_OVER_DAYS = null;
    private final int value;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/feed/app/entity/FeedFilter$Companion;", "", "<init>", "()V", "valueOf", "Lcom/ss/android/lark/feed/app/entity/FeedFilter;", "value", "", "forNumber", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final FeedFilter forNumber(int r100) {
            if (r100 == 27) goto L41;
            if (r100 == 28) goto L69;
            if (r100 == 100) goto L68;
            if (r100 == 101) goto L67;
            switch(r100) {
                case 0: goto L66;
                case 1: goto L65;
                case 2: goto L64;
                case 3: goto L63;
                case 4: goto L62;
                case 5: goto L61;
                case 6: goto L60;
                case 7: goto L59;
                case 8: goto L58;
                case 9: goto L57;
                case 10: goto L56;
                case 11: goto L55;
                case 12: goto L54;
                case 13: goto L53;
                case 14: goto L52;
                case 15: goto L51;
                case 16: goto L50;
                default: goto L11;
            };
        L11:
            switch(r100) {
                case 18: goto L49;
                case 19: goto L48;
                case 20: goto L47;
                case 21: goto L46;
                case 22: goto L45;
                case 23: goto L44;
                case 24: goto L43;
                default: goto L42;
            };
        L42:
            return FeedFilter.UNKNOWN;
        L43:
            return FeedFilter.COLLAPSED;
        L44:
            return FeedFilter.INSTANT_MEETING_GROUP;
        L45:
            return FeedFilter.CALENDAR_GROUP;
        L46:
            return FeedFilter.UNREAD_OVER_DAYS;
        L47:
            return FeedFilter.THREAD;
        L48:
            return FeedFilter.FLAG;
        L49:
            return FeedFilter.TAG;
        L50:
            return FeedFilter.TEAM;
        L51:
            return FeedFilter.GROUP;
        L52:
            return FeedFilter.MUTE;
        L53:
            return FeedFilter.MESSAGE;
        L54:
            return FeedFilter.CRYPTO_CHAT;
        L55:
            return FeedFilter.DONE;
        L56:
            return FeedFilter.TOPIC_GROUP;
        L57:
            return FeedFilter.HELP_DESK;
        L58:
            return FeedFilter.BOT;
        L59:
            return FeedFilter.GROUP_CHAT;
        L60:
            return FeedFilter.P2P_CHAT;
        L61:
            return FeedFilter.DOC;
        L62:
            return FeedFilter.DELAYED;
        L63:
            return FeedFilter.UNREAD;
        L64:
            return FeedFilter.AT_ME;
        L65:
            return FeedFilter.INBOX;
        L66:
            return FeedFilter.UNKNOWN;
        L67:
            return FeedFilter.BOX;
        L68:
            return FeedFilter.SHORTCUTS;
        L69:
            return FeedFilter.MESSAGE_WITHOUT_DOUBAO;
        L41:
            return FeedFilter.MARK_AS_DELETED;
        }

        public final FeedFilter valueOf(int r100) {
            return forNumber(r100);
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[FeedFilter.values().length];
            r100[FeedFilter.UNKNOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L32
        L75:
            r100[FeedFilter.INBOX.ordinal()] = 2;     // Catch: NoSuchFieldError -> L33
        L85:
            r100[FeedFilter.AT_ME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L34
        L91:
            r100[FeedFilter.UNREAD.ordinal()] = 4;     // Catch: NoSuchFieldError -> L35
        L95:
            r100[FeedFilter.DELAYED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L36
        L99:
            r100[FeedFilter.DOC.ordinal()] = 6;     // Catch: NoSuchFieldError -> L37
        L109:
            r100[FeedFilter.P2P_CHAT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L38
        L67:
            r100[FeedFilter.GROUP_CHAT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L39
        L77:
            r100[FeedFilter.BOT.ordinal()] = 9;     // Catch: NoSuchFieldError -> L40
        L79:
            r100[FeedFilter.HELP_DESK.ordinal()] = 10;     // Catch: NoSuchFieldError -> L41
        L87:
            r100[FeedFilter.TOPIC_GROUP.ordinal()] = 11;     // Catch: NoSuchFieldError -> L42
        L103:
            r100[FeedFilter.DONE.ordinal()] = 12;     // Catch: NoSuchFieldError -> L43
        L111:
            r100[FeedFilter.CRYPTO_CHAT.ordinal()] = 13;     // Catch: NoSuchFieldError -> L44
        L59:
            r100[FeedFilter.MESSAGE.ordinal()] = 14;     // Catch: NoSuchFieldError -> L45
        L65:
            r100[FeedFilter.MUTE.ordinal()] = 15;     // Catch: NoSuchFieldError -> L46
        L83:
            r100[FeedFilter.TEAM.ordinal()] = 16;     // Catch: NoSuchFieldError -> L47
        L89:
            r100[FeedFilter.BOX.ordinal()] = 17;     // Catch: NoSuchFieldError -> L48
        L93:
            r100[FeedFilter.TAG.ordinal()] = 18;     // Catch: NoSuchFieldError -> L49
        L101:
            r100[FeedFilter.FLAG.ordinal()] = 19;     // Catch: NoSuchFieldError -> L50
        L63:
            r100[FeedFilter.THREAD.ordinal()] = 20;     // Catch: NoSuchFieldError -> L51
        L71:
            r100[FeedFilter.UNREAD_OVER_DAYS.ordinal()] = 21;     // Catch: NoSuchFieldError -> L52
        L73:
            r100[FeedFilter.CALENDAR_GROUP.ordinal()] = 22;     // Catch: NoSuchFieldError -> L53
        L81:
            r100[FeedFilter.INSTANT_MEETING_GROUP.ordinal()] = 23;     // Catch: NoSuchFieldError -> L54
        L97:
            r100[FeedFilter.COLLAPSED.ordinal()] = 24;     // Catch: NoSuchFieldError -> L55
        L105:
            r100[FeedFilter.EXPIRED_FOLD.ordinal()] = 25;     // Catch: NoSuchFieldError -> L56
        L107:
            r100[FeedFilter.MARK_AS_DELETED.ordinal()] = 26;     // Catch: NoSuchFieldError -> L57
        L61:
            r100[FeedFilter.MESSAGE_WITHOUT_DOUBAO.ordinal()] = 27;     // Catch: NoSuchFieldError -> L58
        L30:
            $EnumSwitchMapping$0 = r100;
        }
    }

    private static final /* synthetic */ FeedFilter[] $values() {
        return new FeedFilter[]{UNKNOWN, INBOX, AT_ME, UNREAD, DELAYED, DOC, P2P_CHAT, GROUP_CHAT, BOT, HELP_DESK, TOPIC_GROUP, DONE, CRYPTO_CHAT, MESSAGE, MUTE, GROUP, TEAM, TAG, FLAG, THREAD, SHORTCUTS, BOX, UNREAD_OVER_DAYS, CALENDAR_GROUP, INSTANT_MEETING_GROUP, COLLAPSED, EXPIRED_FOLD, MARK_AS_DELETED, MESSAGE_WITHOUT_DOUBAO};
    }

    public static EnumEntries<FeedFilter> getEntries() {
        return $ENTRIES;
    }

    static {
        UNKNOWN = new FeedFilter("UNKNOWN", 0, 0);
        INBOX = new FeedFilter("INBOX", 1, 1);
        AT_ME = new FeedFilter("AT_ME", 2, 2);
        UNREAD = new FeedFilter("UNREAD", 3, 3);
        DELAYED = new FeedFilter("DELAYED", 4, 4);
        DOC = new FeedFilter(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 5, 5);
        P2P_CHAT = new FeedFilter("P2P_CHAT", 6, 6);
        GROUP_CHAT = new FeedFilter("GROUP_CHAT", 7, 7);
        BOT = new FeedFilter("BOT", 8, 8);
        HELP_DESK = new FeedFilter("HELP_DESK", 9, 9);
        TOPIC_GROUP = new FeedFilter("TOPIC_GROUP", 10, 10);
        DONE = new FeedFilter("DONE", 11, 11);
        CRYPTO_CHAT = new FeedFilter("CRYPTO_CHAT", 12, 12);
        MESSAGE = new FeedFilter("MESSAGE", 13, 13);
        MUTE = new FeedFilter("MUTE", 14, 14);
        GROUP = new FeedFilter("GROUP", 15, 15);
        TEAM = new FeedFilter("TEAM", 16, 16);
        TAG = new FeedFilter("TAG", 17, 18);
        FLAG = new FeedFilter("FLAG", 18, 19);
        THREAD = new FeedFilter("THREAD", 19, 20);
        SHORTCUTS = new FeedFilter("SHORTCUTS", 20, 100);
        BOX = new FeedFilter(ManualOfflineSyncData.DRIVE_TYPE, 21, 101);
        UNREAD_OVER_DAYS = new FeedFilter("UNREAD_OVER_DAYS", 22, 21);
        CALENDAR_GROUP = new FeedFilter("CALENDAR_GROUP", 23, 22);
        INSTANT_MEETING_GROUP = new FeedFilter("INSTANT_MEETING_GROUP", 24, 23);
        COLLAPSED = new FeedFilter("COLLAPSED", 25, 24);
        EXPIRED_FOLD = new FeedFilter("EXPIRED_FOLD", 26, 26);
        MARK_AS_DELETED = new FeedFilter("MARK_AS_DELETED", 27, 27);
        MESSAGE_WITHOUT_DOUBAO = new FeedFilter("MESSAGE_WITHOUT_DOUBAO", 28, 28);
        FeedFilter[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new Companion(null);
    }

    public static FeedFilter[] values() {
        return (FeedFilter[]) $VALUES.clone();
    }

    public final String tabType() {
        switch(WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L28;
            case 5: goto L27;
            case 6: goto L26;
            case 7: goto L25;
            case 8: goto L24;
            case 9: goto L23;
            case 10: goto L22;
            case 11: goto L21;
            case 12: goto L20;
            case 13: goto L19;
            case 14: goto L18;
            case 15: goto L17;
            case 16: goto L16;
            case 17: goto L15;
            case 18: goto L14;
            case 19: goto L13;
            case 20: goto L12;
            case 21: goto L11;
            case 22: goto L10;
            case 23: goto L9;
            case 24: goto L8;
            case 25: goto L7;
            case 26: goto L6;
            case 27: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        return "message_without_doubao";
    L6:
        return "mark_as_deleted";
    L7:
        return "expired_fold";
    L8:
        return "collapsed";
    L9:
        return "instant_meeting_group";
    L10:
        return "calendar_meeting";
    L11:
        return "unread_over_days";
    L12:
        return "thread";
    L13:
        return "mark";
    L14:
        return "label";
    L15:
        return "box";
    L16:
        return WikiSpaceType.TEAM;
    L17:
        return ITTVideoEngineEventSource.KEY_MUTE;
    L18:
        return "message";
    L19:
        return IMessageResourcePreloadTask.Scene.SECRET_CHAT;
    L20:
        return "done";
    L21:
        return "channel";
    L22:
        return "helpdesk";
    L23:
        return "bot";
    L24:
        return "group_chat";
    L25:
        return "p2p_chat";
    L26:
        return "docs";
    L27:
        return "delayed";
    L28:
        return "unread";
    L29:
        return "at_me";
    L30:
        return "inbox";
    L31:
        return "unknown";
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        int r101 = R.string.Lark_Legacy_ChatBox;
        switch(r100) {
            case 1: goto L27;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L24;
            case 5: goto L23;
            case 6: goto L22;
            case 7: goto L21;
            case 8: goto L20;
            case 9: goto L19;
            case 10: goto L18;
            case 11: goto L17;
            case 12: goto L16;
            case 13: goto L15;
            case 14: goto L14;
            case 15: goto L13;
            case 16: goto L12;
            case 17: goto L29;
            case 18: goto L11;
            case 19: goto L10;
            case 20: goto L9;
            case 21: goto L8;
            case 22: goto L7;
            case 23: goto L6;
            case 24: goto L29;
            case 25: goto L5;
            default: goto L27;
        };
    L5:
        r101 = R.string.Lark_IM_FilterClutter_Tab;
        goto L29
    L6:
        r101 = R.string.Lark_IM_MeetingGroups_Label;
        goto L29
    L7:
        r101 = R.string.Lark_IM_EventMeetings_Filter;
        goto L29
    L8:
        r101 = R.string.Lark_Core_UnreadOver1Week_Tab;
        goto L29
    L9:
        r101 = R.string.Lark_IM_FeedFilter_Thread_Title;
        goto L29
    L10:
        r101 = R.string.Lark_IM_Marked_TabTitle;
        goto L29
    L11:
        r101 = R.string.Lark_Core_LabelTab_Title;
        goto L29
    L12:
        r101 = R.string.Project_T_TeamMenuTab;
        goto L29
    L13:
        r101 = R.string.Lark_Feed_FilterMuted;
        goto L29
    L14:
        r101 = R.string.Lark_Feed_FilterChats;
        goto L29
    L15:
        r101 = R.string.Lark_Feed_FilterSecretChats;
        goto L29
    L16:
        r101 = R.string.Lark_Feed_FilterDone;
        goto L29
    L17:
        r101 = R.string.Lark_Feed_FilterCircles;
        goto L29
    L18:
        r101 = R.string.Lark_Feed_FilterHelpDesk;
        goto L29
    L19:
        r101 = R.string.Lark_Feed_FilterBots;
        goto L29
    L20:
        r101 = R.string.Lark_Feed_FilterGroupChats;
        goto L29
    L21:
        r101 = R.string.Lark_Feed_FilterPrivateChats;
        goto L29
    L22:
        r101 = R.string.Lark_Feed_FilterDocs;
        goto L29
    L23:
        r101 = R.string.Lark_IM_MarkAMessageToArchive_Button;
        goto L29
    L24:
        r101 = R.string.Lark_Feed_FilterUnread;
        goto L29
    L25:
        r101 = R.string.Lark_Feed_FilterMentions;
        goto L29
    L26:
        r101 = R.string.Lark_Feed_FilterAll;
        goto L29
    L27:
        r101 = R.string.Lark_Legacy_UnknownErr;
    L29:
        return UIHelper.getString(r101);
    }

    public final int getValue() {
        return this.value;
    }

    public static FeedFilter valueOf(String r100) {
        return (FeedFilter) a.a(FeedFilter.class, r100);
    }

    private FeedFilter(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
