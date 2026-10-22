package com.bytedance.android.shopping.widget.rittag;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/content/Context;", "p1", "Lcom/bytedance/android/shopping/widget/rittag/viewimpl/a;", "invoke", "(Landroid/content/Context;)Lcom/bytedance/android/shopping/widget/rittag/viewimpl/a;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class RitTagViewFactory$elementGenerators$2 extends FunctionReferenceImpl implements Function1<Context, com.bytedance.android.shopping.widget.rittag.viewimpl.a> {
    public static final RitTagViewFactory$elementGenerators$2 INSTANCE = null;

    static {
        INSTANCE = new RitTagViewFactory$elementGenerators$2();
    }

    public RitTagViewFactory$elementGenerators$2() {
        super(1, com.bytedance.android.shopping.widget.rittag.viewimpl.a.class, "<init>", "<init>(Landroid/content/Context;)V", 0);
    }

    public final com.bytedance.android.shopping.widget.rittag.viewimpl.a invoke(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        return new com.bytedance.android.shopping.widget.rittag.viewimpl.a(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Context) r1);
    }
}
