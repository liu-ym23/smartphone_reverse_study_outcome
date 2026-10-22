package com.bytedance.ee.bear.templates.center;

import android.content.Context;
import android.content.res.Resources;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.List;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: loaded from: classes18.dex */
public final class b extends xuc.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MagicIndicator f238913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f238914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f238915d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f238916e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<Tab2> f238917f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final InterfaceC3431b f238918g;

    public class a extends jp5.a {
        public a(Context r100) {
            super(r100);
        }

        @Override // jp5.a, xuc.c
        public final void onPageScrolled(int r100, float r101, int r102) {
            super.onPageScrolled(r100, 0.0f, r102);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.templates.center.b$b, reason: collision with other inner class name */
    public interface InterfaceC3431b {
        void h0(int r100, Tab2 r101);
    }

    @Override // xuc.a
    public final int a() {
        return this.f238917f.size();
    }

    @Override // xuc.a
    public final xuc.c b(Context r100) {
        a r101 = new a(r100);
        r101.setMode(1);
        r101.setColors(new Integer[]{Integer.valueOf(this.f238916e)});
        r101.setLineHeight(n.d(2));
        return r101;
    }

    public final void d(int r100) {
        int r101 = 0;
        this.f238913b.a(r100, 0.0f, 0);
        this.f238913b.b(r100);
        if (this.f238918g != null) goto L5;
        return;
    L5:
        if (this.f238917f.size() <= 0) goto L13;
        List<Tab2> r102 = this.f238917f;
        if (r100 >= r102.size()) goto L10;
        r101 = r100;
    L10:
        Tab2 r103 = (Tab2) ListProtector.get(r102, r101);
        this.f238918g.h0(r100, r103);
        return;
    }

    @Override // xuc.a
    public final xuc.d c(Context r100, final int r101) {
        com.bytedance.ee.bear.widgets.b r102 = new com.bytedance.ee.bear.widgets.b(r100, this.f238914c, this.f238915d, r100.getString(((Tab2) ListProtector.get(this.f238917f, r101)).getValue()), new com.bytedance.ee.bear.templates.center.a(this, r101));
        int r103 = vuc.b.a(r100, 4.0d);
        r102.setPadding(r103, 0, r103, 0);
        return r102;
    }

    public b(FragmentActivity r100, MagicIndicator r101, List r102, InterfaceC3431b r103) {
        this.f238913b = r101;
        this.f238917f = r102;
        this.f238918g = r103;
        Resources r104 = r100.getResources();
        this.f238914c = r104.getColor(R.color.primary_fill_default);
        this.f238915d = r104.getColor(R.color.text_caption);
        this.f238916e = r104.getColor(R.color.primary_fill_default);
    }
}
