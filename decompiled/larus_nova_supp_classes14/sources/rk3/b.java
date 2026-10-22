package rk3;

import com.bytedance.android.shopping.store.tabkit.view.ECTabKitView;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends com.lynx.tasm.behavior.a {
    public b() {
        super("tabkit-view");
    }

    public final LynxUI<?> createUI(LynxContext r2) {
        return new ECTabKitView(r2);
    }
}
