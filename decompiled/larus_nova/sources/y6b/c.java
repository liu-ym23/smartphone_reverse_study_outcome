package y6b;

import com.bytedance.lark.pb.basic.v1.MessageLink;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.entity.chat.ChatDisplayModeSetting;
import com.ss.android.lark.chat.entity.message.AIInfo;
import com.ss.android.lark.chat.entity.message.AIRecommendQuestions;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageDLPState;
import com.ss.android.lark.chat.entity.message.MessageEditInfo;
import com.ss.android.lark.chat.entity.message.MessageFoldDetail;
import com.ss.android.lark.chat.entity.message.MessageSecurityESCReviewExtra;
import com.ss.android.lark.chat.entity.message.MessageSenderAppInfo;
import com.ss.android.lark.chat.entity.message.MessageSourceDisplayPolicy;
import com.ss.android.lark.chat.entity.message.MessageStreamStatus;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.entity.message.Pin;
import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.chat.entity.message.SmartReplyEntryInfo;
import com.ss.android.lark.chat.entity.message.UniversalPinExtra;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import com.ss.android.lark.chat.export.vo.GroupType;
import com.ss.android.lark.ding.entity.DingStatus;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import v5b.a;

/* JADX INFO: loaded from: classes35.dex */
public final class c<T extends v5b.a<?>> extends y6b.a<T> implements y28.b<c<?>> {
    public final String A;
    public final int B;
    public final MessageEditInfo C;
    public final MessageDLPState D;
    public final MessageSecurityESCReviewExtra E;
    public final MessageSenderAppInfo E2;
    public ValidateIMFileResult F;
    public final AIInfo F2;
    public final MessageFoldDetail G;
    public final long G1;
    public final SmartReplyEntryInfo G2;
    public final boolean H;
    public final CharSequence H0;
    public final Message.SyncToChatMessageType H1;
    public final f5b.a H2;
    public final boolean I;
    public final boolean I2;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final Map<Integer, com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior> f566478J;
    public final AIRecommendQuestions J2;
    public final MessageStreamStatus K;
    public boolean K2;
    public final long L;
    public final b L0;
    public final long L1;
    public boolean L2;
    public final List<String> M;
    public final boolean M1;
    public boolean M2;
    public final boolean N;
    public boolean N2;
    public final Message.SourceType O;
    public final Map<Class<?>, Object> O2;
    public final String P;
    public final int P0;
    public final boolean P1;
    public boolean P2;
    public final boolean Q;
    public String Q1;
    public boolean Q2;
    public final String R;
    public int R2;
    public final String S;
    public final Message.ThreadMessageType S1;
    public g S2;
    public final boolean T;
    public int T1;
    public boolean T2;
    public final boolean U;
    public boolean U2;
    public final DingStatus V;
    public final int V0;
    public final boolean V1;
    public boolean V2;
    public final boolean W;
    public int W2;
    public final int X;
    public int X2;
    public final boolean Y;
    public boolean Y2;
    public final long Z;
    public boolean Z2;

    /* JADX INFO: renamed from: a3, reason: collision with root package name */
    public com.bytedance.lark.pb.basic.v1.Message.AIMessageLikeFeedbackStatus f566479a3;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public final y6b.b f566480b1;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    public final ChatDisplayModeSetting f566481b2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f566482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f566483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f566484e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Message.Type f566485f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f566486g;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public final String f566487g1;

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    public List<f> f566488g2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f566489h;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public final boolean f566490h1;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public HashMap<Integer, String> f566491h2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f566492i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f566493j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f566494k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final int f566495k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public final boolean f566496k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f566497l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f566498m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f566499n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final T f566500o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f566501p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final boolean f566502p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public final y6b.b f566503p1;

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    public final Map<String, MessageLink> f566504p2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f566505q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Message.Status f566506r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final SendStatus f566507s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final y6b.b f566508t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final List<ReactionInfo> f566509u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Pin f566510v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public final c<T> f566511v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public final UniversalPinExtra f566512v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f566513w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Message.RecallerIdentity f566514x;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public final PartialReplyInfo f566515x1;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    public final String f566516x2;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f566517y;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public final c<T> f566518y1;

