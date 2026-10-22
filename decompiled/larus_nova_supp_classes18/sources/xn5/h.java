package xn5;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.bizwidget.banner.adapter.BannerAdapter;
import com.bytedance.ee.bear.bizwidget.banner.banner.Banner;
import com.bytedance.ee.bear.templates.banner.BannerData;
import com.bytedance.ee.bear.templates.banner.TemplateBannerAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h<T> implements Observer {
    public final /* synthetic */ g a;

    public h(g r1) {
        this.a = r1;
    }

    public final void onChanged(Object r11) {
        sbb.e r12 = (sbb.e) r11;
        Banner<Void, TemplateBannerAdapter> r0 = this.a.d;
        List<BannerData> r1 = null;
        if (r0 == null) goto L5;
        TemplateBannerAdapter r2 = (TemplateBannerAdapter) r0.getAdapter();
    L7:
        if (Intrinsics.areEqual(r12, sbb.e.e) == false) goto L18;
        Banner<Void, TemplateBannerAdapter> r13 = this.a.d;
        if (r13 == null) goto L11;
        r13.setVisibility(0);
    L11:
        if (r2 == null) goto L16;
        List r14 = r2.e;
        if (r14 != null) goto L15;
        r14 = new ArrayList();
    L15:
        ((BannerAdapter) r2).a = r14;
    L16:
        if (r2 == null) goto L48;
        r2.notifyDataSetChanged();
        return;
    L48:
        return;
    L18:
        if (r2 == null) goto L20;
        r1 = r2.e;
    L20:
        if (r1 == null) goto L41;
        List<BannerData> r3 = r2.e;
        Intrinsics.checkNotNull(r3);
        ArrayList r4 = new ArrayList();
        int r5 = r3.size();
        int r6 = 0;
    L22:
        boolean r7 = true;
        if (r6 >= r5) goto L36;
        BannerData r8 = (BannerData) ListProtector.get(r3, r6);
        if (r8 == null) goto L31;
        List<Integer> r9 = r8.getObj_type_list();
        if (r9 == null) goto L31;
        if (r9.contains(Integer.valueOf(r12.b)) != true) goto L31;
    L32:
        if (r7 == false) goto L34;
        r4.add(r8);
    L34:
        r6 = r6 + 1;
    L31:
        r7 = false;
        goto L32
    L36:
        if ((!r4.isEmpty()) == false) goto L41;
        Banner<Void, TemplateBannerAdapter> r15 = this.a.d;
        if (r15 == null) goto L40;
        r15.setVisibility(0);
    L40:
        ((BannerAdapter) r2).a = r4;
        r2.notifyDataSetChanged();
        return;
    L41:
        Banner<Void, TemplateBannerAdapter> r16 = this.a.d;
        if (r16 == null) goto L51;
        r16.setVisibility(8);
        return;
    L51:
        return;
    L5:
        r2 = null;
        goto L7
    }
}
