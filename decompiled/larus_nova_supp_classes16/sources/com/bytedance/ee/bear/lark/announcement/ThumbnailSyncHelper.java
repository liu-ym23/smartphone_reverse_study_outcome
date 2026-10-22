package com.bytedance.ee.bear.lark.announcement;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.domain.BearUrl;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class ThumbnailSyncHelper {
    public final NetService a;
    public final String b;
    public Disposable c;
    public FlowableEmitter<String> d;
    public final String e;

    public static class ThumbSyncResult extends Result {
        public ThumbSyncResult() {
        }
    }

    public class a implements FlowableOnSubscribe<String> {
        public final /* synthetic */ ThumbnailSyncHelper a;

        public a(ThumbnailSyncHelper r1) {
            this.a = r1;
        }

        public final void subscribe(FlowableEmitter<String> r2) throws Exception {
            this.a.d = r2;
        }
    }

    public class b implements NetService.c<ThumbSyncResult> {
        public b() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result parse(String r1) throws NetService.ParseException {
            return new ThumbSyncResult();
        }
    }

    public final String a() {
        return "https://" + s45.p.u + "/space/file/f/cdp-" + this.e + "-" + this.b + "~noop/";
    }

    public final Flowable<String> b() {
        Disposable r0 = this.c;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Flowable<String> r1 = Flowable.create(new a(this), BackpressureStrategy.BUFFER);
        NetService.e r2 = new NetService.f("/space/api/thumbnail/sync/");
        HashMap r3 = new HashMap();
        r3.put("token", this.b);
        r3.put("obj_type", sbb.e.g(this.e) + "");
        r2.d(r3);
        r2.c = 1;
        this.c = this.a.Vc(new b()).a(r2).subscribe(new u(this), new v(this));
        return r1;
    }

    public ThumbnailSyncHelper(BearUrl r3) {
        this.a = (NetService) org.koin.java.a.a(NetService.class);
        String r0 = "";
        if (r3 != null) goto L5;
        String r1 = "";
    L6:
        this.e = r1;
        if (r3 == null) goto L10;
        r0 = r3.b;
    L10:
        this.b = r0;
        return;
    L5:
        r1 = r3.a;
        goto L6
    }
}
