package ip0;

import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.repository.MiniAppListRepository;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MiniAppListRepository f495252a;

    public c(MiniAppListRepository r100) {
        this.f495252a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        Intrinsics.checkNotNullParameter(r101, "response");
        int r102 = qo0.a.f534145a;
        qo0.a.c("choose_list", "fetch list success, no update: " + ((com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.b) r101.data).noUpdate + ", hash: " + ((com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.b) r101.data).hash);
        com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.b r103 = (com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.b) r101.data;
        if (r103.noUpdate == false) goto L13;
        com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.b r104 = this.f495252a.f84247a.f499935a;
        if (r104 == null) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == true) goto L11;
        r104 = null;
    L11:
        if (r104 == null) goto L16;
        return r104;
    L16:
        return (com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.b) r101.data;
    L7:
        r105 = false;
        goto L8
    L13:
        this.f495252a.f84247a.f499935a = r103;
        return (com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.b) r101.data;
    }
}
