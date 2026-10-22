package unc;

import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public abstract class f implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vnc.a f550898a;

    public static final class a implements tnc.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f550899a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ snc.b f550900b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ tnc.a f550901c;

        @Override // tnc.a
        public final void onNext() {
            this.f550899a.c(this.f550900b, this.f550901c);
        }

        public a(f r100, snc.b r101, tnc.a r102) {
            this.f550899a = r100;
            this.f550900b = r101;
            this.f550901c = r102;
        }
    }

    public abstract void c(snc.b r100, tnc.a r101);

    public f() {
        this.f550898a = new vnc.a();
    }

    public final String toString() {
        return getClass().getSimpleName();
    }

    public final void b(snc.b r100, tnc.a r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (a(r100) == false) goto L8;
        Log.i("Router", this + ": handle request " + r100.f542687b.getPath());
        if (((ArrayList) this.f550898a.f556473a).isEmpty() == true) goto L7;
        this.f550898a.a(r100, new a(this, r100, r101));
        return;
    L7:
        c(r100, r101);
        return;
    L8:
        Log.i("Router", this + ": ignore request " + r100.f542687b.getPath());
        r101.onNext();
    }
}
