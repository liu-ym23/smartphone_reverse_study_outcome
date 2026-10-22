package com.bytedance.android.shopping.widget.rittag;

import android.content.Context;
import com.bytedance.android.shopping.widget.rittag.viewimpl.RitTagTextView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/bytedance/android/shopping/widget/rittag/viewimpl/RitTagTextView;", "p1", "Landroid/content/Context;", "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class RitTagViewFactory$elementGenerators$1 extends FunctionReferenceImpl implements Function1<Context, RitTagTextView> {
    public static final RitTagViewFactory$elementGenerators$1 INSTANCE = null;

    static {
        INSTANCE = new RitTagViewFactory$elementGenerators$1();
    }

    public RitTagViewFactory$elementGenerators$1() {
        super(1, RitTagTextView.class, "<init>", "<init>(Landroid/content/Context;)V", 0);
    }

    public final RitTagTextView invoke(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        return new RitTagTextView(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Context) r1);
    }
}
