package uw3;

import android.text.TextUtils;
import com.bytedance.applog.log.m;
import com.bytedance.applog.monitor.MonitorKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gx3.c f551940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final rw3.f f551941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile j f551942c;

    /* JADX INFO: loaded from: classes14.dex */
    public class a implements com.bytedance.applog.log.g.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ rw3.f f551943a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ gx3.c f551944b;

        @Override // com.bytedance.applog.log.g.b
        public final Object fetch() {
            JSONObject r100 = new JSONObject();
            r100.put("appId", this.f551943a.f539603c.f192413j);     // Catch: Throwable -> L5
            r100.put("config", this.f551944b.f483097c);     // Catch: Throwable -> L5
        L4:
            return r100;
        }

        public a(rw3.f r100, gx3.c r101) {
            this.f551943a = r100;
            this.f551944b = r101;
        }
    }

    @Override // uw3.e
    public final boolean b() {
        return !(!((ArrayList) this.f551940a.f483099e).isEmpty());
    }

    public i(rw3.f r100, gx3.c r101) {
        this.f551942c = null;
        this.f551941b = r100;
        this.f551940a = r101;
        if (m.b() == true) goto L6;
        m.c("sampling_config", new a(r100, r101));
        return;
    }

    @Override // uw3.e
    public final boolean a(MonitorKey r100, String r101, String r102, JSONObject r103) {
        if (MonitorKey.event_v3.equals(r100) == false) goto L5;
    L7:
        gx3.c r104 = this.f551940a;
        if (this.f551942c == null) goto L10;
        j r105 = this.f551942c;
    L11:
        Iterator r106 = ((ArrayList) r104.f483099e).iterator();
    L13:
        if (r106.hasNext() == false) goto L52;
        gx3.a r107 = (gx3.a) r106.next();
        r107.getClass();
        if (TextUtils.isEmpty(r101) == true) goto L40;
        Set<String> r108 = r107.f483092b;
        if (r108 == null) goto L23;
        if (r108.contains(r101) == false) goto L23;
        boolean r109 = true;
    L41:
        if (r109 == false) goto L13;
        return r107.c(r105);
    L23:
        if (TextUtils.isEmpty(r102) == false) goto L26;
        if (r103 == null) goto L40;
    L26:
        Map<String, List<Set<String>>> r110 = r107.f483093c;
        if (r110 != null) goto L29;
    L30:
        Map<String, List<Map<String, Object>>> r111 = r107.f483094d;
        if (r111 == null) goto L40;
        if (r111.containsKey(r101) == false) goto L40;
    L34:
        if (r103 == null) goto L36;
        JSONObject r112 = r103;
    L44:
        r109 = r107.b(r101, r112);     // Catch: Throwable -> L39
    L36:
        r112 = new JSONObject(r102);     // Catch: Throwable -> L39
        goto L44
    L29:
        if (r110.containsKey(r101) == true) goto L34;
    L40:
        r109 = false;
        goto L41
    L52:
        return false;
    L10:
        this.f551942c = new j(this);
        r105 = this.f551942c;
        goto L11
    L5:
        if (MonitorKey.log_data.equals(r100) == true) goto L7;
        return false;
    }
}
