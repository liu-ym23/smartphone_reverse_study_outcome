package com.ss.android.lark.feed.app.entity;

import android.text.TextUtils;
import androidx.collection.SieveCacheKt;
import com.bytedance.lark.pb.feed.v1.AppFeedCardType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.biz.im.api.UrgentInfo;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.reaction.Reaction;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
public class UIFeedCard implements Comparable<UIFeedCard>, Cloneable, Serializable, IBadgeable {
    private String appId;
    private AtInfo atInfo;
    protected String avatarId;
    protected String avatarKey;
    private String bizId;
    private AppFeedCardType bizType;
    private int canSetStranger;
    private Chat.ChatMode chatMode;
    private boolean checkUser;
    protected ArrayList<DigestElement> digestMessage;
    private long displayTime;
    protected ArrayList<DigestElement> draftDigestMessage;
    private String draftMessage;
    private FeedCard.Type entityType;
    protected ArrayList<FeedCardButton> feedCardButtons;
    private FeedCard.FeedType feedType;
    private FlowDisplayType flowDisplayType;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f420757id;
    private boolean isBlocked;
    protected boolean isCrossTenant;
    private boolean isDisplayInShortcut;
    private boolean isExpiredFoldHint;
    private boolean isFake;
    private boolean isFirstTopRank;
    protected boolean isFlag;
    private boolean isFlowMainBot;
    private boolean isOfflineOncall;
    private boolean isPriorityProcessing;
    private boolean isRedBadge;
    protected boolean isRemind;
    protected boolean isShortCutFeed;
    private boolean isStranger;
    private boolean isSwipeRightPinned;
    private boolean isSwipedLeftPinned;
    private volatile transient WeakReference<DataObserver> mDataObserver;
    private int markType;
    private AutoMuteSettingNoticeType muteNoticeType;
    private MutexMarkType mutexMarkType;
    protected String name;
    private long onTopRankTime;
    private String parentCardId;
    private long rankPriority;
    private long rankTime;
    protected int reactionCount;
    protected int reactionDisplayCount;
    protected ArrayList<Reaction> reactions;
    private int shortcutPosition;
    private String uid;
    protected long unreadCount;
    private long updateTime;
    private ArrayList<UrgentInfo> urgentInfos;

    public static class AtInfo implements Serializable {
        private String atContent;
        private long atDisplayTime;
        private long atRankTime;
        private com.bytedance.lark.pb.feed.v1.AtInfo.AtType atType;
        private String avatarKey;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private String f420758id;
        private String localizedUserName;

        public int hashCode() {
            String r100 = this.avatarKey;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.localizedUserName;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public String getAtContent() {
            return this.atContent;
        }

        public long getAtDisplayTime() {
            return this.atDisplayTime;
        }

        public long getAtRankTime() {
            return this.atRankTime;
        }

        public com.bytedance.lark.pb.feed.v1.AtInfo.AtType getAtType() {
            return this.atType;
        }

        public String getAvatarKey() {
            return this.avatarKey;
        }

        public String getId() {
            return this.f420758id;
        }

        public String getLocalizedUserName() {
            return this.localizedUserName;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L21:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L21;
            AtInfo r101 = (AtInfo) r100;
            if (Objects.equals(this.avatarKey, r101.avatarKey) == true) goto L14;
            return false;
        L14:
            if (this.atType == r101.atType) goto L17;
            return false;
        L17:
            if (Objects.equals(this.atContent, r101.atContent) == true) goto L20;
            return false;
        L20:
            return Objects.equals(this.localizedUserName, r101.localizedUserName);
        }

        public void setAtContent(String r100) {
            this.atContent = r100;
        }

        public void setAtDisplayTime(long r100) {
            this.atDisplayTime = r100;
        }

        public void setAtRankTime(long r100) {
            this.atRankTime = r100;
        }

        public void setAtType(com.bytedance.lark.pb.feed.v1.AtInfo.AtType r100) {
            this.atType = r100;
        }

        public void setAvatarKey(String r100) {
            this.avatarKey = r100;
        }

        public void setId(String r100) {
            this.f420758id = r100;
        }

        public void setLocalizedUserName(String r100) {
            this.localizedUserName = r100;
        }

        public AtInfo(String r100, String r101, String r102) {
            this.f420758id = r100;
            this.avatarKey = r101;
            this.localizedUserName = r102;
        }
    }

    public interface DataObserver {
        void onChanged(String r100);
    }

    public static final enum FlowDisplayType extends Enum<FlowDisplayType> {
        private static final /* synthetic */ FlowDisplayType[] $VALUES = null;
        public static final FlowDisplayType FLOW_LOCAL = null;
        public static final FlowDisplayType FROM_SERVER = null;
        public static final FlowDisplayType KV_STORAGE = null;
        public static final FlowDisplayType UNKNOWN = null;
        private final int value;

