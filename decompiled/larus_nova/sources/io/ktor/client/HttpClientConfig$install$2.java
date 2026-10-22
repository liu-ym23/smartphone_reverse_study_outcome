package io.ktor.client;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000\"\b\b\u0002\u0010\u0004*\u00020\u0003*\u00020\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "TBuilder", "TPlugin", "Lio/ktor/client/engine/e;", ExifInterface.GPS_DIRECTION_TRUE, "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
final class HttpClientConfig$install$2 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ Function1<Object, Unit> $configure;
    final /* synthetic */ Function1<Object, Unit> $previousConfigBlock;

    public HttpClientConfig$install$2(Function1<Object, Unit> r100, Function1<Object, Unit> r101) {
        this.$previousConfigBlock = r100;
        this.$configure = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$null");
        Function1<Object, Unit> r101 = this.$previousConfigBlock;
        if (r101 == null) goto L5;
        r101.invoke(r100);
    L5:
        this.$configure.invoke(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
