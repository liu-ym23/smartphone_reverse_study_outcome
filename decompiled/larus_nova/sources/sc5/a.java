package sc5;

import android.content.Context;
import android.content.res.Resources;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import java.util.List;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends xc5.b {

    /* JADX INFO: renamed from: sc5.a$a, reason: collision with other inner class name */
    public static final class C7596a extends jp5.a {
        public C7596a(Context r100) {
            super(r100);
        }

        @Override // jp5.a, xuc.c
        public final void onPageScrolled(int r100, float r101, int r102) {
            super.onPageScrolled(r100, 0.0f, r102);
        }
    }

    @Override // xc5.b, xuc.a
    public final xuc.c b(Context r100) {
        C7596a r101 = new C7596a(r100);
        r101.setMode(0);
        Integer[] r102 = new Integer[1];
        if (r100 == null) goto L7;
        Resources r103 = r100.getResources();
        if (r103 == null) goto L7;
        int r104 = r103.getColor(R.color.primary_fill_default);
    L8:
        r102[0] = Integer.valueOf(r104);
        r101.setColors(r102);
        r101.setLineHeight(n.d(2));
        return r101;
    L7:
        r104 = 0;
        goto L8
    }

    public a(MagicIndicator r100, List<? extends ad5.e> r101, Context r102, b r103) {
        super(r102, r100, r101, r103);
    }
}
