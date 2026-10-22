package com.bytedance.locallife.photo.photodraweeview;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes21.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Integer, Unit> f262105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f262106b;

    /* JADX WARN: Multi-variable type inference failed */
    public d(Function1<? super Integer, Unit> r100, int r101) {
        this.f262105a = r100;
        this.f262106b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f262105a.invoke(Integer.valueOf(this.f262106b));
    }
}
