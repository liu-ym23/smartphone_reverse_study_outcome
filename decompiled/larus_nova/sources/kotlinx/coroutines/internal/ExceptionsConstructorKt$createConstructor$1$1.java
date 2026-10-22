package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "e", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
final class ExceptionsConstructorKt$createConstructor$1$1 extends Lambda implements Function1<Throwable, Throwable> {
    final /* synthetic */ Constructor<?> $constructor;

    public ExceptionsConstructorKt$createConstructor$1$1(Constructor<?> r100) {
        this.$constructor = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Throwable invoke2(Throwable r100) {
        Object r101 = this.$constructor.newInstance(new Object[]{r100.getMessage(), r100});
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Throwable");
        return (Throwable) r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Throwable invoke(Throwable r100) {
        return invoke2(r100);
    }
}
