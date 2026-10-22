package com.relax.relaxframework;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, AbsMethodDelegate.TAG_INVOKE, "()Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class RelaxFrameworkKt$untrackWithSilentStrictMode$ret$1 extends Lambda implements Function0<Object> {
    final /* synthetic */ Function0<Object> $cb;

    public RelaxFrameworkKt$untrackWithSilentStrictMode$ret$1(Function0<Object> r100) {
        this.$cb = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return this.$cb.invoke();
    }
}
