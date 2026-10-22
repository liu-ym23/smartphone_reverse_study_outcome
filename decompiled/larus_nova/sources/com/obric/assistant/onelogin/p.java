package com.obric.assistant.onelogin;

import androidx.lifecycle.LifecycleOwnerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes33.dex */
public final /* synthetic */ class p implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ObricOneLoginTransparentActivity f390940a;

    public /* synthetic */ p(ObricOneLoginTransparentActivity r100) {
        this.f390940a = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ObricOneLoginTransparentActivity r100 = this.f390940a;
        int r101 = ObricOneLoginTransparentActivity.f390893d;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r100), null, null, new ObricOneLoginTransparentActivity$onCreate$2$1(r100, null), 3, null);
        return Unit.INSTANCE;
    }
}
