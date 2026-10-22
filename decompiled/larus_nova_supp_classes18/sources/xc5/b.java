package xc5;

import ad5.e;
import android.content.Context;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import net.lucode.hackware.magicindicator.MagicIndicator;
import xuc.c;
import xuc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class b extends xuc.a {
    public final int b;
    public final List<e> c;
    public final MagicIndicator d;
    public final InterfaceC0330b e;

    public class a extends jp5.a {
        public a(Context r1) {
            super(r1);
        }

        @Override // jp5.a
        public final void onPageScrolled(int r1, float r2, int r3) {
            super.onPageScrolled(r1, 0.0f, r3);
        }
    }

    /* JADX INFO: renamed from: xc5.b$b, reason: collision with other inner class name */
    public interface InterfaceC0330b {
        void a(int r1);
    }

    public final int a() {
        return this.c.size();
    }

    public c b(Context r4) {
        a r0 = new a(r4);
        r0.setMode(1);
        r0.setColors(new Integer[]{Integer.valueOf(this.b)});
        r0.setLineHeight(n.d(2));
        return r0;
    }

    public int d(Context r2) {
        return r2.getResources().getColor(2131105548);
    }

    public int e(Context r2) {
        return r2.getResources().getColor(2131106607);
    }

    public final void f(int r4) {
        this.d.a(r4, 0.0f, 0);
        this.d.b(r4);
        if (this.e == null) goto L6;
        e r0 = (e) hu5.a.b(this.c, r4);
        this.e.a(r4);
        return;
    }

    public d c(Context r8, final int r9) {
        avc.a r6 = new com.bytedance.ee.bear.widgets.b(r8, d(r8), e(r8), r8.getString(((e) ListProtector.get(this.c, r9)).b), new xc5.a(this, r9));
        r6.setMaxLines(1);
        return r6;
    }

    public b(Context r1, MagicIndicator r2, List<e> r3, InterfaceC0330b r4) {
        this.c = r3;
        this.d = r2;
        this.e = r4;
        this.b = r1.getResources().getColor(2131105548);
    }
}
