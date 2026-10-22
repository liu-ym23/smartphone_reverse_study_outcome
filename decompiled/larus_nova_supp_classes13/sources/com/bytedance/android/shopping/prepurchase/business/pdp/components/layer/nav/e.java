package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e {
    public LinearLayout a;
    public FrameLayout b;
    public String c;
    public String d;
    public final Context e;
    public final Map<String, Object> f;
    public final Boolean g;
    public final Function0<Boolean> h;
    public final Function2<View, IAction, Unit> i;

    /* JADX WARN: Multi-variable type inference failed */
    public e(Context r2, Map<String, ? extends Object> r3, Boolean r4, Function0<Boolean> r5, Function2<? super View, ? super IAction, Unit> r6) {
        Intrinsics.checkNotNullParameter(r2, "slcContext");
        Intrinsics.checkNotNullParameter(r5, "collectGetter");
        Intrinsics.checkNotNullParameter(r6, "actionExecutor");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.i = r6;
    }
}
