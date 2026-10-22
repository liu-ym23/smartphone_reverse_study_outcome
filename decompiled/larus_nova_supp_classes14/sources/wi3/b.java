package wi3;

import android.content.Context;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.core.utils.n1;
import com.bytedance.android.ec.core.utils.y0;
import com.bytedance.android.ec.store.common.headlive.StoreV3LiveRoomVO;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.e0;
import com.bytedance.android.shopping.store.home.entity.i;
import com.bytedance.android.shopping.store.home.entity.n;
import com.bytedance.android.shopping.store.home.presenter.e4;
import com.bytedance.android.shopping.store.home.presenter.y3;
import com.bytedance.android.shopping.store.repository.vo.ShopHeaderVideoInfoVO;
import com.bytedance.android.shopping.store.repository.vo.ShopHeaderVideoVO;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.android.shopping.store.viewmodel.ShopFrameworkType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements y3 {
    public final Context a;

    public final Context getContext() {
        return this.a;
    }

    public b(Context r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.store.home.presenter.y3
    public final e4 a(ECStoreParam r7, n r8) {
        Intrinsics.checkNotNullParameter(r7, "ecStoreParam");
        Intrinsics.checkNotNullParameter(r8, "headerInfo");
        boolean r1 = true;
        boolean r2 = false;
        if (r7.isCroppedStyle() == true) goto L10;
        ECStoreViewModel.Companion.getClass();
        if (ECStoreViewModel.a.a(r8, r7) == true) goto L10;
        if (ECStoreViewModel.a.b(r8, r7) == true) goto L10;
        boolean r0 = false;
    L12:
        if (r8.a() != ShopFrameworkType.MIDDLE_TAB.getType()) goto L14;
        int r3 = 0;
    L16:
        if (r7.isCroppedStyle() == false) goto L18;
        n1.i.getClass();
        int r9 = n1.a.b();
        int r10 = 4;
    L59:
        return new e4(r0, r9, r10, r1);
    L18:
        i r4 = r8.g;
        if (r4 == null) goto L21;
        StoreV3LiveRoomVO r5 = r4.a;
    L22:
        if (r5 != null) goto L24;
    L26:
        boolean r6 = false;
    L28:
        if (r6 == true) goto L30;
    L32:
        i r11 = r8.g;
        if (r11 == null) goto L41;
        ShopHeaderVideoVO r12 = r11.b;
        if (r12 == null) goto L41;
        List<ShopHeaderVideoInfoVO> r13 = r12.getFeedData();
        if (r13 == null) goto L41;
        if ((!r13.isEmpty()) != true) goto L41;
        boolean r14 = true;
    L42:
        if (r14 == true) goto L44;
    L47:
        n1.i.getClass();
        int r15 = n1.a.c() - k1.p();
        if (r8.d() == false) goto L57;
        int r16 = e0.a;
        if (ECShopABSettings.k.getEC_SHOP_HEADER_UI_OPT() < 1) goto L52;
        boolean r17 = true;
    L53:
        if (r17 == false) goto L57;
        if (r7.isCroppedStyle() == true) goto L57;
        r2 = true;
        goto L57
    L52:
        r17 = false;
    L57:
        r9 = r15;
        r0 = r2;
        r10 = 3;
        goto L59
    L44:
        if (r8.d() == true) goto L47;
        n1.i.getClass();
        int r18 = (n1.a.c() - c.a(2131166416, this.a)) - r3;
        int r19 = k1.f(l0.c(this.a));
    L46:
        r9 = r18 - r19;
        r10 = 3;
        r1 = false;
    L41:
        r14 = false;
        goto L42
    L30:
        if (r8.d() == true) goto L32;
        n1.i.getClass();
        r18 = ((n1.a.c() - c.a(2131166434, this.a)) - r3) + c.a(2131166412, this.a);
        r19 = k1.f(l0.c(this.a));
        goto L46
    L24:
        if (y0.a() == false) goto L26;
        r6 = true;
        goto L28
    L21:
        r5 = null;
        goto L22
    L14:
        r3 = c.a(2131166411, this.a);
    L10:
        r0 = true;
        goto L12
    }
}
