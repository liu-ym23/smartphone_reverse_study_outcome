package xk7;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.ug.sdk.luckydog.api.settings.ILuckyDogCommonSettingsService;
import com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings;
import com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.api.ILuckyDogCommonSettingRequestApi;
import com.bytedance.ug.sdk.luckydog.api.settings.h;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import rk7.m;
import uk7.i;
import uk7.k;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e extends jl7.b<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ILuckyDogCommonSettingRequestApi f564221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ILuckyDogCommonSettingRequestApi f564222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f564223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArrayList<com.bytedance.ug.sdk.luckydog.api.settings.d> f564224d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArrayList<com.bytedance.ug.sdk.luckydog.api.settings.c> f564225e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CopyOnWriteArrayList<com.bytedance.ug.sdk.luckydog.api.settings.c> f564226f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CopyOnWriteArrayList<xk7.a> f564227g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f564228h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f564229i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicBoolean f564230j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f564231k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ScheduledFuture<?> f564232l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LuckyDogLocalSettings f564233m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final HashMap<String, Object> f564234n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile boolean f564235o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f564236p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Gson f564237q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AtomicBoolean f564238r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f564239s;

    /* JADX INFO: loaded from: classes22.dex */
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f564240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f564241b;

        public a(e r100, String r101) {
            this.f564240a = r100;
            this.f564241b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            e r100 = this.f564240a;     // Catch: Throwable -> L4
            String r101 = this.f564241b;     // Catch: Throwable -> L4
            r100.f564232l = null;     // Catch: Throwable -> L4
            r100.a(r101);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public boolean A() {
        return !(this instanceof com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.g);
    }

    public boolean e() {
        return false;
    }

    public abstract ILuckyDogCommonSettingsService.Channel g();

    public abstract long h();

    public abstract int i(JSONObject r100);

    public abstract String m();

    public abstract void n();

    public void o() {
    }

    public abstract Call<uk7.a<JsonObject>> t(int r100);

    public abstract void w(JSONObject r100);

    public abstract void x();

    public void y(JSONObject r100) {
    }

    public boolean b() {
        Application r100 = m.f538347a;
        m.p();
        m.k();
        return true;
    }

    public final void p() {
        if (this.f564229i == true) goto L5;
        this.f564229i = true;
    L5:
        Iterator<xk7.a> r100 = this.f564227g.iterator();
    L7:
        if (r100.hasNext() == false) goto L9;
        r100.next().a(g());
        goto L7
    }

    public e() {
        g37.a r100 = h.f271653a;
        StringBuilder r101 = new StringBuilder();
        if (h.f271656d == true) goto L5;
        h.f271656d = true;
        h.f271655c = h.c(r101);
        r101.append(" setupUrl=");
        r101.append(h.f271655c);
    L5:
        String r102 = "https://polaris.zijieapi.com/";
        if (TextUtils.isEmpty(h.f271655c) == false) goto L8;
    L10:
        String r103 = "https://polaris.zijieapi.com/";
    L11:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogSettingsManager", "getDogSettingsBaseUrlConfByServer: " + r101.toString());
        if (r103 != null) goto L15;
        r103 = "https://polaris.zijieapi.com/";
    L15:
        this.f564221a = (ILuckyDogCommonSettingRequestApi) i.a(r103).create(ILuckyDogCommonSettingRequestApi.class);
        StringBuilder r104 = new StringBuilder();
        if (h.f271656d == true) goto L19;
        h.f271656d = true;
        h.f271655c = h.c(r104);
        r104.append(" setupUrl=");
        r104.append(h.f271655c);
    L19:
        if (TextUtils.isEmpty(h.f271655c) == false) goto L21;
    L23:
        String r105 = "https://polaris.zijieapi.com/";
    L24:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogSettingsManager", "getDogSettingsBaseUrlConfByServer: " + r104.toString());
        if (r105 == null) goto L27;
        r102 = r105;
    L27:
        this.f564222b = (ILuckyDogCommonSettingRequestApi) i.a(r102).create(ILuckyDogCommonSettingRequestApi.class);
        this.f564224d = new CopyOnWriteArrayList();
        this.f564225e = new CopyOnWriteArrayList();
        this.f564226f = new CopyOnWriteArrayList();
        this.f564227g = new CopyOnWriteArrayList();
        this.f564230j = new AtomicBoolean(false);
        this.f564233m = h.a();
        this.f564234n = new HashMap();
        n();
        this.f564236p = "";
        this.f564237q = new Gson();
        this.f564238r = new AtomicBoolean(false);
        this.f564239s = "";
        return;
    L21:
        if ("https://polaris.zijieapi.com/".equals(h.f271655c) == true) goto L23;
        r105 = h.f271655c;
        r104.append(" useServerHost=");
        r104.append(r105);
        goto L24
    L8:
        if ("https://polaris.zijieapi.com/".equals(h.f271655c) == true) goto L10;
        r103 = h.f271655c;
        r101.append(" useServerHost=");
        r101.append(r103);
        goto L11
    }

    public final boolean c() {
        if (g() != ILuckyDogCommonSettingsService.Channel.POLL) goto L9;
        if (this.f564231k != 1) goto L12;
        return true;
    L12:
        return false;
    L9:
        if (this.f564231k != 2) goto L13;
        return true;
    L13:
        return false;
    }

    public boolean f() {
        return this.f564235o;
    }

    public final boolean d(JSONObject r100) {
        com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.h r101 = com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.f271628a;
        ILuckyDogCommonSettingsService.Channel r102 = ILuckyDogCommonSettingsService.Channel.STATIC;
        e r103 = com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.b(r102);
        String r104 = "https://polaris.zijieapi.com/";
        if (g() != r102) goto L10;
        Object r105 = yk7.c.d(r100, "common_info.domain.dog_settings_domain");
        if ((r105 instanceof String) == false) goto L7;
        String r106 = (String) r105;
    L8:
        if (r103 == null) goto L15;
        r103.f564236p = r106;
    L15:
        e r107 = com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.b(r102);
        if (r107 == null) goto L20;
        JSONObject r108 = r107.f564223c;
        if (r108 == null) goto L20;
        Object r109 = yk7.c.d(r108, "data.common_info.domain.dog_settings_domain");
    L22:
        if ((r109 instanceof String) == true) goto L24;
    L26:
        com.bytedance.ug.sdk.luckydog.api.log.d.d(m(), "serviceDomain:" + r106 + " lastUrl:" + r104);
        boolean r110 = false;
        if (r106.length() <= 0) goto L29;
        boolean r111 = true;
    L30:
        if (r111 == true) goto L32;
    L34:
        if (r110 == false) goto L36;
        this.f564221a = (ILuckyDogCommonSettingRequestApi) i.a(r106).create(ILuckyDogCommonSettingRequestApi.class);
    L36:
        return r110;
    L32:
        if ((!Intrinsics.areEqual(r106, r104)) == false) goto L34;
        r110 = true;
        goto L34
    L29:
        r111 = false;
        goto L30
    L24:
        if (TextUtils.isEmpty((CharSequence) r109) == true) goto L26;
        r104 = (String) r109;
    L20:
        r109 = null;
        goto L22
    L7:
        r106 = "https://polaris.zijieapi.com/";
        goto L8
    L10:
        if (r103 == null) goto L14;
        r106 = r103.f564236p;
        if (r106 != null) goto L15;
    L14:
        r106 = "https://polaris.zijieapi.com/";
        goto L15
    }

    public final Object j(String r100) {
        Object r101 = l(r100);
        if ((r101 instanceof JSONArray) == false) goto L9;
        Object r102 = new JSONArray(r101.toString());     // Catch: Exception -> L6
    L5:
        r101 = r102;
    L13:
        if (r101 != null) goto L15;
        com.bytedance.ug.sdk.luckydog.api.log.d.e(m(), "setting access error, key : " + r100);
    L15:
        return r101;
    L6:
        com.bytedance.ug.sdk.luckydog.api.log.d.b(m(), "Exception when parse json array in getSettingByKey");
    L7:
        r101 = null;
        goto L13
    L9:
        if ((r101 instanceof JSONObject) == false) goto L13;
        r102 = new JSONObject(r101.toString());     // Catch: Exception -> L12
    L12:
        com.bytedance.ug.sdk.luckydog.api.log.d.b(m(), "Exception when parse json object in getSettingByKey");
        goto L7
    }

    public Object l(String r100) {
        JSONObject r101 = this.f564223c;
        if (r101 != null) goto L7;
        return null;
    L7:
        return yk7.c.d(r101, r100);
    }

    public final void q(boolean r100) {
        Iterator<com.bytedance.ug.sdk.luckydog.api.settings.d> r101 = this.f564224d.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().a(g(), r100);
        goto L4
    L6:
        com.bytedance.ug.sdk.luckydog.api.log.d.d(m(), "notify settings update finish, success " + r100);
    }

    public final void u(String r100) {
        if (this.f564238r.getAndSet(false) == false) goto L7;
        this.f564231k = 0;
        com.bytedance.ug.sdk.luckydog.api.log.d.d(m(), "compensate request from retry request");
        a(this.f564239s);
        return;
    L7:
        if (g() == ILuckyDogCommonSettingsService.Channel.POLL) goto L9;
        int r101 = this.f564231k + 1;
        this.f564231k = r101;
        if (r101 != 1) goto L20;
        a(r100);
        return;
    L20:
        if (r101 != 2) goto L22;
        this.f564232l = yk7.f.a(new a(this, r100), 30000);
        return;
    L22:
        if (r101 != 3) goto L31;
        com.bytedance.ug.sdk.luckydog.api.log.d.d(m(), "retryRequest fail channel = " + g());
        q(false);
        this.f564231k = 0;
        return;
    L31:
        return;
    L9:
        if (this.f564231k < 1) goto L15;
        com.bytedance.ug.sdk.luckydog.api.log.d.d(m(), "pollingSettingsRetryRequest mHasRetryTimes = " + this.f564231k + ' ');
        q(false);
        int r102 = g.f564243a;
        g.a(g(), r100);
        JSONObject r103 = this.f564223c;
        if (r103 == null) goto L13;
        String r104 = r103.toString();
    L14:
        r(true, false, r104);
        this.f564231k = 0;
        return;
    L13:
        r104 = null;
        goto L14
    L15:
        this.f564232l = yk7.f.a(new d(this, r100), 10000);
        this.f564231k++;
        com.bytedance.ug.sdk.luckydog.api.log.d.d(m(), "pollingSettingsRetryRequest change");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z(String r210) {
        Application r110 = m.f538347a;
        if (m.m() == false) goto L7;
        com.bytedance.ug.sdk.luckydog.api.log.d.d(m(), "isDisableSettings = true");
        return;
    L7:
        if (b() == true) goto L11;
        com.bytedance.ug.sdk.luckydog.api.log.d.d(m(), "can't request setting now");
        this.f564230j.set(false);
        return;
    L11:
        if (com.bytedance.ug.sdk.luckydog.api.settings.b.a() == false) goto L14;
        com.bytedance.ug.sdk.luckydog.api.log.d.d(m(), "getEnableInterceptNetworkRequest is false");
        return;
    L14:
        int r111 = g.f564243a;
        int r112 = g.a(g(), r210);
        com.bytedance.ug.sdk.luckydog.api.log.d.d(m(), "start update " + g() + " setting for scene " + r210 + ", sceneId = " + r112);
        Call<uk7.a<JsonObject>> r113 = t(r112);     // Catch: Throwable -> L57 Exception -> L59
        Object r211 = null;
        if (r113 == null) goto L18;
        SsResponse<uk7.a<JsonObject>> r114 = r113.execute();     // Catch: Throwable -> L57 Exception -> L59
    L20:
        if (r114 != null) goto L22;
    L121:
        SsResponse<uk7.a<JsonObject>> r100 = r114;
        String r101 = m();     // Catch: Throwable -> L57 Exception -> L59
        if (r100 != null) goto L124;
        String r102 = "resp is null";
    L125:
        com.bytedance.ug.sdk.luckydog.api.log.d.b(r101, "fail update setting, ".concat(r102));     // Catch: Throwable -> L57 Exception -> L59
        this.f564230j.set(false);     // Catch: Throwable -> L57 Exception -> L59
        if (c() == false) goto L188;
        int r103 = yk7.b.f568235a;     // Catch: Throwable -> L57 Exception -> L59
        ILuckyDogCommonSettingsService.Channel r115 = g();     // Catch: Throwable -> L57 Exception -> L59
        int r104 = -2;
        if (r100 == null) goto L132;
        uk7.a<JsonObject> r105 = r100.body();     // Catch: Throwable -> L57 Exception -> L59
        if (r105 == null) goto L132;
        int r116 = r105.errNo;     // Catch: Throwable -> L57 Exception -> L59
    L133:
        if (r100 == null) goto L135;
        int r117 = r100.code();     // Catch: Throwable -> L57 Exception -> L59
    L136:
        StringBuilder r106 = new StringBuilder("resp success? ");     // Catch: Throwable -> L57 Exception -> L59
        if (r100 == null) goto L139;
        Boolean r107 = Boolean.valueOf(r100.isSuccessful());     // Catch: Throwable -> L57 Exception -> L59
    L140:
        r106.append(r107);     // Catch: Throwable -> L57 Exception -> L59
        r106.append(", body is null? ");     // Catch: Throwable -> L57 Exception -> L59
        if (r100 == null) goto L143;
        uk7.a<JsonObject> r108 = r100.body();     // Catch: Throwable -> L57 Exception -> L59
    L144:
        if (r108 != null) goto L146;
        boolean r109 = true;
    L147:
        r106.append(r109);     // Catch: Throwable -> L57 Exception -> L59
        yk7.b.b(r115, false, r112, -1, r116, r117, r106.toString());     // Catch: Throwable -> L57 Exception -> L59
        ILuckyDogCommonSettingsService.Channel r118 = g();     // Catch: Throwable -> L57 Exception -> L59
        if (r100 == null) goto L152;
        uk7.a<JsonObject> r119 = r100.body();     // Catch: Throwable -> L57 Exception -> L59
        if (r119 == null) goto L152;
        int r120 = r119.errNo;     // Catch: Throwable -> L57 Exception -> L59
    L153:
        StringBuilder r121 = new StringBuilder("resp success? ");     // Catch: Throwable -> L57 Exception -> L59
        if (r100 == null) goto L156;
        Boolean r122 = Boolean.valueOf(r100.isSuccessful());     // Catch: Throwable -> L57 Exception -> L59
    L157:
        r121.append(r122);     // Catch: Throwable -> L57 Exception -> L59
        r121.append(", body is null? ");     // Catch: Throwable -> L57 Exception -> L59
        if (r100 == null) goto L160;
        uk7.a<JsonObject> r123 = r100.body();     // Catch: Throwable -> L57 Exception -> L59
    L161:
        if (r123 != null) goto L163;
        boolean r124 = true;
    L164:
        r121.append(r124);     // Catch: Throwable -> L57 Exception -> L59
        yk7.b.a(r118, r120, r121.toString());     // Catch: Throwable -> L57 Exception -> L59
        if (r100 == null) goto L169;
        uk7.a<JsonObject> r125 = r100.body();     // Catch: Throwable -> L57 Exception -> L59
        if (r125 == null) goto L169;
        int r126 = r125.errNo;     // Catch: Throwable -> L57 Exception -> L59
    L170:
        if (r100 == null) goto L172;
        int r127 = r100.code();     // Catch: Throwable -> L57 Exception -> L59
    L173:
        if (r100 == null) goto L177;
        uk7.a<JsonObject> r128 = r100.body();     // Catch: Throwable -> L57 Exception -> L59
        if (r128 == null) goto L177;
        r104 = r128.errNo;     // Catch: Throwable -> L57 Exception -> L59
    L177:
        StringBuilder r129 = new StringBuilder("resp success? ");     // Catch: Throwable -> L57 Exception -> L59
        if (r100 == null) goto L180;
        Boolean r130 = Boolean.valueOf(r100.isSuccessful());     // Catch: Throwable -> L57 Exception -> L59
    L181:
        r129.append(r130);     // Catch: Throwable -> L57 Exception -> L59
        r129.append(", body is null? ");     // Catch: Throwable -> L57 Exception -> L59
        if (r100 == null) goto L184;
        r211 = (uk7.a) r100.body();     // Catch: Throwable -> L57 Exception -> L59
    L184:
        if (r211 != null) goto L186;
        boolean r131 = true;
    L187:
        r129.append(r131);     // Catch: Throwable -> L57 Exception -> L59
        v(r126, r127, r104, r129.toString());     // Catch: Throwable -> L57 Exception -> L59
        goto L188
    L186:
        r131 = false;
        goto L187
    L180:
        r130 = null;
        goto L181
    L172:
        r127 = -2;
    L169:
        r126 = -2;
        goto L170
    L163:
        r124 = false;
        goto L164
    L160:
        r123 = null;
        goto L161
    L156:
        r122 = null;
    L152:
        r120 = -2;
        goto L153
    L146:
        r109 = false;
        goto L147
    L143:
        r108 = null;
        goto L144
    L139:
        r107 = null;
        goto L140
    L135:
        r117 = -2;
    L132:
        r116 = -2;
    L188:
        u(r210);     // Catch: Throwable -> L57 Exception -> L59
    L207:
        p();
        return;
    L124:
        r102 = "";
        goto L125
    L22:
        if (r114.isSuccessful() == false) goto L121;
        if (r114.body() == null) goto L121;
        uk7.a<JsonObject> r132 = r114.body();     // Catch: Throwable -> L57 Exception -> L59
        if (r132 != null) goto L28;
    L70:
        SsResponse<uk7.a<JsonObject>> r133 = r114;
        com.bytedance.ug.sdk.luckydog.api.log.d.b(m(), "request resp error");     // Catch: Throwable -> L57 Exception -> L59
        this.f564230j.set(false);     // Catch: Throwable -> L57 Exception -> L59
        if (c() == false) goto L120;
        int r134 = yk7.b.f568235a;     // Catch: Throwable -> L57 Exception -> L59
        ILuckyDogCommonSettingsService.Channel r135 = g();     // Catch: Throwable -> L57 Exception -> L59
        uk7.a<JsonObject> r136 = r133.body();     // Catch: Throwable -> L57 Exception -> L59
        int r137 = -3;
        if (r136 == null) goto L75;
        int r138 = r136.errNo;     // Catch: Throwable -> L57 Exception -> L59
    L76:
        int r139 = r133.code();     // Catch: Throwable -> L57 Exception -> L59
        StringBuilder r140 = new StringBuilder("errorNo = ");     // Catch: Throwable -> L57 Exception -> L59
        if (r132 == null) goto L79;
        Integer r141 = Integer.valueOf(r132.errNo);     // Catch: Throwable -> L57 Exception -> L59
    L80:
        r140.append(r141);     // Catch: Throwable -> L57 Exception -> L59
        r140.append(", data is null? ");     // Catch: Throwable -> L57 Exception -> L59
        if (r132 == null) goto L83;
        JsonObject r142 = r132.data;     // Catch: Throwable -> L57 Exception -> L59
    L84:
        if (r142 != null) goto L86;
        boolean r143 = true;
    L87:
        r140.append(r143);     // Catch: Throwable -> L57 Exception -> L59
        yk7.b.b(r135, false, r112, -1, r138, r139, r140.toString());     // Catch: Throwable -> L57 Exception -> L59
        ILuckyDogCommonSettingsService.Channel r144 = g();     // Catch: Throwable -> L57 Exception -> L59
        if (r132 == null) goto L90;
        int r145 = r132.errNo;     // Catch: Throwable -> L57 Exception -> L59
    L91:
        StringBuilder r146 = new StringBuilder("errorNo = ");     // Catch: Throwable -> L57 Exception -> L59
        if (r132 == null) goto L94;
        Integer r147 = Integer.valueOf(r132.errNo);     // Catch: Throwable -> L57 Exception -> L59
    L95:
        r146.append(r147);     // Catch: Throwable -> L57 Exception -> L59
        r146.append(", data is null? ");     // Catch: Throwable -> L57 Exception -> L59
        if (r132 == null) goto L98;
        JsonObject r148 = r132.data;     // Catch: Throwable -> L57 Exception -> L59
    L99:
        if (r148 != null) goto L101;
        boolean r149 = true;
    L102:
        r146.append(r149);     // Catch: Throwable -> L57 Exception -> L59
        yk7.b.a(r144, r145, r146.toString());     // Catch: Throwable -> L57 Exception -> L59
        uk7.a<JsonObject> r150 = r133.body();     // Catch: Throwable -> L57 Exception -> L59
        if (r150 == null) goto L105;
        int r151 = r150.errNo;     // Catch: Throwable -> L57 Exception -> L59
    L106:
        int r152 = r133.code();     // Catch: Throwable -> L57 Exception -> L59
        if (r132 == null) goto L109;
        r137 = r132.errNo;     // Catch: Throwable -> L57 Exception -> L59
    L109:
        StringBuilder r153 = new StringBuilder("errorNo = ");     // Catch: Throwable -> L57 Exception -> L59
        if (r132 == null) goto L112;
        Integer r154 = Integer.valueOf(r132.errNo);     // Catch: Throwable -> L57 Exception -> L59
    L113:
        r153.append(r154);     // Catch: Throwable -> L57 Exception -> L59
        r153.append(", data is null? ");     // Catch: Throwable -> L57 Exception -> L59
        if (r132 == null) goto L116;
        r211 = (JsonObject) r132.data;     // Catch: Throwable -> L57 Exception -> L59
    L116:
        if (r211 != null) goto L118;
        boolean r155 = true;
    L119:
        r153.append(r155);     // Catch: Throwable -> L57 Exception -> L59
        v(r151, r152, r137, r153.toString());     // Catch: Throwable -> L57 Exception -> L59
        goto L120
    L118:
        r155 = false;
        goto L119
    L112:
        r154 = null;
        goto L113
    L105:
        r151 = -3;
        goto L106
    L101:
        r149 = false;
        goto L102
    L98:
        r148 = null;
        goto L99
    L94:
        r147 = null;
        goto L95
    L90:
        r145 = -3;
        goto L91
    L86:
        r143 = false;
        goto L87
    L83:
        r142 = null;
        goto L84
    L79:
        r141 = null;
        goto L80
    L75:
        r138 = -3;
    L120:
        u(r210);     // Catch: Throwable -> L57 Exception -> L59
        goto L207
    L28:
        if (r132.errNo != 0) goto L70;
        JsonObject r156 = r132.data;     // Catch: Throwable -> L57 Exception -> L59
        if (r156 == null) goto L70;
        JSONObject r157 = new JSONObject(r156.toString());     // Catch: Throwable -> L57 Exception -> L59
        y(r157);     // Catch: Throwable -> L57 Exception -> L59
        JSONObject r158 = new JSONObject();     // Catch: Throwable -> L57 Exception -> L59
        if (d(r157) == false) goto L34;
        this.f564230j.set(false);     // Catch: Throwable -> L57 Exception -> L59
        this.f564231k = 0;     // Catch: Throwable -> L57 Exception -> L59
        a("domain_change");     // Catch: Throwable -> L57 Exception -> L59
        com.bytedance.ug.sdk.luckydog.api.log.d.d(m(), "use new domain request, return");     // Catch: Throwable -> L57 Exception -> L59
    L34:
        yk7.c.a(r157);     // Catch: Throwable -> L57 Exception -> L59
        yk7.c.c(r157);     // Catch: Throwable -> L57 Exception -> L59
        yk7.c.b(r157);     // Catch: Throwable -> L57 Exception -> L59
        r158.put("data", r157);     // Catch: Throwable -> L57 Exception -> L59
        if (r132.common == null) goto L38;
        r158.put("act_common", new JSONObject(this.f564237q.toJson(r132.common)));     // Catch: Exception -> L211 Throwable -> L57
    L38:
        if (A() == true) goto L40;
    L42:
        SsResponse<uk7.a<JsonObject>> r159 = r114;
        boolean r160 = true;
        this.f564235o = false;     // Catch: Throwable -> L57 Exception -> L59
        this.f564223c = r158;     // Catch: Throwable -> L57 Exception -> L59
        s(r159, r158);     // Catch: Throwable -> L57 Exception -> L59
        x();     // Catch: Throwable -> L57 Exception -> L59
        int r161 = yk7.b.f568235a;     // Catch: Throwable -> L57 Exception -> L59
        yk7.b.b(g(), true, r112, i(r158), r159.body().errNo, r159.code(), "success");     // Catch: Throwable -> L57 Exception -> L59
        v(r159.body().errNo, r159.code(), r159.body().errNo, "success");     // Catch: Throwable -> L57 Exception -> L59
        if (g() != ILuckyDogCommonSettingsService.Channel.STATIC) goto L45;
        com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.i.a();     // Catch: Throwable -> L57 Exception -> L59
        com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.i.b();     // Catch: Throwable -> L57 Exception -> L59
    L45:
        Application r162 = m.f538347a;     // Catch: Throwable -> L57 Exception -> L59
        if (m.l() == false) goto L49;
        com.bytedance.ug.sdk.luckydog.api.log.d.d(m(), "success update settings, data = " + this.f564223c);     // Catch: Throwable -> L57 Exception -> L59
    L49:
        if (g() != ILuckyDogCommonSettingsService.Channel.POLL) goto L62;
        if (e() == false) goto L62;
        ConcurrentHashMap<String, am7.b> r163 = yk7.d.f568236a;     // Catch: Throwable -> L57 Exception -> L59
        if (yk7.d.f568238c.get() != r160) goto L55;
        boolean r164 = true;
    L56:
        com.bytedance.ug.sdk.luckydog.api.log.d.d(m(), "success update settings, isPollingChangeDisaster = " + r164);     // Catch: Throwable -> L57 Exception -> L59
        goto L62
    L55:
        r164 = false;
    L62:
        if (this.f564228h == true) goto L64;
        this.f564228h = r160;     // Catch: Throwable -> L57 Exception -> L59
    L64:
        q(r160);     // Catch: Throwable -> L57 Exception -> L59
        boolean r165 = e();     // Catch: Throwable -> L57 Exception -> L59
        JSONObject r166 = this.f564223c;     // Catch: Throwable -> L57 Exception -> L59
        if (r166 == null) goto L67;
        r211 = r166.toString();     // Catch: Throwable -> L57 Exception -> L59
    L67:
        r(r165, r160, r211);     // Catch: Throwable -> L57 Exception -> L59
        this.f564231k = 0;     // Catch: Throwable -> L57 Exception -> L59
        this.f564230j.set(false);     // Catch: Throwable -> L57 Exception -> L59
        if (this.f564238r.getAndSet(false) == false) goto L207;
        com.bytedance.ug.sdk.luckydog.api.log.d.d(m(), "compensate request");     // Catch: Throwable -> L57 Exception -> L59
        a(this.f564239s);     // Catch: Throwable -> L57 Exception -> L59
        goto L207
    L40:
        if (r157.optBoolean("no_update") == false) goto L42;
        this.f564235o = true;     // Catch: Throwable -> L57 Exception -> L59
        com.bytedance.ug.sdk.luckydog.api.log.d.d(m(), "The settings config is not need update");     // Catch: Throwable -> L57 Exception -> L59
        o();     // Catch: Throwable -> L57 Exception -> L59
        int r167 = yk7.b.f568235a;     // Catch: Throwable -> L57 Exception -> L59
        r160 = true;
        SsResponse<uk7.a<JsonObject>> r168 = r114;
        yk7.b.b(g(), true, r112, i(r158), r114.body().errNo, r114.code(), "no_update");     // Catch: Throwable -> L57 Exception -> L59
        v(r168.body().errNo, r168.code(), r168.body().errNo, "no_update");     // Catch: Throwable -> L57 Exception -> L59
        goto L45
    L18:
        r114 = null;
    L59:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b(m(), "Exception when request setting " + e);     // Catch: Throwable -> L57
        this.f564230j.set(false);     // Catch: Throwable -> L57
        if (c() == false) goto L206;
        int r169 = yk7.b.f568235a;     // Catch: Throwable -> L57
        ILuckyDogCommonSettingsService.Channel r170 = g();     // Catch: Throwable -> L57
        String r171 = e.getMessage();     // Catch: Throwable -> L57
        String r172 = com.bytedance.android.ec.core.event.a.KEY_EXCEPTION;
        if (r171 == null) goto L196;
        String r173 = r171;
    L198:
        yk7.b.b(r170, false, r112, -1, -1, -1, r173);     // Catch: Throwable -> L57
        int r174 = k.a(m.f538361o.e(), e);     // Catch: Throwable -> L57
        ILuckyDogCommonSettingsService.Channel r175 = g();     // Catch: Throwable -> L57
        String r176 = e.getMessage();     // Catch: Throwable -> L57
        if (r176 != null) goto L202;
        r176 = com.bytedance.android.ec.core.event.a.KEY_EXCEPTION;
    L202:
        yk7.b.a(r175, r174, r176);     // Catch: Throwable -> L57
        String r177 = e.getMessage();     // Catch: Throwable -> L57
        if (r177 == null) goto L205;
        r172 = r177;
    L205:
        v(-1, -1, r174, r172);     // Catch: Throwable -> L57
        goto L206
    L196:
        r173 = com.bytedance.android.ec.core.event.a.KEY_EXCEPTION;
    L206:
        u(r210);     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        p();
        throw th;
    }

    public final <T> T k(String r100, Class<T> r101) {
        return (T) this.f564237q.fromJson(String.valueOf(l(r100)), r101);
    L5:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b(m(), "exception when deserialize " + e);
        return null;
    }

    public final void s(SsResponse<uk7.a<JsonObject>> r100, JSONObject r101) {
        if (CollectionUtils.isEmpty(r100.headers()) == true) goto L23;
        Iterator<T> r102 = r100.headers().iterator();
    L5:
        String r103 = null;
        if (r102.hasNext() == false) goto L10;
        Object r104 = r102.next();
        if (StringsKt.equals("x-settings-hash", ((Header) r104).getName(), true) == false) goto L5;
    L11:
        Header r105 = (Header) r104;
        if (r105 == null) goto L15;
        r103 = r105.getValue();
    L15:
        if (g() != ILuckyDogCommonSettingsService.Channel.DYNAMIC) goto L17;
    L18:
        r101.put("key_setting_hash", r103);
        com.bytedance.ug.sdk.luckydog.api.log.d.d(m(), "current channel" + g() + " hash header is:" + r103);
        return;
    L17:
        if (g() == ILuckyDogCommonSettingsService.Channel.STATIC) goto L18;
        return;
    L10:
        r104 = null;
        goto L11
    }

    public final void r(boolean r100, boolean r101, String r102) {
        if (g() == ILuckyDogCommonSettingsService.Channel.POLL) goto L5;
        return;
    L5:
        Iterator<com.bytedance.ug.sdk.luckydog.api.settings.c> r103 = this.f564226f.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        r103.next().a(r101, r102);
        goto L7
    L9:
        if (r100 == false) goto L19;
        Iterator<com.bytedance.ug.sdk.luckydog.api.settings.c> r104 = this.f564225e.iterator();
    L12:
        if (r104.hasNext() == false) goto L14;
        r104.next().a(r101, r102);
        goto L12
    L14:
        ConcurrentHashMap<String, am7.b> r105 = yk7.d.f568236a;
        boolean r106 = true;
        if (yk7.d.f568238c.get() == 1) goto L18;
        r106 = false;
    L18:
        com.bytedance.ug.sdk.luckydog.api.log.d.d(m(), "notifyUpdateSettingFinishData, isPollingChangeDisaster = " + r106);
    L19:
        com.bytedance.ug.sdk.luckydog.api.log.d.d(m(), "notify settings update data finish, change " + r100 + ", success " + r101 + ", data " + r102);
    }

    public final void v(int r100, int r101, int r102, String r103) {
        this.f564234n.put("ttnet_code", Integer.valueOf(r100));
        this.f564234n.put("http_code", Integer.valueOf(r101));
        this.f564234n.put("client_err_code", Integer.valueOf(r102));
        this.f564234n.put("error_msg", r103);
    }
}
