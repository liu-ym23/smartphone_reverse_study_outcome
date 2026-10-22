package com.bytedance.creativex.mediaimport.view.internal.base;

import com.ss.android.ugc.aweme.views.DebounceOnClickListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes15.dex */
public final class o extends DebounceOnClickListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ p<Object> f203856d;

    @Override // com.ss.android.ugc.aweme.views.DebounceOnClickListener
    public final void a() {
        this.f203856d.f203864g.onNext(ti4.i0.b.f546097a);
        Function0<Unit> r100 = this.f203856d.f203863f;
        if (r100 == null) goto L5;
        r100.invoke();
    L5:
        this.f203856d.d();
    }

    public o(p<Object> r100) {
        this.f203856d = r100;
        super(1100);
    }
}
