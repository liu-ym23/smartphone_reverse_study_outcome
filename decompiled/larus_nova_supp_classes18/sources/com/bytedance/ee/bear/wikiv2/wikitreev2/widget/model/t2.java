package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.IOperationUpdate$TreeNodeUpdateTitleAndIconParams;
import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t2<V> implements Callable {
    public final /* synthetic */ IOperationUpdate$TreeNodeUpdateTitleAndIconParams a;

    public t2(IOperationUpdate$TreeNodeUpdateTitleAndIconParams r1) {
        this.a = r1;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        yq5.f r0 = WikiDatabase.c().d();
        IOperationUpdate$TreeNodeUpdateTitleAndIconParams r1 = this.a;
        String r2 = r1.spaceId;
        String r3 = r1.wikiToken;
        String r4 = r1.newTitle;
        String r5 = "";
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        String r6 = r1.newIconInfo;
        if (r6 == null) goto L9;
        r5 = r6;
    L9:
        r0.m(r2, r3, r4, r5);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
