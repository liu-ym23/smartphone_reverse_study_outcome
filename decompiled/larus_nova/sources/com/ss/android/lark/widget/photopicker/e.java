package com.ss.android.lark.widget.photopicker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.supervisor.token.Token;
import com.larus.nova.R;
import com.ss.android.lark.camera_export.CameraParam;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.permission.StoragePermissionUtils;
import com.ss.android.lark.widget.photopicker.entity.Photo;
import com.suite.lark.platform.component.widget_biz_permissionpurposewindow.PermissionPurposeWindowPermissionResult;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f447467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f447468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f447469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f447470d;

    public class a extends PermissionPurposeWindowPermissionResult {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f447471b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Fragment f447472c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f447473d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ e f447474e;

        @Override // com.suite.lark.platform.component.widget_biz_permissionpurposewindow.PermissionPurposeWindowPermissionResult, com.ss.android.lark.permission.StoragePermissionUtils.a
        public final void b(StoragePermissionUtils.c r100) {
            int r101 = r100.f438544a;
            boolean r102 = true;
            if (r101 == 0) goto L7;
            if (r101 == 1) goto L7;
            r102 = false;
        L7:
            if (r102 == true) goto L10;
            Log.w("PhotoPicker", "Failed to open album: no storage permission");
            this.f447474e.f447470d.onIntercept("no storage permission");
            e r103 = this.f447474e;
            r103.f447470d = r103.f447469c;
            return;
        L10:
            this.f447474e.c(this.f447471b, this.f447472c, this.f447473d);
        }

        public a(e r100, Activity r101, Fragment r102, int r103) {
            this.f447474e = r100;
            this.f447471b = r101;
            this.f447472c = r102;
            this.f447473d = r103;
        }
    }

    public final com.ss.android.lark.utils.l a() {
        if (this.f447467a.getBoolean("SHOW_VIDEO", true) == true) goto L7;
        int r100 = com.ss.android.lark.utils.n.f444741a;
        return new com.ss.android.lark.utils.l(R.string.Lark_Core_StorageAccess_Title, R.string.Lark_IM_EnableStorageAccessToSelectImage_Text, R.string.Lark_Core_StorageAccess_Title, R.string.Lark_IM_EnableStorageAccessToSelectImage_Text, null, null, 240);
    L7:
        return com.ss.android.lark.utils.n.b();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.ss.android.lark.widget.photopicker.b, com.ss.android.lark.widget.photopicker.c] */
    public e(s r100) {
        ?? r101 = new c();
        this.f447469c = r101;
        this.f447470d = r101;
        Bundle r102 = new Bundle();
        this.f447467a = r102;
        this.f447468b = r100;
        r102.putBoolean("extra_use_new_photo_picker", true);
    }

    public final void b(Context r110, Fragment r111, int r112) {
        Bundle r100 = this.f447467a;
        r100.putInt("MAX_COUNT", this.f447468b.f447558c);
        this.f447467a.putInt("TOTAL_MAX_COUNT", this.f447468b.f447559d);
        this.f447467a.putBoolean("TOTAL_HAS_VIDEO", this.f447468b.f447560e);
        this.f447467a.putBoolean("SINGLE_VIDEO", this.f447468b.f447561f);
        this.f447467a.putBoolean("SINGLE_SHOW_SELECTOR", this.f447468b.f447562g);
        this.f447467a.putBoolean("TOAST_TOTAL_MAX_COUNT", this.f447468b.f447563h);
        s r101 = this.f447468b;
        if (r101.f447556a != 1) goto L10;
        int r102 = r101.f447557b;
        if (r102 < 2) goto L7;
        this.f447467a.putInt("ONLY_CAMERA_TYPE", 2);
        goto L10
    L7:
        if (r102 != 1) goto L9;
        this.f447467a.putInt("ONLY_CAMERA_TYPE", 3);
        goto L10
    L9:
        this.f447467a.putInt("ONLY_CAMERA_TYPE", 1);
    L10:
        boolean r103 = false;
        if (this.f447468b.f447556a < 1) goto L13;
        boolean r104 = true;
    L14:
        this.f447467a.putBoolean("SHOW_CAMERA", r104);
        this.f447467a.putInt("MAX_DURATION", this.f447468b.f447564i);
        this.f447467a.putBoolean("USE_LARK_CAMERA", this.f447468b.f447566k);
        if (this.f447468b.f447557b < 1) goto L17;
        boolean r105 = true;
    L18:
        this.f447467a.putBoolean("SHOW_VIDEO", r105);
        this.f447467a.putString("ACTION_TXT", this.f447468b.f447573r);
        if (this.f447468b.f447565j != 1) goto L21;
        boolean r106 = true;
    L22:
        this.f447467a.putBoolean("FACE_FRONT", r106);
        this.f447467a.putInt("column", this.f447468b.f447571p);
        this.f447467a.putBoolean("keep_origin", this.f447468b.f447569n);
        this.f447467a.putBoolean("PREVIEW_ENABLED", this.f447468b.f447570o);
        this.f447467a.putSerializable("ORIGINAL_PHOTOS", this.f447468b.f447574s);
        this.f447467a.putBoolean("SHOW_ORIGIN", this.f447468b.f447568m);
        this.f447467a.putBoolean("SHOW_GIF", !this.f447468b.f447567l);
        this.f447467a.putBoolean("EXTRA_CAMERA_USE_1080P", this.f447468b.f447579x);
        this.f447467a.putBoolean("save_to_private_path", this.f447468b.f447578w);
        this.f447467a.putBoolean("enable_pre_upload", this.f447468b.f447580y);
        s r107 = this.f447468b;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r100, "bundle");
        r100.putInt("mediaType", r107.f447557b);
        r100.putInt("sourceType", r107.f447556a);
        r100.putInt("max_select_count", r107.f447558c);
        r100.putInt("total_max_count", r107.f447559d);
        r100.putBoolean("total_selected_video", r107.f447560e);
        r100.putBoolean("single_video", r107.f447561f);
        r100.putBoolean("show_single_selector", r107.f447562g);
        r100.putBoolean("toast_total_count", r107.f447563h);
        r100.putInt("maxDuration", r107.f447564i);
        r100.putInt("defaultCamera", r107.f447565j);
        r100.putBoolean("useLarkCamera", r107.f447566k);
        r100.putBoolean("filterGif", r107.f447567l);
        r100.putBoolean("showOrigin", r107.f447568m);
        r100.putBoolean("keepOrigin", r107.f447569n);
        r100.putBoolean("enablePreview", r107.f447570o);
        r100.putInt("columnNumber", r107.f447571p);
        r100.putBoolean("isSecret", r107.f447572q);
        r100.putString("actionTxt", r107.f447573r);
        ArrayList<Photo> r108 = r107.f447574s;
        if (r108 == null) goto L25;
        r100.putSerializable("selectPhotos", r108);
    L25:
        r100.putSerializable("biz", r107.f447575t);
        r100.putSerializable("scene", r107.f447576u);
        r100.putInt("from_type", r107.f447577v);
        r100.putBoolean("save_to_private_path", r107.f447578w);
        r100.putBoolean("KEY_CAMERA_USE_1080P", r107.f447579x);
        r100.putBoolean("enable_pre_upload", r107.f447580y);
        r100.putString("selection_interceptor_key", r107.f447581z);
        r100.putBoolean("insert_to_input_enabled", r107.A);
        r100.putBoolean("insert_to_input_new_interaction_enabled", r107.B);
        if (r111 == null) goto L30;
        Activity r109 = r111.getActivity();
    L28:
        Activity r113 = r109;
    L34:
        if (r113 != null) goto L38;
        Log.e("PhotoPicker", "Context error: given fragment is null, and context not an Activity");
        this.f447470d = this.f447469c;
        return;
    L38:
        if (this.f447468b.f447556a != 1) goto L56;
        Log.i("PhotoPicker", "open camera");
        int r114 = this.f447468b.f447557b;
        if (r114 != 0) goto L42;
        String r115 = CameraParam.MODE_ONLY_PHOTO;
    L45:
        CameraParam.Builder r116 = new CameraParam.Builder();
        CameraParam.Builder r117 = r116.setFrom("photo_picker").setMode(r115);
        if (this.f447468b.f447565j != 1) goto L48;
        r103 = true;
    L48:
        r117.isFrontCamera(r103).use1080P(this.f447468b.f447579x).isSaveGallery(!this.f447468b.f447578w).setMaxDuration(this.f447468b.f447564i).setInterceptCallback(new d(this));
        if (this.f447468b.f447566k == false) goto L51;
        r116.setType(CameraParam.TYPE_VE_CAMERA);
    L52:
        CameraParam r118 = r116.build();
        int r119 = com.ss.android.lark.camera.b.f410774a;
        com.ss.android.lark.camera.b.a r120 = new com.ss.android.lark.camera.b.a(r118);
        if (r111 == null) goto L55;
        Intrinsics.checkNotNullParameter(r111, WidgetService.PARAM_FRAGMENT);
        r120.d(null, r111, r112);
        return;
    L55:
        Intrinsics.checkNotNullParameter(r113, "activity");
        r120.d(r113, null, r112);
        return;
    L51:
        r116.setType(CameraParam.TYPE_SYSTEM_CAMERA);
        goto L52
    L42:
        if (r114 != 1) goto L44;
        r115 = CameraParam.MODE_ONLY_VIDEO;
        goto L45
    L44:
        r115 = CameraParam.MODE_PHOTO_VIDEO_BOTH;
        goto L45
    L56:
        Log.i("PhotoPicker", "Checking storage permission for opening album");
        new HashMap();
        int r121 = StoragePermissionUtils.a(r110, StoragePermissionUtils.d(r110, 2));
        StoragePermissionUtils.a(r110, StoragePermissionUtils.d(r110, 4));
        StoragePermissionUtils.d(r110, 8);
        StoragePermissionUtils.e(r110);
        if (r121 != 1) goto L59;
        c(r113, r111, r112);
        return;
    L59:
        Token r122 = new Token("LARK-PSDA-android_photo_picker_request_permission");
        a r123 = new a(this, r113, r111, r112);
        int r124 = this.f447468b.f447557b;
        if (r124 != 0) goto L62;
        com.ss.android.lark.utils.h.f(r113, r123, a(), r122, 2, new String[0]);
        return;
    L62:
        if (r124 != 1) goto L64;
        com.ss.android.lark.utils.h.f(r113, r123, a(), r122, 4, new String[0]);
        return;
    L64:
        com.ss.android.lark.utils.h.f(r113, r123, a(), r122, 6, new String[0]);
        return;
    L30:
        if ((r110 instanceof Activity) == false) goto L32;
        r109 = (Activity) r110;
        goto L28
    L32:
        r113 = null;
        goto L34
    L21:
        r106 = false;
        goto L22
    L17:
        r105 = false;
        goto L18
    L13:
        r104 = false;
        goto L14
    }

    public final void c(Activity r100, Fragment r101, int r102) {
        if (r100.isFinishing() == false) goto L5;
    L12:
        Log.e("PhotoPicker", "startPhotoPickerImpl failed, activity is invalid");
        return;
    L5:
        if (r100.isDestroyed() == true) goto L12;
        Intent r103 = new Intent();
        r103.setClass(r100, PhotoPickerActivity.class);
        r103.putExtras(this.f447467a);
        if (r101 != null) goto L10;
        r100.startActivityForResult(r103, r102);
        return;
    L10:
        r101.startActivityForResult(r103, r102);
    }
}
