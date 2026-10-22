package l65;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j implements Runnable {
    public final /* synthetic */ i a;
    public final /* synthetic */ boolean b;

    public final void a() {
        i r0 = this.a;
        if (r0.k == false) goto L7;
        tt5.a.h("vc_follow_module", "dynamicRegisterDelayFollowableContent isOnDetach, cancel dynamic register");
        return;
    L7:
        if (this.b == true) goto L16;
        f r1 = r0.g;
        r1.getClass();
        StringBuilder r2 = new StringBuilder("delayRegisterFollowableContent -> isAttachmentBizType=");
        int r3 = com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.a;
        r2.append(com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.C0037a.a(r1.b));
        tt5.a.h("CCMFollow_DriveFollowableContentManager", r2.toString());
        if (com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.C0037a.a(r1.b) == false) goto L30;
        py4.i r4 = r1.a.f;
        if (r4 != null) goto L14;
        return;
    L14:
        if (r1.e != null) goto L26;
        e r5 = new e("BoxPreview", r1.c);
        r1.e = r5;
        List<e> r6 = r1.d;
        Intrinsics.checkNotNull(r5);
        ((CopyOnWriteArrayList) r6).add(r5);
        r4.b(r1.e);
        return;
    L26:
        return;
    L30:
        return;
    L16:
        f r7 = r0.g;
        r7.getClass();
        StringBuilder r8 = new StringBuilder("delayUnregisterFollowableContent -> isAttachmentBizType=");
        int r9 = com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.a;
        r8.append(com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.C0037a.a(r7.b));
        tt5.a.h("CCMFollow_DriveFollowableContentManager", r8.toString());
        if (com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.C0037a.a(r7.b) == false) goto L31;
        py4.i r10 = r7.a.f;
        if (r10 == null) goto L28;
        e r11 = r7.e;
        if (r11 == null) goto L29;
        r11.onDetach();
        r10.d(r7.e);
        List<e> r12 = r7.d;
        e r13 = r7.e;
        TypeIntrinsics.asMutableCollection(r12).remove(r13);
        r7.e = null;
        return;
    L29:
        return;
    L28:
        return;
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

    public j(i r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}
