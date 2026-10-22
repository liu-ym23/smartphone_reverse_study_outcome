package com.bytedance.android.livesdk.live;

import android.app.Activity;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.utils.personalfeed.PersonalizedFeedUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LivePlayItemHelper {
    public boolean a;
    public boolean b;
    public String c;
    public boolean d;
    public boolean e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;

    public static final class a {
    }

    static {
    }

    public LivePlayItemHelper() {
        this.c = "";
        this.f = LazyKt.lazy(LivePlayItemHelper$optStopRoom$2.INSTANCE);
        this.g = LazyKt.lazy(LivePlayItemHelper$optDetailStopRoom$2.INSTANCE);
        this.h = LazyKt.lazy(LivePlayItemHelper$optStopRoomNotLimitScene$2.INSTANCE);
    }

    public final boolean a(Activity r6) {
        ALogger.i("LivePlayItemHelper", "canInterceptRoomStop roomId:" + this.c + ", isInRoom:" + this.b + ", optStopRoom:" + ((Boolean) this.f.getValue()) + ", act:" + r6);
        if (this.a == false) goto L5;
        return false;
    L5:
        if (r6 != null) goto L8;
        return false;
    L8:
        if (b(r6) == true) goto L20;
        if (((Boolean) this.g.getValue()).booleanValue() == true) goto L12;
    L14:
        boolean r7 = false;
    L15:
        ALogger.i("LivePlayItemHelper", "isDetailActivityMode, isDetailPreview:" + r7);
        if (r7 == true) goto L20;
        return false;
    L12:
        if (Intrinsics.areEqual(r6.getClass().getCanonicalName(), "com.ss.android.ugc.aweme.detail.ui.DetailActivity") == false) goto L14;
        r7 = true;
    L20:
        return !this.b;
    }

    public final boolean b(Activity r4) {
        boolean r1 = false;
        if (((Boolean) this.f.getValue()).booleanValue() == true) goto L5;
    L30:
        ALogger.i("LivePlayItemHelper", "isLiveActivityMode, liveMode:" + r1 + ", isPersonalRoom:" + this.d + ", isConsumed:" + this.e);
        return r1;
    L5:
        if (Intrinsics.areEqual(r4.getClass().getCanonicalName(), "com.ss.android.ugc.aweme.live.LivePlayActivity") == false) goto L7;
    L10:
        boolean r5 = true;
    L11:
        if (r5 == false) goto L30;
        if (PersonalizedFeedUtils.b().f() == true) goto L15;
    L20:
        boolean r6 = true;
    L21:
        if (r6 == false) goto L23;
    L29:
        r1 = true;
        goto L30
    L23:
        if (((Boolean) this.h.getValue()).booleanValue() == true) goto L25;
    L27:
        boolean r7 = false;
    L28:
        if (r7 == false) goto L30;
    L25:
        if (this.e == true) goto L27;
        r7 = true;
        goto L28
    L15:
        if (this.d == true) goto L17;
    L19:
        r6 = false;
        goto L21
    L17:
        if (this.e == true) goto L19;
    L7:
        if (Intrinsics.areEqual(r4.getClass().getCanonicalName(), "com.ss.android.ugc.aweme.live.LivePlayActivityV2") == true) goto L10;
        r5 = false;
        goto L11
    }
}
