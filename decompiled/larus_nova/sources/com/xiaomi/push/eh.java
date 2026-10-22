package com.xiaomi.push;

import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ttnetuploader.uploader.api.UploadCode;

/* JADX INFO: loaded from: classes41.dex */
public final enum eh extends Enum<eh> {
    public static final eh A = null;
    public static final eh B = null;
    public static final eh C = null;
    public static final eh D = null;
    public static final eh E = null;
    public static final eh F = null;
    public static final eh G = null;
    public static final eh H = null;
    public static final eh I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final eh f463437J = null;
    public static final eh K = null;
    public static final eh L = null;
    public static final eh M = null;
    public static final eh N = null;
    public static final eh O = null;
    public static final eh P = null;
    public static final eh Q = null;
    public static final eh R = null;
    public static final eh S = null;
    public static final eh T = null;
    public static final eh U = null;
    public static final eh V = null;
    public static final eh W = null;
    public static final eh X = null;
    public static final eh Y = null;
    public static final eh Z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final eh f463438a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final /* synthetic */ eh[] f479a = null;

    /* JADX INFO: renamed from: aa, reason: collision with root package name */
    public static final eh f463439aa = null;

    /* JADX INFO: renamed from: ab, reason: collision with root package name */
    public static final eh f463440ab = null;

    /* JADX INFO: renamed from: ac, reason: collision with root package name */
    public static final eh f463441ac = null;

    /* JADX INFO: renamed from: ad, reason: collision with root package name */
    public static final eh f463442ad = null;

    /* JADX INFO: renamed from: ae, reason: collision with root package name */
    public static final eh f463443ae = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final eh f463444b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final eh f463445c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final eh f463446d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final eh f463447e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final eh f463448f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final eh f463449g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final eh f463450h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final eh f463451i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final eh f463452j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final eh f463453k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final eh f463454l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final eh f463455m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final eh f463456n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final eh f463457o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final eh f463458p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final eh f463459q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final eh f463460r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final eh f463461s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final eh f463462t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final eh f463463u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final eh f463464v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final eh f463465w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final eh f463466x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final eh f463467y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final eh f463468z = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final int f480a;

