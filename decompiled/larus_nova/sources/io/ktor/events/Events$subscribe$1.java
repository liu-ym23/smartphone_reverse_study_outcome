package io.ktor.events;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/events/a;", "it", "Lio/ktor/util/internal/a;", AbsMethodDelegate.TAG_INVOKE, "(Lio/ktor/events/a;)Lio/ktor/util/internal/a;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
final class Events$subscribe$1 extends Lambda implements Function1<a<?>, io.ktor.util.internal.a> {
    public static final Events$subscribe$1 INSTANCE = null;

    static {
        INSTANCE = new Events$subscribe$1();
    }

    public Events$subscribe$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final io.ktor.util.internal.a invoke2(a<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return new io.ktor.util.internal.a();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ io.ktor.util.internal.a invoke(a<?> r100) {
        return invoke2(r100);
    }
}
