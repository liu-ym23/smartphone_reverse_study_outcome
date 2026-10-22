package com.bytedance.ee.bear.lynx.impl.lynxview;

import com.bytedance.ee.util.ui.n;
import com.bytedance.lark.lynxlib.widget.udtabs.LynxTabBarView;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\tH\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/lynx/impl/lynxview/CCMLynxTabbarView;", "Lcom/bytedance/lark/lynxlib/widget/udtabs/LynxTabBarView;", "lynxContext", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "setBackgroundColor", "", "backgroundColor", "", "setLeftOffset", "leftOffset", "features-lynx-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CCMLynxTabbarView extends LynxTabBarView {
    public CCMLynxTabbarView(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxContext");
        super(r2);
    }

    public final void setBackgroundColor(int r3) {
        getView().setBackground(null);
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.setBackgroundColor(r3);
    }

    @LynxProp(name = "left-offset")
    public final void setLeftOffset(int r5) {
        getView().setPadding(n.d(r5), getView().getPaddingTop(), getView().getPaddingRight(), getView().getPaddingBottom());
    }
}
