package f25;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.offline.OfflineCacheConfig;
import com.bytedance.ee.bear.document.offline.base.FetchModel;
import com.bytedance.ee.bear.document.offline.base.OfflineResultModel;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import okhttp3.Call;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f implements tb5.h<FetchModel> {
    public static long j = 2621440;
    public final String a;
    public final ConcurrentLinkedQueue<Call> b;
    public final CompositeDisposable c;
    public final i d;
    public final com.bytedance.ee.bear.contract.j e;
    public boolean f;
    public final LiveData<ConnectionService.NetworkState> g;
    public String h;
    public final a i;

    public class a implements Observer<ConnectionService.NetworkState> {
        public final /* synthetic */ f a;

        public a(f r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            this.a.f = ((ConnectionService.NetworkState) r3).a();
            tt5.a.h(this.a.a, "==openDocs==fetch== newConnectionDetector  mIsConnected: " + this.a.f);
        }
    }

    public final void a() {
        tt5.a.h(this.a, "==openDocs==fetch== cancelAll: ");
        Iterator<Call> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().cancel();
        goto L4
    L6:
        this.b.clear();
        this.c.clear();
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final BridgeAuthType authType() {
        return BridgeAuthType.Private;
    }

    public f(Context r4) {
        this.a = "FetchHandler";
        this.b = new ConcurrentLinkedQueue();
        this.c = new CompositeDisposable();
        this.f = true;
        this.i = new a(this);
        this.a = "FetchHandlertrue";
        r4.getApplicationContext();
        com.bytedance.ee.bear.contract.j r5 = com.bytedance.ee.bear.contract.j.a.a;
        this.e = r5;
        this.g = r5.a();
        com.bytedance.ee.util.ui.m.a(new d(this));
        this.d = new i(r5);
        if (i.d == null) goto L5;
        i.d.getClass();
        t.d();
    L5:
        OfflineCacheConfig r6 = (OfflineCacheConfig) com.bytedance.ee.bear.appsetting.c.a.a.c("offline_cache_config", OfflineCacheConfig.class, new OfflineCacheConfig());
        if (r6 == null) goto L9;
        j = r6.getSingle_doc_max_length();
        return;
    }

    public final void c(Disposable[] r4) {
        Disposable r5 = r4[0];     // Catch: Exception -> L7
        if (r5 == null) goto L12;
        this.c.remove(r5);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        tt5.a.d(this.a, "==openDocs==fetch== tryRemoveDisposable error " + e.getMessage());
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final void handle(Object r7, final tb5.m r8) {
        final FetchModel r9 = (FetchModel) r7;
        if (r9 != null) goto L6;
        tt5.a.d(this.a, "==openDocs==fetch== handle: fetchModel is null");
        return;
    L6:
        if (TextUtils.equals(r9.iframeJsbCheck, this.h) == true) goto L8;
        iu5.d.a("IFAME_JSB_CHECK", new Throwable("url: " + r9.url + " local key: " + this.h + " remote key: " + r9.iframeJsbCheck));
        boolean r0 = true;
    L10:
        if (r0 == false) goto L12;
        d25.d.f(new OfflineResultModel(-18, "iframeJsbCheck vertification failed!", "{}"), r8);
        return;
    L12:
        final Disposable[] r1 = new Disposable[1];
        if (this.f == false) goto L15;
    L17:
        Flowable r2 = Flowable.create(new g(this, r9, new int[]{0}), BackpressureStrategy.BUFFER).retry(r9.retryCount, new e(this));
    L18:
        Disposable r10 = r2.subscribe(new f25.a(this, r9, r8, r1), new b(this, r8, r1));
        r1[0] = r10;
        this.c.add(r10);
        return;
    L15:
        if (this.e.getNetworkState().a() == true) goto L17;
        tt5.a.k(this.a, "==openDocs==fetch== sendRequestIfNeed not connected ");
        r2 = Flowable.just(new OfflineResultModel(-1, "no_network", "{}"));
        goto L18
    L8:
        r0 = false;
        goto L10
    }
}
