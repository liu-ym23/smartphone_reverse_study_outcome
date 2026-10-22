package jsa;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.larus.nova.R;
import com.ss.android.bytedcert.base.BytedCertSdkAbsActivity;
import com.ss.android.bytedcert.face.ui.FaceDetectFullActivity;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.cert.manager.permission.PermissionEntity;
import com.ss.android.cert.manager.utils.LocaleHelper;
import java.util.HashMap;

/* JADX INFO: loaded from: classes34.dex */
public final class g implements BytedCertSdkAbsActivity.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f500249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f500250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f500251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f500252d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f500253e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f500254f;

    @Override // com.ss.android.bytedcert.base.BytedCertSdkAbsActivity.c
    public final HashMap<String, PermissionEntity> a(Context r100) {
        HashMap<String, PermissionEntity> r101 = new HashMap();
        PermissionEntity r102 = PermissionEntity.getCameraEntity(r100, LocaleHelper.getMultiLanguageString(r100, this.f500253e, R.string.byted_permission_camera));
        r101.put(r102.permission, r102);
        if (this.f500254f == false) goto L5;
        PermissionEntity r103 = PermissionEntity.getRecordAudioEntity(r100, LocaleHelper.getMultiLanguageString(r100, this.f500253e, R.string.byted_permission_audio));
        r101.put(r103.permission, r103);
    L5:
        return r101;
    }

    @Override // com.ss.android.bytedcert.base.BytedCertSdkAbsActivity.c
    public final Intent b(Context r100, boolean r101) {
        Intent r102 = new Intent(r100, FaceDetectFullActivity.class);
        r102.putExtra(EventConstant.Key.ALREADY_HAS_PERMISSION, r101);
        r102.putExtra(BytedCertConstant.IntentKey.FLOW_ID, this.f500249a);
        r102.putExtra("translation_y", this.f500250b);
        r102.putExtra("radius", this.f500251c);
        if (this.f500252d == false) goto L6;
        r102.putExtra("without_animation", true);
    L6:
        if (TextUtils.isEmpty(this.f500253e) == true) goto L8;
        r102.putExtra("language", this.f500253e);
    L8:
        return r102;
    }

    public g(String r100, float r101, float r102, boolean r103, String r104, boolean r105) {
        this.f500249a = r100;
        this.f500250b = r101;
        this.f500251c = r102;
        this.f500252d = r103;
        this.f500253e = r104;
        this.f500254f = r105;
    }
}
