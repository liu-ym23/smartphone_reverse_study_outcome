package io.ktor.http.parsing;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/ktor/http/parsing/d;", AbsMethodDelegate.TAG_INVOKE, "()Lio/ktor/http/parsing/d;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
final class ParserDslKt$maybe$1 extends Lambda implements Function0<d> {
    final /* synthetic */ Function1<e, Unit> $block;

    /* JADX WARN: Multi-variable type inference failed */
    public ParserDslKt$maybe$1(Function1<? super e, Unit> r100) {
        this.$block = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final d invoke() {
        e r100 = new e();
        this.$block.invoke(r100);
        if (((ArrayList) r100.f491896a).size() != 1) goto L5;
        d r101 = (d) CollectionsKt.first(r100.f491896a);
    L6:
        Intrinsics.checkNotNullParameter(r101, "grammar");
        return new f(r101);
    L5:
        r101 = new l(r100.f491896a);
        goto L6
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ d invoke() {
        return invoke();
    }
}