    /* JADX INFO: renamed from: y2, reason: collision with root package name */
    public final MessageSourceDisplayPolicy f566519y2;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f566520z;

    public static final class a<T extends v5b.a<?>> extends y6b.a.AbstractC8309a<T, c<T>, a<T>> {
        public MessageFoldDetail A0;
        public ChatDisplayModeSetting B0;
        public List<f> C0;
        public HashMap<Integer, String> D0;
        public UniversalPinExtra E0;
        public SmartReplyEntryInfo F0;
        public f5b.a G0;
        public AIRecommendQuestions H0;
        public boolean I0;
        public String R;
        public String S;
        public boolean T;
        public boolean U;
        public boolean V;
        public DingStatus W;
        public boolean X;
        public long Y;
        public int Z;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public boolean f566521a0;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public CharSequence f566522b0;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public b f566523c0;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        public int f566524d0;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        public int f566525e0;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        public int f566526f0;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        public boolean f566527g0;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        public y6b.b f566528h0;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        public c<T> f566529i0;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        public PartialReplyInfo f566530j0;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        public c<T> f566531k0;

        /* JADX INFO: renamed from: l0, reason: collision with root package name */
        public long f566532l0;

        /* JADX INFO: renamed from: m0, reason: collision with root package name */
        public Message.SyncToChatMessageType f566533m0;

        /* JADX INFO: renamed from: n0, reason: collision with root package name */
        public long f566534n0;

        /* JADX INFO: renamed from: o0, reason: collision with root package name */
        public y6b.b f566535o0;

        /* JADX INFO: renamed from: p0, reason: collision with root package name */
        public String f566536p0;

        /* JADX INFO: renamed from: q0, reason: collision with root package name */
        public boolean f566537q0;

        /* JADX INFO: renamed from: r0, reason: collision with root package name */
        public boolean f566538r0;

        /* JADX INFO: renamed from: s0, reason: collision with root package name */
        public Message.RecallerIdentity f566539s0;

        /* JADX INFO: renamed from: t0, reason: collision with root package name */
        public boolean f566540t0;

        /* JADX INFO: renamed from: u0, reason: collision with root package name */
        public boolean f566541u0;

        /* JADX INFO: renamed from: v0, reason: collision with root package name */
        public String f566542v0;

        /* JADX INFO: renamed from: w0, reason: collision with root package name */
        public Message.ThreadMessageType f566543w0;

        /* JADX INFO: renamed from: x0, reason: collision with root package name */
        public int f566544x0;

        /* JADX INFO: renamed from: y0, reason: collision with root package name */
        public boolean f566545y0;

        /* JADX INFO: renamed from: z0, reason: collision with root package name */
        public MessageEditInfo f566546z0;

