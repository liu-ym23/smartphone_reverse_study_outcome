package com.bytedance.locallife.live.dsl;

import android.content.Context;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.model.UpdatePackage;
import com.bytedance.locallife.common.utils.k;
import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class f extends GeckoUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f259456a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f259457a;

        public a(Context r100) {
            this.f259457a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            List<String> r100 = h.f259460a;     // Catch: Throwable -> L4
            h.d(this.f259457a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public f(Context r100) {
        this.f259456a = r100;
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onUpdateSuccess(UpdatePackage r100, long r101) {
        LiveLifeSaaSUtil.t().i("LiveLocalLifeDSLEngine", "onGeckoUpdateSuccess " + r101);
        k.d(new a(this.f259456a));
    }
}
