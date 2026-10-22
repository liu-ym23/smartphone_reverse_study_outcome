package sz2;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.bytedance.android.monitorV2.DataReporter;
import com.bytedance.android.monitorV2.dataprocessor.TypedDataDispatcher;
import com.bytedance.android.monitorV2.entity.NativeCommon;
import com.bytedance.android.monitorV2.util.l;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f543917a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f543918b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, c> f543919c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Handler f543920d = null;

    public e() {
    }

    static {
        f543917a = new e();
        f543918b = a.f543906a;
        f543919c = new LinkedHashMap();
        f543920d = new Handler(Looper.getMainLooper());
    }

    public static jz2.e h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "monitorId");
        f543918b.getClass();
        f r101 = a.f(r100);
        if (r101 == null) goto L16;
        String r102 = r101.getType();
        if (Intrinsics.areEqual(r102, "lynx") == false) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == false) goto L15;
        Map<String, c> r104 = f543919c;
        LinkedHashMap r105 = (LinkedHashMap) r104;
        c r106 = (c) r105.get(r101.getType());
        if (r106 == null) goto L14;
        jz2.e r107 = r106.b(r101.a());
        if (r107 == null) goto L14;
        return r107;
    L14:
        return new jz2.e(new NativeCommon());
    L15:
        nz2.b.b("ContainerStandardApi", "getUnifyInfo, type not register");
        Unit r108 = Unit.INSTANCE;
    L17:
        if (r108 != null) goto L20;
        nz2.b.b("ContainerStandardApi", "getUnifyInfo, attachedView is null");
    L20:
        return new jz2.e(new NativeCommon());
    L7:
        r103 = Intrinsics.areEqual(r102, "web");
        goto L8
    L16:
        r108 = null;
        goto L17
    }

    public static void b(String r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, "monitorId");
        Intrinsics.checkNotNullParameter(r101, "ct");
        nz2.b.f("ContainerStandardApi", "attach [" + r100 + "] containerType:" + r101.getType());
        f543918b.getClass();
        Intrinsics.checkNotNullParameter(r100, "monitorId");
        Intrinsics.checkNotNullParameter(r101, "ct");
        a.f543910e.put(r100, r101);
        WeakHashMap<View, a.InterfaceC7672a> r102 = a.f543911f;     // Catch: Throwable -> L8
        a.InterfaceC7672a r103 = r102.get(r101.a());     // Catch: Throwable -> L8
        if (r103 == null) goto L6;
        r103.a(r100);     // Catch: Throwable -> L8
    L6:
        r102.remove(r101.a());     // Catch: Throwable -> L8
    L10:
        f543918b.getClass();
        a.j(r100, "container_id", r100);
        a.j(r100, ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE, r101.getType());
        return;
    L8:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);
        goto L10
    }

    public static void a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "monitorId");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        nz2.b.f("ContainerStandardApi", "addContainerContext [monitorId:" + r100 + "][field:" + r101 + "][value:" + r102 + ']');
        f543918b.getClass();
        Intrinsics.checkNotNullParameter(r100, "monitorId");
        Intrinsics.checkNotNullParameter(r101, "field");
        Intrinsics.checkNotNullParameter(r102, "value");
        l.p(a.b(r100), r101, r102);
    }

    public static void c(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "monitorId");
        Intrinsics.checkNotNullParameter(r101, "field");
        nz2.b.f("ContainerStandardApi", "collectBoolean [monitorId:" + r100 + "][field:" + r101 + "][value:" + r102 + ']');
        i(r100, r101, Boolean.valueOf(r102));
    }

    public static void d(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "monitorId");
        Intrinsics.checkNotNullParameter(r101, "field");
        nz2.b.f("ContainerStandardApi", "collectInt [monitorId:" + r100 + "][field:" + r101 + "][value:" + r102 + ']');
        i(r100, r101, Integer.valueOf(r102));
    }

    public static void e(String r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "monitorId");
        Intrinsics.checkNotNullParameter(r101, "field");
        nz2.b.f("ContainerStandardApi", "collectLong [monitorId:" + r100 + "][field:" + r101 + "][value:" + r102 + ']');
        i(r100, r101, Long.valueOf(r102));
    }

    public static void f(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "monitorId");
        Intrinsics.checkNotNullParameter(r101, "field");
        Intrinsics.checkNotNullParameter(r102, "value");
        nz2.b.f("ContainerStandardApi", "collectString [monitorId:" + r100 + "][field:" + r101 + "][value:" + r102 + ']');
        i(r100, r101, r102);
    }

    public static void g(String r100, int r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r100, "monitorId");
        Intrinsics.checkNotNullParameter(r102, "performanceCallback");
        f543918b.getClass();
        f r103 = a.f(r100);
        if (r103 == null) goto L13;
        String r104 = r103.getType();
        if (Intrinsics.areEqual(r104, "lynx") == false) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == false) goto L12;
        Map<String, c> r106 = f543919c;
        LinkedHashMap r107 = (LinkedHashMap) r106;
        c r108 = (c) r107.get(r103.getType());
        if (r108 == null) goto L13;
        r108.d(r103.a(), r101, r102);
        Unit r109 = Unit.INSTANCE;
    L14:
        if (r109 != null) goto L17;
        nz2.b.b("ContainerStandardApi", "getPerformance, attachedView is null");
        return;
    L17:
        return;
    L12:
        nz2.b.b("ContainerStandardApi", "handleNativeInfo, type not register");
        r109 = Unit.INSTANCE;
        goto L14
    L7:
        r105 = Intrinsics.areEqual(r104, "web");
    L13:
        r109 = null;
        goto L14
    }

    public static void i(String r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r101, "field");
        switch(r101.hashCode()) {
            case -1573000044: goto L30;
            case -907987551: goto L27;
            case -245775970: goto L24;
            case -77002359: goto L21;
            case 97555: goto L18;
            case 351608024: goto L15;
            case 855478153: goto L12;
            case 946461684: goto L9;
            case 2138439450: goto L6;
            default: goto L33;
        };
    L33:
        boolean r103 = false;
    L34:
        if (r103 == false) goto L36;
        f543918b.getClass();
        a.j(r100, r101, r102);
    L37:
        f543918b.getClass();
        f r104 = a.f(r100);
        if (r104 == null) goto L43;
        Map<String, c> r105 = f543919c;
        LinkedHashMap r106 = (LinkedHashMap) r105;
        c r107 = (c) r106.get(r104.getType());
        if (r107 == null) goto L44;
        r104.a();
        r107.a(r101, r102);
        return;
    L44:
        return;
    L43:
        return;
    L36:
        f543918b.getClass();
        Intrinsics.checkNotNullParameter(r100, "monitorId");
        Intrinsics.checkNotNullParameter(r101, "field");
        Intrinsics.checkNotNullParameter(r102, "value");
        a.c(r100).put(r101, r102);
        goto L37
    L6:
        if (r101.equals("container_version") == false) goto L33;
    L32:
        r103 = true;
        goto L34
    L9:
        if (r101.equals("core_view_type") == true) goto L32;
    L12:
        if (r101.equals("container_name") == true) goto L32;
    L15:
        if (r101.equals("version") == true) goto L32;
    L18:
        if (r101.equals("biz") == true) goto L32;
    L21:
        if (r101.equals("client_component") == true) goto L32;
    L24:
        if (r101.equals("template_res_type") == true) goto L32;
    L27:
        if (r101.equals("schema") == true) goto L32;
    L30:
        if (r101.equals(BytedCertConstant.IntentKey.VIEW_TYPE) == true) goto L32;
        goto L32
    }

    public static void j(View r100, String r101, b r102) {
        Intrinsics.checkNotNullParameter(r101, "monitorId");
        Intrinsics.checkNotNullParameter(r102, "error");
        nz2.b.f("ContainerStandardApi", "reportContainerError [monitorId:" + r101 + "][errorCode:" + r102.f543912a + "][errorMsg:" + r102.f543913b + ']');
        f543918b.getClass();
        f r103 = a.f(r101);
        if (r100 == null) goto L5;
        jz2.a r104 = a.g(r100);
    L6:
        if (r103 == null) goto L10;
        LinkedHashMap r105 = (LinkedHashMap) f543919c;
        if (r105.get(r103.getType()) == null) goto L10;
        Object r106 = r105.get(r103.getType());
        Intrinsics.checkNotNull(r106);
        ((c) r106).e(r100, r101, r104, r102);
        return;
    L10:
        com.bytedance.android.monitorV2.event.a r107 = new com.bytedance.android.monitorV2.event.a("containerError");
        r107.c();
        r107.f163019m = new jz2.c();
        NativeCommon r108 = new NativeCommon();
        r108.virtualAid = r102.f543914c;
        Intrinsics.checkNotNullParameter(r101, "monitorId");
        Object r109 = a.c(r101).get("url");
        if ((r109 instanceof String) == false) goto L13;
        String r110 = (String) r109;
    L14:
        if (r110 == null) goto L16;
        r108.url = r110;
    L16:
        Intrinsics.checkNotNullParameter(r101, "monitorId");
        Object r111 = a.c(r101).get("native_page");
        if ((r111 instanceof String) == false) goto L19;
        String r112 = (String) r111;
    L20:
        if (r112 == null) goto L22;
        r108.nativePage = r112;
    L22:
        Intrinsics.checkNotNullParameter(r101, "monitorId");
        Object r113 = a.c(r101).get(ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE);
        if ((r113 instanceof String) == false) goto L25;
        String r114 = (String) r113;
    L26:
        if (r114 == null) goto L28;
        r108.containerType = r114;
    L28:
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r107.f163006f = r108;
        r107.f163020n = r102.a();
        r107.f163008h = r104;
        r107.e();
        TypedDataDispatcher r115 = DataReporter.f162979a;
        DataReporter.g(r107, null, Boolean.TRUE);
        return;
    L25:
        r114 = null;
        goto L26
    L19:
        r112 = null;
        goto L20
    L13:
        r110 = null;
        goto L14
    L5:
        Intrinsics.checkNotNullParameter(r101, "monitorId");
        r104 = new jz2.a(a.a(r101));
        goto L6
    }
}
