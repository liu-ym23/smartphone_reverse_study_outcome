package s53;

import com.bytedance.android.shopping.anchorv3.comment.sku.viewmodel.CommentSkuViewModel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class k<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f540730a;

    public k(h r100) {
        this.f540730a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (((Boolean) r100).booleanValue() == false) goto L9;
        ((LinkedHashMap) this.f540730a.f540723j).clear();
        CommentSkuViewModel r101 = this.f540730a.f540719f;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L7:
        r101.getSkuRequestInfo().e(new LinkedHashMap());
        this.f540730a.d0();
        return;
    }
}
