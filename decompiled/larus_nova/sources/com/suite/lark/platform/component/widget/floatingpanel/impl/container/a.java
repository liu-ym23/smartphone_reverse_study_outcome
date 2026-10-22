package com.suite.lark.platform.component.widget.floatingpanel.impl.container;

import android.app.Activity;
import androidx.core.util.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes36.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f460709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1<Activity, Unit> f460710b;

    /* JADX WARN: Multi-variable type inference failed */
    public a(Activity r100, Function1<? super Activity, Unit> r101) {
        this.f460709a = r100;
        this.f460710b = r101;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object r100) {
        if (((Boolean) r100).booleanValue() == false) goto L5;
        Activity r101 = this.f460709a;
    L6:
        this.f460710b.invoke(r101);
        return;
    L5:
        r101 = null;
        goto L6
    }
}
