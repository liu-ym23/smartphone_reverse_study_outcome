package com.bytedance.ee.bear.document.icon;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes16.dex */
public final class b extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ IconImageAdapter f219988c;

    public b(IconImageAdapter r100) {
        this.f219988c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        DocIconNetResult.Icon r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.getTag();
    L7:
        if ((r102 instanceof DocIconNetResult.Icon) == false) goto L9;
        r101 = (DocIconNetResult.Icon) r102;
    L9:
        if (r101 == null) goto L14;
        Function1<? super DocIconNetResult.Icon, Unit> r103 = this.f219988c.f219958b;
        if (r103 == null) goto L15;
        r103.invoke(r101);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r102 = null;
        goto L7
    }
}
