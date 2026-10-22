package com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea;

import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ToolVO;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements Runnable {
    public final /* synthetic */ ToolListAdapter a;
    public final /* synthetic */ boolean b;

    public c(ToolListAdapter r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List<ToolVO> r0 = this.a.c;     // Catch: Throwable -> L14 Exception -> L16
        if (r0 == null) goto L12;
        Iterator<T> r1 = r0.iterator();     // Catch: Throwable -> L14 Exception -> L16
    L6:
        if (r1.hasNext() == false) goto L12;
        ToolVO r2 = (ToolVO) r1.next();     // Catch: Throwable -> L14 Exception -> L16
        if (r2 == null) goto L6;
        ToolVO.Corner r3 = r2.getCorner();     // Catch: Throwable -> L14 Exception -> L16
        if (r3 == null) goto L6;
        r3.setCanShow(this.b);     // Catch: Throwable -> L14 Exception -> L16
    L12:
        this.a.notifyDataSetChanged();     // Catch: Throwable -> L14 Exception -> L16
    L33:
        return;
    L16:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L22;
        return;
    L22:
        throw th;
    }
}
