package mf5;

import com.bytedance.ee.bear.middleground.permission.collaborator.askowner.AskOwnerModel$SendResult;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes18.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Throwable, Unit> f513635a;

    /* JADX WARN: Multi-variable type inference failed */
    public f(Function1<? super Throwable, Unit> r100) {
        this.f513635a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        AskOwnerModel$SendResult r101 = (AskOwnerModel$SendResult) r100;
        this.f513635a.invoke(null);
    }
}
