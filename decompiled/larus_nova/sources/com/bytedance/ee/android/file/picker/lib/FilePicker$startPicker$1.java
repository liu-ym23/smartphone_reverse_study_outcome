package com.bytedance.ee.android.file.picker.lib;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.suite.lark.component.navroute.forseti.ForsetiNavOptions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/suite/lark/component/navroute/forseti/ForsetiNavOptions$Builder;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class FilePicker$startPicker$1 extends Lambda implements Function1<ForsetiNavOptions.a, Unit> {
    final /* synthetic */ int $requestCode;

    public FilePicker$startPicker$1(int r100) {
        this.$requestCode = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ForsetiNavOptions.a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$navigate");
        r100.f460325d = this.$requestCode;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ForsetiNavOptions.a r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
