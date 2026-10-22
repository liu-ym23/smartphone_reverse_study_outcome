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
import com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsMvpFragment;
import com.bytedance.ee.bear.fileselector.bean.FileBean;
import com.ss.android.cert.manager.constants.EventConstant;
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

/* JADX INFO: loaded from: classes16.dex */
public class BaseUploadFragment extends AbsMvpFragment<e> implements c, Observer<ConnectionService.NetworkState> {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f223842x = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LiveData<ConnectionService.NetworkState> f223843g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public n75.a<ConnectionService.NetworkState> f223844h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Disposable f223845i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f223846j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f223847k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Bundle f223848l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f223849m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f223850n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f223851o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f223852p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f223853q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f223854r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f223855s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f223856t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ArrayList<String> f223857u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ArrayList<FileBean> f223858v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f223859w;

    public class a extends b<ConnectionService.NetworkState> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseUploadFragment f223860a;

        public a(BaseUploadFragment r100) {
            this.f223860a = r100;
        }

        @Override // n75.b
        public final void a(n75.a<ConnectionService.NetworkState> r100) throws Exception {
            BaseUploadFragment r101 = this.f223860a;
            if (r101.f223844h != null) goto L6;
            r101.f223844h = r100;
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

    public void X90(ConnectionService.NetworkState r100) {
    }

    public void Y90(Bundle r100) {
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsBaseFragment
    public int getContentViewLayoutId() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsBaseFragment
    public final void initActions(View r100) {
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsBaseFragment
    public final void initViews(View r100, Bundle r101) {
    }

    public BaseUploadFragment() {
        this.f223855s = false;
        this.f223856t = true;
        this.f223859w = false;
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsBaseFragment
    public final void initData() {
        Bundle r100 = getArguments();
        Objects.requireNonNull(r100);
        this.f223846j = r100.getString("extras_mount_node_point", "");
        this.f223847k = r100.getString("extras_mount_point", "");
        this.f223852p = r100.getBoolean("extras_need_result", false);
        this.f223853q = r100.getBoolean("extras_do_not_upload", false);
        this.f223856t = r100.getBoolean("extras_multiple", true);
        Bundle r101 = r100.getBundle("extras_tea_params");
        this.f223848l = r101;
        if (r101 == null) goto L5;
        this.f223849m = r101.getString(EventConstant.Key.MODULE, "");
        this.f223850n = this.f223848l.getString("sub_module", "");
        this.f223851o = this.f223848l.getString(DocViewModel.EXTRA_PARENT_TOKEN, "");
    L5:
        this.f223843g = j.a.f217090a.a();
        this.f223845i = Flowable.create(new a(this), BackpressureStrategy.LATEST).throttleWithTimeout(1, TimeUnit.SECONDS).observeOn(d.d()).subscribe(new r65.a(this), new r65.b());
        this.f223843g.observeForever(this);
        o75.b.a().Ke().x("click_upload", "", "", this.f223848l);
        Y90(r100);
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        LiveData<ConnectionService.NetworkState> r100 = this.f223843g;
        if (r100 == null) goto L5;
        r100.removeObserver(this);
    L5:
        Disposable r101 = this.f223845i;
        if (r101 == null) goto L9;
        r101.dispose();
        return;
    }

    @Override // r65.c
    public final void NU(int r100) {
        FragmentActivity r101 = getActivity();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isFinishing() == false) goto L8;
        return;
    L8:
        if (this.f223852p == false) goto L10;
        Intent r102 = r101.getIntent();
        r102.putExtra("drive_picker_success", this.f223855s);
        r102.putExtra("drive_picker_type", this.f223854r);
        r102.putStringArrayListExtra("drive_picker_file_list", this.f223857u);
        r102.putExtra("drive_picker_file_use_uri", this.f223859w);
        r102.putExtra("drive_picker_media_list", this.f223858v);
        r101.setResult(101, r102);
    L11:
        r101.finish();
        return;
    L10:
        r101.setResult(r100);
        goto L11
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsMvpFragment
    public /* bridge */ /* synthetic */ m75.d V90(Context r100) {
        return W90();
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(ConnectionService.NetworkState r100) {
        ConnectionService.NetworkState r101 = r100;
        n75.a<ConnectionService.NetworkState> r102 = this.f223844h;
        if (r102 == null) goto L6;
        r102.onNext(r101);
        return;
    }
}
