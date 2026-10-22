package com.larus.home.impl.sdk;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.larus.community.api.ICommunityService;
import com.larus.home.api.main.HomeService;
import com.larus.home.api.main.HomeServiceV2;
import com.larus.home.impl.main.tab.config.BottomTabConfigManager;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes29.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f346269a = null;

    static {
        f346269a = new y();
    }

    public y() {
    }

    public final int a() {
        BottomTabConfigManager r100 = BottomTabConfigManager.f345968a;
        Integer r101 = BottomTabConfigManager.i("address_book");
        if (r101 == null) goto L5;
        int r102 = r101.intValue();
        FLogger.f375446a.i("BottomTabConfigManager", "getAddressBookTabIndex index = " + r102);
    L6:
        if (r101 != null) goto L10;
        return 1;
    L10:
        return r101.intValue();
    L5:
        r101 = null;
        goto L6
    }

    public final int c() {
        BottomTabConfigManager r100 = BottomTabConfigManager.f345968a;
        Integer r101 = BottomTabConfigManager.i("bot_create");
        if (r101 != null) goto L5;
        r101 = BottomTabConfigManager.i("community_create");
    L5:
        if (r101 == null) goto L7;
        int r102 = r101.intValue();
        FLogger.f375446a.i("BottomTabConfigManager", "getCreateTabIndex index = " + r102);
    L8:
        if (r101 != null) goto L10;
        ICommunityService.Companion r103 = ICommunityService.f328743a;
        if (r103.f1().f() == true) goto L14;
    L16:
        return 5;
    L14:
        if (r103.f1().c() == true) goto L16;
        return 2;
    L10:
        return r101.intValue();
    L7:
        r101 = null;
        goto L8
    }

    public final int d() {
        BottomTabConfigManager r100 = BottomTabConfigManager.f345968a;
        Integer r101 = BottomTabConfigManager.i("bot_discovery");
        if (r101 == null) goto L5;
        int r102 = r101.intValue();
        FLogger.f375446a.i("BottomTabConfigManager", "getDiscoveryTabIndex index = " + r102);
    L6:
        if (r101 != null) goto L10;
        return 1;
    L10:
        return r101.intValue();
    L5:
        r101 = null;
        goto L6
    }

    public final int e() {
        BottomTabConfigManager r100 = BottomTabConfigManager.f345968a;
        Integer r101 = BottomTabConfigManager.i("drive");
        if (r101 == null) goto L5;
        int r102 = r101.intValue();
        FLogger.f375446a.i("BottomTabConfigManager", "getDriveTabIndex index = " + r102);
    L6:
        if (r101 != null) goto L10;
        return 1;
    L10:
        return r101.intValue();
    L5:
        r101 = null;
        goto L6
    }

    public final String f() {
        return HomeServiceV2.f344096a.a();
    }

    public final int g() {
        BottomTabConfigManager r100 = BottomTabConfigManager.f345968a;
        Integer r101 = BottomTabConfigManager.i("notice");
        if (r101 == null) goto L5;
        int r102 = r101.intValue();
        FLogger.f375446a.i("BottomTabConfigManager", "getNotifyTabIndex index = " + r102);
    L6:
        if (r101 != null) goto L8;
        ICommunityService.Companion r103 = ICommunityService.f328743a;
        if (r103.f1().f() == true) goto L12;
    L14:
        return 2;
    L12:
        if (r103.f1().c() == true) goto L14;
        return 3;
    L8:
        return r101.intValue();
    L5:
        r101 = null;
        goto L6
    }

    public final Fragment b(Activity r100) {
        Object r101 = HomeService.f344094a.a(r100);
        if ((r101 instanceof Fragment) == true) goto L7;
        return null;
    L7:
        return (Fragment) r101;
    }
}
