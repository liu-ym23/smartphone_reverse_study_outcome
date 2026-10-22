package pg2;

import am2.x;
import android.os.Bundle;
import com.bytedance.android.livesdk.config.h31;
import com.bytedance.android.livesdk.config.r4;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f {
    public final List<String> a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public Bundle g;

    public static String c() {
        return a() + "-" + b();
    }

    public f() {
        this.a = CollectionsKt.listOf(new String[]{"source_key", "need_map", "show_type"});
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
    }

    public static String a() {
        o r0 = u.l().c(x.class);
        if (r0 == null) goto L8;
        Map<String, String> r1 = r0.getMap();
        if (r1 == null) goto L8;
        String r2 = r1.get("enter_from_merge");
        if (r2 == null) goto L8;
        return r2;
    L8:
        return "";
    }

    public static String b() {
        o r0 = u.l().c(x.class);
        if (r0 == null) goto L8;
        Map<String, String> r1 = r0.getMap();
        if (r1 == null) goto L8;
        String r2 = r1.get("enter_method");
        if (r2 == null) goto L8;
        return r2;
    L8:
        return "";
    }

    public final String d(String r6) {
        Bundle r0 = this.g;
        if (r0 == null) goto L6;
        String r1 = r0.getString("pre_enter_from");
        if (r1 == null) goto L6;
    L7:
        h31 r2 = com.bytedance.android.livesdk.chatroom.followrecommendguide.a.a;
        String r3 = this.d;
        Intrinsics.checkNotNullParameter(r1, "preEnterFrom");
        Intrinsics.checkNotNullParameter(r6, "fromType");
        Intrinsics.checkNotNullParameter(r3, "defaultEnterFrom");
        if (com.bytedance.android.livesdk.chatroom.followrecommendguide.a.j() == false) goto L25;
        Map r4 = com.bytedance.android.livesdk.chatroom.followrecommendguide.a.a.c();
        if (r4.containsKey(r1) == false) goto L18;
        r4 r7 = (r4) r4.get(r1);
        if (r7 == null) goto L27;
        String r8 = r7.f();
        if (r8 != null) goto L28;
        return "";
    L28:
        return r8;
    L27:
        return "";
    L18:
        if (r4.containsKey(r6) == false) goto L30;
        r4 r9 = (r4) r4.get(r6);
        if (r9 == null) goto L29;
        r8 = r9.f();
        if (r8 != null) goto L28;
        return "";
    L29:
        return "";
    L30:
        return r3;
    L25:
        return "follow_recommend";
    L6:
        r1 = "";
        goto L7
    }

    public final String e(String r7) {
        Bundle r0 = this.g;
        if (r0 == null) goto L6;
        String r1 = r0.getString("pre_enter_from");
        if (r1 == null) goto L6;
    L7:
        h31 r2 = com.bytedance.android.livesdk.chatroom.followrecommendguide.a.a;
        String r3 = this.e;
        Intrinsics.checkNotNullParameter(r1, "preEnterFrom");
        Intrinsics.checkNotNullParameter(r7, "fromType");
        Intrinsics.checkNotNullParameter(r3, "defaultRecEnterMethod");
        if (com.bytedance.android.livesdk.chatroom.followrecommendguide.a.j() == false) goto L24;
        Map r4 = com.bytedance.android.livesdk.chatroom.followrecommendguide.a.a.c();
        if (r4.containsKey(r1) == false) goto L18;
        r4 r8 = (r4) r4.get(r1);
        if (r8 == null) goto L48;
        String r9 = r8.g();
        if (r9 != null) goto L49;
        return "";
    L49:
        return r9;
    L48:
        return "";
    L18:
        if (r4.containsKey(r7) == false) goto L47;
        r4 r10 = (r4) r4.get(r7);
        if (r10 == null) goto L50;
        r9 = r10.g();
        if (r9 != null) goto L49;
        return "";
    L50:
        return "";
    L47:
        return r3;
    L24:
        List r5 = com.bytedance.android.livesdk.chatroom.followrecommendguide.a.a.e();
        if (r5 == null) goto L47;
        if (r5.contains(r7) != true) goto L47;
        if (StringsKt.startsWith$default(r7, "homepage_follow-live_cover", false, 2, null) == false) goto L32;
        return "follow_live_cover";
    L32:
        if (StringsKt.startsWith$default(r7, "homepage_follow-live_cell", false, 2, null) == false) goto L35;
        return "follow_live_cell";
    L35:
        if (StringsKt.startsWith$default(r7, "homepage_follow-video_head", false, 2, null) == false) goto L37;
        return "follow_video_head";
    L37:
        String r6 = "drawer_follow";
        if (StringsKt.startsWith$default(r7, "drawer_follow", false, 2, null) == true) goto L54;
        r6 = "push";
        if (StringsKt.startsWith$default(r7, "push", false, 2, null) == true) goto L54;
        if (StringsKt.startsWith$default(r7, "inner_push", false, 2, null) == false) goto L47;
    L54:
        return r6;
    L6:
        r1 = "";
        goto L7
    }
}
