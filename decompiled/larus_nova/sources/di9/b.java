package di9;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b implements xe6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f468864a = null;

    static {
        f468864a = new b();
    }

    public b() {
    }

    @Override // xe6.b
    public final void d(String r100) {
        Intrinsics.checkNotNullParameter("BDLbsTrace", "tag");
        Intrinsics.checkNotNullParameter(r100, "msg");
        FLogger.f375446a.d("BDLbsTrace", r100);
    }

    @Override // xe6.b
    public final void e(String r100) {
        Intrinsics.checkNotNullParameter("BDLbsTrace", "tag");
        Intrinsics.checkNotNullParameter(r100, "msg");
        FLogger.f375446a.e("BDLbsTrace", r100);
    }

    @Override // xe6.b
    public final void i(String r100) {
        Intrinsics.checkNotNullParameter("BDLbsTrace", "tag");
        Intrinsics.checkNotNullParameter(r100, "msg");
        FLogger.f375446a.i("BDLbsTrace", r100);
    }

    @Override // xe6.b
    public final void w(String r100) {
        Intrinsics.checkNotNullParameter("BDLbsTrace", "tag");
        Intrinsics.checkNotNullParameter(r100, "msg");
        FLogger.f375446a.w("BDLbsTrace", r100);
    }
}
