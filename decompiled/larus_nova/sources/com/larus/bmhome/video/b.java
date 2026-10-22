package com.larus.bmhome.video;

import com.larus.bmhome.auth.FeedItemConfig;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.model.repo.SettingRepoDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.platform.model.chat.ChatAwemeFeedConfig;
import com.larus.platform.service.e2;
import com.larus.platform.service.z2;
import com.larus.utils.i;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f315193a = null;

    public b() {
    }

    static {
        f315193a = LazyKt.lazy(new a());
    }

    public static Pair a() {
        e2 r100 = e2.f365734a;
        if (r100.isPad() == true) goto L5;
    L7:
        int r101 = 4;
        if (r100.isPad() == false) goto L13;
        if (AppHost.f326268a.getApplication().getResources().getConfiguration().orientation != 1) goto L13;
        return new Pair(4, 4);
    L13:
        if (((ChatAwemeFeedConfig) f315193a.getValue()).getShouldFullyDisplay() == false) goto L16;
        r101 = 2;
    L16:
        return new Pair(Integer.valueOf(r101), 2);
    L5:
        if (AppHost.f326268a.getApplication().getResources().getConfiguration().orientation != 2) goto L7;
        return new Pair(5, 5);
    }

    public static String e() {
        if (SettingRepoDelegate.f307752b.R0() == false) goto L5;
        String r100 = AppHost.f326268a.getApplication().getString(R.string.larus_db_feed_recommend_tip_cn);
        Intrinsics.checkNotNull(r100);
        return r100;
    L5:
        String r101 = AppHost.f326268a.getApplication().getString(R.string.larus_db_feed_recommend_tip_psnlOFF_cn);
        Intrinsics.checkNotNull(r101);
        return r101;
    }

    public static boolean f() {
        LaunchInfo r100 = AuthModelDelegate.f297134b.x().getValue();
        if (r100 == null) goto L9;
        FeedItemConfig r101 = r100.F0();
        if (r101 == null) goto L9;
        if (r101.b() != 3) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == true) goto L12;
        return false;
    L12:
        if (SettingRepoDelegate.f307752b.q0() == false) goto L16;
        return true;
    L16:
        return false;
    L9:
        r102 = false;
        goto L10
    }

    public static boolean g() {
        LaunchInfo r100 = AuthModelDelegate.f297134b.x().getValue();
        if (r100 == null) goto L9;
        FeedItemConfig r101 = r100.F0();
        if (r101 == null) goto L9;
        if (r101.b() != 4) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == true) goto L12;
        return false;
    L12:
        if (SettingRepoDelegate.f307752b.q0() == false) goto L16;
        return true;
    L16:
        return false;
    L9:
        r102 = false;
        goto L10
    }

    public static int b(boolean r100) {
        if (r100 == true) goto L4;
    L6:
        int r101 = c7.b(Integer.valueOf(z2.f365865a.getAwemeVideoFeedConfig().d()));
    L8:
        return r101 / 2;
    L4:
        if (f() == true) goto L6;
        r101 = c7.b(Integer.valueOf(z2.f365865a.getAwemeVideoFeedConfig().e()));
        goto L8
    }

    public static int c(boolean r100) {
        if (r100 == false) goto L7;
        if (f() == true) goto L7;
        return c7.b(Float.valueOf(z2.f365865a.getAwemeVideoFeedConfig().c()));
    L7:
        return c7.b(Float.valueOf(z2.f365865a.getAwemeVideoFeedConfig().b()));
    }

    public static int d(int r100, int r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = i.d(AppHost.f326268a.getApplication());
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 2;
    L8:
        int r103 = c7.b(Integer.valueOf(z2.f365865a.getAwemeVideoFeedConfig().d()));
        return (((r100 - r103) - r103) - ((r101 - 1) * r103)) / r101;
    }
}
