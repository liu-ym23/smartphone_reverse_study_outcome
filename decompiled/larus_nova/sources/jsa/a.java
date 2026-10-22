package jsa;

import android.content.Context;
import android.content.Intent;
import com.larus.nova.R;
import com.ss.android.bytedcert.base.BytedCertSdkAbsActivity;
import com.ss.android.bytedcert.face.ui.FaceDetectDialogActivity;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.cert.manager.permission.PermissionEntity;
import com.ss.android.cert.manager.utils.LocaleHelper;
import java.util.HashMap;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements BytedCertSdkAbsActivity.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f500237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f500238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f500239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f500240d;

    @Override // com.ss.android.bytedcert.base.BytedCertSdkAbsActivity.c
    public final HashMap<String, PermissionEntity> a(Context r100) {
        HashMap<String, PermissionEntity> r101 = new HashMap();
        PermissionEntity r102 = PermissionEntity.getCameraEntity(r100, LocaleHelper.getMultiLanguageString(r100, this.f500239c, R.string.byted_permission_camera));
        r101.put(r102.permission, r102);
        if (this.f500240d == false) goto L5;
        PermissionEntity r103 = PermissionEntity.getRecordAudioEntity(r100, LocaleHelper.getMultiLanguageString(r100, this.f500239c, R.string.byted_permission_audio));
        r101.put(r103.permission, r103);
    L5:
        return r101;
    }

    @Override // com.ss.android.bytedcert.base.BytedCertSdkAbsActivity.c
    public final Intent b(Context r100, boolean r101) {
        Intent r102 = new Intent(r100, FaceDetectDialogActivity.class);
        r102.putExtra(EventConstant.Key.ALREADY_HAS_PERMISSION, r101);
        r102.putExtra(BytedCertConstant.IntentKey.FLOW_ID, this.f500237a);
        if (this.f500238b == false) goto L5;
        r102.putExtra("without_animation", true);
    L5:
        return r102;
    }

    public a(String r100, boolean r101, String r102, boolean r103) {
        this.f500237a = r100;
        this.f500238b = r101;
        this.f500239c = r102;
        this.f500240d = r103;
    }
}
