package vnc;

import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f556473a;

    /* JADX INFO: renamed from: vnc.a$a, reason: collision with other inner class name */
    public static final class C8025a implements tnc.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f556474a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterator<b> f556475b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ snc.b f556476c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ tnc.a f556477d;

        @Override // tnc.a
        public final void onNext() {
            this.f556474a.b(this.f556475b, this.f556476c, this.f556477d);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C8025a(a r100, Iterator<? extends b> r101, snc.b r102, tnc.a r103) {
            this.f556474a = r100;
            this.f556475b = r101;
            this.f556476c = r102;
            this.f556477d = r103;
        }
    }

    public a() {
        this.f556473a = new ArrayList();
    }

    @Override // vnc.b
    public final void a(snc.b r100, tnc.a r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "callback");
        b(((ArrayList) this.f556473a).iterator(), r100, r101);
    }

    public final void b(Iterator<? extends b> r100, snc.b r101, tnc.a r102) {
        if (r100.hasNext() == false) goto L5;
        b r103 = r100.next();
        Log.i("Router", r103.getClass().getSimpleName() + ": intercept, request = " + r101.f542687b.getPath());
        r103.a(r101, new C8025a(this, r100, r101, r102));
        return;
    L5:
        r102.onNext();
    }
}
