package com.ss.android.lark.search.dto.constant;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import com.bytedance.ee.bear.drive.biz.cache.manual.model.ManualOfflineSyncData;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.obric.miniapp.alarm.AccountType;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
public final class SearchCommonConstants {

    public static final enum FeedType extends Enum<FeedType> {
        public static final FeedType APP = null;
        public static final FeedType BOX = null;
        public static final FeedType CHAT = null;
        public static final FeedType DOC = null;
        public static final FeedType MSG_THREAD = null;
        public static final FeedType OPEN_APP_CHAT = null;
        public static final FeedType THREAD = null;
        public static final FeedType TOPIC = null;
        public static final FeedType UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FeedType[] f440134a = null;
        private int value;

        static {
            FeedType r100 = new FeedType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            FeedType r101 = new FeedType("CHAT", 1, 1);
            CHAT = r101;
            FeedType r102 = new FeedType(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 2, 3);
            DOC = r102;
            FeedType r103 = new FeedType("THREAD", 3, 4);
            THREAD = r103;
            FeedType r104 = new FeedType(ManualOfflineSyncData.DRIVE_TYPE, 4, 5);
            BOX = r104;
            FeedType r110 = new FeedType("APP", 5, 6);
            APP = r110;
            FeedType r111 = new FeedType("TOPIC", 6, 7);
            TOPIC = r111;
            FeedType r112 = new FeedType("OPEN_APP_CHAT", 7, 8);
            OPEN_APP_CHAT = r112;
            FeedType r113 = new FeedType("MSG_THREAD", 8, 11);
            MSG_THREAD = r113;
            f440134a = new FeedType[]{r100, r101, r102, r103, r104, r110, r111, r112, r113};
        }

