package com.bytedance.ee.bear.list.sidebar.homedrive;

import ad5.e;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import ce5.a;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.list.folder.HomePersonalFragment;
import com.bytedance.ee.bear.list.homepage.banner.f;
import com.bytedance.ee.bear.list.homepage.tab.HomeTabEnum;
import com.bytedance.ee.bear.list.share.NewShareFolderFragment;
import com.bytedance.ee.bear.list.sidebar.homedrive.pinfolder.banner.SidebarPinFolderHeader;
import com.bytedance.ee.bear.widgets.button.CommonCreateButton;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.ContextsKt;
import d0c.b;
import d0c.c;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import dd5.m1;
import dd5.s1;
import e0c.l;
import f0c.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import lc5.g;
import lc5.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u000bH\u0014J\b\u0010\u000f\u001a\u00020\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\u0014\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0013H\u0016J\b\u0010\u001a\u001a\u00020\u000bH\u0002J\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u000bH\u0016J\b\u0010\u001e\u001a\u00020\u000bH\u0014J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/list/sidebar/homedrive/SidebarHomeDriveFragment;", "Lcom/bytedance/ee/bear/list/drive/HomeDriveFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "Lcom/bytedance/ee/bear/list/list/SpaceNotificationService$OnPinItemListener;", "<init>", "()V", "pinFolderHeader", "Lcom/bytedance/ee/bear/list/sidebar/homedrive/pinfolder/banner/SidebarPinFolderHeader;", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "onCreateViewLazy", "", "savedInstanceState", "Landroid/os/Bundle;", "onResumeLazy", "initPinFolderHeader", "onDestroy", "getMenuNameResId", "Lkotlin/Pair;", "", "getLayoutResId", "provideHomeTabs", "", "Lcom/bytedance/ee/bear/list/homepage/tab/HomeTabInfo;", "onClickSwitchTab", "index", "reportDrivePageClick", "getSubModule", "", "onPinItemSuccess", "onDestroyViewLazy", "getContext", "Landroid/content/Context;", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SidebarHomeDriveFragment extends Hilt_SidebarHomeDriveFragment implements c, m1 {
    public SidebarPinFolderHeader s;

    public final void afterUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // com.bytedance.ee.bear.list.drive.HomeDriveFragment
    public final int ba0() {
        return 2131563513;
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ m getPassport() {
        return b.a(this);
    }

    public final void onUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ l provideComponent() {
        return b.b(this);
    }

    @Override // dd5.m1
    public final void Jl() {
        SidebarPinFolderHeader r0 = this.s;
        if (r0 == null) goto L6;
        ((f) ((com.bytedance.ee.bear.list.sidebar.homedrive.pinfolder.banner.b) r0.g.getValue()).getModel()).m5();
        return;
    }

    public final void W90() {
        s1.a.a.h(this);
    }

    @Override // com.bytedance.ee.bear.list.drive.HomeDriveFragment
    public final Pair<Integer, Integer> ca0() {
        return new Pair(2131889621, 2131889636);
    }

    @Override // com.bytedance.ee.bear.list.drive.HomeDriveFragment
    public final List<e> ea0() {
        ArrayList r0 = new ArrayList();
        r0.add(new e(HomeTabEnum.PERSONAL_FOLDER.id, ((Number) ca0().getFirst()).intValue(), HomePersonalFragment.class.getName()));
        r0.add(new e(HomeTabEnum.SHARE_FOLDER.id, ((Number) ca0().getSecond()).intValue(), NewShareFolderFragment.class.getName()));
        return r0;
    }

    public final void Y90() {
        super.Y90();
        SidebarPinFolderHeader r0 = this.s;
        if (r0 == null) goto L5;
        ((f) ((com.bytedance.ee.bear.list.sidebar.homedrive.pinfolder.banner.b) r0.g.getValue()).getModel()).m5();
    L5:
        lc5.f.a.M("ccm_space_drive_page_view", "new_drive", "none", null);
    }

    public final UserSession e9() {
        if ((getActivity() instanceof c) == false) goto L6;
        c r0 = getActivity();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.passportc.convention.view.UserScopeView");
        return r0.e9();
    L6:
        return new a().b;
    }

    @Override // com.bytedance.ee.bear.list.sidebar.homedrive.Hilt_SidebarHomeDriveFragment
    public Context getContext() {
        Context r0 = super.getContext();
        if (r0 != null) goto L7;
        return null;
    L7:
        return ContextsKt.findActivity(r0);
    }

    public final void onDestroy() {
        super/*com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment*/.onDestroy();
        SidebarPinFolderHeader r0 = this.s;
        if (r0 == null) goto L6;
        ((com.bytedance.ee.bear.list.sidebar.homedrive.pinfolder.banner.b) r0.g.getValue()).destroy();
        return;
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m47provideComponent() {
        return provideComponent();
    }

    public SidebarHomeDriveFragment() {
    }

    @Override // com.bytedance.ee.bear.list.drive.HomeDriveFragment
    public final void V90(Bundle r4) {
        super.V90(r4);
        a r5 = new a(this);
        if (qc5.a.e(r5) == false) goto L7;
        Context r0 = getContext();
        if (r0 == null) goto L7;
        this.s = new SidebarPinFolderHeader(r0, this, findViewById(2131374280), r5);
    L7:
        SidebarPinFolderHeader r6 = this.s;
        if (r6 == null) goto L10;
        ((com.bytedance.ee.bear.list.sidebar.homedrive.pinfolder.banner.b) r6.g.getValue()).create();
    L10:
        s1.a.a.a(this);
    }

    @Override // com.bytedance.ee.bear.list.drive.HomeDriveFragment
    public final void da0(int r15) {
        CommonCreateButton r16 = this.p;
        if (r16 != null) goto L5;
    L9:
        lc5.f.a r17 = lc5.f.a;
        int r1 = this.o;
        if (r1 != 0) goto L12;
        String r5 = WikiSpaceType.PERSONAL;
    L13:
        if (r1 != 0) goto L15;
        String r11 = WikiSpaceType.PERSONAL;
    L16:
        Intrinsics.checkNotNullParameter(new k(r5, r11), "param");
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L27
        lc5.f.a.b(r17, new g(r0, "new_drive", r5, "", 0, "", "", "", ""));     // Catch: Exception -> L27
        if (TextUtils.isEmpty(r11) == true) goto L21;
        r0.put("click", r11);     // Catch: Exception -> L27
    L21:
        if (TextUtils.isEmpty(null) == true) goto L23;
        r0.put("target", null);     // Catch: Exception -> L27
    L23:
        d r18 = lc5.f.a.d();     // Catch: Exception -> L27
        if (r18 == null) goto L31;
        r18.i("ccm_space_drive_page_click", r0);     // Catch: Exception -> L27
        return;
    L31:
        return;
    L27:
        tt5.a.d("ListAnalysis", "reportSidebarDrivePageClick error");
        return;
    L15:
        r11 = "shared";
        goto L16
    L12:
        r5 = "shared";
        goto L13
    L5:
        if (this.o != 0) goto L7;
        int r2 = 0;
    L8:
        r16.setVisibility(r2);
        goto L9
    L7:
        r2 = 8;
        goto L8
    }
}
