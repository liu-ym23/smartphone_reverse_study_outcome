package com.bytedance.android.shopping.deepfeed;

import com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.larus.apm.impl.protector.RunnableProtector;
import he3.e1;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l implements Runnable {
    public final /* synthetic */ DeepFeedProductFragment a;
    public final /* synthetic */ com.bytedance.android.shopping.deepfeed.viewmodel.d b;

    public l(DeepFeedProductFragment r1, com.bytedance.android.shopping.deepfeed.viewmodel.d r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        DeepFeedProductFragment r0 = this.a;
        String r1 = null;
        r0.Y = null;
        com.bytedance.android.shopping.deepfeed.viewmodel.d r2 = this.b;
        int r3 = r2.a;
        String r4 = r2.b;
        AbsDeepFeedProductVH r5 = r0.v;
        if (r5 == null) goto L9;
        InFeedProductV2 r6 = r5.m;
        if (r6 == null) goto L9;
        e1 r7 = com.bytedance.android.shopping.deepfeed.utlis.a.a(r6);
        if (r7 == null) goto L9;
        r1 = r7.a();
    L9:
        boolean r8 = false;
        if (r5 != null) goto L12;
    L14:
        boolean r9 = false;
    L15:
        if (r3 != 1) goto L27;
        if (r9 == false) goto L27;
        if (r4 != null) goto L19;
    L22:
        boolean r10 = true;
    L23:
        if (r10 == true) goto L27;
        if (Intrinsics.areEqual(r4, r1) == false) goto L27;
        r8 = true;
        goto L27
    L19:
        if (r4.length() == 0) goto L22;
        r10 = false;
    L27:
        if (r8 == false) goto L30;
        LinkedHashMap r11 = new LinkedHashMap();
        r11.put("pitaya_auto_slide_params", this.b.c);
        this.a.V90(r11);
        return;
    L30:
        return;
    L12:
        if (r5.getAdapterPosition() != 0) goto L14;
        r9 = true;
        goto L15
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
