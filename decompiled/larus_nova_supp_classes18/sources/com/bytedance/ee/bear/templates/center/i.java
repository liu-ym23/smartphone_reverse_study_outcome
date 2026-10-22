package com.bytedance.ee.bear.templates.center;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i<T> implements Observer {
    public final /* synthetic */ TemplateCenterView a;

    public i(TemplateCenterView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        FolderSortStrategy r4 = (FolderSortStrategy) r3;
        Intrinsics.checkNotNullParameter(r4, "folderSortStrategy");
        if (Intrinsics.areEqual(r4.a, "template_v4") == false) goto L6;
        sbb.e r5 = sbb.e.d(r4.getType());
        TemplateCenterView r0 = this.a;
        Intrinsics.checkNotNull(r5);
        r0.k(r5);
        return;
    }
}
