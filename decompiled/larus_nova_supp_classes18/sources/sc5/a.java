package sc5;

import android.content.Context;
import android.content.res.Resources;
import com.bytedance.ee.util.ui.n;
import java.util.List;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends xc5.b {

    /* JADX INFO: renamed from: sc5.a$a, reason: collision with other inner class name */
    public static final class C0303a extends jp5.a {
        public C0303a(Context r1) {
            super(r1);
        }

        @Override // jp5.a
        public final void onPageScrolled(int r1, float r2, int r3) {
            super.onPageScrolled(r1, 0.0f, r3);
        }
    }

    @Override // xc5.b
    public final xuc.c b(Context r5) {
        C0303a r0 = new C0303a(r5);
        r0.setMode(0);
        Integer[] r2 = new Integer[1];
        if (r5 == null) goto L7;
        Resources r6 = r5.getResources();
        if (r6 == null) goto L7;
        int r7 = r6.getColor(2131105548);
    L8:
        r2[0] = Integer.valueOf(r7);
        r0.setColors(r2);
        r0.setLineHeight(n.d(2));
        return r0;
    L7:
        r7 = 0;
        goto L8
    }

    public a(MagicIndicator r1, List<? extends ad5.e> r2, Context r3, b r4) {
        super(r3, r1, r2, r4);
    }
}
