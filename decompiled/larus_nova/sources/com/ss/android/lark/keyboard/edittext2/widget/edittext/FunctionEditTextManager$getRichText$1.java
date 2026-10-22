package com.ss.android.lark.keyboard.edittext2.widget.edittext;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.keyboard.edittext2.edittors.richText.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/keyboard/edittext2/edittors/richText/RichTextGenerator;", "it", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class FunctionEditTextManager$getRichText$1 extends Lambda implements Function2<d, d, Unit> {
    public static final FunctionEditTextManager$getRichText$1 INSTANCE = null;

    static {
        INSTANCE = new FunctionEditTextManager$getRichText$1();
    }

    public FunctionEditTextManager$getRichText$1() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(d r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$copy");
        Intrinsics.checkNotNullParameter(r101, "it");
        r100.f429101a = true;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(d r100, d r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
