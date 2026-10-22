package com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.trigger;

import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.async.AsyncBindManager;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.config.SerialPreloader;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.core.AsyncCacheExtension;
import com.ss.ugc.android.cachalot.api.Trigger;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/trigger/AbsTriggerHandler;", "Ljava/lang/Runnable;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsTriggerHandler implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PreloadTriggerContext f450740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f450741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AsyncBindManager<?> f450742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AsyncCacheExtension<?> f450743d;

    public void a() {
        this.f450741b.removeCallbacks(this);
        RecyclerView r100 = this.f450741b;
        this.f450740a.i().c();
        r100.postDelayed(this, 0);
    }

    public AbsTriggerHandler(TriggerEnterParams r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f450740a = r100.getContext();
        this.f450741b = r100.f450769b;
        this.f450742c = r100.f450770c;
        this.f450743d = r100.f450771d;
    }

    public static /* synthetic */ void c(AbsTriggerHandler r100, Queue r101, Trigger r102, int r103) {
        if ((r103 & 4) == 0) goto L5;
        boolean r104 = true;
    L6:
        r100.b(r101, r102, r104, false, true);
        return;
    L5:
        r104 = false;
        goto L6
    }

    public final void b(Queue<Integer> r110, Trigger r111, boolean r112, boolean r113, final boolean r114) {
        Intrinsics.checkNotNullParameter(r110, "queue");
        Intrinsics.checkNotNullParameter(r111, "trigger");
        if (r112 == false) goto L5;
        this.f450743d.a(r110);
    L5:
        final long r100 = System.currentTimeMillis();
        this.f450740a.e(r100);
        AsyncBindManager<?> r101 = this.f450742c;
        Function0<Boolean> r102 = new AbsTriggerHandler$summitPreloadTask$preloader$1(this, r100, r114);
        this.f450740a.i().b();
        SerialPreloader r115 = new SerialPreloader(r101, r110, r102, r113, r111, true, AbsTriggerHandler$summitPreloadTask$preloader$2.INSTANCE);
        r115.a();
        this.f450740a.h(r115);
    }
}
