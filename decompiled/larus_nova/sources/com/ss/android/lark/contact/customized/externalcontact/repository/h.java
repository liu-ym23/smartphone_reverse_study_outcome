package com.ss.android.lark.contact.customized.externalcontact.repository;

import com.bytedance.lark.pb.contact.v2.ContactProfile;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ContactProfile f419144a;

    public h(ContactProfile r100) {
        this.f419144a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r100 = ((List) OfficeExternalContactRepository.f419135b.getValue()).iterator();     // Catch: Throwable -> L7
    L4:
        if (r100.hasNext() == false) goto L16;
        b r101 = (b) r100.next();     // Catch: Throwable -> L7
        int r102 = mtb.d.f515661l;     // Catch: Throwable -> L7
        r101.a(mtb.d.a.a(this.f419144a));     // Catch: Throwable -> L7
        goto L4
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
