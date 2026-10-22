package l46;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public class b implements com.bytedance.ies.ezpermission.core.permissions.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f507349a;

    @Override // com.bytedance.ies.ezpermission.core.permissions.a
    public final String d() {
        return this.f507349a;
    }

    public final String toString() {
        return this.f507349a;
    }

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "permission");
        this.f507349a = r100;
    }

    @Override // com.bytedance.ies.ezpermission.core.permissions.a
    public boolean a(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        n46.a r101 = n46.a.f517060b;
        String r102 = this.f507349a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "permission");
        if (Build.VERSION.SDK_INT >= 23) goto L6;
    L10:
        return false;
    L6:
        if (n46.a.b(r100, r102) == true) goto L10;
        if (n46.a.a(r100, r102) == true) goto L10;
        return true;
    }

    @Override // com.bytedance.ies.ezpermission.core.permissions.a
    public final boolean b(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        n46.a r101 = n46.a.f517060b;
        String r102 = this.f507349a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "permission");
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        return false;
    L6:
        return n46.a.a(r100, r102);
    }

    @Override // com.bytedance.ies.ezpermission.core.permissions.a
    public boolean c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        n46.a r101 = n46.a.f517060b;
        String r102 = this.f507349a;
        r101.getClass();
        return n46.a.b(r100, r102);
    }
}
