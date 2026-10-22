package com.bytedance.android.shopping.card_list.slice.viewmanagers;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.shopping.card_list.slice.widgets.CircleLoadingView;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends BaseSlcViewManager<CircleLoadingView> {
    public final void H0(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "props");
    }

    public final void I0(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "styles");
    }

    public c(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public final View A0(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return new CircleLoadingView(r5, null, 6, 0);
    }
}
