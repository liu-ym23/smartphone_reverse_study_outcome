package hl;

import com.bytedance.android.ec.model.sku.CartNumWithBusinessLine;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f485615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f485616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f485617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f485618d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<CartNumWithBusinessLine> f485619e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f485620f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f485621g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f485622h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, Object> f485623i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f485624j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f485625k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Integer f485626l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f485627m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f485628n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f485629o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f485630p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final JSONObject f485631q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final float[] f485632r;

    public b(int r210, String r211, Integer r212, String r213, List r214, String r215, String r216, String r217, Map r218, Integer r310, String r311, Integer r312, String r313, String r314, boolean r315, String r316, JSONObject r317, float[] r318, int r319) {
        if ((r319 & 2) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r319 & 4) == 0) goto L9;
        Integer r101 = null;
    L11:
        if ((r319 & 8) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r319 & 16) == 0) goto L17;
        List r103 = null;
    L19:
        if ((r319 & 32) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r319 & 64) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r319 & 128) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r319 & 256) == 0) goto L33;
        Map r110 = null;
    L35:
        if ((r319 & 512) == 0) goto L37;
        Integer r111 = null;
    L39:
        if ((r319 & 1024) == 0) goto L41;
        String r112 = null;
    L43:
        if ((r319 & 8192) == 0) goto L45;
        Integer r113 = null;
    L47:
        if ((r319 & 16384) == 0) goto L49;
        String r114 = null;
    L51:
        if ((32768 & r319) == 0) goto L53;
        String r115 = null;
    L55:
        if ((r319 & 65536) == 0) goto L57;
        boolean r107 = false;
    L59:
        if ((r319 & 131072) == 0) goto L61;
        String r116 = null;
    L63:
        if ((r319 & 262144) == 0) goto L65;
        JSONObject r117 = null;
    L67:
        if ((r319 & 524288) == 0) goto L69;
        float[] r108 = null;
    L70:
        float[] r118 = r108;
        this.f485615a = r210;
        this.f485616b = r100;
        this.f485617c = r101;
        this.f485618d = r102;
        this.f485619e = r103;
        this.f485620f = r104;
        this.f485621g = r105;
        this.f485622h = r106;
        this.f485623i = r110;
        this.f485624j = r111;
        this.f485625k = r112;
        this.f485626l = r113;
        this.f485627m = r114;
        this.f485628n = r115;
        this.f485629o = r107;
        this.f485630p = r116;
        this.f485631q = r117;
        this.f485632r = r118;
        return;
    L69:
        r108 = r318;
        goto L70
    L65:
        r117 = r317;
        goto L67
    L61:
        r116 = r316;
        goto L63
    L57:
        r107 = r315;
        goto L59
    L53:
        r115 = r314;
        goto L55
    L49:
        r114 = r313;
        goto L51
    L45:
        r113 = r312;
        goto L47
    L41:
        r112 = r311;
        goto L43
    L37:
        r111 = r310;
        goto L39
    L33:
        r110 = r218;
        goto L35
    L29:
        r106 = r217;
        goto L31
    L25:
        r105 = r216;
        goto L27
    L21:
        r104 = r215;
        goto L23
    L17:
        r103 = r214;
        goto L19
    L13:
        r102 = r213;
        goto L15
    L9:
        r101 = r212;
        goto L11
    L5:
        r100 = r211;
        goto L7
    }
}
