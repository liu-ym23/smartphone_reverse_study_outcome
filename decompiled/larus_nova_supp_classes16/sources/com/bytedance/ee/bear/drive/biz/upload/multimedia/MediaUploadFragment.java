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
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import m75.d;
import o75.b;
import r65.e;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class MediaUploadFragment extends BaseUploadFragment {
    public static final /* synthetic */ int z = 0;
    public int y;

    @Override // com.bytedance.ee.bear.drive.biz.upload.BaseUploadFragment
    public final void X90(ConnectionService.NetworkState r1) {
    }

    @Override // com.bytedance.ee.bear.drive.biz.upload.BaseUploadFragment, com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsBaseFragment
    public final int getContentViewLayoutId() {
        return 2131560235;
    }

    @Override // com.bytedance.ee.bear.drive.biz.upload.BaseUploadFragment
    public final e W90() {
        return new e(getActivity(), b.a());
    }

    public MediaUploadFragment() {
        this.y = 3;
    }

    @Override // com.bytedance.ee.bear.drive.biz.upload.BaseUploadFragment, com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsMvpFragment
    public final /* bridge */ /* synthetic */ d V90(Context r1) {
        return W90();
    }

    @Override // com.bytedance.ee.bear.drive.biz.upload.BaseUploadFragment
    public final void Y90(Bundle r4) {
        this.r = "drive_picker_type_media";
        this.y = r4.getInt("extras_media_type", 2);
        c r5 = b.a().Ke();
        r5.getClass();
        r5.H("", "drive_click_upload_multimedia", new HashMap());
        e r6 = (e) this.f;
        String r0 = this.k;
        String r1 = this.j;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, "mountPoint");
        Intrinsics.checkNotNullParameter(r1, "mountNodePoint");
        r6.g = r0;
        r6.h = r1;
    }

    public final void onActivityCreated(Bundle r8) {
        super.onActivityCreated(r8);
        if (com.bytedance.ee.util.ui.b.a(getActivity()) == true) goto L5;
        a.h("DRIVE_MediaPickerFragment", "startFilePicker activity finished");
        return;
    L5:
        FragmentActivity r9 = getActivity();
        FragmentManager r1 = getActivity().getSupportFragmentManager();
        FileSelectConfig.g r2 = FileSelectConfig.fullScreenAlbumBuilder();
        FileSelectConfig r3 = r2.a;
        r3.showGif = true;
        r3.sourceType = 2;
        r3.showOrigin = true;
        r3.checkedKeepOrigin = true;
        r3.isOriginFile = true;
        r3.mediaType = this.y;
        if (this.t == true) goto L8;
        int r6 = 1;
    L9:
        r3.maxSelectImageNum = r6;
        r3.enableImageCompress = true;
        r3.larkAlbumActionType = 2;
        x65.b r4 = new x65.b(this);
        FileSelectConfig r5 = r2.a;
        r5.fileSelectListener = r4;
        r5.permissionCheckListener = new x65.a(this);
        FileSelectConfig r7 = r2.a();
        int r10 = com.bytedance.ee.bear.fileselector.d.a;
        com.bytedance.ee.bear.fileselector.d.a.c(r9, r1, r7, "DRIVE_MediaPickerFragment");
        return;
    L8:
        r6 = 99;
        goto L9
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsMvpFragment
    public final void onSaveInstanceState(Bundle r3) {
        super.onSaveInstanceState(r3);
        r3.putBoolean("callSaveInstanceState", true);
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsBaseFragment
    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        return super.onCreateView(r1, r2, r3);
    }
}
