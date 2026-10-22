package io.ktor.client.request.forms;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import io.ktor.utils.io.core.j;
import io.ktor.utils.io.core.n;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/ktor/utils/io/core/n;", AbsMethodDelegate.TAG_INVOKE, "()Lio/ktor/utils/io/core/n;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
public final class FormDslKt$append$2 extends Lambda implements Function0<n> {
    final /* synthetic */ Function1<j, Unit> $bodyBuilder;

    /* JADX WARN: Multi-variable type inference failed */
    public FormDslKt$append$2(Function1<? super j, Unit> r100) {
        this.$bodyBuilder = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final n invoke() {
        Function1<j, Unit> r100 = this.$bodyBuilder;
        j r101 = new j(null);
        r100.invoke(r101);     // Catch: Throwable -> L5
        return r101.m();
    L5:
        th = move-exception;
        r101.close();
        throw th;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ n invoke() {
        return invoke();
    }
}
