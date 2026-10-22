package gr3;

import androidx.fragment.app.Fragment;
import com.bytedance.android.window.shop.home.BaseWindowTabViewModel;
import com.bytedance.android.window.shop.home.tab.WindowHybridTabViewModel;
import com.bytedance.android.window.shop.home.tab.WindowTabViewModel;
import com.bytedance.android.window.shop.home.tab.common.WindowConstDef;
import com.bytedance.android.window.shop.secondary.ECWindowSecondaryPageActivity;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public static final BaseWindowTabViewModel a(QContext r1, Fragment r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$getWindowTabViewModel");
        Intrinsics.checkNotNullParameter(r2, "fragment");
        if ((r2.getActivity() instanceof ECWindowSecondaryPageActivity) == false) goto L7;
        r1.getClass();
        return QContext.h(WindowTabViewModel.class, r2);
    L7:
        if (WindowConstDef.b == false) goto L9;
        r1.getClass();
        return QContext.h(WindowHybridTabViewModel.class, r2);
    L9:
        r1.getClass();
        return QContext.h(WindowTabViewModel.class, r2);
    }
}