    static {
        eh r100 = new eh("TCP_CONN_FAIL", 0, 1);
        f463438a = r100;
        eh r101 = new eh("TCP_CONN_TIME", 1, 2);
        f463444b = r101;
        eh r102 = new eh("PING_RTT", 2, 3);
        f463445c = r102;
        eh r103 = new eh("CHANNEL_CON_FAIL", 3, 4);
        f463446d = r103;
        eh r104 = new eh("CHANNEL_CON_OK", 4, 5);
        f463447e = r104;
        eh r110 = new eh("ICMP_PING_FAIL", 5, 6);
        f463448f = r110;
        eh r111 = new eh("ICMP_PING_OK", 6, 7);
        f463449g = r111;
        eh r112 = new eh("CHANNEL_ONLINE_RATE", 7, 8);
        f463450h = r112;
        eh r113 = new eh("BATCH_TCP_CONN_SUCCESS", 8, 1000);
        f463451i = r113;
        eh r105 = new eh("BATCH_TCP_CONN_FAIL", 9, 1001);
        f463452j = r105;
        eh r114 = new eh("CHANNEL_STATS_COUNTER", 10, 8000);
        f463453k = r114;
        eh r106 = new eh("GSLB_REQUEST_SUCCESS", 11, 10000);
        f463454l = r106;
        eh r107 = new eh("GSLB_TCP_NOACCESS", 12, 10101);
        f463455m = r107;
        eh r108 = new eh("GSLB_TCP_NETUNREACH", 13, 10102);
        f463456n = r108;
        eh r109 = new eh("GSLB_TCP_CONNREFUSED", 14, 10103);
        f463457o = r109;
        eh r115 = new eh("GSLB_TCP_NOROUTETOHOST", 15, 10104);
        f463458p = r115;
        eh r116 = new eh("GSLB_TCP_TIMEOUT", 16, 10105);
        f463459q = r116;
        eh r117 = new eh("GSLB_TCP_INVALARG", 17, 10106);
        f463460r = r117;
        eh r118 = new eh("GSLB_TCP_UKNOWNHOST", 18, 10107);
        f463461s = r118;
        eh r119 = new eh("GSLB_TCP_ERR_OTHER", 19, 10199);
        f463462t = r119;
        eh r120 = new eh("GSLB_ERR", 20, 10999);
        f463463u = r120;
        eh r121 = new eh("CONN_SUCCESS", 21, 20000);
        f463464v = r121;
        eh r122 = new eh("CONN_TCP_NOACCESS", 22, 20101);
        f463465w = r122;
        eh r123 = new eh("CONN_TCP_NETUNREACH", 23, 20102);
        f463466x = r123;
        eh r124 = new eh("CONN_TCP_CONNREFUSED", 24, 20103);
        f463467y = r124;
        eh r125 = new eh("CONN_TCP_NOROUTETOHOST", 25, UploadCode.TT_UPLOAD_SERVER_NOT_LOGIN);
        f463468z = r125;
        eh r126 = new eh("CONN_TCP_TIMEOUT", 26, 20105);
        A = r126;
        eh r127 = new eh("CONN_TCP_INVALARG", 27, 20106);
        B = r127;
        eh r128 = new eh("CONN_TCP_UKNOWNHOST", 28, 20107);
        C = r128;
        eh r129 = new eh("CONN_TCP_ERR_OTHER", 29, 20199);
        D = r129;
        eh r130 = new eh("CONN_XMPP_ERR", 30, 20399);
        E = r130;
        eh r131 = new eh("CONN_BOSH_UNKNOWNHOST", 31, 20407);
        F = r131;
        eh r132 = new eh("CONN_BOSH_ERR", 32, 20499);
        G = r132;
        eh r133 = new eh("BIND_SUCCESS", 33, 30000);
        H = r133;
        eh r134 = new eh("BIND_TCP_READ_TIMEOUT_DEPRECTED", 34, 30101);
        I = r134;
        eh r135 = new eh("BIND_TCP_CONNRESET_DEPRECTED", 35, 30102);
        f463437J = r135;
        eh r136 = new eh("BIND_TCP_BROKEN_PIPE_DEPRECTED", 36, 30103);
        K = r136;
        eh r137 = new eh("BIND_TCP_READ_TIMEOUT", 37, 30108);
        L = r137;
        eh r138 = new eh("BIND_TCP_CONNRESET", 38, 30109);
        M = r138;
        eh r139 = new eh("BIND_TCP_BROKEN_PIPE", 39, 30110);
        N = r139;
        eh r140 = new eh("BIND_TCP_ERR", 40, 30199);
        O = r140;
        eh r141 = new eh("BIND_XMPP_ERR", 41, 30399);
        P = r141;
        eh r142 = new eh("BIND_BOSH_ITEM_NOT_FOUND", 42, 30401);
        Q = r142;
        eh r143 = new eh("BIND_BOSH_ERR", 43, 30499);
        R = r143;
        eh r144 = new eh("BIND_TIMEOUT", 44, 30501);
        S = r144;
        eh r145 = new eh("BIND_INVALID_SIG", 45, 30502);
        T = r145;
        eh r146 = new eh("CHANNEL_TCP_READTIMEOUT_DEPRECTED", 46, 40101);
        U = r146;
        eh r147 = new eh("CHANNEL_TCP_CONNRESET_DEPRECTED", 47, 40102);
        V = r147;
        eh r148 = new eh("CHANNEL_TCP_BROKEN_PIPE_DEPRECTED", 48, 40103);
        W = r148;
        eh r149 = new eh("CHANNEL_TCP_READTIMEOUT", 49, 40108);
        X = r149;
        eh r150 = new eh("CHANNEL_TCP_CONNRESET", 50, 40109);
        Y = r150;
        eh r151 = new eh("CHANNEL_TCP_BROKEN_PIPE", 51, 40110);
        Z = r151;
        eh r152 = new eh("CHANNEL_TCP_ERR", 52, 40199);
        f463439aa = r152;
        eh r153 = new eh("CHANNEL_XMPPEXCEPTION", 53, 40399);
        f463440ab = r153;
        eh r154 = new eh("CHANNEL_BOSH_ITEMNOTFIND", 54, 40401);
        f463441ac = r154;
        eh r155 = new eh("CHANNEL_BOSH_EXCEPTION", 55, 40499);
        f463442ad = r155;
        eh r156 = new eh("CHANNEL_TIMER_DELAYED", 56, TTVideoEngineInterface.ALGO_OPTION_INT_STOP_BACKGROUND);
        f463443ae = r156;
        f479a = new eh[]{r100, r101, r102, r103, r104, r110, r111, r112, r113, r105, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154, r155, r156};
    }

