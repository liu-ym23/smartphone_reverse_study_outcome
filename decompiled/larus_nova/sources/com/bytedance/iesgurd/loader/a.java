package com.bytedance.iesgurd.loader;

import b96.i;
import com.bytedance.geckox.AppSettingsManager;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.iesgurd.IESGurdKit;
import com.bytedance.iesgurd.meta.ChannelMeta;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.iesgurd.meta.PrepareMetaManager;
import com.bytedance.iesgurd.strategy.ColdStartManager;
import com.bytedance.iesgurd.utils.GeckoExecutors;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f250751a = null;

    /* JADX INFO: renamed from: com.bytedance.iesgurd.loader.a$a, reason: collision with other inner class name */
    public static final class RunnableC3568a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Long f250752a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f250753b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f250754c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f250755d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f250756e;

        public RunnableC3568a(Long r100, String r101, String r102, long r103, String r104) {
            this.f250752a = r100;
            this.f250753b = r101;
            this.f250754c = r102;
            this.f250755d = r103;
            this.f250756e = r104;
        }

        public final void a() {
            Long r100 = this.f250752a;
            if (r100 == null) goto L5;
            long r101 = r100.longValue();
        L6:
            long r102 = r101;
            a r103 = a.f250751a;
            String r104 = this.f250753b;
            String r105 = this.f250754c;
            long r106 = this.f250755d;
            r103.getClass();
            Pair r107 = a.c(r104, r105, r102, r102, r106, true);
            JSONObject r108 = a.a(this.f250753b, this.f250754c, this.f250752a, this.f250756e, r107);
            if (r108 == null) goto L10;
            y86.a.c("geckosdk_resource_access_stats", r108);
            return;
        L10:
            return;
        L5:
            r101 = 0;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public a() {
    }

    static {
        f250751a = new a();
    }

    public static void b(String r100, String r110, Long r111, String r112) {
        long r101 = System.currentTimeMillis();
        ((Executor) GeckoExecutors.f250871d.getValue()).execute(new RunnableC3568a(r111, r100, r110, r101, r112));
    }

    public static JSONObject a(String r100, String r101, Long r102, String r103, Pair r104) {
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L17
        JSONObject r106 = new JSONObject();     // Catch: Throwable -> L17
        r106.put("access_key", r100);     // Catch: Throwable -> L17
        r106.put("channel", r101);     // Catch: Throwable -> L17
        if (r102 != null) goto L5;
        String r107 = "0";
    L6:
        r106.put("id", r107);     // Catch: Throwable -> L17
        r106.put("type", r103);     // Catch: Throwable -> L17
        if (((Boolean) r104.getFirst()).booleanValue() == false) goto L9;
        int r108 = 1;
    L10:
        r106.put("is_blacklist", r108);     // Catch: Throwable -> L17
        if (((Number) r104.getSecond()).longValue() <= 0) goto L13;
        r106.put("dur_expire_clean_to_access", String.valueOf(((Number) r104.getSecond()).longValue()));     // Catch: Throwable -> L17
    L13:
        r106.put("cold_start_finish", ColdStartManager.f250851b.get());     // Catch: Throwable -> L17
        PrepareMeta r109 = PrepareMetaManager.b(r100, r101);     // Catch: Throwable -> L17
        if (r109 == null) goto L16;
        r106.put("prepare_id", r109.getVersion());     // Catch: Throwable -> L17
        r106.put("prepare_block_type", r109.getBlockType());     // Catch: Throwable -> L17
        r106.put("prepare_updating", i.b(r100, r101));     // Catch: Throwable -> L17
    L16:
        return r106;
    L9:
        r108 = 0;
        goto L10
    L5:
        r107 = String.valueOf(r102.longValue());     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Throwable r111 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        r111.getClass();
        GeckoLogger.e("resource access occurs exception", r111);
        return null;
    }

    public static Pair c(String r100, String r101, long r102, long r103, long r104, boolean r110) {
        if (r103 != 0) goto L11;
        ConcurrentHashMap r105 = (ConcurrentHashMap) com.bytedance.iesgurd.utils.a.f250878a;
        List r106 = (List) r105.get(r100);
        if (r106 != null) goto L8;
        r106 = new ArrayList();
        r105.put(r100, r106);
    L8:
        if (r106.contains(r101) == true) goto L16;
        r106.add(r101);
    L16:
        Pair r107 = yy5.c.i(r100, r101, r104);
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L23
        Iterator r109 = ((CopyOnWriteArraySet) ty5.a.f547967a).iterator();     // Catch: Throwable -> L23
    L19:
        if (r109.hasNext() == false) goto L21;
        ((GeckoUpdateListener) r109.next()).onChannelAccess(new GeckoUpdateListener.GeckoParams(r100, r101, r102));     // Catch: Throwable -> L23
        goto L19
    L21:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L25:
        if (r110 == false) goto L27;
        PrepareMetaManager.d(r100, r101);
    L27:
        int r111 = cz5.c.f466054a;
        AppSettingsManager.IGeckoAppSettings r112 = AppSettingsManager.b.f245071a.b();
        if (r112 == null) goto L30;
        r112.getConfig();
    L30:
        Iterator r113 = ((ConcurrentHashMap) IESGurdKit.f250623a).entrySet().iterator();
    L32:
        if (r113.hasNext() == false) goto L34;
        ((com.bytedance.iesgurd.c) ((Map.Entry) r113.next()).getValue()).b();
        goto L32
    L34:
        return r107;
    L23:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L25
    L11:
        if (AppSettingsManager.b.f245071a.a() == false) goto L15;
        ChannelMeta r115 = com.bytedance.iesgurd.meta.a.c(r100, r101);
        if (r115 == null) goto L16;
        r115.setAccessTime(Long.valueOf(r104));
        com.bytedance.iesgurd.meta.a.f(r100, r101, r115);
        goto L16
    L15:
        com.bytedance.iesgurd.utils.a.c(r100, r101);
        goto L16
    }
}
