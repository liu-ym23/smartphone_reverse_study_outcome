package ct4;

import android.os.Build;
import android.view.ActionMode;
import android.view.View;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.performance.BitableViewTracer;
import com.bytedance.ee.bear.bitable.statistic.m;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import dt4.k;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public abstract class b<T> implements k<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ActionMode f465347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BitableViewTracer f465348b;

    @Override // dt4.k
    public /* synthetic */ void f() {
    }

    @Override // dt4.k
    public abstract String getViewType();

    @Override // dt4.k
    public final void b() {
        ActionMode r100 = this.f465347a;
        if (r100 == null) goto L5;
        r100.finish();
    L5:
        this.f465347a = null;
    }

    @Override // dt4.k
    public final com.bytedance.ee.bear.bitable.infoarch.nativeview.performance.e d() {
        return this.f465348b.f213638c;
    }

    @Override // dt4.k
    public final void init() {
        BitableViewTracer r100 = this.f465348b;
        String r101 = getDocumentTraceId();
        String r102 = getViewType();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "viewType");
        com.bytedance.ee.bear.bitable.statistic.c r103 = ((m) r100.f213636a.getValue()).createFpsTrace(r101);
        r100.f213640e = r103;
        r100.f213641f = r102;
        com.bytedance.ee.bear.bitable.statistic.c r104 = null;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("fpsTrace");
        r103 = null;
    L5:
        com.bytedance.ee.bear.bitable.infoarch.nativeview.performance.c r105 = new com.bytedance.ee.bear.bitable.infoarch.nativeview.performance.c(r102);
        r100.f213639d = r105;
        r103.d(r105);
        com.bytedance.ee.bear.bitable.statistic.c r106 = r100.f213640e;
        if (r106 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("fpsTrace");
    L9:
        r104.d(r100.f213638c);
        return;
    L8:
        r104 = r106;
        goto L9
    }

    public b() {
        this.f465348b = new BitableViewTracer();
    }

    @Override // dt4.k
    public final BitableViewTracer c() {
        return this.f465348b;
    }

    public final void g(View r100, List<SimpleItemModel> r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "itemModel");
        ActionMode r102 = this.f465347a;
        if (r102 == null) goto L6;
        r102.finish();
    L6:
        if (Build.VERSION.SDK_INT < 23) goto L8;
        ActionMode r103 = r100.startActionMode(new com.bytedance.ee.bear.bitable.common.widgets.a(r101, e()), 1);
    L9:
        this.f465347a = r103;
        return;
    L8:
        r103 = r100.startActionMode(new com.bytedance.ee.bear.bitable.common.widgets.a(r101, e()));
        goto L9
    }
}
