package com.bytedance.ee.bear.drive.biz.upload.uploadstatuslist.view;

import a75.e;
import a75.f;
import a75.g;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.contract.drive.DriveCommonConstants$DriveRustFgConfig;
import com.bytedance.ee.bear.drive.biz.upload.uploadstatuslist.presenter.h;
import com.bytedance.ee.bear.drive.biz.upload.uploadstatuslist.presenter.w;
import com.bytedance.ee.bear.drive.biz.upload.uploadstatuslist.view.uploadlist.UploadListAdapter;
import com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsMvpFragment;
import com.bytedance.ee.bear.quoto.FullQuotoConfig;
import com.bytedance.ee.bear.quoto.SingleFileQuotaConfig;
import com.bytedance.ee.bear.quoto.t;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larksuite.framework.thread.CoreThreadPool;
import io.reactivex.Flowable;
import java.util.List;
import m75.d;
import on4.i;
import yu5.c;
import z65.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class UploadListFragment extends AbsMvpFragment<f> implements g {
    public static final /* synthetic */ int n = 0;
    public a g;
    public Dialog h;
    public TextView i;
    public UploadListAdapter j;
    public String k;
    public String l;
    public String m;

    public static final class a {
        public final View a;
        public BaseTitleBar b;
        public RecyclerView c;
        public SpaceEmptyState d;
        public final String e;

        public a(View r1, String r2) {
            this.a = r1;
            this.e = r2;
            this.b = r1.findViewById(2131391929);
            this.c = r1.findViewById(2131370340);
            this.d = r1.findViewById(2131391810);
            this.b.setLeftClickListener(new e(this));
        }
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsBaseFragment
    public final int getContentViewLayoutId() {
        return 2131560242;
    }

    @Override // a75.g
    public final String QD() {
        return this.j.e;
    }

    @Override // a75.g
    public final void sP() {
        this.j.notifyDataSetChanged();
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsBaseFragment
    public final void initData() {
        if (getArguments() == null) goto L5;
        this.k = getArguments().getString("mountNodeToken", "");
        this.l = getArguments().getString("mountPoint", "");
        this.m = getArguments().getString("spaceId", "");
        tt5.a.h("UpdateListTAG", "mountNodeTokens=" + c.j(this.k) + ", mountPoint=" + this.l);
    L5:
        DriveCommonConstants$DriveRustFgConfig r0 = (DriveCommonConstants$DriveRustFgConfig) com.bytedance.ee.bear.appsetting.c.a.a.c("drive_rust_config", DriveCommonConstants$DriveRustFgConfig.class, new DriveCommonConstants$DriveRustFgConfig());
    }

    public UploadListFragment() {
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsMvpFragment
    public final d V90(Context r2) {
        return new f((FragmentActivity) r2);
    }

    @Override // a75.g
    public final void aw(String r9) {
        FragmentActivity r1 = getActivity();
        if (r1 != null) goto L36;
        tt5.a.k("UpdateListTAG", "showUpdateErrorDialogIfNeed fail, activity is null");
        return;
    L36:
        int r3 = CastIntegerProtector.valueOf(r9).intValue();     // Catch: Throwable -> L9
    L10:
        t r4 = (t) org.koin.java.a.a(t.class);
        if (TextUtils.equals(String.valueOf(13001), r9) == false) goto L13;
        r4.j(r1, FullQuotoConfig.UPLOAD);
        return;
    L13:
        boolean r6 = true;
        if (r4.k(r3) == false) goto L23;
        if (TextUtils.isEmpty(this.k) == false) goto L18;
    L20:
        r6 = false;
    L21:
        r4.c(r1, "", "", r6, false, "");
        return;
    L18:
        if (TextUtils.equals(this.k, "all_files_token") == true) goto L20;
    L23:
        if (r4.s(r3) == false) goto L32;
        if (TextUtils.isEmpty(this.k) == false) goto L27;
    L29:
        r6 = false;
    L30:
        r4.c(r1, "", "", r6, true, "");
        return;
    L27:
        if (TextUtils.equals(this.k, "all_files_token") == true) goto L29;
    L32:
        if (TextUtils.equals(String.valueOf(90003043), r9) == false) goto L34;
        r4.f(r1, SingleFileQuotaConfig.UPLOAD, 0L);
        return;
    L34:
        tt5.a.k("UpdateListTAG", "showUpdateErrorDialogIfNeed fail, errorCode=" + r9);
        return;
    L9:
        tt5.a.d("UpdateListTAG", "parse errorcode err");
        r3 = 0;
        goto L10
    }

    @Override // a75.g
    public final void b60(List<b> r2) {
        this.j.a = r2;
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsBaseFragment
    public final void bindViews(View r3) {
        this.g = new a(r3, this.m);
    }

    @Override // a75.g
    public final void e50(List<b> r3) {
        if (hu5.a.d(r3) == false) goto L7;
        this.g.c.setVisibility(8);
        this.g.d.setVisibility(0);
        TextView r4 = this.i;
        if (r4 == null) goto L11;
        r4.setTextColor(getResources().getColor(2131106610));
        return;
    L11:
        return;
    L7:
        this.g.c.setVisibility(0);
        this.g.d.setVisibility(8);
        TextView r5 = this.i;
        if (r5 == null) goto L13;
        r5.setTextColor(getResources().getColor(2131105548));
        return;
    }

    @Override // a75.g
    public final void eH(boolean r2) {
        this.i.setEnabled(r2);
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsBaseFragment
    public final void initActions(View r6) {
        f r7 = (f) this.f;
        String r0 = this.k;
        String r1 = this.l;
        r7.getClass();
        w r2 = new w(CoreThreadPool.getSerialTaskHandler().getLooper(), (g) r7.a, r0, r1);
        r7.e = r2;
        r2.sendMessage(Message.obtain(r2, 10000));
        final h r8 = r7.e.a;
        r8.getClass();
        r8.a = new com.bytedance.ee.bear.drive.biz.upload.uploadstatuslist.presenter.g(r8);
        Flowable.just("").subscribeOn(fo5.d.b()).map(new com.bytedance.ee.bear.drive.biz.upload.uploadstatuslist.presenter.d()).doOnNext(new com.bytedance.ee.bear.drive.biz.upload.uploadstatuslist.presenter.e(r8)).subscribe(new i(), new com.bytedance.ee.bear.drive.biz.upload.uploadstatuslist.presenter.f());
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsBaseFragment
    public final void initViews(View r2, Bundle r3) {
        g85.f r4 = ((f) this.f).f;
        UploadListAdapter r5 = new UploadListAdapter();
        this.j = r5;
        r5.g = this.l;
        this.g.b.setTitle(getResources().getString(2131888456));
        String r6 = getResources().getString(2131888371);
        if (TextUtils.isEmpty(r6) == true) goto L5;
        a75.d r7 = new a75.d(this, r6);
    L6:
        this.i = (TextView) this.g.b.a(r7, true);
        LinearLayoutManager r8 = new LinearLayoutManager(getContext());
        this.g.c.setLayoutManager(r8);
        this.g.c.setAdapter(this.j);
        UploadListAdapter r9 = this.j;
        r9.c = new a75.a(this);
        r9.d = new a75.b(this);
        return;
    L5:
        r7 = null;
        goto L6
    }
}
