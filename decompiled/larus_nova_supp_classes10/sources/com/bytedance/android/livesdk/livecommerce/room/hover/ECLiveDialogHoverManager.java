package com.bytedance.android.livesdk.livecommerce.room.hover;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.model.live.LiveClearScreenMode;
import com.bytedance.android.ec.model.live.LiveScreenMoveMode;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.utils.ECLiveClearScreenHelper;
import com.bytedance.android.livesdk.livecommerce.utils.ECDisplayUtils;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import wj2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECLiveDialogHoverManager {
    public static final /* synthetic */ int j = 0;
    public final List<LiveClearScreenMode> a;
    public final List<LiveScreenMoveMode> b;
    public final List<String> c;
    public final ECLiveDialogHoverManager$fragmentLifecycleCallback$1 d;
    public final FragmentManager e;
    public final Context f;
    public final String g;
    public final String h;
    public final boolean i;

    public static final class a {
        public static boolean a(int r4) {
            Integer r0 = ECLiveABUtils.INSTANCE.getECOM_PDP_PANEL_CLEAR_LIVE_PENDANT_TYPE();
            if (r0 != null) goto L6;
        L7:
            if (r0 != null) goto L10;
        L12:
            if (r0 != null) goto L15;
        L18:
            return false;
        L15:
            if (r0.intValue() != 1) goto L18;
            if (r4 >= 1) goto L18;
            return true;
        L10:
            if (r0.intValue() != 2) goto L12;
            if (r4 < 1) goto L12;
            return true;
        L6:
            if (r0.intValue() != 3) goto L7;
            return true;
        }
    }

    static {
    }

    public static String d(Fragment r2) {
        return Reflection.getOrCreateKotlinClass(r2.getClass()).getSimpleName() + '@' + r2.hashCode();
    }

    public final void a(boolean r10) {
        int r0 = ECSdk.a;
        IAdapterService r1 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r1 == null) goto L6;
        int r3 = (int) ((ECDisplayUtils.a(this.f) * 73) / 100.0f);
        int r2 = h.a;
        r1.notifyPanelEventByLiveCard(r10, r3, ((Number) EComABUtils.getLiveSettingValue("ec_live_list_panel_event_open_animator_duration", 300L)).longValue(), ((Number) EComABUtils.getLiveSettingValue("ec_live_list_panel_event_close_animator_duration", 200L)).longValue(), ((Boolean) EComABUtils.getLiveSettingValue("ec_live_list_panel_event_sync_notify", Boolean.TRUE)).booleanValue());
        return;
    }

    public final void b(Fragment r3, LiveClearScreenMode r4, LiveScreenMoveMode r5) {
        Intrinsics.checkNotNullParameter(r3, "f");
        Intrinsics.checkNotNullParameter(r4, "clearScreenMode");
        Intrinsics.checkNotNullParameter(r5, "screenMoveMode");
        LiveClearScreenMode r0 = LiveClearScreenMode.CLEAR_SCREEN_MODE_NONE;
        if (r4 == r0) goto L5;
    L7:
        String r6 = d(r3);
        if (((ArrayList) this.c).contains(r6) == true) goto L10;
        return;
    L10:
        ((ArrayList) this.c).remove(r6);
        if (this.i == false) goto L25;
        if (r4 == r0) goto L25;
        ((ArrayList) this.a).remove(r4);
        LiveClearScreenMode r7 = LiveClearScreenMode.CLEAR_SCREEN_MODE_HALF;
        if (r4 == r7) goto L16;
        List<LiveClearScreenMode> r8 = this.a;
        ArrayList r9 = (ArrayList) r8;
        if (r9.contains(LiveClearScreenMode.CLEAR_SCREEN_MODE_FULL) == true) goto L25;
        if (((ArrayList) this.a).contains(r7) == false) goto L23;
        ECLiveClearScreenHelper.a(3, this.g, this.h);
        goto L25
    L23:
        ECLiveClearScreenHelper.a(5, this.g, this.h);
        goto L25
    L16:
        if (((ArrayList) this.a).isEmpty() == false) goto L25;
        ECLiveClearScreenHelper.a(4, this.g, this.h);
    L25:
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_ENABLE_CARD_ADAPTATION() == 1) goto L27;
        return;
    L27:
        if (r5 == LiveScreenMoveMode.LIVE_SCREEN_MOVE_NONE) goto L33;
        ((ArrayList) this.b).remove(r5);
        if (((ArrayList) this.b).isEmpty() == false) goto L34;
        a(false);
        return;
    L34:
        return;
    L33:
        return;
    L5:
        if (r5 != LiveScreenMoveMode.LIVE_SCREEN_MOVE_NONE) goto L7;
    }

    public final void c(Fragment r4, LiveClearScreenMode r5, LiveScreenMoveMode r6) {
        Intrinsics.checkNotNullParameter(r4, "f");
        Intrinsics.checkNotNullParameter(r5, "clearScreenMode");
        Intrinsics.checkNotNullParameter(r6, "screenMoveMode");
        LiveClearScreenMode r0 = LiveClearScreenMode.CLEAR_SCREEN_MODE_NONE;
        if (r5 == r0) goto L5;
    L7:
        String r7 = d(r4);
        if (((ArrayList) this.c).contains(r7) == false) goto L10;
        return;
    L10:
        ((ArrayList) this.c).add(r7);
        if (this.i == false) goto L26;
        if (r5 == r0) goto L26;
        LiveClearScreenMode r8 = LiveClearScreenMode.CLEAR_SCREEN_MODE_HALF;
        if (r5 == r8) goto L16;
        List<LiveClearScreenMode> r1 = this.a;
        ArrayList r2 = (ArrayList) r1;
        if (r2.contains(LiveClearScreenMode.CLEAR_SCREEN_MODE_FULL) == false) goto L21;
    L24:
        ((ArrayList) this.a).add(r5);
        goto L26
    L21:
        if (((ArrayList) this.a).contains(r8) == false) goto L23;
        ECLiveClearScreenHelper.a(2, this.g, this.h);
        goto L24
    L23:
        ECLiveClearScreenHelper.a(6, this.g, this.h);
        goto L24
    L16:
        if (((ArrayList) this.a).isEmpty() == false) goto L24;
        ECLiveClearScreenHelper.a(1, this.g, this.h);
    L26:
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_ENABLE_CARD_ADAPTATION() == 1) goto L28;
        return;
    L28:
        if (r6 != LiveScreenMoveMode.LIVE_SCREEN_MOVE_NONE) goto L30;
        return;
    L30:
        if (((ArrayList) this.b).isEmpty() == false) goto L32;
        a(true);
    L32:
        ((ArrayList) this.b).add(r6);
        return;
    L5:
        if (r6 != LiveScreenMoveMode.LIVE_SCREEN_MOVE_NONE) goto L7;
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks, com.bytedance.android.livesdk.livecommerce.room.hover.ECLiveDialogHoverManager$fragmentLifecycleCallback$1] */
    public ECLiveDialogHoverManager(Context r2, String r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.i = r5;
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new ArrayList();
        ?? r6 = new ECLiveDialogHoverManager$fragmentLifecycleCallback$1(this);
        this.d = r6;
        FragmentManager r7 = null;
        if ((r2 instanceof FragmentActivity) == true) goto L5;
        r2 = null;
    L5:
        FragmentActivity r8 = (FragmentActivity) r2;
        if (r8 == null) goto L8;
        r7 = r8.getSupportFragmentManager();
    L8:
        this.e = r7;
        dm.a.a("LiveHover").i("Register fragmentLifecycleCallback");
        if (r7 == null) goto L12;
        r7.registerFragmentLifecycleCallbacks(r6, false);
        return;
    }
}
