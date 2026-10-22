package com.lynx.xelement.input;

import com.lynx.tasm.behavior.LynxBehavior;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxGeneratorName;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@LynxBehavior(isCreateAsync = false, needProcessDirection = true, tagName = {"x-textarea-ng"})
@LynxGeneratorName(packageName = "com.lynx.xelement.input")
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/lynx/xelement/input/LynxUITextAreaNG;", "Lcom/lynx/xelement/input/LynxUITextArea;", "Input_release"}, k = 1, mv = {1, 6, 0})
public final class LynxUITextAreaNG extends LynxUITextArea {
    public LynxUITextAreaNG(LynxContext r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }
}
