package com.bytedance.awemeopen.apps.framework.feed.pinch.presenter;

import android.view.View;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.framework.livedata.DiscardFirstValueLiveData;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class g0 extends b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f195720h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f195721i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final f0 f195722j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a f195723k;

    public static final class a implements com.bytedance.awemeopen.infra.base.player.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g0 f195724a;

        @Override // com.bytedance.awemeopen.infra.base.player.k
        public final void c(String r100) {
        }

        @Override // com.bytedance.awemeopen.infra.base.player.k
        public final void d(String r100, long r101, int r102) {
        }

        @Override // com.bytedance.awemeopen.infra.base.player.k
        public final void e(String r100, int r101, String r102) {
        }

        @Override // com.bytedance.awemeopen.infra.base.player.k
        public final void f(String r100, boolean r101, int r102, int r103) {
        }

        @Override // com.bytedance.awemeopen.infra.base.player.k
        public final void g(String r100, boolean r101, String r102) {
        }

        @Override // com.bytedance.awemeopen.infra.base.player.k
        public final void onPlayPrepare(String r100) {
        }

        public a(g0 r100) {
            this.f195724a = r100;
        }

        @Override // com.bytedance.awemeopen.infra.base.player.k
        public final void h(String r100) {
            sz3.c r101 = this.f195724a.f195702b;
            if (r101 == null) goto L7;
            r14.c r102 = r101.f543930f;
            if (r102 == null) goto L7;
            String r103 = r102.c();
        L9:
            if (Intrinsics.areEqual(r100, r103) == true) goto L11;
            return;
        L11:
            g0 r104 = this.f195724a;
            if (r104.f195720h == true) goto L14;
            r104.g("click_screen");
        L14:
            g0 r105 = this.f195724a;
            r105.f195720h = false;
            r105.f195721i = false;
            return;
        L7:
            r103 = null;
            goto L9
        }

        @Override // com.bytedance.awemeopen.infra.base.player.k
        public final void onPlaying(String r100) {
            sz3.c r101 = this.f195724a.f195702b;
            if (r101 == null) goto L7;
            r14.c r102 = r101.f543930f;
            if (r102 == null) goto L7;
            String r103 = r102.c();
        L9:
            if (Intrinsics.areEqual(r100, r103) == true) goto L11;
            return;
        L11:
            g0 r104 = this.f195724a;
            if (r104.f195721i == true) goto L14;
            r104.h("click_screen");
        L14:
            g0 r105 = this.f195724a;
            r105.f195720h = false;
            r105.f195721i = false;
            return;
        L7:
            r103 = null;
            goto L9
        }

        @Override // com.bytedance.awemeopen.infra.base.player.k
        public final void l(String r100, com.bytedance.awemeopen.infra.base.player.l r101) {
            Intrinsics.checkNotNullParameter(r101, "playerStatusInfo");
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.b
    public final void e() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.b
    public final void c() {
        sz3.c r100 = this.f195702b;
        if (r100 == null) goto L7;
        qz3.b r101 = r100.f543933i;
        if (r101 == null) goto L7;
        r101.p(r100.f543926b, this.f195722j);
    L7:
        sz3.c r102 = this.f195702b;
        if (r102 == null) goto L13;
        com.bytedance.awemeopen.apps.framework.framework.viewpager.o r103 = r102.f543927c;
        if (r103 == null) goto L14;
        r103.addPlayStateListener(this.f195723k);
        return;
    L14:
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.b
    public final void f() {
        sz3.c r100 = this.f195702b;
        if (r100 == null) goto L7;
        qz3.b r101 = r100.f543933i;
        if (r101 == null) goto L7;
        r101.y(this.f195722j);
    L7:
        sz3.c r102 = this.f195702b;
        if (r102 == null) goto L13;
        com.bytedance.awemeopen.apps.framework.framework.viewpager.o r103 = r102.f543927c;
        if (r103 == null) goto L14;
        r103.removePlayStateListener(this.f195723k);
        return;
    L14:
        return;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.f0] */
    public g0(View r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        super(r100);
        this.f195722j = new f0(this);
        this.f195723k = new a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v32 */
    public final void g(String r100) {
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r101 = this.f195703c;
        if (r101 != null) goto L5;
        return;
    L5:
        int r102 = com.bytedance.awemeopen.bizmodels.user.d.f198220a;
        Intrinsics.checkNotNull(r101);
        sz3.c r103 = r101.f195843d;
        if (r103 == null) goto L8;
        r14.c r104 = r103.f543930f;
    L10:
        if (com.bytedance.awemeopen.bizmodels.user.d.b(r104) == false) goto L12;
        return;
    L12:
        LinkedHashMap r105 = new LinkedHashMap();
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r106 = this.f195703c;
        Intrinsics.checkNotNull(r106);
        sz3.c r107 = r106.f195843d;
        String r108 = "";
        if (r107 == null) goto L16;
        String r109 = r107.f543929e;
        if (r109 == null) goto L16;
    L17:
        r105.put("enter_from", r109);
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r110 = this.f195703c;
        Intrinsics.checkNotNull(r110);
        sz3.c r111 = r110.f195843d;
        if (r111 == null) goto L23;
        r14.c r112 = r111.f543930f;
        if (r112 == null) goto L23;
        String r113 = r112.c();
        if (r113 == null) goto L23;
    L24:
        r105.put("group_id", r113);
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r114 = this.f195703c;
        Intrinsics.checkNotNull(r114);
        sz3.c r115 = r114.f195843d;
        if (r115 == null) goto L34;
        r14.c r116 = r115.f543930f;
        if (r116 == null) goto L34;
        User r117 = r116.f();
        if (r117 == null) goto L34;
        String r118 = r117.u();
        if (r118 == null) goto L34;
        r108 = r118;
    L34:
        r105.put("author_id", r108);
        r105.put("enter_method", r100);
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r119 = this.f195703c;
        Intrinsics.checkNotNull(r119);
        sz3.c r120 = r119.f195843d;
        ?? r121 = 0;
        r121 = 0;
        r121 = 0;
        if (r120 == null) goto L39;
        r14.c r122 = r120.f543930f;
        if (r122 == null) goto L39;
        int r123 = r122.q();
    L40:
        r105.put("item_duration", Integer.valueOf(r123));
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r124 = this.f195703c;
        Intrinsics.checkNotNull(r124);
        sz3.c r125 = r124.f195843d;
        if (r125 == null) goto L47;
        qz3.b r126 = r125.f543933i;
        if (r126 == null) goto L47;
        int r127 = 1;
        if (r126.A() != true) goto L47;
    L48:
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r128 = this.f195703c;
        Intrinsics.checkNotNull(r128);
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r129 = r128.f195840a;
        if (r129 == null) goto L55;
        com.bytedance.awemeopen.apps.framework.framework.viewpager.o r130 = r129.f195163c;
        if (r130 == null) goto L55;
        DiscardFirstValueLiveData<Boolean> r131 = r130.getEnterPinchMode();
        if (r131 == null) goto L55;
        r121 = Intrinsics.areEqual(r131.getValue(), Boolean.TRUE);
    L55:
        r105.put("pinch_zoom", Integer.valueOf(r121));
        r105.put("pure_zoom", Integer.valueOf(r127));
        AosEventReporter.s(AosEventReporter.f194596a, "video_play_pause", r105, null, null, null, 28);
        return;
    L47:
        r127 = 0;
    L39:
        r123 = 0;
    L23:
        r113 = "";
    L16:
        r109 = "";
        goto L17
    L8:
        r104 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    public final void h(String r100) {
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r101 = this.f195703c;
        if (r101 != null) goto L5;
        return;
    L5:
        int r102 = com.bytedance.awemeopen.bizmodels.user.d.f198220a;
        Intrinsics.checkNotNull(r101);
        sz3.c r103 = r101.f195843d;
        if (r103 == null) goto L8;
        r14.c r104 = r103.f543930f;
    L10:
        if (com.bytedance.awemeopen.bizmodels.user.d.b(r104) == false) goto L12;
        return;
    L12:
        LinkedHashMap r105 = new LinkedHashMap();
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r106 = this.f195703c;
        Intrinsics.checkNotNull(r106);
        sz3.c r107 = r106.f195843d;
        String r108 = "";
        if (r107 == null) goto L16;
        String r109 = r107.f543929e;
        if (r109 == null) goto L16;
    L17:
        r105.put("enter_from", r109);
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r110 = this.f195703c;
        Intrinsics.checkNotNull(r110);
        sz3.c r111 = r110.f195843d;
        if (r111 == null) goto L23;
        r14.c r112 = r111.f543930f;
        if (r112 == null) goto L23;
        String r113 = r112.c();
        if (r113 == null) goto L23;
    L24:
        r105.put("group_id", r113);
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r114 = this.f195703c;
        Intrinsics.checkNotNull(r114);
        sz3.c r115 = r114.f195843d;
        if (r115 == null) goto L34;
        r14.c r116 = r115.f543930f;
        if (r116 == null) goto L34;
        User r117 = r116.f();
        if (r117 == null) goto L34;
        String r118 = r117.u();
        if (r118 == null) goto L34;
        r108 = r118;
    L34:
        r105.put("author_id", r108);
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r119 = this.f195703c;
        Intrinsics.checkNotNull(r119);
        sz3.c r120 = r119.f195843d;
        ?? r121 = 0;
        r121 = 0;
        r121 = 0;
        if (r120 == null) goto L39;
        r14.c r122 = r120.f543930f;
        if (r122 == null) goto L39;
        int r123 = r122.q();
    L40:
        r105.put("item_duration", Integer.valueOf(r123));
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r124 = this.f195703c;
        Intrinsics.checkNotNull(r124);
        sz3.c r125 = r124.f195843d;
        if (r125 == null) goto L47;
        qz3.b r126 = r125.f543933i;
        if (r126 == null) goto L47;
        int r127 = 1;
        if (r126.A() != true) goto L47;
    L48:
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r128 = this.f195703c;
        Intrinsics.checkNotNull(r128);
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r129 = r128.f195840a;
        if (r129 == null) goto L55;
        com.bytedance.awemeopen.apps.framework.framework.viewpager.o r130 = r129.f195163c;
        if (r130 == null) goto L55;
        DiscardFirstValueLiveData<Boolean> r131 = r130.getEnterPinchMode();
        if (r131 == null) goto L55;
        r121 = Intrinsics.areEqual(r131.getValue(), Boolean.TRUE);
    L55:
        r105.put("pinch_zoom", Integer.valueOf(r121));
        r105.put("pure_zoom", Integer.valueOf(r127));
        if (Intrinsics.areEqual(r100, DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON) == false) goto L60;
        if (r127 == 0) goto L59;
        r100 = "click_play_button";
        goto L60
    L59:
        r100 = DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON;
    L60:
        r105.put("enter_method", r100);
        AosEventReporter.s(AosEventReporter.f194596a, "feed_screen_video_play", r105, null, null, null, 28);
        return;
    L47:
        r127 = 0;
    L39:
        r123 = 0;
    L23:
        r113 = "";
    L16:
        r109 = "";
        goto L17
    L8:
        r104 = null;
        goto L10
    }
}
