package com.ss.android.lark.picker.statistics;

import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResConstants;
import com.ss.android.lark.notification.export.offline.IOfflineExtraParser;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/picker/statistics/PickerStatistics;", "", "<init>", "()V", "getBizByScene", "", "scene", "Lcom/ss/android/lark/picker/statistics/PickerStatistics$Scene;", "Scene", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PickerStatistics {
    public static final PickerStatistics INSTANCE = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b#\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%¨\u0006&"}, d2 = {"Lcom/ss/android/lark/picker/statistics/PickerStatistics$Scene;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Unknown", "Demo", "CalendarAgendaAssociate", "CalendarShareMember", "CalendarBindGroup", "CcmInlineAI", "CcmSearchInSpace", "CcmSearchInWiki", "CcmSearchInWikiTree", "CcmSearchInWikiAndFolder", "CcmSearchFolder", "CcmSearchWikiSpace", "CcmFilterByFolder", "CcmFilterByWikiSpace", "CcmFilterByOwner", "CcmFilterByChat", "CcmCommentVisible", "CcmCommonPanelAddMember", "ImSelectDocs", "ImCreateAndForward", "SearchFilterByOpenMail", "SearchCalendarFilterByParticipants", "OpenPlatformChooseContact", "BaseMyDashboardAddChart", "BaseFormAddNotificationUser", "MailSearchFilterBySender", "ImForwardMention", "ImForwardMain", "ProfileMention", "DescriptionScope", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Scene extends Enum<Scene> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Scene[] $VALUES = null;
        public static final Scene BaseFormAddNotificationUser = null;
        public static final Scene BaseMyDashboardAddChart = null;
        public static final Scene CalendarAgendaAssociate = null;
        public static final Scene CalendarBindGroup = null;
        public static final Scene CalendarShareMember = null;
        public static final Scene CcmCommentVisible = null;
        public static final Scene CcmCommonPanelAddMember = null;
        public static final Scene CcmFilterByChat = null;
        public static final Scene CcmFilterByFolder = null;
        public static final Scene CcmFilterByOwner = null;
        public static final Scene CcmFilterByWikiSpace = null;
        public static final Scene CcmInlineAI = null;
        public static final Scene CcmSearchFolder = null;
        public static final Scene CcmSearchInSpace = null;
        public static final Scene CcmSearchInWiki = null;
        public static final Scene CcmSearchInWikiAndFolder = null;
        public static final Scene CcmSearchInWikiTree = null;
        public static final Scene CcmSearchWikiSpace = null;
        public static final Scene Demo = null;
        public static final Scene DescriptionScope = null;
        public static final Scene ImCreateAndForward = null;
        public static final Scene ImForwardMain = null;
        public static final Scene ImForwardMention = null;
        public static final Scene ImSelectDocs = null;
        public static final Scene MailSearchFilterBySender = null;
        public static final Scene OpenPlatformChooseContact = null;
        public static final Scene ProfileMention = null;
        public static final Scene SearchCalendarFilterByParticipants = null;
        public static final Scene SearchFilterByOpenMail = null;
        public static final Scene Unknown = null;
        private final String value;

        private static final /* synthetic */ Scene[] $values() {
            return new Scene[]{Unknown, Demo, CalendarAgendaAssociate, CalendarShareMember, CalendarBindGroup, CcmInlineAI, CcmSearchInSpace, CcmSearchInWiki, CcmSearchInWikiTree, CcmSearchInWikiAndFolder, CcmSearchFolder, CcmSearchWikiSpace, CcmFilterByFolder, CcmFilterByWikiSpace, CcmFilterByOwner, CcmFilterByChat, CcmCommentVisible, CcmCommonPanelAddMember, ImSelectDocs, ImCreateAndForward, SearchFilterByOpenMail, SearchCalendarFilterByParticipants, OpenPlatformChooseContact, BaseMyDashboardAddChart, BaseFormAddNotificationUser, MailSearchFilterBySender, ImForwardMention, ImForwardMain, ProfileMention, DescriptionScope};
        }

        public static EnumEntries<Scene> getEntries() {
            return $ENTRIES;
        }

        static {
            Unknown = new Scene("Unknown", 0, "unknown");
            Demo = new Scene("Demo", 1, "demo");
            CalendarAgendaAssociate = new Scene("CalendarAgendaAssociate", 2, "calendarAgendaAssociate");
            CalendarShareMember = new Scene("CalendarShareMember", 3, "calendarShareMember");
            CalendarBindGroup = new Scene("CalendarBindGroup", 4, "calendarBindGroup");
            CcmInlineAI = new Scene("CcmInlineAI", 5, "ccmInlineAI");
            CcmSearchInSpace = new Scene("CcmSearchInSpace", 6, "ccmSearchInSpace");
            CcmSearchInWiki = new Scene("CcmSearchInWiki", 7, "ccmSearchInWiki");
            CcmSearchInWikiTree = new Scene("CcmSearchInWikiTree", 8, "ccmSearchInWikiTree");
            CcmSearchInWikiAndFolder = new Scene("CcmSearchInWikiAndFolder", 9, "ccmSearchInWikiAndFolder");
            CcmSearchFolder = new Scene("CcmSearchFolder", 10, "ccmSearchFolder");
            CcmSearchWikiSpace = new Scene("CcmSearchWikiSpace", 11, "ccmSearchWikiSpace");
            CcmFilterByFolder = new Scene("CcmFilterByFolder", 12, "ccmFilterByFolder");
            CcmFilterByWikiSpace = new Scene("CcmFilterByWikiSpace", 13, "ccmFilterByWikiSpace");
            CcmFilterByOwner = new Scene("CcmFilterByOwner", 14, "ccmFilterByOwner");
            CcmFilterByChat = new Scene("CcmFilterByChat", 15, "ccmFilterByChat");
            CcmCommentVisible = new Scene("CcmCommentVisible", 16, "ccmCommentVisible");
            CcmCommonPanelAddMember = new Scene("CcmCommonPanelAddMember", 17, "ccmCommonPanelAddMember");
            ImSelectDocs = new Scene("ImSelectDocs", 18, "imSelectDocs");
            ImCreateAndForward = new Scene("ImCreateAndForward", 19, "imCreateAndForward");
            SearchFilterByOpenMail = new Scene("SearchFilterByOpenMail", 20, "searchFilterByOpenMail");
            SearchCalendarFilterByParticipants = new Scene("SearchCalendarFilterByParticipants", 21, "searchCalendarFilterByParticipants");
            OpenPlatformChooseContact = new Scene("OpenPlatformChooseContact", 22, "openPlatformChooseContact");
            BaseMyDashboardAddChart = new Scene("BaseMyDashboardAddChart", 23, "baseMyDashboardAddChart");
            BaseFormAddNotificationUser = new Scene("BaseFormAddNotificationUser", 24, "baseFormAddNotificationUser");
            MailSearchFilterBySender = new Scene("MailSearchFilterBySender", 25, "mailSearchFilterBySender");
            ImForwardMention = new Scene("ImForwardMention", 26, "imForwardMention");
            ImForwardMain = new Scene("ImForwardMain", 27, "imForwardMain");
            ProfileMention = new Scene("ProfileMention", 28, "profileMention");
            DescriptionScope = new Scene("DescriptionScope", 29, "DESCRIPTION_SCOPE");
            Scene[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static Scene[] values() {
            return (Scene[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static Scene valueOf(String r100) {
            return (Scene) a.a(Scene.class, r100);
        }

        private Scene(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[Scene.values().length];
            r100[Scene.CalendarAgendaAssociate.ordinal()] = 1;     // Catch: NoSuchFieldError -> L29
        L85:
            r100[Scene.CalendarBindGroup.ordinal()] = 2;     // Catch: NoSuchFieldError -> L30
        L99:
            r100[Scene.CalendarShareMember.ordinal()] = 3;     // Catch: NoSuchFieldError -> L31
        L61:
            r100[Scene.CcmInlineAI.ordinal()] = 4;     // Catch: NoSuchFieldError -> L32
        L65:
            r100[Scene.CcmSearchInSpace.ordinal()] = 5;     // Catch: NoSuchFieldError -> L33
        L79:
            r100[Scene.CcmSearchInWiki.ordinal()] = 6;     // Catch: NoSuchFieldError -> L34
        L93:
            r100[Scene.CcmSearchInWikiTree.ordinal()] = 7;     // Catch: NoSuchFieldError -> L35
        L71:
            r100[Scene.CcmSearchInWikiAndFolder.ordinal()] = 8;     // Catch: NoSuchFieldError -> L36
        L87:
            r100[Scene.CcmSearchFolder.ordinal()] = 9;     // Catch: NoSuchFieldError -> L37
        L89:
            r100[Scene.CcmSearchWikiSpace.ordinal()] = 10;     // Catch: NoSuchFieldError -> L38
        L55:
            r100[Scene.CcmFilterByFolder.ordinal()] = 11;     // Catch: NoSuchFieldError -> L39
        L83:
            r100[Scene.CcmFilterByWikiSpace.ordinal()] = 12;     // Catch: NoSuchFieldError -> L40
        L97:
            r100[Scene.CcmFilterByOwner.ordinal()] = 13;     // Catch: NoSuchFieldError -> L41
        L53:
            r100[Scene.CcmFilterByChat.ordinal()] = 14;     // Catch: NoSuchFieldError -> L42
        L67:
            r100[Scene.CcmCommentVisible.ordinal()] = 15;     // Catch: NoSuchFieldError -> L43
        L95:
            r100[Scene.ImSelectDocs.ordinal()] = 16;     // Catch: NoSuchFieldError -> L44
        L59:
            r100[Scene.ImCreateAndForward.ordinal()] = 17;     // Catch: NoSuchFieldError -> L45
        L63:
            r100[Scene.SearchFilterByOpenMail.ordinal()] = 18;     // Catch: NoSuchFieldError -> L46
        L81:
            r100[Scene.SearchCalendarFilterByParticipants.ordinal()] = 19;     // Catch: NoSuchFieldError -> L47
        L57:
            r100[Scene.OpenPlatformChooseContact.ordinal()] = 20;     // Catch: NoSuchFieldError -> L48
        L75:
            r100[Scene.BaseMyDashboardAddChart.ordinal()] = 21;     // Catch: NoSuchFieldError -> L49
        L77:
            r100[Scene.BaseFormAddNotificationUser.ordinal()] = 22;     // Catch: NoSuchFieldError -> L50
        L91:
            r100[Scene.MailSearchFilterBySender.ordinal()] = 23;     // Catch: NoSuchFieldError -> L51
        L69:
            r100[Scene.Demo.ordinal()] = 24;     // Catch: NoSuchFieldError -> L52
        L27:
            $EnumSwitchMapping$0 = r100;
        }
    }

    static {
        INSTANCE = new PickerStatistics();
    }

    private PickerStatistics() {
    }

    public final String getBizByScene(Scene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        switch(WhenMappings.$EnumSwitchMapping$0[r100.ordinal()]) {
            case 1: goto L11;
            case 2: goto L11;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L10;
            case 6: goto L10;
            case 7: goto L10;
            case 8: goto L10;
            case 9: goto L10;
            case 10: goto L10;
            case 11: goto L10;
            case 12: goto L10;
            case 13: goto L10;
            case 14: goto L10;
            case 15: goto L10;
            case 16: goto L9;
            case 17: goto L9;
            case 18: goto L8;
            case 19: goto L8;
            case 20: goto L7;
            case 21: goto L6;
            case 22: goto L6;
            case 23: goto L5;
            case 24: goto L13;
            default: goto L13;
        };
    L5:
        return IOfflineExtraParser.ParserType.MAIL;
    L6:
        return "base";
    L7:
        return "openPlatform";
    L8:
        return "search";
    L9:
        return "im";
    L10:
        return ChameleonResConstants.CCM_ROOT_DIR;
    L11:
        return "calendar";
    L13:
        return "unknown";
    }
}
