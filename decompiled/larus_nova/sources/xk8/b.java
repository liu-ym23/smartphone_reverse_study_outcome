package xk8;

import android.content.Context;
import android.view.View;
import com.larus.bmhome.chat.block.base.renderer.FileCardVMData;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b implements lc8.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vk8.b f564245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f564246b;

    @Override // lc8.b
    public final View getView() {
        return (View) this.f564246b.getValue();
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f564245a = new vk8.b(r100);
        this.f564246b = LazyKt.lazy(new a(this));
    }

    @Override // lc8.b
    public final void a(FileCardVMData r100, lc8.a r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "dependency");
        this.f564245a.a(r100, r101);
    }
}
