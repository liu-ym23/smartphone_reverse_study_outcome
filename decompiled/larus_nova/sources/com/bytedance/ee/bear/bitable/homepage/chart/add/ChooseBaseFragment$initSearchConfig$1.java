package com.bytedance.ee.bear.bitable.homepage.chart.add;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.picker.config.Wiki;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/picker/config/Wiki;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ChooseBaseFragment$initSearchConfig$1 extends Lambda implements Function1<Wiki, Unit> {
    public static final ChooseBaseFragment$initSearchConfig$1 INSTANCE = null;

    static {
        INSTANCE = new ChooseBaseFragment$initSearchConfig$1();
    }

    public ChooseBaseFragment$initSearchConfig$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Wiki r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$wiki");
        r100.filter(AnonymousClass1.INSTANCE);
        r100.extra(AnonymousClass2.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Wiki r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
