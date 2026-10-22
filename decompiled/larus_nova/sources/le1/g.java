package le1;

import com.bytedance.android.livesdk.arch.plugin.handler.BehaviorPluginHandler;
import com.bytedance.android.livesdk.arch.plugin.handler.BizCheckPluginHandler;
import com.bytedance.android.livesdk.arch.plugin.handler.PreloadContentPluginHandler;
import com.bytedance.android.livesdk.arch.plugin.handler.TracePluginHandler;
import com.bytedance.android.livesdk.arch.plugin.handler.Unfold2MorePanelPluginHandler;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.Disposables;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class g implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<d> f508913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.livesdk.arch.context.a f508914b;

    @Override // le1.e
    public final void a() {
        Iterator<T> r100 = this.f508913a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((d) r100.next()).a();
        goto L4
    }

    public final void b() {
        c(new TracePluginHandler());
        c(new PreloadContentPluginHandler());
        c(new BehaviorPluginHandler());
        c(new Unfold2MorePanelPluginHandler());
        c(new BizCheckPluginHandler());
    }

    @Override // le1.e
    public final void onDestroy() {
        Iterator r100 = CollectionsKt.toList(this.f508913a).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        d((d) r100.next());
        goto L4
    L6:
        ((ArrayList) this.f508913a).clear();
    }

    public final void c(b r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        if (((ArrayList) this.f508913a).contains(r100) == true) goto L5;
        r100.d(this.f508914b);
        r100.onRegister();
        ((ArrayList) this.f508913a).add(r100);
    L5:
        Disposables.fromAction(new f(this, r100));
    }

    public final void d(d r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        Boolean r101 = Boolean.valueOf(((ArrayList) this.f508913a).remove(r100));
        if (r101.booleanValue() == true) goto L6;
        r101 = null;
    L6:
        if (r101 == null) goto L9;
        r101.booleanValue();
        r100.c();
        return;
    }

    public g(com.bytedance.android.livesdk.arch.context.a r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "tbContext");
        this.f508914b = r100;
        this.f508913a = new ArrayList();
    }
}
