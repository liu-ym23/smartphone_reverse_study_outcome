package com.larus.login.impl.multiaccount;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.common.apphost.AppHost;
import com.larus.login.impl.AccountUtils;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.ttm.player.MediaPlayer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class g implements n38.k {
    public g() {
    }

    @Override // n38.k
    public final void a(n38.b r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        FLogger.f375446a.i("LogoutAutoSwitcher", "switch to next account failed");
        h.a();
    }

    @Override // n38.k
    public final void b(n38.b r110) {
        Intrinsics.checkNotNullParameter(r110, "result");
        FLogger r111 = FLogger.f375446a;
        r111.i("LogoutAutoSwitcher", "switch to next account success");
        int r100 = h.f358117a;
        Activity r101 = AppHost.f326268a.a().getCurrentActivity();
        Fragment r102 = null;
        if ((r101 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r103 = (FragmentActivity) r101;
    L6:
        if (r103 == null) goto L10;
        FragmentManager r104 = r103.getSupportFragmentManager();
        if (r104 == null) goto L10;
        r102 = r104.findFragmentById(R.id.fragment_container);
    L10:
        Fragment r105 = r102;
        if (r103 == null) goto L15;
        if (r105 == null) goto L15;
        AccountUtils r112 = AccountUtils.f357130a;
        AccountUtils.r(r103);
        AccountUtils.p(r103, r105, null, null, false, null, null, new e(), null, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_PTS_SYNCED_SEI_NOTIFICATION);
        AccountUtils.s("LogoutAutoSwitch");
        return;
    L15:
        r111.w("LogoutAutoSwitcher", "can not find fragment to attach, skip request launch and go back to login page");
        h.a();
        return;
    L5:
        r103 = null;
        goto L6
    }
}
