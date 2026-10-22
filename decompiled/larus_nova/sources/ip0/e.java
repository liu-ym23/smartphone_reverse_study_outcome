package ip0;

import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.repository.MiniAppListRepository;
import io.reactivex.functions.Consumer;
import kotlin.Result;

/* JADX INFO: loaded from: classes46.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MiniAppListRepository f495254a;

    public e(MiniAppListRepository r100) {
        this.f495254a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f495254a.f84248b.a(Result.m9448boximpl(Result.m9449constructorimpl((b) r100)));
    }
}
