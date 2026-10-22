package com.bytedance.awemeopen.apps.framework.landscape;

import com.bytedance.awemeopen.infra.base.log.AoLogger;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n implements k54.d {
    public final /* synthetic */ VideoLandscapeActivity a;

    public final b54.a a() {
        return null;
    }

    public final void b() {
    }

    public final void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "errorCode");
    }

    public final void e(boolean r1, String r2, k54.a r3) {
        Intrinsics.checkNotNullParameter(r2, "aid");
        Intrinsics.checkNotNullParameter(r3, "feedItemInfo");
    }

    public final void f() {
        AoLogger.b("LandscapeVideo", new Object[]{"onCommentPanelHide"});
    }

    public final void h() {
        AoLogger.b("LandscapeVideo", new Object[]{"onCommentPanelShow"});
    }

    public final void i() {
    }

    public final void onLoadError(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final void onLoadSuccess() {
    }

    public n(VideoLandscapeActivity r1) {
        this.a = r1;
    }

    public final void d(boolean r4) {
        AoLogger.b("LandscapeVideo", new Object[]{"autoPlayNextSwitchChange " + r4});
    }

    public final void g(String r3) {
        Intrinsics.checkNotNullParameter(r3, "aid");
        AoLogger.b("LandscapeVideo", new Object[]{"markDislike"});
        this.a.finish();
    }

    public final void j(k54.b r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Objects.toString(r2);
    }
}
