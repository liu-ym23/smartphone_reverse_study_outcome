package com.bytedance.awemeopen.apps.framework.landscape;

import com.bytedance.awemeopen.infra.base.log.AoLogger;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class n implements k54.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VideoLandscapeActivity f197180a;

    @Override // k54.c
    public final b54.a a() {
        return null;
    }

    @Override // k54.d
    public final void b() {
    }

    @Override // k54.d
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "errorCode");
    }

    @Override // k54.c
    public final void e(boolean r100, String r101, k54.a r102) {
        Intrinsics.checkNotNullParameter(r101, "aid");
        Intrinsics.checkNotNullParameter(r102, "feedItemInfo");
    }

    @Override // k54.d
    public final void f() {
        AoLogger.b("LandscapeVideo", new Object[]{"onCommentPanelHide"});
    }

    @Override // k54.d
    public final void h() {
        AoLogger.b("LandscapeVideo", new Object[]{"onCommentPanelShow"});
    }

    @Override // k54.d
    public final void i() {
    }

    @Override // k54.c
    public final void onLoadError(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
    }

    @Override // k54.c
    public final void onLoadSuccess() {
    }

    public n(VideoLandscapeActivity r100) {
        this.f197180a = r100;
    }

    @Override // k54.d
    public final void d(boolean r100) {
        AoLogger.b("LandscapeVideo", new Object[]{"autoPlayNextSwitchChange " + r100});
    }

    @Override // k54.c
    public final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "aid");
        AoLogger.b("LandscapeVideo", new Object[]{"markDislike"});
        this.f197180a.finish();
    }

    @Override // k54.c
    public final void j(k54.b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Objects.toString(r100);
    }
}
