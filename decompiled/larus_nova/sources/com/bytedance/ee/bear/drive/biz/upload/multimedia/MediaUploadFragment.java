package com.bytedance.ee.bear.drive.biz.upload.multimedia;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.drive.biz.upload.BaseUploadFragment;
import com.bytedance.ee.bear.drive.report.c;
import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;
import com.larus.nova.R;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import m75.d;
import o75.b;
import r65.e;
import tt5.a;

/* JADX INFO: loaded from: classes16.dex */
public class MediaUploadFragment extends BaseUploadFragment {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ int f223888z = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f223889y;

    @Override // com.bytedance.ee.bear.drive.biz.upload.BaseUploadFragment
    public final void X90(ConnectionService.NetworkState r100) {
    }

    @Override // com.bytedance.ee.bear.drive.biz.upload.BaseUploadFragment, com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsBaseFragment
    public final int getContentViewLayoutId() {
        return R.layout.drive_stub_layout;
    }

    @Override // com.bytedance.ee.bear.drive.biz.upload.BaseUploadFragment
    public final e W90() {
        return new e(getActivity(), b.a());
    }

    public MediaUploadFragment() {
        this.f223889y = 3;
    }

    @Override // com.bytedance.ee.bear.drive.biz.upload.BaseUploadFragment, com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsMvpFragment
    public final /* bridge */ /* synthetic */ d V90(Context r100) {
        return W90();
    }

    @Override // com.bytedance.ee.bear.drive.biz.upload.BaseUploadFragment
    public final void Y90(Bundle r100) {
        this.f223854r = "drive_picker_type_media";
        this.f223889y = r100.getInt("extras_media_type", 2);
        c r101 = b.a().Ke();
        r101.getClass();
        r101.H("", "drive_click_upload_multimedia", new HashMap());
        e r102 = (e) this.f224080f;
        String r103 = this.f223847k;
        String r104 = this.f223846j;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "mountPoint");
        Intrinsics.checkNotNullParameter(r104, "mountNodePoint");
        r102.f536347g = r103;
        r102.f536348h = r104;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        if (com.bytedance.ee.util.ui.b.a(getActivity()) == true) goto L5;
        a.h("DRIVE_MediaPickerFragment", "startFilePicker activity finished");
        return;
    L5:
        FragmentActivity r101 = getActivity();
        FragmentManager r102 = getActivity().getSupportFragmentManager();
        FileSelectConfig.g r103 = FileSelectConfig.fullScreenAlbumBuilder();
        FileSelectConfig r104 = r103.f226780a;
        r104.showGif = true;
        r104.sourceType = 2;
        r104.showOrigin = true;
        r104.checkedKeepOrigin = true;
        r104.isOriginFile = true;
        r104.mediaType = this.f223889y;
        if (this.f223856t == true) goto L8;
        int r105 = 1;
    L9:
        r104.maxSelectImageNum = r105;
        r104.enableImageCompress = true;
        r104.larkAlbumActionType = 2;
        x65.b r106 = new x65.b(this);
        FileSelectConfig r107 = r103.f226780a;
        r107.fileSelectListener = r106;
        r107.permissionCheckListener = new x65.a(this);
        FileSelectConfig r108 = r103.a();
        int r109 = com.bytedance.ee.bear.fileselector.d.f226786a;
        com.bytedance.ee.bear.fileselector.d.a.c(r101, r102, r108, "DRIVE_MediaPickerFragment");
        return;
    L8:
        r105 = 99;
        goto L9
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsMvpFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle r100) {
        super.onSaveInstanceState(r100);
        r100.putBoolean("callSaveInstanceState", true);
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsBaseFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        return super.onCreateView(r100, r101, r102);
    }
}
