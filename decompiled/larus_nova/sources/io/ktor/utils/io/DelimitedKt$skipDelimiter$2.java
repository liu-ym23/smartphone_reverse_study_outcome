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
final class DelimitedKt$skipDelimiter$2 extends Lambda implements Function1<p, Unit> {
    final /* synthetic */ ByteBuffer $delimiter;
    final /* synthetic */ Ref.BooleanRef $found;

    public DelimitedKt$skipDelimiter$2(Ref.BooleanRef r100, ByteBuffer r101) {
        this.$found = r100;
        this.$delimiter = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(p r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$lookAhead");
        Ref.BooleanRef r101 = this.$found;
        if (l.b(r100, this.$delimiter) != this.$delimiter.remaining()) goto L5;
        boolean r102 = true;
    L6:
        r101.element = r102;
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(p r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
