package jg2;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.projectmode.ILiveSdkProjectModeService;
import com.bytedance.android.livesdk.utils.personalfeed.PersonalizedFeedUtils;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListProvider;
import com.bytedance.android.livesdkapi.feed.IPersonalizedContext;
import com.bytedance.bdlocation.exception.BDLocationException;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kf2.g;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements IPersonalizedContext {
    public boolean a;
    public int b;
    public long[] c;
    public final HashMap<String, HashSet<Long>> d;
    public g e;
    public long f;
    public final long g;
    public final long h;
    public final String i;
    public final Bundle j;
    public final ILiveRoomListProvider k;

    /* JADX INFO: renamed from: jg2.a$a, reason: collision with other inner class name */
    public static final class C0148a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ String a;

        public b(String r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            PersonalizedFeedUtils.e("DrawRoomPersonalizedContext", "Collecting unread room result, extra: " + this.a + ", statusCode: " + ((BaseResponse) ((Response) r3)).statusCode + '.');
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    static {
    }

    public final void configPreviewCleanScreenEnter(boolean r1) {
    }

    public final void configPreviewLandscapeEnter(boolean r1) {
    }

    public final void onFetchError() {
        if (this.f <= 0) goto L6;
        long r0 = SystemClock.elapsedRealtime() - this.f;
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("status", BDLocationException.ERROR_TIMEOUT);
        r2.put("path", "webcast_feed_cache");
        r2.put("request_scene", "cache_preload");
        r2.put("cost_time", String.valueOf(r0));
        Unit r1 = Unit.INSTANCE;
        u.l().sendLog("livesdk_live_api", r2, new Object[0]);
        return;
    }

    public final void onFetchSuccess() {
        if (this.f <= 0) goto L6;
        long r0 = SystemClock.elapsedRealtime() - this.f;
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("status", "1");
        r2.put("path", "webcast_feed_cache");
        r2.put("request_scene", "cache_preload");
        r2.put("cost_time", String.valueOf(r0));
        Unit r1 = Unit.INSTANCE;
        u.l().sendLog("livesdk_live_api", r2, new Object[0]);
        return;
    }

    public final Map<String, String> packSlideUpPersonalEventMap() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("enter_feed_time", String.valueOf(this.g));
        r0.put("leave_feed_time", String.valueOf(System.currentTimeMillis()));
        r0.put("total_page_count", String.valueOf(this.b));
        return r0;
    }

    public final void onFetchStart() {
        this.f = SystemClock.elapsedRealtime();
    }

    public final long getFetchStartTime() {
        return this.f;
    }

    public final void a(long[] r11) {
        String r12 = r11 + " visibleArray: [" + ArraysKt.joinToString$default(this.c, ",", null, null, 0, null, null, 62, null) + "]}";
        Lazy r0 = PersonalizedFeedUtils.a;
        Intrinsics.checkNotNullParameter("DrawRoomPersonalizedContext", "subTag");
        Intrinsics.checkNotNullParameter(r12, "msg");
        ALogger.d("PersonalizedFeedUtils", "subTag:DrawRoomPersonalizedContext, msg:" + r12);
    }

    public final void onItemShow(int r7) {
        boolean r0 = false;
        if (r7 < 0) goto L9;
    L5:
        long[] r1 = this.c;
        if (r7 < r1.length) goto L8;
        long[] r2 = new long[r1.length * 2];
        System.arraycopy(r1, 0, r2, 0, r1.length);
        this.c = r2;
        goto L5
    L8:
        r0 = true;
    L9:
        if (r0 == false) goto L15;
    L10:
        if (r7 < 0) goto L20;
        long[] r3 = this.c;
        if (r3[r7] != 0) goto L14;
        r3[r7] = System.currentTimeMillis() / ((long) 1000);
    L14:
        r7 = r7 - 1;
        goto L10
    L20:
        return;
    }

    public final void b(HashSet<Long> r11, Function1<? super HashMap<String, HashSet<Long>>, Unit> r12) {
        Intrinsics.checkNotNullParameter(r11, "readRoomSet");
        HashMap<String, HashSet<Long>> r0 = this.d;
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator<Map.Entry<String, HashSet<Long>>> r2 = r0.entrySet().iterator();
    L3:
        boolean r3 = false;
        if (r2.hasNext() == false) goto L10;
        Map.Entry<String, HashSet<Long>> r4 = r2.next();
        r4.getValue().removeAll(r11);
        if (r4.getValue().size() <= 0) goto L8;
        r3 = true;
    L8:
        if (r3 == false) goto L3;
        r1.put(r4.getKey(), r4.getValue());
        goto L3
    L10:
        Iterator r13 = r1.entrySet().iterator();
    L12:
        if (r13.hasNext() == false) goto L21;
        Map.Entry r5 = (Map.Entry) r13.next();
        String r6 = (String) r5.getKey();     // Catch: Exception -> L19
        int r7 = StringsKt.lastIndexOf$default((CharSequence) r5.getKey(), "_", 0, false, 6, null);     // Catch: Exception -> L19
        if (r6 == null) goto L18;
        String r8 = r6.substring(0, r7);     // Catch: Exception -> L19
    L20:
        c(r8, new ArrayList((Collection) r5.getValue()));
        Unit r9 = (Unit) r12.invoke(this.d);
        goto L12
    L18:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Exception -> L19
    L19:
        r8 = (String) r5.getKey();
        goto L20
    L21:
        this.d.clear();
    }

    public final void c(String r4, ArrayList<Long> r5) {
        Intrinsics.checkNotNullParameter(r4, "realKey");
        if (r5.isEmpty() == false) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return;
    L9:
        if (this.e != null) goto L12;
        this.e = new g();
    L12:
        if (this.e == null) goto L17;
        Observable r6 = g.c(this.h, this.i, r4, r5);
        if (r6 == null) goto L18;
        r6.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(r4), c.a);
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void configCurrentContentCategory(Activity r3, int r4) {
        if (v.a() == false) goto L14;
        ILiveSdkProjectModeService r0 = k.f(ILiveSdkProjectModeService.class);
        if (r0 == null) goto L15;
        ILiveRoomListProvider r1 = this.k;
        if (r1 == null) goto L11;
        FeedItem r5 = r1.getFeedItem(r4);
        if (r5 == null) goto L11;
        int r6 = r5.contentCategory;
    L12:
        r0.configCurrentContentCategory(r3, r6);
        return;
    L11:
        r6 = 0;
        goto L12
    L15:
        return;
    }

    public a(long r2, String r4, Bundle r5, ILiveRoomListProvider r6) {
        Intrinsics.checkNotNullParameter(r4, "enterAnchorId");
        Intrinsics.checkNotNullParameter(r5, "roomArgs");
        this.h = r2;
        this.i = r4;
        this.j = r5;
        this.k = r6;
        this.c = new long[16];
        this.d = new HashMap();
        this.f = -1;
        this.g = System.currentTimeMillis();
    }
}
