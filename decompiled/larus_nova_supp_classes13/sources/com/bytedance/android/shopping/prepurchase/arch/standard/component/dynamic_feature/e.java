package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.anchorv4.helper.SlcTemplateViewHelper;
import java.util.Map;
import ti.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface e {
    l a(Context r1, String r2, FrameLayout r3, Map<String, ? extends Object> r4);

    SlcTemplateViewHelper b();

    View c(c r1, String r2);

    void d(com.bytedance.android.ecom.arch.slice.g r1, IAction r2, c r3);
}
