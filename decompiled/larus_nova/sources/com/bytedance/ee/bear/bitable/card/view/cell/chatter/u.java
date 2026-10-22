package com.bytedance.ee.bear.bitable.card.view.cell.chatter;

import android.view.View;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes15.dex */
public final class u extends com.bytedance.ee.bear.widgets.t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SelectedChatterAdapter<IChatterEntity> f207622c;

    public u(SelectedChatterAdapter<IChatterEntity> r100) {
        this.f207622c = r100;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        IChatterEntity r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.getTag();
    L7:
        if ((r102 instanceof IChatterEntity) == false) goto L9;
        r101 = (IChatterEntity) r102;
    L9:
        if (r101 != null) goto L11;
        return;
    L11:
        SelectedChatterAdapter<IChatterEntity> r103 = this.f207622c;
        if (r103.f207543e == false) goto L14;
        r103.y2(r101);
        return;
    L14:
        Function1<? super D, Unit> r104 = r103.f207542d;
        if (r104 == 0) goto L19;
        r104.invoke(r101);
        return;
    L19:
        return;
    L5:
        r102 = null;
        goto L7
    }
}
