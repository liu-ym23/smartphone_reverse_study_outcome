package wj5;

import com.bytedance.ee.bear.list.dto.DocVersion;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f559994a;

    public i(a r100) {
        this.f559994a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        DocVersion r101 = (DocVersion) r100;
        tt5.a.h("DocMoreInfoBehavior", "ownerTypeFlow ok. ");
        oj5.a r102 = this.f559994a.c();
        if (r102 == null) goto L5;
        Intrinsics.checkNotNull(r101);
        Intrinsics.checkNotNullParameter(r101, "docVersion");
        r102.f523539j = r101;
    L5:
        a r103 = this.f559994a;
        r103.e(r103.c());
    }
}
