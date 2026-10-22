package ud1;

import com.bytedance.android.live.network.response.BaseListResponse;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import td1.e;

/* JADX INFO: loaded from: classes7.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f549729a;

    public b(a r100) {
        this.f549729a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        BaseListResponse r101 = (BaseListResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "response");
        e r102 = new e();
        r102.f545504a = r101.data;
        td1.a r103 = (td1.a) r101.extra;
        int r104 = 10;
        if (r103 == null) goto L5;
        int r105 = r103.a();
    L6:
        if (r105 <= 0) goto L9;
        r104 = r105;
    L9:
        r102.a(r104);
        List<T> r106 = r101.data;
        if (r106 == null) goto L12;
        r106.size();
    L12:
        wd1.a r107 = this.f549729a.f549723a;
        if (r107 == null) goto L16;
        r107.y0(r102, null);
        return;
    L16:
        return;
    L5:
        r105 = 10;
        goto L6
    }
}