    public static eh[] values() {
        return (eh[]) f479a.clone();
    }

    public int a() {
        return this.f480a;
    }

    public static eh a(int r100) {
        if (r100 == 30501) goto L125;
        if (r100 == 30502) goto L123;
        switch(r100) {
            case 1: goto L121;
            case 2: goto L119;
            case 3: goto L117;
            case 4: goto L115;
            case 5: goto L113;
            case 6: goto L111;
            case 7: goto L109;
            case 8: goto L107;
            default: goto L7;
        };
    L7:
        switch(r100) {
            case 8000: goto L105;
            case 10000: goto L103;
            case 10199: goto L101;
            case 10999: goto L99;
            case 20000: goto L97;
            case 20199: goto L95;
            case 20399: goto L93;
            case 20407: goto L91;
            case 20499: goto L89;
            case 30000: goto L87;
            case 30199: goto L85;
            case 30399: goto L83;
            case 30401: goto L81;
            case 30499: goto L79;
            case 40199: goto L77;
            case 40399: goto L75;
            case 40401: goto L73;
            case 40499: goto L71;
            case 50001: goto L69;
            default: goto L8;
        };
    L8:
        switch(r100) {
            case 10101: goto L67;
            case 10102: goto L65;
            case 10103: goto L63;
            case 10104: goto L61;
            case 10105: goto L59;
            case 10106: goto L57;
            case 10107: goto L55;
            default: goto L9;
        };
    L9:
        switch(r100) {
            case 20101: goto L53;
            case 20102: goto L51;
            case 20103: goto L49;
            case 20104: goto L47;
            case 20105: goto L45;
            case 20106: goto L43;
            case 20107: goto L41;
            default: goto L10;
        };
    L10:
        switch(r100) {
            case 30101: goto L39;
            case 30102: goto L37;
            case 30103: goto L35;
            default: goto L11;
        };
    L11:
        switch(r100) {
            case 30108: goto L33;
            case 30109: goto L31;
            case 30110: goto L29;
            default: goto L12;
        };
    L12:
        switch(r100) {
            case 40101: goto L27;
            case 40102: goto L25;
            case 40103: goto L23;
            default: goto L13;
        };
    L13:
        switch(r100) {
            case 40108: goto L21;
            case 40109: goto L19;
            case 40110: goto L17;
            default: goto L14;
        };
    L14:
        return null;
    L17:
        return Z;
    L19:
        return Y;
    L21:
        return X;
    L23:
        return W;
    L25:
        return V;
    L27:
        return U;
    L29:
        return N;
    L31:
        return M;
    L33:
        return L;
    L35:
        return K;
    L37:
        return f463437J;
    L39:
        return I;
    L41:
        return C;
    L43:
        return B;
    L45:
        return A;
    L47:
        return f463468z;
    L49:
        return f463467y;
    L51:
        return f463466x;
    L53:
        return f463465w;
    L55:
        return f463461s;
    L57:
        return f463460r;
    L59:
        return f463459q;
    L61:
        return f463458p;
    L63:
        return f463457o;
    L65:
        return f463456n;
    L67:
        return f463455m;
    L69:
        return f463443ae;
    L71:
        return f463442ad;
    L73:
        return f463441ac;
    L75:
        return f463440ab;
    L77:
        return f463439aa;
    L79:
        return R;
    L81:
        return Q;
    L83:
        return P;
    L85:
        return O;
    L87:
        return H;
    L89:
        return G;
    L91:
        return F;
    L93:
        return E;
    L95:
        return D;
    L97:
        return f463464v;
    L99:
        return f463463u;
    L101:
        return f463462t;
    L103:
        return f463454l;
    L105:
        return f463453k;
    L107:
        return f463450h;
    L109:
        return f463449g;
    L111:
        return f463448f;
    L113:
        return f463447e;
    L115:
        return f463446d;
    L117:
        return f463445c;
    L119:
        return f463444b;
    L121:
        return f463438a;
    L123:
        return T;
    L125:
        return S;
    }

    public static eh valueOf(String r100) {
        return (eh) r27.a.a(eh.class, r100);
    }

    private eh(String r100, int r101, int r102) {
        super(r100, r101);
        this.f480a = r102;
    }
}
