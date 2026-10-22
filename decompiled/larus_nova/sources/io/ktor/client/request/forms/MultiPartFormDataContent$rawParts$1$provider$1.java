package io.ktor.client.request.forms;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import io.ktor.utils.io.core.j;
import io.ktor.utils.io.core.k;
import io.ktor.utils.io.core.s;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/ktor/utils/io/core/k;", AbsMethodDelegate.TAG_INVOKE, "()Lio/ktor/utils/io/core/k;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
final class MultiPartFormDataContent$rawParts$1$provider$1 extends Lambda implements Function0<k> {
    final /* synthetic */ byte[] $bytes;

    public MultiPartFormDataContent$rawParts$1$provider$1(byte[] r100) {
        this.$bytes = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final k invoke() {
        byte[] r100 = this.$bytes;
        j r101 = new j(null);
        s.c(r101, r100);     // Catch: Throwable -> L5
        return r101.m();
    L5:
        th = move-exception;
        r101.close();
        throw th;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ k invoke() {
        return invoke();
    }
}
