package t10;

import android.content.Context;
import com.bytedance.android.live.broadcastgame.opengame.q;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.ies.web.jsbridge2.c0;
import com.bytedance.ies.web.jsbridge2.d0;
import com.bytedance.ies.web.jsbridge2.o;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public na4.b f544135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0 f544136b;

    /* JADX INFO: renamed from: t10.a$a, reason: collision with other inner class name */
    public static final class C7676a extends com.bytedance.ies.web.jsbridge2.b {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final Map<String, C7677a> f544137n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final Context f544138o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final b f544139p;

        /* JADX INFO: renamed from: t10.a$a$a, reason: collision with other inner class name */
        public static final class C7677a {
            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof C7677a) == false) goto L10;
                ((C7677a) r100).getClass();
                if (Intrinsics.areEqual(null, null) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(null, null) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public final int hashCode() {
                return 0;
            }

            public final String toString() {
                return "HandlerWrap(eventName=null, sender=null)";
            }
        }

        /* JADX INFO: renamed from: t10.a$a$b */
        public interface b {
            void a(JSONObject r100);
        }

        /* JADX INFO: renamed from: t10.a$a$c */
        public static final class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final JSONObject f544140a;

            /* JADX INFO: renamed from: t10.a$a$c$a, reason: collision with other inner class name */
            public static final class C7678a {
            }

            static {
            }

            public c() {
                JSONObject r100 = new JSONObject();
                r100.put("__liveOpenPlatform", true);
                Unit r101 = Unit.INSTANCE;
                this.f544140a = r100;
            }
        }

        @Override // com.bytedance.ies.web.jsbridge2.b
        public final String h() {
            return "https://snssdk.com";
        }

        @Override // com.bytedance.ies.web.jsbridge2.b
        public final void j(o r100) {
        }

        @Override // com.bytedance.ies.web.jsbridge2.b
        public Context getContext(o r100) {
            return this.f544138o;
        }

        @Override // com.bytedance.ies.web.jsbridge2.b
        public final void k(String r100) {
            if (r100 == null) goto L34;
            LiveSeiUtil.f71508i.getClass();     // Catch: Exception -> L31
            Object r101 = LiveSeiUtil.c(r100).remove("__params");     // Catch: Exception -> L31
            Object r102 = null;
            if ((r101 instanceof JSONObject) == true) goto L7;
            r101 = null;
        L7:
            JSONObject r103 = (JSONObject) r101;     // Catch: Exception -> L31
            if (r103 == null) goto L35;
            Object r104 = r103.remove("eventName");     // Catch: Exception -> L31
            if ((r104 instanceof String) == true) goto L12;
            r104 = null;
        L12:
            String r105 = (String) r104;     // Catch: Exception -> L31
            Object r106 = r103.remove(com.heytap.mcssdk.constant.b.f276361k);     // Catch: Exception -> L31
            if ((r106 instanceof Integer) == true) goto L15;
            r106 = null;
        L15:
            Integer r107 = (Integer) r106;     // Catch: Exception -> L31
            Object r108 = r103.remove("data");     // Catch: Exception -> L31
            if ((r108 instanceof JSONObject) == false) goto L19;
            r102 = r108;
        L19:
            JSONObject r109 = (JSONObject) r102;     // Catch: Exception -> L31
            c r110 = new c();     // Catch: Exception -> L31
            if (r105 != null) goto L22;
            r105 = "";
        L22:
            Intrinsics.checkNotNullParameter(r105, "name");     // Catch: Exception -> L31
            r110.f544140a.put("eventName", r105);     // Catch: Exception -> L31
            if (r107 == null) goto L25;
            int r111 = r107.intValue();     // Catch: Exception -> L31
        L26:
            r110.f544140a.put(com.heytap.mcssdk.constant.b.f276361k, r111);     // Catch: Exception -> L31
            JSONObject r112 = r110.f544140a;     // Catch: Exception -> L31
            if (r109 != null) goto L29;
            r109 = new JSONObject();     // Catch: Exception -> L31
        L29:
            r112.put("data", r109);     // Catch: Exception -> L31
            this.f544139p.a(r110.f544140a);     // Catch: Exception -> L31
            Unit r113 = Unit.INSTANCE;     // Catch: Exception -> L31
            return;
        L25:
            r111 = 0;
            goto L26
        L35:
            return;
        L36:
            return;
        }

        public C7676a(Context r100, b r101) {
            Intrinsics.checkNotNullParameter(r100, "ctx");
            Intrinsics.checkNotNullParameter(r101, "sender");
            this.f544138o = r100;
            this.f544139p = r101;
            this.f544137n = new LinkedHashMap();
        }

        @Override // com.bytedance.ies.web.jsbridge2.b
        public final void m(String r100, c0 r101) {
            if (r101 == null) goto L6;
            String r102 = r101.f249321f;
            if (r102 == null) goto L6;
        L7:
            C7677a r103 = this.f544137n.remove(r102);
            if (r103 != null) goto L15;
            int r104 = q.f60744a;
            Object[] r105 = new Object[4];
            r105[0] = "event handler is null, event id: ";
            r105[1] = r102;
            r105[2] = ", name: ";
            if (r101 == null) goto L13;
            String r106 = r101.f249319d;
            if (r106 == null) goto L13;
        L14:
            r105[3] = r106;
            q.e("PluginJsBridgeAdapter", r105);
        L13:
            r106 = "null";
        L15:
            c r107 = new c();
            Intrinsics.checkNotNullParameter("", "name");
            r107.f544140a.put("eventName", "");
            int r108 = CastIntegerProtector.parseInt(r102);
            r107.f544140a.put(com.heytap.mcssdk.constant.b.f276361k, r108);
            if (r103 != null) goto L30;
            return;
        L30:
            JSONObject r109 = new JSONObject(r100);     // Catch: Throwable -> L27
            r109.remove("__msg_type");     // Catch: Throwable -> L27
            r109.remove("__callback_id");     // Catch: Throwable -> L27
            Object r110 = r109.remove("__params");     // Catch: Throwable -> L27
            if (r110 == null) goto L26;
            JSONObject r111 = (JSONObject) r110;     // Catch: Throwable -> L27
            int r112 = r111.optInt("errCode", -1);     // Catch: Throwable -> L27
            if (r112 != (-1)) goto L23;
            r112 = r111.optInt("code");     // Catch: Throwable -> L27
        L23:
            r107.f544140a.put("resultCode", r112);     // Catch: Throwable -> L27
            r107.f544140a.put("data", r111);     // Catch: Throwable -> L27
            throw null;     // Catch: Throwable -> L27
        L26:
            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");     // Catch: Throwable -> L27
        L27:
            r107.f544140a.put("resultCode", -1);
            Intrinsics.checkNotNullParameter("数据解析错误，操作失败", "errMsg");
            r107.f544140a.put("errMsg", "数据解析错误，操作失败");
            throw null;
        L6:
            r102 = "";
            goto L7
        }
    }

    public static final class b implements C7676a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f544141a;

        public b(a r100) {
            this.f544141a = r100;
        }

        @Override // t10.a.C7676a.b
        public final void a(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            int r101 = r100.optInt(com.heytap.mcssdk.constant.b.f276361k, 0);
            int r102 = q.f60744a;
            q.f("PluginJsBridgeAdapter", new Object[]{"post js message, event id: ", Integer.valueOf(r101), ", params:", r100});
            na4.b r103 = this.f544141a.f544135a;
            if (r103 == null) goto L6;
            r103.c(r100);
            return;
        }
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        C7676a r101 = new C7676a(r100, new b(this));
        t10.b r102 = new t10.b(r101);
        d0.a r103 = d0.f249336g;
        o r104 = new o(r102);
        r104.f249401f = r100;
        r104.f249398c = r101;
        r104.f249402g = false;
        r104.f249403h = true;
        r104.f249399d = "OpenPlatformMiniGameJsbridge";
        r104.f249410o = true;
        r104.c(new c());
        r104.f249406k = "webcast";
        this.f544136b = r104.a();
    }
}
