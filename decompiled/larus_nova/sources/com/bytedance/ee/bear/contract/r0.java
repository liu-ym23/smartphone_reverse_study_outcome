package com.bytedance.ee.bear.contract;

import com.bytedance.ttnet.cronet.AbsCronetDependAdapter;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes16.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c> f217131a;

    public class a extends AbsCronetDependAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r0 f217132a;

        public a(r0 r100) {
            this.f217132a = r100;
        }

        @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
        public final void onEffectiveConnectionTypeChanged(int r100) {
            tt5.a.h("TTnetConnectionType", "onEffectiveConnectionTypeChanged type: " + r100);
            Iterator r101 = ((CopyOnWriteArrayList) this.f217132a.f217131a).iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ((c) r101.next()).onEffectiveConnectionTypeChanged(r100);
            goto L4
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final r0 f217133a = null;

        static {
            f217133a = new r0();
        }
    }

    public interface c {
        void onEffectiveConnectionTypeChanged(int r100);
    }

    public r0() {
        new a(this);
        this.f217131a = new CopyOnWriteArrayList();
    }
}
