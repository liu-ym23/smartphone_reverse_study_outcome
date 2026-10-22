package org.koin.core;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class KoinApplication$modules$duration$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ List<kwc.a> $modules;
    final /* synthetic */ b this$0;

    public KoinApplication$modules$duration$1(b r100, List<kwc.a> r101) {
        this.this$0 = r100;
        this.$modules = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        b r100 = this.this$0;
        List<kwc.a> r101 = this.$modules;
        r100.f526127a.c(r101, false);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
