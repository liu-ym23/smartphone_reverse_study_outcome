package com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea;

import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ToolVO;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements Runnable {
    public final /* synthetic */ ToolListAdapter a;
    public final /* synthetic */ String b;
    public final /* synthetic */ boolean c;

    public d(ToolListAdapter r1, boolean r2) {
        this.a = r1;
        this.b = "2";
        this.c = r2;
    }

    public final void a() {
        List<ToolVO> r0 = this.a.c;     // Catch: Exception -> L27
        Integer r1 = null;
        if (r0 == null) goto L17;
        Iterator<ToolVO> r2 = r0.iterator();     // Catch: Exception -> L27
        int r3 = 0;
    L6:
        if (r2.hasNext() == false) goto L15;
        ToolVO r4 = r2.next();     // Catch: Exception -> L27
        String r5 = this.b;     // Catch: Exception -> L27
        if (r4 == null) goto L10;
        String r6 = r4.getComponentId();     // Catch: Exception -> L27
    L12:
        if (Intrinsics.areEqual(r5, r6) == true) goto L16;
        r3 = r3 + 1;     // Catch: Exception -> L27
    L16:
        r1 = Integer.valueOf(r3);     // Catch: Exception -> L27
        goto L17
    L10:
        r6 = null;
        goto L12
    L15:
        r3 = -1;
    L17:
        if (r1 != null) goto L19;
        return;
    L19:
        if (r1.intValue() < 0) goto L35;
        ToolVO r7 = this.a.A2(r1.intValue());     // Catch: Exception -> L27
        if (r7 == null) goto L36;
        ToolVO.Corner r8 = r7.getCorner();     // Catch: Exception -> L27
        if (r8 == null) goto L25;
        r8.setCanShow(this.c);     // Catch: Exception -> L27
    L25:
        this.a.notifyItemChanged(r1.intValue());     // Catch: Exception -> L27
        return;
    L36:
        return;
    L35:
        return;
    L27:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
