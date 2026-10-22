package com.bytedance.ee.bear.office.common.upload;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class OfficeUploadUiHost implements i0 {
    public final ViewGroup a;
    public final LifecycleOwner b;
    public final List<OfficeUploadRecoveryTarget> c;
    public final View d;
    public Function0<Unit> e;
    public Lambda f;
    public final OfficeUploadUiController g;
    public final g h;
    public List<u> i;
    public final OfficeUploadUiHost$lifecycleObserver$1 j;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.office.common.upload.i0
    public final void b() {
        StringBuilder r0 = new StringBuilder("office_upload_recovery_trace banner_close currentTasks=");
        Handler r1 = OfficeUploadStore.a;
        LinkedHashMap<String, h0> r2 = OfficeUploadStore.c;
        r0.append(CollectionsKt.toList(r2.values()).size());
        tt5.a.h("OfficeUploadUiHost", r0.toString());
        List r3 = CollectionsKt.toList(r2.values());
        ArrayList r4 = new ArrayList();
        Iterator r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L14;
        Object r6 = r5.next();
        OfficeUploadStatus r7 = ((h0) r6).k;
        if (r7 != OfficeUploadStatus.FINISH) goto L8;
    L11:
        boolean r8 = true;
    L12:
        if (r8 == false) goto L4;
        r4.add(r6);
        goto L4
    L8:
        if (r7 == OfficeUploadStatus.FAILED) goto L11;
        r8 = false;
        goto L12
    L14:
        Iterator r9 = r4.iterator();
    L16:
        if (r9.hasNext() == false) goto L18;
        h0 r10 = (h0) r9.next();
        k.a.getClass();
        Intrinsics.checkNotNullParameter(r10, "task");
        k.b.execute(new l(r10));
        goto L16
    }

    public final void e() {
        if (this.e == null) goto L6;
        tt5.a.h("OfficeUploadUiHost", "office_upload_recovery_trace host_attach_skip reason=already_attached targets=" + g(this.c));
        return;
    L6:
        tt5.a.h("OfficeUploadUiHost", "office_upload_recovery_trace host_attach_start hasHost=" + this.a.isAttachedToWindow() + " lifecycle=" + this.b.getLifecycle().getCurrentState() + " targets=" + g(this.c));
        this.b.getLifecycle().addObserver(this.j);
        OfficeUploadUiController.a(this.g);
        OfficeUploadRecoveryCoordinator r0 = OfficeUploadRecoveryCoordinator.a;
        List<OfficeUploadRecoveryTarget> r1 = this.c;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "targets");
        tt5.a.h("OfficeUploadRecovery", "office_upload_recovery_trace coordinator_attach targets=" + CollectionsKt.joinToString$default(r1, null, "[", "]", 0, null, OfficeUploadRecoveryCoordinator$toTraceString$1.INSTANCE, 25, null));
        if (r1.isEmpty() == false) goto L9;
        tt5.a.k("OfficeUploadRecovery", "office_upload_recovery_trace coordinator_attach_skip reason=empty_targets");
        Lambda r2 = OfficeUploadRecoveryCoordinator$attach$1.INSTANCE;
    L14:
        this.f = r2;
        Handler r3 = OfficeUploadStore.a;
        final Function1<List<? extends u>, Unit> r4 = new OfficeUploadUiHost$attach$1(this);
        Intrinsics.checkNotNullParameter(r4, "listener");
        OfficeUploadStore.e(new OfficeUploadStore$subscribe$1(r4));
        this.e = new OfficeUploadStore$subscribe$2(r4);
        return;
    L9:
        List<OfficeUploadRecoveryTarget> r5 = r1;
        final ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r7 = r5.iterator();
    L11:
        if (r7.hasNext() == false) goto L13;
        OfficeUploadRecoveryTarget r8 = (OfficeUploadRecoveryTarget) r7.next();
        OfficeUploadRecoveryCoordinator.a.getClass();
        r6.add(OfficeUploadRecoveryCoordinator.d(r8));
        goto L11
    L13:
        OfficeUploadRecoveryCoordinator.b.execute(new b0(r1));
        r2 = new OfficeUploadRecoveryCoordinator$attach$3(r6);
        goto L14
    }

    public final void f() {
        tt5.a.h("OfficeUploadUiHost", "office_upload_recovery_trace host_detach targets=" + g(this.c));
        Function0<Unit> r0 = this.e;
        if (r0 == null) goto L5;
        r0.invoke();
    L5:
        ViewGroup r1 = null;
        this.e = null;
        Lambda r2 = this.f;
        if (r2 == null) goto L8;
        r2.invoke();
    L8:
        this.f = null;
        this.b.getLifecycle().removeObserver(this.j);
        g r3 = this.h;
        if (r3 == null) goto L11;
        r3.a(0);
    L11:
        OfficeUploadUiController r4 = this.g;
        r4.e.setVisibility(8);
        ViewParent r5 = r4.e.getParent();
        if ((r5 instanceof ViewGroup) == false) goto L14;
        ViewGroup r6 = (ViewGroup) r5;
    L15:
        if (r6 == null) goto L17;
        r6.removeView(r4.e);
    L17:
        ViewParent r7 = r4.d.getParent();
        if ((r7 instanceof ViewGroup) == false) goto L20;
        r1 = (ViewGroup) r7;
    L20:
        if (r1 == null) goto L23;
        r1.removeView(r4.d);
        return;
    L23:
        return;
    L14:
        r6 = null;
        goto L15
    }

    public static final void d(OfficeUploadUiHost r5) {
        g r0 = r5.h;
        if (r0 == null) goto L28;
        d r1 = r5.g.d;
        boolean r3 = true;
        if (r1.getVisibility() != 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L10;
    L12:
        r3 = false;
    L13:
        Intrinsics.checkNotNullParameter(r1, "bannerView");
        if (r3 == true) goto L16;
        r0.a(0);
        return;
    L16:
        int r6 = r1.getHeight();
        if (r6 <= 0) goto L20;
        r0.a(r6 + r0.b);
        return;
    L20:
        if (r1.isLaidOut() == true) goto L22;
    L26:
        r1.addOnLayoutChangeListener(new f(r0));
        return;
    L22:
        if (r1.isLayoutRequested() == true) goto L26;
        if (r1.getHeight() <= 0) goto L31;
        r0.a(r1.getHeight() + r0.b);
        return;
    L31:
        return;
    L10:
        if ((!r5.i.isEmpty()) == false) goto L12;
    L7:
        r2 = false;
        goto L8
    }

    public static String g(List r9) {
        return CollectionsKt.joinToString$default(r9, null, "[", "]", 0, null, OfficeUploadUiHost$toTraceString$1.INSTANCE, 25, null);
    }

    @Override // com.bytedance.ee.bear.office.common.upload.i0
    public final void a(u r3) {
        Intrinsics.checkNotNullParameter(r3, "item");
        tt5.a.h("OfficeUploadUiHost", "office_upload_recovery_trace item_remove itemId=" + r3.a.hashCode() + " status=" + r3.d);
        Handler r0 = OfficeUploadStore.a;
        String r4 = r3.a;
        Intrinsics.checkNotNullParameter(r4, "localId");
        h0 r5 = OfficeUploadStore.c.get(r4);
        if (r5 == null) goto L6;
        k.a.getClass();
        Intrinsics.checkNotNullParameter(r5, "task");
        k.b.execute(new l(r5));
        return;
    }

    @Override // com.bytedance.ee.bear.office.common.upload.i0
    public final void c(u r3) {
        Intrinsics.checkNotNullParameter(r3, "item");
        tt5.a.h("OfficeUploadUiHost", "office_upload_recovery_trace item_retry itemId=" + r3.a.hashCode() + " status=" + r3.d);
        Handler r0 = OfficeUploadStore.a;
        String r4 = r3.a;
        Intrinsics.checkNotNullParameter(r4, "localId");
        h0 r5 = OfficeUploadStore.c.get(r4);
        if (r5 == null) goto L6;
        k.a.getClass();
        Intrinsics.checkNotNullParameter(r5, "task");
        k.b.execute(new m(r5));
        return;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.ee.bear.office.common.upload.OfficeUploadUiHost$lifecycleObserver$1] */
    public OfficeUploadUiHost(ViewGroup r2, LifecycleOwner r3, List<OfficeUploadRecoveryTarget> r4, View r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "recoveryTargets");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.g = new OfficeUploadUiController(r2, this, r6);
        if (r5 == null) goto L5;
        g r8 = new g(r5, r7);
    L6:
        this.h = r8;
        this.i = CollectionsKt.emptyList();
        this.j = new OfficeUploadUiHost$lifecycleObserver$1(this);
        return;
    L5:
        r8 = null;
        goto L6
    }
}
