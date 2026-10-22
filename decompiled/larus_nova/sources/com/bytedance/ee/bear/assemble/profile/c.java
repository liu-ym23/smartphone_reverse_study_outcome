package com.bytedance.ee.bear.assemble.profile;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.bizwidget.officesdk.CCMOfficeSDKAssembleFG;
import com.bytedance.ee.bear.lark.dependency.c0;
import com.bytedance.ee.bear.profile.HalfProfileLauncher;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.contact.export.ContactSource;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.profile.utils.IProfileLauncherV2;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import javax.inject.Inject;
import kotlin.Pair;

/* JADX INFO: loaded from: classes15.dex */
@UserScope
public final class c implements c0 {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f206288a = null;

        static {
            int[] r100 = new int[Chatter.ChatterType.values().length];
            f206288a = r100;
            r100[Chatter.ChatterType.USER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f206288a[Chatter.ChatterType.BOT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f206288a[Chatter.ChatterType.AI.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    @Override // com.bytedance.ee.bear.lark.dependency.c0
    public final void onDestroy() {
    }

    @Inject
    public c() {
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
        IProfileLauncherV2.f438837a.getClass();
        Fragment r105 = IProfileLauncherV2.Companion.a().newUserProfileFragmentV2(r103);
        return new Pair(r105, new OfficeProfilePageControllerAdapter(r105));
    }

    @Override // com.bytedance.ee.bear.lark.dependency.c0
    public final void eb(final Context r100, final String r110, final String r111, final boolean r112) {
        if (en4.a.j() == false) goto L6;
        tt5.a.h("IProfileDependency", "startUserProfile, isDolaHost, return");
        return;
    L6:
        RxScheduledExecutor.execInIO(new com.bytedance.ee.bear.assemble.profile.a(r110), new b(this, r112, r111, r100, r110));
    }

    @Override // com.bytedance.ee.bear.lark.dependency.c0
    public final void D1(Fragment r100, UserSession r101, String r102, String r103, String r104, String r105, c0.a r106) {
        if (r100 != null) goto L4;
    L14:
        tt5.a.h("IProfileDependency", "startHalfProfileInForseti, return");
        return;
    L4:
        if (r100.isAdded() == false) goto L14;
        if (r100.getContext() == null) goto L14;
        if (CCMOfficeSDKAssembleFG.a() == true) goto L12;
        eb(r100.getContext(), r102, r103, false);
        return;
    L12:
        HalfProfileLauncher.b(r100, r101, r102, r103, r104, r105, r106);
    }

    @Override // com.bytedance.ee.bear.lark.dependency.c0
    public final void Wb(FragmentActivity r100, FragmentManager r101, UserSession r102, String r103, String r104, String r105, String r106, c0.a r107) {
        if (CCMOfficeSDKAssembleFG.a() == true) goto L6;
        eb(r100, r103, r104, false);
        return;
    L6:
        HalfProfileLauncher.a(r100, r101, r102, r103, r104, r105, r106, r107);
    }
}
