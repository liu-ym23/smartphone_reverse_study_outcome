package com.bytedance.ee.bear.bitable.core.infoarch.arch;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.BitableNativeViewContainer;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class j {
    public static final BitableNativeViewContainer a(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "parentView");
        BitableNativeViewContainer r102 = new BitableNativeViewContainer(r100, null);
        r102.setId(R.id.bitable_native_view_container);
        r101.addView(r102, new ViewGroup.LayoutParams(-1, -1));
        return r102;
    }
}
