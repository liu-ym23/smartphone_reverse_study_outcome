package com.bytedance.ee.bear.more.view3;

import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.more.protocol3.i;
import com.bytedance.ee.bear.more.protocol3.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import s45.p;
import sbb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a<T> implements Observer {
    public final /* synthetic */ MoreFragmentV3 a;

    public a(MoreFragmentV3 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r7) {
        i r8 = (i) r7;
        MoreFragmentV3 r0 = this.a;
        Intrinsics.checkNotNull(r8);
        int r1 = MoreFragmentV3.n;
        r0.getClass();
        List<k> r9 = r8.a;
        Iterator<T> r2 = r9.iterator();
    L3:
        Window r3 = null;
        if (r2.hasNext() == false) goto L8;
        T r4 = r2.next();
        if ((((k) r4) instanceof zj5.b) == false) goto L3;
    L9:
        r0.ea0(r4);
        MoreAdapter r5 = (MoreAdapter) r0.l.getValue();
        ArrayList r6 = new ArrayList();
        Iterator<T> r10 = r9.iterator();
    L11:
        if (r10.hasNext() == false) goto L15;
        T r11 = r10.next();
        if ((((k) r11) instanceof zj5.b) == true) goto L11;
        r6.add(r11);
        goto L11
    L15:
        r5.y2(new i(r6));
        MoreFragmentV3 r12 = this.a;
        if (r12.m == true) goto L65;
        MoreViewModelV3 r13 = r12.k;
        if (r13 == null) goto L21;
        Integer r14 = r13.getType();
    L22:
        if (r14 != null) goto L24;
    L29:
        MoreViewModelV3 r15 = r12.k;
        if (r15 == null) goto L33;
        String r16 = r15.getUrl();
        if (r16 == null) goto L33;
    L35:
        if (TextUtils.isEmpty(r16) == true) goto L66;
        BearUrl r17 = p.a().Z(r16);
        String r18 = r17.b;
        r14 = Integer.valueOf(r17.a());
    L39:
        if (r18 != null) goto L41;
    L44:
        boolean r19 = true;
    L45:
        if (r19 == true) goto L67;
        zo5.b r20 = (zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6);
        if (r12.getDialog() == null) goto L51;
        Dialog r21 = r12.getDialog();
        Intrinsics.checkNotNull(r21);
        r3 = r21.getWindow();
    L51:
        if (r3 != null) goto L53;
    L55:
        r20.h(r18, r14.intValue());
        r20.j(r18, r14.intValue(), r12.getDialog());
        r12.m = true;
        return;
    L53:
        if ((MoreFragmentV3.da0(r3) instanceof FrameLayout) == false) goto L55;
        Dialog r22 = r12.getDialog();
        Intrinsics.checkNotNull(r22);
        Window r23 = r22.getWindow();
        Intrinsics.checkNotNull(r23);
        View r24 = MoreFragmentV3.da0(r23);
        Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type android.widget.FrameLayout");
        r20.detachWatermark((FrameLayout) r24);
        goto L55
    L67:
        return;
    L41:
        if (r18.length() == 0) goto L44;
        r19 = false;
        goto L45
    L66:
        return;
    L33:
        r16 = "";
        goto L35
    L24:
        if (g.b(r14.intValue()) == false) goto L29;
        MoreViewModelV3 r25 = r12.k;
        if (r25 == null) goto L28;
        r18 = r25.getToken();
        goto L39
    L28:
        r18 = null;
        goto L39
    L21:
        r14 = null;
        goto L22
    L65:
        return;
    L8:
        r4 = (T) null;
        goto L9
    }
}