        public final c<T> g() {
            String r100 = this.f566425a;
            String r101 = this.f566426b;
            Message.Type r102 = getType();
            String r103 = this.f566428d;
            String r104 = this.f566429e;
            String r105 = this.f566430f;
            boolean r106 = this.f566431g;
            boolean r107 = this.f566432h;
            boolean r110 = this.f566433i;
            int r111 = this.f566434j;
            long r112 = this.f566435k;
            int r113 = this.f566436l;
            int r108 = this.f566437m;
            boolean r114 = this.f566438n;
            Message.Status r109 = this.f566439o;
            if (r109 != null) goto L5;
            r109 = Message.Status.NORMAL;
        L5:
            Message.Status r115 = r109;
            SendStatus r116 = this.f566440p;
            y6b.b r117 = this.f566441q;
            List<? extends ReactionInfo> r118 = this.f566442r;
            C r119 = this.f566443s;
            Intrinsics.checkNotNull(r119);
            Pin r120 = this.f566444t;
            boolean r121 = this.f566445u;
            boolean r122 = this.f566446v;
            MessageDLPState r123 = this.f566449y;
            MessageSecurityESCReviewExtra r124 = this.f566450z;
            ValidateIMFileResult r125 = this.C;
            boolean r126 = this.A;
            boolean r127 = this.B;
            Map<Integer, com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior> r128 = this.D;
            String r129 = this.R;
            String r130 = this.S;
            boolean r131 = this.T;
            boolean r132 = this.U;
            boolean r133 = this.V;
            DingStatus r134 = this.W;
            int r135 = this.f566526f0;
            boolean r136 = this.X;
            long r137 = this.Y;
            int r138 = this.Z;
            boolean r139 = this.f566521a0;
            CharSequence r140 = this.f566522b0;
            b r141 = this.f566523c0;
            int r142 = this.f566524d0;
            boolean r143 = this.f566537q0;
            String r144 = this.f566536p0;
            y6b.b r145 = this.f566535o0;
            int r146 = this.f566525e0;
            boolean r147 = this.f566527g0;
            y6b.b r148 = this.f566528h0;
            c<T> r149 = this.f566529i0;
            PartialReplyInfo r150 = this.f566530j0;
            c<T> r151 = this.f566531k0;
            long r152 = this.f566532l0;
            Message.SyncToChatMessageType r153 = this.f566533m0;
            long r154 = this.f566534n0;
            boolean r155 = this.f566538r0;
            boolean r156 = this.f566540t0;
            boolean r157 = this.f566541u0;
            Message.RecallerIdentity r158 = this.f566539s0;
            String r159 = this.f566542v0;
            Message.ThreadMessageType r160 = this.f566543w0;
            int r161 = this.f566544x0;
            boolean r162 = this.f566545y0;
            String r163 = this.f566447w;
            int r164 = this.f566448x;
            MessageEditInfo r165 = this.f566546z0;
            MessageFoldDetail r166 = this.A0;
            ChatDisplayModeSetting r167 = this.B0;
            List<f> r168 = this.C0;
            HashMap<Integer, String> r169 = this.D0;
            MessageStreamStatus r170 = this.E;
            long r171 = this.F;
            Map<String, MessageLink> r172 = this.N;
            UniversalPinExtra r173 = this.E0;
            c<T> r174 = new c(r100, r101, r103, r102, r104, r105, r106, r107, r110, r111, r112, r113, r119, r108, r114, r115, r116, r117, r118, r120, r155, r158, r121, r122, r163, r164, r165, r123, r124, r125, r166, r126, r127, r128, r170, r171, this.G, this.H, this.I, r129, r130, r131, r132, r133, r134, r147, r135, r136, r137, r138, r139, r140, r141, r142, r146, r145, r144, r143, r156, r148, r149, r150, r151, r152, r153, r154, r157, r159, r160, r161, r162, r167, r168, r169, r172, r173, this.f566424J, this.K, this.L, this.M, this.F0, this.G0, this.H0, this.I0, this.Q);
            r174.f566422a = this.O;
            r174.f566423b = this.P;
            return r174;
        }

        public a() {
            this.R = "";
            this.S = "";
            this.f566522b0 = "";
            this.B0 = ChatDisplayModeSetting.UNKNOWN;
        }
    }

    public interface b {
    }

    public c() {
        throw null;
    }

