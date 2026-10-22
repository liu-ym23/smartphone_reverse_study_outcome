package vf7;

import android.app.Activity;
import android.app.Fragment;
import androidx.core.app.ActivityCompat;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.supervisor.token.Token;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class c implements a {
    public c() {
    }

    @Override // vf7.a
    public final void c(Activity r100, String[] r101, int r102, Token r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
        Intrinsics.checkNotNullParameter(r103, "token");
        ActivityCompat.requestPermissions(r100, r101, r102);
    }

    @Override // vf7.a
    public void requestPermissions(Activity r100, String[] r101, int r102, Token r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
        Intrinsics.checkNotNullParameter(r103, "token");
        r100.requestPermissions(r101, r102);
    }

    @Override // vf7.a
    public void requestPermissions(Fragment r100, String[] r101, int r102, Token r103) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
        Intrinsics.checkNotNullParameter(r103, "token");
        r100.requestPermissions(r101, r102);
    }

    @Override // vf7.a
    public void requestPermissions(androidx.fragment.app.Fragment r100, String[] r101, int r102, Token r103) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
        Intrinsics.checkNotNullParameter(r103, "token");
        r100.requestPermissions(r101, r102);
    }
}
