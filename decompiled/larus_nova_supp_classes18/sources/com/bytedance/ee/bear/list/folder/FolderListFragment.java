package com.bytedance.ee.bear.list.folder;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseCCMForsetiFragment;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import e0c.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class FolderListFragment extends BaseCCMForsetiFragment implements FolderRouteFragment.b, d0c.c {
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public int m;
    public String n;
    public int o;
    public int p;
    public boolean q;
    public boolean r;
    public Fragment s;
    public boolean t;

    public final void afterUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    public final void onResume() {
        super.onResume();
        if (TextUtils.isEmpty(this.f) == true) goto L6;
        lc5.f.h(this.f);
        return;
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m13provideComponent() {
        return provideComponent();
    }

    public FolderListFragment() {
    }

    @Override // com.bytedance.ee.bear.list.folder.FolderRouteFragment.b
    public final void lc(int r4) {
        Bundle r0 = new Bundle();
        r0.putString(ResourceData.KEY_TOKEN, this.f);
        r0.putString(ResourceData.KEY_URL, this.g);
        W90(r0, r4);
    }

    public final void W90(Bundle r4, int r5) {
        if (FolderVersion.isShareFolderV2(Integer.valueOf(r5)) == false) goto L5;
        String r6 = SubFolderFragment.class.getName();
    L6:
        tt5.a.h("FolderListFragment", "initFragment()...fragmentName = ".concat(r6));
        this.s = Fragment.instantiate(requireContext(), r6, r4);
        FragmentTransaction r7 = getChildFragmentManager().beginTransaction();
        Fragment r8 = this.s;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r7, r8, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L10;
        r7 = r7.replace(2131373275, r8);
    L10:
        r7.commitAllowingStateLoss();
        return;
    L5:
        r6 = FolderDetailFragment.class.getName();
        goto L6
    }

    public final void onViewCreated(View r17, Bundle r18) {
        super.onViewCreated(r17, r18);
        requireActivity().getWindow().setBackgroundDrawable(new ColorDrawable(ResourcesCompat.getColor(getResources(), 2131100548, null)));
        Bundle r1 = getArguments();
        if (r1 != null) goto L5;
        tt5.a.k("FolderListFragment", "initData: arguments is empty ");
    L7:
        if (this.t == false) goto L13;
        Bundle r2 = new Bundle();
        r2.putString(ResourceData.KEY_URL, this.g);
        r2.putString(ResourceData.KEY_TOKEN, this.f);
        Fragment r3 = Fragment.instantiate(requireContext(), FolderRouteFragment.class.getName(), r2);
        FragmentTransaction r4 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r4, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L12;
        r4 = r4.replace(2131373275, r3);
    L12:
        r4.commitAllowingStateLoss();
        return;
    L13:
        Bundle r5 = new Bundle();
        r5.putString(ResourceData.KEY_TOKEN, this.f);
        r5.putString("title", this.h);
        r5.putString("parent_space_id", this.i);
        r5.putString("current_module", this.k);
        r5.putString("source", this.l);
        r5.putInt("depth", this.m);
        r5.putString(ResourceData.KEY_TYPE, this.n);
        r5.putInt("permission", this.o);
        r5.putBoolean("is_external", this.q);
        r5.putBoolean("is_personal_folder", this.r);
        r5.putString("parent_token", this.j);
        W90(r5, this.p);
        return;
    L5:
        this.f = r1.getString(ResourceData.KEY_TOKEN);
        this.g = r1.getString(ResourceData.KEY_URL);
        this.h = r1.getString("title");
        this.i = r1.getString("parent_space_id");
        this.k = r1.getString("current_module");
        this.l = r1.getString("source");
        this.m = r1.getInt("depth", 0);
        this.n = r1.getString(ResourceData.KEY_TYPE);
        this.p = r1.getInt("owner_type", 0);
        this.o = r1.getInt("permission", 2);
        this.q = r1.getBoolean("is_external", false);
        this.r = r1.getBoolean("is_personal_folder", false);
        this.j = r1.getString("parent_token");
        this.t = r1.getBoolean("open_route", false);
        goto L7
    }

    public final void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        Fragment r0 = this.s;
        if (r0 == null) goto L6;
        r0.onActivityResult(r2, r3, r4);
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131561199, r3, false);
    }
}
