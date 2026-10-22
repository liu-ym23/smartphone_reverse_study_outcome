package com.ss.android.lark.integrator.ccm.dependency.di;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.profile.HalfProfileLauncher;
import com.ss.android.lark.contact.export.ContactSource;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.profile_api.IProfileApi;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import javax.inject.Inject;
import kotlin.Pair;

/* JADX INFO: loaded from: classes36.dex */
@UserScope
public final class n1 implements com.bytedance.ee.bear.lark.dependency.c0 {
    @Override // com.bytedance.ee.bear.lark.dependency.c0
    public final void onDestroy() {
    }

    @Inject
    public n1() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.c0
    public final Pair<Fragment, r1c.a> j4(UserSession r100, String r101, String r102) {
        Bundle r103 = new Bundle();
        r103.putString("param_key_user_id", r101);
        ContactSource r104 = new ContactSource();
        r104.setSourceType(4);
        r104.setSourceName(r102);
        r103.putSerializable("param_key_source", r104);
        PassportcConvention.h(r103, r100);
        return ((IProfileApi) ApiUtils.getApi(IProfileApi.class)).buildProfileFragment(r103);
    }

    @Override // com.bytedance.ee.bear.lark.dependency.c0
    public final void eb(final Context r100, final String r101, final String r102, final boolean r103) {
        RxScheduledExecutor.execInIO(new l1(r101), new m1(r100, r101, r102, r103));
    }

    @Override // com.bytedance.ee.bear.lark.dependency.c0
    public final void D1(Fragment r100, UserSession r101, String r102, String r103, String r104, String r105, com.bytedance.ee.bear.lark.dependency.c0.a r106) {
        HalfProfileLauncher.b(r100, r101, r102, r103, r104, r105, r106);
    }

    @Override // com.bytedance.ee.bear.lark.dependency.c0
    public final void Wb(FragmentActivity r100, FragmentManager r101, UserSession r102, String r103, String r104, String r105, String r106, com.bytedance.ee.bear.lark.dependency.c0.a r107) {
        HalfProfileLauncher.a(r100, r101, r102, r103, r104, r105, r106, r107);
    }
}
