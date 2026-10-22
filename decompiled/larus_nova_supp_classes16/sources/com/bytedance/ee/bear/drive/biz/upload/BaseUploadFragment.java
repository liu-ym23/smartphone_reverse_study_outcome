package com.bytedance.ee.bear.drive.biz.upload;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.drive.biz.versions.model.VersionPayLoadData;
import com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsMvpFragment;
import com.bytedance.ee.bear.fileselector.bean.FileBean;
import fo5.d;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import n75.b;
import r65.c;
import r65.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class BaseUploadFragment extends AbsMvpFragment<e> implements c, Observer<ConnectionService.NetworkState> {
    public static final /* synthetic */ int x = 0;
    public LiveData<ConnectionService.NetworkState> g;
    public n75.a<ConnectionService.NetworkState> h;
    public Disposable i;
    public String j;
    public String k;
    public Bundle l;
    public String m;
    public String n;
    public String o;
    public boolean p;
    public boolean q;
    public String r;
    public boolean s;
    public boolean t;
    public ArrayList<String> u;
    public ArrayList<FileBean> v;
    public boolean w;

    public class a extends b<ConnectionService.NetworkState> {
        public final /* synthetic */ BaseUploadFragment a;

        public a(BaseUploadFragment r1) {
            this.a = r1;
        }

        @Override // n75.b
        public final void a(n75.a<ConnectionService.NetworkState> r3) throws Exception {
            BaseUploadFragment r0 = this.a;
            if (r0.h != null) goto L6;
            r0.h = r3;
            return;
        }
    }

    @Override // r65.c
    public final void HW() {
        NU(0);
    }

    public e W90() {
        return null;
    }

    public void X90(ConnectionService.NetworkState r1) {
    }

    public void Y90(Bundle r1) {
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsBaseFragment
    public int getContentViewLayoutId() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsBaseFragment
    public final void initActions(View r1) {
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsBaseFragment
    public final void initViews(View r1, Bundle r2) {
    }

    public BaseUploadFragment() {
        this.s = false;
        this.t = true;
        this.w = false;
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsBaseFragment
    public final void initData() {
        Bundle r0 = getArguments();
        Objects.requireNonNull(r0);
        this.j = r0.getString("extras_mount_node_point", "");
        this.k = r0.getString("extras_mount_point", "");
        this.p = r0.getBoolean("extras_need_result", false);
        this.q = r0.getBoolean("extras_do_not_upload", false);
        this.t = r0.getBoolean("extras_multiple", true);
        Bundle r1 = r0.getBundle("extras_tea_params");
        this.l = r1;
        if (r1 == null) goto L5;
        this.m = r1.getString("module", "");
        this.n = this.l.getString("sub_module", "");
        this.o = this.l.getString(DocViewModel.EXTRA_PARENT_TOKEN, "");
    L5:
        this.g = j.a.a.a();
        this.i = Flowable.create(new a(this), BackpressureStrategy.LATEST).throttleWithTimeout(1, TimeUnit.SECONDS).observeOn(d.d()).subscribe(new r65.a(this), new r65.b());
        this.g.observeForever(this);
        o75.b.a().Ke().x("click_upload", "", "", this.l);
        Y90(r0);
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onDestroy() {
        super.onDestroy();
        LiveData<ConnectionService.NetworkState> r0 = this.g;
        if (r0 == null) goto L5;
        r0.removeObserver(this);
    L5:
        Disposable r1 = this.i;
        if (r1 == null) goto L9;
        r1.dispose();
        return;
    }

    @Override // r65.c
    public final void NU(int r4) {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isFinishing() == false) goto L8;
        return;
    L8:
        if (this.p == false) goto L10;
        Intent r5 = r0.getIntent();
        r5.putExtra("drive_picker_success", this.s);
        r5.putExtra("drive_picker_type", this.r);
        r5.putStringArrayListExtra("drive_picker_file_list", this.u);
        r5.putExtra("drive_picker_file_use_uri", this.w);
        r5.putExtra("drive_picker_media_list", this.v);
        r0.setResult(VersionPayLoadData.OPERATION_UPDATE, r5);
    L11:
        r0.finish();
        return;
    L10:
        r0.setResult(r4);
        goto L11
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsMvpFragment
    public /* bridge */ /* synthetic */ m75.d V90(Context r1) {
        return W90();
    }

    public final void onChanged(Object r2) {
        ConnectionService.NetworkState r3 = (ConnectionService.NetworkState) r2;
        n75.a<ConnectionService.NetworkState> r0 = this.h;
        if (r0 == null) goto L6;
        r0.onNext(r3);
        return;
    }
}
