package mdc;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.photopickerimpl.bean.Photo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import ldc.d;

/* JADX INFO: loaded from: classes38.dex */
public final class a<DATA extends Photo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ndc.b<DATA> f513432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.widget.photopickerimpl.model.b<DATA> f513433b;

    /* JADX INFO: renamed from: mdc.a$a, reason: collision with other inner class name */
    public static final class C6805a implements odc.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a<DATA> f513434a;

        @Override // odc.a.b
        public final void a() {
            this.f513434a.f513433b.a();
        }

        @Override // odc.a.b
        public final void b() {
            this.f513434a.f513433b.b();
        }

        public C6805a(a<DATA> r100) {
            this.f513434a = r100;
        }
    }

    public static final class b implements ldc.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a<DATA> f513435a;

        public b(a<DATA> r100) {
            this.f513435a = r100;
        }

        @Override // ldc.c
        public final void a(Map<Integer, com.ss.android.lark.widget.photopickerimpl.bean.b> r100) {
            Intrinsics.checkNotNullParameter(r100, "photoDirs");
            ndc.b<DATA> r101 = this.f513435a.f513432a;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r100, "data");
            Iterator<T> r102 = r101.f518844b.iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            ((odc.a) r102.next()).h(r100);
            goto L4
        }
    }

    public static final class c implements d<DATA> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a<DATA> f513436a;

        public c(a<DATA> r100) {
            this.f513436a = r100;
        }

        @Override // ldc.d
        public final void a(List r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "photos");
            ndc.b<DATA> r102 = this.f513436a.f513432a;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r100, "data");
            Iterator<T> r103 = r102.f518844b.iterator();
        L4:
            if (r103.hasNext() == false) goto L6;
            ((odc.a) r103.next()).g(r100, r101, true);
            goto L4
        }
    }

    public a(ndc.b<DATA> r100, com.ss.android.lark.widget.photopickerimpl.model.b<DATA> r101) {
        Intrinsics.checkNotNullParameter(r100, "mView");
        Intrinsics.checkNotNullParameter(r101, "mModel");
        this.f513432a = r100;
        this.f513433b = r101;
        C6805a r102 = new C6805a(this);
        Intrinsics.checkNotNullParameter(r102, "notify");
        Iterator<T> r103 = r100.f518844b.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        odc.a r104 = (odc.a) r103.next();
        r104.getClass();
        Intrinsics.checkNotNullParameter(r102, "notify");
        r104.f522913a = r102;
        goto L4
    L6:
        this.f513433b.e(new b(this));
        this.f513433b.c(new c(this));
        ndc.b<DATA> r105 = this.f513432a;
        r105.getClass();
        FrameLayout r106 = new FrameLayout(r105.f518843a.getContext());
        r106.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -1));
        r105.f518843a.addView(r106);
        r105.f518846d = r106;
        Intrinsics.checkNotNull(r106);
        ndc.a r107 = new ndc.a(r105);
        Iterator<T> r108 = r105.f518844b.iterator();
    L8:
        if (r108.hasNext() == false) goto L10;
        odc.a r109 = (odc.a) r108.next();
        r109.getClass();
        Intrinsics.checkNotNullParameter(r107, PerfLog.PARAM_KEY_CONTEXT_ID);
        r109.f522914b = r107;
        r106.addView(r109.c(r106));
        goto L8
    L10:
        r107.c(Reflection.getOrCreateKotlinClass(ListProtector.get(r105.f518844b, 0).getClass()), new com.ss.android.lark.widget.photopickerimpl.bean.c());
        this.f513433b.create();
    }
}
