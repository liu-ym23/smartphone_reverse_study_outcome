package com.bytedance.awemeopen.apps.framework.card.dialog;

import android.app.Activity;
import com.bytedance.awemeopen.apps.framework.report.WebReportActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class AosHostCardBottomPanelDialog$doReport$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AosHostCardBottomPanelDialog this$0;

    public AosHostCardBottomPanelDialog$doReport$2(AosHostCardBottomPanelDialog r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1224invoke() {
        int r0 = WebReportActivity.a;
        AosHostCardBottomPanelDialog r1 = this.this$0;
        Activity r2 = r1.e;
        r1.getClass();
        Intrinsics.throwUninitializedPropertyAccessException("bean");
        throw null;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1224invoke();
        return Unit.INSTANCE;
    }
}
