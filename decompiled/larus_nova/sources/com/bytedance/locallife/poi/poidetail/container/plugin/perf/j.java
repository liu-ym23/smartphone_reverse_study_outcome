package com.bytedance.locallife.poi.poidetail.container.plugin.perf;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes21.dex */
public final class j implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f264159a;

    public j(Function0<Unit> r100) {
        this.f264159a = r100;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        this.f264159a.invoke();
        return true;
    }
}
