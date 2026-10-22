package com.bytedance.ee.bear.bitable.filter.step.impl.valueedit;

import com.bytedance.ee.bear.bitable.common.widgets.item.BitableSelectorItemView;
import com.bytedance.ee.bear.bitable.filter.model.EFilterDuration;
import com.bytedance.ee.bear.bitable.filter.model.FilterOptions;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;
import kotlin.Pair;

/* JADX INFO: loaded from: classes15.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DateFilterValueEditViewHolder f211989a;

    public e(DateFilterValueEditViewHolder r100) {
        this.f211989a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        FilterOptions.DurationOption[] r111 = (FilterOptions.DurationOption[]) r110;
        DateFilterValueEditViewHolder r100 = this.f211989a;
        r100.getClass();
        if (r111 != null) goto L5;
    L11:
        boolean r101 = true;
    L12:
        if (r101 == true) goto L29;
        Pair<? extends EFilterDuration, Long> r102 = r100.f211943o;
        if (r102 == null) goto L18;
        EFilterDuration r103 = r102.getFirst();
        if (r103 == null) goto L18;
    L19:
        r100.f211944p = r103;
        int r104 = r111.length;
        int r105 = 0;
    L20:
        if (r105 >= r104) goto L33;
        FilterOptions.DurationOption r106 = r111[r105];
        EFilterDuration.a r107 = EFilterDuration.Companion;
        String r108 = r106.getValue();
        r107.getClass();
        EFilterDuration r109 = EFilterDuration.a.a(r108);
        boolean r112 = gs4.a.a(r109);
        if (r109 != r100.f211944p) goto L24;
        boolean r113 = true;
    L25:
        BitableSelectorItemView r114 = new BitableSelectorItemView(r100.f211972a, null, 6, 0);
        BitableSelectorItemView.f(r114, r106.getText());
        r114.setSelected(r113);
        if (r112 == false) goto L28;
        r114.d(R.drawable.ud_icon_right_bold_outlined, null);
    L28:
        r114.setOnItemClickListener(new g(r100, r109, r112));
        r100.f211940l.addView(r114);
        r105 = r105 + 1;
        goto L20
    L24:
        r113 = false;
        goto L25
    L33:
        return;
    L18:
        EFilterDuration.a r115 = EFilterDuration.Companion;
        String r116 = r111[0].getValue();
        r115.getClass();
        r103 = EFilterDuration.a.a(r116);
        goto L19
    L29:
        return;
    L5:
        if (r111.length != 0) goto L7;
        boolean r117 = true;
    L8:
        if (r117 == true) goto L11;
        r101 = false;
        goto L12
    L7:
        r117 = false;
        goto L8
    }
}
