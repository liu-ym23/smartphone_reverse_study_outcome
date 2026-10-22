package com.bytedance.frameworks.baselib.netx.partner.mutable;

import com.alibaba.gaiax.render.view.basic.GXImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes19.dex */
public final class MutableRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableUrl f244819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f244820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f244821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f244822d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f244823e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f244824f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f244825g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f244826h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f244827i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f244828j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final RetrofitMetrics f244829k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Request f244830l;

    public final Request a() {
        Request.Builder r100 = this.f244830l.newBuilder();
        c r101 = this.f244821c;
        Request.Builder r102 = r100.method(r101.f244842a, r101.f244843b).url(this.f244819a.b());
        Map<String, List<Header>> r103 = this.f244820b.f244841a;
        ArrayList r104 = new ArrayList();
        Iterator r105 = ((LinkedHashMap) r103).entrySet().iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        CollectionsKt.addAll(r104, (List) ((Map.Entry) r105.next()).getValue());
        goto L4
    L6:
        Request.Builder r106 = r102.headers(r104).requestPriorityLevel(this.f244822d).requestPriorityLevel(this.f244823e).responseStreaming(this.f244824f).maxLength(this.f244825g).setExtraInfo(this.f244826h).serviceType(this.f244827i);
        Iterator r107 = ((Map) this.f244828j.getValue()).entrySet().iterator();
    L8:
        if (r107.hasNext() == false) goto L13;
        Map.Entry r108 = (Map.Entry) r107.next();
        Object r109 = r108.getKey();
        if ((r109 instanceof Class) == true) goto L12;
        r109 = null;
    L12:
        r106.tag((Class) r109, r108.getValue());
        goto L8
    L13:
        Request r110 = r106.build();
        r110.setMetrics(this.f244829k);
        return r110;
    }

    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v58 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 2 */
    public MutableRequest(Request r210) {
        Intrinsics.checkNotNullParameter(r210, "originRequest");
        this.f244830l = r210;
        r210.isAddCommonParam();
        String r100 = r210.getUrl();
        if (r100 == null) goto L179;
        MutableUrl r101 = new MutableUrl();
        int r102 = cvc.c.t(r100, 0, r100.length());
        int r110 = cvc.c.u(r100, r102, r100.length());
        if (r100.regionMatches(true, r102, GXImageView.NET_HTTPS_PREFIX, 0, 6) == false) goto L8;
        r101.f244831a = "https";
        r102 = r102 + 6;
    L11:
        int r103 = r102;
        int r104 = 0;
    L12:
        char r111 = '\\';
        char r112 = '/';
        if (r103 >= r110) goto L18;
        char r105 = r100.charAt(r103);
        if (r105 == '\\') goto L17;
        if (r105 != '/') goto L18;
    L17:
        r104 = r104 + 1;
        r103 = r103 + 1;
    L18:
        int r106 = r102 + r104;
        String r107 = "";
        String r113 = r107;
        boolean r114 = false;
        boolean r115 = false;
    L19:
        int r108 = cvc.c.j(r100, r106, r110, "@/\\?#");
        if (r108 == r110) goto L22;
        byte r109 = r100.charAt(r108);
    L24:
        if (r109 == (-1)) goto L45;
        if (r109 == 35) goto L45;
        if (r109 == r112) goto L45;
        if (r109 == r111) goto L45;
        if (r109 == 63) goto L45;
        if (r109 != 64) goto L44;
        if (r114 == true) goto L42;
        int r116 = cvc.c.i(r100, r106, r108, ':');
        int r117 = r108;
        String r118 = r107;
        String r119 = a.a(r100, r106, r116, " \"':;<=>@[]^`{}|/\\?#", true, false, true);
        if (r115 == false) goto L37;
        r119 = r113 + "%40" + r119;
    L37:
        String r120 = r119;
        if (r116 == r117) goto L40;
        r107 = a.a(r100, r116 + 1, r117, " \"':;<=>@[]^`{}|/\\?#", true, false, true);
        r114 = true;
    L41:
        r113 = r120;
        r115 = true;
    L43:
        r106 = r117 + 1;
        goto L44
    L40:
        r107 = r118;
        goto L41
    L42:
        r117 = r108;
        r107 = r107 + "%40" + a.a(r100, r106, r117, " \"':;<=>@[]^`{}|/\\?#", true, false, true);
    L44:
        r111 = '\\';
        r112 = '/';
    L45:
        String r121 = r107;
        int r122 = r106;
    L46:
        if (r122 >= r108) goto L58;
        char r123 = r100.charAt(r122);
        if (r123 == ':') goto L59;
        if (r123 == '[') goto L52;
        int r124 = 1;
    L57:
        r122 = r122 + r124;
        goto L46
    L52:
        r124 = 1;
    L53:
        r122 = r122 + 1;
        if (r122 >= r108) goto L57;
        if (r100.charAt(r122) != ']') goto L53;
    L59:
        int r125 = r122 + 1;
        if (r125 >= r108) goto L76;
        r101.f244834d = cvc.c.c(a.c(r100, r106, r122, false));
        int r126 = -1;
        char r127 = '#';
        int r128 = CastIntegerProtector.parseInt(a.a(r100, r125, r108, "", false, false, true));     // Catch: NumberFormatException -> L180
        if (r128 <= 0) goto L71;
        if (r128 > 65535) goto L71;
    L72:
        r101.f244835e = r128;
        if (r128 != (-1)) goto L75;
        MutableUrl.ParseResult r129 = MutableUrl.ParseResult.INVALID_PORT;
    L169:
        if (MutableUrl.ParseResult.SUCCESS.equals(r129) == false) goto L177;
        this.f244819a = r101;
        if (this.f244830l.getHeaders() != null) goto L173;
        b r130 = new b(CollectionsKt.emptyList());
    L174:
        this.f244820b = r130;
        this.f244821c = new c(this.f244830l);
        this.f244822d = this.f244830l.getPriorityLevel();
        this.f244823e = this.f244830l.getRequestPriorityLevel();
        this.f244824f = this.f244830l.isResponseStreaming();
        this.f244825g = this.f244830l.getMaxLength();
        this.f244826h = this.f244830l.getExtraInfo();
        this.f244827i = this.f244830l.getServiceType();
        this.f244828j = LazyKt.lazy(MutableRequest$tags$2.INSTANCE);
        this.f244829k = this.f244830l.getMetrics();
        return;
    L173:
        r130 = new b(this.f244830l.getHeaders());
        goto L174
    L177:
        throw new InvalidParameterException(r129.name());
    L75:
        ?? r131 = 0;
    L78:
        if (r101.f244834d != null) goto L80;
        r129 = MutableUrl.ParseResult.INVALID_HOST;
        goto L169
    L80:
        r101.f244832b = a.c(r113, r131, r113.length(), r131);
        r101.f244833c = a.c(r121, r131, r121.length(), r131);
        int r132 = cvc.c.j(r100, r108, r110, "?#");
        d r133 = r101.f244836f;
        r133.getClass();
        Intrinsics.checkNotNullParameter(r100, "input");
        if (r108 == r132) goto L143;
        char r134 = r100.charAt(r108);
        if (r134 != '/') goto L86;
    L89:
        ((ArrayList) r133.f244844a).clear();
        ((ArrayList) r133.f244844a).add("");
        int r135 = r108 + 1;
    L90:
        int r136 = r135;
    L91:
        if (r136 >= r132) goto L143;
        int r137 = cvc.c.j(r100, r136, r132, "/\\");
        if (r137 >= r132) goto L95;
        boolean r138 = true;
    L96:
        String r139 = a.a(r100, r136, r137, " \"<>^`{}|/\\?#", true, false, true);
        if (r139.equals(".") == false) goto L99;
    L102:
        boolean r140 = true;
    L103:
        if (r140 == false) goto L106;
    L140:
        if (r138 == false) goto L142;
        r137 = r137 + 1;
    L142:
        r136 = r137;
        goto L91
    L106:
        if (r139.equals(DownloadConstants.VULNERABILITY_PATH) == false) goto L108;
    L115:
        boolean r141 = true;
    L116:
        if (r141 == false) goto L131;
        ArrayList r142 = (ArrayList) r133.f244844a;
        if (r142.isEmpty() == false) goto L120;
        String r143 = null;
    L121:
        if (r143 == null) goto L140;
        if (r143.length() != 0) goto L125;
        boolean r144 = true;
    L126:
        if (r144 == true) goto L128;
    L130:
        ((ArrayList) r133.f244844a).add("");
        goto L140
    L128:
        if ((!((ArrayList) r133.f244844a).isEmpty()) == false) goto L130;
        List<String> r145 = r133.f244844a;
        ListProtector.set(r145, ((ArrayList) r145).size() - 1, "");
        goto L140
    L125:
        r144 = false;
        goto L126
    L120:
        r143 = (String) ListProtector.remove(r142, CollectionsKt.getLastIndex(r142));
        goto L121
    L131:
        String r146 = a.c(r139, 0, r139.length(), false);
        List<String> r147 = r133.f244844a;
        if (((CharSequence) ListProtector.get(r147, ((ArrayList) r147).size() + r126)).length() != 0) goto L134;
        boolean r148 = true;
    L135:
        if (r148 == false) goto L137;
        List<String> r149 = r133.f244844a;
        ListProtector.set(r149, ((ArrayList) r149).size() + r126, r146);
    L138:
        if (r138 == false) goto L140;
        ((ArrayList) r133.f244844a).add("");
        goto L140
    L137:
        ((ArrayList) r133.f244844a).add(r146);
        goto L138
    L134:
        r148 = false;
        goto L135
    L108:
        if (StringsKt.equals(r139, "%2e.", true) == true) goto L115;
        if (StringsKt.equals(r139, ".%2e", true) == true) goto L115;
        if (StringsKt.equals(r139, "%2e%2e", true) == true) goto L115;
        r141 = false;
        goto L116
    L99:
        if (StringsKt.equals(r139, "%2e", true) == true) goto L102;
        r140 = false;
        goto L103
    L95:
        r138 = false;
        goto L96
    L86:
        if (r134 == '\\') goto L89;
        List<String> r150 = r133.f244844a;
        ListProtector.set(r150, ((ArrayList) r150).size() - 1, "");
        r135 = r108;
    L143:
        if (r132 < r110) goto L145;
    L163:
        if (r132 < r110) goto L165;
    L167:
        r129 = MutableUrl.ParseResult.SUCCESS;
        goto L169
    L165:
        if (r100.charAt(r132) != r127) goto L167;
        String r151 = a.a(r100, r132 + 1, r110, "", true, false, false);
        r101.f244838h = a.c(r151, 0, r151.length(), false);
        goto L167
    L145:
        if (r100.charAt(r132) != '?') goto L163;
        int r152 = cvc.c.i(r100, r132, r110, r127);
        e r153 = r101.f244837g;
        String r154 = a.a(r100, r132 + 1, r152, " \"'<>#", true, true, true);
        ((LinkedHashMap) r153.f244845a).clear();
        if (r154 == null) goto L162;
        int r155 = 0;
    L151:
        if (r155 > r154.length()) goto L162;
        int r156 = StringsKt.indexOf$default(r154, Typography.amp, r155, false, 4, null);
        if (r156 != r126) goto L155;
        r156 = r154.length();
    L155:
        int r157 = StringsKt.indexOf$default(r154, com.alipay.sdk.m.n.a.f25612h, r155, false, 4, null);
        if (r157 == r126) goto L160;
        if (r157 > r156) goto L160;
        r153.a(r154.substring(r155, r157), r154.substring(r157 + 1, r156));
    L161:
        r155 = r156 + 1;
    L160:
        r153.a(r154.substring(r155, r156), null);
    L162:
        r132 = r152;
    L71:
        r128 = -1;
        goto L72
    L76:
        r131 = 0;
        r126 = -1;
        r127 = '#';
        r101.f244834d = cvc.c.c(a.c(r100, r106, r122, false));
        goto L78
    L58:
        r122 = r108;
        goto L59
    L22:
        r109 = -1;
        goto L24
    L8:
        if (r100.regionMatches(true, r102, GXImageView.NET_HTTP_PREFIX, 0, 5) == false) goto L10;
        r101.f244831a = "http";
        r102 = r102 + 5;
        goto L11
    L10:
        r101.f244831a = r101.a();
        goto L11
    L179:
        throw new NullPointerException("URL must not be null.");
    }
}
