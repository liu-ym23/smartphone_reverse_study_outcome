package com.bytedance.ee.bear.middleground.like;

import android.util.ArrayMap;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.middleground.like.executor.AddLikeExecutor;
import com.bytedance.ee.bear.middleground.like.executor.ClearLikeExecutor;
import com.bytedance.ee.bear.rn.RnPushProtocol;
import com.bytedance.ee.bear.route.PostCard;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements hg5.b {
    public final ArrayMap<String, Push> a;
    public final com.bytedance.ee.bear.middleground.like.executor.g b;
    public final ClearLikeExecutor c;
    public final AddLikeExecutor d;
    public final com.bytedance.ee.bear.middleground.like.executor.i e;

    @Override // hg5.b
    public final void clearCallback() {
        this.d.a = null;
        this.c.a = null;
        this.b.a = null;
    }

    public a() {
        this.a = new ArrayMap(2);
        NetService r0 = (NetService) org.koin.java.a.a(NetService.class);
        this.d = new AddLikeExecutor(r0);
        this.c = new ClearLikeExecutor(r0);
        this.b = new com.bytedance.ee.bear.middleground.like.executor.g(r0);
        this.e = new com.bytedance.ee.bear.middleground.like.executor.i(r0);
    }

    @Override // hg5.b
    public final void a(String r2) {
        Push r0 = this.a.get(r2);     // Catch: Exception -> L7
        if (r0 == null) goto L5;
        ((RnPushProtocol) r0.d.getValue()).a();     // Catch: Exception -> L7
    L5:
        this.a.remove(r2);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        tt5.a.j("DefaultLikeManager", e);
    }

    @Override // hg5.b
    public final Flowable b(final String r6) {
        com.bytedance.ee.bear.middleground.like.executor.i r0 = this.e;
        r0.getClass();
        NetService.f r1 = new NetService.f("api/like/data/");
        r0.b = r1;
        ((NetService.e) r1).c = 2;
        r1.b(ResourceData.KEY_TOKEN, r6);
        r0.b.b("refer_type", String.valueOf(6));
        r0.b.b("last_like_id", "0");
        r0.b.b("page_size", String.valueOf(2));
        NetService.d r2 = r0.a.Vc(new com.bytedance.ee.bear.middleground.like.executor.i.a());
        r0.getClass();
        return r2.a(r0.b).onErrorResumeNext(new com.bytedance.ee.bear.middleground.like.executor.h(r6));
    }

    @Override // hg5.b
    public final int d(sbb.e r3) {
        if (sbb.e.g != r3) goto L6;
        return 1;
    L6:
        if (sbb.e.h != r3) goto L10;
        return 2;
    L10:
        if (sbb.e.i != r3) goto L14;
        return 4;
    L14:
        if (sbb.e.l != r3) goto L17;
        return 5;
    L17:
        return 1;
    }

    @Override // hg5.b
    public final void g(String r3) {
        PostCard r0 = ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).w2("/doc/like/activity");
        int r1 = LikeListActivity.n;
        r0.i("doc_token", r3).j("ref_type", 6).i("from", null).e();
    }

    @Override // hg5.b
    public final Disposable c(final String r5, f55.k r6) {
        final com.bytedance.ee.bear.middleground.like.executor.g r0 = this.b;
        r0.getClass();
        NetService.f r1 = new NetService.f("api/like/count/");
        r0.b = r1;
        ((NetService.e) r1).c = 2;
        r1.b(ResourceData.KEY_TOKEN, r5);
        r0.b.b("refer_type", String.valueOf(6));
        r0.a = r6;
        NetService.d r7 = r0.c.Vc(new com.bytedance.ee.bear.middleground.like.executor.g.a());
        r0.getClass();
        return r7.a(r0.b).subscribe(new com.bytedance.ee.bear.middleground.like.executor.e(r0), new com.bytedance.ee.bear.middleground.like.executor.f(r0, r5));
    }

    @Override // hg5.b
    public final Disposable f(String r5, f55.h r6) {
        ClearLikeExecutor r0 = this.c;
        r0.getClass();
        HashMap r1 = new HashMap();
        r1.put(ResourceData.KEY_TOKEN, r5);
        r1.put("refer_type", Integer.toString(6));
        NetService.f r2 = new NetService.f("api/like/dislike/");
        r0.b = r2;
        r2.d(r1);
        ((NetService.e) r0.b).c = 1;
        r0.a = r6;
        NetService.d r7 = r0.c.Vc(new ClearLikeExecutor.a());
        r0.getClass();
        return r7.a(r0.b).subscribe(new com.bytedance.ee.bear.middleground.like.executor.c(r0), new com.bytedance.ee.bear.middleground.like.executor.d(r0, r5));
    }

    @Override // hg5.b
    public final Disposable h(String r5, f55.j r6) {
        AddLikeExecutor r0 = this.d;
        r0.getClass();
        HashMap r1 = new HashMap();
        r1.put(ResourceData.KEY_TOKEN, r5);
        r1.put("refer_type", Integer.toString(6));
        NetService.f r2 = new NetService.f("api/like/like/");
        r0.b = r2;
        r2.d(r1);
        ((NetService.e) r0.b).c = 1;
        r0.a = r6;
        NetService.d r7 = r0.c.Vc(new AddLikeExecutor.a());
        r0.getClass();
        return r7.a(r0.b).subscribe(new com.bytedance.ee.bear.middleground.like.executor.a(r0), new com.bytedance.ee.bear.middleground.like.executor.b(r0, r5));
    }

    @Override // hg5.b
    public final String e(int r2, String r3, int r4, f55.d r5) {
        Intrinsics.checkNotNullParameter(r3, "docToken");     // Catch: Exception -> L4
        Push r0 = new Push(r3, r4, r2);     // Catch: Exception -> L4
        Intrinsics.checkNotNullParameter(r5, "observer");     // Catch: Exception -> L4
        ((RnPushProtocol) r0.d.getValue()).b(new x(r5));     // Catch: Exception -> L4
        String r6 = String.valueOf(r0.hashCode());     // Catch: Exception -> L4
        this.a.put(r6, r0);     // Catch: Exception -> L4
        return r6;
    L4:
        e = move-exception;
        tt5.a.j("DefaultLikeManager", e);
        return null;
    }
}
