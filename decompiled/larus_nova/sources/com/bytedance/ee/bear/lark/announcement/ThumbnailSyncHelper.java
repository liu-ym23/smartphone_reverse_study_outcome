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

/* JADX INFO: loaded from: classes16.dex */
public final class ThumbnailSyncHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetService f227237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f227238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f227239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FlowableEmitter<String> f227240d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f227241e;

    public static class ThumbSyncResult extends Result {
        public ThumbSyncResult() {
        }
    }

    public class a implements FlowableOnSubscribe<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ThumbnailSyncHelper f227242a;

        public a(ThumbnailSyncHelper r100) {
            this.f227242a = r100;
        }

        @Override // io.reactivex.FlowableOnSubscribe
        public final void subscribe(FlowableEmitter<String> r100) throws Exception {
            this.f227242a.f227240d = r100;
        }
    }

    public class b implements NetService.c<ThumbSyncResult> {
        public b() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result parse(String r100) throws NetService.ParseException {
            return new ThumbSyncResult();
        }
    }

    public final String a() {
        return "https://" + s45.p.f540584u + "/space/file/f/cdp-" + this.f227241e + "-" + this.f227238b + "~noop/";
    }

    public final Flowable<String> b() {
        Disposable r100 = this.f227239c;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        Flowable<String> r101 = Flowable.create(new a(this), BackpressureStrategy.BUFFER);
        NetService.e r102 = new NetService.f("/space/api/thumbnail/sync/");
        HashMap r103 = new HashMap();
        r103.put("token", this.f227238b);
        r103.put("obj_type", sbb.e.g(this.f227241e) + "");
        r102.d(r103);
        r102.f216906c = 1;
        this.f227239c = this.f227237a.Vc(new b()).a(r102).subscribe(new u(this), new v(this));
        return r101;
    }

    public ThumbnailSyncHelper(BearUrl r100) {
        this.f227237a = (NetService) org.koin.java.a.a(NetService.class);
        String r101 = "";
        if (r100 != null) goto L5;
        String r102 = "";
    L6:
        this.f227241e = r102;
        if (r100 == null) goto L10;
        r101 = r100.f222561b;
    L10:
        this.f227238b = r101;
        return;
    L5:
        r102 = r100.f222560a;
        goto L6
    }
}
