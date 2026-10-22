package com.bytedance.ee.bear.contract;

import com.bytedance.ttnet.cronet.AbsCronetDependAdapter;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class r0 {
    public final List<c> a;

    public class a extends AbsCronetDependAdapter {
        public final /* synthetic */ r0 a;

        public a(r0 r1) {
            this.a = r1;
        }

        public final void onEffectiveConnectionTypeChanged(int r3) {
            tt5.a.h("TTnetConnectionType", "onEffectiveConnectionTypeChanged type: " + r3);
            Iterator r0 = ((CopyOnWriteArrayList) this.a.a).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((c) r0.next()).onEffectiveConnectionTypeChanged(r3);
            goto L4
        }
    }

    public static class b {
        public static final r0 a = null;

        static {
            a = new r0();
        }
    }

    public interface c {
        void onEffectiveConnectionTypeChanged(int r1);
    }

    public r0() {
        new a(this);
        this.a = new CopyOnWriteArrayList();
    }
}
