package com.bytedance.ee.bear.wikiv2.wikitreev2.ai;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class WikiAiController$checkAiEnable$1 extends Lambda implements Function0<Unit> {
    public static final WikiAiController$checkAiEnable$1 INSTANCE = null;

    static {
        INSTANCE = new WikiAiController$checkAiEnable$1();
    }

    public WikiAiController$checkAiEnable$1() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m694invoke() {
        tt5.a.h("WikiAiController", "tryOnBoarding success");
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m694invoke();
        return Unit.INSTANCE;
    }
}
