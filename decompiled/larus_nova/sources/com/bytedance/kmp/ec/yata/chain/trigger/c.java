package com.bytedance.kmp.ec.yata.chain.trigger;

import com.bytedance.kmp.ec.yata.common.utils.YataConcurrentHashMap;
import com.bytedance.kmp.ec.yata.event.core.YataEventCenter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f251313j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f251314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f251315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<com.bytedance.kmp.ec.yata.chain.event.a> f251316c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f251317d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final YataConcurrentHashMap<Object, Object> f251318e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f251319f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f251320g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f251321h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final g f251322i;

    public static final class a {
        public a() {
        }

        public final c a(String r110, List<? extends com.bytedance.kmp.ec.yata.chain.event.a> r111, Map<String, ? extends Object> r112, Map<Object, ? extends Object> r113, String r114) {
            Intrinsics.checkNotNullParameter(r110, "chainName");
            Intrinsics.checkNotNullParameter(r111, "events");
            Intrinsics.checkNotNullParameter(r114, "monitorTag");
            return b(this, r110, r111, r112, r113, "biz", r114, false, null, 129);
        }

        public static c b(a r110, String r111, List r112, Map r113, Map r114, String r115, String r116, boolean r210, YataEventCenter.a r211, int r212) {
            if ((r212 & 1) == 0) goto L5;
            int r100 = com.bytedance.kmp.ec.yata.common.platform.h.f251540a;
            String r101 = UUID.randomUUID().toString();
        L7:
            if ((r212 & 8) == 0) goto L9;
            Map r102 = null;
        L11:
            if ((r212 & 16) == 0) goto L13;
            Map r103 = null;
        L15:
            if ((r212 & 64) == 0) goto L17;
            String r117 = "sdkBuild";
        L19:
            if ((r212 & 128) == 0) goto L21;
            boolean r118 = false;
        L23:
            if ((r212 & 256) == 0) goto L25;
            YataEventCenter.a r119 = null;
        L26:
            r110.getClass();
            Intrinsics.checkNotNullParameter(r101, "chainId");
            Intrinsics.checkNotNullParameter(r111, "chainName");
            Intrinsics.checkNotNullParameter(r112, "events");
            Intrinsics.checkNotNullParameter(r115, "chainStartSource");
            Intrinsics.checkNotNullParameter(r117, "monitorTag");
            if (r103 == null) goto L30;
            Map r104 = com.bytedance.kmp.ec.yata.common.utils.d.g(r103);
            if (r104 == null) goto L30;
        L32:
            return new c(r101, r111, r112, r102, new YataConcurrentHashMap(r104), r115, r117, r118, r119);
        L30:
            r104 = new LinkedHashMap();
            goto L32
        L25:
            r119 = r211;
            goto L26
        L21:
            r118 = r210;
            goto L23
        L17:
            r117 = r116;
            goto L19
        L13:
            r103 = r114;
            goto L15
        L9:
            r102 = r113;
            goto L11
        L5:
            r101 = null;
            goto L7
        }
    }

    static {
        f251313j = new a();
    }

    public c(String r100, String r101, List r102, Map r103, YataConcurrentHashMap r104, String r105, String r106, boolean r107, g r108) {
        this.f251314a = r100;
        this.f251315b = r101;
        this.f251316c = r102;
        this.f251317d = r103;
        this.f251318e = r104;
        this.f251319f = r105;
        this.f251320g = r106;
        this.f251321h = r107;
        this.f251322i = r108;
    }
}
