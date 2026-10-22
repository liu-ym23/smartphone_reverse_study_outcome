package com.ss.android.lark.biz.im.api;

import android.text.TextUtils;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.bytedance.lark.pb.basic.v1.AppFeedCardButton;
import com.bytedance.lark.pb.basic.v1.CloudDraftContent;
import com.bytedance.lark.pb.basic.v1.DraftAttachmentSnapshot;
import com.bytedance.lark.pb.basic.v1.Tag;
import com.bytedance.lark.pb.basic.v1.TagData;
import com.bytedance.lark.pb.feed.v1.AIKnowledgeQueryStatus;
import com.bytedance.lark.pb.feed.v1.AppFeedCard;
import com.bytedance.lark.pb.feed.v1.Digest;
import com.obric.miniapp.alarm.AccountType;
import com.ss.android.lark.chat.entity.Item;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.ChatTeamInfo;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.chatter.ChatterCustomStatus;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.reaction.Reaction;
import com.ss.android.lark.chat.export.entity.message.content.SystemMessageType;
import com.ss.android.lark.doc.entity.DocMessage;
import com.ss.android.lark.doc.entity.DocType;
import com.ss.android.lark.feed.app.entity.AutoMuteSettingNoticeType;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public class FeedPreviewInfo implements Comparable<FeedPreviewInfo> {
    public boolean A;
    public DocType B;
    public String C;
    public DocMessage.Type D;
    public String E;
    public boolean E2;
    public String F;
    public boolean F2;
    public Chat.Type G;
    public boolean G1;
    public int G2;
    public Chat.ChatMode H;
    public boolean H0;
    public ChatNotMemberType H1;
    public String H2;
    public Chatter.ChatterType I;
    public boolean I2;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public String f409809J;
    public boolean J2;
    public boolean K;
    public long K2;
    public boolean L;
    public boolean L0;
    public boolean L1;
    public boolean L2;
    public String M;
    public List<AtInfo> M1;
    public boolean M2;
    public boolean N;
    public c N2;
    public List<UrgentInfo> O;
    public AppFeedCard.PreviewStatus O2;
    public boolean P;
    public ArrayList<Reaction> P0;
    public String P1;
    public List<AppFeedCardButton> P2;
    public boolean Q;
    public String Q1;
    public AIKnowledgeQueryStatus Q2;
    public boolean R;
    public boolean R2;
    public boolean S;
    public boolean S1;
    public AutoMuteSettingNoticeType S2;
    public boolean T;
    public String T1;
    public boolean T2;
    public boolean U;
    public boolean U2;
    public boolean V;
    public String V0;
    public String V1;
    public List<Tag> W;
    public TagData X;
    public FocusInfo Y;
    public int Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f409810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f409811b;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public int f409812b1;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    public String f409813b2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f409814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FeedCard.Type f409815d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FeedCard.FeedType f409816e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f409817f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f409818g;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public boolean f409819g1;

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    public boolean f409820g2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f409821h;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public List<Item> f409822h1;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public String f409823h2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f409824i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f409825j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f409826k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f409827k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public List<FeedTeamInfo> f409828k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f409829l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f409830m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f409831n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f409832o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public AtInfo f409833p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public Digest f409834p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public List<ChatTeamInfo> f409835p1;

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    public List<com.bytedance.lark.pb.basic.v1.Chatter.ChatterCustomStatus> f409836p2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f409837q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public MuteUrgentInfo f409838r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public a f409839s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public EntityStatus f409840t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f409841u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Message.Type f409842v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public boolean f409843v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public List<ChatterCustomStatus> f409844v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public SystemMessageType f409845w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public CardContentType f409846x;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public boolean f409847x1;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    public Chat.Role f409848x2;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public VideoChatContentType f409849y;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public boolean f409850y1;

    /* JADX INFO: renamed from: y2, reason: collision with root package name */
    public int f409851y2;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f409852z;

    public static class AtInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f409853a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AtType f409854b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f409855c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f409856d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f409857e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f409858f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f409859g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f409860h;

        public static final enum AtType extends Enum<AtType> {
            public static final AtType ALL = null;
            public static final AtType UNKNOWN = null;
            public static final AtType USER = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ AtType[] f409861a = null;
            private int value;

            static {
                AtType r100 = new AtType("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                AtType r101 = new AtType(AccountType.ALL, 1, 1);
                ALL = r101;
                AtType r102 = new AtType(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 2, 2);
                USER = r102;
                f409861a = new AtType[]{r100, r101, r102};
            }

            public static AtType[] values() {
                return (AtType[]) f409861a.clone();
            }

            public int getValue() {
                return this.value;
            }

            public static /* synthetic */ int access$000(AtType r100) {
                return r100.value;
            }

            public static AtType getSource(int r100) {
                AtType[] r101 = values();
                int r102 = r101.length;
                int r103 = 0;
            L3:
                if (r103 >= r102) goto L9;
                AtType r104 = r101[r103];
                if (r104.getValue() == r100) goto L6;
                r103 = r103 + 1;
                goto L3
            L6:
                return r104;
            L9:
                return UNKNOWN;
            }

            public static AtType valueOf(String r100) {
                return (AtType) r27.a.a(AtType.class, r100);
            }

            public AtType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public AtInfo() {
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof AtInfo) == true) goto L5;
            return false;
        L5:
            AtInfo r101 = (AtInfo) r100;
            if (TextUtils.equals(this.f409856d, r101.f409856d) == true) goto L9;
            return false;
        L9:
            if (TextUtils.equals(this.f409853a, r101.f409853a) == true) goto L12;
            return false;
        L12:
            if (TextUtils.equals(this.f409855c, r101.f409855c) == true) goto L15;
            return false;
        L15:
            if (AtType.access$000(this.f409854b) == AtType.access$000(r101.f409854b)) goto L18;
            return false;
        L18:
            if (TextUtils.equals(this.f409857e, r101.f409857e) == true) goto L20;
            return false;
        L20:
            return true;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface CanSetStrangerType {
        public static final int FALSE = 2;
        public static final int NONE = 0;
        public static final int TRUE = 1;
    }

    public static final enum CardContentType extends Enum<CardContentType> {
        public static final CardContentType TEXT = null;
        public static final CardContentType UNKNOWN = null;
        public static final CardContentType VCHAT = null;
        public static final CardContentType VOTE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CardContentType[] f409862a = null;
        int value;

        static {
            CardContentType r100 = new CardContentType("UNKNOWN", 0, -1);
            UNKNOWN = r100;
            CardContentType r101 = new CardContentType("VOTE", 1, 1);
            VOTE = r101;
            CardContentType r102 = new CardContentType(CardAdapter.TEXT, 2, 2);
            TEXT = r102;
            CardContentType r103 = new CardContentType("VCHAT", 3, 3);
            VCHAT = r103;
            f409862a = new CardContentType[]{r100, r101, r102, r103};
        }

        public static CardContentType[] values() {
            return (CardContentType[]) f409862a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static CardContentType forNumber(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return UNKNOWN;
        L11:
            return VCHAT;
        L13:
            return TEXT;
        L15:
            return VOTE;
        }

        public static CardContentType valueOf(String r100) {
            return (CardContentType) r27.a.a(CardContentType.class, r100);
        }

        public static CardContentType valueOf(int r100) {
            return forNumber(r100);
        }

        public CardContentType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum EntityStatus extends Enum<EntityStatus> {
        public static final EntityStatus FAILED = null;
        public static final EntityStatus NORMAL = null;
        public static final EntityStatus PENDING = null;
        public static final EntityStatus READ = null;
        public static final EntityStatus UNKNOWN = null;
        public static final EntityStatus UNREAD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EntityStatus[] f409863a = null;
        private int value;

        static {
            EntityStatus r100 = new EntityStatus("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            EntityStatus r101 = new EntityStatus(EffectConstants.NORMAL, 1, 1);
            NORMAL = r101;
            EntityStatus r102 = new EntityStatus("PENDING", 2, 2);
            PENDING = r102;
            EntityStatus r103 = new EntityStatus("FAILED", 3, 3);
            FAILED = r103;
            EntityStatus r104 = new EntityStatus("READ", 4, 4);
            READ = r104;
            EntityStatus r105 = new EntityStatus("UNREAD", 5, 5);
            UNREAD = r105;
            f409863a = new EntityStatus[]{r100, r101, r102, r103, r104, r105};
        }

        public static EntityStatus[] values() {
            return (EntityStatus[]) f409863a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static EntityStatus getSource(int r100) {
            EntityStatus[] r101 = values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L9;
            EntityStatus r104 = r101[r103];
            if (r104.getValue() == r100) goto L6;
            r103 = r103 + 1;
            goto L3
        L6:
            return r104;
        L9:
            return UNKNOWN;
        }

        public static EntityStatus valueOf(String r100) {
            return (EntityStatus) r27.a.a(EntityStatus.class, r100);
        }

        public EntityStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum VideoChatContentType extends Enum<VideoChatContentType> {
        public static final VideoChatContentType CHAT_ROOM_CARD = null;
        public static final VideoChatContentType MEETING_CARD = null;
        public static final VideoChatContentType UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ VideoChatContentType[] f409864a = null;
        int value;

        static {
            VideoChatContentType r100 = new VideoChatContentType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            VideoChatContentType r101 = new VideoChatContentType("MEETING_CARD", 1, 1);
            MEETING_CARD = r101;
            VideoChatContentType r102 = new VideoChatContentType("CHAT_ROOM_CARD", 2, 2);
            CHAT_ROOM_CARD = r102;
            f409864a = new VideoChatContentType[]{r100, r101, r102};
        }

        public static VideoChatContentType[] values() {
            return (VideoChatContentType[]) f409864a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static VideoChatContentType forNumber(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return UNKNOWN;
        L9:
            return CHAT_ROOM_CARD;
        L11:
            return MEETING_CARD;
        }

        public static VideoChatContentType valueOf(String r100) {
            return (VideoChatContentType) r27.a.a(VideoChatContentType.class, r100);
        }

        public static VideoChatContentType valueOf(int r100) {
            return forNumber(r100);
        }

        public VideoChatContentType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f409865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CloudDraftContent f409866b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public DraftAttachmentSnapshot f409867c;

        public a() {
        }

        public final String toString() {
            return "[" + this.f409865a + "]";
        }
    }

    public final String a() {
        FeedCard.Type r100 = this.f409815d;
        if (r100 != FeedCard.Type.MSG_THREAD) goto L11;
        if (this.G != Chat.Type.P2P) goto L9;
        return this.f409809J;
    L9:
        return this.f409813b2;
    L11:
        if (r100 != FeedCard.Type.THREAD) goto L15;
        return this.f409813b2;
    L15:
        if (this.G != Chat.Type.P2P) goto L19;
        return this.f409809J;
    L19:
        return this.f409810a;
    }

    public FeedPreviewInfo() {
        this.O = new ArrayList();
        this.f409819g1 = true;
        this.f409851y2 = 0;
        this.E2 = false;
        this.F2 = false;
        this.G2 = 0;
        this.S2 = AutoMuteSettingNoticeType.UNKNOWN;
        this.T2 = true;
        this.U2 = false;
    }

    @Override // java.lang.Comparable
    public final int compareTo(FeedPreviewInfo r100) {
        FeedPreviewInfo r101 = r100;
        if (r101 == null) goto L13;
        long r102 = this.f409829l;
        long r103 = r101.f409829l;
        if (r102 >= r103) goto L8;
        return 1;
    L8:
        if (r102 <= r103) goto L12;
        return -1;
    L12:
        return 0;
    L13:
        return 0;
    }
}
