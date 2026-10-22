package ssa;

import android.content.Context;
import android.content.Intent;
import com.larus.nova.R;
import com.ss.android.bytedcert.base.BytedCertSdkAbsActivity;
import com.ss.android.bytedcert.video.VideoUploadActivity;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.permission.PermissionEntity;
import com.ss.android.cert.manager.utils.LocaleHelper;
import java.util.HashMap;

/* JADX INFO: loaded from: classes34.dex */
public final class f implements BytedCertSdkAbsActivity.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f543492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f543493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f543494c;

    @Override // com.ss.android.bytedcert.base.BytedCertSdkAbsActivity.c
    public final HashMap<String, PermissionEntity> a(Context r100) {
        HashMap<String, PermissionEntity> r101 = new HashMap();
        PermissionEntity r102 = PermissionEntity.getCameraEntity(r100, LocaleHelper.getMultiLanguageString(r100, this.f543493b, R.string.byted_permission_camera));
        PermissionEntity r103 = PermissionEntity.getRecordAudioEntity(r100, LocaleHelper.getMultiLanguageString(r100, this.f543493b, R.string.byted_permission_audio));
        r101.put(r102.permission, r102);
        r101.put(r103.permission, r103);
        return r101;
    }

    @Override // com.ss.android.bytedcert.base.BytedCertSdkAbsActivity.c
    public final Intent b(Context r100, boolean r101) {
        Intent r102 = new Intent(r100, VideoUploadActivity.class);
        r102.putExtra(BytedCertConstant.IntentKey.FLOW_ID, this.f543492a);
        r102.putExtra("language", this.f543493b);
        r102.putExtra(BytedCertConstant.IntentKey.VIEW_TYPE, this.f543494c);
        return r102;
    }

    public f(String r100, String r101, String r102) {
        this.f543492a = r100;
        this.f543493b = r101;
        this.f543494c = r102;
    }
}
