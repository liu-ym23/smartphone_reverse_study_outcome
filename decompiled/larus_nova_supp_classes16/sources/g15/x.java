package g15;

import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Singleton
public final class x implements rw4.d {
    @Inject
    public x() {
    }

    @Override // rw4.d
    public final void Z(rw4.c r2) {
        Intrinsics.checkNotNullParameter(r2, TipCallBackData.RESULT);
        rw4.d r0 = (rw4.d) OfficeSDKManager.getHostGlobalService(rw4.d.class);
        if (r0 == null) goto L6;
        r0.Z(r2);
        return;
    }

    @Override // rw4.d
    public final void j1(rw4.b r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        rw4.d r0 = (rw4.d) OfficeSDKManager.getHostGlobalService(rw4.d.class);
        if (r0 == null) goto L6;
        r0.j1(r2);
        return;
    }
}
