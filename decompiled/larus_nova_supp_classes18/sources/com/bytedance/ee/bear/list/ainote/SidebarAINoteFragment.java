package com.bytedance.ee.bear.list.ainote;

import android.content.Context;
import android.os.Bundle;
import ce5.a;
import com.bytedance.ee.bear.list.homepage.banner.f;
import com.bytedance.ee.bear.list.sidebar.homedrive.pinfolder.banner.SidebarPinFolderHeader;
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
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u000bH\u0014J\b\u0010\u000f\u001a\u00020\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0014J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/list/ainote/SidebarAINoteFragment;", "Lcom/bytedance/ee/bear/list/ainote/AINoteFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "Lcom/bytedance/ee/bear/list/list/SpaceNotificationService$OnPinItemListener;", "<init>", "()V", "pinFolderHeader", "Lcom/bytedance/ee/bear/list/sidebar/homedrive/pinfolder/banner/SidebarPinFolderHeader;", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "onCreateViewLazy", "", "savedInstanceState", "Landroid/os/Bundle;", "onResumeLazy", "initPinFolderHeader", "onDestroy", "getLayoutResId", "", "getSubModule", "", "onPinItemSuccess", "onDestroyViewLazy", "getContext", "Landroid/content/Context;", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SidebarAINoteFragment extends Hilt_SidebarAINoteFragment implements c, m1 {
    public SidebarPinFolderHeader s;

    public final void afterUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // com.bytedance.ee.bear.list.ainote.AINoteFragment
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

    public final void Y90() {
        super.Y90();
        SidebarPinFolderHeader r0 = this.s;
        if (r0 == null) goto L5;
        ((f) ((com.bytedance.ee.bear.list.sidebar.homedrive.pinfolder.banner.b) r0.g.getValue()).getModel()).m5();
    L5:
        lc5.f.a r1 = lc5.f.a;
        int r2 = this.o;
        if (r2 != 0) goto L9;
        String r3 = "ai_note_owned_by_me";
    L12:
        r1.M("ccm_space_ai_notes_view", r3, "none", null);
        return;
    L9:
        if (r2 != 1) goto L11;
        r3 = "ai_note_my_involved";
        goto L12
    L11:
        r3 = "ai_note_share_with_me";
        goto L12
    }

    public final UserSession e9() {
        if ((getActivity() instanceof c) == false) goto L6;
        c r0 = getActivity();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.passportc.convention.view.UserScopeView");
        return r0.e9();
    L6:
        return new a().b;
    }

    @Override // com.bytedance.ee.bear.list.ainote.Hilt_SidebarAINoteFragment
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
    public final /* bridge */ /* synthetic */ Object m2provideComponent() {
        return provideComponent();
    }

    public SidebarAINoteFragment() {
    }

    @Override // com.bytedance.ee.bear.list.ainote.AINoteFragment
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
}
