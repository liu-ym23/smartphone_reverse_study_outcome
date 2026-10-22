package com.bytedance.ee.bear.wikiv2.sidebar.wikitree.widget.view;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j implements View.OnClickListener {
    public final /* synthetic */ Function0<Unit> a;

    public j(Function0<Unit> r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        this.a.invoke();
    }
}
