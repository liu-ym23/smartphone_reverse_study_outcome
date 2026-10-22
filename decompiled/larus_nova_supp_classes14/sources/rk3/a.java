package rk3;

import com.bytedance.android.shopping.store.tabkit.view.ECTabKitView;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends com.lynx.tasm.behavior.a {
    public a() {
        super("tabkit-view");
    }

    public final LynxUI<?> createUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new ECTabKitView(r2);
    }
}
