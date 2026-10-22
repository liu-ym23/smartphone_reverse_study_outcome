package com.bytedance.timonbase.scene;

import android.app.Application;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
public final class ScenesDetector$start$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Application $application;

    public ScenesDetector$start$1(Application r100) {
        this.$application = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ph7.c r100 = ph7.d.a();
        if (r100 == null) goto L5;
        ph7.d.f529300a = r100;
    L5:
        boolean r101 = ScenesDetector.f270865a;
        ScenesDetector.a(this.$application);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
