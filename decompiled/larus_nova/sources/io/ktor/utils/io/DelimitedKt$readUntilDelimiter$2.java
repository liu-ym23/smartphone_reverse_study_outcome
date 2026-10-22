package io.ktor.utils.io;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/utils/io/p;", "", AbsMethodDelegate.TAG_INVOKE, "(Lio/ktor/utils/io/p;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
final class DelimitedKt$readUntilDelimiter$2 extends Lambda implements Function1<p, Unit> {
    final /* synthetic */ Ref.IntRef $copied;
    final /* synthetic */ ByteBuffer $delimiter;
    final /* synthetic */ ByteBuffer $dst;
    final /* synthetic */ Ref.BooleanRef $endFound;

    public DelimitedKt$readUntilDelimiter$2(ByteBuffer r100, ByteBuffer r101, Ref.BooleanRef r102, Ref.IntRef r103) {
        this.$delimiter = r100;
        this.$dst = r101;
        this.$endFound = r102;
        this.$copied = r103;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(p r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$lookAhead");
    L3:
        int r101 = l.a(r100, this.$delimiter, this.$dst);
        if (r101 == 0) goto L11;
        if (r101 >= 0) goto L7;
        this.$endFound.element = true;
        r101 = -r101;
    L7:
        this.$copied.element += r101;
        if (this.$dst.hasRemaining() == false) goto L16;
        if (this.$endFound.element == false) goto L3;
        return;
    L16:
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(p r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
