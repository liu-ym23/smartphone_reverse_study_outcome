package f92;

import android.text.TextUtils;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.interactivity.medialink.ui.window.MediaMultiLinkAnchorWindowManager;
import com.bytedance.android.livesdk.interactivity.medialink.widget.mixer.MediaLinkSeiCreator;
import com.bytedance.android.livesdk.interactivity.medialink.widget.mixer.WindowsPosition;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.interact.data.LinkConstant;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import nc0.r;
import nc0.s;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ti6.j;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements j {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f475949i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, Boolean> f475950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaLinkSeiCreator f475951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f475952c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f475953d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.live.revenuelink.e f475954e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f475955f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f475956g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final gy.f f475957h;

    public static final class a {
    }

    static {
    }

    @Override // ti6.j
    public final /* synthetic */ boolean b(aj6.d r100, aj6.b r101) {
        ti6.a.a(r100, r101);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v30 */
    /* JADX WARN: Type inference failed for: r6v31, types: [int] */
    /* JADX WARN: Type inference failed for: r6v47 */
    public final String c(List<ti6.f> r110) {
        com.bytedance.android.live.revenuelink.e r100 = this.f475954e;
        if (r100 == null) goto L13;
        if ((!r110.isEmpty()) == false) goto L10;
        r100.a(false);
        if (this.f475955f == true) goto L13;
        r100.b("rtc_init");
        this.f475955f = true;
        goto L13
    L10:
        if (this.f475955f == false) goto L13;
        r100.dispose();
        this.f475955f = false;
    L13:
        if (r110.size() <= 4) goto L24;
        HashMap r101 = new HashMap();
        if (com.bytedance.android.live.liveinteract.api.utils.g.l("multi_anchor_too_much") == true) goto L24;
        r101.put("event", "multi_anchor_too_much");
        com.bytedance.android.livesdk.user.e r102 = ((IMiddlewareUserService) k.f(IMiddlewareUserService.class)).user();
        Room r103 = m.i().getCurrentRoom();
        if (r103 == null) goto L21;
        if (r102 == null) goto L21;
        r101.put("room_id", r103.getIdStr());
        r101.put("anchor_id", r103.getOwnerUserIdString());
        boolean r104 = Objects.equals(r103.getOwnerUserIdString(), r102.n());
    L22:
        LiveSlardarMonitor.monitorStatus("ttlive_interact_event_api_all", com.bytedance.android.live.liveinteract.api.utils.d.a("multi_anchor_too_much", ((IInteractService) k.f(IInteractService.class)).getCurrentScene(), r104), r101);
        b0.o().j("ttlive_link", r101);
    L21:
        r104 = false;
    L24:
        if (TextUtils.isEmpty(this.f475952c) == true) goto L26;
    L28:
        HashMap r105 = new HashMap();
        r105.put("self", this.f475952c);
        r105.put("region_size", Integer.valueOf(r110.size()));
        StringBuilder r106 = new StringBuilder();
        Iterator<ti6.f> r107 = r110.iterator();
    L30:
        if (r107.hasNext() == false) goto L32;
        r106.append(r107.next().f546160b);
        r106.append("，");
        goto L30
    L32:
        r105.put("regions", r106.toString());
        b r108 = this.f475956g;
        JSONObject r109 = null;
        if (r108 == null) goto L35;
        Map<String, WindowsPosition> r111 = r108.e();
    L36:
        r105.put("window_position", r111);
        b0.o().j("ttlive_anchor", r105);
        x82.e.A2.getClass();
        x82.e r112 = x82.e.a.a();
        if (r112 == null) goto L40;
        f r113 = r112.Q8();
        if (r113 == null) goto L40;
    L41:
        Iterator<ti6.f> r114 = r110.iterator();
    L43:
        if (r114.hasNext() == false) goto L73;
        ti6.f r115 = r114.next();
        b r116 = this.f475956g;
        if (r116 == null) goto L47;
        WindowsPosition r117 = r116.o(r115.f546160b);
    L48:
        if (r117 == null) goto L49;
        i r118 = r113.c(r117);
        double r119 = r118.e();
        double r120 = r118.f();
        r115.f546162d = r119;
        r115.f546163e = r120;
        double r121 = r118.d();
        double r122 = r118.a();
        r115.f546164f = r121;
        r115.f546165g = r122;
        r115.f546159a = 1;
        if (r117 == WindowsPosition.IGNORE) goto L53;
        boolean r123 = true;
    L54:
        r115.f546170l = r123;
        String r124 = r115.f546160b;
        if (this.f475950a.containsKey(r124) == false) goto L59;
        Boolean r125 = this.f475950a.get(r124);
        if (r125 == null) goto L59;
        ?? r126 = r125.booleanValue();
    L60:
        r115.f546167i = r126;
        if (TextUtils.equals(this.f475952c, r115.f546160b) == true) goto L43;
        gy.f r127 = this.f475957h;
        if (r127 == null) goto L71;
        s r128 = r127.L();
        if (r128 == null) goto L71;
        r r129 = r128.e(r115.f546160b);
        if (r129 == null) goto L71;
        if (r129.f518620a.f91961g != true) goto L71;
        boolean r130 = true;
    L72:
        r115.f546171m = r130;
    L71:
        r130 = false;
    L59:
        r126 = 0;
        goto L60
    L53:
        r123 = false;
        goto L54
    L49:
        r115.f546170l = false;
        r115.f546162d = 1.0d;
        r115.f546163e = 1.0d;
        r115.f546164f = 0.1d;
        r115.f546165g = 0.1d;
        goto L43
    L47:
        r117 = null;
        goto L48
    L73:
        JSONObject r131 = new JSONObject();
        x82.d.f562892z2.getClass();
        x82.d r132 = x82.d.a.a();
        if (r132 == null) goto L77;
        String r133 = r132.zd();
        if (r133 == null) goto L77;
    L78:
        r131.put("focus_id", r133);
        r131.put("layout_type", e92.m.a().ordinal());
        ArrayList r134 = new ArrayList(r110);
        CollectionsKt.sortWith(r134, d.f475958a);
        Iterator r135 = r134.iterator();
    L80:
        if (r135.hasNext() == false) goto L84;
        Object r136 = r135.next();
        if (TextUtils.equals(this.f475952c, ((ti6.f) r136).f546160b) == false) goto L80;
    L85:
        ti6.f r137 = (ti6.f) r136;
        if (r137 == null) goto L88;
        r134.remove(r137);
        ListProtector.add(r134, 0, r137);
    L88:
        Iterator r138 = r134.iterator();
        int r139 = 0;
    L90:
        if (r138.hasNext() == false) goto L95;
        if (TextUtils.equals(this.f475952c, ((ti6.f) r138.next()).f546160b) == true) goto L96;
        r139 = r139 + 1;
    L96:
        r131.put("owner_index", RangesKt.coerceAtLeast(r139, 0));
        MediaLinkSeiCreator r140 = this.f475951b;
        long r141 = e92.m.b();
        r140.getClass();
        JSONObject r142 = new JSONObject();     // Catch: JSONException -> L149
        r142.put("ver", 19);     // Catch: JSONException -> L149
        r142.put(Constants.OperatorKey.KEY_VENDOR, "byte");     // Catch: JSONException -> L149
        r142.put("anchor_interact_info", r131);     // Catch: JSONException -> L149
        if (r140.f138542b == 0) goto L120;
        List<ti6.f> r143 = r140.f138543c;     // Catch: JSONException -> L149
        if (Lists.isEmpty(r143) == false) goto L103;
    L116:
        boolean r144 = false;
    L117:
        if (r144 == false) goto L120;
        r142.put("timestamp", r140.f138542b);     // Catch: JSONException -> L149
    L121:
        r140.f138543c = r134;     // Catch: JSONException -> L149
        r142.put("channel_id", String.valueOf(r141));     // Catch: JSONException -> L149
        JSONArray r145 = new JSONArray();     // Catch: JSONException -> L149
        Iterator r146 = r134.iterator();     // Catch: JSONException -> L149
    L123:
        if (r146.hasNext() == false) goto L138;
        ti6.f r147 = (ti6.f) r146.next();     // Catch: JSONException -> L149
        if (r147.f546170l == false) goto L123;
        JSONObject r148 = new JSONObject();     // Catch: JSONException -> L149
        r148.put("type", r147.f546159a);     // Catch: JSONException -> L149
        r148.put("alpha", 1);     // Catch: JSONException -> L149
        r148.put("w", r147.f546164f);     // Catch: JSONException -> L149
        r148.put("h", r147.f546165g);     // Catch: JSONException -> L149
        r148.put("x", r147.f546162d);     // Catch: JSONException -> L149
        r148.put("y", r147.f546163e);     // Catch: JSONException -> L149
        r148.put("account", 0);     // Catch: JSONException -> L149
        r148.put("uid", 0);     // Catch: JSONException -> L149
        r148.put("uid_str", r147.f546160b);     // Catch: JSONException -> L149
        r148.put("zorder", 0);     // Catch: JSONException -> L149
        r148.put(CloudControlInf.STAT, r147.f546167i);     // Catch: JSONException -> L149
        if (r147.f546168j == true) goto L132;
        int r149 = 0;
    L133:
        r148.put("talk", r149);     // Catch: JSONException -> L149
        if (r147.f546171m == false) goto L136;
        int r150 = 1;
    L137:
        r148.put("mute_audio", r150);     // Catch: JSONException -> L149
        r145.put(r148);     // Catch: JSONException -> L149
        goto L123
    L136:
        r150 = 0;
        goto L137
    L132:
        r149 = 2;
        goto L133
    L138:
        r142.put("grids", r145);     // Catch: JSONException -> L149
        JSONObject r151 = new JSONObject();     // Catch: JSONException -> L149
        Room r152 = ((IRoomService) k.f(IRoomService.class)).getCurrentRoom();     // Catch: JSONException -> L149
        if (r152 != null) goto L142;
    L144:
        r151.put("width", 720);     // Catch: JSONException -> L149
        r151.put("height", 1280);     // Catch: JSONException -> L149
    L145:
        r151.put("background", LinkConstant.STREAM_BACKGROUND);     // Catch: JSONException -> L149
        r142.put("canvas", r151);     // Catch: JSONException -> L149
        new HashMap().put("sei", r142.toString());     // Catch: JSONException -> L149
        r109 = r142;
        goto L148
    L142:
        if (r152.getStreamUrlExtra() == null) goto L144;
        r151.put("width", r152.getStreamUrlExtra().getWidth());     // Catch: JSONException -> L149
        r151.put("height", r152.getStreamUrlExtra().getHeight());     // Catch: JSONException -> L149
        goto L145
    L103:
        if (Lists.isEmpty(r134) == true) goto L116;
        if (r143.size() != r134.size()) goto L116;
        int r153 = 0;
    L110:
        if (r153 >= r143.size()) goto L115;
        if (r140.f138541a.a((ti6.f) ListProtector.get(r143, r153), (ti6.f) ListProtector.get(r134, r153)) == false) goto L116;
        r153 = r153 + 1;     // Catch: JSONException -> L149
        goto L110
    L115:
        r144 = true;
    L120:
        long r154 = System.currentTimeMillis();     // Catch: JSONException -> L149
        r140.f138542b = r154;     // Catch: JSONException -> L149
        r142.put("timestamp", r154);     // Catch: JSONException -> L149
    L148:
        return r109.toString();
    L95:
        r139 = -1;
        goto L96
    L84:
        r136 = null;
    L77:
        r133 = "0";
    L40:
        r113 = new g();
        goto L41
    L35:
        r111 = null;
        goto L36
    L26:
        if (Lists.isEmpty(r110) == true) goto L28;
        this.f475952c = ((ti6.f) ListProtector.get(r110, 0)).f546160b;
        goto L28
    }

    public c(MediaMultiLinkAnchorWindowManager r100, gy.f r101, hy.e r102) {
        this.f475956g = r100;
        this.f475957h = r101;
        this.f475950a = new HashMap();
        this.f475953d = "";
        this.f475951b = new MediaLinkSeiCreator();
        this.f475952c = String.valueOf(e92.m.b());
    }

    @Override // ti6.j
    public final String a(int r100, int r101, List<ti6.f> r102) {
        Intrinsics.checkNotNullParameter(r102, "mixRegions");
        String r103 = c(r102);     // Catch: Throwable -> L5
        this.f475953d = r103;     // Catch: Throwable -> L5
        return r103;
    L6:
        return this.f475953d;
    }
}
