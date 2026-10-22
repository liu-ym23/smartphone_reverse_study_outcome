package y54;

import android.app.Application;
import com.bytedance.awemeopen.servicesapi.context.AoHostService;
import j64.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Application f566239a;

    static {
    }

    public static final Application a() {
        if (f566239a != null) goto L5;
        int r100 = b.f497514a;
        f566239a = ((AoHostService) b.a(AoHostService.class)).getHostApplication();
    L5:
        Application r101 = f566239a;
        Intrinsics.checkNotNull(r101);
        return r101;
    }
}