    @Override // y6b.a
    public final boolean U() {
        if (this.f566495k0 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean Z() {
        if (this.W2 < 0) goto L5;
    L7:
        return false;
    L5:
        if (isPreMessage() == true) goto L7;
        return true;
    }

    @Override // v5b.c
    public final boolean c() {
        if (this.f566481b2 != ChatDisplayModeSetting.THREAD) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // v5b.c
    public final boolean d() {
        if (this.U2 == false) goto L7;
        return true;
    L7:
        return c();
    }

    @Override // v5b.c
    public final boolean j() {
        if (this.f566506r != Message.Status.DELETED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // v5b.c
    public final boolean na() {
        MessageEditInfo r100 = this.C;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isEdited();
    }

    public final boolean X() {
        if (isPreMessage() == false) goto L5;
        return false;
    L5:
        if (j() == false) goto L7;
        return false;
    L7:
        if (getType() != Message.Type.SYSTEM) goto L9;
        return false;
    L9:
        if (this.U == false) goto L11;
        return false;
    L11:
        if (this.G == null) goto L13;
        return false;
    L13:
        if (MessageDLPState.BLOCK != this.D) goto L15;
        return false;
    L15:
        if (this.f566422a == null) goto L17;
        boolean r100 = true;
    L18:
        if (r100 == true) goto L27;
        return true;
    L27:
        return false;
    L17:
        r100 = false;
        goto L18
    }

    public final boolean Y() {
        if (isPreMessage() == false) goto L5;
    L9:
        return false;
    L5:
        if (Intrinsics.areEqual(this.Q1, this.f566482c) == false) goto L7;
    L8:
        return true;
    L7:
        if (this.S1 != Message.ThreadMessageType.THREAD_ROOT_MESSAGE) goto L9;
        goto L8
    }

    @Override // y6b.a
    public final int A() {
        return this.f566499n;
    }

    @Override // y6b.a
    public final List<ReactionInfo> B() {
        return this.f566509u;
    }

    @Override // y6b.a
    public final int C() {
        return this.X;
    }

    @Override // y6b.a
    public final y6b.b D() {
        return this.f566503p1;
    }

    @Override // y6b.a
    public final Message.RecallerIdentity E() {
        return this.f566514x;
    }

    @Override // y6b.a
    public final String F() {
        return this.R;
    }

    @Override // y6b.a
    public final SendStatus G() {
        return this.f566507s;
    }

    @Override // y6b.a
    public final boolean H() {
        return this.I;
    }

    @Override // y6b.a
    public final String I() {
        return this.P;
    }

    @Override // y6b.a
    public final Message.SourceType J() {
        return this.O;
    }

    @Override // y6b.a
    public final Message.Status K() {
        return this.f566506r;
    }

    @Override // y6b.a
    public final MessageStreamStatus L() {
        return this.K;
    }

    @Override // y6b.a
    public final String M() {
        return this.Q1;
    }

    @Override // y6b.a
    public final ValidateIMFileResult N() {
        return this.F;
    }

    @Override // y6b.a
    public final boolean O() {
        return this.f566520z;
    }

    @Override // y6b.a
    public final boolean P() {
        return this.f566493j;
    }

    @Override // y6b.a
    public final boolean R() {
        return this.W;
    }

    @Override // y6b.a
    public final boolean S() {
        return this.f566513w;
    }

    @Override // v5b.c
    public final y6b.b a() {
        return this.f566508t;
    }

    @Override // v5b.c
    public final T b() {
        return this.f566500o;
    }

    @Override // v5b.c
    public final boolean e() {
        return this.N;
    }

    @Override // v5b.c
    public final String g() {
        return this.f566486g;
    }

    @Override // v5b.c
    public final String getChatId() {
        return this.f566484e;
    }

    @Override // v5b.c
    public final long getCreateTime() {
        return this.f566498m;
    }

    @Override // v5b.c
    @GroupType
    public final int getGroupType() {
        return this.R2;
    }

    @Override // v5b.c
    public final String getId() {
        return this.f566482c;
    }

    @Override // y6b.a, v5b.c, v5b.d
    public Message.Type getType() {
        return this.f566485f;
    }

    @Override // v5b.c
    public final String getcId() {
        return this.f566483d;
    }

    @Override // v5b.c
    public final boolean h() {
        return this.f566492i;
    }

    @Override // v5b.c
    public final String i() {
        return this.S;
    }

    @Override // v5b.c
    public final HashMap<Integer, String> k() {
        return this.f566491h2;
    }

    @Override // v5b.c
    public final boolean m() {
        return this.f566517y;
    }

    @Override // y6b.a
    public final long o() {
        return this.L;
    }

    @Override // y6b.a
    public final int q() {
        return this.f566501p;
    }

    @Override // y6b.a
    public final int r() {
        return this.B;
    }

    @Override // y6b.a
    public final MessageDLPState t() {
        return this.D;
    }

    @Override // y6b.a
    public final MessageEditInfo u() {
        return this.C;
    }

    @Override // y6b.a
    public final MessageSecurityESCReviewExtra v() {
        return this.E;
    }

    @Override // y6b.a
    public final Map<Class<?>, Object> w() {
        return this.O2;
    }

    @Override // y6b.a
    public final MessageFoldDetail x() {
        return this.G;
    }

    @Override // y6b.a
    public final String y() {
        return this.A;
    }

    @Override // y6b.a
    public final Map<String, MessageLink> z() {
        return this.f566504p2;
    }

    @Override // y6b.a
    public final boolean V(long r100) {
        if (this.Y == true) goto L14;
        long r101 = this.Z;
        if (1 <= r101) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == true) goto L15;
        return false;
    L15:
        return true;
    L7:
        if (r101 > r100) goto L9;
        r102 = true;
        goto L10
    L14:
        return true;
    }

    public final boolean W(c<?> r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (Q(r100) == true) goto L7;
    L83:
        boolean r101 = false;
    L84:
        if (r101 == true) goto L87;
        return false;
    L87:
        if (this.T == r100.T) goto L89;
        return false;
    L89:
        if (this.U == r100.U) goto L91;
        return false;
    L91:
        if (y28.a.c(this.V, r100.V) == true) goto L93;
        return false;
    L93:
        if (this.W == r100.W) goto L95;
        return false;
    L95:
        if (this.X == r100.X) goto L97;
        return false;
    L97:
        if (this.Y == r100.Y) goto L99;
        return false;
    L99:
        if (this.Z == r100.Z) goto L101;
        return false;
    L101:
        if (this.f566495k0 == r100.f566495k0) goto L103;
        return false;
    L103:
        if (y28.a.a(this.H0, r100.H0) == true) goto L105;
        return false;
    L105:
        if (this.P0 == r100.P0) goto L107;
        return false;
    L107:
        if (this.V0 == r100.V0) goto L109;
        return false;
    L109:
        if (this.P2 == r100.P2) goto L111;
        return false;
    L111:
        if (this.Q2 == r100.Q2) goto L113;
        return false;
    L113:
        if (this.R2 == r100.R2) goto L115;
        return false;
    L115:
        if (this.f566490h1 == r100.f566490h1) goto L117;
        return false;
    L117:
        if (Intrinsics.areEqual(this.f566487g1, r100.f566487g1) == true) goto L119;
        return false;
    L119:
        if (y28.a.c(this.f566480b1, r100.f566480b1) == true) goto L121;
        return false;
    L121:
        if (y28.a.c(this.S2, r100.S2) == true) goto L123;
        return false;
    L123:
        if (y28.a.c(this.f566503p1, r100.f566503p1) == true) goto L125;
        return false;
    L125:
        if (y28.a.c(this.f566511v1, r100.f566511v1) == true) goto L127;
        return false;
    L127:
        if (Intrinsics.areEqual(this.f566515x1, r100.f566515x1) == true) goto L129;
        return false;
    L129:
        if (y28.a.c(this.f566518y1, r100.f566518y1) == true) goto L131;
        return false;
    L131:
        if (this.G1 == r100.G1) goto L133;
        return false;
    L133:
        if (this.H1 == r100.H1) goto L135;
        return false;
    L135:
        if (this.L1 == r100.L1) goto L137;
        return false;
    L137:
        if (this.V2 != r100.V2) goto L255;
        boolean r102 = this.M1;
        boolean r103 = r100.M1;
        if (r102 == r103) goto L141;
        return false;
    L141:
        if (this.W2 == r100.W2) goto L143;
        return false;
    L143:
        if (this.f566514x != r100.f566514x) goto L258;
        if (r102 == r103) goto L146;
        return false;
    L146:
        if (this.f566496k1 == r100.f566496k1) goto L148;
        return false;
    L148:
        if (this.P1 == r100.P1) goto L150;
        return false;
    L150:
        if (this.f566507s == r100.f566507s) goto L152;
        return false;
    L152:
        if (Intrinsics.areEqual(this.Q1, r100.Q1) == true) goto L154;
        return false;
    L154:
        if (this.S1 == r100.S1) goto L156;
        return false;
    L156:
        if (this.T1 == r100.T1) goto L158;
        return false;
    L158:
        if (this.X2 == r100.X2) goto L160;
        return false;
    L160:
        if (this.V1 == r100.V1) goto L162;
        return false;
    L162:
        if (Intrinsics.areEqual(this.A, r100.A) == true) goto L164;
        return false;
    L164:
        if (this.B == r100.B) goto L166;
        return false;
    L166:
        if (Intrinsics.areEqual(this.C, r100.C) == true) goto L168;
        return false;
    L168:
        if (Intrinsics.areEqual(this.G, r100.G) == true) goto L170;
        return false;
    L170:
        if (this.f566502p0 == r100.f566502p0) goto L172;
        return false;
    L172:
        if (this.Q != r100.Q) goto L273;
        MessageSecurityESCReviewExtra r104 = this.E;
        String r105 = null;
        if (r104 == null) goto L176;
        String r106 = r104.getTipText();
    L177:
        MessageSecurityESCReviewExtra r107 = r100.E;
        if (r107 == null) goto L180;
        String r108 = r107.getTipText();
    L182:
        if (Intrinsics.areEqual(r106, r108) == false) goto L274;
        MessageSecurityESCReviewExtra r109 = this.E;
        if (r109 == null) goto L186;
        String r110 = r109.getSubmitText();
    L187:
        MessageSecurityESCReviewExtra r111 = r100.E;
        if (r111 == null) goto L190;
        String r112 = r111.getSubmitText();
    L192:
        if (Intrinsics.areEqual(r110, r112) == false) goto L275;
        MessageSecurityESCReviewExtra r113 = this.E;
        if (r113 == null) goto L196;
        String r114 = r113.getFeedBackUrl();
    L197:
        MessageSecurityESCReviewExtra r115 = r100.E;
        if (r115 == null) goto L201;
        r105 = r115.getFeedBackUrl();
    L201:
        if (Intrinsics.areEqual(r114, r105) == true) goto L203;
        return false;
    L203:
        if (y28.a.b(this.f566488g2, r100.f566488g2) == true) goto L205;
        return false;
    L205:
        if (this.K == r100.K) goto L207;
        return false;
    L207:
        if (this.f566479a3 != r100.f566479a3) goto L279;
        UniversalPinExtra r116 = this.f566512v2;
        if (r116 != null) goto L211;
    L213:
        boolean r117 = false;
    L214:
        if (r117 == true) goto L216;
        return false;
    L216:
        if (f5b.c.a(this.G2, r100.G2) == true) goto L218;
        return false;
    L218:
        if (y28.a.c(this.H2, r100.H2) == true) goto L220;
        return false;
    L220:
        if (this.I2 == r100.I2) goto L222;
        return false;
    L222:
        if (this.K2 == r100.K2) goto L224;
        return false;
    L224:
        if (this.L2 == r100.L2) goto L226;
        return false;
    L226:
        if (this.M2 != r100.M2) goto L286;
        return true;
    L286:
        return false;
    L211:
        if (r116.isContentSame(r100.f566512v2) != true) goto L213;
        r117 = true;
        goto L214
    L279:
        return false;
    L196:
        r114 = null;
        goto L197
    L275:
        return false;
    L190:
        r112 = null;
        goto L192
    L186:
        r110 = null;
        goto L187
    L274:
        return false;
    L180:
        r108 = null;
        goto L182
    L176:
        r106 = null;
        goto L177
    L273:
        return false;
    L258:
        return false;
    L255:
        return false;
    L7:
        if (getType() != r100.getType()) goto L83;
        if (y28.a.c(this.f566508t, r100.f566508t) == false) goto L83;
        if (y28.a.a(this.f566489h, r100.f566489h) == false) goto L83;
        if (j() != r100.j()) goto L83;
        if (this.f566493j != r100.f566493j) goto L83;
        if (this.f566494k != r100.f566494k) goto L83;
        if (this.f566497l != r100.f566497l) goto L83;
        if (this.f566506r != r100.f566506r) goto L83;
        if (this.f566507s != r100.f566507s) goto L83;
        if (y28.a.c(this.f566510v, r100.f566510v) == false) goto L83;
        if (y28.a.b(this.f566509u, r100.f566509u) == true) goto L45;
        List<ReactionInfo> r118 = this.f566509u;
        if (r118 != null) goto L31;
    L34:
        boolean r119 = true;
    L35:
        if (r119 == false) goto L83;
        List<ReactionInfo> r120 = r100.f566509u;
        if (r120 != null) goto L39;
    L42:
        boolean r121 = true;
    L43:
        if (r121 == false) goto L83;
    L39:
        if (r120.isEmpty() == true) goto L42;
        r121 = false;
        goto L43
    L31:
        if (r118.isEmpty() == true) goto L34;
        r119 = false;
    L45:
        if (this.f566500o.d(r100.f566500o) == false) goto L83;
        if (this.f566517y != r100.f566517y) goto L83;
        if (this.D != r100.D) goto L83;
        if (Intrinsics.areEqual(this.F, r100.F) == false) goto L83;
        if (this.H != r100.H) goto L83;
        if (this.I != r100.I) goto L83;
        if (this.f566520z != r100.f566520z) goto L83;
        if (T(this.f566478J, r100.f566478J) == false) goto L83;
        if (this.K != r100.K) goto L83;
        if (this.L != r100.L) goto L83;
        if (this.N != r100.N) goto L83;
        if (this.O != r100.O) goto L83;
        if (Intrinsics.areEqual(this.P, r100.P) == false) goto L83;
        if (Intrinsics.areEqual(this.f566516x2, r100.f566516x2) == false) goto L83;
        if (this.f566519y2 != r100.f566519y2) goto L83;
        if (Intrinsics.areEqual(this.E2, r100.E2) == false) goto L83;
        if (Intrinsics.areEqual(this.F2, r100.F2) == false) goto L83;
        if (Intrinsics.areEqual(this.f566504p2, r100.f566504p2) == false) goto L83;
        if (Intrinsics.areEqual(s(), r100.s()) == false) goto L83;
        r101 = true;
        goto L84
    }

    @Override // y28.b
    public final /* bridge */ /* synthetic */ boolean isContentSame(y28.b r100) {
        return W((c) r100);
    }

    @Override // y28.b
    public final boolean isItemSame(y28.b r100) {
        return Q((c) r100);
    }

    @Override // v5b.c
    public final void f(int r100, String r101) {
        if (this.f566491h2 != null) goto L5;
        this.f566491h2 = new HashMap();
    L5:
        HashMap<Integer, String> r102 = this.f566491h2;
        if (r102 == null) goto L9;
        r102.put(Integer.valueOf(r100), r101);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(String r100, String r101, String r102, Message.Type r103, String r104, String r110, boolean r111, boolean r112, boolean r113, int r114, long r115, int r116, v5b.a r117, int r118, boolean r210, Message.Status r211, SendStatus r212, y6b.b r213, List r214, Pin r215, boolean r216, Message.RecallerIdentity r217, boolean r218, boolean r219, String r310, int r311, MessageEditInfo r312, MessageDLPState r313, MessageSecurityESCReviewExtra r314, ValidateIMFileResult r315, MessageFoldDetail r316, boolean r317, boolean r318, Map r319, MessageStreamStatus r410, long r411, boolean r412, Message.SourceType r413, String r414, String r415, String r416, boolean r417, boolean r418, boolean r510, DingStatus r511, boolean r512, int r513, boolean r514, long r515, int r516, boolean r517, CharSequence r518, b r610, int r611, int r612, y6b.b r613, String r614, boolean r615, boolean r616, y6b.b r617, c r618, PartialReplyInfo r619, c r710, long r711, Message.SyncToChatMessageType r712, long r713, boolean r714, String r715, Message.ThreadMessageType r716, int r717, boolean r810, ChatDisplayModeSetting r811, List r812, HashMap r813, Map r814, UniversalPinExtra r815, String r816, MessageSourceDisplayPolicy r817, MessageSenderAppInfo r818, AIInfo r819, SmartReplyEntryInfo r910, f5b.a r911, AIRecommendQuestions r912, boolean r913, Map r914) {
        this.f566482c = r100;
        this.f566483d = r101;
        this.f566484e = r102;
        this.f566485f = r103;
        this.f566486g = r104;
        this.f566489h = r110;
        this.f566492i = r111;
        this.f566493j = r112;
        this.f566494k = r113;
        this.f566497l = r114;
        this.f566498m = r115;
        this.f566499n = r116;
        this.f566500o = r117;
        this.f566501p = r118;
        this.f566505q = r210;
        this.f566506r = r211;
        this.f566507s = r212;
        this.f566508t = r213;
        this.f566509u = r214;
        this.f566510v = r215;
        this.f566513w = r216;
        this.f566514x = r217;
        this.f566517y = r218;
        this.f566520z = r219;
        this.A = r310;
        this.B = r311;
        this.C = r312;
        this.D = r313;
        this.E = r314;
        this.F = r315;
        this.G = r316;
        this.H = r317;
        this.I = r318;
        this.f566478J = r319;
        this.K = r410;
        this.L = r411;
        this.M = null;
        this.N = r412;
        this.O = r413;
        this.P = r414;
        this.Q = false;
        this.R = r415;
        this.S = r416;
        this.T = r417;
        this.U = r418;
        this.V = r511;
        this.W = r512;
        this.X = r513;
        this.Y = r514;
        this.Z = r515;
        this.f566495k0 = r516;
        this.f566502p0 = r517;
        this.H0 = r518;
        this.L0 = r610;
        this.P0 = r611;
        this.V0 = r612;
        this.f566480b1 = r613;
        this.f566487g1 = r614;
        this.f566490h1 = r615;
        this.f566496k1 = r616;
        this.f566503p1 = r617;
        this.f566511v1 = r618;
        this.f566515x1 = r619;
        this.f566518y1 = r710;
        this.G1 = r711;
        this.H1 = r712;
        this.L1 = r713;
        this.M1 = false;
        this.P1 = r714;
        this.Q1 = r715;
        this.S1 = r716;
        this.T1 = r717;
        this.V1 = r810;
        this.f566481b2 = r811;
        this.f566488g2 = r812;
        this.f566491h2 = r813;
        this.f566504p2 = r814;
        this.f566512v2 = r815;
        this.f566516x2 = r816;
        this.f566519y2 = r817;
        this.E2 = r818;
        this.F2 = r819;
        this.G2 = r910;
        this.H2 = r911;
        this.I2 = false;
        this.J2 = r912;
        this.K2 = false;
        this.L2 = false;
        this.M2 = false;
        this.N2 = r913;
        this.O2 = r914;
    }
}
