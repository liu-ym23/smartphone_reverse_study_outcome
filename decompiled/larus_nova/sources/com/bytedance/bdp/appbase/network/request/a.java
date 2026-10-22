package com.bytedance.bdp.appbase.network.request;

import android.content.Context;
import com.bytedance.bdp.appbase.network.BdpNetRequest;
import com.bytedance.bdp.appbase.network.BdpNetResponse;
import com.bytedance.bdp.appbase.network.BdpNetworkManager;
import com.bytedance.bdp.appbase.network.IBdpNetCall;
import g94.b;
import gb4.c;
import gb4.d;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f200907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IBdpNetCall f200908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f200909c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f200910d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BdpNetRequest f200911e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BdpRequestCallback f200912f;

    /* JADX INFO: renamed from: com.bytedance.bdp.appbase.network.request.a$a, reason: collision with other inner class name */
    public static final class C2898a {
    }

    static {
    }

    public final void a() {
        b.d("BdpRequestTask", new Object[]{"execute", this.f200911e});
        BdpRequestCallback r100 = this.f200912f;
        if (r100 == null) goto L6;
        r100.onStart(this.f200909c);
    L6:
        if (this.f200907a.compareAndSet(1, 2) == true) goto L18;
        b.d("BdpRequestTask", new Object[]{"failed", -201, "task is finished", this.f200907a});
        if (this.f200907a.compareAndSet(2, 3) == false) goto L13;
        BdpNetResponse r101 = new BdpNetResponse(-201, "task is finished", this.f200911e.getUrl(), c.f480683b, null, new Exception("task is finished"), this.f200911e.getRequestLibType(), new d(), MapsKt.emptyMap());
        BdpRequestCallback r102 = this.f200912f;
        if (r102 == null) goto L29;
        r102.onFinish(this.f200909c, this.f200911e, r101);
        return;
    L29:
        return;
    L13:
        if (this.f200907a.get() != 4) goto L31;
        BdpRequestCallback r103 = this.f200912f;
        if (r103 == null) goto L32;
        r103.onCancel(this.f200909c, this.f200911e);
        return;
    L32:
        return;
    L31:
        return;
    L18:
        IBdpNetCall r104 = BdpNetworkManager.Companion.with(this.f200910d).newCall(this.f200911e);
        this.f200908b = r104;
        BdpNetResponse r105 = r104.execute();
        b.d("BdpRequestTask", new Object[]{"success", r105, this.f200907a});
        if (this.f200907a.compareAndSet(2, 3) == false) goto L24;
        BdpRequestCallback r106 = this.f200912f;
        if (r106 == null) goto L33;
        r106.onFinish(this.f200909c, this.f200911e, r105);
        return;
    L33:
        return;
    L24:
        if (this.f200907a.get() != 4) goto L35;
        BdpRequestCallback r107 = this.f200912f;
        if (r107 == null) goto L36;
        r107.onCancel(this.f200909c, this.f200911e);
        return;
    L36:
        return;
    }

    public a(int r100, Context r101, BdpNetRequest r102, BdpRequestCallback r103) {
        this.f200909c = r100;
        this.f200910d = r101;
        this.f200911e = r102;
        this.f200912f = r103;
        this.f200907a = new AtomicInteger(1);
    }
}
