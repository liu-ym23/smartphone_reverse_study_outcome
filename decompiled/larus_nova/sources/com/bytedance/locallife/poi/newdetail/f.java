package com.bytedance.locallife.poi.newdetail;

import com.bytedance.locallife.dito.common.provider.DitoBaseViewProvider;
import com.bytedance.locallife.dito.core.viewmodel.DitoViewModel;
import com.bytedance.locallife.poi.poidetail.container.dito.PoiDetailBizContainerViewProvider;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.thread.ThreadPoolHelper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f263245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<Object> f263246b = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f263247a = null;

        static {
            f263247a = new a();
        }

        public a() {
        }

        public static void a() {
            List<Object> r100 = f.f263246b;
            ArrayList r101 = (ArrayList) r100;
            r101.add(new PoiDetailBizContainerViewProvider());
            r101.add(new DitoBaseViewProvider());
            r101.add(DitoViewModel.class);
            r101.clear();
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        f263246b = new ArrayList();
    }

    public static void a() {
        if (f263245a == false) goto L5;
        return;
    L5:
        f263245a = true;
        ThreadPoolHelper.b().execute(a.f263247a);
    }
}
