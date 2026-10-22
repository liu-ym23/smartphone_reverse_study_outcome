package com.bytedance.ee.bear.drive.core.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.OneShotPreDrawListener;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.drive.view.preview.imageviewer.DrivePreviewViewPager;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements t75.i {
    public final /* synthetic */ k a;
    public final /* synthetic */ Bundle b;
    public final /* synthetic */ DriveMainFragment c;

    @Override // t75.i
    public final t75.e Mk() {
        DriveMainFragment r0 = this.c;
        ArrayList<BaseOpenEntity> r1 = r0.g;
        if (r1 == null) goto L11;
        DrivePreviewViewPager r2 = r0.e;
        if (r2 == null) goto L11;
        int r3 = r2.getCurrentItem();
        BaseOpenEntity r4 = (BaseOpenEntity) CollectionsKt.getOrNull(r1, r3);
        if (r4 == null) goto L11;
        return new t75.e(r3, r1.size(), r4);
    L11:
        return null;
    }

    @Override // t75.i
    public final long gg() {
        DriveMainFragment r0 = this.c;
        long r1 = r0.h + 1;
        r0.h = r1;
        return r1;
    }

    @Override // t75.i
    public final t75.c Ea(Object r17) {
        Intrinsics.checkNotNullParameter(r17, "owner");
        k r9 = this.a;
        Bundle r3 = this.b;
        ConcurrentHashMap<String, com.bytedance.ee.drive.render.j> r4 = x75.a.a;
        String r5 = r3.getString("drive_open_strategy_key");
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        String r10 = r5;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r17, "owner");
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        int r1 = System.identityHashCode(r17);
        if (r9.n == false) goto L8;
        tt5.a.k("DriveSdk", "attachAiContainers skipped: released, sessionId=" + r10 + ", owner=" + r1);
    L14:
        return null;
    L8:
        FrameLayout r2 = (FrameLayout) r9.a.findViewById(2131370248);
        if (r2 != null) goto L11;
        tt5.a.k("DriveSdk", "attachAiContainers skipped: bottom container missing, sessionId=" + r10 + ", owner=" + r1);
        goto L14
    L11:
        FrameLayout r8 = (FrameLayout) r9.a.findViewById(2131370249);
        if (r8 != null) goto L15;
        tt5.a.k("DriveSdk", "attachAiContainers skipped: side container missing, sessionId=" + r10 + ", owner=" + r1);
        goto L14
    L15:
        boolean r14 = r9.j.isEmpty();
        boolean r16 = r9.j.add(Integer.valueOf(r1));
        if (r9.m != null) goto L18;
        r9.m = new k.b(r9, r10, r9.b, r2, r8);
    L18:
        k.b r6 = r9.m;
        if (r6 == null) goto L21;
        t75.c r11 = new t75.c(r6, r14);
    L22:
        StringBuilder r7 = new StringBuilder("attachAiContainers finish, sessionId=");
        r7.append(r10);
        r7.append(", owner=");
        r7.append(r1);
        r7.append(", ownerAdded=");
        r7.append(r16);
        r7.append(", ownerCount=");
        r7.append(r9.j.size());
        r7.append(", firstAttach=");
        r7.append(r14);
        r7.append(", hasHost=");
        boolean r12 = true;
        if (r11 == null) goto L25;
        boolean r13 = true;
    L26:
        r7.append(r13);
        r7.append(", bottomContainer=");
        r7.append(System.identityHashCode(r2));
        r7.append(", bottomChildCount=");
        r7.append(r2.getChildCount());
        r7.append(", bottomVisible=");
        if (r2.getVisibility() == 0) goto L30;
        r12 = false;
    L30:
        r7.append(r12);
        tt5.a.h("DriveSdk", r7.toString());
        return r11;
    L25:
        r13 = false;
        goto L26
    L21:
        r11 = null;
        goto L22
    }

    @Override // t75.i
    public final void G5(Object r7) {
        Intrinsics.checkNotNullParameter(r7, "owner");
        k r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r7, "owner");
        if (r1.n == false) goto L5;
        tt5.a.h("DriveSdk", "cancelPreviewBottomOverlaysSuppression skipped: released");
        return;
    L5:
        Intrinsics.checkNotNullParameter(r7, "owner");
        if (r1.n == false) goto L9;
        tt5.a.h("DriveSdk", "cancelAiBottomContainerSuppression skipped: released");
    L17:
        if (r1.t.remove(r7) == false) goto L21;
        r1.h.invoke(r7, Boolean.FALSE);
        return;
    L21:
        return;
    L9:
        if (r1.s.remove(r7) == null) goto L11;
        boolean r0 = true;
    L12:
        boolean r2 = r1.r.remove(r7);
        if (r2 == false) goto L15;
        r1.c();
    L15:
        tt5.a.h("DriveSdk", "cancelAiBottomContainerSuppression success, pendingRemoved=" + r0 + ", ownerRemoved=" + r2);
        goto L17
    L11:
        r0 = false;
        goto L12
    }

    @Override // t75.i
    public final void K9(Object r3) {
        Intrinsics.checkNotNullParameter(r3, "owner");
        k r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "owner");
        t75.h r2 = r1.k;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "owner");
        if (r2.a != r3) goto L7;
        r2.a = null;
        r2.b = null;
        r2.c = null;
        return;
    }

    @Override // t75.i
    public final boolean k2(Object r13) {
        Intrinsics.checkNotNullParameter(r13, "owner");
        k r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r13, "owner");
        int r14 = System.identityHashCode(r13);
        boolean r2 = true;
        if (r1.n == true) goto L5;
        k.b r0 = r1.m;
        Boolean r5 = null;
        if (r0 == null) goto L17;
        String r6 = r0.a;
    L18:
        if (r0 == null) goto L22;
        FrameLayout r7 = r0.c;
        if (r7 == null) goto L22;
        Integer r8 = Integer.valueOf(r7.getChildCount());
    L23:
        if (r0 == null) goto L31;
        FrameLayout r9 = r0.c;
        if (r9 == null) goto L31;
        if (r9.getVisibility() != 0) goto L29;
        boolean r10 = true;
    L30:
        r5 = Boolean.valueOf(r10);
        goto L31
    L29:
        r10 = false;
    L31:
        boolean r11 = r1.j.remove(Integer.valueOf(r14));
        boolean r12 = r1.j.isEmpty();
        if (r12 == false) goto L34;
        r1.d(false);
    L34:
        StringBuilder r16 = new StringBuilder("detachAiContainers finish, sessionId=");
        r16.append(r6);
        r16.append(", owner=");
        r16.append(r14);
        r16.append(", ownerRemoved=");
        r16.append(r11);
        r16.append(", ownerCount=");
        r16.append(r1.j.size());
        r16.append(", lastDetach=");
        r16.append(r12);
        r16.append(", hadHost=");
        if (r0 != null) goto L38;
        r2 = false;
    L38:
        r16.append(r2);
        r16.append(", bottomChildCount=");
        r16.append(r8);
        r16.append(", bottomVisible=");
        r16.append(r5);
        tt5.a.h("DriveSdk", r16.toString());
        return r12;
    L22:
        r8 = null;
        goto L23
    L17:
        r6 = null;
        goto L18
    L5:
        if (r1.o == false) goto L8;
        tt5.a.h("DriveSdk", "detachAiContainersAfterRelease skipped: alreadyReturned");
        return false;
    L8:
        if (r1.l.remove(Integer.valueOf(r14)) == true) goto L10;
        tt5.a.h("DriveSdk", "detachAiContainersAfterRelease skipped: ownerNotPending");
        return false;
    L10:
        boolean r3 = r1.l.isEmpty();
        if (r3 == false) goto L13;
        r1.o = true;
    L13:
        tt5.a.h("DriveSdk", "detachAiContainersAfterRelease lastDetach=" + r3 + " pendingCount=" + r1.l.size());
        return r3;
    }

    @Override // t75.i
    public final void E6(Object r10, Runnable r11) {
        Intrinsics.checkNotNullParameter(r10, "owner");
        Intrinsics.checkNotNullParameter(r11, JSEventListener.ACTION);
        k r4 = this.a;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r10, "owner");
        Intrinsics.checkNotNullParameter(r11, JSEventListener.ACTION);
        if (r4.n == false) goto L5;
        tt5.a.h("DriveSdk", "suppressPreviewBottomOverlaysUntilNextLayout skipped: released");
        return;
    L5:
        boolean r2 = false;
        if (RangesKt.coerceAtLeast(((Number) r4.g.invoke()).intValue(), 0) <= 0) goto L8;
        boolean r0 = true;
    L10:
        if (r4.t.add(r10) == false) goto L13;
        r4.h.invoke(r10, Boolean.TRUE);
    L13:
        if (r4.n == false) goto L15;
        tt5.a.h("DriveSdk", "suppressAiBottomContainerUntilNextLayout skipped: released");
        return;
    L15:
        FrameLayout r5 = (FrameLayout) r4.a.findViewById(2131370248);
        if (r5 != null) goto L18;
    L20:
        boolean r3 = true ^ r4.s.isEmpty();
        r4.r.add(r10);
        r4.c();
        if (r0 == true) goto L25;
        if (r2 == true) goto L25;
        if (r3 == true) goto L25;
        r11.run();
        tt5.a.h("DriveSdk", "suppressAiBottomContainerUntilNextLayout success: synchronous");
        return;
    L25:
        long r6 = r4.u + 1;
        r4.u = r6;
        Long r1 = Long.valueOf(r6);
        r4.s.put(r10, r1);
        View r7 = r4.a.findViewById(2131379451);
        if (r7 != null) goto L28;
        r4.s.remove(r10);
        r11.run();
        tt5.a.h("DriveSdk", "suppressAiBottomContainerUntilNextLayout success: content missing");
        return;
    L28:
        OneShotPreDrawListener.add(r7, new p(r7, r4, r10, r6, r11));
        return;
    L18:
        if (r5.getVisibility() != 0) goto L20;
        r2 = true;
        goto L20
    L8:
        r0 = false;
        goto L10
    }

    @Override // t75.i
    public final void J3(Object r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "owner");
        k r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "owner");
        if (r1.n == false) goto L5;
        tt5.a.h("DriveSdk", "setAiBottomContainerSuppressed skipped: released");
        return;
    L5:
        if (r5 == false) goto L7;
        boolean r6 = r1.r.add(r4);
    L8:
        if (r6 == false) goto L13;
        r1.c();
        tt5.a.h("DriveSdk", "setAiBottomContainerSuppressed suppressed=" + r5 + ", ownerCount=" + r1.r.size());
        return;
    L13:
        return;
    L7:
        r6 = r1.r.remove(r4);
        goto L8
    }

    public c(k r1, Bundle r2, DriveMainFragment r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // t75.i
    public final void Cf(Object r6, Function0<ir5.i> r7, Function0<Boolean> r8) {
        Intrinsics.checkNotNullParameter(r6, "owner");
        Intrinsics.checkNotNullParameter(r7, "provider");
        Intrinsics.checkNotNullParameter(r8, "clearSelection");
        k r3 = this.a;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r6, "owner");
        Intrinsics.checkNotNullParameter(r7, "provider");
        Intrinsics.checkNotNullParameter(r8, "clearSelection");
        if (r3.n == false) goto L5;
        tt5.a.h("DriveSdk", "bindSelectionContextProvider skipped: released");
        return;
    L5:
        t75.h r4 = r3.k;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r6, "owner");
        Intrinsics.checkNotNullParameter(r7, "provider");
        Intrinsics.checkNotNullParameter(r8, "clearSelection");
        r4.a = r6;
        r4.b = r7;
        r4.c = r8;
    }
}
