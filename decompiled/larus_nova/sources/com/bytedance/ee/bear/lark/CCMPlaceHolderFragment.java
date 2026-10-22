package com.bytedance.ee.bear.lark;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.lark.ai_notes.PadAINotesFragment;
import com.bytedance.ee.bear.lark.space.PadHomeDriveFragment;
import com.bytedance.ee.bear.lark.space.PadHomeMainFragment;
import com.bytedance.ee.bear.lark.space.PadOfflineFragment;
import com.bytedance.ee.bear.lark.space.PadWikiFragment;
import com.bytedance.ee.bear.list.homepage.navigation.NavigationEnum;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.api.bean.ForsetiViewMode;
import com.ss.android.lark.api.ui.ForsetiPlaceHolderFragment;
import com.ss.android.lark.utils.LarkContext;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0005J\u0010\u0010\u0017\u001a\u00020\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\b\u0010\u0018\u001a\u00020\u0012H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/lark/CCMPlaceHolderFragment;", "Lcom/ss/android/lark/api/ui/ForsetiPlaceHolderFragment;", "<init>", "()V", "mCurrentNavigationId", "", "mCurrentSubNavigationId", "kvStorage", "Lcom/bytedance/ee/bear/diskmanager/container/ICCMUserKVStorage;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "showFragment", "navigationId", "onSelected", "setKvStorage", "onDestroyView", "shouldRemovePlaceholderWhenCompact", "", "Companion", "contentmanager-lark-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CCMPlaceHolderFragment extends ForsetiPlaceHolderFragment {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f227169o = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f227170l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f227171m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public by4.d f227172n;

    public static final class a {
    }

    static {
        f227169o = NavigationEnum.HOME_PAGE.f228307id;
    }

    public CCMPlaceHolderFragment() {
        this.f227170l = -1;
        this.f227171m = -1;
    }

    @Override // com.ss.android.lark.api.ui.ForsetiPlaceHolderFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        tt5.a.h("CCMPlaceHolderFragment", "onDestroyView() called this:" + hashCode());
    }

    public final void S90(int r100) {
        com.ss.android.lark.forsetiutils.b r101 = com.ss.android.lark.forsetiutils.b.f424768a;
        FragmentActivity r102 = getActivity();
        r101.getClass();
        ForsetiViewMode r103 = com.ss.android.lark.forsetiutils.b.a(r102);
        StringBuilder r104 = new StringBuilder("onSelected() called with: navigationId = ");
        r104.append(r100);
        r104.append(" mCurrentNavigationId:");
        r104.append(this.f227170l);
        r104.append(" isAdded:");
        r104.append(isAdded());
        r104.append(" isDetached:");
        r104.append(!isDetached());
        r104.append(" mode:");
        r104.append(r103);
        tt5.a.h("CCMPlaceHolderFragment", r104.toString());
        if (this.f227170l != r100) goto L5;
        return;
    L5:
        if (r103 != null) goto L7;
    L51:
        this.f227170l = r100;
        return;
    L7:
        if (r103.isCompact() == true) goto L51;
        if (isAdded() == true) goto L12;
    L46:
        Iterator r105 = ((CopyOnWriteArrayList) this.f408694j.getValue()).iterator();
    L48:
        if (r105.hasNext() == false) goto L50;
        ((ForsetiPlaceHolderFragment.b) r105.next()).a(r100);
        goto L48
    L50:
        return;
    L12:
        if (isDetached() == true) goto L46;
        if (r100 != NavigationEnum.SIDEBAR_DRIVE.f228307id) goto L21;
        int r106 = PadHomeDriveFragment.f227546x;
        Bundle r107 = getArguments();
        PadHomeDriveFragment r108 = new PadHomeDriveFragment();
        if (r107 != null) goto L19;
        r107 = new Bundle();
    L19:
        r108.setArguments(r107);
        Fragment r109 = r108;
    L39:
        if (r109 != null) goto L41;
        tt5.a.k("CCMPlaceHolderFragment", "showFragment failed, fragment is null");
        goto L46
    L41:
        this.f227170l = r100;
        FragmentTransaction r110 = getChildFragmentManager().beginTransaction();
        boolean r111 = LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r110, r109, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, R.id.spacePlaceHolderFragment);
        FragmentTransaction r112 = r110;
        if (r111 == true) goto L45;
        r112 = r110.replace(R.id.spacePlaceHolderFragment, r109);
    L45:
        r112.commitAllowingStateLoss();
        tt5.a.h("CCMPlaceHolderFragment", "showFragment success fragment=" + r109);
        goto L46
    L21:
        if (r100 != NavigationEnum.MANUAL_OFFLINE.f228307id) goto L24;
        r109 = new PadOfflineFragment();
        goto L39
    L24:
        if (r100 != NavigationEnum.WIKI.f228307id) goto L27;
        r109 = new PadWikiFragment();
        goto L39
    L27:
        if (r100 != NavigationEnum.HOME_PAGE.f228307id) goto L33;
        int r113 = PadHomeMainFragment.f227547y;
        Bundle r114 = getArguments();
        PadHomeMainFragment r115 = new PadHomeMainFragment();
        if (r114 != null) goto L31;
        r114 = new Bundle();
    L31:
        r115.setArguments(r114);
        c r116 = new c(this);
        Intrinsics.checkNotNullParameter(r116, "listener");
        r115.f227548x = r116;
        r109 = r115;
        goto L39
    L33:
        if (r100 != NavigationEnum.AI_NOTE.f228307id) goto L38;
        int r117 = PadAINotesFragment.f227208y;
        Bundle r118 = getArguments();
        PadAINotesFragment r119 = new PadAINotesFragment();
        if (r118 != null) goto L37;
        r118 = new Bundle();
    L37:
        r119.setArguments(r118);
        r109 = r119;
        goto L39
    L38:
        r109 = null;
        goto L39
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        tt5.a.h("CCMPlaceHolderFragment", "onViewCreated() called with: view = " + r100 + ", savedInstanceState = " + r101);
        int r102 = this.f227170l;
        if (r102 == (-1)) goto L6;
        this.f227170l = -1;
        S90(r102);
        return;
    L6:
        Bundle r103 = getArguments();
        if (r103 == null) goto L9;
        S90(r103.getInt("key_navigation_id"));
        return;
    L9:
        S90(f227169o);
    }

    @Override // com.ss.android.lark.api.ui.ForsetiPlaceHolderFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Context r103 = getContext();
        if (r103 != null) goto L5;
        r103 = LarkContext.getApplication();
    L5:
        FrameLayout r104 = new FrameLayout(r103);
        r104.setId(R.id.spacePlaceHolderFragment);
        return r104;
    }
}
