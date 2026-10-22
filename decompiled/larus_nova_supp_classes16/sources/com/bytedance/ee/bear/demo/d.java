package com.bytedance.ee.bear.demo;

import com.bytedance.ee.bear.document.tips.TipCallBackData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d<T> implements nc5.c {
    public final /* synthetic */ CCMFolderDemoActivity a;

    public d(CCMFolderDemoActivity r1) {
        this.a = r1;
    }

    public final void a(com.bytedance.ee.bear.list.delete.e r5) {
        Intrinsics.checkNotNullParameter(r5, TipCallBackData.RESULT);
        StringBuilder r0 = new StringBuilder("deleteItems result\n");
        r0.append("allSuccess=" + r5.a + '\n');
        r0.append("failedTokenToCode=" + r5.b + '\n');
        this.a.C1(r0.toString());
    }
}
