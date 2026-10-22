package com.bytedance.ee.bear.bitable.card.view.cell.chatter;

import android.view.View;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes15.dex */
public final class w extends com.bytedance.ee.bear.widgets.t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SuggestChatterAdapter<IChatterEntity> f207625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ IChatterEntity f207626d;

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        Function1<? super D, Unit> r101 = this.f207625c.f207554h;
        if (r101 == 0) goto L6;
        r101.invoke(this.f207626d);
        return;
    }

    public w(SuggestChatterAdapter<IChatterEntity> r100, IChatterEntity r101) {
        this.f207625c = r100;
        this.f207626d = r101;
    }
}
