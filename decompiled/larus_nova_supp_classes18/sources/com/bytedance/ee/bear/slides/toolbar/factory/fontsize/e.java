package com.bytedance.ee.bear.slides.toolbar.factory.fontsize;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.document.model.toolbar.DocToolbarV2;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarPrimaryItemId;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e<T> implements Observer {
    public final /* synthetic */ d a;
    public final /* synthetic */ an4.b b;
    public final /* synthetic */ Fragment c;

    public e(d r1, an4.b r2, Fragment r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onChanged(Object r3) {
        DocToolbarV2 r4 = (DocToolbarV2) r3;
        if (r4 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r4.getShowingItemId(), ToolbarPrimaryItemId.textTransform.name()) == true) goto L9;
        this.a.c(this.b, this.c);
        return;
    }
}
