package com.ss.android.ugc.route_monitor.impl.launch_info;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.ugc.route_monitor.ComponentType;
import com.ss.android.ugc.route_monitor.RouteMonitorManager;
import com.ss.android.ugc.route_monitor.utils.Logger;
import com.ss.android.ugc.route_monitor.utils.j;
import com.ss.android.ugc.route_monitor.utils.o;
import ihc.p;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class f {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f454464l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p f454465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f454466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f454467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f454468d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f454469e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f454470f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Intent f454471g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f454472h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ComponentType f454473i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f454474j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final j<jhc.h> f454475k;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static f b(Intent r100) {
            f r101 = new f(false, 7);
            String r102 = "";
            r101.f454466b = "";
            r101.f454467c = true;
            r101.f454471g = new Intent(r100);
            ComponentName r103 = r100.getComponent();
            if (r103 == null) goto L7;
            String r104 = r103.getClassName();
            if (r104 == null) goto L7;
        L8:
            r101.f454472h = r104;
            r101.f454473i = ComponentType.SERVICE;
            Uri r105 = r100.getData();
            if (r105 == null) goto L13;
            String r106 = r105.toString();
            if (r106 == null) goto L13;
        L14:
            r101.f454469e = r106;
            String r107 = r100.getAction();
            if (r107 == null) goto L17;
            r102 = r107;
        L17:
            r101.f454470f = r102;
            return r101;
        L13:
            r106 = "";
        L7:
            r104 = "";
            goto L8
        }

        @JvmStatic
        public static f a(String r110, Intent r111, String r112, Context r113) {
            Logger r100 = Logger.f454747c;
            Objects.toString(r111);
            r100.b();
            boolean r101 = false;
            f r102 = new f(false, 7);
            if (r111 != null) goto L5;
            Intent r103 = new Intent();
        L6:
            r102.f454471g = r103;
            String r104 = "";
            if (r112 == null) goto L9;
            String r105 = r112;
        L10:
            r102.f454466b = r105;
            if (r110 != null) goto L13;
        L16:
            boolean r106 = true;
        L17:
            String r107 = null;
            if (r106 == false) goto L23;
            ComponentName r114 = r103.getComponent();
            if (r114 == null) goto L22;
            r110 = r114.getClassName();
            goto L23
        L22:
            r110 = null;
        L23:
            if (r110 != null) goto L27;
            r110 = "";
        L27:
            if (Intrinsics.areEqual(r110, "com.xiaomi.mipush.sdk.NotificationClickedActivity") == false) goto L29;
            String r108 = "";
            boolean r109 = true;
        L113:
            r102.f454473i = ComponentType.ACTIVITY;
            if (r108.length() != 0) goto L116;
            boolean r115 = true;
        L117:
            if (r115 == false) goto L142;
            com.ss.android.ugc.route_monitor.c.a().getClass();
            Uri r116 = r103.getData();
            if (r116 == null) goto L196;
            r108 = r116.toString();
            if (r108 == null) goto L196;
            if (r108.length() <= 0) goto L125;
            boolean r117 = true;
        L126:
            if (r117 == true) goto L129;
            r108 = null;
        L129:
            if (r108 == null) goto L196;
        L139:
            if (r108 != null) goto L142;
            r108 = "";
            goto L142
        L125:
            r117 = false;
        L196:
            Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L133
            Object r119 = Result.m9449constructorimpl(r103.getStringExtra(IHostAction.ORIGIN_SCHEME));     // Catch: Throwable -> L133
        L136:
            if (Result.m9455isFailureimpl(r119) == false) goto L138;
            r119 = null;
        L138:
            r108 = (String) r119;
        L133:
            th = move-exception;
            Result.Companion r120 = Result.Companion;
            r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        L142:
            r102.f454469e = r108;
            r102.f454472h = r110;
            String r121 = h.b(r113);
            if (r109 == false) goto L146;
            p r122 = p.f489950c;
        L177:
            r102.f454465a = r122;
            com.ss.android.ugc.route_monitor.c.a().getClass();
            String r123 = r103.getAction();
            if (r123 == null) goto L180;
            r104 = r123;
        L180:
            r102.f454470f = r104;
            Logger r124 = Logger.f454747c;
            r102.toString();
            r124.b();
            return r102;
        L146:
            if (Intrinsics.areEqual(h.a(r113), r112) == false) goto L162;
            com.ss.android.ugc.route_monitor.c.a().getClass();
            if (r111 == null) goto L151;
            r107 = r111.getAction();
        L151:
            if (Intrinsics.areEqual(r107, "android.intent.action.MAIN") == false) goto L156;
            Set<String> r125 = r111.getCategories();
            if (r125 == null) goto L156;
            if (r125.contains("android.intent.category.LAUNCHER") != true) goto L156;
        L158:
            boolean r126 = true;
        L160:
            if (r126 == false) goto L162;
            r122 = p.f489949b;
        L156:
            com.ss.android.ugc.route_monitor.c.a().getClass();
            if (ihc.f.h(r110) == true) goto L158;
            r126 = false;
        L162:
            if (r112 != null) goto L164;
        L165:
            r101 = true;
        L166:
            if (r101 == true) goto L171;
            if ((!Intrinsics.areEqual(r112, r121)) == false) goto L171;
            r122 = p.f489951d;
        L171:
            if (Intrinsics.areEqual(r112, r121) == false) goto L176;
            com.ss.android.ugc.route_monitor.c.a().getClass();
            if (RouteMonitorManager.f454384g.c(r110) == false) goto L175;
            com.ss.android.ugc.route_monitor.c.a().getClass();
        L175:
            r122 = p.f489953f;
            goto L177
        L176:
            r122 = p.f489954g;
            goto L177
        L164:
            if (r112.length() != 0) goto L166;
        L116:
            r115 = false;
            goto L117
        L29:
            com.ss.android.ugc.route_monitor.c.a().getClass();
            a r127 = f.f454464l;
            ComponentName r128 = r103.getComponent();
            if (r128 == null) goto L34;
            String r129 = r128.getClassName();
            if (r129 == null) goto L34;
        L35:
            r127.getClass();
            RouteMonitorManager r130 = RouteMonitorManager.f454384g;
            if (r130.c(r129) == false) goto L38;
        L41:
            boolean r131 = true;
        L42:
            if (r131 == false) goto L63;
            int r132 = com.ss.android.ugc.route_monitor.a.f454385a;
            o.f454778a.getClass();
            Bundle r133 = r103.getExtras();
            if (r133 == null) goto L63;
            Result.Companion r134 = Result.Companion;     // Catch: Throwable -> L47
            Object r135 = Result.m9449constructorimpl(r133.get("from_notification"));     // Catch: Throwable -> L47
        L50:
            if (Result.m9455isFailureimpl(r135) == false) goto L52;
            r135 = null;
        L52:
            if (r135 == null) goto L63;
            if ((r135 instanceof String) == true) goto L190;
            r109 = ((Boolean) r135).booleanValue();     // Catch: Throwable -> L61
        L64:
            if (r109 == false) goto L101;
            if (RouteMonitorManager.f454384g.b().b().contains(r110) == false) goto L101;
            com.ss.android.ugc.route_monitor.c.a().getClass();
            int r136 = com.ss.android.ugc.route_monitor.a.f454385a;
            String r137 = r103.getStringExtra("push_body");
        L74:
            th = move-exception;
            Logger.f454747c.d(th);
            o.f454778a.getClass();
            Bundle r138 = r103.getExtras();
            if (r138 == null) goto L89;
            Object r139 = r138.get(AppConstants.KEY_MESSAGE_FROM);
            if (r139 == null) goto L89;
            if ((r139 instanceof String) == true) goto L192;
            int r140 = ((Integer) r139).intValue();     // Catch: Throwable -> L87
        L91:
            if (11 != r140) goto L93;
            boolean r141 = true;
        L94:
            if (r141 == true) goto L182;
        L103:
            r108 = "";
        L104:
            RouteMonitorManager r142 = RouteMonitorManager.f454384g;
            if (r142.c(r110) == false) goto L107;
        L110:
            boolean r143 = true;
        L111:
            if (r143 == false) goto L113;
            r102.a();
            goto L113
        L107:
            if (r142.b().b().contains(r110) == true) goto L110;
            r143 = false;
            goto L111
        L182:
            String r144 = com.ss.android.ugc.route_monitor.a.a(Base64.decode(r137, 8));     // Catch: Throwable -> L98
            Logger r145 = Logger.f454747c;     // Catch: Throwable -> L98
            "uncompressed vivo channel push msgBody = ".concat(r144);     // Catch: Throwable -> L98
            r145.b();     // Catch: Throwable -> L98
            r108 = JSONObjectProtectorUtils.getString(new JSONObject(r144), "open_url");     // Catch: Throwable -> L98
        L98:
            th = move-exception;
            Logger.f454747c.d(th);
            goto L103
        L93:
            r141 = false;
        L87:
            th = move-exception;
            Logger.f454747c.d(th);
            goto L89
        L192:
            r140 = CastIntegerProtector.parseInt((String) r139);     // Catch: Throwable -> L83
        L83:
            th = move-exception;
            Logger.f454747c.d(th);
        L89:
            r140 = 0;
            goto L91
        L69:
            if (r137 == null) goto L71;
            String r146 = r137;
        L72:
            r108 = JSONObjectProtectorUtils.getString(new JSONObject(r146), "open_url");     // Catch: Throwable -> L74
            goto L104
        L71:
            r146 = "";
        L101:
            if (RouteMonitorManager.f454384g.c(r110) == false) goto L103;
            com.ss.android.ugc.route_monitor.c.a().c();
        L61:
            th = move-exception;
            Logger.f454747c.d(th);
            goto L63
        L190:
            r109 = Boolean.parseBoolean((String) r135);     // Catch: Throwable -> L57
        L57:
            th = move-exception;
            Logger.f454747c.d(th);
        L47:
            th = move-exception;
            Result.Companion r147 = Result.Companion;
            r135 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        L63:
            r109 = false;
            goto L64
        L38:
            if (r130.b().b().contains(r129) == true) goto L41;
            r131 = false;
        L34:
            r129 = "";
            goto L35
        L13:
            if (r110.length() == 0) goto L16;
            r106 = false;
            goto L17
        L9:
            r105 = "";
            goto L10
        L5:
            r103 = new Intent(r111);
            goto L6
        }
    }

    static {
        f454464l = new a();
    }

    public final void a() {
        if (this.f454468d.length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        Intent r101 = this.f454471g;
        if (r101 == null) goto L26;
        com.ss.android.ugc.route_monitor.impl.route_out.o.f454736h.getClass();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
        Object r103 = Result.m9449constructorimpl(r101.getStringExtra("___route_out_monitor_session___"));     // Catch: Throwable -> L13
    L16:
        if (Result.m9455isFailureimpl(r103) == false) goto L18;
        r103 = null;
    L18:
        String r104 = (String) r103;
        if (r104 != null) goto L22;
        r104 = "";
    L22:
        this.f454468d = r104;
        return;
    L13:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L26:
        return;
    L5:
        r100 = false;
        goto L6
    }

    public final String toString() {
        return super.toString() + ":{launchMode=" + this.f454465a + ", referrer=" + this.f454466b + ", isColdBoot=" + this.f454467c + ", firstComponentClassName=" + this.f454472h + ", launchComponentType=" + this.f454473i + ", openUrl=" + this.f454469e + ", realUrl=null, action=" + this.f454470f + ", extraData=" + this.f454474j + '}';
    }

    public f(boolean r100, int r101) {
        String r102 = null;
        if ((r101 & 1) == 0) goto L5;
        p r103 = p.f489954g;
    L7:
        if ((r101 & 2) == 0) goto L10;
        r102 = "";
    L10:
        if ((r101 & 4) == 0) goto L12;
        r100 = false;
    L12:
        this.f454465a = r103;
        this.f454466b = r102;
        this.f454467c = r100;
        this.f454468d = "";
        this.f454469e = "";
        this.f454470f = "";
        this.f454472h = "";
        this.f454473i = ComponentType.UNKNOWN;
        System.currentTimeMillis();
        this.f454474j = new ConcurrentHashMap();
        this.f454475k = new j();
        return;
    L5:
        r103 = null;
        goto L7
    }
}
