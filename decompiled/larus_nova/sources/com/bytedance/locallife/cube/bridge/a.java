package com.bytedance.locallife.cube.bridge;

import com.bytedance.ies.bullet.service.base.c1;
import com.bytedance.ies.bullet.service.base.q0;
import com.bytedance.ies.bullet.service.base.r;
import com.bytedance.locallife.biz.base.cube.n;
import com.bytedance.locallife.cube.api.model.GeckoInfo;
import com.bytedance.locallife.cube.experiments.CubeFontFamily;
import com.bytedance.locallife.cube.experiments.CubeSettings;
import com.bytedance.locallife.cube.impl.CubeInstance;
import com.bytedance.locallife.cube.impl.d;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f257187a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f257188b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CubeFontFamily f257189c = null;

    /* JADX INFO: renamed from: com.bytedance.locallife.cube.bridge.a$a, reason: collision with other inner class name */
    public static final class C3650a extends com.bytedance.ies.bullet.service.base.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ies.bullet.service.base.b f257190a;

        public C3650a(com.bytedance.ies.bullet.service.base.b r100) {
            this.f257190a = r100;
        }

        @Override // com.bytedance.ies.bullet.service.base.b
        public final void a(c1 r110) {
            Intrinsics.checkNotNullParameter(r110, "info");
            String r100 = r110.f247800j;
            boolean r101 = false;
            if (r100 != null) goto L5;
        L8:
            boolean r102 = true;
        L9:
            if (r102 == false) goto L103;
            String r103 = r110.f247792b;
            if (r103 != null) goto L13;
        L16:
            boolean r104 = true;
        L17:
            if (r104 == true) goto L103;
            String r105 = r110.f247792b;
            kp6.c.f505514a.getClass();
            GeckoInfo r106 = GeckoInfo.Companion.parse(r105);
            d r107 = null;
            if (r106 == null) goto L21;
            String r108 = r106.getChannel();
        L22:
            if (r106 == null) goto L24;
            String r109 = r106.getBundle();
        L25:
            String r111 = kp6.c.i(r105, true);
            JSONObject r112 = r110.f247794d;
            if (r112 == null) goto L28;
            String r113 = r112.optString("channel");
        L29:
            JSONObject r114 = r110.f247794d;
            if (r114 == null) goto L32;
            String r115 = r114.optString("bundle");
        L107:
            Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L35
            Object r117 = Result.m9449constructorimpl(a36.b.d(UriProtector.parse(r105)));     // Catch: Throwable -> L35
        L38:
            if (Result.m9455isFailureimpl(r117) == false) goto L40;
            r117 = null;
        L40:
            String r118 = (String) r117;
            Iterator<d> r119 = CubeInstance.S.iterator();
        L42:
            if (r119.hasNext() == false) goto L101;
            d r120 = r119.next();
            d r121 = r120;
            boolean r122 = ap6.a.b(r121.f257234b);
            String r123 = r121.f257233a.getSchema();
            if (r123.length() != 0) goto L46;
            boolean r124 = true;
        L47:
            if (r124 == true) goto L49;
        L51:
            boolean r125 = false;
        L52:
            if (r122 == true) goto L54;
            Iterator<d> r126 = r119;
        L66:
            boolean r127 = false;
        L67:
            if (r122 == true) goto L69;
        L73:
            boolean r128 = false;
        L74:
            if (r122 == true) goto L76;
        L80:
            boolean r129 = false;
        L82:
            if (ap6.a.b(r121.f257237e) == true) goto L84;
        L88:
            boolean r130 = false;
        L89:
            if (r125 == true) goto L96;
            if (r127 == true) goto L96;
            if (r128 == true) goto L96;
            if (r129 == true) goto L96;
            if (r130 == true) goto L96;
            boolean r131 = false;
        L97:
            if (r131 == true) goto L98;
            r119 = r126;
            r101 = false;
            goto L42
        L98:
            r107 = r120;
        L96:
            r131 = true;
            goto L97
        L84:
            if (Intrinsics.areEqual(r121.f257237e, r111) == false) goto L86;
        L87:
            r130 = true;
            goto L89
        L86:
            if (Intrinsics.areEqual(r121.f257237e, r118) == false) goto L88;
        L76:
            if (Intrinsics.areEqual(r113, r121.f257234b) == false) goto L80;
            if (Intrinsics.areEqual(r115, r121.f257235c) == false) goto L80;
            r129 = true;
            goto L82
        L69:
            if (Intrinsics.areEqual(r108, r121.f257234b) == false) goto L73;
            if (Intrinsics.areEqual(r109, r121.f257235c) == false) goto L73;
            r128 = true;
            goto L74
        L54:
            if (r105 == null) goto L58;
            r126 = r119;
            if (StringsKt.contains$default(r105, r121.f257234b, r101, 2, null) != true) goto L59;
            boolean r132 = true;
        L60:
            if (r132 == false) goto L66;
            if (StringsKt.contains$default(r105, r121.f257235c, false, 2, null) == false) goto L66;
            r127 = true;
        L59:
            r132 = false;
            goto L60
        L58:
            r126 = r119;
            goto L59
        L49:
            if (Intrinsics.areEqual(r123, r105) == false) goto L51;
            r125 = true;
            goto L52
        L46:
            r124 = false;
        L101:
            if (r107 == null) goto L103;
            r110.f247800j = "life_service_bid";
        L35:
            th = move-exception;
            Result.Companion r133 = Result.Companion;
            r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L38
        L32:
            r115 = null;
            goto L107
        L28:
            r113 = null;
            goto L29
        L24:
            r109 = null;
            goto L25
        L21:
            r108 = null;
            goto L22
        L13:
            if (r103.length() == 0) goto L16;
            r104 = false;
        L103:
            com.bytedance.ies.bullet.service.base.b r134 = this.f257190a;
            if (r134 == null) goto L111;
            r134.a(r110);
            return;
        L111:
            return;
        L5:
            if (r100.length() == 0) goto L8;
            r102 = false;
            goto L9
        }
    }

    static {
        f257187a = new AtomicBoolean(false);
        f257188b = new AtomicBoolean(false);
        f257189c = CubeSettings.b().getFontFamily();
        com.bytedance.locallife.cube.c.d().f();
        n.f256546a.c();
        s26.d r100 = s26.d.f540305c;
        k16.b r101 = (k16.b) s26.d.f540305c.d("default_bid", k16.b.class);
        if (r101 == null) goto L5;
        r101.initialize();
    L5:
        r r102 = (r) s26.d.f540305c.d("default_bid", r.class);
        if (r102 == null) goto L11;
        q0 r103 = r102.getMonitorConfig();
        if (r103 == null) goto L12;
        r103.f247900f = new C3650a(r103.f247900f);
        return;
    L12:
        return;
    }
}
