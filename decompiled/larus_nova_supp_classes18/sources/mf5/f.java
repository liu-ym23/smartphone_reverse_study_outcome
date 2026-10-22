package mf5;

import com.bytedance.ee.bear.middleground.permission.collaborator.askowner.AskOwnerModel$SendResult;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ Function1<Throwable, Unit> a;

    /* JADX WARN: Multi-variable type inference failed */
    public f(Function1<? super Throwable, Unit> r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        AskOwnerModel$SendResult r3 = (AskOwnerModel$SendResult) r2;
        this.a.invoke(null);
    }
}
