package com.bytedance.awemeopen.bizmodels.user;

import com.larus.bmhome.share.panel.ShareChannel;
import com.ss.ttvideoengine.strategrycenter.IStrategyStateSupplier;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f198216a = 0;

    static {
    }

    public static String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "aoLoginType");
        if (Intrinsics.areEqual(r100, IStrategyStateSupplier.KEY_INFO_LIKE) == false) goto L5;
        return "commend";
    L5:
        String r101 = "comment";
        if (Intrinsics.areEqual(r100, "comment") == true) goto L32;
        r101 = "share";
        if (Intrinsics.areEqual(r100, "share") == true) goto L32;
        if (Intrinsics.areEqual(r100, ShareChannel.COLLECT) == false) goto L15;
        return "video_collect_single";
    L15:
        if (Intrinsics.areEqual(r100, "my_collect") == false) goto L18;
        return "video_my_collection";
    L18:
        if (Intrinsics.areEqual(r100, "mix") == false) goto L21;
        return "collect_group";
    L21:
        if (Intrinsics.areEqual(r100, "group_follow") == false) goto L23;
        boolean r102 = true;
    L24:
        if (r102 == false) goto L27;
        return "follow";
    L27:
        if (Intrinsics.areEqual(r100, "click_report") == false) goto L29;
        return "report";
    L29:
        return "default";
    L23:
        r102 = Intrinsics.areEqual(r100, "profile_follow");
    L32:
        return r101;
    }
}
