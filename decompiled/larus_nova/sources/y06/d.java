package y06;

import com.bytedance.ies.bullet.service.base.BulletLogger;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.text.Charsets;
import org.json.JSONObject;
import w26.g;
import yf7.j;
import yf7.n;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f565588a = null;

    static {
        f565588a = new d();
    }

    public d() {
    }

    @Override // yf7.n
    public final void a(j.a r100) {
        ExecutorService r101 = BulletLogger.f247763a;
        StringBuilder r102 = new StringBuilder("BulletByteSyncManager： receive message : ");
        String r103 = null;
        if (r100 == null) goto L5;
        byte[] r104 = r100.f567450a;
    L6:
        r102.append(r104);
        BulletLogger.d(r102.toString());
        if (r100 == null) goto L11;
        byte[] r105 = r100.f567450a;
        if (r105 == null) goto L11;
        r103 = new String(r105, Charsets.UTF_8);
    L11:
        c r106 = c.f565585a;
        int r107 = new JSONObject(r103).optInt("sync_type");
        BulletLogger.d("BulletByteSyncManager： dealWithUpdate type : " + r107);
        if (r107 != 1) goto L24;
        if (r100 == null) goto L15;
        long r108 = r100.f567451b;
    L16:
        Long r109 = c.f565586b;
        if (r109 != null) goto L19;
        return;
    L19:
        if (r108 <= r109.longValue()) goto L26;
        BulletLogger.d("BulletByteSyncManager：checkUpdate");
        Map<String, Map<Class<?>, Object>> r110 = x26.a.f562251a;
        g r111 = (g) x26.a.a(g.class);
        if (r111 == null) goto L27;
        r111.a();
        return;
    L27:
        return;
    L26:
        return;
    L15:
        r108 = System.currentTimeMillis();
        goto L16
    L24:
        return;
    L5:
        r104 = null;
        goto L6
    }
}