        public static FeedType[] values() {
            return (FeedType[]) f440134a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static FeedType forNumber(int r100) {
            if (r100 == 1) goto L24;
            if (r100 == 11) goto L22;
            switch(r100) {
                case 3: goto L20;
                case 4: goto L18;
                case 5: goto L16;
                case 6: goto L14;
                case 7: goto L12;
                case 8: goto L10;
                default: goto L7;
            };
        L7:
            return null;
        L10:
            return OPEN_APP_CHAT;
        L12:
            return TOPIC;
        L14:
            return APP;
        L16:
            return BOX;
        L18:
            return THREAD;
        L20:
            return DOC;
        L22:
            return MSG_THREAD;
        L24:
            return CHAT;
        }

        public static FeedType valueOf(String r100) {
            return (FeedType) a.a(FeedType.class, r100);
        }

        public static FeedType valueOf(int r100) {
            return forNumber(r100);
        }

        public FeedType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface OpenAppAbilityType {
        public static final int BOT = 1;
        public static final int H5 = 2;
        public static final int LOCAL_COMPONENT = 4;
        public static final int MICRO_APP = 3;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SearchFrom {
        public static final int LOCAL = 0;
        public static final int NET = 1;
    }

    public static final enum SearchHistorySource extends Enum<SearchHistorySource> {
        public static final SearchHistorySource CHAT = null;
        public static final SearchHistorySource EXTERNAL = null;
        public static final SearchHistorySource MAIN = null;
        public static final SearchHistorySource MESSAGE = null;
        public static final SearchHistorySource SPACE = null;
        public static final SearchHistorySource UNKNOWN = null;
        public static final SearchHistorySource USER = null;
        public static final SearchHistorySource WIKI = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SearchHistorySource[] f440135a = null;
        private int value;

        static {
            SearchHistorySource r100 = new SearchHistorySource("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            SearchHistorySource r101 = new SearchHistorySource(AccountType.MAIN, 1, 1);
            MAIN = r101;
            SearchHistorySource r102 = new SearchHistorySource("MESSAGE", 2, 2);
            MESSAGE = r102;
            SearchHistorySource r103 = new SearchHistorySource("SPACE", 3, 3);
            SPACE = r103;
            SearchHistorySource r104 = new SearchHistorySource("EXTERNAL", 4, 4);
            EXTERNAL = r104;
            SearchHistorySource r105 = new SearchHistorySource("WIKI", 5, 5);
            WIKI = r105;
            SearchHistorySource r110 = new SearchHistorySource("CHAT", 6, 6);
            CHAT = r110;
            SearchHistorySource r111 = new SearchHistorySource(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 7, 7);
            USER = r111;
            f440135a = new SearchHistorySource[]{r100, r101, r102, r103, r104, r105, r110, r111};
        }

        public static SearchHistorySource[] values() {
            return (SearchHistorySource[]) f440135a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static SearchHistorySource forNumber(int r100) {
            switch(r100) {
                case 1: goto L18;
                case 2: goto L16;
                case 3: goto L14;
                case 4: goto L12;
                case 5: goto L10;
                case 6: goto L8;
                case 7: goto L6;
                default: goto L4;
            };
        L4:
            return UNKNOWN;
        L6:
            return USER;
        L8:
            return CHAT;
        L10:
            return WIKI;
        L12:
            return EXTERNAL;
        L14:
            return SPACE;
        L16:
            return MESSAGE;
        L18:
            return MAIN;
        }

        public static SearchHistorySource valueOf(String r100) {
            return (SearchHistorySource) a.a(SearchHistorySource.class, r100);
        }

        public static SearchHistorySource valueOf(int r100) {
            return forNumber(r100);
        }

        public SearchHistorySource(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SearchResultType {
        public static final int ACTION = 100000019;
        public static final int AI_KNOWLEDGE = 26;
        public static final int BOX = 9;
        public static final int CALENDAR_EVENT = 10000004;
        public static final int CARD = 100000017;
        public static final int CHAT = 2;
        public static final int CHATTER = 1;
        public static final int CRYPTO_P2P_CHAT = 11;
        public static final int CUSTOMIZATION = 100000016;
        public static final int DEPARTMENT = 17;
        public static final int DOC_FEED = 4;
        public static final int EMAIL = 5;
        public static final int EMAIL_MESSAGE = 7;
        public static final int EXTERNAL = 14;
        public static final int FACILITY = 20;
        public static final int FILE = 10000001;
        public static final int HELPDESK = 10;
        public static final int HISTORY = 100000018;
        public static final int JUMP_TAB = 100000021;
        public static final int LINK = 13;
        public static final int MAIL_CONTACT = 16;
        public static final int MESSAGE = 3;
        public static final int MESSAGE_FILE = 25;
        public static final int NO_RESULT = 10000005;
        public static final int OPEN_APP = 12;
        public static final int PLACE_HOLDER = 100000020;
        public static final int QA_CARD = 100000015;
        public static final int QUICK_SEARCH_FEED_RECOMMEND = 10000007;
        public static final int QUICK_SEARCH_HEADER = 10000006;
        public static final int QUICK_SEARCH_URGENT_RECOMMEND = 10000008;
        public static final int RESOURCE = 22;
        public static final int RESOURCE_IN_CHAT = 100000029;
        public static final int SEARCH_FEEDBACK = 100000013;
        public static final int SERVICE_CARD = 100000014;
        public static final int SHIELD_P2P_CHAT = 100000027;
        public static final int SHOW_MORE = 10000002;
        public static final int SLASH_COMMAND = 21;
        public static final int SMART_SEARCH = 100000012;
        public static final int SPACE = 6;
        public static final int SPACE_HOLDER = 10000003;
        public static final int THREAD = 8;
        public static final int THREAD_FROM_MESSAGE = 100000011;
        public static final int THREAD_GROUP = 10000009;
        public static final int UNFOLD = 100000022;
        public static final int UNKNOWN = 0;
        public static final int USER = 100000010;
        public static final int USER_GROUP = 100000028;
        public static final int WIKI = 15;
        public static final int WIKI_SPACE = 24;
    }

    public static String a(int r100) {
        if (r100 != 20) goto L5;
        return "FACILITY";
    L5:
        if (r100 != 21) goto L7;
        return "SLASH_COMMAND";
    L7:
        if (r100 != 24) goto L9;
        return "WIKI_SPACE";
    L9:
        if (r100 != 25) goto L11;
        return "MESSAGE_FILE";
    L11:
        if (r100 != 10000001) goto L13;
        return "FILE";
    L13:
        if (r100 == 100000027) goto L48;
        switch(r100) {
            case 1: goto L46;
            case 2: goto L44;
            case 3: goto L42;
            case 4: goto L40;
            case 5: goto L38;
            case 6: goto L36;
            case 7: goto L34;
            case 8: goto L32;
            default: goto L15;
        };
    L15:
        switch(r100) {
            case 10: goto L30;
            case 11: goto L28;
            case 12: goto L26;
            case 13: goto L24;
            case 14: goto L22;
            case 15: goto L20;
            case 16: goto L18;
            default: goto L16;
        };
    L16:
        return "UNKNOWN";
    L18:
        return "MAIL_CONTACT";
    L20:
        return "WIKI";
    L22:
        return "EXTERNAL";
    L24:
        return "LINK";
    L26:
        return "OPEN_APP";
    L28:
        return "CRYPTO_P2P_CHAT";
    L30:
        return "HELPDESK";
    L32:
        return "THREAD";
    L34:
        return "EMAIL_MESSAGE";
    L36:
        return "SPACE";
    L38:
        return CommonConstant.RETKEY.EMAIL;
    L40:
        return "DOC_FEED";
    L42:
        return "MESSAGE";
    L44:
        return "CHAT";
    L46:
        return "CHATTER";
    L48:
        return "SHIELD_P2P_CHAT";
    }
}
