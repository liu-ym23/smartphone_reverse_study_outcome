package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.IOperationUpdate$TreeNodeUpdateTitleAndIconParams;
import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: classes18.dex */
public final class t2<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IOperationUpdate$TreeNodeUpdateTitleAndIconParams f242113a;

    public t2(IOperationUpdate$TreeNodeUpdateTitleAndIconParams r100) {
        this.f242113a = r100;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        yq5.f r100 = WikiDatabase.c().d();
        IOperationUpdate$TreeNodeUpdateTitleAndIconParams r101 = this.f242113a;
        String r102 = r101.spaceId;
        String r103 = r101.wikiToken;
        String r104 = r101.newTitle;
        String r105 = "";
        if (r104 != null) goto L5;
        r104 = "";
    L5:
        String r106 = r101.newIconInfo;
        if (r106 == null) goto L9;
        r105 = r106;
    L9:
        r100.m(r102, r103, r104, r105);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
