package com.bytedance.ee.bear.demo;

import com.bytedance.ee.bear.document.tips.TipCallBackData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e<T> implements nc5.c {
    public final /* synthetic */ CCMFolderDemoActivity a;

    public e(CCMFolderDemoActivity r1) {
        this.a = r1;
    }

    public final void a(com.bytedance.ee.bear.list.delete.e r4) {
        Intrinsics.checkNotNullParameter(r4, TipCallBackData.RESULT);
        this.a.C1("deleteMulti result: allSuccess=" + r4.a + ", failedTokenToCode=" + r4.b + '\n');
    }
}
