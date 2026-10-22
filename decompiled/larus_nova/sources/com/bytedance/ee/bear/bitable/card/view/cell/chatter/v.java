package com.bytedance.ee.bear.bitable.card.view.cell.chatter;

import android.view.View;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes15.dex */
public final class v extends com.bytedance.ee.bear.widgets.t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SuggestChatterAdapter<IChatterEntity> f207623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ SuggestChatterViewHolder f207624d;

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        if (r100 == null) goto L5;
        Object r101 = r100.getTag();
    L7:
        if ((r101 instanceof IChatterEntity) == false) goto L9;
        IChatterEntity r102 = (IChatterEntity) r101;
    L10:
        if (r102 != null) goto L12;
        return;
    L12:
        ArrayList r103 = new ArrayList();
        SuggestChatterAdapter<IChatterEntity> r104 = this.f207623c;
        if (r104.f207549c == false) goto L31;
        r103.addAll(r104.f207547a);
        if (this.f207624d.f207558d.isChecked() == false) goto L19;
        r103.remove(r102);
        Function4<? super List<? extends D>, ? super D, ? super D, ? super Boolean, Unit> r105 = this.f207623c.f207552f;
        if (r105 == 0) goto L40;
        r105.invoke(r103, null, r102, Boolean.FALSE);
        return;
    L40:
        return;
    L19:
        Integer r106 = this.f207623c.f207550d;
        if (r106 != null) goto L22;
    L27:
        r103.add(r102);
        Function4<? super List<? extends D>, ? super D, ? super D, ? super Boolean, Unit> r107 = this.f207623c.f207552f;
        if (r107 == 0) goto L42;
        r107.invoke(r103, r102, r102, Boolean.FALSE);
        return;
    L42:
        return;
    L22:
        if (r103.size() < r106.intValue()) goto L27;
        tt5.a.h(SuggestChatterAdapter.y2(), "chatter itemView onClicked reach max limit");
        Function4<? super List<? extends D>, ? super D, ? super D, ? super Boolean, Unit> r108 = this.f207623c.f207552f;
        if (r108 == 0) goto L39;
        r108.invoke(r103, null, r102, Boolean.TRUE);
        return;
    L39:
        return;
    L31:
        if (this.f207624d.f207558d.isChecked() == true) goto L35;
        r103.add(r102);
        Function4<? super List<? extends D>, ? super D, ? super D, ? super Boolean, Unit> r109 = this.f207623c.f207552f;
        if (r109 == 0) goto L44;
        r109.invoke(r103, r102, r102, Boolean.FALSE);
        return;
    L44:
        return;
    L35:
        Function4<? super List<? extends D>, ? super D, ? super D, ? super Boolean, Unit> r110 = this.f207623c.f207552f;
        if (r110 == 0) goto L46;
        r110.invoke(r103, null, r102, Boolean.FALSE);
        return;
    L46:
        return;
    L9:
        r102 = null;
        goto L10
    L5:
        r101 = null;
        goto L7
    }

    public v(SuggestChatterAdapter<IChatterEntity> r100, SuggestChatterViewHolder r101) {
        this.f207623c = r100;
        this.f207624d = r101;
    }
}
