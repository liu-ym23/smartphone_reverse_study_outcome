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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g {
    public static final d a = null;
    public static ShareWordsThumbnailRequest b;
    public static ShareWordsThumbnailResponse c;
    public static b d;
    public static boolean e;
    public static long f;
    public static final t35.a g = null;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.sharewords.g$a$a, reason: collision with other inner class name */
        public static final class C0105a implements d.c {
            public C0105a() {
            }

            @Override // com.bytedance.ee.bear.document.sharewords.d.c
            public final void a(ShareWordsThumbnailResponse r6) {
                g.c = r6;
                StringBuilder r0 = new StringBuilder("onCallback: ");
                if (g.c != null) goto L5;
                boolean r1 = true;
            L6:
                r0.append(r1);
                Log.i("ShareWordsInstance", r0.toString());
                b r2 = g.d;
                if (r2 == null) goto L9;
                r2.a(r6, g.f);
            L9:
                g.e = false;
                return;
            L5:
                r1 = false;
                goto L6
            }
        }

        public static void a(boolean r6) {
            ShareWordsThumbnailRequest r0 = g.b;
            if (r0 == null) goto L6;
            g.e = true;
            g.c = null;
            Log.i("ShareWordsInstance", "start requestShareWordsThumbnailUrl " + r6);
            d r7 = g.a;
            C0105a r1 = new C0105a();
            r7.getClass();
            Intrinsics.checkNotNullParameter(r0, "request");
            Intrinsics.checkNotNullParameter(r1, "callback");
            NetService.d r2 = ((NetService) k.a(LarkContext.getApplication(), NetService.class)).Vc(new d.b());
            NetService.e r3 = new NetService.f("/space/api/file/get_thumbnail_url");
            r3.c = 2;
            r3.b("obj_token", r0.a);
            r3.b("obj_type", String.valueOf(r0.b));
            r3.b("url", r0.c);
            HashMap r4 = new HashMap();
            r4.put("Content-Type", "application/x-www-form-urlencoded");
            r3.c(r4);
            r7.a.add(r2.a(r3).timeout(7, TimeUnit.SECONDS).subscribeOn(fo5.d.c()).observeOn(fo5.d.d()).subscribe(new e(r1), new f(r1)));
            return;
        }
    }

    public interface b {
        void a(ShareWordsThumbnailResponse r1, long r2);
    }

    static {
        a = new d();
        g = new t35.a((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6));
    }
}
