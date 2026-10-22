package l65;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f507730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f507731b;

    public final void a() {
        i r100 = this.f507730a;
        if (r100.f507729k == false) goto L7;
        tt5.a.h("vc_follow_module", "dynamicRegisterDelayFollowableContent isOnDetach, cancel dynamic register");
        return;
    L7:
        if (this.f507731b == true) goto L16;
        f r101 = r100.f507725g;
        r101.getClass();
        StringBuilder r102 = new StringBuilder("delayRegisterFollowableContent -> isAttachmentBizType=");
        int r103 = com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.f217038a;
        r102.append(com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.C3093a.a(r101.f507709b));
        tt5.a.h("CCMFollow_DriveFollowableContentManager", r102.toString());
        if (com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.C3093a.a(r101.f507709b) == false) goto L30;
        py4.i r104 = r101.f507708a.f507724f;
        if (r104 != null) goto L14;
        return;
    L14:
        if (r101.f507712e != null) goto L26;
        e r105 = new e("BoxPreview", r101.f507710c);
        r101.f507712e = r105;
        List<e> r106 = r101.f507711d;
        Intrinsics.checkNotNull(r105);
        ((CopyOnWriteArrayList) r106).add(r105);
        r104.b(r101.f507712e);
        return;
    L26:
        return;
    L30:
        return;
    L16:
        f r107 = r100.f507725g;
        r107.getClass();
        StringBuilder r108 = new StringBuilder("delayUnregisterFollowableContent -> isAttachmentBizType=");
        int r109 = com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.f217038a;
        r108.append(com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.C3093a.a(r107.f507709b));
        tt5.a.h("CCMFollow_DriveFollowableContentManager", r108.toString());
        if (com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.C3093a.a(r107.f507709b) == false) goto L31;
        py4.i r110 = r107.f507708a.f507724f;
        if (r110 == null) goto L28;
        e r111 = r107.f507712e;
        if (r111 == null) goto L29;
        r111.onDetach();
        r110.d(r107.f507712e);
        List<e> r112 = r107.f507711d;
        e r113 = r107.f507712e;
        TypeIntrinsics.asMutableCollection(r112).remove(r113);
        r107.f507712e = null;
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

    public j(i r100, boolean r101) {
        this.f507730a = r100;
        this.f507731b = r101;
    }
}
