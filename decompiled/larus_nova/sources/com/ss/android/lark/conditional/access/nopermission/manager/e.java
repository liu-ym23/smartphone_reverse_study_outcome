package com.ss.android.lark.conditional.access.nopermission.manager;

import androidx.lifecycle.Observer;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import java.util.Iterator;

/* JADX INFO: loaded from: classes35.dex */
public final class e<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NoPermissionModuleManager f418173a;

    public e(NoPermissionModuleManager r100) {
        this.f418173a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (((Boolean) r100).booleanValue() == true) goto L11;
        NoPermissionModuleManager r101 = this.f418173a;
        r101.f418114n = false;
        Iterator<NoPermissionModuleManager.b> r102 = r101.f418112l.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        NoPermissionModuleManager.b r103 = r102.next();
        int r104 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "proceed navigate " + r103.f418120c);
        r103.f418120c.a(r103.f418118a, r103.f418119b);
        goto L6
    L8:
        r101.f418112l.clear();
        return;
    }
}
