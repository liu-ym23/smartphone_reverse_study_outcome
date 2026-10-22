package x1a;

import com.larus.im.FlowRuntime;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f562150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f562151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f562152c;

    /* JADX INFO: renamed from: x1a.a$a, reason: collision with other inner class name */
    public static final class C8182a implements b {
        public C8182a() {
        }

        @Override // x1a.b
        public final void ensureNotReachHere(Throwable r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "t");
            Intrinsics.checkNotNullParameter(r101, "msg");
        }

        @Override // x1a.b
        public final void log(int r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "tag");
            Intrinsics.checkNotNullParameter(r102, "msg");
            if (r100 != 1) goto L5;
            FlowRuntime.b().e().v(r101, r102);
            return;
        L5:
            if (r100 != 2) goto L7;
            FlowRuntime.b().e().d(r101, r102);
            return;
        L7:
            if (r100 != 3) goto L9;
            FlowRuntime.b().e().i(r101, r102);
            return;
        L9:
            if (r100 != 4) goto L11;
            FlowRuntime.b().e().w(r101, r102);
            return;
        L11:
            if (r100 == 5) goto L13;
            FlowRuntime.b().e().d(r101, r102);
            return;
        L13:
            FlowRuntime.b().e().e(r101, r102);
        }
    }

    static {
        f562152c = new C8182a();
    }
}
