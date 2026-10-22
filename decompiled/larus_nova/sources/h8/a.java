package h8;

import com.alipay.sdk.m.p.e;
import com.bytedance.android.annie.ng.g;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.ies.web.jsbridge2.TimeLineEvent;
import com.bytedance.ies.web.jsbridge2.c0;
import com.bytedance.ies.web.jsbridge2.o0;
import com.bytedance.ies.web.jsbridge2.u;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f484051a;

    /* JADX INFO: renamed from: h8.a$a, reason: collision with other inner class name */
    public static final class C6111a {
    }

    static {
    }

    @Override // com.bytedance.ies.web.jsbridge2.u
    public final /* synthetic */ void b(c0 r100, int r101) {
    }

    public a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "mLogProvider");
        this.f484051a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.u
    public final void a(String r100, String r101, o0 r102) {
        d(r100, r101, r102, false);
    }

    public final void d(String r110, String r111, o0 r112, boolean r113) {
        if (r111 != null) goto L4;
        return;
    L4:
        if (g.f39675g == true) goto L7;
        return;
    L7:
        if (AnnieConfigSettingKeys.ALLOW_REPORT_JSB_LIST.a().contains(r111) == true) goto L9;
        return;
    L9:
        List<TimeLineEvent> r100 = r112.f249419c;
        if (r100 != null) goto L12;
        return;
    L12:
        TimeLineEvent r101 = (TimeLineEvent) ListProtector.get(r100, 0);
        if (r101 == null) goto L20;
        HashMap<String, Object> r102 = r101.getExtra();
        if (r102 == null) goto L20;
        Object r103 = r102.get("params");
        if (r103 == null) goto L20;
        String r104 = r103.toString();
        if (r104 == null) goto L20;
    L22:
        if (r113 == false) goto L41;
        List<TimeLineEvent> r114 = r112.f249419c;
        if (r114 == null) goto L28;
        TimeLineEvent r115 = (TimeLineEvent) CollectionsKt.last(r114);
        if (r115 == null) goto L28;
        String r116 = r115.getLabel();
    L29:
        if (r116 != null) goto L32;
        r116 = "";
    L32:
        if (Intrinsics.areEqual(r116, "unknown_namespace") == false) goto L35;
        int r117 = -4;
    L42:
        Pair[] r118 = new Pair[4];
        if (r110 != null) goto L45;
        String r105 = "";
    L46:
        r118[0] = TuplesKt.to("url", ListProtector.get(StringsKt.split$default(r105, new String[]{"?"}, false, 0, 6, null), 0));
        r118[1] = TuplesKt.to(e.f25671s, r111);
        r118[2] = TuplesKt.to("code", String.valueOf(r117));
        r118[3] = TuplesKt.to("params", r104);
        Map r119 = MapsKt.mutableMapOf(r118);
        this.f484051a.f(r119);
        return;
    L45:
        r105 = r110;
        goto L46
    L35:
        if (Intrinsics.areEqual(r116, "not_registered_1") == false) goto L38;
        r117 = -2;
        goto L42
    L38:
        if (Intrinsics.areEqual(r116, "label_call_handler_reject") == false) goto L40;
        r117 = -1;
        goto L42
    L40:
        r117 = -999;
    L28:
        r116 = null;
        goto L29
    L41:
        r117 = 1;
    L20:
        r104 = "";
        goto L22
    }

    @Override // com.bytedance.ies.web.jsbridge2.u
    public final void c(String r100, String r101, int r102, String r103, o0 r104) {
        d(r100, r101, r104, true);
    }
}
