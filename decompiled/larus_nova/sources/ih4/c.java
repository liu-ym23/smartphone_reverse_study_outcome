package ih4;

import android.os.Message;
import android.os.SystemClock;
import com.bytedance.apm.block.i;
import com.bytedance.apm.block.j;
import com.bytedance.crash.util.g;
import com.bytedance.crash.util.h;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.sva.sdk.effectplatform.EffectConstant;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f489850c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f489851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f489852b;

    public final synchronized void f() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.f489852b == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f489852b = true;     // Catch: Throwable -> L13
        a r100 = this.f489851a;     // Catch: Throwable -> L13
        r100.getClass();     // Catch: Throwable -> L13
        a.d r101 = new a.d();     // Catch: Throwable -> L13
        r100.f489810a = r101;     // Catch: Throwable -> L13
        r100.f489811b = r101;     // Catch: Throwable -> L13
        r100.f489816g = new JSONArray();     // Catch: Throwable -> L13
        j.c();     // Catch: Throwable -> L13
        j.a r102 = j.f190356h;     // Catch: Throwable -> L13
        if (r102 == null) goto L11;
        r102.addMessageObserver(this);     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
    }

    static {
        f489850c = new c();
    }

    public c() {
        this.f489851a = new a();
    }

    @Override // com.bytedance.apm.block.i
    public final void b(String r100) {
        this.f489851a.a(null);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00ba -> B:38:0x00be). Please report as a decompilation issue!!! */
    public final void c(File r210) {
        a r100 = this.f489851a;
        r100.getClass();
        long r101 = System.currentTimeMillis();
        long r102 = SystemClock.uptimeMillis();
        monitor-enter(r100);
    L108:
        th = move-exception;
        throw th;
    L5:
        if (r100.f489811b != null) goto L7;
        long r110 = 0;
        long r111 = 0;
        a.d r103 = null;
        boolean r104 = false;
        a.c r112 = null;
    L15:
        monitor-exit(r100);     // Catch: Throwable -> L108
        if (r112 == null) goto L18;
        File r113 = r210;
        a.c.b(r112, r113, r101 - r110, r104);
    L20:
        if (r103 == null) goto L47;
        r103.f489823b.e(true);
        JSONArray r105 = new JSONArray();
        a.d.C6267a r106 = r103.f489822a;
        int r107 = r106.f489826c;
        a.d r114 = r103;
        if (r107 != (-1)) goto L24;
        a r115 = r100;
        JSONArray r108 = r105;
        File r109 = r113;
        long r116 = r102;
        long r117 = r101;
        long r118 = r111;
        long r119 = r110;
        a.c r120 = r112;
        long r121 = r116;
    L38:
        a r211 = r100;
        a.d r122 = r114;
        a.j r123 = null;
    L30:
        if (r123 == null) goto L44;
        File r124 = r113;
        JSONObject r125 = new JSONObject();
        r123.c(r125);     // Catch: JSONException -> L34
        r108.put(r125);     // Catch: JSONException -> L34
    L35:
        a.d.C6267a r126 = r122.f489822a;
        int r127 = r126.f489827d + 1;
        r126.f489827d = r127;
        r114 = r122;
        if (r127 == (r126.f489826c + 1)) goto L37;
        if (r127 != r126.f489825b) goto L43;
        r126.f489827d = 0;
    L43:
        r123 = r126.f489824a[r126.f489827d];
        r113 = r124;
        r122 = r114;
        goto L30
    L37:
        r100 = r211;
        r113 = r124;
        goto L38
    L44:
        File r128 = r113;
        JSONObject r129 = new JSONObject();
        r129.put("history_message", r108);     // Catch: JSONException -> L111
        JSONObject r130 = new JSONObject();     // Catch: JSONException -> L111
        r130.put("dump_wall_time", r117);     // Catch: JSONException -> L111
        r130.put("dump_up_time", r116);     // Catch: JSONException -> L111
        r130.put("last_wall_time", r119);     // Catch: JSONException -> L111
        r130.put("last_cpu_time", r118);     // Catch: JSONException -> L111
        r129.put("history_details", r130);     // Catch: JSONException -> L111
    L46:
        h.i(new PolarisFileWrapper(r109, "history.json"), r129);
        r100 = r211;
        r102 = r121;
        r112 = r120;
        a r131 = r115;
        r113 = r128;
    L49:
        if (r100.f489816g.length() == 0) goto L51;
        JSONObject r132 = new JSONObject();
        com.bytedance.crash.util.j.h(r132, "block_stack", r100.f489816g);
        h.i(new PolarisFileWrapper(r113, "block_stack.json"), r132);
    L51:
        a.e r133 = new a.e();
        a.e.c(r133, r102);
        monitor-enter(r131);
    L105:
        th = move-exception;
        throw th;
    L54:
        if ((r100.f489811b instanceof a.e) == false) goto L57;
        r133.f489833b = ((a.e) r100.f489811b).f489833b;     // Catch: Throwable -> L105
        r100.f489811b = r100.f489810a;     // Catch: Throwable -> L105
    L61:
        monitor-exit(r131);     // Catch: Throwable -> L105
        JSONArray r134 = new JSONArray();
        int r135 = 0;
        int r136 = 0;
        int r137 = 0;
    L64:
        if (r135 >= 200) goto L101;
        if (r136 < r133.f489833b.size()) goto L67;
        if (r137 >= r133.f489832a.size()) goto L101;
        int r138 = r137 + 1;
        a.k r139 = r133.f489832a.get(r137);
        JSONObject r140 = new JSONObject();
        r139.c(r140);     // Catch: JSONException -> L99
        int r141 = r135 + 1;
        r140.put("id", r135);     // Catch: JSONException -> L97
        r134.put(r140);     // Catch: JSONException -> L97
    L98:
        r135 = r141;
    L100:
        r137 = r138;
        goto L64
    L67:
        int r142 = r136 + 1;
        a.f r143 = r133.f489833b.get(r136);
        JSONObject r144 = new JSONObject();
        r143.c(r144);     // Catch: JSONException -> L74
        int r145 = r135 + 1;
        r144.put("id", r135);     // Catch: JSONException -> L72
        r134.put(r144);     // Catch: JSONException -> L72
    L73:
        r135 = r145;
    L76:
        if (r137 >= r133.f489832a.size()) goto L89;
        a.k r146 = r133.f489832a.get(r137);
        if (r143.f489845c == r146.f489845c) goto L80;
    L86:
        boolean r147 = false;
    L87:
        if (r147 == false) goto L89;
        r137 = r137 + 1;
        goto L89
    L80:
        if (r143.f489846d != r146.f489846d) goto L86;
        if (r143.f489843a != r146.f489843a) goto L86;
        if (r143.f489844b != r146.f489844b) goto L86;
        r147 = true;
    L89:
        r136 = r142;
    L101:
        JSONObject r148 = new JSONObject();
        r148.put("pending_messages", r134);     // Catch: JSONException -> L112
    L103:
        h.i(new PolarisFileWrapper(r113, "pending.json"), r148);
        return;
    L57:
        if ((r100.f489811b instanceof a.c) == false) goto L61;
        if (r112 == null) goto L61;
        r112.f489821d = true;     // Catch: Throwable -> L105
        goto L61
    L24:
        int r149 = r107 + 1;
        r106.f489827d = r149;
        if (r149 != r106.f489825b) goto L27;
    L28:
        r106.f489827d = 0;
    L29:
        r123 = r106.f489824a[r106.f489827d];
        r211 = r100;
        r115 = r211;
        r108 = r105;
        r109 = r113;
        r122 = r114;
        r116 = r102;
        r117 = r101;
        r118 = r111;
        r119 = r110;
        r120 = r112;
        r121 = r116;
        goto L30
    L27:
        if (r106.f489824a[r149].f489834e != 0) goto L29;
    L47:
        r131 = r100;
        goto L49
    L18:
        r113 = r210;
        goto L20
    L7:
        if (r100.f489812c != 0) goto L9;
    L12:
        monitor-exit(r100);     // Catch: Throwable -> L108
        return;
    L9:
        if ((r100.f489811b instanceof a.d) == false) goto L12;
        r103 = (a.d) r100.f489811b;     // Catch: Throwable -> L108
        r112 = new a.c();     // Catch: Throwable -> L108
        r110 = r100.f489812c;     // Catch: Throwable -> L108
        r111 = r100.f489813d;     // Catch: Throwable -> L108
        r104 = r100.f489815f;     // Catch: Throwable -> L108
        r100.f489811b = r112;     // Catch: Throwable -> L108
        goto L15
    }

    public static void d(JSONObject r100, File r101) {
        e(r100, new PolarisFileWrapper(r101, EffectConstant.CURRENT_CONFIG_JSON));
        e(r100, new PolarisFileWrapper(r101, "history.json"));
        e(r100, new PolarisFileWrapper(r101, "pending.json"));
        e(r100, new PolarisFileWrapper(r101, "block_stack.json"));
    }

    public static void e(JSONObject r100, PolarisFileWrapper r101) {
        String r102 = g.f(r101);     // Catch: Exception -> L6
        if (r102 == null) goto L9;
        com.bytedance.crash.util.j.d(r100, new JSONObject(r102));     // Catch: Exception -> L6
        return;
    L9:
        return;
    }

    @Override // com.bytedance.apm.block.i
    public final void a(String r100, Message r101) {
        this.f489851a.a(r101);
    }
}
