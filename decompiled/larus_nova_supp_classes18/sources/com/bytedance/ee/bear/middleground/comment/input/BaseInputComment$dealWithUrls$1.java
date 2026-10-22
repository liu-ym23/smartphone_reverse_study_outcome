package com.bytedance.ee.bear.middleground.comment.input;

import com.bytedance.ee.bear.at.MentionTitleResultList;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.docsdk.impl.utils.keyboard.producer.BaseKeyboardHeightProducer;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class BaseInputComment$dealWithUrls$1 implements Runnable {
    public final /* synthetic */ BaseInputComment a;
    public final /* synthetic */ List<String> b;

    public BaseInputComment$dealWithUrls$1(BaseInputComment r1, List<String> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        this.a.p0(true);
        com.bytedance.ee.util.ui.j.e(this.a.f0);
        com.bytedance.ee.util.ui.j.d(this.a.f0, BaseKeyboardHeightProducer.CONFIGURATION_CHANGED_WAIT_MAX_INTERVAL);
        final BaseInputComment r0 = this.a;
        b2 r1 = r0.X;
        List<String> r2 = this.b;
        Function3<List<? extends String>, List<? extends BearUrl>, MentionTitleResultList, Unit> r3 = new AnonymousClass1(r0);
        final BaseInputComment r4 = this.a;
        r1.i(r2, r3, new AnonymousClass2(r4));
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
