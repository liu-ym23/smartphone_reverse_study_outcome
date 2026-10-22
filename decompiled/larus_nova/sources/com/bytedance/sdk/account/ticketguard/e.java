package com.bytedance.sdk.account.ticketguard;

import com.bytedance.android.sdk.bdticketguard.r;
import com.bytedance.android.sdk.bdticketguard.s0;
import com.bytedance.android.sdk.bdticketguard.t0;
import com.bytedance.sdk.account.utils.NetworkUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import wqa.i;
import wqa.k;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements r {
    public e() {
    }

    public final t0 a(String r100, Map r101, List r102) throws Exception {
        ArrayList r103 = null;
        if (r102 != null) goto L5;
    L10:
        ArrayList r104 = null;
    L11:
        if (r104 != null) goto L13;
        r104 = new ArrayList();
    L13:
        k r105 = NetworkUtils.b(r100, r101, r104);
        if (r105 == null) goto L25;
        List<i> r106 = r105.f560779b;
        if (r106 == null) goto L24;
        if (r106.isEmpty() == true) goto L24;
        r103 = new ArrayList();
        Iterator<i> r107 = r106.iterator();
    L21:
        if (r107.hasNext() == false) goto L24;
        i r108 = r107.next();
        r103.add(new s0(r108.f560775a, r108.f560776b));
    L24:
        return new t0(r105.f560778a, r103, r105.f560780c);
    L25:
        return null;
    L5:
        if (r102.isEmpty() == true) goto L10;
        r104 = new ArrayList();
        Iterator r109 = r102.iterator();
    L8:
        if (r109.hasNext() == false) goto L11;
        s0 r110 = (s0) r109.next();
        r104.add(new i(r110.f163980a, r110.f163981b));
        goto L8
    }
}
