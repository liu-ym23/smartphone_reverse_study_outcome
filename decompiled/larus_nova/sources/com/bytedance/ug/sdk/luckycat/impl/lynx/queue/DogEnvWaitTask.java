package com.bytedance.ug.sdk.luckycat.impl.lynx.queue;

import android.os.Handler;
import com.bytedance.ug.sdk.luckycat.api.depend.Dependency;
import com.bytedance.ug.sdk.luckycat.impl.manager.m;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes22.dex */
public final class DogEnvWaitTask extends a<c> implements hn7.b<zl7.i> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f271249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f271250d;

    @Override // com.bytedance.ug.sdk.luckycat.impl.lynx.queue.a
    public final String d() {
        return "dog";
    }

    @Override // com.bytedance.ug.sdk.luckycat.impl.lynx.queue.a
    public final boolean b() {
        if (hn7.d.b(zl7.i.class) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ug.sdk.luckycat.impl.lynx.queue.a
    public final void g() {
        e r100 = this.f271249c;
        if (r100 == null) goto L8;
        Handler r101 = r100.f271258b;
        if (r101 == null) goto L7;
        r101.removeCallbacksAndMessages(null);
    L7:
        r100.f271258b = null;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("WaitTaskProgress", "stop");
    L8:
        this.f271249c = null;
        hn7.d.c(this);
    }

    @Override // com.bytedance.ug.sdk.luckycat.impl.lynx.queue.a
    public final void e() {
        super.e();
        e r100 = this.f271249c;
        if (r100 == null) goto L8;
        Handler r101 = r100.f271258b;
        if (r101 == null) goto L7;
        r101.removeCallbacksAndMessages(null);
    L7:
        r100.f271258b = null;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("WaitTaskProgress", "stop");
    L8:
        this.f271249c = null;
    }

    public DogEnvWaitTask(long r100) {
        this.f271250d = r100;
    }

    @Override // hn7.b
    public final void a(hn7.a r100) {
        if (((zl7.i) r100) == null) goto L5;
        c("dog plugin is ready!!!");
        e();
        return;
    L5:
        c("ServiceChange, but service not found");
    }

    @Override // com.bytedance.ug.sdk.luckycat.impl.lynx.queue.a
    public final void f(c r100) {
        hn7.d.a(zl7.i.class, this);
        if (((zl7.i) hn7.d.b(zl7.i.class)) == null) goto L5;
        c("dog plugin is ready!!!");
        e();
        return;
    L5:
        e r101 = this.f271249c;
        if (r101 == null) goto L11;
        Handler r102 = r101.f271258b;
        if (r102 == null) goto L10;
        r102.removeCallbacksAndMessages(null);
    L10:
        r101.f271258b = null;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("WaitTaskProgress", "stop");
    L11:
        this.f271249c = null;
        m r103 = m.a.f271349a;
        Dependency r104 = Dependency.DOG;
        Map<Dependency, com.bytedance.ug.sdk.luckycat.api.depend.a> r105 = r103.f271347o;
        if (r105 == null) goto L16;
        com.bytedance.ug.sdk.luckycat.api.depend.a r106 = (com.bytedance.ug.sdk.luckycat.api.depend.a) ((ConcurrentHashMap) r105).get(r104);
        if (r106 == null) goto L16;
        r106.create();
    L16:
        e r107 = new e();
        r107.a(this.f271250d, new DogEnvWaitTask$start$$inlined$also$lambda$1(this));
        this.f271249c = r107;
        c("wait dog plugin ready...");
    }
}
