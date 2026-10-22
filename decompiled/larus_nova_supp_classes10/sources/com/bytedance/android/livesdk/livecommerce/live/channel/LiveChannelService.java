package com.bytedance.android.livesdk.livecommerce.live.channel;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.live.api.commerce.live.channel.ILiveChannelService;
import com.bytedance.android.ec.model.g;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import si2.k;
import vi2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/live/channel/LiveChannelService;", "Lcom/bytedance/android/ec/live/api/commerce/live/channel/ILiveChannelService;", "<init>", "()V", "Companion", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveChannelService implements ILiveChannelService {
    public static final Gson d = null;
    public static final JsonParser e = null;
    public static final SharedPreferences f = null;
    public static final LiveChannelService g = null;
    public static final Companion h = null;
    public MessageQueue.IdleHandler a;
    public Map<String, String> b;
    public Map<String, Number> c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u001d\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/live/channel/LiveChannelService$Companion;", "", "()V", "GSON", "Lcom/google/gson/Gson;", "INSTANCE", "Lcom/bytedance/android/livesdk/livecommerce/live/channel/LiveChannelService;", "JSON_PARSER", "Lcom/google/gson/JsonParser;", "KEY_HAS_ENTERED_LIVE_CHANNEL", "", "KEY_LIVE_CHANNEL_PREFETCH", "LIVE_CHANNEL_CATEGORY_FAILED_REASON", "LIVE_CHANNEL_CATEGORY_HAS_ENTERED", "LIVE_CHANNEL_CATEGORY_PREFETCH_STATUS", "LIVE_CHANNEL_CATEGORY_STATUS_CODE", "LIVE_CHANNEL_CATEGORY_STRATEGY", "LIVE_CHANNEL_CLIENT_STATUS_HAS_CACHE", "LIVE_CHANNEL_CLIENT_STATUS_NO_HIT_EXPERIMENT", "LIVE_CHANNEL_CLIENT_STATUS_PARSE_ERROR", "LIVE_CHANNEL_METRIC_TIME_START", "LIVE_CHANNEL_METRIC_TIME_USAGE", "LIVE_CHANNEL_MONITOR_EVENT_NAME", "LIVE_CHANNEL_PREFETCH_STATUS_DO_NOTHING", "LIVE_CHANNEL_PREFETCH_STATUS_FAILED", "LIVE_CHANNEL_PREFETCH_STATUS_SUCCESS", "TAG", "sp", "Landroid/content/SharedPreferences;", "getInstance", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        public Companion() {
        }

        @JvmStatic
        public final LiveChannelService getInstance() {
            return LiveChannelService.g;
        }
    }

    public static final class a implements MessageQueue.IdleHandler {
        public final /* synthetic */ LiveChannelService a;

        public a(LiveChannelService r1) {
            this.a = r1;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            this.a.b();
            return false;
        }
    }

    public static final class b implements MessageQueue.IdleHandler {
        public final /* synthetic */ LiveChannelService a;
        public final /* synthetic */ long b;
        public final /* synthetic */ li2.b c;
        public final /* synthetic */ boolean d;

        public b(LiveChannelService r1, long r2, li2.b r4, boolean r5) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            this.a.c.put("start_time", Long.valueOf(SystemClock.uptimeMillis() - this.b));
            if (this.c.a() != 2) goto L5;
        L8:
            this.a.b();
            return false;
        L5:
            if (this.c.a() == 1) goto L7;
            return false;
        L7:
            if (this.d == true) goto L8;
            return false;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ LiveChannelService a;
        public final /* synthetic */ long b;

        public c(LiveChannelService r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r13) {
            li2.a r14 = (li2.a) r13;
            SharedPreferences r5 = LiveChannelService.f;     // Catch: Throwable -> L19
            LinkedHashMap r6 = null;
            if (r5 == null) goto L6;
            SharedPreferences.Editor r7 = r5.edit();     // Catch: Throwable -> L19
        L7:
            this.a.b.put("status_code", String.valueOf(((g) r14).statusCode));     // Catch: Throwable -> L19
            this.a.b.put("failed_reason", ((g) r14).statusMessage);     // Catch: Throwable -> L19
            if (((g) r14).statusCode != 0) goto L10;
            this.a.b.put("prefetch_status", "1");     // Catch: Throwable -> L19
            r6 = new LinkedHashMap();     // Catch: Throwable -> L19
            r6.put(EComABUtils.getEcLiveChannelPrefetchOpt().b(), new li2.c(r14));     // Catch: Throwable -> L19
        L11:
            this.a.c.put("time_usage", Long.valueOf(SystemClock.uptimeMillis() - this.b));     // Catch: Throwable -> L19
            if (r6 == null) goto L21;
            dm.a.b r15 = dm.a.a("LiveChannelService");     // Catch: Throwable -> L19
            StringBuilder r8 = new StringBuilder("requestGylApi result = ");     // Catch: Throwable -> L19
            Gson r4 = LiveChannelService.d;     // Catch: Throwable -> L19
            r8.append(r4.toJson(r6));     // Catch: Throwable -> L19
            r15.i(r8.toString());     // Catch: Throwable -> L19
            if (r7 == null) goto L21;
            SharedPreferences.Editor r16 = r7.putString("ecom_live_square_injection_mall_tab", r4.toJson(r6));     // Catch: Throwable -> L19
            if (r16 == null) goto L21;
            r16.apply();     // Catch: Throwable -> L19
        L21:
            LiveChannelService r17 = this.a;
            Gson r0 = LiveChannelService.d;
            r17.a();
            return;
        L10:
            this.a.b.put("prefetch_status", BDLocationException.ERROR_TIMEOUT);     // Catch: Throwable -> L19
            goto L11
        L6:
            r7 = null;
        L19:
            th = move-exception;
            this.a.b.put("prefetch_status", BDLocationException.ERROR_TIMEOUT);
            this.a.b.put("status_code", "-10101");
            this.a.b.put("failed_reason", String.valueOf(th.getMessage()));
            ECExceptionMonitor.e(th);
            goto L21
        }
    }

    @JvmStatic
    public static final LiveChannelService getInstance() {
        return h.getInstance();
    }

    static {
        h = new Companion();
        d = new Gson();
        e = new JsonParser();
        Context r0 = ECAppInfoService.e.getApplicationContext();
        if (r0 == null) goto L5;
        SharedPreferences r1 = r0.getSharedPreferences("js_kv_methods_20191113", 0);
    L6:
        f = r1;
        g = new LiveChannelService();
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void a() {
        int r0 = ECSdk.a;
        pi.b r1 = (pi.b) ECSdk.a(pi.b.class);
        if (r1 == null) goto L6;
        r1.monitorEvent("live_channel_client_prefetch", cd.a.a(this.b), cd.a.a(this.c), null);
        return;
    }

    public final void onEnterLiveChannel() {
        dm.a.a("LiveChannelService").a("onEnterLiveChannel");
        q.a.c("ec_live_channel_has_entered_live_channel", true);
    }

    public final void unregisterLiveChannelPrefetchHandler() {
        if (Build.VERSION.SDK_INT < 23) goto L8;
        MessageQueue.IdleHandler r0 = this.a;
        if (r0 == null) goto L9;
        Looper.getMainLooper().getQueue().removeIdleHandler(r0);
        return;
    L9:
        return;
    }

    public LiveChannelService() {
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
    }

    public final void b() {
        long r0 = SystemClock.uptimeMillis();
        dm.a.a("LiveChannelService").i("requestGylApi start");
        final ArrayList r2 = new ArrayList();
        int r3 = k.c;
        r2.add(k.a.a("can_apply_coupon", "1"));
        r2.add(k.a.a("count", "10"));
        r2.add(k.a.a("cursor", BDLocationException.ERROR_TIMEOUT));
        r2.add(k.a.a("ecom_scene_id", "1099,1031"));
        r2.add(k.a.a("feature_version", "new_operate_resource"));
        r2.add(k.a.a("only_entrance", BDLocationException.ERROR_TIMEOUT));
        r2.add(k.a.a("page_name", "ecom_live_channel"));
        r2.add(k.a.a("page_num", "1"));
        r2.add(k.a.a("preload", BDLocationException.ERROR_TIMEOUT));
        r2.add(k.a.a("recommend_back_up_offset", BDLocationException.ERROR_TIMEOUT));
        r2.add(k.a.a("render_purchase", "1"));
        r2.add(k.a.a("server_force_insert", "1"));
        r2.add(k.a.a("with_live_product", "1"));
        r2.add(k.a.a("with_tabs", "1"));
        r2.add(k.a.a("latch_prefetch_type", "native_prefetch"));
        r2.add(k.a.a("feature_version", "new_operate_resource"));
        r2.add(k.a.a("enter_from", "homepage_bottom_tab__xtab_homepage_mall_tab_live"));
        h.e(null, null, "https://ecom.snssdk.com/live/channel/common/favorite/feed", new vi2.b(r2)).subscribe(new c(this, r0));
    }

    public final void registerLiveChannelPrefetchHandler() {
        long r2 = SystemClock.uptimeMillis();
        this.b = new HashMap();
        this.c = new HashMap();
        if (Build.VERSION.SDK_INT < 23) goto L35;
        li2.b r4 = EComABUtils.getEcLiveChannelPrefetchOpt();
        boolean r5 = false;
        boolean r6 = q.a.getBoolean("ec_live_channel_has_entered_live_channel", false);
        this.b.put("strategy", String.valueOf(r4.a()));
        this.b.put("has_entered", String.valueOf(r6));
        dm.a.a("LiveChannelService").i("registerHandler，optSettings=" + r4.a() + ",debugMode=" + EComABUtils.getEcLiveChannelPrefetchOptDebug());
        if (ECAppInfoService.e.i() == false) goto L10;
        if (EComABUtils.getEcLiveChannelPrefetchOptDebug() == false) goto L10;
        a r0 = new a(this);
        this.a = r0;
        Looper.getMainLooper().getQueue().addIdleHandler(r0);
        return;
    L10:
        if (r4.a() != 0) goto L13;
        this.b.put("prefetch_status", "-1");
        this.b.put("status_code", "-10099");
        dm.a.a("LiveChannelService").b("registerLiveChannelPrefetchHandler，not hit experiment", null);
        a();
        return;
    L13:
        SharedPreferences r1 = f;
        String r11 = "";
        if (r1 == null) goto L20;
        String r3 = r1.getString("ecom_live_square_injection_mall_tab", "");
        if (r3 == null) goto L20;
        r11 = r3;
    L20:
        if (r11.length() != 0) goto L22;
        boolean r7 = true;
    L23:
        if (r7 == false) goto L33;
    L28:
        if (r5 == false) goto L31;
        this.b.put("status_code", "-10100");
        this.b.put("prefetch_status", "-1");
        dm.a.a("LiveChannelService").b("registerLiveChannelPrefetchHandler，already have prefetch data", null);
        a();
        return;
    L31:
        b r8 = new b(this, r2, r4, r6);
        this.a = r8;
        Looper.getMainLooper().getQueue().addIdleHandler(r8);
        return;
    L33:
        GsonProtectorUtils.parse(e, r11);     // Catch: JsonParseException -> L27
        r5 = true;
        goto L28
    L22:
        r7 = false;
        goto L23
    }
}
