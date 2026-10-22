package com.ss.android.download.api.runtime;

import android.app.Activity;
import android.content.Context;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import n6.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J.\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH&J\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&J&\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0012\u001a\u00020\u0011H&¨\u0006\u0014"}, d2 = {"Lcom/ss/android/download/api/runtime/IAdPermissionProvider;", "", "Landroid/app/Activity;", "activity", "", "requestCode", "", "", ComplianceResult.JsonKey.PERMISSIONS, "", "grantResults", "", "onRequestPermissionsResult", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "hasPermissions", "Ln6/a$a;", "callback", "requestPermission", "download-api_release"}, k = 1, mv = {1, 4, 0})
public interface IAdPermissionProvider {
    boolean hasPermissions(Context r100, List<String> r101);

    void onRequestPermissionsResult(Activity r100, int r101, List<String> r102, int[] r103);

    boolean requestPermission(Activity r100, List<String> r101, a.InterfaceC6895a r102);
}
