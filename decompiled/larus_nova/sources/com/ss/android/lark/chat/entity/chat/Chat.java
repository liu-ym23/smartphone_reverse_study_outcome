package com.ss.android.lark.chat.entity.chat;

import android.text.TextUtils;
import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
import com.bytedance.lark.pb.basic.v1.Tag;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.lark.chat.entity.tag.TagData;
import com.ss.android.lark.chat.entity.translate.LanguageInfo;
import com.ss.android.lark.chat.export.entity.chat.OpenChat;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes35.dex */
public class Chat implements OpenChat, Serializable {
    private static final long serialVersionUID = -4912521595824753252L;
    private AddMemberPermission addMemberPermission;
    private AdminPostSetting adminPostSetting;
    private AtAllPermission atAllPermission;
    private Long atKnowledgeQueryCreateTime;
    private Long atKnowledgeQueryId;
    private String avatarKey;
    private BannerSetting bannerSetting;
    private boolean bannerSettingAdmin;
    private String bannerText;
    private List<ChatTeamInfo> boundTeamInfos;
    private int burnLife;
    private BuzzPermissionSetting buzzPermissionSetting;
    private boolean canBeSortedAlphabetically;
    private boolean canTranslateName;
    private ChatAnnouncement chatAnnouncement;
    private ChatDisplayModeSetting chatDisplayModeSetting;
    private ChatMode chatMode;
    private ChatOptionInfo chatOptionInfo;
    private ChatPinPermissionSetting chatPinPermissionSetting;
    private ChatTabPermissionSetting chatTabPermissionSetting;
    private ChatTnsInfo chatTnsInfo;
    private boolean chatable;
    private Map<Integer, Integer> chatterExtraStates;
    private String createTime;
    private CreateVideoConferenceSetting createVideoConferenceSetting;
    private DefaultDisplaySetting defaultDisplaySetting;
    private String description;
    private DoubaoSetting doubaoSetting;
    private int firstMessagePosition;
    private GroupMailSendPermissionType groupMailSendType;
    private boolean hasVCChatPermission;
    private boolean hasWatermark;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f415114id;
    private boolean isAIBotChat;
    private boolean isAIMainChat;
    private boolean isAccept;
    private boolean isAdmin;
    private boolean isAllowPost;
    private boolean isArchived;
    private boolean isAutoTranslate;
    private boolean isChatterReady;
    private boolean isCrossTenant;
    private boolean isCrossWithKa;
    private boolean isCustomAvatar;
    private boolean isCustomerService;
    private boolean isDeleted;
    private boolean isDissolved;
    private boolean isFake;
    private boolean isFlag;
    private boolean isFrozen;
    private boolean isGroupMailEnable;
    private boolean isInBox;
    private boolean isMeeting;
    private boolean isOcicService;
    private boolean isOfficialOncall;
    private boolean isOfflineOncall;
    private boolean isOnlyOwnerEditGroupInfo;
    private boolean isPublic;
    private boolean isRemind;
    private boolean isSecret;
    private boolean isShotCut;
    private boolean isShowApplyBanner;
    private boolean isSuper;
    private boolean isTenant;
    private boolean isUserCountVisible;
    private boolean is_department;
    private boolean is_public;
    private SystemMessageVisible joinMessageVisible;
    private String key;
    private String lastDraftId;
    private String lastMessageId;
    private int lastMessagePosition;
    private int lastMessagePositionBadgeCount;
    private String lastThreadId;
    private int lastThreadPosition;
    private int lastThreadPositionBadgeCount;
    private String lastVisibleMessageId;
    private int lastVisibleMessagePosition;
    private String lastVisibleThreadId;
    private int lastVisibleThreadPosition;
    private AddMemberApply mAddMemberApply;
    private String mAnonymousId;
    private AnonymousSetting mAnonymousSetting;
    private long mAnonymousTotalQuota;
    private ChatUserAutoMuteSetting mChatUserAutoMuteSetting;
    private boolean mIsDelayed;
    private boolean mIsMuteAtAll;
    private MessageVisibilitySetting mMessageVisibilitySetting;
    private long mThemeId;
    private int memberCount;
    private MessagePosition messagePosition;
    private String miniAvatarKey;
    private boolean muteable;
    private int myThreadsUnreadCount;
    private String name;
    private String nameMajorLanguage;
    private String namePinyin;
    private String nameTranslateLanguage;
    private String onCallId;
    private String ownerId;
    private String p2pChatterId;
    private PinPermissionSetting pinPermissionSetting;
    private String postDraftId;
    private PostType postType;
    private int putChatterApplyCount;
    private SystemMessageVisible quitMessageVisible;
    private String reEditDraftId;
    private int readPosition;
    private int readPositionBadgeCount;
    private int readThreadPosition;
    private int readThreadPositionBadgeCount;
    private float recentReadOffset;
    private int recentReadPosition;
    private RestrictedModeSetting restrictedModeSetting;
    Role role;
    private String scheduleDraftId;
    private ShareCardPermission shareCardPermission;
    private boolean shouldDisplayTranslatedName;
    private boolean showBannerTitle;
    private List<SideBarButton> sideBarButtons;
    private String sideBarId;
    private Status status;
    private TagData tagData;
    private List<Tag> tags;
    private String tenantId;
    private String textDraftId;
    private long threadLastTimeStamp;
    private long threadReadTimeStamp;
    private TopNoticePermissionSetting topNoticePermissionSetting;
    private String translatedName;
    private Type type;
    private boolean typingTranslateHasAutoOpened;
    private TypingTranslateSetting typingTranslateSetting;
    private long updateTime;
    private int userCount;
    private UserCountVisibleSetting userCountVisibleSetting;

    public static final enum AddMemberApply extends Enum<AddMemberApply> {
        public static final AddMemberApply NEED_APPLY = null;
        public static final AddMemberApply NO_APPLY = null;
        public static final AddMemberApply UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AddMemberApply[] f415115a = null;
        private final int value;

