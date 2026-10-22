package ftb;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d implements etb.b {
    public d() {
    }

    @Override // etb.b
    public final <T> T r(String r100, Class<T> r101, T r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "tClass");
        etb.b r103 = (etb.b) OfficeSDKManager.getHostGlobalService(etb.b.class);
        if (r103 == null) goto L9;
        T r104 = (T) r103.r(r100, r101, r102);
        if (r104 != null) goto L8;
        return r102;
    L8:
        return r104;
    L9:
        return r102;
    }
}
