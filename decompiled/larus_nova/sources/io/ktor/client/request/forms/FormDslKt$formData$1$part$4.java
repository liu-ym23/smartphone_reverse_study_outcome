package io.ktor.client.request.forms;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import io.ktor.utils.io.core.l;
import io.ktor.utils.io.core.n;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/ktor/utils/io/core/n;", AbsMethodDelegate.TAG_INVOKE, "()Lio/ktor/utils/io/core/n;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
final class FormDslKt$formData$1$part$4 extends Lambda implements Function0<n> {
    final /* synthetic */ Object $value;

    public FormDslKt$formData$1$part$4(Object r100) {
        this.$value = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final n invoke() {
        final byte[] r100 = (byte[]) this.$value;
        return l.a(ByteBuffer.wrap(r100, 0, r100.length), new FormDslKt$formData$1$part$4$invoke$$inlined$ByteReadPacket$default$1(r100));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ n invoke() {
        return invoke();
    }
}
