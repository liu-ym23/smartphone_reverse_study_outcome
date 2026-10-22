package com.bytedance.ee.bear.list.homepage.ai;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tt5.a;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class SpaceHomePageAiLauncher$checkOnBoarding$1 extends Lambda implements Function0<Unit> {
    public static final SpaceHomePageAiLauncher$checkOnBoarding$1 INSTANCE = null;

    static {
        INSTANCE = new SpaceHomePageAiLauncher$checkOnBoarding$1();
    }

    public SpaceHomePageAiLauncher$checkOnBoarding$1() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        a.h("SpaceHomePageAiLauncher", "tryOnBoarding success");
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
