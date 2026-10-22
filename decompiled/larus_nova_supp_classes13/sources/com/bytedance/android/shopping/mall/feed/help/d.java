package com.bytedance.android.shopping.mall.feed.help;

import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import com.bytedance.android.shopping.mall.homepage.tools.FavRefreshParams;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public static final /* synthetic */ int i = 0;
    public volatile String a;
    public volatile Long b;
    public volatile com.bytedance.android.shopping.api.mall.c c;
    public volatile String d;
    public Runnable e;
    public final b f;
    public final c g;
    public final ECMallFeed h;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.ec.hybrid.card.event.e {
        public final /* synthetic */ d a;

        public b(d r1) {
            this.a = r1;
        }

        public final void a(com.bytedance.android.ec.hybrid.card.event.d r10) {
            Intrinsics.checkNotNullParameter(r10, "jsEvent");
            Lazy r0 = ECMallLogUtil.a;
            com.bytedance.android.ec.hybrid.log.mall.a.e r1 = com.bytedance.android.ec.hybrid.log.mall.a.e.b;
            ECMallLogUtil.c(r1, "refresh from lynx, refresh event get");
            if ((!Intrinsics.areEqual(r10.a, "mallRefreshFeedData")) == false) goto L5;
            return;
        L5:
            Map r11 = r10.b;
            Object r2 = null;
            if (r11 == null) goto L8;
            Object r12 = r11.get("id");
        L10:
            if ((r12 instanceof String) == false) goto L13;
            r2 = r12;
        L13:
            String r3 = (String) r2;
            if (r3 != null) goto L16;
        L19:
            boolean r4 = true;
        L20:
            if (r4 == false) goto L22;
        L23:
            this.a.a();
        L24:
            this.a.d = r3;
            com.bytedance.android.shopping.api.mall.c r5 = this.a.c;
            if (r5 == null) goto L31;
            d r6 = this.a;
            r6.a();
            ECMallFeed r7 = r6.h;
            if (r7.Q > 0) goto L31;
            r7.H(0, r5, false, null, null, null);
        L31:
            if (this.a.e == null) goto L34;
            ECMallLogUtil.c(r1, "refresh from lynx, retry by refresh");
            this.a.b(false);
            return;
        L34:
            return;
        L22:
            if ((true ^ Intrinsics.areEqual(r3, this.a.a)) == false) goto L24;
        L16:
            if (r3.length() == 0) goto L19;
            r4 = false;
            goto L20
        L8:
            r12 = null;
            goto L10
        }
    }

    public static final class c implements com.bytedance.android.ec.hybrid.card.event.e {
        public final /* synthetic */ d a;

        public static final class a implements Runnable {
            public final /* synthetic */ Map a;
            public final /* synthetic */ String b;
            public final /* synthetic */ c c;

            public a(Map r1, String r2, c r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                d r0 = this.c.a;     // Catch: Throwable -> L6
                Map r3 = this.a;     // Catch: Throwable -> L6
                String r1 = this.b;     // Catch: Throwable -> L6
                ECMallFeed r8 = r0.h;     // Catch: Throwable -> L6
                FavRefreshParams r9 = new FavRefreshParams(true, r3, false, null, new FavFeedUpdateHelp$startRequest$result$1(r0, r1), 12);     // Catch: Throwable -> L6
                int r2 = ECMallFeed.I1;     // Catch: Throwable -> L6
                if (r8.p(r9, null, null) == false) goto L9;
                this.c.a.e = null;     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        public c(d r1) {
            this.a = r1;
        }

        public final void a(com.bytedance.android.ec.hybrid.card.event.d r14) {
            Intrinsics.checkNotNullParameter(r14, "jsEvent");
            if ((!Intrinsics.areEqual(r14.a, "mallRequestFeedData")) == false) goto L5;
            return;
        L5:
            Lazy r0 = ECMallLogUtil.a;
            com.bytedance.android.ec.hybrid.log.mall.a.e r1 = com.bytedance.android.ec.hybrid.log.mall.a.e.b;
            ECMallLogUtil.c(r1, "refresh from lynx, request start");
            this.a.a();
            Map r15 = r14.b;
            if (r15 == null) goto L30;
            Object r2 = r15.get("id");
            if ((r2 instanceof String) == true) goto L10;
            r2 = null;
        L10:
            String r3 = (String) r2;
            if (r3 != null) goto L13;
            return;
        L13:
            Object r4 = r15.get("save_data_timeout");
            if ((r4 instanceof Long) == true) goto L16;
            r4 = null;
        L16:
            Long r5 = (Long) r4;
            if (r5 == null) goto L19;
            long r6 = r5.longValue();
            this.a.b = Long.valueOf(r6);
        L19:
            this.a.a = r3;
            Object r16 = r15.get("request_data");
            if (TypeIntrinsics.isMutableMap(r16) == true) goto L22;
            r16 = null;
        L22:
            Map r17 = (Map) r16;
            if (r17 == null) goto L25;
            r17.put("is_filter_exempt", 1);
        L25:
            if (r17 == null) goto L31;
            d r7 = this.a;
            ECMallFeed r8 = r7.h;
            FavRefreshParams r12 = new FavRefreshParams(true, r17, false, null, new FavFeedUpdateHelp$startRequest$result$1(r7, r3), 12);
            int r9 = ECMallFeed.I1;
            if (r8.p(r12, null, null) == true) goto L32;
            ECMallLogUtil.c(r1, "refresh from lynx, need retry request");
            this.a.e = new a(r17, r3, this);
            return;
        L32:
            return;
        L31:
            return;
        }
    }

    static {
    }

    public final void a() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        ECMallGulRefresh r0 = this.h.w();
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public final void b(boolean r3) {
        Lazy r0 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.a.e.b, "refresh from lynx, retry request");
        Runnable r1 = this.e;
        if (r1 == null) goto L5;
        r1.run();
    L5:
        if (r3 == false) goto L8;
        this.e = null;
        return;
    }

    public d(ECMallFeed r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "feed");
        Intrinsics.checkNotNullParameter(r4, "sceneId");
        this.h = r3;
        b r5 = new b(this);
        this.f = r5;
        c r0 = new c(this);
        this.g = r0;
        ECEventCenter.e("mallRequestFeedData", r0, r4);
        ECEventCenter.e("mallRefreshFeedData", r5, r4);
    }
}
