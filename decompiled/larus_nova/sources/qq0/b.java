package qq0;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.view.AudienceShelfDisplayDialog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudienceShelfDisplayDialog f534447a;

    public b(AudienceShelfDisplayDialog r100) {
        this.f534447a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == true) goto L5;
        return;
    L5:
        if (this.f534447a.f84969m == true) goto L9;
        f2.c("主播已更新内容", 0);
        return;
    }
}
