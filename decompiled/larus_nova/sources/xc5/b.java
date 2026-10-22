package xc5;

import ad5.e;
import android.content.Context;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.List;
import net.lucode.hackware.magicindicator.MagicIndicator;
import xuc.c;
import xuc.d;

/* JADX INFO: loaded from: classes18.dex */
public class b extends xuc.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f563215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<e> f563216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MagicIndicator f563217d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final InterfaceC8214b f563218e;

    public class a extends jp5.a {
        public a(Context r100) {
            super(r100);
        }

        @Override // jp5.a, xuc.c
        public final void onPageScrolled(int r100, float r101, int r102) {
            super.onPageScrolled(r100, 0.0f, r102);
        }
    }

    /* JADX INFO: renamed from: xc5.b$b, reason: collision with other inner class name */
    public interface InterfaceC8214b {
        void a(int r100);
    }

    @Override // xuc.a
    public final int a() {
        return this.f563216c.size();
    }

    @Override // xuc.a
    public c b(Context r100) {
        a r101 = new a(r100);
        r101.setMode(1);
        r101.setColors(new Integer[]{Integer.valueOf(this.f563215b)});
        r101.setLineHeight(n.d(2));
        return r101;
    }

    public int d(Context r100) {
        return r100.getResources().getColor(R.color.primary_fill_default);
    }

    public int e(Context r100) {
        return r100.getResources().getColor(R.color.text_caption);
    }

    public final void f(int r100) {
        this.f563217d.a(r100, 0.0f, 0);
        this.f563217d.b(r100);
        if (this.f563218e == null) goto L6;
        e r101 = (e) hu5.a.b(this.f563216c, r100);
        this.f563218e.a(r100);
        return;
    }

    @Override // xuc.a
    public d c(Context r100, final int r101) {
        com.bytedance.ee.bear.widgets.b r102 = new com.bytedance.ee.bear.widgets.b(r100, d(r100), e(r100), r100.getString(((e) ListProtector.get(this.f563216c, r101)).f3019b), new xc5.a(this, r101));
        r102.setMaxLines(1);
        return r102;
    }

    public b(Context r100, MagicIndicator r101, List<e> r102, InterfaceC8214b r103) {
        this.f563216c = r102;
        this.f563217d = r101;
        this.f563218e = r103;
        this.f563215b = r100.getResources().getColor(R.color.primary_fill_default);
    }
}
