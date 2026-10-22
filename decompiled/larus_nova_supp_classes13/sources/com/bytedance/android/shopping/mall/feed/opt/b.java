package com.bytedance.android.shopping.mall.feed.opt;

import com.bytedance.android.ec.hybrid.list.entity.dto.ChipData;
import com.bytedance.android.ec.hybrid.list.entity.dto.ChipViewConfig;
import com.bytedance.android.ec.hybrid.list.opt.ImageRequestOpt;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements Runnable {
    public final /* synthetic */ List a;

    public b(List r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r0 = this.a.iterator();     // Catch: Throwable -> L9
    L4:
        if (r0.hasNext() == false) goto L21;
        ChipData r1 = ((ChipViewConfig) r0.next()).getChipData();     // Catch: Throwable -> L9
        if (r1 == null) goto L4;
        Set r2 = ImageRequestOpt.a;     // Catch: Throwable -> L9
        ImageRequestOpt.a(r1.getImageUrl(), r1.getBizTag(), r1.getSceneTag());     // Catch: Throwable -> L9
        goto L4
    L21:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L13;
        return;
    L13:
        throw th;
    }
}
