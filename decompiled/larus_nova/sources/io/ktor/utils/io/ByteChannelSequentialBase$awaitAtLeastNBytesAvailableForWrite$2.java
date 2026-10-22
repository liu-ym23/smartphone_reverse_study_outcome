package io.ktor.utils.io;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$2 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ int $count;
    final /* synthetic */ ByteChannelSequentialBase this$0;

    public ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$2(ByteChannelSequentialBase r100, int r101) {
        this.this$0 = r100;
        this.$count = r101;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        if (this.this$0.T() < this.$count) goto L5;
    L7:
        boolean r100 = false;
    L9:
        return Boolean.valueOf(r100);
    L5:
        if (this.this$0.U() == true) goto L7;
        r100 = true;
        goto L9
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return invoke();
    }
}
