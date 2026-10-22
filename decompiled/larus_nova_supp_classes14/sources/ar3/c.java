package ar3;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.home.tab.WindowHybridTabViewModel;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.utils.vane.WindowVaneConfigEnum;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends d {
    @Override // ar3.d
    public final WindowVaneConfigEnum b() {
        return WindowVaneConfigEnum.SEARCH_VANE;
    }

    @Override // ar3.d
    public final boolean c(WindowV2ProductItemVO r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "itemVO");
        Intrinsics.checkNotNullParameter(r6, "categoryId");
        com.bytedance.android.window.shop.repository.tab.entity.f r7 = d.a(r5);
        if (r7 != null) goto L5;
        return false;
    L5:
        WindowHybridTabViewModel r0 = this.c;
        WindowHybridTabViewModel.Companion.getClass();
        Function2 r1 = (Function2) r0.getExtension(WindowHybridTabViewModel.access$getDYNAMIC_CARD_CHECKER$cp());
        if (r1 == null) goto L24;
        Lazy r2 = ECSettingKeys.a;
        int r3 = p.a;
        Object r4 = 0;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L12
        jj4.b r9 = jj4.b.b;     // Catch: Throwable -> L12
        Object r10 = jj4.a.a("window_dynamic_insert_card_gap", Integer.class, r4, false);     // Catch: Throwable -> L12
        if (r10 != null) goto L19;
        Intrinsics.throwNpe();     // Catch: Throwable -> L12
    L19:
        if (((Boolean) r1.invoke(r7, Integer.valueOf(((Number) r10).intValue()))).booleanValue() == true) goto L25;
        return true;
    L25:
        return false;
    L12:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Object r12 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r12) == true) goto L17;
        r4 = r12;
    L17:
        r10 = r4;
        goto L19
    L24:
        return false;
    }

    public c(Fragment r2, ECWindowViewModel r3, WindowHybridTabViewModel r4) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        Intrinsics.checkNotNullParameter(r4, "tabViewModel");
        super(r2, r3, r4);
    }
}
