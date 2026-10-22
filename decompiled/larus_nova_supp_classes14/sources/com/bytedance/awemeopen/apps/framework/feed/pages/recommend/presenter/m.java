package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.export.api.pageconfig.recfeed.FeedPageConfig;
import com.bytedance.awemeopen.infra.base.settings.AoSettings;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ VideoFeedGesturePresenter a;

    public m(VideoFeedGesturePresenter r1) {
        this.a = r1;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent r13) {
        Intrinsics.checkNotNullParameter(r13, "e");
        VideoFeedGesturePresenter r0 = this.a;
        r0.j = true;
        if (r0.e.c.getPageConfig().isLandscapeFullscreen() == false) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this.a.e.c.getEnterPinchMode().getValue(), Boolean.TRUE) == true) goto L45;
        boolean r1 = !this.a.e.c.getPageConfig().getHideLongPressTab();
        JSONObject r2 = AoSettings.a("ao_feed_long_press_config");
        if (r2 == null) goto L10;
        r1 = r2.optBoolean("enable_long_press_panel", r1);
    L10:
        if (r1 == true) goto L12;
        return;
    L12:
        if (this.a.e.c.getPageConfig().isTeenagerModel() == true) goto L43;
        this.a.m(r13);
        VideoFeedGesturePresenter r3 = this.a;
        if (r13 != null) goto L16;
        r3.getClass();
        return;
    L16:
        FeedPageConfig r4 = r3.e.c.getPageConfig();
        float r8 = r13.getRawX() / com.bytedance.awemeopen.apps.framework.utils.d0.d(r3.getContext());
        float r9 = r13.getRawY() / com.bytedance.awemeopen.apps.framework.utils.d0.c(r3.getContext());
        AosEventReporter r14 = AosEventReporter.a;
        jz3.a r5 = r3.p;
        jz3.a r6 = null;
        if (r5 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r5 = null;
    L19:
        User r7 = r5.a.f();
        if (r7 == null) goto L23;
        String r10 = r7.u();
        if (r10 == null) goto L23;
    L24:
        String r11 = r3.e.c.sceneId();
        jz3.a r12 = r3.p;
        if (r12 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r12 = null;
    L27:
        String r15 = r12.a.c();
        jz3.a r16 = r3.p;
        if (r16 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r16 = null;
    L30:
        r14.a0 r17 = r16.a.d;
        if (r17 == null) goto L34;
        String r18 = r17.a();
        if (r18 == null) goto L34;
    L35:
        String r19 = r4.getPreviousPage();
        jz3.a r20 = r3.p;
        if (r20 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L39:
        com.bytedance.awemeopen.apps.framework.utils.e r110 = new com.bytedance.awemeopen.apps.framework.utils.e(r6.a);
        r14.getClass();
        AosEventReporter.J(r10, r11, r15, r18, r8, r9, r19, r110);
        return;
    L38:
        r6 = r20;
    L34:
        r18 = "";
    L23:
        r10 = "";
        goto L24
    L43:
        return;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent r3, MotionEvent r4, float r5, float r6) {
        if (r3 == null) goto L10;
        if (r4 == null) goto L10;
        if ((r3.getRawX() - r4.getRawX()) <= 300.0f) goto L10;
        Function0<Unit> r0 = this.a.g.a;
        if (r0 == null) goto L10;
        r0.invoke();
    L10:
        return super.onFling(r3, r4, r5, r6);
    }
}
