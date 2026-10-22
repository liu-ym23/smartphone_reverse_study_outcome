package com.permissionx.guolindev.request;

import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class u extends a {
    @Override // com.permissionx.guolindev.request.b
    public final void request() {
        ArrayList r100 = new ArrayList();
        Iterator<String> r101 = this.f404364a.f404380d.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        String r102 = r101.next();
        if (moa.b.a(this.f404364a.getActivity(), r102) == true) goto L7;
        r100.add(r102);
        goto L4
    L7:
        this.f404364a.f404384h.add(r102);
        goto L4
    L10:
        if (r100.isEmpty() == false) goto L13;
        finish();
        return;
    L13:
        this.f404364a.getClass();
        o r103 = this.f404364a;
        r103.d(r103.f404380d, this);
    }

    public u(o r100) {
        Intrinsics.checkNotNullParameter(r100, "permissionBuilder");
        super(r100);
    }

    @Override // com.permissionx.guolindev.request.b
    public final void b(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        HashSet r101 = new HashSet(this.f404364a.f404384h);
        r101.addAll(r100);
        if ((!r101.isEmpty()) == false) goto L5;
        this.f404364a.d(r101, this);
        return;
    L5:
        finish();
    }
}
