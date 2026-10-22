package com.bytedance.applet.aibridge.navigation;

import com.bytedance.applet.task.NavigationCardSessionState;
import com.bytedance.applet.task.NavigationMultitaskCard;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class NavigationTestEntry$createMultitaskCardBridge$owner$1 extends FunctionReferenceImpl implements Function2<NavigationCardSessionState.a, String, NavigationCardSessionState.a> {
    public NavigationTestEntry$createMultitaskCardBridge$owner$1(Object r8) {
        super(2, r8, NavigationMultitaskCard.class, "bindNavigationSession", "bindNavigationSession$impl_mainlandRelease(Lcom/bytedance/applet/task/NavigationCardSessionState$Owner;Ljava/lang/String;)Lcom/bytedance/applet/task/NavigationCardSessionState$Owner;", 0);
    }

    public final NavigationCardSessionState.a invoke(NavigationCardSessionState.a r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        Intrinsics.checkNotNullParameter(r3, "p1");
        ((NavigationMultitaskCard) ((CallableReference) this).receiver).getClass();
        return NavigationMultitaskCard.b(r2, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((NavigationCardSessionState.a) r1, (String) r2);
    }
}
