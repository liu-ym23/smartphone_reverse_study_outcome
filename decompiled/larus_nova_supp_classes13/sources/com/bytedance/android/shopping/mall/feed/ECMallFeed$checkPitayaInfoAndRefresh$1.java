package com.bytedance.android.shopping.mall.feed;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallFeed$checkPitayaInfoAndRefresh$1 implements Runnable {
    public final /* synthetic */ ECMallFeed a;
    public final /* synthetic */ JSONObject b;
    public final /* synthetic */ String c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ com.bytedance.android.shopping.mall.opt.g e;
    public final /* synthetic */ Function0 f;

    public ECMallFeed$checkPitayaInfoAndRefresh$1(ECMallFeed r1, JSONObject r2, String r3, boolean r4, com.bytedance.android.shopping.mall.opt.g r5, Function0 r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r0 = com.bytedance.android.shopping.mall.homepage.tools.u.a;     // Catch: Throwable -> L4
        final boolean r1 = com.bytedance.android.shopping.mall.homepage.tools.u.a(this.a.A1.getPageInfo());     // Catch: Throwable -> L4
        ECMallFeed.g0(this.a, new AnonymousClass1(this, r1));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
