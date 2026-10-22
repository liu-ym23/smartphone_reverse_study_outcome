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
import com.bytedance.ee.bear.lark.ai_notes.PadAINotesFragment;
import com.bytedance.ee.bear.lark.space.PadHomeDriveFragment;
import com.bytedance.ee.bear.lark.space.PadHomeMainFragment;
import com.bytedance.ee.bear.lark.space.PadOfflineFragment;
import com.bytedance.ee.bear.lark.space.PadWikiFragment;
import com.bytedance.ee.bear.list.homepage.navigation.NavigationEnum;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.api.bean.ForsetiViewMode;
import com.ss.android.lark.api.ui.ForsetiPlaceHolderFragment;
import com.ss.android.lark.utils.LarkContext;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0005J\u0010\u0010\u0017\u001a\u00020\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\b\u0010\u0018\u001a\u00020\u0012H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/lark/CCMPlaceHolderFragment;", "Lcom/ss/android/lark/api/ui/ForsetiPlaceHolderFragment;", "<init>", "()V", "mCurrentNavigationId", "", "mCurrentSubNavigationId", "kvStorage", "Lcom/bytedance/ee/bear/diskmanager/container/ICCMUserKVStorage;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "showFragment", "navigationId", "onSelected", "setKvStorage", "onDestroyView", "shouldRemovePlaceholderWhenCompact", "", "Companion", "contentmanager-lark-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CCMPlaceHolderFragment extends ForsetiPlaceHolderFragment {
    public static final int o = 0;
    public int l;
    public int m;
    public by4.d n;

    public static final class a {
    }

    static {
        o = NavigationEnum.HOME_PAGE.id;
    }

    public CCMPlaceHolderFragment() {
        this.l = -1;
        this.m = -1;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        tt5.a.h("CCMPlaceHolderFragment", "onDestroyView() called this:" + hashCode());
    }

    public final void S90(int r7) {
        com.ss.android.lark.forsetiutils.b r0 = com.ss.android.lark.forsetiutils.b.a;
        FragmentActivity r1 = getActivity();
        r0.getClass();
        ForsetiViewMode r2 = com.ss.android.lark.forsetiutils.b.a(r1);
        StringBuilder r3 = new StringBuilder("onSelected() called with: navigationId = ");
        r3.append(r7);
        r3.append(" mCurrentNavigationId:");
        r3.append(this.l);
        r3.append(" isAdded:");
        r3.append(isAdded());
        r3.append(" isDetached:");
        r3.append(!isDetached());
        r3.append(" mode:");
        r3.append(r2);
        tt5.a.h("CCMPlaceHolderFragment", r3.toString());
        if (this.l != r7) goto L5;
        return;
    L5:
        if (r2 != null) goto L7;
    L51:
        this.l = r7;
        return;
    L7:
        if (r2.isCompact() == true) goto L51;
        if (isAdded() == true) goto L12;
    L46:
        Iterator r4 = ((CopyOnWriteArrayList) ((ForsetiPlaceHolderFragment) this).j.getValue()).iterator();
    L48:
        if (r4.hasNext() == false) goto L50;
        ((ForsetiPlaceHolderFragment.b) r4.next()).a(r7);
        goto L48
    L50:
        return;
    L12:
        if (isDetached() == true) goto L46;
        if (r7 != NavigationEnum.SIDEBAR_DRIVE.id) goto L21;
        int r5 = PadHomeDriveFragment.x;
        Bundle r6 = getArguments();
        PadHomeDriveFragment r8 = new PadHomeDriveFragment();
        if (r6 != null) goto L19;
        r6 = new Bundle();
    L19:
        r8.setArguments(r6);
        Fragment r9 = r8;
    L39:
        if (r9 != null) goto L41;
        tt5.a.k("CCMPlaceHolderFragment", "showFragment failed, fragment is null");
        goto L46
    L41:
        this.l = r7;
        FragmentTransaction r10 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r10, r9, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131387025) == true) goto L45;
        r10 = r10.replace(2131387025, r9);
    L45:
        r10.commitAllowingStateLoss();
        tt5.a.h("CCMPlaceHolderFragment", "showFragment success fragment=" + r9);
        goto L46
    L21:
        if (r7 != NavigationEnum.MANUAL_OFFLINE.id) goto L24;
        r9 = new PadOfflineFragment();
        goto L39
    L24:
        if (r7 != NavigationEnum.WIKI.id) goto L27;
        r9 = new PadWikiFragment();
        goto L39
    L27:
        if (r7 != NavigationEnum.HOME_PAGE.id) goto L33;
        int r11 = PadHomeMainFragment.y;
        Bundle r12 = getArguments();
        PadHomeMainFragment r13 = new PadHomeMainFragment();
        if (r12 != null) goto L31;
        r12 = new Bundle();
    L31:
        r13.setArguments(r12);
        c r14 = new c(this);
        Intrinsics.checkNotNullParameter(r14, "listener");
        r13.x = r14;
        r9 = r13;
        goto L39
    L33:
        if (r7 != NavigationEnum.AI_NOTE.id) goto L38;
        int r16 = PadAINotesFragment.y;
        Bundle r17 = getArguments();
        PadAINotesFragment r18 = new PadAINotesFragment();
        if (r17 != null) goto L37;
        r17 = new Bundle();
    L37:
        r18.setArguments(r17);
        r9 = r18;
        goto L39
    L38:
        r9 = null;
        goto L39
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r3, r4);
        tt5.a.h("CCMPlaceHolderFragment", "onViewCreated() called with: view = " + r3 + ", savedInstanceState = " + r4);
        int r5 = this.l;
        if (r5 == (-1)) goto L6;
        this.l = -1;
        S90(r5);
        return;
    L6:
        Bundle r6 = getArguments();
        if (r6 == null) goto L9;
        S90(r6.getInt("key_navigation_id"));
        return;
    L9:
        S90(o);
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        Context r4 = getContext();
        if (r4 != null) goto L5;
        r4 = LarkContext.getApplication();
    L5:
        FrameLayout r5 = new FrameLayout(r4);
        r5.setId(2131387025);
        return r5;
    }
}
