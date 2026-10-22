package com.bytedance.ee.bear.operation;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.lynx.api.CCMLynxPageRouter;
import com.bytedance.ee.bear.more.pageview2.PageViewFragment;
import com.bytedance.ee.bear.operation.api.event.OperationEvent;
import com.bytedance.ee.docsdk.impl.utils.keyboard.producer.BaseKeyboardHeightProducer;
import com.bytedance.ee.util.ui.m;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import dl5.g;
import gl5.h;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements zk5.b {
    public static final AtomicBoolean c = null;
    public final ReentrantLock a;
    public final com.bytedance.ee.bear.operation.check.a b;

    static {
        c = new AtomicBoolean(false);
    }

    @Override // zk5.b
    public final void checkAndInit() {
        AtomicBoolean r1 = c;
        if (r1.get() == false) goto L17;
        return;
    L17:
        this.a.lock();     // Catch: Throwable -> L11
        if (r1.get() == false) goto L9;
    L7:
        this.a.unlock();
        return;
    L9:
        tt5.a.h("OperationManager", "native upload task init");     // Catch: Throwable -> L11
        gl5.b.a().a = true;     // Catch: Throwable -> L11
        m.a(new c());     // Catch: Throwable -> L11
        ((h0) org.koin.java.a.a(h0.class)).Pe(new e());     // Catch: Throwable -> L11
        r1.compareAndSet(false, true);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        iu5.d.a("OperationManager", th);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        this.a.unlock();
        throw th;
    }

    public f() {
        this.a = new ReentrantLock();
        this.b = new com.bytedance.ee.bear.operation.check.a((NetService) org.koin.java.a.a(NetService.class));
    }

    @Override // zk5.b
    public final void c(OperationEvent r4) {
        tt5.a.h("OperationManager", "record operation event");
        final g r0 = g.b();
        dl5.a r1 = new dl5.a();
        r1.d = r4.a;
        r1.b = r4.b;
        r1.c = r4.c;
        r1.e = r4.e;
        r1.f = r4.d;
        r1.g = r4.f;
        r1.h = r4.g;
        r1.i = UUID.randomUUID().toString();
        r0.getClass();
        Disposable r5 = Flowable.just(r1).observeOn(fo5.d.b()).subscribe(new dl5.e(r0), new dl5.f());
        r0.a.add(r5);
        if (c.get() == false) goto L5;
        gl5.b.a().b(new h(), BaseKeyboardHeightProducer.CONFIGURATION_CHANGED_WAIT_MAX_INTERVAL);
        return;
    L5:
        checkAndInit();
    }

    @Override // zk5.b
    public final Flowable<al5.a> a(String r3, int r4) {
        if (TextUtils.isEmpty(r3) == true) goto L5;
        final com.bytedance.ee.bear.operation.check.a r0 = this.b;
        r0.getClass();
        return Flowable.just(new al5.a(r3, r4)).flatMap(new cl5.a(r0)).flatMap(new cl5.b(r0));
    L5:
        return Flowable.just(new al5.a(r3, r4, 0));
    }

    @Override // zk5.b
    public final void b(Context r9, PageViewFragment r10, HashMap r11) {
        tt5.a.h("OperationManager", "launchOperationListActivity, context: " + r9 + ", params: ");
        if (r9 != null) goto L5;
        return;
    L5:
        if (r11 != null) goto L7;
        r11 = new HashMap();
    L7:
        HashMap r2 = r11;
        r2.put("isOfficeSdk", Boolean.valueOf(LarkAppContext.inst().buildConfig().isOfficeSDK()));
        ((CCMLynxPageRouter) org.koin.java.a.a(CCMLynxPageRouter.class)).c(r9, CCMLynxPageRouter.PageType.DOC_OPERATION_HIST, new de5.a(null, r2, null, null, null, r10, true));
    }
}
