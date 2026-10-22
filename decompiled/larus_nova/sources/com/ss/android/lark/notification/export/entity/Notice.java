package com.ss.android.lark.notification.export.entity;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes36.dex */
public class Notice {
    public String content;
    public long createTime;
    public Extra extra;
    public boolean isFromBackgroundUser;
    public String key;
    public String messageId;
    public final Object pbNotification;
    public int position;
    public boolean shouldNotify;
    public int state;
    public String title;
    public int type;
    public String voipParams;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ChannelType {
        public static final int CHAT = 1;
        public static final int DOC = 3;
        public static final int EMAIL = 2;
        public static final int UNKNOWN = 0;
    }

    public static class Extra {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f433057a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ChatType f433058b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f433059c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ChatMode f433060d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f433061e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f433062f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f433063g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f433064h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f433065i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f433066j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f433067k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f433068l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f433069m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public String f433070n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public String f433071o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public String f433072p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f433073q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public Boolean f433074r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public String f433075s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public String f433076t;

        public static final enum ChatMode extends Enum<ChatMode> {
            public static final ChatMode DEFAULT = null;
            public static final ChatMode THREAD = null;
            public static final ChatMode THREAD_V2 = null;
            public static final ChatMode UNKNOWN = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ ChatMode[] f433077a = null;
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
                f433077a = new ChatMode[]{r100, r101, r102, r103};
            }

            public static ChatMode[] values() {
                return (ChatMode[]) f433077a.clone();
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

        public static final enum ChatType extends Enum<ChatType> {
            public static final ChatType GROUP = null;
            public static final ChatType P2P = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ ChatType[] f433078a = null;
            private final int value;

            static {
                ChatType r100 = new ChatType("P2P", 0, 1);
                P2P = r100;
                ChatType r101 = new ChatType("GROUP", 1, 2);
                GROUP = r101;
                f433078a = new ChatType[]{r100, r101};
            }

            public static ChatType[] values() {
                return (ChatType[]) f433078a.clone();
            }

            public int getNumber() {
                return this.value;
            }

            public static ChatType forNumber(int r100) {
                if (r100 == 1) goto L11;
                if (r100 == 2) goto L9;
                return null;
            L9:
                return GROUP;
            L11:
                return P2P;
            }

            public static ChatType valueOf(String r100) {
                return (ChatType) r27.a.a(ChatType.class, r100);
            }

            public static ChatType valueOf(int r100) {
                return forNumber(r100);
            }

            public ChatType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public Extra() {
            this.f433057a = "";
            this.f433058b = null;
            this.f433059c = "";
            new ArrayList();
            this.f433060d = null;
            this.f433061e = "";
            this.f433062f = false;
            this.f433063g = "";
            this.f433064h = 0;
            this.f433069m = null;
            this.f433070n = null;
            this.f433071o = null;
            this.f433072p = null;
            this.f433073q = false;
            this.f433074r = Boolean.FALSE;
            this.f433075s = null;
            this.f433076t = null;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
        public static final int DELETE = 3;
        public static final int FAILED = 4;
        public static final int NEW = 1;
        public static final int RECALL = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
        public static final int AT = 2;
        public static final int CALENDAR_REMINDER = 10001;
        public static final int CHAT_APPLICATION = 6;
        public static final int CHAT_APPLY = 8;
        public static final int DOC_IMAGE_REPLY = 9;
        public static final int MAIL = 7;
        public static final int MEDIA_UPLOAD = 13;
        public static final int NORMAL = 1;
        public static final int OFFLINE = 20001;
        public static final int OFFLINE_VOIP = 20002;
        public static final int OPEN_APP = 10;
        public static final int OPEN_APP_CHAT = 11;
        public static final int OPEN_APP_FEED = 14;
        public static final int REACTION = 4;
        public static final int TODO_REMINDER = 10006;
        public static final int URGENT = 3;
        public static final int URGENT_ACK = 5;
        public static final int URGENT_FAILED = 12;
        public static final int VC_CALENDAR_PROMPT = 10005;
        public static final int VIDEO_CHAT_RING = 10003;
        public static final int VOIP_MISSED_CALL = 10002;
        public static final int VOIP_RING = 10004;
    }

    public Notice() {
        this(null);
    }

    public boolean isOnTimeDel() {
        return this.extra.f433073q;
    }

    public Notice(Notice r100) {
        this(r100.pbNotification);
        this.messageId = r100.messageId;
        this.state = r100.state;
        this.content = r100.content;
        this.title = r100.title;
        this.type = r100.type;
        this.key = r100.key;
        this.extra = r100.extra;
        this.createTime = r100.createTime;
        this.position = r100.position;
        this.shouldNotify = r100.shouldNotify;
        this.voipParams = r100.voipParams;
        this.isFromBackgroundUser = r100.isFromBackgroundUser;
    }

    public Notice(Object r100) {
        this.extra = new Extra();
        this.shouldNotify = true;
        this.isFromBackgroundUser = false;
        this.pbNotification = r100;
    }
}
