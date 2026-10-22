package ih4;

import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.SystemClock;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.sva.sdk.effectplatform.EffectConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile d f489810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile b f489811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f489812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f489813d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f489814e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f489815f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public JSONArray f489816g;

    /* JADX INFO: renamed from: ih4.a$a, reason: collision with other inner class name */
    public class RunnableC6266a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f489817a;

        public final void a() {
            long r100 = System.currentTimeMillis();
            String r101 = NativeBridge.y();
            JSONObject r102 = new JSONObject();     // Catch: Throwable -> L7
            r102.put("time", r100);     // Catch: Throwable -> L7
            r102.put("trace", r101);     // Catch: Throwable -> L7
            this.f489817a.f489816g.put(r102);     // Catch: Throwable -> L7
            if (this.f489817a.f489816g.length() < 5) goto L10;
            this.f489817a.f489816g.remove(0);     // Catch: Throwable -> L7
            return;
        L10:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC6266a(a r100) {
            this.f489817a = r100;
        }
    }

    public interface b {
        b a(Message r100, long r101, long r102, long r103);
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public File f489818a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public f f489819b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final JSONObject f489820c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f489821d;

        public c() {
            this.f489820c = new JSONObject();
        }

        public static void b(c r100, File r101, long r102, boolean r103) {
            JSONObject r104 = r100.f489820c;
            monitor-enter(r104);
            JSONObject r105 = r100.f489820c.optJSONObject("current_message");     // Catch: Throwable -> L15 JSONException -> L21
            if (r105 != null) goto L11;
            r105 = new JSONObject();     // Catch: Throwable -> L15 JSONException -> L21
            r100.f489820c.put("current_message", r105);     // Catch: Throwable -> L15 JSONException -> L21
            if (r103 == false) goto L9;
            String r106 = "message is running";
        L10:
            r105.put("message", r106);     // Catch: Throwable -> L15 JSONException -> L21
            goto L11
        L9:
            r106 = "no message running";
        L11:
            r105.put("currentMessageCost", r102);     // Catch: Throwable -> L15 JSONException -> L21
            r105.put("currentMessageCpu", -1);     // Catch: Throwable -> L15 JSONException -> L21
            r100.f489818a = r101;     // Catch: Throwable -> L15 JSONException -> L21
            if (r101 == null) goto L17;
            com.bytedance.crash.util.h.i(new PolarisFileWrapper(r101, EffectConstant.CURRENT_CONFIG_JSON), r100.f489820c);     // Catch: Throwable -> L15 JSONException -> L21
        L15:
            th = move-exception;
            throw th;
        L17:
            monitor-exit(r104);     // Catch: Throwable -> L15
        }

        @Override // ih4.a.b
        public final b a(Message r100, long r101, long r102, long r103) {
            f r104 = new f();
            this.f489819b = r104;
            r104.f489834e = r101;
            r104.f489835f = r102;
            r104.a(r100, r103);
            JSONObject r105 = this.f489820c;
            monitor-enter(r105);
            JSONObject r106 = (JSONObject) this.f489820c.opt("current_message");     // Catch: Throwable -> L18 JSONException -> L29
            if (r106 != null) goto L7;
            r106 = new JSONObject();     // Catch: Throwable -> L18 JSONException -> L29
            this.f489820c.put("current_message", r106);     // Catch: Throwable -> L18 JSONException -> L29
        L7:
            f r107 = this.f489819b;     // Catch: Throwable -> L18 JSONException -> L29
            String r108 = r107.f489844b;     // Catch: Throwable -> L18 JSONException -> L29
            if (r108 != null) goto L14;
            r108 = r107.f489843a;     // Catch: Throwable -> L18 JSONException -> L29
            if (r108 != null) goto L14;
            r108 = "no message running";
        L14:
            r106.put("message", r108);     // Catch: Throwable -> L18 JSONException -> L29
            r106.put("currentMessageLastCost", this.f489819b.f489834e);     // Catch: Throwable -> L18 JSONException -> L29
            r106.put("currentMessageLastCpu", this.f489819b.f489835f);     // Catch: Throwable -> L18 JSONException -> L29
            File r109 = this.f489818a;     // Catch: Throwable -> L18 JSONException -> L29
            if (r109 == null) goto L20;
            com.bytedance.crash.util.h.i(new PolarisFileWrapper(r109, EffectConstant.CURRENT_CONFIG_JSON), this.f489820c);     // Catch: Throwable -> L18 JSONException -> L29
        L18:
            th = move-exception;
            throw th;
        L20:
            monitor-exit(r105);     // Catch: Throwable -> L18
            if (this.f489821d == false) goto L24;
            return null;
        L24:
            return new e();
        }
    }

    public static class d implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C6267a f489822a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b f489823b;

        /* JADX INFO: renamed from: ih4.a$d$a, reason: collision with other inner class name */
        public static class C6267a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final j[] f489824a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f489825b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f489826c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f489827d;

            public C6267a() {
                this.f489824a = new j[50];
                int r100 = 0;
            L3:
                if (r100 >= 50) goto L5;
                this.f489824a[r100] = new j(0);
                r100 = r100 + 1;
                goto L3
            L5:
                this.f489825b = 50;
                this.f489826c = -1;
            }
        }

        public static class b extends l {

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final HashMap<String, h> f489828k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final i f489829l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public final C6267a f489830m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public h f489831n;

            @Override // ih4.a.l
            public final void d() {
                super.d();
                this.f489831n = null;
                Iterator<h> r100 = this.f489828k.values().iterator();
            L4:
                if (r100.hasNext() == false) goto L8;
                h r101 = r100.next();
                if (r101 == null) goto L4;
                i r102 = this.f489829l;
                r101.f489837h = r102.f489838a;
                r102.f489838a = r101;
                goto L4
            L8:
                this.f489828k.clear();
            }

            public b(C6267a r100) {
                super(0);
                this.f489828k = new HashMap(30);
                this.f489829l = new i();
                this.f489830m = r100;
            }

            public final void e(boolean r100) {
                long r101 = this.f489834e;
                if (r101 == 0) goto L5;
            L6:
                if (r100 == false) goto L8;
            L10:
                C6267a r102 = this.f489830m;
                int r103 = r102.f489826c + 1;
                r102.f489826c = r103;
                if (r103 != r102.f489825b) goto L13;
                r102.f489826c = 0;
            L13:
                j r104 = r102.f489824a[r102.f489826c];
                r104.d();
                r104.f489836g = this.f489836g;
                r104.f489834e = this.f489834e;
                r104.f489835f = this.f489835f;
                r104.f489845c = this.f489845c;
                r104.f489849j = this.f489849j;
                r104.f489847h = this.f489847h;
                r104.f489848i = this.f489848i;
                h r105 = this.f489831n;
                if (r105 == null) goto L17;
                r104.f489839k = r105.f489836g;
                r104.f489840l = r105.f489834e;
                r104.f489841m = r105.f489835f;
                r104.f489842n = r105.f489845c;
            L17:
                if (r105 == null) goto L20;
                r104.f489843a = r105.f489843a;
                r104.f489844b = r105.f489844b;
                r104.f489846d = r105.f489846d;
            L20:
                d();
                return;
            L8:
                if (r101 > 200) goto L10;
                return;
            L5:
                if (this.f489836g != 0) goto L6;
            }
        }

        public d() {
            C6267a r100 = new C6267a();
            this.f489822a = r100;
            this.f489823b = new b(r100);
        }

        @Override // ih4.a.b
        public final b a(Message r110, long r111, long r210, long r211) {
            if (r110 == null) goto L47;
            b r100 = this.f489823b;
            if (r111 <= 200) goto L7;
            r100.e(true);
        L9:
            if (r110.getCallback() == null) goto L12;
            String r101 = r110.getCallback().getClass().getName();
        L15:
            h r102 = r100.f489828k.get(r101);
            if (r102 != null) goto L30;
            i r103 = r100.f489829l;
            h r112 = r103.f489838a;
            h r113 = null;
            if (r112 == null) goto L20;
            r103.f489838a = r112.f489837h;
            r112.f489837h = null;
            r112.f489843a = null;
            r112.f489844b = null;
            r112.f489845c = Long.MAX_VALUE;
            r112.f489846d = -1;
            r112.f489834e = 0;
            r112.f489835f = 0;
            r112.f489836g = 0;
        L21:
            if (r112 != null) goto L28;
            r100.e(true);
            i r104 = r100.f489829l;
            h r105 = r104.f489838a;
            if (r105 == null) goto L25;
            r104.f489838a = r105.f489837h;
            r105.f489837h = null;
            r105.f489843a = null;
            r105.f489844b = null;
            r105.f489845c = Long.MAX_VALUE;
            r105.f489846d = -1;
            r105.f489834e = 0;
            r105.f489835f = 0;
            r105.f489836g = 0;
            r113 = r105;
        L25:
            if (r113 == null) goto L54;
            r102 = r113;
        L29:
            r100.f489828k.put(r101, r102);
            r102.a(r110, r211);
        L54:
            return this;
        L28:
            r102 = r112;
            goto L29
        L20:
            r112 = null;
        L30:
            r102.f489834e += r111;
            r102.f489835f += r210;
            r102.f489836g++;
            long r114 = k.b(r110, r211);
            if (r102.f489845c <= r114) goto L33;
            r102.f489845c = r114;
        L33:
            r100.f489836g++;
            if (r100.f489845c != Long.MAX_VALUE) goto L41;
            long r106 = k.b(r110, r211);
            if (r106 > 0) goto L41;
            long r107 = r106 + r100.f489834e;
            if (r107 <= 0) goto L40;
            r100.f489845c = 0;
            goto L41
        L40:
            r100.f489845c = r107;
        L41:
            r100.f489834e += r111;
            r100.f489835f += r210;
            h r108 = r100.f489831n;
            if (r108 != null) goto L44;
        L45:
            r100.f489831n = r102;
        L46:
            r100.e(false);
            goto L54
        L44:
            if (r102.f489834e <= r108.f489834e) goto L46;
        L12:
            if (r110.getTarget() == null) goto L14;
            r101 = r110.getTarget().getClass().getName();
            goto L15
        L14:
            r101 = "unknown";
            goto L15
        L7:
            r100.getClass();
            goto L9
        L47:
            b r109 = this.f489823b;
            if (r111 <= 200) goto L50;
            r109.e(true);
        L50:
            r109.f489847h += r111;
            r109.f489848i += r210;
            if (r111 <= 1) goto L53;
            r109.f489849j++;
        L53:
            r109.f489834e += r111;
            r109.f489835f += r210;
            r109.e(false);
            goto L54
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static class e implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LinkedList<k> f489832a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public LinkedList<f> f489833b;

        public e() {
            this.f489832a = new LinkedList();
            this.f489833b = new LinkedList();
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class b(String r100) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
        L7:
            return r103;
        L8:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r100);
        L12:
            throw th;
        L34:
            Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
        L16:
            return r104;
        L17:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r100);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName(r100);
        }

        public static void c(e r100, long r101) {
            if (Looper.getMainLooper() == null) goto L12;
            Looper r102 = Looper.getMainLooper();
            if (r102 != Looper.myLooper()) goto L8;
            MessageQueue r103 = Looper.myQueue();
        L54:
            Field r104 = b("android.os.MessageQueue").getDeclaredField("mMessages");     // Catch: Exception -> L16
            r104.setAccessible(true);     // Catch: Exception -> L16
        L52:
            Field r105 = b("android.os.Message").getDeclaredField(TeaEventTrack.ACTION_DRAMA_NEXT);     // Catch: Exception -> L20
            r105.setAccessible(true);     // Catch: Exception -> L20
        L21:
            if (r103 == null) goto L43;
            if (r104 == null) goto L63;
            if (r105 == null) goto L65;
            monitor-enter(r103);     // Catch: Throwable -> L44
            Object r106 = r104.get(r103);     // Catch: IllegalAccessException -> L28 Throwable -> L40
        L29:
            Message r107 = (Message) r106;     // Catch: Throwable -> L40
            int r108 = 0;
        L30:
            if (r107 == null) goto L38;
            int r109 = r108 + 1;     // Catch: Throwable -> L40
            if (r108 >= 200) goto L38;
            k r110 = new k();     // Catch: Throwable -> L40
            r110.a(r107, r101);     // Catch: Throwable -> L40
            r100.f489832a.add(r110);     // Catch: Throwable -> L40
            Object r111 = r105.get(r107);     // Catch: IllegalAccessException -> L36 Throwable -> L40
        L37:
            r107 = (Message) r111;     // Catch: Throwable -> L40
            r108 = r109;
        L36:
            r111 = null;
        L38:
            monitor-exit(r103);     // Catch: Throwable -> L40
            goto L66
        L64:
            return;
        L28:
            r106 = null;
        L40:
            th = move-exception;
            throw th;     // Catch: Throwable -> L44
        L66:
            return;
        L65:
            return;
        L63:
            return;
        L43:
            return;
        L20:
            r105 = null;
        L16:
            r104 = null;
            goto L52
        L8:
            if (Build.VERSION.SDK_INT < 23) goto L50;
            r103 = r102.getQueue();
            goto L54
        L50:
            Field r112 = r102.getClass().getDeclaredField("mQueue");     // Catch: Throwable -> L45
            r112.setAccessible(true);     // Catch: Throwable -> L45
            r103 = (MessageQueue) r112.get(r102);     // Catch: Throwable -> L45
        L12:
            r103 = null;
            goto L54
        }

        @Override // ih4.a.b
        public final b a(Message r100, long r101, long r102, long r103) {
            if (r100 == null) goto L4;
            f r104 = new f();
            r104.a(r100, r103);
            r104.f489834e = r101;
            r104.f489835f = r102;
            this.f489833b.add(r104);
        L4:
            return this;
        }
    }

    public static class f extends k {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f489834e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f489835f;

        public f() {
        }

        @Override // ih4.a.k
        public void c(JSONObject r100) throws JSONException {
            super.c(r100);
            r100.put("duration", this.f489834e);
            r100.put("cpuDuration", this.f489835f);
        }
    }

    public static class g extends f {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f489836g;

        public g(int r100) {
        }
    }

    public static class h extends g {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public h f489837h;

        public h() {
            super(0);
        }
    }

    public static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h f489838a;

        public i() {
            int r100 = 30;
        L3:
            if (r100 <= 0) goto L5;
            h r101 = new h();
            r101.f489837h = this.f489838a;
            this.f489838a = r101;
            r100 = r100 - 1;
            goto L3
        }
    }

    public static class j extends l {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f489839k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f489840l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f489841m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public long f489842n;

        private int getType() {
            int r100 = this.f489836g;
            boolean r101 = true;
            if (r100 == 0) goto L15;
            if (r100 == 1) goto L7;
        L9:
            r101 = false;
        L10:
            if (r101 == false) goto L12;
            return 8;
        L12:
            return 9;
        L7:
            if ((this.f489834e - this.f489847h) <= 200) goto L9;
        L15:
            return 1;
        }

        @Override // ih4.a.l
        public final void d() {
            super.d();
            this.f489839k = 0;
            this.f489840l = 0;
            this.f489841m = 0;
        }

        public j(int r100) {
            super(0);
        }

        @Override // ih4.a.l, ih4.a.f, ih4.a.k
        public final void c(JSONObject r100) throws JSONException {
            super.c(r100);
            int r101 = getType();
            if (r101 != 9) goto L5;
            r100.put("LongestGroupMessageCount", this.f489839k);
            r100.put("LongestGroupDuration", this.f489840l);
            r100.put("LongestGroupCpuDuration", this.f489841m);
            r100.put("LongestGroupDelay", this.f489842n);
            r100.put("messageCount", this.f489836g);
        L5:
            String r102 = this.f489844b;
            if (r102 != null) goto L12;
            r102 = this.f489843a;
            if (r102 != null) goto L12;
            r102 = "no message running";
        L12:
            r100.put("msg", r102);
            r100.put("type", r101);
        }
    }

    public static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f489843a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f489844b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f489845c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f489846d;

        public k() {
            this.f489845c = Long.MAX_VALUE;
        }

        public void c(JSONObject r100) throws JSONException {
            String r101 = this.f489844b;
            if (r101 == null) goto L5;
            r100.put("callback", r101);
        L5:
            String r102 = this.f489843a;
            if (r102 == null) goto L8;
            r100.put(PickerReporterConstants.KEY.TARGET, r102);
        L8:
            int r103 = this.f489846d;
            if (r103 == (-1)) goto L11;
            r100.put("what", r103);
        L11:
            long r104 = this.f489845c;
            if (r104 == Long.MAX_VALUE) goto L15;
            r100.put(RemoteMessageConst.Notification.WHEN, r104);
            return;
        }

        public static long b(Message r100, long r101) {
            if (r100.getWhen() <= 100) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == true) goto L10;
            return Long.MAX_VALUE;
        L10:
            return r100.getWhen() - r101;
        L5:
            r102 = false;
            goto L6
        }

        public final void a(Message r100, long r101) {
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.getTarget() == null) goto L8;
            this.f489843a = r100.getTarget().getClass().getName();
        L8:
            if (r100.getCallback() == null) goto L23;
            String r102 = r100.getCallback().getClass().getName();
            this.f489844b = r102;
            if (r102.startsWith("Y.ARunnable") == false) goto L23;
            String r103 = r100.getCallback().toString();
            int r104 = 0;
            if (r103.charAt(0) < '0') goto L23;
            if (r103.charAt(0) > '9') goto L23;
            StringBuilder r105 = new StringBuilder();
            r105.append(this.f489844b);
            r105.append(".run$");
        L17:
            if (r104 >= r103.length()) goto L22;
            if (r103.charAt(r104) == '_') goto L22;
            r105.append(r103.charAt(r104));
            r104 = r104 + 1;
        L22:
            this.f489844b = r105.toString();
        L23:
            this.f489845c = b(r100, r101);
            this.f489846d = r100.what;
        }
    }

    public static class l extends g {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f489847h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f489848i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f489849j;

        public void d() {
            this.f489843a = null;
            this.f489844b = null;
            this.f489845c = Long.MAX_VALUE;
            this.f489846d = -1;
            this.f489834e = 0;
            this.f489835f = 0;
            this.f489836g = 0;
            this.f489847h = 0;
            this.f489848i = 0;
            this.f489849j = 0;
        }

        public l(int r100) {
            super(0);
        }

        @Override // ih4.a.f, ih4.a.k
        public void c(JSONObject r100) throws JSONException {
            super.c(r100);
            if (this.f489849j == 0) goto L6;
            r100.put("idleDuration", this.f489847h);
            r100.put("idleCpuDuration", this.f489848i);
            r100.put("idleCount", this.f489849j);
            return;
        }
    }

    public a() {
        new RunnableC6266a(this);
    }

    public final synchronized void a(Message r110) {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (this.f489811b != null) goto L8;
        monitor-exit(this);
        return;
    L8:
        long r100 = SystemClock.currentThreadTimeMillis();     // Catch: Throwable -> L20
        long r101 = System.currentTimeMillis();     // Catch: Throwable -> L20
        long r102 = SystemClock.uptimeMillis();     // Catch: Throwable -> L20
        long r103 = this.f489812c;     // Catch: Throwable -> L20
        if (r103 == 0) goto L14;
        long r111 = r101 - r103;     // Catch: Throwable -> L20
        long r112 = r100 - this.f489813d;     // Catch: Throwable -> L20
        b r104 = this.f489811b.a(r110, r111, r112, this.f489814e);     // Catch: Throwable -> L20
        if (r104 != null) goto L13;
        r104 = this.f489810a;     // Catch: Throwable -> L20
    L13:
        this.f489811b = r104;     // Catch: Throwable -> L20
    L14:
        if (r110 == null) goto L16;
        boolean r105 = true;
    L17:
        this.f489815f = r105;     // Catch: Throwable -> L20
        this.f489812c = r101;     // Catch: Throwable -> L20
        this.f489813d = r100;     // Catch: Throwable -> L20
        this.f489814e = r102;     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L16:
        r105 = false;
        goto L17
    }
}
