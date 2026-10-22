package h4a;

import android.app.Activity;
import android.content.Context;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.larus.platform.service.i2;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class h implements hx7.e {
    public h() {
    }

    @Override // hx7.e
    public final boolean isPermissionAllGranted(Context r100, String... r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "permission");
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        if ((-1) == ContextCompat.checkSelfPermission(r100, r101[r103])) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    @Override // hx7.e
    public final void a(Activity r100, String[] r101, final hx7.i r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "permissionName");
        Intrinsics.checkNotNullParameter(r102, "callback");
        i2.f365748b.m((FragmentActivity) r100, ArraysKt.toList(r101), new g(r102));
    }
}
