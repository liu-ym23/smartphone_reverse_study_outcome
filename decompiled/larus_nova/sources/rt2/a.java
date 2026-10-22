package rt2;

import android.app.Application;
import android.net.Uri;
import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostNetwork;
import com.bytedance.android.livehostapi.platform.IHostWebView;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import zg1.k1;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements gmc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f539167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f539168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f539169c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f539170d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h f539171e;

    /* JADX INFO: renamed from: rt2.a$a, reason: collision with other inner class name */
    public static final class C7532a<T> implements h80.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f539172a;

        public C7532a(a r100) {
            this.f539172a = r100;
        }

        @Override // h80.d
        public final Object get() {
            IHostWebView r100 = (IHostWebView) k.f(IHostWebView.class);
            if (r100 == null) goto L30;
            Map<String, String> r101 = r100.getHeaderMap("https://" + this.f539172a.f539167a);
            if (r101 == null) goto L30;
            LinkedHashMap r102 = new LinkedHashMap();
            Iterator<Map.Entry<String, String>> r103 = r101.entrySet().iterator();
        L8:
            if (r103.hasNext() == false) goto L36;
            Map.Entry<String, String> r104 = r103.next();
            String r105 = r104.getKey();
            boolean r106 = true;
            if (r105 != null) goto L12;
        L15:
            boolean r107 = true;
        L16:
            if (r107 == true) goto L26;
            String r108 = r104.getValue();
            if (r108 != null) goto L20;
        L23:
            boolean r109 = true;
        L24:
            if (r109 == true) goto L26;
        L27:
            if (r106 == false) goto L8;
            r102.put(r104.getKey(), r104.getValue());
            goto L8
        L20:
            if (r108.length() == 0) goto L23;
            r109 = false;
        L26:
            r106 = false;
            goto L27
        L12:
            if (r105.length() == 0) goto L15;
            r107 = false;
            goto L16
        L36:
            return r102;
        L30:
            return new HashMap();
        }
    }

    @Override // gmc.a
    public final void b() {
    }

    @Override // gmc.a
    public final Map<String, String> a() {
        IMiddleWareHostContext r100 = (IMiddleWareHostContext) k.n(IMiddleWareHostContext.class);
        HashMap r101 = new HashMap(((IMiddlewareNetworkService) k.n(IMiddlewareNetworkService.class)).getCommonParams());
        r101.put("aid", String.valueOf(r100.hostAppId()));
        r101.put("user_id", ((IMiddlewareUserService) k.n(IMiddlewareUserService.class)).user().n().toString());
        r101.put("live_id", String.valueOf(((IMiddleWareHostContext) k.n(IMiddleWareHostContext.class)).liveId()));
        return r101;
    }

    @Override // gmc.a
    public final Uri e() {
        return UriProtector.parse("https://" + this.f539167a + hm2.c.a("union"));
    }

    public a() {
        Application r100 = jc1.a.b();
        this.f539167a = ((IMiddlewareHostNetwork) k.n(IMiddlewareHostNetwork.class)).getHostDomain();
        this.f539168b = new d();
        this.f539169c = new e();
        this.f539170d = new c();
        this.f539171e = new h(r100, new C7532a(this));
        xs2.b.a().b(k1.class).subscribe(new b(this));
    }

    @Override // gmc.a
    public final Uri f() {
        return UriProtector.parse("wss://webcast100-ws-frontier.amemv.com/webcast/im/push/union/");
    }

    @Override // gmc.a
    public final Uri g() {
        return UriProtector.parse("wss://webcast100-ws-c.amemv.com/webcast/im/push/union/");
    }

    @Override // gmc.a
    public final com.ss.ugc.live.sdk.msg.unify.network.a c() {
        return this.f539170d;
    }

    @Override // gmc.a
    public final com.ss.ugc.live.sdk.msg.unify.network.c d() {
        return this.f539171e;
    }

    @Override // gmc.a
    public final vlc.c logger() {
        return this.f539168b;
    }

    @Override // gmc.a
    public final vlc.g monitor() {
        return this.f539169c;
    }
}
