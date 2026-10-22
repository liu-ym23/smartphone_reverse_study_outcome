package com.bytedance.ee.bear.drive.biz.external;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.supervisor.token.Token;
import com.ss.android.lark.utils.n;
import java.lang.ref.WeakReference;
import java.util.Objects;
import s45.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OpenExternalFragment extends BaseFragment {
    public static final /* synthetic */ int h = 0;
    public String e;
    public String f;
    public f g;

    public static class a implements f.d {
        public final WeakReference<OpenExternalFragment> a;

        @Override // com.bytedance.ee.bear.drive.biz.external.f.d
        public final void c(w75.a r1) {
        }

        @Override // com.bytedance.ee.bear.drive.biz.external.f.d
        public final /* synthetic */ void f() {
        }

        @Override // com.bytedance.ee.bear.drive.biz.external.f.d
        public final void d() {
            tt5.a.d("DRIVE_OpenExternalFragment", "onStoragePermissionDenied");
        }

        public final void g() {
            if (this.a.get() == null) goto L6;
            OpenExternalFragment r0 = this.a.get();
            int r1 = OpenExternalFragment.h;
            r0.U90();
            return;
        }

        @Override // com.bytedance.ee.bear.drive.biz.external.f.d
        public final void b() {
            g();
        }

        @Override // com.bytedance.ee.bear.drive.biz.external.f.d
        public final void e() {
            g();
        }

        @Override // com.bytedance.ee.bear.drive.biz.external.f.d
        public final void onDismiss() {
            g();
        }

        public a(OpenExternalFragment r2) {
            this.a = new WeakReference(r2);
        }

        @Override // com.bytedance.ee.bear.drive.biz.external.f.d
        public final void a(int r2) {
            if (this.a.get() == null) goto L6;
            OpenExternalFragment r3 = this.a.get();
            int r0 = OpenExternalFragment.h;
            r3.U90();
            return;
        }
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onDestroy() {
        this.g.c();
        super.onDestroy();
    }

    public final void U90() {
        if (getActivity() != null) goto L5;
        return;
    L5:
        if (getActivity().isFinishing() == true) goto L9;
        getActivity().finish();
        return;
    }

    public OpenExternalFragment() {
    }

    /* JADX WARN: Type inference failed for: r6v10, types: [d55.a] */
    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onCreate(Bundle r6) {
        super.onCreate(r6);
        Bundle r7 = getArguments();
        Objects.requireNonNull(r7);
        this.e = r7.getString("url");
        String r8 = p.a().Z(this.e).b;
        if (r8 != null) goto L5;
        r8 = "";
    L5:
        this.f = r8;
        f r9 = new f(getActivity(), new a(this), new g(), new a95.a());
        this.g = r9;
        r9.a = new d(this);
        if (com.bytedance.ee.util.ui.b.a(getActivity()) == true) goto L8;
        tt5.a.h("DRIVE_OpenExternalFragment", "showFileStorageConfirmDialog activity finished");
        return;
    L8:
        final ?? r10 = new d55.a(this);
        if (getContext() != null) goto L11;
    L13:
        Toast.showFailureText(getContext(), getContext().getResources().getString(2131888446), 0);
        U90();
        return;
    L11:
        if ((getContext() instanceof Activity) == false) goto L13;
        com.ss.android.lark.utils.h.g((Activity) getContext(), new d55.b(this, r10), n.a(), new Token("LARK-PSDA-ccm_list_drive_open_external"), new String[0]);
    }
}
