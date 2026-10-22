package com.lynx.xelement.overlay;

import com.lynx.tasm.behavior.LynxBehavior;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxGeneratorName;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@LynxBehavior(isCreateAsync = false, tagName = {"overlay"})
@LynxGeneratorName(packageName = "com.lynx.xelement.overlay")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/lynx/xelement/overlay/LynxUIOverlayNG;", "Lcom/lynx/xelement/overlay/LynxUIOverlay;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/lynx/tasm/behavior/LynxContext;", "params", "", "(Lcom/lynx/tasm/behavior/LynxContext;Ljava/lang/Object;)V", "Overlay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class LynxUIOverlayNG extends LynxUIOverlay {
    public LynxUIOverlayNG(LynxContext r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }
}
