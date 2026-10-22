package com.bytedance.ee.bear.connection;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.connection.rust.NetStateChangeRustManager;
import fw4.d;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class NetworkDetector extends LiveData<NetworkType> {
    public static final /* synthetic */ int d = 0;
    public final Context a;
    public Disposable b;
    public final a c;

    public class a implements fw4.b {
        public final /* synthetic */ NetworkDetector a;

        @Override // fw4.b
        public final void a() {
            tt5.a.b("NetworkDetector", "network is disconnected.");
            NetworkDetector r0 = this.a;
            NetworkType r1 = NetworkType.NETWORK_NO;
            int r2 = NetworkDetector.d;
            r0.postValue(r1);
        }

        public a(NetworkDetector r1) {
            this.a = r1;
        }

        @Override // fw4.b
        public final void b(NetworkType r3) {
            StringBuilder r0 = new StringBuilder("network is connected. netWorkType =");
            if (r3 != null) goto L5;
            String r1 = null;
        L6:
            r0.append(r1);
            tt5.a.b("NetworkDetector", r0.toString());
            NetworkDetector r2 = this.a;
            int r4 = NetworkDetector.d;
            r2.postValue(r3);
            return;
        L5:
            r1 = r3.name();
            goto L6
        }
    }

    public class b implements Consumer<Boolean> {
        public final /* synthetic */ NetworkDetector a;

        public b(NetworkDetector r1) {
            this.a = r1;
        }

        public final void accept(Object r2) throws Exception {
            Boolean r3 = (Boolean) r2;
            NetworkDetector r4 = this.a;
            r4.postValue(d.b(r4.a));
        }
    }

    public class c implements Consumer<Throwable> {
        public c() {
        }

        public final void accept(Object r3) throws Exception {
            tt5.a.f("NetworkDetector", (Throwable) r3, false);
        }
    }

    public final void onActive() {
        super.onActive();
        this.b = Flowable.just(Boolean.TRUE).observeOn(fo5.d.e()).subscribe(new b(this), new c());
        tt5.a.b("NetworkDetector", "register observer in active state.");
        a r0 = this.c;
        int r1 = fw4.c.a;
        NetStateChangeRustManager r2 = NetStateChangeRustManager.e;
        r2.getClass();
        tt5.a.b("BaseNetStateChangeService", "registerObserver()... observer =" + r0);
        if (r0 == null) goto L6;
        ((ConcurrentHashMap) r2.a).put(r0, fw4.a.d);
        return;
    }

    public final void onInactive() {
        super.onInactive();
        Disposable r0 = this.b;
        if (r0 != null) goto L5;
    L7:
        tt5.a.b("NetworkDetector", "unregister observer in inactive state.");
        a r1 = this.c;
        int r2 = fw4.c.a;
        NetStateChangeRustManager r3 = NetStateChangeRustManager.e;
        r3.getClass();
        tt5.a.b("BaseNetStateChangeService", "unregisterObserver()... observer = " + r1);
        if (r1 == null) goto L11;
        ((ConcurrentHashMap) r3.a).remove(r1);
        return;
    L11:
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        this.b.dispose();
        goto L7
    }

    public NetworkDetector(Context r2) {
        this.c = new a(this);
        this.a = r2.getApplicationContext();
    }
}
