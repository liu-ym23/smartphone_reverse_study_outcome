package jsa;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.larus.nova.R;
import com.ss.android.bytedcert.base.BytedCertSdkAbsActivity;
import com.ss.android.bytedcert.face.ui.FaceDetectPercentActivity;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.cert.manager.permission.PermissionEntity;
import com.ss.android.cert.manager.utils.LocaleHelper;
import java.util.HashMap;

/* JADX INFO: loaded from: classes34.dex */
public final class m implements BytedCertSdkAbsActivity.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f500263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f500264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f500265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f500266d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f500267e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f500268f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ boolean f500269g;

    @Override // com.ss.android.bytedcert.base.BytedCertSdkAbsActivity.c
    public final HashMap<String, PermissionEntity> a(Context r100) {
        HashMap<String, PermissionEntity> r101 = new HashMap();
        PermissionEntity r102 = PermissionEntity.getCameraEntity(r100, LocaleHelper.getMultiLanguageString(r100, this.f500268f, R.string.byted_permission_camera));
        r101.put(r102.permission, r102);
        if (this.f500269g == false) goto L5;
        PermissionEntity r103 = PermissionEntity.getRecordAudioEntity(r100, LocaleHelper.getMultiLanguageString(r100, this.f500268f, R.string.byted_permission_audio));
        r101.put(r103.permission, r103);
    L5:
        return r101;
    }

    @Override // com.ss.android.bytedcert.base.BytedCertSdkAbsActivity.c
    public final Intent b(Context r100, boolean r101) {
        Intent r102 = new Intent(r100, FaceDetectPercentActivity.class);
        r102.putExtra(EventConstant.Key.ALREADY_HAS_PERMISSION, r101);
        r102.putExtra(BytedCertConstant.IntentKey.FLOW_ID, this.f500263a);
        r102.putExtra("translation_y", this.f500264b);
        r102.putExtra("radius", this.f500265c);
        r102.putExtra("face_view_height", this.f500266d);
        if (this.f500267e == false) goto L6;
        r102.putExtra("without_animation", true);
    L6:
        if (TextUtils.isEmpty(this.f500268f) == true) goto L8;
        r102.putExtra("language", this.f500268f);
    L8:
        return r102;
    }

    public m(String r100, float r101, float r102, int r103, boolean r104, String r105, boolean r106) {
        this.f500263a = r100;
        this.f500264b = r101;
        this.f500265c = r102;
        this.f500266d = r103;
        this.f500267e = r104;
        this.f500268f = r105;
        this.f500269g = r106;
    }
}
