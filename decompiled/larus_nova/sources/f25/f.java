package f25;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.ec.slice.SliceInitService;
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

/* JADX INFO: loaded from: classes16.dex */
public final class f implements tb5.h<FetchModel> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static long f475149j = 2621440;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f475150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue<Call> f475151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f475152c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f475153d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.ee.bear.contract.j f475154e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f475155f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LiveData<ConnectionService.NetworkState> f475156g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f475157h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f475158i;

    public class a implements Observer<ConnectionService.NetworkState> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f475159a;

        public a(f r100) {
            this.f475159a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(ConnectionService.NetworkState r100) {
            this.f475159a.f475155f = r100.a();
            tt5.a.h(this.f475159a.f475150a, "==openDocs==fetch== newConnectionDetector  mIsConnected: " + this.f475159a.f475155f);
        }
    }

    public final void a() {
        tt5.a.h(this.f475150a, "==openDocs==fetch== cancelAll: ");
        Iterator<Call> r100 = this.f475151b.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().cancel();
        goto L4
    L6:
        this.f475151b.clear();
        this.f475152c.clear();
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final BridgeAuthType authType() {
        return BridgeAuthType.Private;
    }

    public f(Context r100) {
        this.f475150a = "FetchHandler";
        this.f475151b = new ConcurrentLinkedQueue();
        this.f475152c = new CompositeDisposable();
        this.f475155f = true;
        this.f475158i = new a(this);
        this.f475150a = "FetchHandlertrue";
        r100.getApplicationContext();
        com.bytedance.ee.bear.contract.j r101 = com.bytedance.ee.bear.contract.j.a.f217090a;
        this.f475154e = r101;
        this.f475156g = r101.a();
        com.bytedance.ee.util.ui.m.a(new d(this));
        this.f475153d = new i(r101);
        if (i.f475168d == null) goto L5;
        i.f475168d.getClass();
        t.d();
    L5:
        OfflineCacheConfig r102 = (OfflineCacheConfig) com.bytedance.ee.bear.appsetting.c.a.f206237a.c("offline_cache_config", OfflineCacheConfig.class, new OfflineCacheConfig());
        if (r102 == null) goto L9;
        f475149j = r102.getSingle_doc_max_length();
        return;
    }

    public final void c(Disposable[] r100) {
        Disposable r101 = r100[0];     // Catch: Exception -> L7
        if (r101 == null) goto L12;
        this.f475152c.remove(r101);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        tt5.a.d(this.f475150a, "==openDocs==fetch== tryRemoveDisposable error " + e.getMessage());
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final void handle(Object r100, final tb5.m r101) {
        final FetchModel r102 = (FetchModel) r100;
        if (r102 != null) goto L6;
        tt5.a.d(this.f475150a, "==openDocs==fetch== handle: fetchModel is null");
        return;
    L6:
        if (TextUtils.equals(r102.iframeJsbCheck, this.f475157h) == true) goto L8;
        iu5.d.a("IFAME_JSB_CHECK", new Throwable("url: " + r102.url + " local key: " + this.f475157h + " remote key: " + r102.iframeJsbCheck));
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
        d25.d.f(new OfflineResultModel(-18, "iframeJsbCheck vertification failed!", SliceInitService.DEFAULT_SWITCH), r101);
        return;
    L12:
        final Disposable[] r104 = new Disposable[1];
        if (this.f475155f == false) goto L15;
    L17:
        Flowable r105 = Flowable.create(new g(this, r102, new int[]{0}), BackpressureStrategy.BUFFER).retry(r102.retryCount, new e(this));
    L18:
        Disposable r106 = r105.subscribe(new f25.a(this, r102, r101, r104), new b(this, r101, r104));
        r104[0] = r106;
        this.f475152c.add(r106);
        return;
    L15:
        if (this.f475154e.getNetworkState().a() == true) goto L17;
        tt5.a.k(this.f475150a, "==openDocs==fetch== sendRequestIfNeed not connected ");
        r105 = Flowable.just(new OfflineResultModel(-1, "no_network", SliceInitService.DEFAULT_SWITCH));
        goto L18
    L8:
        r103 = false;
        goto L10
    }
}
