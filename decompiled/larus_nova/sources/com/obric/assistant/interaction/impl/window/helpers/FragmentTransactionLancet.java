package com.obric.assistant.interaction.impl.window.helpers;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import me.ele.lancet.base.Origin;
import me.ele.lancet.base.This;

/* JADX INFO: loaded from: classes33.dex */
public class FragmentTransactionLancet {
    private static final int NO_CONTAINER_VIEW_ID = 0;

    public FragmentTransactionLancet() {
    }

    public FragmentTransaction add(int r100, Fragment r101) {
        Object r102 = This.get();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r102, r101, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, r100) == false) goto L7;
        return (FragmentTransaction) r102;
    L7:
        return (FragmentTransaction) Origin.call();
    }

    public FragmentTransaction replace(int r100, Fragment r101) {
        Object r102 = This.get();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r102, r101, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r100) == false) goto L7;
        return (FragmentTransaction) r102;
    L7:
        return (FragmentTransaction) Origin.call();
    }

    public FragmentTransaction add(Fragment r100, String r101) {
        Object r102 = This.get();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r102, r100, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r101, 0) == false) goto L7;
        return (FragmentTransaction) r102;
    L7:
        return (FragmentTransaction) Origin.call();
    }

    public FragmentTransaction add(int r100, Fragment r101, String r102) {
        Object r103 = This.get();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r103, r101, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r102, r100) == false) goto L7;
        return (FragmentTransaction) r103;
    L7:
        return (FragmentTransaction) Origin.call();
    }

    public FragmentTransaction replace(int r100, Fragment r101, String r102) {
        Object r103 = This.get();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r103, r101, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r102, r100) == false) goto L7;
        return (FragmentTransaction) r103;
    L7:
        return (FragmentTransaction) Origin.call();
    }
}
