package ew;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.bpea.basics.Cert;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements yv.a {
    public b() {
    }

    @Override // yv.a
    public final void A2(String r100, String r101, Long r102, String r103, com.bytedance.android.gamecp.business.gamedetail.component.fansgroup.c.a r104) {
    }

    @Override // yv.a
    public final void Z0(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "url");
    }

    @Override // yv.a
    public final boolean handleSchema(Context r100, String r101, Bundle r102) {
        return false;
    }

    @Override // yv.a
    public final boolean isGranted(Context r100, String... r101) {
        Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
        return false;
    }

    @Override // yv.a
    public void requestPermissions(Activity r100, yv.a.b r101, Cert r102, String... r103) {
        Intrinsics.checkNotNullParameter(r103, ComplianceResult.JsonKey.PERMISSIONS);
    }
}
