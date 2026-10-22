package com.bytedance.kmp.ec.yata.chain.event;

import com.bytedance.kmp.ec.yata.common.log.YaTaLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f251281h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EventState f251282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f251283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f251284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f251285d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Throwable f251286e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Object> f251287f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Object> f251288g;

    public static final class a {
        public a() {
        }

        public static b c(boolean r100, Map r101, Map r110, int r111) {
            int r102 = b.f251281h;
            if ((r111 & 1) == 0) goto L5;
            boolean r103 = false;
        L7:
            if ((r111 & 2) == 0) goto L9;
            Map r104 = null;
        L11:
            if ((r111 & 4) == 0) goto L13;
            r110 = null;
        L13:
            EventState r105 = EventState.SUCCESS;
            if (r110 == null) goto L17;
            Map r106 = MapsKt.toMutableMap(r110);
            if (r106 == null) goto L17;
        L19:
            return new b(r105, r103, false, null, null, r104, r106);
        L17:
            r106 = new LinkedHashMap();
            goto L19
        L9:
            r104 = r101;
            goto L11
        L5:
            r103 = r100;
            goto L7
        }

        public static b b(boolean r100, boolean r101, String r110, Throwable r111, int r112) {
            int r102 = b.f251281h;
            if ((r112 & 1) == 0) goto L5;
            boolean r103 = false;
        L7:
            if ((r112 & 2) == 0) goto L9;
            boolean r104 = true;
        L11:
            if ((r112 & 8) == 0) goto L13;
            r111 = null;
        L13:
            EventState r105 = EventState.FAILED;
            return new b(r105, r103, r104, r110, r111, null, new LinkedHashMap());
        L9:
            r104 = r101;
            goto L11
        L5:
            r103 = r100;
            goto L7
        }

        public static b a(boolean r100, boolean r101, String r110, Throwable r111, Map r112, int r113) {
            int r102 = b.f251281h;
            if ((r113 & 1) == 0) goto L5;
            boolean r103 = false;
        L7:
            if ((r113 & 8) == 0) goto L9;
            Throwable r104 = null;
        L11:
            if ((r113 & 16) == 0) goto L13;
            Map r105 = null;
        L15:
            return new b(EventState.FAILED, r103, r101, r110, r104, r105, new LinkedHashMap());
        L13:
            r105 = r112;
            goto L15
        L9:
            r104 = r111;
            goto L11
        L5:
            r103 = r100;
            goto L7
        }
    }

    static {
        new a();
    }

    public /* synthetic */ b() {
        throw null;
    }

    public b(EventState r100, boolean r101, boolean r102, String r103, Throwable r104, Map<String, ? extends Object> r105, Map<String, Object> r106) {
        this.f251282a = r100;
        this.f251283b = r101;
        this.f251284c = r102;
        this.f251285d = r103;
        this.f251286e = r104;
        this.f251287f = r105;
        this.f251288g = r106;
        YaTaLog.a("YataEventResult.response", r105);
    }
}
