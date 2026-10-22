package ip0;

import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.repository.MiniAppListRepository;
import io.reactivex.functions.Consumer;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes46.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MiniAppListRepository f495255a;

    public f(MiniAppListRepository r100) {
        this.f495255a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        int r102 = qo0.a.f534145a;
        StringBuilder r103 = new StringBuilder("fetch list fail, error: ");
        if (r101 == null) goto L5;
        Object r104 = r101;
    L6:
        r103.append(r104);
        qo0.a.c("choose_list", r103.toString());
        np0.b<Result<b>> r105 = this.f495255a.f84248b;
        Result.Companion r106 = Result.Companion;
        r105.a(Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(r101))));
        return;
    L5:
        r104 = "null";
        goto L6
    }
}
