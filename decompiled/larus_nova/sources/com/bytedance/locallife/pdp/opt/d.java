package com.bytedance.locallife.pdp.opt;

import android.app.Activity;
import android.os.MessageQueue;
import com.bytedance.locallife.pdp.container.impl.n;
import com.bytedance.locallife.pdp.container.view.lynx.k;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class d implements MessageQueue.IdleHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WeakReference<Activity> f261621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f261622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k f261623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ List<String> f261624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ List<n> f261625e;

    public d(WeakReference<Activity> r100, String r101, k r102, List<String> r103, List<n> r104) {
        this.f261621a = r100;
        this.f261622b = r101;
        this.f261623c = r102;
        this.f261624d = r103;
        this.f261625e = r104;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        Activity r100 = this.f261621a.get();
        if (r100 != null) goto L5;
        return false;
    L5:
        r100.toString();
        GoodsDetailOptManager r101 = GoodsDetailOptManager.f261609a;
        GoodsDetailOptManager.j(r100, this.f261622b, this.f261623c, this.f261624d, this.f261625e);
        return false;
    }
}
