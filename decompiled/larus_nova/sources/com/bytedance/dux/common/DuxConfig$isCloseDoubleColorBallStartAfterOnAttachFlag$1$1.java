package com.bytedance.dux.common;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class DuxConfig$isCloseDoubleColorBallStartAfterOnAttachFlag$1$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ boolean $value;

    public DuxConfig$isCloseDoubleColorBallStartAfterOnAttachFlag$1$1(boolean r100) {
        this.$value = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        return Boolean.valueOf(this.$value);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return invoke();
    }
}
