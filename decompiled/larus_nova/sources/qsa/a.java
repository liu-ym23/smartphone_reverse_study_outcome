package qsa;

import android.content.Context;
import android.content.Intent;
import com.larus.nova.R;
import com.ss.android.bytedcert.base.BytedCertSdkAbsActivity;
import com.ss.android.bytedcert.ocr.OCRManualActivity;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.permission.PermissionEntity;
import com.ss.android.cert.manager.utils.LocaleHelper;
import java.util.HashMap;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements BytedCertSdkAbsActivity.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f534693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f534694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f534695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f534696d;

    @Override // com.ss.android.bytedcert.base.BytedCertSdkAbsActivity.c
    public final HashMap<String, PermissionEntity> a(Context r100) {
        HashMap<String, PermissionEntity> r101 = new HashMap();
        PermissionEntity r102 = PermissionEntity.getCameraEntity(r100, LocaleHelper.getMultiLanguageString(r100, this.f534696d, R.string.byted_permission_camera));
        r101.put(r102.permission, r102);
        return r101;
    }

    @Override // com.ss.android.bytedcert.base.BytedCertSdkAbsActivity.c
    public final Intent b(Context r100, boolean r101) {
        Intent r102 = new Intent(r100, OCRManualActivity.class);
        r102.putExtra("type", this.f534693a);
        r102.putExtra(BytedCertConstant.IntentKey.FLOW_ID, this.f534694b);
        r102.putExtra("orientation", this.f534695c);
        wsa.a.f561109e = 0;
        return r102;
    }

    public a(String r100, String r101, String r102, String r103) {
        this.f534693a = r100;
        this.f534694b = r101;
        this.f534695c = r102;
        this.f534696d = r103;
    }
}
