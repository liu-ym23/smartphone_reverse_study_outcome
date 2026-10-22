package com.ss.android.lark.officesdk.integrator.im.impl;

import com.ss.android.lark.integrator.im.extension.ExtensionManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes37.dex */
public final class m implements pmb.g {
    public m() {
    }

    @Override // pmb.g
    public final void a(List<r5b.e<?, ?, ?>> r100) {
        Iterator<rxa.a> r101 = ExtensionManager.a().f427937b.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ArrayList r102 = (ArrayList) r100;
        r102.addAll(r101.next().a());
        goto L4
    }
}
