package com.bytedance.android.window.shop.holder.factory;

import androidx.fragment.app.Fragment;
import com.bytedance.android.window.shop.holder.WindowDynamicHolder;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/fragment/app/Fragment;", "p1", "Lfo/b;", "p2", "Lcom/bytedance/android/window/shop/holder/WindowDynamicHolder;", "invoke", "(Landroidx/fragment/app/Fragment;Lfo/b;)Lcom/bytedance/android/window/shop/holder/WindowDynamicHolder;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowDynamicHolderFactory$windowHolderCreators$1$1 extends FunctionReferenceImpl implements Function2<Fragment, fo.b, WindowDynamicHolder> {
    public WindowDynamicHolderFactory$windowHolderCreators$1$1(WindowDynamicHolderFactory r8) {
        super(2, r8, WindowDynamicHolderFactory.class, "createWindowDynamicHolder", "createWindowDynamicHolder(Landroidx/fragment/app/Fragment;Lcom/bytedance/android/ec/window/base/common/typeddata/WindowTypedDataCache;)Lcom/bytedance/android/window/shop/holder/WindowDynamicHolder;", 0);
    }

    public final WindowDynamicHolder invoke(Fragment r2, fo.b r3) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        Intrinsics.checkNotNullParameter(r3, "p2");
        WindowDynamicHolderFactory r4 = (WindowDynamicHolderFactory) ((CallableReference) this).receiver;
        Lazy r0 = WindowDynamicHolderFactory.a;
        r4.getClass();
        return new WindowDynamicHolder(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Fragment) r1, (fo.b) r2);
    }
}
