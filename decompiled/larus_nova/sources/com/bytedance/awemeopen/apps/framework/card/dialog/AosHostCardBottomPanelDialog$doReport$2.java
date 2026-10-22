package com.bytedance.awemeopen.apps.framework.card.dialog;

import android.app.Activity;
import com.bytedance.awemeopen.apps.framework.report.WebReportActivity;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class AosHostCardBottomPanelDialog$doReport$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AosHostCardBottomPanelDialog this$0;

    public AosHostCardBottomPanelDialog$doReport$2(AosHostCardBottomPanelDialog r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        int r100 = WebReportActivity.f197609a;
        AosHostCardBottomPanelDialog r101 = this.this$0;
        Activity r102 = r101.f193819e;
        r101.getClass();
        Intrinsics.throwUninitializedPropertyAccessException("bean");
        throw null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
