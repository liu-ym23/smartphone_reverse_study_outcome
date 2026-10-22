package qsa;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.larus.nova.R;
import com.ss.android.bytedcert.base.BytedCertSdkAbsActivity;
import com.ss.android.bytedcert.ocr.OCRTakePhotoActivity;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.permission.PermissionEntity;
import com.ss.android.cert.manager.utils.LocaleHelper;
import com.tencent.open.SocialConstants;
import java.util.HashMap;

/* JADX INFO: loaded from: classes34.dex */
public final class n implements BytedCertSdkAbsActivity.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f534712a;

    public n(o r100) {
        this.f534712a = r100;
    }

    @Override // com.ss.android.bytedcert.base.BytedCertSdkAbsActivity.c
    public final HashMap<String, PermissionEntity> a(Context r100) {
        HashMap<String, PermissionEntity> r101 = new HashMap();
        PermissionEntity r102 = PermissionEntity.getCameraEntity(r100, LocaleHelper.getMultiLanguageString(r100, this.f534712a.f534722j, R.string.byted_permission_camera));
        r101.put(r102.permission, r102);
        return r101;
    }

    @Override // com.ss.android.bytedcert.base.BytedCertSdkAbsActivity.c
    public final Intent b(Context r100, boolean r101) {
        Intent r102 = new Intent(r100, OCRTakePhotoActivity.class);
        r102.putExtra("type", this.f534712a.f534713a);
        if (TextUtils.isEmpty(this.f534712a.f534714b) == true) goto L5;
        r102.putExtra(BytedCertConstant.IntentKey.FLOW_ID, this.f534712a.f534714b);
    L5:
        r102.putExtra("orientation", this.f534712a.f534715c);
        r102.putExtra("title", this.f534712a.f534716d);
        r102.putExtra(SocialConstants.PARAM_APP_DESC, this.f534712a.f534717e);
        r102.putExtra("camera_position", this.f534712a.f534718f);
        r102.putExtra("show_album_entry", this.f534712a.f534719g);
        r102.putExtra("show_camera_switcher", this.f534712a.f534720h);
        r102.putExtra("hide_mask", this.f534712a.f534721i);
        r102.putExtra("language", this.f534712a.f534722j);
        return r102;
    }
}
