package com.bytedance.ee.bear.bitable.anniex.util;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f206758d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f206759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f206760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f206761c;

    public static final class a {
    }

    static {
    }

    public static void b(Function0 r100) {
        Map r101 = (Map) r100.invoke();     // Catch: Exception -> L7
        if (r101 != null) goto L5;
        return;
    L5:
        ((com.bytedance.ee.bear.bitable.anniex.host.c) org.koin.java.a.c(com.bytedance.ee.bear.bitable.anniex.host.c.class, null, null, 6)).b(new com.bytedance.ee.bear.bitable.anniex.host.b(r101));     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        tt5.a.e("BitableLynxTemplateAnalytic", "report failed: ", e, false);
    }

    public h(int r100, String r101) {
        this.f206759a = r100;
        this.f206760b = r101;
    }

    public static void d(final h r100, final String r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "stage");
        final Long r102 = null;
        b(new BitableLynxTemplateAnalytic$reportSuccess$1(r100, r101, r102));
    }

    public static final Map a(h r100, String r101, Long r102) {
        long r103 = r100.f206761c;
        if (r102 == null) goto L5;
        long r104 = r102.longValue();
    L6:
        Pair[] r105 = new Pair[4];
        r105[0] = TuplesKt.to("duration", Long.valueOf(r104 - r103));
        r105[1] = TuplesKt.to("stage", r101);
        switch(r100.f206759a) {
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L18;
            case 9: goto L17;
            case 10: goto L16;
            case 11: goto L15;
            case 12: goto L14;
            case 13: goto L13;
            case 14: goto L12;
            case 15: goto L11;
            case 16: goto L10;
            case 17: goto L9;
            default: goto L8;
        };
    L8:
        String r106 = "";
    L26:
        r105[2] = TuplesKt.to("scene", r106);
        r105[3] = TuplesKt.to("template_path", r100.f206760b);
        return MapsKt.mutableMapOf(r105);
    L9:
        r106 = "choose_base_view";
        goto L26
    L10:
        r106 = "super_agent_sub_conversation";
        goto L26
    L11:
        r106 = "super_agent_conversation_manager";
        goto L26
    L12:
        r106 = "super_agent_card_expand";
        goto L26
    L13:
        r106 = "super_agent_panel";
        goto L26
    L14:
        r106 = "text_ai_polish";
        goto L26
    L15:
        r106 = "voice_input";
        goto L26
    L16:
        r106 = "bitable_feed_filter";
        goto L26
    L17:
        r106 = "bitable_feed_center";
        goto L26
    L18:
        r106 = "bitable_feed_subscribe";
        goto L26
    L19:
        r106 = "bitable_editor_linktag";
        goto L26
    L20:
        r106 = "app_drawer";
        goto L26
    L21:
        r106 = "workspace_panel";
        goto L26
    L22:
        r106 = "workspace_search";
        goto L26
    L23:
        r106 = "search_config";
        goto L26
    L24:
        r106 = "base_calendar";
        goto L26
    L25:
        r106 = "record_share";
        goto L26
    L5:
        r104 = System.currentTimeMillis();
        goto L6
    }

    public static void c(final h r100, final String r101, final String r102, Integer r103, int r110) {
        if ((r110 & 4) == 0) goto L5;
        r103 = null;
    L5:
        final Integer r104 = r103;
        final Long r105 = null;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "stage");
        Intrinsics.checkNotNullParameter(r102, "reason");
        b(new BitableLynxTemplateAnalytic$reportFailed$1(r100, r101, r105, r104, r102));
    }
}
