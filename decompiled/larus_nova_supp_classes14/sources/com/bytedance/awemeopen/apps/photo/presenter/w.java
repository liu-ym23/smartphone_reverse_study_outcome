package com.bytedance.awemeopen.apps.photo.presenter;

import android.app.Activity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.photo.AosPictureDetailLayout;
import com.bytedance.awemeopen.apps.photo.view.AosPictureDetailBottomPanelDialog;
import com.bytedance.awemeopen.apps.photo.viewmodel.FlowPagePinchVM;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.export.api.picturedetail.AosPictureDetailConfig;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class w extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ GuesturePresenter a;

    public w(GuesturePresenter r1) {
        this.a = r1;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent r18) {
        Intrinsics.checkNotNullParameter(r18, "e");
        GuesturePresenter r1 = this.a;
        float r3 = r18.getRawX();
        float r4 = r18.getRawY();
        int[] r5 = new int[2];
        r1.m.getLocationOnScreen(r5);
        int r7 = r5[0];
        int r6 = r5[1];
        int r9 = r1.m.getWidth();
        int r2 = r1.m.getHeight();
        if (r3 >= r7) goto L5;
    L11:
        boolean r8 = false;
    L12:
        if (r8 == true) goto L14;
        return;
    L14:
        if (Intrinsics.areEqual(((FlowPagePinchVM) this.a.l.getValue()).getInStableView().getValue(), Boolean.TRUE) == true) goto L57;
        final GuesturePresenter r10 = this.a;
        r10.i = true;
        LifecycleOwner r11 = r10.d.d;
        if ((r11 instanceof AosPictureDetailLayout) == false) goto L19;
        View r12 = ((AosPictureDetailLayout) r11).getView();
    L20:
        if (r12 == null) goto L22;
        r12.dispatchTouchEvent(MotionEvent.obtain(r18.getDownTime(), r18.getEventTime(), 3, r18.getX(), r18.getY(), r18.getMetaState()));
    L22:
        AoLogger.b("GuesturePresenter", new Object[]{"show AosPictureDetailBottomPanelDialog currentPhotoPosition=" + r10.e.getCurrentPhotoPosition().getValue()});
        Activity r13 = r10.d.getActivity();
        a14.a r14 = r10.d;
        Integer r15 = (Integer) r10.e.getCurrentPhotoPosition().getValue();
        if (r15 != null) goto L25;
        r15 = 0;
    L25:
        r15.intValue();
        AosPictureDetailBottomPanelDialog r16 = new AosPictureDetailBottomPanelDialog(r13, r14, new y());
        r16.j = new GuesturePresenter$showBottomPanel$2(r10);
        if (DialogLancet.shouldBlockDialogShow(r16) == false) goto L54;
        DialogLancet.handleBlockedDialogShow(r16);
    L30:
        GuesturePresenter r17 = this.a;
        r17.getClass();
        float r19 = r18.getRawX() / com.bytedance.awemeopen.apps.framework.utils.d0.d(r17.getContext());
        float r110 = r18.getRawY() / com.bytedance.awemeopen.apps.framework.utils.d0.c(r17.getContext());
        AosEventReporter r20 = AosEventReporter.a;
        User r21 = r17.d.a.f();
        if (r21 == null) goto L36;
        String r22 = r21.u();
        if (r22 == null) goto L36;
        String r23 = r22;
    L37:
        String r24 = r17.d.c.sceneId();
        String r25 = r17.d.a.c();
        r14.a0 r26 = r17.d.a.d;
        if (r26 == null) goto L43;
        String r27 = r26.a();
        if (r27 == null) goto L43;
        String r28 = r27;
    L44:
        AosPictureDetailConfig r29 = r17.d.c.getPageConfig();
        if (r29 == null) goto L50;
        String r30 = r29.getPreviousPage();
        if (r30 == null) goto L50;
        String r111 = r30;
    L51:
        com.bytedance.awemeopen.apps.framework.utils.e r112 = new com.bytedance.awemeopen.apps.framework.utils.e(r17.d.a);
        r20.getClass();
        AosEventReporter.J(r23, r24, r25, r28, r19, r110, r111, r112);
        return;
    L50:
        r111 = "";
    L43:
        r28 = "";
    L36:
        r23 = "";
        goto L37
    L54:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L53
    L29:
        DialogLancet.beforeDialogShow(r16);
        r16.show();
        DialogLancet.afterDialogShow(r16);
        goto L30
    L19:
        r12 = null;
        goto L20
    L57:
        return;
    L5:
        if (r3 > (r7 + r9)) goto L11;
        if (r4 < r6) goto L11;
        if (r4 > (r6 + r2)) goto L11;
        r8 = true;
        goto L12
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent r2, MotionEvent r3, float r4, float r5) {
        Intrinsics.checkNotNullParameter(r2, "e1");
        Intrinsics.checkNotNullParameter(r3, "e2");
        return super.onFling(r2, r3, r4, r5);
    }
}
