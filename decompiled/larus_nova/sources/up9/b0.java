package up9;

import androidx.viewpager2.widget.ViewPager2;
import com.larus.photopicker.v2.impl.viewmodel.BottomSheetViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b0 extends v {
    @Override // up9.i0
    public final void h(ViewPager2 r100) {
        Intrinsics.checkNotNullParameter(r100, "viewPager");
        r100.setUserInputEnabled(true);
    }

    public b0(BottomSheetViewModel r100, boolean r101) {
        super(r100, r101);
    }

    @Override // up9.i0
    public final void j(ViewPager2 r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "viewPager");
        if (r102 == true) goto L7;
        if (r101 == true) goto L7;
        boolean r103 = false;
    L8:
        v.p(this, r100, r103);
        return;
    L7:
        r103 = true;
        goto L8
    }
}
