package com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.ss.android.lark.insets.WindowInsetsUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class RequestLinkPasswordFragment extends BaseFragment implements g.a {
    public static final /* synthetic */ int k = 0;
    public String e;
    public int f;
    public boolean g;
    public Runnable h;
    public g i;
    public View j;

    public final void onDestroyView() {
        g r0 = this.i;
        if (r0 == null) goto L5;
        r0.destroy();
    L5:
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    @Override // com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.g.a
    public final void RN() {
        dismissAllowingStateLoss();
        Runnable r0 = this.h;
        if (r0 == null) goto L6;
        r0.run();
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.g.a
    public final void c8() {
        if (getActivity() == null) goto L6;
        getActivity().onBackPressed();
        return;
    }

    public final void dismissAllowingStateLoss() {
        if (isAdded() == true) goto L6;
        tt5.a.k("RequestLinkPasswordFragment", "dismiss skipped because fragment is not added");
        return;
    L6:
        tt5.a.h("RequestLinkPasswordFragment", "dismiss by owning fragment manager");
        getParentFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
    }

    public RequestLinkPasswordFragment() {
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        if (r2 == null) goto L6;
        tt5.a.d("RequestLinkPasswordFragment", "onCreate savedInstanceState is not null");
        dismissAllowingStateLoss();
        return;
    L6:
        Bundle r3 = getArguments();
        if (r3 == null) goto L9;
        this.e = r3.getString(ResourceData.KEY_OBJ_TOKEN);
        this.f = r3.getInt(ResourceData.KEY_TYPE);
        this.g = r3.getBoolean("extraShowBack");
        return;
    L9:
        tt5.a.d("RequestLinkPasswordFragment", "getArguments is null");
        dismissAllowingStateLoss();
    }

    public final void onViewCreated(View r9, Bundle r10) {
        super.onViewCreated(r9, r10);
        if (AppInfoUtils.f().booleanValue() == false) goto L6;
        com.ss.android.lark.insets.f r11 = WindowInsetsUtils.b(this);
        r11.c(true);
        r11.o(true);
        tt5.a.h("RequestLinkPasswordFragment", "bind window insets for OfficeSDK fragment");
    L6:
        FragmentActivity r1 = getActivity();
        d r2 = new d(this.e, this.f);
        FragmentActivity r0 = getActivity();
        View r3 = this.j;
        boolean r4 = this.g;
        ii5.b r5 = (ii5.b) org.koin.java.a.a(ii5.b.class);     // Catch: Throwable -> L9
    L11:
        g r12 = new g(r1, r2, r5.c(r0, r3, r4), this, false);
        this.i = r12;
        r12.create();
        return;
    L9:
        th = move-exception;
        tt5.a.e("RequestLinkPasswordFragment", "get request password page factory failed, fallback default", th, false);
        r5 = ii5.a.a;
        goto L11
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        ii5.b r0 = (ii5.b) org.koin.java.a.a(ii5.b.class);     // Catch: Throwable -> L5
    L7:
        View r7 = r4.inflate(r0.a(), r5, false);
        this.j = r7;
        return r7;
    L5:
        th = move-exception;
        tt5.a.e("RequestLinkPasswordFragment", "get request password page factory failed, fallback default", th, false);
        r0 = ii5.a.a;
        goto L7
    }
}
