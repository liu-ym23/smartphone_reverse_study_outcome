package com.ss.android.lark.biz.im.api;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import com.bytedance.ee.bear.drive.biz.cache.manual.model.ManualOfflineSyncData;
import com.obric.miniapp.alarm.AccountType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes34.dex */
public class FeedCard implements Serializable, Comparable<FeedCard> {
    private FeedType feedType;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f409805id;
    private boolean isActive;
    private Type type;
    private long updateTime;

    public static final enum FeedType extends Enum<FeedType> {
        public static final FeedType ALL = null;
        public static final FeedType DONE = null;
        public static final FeedType INBOX = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FeedType[] f409806a = null;
        private int value;

        static {
            FeedType r100 = new FeedType(AccountType.ALL, 0, 0);
            ALL = r100;
            FeedType r101 = new FeedType("INBOX", 1, 1);
            INBOX = r101;
            FeedType r102 = new FeedType("DONE", 2, 2);
            DONE = r102;
            f409806a = new FeedType[]{r100, r101, r102};
        }

        public static FeedType[] values() {
            return (FeedType[]) f409806a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static FeedType forNumber(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return DONE;
        L12:
            return INBOX;
        L14:
            return ALL;
        }

        public static FeedType valueOf(String r100) {
            return (FeedType) r27.a.a(FeedType.class, r100);
        }

        public static FeedType valueOf(int r100) {
            return forNumber(r100);
        }

        public FeedType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum FilterType extends Enum<FilterType> {
        public static final FilterType FILTER_ALL = null;
        public static final FilterType FILTER_CROSS_TENANT = null;
        public static final FilterType FILTER_DOC = null;
        public static final FilterType FILTER_MESSAGE = null;
        public static final FilterType FILTER_SECRET = null;
        public static final FilterType FILTER_THREAD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FilterType[] f409807a = null;
        private int value;

        static {
            FilterType r100 = new FilterType("FILTER_ALL", 0, 100);
            FILTER_ALL = r100;
            FilterType r101 = new FilterType("FILTER_MESSAGE", 1, 101);
            FILTER_MESSAGE = r101;
            FilterType r102 = new FilterType("FILTER_DOC", 2, 103);
            FILTER_DOC = r102;
            FilterType r103 = new FilterType("FILTER_THREAD", 3, 104);
            FILTER_THREAD = r103;
            FilterType r104 = new FilterType("FILTER_SECRET", 4, 1001);
            FILTER_SECRET = r104;
            FilterType r105 = new FilterType("FILTER_CROSS_TENANT", 5, 1002);
            FILTER_CROSS_TENANT = r105;
            f409807a = new FilterType[]{r100, r101, r102, r103, r104, r105};
        }

        public static FilterType[] values() {
            return (FilterType[]) f409807a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static FilterType forNumber(int r100) {
            if (r100 == 100) goto L27;
            if (r100 == 101) goto L25;
            if (r100 == 103) goto L23;
            if (r100 == 104) goto L21;
            if (r100 == 1001) goto L19;
            if (r100 == 1002) goto L17;
            return null;
        L17:
            return FILTER_CROSS_TENANT;
        L19:
            return FILTER_SECRET;
        L21:
            return FILTER_THREAD;
        L23:
            return FILTER_DOC;
        L25:
            return FILTER_MESSAGE;
        L27:
            return FILTER_ALL;
        }

        public static FilterType valueOf(String r100) {
            return (FilterType) r27.a.a(FilterType.class, r100);
        }

        public static FilterType valueOf(int r100) {
            return forNumber(r100);
        }

        public FilterType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum Type extends Enum<Type> {
        public static final Type APP = null;
        public static final Type APP_FEED = null;
        public static final Type BOX = null;
        public static final Type CHAT = null;
        public static final Type DOC = null;
        public static final Type DOUBAO_CONVERSATION = null;
        public static final Type KNOWLEDGE_AI = null;
        public static final Type MSG_THREAD = null;
        public static final Type OPEN_APP_CHAT = null;
        public static final Type SUBSCRIPTION = null;
        public static final Type THREAD = null;
        public static final Type TOPIC = null;
        public static final Type UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f409808a = null;
        private int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type("CHAT", 1, 1);
            CHAT = r101;
            Type r102 = new Type(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 2, 3);
            DOC = r102;
            Type r103 = new Type("THREAD", 3, 4);
            THREAD = r103;
            Type r104 = new Type(ManualOfflineSyncData.DRIVE_TYPE, 4, 5);
            BOX = r104;
            Type r110 = new Type("APP", 5, 6);
            APP = r110;
            Type r111 = new Type("TOPIC", 6, 7);
            TOPIC = r111;
            Type r112 = new Type("OPEN_APP_CHAT", 7, 8);
            OPEN_APP_CHAT = r112;
            Type r113 = new Type("SUBSCRIPTION", 8, 10);
            SUBSCRIPTION = r113;
            Type r114 = new Type("MSG_THREAD", 9, 11);
            MSG_THREAD = r114;
            Type r115 = new Type("APP_FEED", 10, 13);
            APP_FEED = r115;
            Type r105 = new Type("KNOWLEDGE_AI", 11, 14);
            KNOWLEDGE_AI = r105;
            Type r106 = new Type("DOUBAO_CONVERSATION", 12, 15);
            DOUBAO_CONVERSATION = r106;
            f409808a = new Type[]{r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r115, r105, r106};
        }

        public static Type[] values() {
            return (Type[]) f409808a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static Type forNumber(int r100) {
            switch(r100) {
                case 1: goto L26;
                case 2: goto L3;
                case 3: goto L24;
                case 4: goto L22;
                case 5: goto L20;
                case 6: goto L18;
                case 7: goto L16;
                case 8: goto L14;
                case 9: goto L3;
                case 10: goto L12;
                case 11: goto L10;
                case 12: goto L3;
                case 13: goto L3;
                case 14: goto L8;
                case 15: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return DOUBAO_CONVERSATION;
        L8:
            return KNOWLEDGE_AI;
        L10:
            return MSG_THREAD;
        L12:
            return SUBSCRIPTION;
        L14:
            return OPEN_APP_CHAT;
        L16:
            return TOPIC;
        L18:
            return APP;
        L20:
            return BOX;
        L22:
            return THREAD;
        L24:
            return DOC;
        L26:
            return CHAT;
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

    public FeedCard() {
        this.type = Type.UNKNOWN;
    }

    public FeedType getFeedType() {
        return this.feedType;
    }

    public String getId() {
        return this.f409805id;
    }

    public Type getType() {
        return this.type;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public FeedCard(FeedCard r100) {
        this.type = Type.UNKNOWN;
        this.isActive = r100.isActive();
        this.f409805id = r100.getId();
        this.type = r100.getType();
        this.updateTime = r100.getUpdateTime();
        this.feedType = r100.getFeedType();
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(FeedCard r100) {
        long r101 = getUpdateTime();
        long r102 = r100.getUpdateTime();
        if (r101 >= r102) goto L5;
        return -1;
    L5:
        if (r101 != r102) goto L7;
        return 0;
    L7:
        return 1;
    }

    public void setActive(boolean r100) {
        this.isActive = r100;
    }

    public void setFeedType(FeedType r100) {
        this.feedType = r100;
    }

    public void setId(String r100) {
        this.f409805id = r100;
    }

    public void setType(Type r100) {
        this.type = r100;
    }

    public void setUpdateTime(long r100) {
        this.updateTime = r100;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(FeedCard r100) {
        return compareTo2(r100);
    }
}
