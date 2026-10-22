package androidx.activity.contextaware;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"androidx/activity/contextaware/ContextAwareKt$withContextAvailable$2$listener$1", "Landroidx/activity/contextaware/OnContextAvailableListener;", "onContextAvailable", "", "context", "Landroid/content/Context;", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 176)
public final class ContextAwareKt$withContextAvailable$2$listener$1 implements OnContextAvailableListener {
    final /* synthetic */ i<R> $co;
    final /* synthetic */ Function1<Context, R> $onContextAvailable;

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public void onContextAvailable(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        i<R> r0 = this.$co;
        Function1<Context, R> r1 = this.$onContextAvailable;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        Object r5 = Result.constructor-impl(r1.invoke(r4));     // Catch: Throwable -> L5
    L7:
        r0.resumeWith(r5);
        return;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public ContextAwareKt$withContextAvailable$2$listener$1(i<R> r1, Function1<Context, R> r2) {
        this.$co = r1;
        this.$onContextAvailable = r2;
    }
}
