package em;

import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.host.api.service.IECHostService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ji.a f473044a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f473045b = null;

    /* JADX INFO: renamed from: em.a$a, reason: collision with other inner class name */
    public static final class C5789a implements ji.a {
        public C5789a() {
        }

        @Override // ji.a
        public final void log(int r100, String r101, String r102) {
        }
    }

    public a() {
    }

    @Override // em.c
    public final boolean b(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "tag");
        if (r100 < 4) goto L5;
        return true;
    L5:
        return false;
    }

    static {
        f473045b = new a();
        boolean r100 = ECServiceManager.f42805a;
        IECHostService r101 = (IECHostService) ECServiceManager.c(IECHostService.class);
        if (r101 == null) goto L6;
        ji.a r102 = r101.getIECHostALogService();
        if (r102 == null) goto L6;
    L7:
        f473044a = r102;
        return;
    L6:
        r102 = new C5789a();
        goto L7
    }

    @Override // em.c
    public final void a(int r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r102, "msg");
        f473044a.log(r100, r101, r102);
    }
}
