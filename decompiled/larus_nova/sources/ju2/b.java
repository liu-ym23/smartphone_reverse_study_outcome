package ju2;

import android.text.TextUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f500417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f500418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f500419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f500420d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f500421e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f500422f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f500423g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f500424h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Integer f500425i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f500426j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f500427k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f500428l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f500429m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f500430n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f500431o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f500432p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f500433q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f500434r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f500435s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f500436t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f500437u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f500438v;

    public static final class a {
    }

    static {
    }

    public final Map<String, String> c() {
        HashMap r100 = new HashMap();
        boolean r101 = false;
        if (this.f500418b.length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        r100.put("enter_from_merge", this.f500418b);
    L9:
        if (this.f500419c.length() <= 0) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == false) goto L15;
        r100.put("enter_method", this.f500419c);
    L15:
        if (this.f500420d.length() <= 0) goto L17;
        boolean r104 = true;
    L18:
        if (r104 == false) goto L21;
        r100.put("vs_rec_type", this.f500420d);
    L21:
        if (this.f500434r.length() <= 0) goto L23;
        boolean r105 = true;
    L24:
        if (r105 == false) goto L27;
        r100.put("vs_boost_task_id", this.f500434r);
    L27:
        if (this.f500421e.length() <= 0) goto L29;
        boolean r106 = true;
    L30:
        if (r106 == false) goto L33;
        r100.put("vs_force_task_id", this.f500421e);
    L33:
        if (this.f500423g.length() <= 0) goto L35;
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r100.put("action_type", this.f500423g);
    L39:
        if (TextUtils.isEmpty(this.f500424h) == true) goto L41;
        String r108 = this.f500424h;
        Intrinsics.checkNotNull(r108);
        r100.put("video_id", r108);
    L41:
        Integer r109 = this.f500425i;
        if (r109 == null) goto L45;
        r109.intValue();
        r100.put("vs_is_watched_video", String.valueOf(this.f500425i));
    L45:
        if (this.f500427k.length() <= 0) goto L47;
        boolean r110 = true;
    L48:
        if (r110 == false) goto L51;
        r100.put("vs_draw_id", this.f500427k);
    L51:
        if (this.f500428l.length() <= 0) goto L53;
        boolean r111 = true;
    L54:
        if (r111 == false) goto L57;
        r100.put("vs_draw_last_episode_id", this.f500428l);
    L57:
        if ("".length() <= 0) goto L59;
        boolean r112 = true;
    L60:
        if (r112 == false) goto L62;
        r100.put("vs_draw_direction", "");
    L62:
        String r113 = "0";
        r100.put("vs_is_auto_play", "0");
        r100.put("is_from_next_episode_icon", "0");
        r100.put("is_vs", "1");
        if (this.f500422f.length() <= 0) goto L65;
        boolean r114 = true;
    L66:
        if (r114 == false) goto L69;
        r100.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_PUSH_TYPE, this.f500422f);
    L69:
        if (this.f500430n.length() <= 0) goto L71;
        boolean r115 = true;
    L72:
        if (r115 == false) goto L75;
        r100.put("search_params", this.f500430n);
    L75:
        if ("1".equals(this.f500431o) == false) goto L78;
        r100.put(ILiveRoomPlayFragmentConstant.EXTRA_CARRY_SEARCH_PARAMS, this.f500431o);
    L78:
        if (this.f500432p.length() <= 0) goto L80;
        boolean r116 = true;
    L81:
        if (r116 == false) goto L84;
        r100.put("is_from_pad", this.f500432p);
    L84:
        if (this.f500433q.length() <= 0) goto L86;
        boolean r117 = true;
    L87:
        if (r117 == false) goto L89;
        r100.put("format_center_position", this.f500433q);
    L89:
        r100.put(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_VIDEO_TYPES, String.valueOf(this.f500429m));
        if (this.f500417a.length() <= 0) goto L92;
        boolean r118 = true;
    L93:
        if (r118 == false) goto L95;
        r100.put("vs_app_theme", this.f500417a);
    L95:
        r100.put("is_from_window_pay_page", "0");
        if (this.f500435s.length() <= 0) goto L98;
        boolean r119 = true;
    L99:
        if (r119 == false) goto L102;
        r100.put("sub_tab_type", this.f500435s);
    L102:
        if (this.f500436t.length() <= 0) goto L104;
        boolean r120 = true;
    L105:
        if (r120 == false) goto L107;
        r100.put("is_pad_landscape", this.f500436t);
    L107:
        String r121 = this.f500437u;
        if (r121 != null) goto L110;
    L115:
        String r122 = this.f500438v;
        if (r122 == null) goto L124;
        if (r122.length() <= 0) goto L120;
        boolean r123 = true;
    L121:
        if (r123 != true) goto L124;
        String r124 = this.f500438v;
        Intrinsics.checkNotNull(r124);
        r100.put("douplus_channel", r124);
        goto L124
    L120:
        r123 = false;
    L124:
        if (this.f500426j.length() <= 0) goto L126;
        r101 = true;
    L126:
        if (r101 == false) goto L129;
        r100.put(VSConstants.EXTRA_FROM_SEARCH_PAY_SUCCESS, this.f500426j);
    L129:
        if ((!Intrinsics.areEqual(this.f500432p, "1")) == true) goto L131;
    L134:
        return r100;
    L131:
        if (s1.getContext().getResources().getConfiguration().orientation != 2) goto L133;
        r113 = "1";
    L133:
        r100.put("is_hor", r113);
        goto L134
    L110:
        if (r121.length() <= 0) goto L112;
        boolean r125 = true;
    L113:
        if (r125 != true) goto L115;
        String r126 = this.f500437u;
        Intrinsics.checkNotNull(r126);
        r100.put("is_other_channel", r126);
        goto L115
    L112:
        r125 = false;
        goto L113
    L104:
        r120 = false;
        goto L105
    L98:
        r119 = false;
        goto L99
    L92:
        r118 = false;
        goto L93
    L86:
        r117 = false;
        goto L87
    L80:
        r116 = false;
        goto L81
    L71:
        r115 = false;
        goto L72
    L65:
        r114 = false;
        goto L66
    L59:
        r112 = false;
        goto L60
    L53:
        r111 = false;
        goto L54
    L47:
        r110 = false;
        goto L48
    L35:
        r107 = false;
        goto L36
    L29:
        r106 = false;
        goto L30
    L23:
        r105 = false;
        goto L24
    L17:
        r104 = false;
        goto L18
    L11:
        r103 = false;
        goto L12
    L5:
        r102 = false;
        goto L6
    }

    public b() {
        this.f500417a = "";
        this.f500418b = "";
        this.f500419c = "";
        this.f500420d = "";
        this.f500421e = "";
        this.f500422f = "";
        this.f500423g = "";
        this.f500426j = "";
        this.f500427k = "";
        this.f500428l = "";
        this.f500430n = "";
        this.f500431o = "";
        this.f500432p = "";
        this.f500433q = "";
        this.f500434r = "";
        this.f500435s = "";
        this.f500436t = "";
        this.f500437u = "";
        this.f500438v = "";
    }

    public final String a() {
        return this.f500418b;
    }

    public final String b() {
        return this.f500419c;
    }
}
