package rq0;

import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.f;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.viewmodel.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ShelfCardInfo> f538920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f538921b;

    public c(List<ShelfCardInfo> r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, "cardInfoList");
        this.f538920a = r100;
        this.f538921b = r101;
    }
}
