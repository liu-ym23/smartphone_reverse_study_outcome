package com.bytedance.android.shopping.deepfeed.slice.view.viewpage;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.elements.viewpager.SlcViewPager2ItemData;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends com.bytedance.android.ecom.arch.slice.render.elements.viewpager.b {
    public a J3;
    public long K3;
    public long L3;
    public boolean M3;
    public boolean N3;
    public b O3;

    public final void r1() {
        if (this.N3 == true) goto L5;
    L30:
        a r0 = this.J3;
        if (r0 == null) goto L36;
        r0.b();
        return;
    L36:
        return;
    L5:
        if (this.M3 == false) goto L30;
        if (this.L3 > 0) goto L9;
    L13:
        boolean r1 = false;
    L14:
        if (r1 == false) goto L30;
        a r2 = this.J3;
        if (r2 != null) goto L18;
    L20:
        if (r2 == null) goto L22;
        long r3 = this.L3;
        long r4 = this.K3;
        r2.d = r3;
        r2.e = r4;
    L22:
        if (r2 == null) goto L24;
        r2.b();
    L24:
        a r5 = this.J3;
        if (r5 == null) goto L34;
        q1();
        if (r5.c == true) goto L37;
        r5.a.removeCallbacksAndMessages(null);
        r5.a();
        return;
    L37:
        return;
    L34:
        return;
    L18:
        if (r2.b != true) goto L20;
        return;
    L9:
        if (this.K3 <= 0) goto L13;
        if (q1() <= 1) goto L13;
        r1 = true;
        goto L14
    }

    public final int q1() {
        RecyclerView.Adapter r0 = l1().getAdapter();
        if ((r0 instanceof DeepFeedViewPageAdapter) == true) goto L5;
        r0 = null;
    L5:
        DeepFeedViewPageAdapter r1 = (DeepFeedViewPageAdapter) r0;
        if (r1 == null) goto L10;
        List<SlcViewPager2ItemData> r2 = r1.a;
        if (r2 == null) goto L10;
        return r2.size();
    L10:
        return 0;
    }

    public c(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "templateContext");
        super(r2);
    }

    public final void H0(Map<String, ? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r6, "props");
        Object r0 = r6.get("duration");
        Object r2 = null;
        if ((r0 instanceof Double) == true) goto L5;
        r0 = null;
    L5:
        Double r1 = (Double) r0;
        long r3 = 0;
        if (r1 == null) goto L8;
        long r4 = (long) r1.doubleValue();
    L9:
        this.K3 = r4;
        Object r5 = r6.get("interval");
        if ((r5 instanceof Double) == true) goto L12;
        r5 = null;
    L12:
        Double r7 = (Double) r5;
        if (r7 == null) goto L15;
        r3 = (long) r7.doubleValue();
    L15:
        this.L3 = r3;
        Object r8 = r6.get("autoPlay");
        if ((r8 instanceof Boolean) == true) goto L18;
        r8 = null;
    L18:
        Boolean r9 = (Boolean) r8;
        if (r9 == null) goto L21;
        boolean r10 = r9.booleanValue();
    L22:
        this.M3 = r10;
        Object r11 = r6.get("visible");
        if ((r11 instanceof Boolean) == false) goto L26;
        r2 = r11;
    L26:
        Boolean r12 = (Boolean) r2;
        if (r12 == null) goto L29;
        boolean r13 = r12.booleanValue();
    L30:
        this.N3 = r13;
        if (q1() <= 1) goto L34;
        r1();
        return;
    L34:
        return;
    L29:
        r13 = true;
        goto L30
    L21:
        r10 = false;
        goto L22
    L8:
        r4 = 0;
        goto L9
    }

    public final /* bridge */ /* synthetic */ View n1(Context r1) {
        return o1(r1);
    }

    public final ViewPager2 o1(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        ViewPager2 r0 = new ViewPager2(r4);
        r0.setOrientation(1);
        r0.setPageTransformer(new DeepFeedCrossFadePageTransformer());
        this.J3 = new a(r0);
        b r5 = new b(this);
        this.O3 = r5;
        Object r1 = ((BaseSlcViewManager) this).a.o(com.bytedance.android.shopping.deepfeed.slice.service.b.class);
        if ((r1 instanceof com.bytedance.android.shopping.deepfeed.slice.service.b) == true) goto L5;
        r1 = null;
    L5:
        com.bytedance.android.shopping.deepfeed.slice.service.b r2 = (com.bytedance.android.shopping.deepfeed.slice.service.b) r1;
        if (r2 == null) goto L8;
        r2.K(r5);
    L8:
        return r0;
    }

    public final void p1(List<SlcViewPager2ItemData> r6) {
        Intrinsics.checkNotNullParameter(r6, "dataList");
        RecyclerView.Adapter r0 = l1().getAdapter();
        if ((r0 instanceof DeepFeedViewPageAdapter) == true) goto L5;
        r0 = null;
    L5:
        DeepFeedViewPageAdapter r1 = (DeepFeedViewPageAdapter) r0;
        if (r1 != null) goto L9;
        r1 = new DeepFeedViewPageAdapter(((BaseSlcViewManager) this).a);
    L9:
        if ((!Intrinsics.areEqual(l1().getAdapter(), r1)) == false) goto L11;
        l1().setAdapter(r1);
        boolean r2 = true;
    L12:
        Intrinsics.checkNotNullParameter(r6, "data");
        r1.a = r6;
        r1.notifyDataSetChanged();
        if (r2 == true) goto L15;
    L17:
        boolean r3 = false;
    L18:
        if (r3 == true) goto L20;
    L22:
        l1().requestTransform();
        r1();
        if (r6.size() > 1) goto L25;
        l1().setUserInputEnabled(false);
        return;
    L25:
        l1().setUserInputEnabled(true);
        return;
    L20:
        if (q1() <= 0) goto L22;
        l1().setCurrentItem(1073741823 - (1073741823 % q1()), false);
        goto L22
    L15:
        if ((!r6.isEmpty()) == false) goto L17;
        r3 = true;
        goto L18
    L11:
        r2 = false;
        goto L12
    }
}
