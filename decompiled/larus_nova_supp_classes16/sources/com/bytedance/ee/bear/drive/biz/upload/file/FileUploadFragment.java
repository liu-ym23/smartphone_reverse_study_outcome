package com.bytedance.ee.bear.drive.biz.upload.file;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.drive.biz.upload.BaseUploadFragment;
import com.bytedance.ee.bear.drive.report.c;
import com.bytedance.ee.bear.f;
import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import m75.d;
import o75.b;
import r65.e;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FileUploadFragment extends BaseUploadFragment {
    public boolean y;

    @Override // com.bytedance.ee.bear.drive.biz.upload.BaseUploadFragment, com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsBaseFragment
    public final int getContentViewLayoutId() {
        return 2131560235;
    }

    @Override // com.bytedance.ee.bear.drive.biz.upload.BaseUploadFragment
    public final e W90() {
        return new e(getActivity(), b.a());
    }

    public FileUploadFragment() {
        this.y = true;
    }

    @Override // com.bytedance.ee.bear.drive.biz.upload.BaseUploadFragment, com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsMvpFragment
    public final /* bridge */ /* synthetic */ d V90(Context r1) {
        return W90();
    }

    @Override // com.bytedance.ee.bear.drive.biz.upload.BaseUploadFragment
    public final void X90(ConnectionService.NetworkState r2) {
        if (r2 != null) goto L4;
    L8:
        this.y = true;
        return;
    L4:
        if (getContext() == null) goto L8;
        if (r2.a() == true) goto L8;
        this.y = false;
    }

    @Override // com.bytedance.ee.bear.drive.biz.upload.BaseUploadFragment
    public final void Y90(Bundle r4) {
        this.r = "drive_picker_type_file";
        c r5 = b.a().Ke();
        r5.getClass();
        r5.H("", "drive_click_upload_file", new HashMap());
        e r6 = (e) this.f;
        String r0 = this.k;
        String r1 = this.j;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, "mountPoint");
        Intrinsics.checkNotNullParameter(r1, "mountNodePoint");
        r6.g = r0;
        r6.h = r1;
    }

    public final void onActivityCreated(Bundle r6) {
        super.onActivityCreated(r6);
        if (com.bytedance.ee.util.ui.b.a(getActivity()) == true) goto L5;
        a.h("DRIVE_FilePickerFragment", "startFilePicker activity finished");
        return;
    L5:
        FragmentActivity r7 = getActivity();
        FragmentManager r1 = getActivity().getSupportFragmentManager();
        FileSelectConfig.f r2 = FileSelectConfig.filePickerBuilder();
        r2.a.customSendBtnTips = getResources().getString(2131887846);
        u65.b r3 = new u65.b(this);
        FileSelectConfig r4 = r2.a;
        r4.fileSelectListener = r3;
        r4.permissionCheckListener = new u65.a(this);
        FileSelectConfig r5 = r2.a();
        int r8 = com.bytedance.ee.bear.fileselector.d.a;
        com.bytedance.ee.bear.fileselector.d.a.c(r7, r1, r5, "DRIVE_FilePickerFragment");
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsMvpFragment
    public final void onSaveInstanceState(Bundle r3) {
        super.onSaveInstanceState(r3);
        r3.putBoolean("callSaveInstanceState", true);
    }

    public static void Z90(FileUploadFragment r3, List r4, boolean r5) {
        r3.getClass();
        if (hu5.a.d(r4) == true) goto L13;
        r3.w = r5;
        r3.u = new ArrayList(r4);
        r3.s = true;
        a.h("DRIVE_FilePickerFragment", "handleResult: needResult= " + r3.p);
        if (r3.p == false) goto L10;
        if (r3.q == false) goto L10;
        r3.NU(0);
        return;
    L10:
        if (r3.y == true) goto L12;
        r3.NU(0);
        return;
    L12:
        ((e) r3.f).j(r3.u, r3.l, false, r3.w);
        ((f) org.koin.java.a.a(f.class)).f(r3.m, r3.n, r3.o, TipCallBackData.CONFIRM);
        return;
    L13:
        r3.s = false;
        r3.u = null;
        r3.NU(0);
        ((f) org.koin.java.a.a(f.class)).f(r3.m, r3.n, r3.o, "cancel");
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsBaseFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.y = true;
        return super.onCreateView(r2, r3, r4);
    }
}
