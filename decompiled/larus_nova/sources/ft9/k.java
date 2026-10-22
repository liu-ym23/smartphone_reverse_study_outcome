package ft9;

import android.content.Context;
import androidx.camera.video.AudioStats;
import com.bytedance.keva.Keva;
import com.bytedance.news.common.settings.SettingsManager;
import com.bytedance.news.common.settings.api.SettingsData;
import com.google.gson.Gson;
import com.larus.applog.api.IApplog;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import hq9.n2;
import hq9.v2;
import hq9.w2;
import hq9.x2;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f478804a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentLinkedQueue<Function1<JSONObject, Unit>> f478805b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CopyOnWriteArrayList<Function1<x2, Unit>> f478806c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f478807d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f478808e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicLong f478809f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicLong f478810g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Gson f478811h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f478812i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile JSONObject f478813j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile v2 f478814k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile x2 f478815l;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final v2 f478816a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f478817b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f478816a, r101.f478816a) == true) goto L12;
            return false;
        L12:
            if (this.f478817b == r101.f478817b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f478816a.hashCode() * 31;
            long r101 = this.f478817b;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "SocialSettingsRequestToken(session=" + this.f478816a + ", requestId=" + this.f478817b + ')';
        }

        public a(v2 r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
            this.f478816a = r100;
            this.f478817b = r101;
        }
    }

    public k() {
    }

    static {
        f478804a = new k();
        f478805b = new ConcurrentLinkedQueue();
        f478806c = new CopyOnWriteArrayList();
        f478807d = new Object();
        f478808e = new Object();
        f478809f = new AtomicLong(0);
        f478810g = new AtomicLong(System.currentTimeMillis());
        f478811h = new Gson();
        f478812i = LazyKt.lazy(new i());
    }

    public static void a(String r100) {
        Object r101 = f478808e;
        monitor-enter(r101);
        Object r102 = f478807d;     // Catch: Throwable -> L26
        monitor-enter(r102);     // Catch: Throwable -> L26
        v2 r103 = f478814k;     // Catch: Throwable -> L23
        if (r100 == null) goto L14;
        if (r103 == null) goto L10;
        String r104 = r103.f486794a;     // Catch: Throwable -> L23
    L12:
        if (Intrinsics.areEqual(r104, r100) == true) goto L14;
    L17:
        boolean r105 = false;
    L18:
        monitor-exit(r102);     // Catch: Throwable -> L26
        monitor-exit(r101);
        if (r105 == false) goto L32;
        FLogger.f375446a.i("SettingsManagerWrapper", "endSocialUserScope expectedUid=" + r100);
        b(null);
        return;
    L32:
        return;
    L10:
        r104 = null;
    L14:
        f478814k = null;     // Catch: Throwable -> L23
        f478815l = null;     // Catch: Throwable -> L23
        f478809f.incrementAndGet();     // Catch: Throwable -> L23
        if (r103 == null) goto L17;
        r105 = true;
        goto L18
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    public static void b(x2 r100) {
        Iterator<Function1<x2, Unit>> r101 = f478806c.iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        Function1<x2, Unit> r102 = r101.next();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L8
        r102.invoke(r100);     // Catch: Throwable -> L8
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L4;
        FLogger.f375446a.e("SettingsManagerWrapper", "notify social snapshot failed", r105);
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public static JSONObject c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        SettingsData r101 = SettingsManager.obtainSettingsFast(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getAppSettings();
    }

    public static Boolean d(Object r100) {
        if ((r100 instanceof Boolean) == true) goto L29;
        boolean r101 = true;
        if ((r100 instanceof String) == false) goto L14;
        String r102 = (String) r100;
        if (StringsKt.equals(r102, "true", true) == false) goto L11;
        return Boolean.TRUE;
    L11:
        if (StringsKt.equals(r102, "false", true) == true) goto L31;
    L27:
        return null;
    L31:
        return Boolean.FALSE;
    L14:
        if ((r100 instanceof Number) == false) goto L27;
        double r103 = ((Number) r100).doubleValue();
        if (r103 != 1.0d) goto L18;
        boolean r104 = true;
    L19:
        if (r104 == false) goto L22;
        return Boolean.TRUE;
    L22:
        if (r103 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L25;
        r101 = false;
    L25:
        if (r101 == false) goto L27;
        return Boolean.FALSE;
    L18:
        r104 = false;
        goto L19
    L29:
        return (Boolean) r100;
    }

    public static void e(x2 r110) {
        Object r100 = f478808e;
        monitor-enter(r100);
        k r101 = f478804a;     // Catch: Throwable -> L37
        String r102 = r110.f486805a.f486794a;     // Catch: Throwable -> L37
        r101.getClass();     // Catch: Throwable -> L37
        x2 r103 = g(r102);     // Catch: Throwable -> L37
        int r104 = w2.f486803a;     // Catch: Throwable -> L37
        if (r103 == null) goto L7;
        Long r105 = Long.valueOf(r103.f486810f);     // Catch: Throwable -> L37
    L8:
        long r106 = r110.f486810f;     // Catch: Throwable -> L37
        v2 r107 = f478814k;     // Catch: Throwable -> L37
        v2 r108 = r110.f486805a;     // Catch: Throwable -> L37
        boolean r109 = true;
        if (r107 == null) goto L16;
        if (r108 == null) goto L16;
        if (Intrinsics.areEqual(r107.f486794a, r108.f486794a) == false) goto L16;
        if (Intrinsics.areEqual(r107, r108) == true) goto L16;
        boolean r111 = true;
    L17:
        if (r111 == true) goto L22;
        if (r105 != null) goto L20;
    L23:
        if (r109 == true) goto L34;
        FLogger r112 = FLogger.f375446a;     // Catch: Throwable -> L37
        StringBuilder r113 = new StringBuilder("ignore stale persisted snapshot responseGeneration=");     // Catch: Throwable -> L37
        r113.append(r110.f486805a.f486795b);     // Catch: Throwable -> L37
        r113.append(" activeGeneration=");     // Catch: Throwable -> L37
        v2 r114 = f478814k;     // Catch: Throwable -> L37
        long r115 = -1;
        if (r114 == null) goto L27;
        long r116 = r114.f486795b;     // Catch: Throwable -> L37
    L28:
        r113.append(r116);     // Catch: Throwable -> L37
        r113.append(" requestId=");     // Catch: Throwable -> L37
        r113.append(r110.f486810f);     // Catch: Throwable -> L37
        r113.append(" latest=");     // Catch: Throwable -> L37
        if (r103 == null) goto L31;
        r115 = r103.f486810f;     // Catch: Throwable -> L37
    L31:
        r113.append(r115);     // Catch: Throwable -> L37
        r112.w("SettingsManagerWrapper", r113.toString());     // Catch: Throwable -> L37
        monitor-exit(r100);
        return;
    L27:
        r116 = -1;
        goto L28
    L34:
        JSONObject r117 = new JSONObject();     // Catch: Throwable -> L37
        r117.put("uid", r110.f486805a.f486794a);     // Catch: Throwable -> L37
        r117.put("generation", r110.f486805a.f486795b);     // Catch: Throwable -> L37
        r117.put("flow_social_next_config", new JSONObject(r110.f486807c));     // Catch: Throwable -> L37
        r117.put("social_next_feature_gating", r110.f486808d);     // Catch: Throwable -> L37
        r117.put("settings_revision", r110.f486809e);     // Catch: Throwable -> L37
        r117.put("settings_request_id", r110.f486810f);     // Catch: Throwable -> L37
        r117.put("received_at_ms", r110.f486811g);     // Catch: Throwable -> L37
        ((Keva) f478812i.getValue()).storeString("snapshot_" + r110.f486805a.f486794a, r117.toString());     // Catch: Throwable -> L37
        Unit r118 = Unit.INSTANCE;     // Catch: Throwable -> L37
        monitor-exit(r100);
        return;
    L20:
        if (r105.longValue() <= r106) goto L23;
    L22:
        r109 = false;
    L16:
        r111 = false;
        goto L17
    L7:
        r105 = null;
    L37:
        th = move-exception;
        throw th;
    }

    public static x2 g(String r110) {
        String r100 = ((Keva) f478812i.getValue()).getString("snapshot_" + r110, "");
        Intrinsics.checkNotNull(r100);
        Object r101 = null;
        if (StringsKt.isBlank(r100) == false) goto L29;
        return null;
    L29:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L18
        JSONObject r103 = new JSONObject(r100);     // Catch: Throwable -> L18
        JSONObject r104 = r103.optJSONObject("flow_social_next_config");     // Catch: Throwable -> L18
        if (r104 == null) goto L15;
        Boolean r105 = d(r103.opt("social_next_feature_gating"));     // Catch: Throwable -> L18
        if (r105 == null) goto L15;
        boolean r106 = r105.booleanValue();     // Catch: Throwable -> L18
        v2 r107 = new v2(r110, r103.optLong("generation"));     // Catch: Throwable -> L18
        n2 r108 = (n2) f478811h.fromJson(r104.toString(), n2.class);     // Catch: Throwable -> L18
        String r109 = r104.toString();     // Catch: Throwable -> L18
        String r111 = r103.optString("settings_revision");     // Catch: Throwable -> L18
        Intrinsics.checkNotNull(r111);     // Catch: Throwable -> L18
        if ((!StringsKt.isBlank(r111)) == false) goto L13;
        String r112 = r111;
    L14:
        x2 r113 = new x2(r107, r108, r109, r106, r112, r103.optLong("settings_request_id"), r103.optLong("received_at_ms"));     // Catch: Throwable -> L18
    L16:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L18
    L20:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);
        if (r115 == null) goto L24;
        FLogger.f375446a.e("SettingsManagerWrapper", "read persisted social settings failed", r115);
    L24:
        if (Result.m9455isFailureimpl(r114) == true) goto L28;
        r101 = r114;
    L28:
        return (x2) r101;
    L13:
        r112 = null;
    L15:
        r113 = null;
    L18:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    }

    public static boolean f(JSONObject r110, a r111, String r112) {
        if (r110 == null) goto L71;
        if (r111 == null) goto L71;
        JSONObject r100 = r110.optJSONObject("flow_social_next_config");
        if (r100 != null) goto L9;
    L69:
        FLogger.f375446a.w("SettingsManagerWrapper", "publishSocialSettingsResponse skipped: incomplete social settings requestId=" + r111.f478817b);
        h("incomplete", r111, r112);
        return false;
    L9:
        if (r110.has("social_next_feature_gating") == false) goto L69;
        if (r110.isNull("social_next_feature_gating") == true) goto L69;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L15
        Object r102 = Result.m9449constructorimpl((n2) f478811h.fromJson(r100.toString(), n2.class));     // Catch: Throwable -> L15
    L17:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 != null) goto L67;
        n2 r104 = (n2) r102;
        Boolean r105 = d(r110.opt("social_next_feature_gating"));
        if (r105 == null) goto L65;
        boolean r113 = r105.booleanValue();
        v2 r106 = r111.f478816a;
        Intrinsics.checkNotNull(r104);
        String r114 = r100.toString();
        Long r107 = null;
        if (r112 != null) goto L24;
    L26:
        String r115 = null;
    L27:
        x2 r108 = new x2(r106, r104, r114, r113, r115, r111.f478817b, System.currentTimeMillis());
        Object r109 = f478807d;
        monitor-enter(r109);
        int r116 = w2.f486803a;     // Catch: Throwable -> L62
        v2 r117 = f478814k;     // Catch: Throwable -> L62
        x2 r118 = f478815l;     // Catch: Throwable -> L62
        if (r118 == null) goto L32;
        r107 = Long.valueOf(r118.f486810f);     // Catch: Throwable -> L62
    L32:
        v2 r119 = r111.f478816a;     // Catch: Throwable -> L62
        long r120 = r111.f478817b;     // Catch: Throwable -> L62
        Intrinsics.checkNotNullParameter(r119, "responseSession");     // Catch: Throwable -> L62
        if (Intrinsics.areEqual(r117, r119) == false) goto L38;
        if (r107 != null) goto L36;
    L37:
        boolean r121 = true;
    L39:
        if (r121 == true) goto L41;
        boolean r122 = false;
    L43:
        monitor-exit(r109);
        e(r108);
        monitor-enter(r109);
    L59:
        th = move-exception;
        throw th;
    L47:
        if (Intrinsics.areEqual(f478814k, r111.f478816a) == false) goto L51;
        if (Intrinsics.areEqual(f478815l, r108) == false) goto L51;
        boolean r123 = true;
    L52:
        monitor-exit(r109);
        if (r122 == false) goto L57;
        if (r123 == false) goto L57;
        FLogger.f375446a.i("SettingsManagerWrapper", "publish social settings generation=" + r111.f478816a.f486795b + " requestId=" + r111.f478817b + " revision=" + r112);
        h("published", r111, r112);
        b(r108);
        return true;
    L57:
        FLogger.f375446a.w("SettingsManagerWrapper", "ignore stale social settings publish generation=" + r111.f478816a.f486795b + " requestId=" + r111.f478817b);
        h("stale", r111, r112);
        return false;
    L51:
        r123 = false;
        goto L52
    L41:
        f478815l = r108;     // Catch: Throwable -> L62
        r122 = true;
        goto L43
    L36:
        if (r107.longValue() <= r120) goto L37;
    L38:
        r121 = false;
    L62:
        th = move-exception;
        throw th;
    L24:
        if ((!StringsKt.isBlank(r112)) == false) goto L26;
        r115 = r112;
        goto L27
    L65:
        FLogger.f375446a.w("SettingsManagerWrapper", "publishSocialSettingsResponse skipped: invalid social gating requestId=" + r111.f478817b);
        h("invalid_gating", r111, r112);
        return false;
    L67:
        FLogger.f375446a.e("SettingsManagerWrapper", "parse flow_social_next_config failed", r103);
        return false;
    L15:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L71:
        FLogger.f375446a.w("SettingsManagerWrapper", "publishSocialSettingsResponse skipped: settings or user scope missing");
        return false;
    }

    public static void h(String r100, a r101, String r102) {
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L19
        IApplog.Companion r104 = IApplog.f287053a;     // Catch: Throwable -> L19
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L19
        r105.put("result", r100);     // Catch: Throwable -> L19
        r105.put("uid", r101.f478816a.f486794a);     // Catch: Throwable -> L19
        r105.put("generation", r101.f478816a.f486795b);     // Catch: Throwable -> L19
        r105.put("request_id", r101.f478817b);     // Catch: Throwable -> L19
        String r106 = "";
        if (r102 != null) goto L6;
        r102 = "";
    L6:
        r105.put("settings_revision", r102);     // Catch: Throwable -> L19
        v2 r107 = f478814k;     // Catch: Throwable -> L19
        if (r107 == null) goto L9;
        String r108 = r107.f486794a;     // Catch: Throwable -> L19
    L10:
        if (r108 == null) goto L13;
        r106 = r108;
    L13:
        r105.put("current_uid", r106);     // Catch: Throwable -> L19
        v2 r109 = f478814k;     // Catch: Throwable -> L19
        if (r109 == null) goto L16;
        long r110 = r109.f486795b;     // Catch: Throwable -> L19
    L17:
        r105.put("current_generation", r110);     // Catch: Throwable -> L19
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L19
        r104.reportEvent("dev_lark_im_settings_snapshot_event", r105);     // Catch: Throwable -> L19
        Object r112 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L27;
        FLogger.f375446a.e("SettingsManagerWrapper", "report social settings event failed", r113);
        return;
    L27:
        return;
    L16:
        r110 = -1;
        goto L17
    L9:
        r108 = null;
    L19:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    }
}
