package com.ss.android.lark.chat.entity.message;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
import com.bytedance.lark.pb.basic.v1.UrlPreviewHangPoint;
import com.larksuite.framework.utils.e;
import com.ss.android.lark.chat.entity.Channel;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.chat.entity.message.MessageParams.a;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes35.dex */
public abstract class MessageParams<T extends MessageParams<T, B>, B extends a<T, B>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f415242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f415243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f415244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f415245d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Message.Type f415246e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Channel.Type f415247f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f415248g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f415249h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f415250i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f415251j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f415252k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f415253l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f415254m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final CreateScene f415255n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Long f415256o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Long f415257p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final LarkAgentContext f415258q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f415259r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo f415260s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f415261t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f415262u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f415263v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Long f415264w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Boolean f415265x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Map<String, UrlPreviewHangPoint> f415266y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Map<String, UrlPreviewEntity> f415267z;

    public static final enum CreateScene extends Enum<CreateScene> {
        public static final CreateScene COMMON_SHARE = null;
        public static final CreateScene NORMAL = null;
        public static final CreateScene SHARE_DOC = null;
        public static final CreateScene SHARE_GROUP_CHAT = null;
        public static final CreateScene SHARE_MINUTES = null;
        public static final CreateScene SHARE_QR_CODE = null;
        public static final CreateScene SHARE_SUBSCRIPTION = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CreateScene[] f415268a = null;
        private final int value;

        static {
            CreateScene r100 = new CreateScene(EffectConstants.NORMAL, 0, 0);
            NORMAL = r100;
            CreateScene r101 = new CreateScene("SHARE_GROUP_CHAT", 1, 1);
            SHARE_GROUP_CHAT = r101;
            CreateScene r102 = new CreateScene("SHARE_DOC", 2, 3);
            SHARE_DOC = r102;
            CreateScene r103 = new CreateScene("SHARE_MINUTES", 3, 5);
            SHARE_MINUTES = r103;
            CreateScene r104 = new CreateScene("SHARE_QR_CODE", 4, 6);
            SHARE_QR_CODE = r104;
            CreateScene r110 = new CreateScene("SHARE_SUBSCRIPTION", 5, 7);
            SHARE_SUBSCRIPTION = r110;
            CreateScene r111 = new CreateScene("COMMON_SHARE", 6, 9);
            COMMON_SHARE = r111;
            f415268a = new CreateScene[]{r100, r101, r102, r103, r104, r110, r111};
        }

        public static CreateScene[] values() {
            return (CreateScene[]) f415268a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static CreateScene forNumber(int r100) {
            if (r100 == 1) goto L23;
            if (r100 == 3) goto L21;
            if (r100 == 5) goto L19;
            if (r100 == 6) goto L17;
            if (r100 == 7) goto L15;
            return NORMAL;
        L15:
            return SHARE_SUBSCRIPTION;
        L17:
            return SHARE_QR_CODE;
        L19:
            return SHARE_MINUTES;
        L21:
            return SHARE_DOC;
        L23:
            return SHARE_GROUP_CHAT;
        }

        public static CreateScene valueOf(String r100) {
            return (CreateScene) r27.a.a(CreateScene.class, r100);
        }

        public static CreateScene valueOf(int r100) {
            return forNumber(r100);
        }

        public CreateScene(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static abstract class a<T extends MessageParams<T, B>, B extends a<T, B>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f415269a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f415270b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f415271c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f415272d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f415273e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f415274f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Channel.Type f415275g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Message.Type f415276h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f415277i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f415278j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f415279k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f415280l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f415281m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public CreateScene f415282n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public long f415283o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Long f415284p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public LarkAgentContext f415285q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f415286r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo f415287s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public String f415288t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f415289u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public boolean f415290v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public Long f415291w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public Boolean f415292x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public Map<String, UrlPreviewHangPoint> f415293y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public Map<String, UrlPreviewEntity> f415294z;

        public abstract T a();

        public a() {
            this.f415273e = -1;
            this.f415275g = Channel.Type.CHAT;
            this.f415279k = false;
            this.f415281m = false;
            this.f415283o = -1;
            this.f415284p = null;
            this.f415285q = null;
            this.f415286r = false;
            this.f415287s = null;
            this.f415289u = false;
            this.f415290v = false;
            this.f415291w = null;
            this.f415292x = null;
            this.f415293y = null;
            this.f415294z = null;
        }
    }

    public abstract Message c(String r100, String r101);

    public MessageParams(B r100) {
        this.f415250i = -1;
        this.f415242a = r100.f415269a;
        this.f415243b = r100.f415270b;
        String r101 = r100.f415271c;
        this.f415244c = r101;
        Message.Type r102 = r100.f415276h;
        this.f415246e = r102;
        this.f415250i = r100.f415273e;
        Channel.Type r103 = r100.f415275g;
        this.f415247f = r103;
        if (r103 != Channel.Type.CHAT) goto L5;
        String r104 = r101;
    L6:
        this.f415248g = r104;
        if (TextUtils.isEmpty(r100.f415272d) == false) goto L9;
        String r105 = UUID.randomUUID().toString();
    L10:
        this.f415245d = r105;
        this.f415249h = r100.f415277i;
        this.f415251j = r100.f415278j;
        this.f415252k = r100.f415279k;
        this.f415253l = r100.f415280l;
        this.f415254m = r100.f415281m;
        this.f415255n = r100.f415282n;
        this.f415256o = Long.valueOf(r100.f415283o);
        this.f415257p = r100.f415284p;
        this.f415259r = r100.f415286r;
        this.f415260s = r100.f415287s;
        this.f415261t = r100.f415288t;
        this.f415262u = r100.f415289u;
        this.f415258q = r100.f415285q;
        this.f415263v = r100.f415290v;
        this.f415264w = r100.f415291w;
        this.f415265x = r100.f415292x;
        this.f415266y = r100.f415293y;
        this.f415267z = r100.f415294z;
        if (r101 == null) goto L15;
        if (r102 == null) goto L15;
        return;
    L15:
        throw new IllegalArgumentException("miss required field");
    L9:
        r105 = r100.f415272d;
        goto L10
    L5:
        r104 = r100.f415274f;
        goto L6
    }

    public final Message b(String r100, String r101) {
        Message r102 = new Message();
        r102.setChatId(this.f415244c);
        r102.setRootId(this.f415242a);
        r102.setParentId(this.f415243b);
        if (TextUtils.isEmpty(this.f415249h) == true) goto L5;
        r102.setThreadId(this.f415249h);
    L5:
        r102.setType(this.f415246e);
        if (this.f415254m == false) goto L10;
        r102.setPosition(-3);
        int r103 = this.f415250i;
        if (r103 < 0) goto L14;
        r102.setThreadPosition(r103 + 1);
    L14:
        if (TextUtils.isEmpty(r100) == true) goto L17;
        r102.setcId(r100);
        r102.setId(r100);
    L20:
        long r104 = e.e();
        r102.setCreateTime(r104);
        r102.setUpdateTime(r104);
        r102.setSendStatus(SendStatus.SENDING);
        r102.setFromType(Message.FromType.USER);
        r102.setIsFromMe(true);
        r102.setFromId(r101);
        Channel.Type r105 = this.f415247f;
        if (r105 != Channel.Type.CHAT) goto L23;
        String r106 = this.f415244c;
    L24:
        r102.setChannel(new Channel(r105, r106));
        Long r107 = this.f415257p;
        if (r107 == null) goto L27;
        r102.setAiChatModeId(r107.longValue());
    L27:
        return r102;
    L23:
        r106 = this.f415248g;
        goto L24
    L17:
        if (TextUtils.isEmpty(this.f415245d) == false) goto L19;
        String r108 = UUID.randomUUID().toString();
        r102.setcId(r108);
        r102.setId(r108);
        goto L20
    L19:
        r102.setcId(this.f415245d);
        r102.setId(this.f415245d);
        goto L20
    L10:
        int r109 = this.f415250i;
        if (r109 < 0) goto L14;
        r102.setPosition(r109);
        goto L14
    }
}
