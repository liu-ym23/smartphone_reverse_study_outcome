package com.bytedance.locallife.poi.perf;

import com.bytedance.locallife.biz.experiment.LifeLynxOptExperiment;
import com.bytedance.locallife.cube.Cube;
import com.bytedance.locallife.cube.api.i.ICubeGlobalListener;
import com.bytedance.locallife.cube.api.model.FileLoadOptions;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.thread.ThreadPoolHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public final class j implements com.bytedance.locallife.poi.perf.a {

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List<?> f263708a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f263709b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f263710c;

        public a(List<?> r100, j r101, boolean r102) {
            this.f263708a = r100;
            this.f263709b = r101;
            this.f263710c = r102;
        }

        public final void a() {
            List<?> r100 = this.f263708a;
            ArrayList r101 = new ArrayList();
            Iterator<T> r102 = r100.iterator();
        L4:
            if (r102.hasNext() == false) goto L8;
            Object r103 = r102.next();
            if ((r103 instanceof String) == false) goto L4;
            r101.add(r103);
            goto L4
        L8:
            j r104 = this.f263709b;
            boolean r105 = this.f263710c;
            Iterator r106 = r101.iterator();
        L10:
            if (r106.hasNext() == false) goto L16;
            String r107 = (String) r106.next();
            r104.getClass();
            kp6.a<ICubeGlobalListener> r108 = Cube.f257155a;
            if (LifeLynxOptExperiment.a().b() == false) goto L14;
            FileLoadOptions r109 = new FileLoadOptions(true, true);
        L15:
            Cube.a(r107, r105, r109, null, false, 24);
            goto L10
        L14:
            r109 = new FileLoadOptions(false, false, 3, null);
            goto L15
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

    public j() {
    }

    @Override // com.bytedance.locallife.poi.perf.a
    public final void handle(Map<String, ? extends Object> r100) {
        Object r101 = r100.get("urls");
        Boolean r102 = null;
        if ((r101 instanceof List) == false) goto L5;
        List r103 = (List) r101;
    L6:
        if (r103 != null) goto L8;
        return;
    L8:
        Object r104 = r100.get("codecache");
        if ((r104 instanceof Boolean) == false) goto L11;
        r102 = (Boolean) r104;
    L11:
        if (r102 == null) goto L14;
        ThreadPoolHelper.d().execute(new a(r103, this, r102.booleanValue()));
        return;
    L14:
        return;
    L5:
        r103 = null;
        goto L6
    }
}
