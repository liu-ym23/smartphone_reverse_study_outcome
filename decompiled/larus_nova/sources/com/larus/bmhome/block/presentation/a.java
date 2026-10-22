package com.larus.bmhome.block.presentation;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.chat.block.base.config.BlockDetailRequest;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kc8.c;
import kc8.d;
import kc8.y;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f296419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<y> f296420b;

    /* JADX INFO: renamed from: com.larus.bmhome.block.presentation.a$a, reason: collision with other inner class name */
    public static final class C4021a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kc8.d
    public final void a(BlockDetailRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Fragment r101 = this.f296419a;
    L3:
        FragmentActivity r102 = null;
        if (r101 == 0) goto L9;
        if ((r101 instanceof c) == true) goto L7;
        r101 = r101.getParentFragment();
        goto L3
    L7:
        c r103 = (c) r101;
    L10:
        if (r103 == null) goto L14;
        boolean r104 = true;
        if (r103.FV(r100) != true) goto L14;
    L15:
        if (r104 == false) goto L17;
        return;
    L17:
        Fragment r105 = this.f296419a;
        if (r105 == null) goto L20;
        FragmentActivity r106 = r105.getActivity();
    L22:
        if ((r106 instanceof FragmentActivity) == true) goto L25;
        r106 = null;
    L25:
        if (r106 != null) goto L32;
        Activity r107 = AppHost.f326268a.a().getCurrentActivity();
        if ((r107 instanceof FragmentActivity) == false) goto L29;
        r102 = (FragmentActivity) r107;
    L29:
        if (r102 != null) goto L31;
        return;
    L31:
        r106 = r102;
    L32:
        FragmentManager r108 = r106.getSupportFragmentManager();
        if (r108.isStateSaved() == false) goto L35;
    L45:
        FLogger.f375446a.w("BlockDetailNavigator", "skip open block detail because fragment state is saved");
        return;
    L35:
        if (r108.isDestroyed() == true) goto L45;
        String r109 = "BlockDetailDialogFragment_" + r100.getBlock();
        if (r108.findFragmentByTag(r109) != null) goto L53;
        int r110 = BlockDetailDialogFragment.f296402i;
        y r111 = this.f296420b.invoke();
        Intrinsics.checkNotNullParameter(r100, "request");
        BlockDetailDialogFragment.b.f296408a = r111;
        BlockDetailDialogFragment r112 = new BlockDetailDialogFragment();
        Bundle r113 = new Bundle();
        r113.putSerializable("arg_block_detail_request", r100);
        r112.setArguments(r113);
        LandscapeRestrictionOperation r114 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r112, r109, r114);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r108, r112, r114) == true) goto L54;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L47
    L44:
        r112.show(r108, r109);
        return;
    L54:
        return;
    L53:
        return;
    L20:
        r106 = null;
    L14:
        r104 = false;
        goto L15
    L9:
        r103 = null;
        goto L10
    }

    public a(Fragment r100, Function0<y> r101) {
        Intrinsics.checkNotNullParameter(r101, "globalConfigProvider");
        this.f296419a = r100;
        this.f296420b = r101;
    }
}
