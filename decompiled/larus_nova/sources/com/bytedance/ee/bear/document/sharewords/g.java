package com.bytedance.ee.bear.document.sharewords;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.sharewords.bean.ShareWordsThumbnailRequest;
import com.bytedance.ee.bear.document.sharewords.bean.ShareWordsThumbnailResponse;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f221797a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ShareWordsThumbnailRequest f221798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ShareWordsThumbnailResponse f221799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static b f221800d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f221801e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f221802f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final t35.a f221803g = null;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.sharewords.g$a$a, reason: collision with other inner class name */
        public static final class C3161a implements d.c {
            public C3161a() {
            }

            @Override // com.bytedance.ee.bear.document.sharewords.d.c
            public final void a(ShareWordsThumbnailResponse r100) {
                g.f221799c = r100;
                StringBuilder r101 = new StringBuilder("onCallback: ");
                if (g.f221799c != null) goto L5;
                boolean r102 = true;
            L6:
                r101.append(r102);
                Log.i("ShareWordsInstance", r101.toString());
                b r103 = g.f221800d;
                if (r103 == null) goto L9;
                r103.a(r100, g.f221802f);
            L9:
                g.f221801e = false;
                return;
            L5:
                r102 = false;
                goto L6
            }
        }

        public static void a(boolean r100) {
            ShareWordsThumbnailRequest r101 = g.f221798b;
            if (r101 == null) goto L6;
            g.f221801e = true;
            g.f221799c = null;
            Log.i("ShareWordsInstance", "start requestShareWordsThumbnailUrl " + r100);
            d r102 = g.f221797a;
            C3161a r103 = new C3161a();
            r102.getClass();
            Intrinsics.checkNotNullParameter(r101, "request");
            Intrinsics.checkNotNullParameter(r103, "callback");
            NetService.d r104 = ((NetService) k.a(LarkContext.getApplication(), NetService.class)).Vc(new d.b());
            NetService.e r105 = new NetService.f("/space/api/file/get_thumbnail_url");
            r105.f216906c = 2;
            r105.b("obj_token", r101.f221787a);
            r105.b("obj_type", String.valueOf(r101.f221788b));
            r105.b("url", r101.f221789c);
            HashMap r106 = new HashMap();
            r106.put("Content-Type", "application/x-www-form-urlencoded");
            r105.c(r106);
            r102.f221794a.add(r104.a(r105).timeout(7, TimeUnit.SECONDS).subscribeOn(fo5.d.c()).observeOn(fo5.d.d()).subscribe(new e(r103), new f(r103)));
            return;
        }
    }

    public interface b {
        void a(ShareWordsThumbnailResponse r100, long r101);
    }

    static {
        f221797a = new d();
        f221803g = new t35.a((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6));
    }
}
