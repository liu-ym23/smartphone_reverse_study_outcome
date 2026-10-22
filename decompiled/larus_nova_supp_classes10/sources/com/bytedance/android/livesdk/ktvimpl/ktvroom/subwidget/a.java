package com.bytedance.android.livesdk.ktvimpl.ktvroom.subwidget;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ListUtils;
import com.bytedance.android.live.liveinteract.linkpanel.util.o;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import hh1.w0;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import kk0.f;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tf0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ KtvRoomContainerBaseWidget a;

    public a(KtvRoomContainerWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        List r7 = (List) r6;
        ALogger.i("KtvRoomContainerBaseWidget", "userListObservable, size: " + r7.size());
        KtvRoomContainerBaseWidget r0 = this.a;
        List r8 = CollectionsKt.toMutableList(r7);
        int r1 = KtvRoomContainerBaseWidget.H;
        r0.getClass();
        List r2 = r8;
        boolean r3 = false;
        if (r2 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == true) goto L58;
        int r5 = r8.size();
        if (1 > r5) goto L31;
        if (9 < r5) goto L31;
        MultiLinkGuestViewBinder.a r9 = (e) ListProtector.get(r8, 0);
        if ((r9 instanceof MultiLinkGuestViewBinder.a) == false) goto L31;
        MultiLinkGuestViewBinder.a r10 = r9;
        if (r10.k.a.getUser() == null) goto L31;
        ILinkPlayerInfoBridge r11 = r10.k.a;
        IBaseUser r12 = r11.getUser();
        Intrinsics.checkNotNull(r12);
        if (r12 == null) goto L29;
        w0 r13 = r0.D;
        if (r13 == null) goto L31;
        String r14 = r12.getIdString();
        if (r11.getSilenceStatus() == 0) goto L27;
        r3 = true;
    L27:
        r13.f9(r14, r3);
        goto L31
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.user.IBaseUser");
    L31:
        if (ListUtils.isEmpty(r8) == true) goto L55;
        Iterator r15 = r8.iterator();
    L34:
        if (r15.hasNext() == false) goto L59;
        MultiLinkGuestViewBinder.a r16 = (e) r15.next();
        if ((r16 instanceof MultiLinkGuestViewBinder.a) == false) goto L34;
        MultiLinkGuestViewBinder.a r17 = r16;
        IBaseUser r18 = r17.k.a.getUser();
        if (r18 == null) goto L40;
        String r19 = r18.getIdString();
    L42:
        if (Intrinsics.areEqual(r19, o.J()) == false) goto L34;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r20 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r20 == null) goto L56;
        f r21 = r20.Bb();
        if (r21 == null) goto L57;
        r21.Vj(r17.k.a);
        return;
    L57:
        return;
    L56:
        return;
    L40:
        r19 = null;
        goto L42
    L59:
        return;
    L55:
        return;
    L58:
        return;
    L5:
        if (r2.isEmpty() == true) goto L8;
        r4 = false;
        goto L9
    }
}
