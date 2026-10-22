package com.bytedance.android.shopping.store.slicecard.viewmanager;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.store.view.ECShopProgressBarView;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m extends com.bytedance.android.ecom.arch.slice.render.elements.b<ECShopProgressBarView> {

    public static final class a {
    }

    static {
    }

    public final void H0(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "props");
    }

    public m(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public final View n1(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new ECShopProgressBarView(r2);
    }
}