        static {
            FlowDisplayType r100 = new FlowDisplayType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            FlowDisplayType r101 = new FlowDisplayType("KV_STORAGE", 1, 1);
            KV_STORAGE = r101;
            FlowDisplayType r102 = new FlowDisplayType("FLOW_LOCAL", 2, 2);
            FLOW_LOCAL = r102;
            FlowDisplayType r103 = new FlowDisplayType("FROM_SERVER", 3, 3);
            FROM_SERVER = r103;
            $VALUES = new FlowDisplayType[]{r100, r101, r102, r103};
        }

        public static FlowDisplayType[] values() {
            return (FlowDisplayType[]) $VALUES.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static FlowDisplayType valueOf(String r100) {
            return (FlowDisplayType) a.a(FlowDisplayType.class, r100);
        }

        private FlowDisplayType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum MarkType extends Enum<MarkType> {
        private static final /* synthetic */ MarkType[] $VALUES = null;
        public static final MarkType AT_ALL = null;
        public static final MarkType AT_USER = null;
        public static final MarkType NO_REMIND_UNREAD = null;
        public static final MarkType UNKNOWN = null;
        public static final MarkType URGENT = null;
        private final int value;

        static {
            MarkType r100 = new MarkType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            MarkType r101 = new MarkType("URGENT", 1, 2);
            URGENT = r101;
            MarkType r102 = new MarkType("AT_USER", 2, 4);
            AT_USER = r102;
            MarkType r103 = new MarkType("AT_ALL", 3, 8);
            AT_ALL = r103;
            MarkType r104 = new MarkType("NO_REMIND_UNREAD", 4, 16);
            NO_REMIND_UNREAD = r104;
            $VALUES = new MarkType[]{r100, r101, r102, r103, r104};
        }

        public static MarkType[] values() {
            return (MarkType[]) $VALUES.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static MarkType valueOf(String r100) {
            return (MarkType) a.a(MarkType.class, r100);
        }

        private MarkType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public String getLog() {
        return "";
    }

    public boolean hasHighPriorityDisplay() {
        return false;
    }

    @Override // com.ss.android.lark.feed.app.entity.IBadgeable
    public int getBadgeCount() {
        return (int) this.unreadCount;
    }

    public Map<String, Object> getEventParams() {
        return new HashMap();
    }

    public MutexMarkType getMutexMarkType() {
        if (this.draftMessage == null) goto L7;
        return MutexMarkType.DRAFT;
    L7:
        return this.mutexMarkType;
    }

    public int getReactionCount() {
        if (this.draftMessage == null) goto L6;
        return 0;
    L6:
        return this.reactionCount;
    }

    public int getReactionDisplayCount() {
        if (this.draftMessage == null) goto L6;
        return 0;
    L6:
        return this.reactionDisplayCount;
    }

    public List<Reaction> getReactions() {
        if (this.draftMessage == null) goto L6;
        return null;
    L6:
        return this.reactions;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f420757id, this.entityType, this.feedType, this.uid, Boolean.valueOf(this.checkUser), Long.valueOf(this.updateTime), Long.valueOf(this.rankTime), Long.valueOf(this.displayTime), Long.valueOf(this.rankPriority), Boolean.valueOf(this.isSwipedLeftPinned), Boolean.valueOf(this.isSwipeRightPinned), this.parentCardId, this.chatMode, this.mDataObserver, Boolean.valueOf(this.isOfflineOncall), Boolean.valueOf(this.isRemind), Boolean.valueOf(this.isShortCutFeed), this.name, this.avatarId, this.avatarKey, Long.valueOf(this.unreadCount), this.digestMessage, this.atInfo, Integer.valueOf(this.shortcutPosition), Boolean.valueOf(this.isDisplayInShortcut), this.appId, this.bizId, this.bizType, Integer.valueOf(this.markType), Boolean.valueOf(this.isStranger), Boolean.valueOf(this.isBlocked), Integer.valueOf(this.canSetStranger), this.urgentInfos, this.mutexMarkType, this.draftMessage, this.reactions, Integer.valueOf(this.reactionCount), Integer.valueOf(this.reactionDisplayCount), this.draftDigestMessage, Boolean.valueOf(this.isCrossTenant), this.feedCardButtons, Integer.valueOf(this.muteNoticeType.getNumber()), Boolean.valueOf(this.isRedBadge), Boolean.valueOf(this.isFlowMainBot)});
    }

    public boolean isInChatBox() {
        if (TextUtils.isEmpty(this.parentCardId) == false) goto L5;
    L7:
        return false;
    L5:
        if ("0".equals(this.parentCardId) == true) goto L7;
        return true;
    }

    public void notifyDataChanged() {
        if (this.mDataObserver != null) goto L5;
        return;
    L5:
        DataObserver r100 = this.mDataObserver.get();
        if (r100 == null) goto L9;
        r100.onChanged(this.f420757id);
        return;
    }

    public String toString() {
        return "UIFeedCard{id='" + this.f420757id + "', feedType=" + this.feedType + "'}";
    }

    public UIFeedCard() {
        this.bizType = AppFeedCardType.UNKNOWN_APP_FEED_CARD_TYPE;
        this.bizId = "";
        this.appId = "";
        this.rankPriority = SieveCacheKt.NodeLinkMask;
        this.isDisplayInShortcut = false;
        this.urgentInfos = new ArrayList();
        this.canSetStranger = 0;
        this.muteNoticeType = AutoMuteSettingNoticeType.UNKNOWN;
        this.isRedBadge = true;
        this.flowDisplayType = FlowDisplayType.UNKNOWN;
        this.isFlowMainBot = false;
    }

    public UIFeedCard clone() throws CloneNotSupportedException {
        return (UIFeedCard) super.clone();
    }

    public long getRealRankTime() {
        return getRankTime();
    }

    public String getAppId() {
        return this.appId;
    }

    public AtInfo getAtInfo() {
        return this.atInfo;
    }

    public String getAvatarId() {
        return this.avatarId;
    }

    public String getAvatarKey() {
        return this.avatarKey;
    }

    public String getBizId() {
        return this.bizId;
    }

    public AppFeedCardType getBizType() {
        return this.bizType;
    }

    public int getCanSetStranger() {
        return this.canSetStranger;
    }

    public Chat.ChatMode getChatMode() {
        return this.chatMode;
    }

    public List<DigestElement> getDigestMessage() {
        return this.digestMessage;
    }

    public long getDisplayTime() {
        return this.displayTime;
    }

    public List<DigestElement> getDraftDigestMessage() {
        return this.draftDigestMessage;
    }

    public String getDraftMessage() {
        return this.draftMessage;
    }

    public ArrayList<FeedCardButton> getFeedCardButtons() {
        return this.feedCardButtons;
    }

    public FeedCard.FeedType getFeedType() {
        return this.feedType;
    }

    public FlowDisplayType getFlowDisplayType() {
        return this.flowDisplayType;
    }

    public String getId() {
        return this.f420757id;
    }

    public boolean getIsDisplayInShortcut() {
        return this.isDisplayInShortcut;
    }

    public boolean getIsExpiredFoldHint() {
        return this.isExpiredFoldHint;
    }

    public boolean getIsFake() {
        return this.isFake;
    }

    public boolean getIsFirstTopRank() {
        return this.isFirstTopRank;
    }

    public boolean getIsFlowMainBot() {
        return this.isFlowMainBot;
    }

    public boolean getIsPriorityProcessing() {
        return this.isPriorityProcessing;
    }

    public int getMarkType() {
        return this.markType;
    }

    @Override // com.ss.android.lark.feed.app.entity.IBadgeable
    public AutoMuteSettingNoticeType getMuteNoticeType() {
        return this.muteNoticeType;
    }

    public String getName() {
        return this.name;
    }

    public boolean getOfflineOncall() {
        return this.isOfflineOncall;
    }

    public long getOnTopRankTime() {
        return this.onTopRankTime;
    }

    public String getParentCardId() {
        return this.parentCardId;
    }

    public long getRankPriority() {
        return this.rankPriority;
    }

    public long getRankTime() {
        return this.rankTime;
    }

    public int getShortcutPosition() {
        return this.shortcutPosition;
    }

    public FeedCard.Type getType() {
        return this.entityType;
    }

    public String getUid() {
        return this.uid;
    }

    public long getUnreadCount() {
        return this.unreadCount;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public ArrayList<UrgentInfo> getUrgentInfos() {
        return this.urgentInfos;
    }

    public boolean isBlocked() {
        return this.isBlocked;
    }

    public boolean isCheckUser() {
        return this.checkUser;
    }

    public boolean isCrossTenant() {
        return this.isCrossTenant;
    }

    public boolean isFlag() {
        return this.isFlag;
    }

    @Override // com.ss.android.lark.feed.app.entity.IBadgeable
    public boolean isRedBadge() {
        return this.isRedBadge;
    }

    @Override // com.ss.android.lark.feed.app.entity.IBadgeable
    public boolean isRemind() {
        return this.isRemind;
    }

    public boolean isShortCut() {
        return this.isShortCutFeed;
    }

    public boolean isStranger() {
        return this.isStranger;
    }

    public boolean isSwipeRightPinned() {
        return this.isSwipeRightPinned;
    }

    public boolean isSwipedLeftPinned() {
        return this.isSwipedLeftPinned;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object mo8637clone() throws CloneNotSupportedException {
        return clone();
    }

    public UIFeedCard(UIFeedCard r100) {
        this.bizType = AppFeedCardType.UNKNOWN_APP_FEED_CARD_TYPE;
        this.bizId = "";
        this.appId = "";
        this.rankPriority = SieveCacheKt.NodeLinkMask;
        this.isDisplayInShortcut = false;
        this.urgentInfos = new ArrayList();
        this.canSetStranger = 0;
        this.muteNoticeType = AutoMuteSettingNoticeType.UNKNOWN;
        this.isRedBadge = true;
        this.flowDisplayType = FlowDisplayType.UNKNOWN;
        this.isFlowMainBot = false;
        if (r100 != null) goto L5;
        return;
    L5:
        this.f420757id = r100.getId();
        this.entityType = r100.getType();
        this.feedType = r100.getFeedType();
        this.bizType = r100.bizType;
        this.bizId = r100.bizId;
        this.appId = r100.appId;
        this.rankTime = r100.getRankTime();
        this.displayTime = r100.getDisplayTime();
        this.updateTime = r100.getUpdateTime();
        this.chatMode = r100.getChatMode();
        this.parentCardId = r100.getParentCardId();
        this.chatMode = r100.getChatMode();
        this.isOfflineOncall = r100.getOfflineOncall();
        this.isRemind = r100.isRemind();
        this.onTopRankTime = r100.onTopRankTime;
        this.isPriorityProcessing = r100.isPriorityProcessing;
        this.isShortCutFeed = r100.isShortCut();
        this.markType = r100.markType;
        this.urgentInfos = r100.urgentInfos;
        this.isFlag = r100.isFlag();
        this.name = r100.name;
        this.avatarId = r100.avatarId;
        this.avatarKey = r100.avatarKey;
        this.unreadCount = r100.unreadCount;
        this.digestMessage = r100.digestMessage;
        this.atInfo = r100.atInfo;
        this.shortcutPosition = r100.shortcutPosition;
        this.isDisplayInShortcut = r100.isDisplayInShortcut;
        this.draftMessage = r100.draftMessage;
        this.mutexMarkType = r100.mutexMarkType;
        this.draftDigestMessage = r100.draftDigestMessage;
        this.reactions = r100.reactions;
        this.reactionDisplayCount = r100.reactionDisplayCount;
        this.reactionCount = r100.reactionCount;
        this.isCrossTenant = r100.isCrossTenant;
        this.feedCardButtons = r100.feedCardButtons;
        this.muteNoticeType = AutoMuteSettingNoticeType.valueOf(Integer.valueOf(r100.muteNoticeType.getNumber()));
        this.isStranger = r100.isStranger;
        this.isBlocked = r100.isBlocked;
        this.canSetStranger = r100.canSetStranger;
        this.isRedBadge = r100.isRedBadge;
        this.isFlowMainBot = r100.isFlowMainBot;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(UIFeedCard r100) {
        if (r100 != null) goto L5;
        return 1;
    L5:
        boolean r101 = UIFeedCardExtraKt.isOnTop(this);
        boolean r102 = UIFeedCardExtraKt.isOnTop(r100);
        if (r101 == false) goto L14;
        if (r102 == false) goto L14;
        if (getOnTopRankTime() <= r100.getOnTopRankTime()) goto L12;
        return -1;
    L12:
        if (getOnTopRankTime() >= r100.getOnTopRankTime()) goto L20;
        return 1;
    L20:
        long r103 = getRealRankTime();
        long r104 = r100.getRealRankTime();
        if (r103 >= r104) goto L23;
        return 1;
    L23:
        if (r103 <= r104) goto L25;
        return -1;
    L25:
        FeedCard.Type r105 = this.entityType;
        FeedCard.Type r106 = FeedCard.Type.DOUBAO_CONVERSATION;
        if (r105 != r106) goto L28;
    L32:
        return 0;
    L28:
        if (r100.entityType == r106) goto L32;
        return r100.getId().compareTo(getId());
    L14:
        if (r101 == true) goto L17;
        if (r102 == false) goto L17;
        return 1;
    L17:
        if (r101 == false) goto L20;
        if (r102 == true) goto L20;
        return -1;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if ((r100 instanceof UIFeedCard) == true) goto L8;
        return false;
    L8:
        if (this != r100) goto L10;
        return true;
    L10:
        UIFeedCard r101 = (UIFeedCard) r100;
        if (this.isRemind == r101.isRemind()) goto L14;
        return false;
    L14:
        if (this.muteNoticeType.getNumber() == r101.muteNoticeType.getNumber()) goto L17;
        return false;
    L17:
        if (TextUtils.equals(getId(), r101.getId()) == true) goto L19;
        return false;
    L19:
        if (Objects.equals(this.name, r101.name) == true) goto L21;
        return false;
    L21:
        if (Objects.equals(this.avatarId, r101.avatarId) == true) goto L23;
        return false;
    L23:
        if (Objects.equals(this.avatarKey, r101.avatarKey) == true) goto L25;
        return false;
    L25:
        if (this.unreadCount == r101.unreadCount) goto L27;
        return false;
    L27:
        if (this.shortcutPosition == r101.shortcutPosition) goto L29;
        return false;
    L29:
        if (this.isDisplayInShortcut == r101.isDisplayInShortcut) goto L31;
        return false;
    L31:
        if (digestMessageEquals(this.digestMessage, r101.digestMessage) == true) goto L33;
        return false;
    L33:
        if (Objects.equals(this.atInfo, r101.atInfo) == true) goto L35;
        return false;
    L35:
        if (Objects.equals(this.bizId, r101.bizId) == true) goto L37;
        return false;
    L37:
        if (Objects.equals(this.appId, r101.appId) == true) goto L39;
        return false;
    L39:
        if (this.bizType == r101.bizType) goto L41;
        return false;
    L41:
        if (this.feedType == r101.feedType) goto L43;
        return false;
    L43:
        if (this.entityType == r101.entityType) goto L45;
        return false;
    L45:
        if (this.markType == r101.markType) goto L47;
        return false;
    L47:
        if (this.isStranger == r101.isStranger) goto L49;
        return false;
    L49:
        if (this.isBlocked == r101.isBlocked) goto L51;
        return false;
    L51:
        if (Objects.equals(Integer.valueOf(this.canSetStranger), Integer.valueOf(r101.canSetStranger)) == true) goto L53;
        return false;
    L53:
        if (this.isRedBadge == r101.isRedBadge) goto L55;
        return false;
    L55:
        if (this.mutexMarkType == r101.mutexMarkType) goto L57;
        return false;
    L57:
        if (Objects.equals(this.draftMessage, r101.draftMessage) == true) goto L59;
        return false;
    L59:
        if (this.isCrossTenant == r101.isCrossTenant) goto L61;
        return false;
    L61:
        if (this.reactionCount == r101.reactionCount) goto L63;
        return false;
    L63:
        if (this.reactionDisplayCount == r101.reactionDisplayCount) goto L65;
        return false;
    L65:
        if (reactionEquals(this.reactions, r101.reactions) == true) goto L67;
        return false;
    L67:
        if (Objects.equals(this.draftDigestMessage, r101.draftDigestMessage) == true) goto L69;
        return false;
    L69:
        if (feedCardButtonsEquals(this.feedCardButtons, r101.feedCardButtons) == true) goto L71;
        return false;
    L71:
        if (urgentInfosEquals(this.urgentInfos, r101.urgentInfos) == true) goto L73;
        return false;
    L73:
        if (this.isFlowMainBot != r101.isFlowMainBot) goto L105;
        return true;
    L105:
        return false;
    }

    public boolean exactlyCompare(Object r100) {
        if (r100 != null) goto L5;
    L107:
        return false;
    L5:
        if ((r100 instanceof UIFeedCard) == false) goto L107;
        if (this != r100) goto L10;
        return true;
    L10:
        UIFeedCard r101 = (UIFeedCard) r100;
        if (r101.getDisplayTime() == getDisplayTime()) goto L14;
        return false;
    L14:
        if (r101.getRankTime() == getRankTime()) goto L17;
        return false;
    L17:
        if (r101.onTopRankTime == this.onTopRankTime) goto L20;
        return false;
    L20:
        if (r101.isPriorityProcessing == this.isPriorityProcessing) goto L23;
        return false;
    L23:
        if (r101.isFirstTopRank == this.isFirstTopRank) goto L26;
        return false;
    L26:
        if (r101.isExpiredFoldHint == this.isExpiredFoldHint) goto L29;
        return false;
    L29:
        if (TextUtils.equals(r101.getParentCardId(), this.parentCardId) == true) goto L32;
        return false;
    L32:
        if (r101.isRemind == this.isRemind) goto L35;
        return false;
    L35:
        if (r101.isCrossTenant == this.isCrossTenant) goto L38;
        return false;
    L38:
        if (r101.isShortCutFeed == this.isShortCutFeed) goto L41;
        return false;
    L41:
        if (r101.markType == this.markType) goto L44;
        return false;
    L44:
        if (r101.isStranger == this.isStranger) goto L47;
        return false;
    L47:
        if (r101.isBlocked == this.isBlocked) goto L50;
        return false;
    L50:
        if (Objects.equals(Integer.valueOf(this.canSetStranger), Integer.valueOf(r101.canSetStranger)) == true) goto L53;
        return false;
    L53:
        if (TextUtils.equals(this.name, r101.name) == true) goto L56;
        return false;
    L56:
        if (TextUtils.equals(this.avatarKey, r101.avatarKey) == true) goto L59;
        return false;
    L59:
        if (r101.unreadCount == this.unreadCount) goto L62;
        return false;
    L62:
        if (digestMessageEquals(this.digestMessage, r101.digestMessage) == true) goto L65;
        return false;
    L65:
        if (TextUtils.equals(this.draftMessage, r101.draftMessage) == true) goto L68;
        return false;
    L68:
        if (r101.isFlag == this.isFlag) goto L71;
        return false;
    L71:
        if (Objects.equals(r101.atInfo, this.atInfo) == true) goto L74;
        return false;
    L74:
        if (TextUtils.equals(this.draftMessage, r101.draftMessage) == true) goto L77;
        return false;
    L77:
        if (r101.mutexMarkType == this.mutexMarkType) goto L80;
        return false;
    L80:
        if (reactionEquals(this.reactions, r101.reactions) == true) goto L83;
        return false;
    L83:
        if (this.reactionCount != r101.reactionCount) goto L107;
        if (this.reactionDisplayCount != r101.reactionDisplayCount) goto L107;
        if (feedCardButtonsEquals(this.feedCardButtons, r101.feedCardButtons) == true) goto L91;
        return false;
    L91:
        if (urgentInfosEquals(this.urgentInfos, r101.urgentInfos) == true) goto L94;
        return false;
    L94:
        if (TextUtils.equals(this.appId, r101.appId) == true) goto L97;
        return false;
    L97:
        if (this.muteNoticeType.getNumber() == r101.muteNoticeType.getNumber()) goto L100;
        return false;
    L100:
        if (this.isRedBadge == r101.isRedBadge) goto L103;
        return false;
    L103:
        if (this.isFlowMainBot == r101.isFlowMainBot) goto L106;
        return false;
    L106:
        return TextUtils.equals(getId(), r101.getId());
    }

    public boolean isContainMarkType(MarkType r100) {
        int r101 = this.markType;
        if ((r100.getNumber() & r101) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void setAppId(String r100) {
        this.appId = r100;
    }

    public void setAtInfo(AtInfo r100) {
        this.atInfo = r100;
    }

    public void setAvatarId(String r100) {
        this.avatarId = r100;
    }

    public void setAvatarKey(String r100) {
        this.avatarKey = r100;
    }

    public void setBizId(String r100) {
        this.bizId = r100;
    }

    public void setBizType(AppFeedCardType r100) {
        this.bizType = r100;
    }

    public void setBlocked(boolean r100) {
        this.isBlocked = r100;
    }

    public void setCanSetStranger(int r100) {
        this.canSetStranger = r100;
    }

    public void setChatMode(Chat.ChatMode r100) {
        this.chatMode = r100;
    }

    public void setCheckUser(boolean r100) {
        this.checkUser = r100;
    }

    public void setCrossTenant(boolean r100) {
        this.isCrossTenant = r100;
    }

    public void setDataObserver(DataObserver r100) {
        this.mDataObserver = new WeakReference(r100);
    }

    public void setDigestMessage(ArrayList<DigestElement> r100) {
        this.digestMessage = r100;
    }

    public void setDisplayTime(long r100) {
        this.displayTime = r100;
    }

    public void setDraftDigestMessage(ArrayList<DigestElement> r100) {
        this.draftDigestMessage = r100;
    }

    public void setDraftMessage(String r100) {
        this.draftMessage = r100;
    }

    public void setFeedCardButtons(ArrayList<FeedCardButton> r100) {
        this.feedCardButtons = r100;
    }

    public void setFeedType(FeedCard.FeedType r100) {
        this.feedType = r100;
    }

    public void setFlag(boolean r100) {
        this.isFlag = r100;
    }

    public void setFlowDisplayType(FlowDisplayType r100) {
        this.flowDisplayType = r100;
    }

    public void setId(String r100) {
        this.f420757id = r100;
    }

    public void setIsDisplayInShortcut(boolean r100) {
        this.isDisplayInShortcut = r100;
    }

    public void setIsExpiredFoldHint(boolean r100) {
        this.isExpiredFoldHint = r100;
    }

    public void setIsFake(boolean r100) {
        this.isFake = r100;
    }

    public void setIsFirstTopRank(boolean r100) {
        this.isFirstTopRank = r100;
    }

    public void setIsFlowMainBot(boolean r100) {
        this.isFlowMainBot = r100;
    }

    public void setIsPriorityProcessing(boolean r100) {
        this.isPriorityProcessing = r100;
    }

    public void setMarkType(int r100) {
        this.markType = r100;
    }

    public void setMuteNoticeType(AutoMuteSettingNoticeType r100) {
        this.muteNoticeType = AutoMuteSettingNoticeType.forNumber(Integer.valueOf(r100.getNumber()));
    }

    public void setMutexMarkType(MutexMarkType r100) {
        this.mutexMarkType = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setOfflineOncall(boolean r100) {
        this.isOfflineOncall = r100;
    }

    public void setOnTopRankTime(long r100) {
        this.onTopRankTime = r100;
    }

    public void setParentCardId(String r100) {
        this.parentCardId = r100;
    }

    public void setRankPriority(long r100) {
        this.rankPriority = r100;
    }

    public void setRankTime(long r100) {
        this.rankTime = r100;
    }

    public void setReactionCount(int r100) {
        this.reactionCount = r100;
    }

    public void setReactionDisplayCount(int r100) {
        this.reactionDisplayCount = r100;
    }

    public void setReactions(ArrayList<Reaction> r100) {
        this.reactions = r100;
    }

    public void setRedBadge(boolean r100) {
        this.isRedBadge = r100;
    }

    public void setRemind(boolean r100) {
        this.isRemind = r100;
    }

    public void setShortCut(boolean r100) {
        this.isShortCutFeed = r100;
    }

    public void setShortcutPosition(int r100) {
        this.shortcutPosition = r100;
    }

    public void setStranger(boolean r100) {
        this.isStranger = r100;
    }

    public void setSwipeRightPinned(boolean r100) {
        this.isSwipeRightPinned = r100;
    }

    public void setSwipedLeftPinned(boolean r100) {
        this.isSwipedLeftPinned = r100;
    }

    public void setType(FeedCard.Type r100) {
        this.entityType = r100;
    }

    public void setUid(String r100) {
        this.uid = r100;
    }

    public void setUnreadCount(long r100) {
        this.unreadCount = r100;
    }

    public void setUpdateTime(long r100) {
        this.updateTime = r100;
    }

    public void setUrgentInfos(ArrayList<UrgentInfo> r100) {
        this.urgentInfos = r100;
    }

    public boolean shortcutCompare(Object r100) {
        if ((r100 instanceof UIFeedCard) == true) goto L6;
        return false;
    L6:
        if (this != r100) goto L8;
        return true;
    L8:
        UIFeedCard r101 = (UIFeedCard) r100;
        if (TextUtils.equals(this.f420757id, r101.f420757id) == true) goto L12;
        return false;
    L12:
        if (this.entityType == r101.entityType) goto L15;
        return false;
    L15:
        if (this.bizType == r101.bizType) goto L18;
        return false;
    L18:
        if (TextUtils.equals(this.bizId, r101.bizId) == true) goto L21;
        return false;
    L21:
        if (TextUtils.equals(this.appId, r101.appId) == true) goto L24;
        return false;
    L24:
        if (this.chatMode == r101.chatMode) goto L27;
        return false;
    L27:
        if (this.isRemind == r101.isRemind) goto L30;
        return false;
    L30:
        if (this.markType == r101.markType) goto L33;
        return false;
    L33:
        if (this.isStranger == r101.isStranger) goto L36;
        return false;
    L36:
        if (this.isBlocked == r101.isBlocked) goto L39;
        return false;
    L39:
        if (Objects.equals(Integer.valueOf(this.canSetStranger), Integer.valueOf(r101.canSetStranger)) == true) goto L42;
        return false;
    L42:
        if (this.feedType == r101.feedType) goto L45;
        return false;
    L45:
        if (TextUtils.equals(this.name, r101.name) == true) goto L48;
        return false;
    L48:
        if (TextUtils.equals(this.avatarId, r101.avatarId) == true) goto L51;
        return false;
    L51:
        if (TextUtils.equals(this.avatarKey, r101.avatarKey) == true) goto L54;
        return false;
    L54:
        if (this.unreadCount == r101.unreadCount) goto L57;
        return false;
    L57:
        if (this.shortcutPosition == r101.shortcutPosition) goto L60;
        return false;
    L60:
        if (this.isDisplayInShortcut == r101.isDisplayInShortcut) goto L63;
        return false;
    L63:
        if (this.bizType == r101.bizType) goto L66;
        return false;
    L66:
        if (this.isFlag == r101.isFlag) goto L69;
        return false;
    L69:
        if (this.muteNoticeType.getNumber() == r101.muteNoticeType.getNumber()) goto L72;
        return false;
    L72:
        if (this.isRedBadge == r101.isRedBadge) goto L75;
        return false;
    L75:
        if (TextUtils.equals(this.bizId, r101.bizId) == true) goto L77;
        return false;
    L77:
        return true;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UIFeedCard r100) {
        return compareTo2(r100);
    }

    public static boolean feedCardButtonsEquals(List<FeedCardButton> r100, List<FeedCardButton> r101) {
        if (r100 != null) goto L7;
        if (r101 != null) goto L7;
        return true;
    L7:
        if (r100 == null) goto L30;
        if (r101 == null) goto L30;
        if (r100.size() != r101.size()) goto L30;
        int r102 = 0;
    L14:
        if (r102 >= r100.size()) goto L29;
        FeedCardButton r103 = (FeedCardButton) ListProtector.get(r100, r102);
        FeedCardButton r104 = (FeedCardButton) ListProtector.get(r101, r102);
        if (r103 != null) goto L18;
        boolean r105 = true;
    L19:
        if (r104 != null) goto L21;
        boolean r106 = true;
    L22:
        if (r105 != r106) goto L28;
        if (r103 == null) goto L27;
        if (r103.isContentSame(r104) == false) goto L28;
    L27:
        r102 = r102 + 1;
    L28:
        return false;
    L21:
        r106 = false;
        goto L22
    L18:
        r105 = false;
        goto L19
    L29:
        return true;
    L30:
        return false;
    }

    private boolean reactionEquals(List<Reaction> r100, List<Reaction> r101) {
        if (r100 != null) goto L7;
        if (r101 != null) goto L7;
        return true;
    L7:
        if (r100 == null) goto L30;
        if (r101 == null) goto L30;
        if (r100.size() != r101.size()) goto L30;
        int r102 = 0;
    L14:
        if (r102 >= r100.size()) goto L29;
        Reaction r103 = (Reaction) ListProtector.get(r100, r102);
        Reaction r104 = (Reaction) ListProtector.get(r101, r102);
        if (r103 != null) goto L18;
        boolean r105 = true;
    L19:
        if (r104 != null) goto L21;
        boolean r106 = true;
    L22:
        if (r105 != r106) goto L28;
        if (r103 == null) goto L27;
        if (r103.isContentSame(r104) == false) goto L28;
    L27:
        r102 = r102 + 1;
    L28:
        return false;
    L21:
        r106 = false;
        goto L22
    L18:
        r105 = false;
        goto L19
    L29:
        return true;
    L30:
        return false;
    }

    public static boolean urgentInfosEquals(List<UrgentInfo> r100, List<UrgentInfo> r101) {
        if (r100 != null) goto L7;
        if (r101 != null) goto L7;
        return true;
    L7:
        if (r100 == null) goto L30;
        if (r101 == null) goto L30;
        if (r100.size() != r101.size()) goto L30;
        int r102 = 0;
    L14:
        if (r102 >= r100.size()) goto L29;
        UrgentInfo r103 = (UrgentInfo) ListProtector.get(r100, r102);
        UrgentInfo r104 = (UrgentInfo) ListProtector.get(r101, r102);
        if (r103 != null) goto L18;
        boolean r105 = true;
    L19:
        if (r104 != null) goto L21;
        boolean r106 = true;
    L22:
        if (r105 != r106) goto L28;
        if (r103 == null) goto L27;
        if (r103.isContentSame(r104) == false) goto L28;
    L27:
        r102 = r102 + 1;
    L28:
        return false;
    L21:
        r106 = false;
        goto L22
    L18:
        r105 = false;
        goto L19
    L29:
        return true;
    L30:
        return false;
    }

    public boolean digestMessageEquals(List<DigestElement> r100, List<DigestElement> r101) {
        if (r100 != null) goto L7;
        if (r101 != null) goto L7;
        return true;
    L7:
        if (r100 == null) goto L30;
        if (r101 == null) goto L30;
        if (r100.size() != r101.size()) goto L30;
        int r102 = 0;
    L14:
        if (r102 >= r100.size()) goto L29;
        DigestElement r103 = (DigestElement) ListProtector.get(r100, r102);
        DigestElement r104 = (DigestElement) ListProtector.get(r101, r102);
        if (r103 != null) goto L18;
        boolean r105 = true;
    L19:
        if (r104 != null) goto L21;
        boolean r106 = true;
    L22:
        if (r105 != r106) goto L28;
        if (r103 == null) goto L27;
        if (r103.isContentSame(r104) == false) goto L28;
    L27:
        r102 = r102 + 1;
    L28:
        return false;
    L21:
        r106 = false;
        goto L22
    L18:
        r105 = false;
        goto L19
    L29:
        return true;
    L30:
        return false;
    }

    public List<DigestElement> getDigestMessage(boolean r100, String r101) {
        if (TextUtils.isEmpty(r101) == true) goto L14;
        if (r100 == true) goto L14;
        ArrayList r102 = new ArrayList();
        ArrayList<DigestElement> r103 = this.draftDigestMessage;
        if (r103 == null) goto L9;
        r102.addAll(r103);
    L12:
        ListProtector.add(r102, 0, new TextProperty(r101));
        return r102;
    L9:
        ArrayList<DigestElement> r104 = this.digestMessage;
        if (r104 == null) goto L12;
        r102.addAll(r104);
    L14:
        ArrayList<DigestElement> r105 = this.draftDigestMessage;
        if (r105 == null) goto L18;
        return r105;
    L18:
        return this.digestMessage;
    }
}
