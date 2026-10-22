package com.bytedance.ee.bear.drive.biz.upload.file;

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
import com.bytedance.ee.bear.f;
import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import m75.d;
import o75.b;
import r65.e;
import tt5.a;

/* JADX INFO: loaded from: classes16.dex */
public class FileUploadFragment extends BaseUploadFragment {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f223879y;

    @Override // com.bytedance.ee.bear.drive.biz.upload.BaseUploadFragment, com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsBaseFragment
    public final int getContentViewLayoutId() {
        return R.layout.drive_stub_layout;
    }

    @Override // com.bytedance.ee.bear.drive.biz.upload.BaseUploadFragment
    public final e W90() {
        return new e(getActivity(), b.a());
    }

    public FileUploadFragment() {
        this.f223879y = true;
    }

    @Override // com.bytedance.ee.bear.drive.biz.upload.BaseUploadFragment, com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsMvpFragment
    public final /* bridge */ /* synthetic */ d V90(Context r100) {
        return W90();
    }

    @Override // com.bytedance.ee.bear.drive.biz.upload.BaseUploadFragment
    public final void X90(ConnectionService.NetworkState r100) {
        if (r100 != null) goto L4;
    L8:
        this.f223879y = true;
        return;
    L4:
        if (getContext() == null) goto L8;
        if (r100.a() == true) goto L8;
        this.f223879y = false;
    }

    @Override // com.bytedance.ee.bear.drive.biz.upload.BaseUploadFragment
    public final void Y90(Bundle r100) {
        this.f223854r = "drive_picker_type_file";
        c r101 = b.a().Ke();
        r101.getClass();
        r101.H("", "drive_click_upload_file", new HashMap());
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
        a.h("DRIVE_FilePickerFragment", "startFilePicker activity finished");
        return;
    L5:
        FragmentActivity r101 = getActivity();
        FragmentManager r102 = getActivity().getSupportFragmentManager();
        FileSelectConfig.f r103 = FileSelectConfig.filePickerBuilder();
        r103.f226780a.customSendBtnTips = getResources().getString(R.string.Doc_Facade_Upload);
        u65.b r104 = new u65.b(this);
        FileSelectConfig r105 = r103.f226780a;
        r105.fileSelectListener = r104;
        r105.permissionCheckListener = new u65.a(this);
        FileSelectConfig r106 = r103.a();
        int r107 = com.bytedance.ee.bear.fileselector.d.f226786a;
        com.bytedance.ee.bear.fileselector.d.a.c(r101, r102, r106, "DRIVE_FilePickerFragment");
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsMvpFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle r100) {
        super.onSaveInstanceState(r100);
        r100.putBoolean("callSaveInstanceState", true);
    }

    public static void Z90(FileUploadFragment r100, List r101, boolean r102) {
        r100.getClass();
        if (hu5.a.d(r101) == true) goto L13;
        r100.f223859w = r102;
        r100.f223857u = new ArrayList(r101);
        r100.f223855s = true;
        a.h("DRIVE_FilePickerFragment", "handleResult: needResult= " + r100.f223852p);
        if (r100.f223852p == false) goto L10;
        if (r100.f223853q == false) goto L10;
        r100.NU(0);
        return;
    L10:
        if (r100.f223879y == true) goto L12;
        r100.NU(0);
        return;
    L12:
        ((e) r100.f224080f).j(r100.f223857u, r100.f223848l, false, r100.f223859w);
        ((f) org.koin.java.a.a(f.class)).f(r100.f223849m, r100.f223850n, r100.f223851o, "confirm");
        return;
    L13:
        r100.f223855s = false;
        r100.f223857u = null;
        r100.NU(0);
        ((f) org.koin.java.a.a(f.class)).f(r100.f223849m, r100.f223850n, r100.f223851o, "cancel");
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsBaseFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        this.f223879y = true;
        return super.onCreateView(r100, r101, r102);
    }
}