        static {
            AddMemberApply r100 = new AddMemberApply("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            AddMemberApply r101 = new AddMemberApply("NO_APPLY", 1, 1);
            NO_APPLY = r101;
            AddMemberApply r102 = new AddMemberApply("NEED_APPLY", 2, 2);
            NEED_APPLY = r102;
            f415115a = new AddMemberApply[]{r100, r101, r102};
        }

        public static AddMemberApply[] values() {
            return (AddMemberApply[]) f415115a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static AddMemberApply forNumber(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return UNKNOWN;
        L10:
            return NEED_APPLY;
        L12:
            return NO_APPLY;
        L14:
            return UNKNOWN;
        }

        public static AddMemberApply valueOf(String r100) {
            return (AddMemberApply) r27.a.a(AddMemberApply.class, r100);
        }

        public static AddMemberApply valueOf(int r100) {
            return forNumber(r100);
        }

        public AddMemberApply(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum AddMemberPermission extends Enum<AddMemberPermission> {
        public static final AddMemberPermission ALL_MEMBERS = null;
        public static final AddMemberPermission ONLY_OWNER = null;
        public static final AddMemberPermission UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AddMemberPermission[] f415116a = null;
        private final int value;

        static {
            AddMemberPermission r100 = new AddMemberPermission("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            AddMemberPermission r101 = new AddMemberPermission("ALL_MEMBERS", 1, 1);
            ALL_MEMBERS = r101;
            AddMemberPermission r102 = new AddMemberPermission("ONLY_OWNER", 2, 2);
            ONLY_OWNER = r102;
            f415116a = new AddMemberPermission[]{r100, r101, r102};
        }

        public static AddMemberPermission[] values() {
            return (AddMemberPermission[]) f415116a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static AddMemberPermission forNumber(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return UNKNOWN;
        L10:
            return ONLY_OWNER;
        L12:
            return ALL_MEMBERS;
        L14:
            return UNKNOWN;
        }

        public static AddMemberPermission valueOf(String r100) {
            return (AddMemberPermission) r27.a.a(AddMemberPermission.class, r100);
        }

        public static AddMemberPermission valueOf(int r100) {
            return forNumber(r100);
        }

        public AddMemberPermission(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum AdminPostSetting extends Enum<AdminPostSetting> {
        public static final AdminPostSetting ALLOW_POST = null;
        public static final AdminPostSetting BANNED_POST = null;
        public static final AdminPostSetting UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AdminPostSetting[] f415117a = null;
        private final int value;

        static {
            AdminPostSetting r100 = new AdminPostSetting("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            AdminPostSetting r101 = new AdminPostSetting("ALLOW_POST", 1, 1);
            ALLOW_POST = r101;
            AdminPostSetting r102 = new AdminPostSetting("BANNED_POST", 2, 2);
            BANNED_POST = r102;
            f415117a = new AdminPostSetting[]{r100, r101, r102};
        }

        public static AdminPostSetting[] values() {
            return (AdminPostSetting[]) f415117a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static AdminPostSetting forNumber(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return UNKNOWN;
        L9:
            return BANNED_POST;
        L11:
            return ALLOW_POST;
        }

        public static AdminPostSetting valueOf(String r100) {
            return (AdminPostSetting) r27.a.a(AdminPostSetting.class, r100);
        }

        public static AdminPostSetting valueOf(int r100) {
            return forNumber(r100);
        }

        public AdminPostSetting(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum AnonymousSetting extends Enum<AnonymousSetting> {
        public static final AnonymousSetting ALLOWED = null;
        public static final AnonymousSetting INVISIBLE = null;
        public static final AnonymousSetting INVISIBLE_ALLOWED = null;
        public static final AnonymousSetting NOT_ALLOWED = null;
        public static final AnonymousSetting UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AnonymousSetting[] f415118a = null;
        private final int value;

        static {
            AnonymousSetting r100 = new AnonymousSetting("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            AnonymousSetting r101 = new AnonymousSetting("INVISIBLE", 1, 1);
            INVISIBLE = r101;
            AnonymousSetting r102 = new AnonymousSetting("NOT_ALLOWED", 2, 2);
            NOT_ALLOWED = r102;
            AnonymousSetting r103 = new AnonymousSetting("ALLOWED", 3, 3);
            ALLOWED = r103;
            AnonymousSetting r104 = new AnonymousSetting("INVISIBLE_ALLOWED", 4, 100);
            INVISIBLE_ALLOWED = r104;
            f415118a = new AnonymousSetting[]{r100, r101, r102, r103, r104};
        }

        public static AnonymousSetting[] values() {
            return (AnonymousSetting[]) f415118a.clone();
        }

        public String getDisplay() {
            return toString();
        }

        public int getNumber() {
            return this.value;
        }

        public static AnonymousSetting forNumber(int r100) {
            AnonymousSetting[] r101 = values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L9;
            AnonymousSetting r104 = r101[r103];
            if (r104.getNumber() == r100) goto L6;
            r103 = r103 + 1;
            goto L3
        L6:
            return r104;
        L9:
            return UNKNOWN;
        }

        public static AnonymousSetting valueOf(String r100) {
            return (AnonymousSetting) r27.a.a(AnonymousSetting.class, r100);
        }

        public static AnonymousSetting valueOf(int r100) {
            return forNumber(r100);
        }

        public AnonymousSetting(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum AtAllPermission extends Enum<AtAllPermission> {
        public static final AtAllPermission ALL_MEMBERS = null;
        public static final AtAllPermission ONLY_OWNER = null;
        public static final AtAllPermission UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AtAllPermission[] f415119a = null;
        private final int value;

        static {
            AtAllPermission r100 = new AtAllPermission("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            AtAllPermission r101 = new AtAllPermission("ALL_MEMBERS", 1, 1);
            ALL_MEMBERS = r101;
            AtAllPermission r102 = new AtAllPermission("ONLY_OWNER", 2, 2);
            ONLY_OWNER = r102;
            f415119a = new AtAllPermission[]{r100, r101, r102};
        }

        public static AtAllPermission[] values() {
            return (AtAllPermission[]) f415119a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static AtAllPermission forNumber(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return UNKNOWN;
        L10:
            return ONLY_OWNER;
        L12:
            return ALL_MEMBERS;
        L14:
            return UNKNOWN;
        }

        public static AtAllPermission valueOf(String r100) {
            return (AtAllPermission) r27.a.a(AtAllPermission.class, r100);
        }

        public static AtAllPermission valueOf(int r100) {
            return forNumber(r100);
        }

        public AtAllPermission(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum BuzzPermissionSetting extends Enum<BuzzPermissionSetting> {
        public static final BuzzPermissionSetting ALL_MEMBERS = null;
        public static final BuzzPermissionSetting ONLY_MANAGER = null;
        public static final BuzzPermissionSetting UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BuzzPermissionSetting[] f415120a = null;
        private final int value;

        static {
            BuzzPermissionSetting r100 = new BuzzPermissionSetting("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            BuzzPermissionSetting r101 = new BuzzPermissionSetting("ALL_MEMBERS", 1, 1);
            ALL_MEMBERS = r101;
            BuzzPermissionSetting r102 = new BuzzPermissionSetting("ONLY_MANAGER", 2, 2);
            ONLY_MANAGER = r102;
            f415120a = new BuzzPermissionSetting[]{r100, r101, r102};
        }

        public static BuzzPermissionSetting[] values() {
            return (BuzzPermissionSetting[]) f415120a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static BuzzPermissionSetting forNumber(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return UNKNOWN;
        L9:
            return ONLY_MANAGER;
        L11:
            return ALL_MEMBERS;
        }

        public static BuzzPermissionSetting valueOf(String r100) {
            return (BuzzPermissionSetting) r27.a.a(BuzzPermissionSetting.class, r100);
        }

        public static BuzzPermissionSetting valueOf(int r100) {
            return forNumber(r100);
        }

        public BuzzPermissionSetting(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum ChatMode extends Enum<ChatMode> {
        public static final ChatMode DEFAULT = null;
        public static final ChatMode THREAD = null;
        public static final ChatMode THREAD_V2 = null;
        public static final ChatMode UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ChatMode[] f415121a = null;
        private final int value;

        static {
            ChatMode r100 = new ChatMode("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            ChatMode r101 = new ChatMode("DEFAULT", 1, 1);
            DEFAULT = r101;
            ChatMode r102 = new ChatMode("THREAD", 2, 2);
            THREAD = r102;
            ChatMode r103 = new ChatMode("THREAD_V2", 3, 3);
            THREAD_V2 = r103;
            f415121a = new ChatMode[]{r100, r101, r102, r103};
        }

        public static ChatMode[] values() {
            return (ChatMode[]) f415121a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static ChatMode forNumber(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return UNKNOWN;
        L11:
            return THREAD_V2;
        L13:
            return THREAD;
        L15:
            return DEFAULT;
        }

        public static ChatMode valueOf(String r100) {
            return (ChatMode) r27.a.a(ChatMode.class, r100);
        }

        public static ChatMode valueOf(int r100) {
            return forNumber(r100);
        }

        public ChatMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum ChatPinPermissionSetting extends Enum<ChatPinPermissionSetting> {
        public static final ChatPinPermissionSetting ALL_MEMBERS = null;
        public static final ChatPinPermissionSetting ONLY_MANAGER = null;
        public static final ChatPinPermissionSetting UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ChatPinPermissionSetting[] f415122a = null;
        private final int value;

        static {
            ChatPinPermissionSetting r100 = new ChatPinPermissionSetting("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            ChatPinPermissionSetting r101 = new ChatPinPermissionSetting("ALL_MEMBERS", 1, 1);
            ALL_MEMBERS = r101;
            ChatPinPermissionSetting r102 = new ChatPinPermissionSetting("ONLY_MANAGER", 2, 2);
            ONLY_MANAGER = r102;
            f415122a = new ChatPinPermissionSetting[]{r100, r101, r102};
        }

        public static ChatPinPermissionSetting[] values() {
            return (ChatPinPermissionSetting[]) f415122a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static ChatPinPermissionSetting forNumber(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return UNKNOWN;
        L9:
            return ONLY_MANAGER;
        L11:
            return ALL_MEMBERS;
        }

        public static ChatPinPermissionSetting valueOf(String r100) {
            return (ChatPinPermissionSetting) r27.a.a(ChatPinPermissionSetting.class, r100);
        }

        public static ChatPinPermissionSetting valueOf(int r100) {
            return forNumber(r100);
        }

        public ChatPinPermissionSetting(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum ChatTabPermissionSetting extends Enum<ChatTabPermissionSetting> {
        public static final ChatTabPermissionSetting ALL_MEMBERS = null;
        public static final ChatTabPermissionSetting ONLY_MANAGER = null;
        public static final ChatTabPermissionSetting UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ChatTabPermissionSetting[] f415123a = null;
        private final int value;

        static {
            ChatTabPermissionSetting r100 = new ChatTabPermissionSetting("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            ChatTabPermissionSetting r101 = new ChatTabPermissionSetting("ALL_MEMBERS", 1, 1);
            ALL_MEMBERS = r101;
            ChatTabPermissionSetting r102 = new ChatTabPermissionSetting("ONLY_MANAGER", 2, 2);
            ONLY_MANAGER = r102;
            f415123a = new ChatTabPermissionSetting[]{r100, r101, r102};
        }

        public static ChatTabPermissionSetting[] values() {
            return (ChatTabPermissionSetting[]) f415123a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static ChatTabPermissionSetting forNumber(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return UNKNOWN;
        L9:
            return ONLY_MANAGER;
        L11:
            return ALL_MEMBERS;
        }

        public static ChatTabPermissionSetting valueOf(String r100) {
            return (ChatTabPermissionSetting) r27.a.a(ChatTabPermissionSetting.class, r100);
        }

        public static ChatTabPermissionSetting valueOf(int r100) {
            return forNumber(r100);
        }

        public ChatTabPermissionSetting(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum CreateVideoConferenceSetting extends Enum<CreateVideoConferenceSetting> {
        public static final CreateVideoConferenceSetting ALL_MEMBERS = null;
        public static final CreateVideoConferenceSetting ONLY_MANAGER = null;
        public static final CreateVideoConferenceSetting UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CreateVideoConferenceSetting[] f415124a = null;
        private final int value;

        static {
            CreateVideoConferenceSetting r100 = new CreateVideoConferenceSetting("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            CreateVideoConferenceSetting r101 = new CreateVideoConferenceSetting("ALL_MEMBERS", 1, 1);
            ALL_MEMBERS = r101;
            CreateVideoConferenceSetting r102 = new CreateVideoConferenceSetting("ONLY_MANAGER", 2, 2);
            ONLY_MANAGER = r102;
            f415124a = new CreateVideoConferenceSetting[]{r100, r101, r102};
        }

        public static CreateVideoConferenceSetting[] values() {
            return (CreateVideoConferenceSetting[]) f415124a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static CreateVideoConferenceSetting forNumber(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return UNKNOWN;
        L9:
            return ONLY_MANAGER;
        L11:
            return ALL_MEMBERS;
        }

        public static CreateVideoConferenceSetting valueOf(String r100) {
            return (CreateVideoConferenceSetting) r27.a.a(CreateVideoConferenceSetting.class, r100);
        }

        public static CreateVideoConferenceSetting valueOf(int r100) {
            return forNumber(r100);
        }

        public CreateVideoConferenceSetting(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum DefaultDisplaySetting extends Enum<DefaultDisplaySetting> {
        public static final DefaultDisplaySetting CHAT_MENU = null;
        public static final DefaultDisplaySetting INPUT_BOX = null;
        public static final DefaultDisplaySetting UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DefaultDisplaySetting[] f415125a = null;
        private final int value;

        static {
            DefaultDisplaySetting r100 = new DefaultDisplaySetting("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            DefaultDisplaySetting r101 = new DefaultDisplaySetting("INPUT_BOX", 1, 1);
            INPUT_BOX = r101;
            DefaultDisplaySetting r102 = new DefaultDisplaySetting("CHAT_MENU", 2, 2);
            CHAT_MENU = r102;
            f415125a = new DefaultDisplaySetting[]{r100, r101, r102};
        }

        public static DefaultDisplaySetting[] values() {
            return (DefaultDisplaySetting[]) f415125a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static DefaultDisplaySetting forNumber(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return UNKNOWN;
        L9:
            return CHAT_MENU;
        L11:
            return INPUT_BOX;
        }

        public static DefaultDisplaySetting valueOf(String r100) {
            return (DefaultDisplaySetting) r27.a.a(DefaultDisplaySetting.class, r100);
        }

        public static DefaultDisplaySetting valueOf(int r100) {
            return forNumber(r100);
        }

        public DefaultDisplaySetting(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static class DoubaoSetting implements Serializable {
        private boolean doubaoProactiveReplyEnabled;
        private boolean doubaoUsingEnabled;

        public DoubaoSetting() {
            this.doubaoUsingEnabled = true;
            this.doubaoProactiveReplyEnabled = false;
        }

        public boolean isDoubaoProactiveReplyEnabled() {
            return this.doubaoProactiveReplyEnabled;
        }

        public boolean isDoubaoUsingEnabled() {
            return this.doubaoUsingEnabled;
        }

        public static DoubaoSetting from(com.bytedance.lark.pb.basic.v1.Chat.DoubaoSetting r100) {
            DoubaoSetting r101 = new DoubaoSetting();
            if (r100 == null) goto L5;
            r101.doubaoUsingEnabled = r100.doubao_using_enabled.booleanValue();
            r101.doubaoProactiveReplyEnabled = r100.doubao_proactive_reply_enabled.booleanValue();
        L5:
            return r101;
        }

        public void setDoubaoProactiveReplyEnabled(boolean r100) {
            this.doubaoProactiveReplyEnabled = r100;
        }

        public void setDoubaoUsingEnabled(boolean r100) {
            this.doubaoUsingEnabled = r100;
        }
    }

    public static final enum GroupMailSendPermissionType extends Enum<GroupMailSendPermissionType> {
        public static final GroupMailSendPermissionType ANYONE = null;
        public static final GroupMailSendPermissionType ONLY_ADMIN = null;
        public static final GroupMailSendPermissionType ONLY_MEMBER = null;
        public static final GroupMailSendPermissionType ONLY_TENANT = null;
        public static final GroupMailSendPermissionType UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ GroupMailSendPermissionType[] f415126a = null;
        private final int value;

        static {
            GroupMailSendPermissionType r100 = new GroupMailSendPermissionType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            GroupMailSendPermissionType r101 = new GroupMailSendPermissionType("ONLY_ADMIN", 1, 1);
            ONLY_ADMIN = r101;
            GroupMailSendPermissionType r102 = new GroupMailSendPermissionType("ONLY_MEMBER", 2, 2);
            ONLY_MEMBER = r102;
            GroupMailSendPermissionType r103 = new GroupMailSendPermissionType("ONLY_TENANT", 3, 3);
            ONLY_TENANT = r103;
            GroupMailSendPermissionType r104 = new GroupMailSendPermissionType("ANYONE", 4, 4);
            ANYONE = r104;
            f415126a = new GroupMailSendPermissionType[]{r100, r101, r102, r103, r104};
        }

        public static GroupMailSendPermissionType[] values() {
            return (GroupMailSendPermissionType[]) f415126a.clone();
        }

        public String getDisplay() {
            int r100 = getNumber();
            if (r100 != 1) goto L5;
            return "AdminOnly";
        L5:
            if (r100 != 2) goto L7;
            return "GroupMember";
        L7:
            if (r100 != 3) goto L9;
            return "Tenant";
        L9:
            if (r100 == 4) goto L12;
            return "UNKNOWN";
        L12:
            return CancelRetainContactInfoFunctions.All;
        }

        public int getNumber() {
            return this.value;
        }

        public static GroupMailSendPermissionType forNumber(int r100) {
            if (r100 == 1) goto L19;
            if (r100 == 2) goto L17;
            if (r100 == 3) goto L15;
            if (r100 == 4) goto L13;
            return UNKNOWN;
        L13:
            return ANYONE;
        L15:
            return ONLY_TENANT;
        L17:
            return ONLY_MEMBER;
        L19:
            return ONLY_ADMIN;
        }

        public static GroupMailSendPermissionType valueOf(String r100) {
            return (GroupMailSendPermissionType) r27.a.a(GroupMailSendPermissionType.class, r100);
        }

        public static GroupMailSendPermissionType valueOf(int r100) {
            return forNumber(r100);
        }

        public GroupMailSendPermissionType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum MessagePosition extends Enum<MessagePosition> {
        public static final MessagePosition NEWEST_UNREAD = null;
        public static final MessagePosition RECENT_LEFT = null;
        public static final MessagePosition UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MessagePosition[] f415127a = null;
        private final int value;

        static {
            MessagePosition r100 = new MessagePosition("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            MessagePosition r101 = new MessagePosition("RECENT_LEFT", 1, 1);
            RECENT_LEFT = r101;
            MessagePosition r102 = new MessagePosition("NEWEST_UNREAD", 2, 2);
            NEWEST_UNREAD = r102;
            f415127a = new MessagePosition[]{r100, r101, r102};
        }

        public static MessagePosition[] values() {
            return (MessagePosition[]) f415127a.clone();
        }

        public String desc() {
            int r100 = this.value;
            if (r100 != 1) goto L5;
            return "RECENT_LEFT";
        L5:
            if (r100 == 2) goto L8;
            return "UNKNOWN";
        L8:
            return "NEWEST_UNREAD";
        }

        public int getNumber() {
            return this.value;
        }

        public static MessagePosition forNumber(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return UNKNOWN;
        L10:
            return NEWEST_UNREAD;
        L12:
            return RECENT_LEFT;
        L14:
            return UNKNOWN;
        }

        public static MessagePosition valueOf(String r100) {
            return (MessagePosition) r27.a.a(MessagePosition.class, r100);
        }

        public static MessagePosition valueOf(int r100) {
            return forNumber(r100);
        }

        public MessagePosition(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum MessageVisibilitySetting extends Enum<MessageVisibilitySetting> {
        public static final MessageVisibilitySetting ALL_MESSAGES = null;
        public static final MessageVisibilitySetting ONLY_NEW_MESSAGES = null;
        public static final MessageVisibilitySetting UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MessageVisibilitySetting[] f415128a = null;
        private final int value;

        static {
            MessageVisibilitySetting r100 = new MessageVisibilitySetting("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            MessageVisibilitySetting r101 = new MessageVisibilitySetting("ALL_MESSAGES", 1, 1);
            ALL_MESSAGES = r101;
            MessageVisibilitySetting r102 = new MessageVisibilitySetting("ONLY_NEW_MESSAGES", 2, 2);
            ONLY_NEW_MESSAGES = r102;
            f415128a = new MessageVisibilitySetting[]{r100, r101, r102};
        }

        public static MessageVisibilitySetting[] values() {
            return (MessageVisibilitySetting[]) f415128a.clone();
        }

        public static MessageVisibilitySetting forNumber(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return UNKNOWN;
        L9:
            return ONLY_NEW_MESSAGES;
        L11:
            return ALL_MESSAGES;
        }

        public static MessageVisibilitySetting valueOf(String r100) {
            return (MessageVisibilitySetting) r27.a.a(MessageVisibilitySetting.class, r100);
        }

        public static MessageVisibilitySetting valueOf(int r100) {
            return forNumber(r100);
        }

        public MessageVisibilitySetting(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum PinPermissionSetting extends Enum<PinPermissionSetting> {
        public static final PinPermissionSetting ALL_MEMBERS = null;
        public static final PinPermissionSetting ONLY_MANAGER = null;
        public static final PinPermissionSetting UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PinPermissionSetting[] f415129a = null;
        private final int value;

        static {
            PinPermissionSetting r100 = new PinPermissionSetting("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            PinPermissionSetting r101 = new PinPermissionSetting("ALL_MEMBERS", 1, 1);
            ALL_MEMBERS = r101;
            PinPermissionSetting r102 = new PinPermissionSetting("ONLY_MANAGER", 2, 2);
            ONLY_MANAGER = r102;
            f415129a = new PinPermissionSetting[]{r100, r101, r102};
        }

        public static PinPermissionSetting[] values() {
            return (PinPermissionSetting[]) f415129a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static PinPermissionSetting forNumber(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return UNKNOWN;
        L9:
            return ONLY_MANAGER;
        L11:
            return ALL_MEMBERS;
        }

        public static PinPermissionSetting valueOf(String r100) {
            return (PinPermissionSetting) r27.a.a(PinPermissionSetting.class, r100);
        }

        public static PinPermissionSetting valueOf(int r100) {
            return forNumber(r100);
        }

        public PinPermissionSetting(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum PostType extends Enum<PostType> {
        public static final PostType ANYONE = null;
        public static final PostType ONLY_ADMIN = null;
        public static final PostType UNKNOWN_POST_TYPE = null;
        public static final PostType WHITE_LIST = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PostType[] f415130a = null;
        private final int value;

        static {
            PostType r100 = new PostType("UNKNOWN_POST_TYPE", 0, 0);
            UNKNOWN_POST_TYPE = r100;
            PostType r101 = new PostType("ANYONE", 1, 1);
            ANYONE = r101;
            PostType r102 = new PostType("ONLY_ADMIN", 2, 2);
            ONLY_ADMIN = r102;
            PostType r103 = new PostType("WHITE_LIST", 3, 3);
            WHITE_LIST = r103;
            f415130a = new PostType[]{r100, r101, r102, r103};
        }

        public static PostType[] values() {
            return (PostType[]) f415130a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static PostType forNumber(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return UNKNOWN_POST_TYPE;
        L11:
            return WHITE_LIST;
        L13:
            return ONLY_ADMIN;
        L15:
            return ANYONE;
        }

        public static PostType valueOf(String r100) {
            return (PostType) r27.a.a(PostType.class, r100);
        }

        public static PostType valueOf(int r100) {
            return forNumber(r100);
        }

        public PostType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static class RestrictedModeSetting implements Serializable {
        private Participant copy;
        private Participant download;
        private Participant forward;
        private OnTimeDelMsgSetting onTimeDelMsgSetting;
        private Participant screenshot;
        private boolean switch_;
        private RestrictedWhiteListSetting whiteListSetting;

        public static class OnTimeDelMsgSetting implements Serializable {
            private long aliveTime;
            private boolean status;

            public OnTimeDelMsgSetting() {
            }

            public long getAliveTime() {
                return this.aliveTime;
            }

            public boolean getStatus() {
                return this.status;
            }

            public void setAliveTime(long r100) {
                this.aliveTime = r100;
            }

            public void setStatus(boolean r100) {
                this.status = r100;
            }
        }

        public static final enum Participant extends Enum<Participant> {
            public static final Participant ALL_MEMBERS = null;
            public static final Participant NO_MEMBER = null;
            public static final Participant UNKNOWN = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Participant[] f415131a = null;
            private final int value;

            static {
                Participant r100 = new Participant("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Participant r101 = new Participant("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r101;
                Participant r102 = new Participant("NO_MEMBER", 2, 2);
                NO_MEMBER = r102;
                f415131a = new Participant[]{r100, r101, r102};
            }

            public static Participant[] values() {
                return (Participant[]) f415131a.clone();
            }

            public int getNumber() {
                return this.value;
            }

            public static Participant forNumber(int r100) {
                if (r100 == 1) goto L11;
                if (r100 == 2) goto L9;
                return UNKNOWN;
            L9:
                return NO_MEMBER;
            L11:
                return ALL_MEMBERS;
            }

            public static Participant valueOf(String r100) {
                return (Participant) r27.a.a(Participant.class, r100);
            }

            public static Participant valueOf(int r100) {
                return forNumber(r100);
            }

            public Participant(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public RestrictedModeSetting() {
            this.switch_ = false;
            Participant r100 = Participant.NO_MEMBER;
            this.copy = r100;
            this.forward = r100;
            this.download = r100;
            this.screenshot = r100;
        }

        public Participant getCopy() {
            return this.copy;
        }

        public Participant getDownload() {
            return this.download;
        }

        public Participant getForward() {
            return this.forward;
        }

        public OnTimeDelMsgSetting getOnTimeDelMsgSetting() {
            return this.onTimeDelMsgSetting;
        }

        public Participant getScreenshot() {
            return this.screenshot;
        }

        public boolean getSwitch() {
            return this.switch_;
        }

        public RestrictedWhiteListSetting getWhiteListSetting() {
            return this.whiteListSetting;
        }

        public void setCopy(Participant r100) {
            this.copy = r100;
        }

        public void setDownload(Participant r100) {
            this.download = r100;
        }

        public void setForward(Participant r100) {
            this.forward = r100;
        }

        public void setOnTimeDelMsgSetting(OnTimeDelMsgSetting r100) {
            this.onTimeDelMsgSetting = r100;
        }

        public void setScreenshot(Participant r100) {
            this.screenshot = r100;
        }

        public void setSwitch(boolean r100) {
            this.switch_ = r100;
        }

        public void setWhiteListSetting(RestrictedWhiteListSetting r100) {
            this.whiteListSetting = r100;
        }
    }

    public static class RestrictedWhiteListSetting implements Serializable {
        private boolean hitWhiteList;
        private LevelEnum level;
        private LinkedList<Long> memberListUserIds;

        public static final enum LevelEnum extends Enum<LevelEnum> {
            public static final LevelEnum MEMBER_LIST = null;
            public static final LevelEnum NO_MEMBER = null;
            public static final LevelEnum ONLY_ADMIN_AND_OWNER = null;
            public static final LevelEnum UNKNOWN = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ LevelEnum[] f415132a = null;
            private final int value;

            static {
                LevelEnum r100 = new LevelEnum("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                LevelEnum r101 = new LevelEnum("NO_MEMBER", 1, 1);
                NO_MEMBER = r101;
                LevelEnum r102 = new LevelEnum("ONLY_ADMIN_AND_OWNER", 2, 2);
                ONLY_ADMIN_AND_OWNER = r102;
                LevelEnum r103 = new LevelEnum("MEMBER_LIST", 3, 3);
                MEMBER_LIST = r103;
                f415132a = new LevelEnum[]{r100, r101, r102, r103};
            }

            public static LevelEnum[] values() {
                return (LevelEnum[]) f415132a.clone();
            }

            public int getNumber() {
                return this.value;
            }

            public static LevelEnum forNumber(int r100) {
                if (r100 == 1) goto L15;
                if (r100 == 2) goto L13;
                if (r100 == 3) goto L11;
                return UNKNOWN;
            L11:
                return MEMBER_LIST;
            L13:
                return ONLY_ADMIN_AND_OWNER;
            L15:
                return NO_MEMBER;
            }

            public static LevelEnum valueOf(String r100) {
                return (LevelEnum) r27.a.a(LevelEnum.class, r100);
            }

            public static LevelEnum valueOf(int r100) {
                return forNumber(r100);
            }

            public LevelEnum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public RestrictedWhiteListSetting() {
            this.level = LevelEnum.UNKNOWN;
        }

        public LevelEnum getLevel() {
            return this.level;
        }

        public LinkedList<Long> getMemberListUserIds() {
            return this.memberListUserIds;
        }

        public boolean isHitWhiteList() {
            return this.hitWhiteList;
        }

        public void setHitWhiteList(boolean r100) {
            this.hitWhiteList = r100;
        }

        public void setLevel(LevelEnum r100) {
            this.level = r100;
        }

        public void setMemberListUserIds(LinkedList<Long> r100) {
            this.memberListUserIds = r100;
        }
    }

    public static final enum Role extends Enum<Role> {
        public static final Role IGNORE = null;
        public static final Role MEMBER = null;
        public static final Role THREAD_FOLLOWER = null;
        public static final Role VISITOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Role[] f415133a = null;
        private final int value;

        static {
            Role r100 = new Role("IGNORE", 0, 0);
            IGNORE = r100;
            Role r101 = new Role("MEMBER", 1, 1);
            MEMBER = r101;
            Role r102 = new Role("VISITOR", 2, 2);
            VISITOR = r102;
            Role r103 = new Role("THREAD_FOLLOWER", 3, 3);
            THREAD_FOLLOWER = r103;
            f415133a = new Role[]{r100, r101, r102, r103};
        }

        public static Role[] values() {
            return (Role[]) f415133a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static Role forNumber(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return IGNORE;
        L12:
            return THREAD_FOLLOWER;
        L14:
            return VISITOR;
        L16:
            return MEMBER;
        L18:
            return IGNORE;
        }

        public static Role valueOf(String r100) {
            return (Role) r27.a.a(Role.class, r100);
        }

        public static Role valueOf(int r100) {
            return forNumber(r100);
        }

        public Role(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum ShareCardPermission extends Enum<ShareCardPermission> {
        public static final ShareCardPermission ALLOWED = null;
        public static final ShareCardPermission NOT_ALLOWED = null;
        public static final ShareCardPermission UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ShareCardPermission[] f415134a = null;
        private final int value;

        static {
            ShareCardPermission r100 = new ShareCardPermission("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            ShareCardPermission r101 = new ShareCardPermission("ALLOWED", 1, 1);
            ALLOWED = r101;
            ShareCardPermission r102 = new ShareCardPermission("NOT_ALLOWED", 2, 2);
            NOT_ALLOWED = r102;
            f415134a = new ShareCardPermission[]{r100, r101, r102};
        }

        public static ShareCardPermission[] values() {
            return (ShareCardPermission[]) f415134a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static ShareCardPermission forNumber(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return UNKNOWN;
        L10:
            return NOT_ALLOWED;
        L12:
            return ALLOWED;
        L14:
            return UNKNOWN;
        }

        public static ShareCardPermission valueOf(String r100) {
            return (ShareCardPermission) r27.a.a(ShareCardPermission.class, r100);
        }

        public static ShareCardPermission valueOf(int r100) {
            return forNumber(r100);
        }

        public ShareCardPermission(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum Status extends Enum<Status> {
        public static final Status ARCHIVE = null;
        public static final Status DELETED = null;
        public static final Status NORMAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Status[] f415135a = null;
        private final int value;

        static {
            Status r100 = new Status(EffectConstants.NORMAL, 0, 0);
            NORMAL = r100;
            Status r101 = new Status("ARCHIVE", 1, 1);
            ARCHIVE = r101;
            Status r102 = new Status("DELETED", 2, 2);
            DELETED = r102;
            f415135a = new Status[]{r100, r101, r102};
        }

        public static Status[] values() {
            return (Status[]) f415135a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static Status forNumber(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return NORMAL;
        L10:
            return DELETED;
        L12:
            return ARCHIVE;
        L14:
            return NORMAL;
        }

        public static Status valueOf(String r100) {
            return (Status) r27.a.a(Status.class, r100);
        }

        public static Status valueOf(int r100) {
            return forNumber(r100);
        }

        public Status(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum SystemMessageVisible extends Enum<SystemMessageVisible> {
        public static final SystemMessageVisible ALL_MEMBERS = null;
        public static final SystemMessageVisible NOT_ANYONE = null;
        public static final SystemMessageVisible ONLY_OWNER = null;
        public static final SystemMessageVisible UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SystemMessageVisible[] f415136a = null;
        private final int value;

        static {
            SystemMessageVisible r100 = new SystemMessageVisible("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            SystemMessageVisible r101 = new SystemMessageVisible("ONLY_OWNER", 1, 1);
            ONLY_OWNER = r101;
            SystemMessageVisible r102 = new SystemMessageVisible("ALL_MEMBERS", 2, 2);
            ALL_MEMBERS = r102;
            SystemMessageVisible r103 = new SystemMessageVisible("NOT_ANYONE", 3, 3);
            NOT_ANYONE = r103;
            f415136a = new SystemMessageVisible[]{r100, r101, r102, r103};
        }

        public static SystemMessageVisible[] values() {
            return (SystemMessageVisible[]) f415136a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static SystemMessageVisible forNumber(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return UNKNOWN;
        L12:
            return NOT_ANYONE;
        L14:
            return ALL_MEMBERS;
        L16:
            return ONLY_OWNER;
        L18:
            return UNKNOWN;
        }

        public static SystemMessageVisible valueOf(String r100) {
            return (SystemMessageVisible) r27.a.a(SystemMessageVisible.class, r100);
        }

        public static SystemMessageVisible valueOf(int r100) {
            return forNumber(r100);
        }

        public SystemMessageVisible(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum TopNoticePermissionSetting extends Enum<TopNoticePermissionSetting> {
        public static final TopNoticePermissionSetting ALL_MEMBER = null;
        public static final TopNoticePermissionSetting ONLY_MANAGER = null;
        public static final TopNoticePermissionSetting UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TopNoticePermissionSetting[] f415137a = null;
        private final int value;

        static {
            TopNoticePermissionSetting r100 = new TopNoticePermissionSetting("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            TopNoticePermissionSetting r101 = new TopNoticePermissionSetting("ALL_MEMBER", 1, 1);
            ALL_MEMBER = r101;
            TopNoticePermissionSetting r102 = new TopNoticePermissionSetting("ONLY_MANAGER", 2, 2);
            ONLY_MANAGER = r102;
            f415137a = new TopNoticePermissionSetting[]{r100, r101, r102};
        }

        public static TopNoticePermissionSetting[] values() {
            return (TopNoticePermissionSetting[]) f415137a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static TopNoticePermissionSetting fromValue(int r100) {
            TopNoticePermissionSetting[] r101 = values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L9;
            TopNoticePermissionSetting r104 = r101[r103];
            if (r104.value == r100) goto L6;
            r103 = r103 + 1;
            goto L3
        L6:
            return r104;
        L9:
            return UNKNOWN;
        }

        public static TopNoticePermissionSetting valueOf(String r100) {
            return (TopNoticePermissionSetting) r27.a.a(TopNoticePermissionSetting.class, r100);
        }

        public TopNoticePermissionSetting(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum Type extends Enum<Type> {
        public static final Type GROUP = null;
        public static final Type P2P = null;
        public static final Type THREAD_DETAIL = null;
        public static final Type TOPIC_GROUP = null;
        public static final Type UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f415138a = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type("P2P", 1, 1);
            P2P = r101;
            Type r102 = new Type("GROUP", 2, 2);
            GROUP = r102;
            Type r103 = new Type("TOPIC_GROUP", 3, 3);
            TOPIC_GROUP = r103;
            Type r104 = new Type("THREAD_DETAIL", 4, 4);
            THREAD_DETAIL = r104;
            f415138a = new Type[]{r100, r101, r102, r103, r104};
        }

        public static Type[] values() {
            return (Type[]) f415138a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static Type forNumber(int r100) {
            if (r100 == 1) goto L19;
            if (r100 == 2) goto L17;
            if (r100 == 3) goto L15;
            if (r100 == 4) goto L13;
            return UNKNOWN;
        L13:
            return THREAD_DETAIL;
        L15:
            return TOPIC_GROUP;
        L17:
            return GROUP;
        L19:
            return P2P;
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public static Type valueOf(int r100) {
            return forNumber(r100);
        }

        public Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static class TypingTranslateSetting implements Serializable {
        private boolean canAutoOpenV3;
        private boolean isOpen;
        private LanguageInfo languageInfo;
        private com.bytedance.lark.pb.basic.v1.Chat.TypingTranslateSetting.OpenMode openMode;
        private boolean translateWithOrigin;
        private long updateTime;

        public int hashCode() {
            return Objects.hash(new Object[]{Boolean.valueOf(this.isOpen), this.languageInfo, Boolean.valueOf(this.translateWithOrigin), Boolean.valueOf(this.canAutoOpenV3), this.openMode});
        }

        public TypingTranslateSetting() {
            this.canAutoOpenV3 = false;
            this.openMode = com.bytedance.lark.pb.basic.v1.Chat.TypingTranslateSetting.OpenMode.MANUAL;
        }

        public boolean getIsOpen() {
            return this.isOpen;
        }

        public LanguageInfo getLanguageInfo() {
            return this.languageInfo;
        }

        public com.bytedance.lark.pb.basic.v1.Chat.TypingTranslateSetting.OpenMode getOpenMode() {
            return this.openMode;
        }

        public long getUpdateTime() {
            return this.updateTime;
        }

        public boolean isCanAutoOpenV3() {
            return this.canAutoOpenV3;
        }

        public boolean isTranslateWithOrigin() {
            return this.translateWithOrigin;
        }

        public static TypingTranslateSetting from(com.bytedance.lark.pb.basic.v1.Chat.TypingTranslateSetting r100) {
            TypingTranslateSetting r101 = new TypingTranslateSetting();
            if (r100 != null) goto L5;
            return r101;
        L5:
            r101.isOpen = r100.is_open.booleanValue();
            String r102 = r100.target_language;
            r101.languageInfo = new LanguageInfo(r102, r102);
            r101.translateWithOrigin = r100.enable_use_translated_original.booleanValue();
            r101.updateTime = r100.update_time_ns.longValue();
            r101.canAutoOpenV3 = r100.can_auto_open_v3.booleanValue();
            r101.openMode = r100.open_mode;
            return r101;
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof TypingTranslateSetting) == true) goto L5;
            return false;
        L5:
            TypingTranslateSetting r101 = (TypingTranslateSetting) r100;
            if (this.isOpen != r101.isOpen) goto L8;
            boolean r102 = true;
        L10:
            if (this.translateWithOrigin != r101.translateWithOrigin) goto L12;
            boolean r103 = true;
        L14:
            if (this.canAutoOpenV3 != r101.canAutoOpenV3) goto L16;
            boolean r104 = true;
        L18:
            if (this.openMode != r101.openMode) goto L20;
            boolean r105 = true;
        L21:
            LanguageInfo r106 = this.languageInfo;
            LanguageInfo r107 = r101.languageInfo;
            if (r106 != null) goto L25;
            if (r107 != null) goto L25;
            return r102;
        L25:
            if (r103 == false) goto L35;
            if (r102 == false) goto L36;
            if (r104 == false) goto L37;
            if (r105 == false) goto L38;
            if (r106 == null) goto L39;
            if (r107 != null) goto L32;
            return false;
        L32:
            if (Objects.equals(r106.getKey(), r107.getKey()) == false) goto L41;
            return true;
        L41:
            return false;
        L39:
            return false;
        L38:
            return false;
        L37:
            return false;
        L36:
            return false;
        L35:
            return false;
        L20:
            r105 = false;
            goto L21
        L16:
            r104 = false;
            goto L18
        L12:
            r103 = false;
            goto L14
        L8:
            r102 = false;
            goto L10
        }

        public void setCanAutoOpenV3(boolean r100) {
            this.canAutoOpenV3 = r100;
        }

        public void setIsOpen(boolean r100) {
            this.isOpen = r100;
        }

        public void setLanguageInfo(LanguageInfo r100) {
            this.languageInfo = r100;
        }

        public void setOpenMode(com.bytedance.lark.pb.basic.v1.Chat.TypingTranslateSetting.OpenMode r100) {
            this.openMode = r100;
        }

        public void setTranslateWithOrigin(boolean r100) {
            this.translateWithOrigin = r100;
        }

        public void setUpdateTime(long r100) {
            this.updateTime = r100;
        }
    }

    public static final enum UserCountVisibleSetting extends Enum<UserCountVisibleSetting> implements Serializable {
        public static final UserCountVisibleSetting ALL_MEMBERS = null;
        public static final UserCountVisibleSetting ONLY_MANAGER = null;
        public static final UserCountVisibleSetting UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ UserCountVisibleSetting[] f415139a = null;
        private final int value;

        static {
            UserCountVisibleSetting r100 = new UserCountVisibleSetting("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            UserCountVisibleSetting r101 = new UserCountVisibleSetting("ALL_MEMBERS", 1, 1);
            ALL_MEMBERS = r101;
            UserCountVisibleSetting r102 = new UserCountVisibleSetting("ONLY_MANAGER", 2, 2);
            ONLY_MANAGER = r102;
            f415139a = new UserCountVisibleSetting[]{r100, r101, r102};
        }

        public static UserCountVisibleSetting[] values() {
            return (UserCountVisibleSetting[]) f415139a.clone();
        }

        public String toDescString() {
            int r100 = this.value;
            if (r100 != 1) goto L5;
            return "ALL_MEMBERS";
        L5:
            if (r100 == 2) goto L8;
            return "UNKNOWN";
        L8:
            return "ONLY_MANAGER";
        }

        public int getNumber() {
            return this.value;
        }

        public static UserCountVisibleSetting forNumber(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return UNKNOWN;
        L9:
            return ONLY_MANAGER;
        L11:
            return ALL_MEMBERS;
        }

        public static UserCountVisibleSetting valueOf(String r100) {
            return (UserCountVisibleSetting) r27.a.a(UserCountVisibleSetting.class, r100);
        }

        public static UserCountVisibleSetting valueOf(int r100) {
            return forNumber(r100);
        }

        public UserCountVisibleSetting(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public boolean canSeeHistoryMessage() {
        if (this.mMessageVisibilitySetting != MessageVisibilitySetting.ALL_MESSAGES) goto L5;
        return true;
    L5:
        return false;
    }

    public String getEntityId() {
        if (this.type != Type.P2P) goto L7;
        return getP2pChatterId();
    L7:
        return getId();
    }

    public int getNewMessageCount() {
        return this.lastMessagePosition - this.readPosition;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public String getP2pChatterId() {
        String r100 = this.p2pChatterId;
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100;
    }

    public int getThreadUnReadBadgeCount() {
        return Math.min(this.lastThreadPositionBadgeCount - this.readThreadPositionBadgeCount, this.lastThreadPosition - this.readThreadPosition);
    }

    public int getUnReadBadgeCount() {
        return Math.min(this.lastMessagePositionBadgeCount - this.readPositionBadgeCount, this.lastMessagePosition - this.readPosition);
    }

    public int getUnReadMessageCount() {
        return this.lastMessagePosition - this.readPosition;
    }

    public boolean isAnonymousSecret() {
        if (this.isSecret == false) goto L9;
        AnonymousSetting r100 = this.mAnonymousSetting;
        if (r100 != AnonymousSetting.ALLOWED) goto L7;
    L8:
        return true;
    L7:
        if (r100 == AnonymousSetting.INVISIBLE_ALLOWED) goto L8;
    L9:
        return false;
    }

    public boolean isDeleted() {
        if (this.status != Status.DELETED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public boolean isGroup() {
        if (this.type != Type.GROUP) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public boolean isMember() {
        if (this.role != Role.MEMBER) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public boolean isOnCall() {
        if (TextUtils.isEmpty(this.onCallId) == false) goto L5;
    L7:
        return false;
    L5:
        if (CastLongProtector.parseLong(this.onCallId) == 0) goto L7;
        return true;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public boolean isOnlyManagerCreateVC() {
        if (this.createVideoConferenceSetting != CreateVideoConferenceSetting.ONLY_MANAGER) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isThread() {
        ChatMode r100 = this.chatMode;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100 != ChatMode.THREAD_V2) goto L7;
        return true;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("Chat{id='");
        r100.append(this.f415114id);
        r100.append("', isSecret=");
        r100.append(this.isSecret);
        r100.append(", uCount=");
        r100.append(this.userCount);
        r100.append(", isUserCountVisible=");
        r100.append(this.isUserCountVisible);
        r100.append(", lastMsgId=");
        r100.append(this.lastMessageId);
        r100.append(", lastMsgPos=");
        r100.append(this.lastMessagePosition);
        r100.append(", lastMsgPosBgCount=");
        r100.append(this.lastMessagePositionBadgeCount);
        r100.append(", readPos=");
        r100.append(this.readPosition);
        r100.append(", readPosBgCount=");
        r100.append(this.readPositionBadgeCount);
        r100.append(", rTPos=");
        r100.append(this.readThreadPosition);
        r100.append(", lTPos=");
        r100.append(this.lastThreadPosition);
        r100.append(", rTBadge=");
        r100.append(this.readThreadPositionBadgeCount);
        r100.append(", lTBadge=");
        r100.append(this.lastThreadPositionBadgeCount);
        r100.append(", lTVisiblePos=");
        r100.append(this.lastVisibleThreadPosition);
        r100.append(", recentReadPos=");
        r100.append(this.recentReadPosition);
        r100.append(", isFlag=");
        r100.append(this.isFlag);
        r100.append(", tagData=");
        Object r101 = this.tagData;
        if (r101 != null) goto L5;
        r101 = "null";
    L5:
        r100.append(r101);
        r100.append(",hasVCChatPermission=");
        r100.append(this.hasVCChatPermission);
        r100.append(",isAIMainChat=");
        r100.append(this.isAIMainChat);
        r100.append(",isAIBotChat=");
        r100.append(this.isAIBotChat);
        r100.append('}');
        return r100.toString();
    }

    public Chat() {
        this.role = Role.IGNORE;
        this.firstMessagePosition = -1;
        this.messagePosition = MessagePosition.RECENT_LEFT;
        this.atAllPermission = AtAllPermission.ALL_MEMBERS;
        this.addMemberPermission = AddMemberPermission.ALL_MEMBERS;
        SystemMessageVisible r100 = SystemMessageVisible.ONLY_OWNER;
        this.joinMessageVisible = r100;
        this.quitMessageVisible = r100;
        this.shareCardPermission = ShareCardPermission.ALLOWED;
        this.burnLife = 30;
        this.isAllowPost = true;
        this.postType = PostType.ANYONE;
        this.isGroupMailEnable = false;
        this.groupMailSendType = GroupMailSendPermissionType.UNKNOWN;
        this.mAnonymousSetting = AnonymousSetting.INVISIBLE;
        this.topNoticePermissionSetting = TopNoticePermissionSetting.UNKNOWN;
        this.buzzPermissionSetting = BuzzPermissionSetting.ALL_MEMBERS;
        this.createVideoConferenceSetting = CreateVideoConferenceSetting.ALL_MEMBERS;
        this.pinPermissionSetting = PinPermissionSetting.ALL_MEMBERS;
        this.typingTranslateSetting = new TypingTranslateSetting();
        this.chatTabPermissionSetting = ChatTabPermissionSetting.ALL_MEMBERS;
        this.chatPinPermissionSetting = ChatPinPermissionSetting.ALL_MEMBERS;
        this.restrictedModeSetting = new RestrictedModeSetting();
        this.adminPostSetting = AdminPostSetting.ALLOW_POST;
        this.defaultDisplaySetting = DefaultDisplaySetting.INPUT_BOX;
        this.chatDisplayModeSetting = ChatDisplayModeSetting.UNKNOWN;
        this.userCountVisibleSetting = UserCountVisibleSetting.ALL_MEMBERS;
        this.doubaoSetting = new DoubaoSetting();
        this.isUserCountVisible = true;
        this.chatterExtraStates = new HashMap();
        this.mIsMuteAtAll = false;
        this.mIsDelayed = false;
        this.tagData = null;
    }

    public int getFirstUnReadMessageBadgeCount() {
        return getReadPositionBadgeCount() + 1;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public String getGroupOwnerId() {
        if (isP2PChat() == false) goto L6;
        return "";
    L6:
        return this.ownerId;
    }

    public int getNoBadgedNewMessageCount() {
        return getNewMessageCount() - getUnReadBadgeCount();
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public boolean isAIChat() {
        if (isAIMainChat() == false) goto L5;
    L8:
        return true;
    L5:
        if (isAIBotChat() == true) goto L8;
        return false;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public boolean isP2PChat() {
        if (getType() != Type.P2P) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public boolean isSoloChat() {
        if (isGroup() == false) goto L5;
    L7:
        return false;
    L5:
        if (this.memberCount != 1) goto L7;
        return true;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public boolean needEnterChatApply() {
        if (getAddMemberApply() != AddMemberApply.NEED_APPLY) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean canTranslateName() {
        return this.canTranslateName;
    }

    public AddMemberApply getAddMemberApply() {
        return this.mAddMemberApply;
    }

    public AddMemberPermission getAddMemberPermission() {
        return this.addMemberPermission;
    }

    public AdminPostSetting getAdminPostSetting() {
        return this.adminPostSetting;
    }

    public String getAnonymousId() {
        return this.mAnonymousId;
    }

    public AnonymousSetting getAnonymousSetting() {
        return this.mAnonymousSetting;
    }

    public long getAnonymousTotalQuota() {
        return this.mAnonymousTotalQuota;
    }

    public AtAllPermission getAtAllPermission() {
        return this.atAllPermission;
    }

    public Long getAtKnowledgeQueryCreateTime() {
        return this.atKnowledgeQueryCreateTime;
    }

    public Long getAtKnowledgeQueryId() {
        return this.atKnowledgeQueryId;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public String getAvatarKey() {
        return this.avatarKey;
    }

    public BannerSetting getBannerSetting() {
        return this.bannerSetting;
    }

    public boolean getBannerSettingAdmin() {
        return this.bannerSettingAdmin;
    }

    public String getBannerText() {
        return this.bannerText;
    }

    public List<ChatTeamInfo> getBoundTeamInfos() {
        return this.boundTeamInfos;
    }

    public int getBurnLife() {
        return this.burnLife;
    }

    public BuzzPermissionSetting getBuzzPermissionSetting() {
        return this.buzzPermissionSetting;
    }

    public ChatAnnouncement getChatAnnouncement() {
        return this.chatAnnouncement;
    }

    public ChatDisplayModeSetting getChatDisplayModeSetting() {
        return this.chatDisplayModeSetting;
    }

    public ChatMode getChatMode() {
        return this.chatMode;
    }

    public ChatOptionInfo getChatOptionInfo() {
        return this.chatOptionInfo;
    }

    public ChatPinPermissionSetting getChatPinPermissionSetting() {
        return this.chatPinPermissionSetting;
    }

    public ChatTabPermissionSetting getChatTabPermissionSetting() {
        return this.chatTabPermissionSetting;
    }

    public ChatTnsInfo getChatTnsInfo() {
        return this.chatTnsInfo;
    }

    public Map<Integer, Integer> getChatterExtraStates() {
        return this.chatterExtraStates;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public CreateVideoConferenceSetting getCreateVideoConferenceSetting() {
        return this.createVideoConferenceSetting;
    }

    public DefaultDisplaySetting getDefaultDisplaySetting() {
        return this.defaultDisplaySetting;
    }

    public String getDescription() {
        return this.description;
    }

    public DoubaoSetting getDoubaoSetting() {
        return this.doubaoSetting;
    }

    public int getFirstMessagePosition() {
        return this.firstMessagePosition;
    }

    public GroupMailSendPermissionType getGroupMailSendType() {
        return this.groupMailSendType;
    }

    public boolean getHasVCChatPermission() {
        return this.hasVCChatPermission;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public String getId() {
        return this.f415114id;
    }

    public SystemMessageVisible getJoinMessageVisible() {
        return this.joinMessageVisible;
    }

    public String getKey() {
        return this.key;
    }

    public String getLastDraftId() {
        return this.lastDraftId;
    }

    public String getLastMessageId() {
        return this.lastMessageId;
    }

    public int getLastMessagePosition() {
        return this.lastMessagePosition;
    }

    public int getLastMessagePositionBadgeCount() {
        return this.lastMessagePositionBadgeCount;
    }

    public String getLastThreadId() {
        return this.lastThreadId;
    }

    public int getLastThreadPosition() {
        return this.lastThreadPosition;
    }

    public int getLastThreadPositionBadgeCount() {
        return this.lastThreadPositionBadgeCount;
    }

    public String getLastVisibleMessageId() {
        return this.lastVisibleMessageId;
    }

    public int getLastVisibleMessagePosition() {
        return this.lastVisibleMessagePosition;
    }

    public String getLastVisibleThreadId() {
        return this.lastVisibleThreadId;
    }

    public int getLastVisibleThreadPosition() {
        return this.lastVisibleThreadPosition;
    }

    public int getMemberCount() {
        return this.memberCount;
    }

    public MessagePosition getMessagePosition() {
        return this.messagePosition;
    }

    public MessageVisibilitySetting getMessageVisibilitySetting() {
        return this.mMessageVisibilitySetting;
    }

    public String getMiniAvatarKey() {
        return this.miniAvatarKey;
    }

    public int getMyThreadsUnreadCount() {
        return this.myThreadsUnreadCount;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public String getName() {
        return this.name;
    }

    public String getNameMajorLanguage() {
        return this.nameMajorLanguage;
    }

    public String getNamePinyin() {
        return this.namePinyin;
    }

    public String getNameTranslateLanguage() {
        return this.nameTranslateLanguage;
    }

    public String getOnCallId() {
        return this.onCallId;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public PinPermissionSetting getPinPermissionSetting() {
        return this.pinPermissionSetting;
    }

    public String getPostDraftId() {
        return this.postDraftId;
    }

    public PostType getPostType() {
        return this.postType;
    }

    public int getPutChatterApplyCount() {
        return this.putChatterApplyCount;
    }

    public SystemMessageVisible getQuitMessageVisible() {
        return this.quitMessageVisible;
    }

    public String getReEditDraftId() {
        return this.reEditDraftId;
    }

    public int getReadPosition() {
        return this.readPosition;
    }

    public int getReadPositionBadgeCount() {
        return this.readPositionBadgeCount;
    }

    public int getReadThreadPosition() {
        return this.readThreadPosition;
    }

    public int getReadThreadPositionBadgeCount() {
        return this.readThreadPositionBadgeCount;
    }

    public float getRecentReadOffset() {
        return this.recentReadOffset;
    }

    public int getRecentReadPosition() {
        return this.recentReadPosition;
    }

    public RestrictedModeSetting getRestrictedModeSetting() {
        return this.restrictedModeSetting;
    }

    public Role getRole() {
        return this.role;
    }

    public String getScheduleDraftId() {
        return this.scheduleDraftId;
    }

    public ShareCardPermission getShareCardPermission() {
        return this.shareCardPermission;
    }

    public List<SideBarButton> getSideBarButtons() {
        return this.sideBarButtons;
    }

    public String getSideBarId() {
        return this.sideBarId;
    }

    public Status getStatus() {
        return this.status;
    }

    public TagData getTagData() {
        return this.tagData;
    }

    public List<Tag> getTags() {
        return this.tags;
    }

    public String getTenantId() {
        return this.tenantId;
    }

    public String getTextDraftId() {
        return this.textDraftId;
    }

    public long getThemeId() {
        return this.mThemeId;
    }

    public long getThreadLastTimeStamp() {
        return this.threadLastTimeStamp;
    }

    public long getThreadReadTimeStamp() {
        return this.threadReadTimeStamp;
    }

    public TopNoticePermissionSetting getTopNoticePermissionSetting() {
        return this.topNoticePermissionSetting;
    }

    public String getTranslatedName() {
        return this.translatedName;
    }

    public Type getType() {
        return this.type;
    }

    public TypingTranslateSetting getTypingTranslateSetting() {
        return this.typingTranslateSetting;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public ChatUserAutoMuteSetting getUserAutoMuteSetting() {
        return this.mChatUserAutoMuteSetting;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public int getUserCount() {
        return this.userCount;
    }

    public UserCountVisibleSetting getUserCountVisibleSetting() {
        return this.userCountVisibleSetting;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public boolean isAIBotChat() {
        return this.isAIBotChat;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public boolean isAIMainChat() {
        return this.isAIMainChat;
    }

    public boolean isAccept() {
        return this.isAccept;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public boolean isAdmin() {
        return this.isAdmin;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public boolean isAllowPost() {
        return this.isAllowPost;
    }

    public boolean isAutoTranslate() {
        return this.isAutoTranslate;
    }

    public boolean isCanBeSortedAlphabetically() {
        return this.canBeSortedAlphabetically;
    }

    public boolean isChatable() {
        return this.chatable;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public boolean isCrossTenant() {
        return this.isCrossTenant;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public boolean isCrossWithKa() {
        return this.isCrossWithKa;
    }

    public boolean isCustomAvatar() {
        return this.isCustomAvatar;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public boolean isCustomerService() {
        return this.isCustomerService;
    }

    public boolean isDelayed() {
        return this.mIsDelayed;
    }

    public boolean isDissolved() {
        return this.isDissolved;
    }

    public boolean isFake() {
        return this.isFake;
    }

    public boolean isFlag() {
        return this.isFlag;
    }

    public boolean isFrozen() {
        return this.isFrozen;
    }

    public boolean isGroupMailEnable() {
        return this.isGroupMailEnable;
    }

    public boolean isHasWatermark() {
        return this.hasWatermark;
    }

    public boolean isInBox() {
        return this.isInBox;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public boolean isMeeting() {
        return this.isMeeting;
    }

    public boolean isMuteAtAll() {
        return this.mIsMuteAtAll;
    }

    public boolean isMuteable() {
        return this.muteable;
    }

    public boolean isOcicService() {
        return this.isOcicService;
    }

    public boolean isOfficialOncall() {
        return this.isOfficialOncall;
    }

    public boolean isOfflineOncall() {
        return this.isOfflineOncall;
    }

    public boolean isOnlyOwnerEditGroupInfo() {
        return this.isOnlyOwnerEditGroupInfo;
    }

    public boolean isPublic() {
        return this.isPublic;
    }

    public boolean isRemind() {
        return this.isRemind;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public boolean isSecret() {
        return this.isSecret;
    }

    public boolean isShotCut() {
        return this.isShotCut;
    }

    public boolean isShowApplyBanner() {
        return this.isShowApplyBanner;
    }

    public boolean isShowBannerTitle() {
        return this.showBannerTitle;
    }

    public boolean isSuper() {
        return this.isSuper;
    }

    public boolean isTenant() {
        return this.isTenant;
    }

    public boolean isTypingTranslateHasAutoOpened() {
        return this.typingTranslateHasAutoOpened;
    }

    public boolean isUserCountVisible() {
        return this.isUserCountVisible;
    }

    public boolean is_department() {
        return this.is_department;
    }

    public boolean shouldDisplayTranslatedName() {
        return this.shouldDisplayTranslatedName;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this != r100) goto L9;
        return true;
    L9:
        if ((r100 instanceof Chat) == true) goto L11;
        return false;
    L11:
        Chat r101 = (Chat) r100;
        String r102 = this.f415114id;
        if (r102 == null) goto L14;
        boolean r103 = r102.equals(r101.getId());
    L18:
        if (r103 == true) goto L21;
        return false;
    L21:
        if (this.burnLife != r101.burnLife) goto L23;
        boolean r104 = true;
    L24:
        if (r104 == true) goto L26;
        return false;
    L26:
        Type r105 = this.type;
        Type r106 = r101.getType();
        if (r105 != null) goto L31;
        if (r106 != null) goto L32;
        return true;
    L32:
        return false;
    L31:
        return r105.equals(r106);
    L23:
        r104 = false;
        goto L24
    L14:
        if (r101.getId() != null) goto L16;
        r103 = true;
        goto L18
    L16:
        r103 = false;
        goto L18
    }

    public boolean exactlyCompare(Chat r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this != r100) goto L8;
        return true;
    L8:
        String r101 = this.f415114id;
        if (r101 == null) goto L11;
        boolean r102 = r101.equals(r100.getId());
    L15:
        if (r102 == true) goto L18;
        return false;
    L18:
        if (this.updateTime != r100.updateTime) goto L20;
        boolean r103 = true;
    L21:
        if (r103 == true) goto L24;
        return false;
    L24:
        if (TextUtils.equals(this.name, r100.name) == true) goto L26;
        return false;
    L26:
        Type r104 = this.type;
        Type r105 = r100.getType();
        if (r104 != null) goto L31;
        if (r105 != null) goto L32;
        return true;
    L32:
        return false;
    L31:
        return r104.equals(r105);
    L20:
        r103 = false;
        goto L21
    L11:
        if (r100.getId() != null) goto L13;
        r102 = true;
        goto L15
    L13:
        r102 = false;
        goto L15
    }

    public void setAIBotChat(boolean r100) {
        this.isAIBotChat = r100;
    }

    public void setAIMainChat(boolean r100) {
        this.isAIMainChat = r100;
    }

    public void setAccept(boolean r100) {
        this.isAccept = r100;
    }

    public void setAddMemberApply(AddMemberApply r100) {
        this.mAddMemberApply = r100;
    }

    public void setAddMemberPermission(AddMemberPermission r100) {
        this.addMemberPermission = r100;
    }

    public void setAdmin(boolean r100) {
        this.isAdmin = r100;
    }

    public void setAdminPostSetting(AdminPostSetting r100) {
        this.adminPostSetting = r100;
    }

    public void setAllowPost(boolean r100) {
        this.isAllowPost = r100;
    }

    public void setAnonymousId(String r100) {
        this.mAnonymousId = r100;
    }

    public void setAnonymousSetting(AnonymousSetting r100) {
        this.mAnonymousSetting = r100;
    }

    public void setAnonymousTotalQuota(long r100) {
        this.mAnonymousTotalQuota = r100;
    }

    public void setAtAllPermission(AtAllPermission r100) {
        this.atAllPermission = r100;
    }

    public void setAtKnowledgeQueryCreateTime(Long r100) {
        this.atKnowledgeQueryCreateTime = r100;
    }

    public void setAtKnowledgeQueryId(Long r100) {
        this.atKnowledgeQueryId = r100;
    }

    public void setAutoTranslate(boolean r100) {
        this.isAutoTranslate = r100;
    }

    public void setAvatarKey(String r100) {
        this.avatarKey = r100;
    }

    public void setBannerSetting(BannerSetting r100) {
        this.bannerSetting = r100;
    }

    public void setBannerSettingAdmin(boolean r100) {
        this.bannerSettingAdmin = r100;
    }

    public void setBannerText(String r100) {
        this.bannerText = r100;
    }

    public void setBoundTeamInfos(List<ChatTeamInfo> r100) {
        this.boundTeamInfos = r100;
    }

    public void setBurnLife(int r100) {
        this.burnLife = r100;
    }

    public void setBuzzPermissionSetting(BuzzPermissionSetting r100) {
        this.buzzPermissionSetting = r100;
    }

    public void setCanBeSortedAlphabetically(boolean r100) {
        this.canBeSortedAlphabetically = r100;
    }

    public void setCanTranslateName(boolean r100) {
        this.canTranslateName = r100;
    }

    public void setChatAnnouncement(ChatAnnouncement r100) {
        this.chatAnnouncement = r100;
    }

    public void setChatDisplayModeSetting(ChatDisplayModeSetting r100) {
        this.chatDisplayModeSetting = r100;
    }

    public void setChatMode(ChatMode r100) {
        this.chatMode = r100;
    }

    public void setChatOptionInfo(ChatOptionInfo r100) {
        this.chatOptionInfo = r100;
    }

    public void setChatPinPermissionSetting(ChatPinPermissionSetting r100) {
        this.chatPinPermissionSetting = r100;
    }

    public void setChatTabPermissionSetting(ChatTabPermissionSetting r100) {
        this.chatTabPermissionSetting = r100;
    }

    public void setChatTnsInfo(ChatTnsInfo r100) {
        this.chatTnsInfo = r100;
    }

    public void setChatable(boolean r100) {
        this.chatable = r100;
    }

    public void setChatterExtraStates(Map<Integer, Integer> r100) {
        this.chatterExtraStates = r100;
    }

    public void setCreateTime(String r100) {
        this.createTime = r100;
    }

    public void setCreateVideoConferenceSetting(CreateVideoConferenceSetting r100) {
        this.createVideoConferenceSetting = r100;
    }

    public void setCrossTenant(boolean r100) {
        this.isCrossTenant = r100;
    }

    public void setCrossWithKa(boolean r100) {
        this.isCrossWithKa = r100;
    }

    public void setCustomerService(boolean r100) {
        this.isCustomerService = r100;
    }

    public void setDefaultDisplaySetting(DefaultDisplaySetting r100) {
        this.defaultDisplaySetting = r100;
    }

    public void setDescription(String r100) {
        this.description = r100;
    }

    public void setDissolved(boolean r100) {
        this.isDissolved = r100;
    }

    public void setDoubaoSetting(DoubaoSetting r100) {
        this.doubaoSetting = r100;
    }

    public void setFake(boolean r100) {
        this.isFake = r100;
    }

    public void setFirstMessagePosition(int r100) {
        this.firstMessagePosition = r100;
    }

    public void setFlag(boolean r100) {
        this.isFlag = r100;
    }

    public void setFrozen(boolean r100) {
        this.isFrozen = r100;
    }

    public void setGroupMailEnable(boolean r100) {
        this.isGroupMailEnable = r100;
    }

    public void setGroupMailSendType(GroupMailSendPermissionType r100) {
        this.groupMailSendType = r100;
    }

    public void setHasVCChatPermission(boolean r100) {
        this.hasVCChatPermission = r100;
    }

    public void setHasWatermark(boolean r100) {
        this.hasWatermark = r100;
    }

    public void setId(String r100) {
        this.f415114id = r100;
    }

    public void setInBox(boolean r100) {
        this.isInBox = r100;
    }

    public void setIsCustomAvatar(boolean r100) {
        this.isCustomAvatar = r100;
    }

    public void setIsDelayed(boolean r100) {
        this.mIsDelayed = r100;
    }

    public void setIsMuteAtAll(boolean r100) {
        this.mIsMuteAtAll = r100;
    }

    public void setIsOcicService(boolean r100) {
        this.isOcicService = r100;
    }

    public void setIs_department(boolean r100) {
        this.is_department = r100;
    }

    public void setIs_public(boolean r100) {
        this.is_public = r100;
    }

    public void setJoinMessageVisible(SystemMessageVisible r100) {
        this.joinMessageVisible = r100;
    }

    public void setKey(String r100) {
        this.key = r100;
    }

    public void setLastDraftId(String r100) {
        this.lastDraftId = r100;
    }

    public void setLastMessageId(String r100) {
        this.lastMessageId = r100;
    }

    public void setLastMessagePosition(int r100) {
        this.lastMessagePosition = r100;
    }

    public void setLastMessagePositionBadgeCount(int r100) {
        this.lastMessagePositionBadgeCount = r100;
    }

    public void setLastThreadId(String r100) {
        this.lastThreadId = r100;
    }

    public void setLastThreadPosition(int r100) {
        this.lastThreadPosition = r100;
    }

    public void setLastThreadPositionBadgeCount(int r100) {
        this.lastThreadPositionBadgeCount = r100;
    }

    public void setLastVisibleMessageId(String r100) {
        this.lastVisibleMessageId = r100;
    }

    public void setLastVisibleMessagePosition(int r100) {
        this.lastVisibleMessagePosition = r100;
    }

    public void setLastVisibleThreadId(String r100) {
        this.lastVisibleThreadId = r100;
    }

    public void setLastVisibleThreadPosition(int r100) {
        this.lastVisibleThreadPosition = r100;
    }

    public void setMeeting(boolean r100) {
        this.isMeeting = r100;
    }

    public void setMemberCount(int r100) {
        this.memberCount = r100;
    }

    public void setMessagePosition(MessagePosition r100) {
        this.messagePosition = r100;
    }

    public void setMessageVisibilitySetting(MessageVisibilitySetting r100) {
        this.mMessageVisibilitySetting = r100;
    }

    public void setMiniAvatarKey(String r100) {
        this.miniAvatarKey = r100;
    }

    public void setMuteable(boolean r100) {
        this.muteable = r100;
    }

    public void setMyThreadsUnreadCount(int r100) {
        this.myThreadsUnreadCount = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setNameMajorLanguage(String r100) {
        this.nameMajorLanguage = r100;
    }

    public void setNamePinyin(String r100) {
        this.namePinyin = r100;
    }

    public void setNameTranslateLanguage(String r100) {
        this.nameTranslateLanguage = r100;
    }

    public void setOfficialOncall(boolean r100) {
        this.isOfficialOncall = r100;
    }

    public void setOfflineOncall(Boolean r100) {
        this.isOfflineOncall = r100.booleanValue();
    }

    public void setOnCallId(String r100) {
        this.onCallId = r100;
    }

    public void setOnlyOwnerEditGroupInfo(boolean r100) {
        this.isOnlyOwnerEditGroupInfo = r100;
    }

    public void setOwnerId(String r100) {
        this.ownerId = r100;
    }

    public void setP2pChatterId(String r100) {
        this.p2pChatterId = r100;
    }

    public void setPinPermissionSetting(PinPermissionSetting r100) {
        this.pinPermissionSetting = r100;
    }

    public void setPostDraftId(String r100) {
        this.postDraftId = r100;
    }

    public void setPostType(PostType r100) {
        this.postType = r100;
    }

    public void setPublic(boolean r100) {
        this.isPublic = r100;
    }

    public void setPutChatterApplyCount(int r100) {
        this.putChatterApplyCount = r100;
    }

    public void setQuitMessageVisible(SystemMessageVisible r100) {
        this.quitMessageVisible = r100;
    }

    public void setReEditDraftId(String r100) {
        this.reEditDraftId = r100;
    }

    public void setReadPosition(int r100) {
        this.readPosition = r100;
    }

    public void setReadPositionBadgeCount(int r100) {
        this.readPositionBadgeCount = r100;
    }

    public void setReadThreadPosition(int r100) {
        this.readThreadPosition = r100;
    }

    public void setReadThreadPositionBadgeCount(int r100) {
        this.readThreadPositionBadgeCount = r100;
    }

    public void setRecentReadOffset(float r100) {
        this.recentReadOffset = r100;
    }

    public void setRecentReadPosition(int r100) {
        this.recentReadPosition = r100;
    }

    public void setRemind(boolean r100) {
        this.isRemind = r100;
    }

    public void setRestrictedModeSetting(RestrictedModeSetting r100) {
        this.restrictedModeSetting = r100;
    }

    public void setRole(Role r100) {
        this.role = r100;
    }

    public void setScheduleDraftId(String r100) {
        this.scheduleDraftId = r100;
    }

    public void setSecret(boolean r100) {
        this.isSecret = r100;
    }

    public void setShareCardPermission(ShareCardPermission r100) {
        this.shareCardPermission = r100;
    }

    public void setShotCut(boolean r100) {
        this.isShotCut = r100;
    }

    public void setShouldDisplayTranslatedName(boolean r100) {
        this.shouldDisplayTranslatedName = r100;
    }

    public void setShowApplyBanner(boolean r100) {
        this.isShowApplyBanner = r100;
    }

    public void setShowBannerTitle(boolean r100) {
        this.showBannerTitle = r100;
    }

    public void setSideBarButtons(List<SideBarButton> r100) {
        this.sideBarButtons = r100;
    }

    public void setSideBarId(String r100) {
        this.sideBarId = r100;
    }

    public void setStatus(Status r100) {
        this.status = r100;
    }

    public void setSuper(boolean r100) {
        this.isSuper = r100;
    }

    public void setTagData(TagData r100) {
        this.tagData = r100;
    }

    public void setTags(List<Tag> r100) {
        this.tags = r100;
    }

    public void setTenant(boolean r100) {
        this.isTenant = r100;
    }

    public void setTenantId(String r100) {
        this.tenantId = r100;
    }

    public void setTextDraftId(String r100) {
        this.textDraftId = r100;
    }

    public void setThemeId(long r100) {
        this.mThemeId = r100;
    }

    public void setThreadLastTimeStamp(long r100) {
        this.threadLastTimeStamp = r100;
    }

    public void setThreadReadTimeStamp(long r100) {
        this.threadReadTimeStamp = r100;
    }

    public void setTopNoticePermissionSetting(TopNoticePermissionSetting r100) {
        this.topNoticePermissionSetting = r100;
    }

    public void setTranslatedName(String r100) {
        this.translatedName = r100;
    }

    public void setType(Type r100) {
        this.type = r100;
    }

    public void setTypingTranslateHasAutoOpened(boolean r100) {
        this.typingTranslateHasAutoOpened = r100;
    }

    public void setTypingTranslateSetting(TypingTranslateSetting r100) {
        this.typingTranslateSetting = r100;
    }

    public void setUpdateTime(long r100) {
        this.updateTime = r100;
    }

    public void setUserAutoMuteSetting(ChatUserAutoMuteSetting r100) {
        this.mChatUserAutoMuteSetting = r100;
    }

    public void setUserCount(int r100) {
        this.userCount = r100;
    }

    public void setUserCountVisible(boolean r100) {
        this.isUserCountVisible = r100;
    }

    public void setUserCountVisibleSetting(UserCountVisibleSetting r100) {
        this.userCountVisibleSetting = r100;
    }
}
