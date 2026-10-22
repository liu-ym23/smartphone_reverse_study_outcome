package com.bytedance.android.shopping.deepfeed.slice.view.customview;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends com.bytedance.android.ecom.arch.slice.render.elements.b<b> {
    public final void H0(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "props");
    }

    public a(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "templateContext");
        super(r2);
    }

    public final View n1(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new b(r2);
    }
}
