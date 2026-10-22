package gi7;

import android.app.Application;
import android.net.Uri;
import android.text.TextUtils;
import ci7.l;
import ci7.p;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.ug.sdk.deeplink.IZlinkDepend;
import com.larus.apm.impl.protector.RunnableProtector;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.text.Charsets;
import mi7.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f481468a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static f f481469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static e f481470c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f481471a;

        public a(JSONObject r100) {
            this.f481471a = r100;
        }

        public final void a() {
            Map r100 = MapsKt.emptyMap();
            String r101 = this.f481471a.toString();
            Charset r102 = Charsets.UTF_8;
            if (r101 == null) goto L7;
            mi7.e.a("SchemaFirstLaunchReporter", "response is " + mi7.f.c("https://zlink.toutiao.com/api/link_activate", r100, r101.getBytes(r102), 0, new JSONObject()) + '.');
            return;
        L7:
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
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
    }

    static {
        f481468a = new AtomicBoolean(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [int] */
    public static void a(Uri r100, String r101) {
        mi7.e.a("SchemaFirstLaunchReporter", "realReport " + r100);
        IZlinkDepend r102 = p.a();
        if (r102 == null) goto L25;
        ?? r103 = new JSONObject();
        r103.put("app_id", r102.getAppId());
        r103.put("scheme", r100.toString());
        if (r101 != null) goto L8;
        r101 = r102.getDeviceId();
    L8:
        r103.put("device_id", r101);
        boolean r104 = mi7.b.f514088a;
        ?? r105 = TextUtils.equals(UriProtector.getQueryParameter(r100, "_zlink_from_applink"), "1");     // Catch: Exception -> L11
    L13:
        r103.put(BdpAppEventConstant.PARAMS_LAUNCH_TYPE, r105);
        Application r106 = l.a();
        long r107 = 0;
        if (mi7.b.f514091d != 0) goto L21;
        mi7.g.a(r106).getClass();
        if (mi7.g.f514094a != null) goto L18;
    L20:
        mi7.b.f514091d = r107;
        goto L21
    L18:
        if (TextUtils.isEmpty("first_launch_timestamp") == true) goto L20;
        r107 = mi7.g.f514094a.getLong("first_launch_timestamp", 0);
    L21:
        r103.put("launch_timestamp", mi7.b.f514091d);
        r103.put("os", "android");
        r103.put("sdk_version", "1.2.5-alpha.0");
        h.a(new a(r103));
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        r105 = 0;
        goto L13
    }
}
