package kotlinx.coroutines.reactive;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.y;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "t", "", "ctx", "Lkotlin/coroutines/CoroutineContext;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
final class PublishKt$DEFAULT_HANDLER$1 extends Lambda implements Function2<Throwable, CoroutineContext, Unit> {
    public static final PublishKt$DEFAULT_HANDLER$1 INSTANCE = null;

    static {
        INSTANCE = new PublishKt$DEFAULT_HANDLER$1();
    }

    public PublishKt$DEFAULT_HANDLER$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r100, CoroutineContext r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable r100, CoroutineContext r101) {
        if ((r100 instanceof CancellationException) == true) goto L6;
        y.a(r101, r100);
        return;
    }
}
