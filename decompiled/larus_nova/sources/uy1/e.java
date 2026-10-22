package uy1;

import android.content.Context;
import com.bytedance.android.anya.q;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gift.grouplive.component.GroupComponentFacade;
import com.bytedance.android.livesdk.gift.grouplive.component.k;
import com.bytedance.android.livesdk.gift.grouplive.component.m;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.scope.o;
import com.ss.android.lark.utils.statistics.PerfLog;
import cy0.j;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.i;
import mz0.n;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q f552070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m f552071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public GroupComponentFacade f552072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.livesdk.revenue.service.ui.b f552073d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f552074e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CompositeDisposable f552075f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final k f552076g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f552077h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.service.room.c f552078i;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        CompositeDisposable r100 = this.f552075f;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f552075f = null;
    }

    public static boolean d(int r100) {
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.g.f130534n.getValue(null, com.bytedance.android.livesdk.gift.platform.core.g.f130521a[11])).booleanValue() == true) goto L5;
    L9:
        return false;
    L5:
        if (r100 != 6) goto L7;
    L8:
        return true;
    L7:
        if (r100 != 7) goto L9;
        goto L8
    }

    public e(k r100, Context r101, com.bytedance.android.livesdk.revenue.service.room.c r102) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "roomService");
        this.f552076g = r100;
        this.f552077h = r101;
        this.f552078i = r102;
    }

    public final aq2.a c(int r100, int r101, int r102, int r103) {
        ALogger.d("GroupCard", "Third Row Count:shortTouchCount(" + r100 + "),normalBannerCount(" + r101 + "),activityBannerCount(" + r102 + ')');
        com.bytedance.android.livesdk.revenue.service.sti.a r104 = (com.bytedance.android.livesdk.revenue.service.sti.a) com.bytedance.android.scope.m.f163449e.d(this.f552076g, com.bytedance.android.livesdk.revenue.service.sti.a.class);
        if (r104 == null) goto L10;
        r104.Io();
        if (((r100 + r101) + r102) > 0) goto L10;
        if (d(r103) == true) goto L10;
        float r105 = 74.0f;
    L12:
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == true) goto L14;
    L18:
        this.f552074e = (r100 + r101) + r102;
        return new aq2.a(new aq2.b(s1.f(12.0f), s1.f(r105 + 8.0f), s1.f(12.0f), s1.f(52.0f)), true, 9);
    L14:
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L18;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L18;
        r105 = r105 + UtilityKotlinExtentionsKt.k(StatusBarUtil.getStatusBarHeight(this.f552077h));
    L10:
        r105 = 128.0f;
        goto L12
    }

    public static final void a(e r100, int r101, int r102, int r103, int r104) {
        com.bytedance.android.livesdk.revenue.service.ui.b r105 = r100.f552073d;
        if (r105 == null) goto L15;
        int r106 = (r101 + r102) + r103;
        if (r100.f552074e <= 0) goto L8;
        if (r106 == 0) goto L9;
    L10:
        boolean r107 = false;
    L11:
        r105.a(r100.c(r101, r102, r103, r104));
        if (r107 == false) goto L16;
        n r108 = new n();
        mz0.m r109 = new mz0.m();
        r109.b(LogCommon.ROOM);
        List<Object> r110 = r108.f516448b;
        ArrayList r111 = (ArrayList) r110;
        r111.addAll(r109.f516446a);
        cy0.e.f465759a.getClass();
        j r112 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r113 = com.bytedance.android.scope.m.b(r112).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r113);
        ((i) ((f80.a) r113)).w3("livesdk_group_playmode_widget_conflict", r108.f516447a, r108.f516448b);
        return;
    L16:
        return;
    L9:
        r107 = true;
        goto L11
    L8:
        if (r106 <= 0) goto L10;
    }
}
