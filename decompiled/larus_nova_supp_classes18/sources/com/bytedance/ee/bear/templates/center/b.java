package com.bytedance.ee.bear.templates.center;

import android.content.Context;
import android.content.res.Resources;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends xuc.a {
    public final MagicIndicator b;
    public final int c;
    public final int d;
    public final int e;
    public final List<Tab2> f;
    public final InterfaceC0184b g;

    public class a extends jp5.a {
        public a(Context r1) {
            super(r1);
        }

        @Override // jp5.a
        public final void onPageScrolled(int r1, float r2, int r3) {
            super.onPageScrolled(r1, 0.0f, r3);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.templates.center.b$b, reason: collision with other inner class name */
    public interface InterfaceC0184b {
        void h0(int r1, Tab2 r2);
    }

    public final int a() {
        return this.f.size();
    }

    public final xuc.c b(Context r4) {
        a r0 = new a(r4);
        r0.setMode(1);
        r0.setColors(new Integer[]{Integer.valueOf(this.e)});
        r0.setLineHeight(n.d(2));
        return r0;
    }

    public final void d(int r4) {
        int r2 = 0;
        this.b.a(r4, 0.0f, 0);
        this.b.b(r4);
        if (this.g != null) goto L5;
        return;
    L5:
        if (this.f.size() <= 0) goto L13;
        List<Tab2> r0 = this.f;
        if (r4 >= r0.size()) goto L10;
        r2 = r4;
    L10:
        Tab2 r1 = (Tab2) ListProtector.get(r0, r2);
        this.g.h0(r4, r1);
        return;
    }

    public final xuc.d c(Context r8, final int r9) {
        avc.a r6 = new com.bytedance.ee.bear.widgets.b(r8, this.c, this.d, r8.getString(((Tab2) ListProtector.get(this.f, r9)).getValue()), new com.bytedance.ee.bear.templates.center.a(this, r9));
        int r10 = vuc.b.a(r8, 4.0d);
        r6.setPadding(r10, 0, r10, 0);
        return r6;
    }

    public b(FragmentActivity r1, MagicIndicator r2, List r3, InterfaceC0184b r4) {
        this.b = r2;
        this.f = r3;
        this.g = r4;
        Resources r5 = r1.getResources();
        this.c = r5.getColor(2131105548);
        this.d = r5.getColor(2131106607);
        this.e = r5.getColor(2131105548);
    }
}
