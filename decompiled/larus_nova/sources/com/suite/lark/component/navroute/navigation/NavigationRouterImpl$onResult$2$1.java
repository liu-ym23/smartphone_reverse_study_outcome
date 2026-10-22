package com.suite.lark.component.navroute.navigation;

import android.os.Bundle;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "key", "", "result", "Landroid/os/Bundle;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class NavigationRouterImpl$onResult$2$1 extends Lambda implements Function2<String, Bundle, Unit> {
    final /* synthetic */ Function1<Bundle, Unit> $callback;
    final /* synthetic */ String $requestKey;

    /* JADX WARN: Multi-variable type inference failed */
    public NavigationRouterImpl$onResult$2$1(String r100, Function1<? super Bundle, Unit> r101) {
        this.$requestKey = r100;
        this.$callback = r101;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "result");
        if (Intrinsics.areEqual(this.$requestKey, r100) == false) goto L6;
        this.$callback.invoke(r101);
        return;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String r100, Bundle r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
