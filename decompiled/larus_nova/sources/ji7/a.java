package ji7;

import android.app.Application;
import android.net.Uri;
import android.text.TextUtils;
import ci7.l;
import ci7.p;
import ci7.x;
import ci7.z;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.ug.sdk.deeplink.CallBackForAppLink;
import com.bytedance.ug.sdk.deeplink.IZlinkDepend;
import com.bytedance.ug.sdk.deeplink.ZlinkApi;
import com.bytedance.ug.sdk.deeplink.ZlinkDependAbility;
import com.bytedance.ug.sdk.deeplink.interfaces.INetwork;
import com.ss.android.lark.monitor.traffic.TrafficMetrics;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import mi7.k;
import mi7.m;
import mi7.n;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements e {

    /* JADX INFO: renamed from: ji7.a$a, reason: collision with other inner class name */
    public static class C6441a implements fi7.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f499201a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f499202b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f499203c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f499204d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ k.a f499205e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ CallBackForAppLink f499206f;

        public final void a(int r110, String r111) {
            long r100 = System.currentTimeMillis() - this.f499201a;
            mi7.c.e(this.f499202b, r110, r100, this.f499203c, TrafficMetrics.FRPM_TTNET);
            if (TextUtils.isEmpty(r111) == false) goto L19;
        L6:
            String r101 = "";
        L7:
            int r112 = a.c(r110, r101, r111, this.f499204d);
            int r102 = 0;
            if (TextUtils.isEmpty(r101) == true) goto L10;
            mi7.c.f(r112, this.f499202b, TrafficMetrics.FRPM_TTNET);
            m.c(1, r101, this.f499205e);
            m.a(0, r101, this.f499205e);
            fi7.d.b(this.f499206f, r101);
            return;
        L10:
            if (r110 >= 200) goto L12;
        L14:
            m.b(r102, this.f499202b, this.f499205e);
            mi7.c.f(r112, this.f499202b, TrafficMetrics.FRPM_TTNET);
            fi7.d.b(this.f499206f, r101);
            return;
        L12:
            if (r110 >= 400) goto L14;
            r102 = 1;
            goto L14
        L19:
            r101 = UriProtector.getQueryParameter(UriProtector.parse(r111), "scheme");     // Catch: Throwable -> L18
            goto L7
        }

        public C6441a(long r100, String r101, int r102, String r103, k.a r104, CallBackForAppLink r105) {
            this.f499201a = r100;
            this.f499202b = r101;
            this.f499203c = r102;
            this.f499204d = r103;
            this.f499205e = r104;
            this.f499206f = r105;
        }
    }

    public a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.util.List] */
    public static boolean e(Uri r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        String r101 = r100.getScheme();
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return false;
    L8:
        String r102 = r100.getHost();
        if ("http".equalsIgnoreCase(r101) == false) goto L11;
    L12:
        Application r103 = l.a();
        List<WeakReference<ki7.b>> r104 = ki7.c.f503641a;
        ?? r105 = new ArrayList();
        String r106 = ki7.d.b(r103).optString("deeplink_domains", "");
        CallBackForAppLink r107 = null;
        if (TextUtils.isEmpty(r106) == true) goto L28;
        JSONArray r108 = new JSONArray(r106);     // Catch: JSONException -> L17
    L19:
        if (r108 == null) goto L28;
        if (r108.length() <= 0) goto L28;
        r105 = new ArrayList();
        int r109 = 0;
    L25:
        if (r109 >= r108.length()) goto L28;
        r105.add(r108.optString(r109));
        r109 = r109 + 1;
    L17:
        e = move-exception;
        e.printStackTrace();
        r108 = null;
    L28:
        if (mi7.a.a(r105) == false) goto L36;
        ZlinkDependAbility r110 = p.f23879a;
        if (r110 == null) goto L33;
        r107 = r110.getCallBackForAppLink();
    L33:
        if (r107 == null) goto L36;
        r105 = r107.getHostList();
    L36:
        if (mi7.a.a(r105) == true) goto L46;
        Iterator r111 = r105.iterator();
    L39:
        if (r111.hasNext() == false) goto L46;
        String r112 = (String) r111.next();
        if (r102 == null) goto L39;
        if (r102.equalsIgnoreCase(r112) == false) goto L39;
        return true;
    L46:
        return false;
    L11:
        if ("https".equalsIgnoreCase(r101) == false) goto L46;
        goto L12
    }

    @Override // ji7.e
    public final boolean a(Uri r100) {
        return e(r100);
    }

    @Override // ji7.e
    public final void b(Uri r100, k.a r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        String r102 = UriProtector.getQueryParameter(r100, "scheme");
        if (x.f23891a != null) goto L7;
        x.f23891a = new CopyOnWriteArrayList();
    L7:
        x.f23891a.add(r100);
        if (TextUtils.isEmpty(r100.getHost()) == false) goto L10;
        return;
    L10:
        ZlinkDependAbility r103 = p.f23879a;
        if (r103 != null) goto L13;
        CallBackForAppLink r104 = null;
    L14:
        if (r104 != null) goto L16;
        return;
    L16:
        Application r105 = l.f23871a;
        if (ZlinkApi.INSTANCE.isInited() == false) goto L19;
        l.b(r100, true);
    L21:
        if (r100.isOpaque() == false) goto L23;
    L28:
        Uri r106 = null;
    L29:
        if (r106 == null) goto L31;
    L35:
        if (r106 == null) goto L37;
        r100 = r106;
    L37:
        d(r100, r104, r101);
        return;
    L31:
        if (TextUtils.isEmpty(r102) == true) goto L35;
        if (n.a(r102) == false) goto L41;
        mi7.c.f(2, "", null);
        fi7.d.b(r104, r102);
        m.c(0, r102, r101);
        m.a(0, r102, r101);
        return;
    L41:
        return;
    L23:
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r100, "zlink_token")) == true) goto L28;
        r106 = n.b(r100);     // Catch: Exception -> L26
    L26:
        e = move-exception;
        mi7.e.b("AppLinkResolver", "get applink new uri error : " + e.getMessage());
        goto L28
    L19:
        ((CopyOnWriteArraySet) fi7.d.f477414d).add(new ci7.n(r100));
        goto L21
    L13:
        r104 = r103.getCallBackForAppLink();
        goto L14
    }

    public static void d(Uri r110, CallBackForAppLink r111, k.a r112) {
        if (r110 == null) goto L38;
        IZlinkDepend r100 = p.a();
        if (r100 == null) goto L6;
        long r101 = r100.getUpdateVersionCode();
        String r102 = r100.getAppId();
    L8:
        if (r101 == 0) goto L11;
        r110 = r110.buildUpon().appendQueryParameter("zlink_update_version_code", String.valueOf(r101)).build();
    L11:
        if (r102.isEmpty() == true) goto L13;
        r110 = r110.buildUpon().appendQueryParameter("zlink_app_id", r102).build();
    L13:
        String r103 = r110.toString();
        String r104 = r110.getScheme();
        if ("http".equalsIgnoreCase(r104) == false) goto L16;
        r104 = "https";
    L16:
        String r105 = r104 + "://" + r110.getHost();
        String r106 = r110.getEncodedQuery();
        String r107 = r110.getPath();
        if (r106 == null) goto L19;
        r107 = r110.getPath() + "?" + r110.getEncodedQuery();
    L19:
        String r113 = r107;
        Application r108 = l.a();
        List<WeakReference<ki7.b>> r109 = ki7.c.f503641a;
        int r114 = ki7.d.b(r108).optInt("deeplink_timeout", 60000);
        if (((INetwork) z.a(INetwork.class)) != null) goto L22;
        mi7.e.b("AppLinkResolver", "the INetwork is null so the request couldn't be sent !");     // Catch: Throwable -> L29
    L32:
        return;
    L22:
        C6441a r115 = new C6441a(System.currentTimeMillis(), r103, r114, r105, r112, r111);     // Catch: Throwable -> L29
        INetwork r116 = (INetwork) z.a(INetwork.class);     // Catch: Throwable -> L29
        if (r116 == null) goto L32;
        r116.fetchScheme(r105, r113, r114, r115);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        mi7.e.b("NetworkUtils", th.getMessage());     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        mi7.e.b("AppLinkResolver", "the network request occurs exception and the exception is : " + th.getMessage());
        return;
    L6:
        r102 = "";
        r101 = 0;
        goto L8
    }

    public static int c(int r100, String r101, String r102, String r103) {
        if (r100 >= 200) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == true) goto L10;
        return 0;
    L10:
        if (r100 == 302) goto L12;
        return r100;
    L12:
        if (TextUtils.isEmpty(r101) == true) goto L14;
    L20:
        return 1;
    L14:
        if (TextUtils.isEmpty(r102) == true) goto L20;
        if (TextUtils.isEmpty(r103) == true) goto L20;
        if (r102.startsWith(r103) == false) goto L20;
        return 3;
    L5:
        if (r100 >= 400) goto L7;
        r104 = true;
        goto L8
    }
}
