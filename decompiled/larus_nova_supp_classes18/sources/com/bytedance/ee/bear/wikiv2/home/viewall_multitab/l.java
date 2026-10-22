package com.bytedance.ee.bear.wikiv2.home.viewall_multitab;

import android.R;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.search.SelectPickerConfig;
import com.bytedance.ee.bear.search.SelectTabConfig;
import com.bytedance.ee.bear.search.picker.filter.wiki.WikiSearchPickerFragment;
import com.bytedance.ee.bear.wikiv2.searchv2.enh.WikiSearchbar;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.picker.statistics.PickerStatistics;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l implements WikiSearchbar.c {
    public final /* synthetic */ WikiSpaceTabFragment a;

    @Override // com.bytedance.ee.bear.wikiv2.searchv2.enh.WikiSearchbar.c
    public final void a() {
        SelectTabConfig r7 = new SelectTabConfig(false, false, false);
        SelectPickerConfig r10 = new SelectPickerConfig(PickerStatistics.Scene.CcmSearchWikiSpace, false, true, false, null, null, r7, 48, null);
        Bundle r0 = this.a.getArguments();
        if (r0 == null) goto L5;
        r0.putSerializable("KEY_PICKER_CONFIG", r10);
    L5:
        WikiSearchPickerFragment r1 = ((com.bytedance.ee.bear.search.b) org.koin.java.a.c(com.bytedance.ee.bear.search.b.class, null, null, 6)).c(this.a.getContext(), this.a.getArguments());
        WikiSpaceTabFragment r2 = this.a;
        Intrinsics.checkNotNull(r1);
        int r3 = WikiSpaceTabFragment.j;
        r2.getClass();
        if (ForsetiHelper.s(r2) == false) goto L12;
        FragmentTransaction r4 = r2.getParentFragmentManager().beginTransaction().setCustomAnimations(2130772290, 2130772289, 2130772288, 2130772293);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r4, r1, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131385861) == true) goto L11;
        r4 = r4.add(2131385861, r1);
    L11:
        r4.addToBackStack(null).commitAllowingStateLoss();
        return;
    L12:
        FragmentActivity r5 = r2.getActivity();
        if (r5 == null) goto L30;
        FragmentManager r6 = r5.getSupportFragmentManager();
        if (r6 == null) goto L31;
        FragmentTransaction r8 = r6.beginTransaction();
        if (r8 == null) goto L32;
        FragmentTransaction r9 = r8.setCustomAnimations(2130772290, 2130772289, 2130772288, 2130772293);
        if (r9 != null) goto L21;
        return;
    L21:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r9, r1, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, R.id.content) == true) goto L24;
        r9 = r9.add(R.id.content, r1);
    L24:
        if (r9 == null) goto L34;
        FragmentTransaction r11 = r9.addToBackStack(null);
        if (r11 == null) goto L35;
        r11.commitAllowingStateLoss();
        return;
    L35:
        return;
    L34:
        return;
    L32:
        return;
    L31:
        return;
    }

    @Override // com.bytedance.ee.bear.wikiv2.searchv2.enh.WikiSearchbar.c
    public final void onExitSearch() {
        WikiSpaceTabFragment r0 = this.a;
        if (r0.i > 0) goto L6;
        r0.i = r0.V90().getHeight();
    L6:
        if (r0.V90().getHeight() > 0) goto L8;
        com.bytedance.ee.util.ui.g.b(r0.V90(), 0, r0.i).start();
    L8:
        WikiSpaceTabViewModel r1 = this.a.h;
        WikiSpaceTabViewModel r2 = null;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r1 = null;
    L11:
        r1.setInSearching(false);
        WikiSpaceTabViewModel r3 = this.a.h;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L15:
        r2.clearSearchInput();
        return;
    L14:
        r2 = r3;
        goto L15
    }

    public l(WikiSpaceTabFragment r1) {
        this.a = r1;
    }
}
