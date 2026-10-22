package ar3;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.home.tab.WindowHybridTabViewModel;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.utils.vane.WindowVaneConfigEnum;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class d {
    public final LifecycleOwner a;
    public final ECWindowViewModel b;
    public final WindowHybridTabViewModel c;

    public abstract WindowVaneConfigEnum b();

    public abstract boolean c(WindowV2ProductItemVO r1, String r2);

    public static com.bytedance.android.window.shop.repository.tab.entity.f a(WindowV2ProductItemVO r1) {
        Intrinsics.checkNotNullParameter(r1, "item");
        if (r1 == null) goto L7;
        fo.b r2 = r1.C;
        if (r2 == null) goto L7;
        return (com.bytedance.android.window.shop.repository.tab.entity.f) r2.a(wn.a.D);
    L7:
        return null;
    }

    public d(Fragment r2, ECWindowViewModel r3, WindowHybridTabViewModel r4) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        Intrinsics.checkNotNullParameter(r4, "tabViewModel");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
