package com.ss.android.lark.chat.entity.message;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.bytedance.lark.pb.basic.v1.File;
import com.bytedance.lark.pb.basic.v1.ImageTranslationAbility;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.media.MediaScene;
import com.obric.miniapp.alarm.AlarmSessionType;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.AuthorityParam;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.entity.Channel;
import com.ss.android.lark.chat.entity.chat.ChatDisplayModeSetting;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.message.content.BaseFileContent;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.chat.entity.message.content.ImageContent;
import com.ss.android.lark.chat.entity.message.content.MediaContent;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.i;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import uxb.c;

/* JADX INFO: loaded from: classes35.dex */
public class Message implements c, p5b.b, Serializable, Cloneable, Comparable<Message>, y28.b<Message> {
    private static final long serialVersionUID = -2587494770206633286L;
    private String aiAnswerRawData;
    private long aiChatModeId;
    private AIInfo aiInfo;
    private com.bytedance.lark.pb.basic.v1.Message.AIMessageLikeFeedbackStatus aiMessageLikeFeedbackStatus;
    private com.bytedance.lark.pb.basic.v1.Message.AIMessageType aiMessageType;
    private AISmartReply aiSmartReply;
    private MessageAnalysisConfig analysisConfigs;
    private String appInfoItemName;
    private final List<String> atBotIds;
    private int badgeCount;
    private int burnLife;
    private long burnTime;
    private String cId;
    private boolean canShowAiProcess;
    private Channel channel;
    private int characterLength;
    private ChatDisplayModeSetting chatDisplayModeSetting;
    private String chatId;
    private int contentVersion;
    private CotContent cotContent;
    private long createTime;
    private long createTimeInMills;
    private String cryptoToken;
    private HashMap<Integer, com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior> disabledAction;
    private MessageSourceDisplayPolicy displayPolicy;
    private MessageDLPState dlpState;
    private MessageEditInfo editInfo;
    private HashMap<Class<?>, Object> extras;
    private FileDeletedStatus fileDeletedStatus;
    private String foldId;
    private String fromChatterTenantId;
    private String fromId;
    private FromType fromType;
    private boolean hasFollowUP;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f415217id;
    private Map<String, ImageTranslationAbility> imageTranslationAbility;
    private boolean isAtAll;
    private boolean isAtMe;
    private boolean isAutoTranslatedForReceiver;
    private boolean isBadged;
    private boolean isBurned;
    private boolean isCleaned;
    private boolean isCryptoIntermediate;
    private boolean isDeCryptFailed;
    private boolean isDing;
    private boolean isEphemeral;
    private boolean isFlag;
    private boolean isForwardFromFriend;
    private boolean isFromMe;
    private boolean isIncludeDocUrl;
    private boolean isNewTopic;
    private boolean isNoTraceDelete;
    private boolean isNotified;
    private boolean isOnTimeDel;
    private boolean isOtherAtMe;
    private boolean isReEditable;
    private boolean isRemoved;
    private boolean isRestricted;
    private boolean isSecretChatDecryptedFailed;
    private boolean isShared;
    private boolean isSourceFileDelete;
    private boolean isStaticResourceMessageRecalled;
    private boolean isSyncMsgDep;
    private boolean isThreadForwardRootMessage;
    private boolean isTranslatedManually;
    private boolean isUntranslatable;
    private boolean isVisible;
    private int mMeReadType;
    private Content messageContent;
    private String messageLanguage;
    private LinkedHashMap<String, com.bytedance.lark.pb.basic.v1.MessageLink> messageLinkMap;
    private HashMap<Integer, String> messageLocalDataInfoMap;
    private int originBadgeCount;
    private String originalSenderId;
    private String parentId;
    private String parentSourceId;
    private PartialReplyInfo partialReplyInfo;
    private int position;
    private String postDraftId;
    private String preprocessKey;
    private List<String> readAtChatterIds;
    private int readCount;
    private String recallerId;
    private RecallerIdentity recallerIdentity;
    private int replyCount;
    private String replyInThreadDraftId;
    private String rootId;
    private String scheduleDraftId;
    private MessageSecurityESCReviewExtra securityESCReviewExtra;
    private SendStatus sendStatus;
    private MessageSenderAppInfo senderAppInfo;
    private boolean setGrey;
    private String sourceId;
    private SourceType sourceType;
    private Status status;
    private long streamSequenceId;
    private MessageStreamStatus streamStatus;
    private SyncToChatMessageType syncToChatMessageType;
    private long syncToChatRelatedMessageId;
    private long syncToChatThreadRootId;
    private String textDraftId;
    private int threadBadgeCount;
    private String threadId;
    private ThreadMessageType threadMessageType;
    private int threadPosition;
    private int translateDisplayRule;
    private String translateLanguage;
    private Type type;
    private int unReadCount;
    private long updateTime;
    private ValidateIMFileResult validateIMFileResult;

    public static final enum FileDeletedStatus extends Enum<FileDeletedStatus> {
        public static final FileDeletedStatus FREED_UP = null;
        public static final FileDeletedStatus NORMAL = null;
        public static final FileDeletedStatus RECALLED = null;
        public static final FileDeletedStatus RECOVERABLE = null;
        public static final FileDeletedStatus UNRECOVERABLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FileDeletedStatus[] f415218a = null;
        private final int value;

        static {
            FileDeletedStatus r100 = new FileDeletedStatus(EffectConstants.NORMAL, 0, 0);
            NORMAL = r100;
            FileDeletedStatus r101 = new FileDeletedStatus("RECOVERABLE", 1, 1);
            RECOVERABLE = r101;
            FileDeletedStatus r102 = new FileDeletedStatus("UNRECOVERABLE", 2, 2);
            UNRECOVERABLE = r102;
            FileDeletedStatus r103 = new FileDeletedStatus("RECALLED", 3, 3);
            RECALLED = r103;
            FileDeletedStatus r104 = new FileDeletedStatus("FREED_UP", 4, 4);
            FREED_UP = r104;
            f415218a = new FileDeletedStatus[]{r100, r101, r102, r103, r104};
        }

