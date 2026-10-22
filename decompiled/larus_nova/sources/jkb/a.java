package jkb;

import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jkb.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public abstract class a<C extends jkb.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<d<C>> f499512a;

    /* JADX INFO: renamed from: jkb.a$a, reason: collision with other inner class name */
    public static final class C6451a {
    }

    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d<C> f499513a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterator<d<C>> f499514b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ C f499515c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a<C> f499516d;

        @Override // jkb.c
        public final void a() {
            if (this.f499514b.hasNext() == false) goto L6;
            this.f499513a = this.f499514b.next();
            int r100 = com.ss.android.lark.im.sdk.a.f425904a;
            com.ss.android.lark.im.sdk.a.b("ImSdkPipeline", "Pipeline step " + this.f499513a.getName() + " start to process");
            this.f499513a.a(this.f499515c, this);
            return;
        }

        @Override // jkb.c
        public final void b(e r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            int r101 = com.ss.android.lark.im.sdk.a.f425904a;
            com.ss.android.lark.im.sdk.a.a("ImSdkPipeline", "Pipeline step " + this.f499513a.getName() + " terminated for reason: " + r100);
            this.f499516d.b(this.f499513a, this.f499515c, r100);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(d<C> r100, Iterator<? extends d<C>> r101, C r102, a<C> r103) {
            this.f499514b = r101;
            this.f499515c = r102;
            this.f499516d = r103;
            this.f499513a = r100;
        }
    }

    static {
    }

    public abstract void b(d<C> r100, C r101, e r102);

    public a() {
        this.f499512a = new ArrayList();
    }

    public final void a(d<C> r100) {
        Intrinsics.checkNotNullParameter(r100, "pipelineStep");
        ((ArrayList) this.f499512a).add(r100);
    }

    public final void c(C r100) {
        Intrinsics.checkNotNullParameter(r100, "pipelineContext");
        com.ss.android.lark.im.sdk.a.b("ImSdkPipeline", "Pipeline start to process");
        Iterator r101 = ((ArrayList) this.f499512a).iterator();
        if (r101.hasNext() == true) goto L6;
        Intrinsics.checkNotNullParameter("ImSdkPipeline", "tag");
        Intrinsics.checkNotNullParameter("Pipeline has no step, return", "message");
        Log.w("ImSdkPipeline", "Pipeline has no step, return");
        return;
    L6:
        d r102 = (d) r101.next();
        b r103 = new b(r102, r101, r100, this);
        com.ss.android.lark.im.sdk.a.b("ImSdkPipeline", "Pipeline step " + r102.getName() + " start to process");
        r102.a(r100, r103);
    }
}
