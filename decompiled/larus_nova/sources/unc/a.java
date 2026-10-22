package unc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public class a extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<f> f550885b;

    /* JADX INFO: renamed from: unc.a$a, reason: collision with other inner class name */
    public static final class C7905a implements tnc.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f550886a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterator<f> f550887b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ snc.b f550888c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ tnc.a f550889d;

        @Override // tnc.a
        public final void onNext() {
            this.f550886a.d(this.f550887b, this.f550888c, this.f550889d);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C7905a(a r100, Iterator<? extends f> r101, snc.b r102, tnc.a r103) {
            this.f550886a = r100;
            this.f550887b = r101;
            this.f550888c = r102;
            this.f550889d = r103;
        }
    }

    public a() {
        this.f550885b = new ArrayList();
    }

    @Override // unc.b
    public final boolean a(snc.b r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        return !this.f550885b.isEmpty();
    }

    @Override // unc.f
    public final void c(snc.b r100, tnc.a r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "callback");
        d(((ArrayList) this.f550885b).iterator(), r100, r101);
    }

    public final void d(Iterator<? extends f> r100, snc.b r101, tnc.a r102) {
        if (r100.hasNext() == false) goto L5;
        r100.next().b(r101, new C7905a(this, r100, r101, r102));
        return;
    L5:
        r102.onNext();
    }
}
