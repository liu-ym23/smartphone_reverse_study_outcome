package com.ss.android.lark.feed.app.entity;

import com.bytedance.lark.pb.feed.v1.DisplayFeedRule;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002)*BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u001f\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u0000J\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\"J\u0013\u0010$\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010%H\u0096\u0002J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\"H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u001e¨\u0006+"}, d2 = {"Lcom/ss/android/lark/feed/app/entity/FeedFolder;", "Ljava/io/Serializable;", "id", "", "filterRules", "", "Lcom/ss/android/lark/feed/app/entity/FeedFolder$FolderFilterRule;", "", "additionRules", "", "Lcom/ss/android/lark/feed/app/entity/FeedFolder$AdditionRule;", "systemPresetType", "Lcom/ss/android/lark/feed/app/entity/FeedFilter;", "specialSetting", "Lcom/ss/android/lark/feed/app/entity/FeedFolderSpecialSetting;", "updateTimeMs", "isCompat", "<init>", "(JLjava/util/Map;Ljava/util/List;Lcom/ss/android/lark/feed/app/entity/FeedFilter;Lcom/ss/android/lark/feed/app/entity/FeedFolderSpecialSetting;JZ)V", "getId", "()J", "getFilterRules", "()Ljava/util/Map;", "getAdditionRules", "()Ljava/util/List;", "getSystemPresetType", "()Lcom/ss/android/lark/feed/app/entity/FeedFilter;", "getSpecialSetting", "()Lcom/ss/android/lark/feed/app/entity/FeedFolderSpecialSetting;", "getUpdateTimeMs", "()Z", "isSameFolderWith", "other", "label", "", "tabType", "equals", "", "hashCode", "", "toString", "FolderFilterRule", "AdditionRule", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedFolder implements Serializable {
    private final List<AdditionRule> additionRules;
    private final Map<FolderFilterRule, Boolean> filterRules;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final long f420756id;
    private final boolean isCompat;
    private final FeedFolderSpecialSetting specialSetting;
    private final FeedFilter systemPresetType;
    private final long updateTimeMs;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/feed/app/entity/FeedFolder$AdditionRule;", "Ljava/io/Serializable;", "folderId", "", "filterRules", "Lcom/bytedance/lark/pb/feed/v1/DisplayFeedRule;", "<init>", "(JLcom/bytedance/lark/pb/feed/v1/DisplayFeedRule;)V", "getFolderId", "()J", "getFilterRules", "()Lcom/bytedance/lark/pb/feed/v1/DisplayFeedRule;", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AdditionRule implements Serializable {
        private final DisplayFeedRule filterRules;
        private final long folderId;

        public final DisplayFeedRule getFilterRules() {
            return this.filterRules;
        }

        public final long getFolderId() {
            return this.folderId;
        }

        public AdditionRule(long r100, DisplayFeedRule r101) {
            Intrinsics.checkNotNullParameter(r101, "filterRules");
            this.folderId = r100;
            this.filterRules = r101;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\b\u0086\u0081\u0002\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/feed/app/entity/FeedFolder$FolderFilterRule;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_RULE", "IS_INBOX", "IS_DONE", "IS_BOX", "HAS_UNREAD", "HAS_AT", "HAS_AT_ME", "HAS_AT_ALL", "HAS_STAR", "IS_MUTE", "IS_THREAD", "IS_DOC", "IS_GROUP_CHAT", "IS_P2P_CHAT", "IS_THREAD_GROUP", "IS_ONCALL", "IS_INSTANT_MEETING", "IS_CALENDAR_MEETING", "IS_BOT", "Companion", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FolderFilterRule extends Enum<FolderFilterRule> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ FolderFilterRule[] $VALUES = null;
        public static final Companion Companion = null;
        public static final FolderFilterRule HAS_AT = null;
        public static final FolderFilterRule HAS_AT_ALL = null;
        public static final FolderFilterRule HAS_AT_ME = null;
        public static final FolderFilterRule HAS_STAR = null;
        public static final FolderFilterRule HAS_UNREAD = null;
        public static final FolderFilterRule IS_BOT = null;
        public static final FolderFilterRule IS_BOX = null;
        public static final FolderFilterRule IS_CALENDAR_MEETING = null;
        public static final FolderFilterRule IS_DOC = null;
        public static final FolderFilterRule IS_DONE = null;
        public static final FolderFilterRule IS_GROUP_CHAT = null;
        public static final FolderFilterRule IS_INBOX = null;
        public static final FolderFilterRule IS_INSTANT_MEETING = null;
        public static final FolderFilterRule IS_MUTE = null;
        public static final FolderFilterRule IS_ONCALL = null;
        public static final FolderFilterRule IS_P2P_CHAT = null;
        public static final FolderFilterRule IS_THREAD = null;
        public static final FolderFilterRule IS_THREAD_GROUP = null;
        public static final FolderFilterRule UNKNOWN_RULE = null;
        private final int value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/feed/app/entity/FeedFolder$FolderFilterRule$Companion;", "", "<init>", "()V", "valueOf", "Lcom/ss/android/lark/feed/app/entity/FeedFolder$FolderFilterRule;", "value", "", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            @JvmStatic
            public final FolderFilterRule valueOf(int r100) {
                if (r100 == 1) goto L31;
                if (r100 == 2) goto L49;
                if (r100 == 3) goto L48;
                if (r100 == 20) goto L47;
                switch(r100) {
                    case 10: goto L46;
                    case 11: goto L45;
                    case 12: goto L44;
                    case 13: goto L43;
                    case 14: goto L42;
                    default: goto L11;
                };
            L11:
                switch(r100) {
                    case 30: goto L41;
                    case 31: goto L40;
                    case 32: goto L39;
                    case 33: goto L38;
                    case 34: goto L37;
                    case 35: goto L36;
                    case 36: goto L35;
                    case 37: goto L34;
                    case 38: goto L33;
                    default: goto L32;
                };
            L32:
                return FolderFilterRule.UNKNOWN_RULE;
            L33:
                return FolderFilterRule.IS_BOT;
            L34:
                return FolderFilterRule.IS_CALENDAR_MEETING;
            L35:
                return FolderFilterRule.IS_INSTANT_MEETING;
            L36:
                return FolderFilterRule.IS_ONCALL;
            L37:
                return FolderFilterRule.IS_THREAD_GROUP;
            L38:
                return FolderFilterRule.IS_P2P_CHAT;
            L39:
                return FolderFilterRule.IS_GROUP_CHAT;
            L40:
                return FolderFilterRule.IS_DOC;
            L41:
                return FolderFilterRule.IS_THREAD;
            L42:
                return FolderFilterRule.HAS_STAR;
            L43:
                return FolderFilterRule.HAS_AT_ALL;
            L44:
                return FolderFilterRule.HAS_AT_ME;
            L45:
                return FolderFilterRule.HAS_AT;
            L46:
                return FolderFilterRule.HAS_UNREAD;
            L47:
                return FolderFilterRule.IS_MUTE;
            L48:
                return FolderFilterRule.IS_BOX;
            L49:
                return FolderFilterRule.IS_DONE;
            L31:
                return FolderFilterRule.IS_INBOX;
            }
        }

        private static final /* synthetic */ FolderFilterRule[] $values() {
            return new FolderFilterRule[]{UNKNOWN_RULE, IS_INBOX, IS_DONE, IS_BOX, HAS_UNREAD, HAS_AT, HAS_AT_ME, HAS_AT_ALL, HAS_STAR, IS_MUTE, IS_THREAD, IS_DOC, IS_GROUP_CHAT, IS_P2P_CHAT, IS_THREAD_GROUP, IS_ONCALL, IS_INSTANT_MEETING, IS_CALENDAR_MEETING, IS_BOT};
        }

        public static EnumEntries<FolderFilterRule> getEntries() {
            return $ENTRIES;
        }

        @JvmStatic
        public static final FolderFilterRule valueOf(int r100) {
            return Companion.valueOf(r100);
        }

        static {
            UNKNOWN_RULE = new FolderFilterRule("UNKNOWN_RULE", 0, 0);
            IS_INBOX = new FolderFilterRule("IS_INBOX", 1, 1);
            IS_DONE = new FolderFilterRule("IS_DONE", 2, 2);
            IS_BOX = new FolderFilterRule("IS_BOX", 3, 3);
            HAS_UNREAD = new FolderFilterRule("HAS_UNREAD", 4, 10);
            HAS_AT = new FolderFilterRule("HAS_AT", 5, 11);
            HAS_AT_ME = new FolderFilterRule("HAS_AT_ME", 6, 12);
            HAS_AT_ALL = new FolderFilterRule("HAS_AT_ALL", 7, 13);
            HAS_STAR = new FolderFilterRule("HAS_STAR", 8, 14);
            IS_MUTE = new FolderFilterRule("IS_MUTE", 9, 20);
            IS_THREAD = new FolderFilterRule("IS_THREAD", 10, 30);
            IS_DOC = new FolderFilterRule("IS_DOC", 11, 31);
            IS_GROUP_CHAT = new FolderFilterRule("IS_GROUP_CHAT", 12, 32);
            IS_P2P_CHAT = new FolderFilterRule("IS_P2P_CHAT", 13, 33);
            IS_THREAD_GROUP = new FolderFilterRule("IS_THREAD_GROUP", 14, 34);
            IS_ONCALL = new FolderFilterRule("IS_ONCALL", 15, 35);
            IS_INSTANT_MEETING = new FolderFilterRule("IS_INSTANT_MEETING", 16, 36);
            IS_CALENDAR_MEETING = new FolderFilterRule("IS_CALENDAR_MEETING", 17, 37);
            IS_BOT = new FolderFilterRule("IS_BOT", 18, 38);
            FolderFilterRule[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
            Companion = new Companion(null);
        }

        public static FolderFilterRule[] values() {
            return (FolderFilterRule[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static FolderFilterRule valueOf(String r100) {
            return (FolderFilterRule) a.a(FolderFilterRule.class, r100);
        }

        private FolderFilterRule(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public int hashCode() {
        long r100 = this.f420756id;
        return (int) (r100 ^ (r100 >>> 32));
    }

    public final String label() {
        return this.systemPresetType.toString();
    }

    public final String tabType() {
        return this.systemPresetType.tabType();
    }

    public String toString() {
        return "FeedFolder(id=" + this.f420756id + ", label=" + label() + ", updateTimeMs=" + this.updateTimeMs + ", isCompat=" + this.isCompat + ')';
    }

    public final List<AdditionRule> getAdditionRules() {
        return this.additionRules;
    }

    public final Map<FolderFilterRule, Boolean> getFilterRules() {
        return this.filterRules;
    }

    public final long getId() {
        return this.f420756id;
    }

    public final FeedFolderSpecialSetting getSpecialSetting() {
        return this.specialSetting;
    }

    public final FeedFilter getSystemPresetType() {
        return this.systemPresetType;
    }

    public final long getUpdateTimeMs() {
        return this.updateTimeMs;
    }

    public final boolean isCompat() {
        return this.isCompat;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(FeedFolder.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.feed.app.entity.FeedFolder");
        if (this.f420756id == ((FeedFolder) r100).f420756id) goto L15;
        return false;
    L15:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public final boolean isSameFolderWith(FeedFolder r100) {
        FeedFilter r101 = this.systemPresetType;
        if (r100 == null) goto L5;
        FeedFilter r102 = r100.systemPresetType;
    L6:
        if (r101 != r102) goto L8;
        return true;
    L8:
        return false;
    L5:
        r102 = null;
        goto L6
    }

    public FeedFolder(long r100, Map<FolderFilterRule, Boolean> r101, List<AdditionRule> r102, FeedFilter r103, FeedFolderSpecialSetting r104, long r105, boolean r110) {
        Intrinsics.checkNotNullParameter(r101, "filterRules");
        Intrinsics.checkNotNullParameter(r102, "additionRules");
        Intrinsics.checkNotNullParameter(r103, "systemPresetType");
        Intrinsics.checkNotNullParameter(r104, "specialSetting");
        this.f420756id = r100;
        this.filterRules = r101;
        this.additionRules = r102;
        this.systemPresetType = r103;
        this.specialSetting = r104;
        this.updateTimeMs = r105;
        this.isCompat = r110;
    }

    public /* synthetic */ FeedFolder(long r110, Map r111, List r112, FeedFilter r113, FeedFolderSpecialSetting r114, long r115, boolean r210, int r211, DefaultConstructorMarker r212) {
        if ((r211 & 64) == 0) goto L5;
        boolean r116 = false;
    L6:
        this(r110, r111, r112, r113, r114, r115, r116);
        return;
    L5:
        r116 = r210;
        goto L6
    }
}
