package io.ktor.client.engine;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001 \u0001*\u00020\u0000*\u00028\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lio/ktor/client/engine/e;", ExifInterface.GPS_DIRECTION_TRUE, "", AbsMethodDelegate.TAG_INVOKE, "(Lio/ktor/client/engine/e;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
final class HttpClientEngineFactory$create$1 extends Lambda implements Function1<e, Unit> {
    public static final HttpClientEngineFactory$create$1 INSTANCE = null;

    static {
        INSTANCE = new HttpClientEngineFactory$create$1();
    }

    public HttpClientEngineFactory$create$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(e r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$null");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(e r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
