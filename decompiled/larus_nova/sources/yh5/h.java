package yh5;

import android.content.Context;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class h implements ph5.e {
    public h() {
    }

    @Override // ph5.e
    public final void a(Context r100, PermissionResponse r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "response");
    }
}
