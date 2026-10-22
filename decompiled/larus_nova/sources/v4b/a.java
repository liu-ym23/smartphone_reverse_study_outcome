package v4b;

import android.content.Context;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import h18.f;

/* JADX INFO: loaded from: classes35.dex */
public class a {
    public static int A;
    public static int B;
    public static int C;
    public static int D;
    public static int E;
    public static int F;
    public static int G;
    public static int H;
    public static int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static int f553162J;
    public static int K;
    public static int L;
    public static int M;
    public static int N;
    public static int O;
    public static int P;
    public static int Q;
    public static int R;
    public static int S;
    public static int T;
    public static int U;
    public static Boolean V;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f553163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f553164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f553165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f553166d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f553167e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f553168f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f553169g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f553170h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f553171i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int f553172j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int f553173k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static int f553174l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static int f553175m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static int f553176n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static int f553177o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static int f553178p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static int f553179q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static int f553180r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static int f553181s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static int f553182t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static int f553183u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static int f553184v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static int f553185w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static int f553186x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static int f553187y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static int f553188z;

    static {
        a(LarkContext.getApplication().getApplicationContext());
    }

    public static void a(Context r110) {
        if (V != null) goto L5;
        Log.i("BubbleConfigExport", "isNightMode null");
    L6:
        Boolean r100 = V;
        if (r100 != null) goto L9;
    L12:
        boolean r101 = true;
    L13:
        Log.i("BubbleConfigExport", "needAssignColor " + r101);
        if (r101 == true) goto L16;
        return;
    L16:
        V = Boolean.valueOf(f.a(r110));
        Log.i("BubbleConfigExport", "new isNightMode " + V);
        b r102 = (b) ClaymoreServiceLoader.loadFirstOrNull(b.class);
        if (r102 == null) goto L20;
        r102.assignColor(r110);
        return;
    L20:
        f553163a = UDColorUtils.getColor(r110, R.color.imtoken_message_bg_bubbles_blue);
        f553164b = j08.b.b(y9c.d.c(r110, R.color.imtoken_message_bg_show_more_blue), 0.0f);
        f553165c = UDColorUtils.getColor(r110, R.color.imtoken_message_bg_bubbles_blue);
        f553166d = y9c.d.c(r110, R.color.ud_B500_15);
        f553167e = y9c.d.c(r110, R.color.text_caption);
        f553168f = y9c.d.c(r110, R.color.imtoken_message_bg_reaction_blue);
        f553169g = R.color.text_caption;
        f553170h = y9c.d.c(r110, R.color.line_divider_default);
        f553171i = j08.b.b(y9c.d.c(r110, R.color.text_caption), 1.0f);
        f553172j = j08.b.b(y9c.d.c(r110, R.color.text_link_normal), 1.0f);
        j08.b.b(y9c.d.c(r110, R.color.lkui_B500), 1.0f);
        j08.b.b(y9c.d.c(r110, R.color.static_white), 1.0f);
        j08.b.b(y9c.d.c(r110, R.color.primary_pri_700), 1.0f);
        f553173k = R.color.text_caption;
        j08.b.b(y9c.d.c(r110, R.color.primary_pri_700), 1.0f);
        j08.b.b(y9c.d.c(r110, R.color.lkui_N900), 1.0f);
        f553174l = R.color.imtoken_message_icon_read_dot;
        f553175m = R.color.imtoken_message_icon_unread_dot;
        f553176n = j08.b.b(y9c.d.c(r110, R.color.ud_N900), 0.16f);
        f553177o = R.color.text_placeholder;
        f553178p = y9c.d.c(r110, R.color.ud_N600);
        f553179q = j08.b.b(y9c.d.c(r110, R.color.lkui_N00), 0.8f);
        f553180r = j08.b.b(y9c.d.c(r110, R.color.ud_N500), 0.5f);
        f553181s = j08.b.b(y9c.d.c(r110, R.color.lkui_N00), 0.5f);
        f553182t = R.color.text_link_normal;
        f553183u = y9c.d.c(r110, R.color.text_title);
        f553184v = y9c.d.c(r110, R.color.imtoken_message_selected_bg);
        f553185w = y9c.d.c(r110, R.color.text_caption);
        f553188z = UDColorUtils.getColor(r110, R.color.imtoken_message_bg_bubbles_grey);
        A = j08.b.b(y9c.d.c(r110, R.color.imtoken_message_bg_show_more_grey), 0.0f);
        B = UDColorUtils.getColor(r110, R.color.imtoken_message_bg_bubbles_grey);
        C = y9c.d.c(r110, R.color.ud_N900_05);
        D = y9c.d.c(r110, R.color.text_caption);
        E = y9c.d.c(r110, R.color.imtoken_message_bg_reaction_grey);
        F = R.color.text_caption;
        G = y9c.d.c(r110, R.color.line_divider_default);
        H = j08.b.b(y9c.d.c(r110, R.color.text_caption), 1.0f);
        I = j08.b.b(y9c.d.c(r110, R.color.text_link_normal), 1.0f);
        j08.b.b(y9c.d.c(r110, R.color.lkui_B500), 1.0f);
        j08.b.b(y9c.d.c(r110, R.color.lkui_N00), 1.0f);
        j08.b.b(y9c.d.c(r110, R.color.lkui_B700), 1.0f);
        f553162J = R.color.text_caption;
        j08.b.b(y9c.d.c(r110, R.color.lkui_B700), 1.0f);
        j08.b.b(y9c.d.c(r110, R.color.lkui_N900), 1.0f);
        K = R.color.imtoken_message_icon_read_dot;
        L = R.color.imtoken_message_icon_unread_dot;
        M = j08.b.b(y9c.d.c(r110, R.color.ud_N900), 0.16f);
        N = y9c.d.c(r110, R.color.ud_N600);
        O = j08.b.b(y9c.d.c(r110, R.color.lkui_N00), 0.8f);
        P = j08.b.b(y9c.d.c(r110, R.color.ud_N500), 0.5f);
        Q = j08.b.b(y9c.d.c(r110, R.color.lkui_N00), 0.5f);
        R = y9c.d.c(r110, R.color.text_title);
        S = y9c.d.c(r110, R.color.text_caption);
        f553186x = R.drawable.chat_chat_bubble_reply_mark_bg;
        T = R.drawable.chat_chat_bubble_reply_mark_bg;
        f553187y = -1;
        U = -1;
        return;
    L9:
        if (r100.booleanValue() != f.a(r110)) goto L12;
        r101 = false;
        goto L13
    L5:
        Log.i("BubbleConfigExport", "isNightMode " + V);
        goto L6
    }
}
