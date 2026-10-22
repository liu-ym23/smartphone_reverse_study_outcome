package lw9;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.larus.platform.service.i2;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class k implements jn7.j {
    public k() {
    }

    @Override // jn7.j
    public final boolean hasPermission(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "permission");
        return moa.b.a(r100, r101);
    }

    @Override // jn7.j
    public void requestPermissions(Activity r100, String[] r101, ShareContent r102, final in7.g r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
        Intrinsics.checkNotNullParameter(r102, "shareContent");
        Intrinsics.checkNotNullParameter(r103, "callback");
        if ((r100 instanceof FragmentActivity) == false) goto L6;
        i2.f365748b.a((FragmentActivity) r100, ArraysKt.toList(r101), new j(r103));
        return;
    }
}
