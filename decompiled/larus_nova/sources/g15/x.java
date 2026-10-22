package g15;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Singleton
public final class x implements rw4.d {
    @Inject
    public x() {
    }

    @Override // rw4.d
    public final void Z(rw4.c r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        rw4.d r101 = (rw4.d) OfficeSDKManager.getHostGlobalService(rw4.d.class);
        if (r101 == null) goto L6;
        r101.Z(r100);
        return;
    }

    @Override // rw4.d
    public final void j1(rw4.b r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        rw4.d r101 = (rw4.d) OfficeSDKManager.getHostGlobalService(rw4.d.class);
        if (r101 == null) goto L6;
        r101.j1(r100);
        return;
    }
}
