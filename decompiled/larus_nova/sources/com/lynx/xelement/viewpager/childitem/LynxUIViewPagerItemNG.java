package com.lynx.xelement.viewpager.childitem;

import com.lynx.tasm.behavior.LynxBehavior;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxGeneratorName;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@LynxBehavior(isCreateAsync = true, tagName = {LynxViewpagerItem.X_ELEMENT_TAG})
@LynxGeneratorName(packageName = "com.lynx.xelement.viewpager.childitem")
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/lynx/xelement/viewpager/childitem/LynxUIViewPagerItemNG;", "Lcom/lynx/xelement/viewpager/childitem/LynxViewpagerItem;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/lynx/tasm/behavior/LynxContext;", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "params", "", "(Lcom/lynx/tasm/behavior/LynxContext;Ljava/lang/Object;)V", "ViewPager_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class LynxUIViewPagerItemNG extends LynxViewpagerItem {
    public LynxUIViewPagerItemNG(LynxContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public LynxUIViewPagerItemNG(LynxContext r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }
}
