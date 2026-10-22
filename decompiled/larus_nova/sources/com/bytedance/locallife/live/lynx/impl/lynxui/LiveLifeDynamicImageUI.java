package com.bytedance.locallife.live.lynx.impl.lynxui;

import android.content.Context;
import android.view.View;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/locallife/live/lynx/impl/lynxui/LiveLifeDynamicImageUI;", "Lcom/lynx/tasm/behavior/ui/view/UISimpleView;", "Lcom/bytedance/locallife/live/lynx/impl/lynxui/LiveLifeDynamicImage;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class LiveLifeDynamicImageUI extends UISimpleView<LiveLifeDynamicImage> {
    public LiveLifeDynamicImageUI(LynxContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new LiveLifeDynamicImage(r100, null, 6, 0);
    }
}
