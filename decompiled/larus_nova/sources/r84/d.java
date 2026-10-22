package r84;

import android.util.Log;
import com.bytedance.bdnavigationsdk.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class d implements e {
    public d() {
    }

    public static void a(String r100, Throwable r101) {
        if (r101 == null) goto L5;
        Log.getStackTraceString(r101);
        return;
    }

    @Override // com.bytedance.bdnavigationsdk.e
    public final void w(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter("BDNAAppContext 尝试重复初始化，但使用的不是同一个 Application Context", "msg");
        a("BDNAAppContext 尝试重复初始化，但使用的不是同一个 Application Context", r101);
    }

    @Override // com.bytedance.bdnavigationsdk.e
    public final void d(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        a(r101, r102);
    }

    @Override // com.bytedance.bdnavigationsdk.e
    public final void e(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        a(r101, r102);
    }

    @Override // com.bytedance.bdnavigationsdk.e
    public final void i(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        a(r101, r102);
    }
}