        public static FileDeletedStatus[] values() {
            return (FileDeletedStatus[]) f415218a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static FileDeletedStatus fromValue(int r100) {
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L16;
            if (r100 == 4) goto L14;
            return null;
        L14:
            return FREED_UP;
        L16:
            return RECALLED;
        L18:
            return UNRECOVERABLE;
        L20:
            return RECOVERABLE;
        L22:
            return NORMAL;
        }

        public static FileDeletedStatus valueOf(String r100) {
            return (FileDeletedStatus) r27.a.a(FileDeletedStatus.class, r100);
        }

        public FileDeletedStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum FromType extends Enum<FromType> {
        public static final FromType BOT = null;
        public static final FromType USER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FromType[] f415219a = null;
        private final int value;

        static {
            FromType r100 = new FromType(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 0, 1);
            USER = r100;
            FromType r101 = new FromType("BOT", 1, 2);
            BOT = r101;
            f415219a = new FromType[]{r100, r101};
        }

        public static FromType[] values() {
            return (FromType[]) f415219a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static FromType forNumber(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return BOT;
        L11:
            return USER;
        }

        public static FromType valueOf(String r100) {
            return (FromType) r27.a.a(FromType.class, r100);
        }

        public static FromType valueOf(int r100) {
            return forNumber(r100);
        }

        public FromType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum RecallerIdentity extends Enum<RecallerIdentity> {
        public static final RecallerIdentity ADMINISTRATOR = null;
        public static final RecallerIdentity DOUBAO_QUERY_OWNER = null;
        public static final RecallerIdentity ENTERPRISE_ADMINISTRATOR = null;
        public static final RecallerIdentity GROUP_ADMIN = null;
        public static final RecallerIdentity OWNER = null;
        public static final RecallerIdentity UNKNOWN_IDENTITY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RecallerIdentity[] f415220a = null;
        private final int value;

        static {
            RecallerIdentity r100 = new RecallerIdentity("UNKNOWN_IDENTITY", 0, 0);
            UNKNOWN_IDENTITY = r100;
            RecallerIdentity r101 = new RecallerIdentity("OWNER", 1, 1);
            OWNER = r101;
            RecallerIdentity r102 = new RecallerIdentity("ADMINISTRATOR", 2, 2);
            ADMINISTRATOR = r102;
            RecallerIdentity r103 = new RecallerIdentity("GROUP_ADMIN", 3, 3);
            GROUP_ADMIN = r103;
            RecallerIdentity r104 = new RecallerIdentity("ENTERPRISE_ADMINISTRATOR", 4, 4);
            ENTERPRISE_ADMINISTRATOR = r104;
            RecallerIdentity r105 = new RecallerIdentity("DOUBAO_QUERY_OWNER", 5, 5);
            DOUBAO_QUERY_OWNER = r105;
            f415220a = new RecallerIdentity[]{r100, r101, r102, r103, r104, r105};
        }

        public static RecallerIdentity[] values() {
            return (RecallerIdentity[]) f415220a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static RecallerIdentity forNumber(int r100) {
            if (r100 == 0) goto L26;
            if (r100 == 1) goto L24;
            if (r100 == 2) goto L22;
            if (r100 == 3) goto L20;
            if (r100 == 4) goto L18;
            if (r100 == 5) goto L16;
            return UNKNOWN_IDENTITY;
        L16:
            return DOUBAO_QUERY_OWNER;
        L18:
            return ENTERPRISE_ADMINISTRATOR;
        L20:
            return GROUP_ADMIN;
        L22:
            return ADMINISTRATOR;
        L24:
            return OWNER;
        L26:
            return UNKNOWN_IDENTITY;
        }

        public static RecallerIdentity valueOf(String r100) {
            return (RecallerIdentity) r27.a.a(RecallerIdentity.class, r100);
        }

        public static RecallerIdentity valueOf(int r100) {
            return forNumber(r100);
        }

        public RecallerIdentity(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum SourceType extends Enum<SourceType> {
        public static final SourceType TYPE_FROM_CHAT_HISTORY = null;
        public static final SourceType TYPE_FROM_CHAT_PIN = null;
        public static final SourceType TYPE_FROM_FAVORITE = null;
        public static final SourceType TYPE_FROM_FLAG = null;
        public static final SourceType TYPE_FROM_MERGEFORWARD = null;
        public static final SourceType TYPE_FROM_MESSAGE = null;
        public static final SourceType TYPE_FROM_TODO_REFER_RESOURCE = null;
        public static final SourceType TYPE_FROM_UNKONWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SourceType[] f415221a = null;
        private final int value;

        static {
            SourceType r100 = new SourceType("TYPE_FROM_UNKONWN", 0, 0);
            TYPE_FROM_UNKONWN = r100;
            SourceType r101 = new SourceType("TYPE_FROM_MESSAGE", 1, 1);
            TYPE_FROM_MESSAGE = r101;
            SourceType r102 = new SourceType("TYPE_FROM_MERGEFORWARD", 2, 2);
            TYPE_FROM_MERGEFORWARD = r102;
            SourceType r103 = new SourceType("TYPE_FROM_FAVORITE", 3, 3);
            TYPE_FROM_FAVORITE = r103;
            SourceType r104 = new SourceType("TYPE_FROM_TODO_REFER_RESOURCE", 4, 4);
            TYPE_FROM_TODO_REFER_RESOURCE = r104;
            SourceType r105 = new SourceType("TYPE_FROM_CHAT_PIN", 5, 5);
            TYPE_FROM_CHAT_PIN = r105;
            SourceType r110 = new SourceType("TYPE_FROM_CHAT_HISTORY", 6, 6);
            TYPE_FROM_CHAT_HISTORY = r110;
            SourceType r111 = new SourceType("TYPE_FROM_FLAG", 7, 7);
            TYPE_FROM_FLAG = r111;
            f415221a = new SourceType[]{r100, r101, r102, r103, r104, r105, r110, r111};
        }

        public static SourceType[] values() {
            return (SourceType[]) f415221a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static SourceType valueOf(int r100) {
            switch(r100) {
                case 0: goto L12;
                case 1: goto L20;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L15;
                case 7: goto L14;
                default: goto L13;
            };
        L13:
            return TYPE_FROM_UNKONWN;
        L14:
            return TYPE_FROM_FLAG;
        L15:
            return TYPE_FROM_CHAT_HISTORY;
        L16:
            return TYPE_FROM_CHAT_PIN;
        L17:
            return TYPE_FROM_TODO_REFER_RESOURCE;
        L18:
            return TYPE_FROM_FAVORITE;
        L19:
            return TYPE_FROM_MERGEFORWARD;
        L20:
            return TYPE_FROM_MESSAGE;
        L12:
            return TYPE_FROM_UNKONWN;
        }

        public static SourceType valueOf(String r100) {
            return (SourceType) r27.a.a(SourceType.class, r100);
        }

        public SourceType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum Status extends Enum<Status> {
        public static final Status DELETED = null;
        public static final Status MODIFIED = null;
        public static final Status NORMAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Status[] f415222a = null;
        private final int value;

        static {
            Status r100 = new Status(EffectConstants.NORMAL, 0, 1);
            NORMAL = r100;
            Status r101 = new Status("DELETED", 1, 2);
            DELETED = r101;
            Status r102 = new Status("MODIFIED", 2, 3);
            MODIFIED = r102;
            f415222a = new Status[]{r100, r101, r102};
        }

        public static Status[] values() {
            return (Status[]) f415222a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static Status forNumber(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return MODIFIED;
        L13:
            return DELETED;
        L15:
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

    public static final enum SyncToChatMessageType extends Enum<SyncToChatMessageType> {
        public static final SyncToChatMessageType SYNC_TO_CHAT_SOURCE_MESSAGE = null;
        public static final SyncToChatMessageType SYNC_TO_CHAT_TARGET_MESSAGE = null;
        public static final SyncToChatMessageType UNKNOWN_SYNC_TO_CHAT_MESSAGE_TYPE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SyncToChatMessageType[] f415223a = null;
        private final int value;

        static {
            SyncToChatMessageType r100 = new SyncToChatMessageType("UNKNOWN_SYNC_TO_CHAT_MESSAGE_TYPE", 0, 0);
            UNKNOWN_SYNC_TO_CHAT_MESSAGE_TYPE = r100;
            SyncToChatMessageType r101 = new SyncToChatMessageType("SYNC_TO_CHAT_TARGET_MESSAGE", 1, 1);
            SYNC_TO_CHAT_TARGET_MESSAGE = r101;
            SyncToChatMessageType r102 = new SyncToChatMessageType("SYNC_TO_CHAT_SOURCE_MESSAGE", 2, 2);
            SYNC_TO_CHAT_SOURCE_MESSAGE = r102;
            f415223a = new SyncToChatMessageType[]{r100, r101, r102};
        }

        public static SyncToChatMessageType[] values() {
            return (SyncToChatMessageType[]) f415223a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static SyncToChatMessageType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return SYNC_TO_CHAT_SOURCE_MESSAGE;
        L12:
            return SYNC_TO_CHAT_TARGET_MESSAGE;
        L14:
            return UNKNOWN_SYNC_TO_CHAT_MESSAGE_TYPE;
        }

        public static SyncToChatMessageType valueOf(String r100) {
            return (SyncToChatMessageType) r27.a.a(SyncToChatMessageType.class, r100);
        }

        public SyncToChatMessageType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum ThreadMessageType extends Enum<ThreadMessageType> {
        public static final ThreadMessageType THREAD_REPLY_MESSAGE = null;
        public static final ThreadMessageType THREAD_ROOT_MESSAGE = null;
        public static final ThreadMessageType UNKNOWN_THREAD_MESSAGE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ThreadMessageType[] f415224a = null;
        private final int value;

        static {
            ThreadMessageType r100 = new ThreadMessageType("UNKNOWN_THREAD_MESSAGE", 0, 0);
            UNKNOWN_THREAD_MESSAGE = r100;
            ThreadMessageType r101 = new ThreadMessageType("THREAD_ROOT_MESSAGE", 1, 1);
            THREAD_ROOT_MESSAGE = r101;
            ThreadMessageType r102 = new ThreadMessageType("THREAD_REPLY_MESSAGE", 2, 2);
            THREAD_REPLY_MESSAGE = r102;
            f415224a = new ThreadMessageType[]{r100, r101, r102};
        }

        public static ThreadMessageType[] values() {
            return (ThreadMessageType[]) f415224a.clone();
        }

        public static ThreadMessageType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return THREAD_REPLY_MESSAGE;
        L12:
            return THREAD_ROOT_MESSAGE;
        L14:
            return UNKNOWN_THREAD_MESSAGE;
        }

        public static ThreadMessageType valueOf(String r100) {
            return (ThreadMessageType) r27.a.a(ThreadMessageType.class, r100);
        }

        public ThreadMessageType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum Type extends Enum<Type> {
        public static final Type AUDIO = null;
        public static final Type CALENDAR = null;
        public static final Type CARD = null;
        public static final Type COMMERCIALIZED_HONGBAO = null;
        public static final Type DOUBAO = null;
        public static final Type EMAIL = null;
        public static final Type FILE = null;
        public static final Type FOLDER = null;
        public static final Type GENERAL_CALENDAR = null;
        public static final Type IMAGE = null;
        public static final Type LOCATION = null;
        public static final Type MEDIA = null;
        public static final Type MERGE_FORWARD = null;
        public static final Type POST = null;
        public static final Type RED_PACKET = null;
        public static final Type SHARE_CALENDAR_EVENT = null;
        public static final Type SHARE_GROUP_CHAT = null;
        public static final Type SHARE_USER_CARD = null;
        public static final Type STICKER = null;
        public static final Type SYSTEM = null;
        public static final Type TEXT = null;
        public static final Type TEXT_IMAGE = null;
        public static final Type TODO = null;
        public static final Type UNKNOWN = null;
        public static final Type VIDEO_CHAT = null;
        public static final Type VOTE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f415225a = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, -1);
            UNKNOWN = r100;
            Type r101 = new Type("TEXT_IMAGE", 1, 1);
            TEXT_IMAGE = r101;
            Type r102 = new Type("POST", 2, 2);
            POST = r102;
            Type r103 = new Type("FILE", 3, 3);
            FILE = r103;
            Type r104 = new Type(CardAdapter.TEXT, 4, 4);
            TEXT = r104;
            Type r105 = new Type("IMAGE", 5, 5);
            IMAGE = r105;
            Type r110 = new Type(MediaScene.SYSTEM, 6, 6);
            SYSTEM = r110;
            Type r111 = new Type("AUDIO", 7, 7);
            AUDIO = r111;
            Type r112 = new Type(CommonConstant.RETKEY.EMAIL, 8, 8);
            EMAIL = r112;
            Type r113 = new Type("SHARE_GROUP_CHAT", 9, 9);
            SHARE_GROUP_CHAT = r113;
            Type r114 = new Type("STICKER", 10, 10);
            STICKER = r114;
            Type r115 = new Type("MERGE_FORWARD", 11, 11);
            MERGE_FORWARD = r115;
            Type r106 = new Type("CALENDAR", 12, 12);
            CALENDAR = r106;
            Type r107 = new Type("CARD", 13, 13);
            CARD = r107;
            Type r108 = new Type("MEDIA", 14, 15);
            MEDIA = r108;
            Type r109 = new Type("SHARE_CALENDAR_EVENT", 15, 16);
            SHARE_CALENDAR_EVENT = r109;
            Type r116 = new Type("RED_PACKET", 16, 17);
            RED_PACKET = r116;
            Type r117 = new Type("GENERAL_CALENDAR", 17, 18);
            GENERAL_CALENDAR = r117;
            Type r118 = new Type("VIDEO_CHAT", 18, 19);
            VIDEO_CHAT = r118;
            Type r119 = new Type(HTTP.LOCATION, 19, 20);
            LOCATION = r119;
            Type r120 = new Type("COMMERCIALIZED_HONGBAO", 20, 22);
            COMMERCIALIZED_HONGBAO = r120;
            Type r121 = new Type("SHARE_USER_CARD", 21, 23);
            SHARE_USER_CARD = r121;
            Type r122 = new Type(AlarmSessionType.TODO, 22, 24);
            TODO = r122;
            Type r123 = new Type("FOLDER", 23, 25);
            FOLDER = r123;
            Type r124 = new Type("VOTE", 24, 27);
            VOTE = r124;
            Type r125 = new Type("DOUBAO", 25, 29);
            DOUBAO = r125;
            f415225a = new Type[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125};
        }

        public static Type[] values() {
            return (Type[]) f415225a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static /* synthetic */ int access$000(Type r100) {
            return r100.value;
        }

        public static Type forNumber(int r100) {
            switch(r100) {
                case 1: goto L54;
                case 2: goto L52;
                case 3: goto L50;
                case 4: goto L48;
                case 5: goto L46;
                case 6: goto L44;
                case 7: goto L42;
                case 8: goto L40;
                case 9: goto L38;
                case 10: goto L36;
                case 11: goto L34;
                case 12: goto L32;
                case 13: goto L30;
                case 14: goto L4;
                case 15: goto L28;
                case 16: goto L26;
                case 17: goto L24;
                case 18: goto L22;
                case 19: goto L20;
                case 20: goto L18;
                case 21: goto L4;
                case 22: goto L16;
                case 23: goto L14;
                case 24: goto L12;
                case 25: goto L10;
                case 26: goto L4;
                case 27: goto L8;
                case 28: goto L4;
                case 29: goto L6;
                default: goto L4;
            };
        L4:
            return UNKNOWN;
        L6:
            return DOUBAO;
        L8:
            return VOTE;
        L10:
            return FOLDER;
        L12:
            return TODO;
        L14:
            return SHARE_USER_CARD;
        L16:
            return COMMERCIALIZED_HONGBAO;
        L18:
            return LOCATION;
        L20:
            return VIDEO_CHAT;
        L22:
            return GENERAL_CALENDAR;
        L24:
            return RED_PACKET;
        L26:
            return SHARE_CALENDAR_EVENT;
        L28:
            return MEDIA;
        L30:
            return CARD;
        L32:
            return CALENDAR;
        L34:
            return MERGE_FORWARD;
        L36:
            return STICKER;
        L38:
            return SHARE_GROUP_CHAT;
        L40:
            return EMAIL;
        L42:
            return AUDIO;
        L44:
            return SYSTEM;
        L46:
            return IMAGE;
        L48:
            return TEXT;
        L50:
            return FILE;
        L52:
            return POST;
        L54:
            return TEXT_IMAGE;
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

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f415226a = null;

        static {
            int[] r100 = new int[Type.values().length];
            f415226a = r100;
            r100[Type.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f415226a[Type.MEDIA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f415226a[Type.FILE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f415226a[Type.FOLDER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f415226a[Type.MERGE_FORWARD.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f415226a[Type.TEXT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f415226a[Type.POST.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f415227a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f415228b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f415229c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Type f415230d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f415231e;

        public b() {
            this.f415228b = null;
            this.f415231e = Integer.MIN_VALUE;
        }
    }

    public boolean canShow() {
        if (this.isRemoved == false) goto L5;
    L9:
        return false;
    L5:
        if (this.isVisible == false) goto L9;
        if (this.isBurned == true) goto L9;
        return true;
    }

    public List<String> getAuthFileKeys() {
        ArrayList r100 = new ArrayList();
        if ((getContent() instanceof BaseFileContent) == false) goto L8;
        String r101 = ((BaseFileContent) getContent()).getKey();
        if (TextUtils.isEmpty(r101) == true) goto L33;
        r100.add(r101);
    L33:
        return r100;
    L8:
        if ((getContent() instanceof ImageContent) == false) goto L17;
        ImageSet r102 = ((ImageContent) getContent()).getImageSet();
        if (r102 == null) goto L33;
        if (r102.getOrigin() == null) goto L33;
        String r103 = r102.getOrigin().getKey();
        if (TextUtils.isEmpty(r103) == true) goto L33;
        r100.add(r103);
        goto L33
    L17:
        if ((getContent() instanceof MediaContent) == false) goto L22;
        String r104 = ((MediaContent) getContent()).getKey();
        if (TextUtils.isEmpty(r104) == true) goto L33;
        r100.add(r104);
        goto L33
    L22:
        if ((getContent() instanceof BaseTextContent) == false) goto L33;
        BaseTextContent r105 = (BaseTextContent) getContent();
        r100.addAll(i.k(r105.getRichText()));
        if (CollectionUtils.isEmpty(r105.getAttachments()) == true) goto L33;
        Iterator<File> r106 = r105.getAttachments().iterator();
    L27:
        if (r106.hasNext() == false) goto L33;
        File r107 = r106.next();
        if (r107 == null) goto L27;
        if (TextUtils.isEmpty(r107.key) == true) goto L27;
        r100.add(r107.key);
        goto L27
    }

    public MessageType getMessageType() {
        Type r100 = this.type;
        if (r100 != null) goto L7;
        return MessageType.UNKNOWN;
    L7:
        return MessageType.forNumber(Type.access$000(r100));
    }

    public SendStatus getSendStatus() {
        SendStatus r100 = this.sendStatus;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return SendStatus.SUCCESS;
    }

    public int hashCode() {
        String r100 = this.f415217id;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.chatId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.cId;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public boolean isMeRead() {
        if (this.mMeReadType <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isMessageDisable() {
        if (this.isRemoved == false) goto L5;
    L10:
        return true;
    L5:
        if (this.status == Status.DELETED) goto L10;
        if (this.isVisible == false) goto L10;
        return false;
    }

    public boolean isPreMessage() {
        return TextUtils.equals(this.f415217id, this.cId);
    }

    public boolean isRecalled() {
        if (this.status != Status.DELETED) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isReplyInThreadChildMessage() {
        if (TextUtils.isEmpty(this.threadId) == false) goto L5;
    L7:
        return false;
    L5:
        if (this.threadMessageType != ThreadMessageType.THREAD_REPLY_MESSAGE) goto L7;
        return true;
    }

    public boolean isReplyInThreadRootMessage() {
        if (TextUtils.isEmpty(this.threadId) == false) goto L5;
    L7:
        return false;
    L5:
        if (this.threadMessageType != ThreadMessageType.THREAD_ROOT_MESSAGE) goto L7;
        return true;
    }

    public boolean isSecret() {
        if (this.burnLife <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isSecretEncrypted() {
        return !TextUtils.isEmpty(this.cryptoToken);
    }

    public boolean isSourceFileDelete() {
        if (this.isSourceFileDelete == false) goto L5;
    L8:
        return true;
    L5:
        if (this.isStaticResourceMessageRecalled == true) goto L8;
        return false;
    }

    public boolean isThreadTopic() {
        if (TextUtils.isEmpty(this.threadId) == false) goto L5;
    L7:
        return false;
    L5:
        if (this.threadMessageType != ThreadMessageType.UNKNOWN_THREAD_MESSAGE) goto L7;
        return true;
    }

    public boolean isTranslatedByDisplayRule() {
        int r100 = this.translateDisplayRule;
        if (r100 == 1) goto L6;
        if (r100 == 0) goto L6;
        return true;
    L6:
        return false;
    }

    public boolean needAuth() {
        switch(a.f415226a[this.type.ordinal()]) {
            case 1: goto L15;
            case 2: goto L15;
            case 3: goto L15;
            case 4: goto L15;
            case 5: goto L15;
            case 6: goto L5;
            case 7: goto L5;
            default: goto L18;
        };
    L5:
        BaseTextContent r100 = (BaseTextContent) getContent();
        RichText r101 = r100.getRichText();
        if (r101 == null) goto L14;
        List<String> r102 = r101.getImageIds();
        List<String> r103 = r101.getMediaIds();
        if (CollectionUtils.isEmpty(r102) == true) goto L11;
        return true;
    L11:
        if (CollectionUtils.isEmpty(r103) == true) goto L14;
        return true;
    L14:
        if (CollectionUtils.isEmpty(r100.getAttachments()) == false) goto L15;
        return false;
    L15:
        return true;
    L18:
        return false;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("Message{type=");
        r100.append(getType());
        r100.append(" cId=");
        r100.append(this.cId);
        r100.append(" id=");
        r100.append(this.f415217id);
        r100.append(" cTime=");
        r100.append(this.createTime);
        r100.append(" uTime=");
        r100.append(this.updateTime);
        r100.append(" fromId=");
        r100.append(this.fromId);
        r100.append(" fromChatterTenantId=");
        r100.append(this.fromChatterTenantId);
        r100.append(" isFromMe");
        r100.append(this.isFromMe);
        r100.append(" position=");
        r100.append(this.position);
        r100.append(" badgeCount=");
        r100.append(this.badgeCount);
        r100.append(" status=");
        r100.append(this.status);
        r100.append(" chatId=");
        r100.append(this.chatId);
        r100.append(" parentId=");
        r100.append(this.parentId);
        r100.append(" isDing=");
        r100.append(this.isDing);
        r100.append(" isVisible=");
        r100.append(this.isVisible);
        r100.append(" isBurned=");
        r100.append(this.isBurned);
        r100.append(" meRead=");
        r100.append(this.mMeReadType);
        r100.append(" read=");
        r100.append(this.readCount);
        r100.append(" unRead=");
        r100.append(this.unReadCount);
        r100.append(" reply=");
        r100.append(this.replyCount);
        r100.append(" sendStatus=");
        r100.append(this.sendStatus);
        r100.append(" burnTime=");
        r100.append(this.burnTime);
        r100.append(" syncDependency=");
        r100.append(this.isSyncMsgDep);
        r100.append(" isFlag=");
        r100.append(this.isFlag);
        r100.append(" dlpState=");
        r100.append(this.dlpState);
        r100.append(" validateIMFileResult=");
        r100.append(this.validateIMFileResult);
        r100.append(" FileDeletedStatus=");
        r100.append(this.fileDeletedStatus);
        r100.append(" foldId=");
        r100.append(this.foldId);
        r100.append(" isRestricted=");
        r100.append(this.isRestricted);
        r100.append(" setGrey=");
        r100.append(this.setGrey);
        r100.append(" disabledAction=");
        r100.append(this.disabledAction);
        r100.append(" update=");
        r100.append(this.updateTime);
        r100.append(" secretMessageDecryptedFailed=");
        r100.append(this.isSecretChatDecryptedFailed);
        Content r101 = this.messageContent;
        if (r101 != null) goto L5;
    L10:
        r100.append(" chatDisplayModeSetting=");
        r100.append(this.chatDisplayModeSetting);
        r100.append(" streamStatus=");
        r100.append(this.streamStatus);
        r100.append(" aiMessageType=");
        com.bytedance.lark.pb.basic.v1.Message.AIMessageType r102 = this.aiMessageType;
        if (r102 == null) goto L13;
        Integer r103 = Integer.valueOf(r102.getValue());
    L14:
        r100.append(r103);
        r100.append(" hasFollowUP=");
        r100.append(this.hasFollowUP);
        r100.append(com.alipay.sdk.m.u.i.f25855d);
        return r100.toString();
    L13:
        r103 = null;
        goto L14
    L5:
        if (r101.toString().startsWith(this.messageContent.getClass().getName()) == true) goto L8;
        r100.append(" content=");
        r100.append(this.messageContent.toString());
    L8:
        if ((this.messageContent instanceof ImageContent) == false) goto L10;
        r100.append(" ImageContent content=");
        r100.append(((ImageContent) this.messageContent).getRiskObjectKeys());
        goto L10
    }

    public Message() {
        this.isShared = false;
        this.isVisible = true;
        this.isEphemeral = false;
        this.fileDeletedStatus = FileDeletedStatus.NORMAL;
        this.mMeReadType = 0;
        this.sendStatus = SendStatus.SUCCESS;
        this.originalSenderId = "";
        this.readAtChatterIds = new ArrayList();
        this.atBotIds = new ArrayList();
        this.burnLife = -1;
        this.cryptoToken = null;
        this.isSecretChatDecryptedFailed = false;
        this.isDeCryptFailed = false;
        this.createTimeInMills = 0;
        this.editInfo = new MessageEditInfo();
        this.foldId = "";
        this.isCleaned = false;
        this.chatDisplayModeSetting = ChatDisplayModeSetting.UNKNOWN;
        this.validateIMFileResult = null;
        this.streamStatus = MessageStreamStatus.Unknown;
        this.aiChatModeId = 0;
        this.syncToChatThreadRootId = 0;
        this.syncToChatRelatedMessageId = 0;
        this.isNewTopic = false;
        this.appInfoItemName = null;
        this.senderAppInfo = null;
        this.displayPolicy = null;
        this.hasFollowUP = true;
    }

    public Message clone() {
        Message r100 = (Message) super.clone();     // Catch: CloneNotSupportedException -> L6
        if ((r100.getContent() instanceof MergeForwardContent) == false) goto L5;
        r100.setMessageContent(((MergeForwardContent) r100.getContent()).clone());     // Catch: CloneNotSupportedException -> L6
    L5:
        return r100;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public boolean isMultiResourceAuth() {
        if (getAuthFileKeys().size() > 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isReEditable() {
        if (getStatus() == Status.DELETED) goto L5;
    L7:
        return false;
    L5:
        if (this.isReEditable == false) goto L7;
        return true;
    }

    public boolean canShowAiProcess() {
        return this.canShowAiProcess;
    }

    public com.bytedance.lark.pb.basic.v1.Message.AIMessageLikeFeedbackStatus getAIMessageLikeFeedbackStatus() {
        return this.aiMessageLikeFeedbackStatus;
    }

    public String getAiAnswerRawData() {
        return this.aiAnswerRawData;
    }

    public long getAiChatModeId() {
        return this.aiChatModeId;
    }

    public AIInfo getAiInfo() {
        return this.aiInfo;
    }

    public com.bytedance.lark.pb.basic.v1.Message.AIMessageType getAiMessageType() {
        return this.aiMessageType;
    }

    public AISmartReply getAiSmartReply() {
        return this.aiSmartReply;
    }

    public MessageAnalysisConfig getAnalysisConfigs() {
        return this.analysisConfigs;
    }

    public String getAppInfoItemName() {
        return this.appInfoItemName;
    }

    public List<String> getAtBotIds() {
        return this.atBotIds;
    }

    public int getBadgeCount() {
        return this.badgeCount;
    }

    public int getBurnLife() {
        return this.burnLife;
    }

    public long getBurnTime() {
        return this.burnTime;
    }

    public Channel getChannel() {
        return this.channel;
    }

    public int getCharacterLength() {
        return this.characterLength;
    }

    public ChatDisplayModeSetting getChatDisplayModeSetting() {
        return this.chatDisplayModeSetting;
    }

    public String getChatId() {
        return this.chatId;
    }

    @Override // p5b.b
    public <T extends Content> T getContent() {
        return (T) this.messageContent;
    }

    public int getContentVersion() {
        return this.contentVersion;
    }

    public CotContent getCotContent() {
        return this.cotContent;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public long getCreateTimeInMills() {
        return this.createTimeInMills;
    }

    public String getCryptoToken() {
        return this.cryptoToken;
    }

    public Map<Integer, com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior> getDisabledAction() {
        return this.disabledAction;
    }

    public MessageSourceDisplayPolicy getDisplayPolicy() {
        return this.displayPolicy;
    }

    public MessageDLPState getDlpState() {
        return this.dlpState;
    }

    public MessageEditInfo getEditInfo() {
        return this.editInfo;
    }

    public Map<Class<?>, Object> getExtras() {
        return this.extras;
    }

    public FileDeletedStatus getFileDeletedStatus() {
        return this.fileDeletedStatus;
    }

    public String getFoldId() {
        return this.foldId;
    }

    public String getFromChatterTenantId() {
        return this.fromChatterTenantId;
    }

    public String getFromId() {
        return this.fromId;
    }

    public FromType getFromType() {
        return this.fromType;
    }

    public String getId() {
        return this.f415217id;
    }

    public Map<String, ImageTranslationAbility> getImageTranslationAbility() {
        return this.imageTranslationAbility;
    }

    public int getMeReadType() {
        return this.mMeReadType;
    }

    public <T extends uxb.b> T getMessageContent() {
        return this.messageContent;
    }

    public String getMessageLanguage() {
        return this.messageLanguage;
    }

    public LinkedHashMap<String, com.bytedance.lark.pb.basic.v1.MessageLink> getMessageLinkMap() {
        return this.messageLinkMap;
    }

    public HashMap<Integer, String> getMessageLocalDataInfoMap() {
        return this.messageLocalDataInfoMap;
    }

    public int getOriginBadgeCount() {
        return this.originBadgeCount;
    }

    public String getOriginalSenderId() {
        return this.originalSenderId;
    }

    public String getParentId() {
        return this.parentId;
    }

    public String getParentSourceId() {
        return this.parentSourceId;
    }

    public PartialReplyInfo getPartialReplyInfo() {
        return this.partialReplyInfo;
    }

    public int getPosition() {
        return this.position;
    }

    public String getPostDraftId() {
        return this.postDraftId;
    }

    public String getPreprocessKey() {
        return this.preprocessKey;
    }

    public List<String> getReadAtChatterIds() {
        return this.readAtChatterIds;
    }

    public int getReadCount() {
        return this.readCount;
    }

    public String getRecallerId() {
        return this.recallerId;
    }

    public RecallerIdentity getRecallerIdentity() {
        return this.recallerIdentity;
    }

    public int getReplyCount() {
        return this.replyCount;
    }

    public String getReplyInThreadDraftId() {
        return this.replyInThreadDraftId;
    }

    public String getRootId() {
        return this.rootId;
    }

    public String getScheduleDraftId() {
        return this.scheduleDraftId;
    }

    public MessageSecurityESCReviewExtra getSecurityESCReviewExtra() {
        return this.securityESCReviewExtra;
    }

    public MessageSenderAppInfo getSenderAppInfo() {
        return this.senderAppInfo;
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public SourceType getSourceType() {
        return this.sourceType;
    }

    public Status getStatus() {
        return this.status;
    }

    public long getStreamSequenceId() {
        return this.streamSequenceId;
    }

    public MessageStreamStatus getStreamStatus() {
        return this.streamStatus;
    }

    public SyncToChatMessageType getSyncToChatMessageType() {
        return this.syncToChatMessageType;
    }

    public long getSyncToChatRelatedMessageId() {
        return this.syncToChatRelatedMessageId;
    }

    public long getSyncToChatThreadRootId() {
        return this.syncToChatThreadRootId;
    }

    public String getTextDraftId() {
        return this.textDraftId;
    }

    public int getThreadBadgeCount() {
        return this.threadBadgeCount;
    }

    public String getThreadId() {
        return this.threadId;
    }

    public ThreadMessageType getThreadMessageType() {
        return this.threadMessageType;
    }

    public int getThreadPosition() {
        return this.threadPosition;
    }

    @Override // p5b.b
    public int getTranslateDisplayRule() {
        return this.translateDisplayRule;
    }

    public String getTranslateLanguage() {
        return this.translateLanguage;
    }

    public Type getType() {
        return this.type;
    }

    public int getUnReadCount() {
        return this.unReadCount;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public ValidateIMFileResult getValidateIMFileResult() {
        return this.validateIMFileResult;
    }

    public String getcId() {
        return this.cId;
    }

    public boolean isAtAll() {
        return this.isAtAll;
    }

    public boolean isAtMe() {
        return this.isAtMe;
    }

    public boolean isAutoTranslatedForReceiver() {
        return this.isAutoTranslatedForReceiver;
    }

    public boolean isBadged() {
        return this.isBadged;
    }

    public boolean isBurned() {
        return this.isBurned;
    }

    public boolean isCleaned() {
        return this.isCleaned;
    }

    public boolean isCryptoIntermediate() {
        return this.isCryptoIntermediate;
    }

    public boolean isDecryptFailed() {
        return this.isDeCryptFailed;
    }

    public boolean isDing() {
        return this.isDing;
    }

    public boolean isEphemeral() {
        return this.isEphemeral;
    }

    public boolean isFlag() {
        return this.isFlag;
    }

    public boolean isForwardFromFriend() {
        return this.isForwardFromFriend;
    }

    public boolean isFromMe() {
        return this.isFromMe;
    }

    public boolean isHasFollowUP() {
        return this.hasFollowUP;
    }

    public boolean isIncludeDocUrl() {
        return this.isIncludeDocUrl;
    }

    public boolean isNewTopic() {
        return this.isNewTopic;
    }

    public boolean isNoTraceDelete() {
        return this.isNoTraceDelete;
    }

    public boolean isNotified() {
        return this.isNotified;
    }

    public boolean isOnTimeDel() {
        return this.isOnTimeDel;
    }

    public boolean isOtherAtMe() {
        return this.isOtherAtMe;
    }

    public boolean isRemoved() {
        return this.isRemoved;
    }

    public boolean isRestricted() {
        return this.isRestricted;
    }

    public boolean isSecretChatDecryptedFailed() {
        return this.isSecretChatDecryptedFailed;
    }

    public boolean isSetGrey() {
        return this.setGrey;
    }

    public boolean isShared() {
        return this.isShared;
    }

    public boolean isSyncMsgDep() {
        return this.isSyncMsgDep;
    }

    public boolean isThreadForwardRootMessage() {
        return this.isThreadForwardRootMessage;
    }

    public boolean isTranslatedManually() {
        return this.isTranslatedManually;
    }

    public boolean isUntranslatable() {
        return this.isUntranslatable;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8605clone() throws CloneNotSupportedException {
        return clone();
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Message r100) {
        if (r100 != null) goto L5;
    L25:
        return 0;
    L5:
        if (getPosition() >= r100.getPosition()) goto L8;
        return -1;
    L8:
        if (getPosition() <= r100.getPosition()) goto L11;
        return 1;
    L11:
        if (getPosition() != r100.getPosition()) goto L25;
        if (isPreMessage() != r100.isPreMessage()) goto L22;
        long r101 = getCreateTime();
        long r102 = r100.getCreateTime();
        if (r101 >= r102) goto L17;
        return -1;
    L17:
        if (r101 == r102) goto L27;
        return 1;
    L27:
        return 0;
    L22:
        if (isPreMessage() == false) goto L28;
        return 1;
    L28:
        return -1;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L31:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L31;
        Message r101 = (Message) r100;
        if (Objects.equals(this.f415217id, r101.f415217id) == true) goto L14;
        return false;
    L14:
        if (Objects.equals(this.chatId, r101.chatId) == true) goto L17;
        return false;
    L17:
        if (Objects.equals(this.translateLanguage, r101.translateLanguage) == true) goto L20;
        return false;
    L20:
        if (Objects.equals(Integer.valueOf(this.translateDisplayRule), Integer.valueOf(r101.translateDisplayRule)) == true) goto L22;
        return false;
    L22:
        Type r102 = this.type;
        Type r103 = Type.MERGE_FORWARD;
        if (r102 != r103) goto L30;
        if (r101.type != r103) goto L30;
        if (((MergeForwardContent) this.messageContent).equals((MergeForwardContent) r101.messageContent) == true) goto L30;
        return false;
    L30:
        return Objects.equals(this.cId, r101.cId);
    }

    public boolean exactlyCompare(Message r100) {
        boolean r101 = equals(r100);
        if (r101 == true) goto L6;
        return false;
    L6:
        if (r100.isRemoved() == false) goto L9;
        return false;
    L9:
        if (this.mMeReadType == r100.getMeReadType()) goto L12;
        return false;
    L12:
        if (getStatus() != null) goto L14;
    L20:
        return false;
    L14:
        if (r100.getStatus() == null) goto L20;
        if (getStatus().getNumber() == r100.getStatus().getNumber()) goto L19;
        return false;
    L19:
        return r101;
    }

    public boolean isContentSame(Message r110) {
        if (this.type == r110.getType()) goto L6;
        return false;
    L6:
        if (getStatus() == r110.getStatus()) goto L8;
        return false;
    L8:
        boolean r100 = true;
        if (this.isRemoved == false) goto L14;
        if (r110.isRemoved == false) goto L14;
        return true;
    L14:
        if (getStatus() != Status.DELETED) goto L20;
        if (this.isReEditable != r110.isReEditable) goto L109;
        return true;
    L109:
        return false;
    L20:
        if (getSendStatus() == r110.getSendStatus()) goto L23;
        return false;
    L23:
        if (this.readCount == r110.getReadCount()) goto L25;
    L100:
        return false;
    L25:
        if (this.unReadCount != r110.getUnReadCount()) goto L100;
        if (this.replyCount == r110.getReplyCount()) goto L31;
        return false;
    L31:
        if (getUpdateTime() == r110.getUpdateTime()) goto L34;
        return false;
    L34:
        if (this.isFlag == r110.isFlag()) goto L37;
        return false;
    L37:
        if (this.isRestricted == r110.isRestricted()) goto L40;
        return false;
    L40:
        if (this.setGrey == r110.isSetGrey()) goto L43;
        return false;
    L43:
        if (this.validateIMFileResult == r110.validateIMFileResult) goto L45;
        return false;
    L45:
        HashMap<Integer, com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior> r101 = this.disabledAction;
        HashMap<Integer, com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior> r102 = r110.disabledAction;
        if (r101 != null) goto L49;
        if (r102 != null) goto L49;
    L67:
        if (r100 == true) goto L70;
        return false;
    L70:
        if (this.isSecretChatDecryptedFailed == r110.isSecretChatDecryptedFailed) goto L73;
        return false;
    L73:
        if (TextUtils.equals(getMessageLanguage(), r110.getMessageLanguage()) == false) goto L100;
        if (TextUtils.equals(getTranslateLanguage(), r110.getTranslateLanguage()) == false) goto L100;
        if (getTranslateDisplayRule() != r110.getTranslateDisplayRule()) goto L100;
        if (isAutoTranslatedForReceiver() != r110.isAutoTranslatedForReceiver()) goto L100;
        if (isTranslatedManually() != r110.isTranslatedManually()) goto L100;
        if (y28.a.c(getContent(), r110.getContent()) == true) goto L87;
        return false;
    L87:
        if (Objects.equals(this.streamStatus, r110.streamStatus) == true) goto L90;
        return false;
    L90:
        if (this.streamSequenceId == r110.streamSequenceId) goto L93;
        return false;
    L93:
        if (this.aiMessageLikeFeedbackStatus == r110.aiMessageLikeFeedbackStatus) goto L96;
        return false;
    L96:
        if (this.hasFollowUP == r110.hasFollowUP) goto L99;
        return false;
    L99:
        return y28.a.c(this.aiSmartReply, r110.aiSmartReply);
    L49:
        if (r101 == null) goto L66;
        if (r102 == null) goto L66;
        if (r101.size() != r102.size()) goto L66;
        Iterator<Integer> r103 = r101.keySet().iterator();
    L57:
        if (r103.hasNext() == false) goto L67;
        Integer r104 = r103.next();
        com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior r105 = r101.get(r104);
        com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior r106 = r102.get(r104);
        if (r105 == null) goto L57;
        if (r106 == null) goto L66;
        if (r105.display_mode != r106.display_mode) goto L66;
        if (r105.code.equals(r106.code) == true) goto L57;
    L66:
        r100 = false;
        goto L67
    }

    public boolean isItemSame(Message r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        return this.cId.equals(r100.getcId());
    }

    public void setAIMessageLikeFeedbackStatus(com.bytedance.lark.pb.basic.v1.Message.AIMessageLikeFeedbackStatus r100) {
        this.aiMessageLikeFeedbackStatus = r100;
    }

    public void setAiAnswerRawData(String r100) {
        this.aiAnswerRawData = r100;
    }

    public void setAiChatModeId(long r100) {
        this.aiChatModeId = r100;
    }

    public void setAiInfo(AIInfo r100) {
        this.aiInfo = r100;
    }

    public void setAiMessageType(com.bytedance.lark.pb.basic.v1.Message.AIMessageType r100) {
        this.aiMessageType = r100;
    }

    public void setAiSmartReply(AISmartReply r100) {
        this.aiSmartReply = r100;
    }

    public void setAnalysisConfigs(MessageAnalysisConfig r100) {
        this.analysisConfigs = r100;
    }

    public void setAppInfoItemName(String r100) {
        this.appInfoItemName = r100;
    }

    public void setAtAll(boolean r100) {
        this.isAtAll = r100;
    }

    public void setAtBotIds(List<String> r100) {
        CollectionUtils.resetToList(this.atBotIds, r100);
    }

    public void setAtMe(boolean r100) {
        this.isAtMe = r100;
    }

    public void setAutoTranslatedForReceiver(boolean r100) {
        this.isAutoTranslatedForReceiver = r100;
    }

    public void setBadgeCount(int r100) {
        this.badgeCount = r100;
    }

    public void setBadged(boolean r100) {
        this.isBadged = r100;
    }

    public void setBurnLife(int r100) {
        this.burnLife = r100;
    }

    public void setBurnTime(long r100) {
        this.burnTime = r100;
    }

    public void setBurned(boolean r100) {
        this.isBurned = r100;
    }

    public void setCanShowAiProcess(boolean r100) {
        this.canShowAiProcess = r100;
    }

    public void setChannel(Channel r100) {
        this.channel = r100;
    }

    public void setCharacterLength(int r100) {
        this.characterLength = r100;
    }

    public void setChatDisplayModeSetting(ChatDisplayModeSetting r100) {
        this.chatDisplayModeSetting = r100;
    }

    public void setChatId(String r100) {
        this.chatId = r100;
    }

    public void setCleaned(boolean r100) {
        this.isCleaned = r100;
    }

    public void setContentVersion(int r100) {
        this.contentVersion = r100;
    }

    public void setCotContent(CotContent r100) {
        this.cotContent = r100;
    }

    public void setCreateTime(long r100) {
        this.createTime = r100;
    }

    public void setCreateTimeInMills(long r100) {
        this.createTimeInMills = r100;
    }

    public void setCryptoToken(String r100) {
        this.cryptoToken = r100;
    }

    public void setDeCryptFailed(boolean r100) {
        this.isDeCryptFailed = r100;
    }

    public void setDing(boolean r100) {
        this.isDing = r100;
    }

    public void setDisabledAction(Map<Integer, com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior> r100) {
        if (r100 == null) goto L5;
        this.disabledAction = new HashMap(r100);
        return;
    }

    public void setDisplayPolicy(MessageSourceDisplayPolicy r100) {
        this.displayPolicy = r100;
    }

    public void setDlpState(MessageDLPState r100) {
        this.dlpState = r100;
    }

    public void setEditInfo(MessageEditInfo r100) {
        this.editInfo = r100;
    }

    public void setEphemeral(boolean r100) {
        this.isEphemeral = r100;
    }

    public void setFileDeletedStatus(FileDeletedStatus r100) {
        this.fileDeletedStatus = r100;
    }

    public void setFlag(boolean r100) {
        this.isFlag = r100;
    }

    public void setFoldId(String r100) {
        this.foldId = r100;
    }

    public void setForwardFromFriend(boolean r100) {
        this.isForwardFromFriend = r100;
    }

    public void setFromChatterTenantId(String r100) {
        this.fromChatterTenantId = r100;
    }

    public void setFromId(String r100) {
        this.fromId = r100;
    }

    public void setFromType(FromType r100) {
        this.fromType = r100;
    }

    public void setGrey(boolean r100) {
        this.setGrey = r100;
    }

    public void setHasFollowUP(boolean r100) {
        this.hasFollowUP = r100;
    }

    public void setId(String r100) {
        this.f415217id = r100;
    }

    public void setImageTranslationAbility(Map<String, ImageTranslationAbility> r100) {
        this.imageTranslationAbility = r100;
    }

    public void setIncludeDocUrl(boolean r100) {
        this.isIncludeDocUrl = r100;
    }

    public void setIsCryptoIntermediate(boolean r100) {
        this.isCryptoIntermediate = r100;
    }

    public void setIsFromMe(boolean r100) {
        this.isFromMe = r100;
    }

    public void setIsRestricted(boolean r100) {
        this.isRestricted = r100;
    }

    public void setIsSyncMsgDep(boolean r100) {
        this.isSyncMsgDep = r100;
    }

    public void setIsUnTranslatable(boolean r100) {
        this.isUntranslatable = r100;
    }

    public void setMeReadType(int r100) {
        this.mMeReadType = r100;
    }

    public void setMessageContent(Content r100) {
        this.messageContent = r100;
    }

    public void setMessageLanguage(String r100) {
        this.messageLanguage = r100;
    }

    public void setMessageLinkMap(LinkedHashMap<String, com.bytedance.lark.pb.basic.v1.MessageLink> r100) {
        this.messageLinkMap = r100;
    }

    public void setMessageLocalDataInfoMap(HashMap<Integer, String> r100) {
        this.messageLocalDataInfoMap = r100;
    }

    public void setMessageType(MessageType r100) {
        setType(Type.forNumber(r100.getNumber()));
    }

    public void setNewTopic(boolean r100) {
        this.isNewTopic = r100;
    }

    public void setNoTraceDelete(boolean r100) {
        this.isNoTraceDelete = r100;
    }

    public void setNotified(boolean r100) {
        this.isNotified = r100;
    }

    public void setOnTimeDel(boolean r100) {
        this.isOnTimeDel = r100;
    }

    public void setOriginBadgeCount(int r100) {
        this.originBadgeCount = r100;
    }

    public void setOriginalSenderId(String r100) {
        this.originalSenderId = r100;
    }

    public void setOtherAtMe(boolean r100) {
        this.isOtherAtMe = r100;
    }

    public void setParentId(String r100) {
        this.parentId = r100;
    }

    public void setParentSourceId(String r100) {
        this.parentSourceId = r100;
    }

    public void setPartialReplyInfo(PartialReplyInfo r100) {
        this.partialReplyInfo = r100;
    }

    public void setPosition(int r100) {
        this.position = r100;
    }

    public void setPostDraftId(String r100) {
        this.postDraftId = r100;
    }

    public void setPreprocessKey(String r100) {
        this.preprocessKey = r100;
    }

    public void setReEditable(boolean r100) {
        this.isReEditable = r100;
    }

    public void setReadAtChatterIds(List<String> r100) {
        this.readAtChatterIds = r100;
    }

    public void setReadCount(int r100) {
        this.readCount = r100;
    }

    public void setRecallerId(String r100) {
        this.recallerId = r100;
    }

    public void setRecallerIdentity(RecallerIdentity r100) {
        this.recallerIdentity = r100;
    }

    public void setRemoved(boolean r100) {
        this.isRemoved = r100;
    }

    public void setReplyCount(int r100) {
        this.replyCount = r100;
    }

    public void setReplyInThreadDraftId(String r100) {
        this.replyInThreadDraftId = r100;
    }

    public void setRootId(String r100) {
        this.rootId = r100;
    }

    public void setScheduleDraftId(String r100) {
        this.scheduleDraftId = r100;
    }

    public void setSecretChatDecryptedFailed(boolean r100) {
        this.isSecretChatDecryptedFailed = r100;
    }

    public void setSecurityESCReviewExtra(MessageSecurityESCReviewExtra r100) {
        this.securityESCReviewExtra = r100;
    }

    public void setSendStatus(SendStatus r100) {
        this.sendStatus = r100;
    }

    public void setSenderAppInfo(MessageSenderAppInfo r100) {
        this.senderAppInfo = r100;
    }

    public void setShared(boolean r100) {
        this.isShared = r100;
    }

    public void setSourceFileDelete(boolean r100) {
        this.isSourceFileDelete = r100;
    }

    public void setSourceId(String r100) {
        this.sourceId = r100;
    }

    public void setSourceType(SourceType r100) {
        this.sourceType = r100;
    }

    public void setStatus(Status r100) {
        this.status = r100;
    }

    public void setStreamSequenceId(long r100) {
        this.streamSequenceId = r100;
    }

    public void setStreamStatus(MessageStreamStatus r100) {
        this.streamStatus = r100;
    }

    public void setSyncToChatMessageType(SyncToChatMessageType r100) {
        this.syncToChatMessageType = r100;
    }

    public void setSyncToChatRelatedMessageId(long r100) {
        this.syncToChatRelatedMessageId = r100;
    }

    public void setSyncToChatThreadRootId(long r100) {
        this.syncToChatThreadRootId = r100;
    }

    public void setTextDraftId(String r100) {
        this.textDraftId = r100;
    }

    public void setThreadBadgeCount(int r100) {
        this.threadBadgeCount = r100;
    }

    public void setThreadForwardRootMessage(boolean r100) {
        this.isThreadForwardRootMessage = r100;
    }

    public void setThreadId(String r100) {
        this.threadId = r100;
    }

    public void setThreadMessageType(ThreadMessageType r100) {
        this.threadMessageType = r100;
    }

    public void setThreadPosition(int r100) {
        this.threadPosition = r100;
    }

    public void setTranslateDisplayRule(int r100) {
        this.translateDisplayRule = r100;
    }

    public void setTranslateLanguage(String r100) {
        this.translateLanguage = r100;
    }

    public void setTranslatedManually(boolean r100) {
        this.isTranslatedManually = r100;
    }

    public void setType(Type r100) {
        this.type = r100;
    }

    public void setUnReadCount(int r100) {
        this.unReadCount = r100;
    }

    public void setUpdateTime(long r100) {
        this.updateTime = r100;
    }

    public void setValidateIMFileResult(ValidateIMFileResult r100) {
        this.validateIMFileResult = r100;
    }

    public void setVisible(boolean r100) {
        this.isVisible = r100;
    }

    public void setcId(String r100) {
        this.cId = r100;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Message r100) {
        return compareTo2(r100);
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(y28.b r100) {
        return isContentSame((Message) r100);
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(y28.b r100) {
        return isItemSame((Message) r100);
    }

    public <T> void putExtra(Class<T> r100, T r101) {
        if (this.extras != null) goto L5;
        this.extras = new HashMap();
    L5:
        this.extras.put(r100, r101);
    }

    public AuthorityParam toAuthorityParam(String r100, String r101) {
        AuthorityParam.a r102 = new AuthorityParam.a();
        r102.f409671a = getId();
        String r103 = getFromId();
        int r104 = AuthorityParam.f409659j;
        AuthorityParam.Companion.AuthScene r105 = AuthorityParam.Companion.AuthScene.IM_FILE_LIST_AUTH;
        r102.f409674d = Long.valueOf(AuthorityParam.Companion.a(r103, r105));
        r102.f409673c = Long.valueOf(AuthorityParam.Companion.a(getFromChatterTenantId(), r105));
        r102.f409676f = AuthorityParam.Companion.a(r100, r105);
        r102.f409675e = AuthorityParam.Companion.a(r101, r105);
        AuthorityParam.AuthorityExtraParam r106 = new AuthorityParam.AuthorityExtraParam(isPreMessage(), isFromMe(), isMultiResourceAuth());
        Intrinsics.checkNotNullParameter(r106, "authorityExtraParam");
        r102.f409679i = r106;
        r102.f409672b = this.chatId;
        List<String> r107 = getAuthFileKeys();
        Intrinsics.checkNotNullParameter(r107, "fileKeys");
        r102.f409678h = r107;
        return r102.a();
    }
}
