package u56;

import android.text.TextUtils;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.XReadableType;
import com.bytedance.ies.xbridge.base.runtime.depend.IHostNetworkDepend;
import com.bytedance.ies.xbridge.base.runtime.network.RequestMethod;
import com.bytedance.ies.xbridge.base.runtime.thread.ThreadUtils;
import com.bytedance.ies.xbridge.s;
import com.bytedance.ies.xbridge.t;
import com.bytedance.ies.xbridge.u;
import com.bytedance.ies.xbridge.utils.j;
import com.bytedance.ies.xbridge.v;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f548844a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f548845a = null;

        static {
            int[] r100 = new int[XReadableType.values().length];
            r100[XReadableType.Int.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[XReadableType.Boolean.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[XReadableType.Number.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[XReadableType.String.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[XReadableType.Map.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[XReadableType.Array.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f548845a = r100;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u56.a f548846a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Integer f548847b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Throwable f548848c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f548849d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f548850e;

        public b(u56.a r100, Integer r101, Throwable r102, String r103, int r104) {
            this.f548846a = r100;
            this.f548847b = r101;
            this.f548848c = r102;
            this.f548849d = r103;
            this.f548850e = r104;
        }

        @Override // java.lang.Runnable
        public final void run() {
            u56.a r100 = this.f548846a;     // Catch: Throwable -> L11
            Integer r101 = this.f548847b;     // Catch: Throwable -> L11
            Throwable r102 = this.f548848c;     // Catch: Throwable -> L11
            String r103 = this.f548849d;     // Catch: Throwable -> L11
            int r104 = this.f548850e;     // Catch: Throwable -> L11
            Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L8
            if (r102 != null) goto L6;
            r102 = new Throwable(r103);     // Catch: Throwable -> L8
        L6:
            r100.c(r101, r102, r104);     // Catch: Throwable -> L8
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        L19:
            return;
        L8:
            th = move-exception;
            Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L11
            Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L15;
            return;
        L15:
            throw th;
        }
    }

    public d() {
    }

    static {
        f548844a = new d();
    }

    public static LinkedHashMap b(XReadableMap r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        if (r100 == null) goto L16;
        u r102 = r100.keyIterator();
    L6:
        if (r102.hasNextKey() == false) goto L16;
        String r103 = r102.nextKey();
        String r104 = s.f(r100, r103, "");
        if (r104.length() <= 0) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == false) goto L13;
        String r106 = r104;
    L14:
        if (r106 == null) goto L6;
        r101.put(r103, r104);
        goto L6
    L13:
        r106 = null;
        goto L14
    L10:
        r105 = false;
    L16:
        return r101;
    }

    public static void c(i r100, u56.a r101) {
        String r102 = r100.e();
        if (r102 != null) goto L5;
    L10:
        r102 = null;
    L11:
        String r103 = r102;
        Integer r104 = r100.a();
        if (r103 != null) goto L25;
        Integer r105 = r100.d();
        String r106 = r100.b();
        Throwable r107 = r100.c();
        if (r104 == null) goto L16;
        int r108 = r104.intValue();
    L18:
        if (d(r105, r106, r107, r108, r101) == true) goto L37;
        LinkedHashMap<String, String> r109 = r100.f548866a;
        Integer r110 = r100.d();
        if (r104 == null) goto L22;
        int r111 = r104.intValue();
    L23:
        ThreadUtils.a().post(new e(r103, r109, r101, r110, r111));
        return;
    L22:
        r111 = 0;
        goto L23
    L37:
        return;
    L16:
        r108 = 0;
        goto L18
    L25:
        Integer r112 = r100.d();
        String r113 = r100.b();
        Throwable r114 = r100.c();
        if (r104 == null) goto L28;
        int r115 = r104.intValue();
    L30:
        if (d(r112, r113, r114, r115, r101) == true) goto L38;
        LinkedHashMap<String, String> r116 = r100.f548866a;
        Integer r117 = r100.d();
        if (r104 == null) goto L34;
        int r118 = r104.intValue();
    L35:
        ThreadUtils.a().post(new e(r103, r116, r101, r117, r118));
        return;
    L34:
        r118 = 0;
        goto L35
    L38:
        return;
    L28:
        r115 = 0;
        goto L30
    L5:
        if (r102.length() <= 0) goto L7;
        boolean r119 = true;
    L8:
        if (r119 == false) goto L10;
    L7:
        r119 = false;
        goto L8
    }

    public static String a(String r100, XReadableMap r101, XBridgePlatformType r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r102, "type");
        t56.d r104 = new t56.d(r100);
        if (r101 == null) goto L16;
        u r105 = r101.keyIterator();
    L6:
        if (r105.hasNextKey() == false) goto L16;
        String r106 = r105.nextKey();
        t r107 = r101.get(r106);
        XReadableType r108 = r107.getType();
        switch(a.f548845a[r108.ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            default: goto L6;
        };
    L10:
        int r109 = j.f249563a;
        v r110 = r107.asArray();
        Intrinsics.checkNotNull(r110);
        r104.a(r106, j.c(r110).toString());
        goto L6
    L11:
        int r111 = j.f249563a;
        XReadableMap r112 = r107.asMap();
        Intrinsics.checkNotNull(r112);
        r104.a(r106, j.d(r112).toString());
        goto L6
    L12:
        r104.a(r106, r107.asString());
        goto L6
    L13:
        r104.a(r106, String.valueOf(r107.asDouble()));
        goto L6
    L14:
        r104.a(r106, String.valueOf(r107.asBoolean()));
        goto L6
    L15:
        r104.a(r106, String.valueOf(r107.asInt()));
    L16:
        if (r103 == true) goto L18;
    L25:
        r104.b();
        return r104.b();
    L18:
        if (r102 != XBridgePlatformType.WEB) goto L21;
        String r113 = "h5";
    L24:
        r104.a("request_tag_from", r113);
        goto L25
    L21:
        if (r102 != XBridgePlatformType.LYNX) goto L23;
        r113 = "lynx";
        goto L24
    L23:
        r113 = "";
        goto L24
    }

    public static boolean d(Integer r100, String r101, Throwable r110, int r111, u56.a r112) {
        boolean r102 = false;
        if (r110 == null) goto L5;
    L8:
        String r103 = null;
        if (r101 != null) goto L11;
    L17:
        if (r110 == null) goto L19;
        r103 = r110.getMessage();
    L19:
        if (r103 != null) goto L22;
        r101 = "";
    L21:
        String r104 = r101;
    L23:
        ThreadUtils.a().post(new b(r112, r100, r110, r104, r111));
        return true;
    L22:
        r104 = r103;
        goto L23
    L11:
        if (r101.length() <= 0) goto L13;
        r102 = true;
    L13:
        if (r102 == true) goto L16;
        r101 = null;
    L16:
        if (r101 != null) goto L21;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return false;
    }

    public final void delete(String r100, Map<String, String> r101, u56.a r102, IHostNetworkDepend r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "targetUrl");
        Intrinsics.checkNotNullParameter(r101, "headers");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Intrinsics.checkNotNullParameter(r103, "hostNetworkDepend");
        t56.c r105 = new t56.c(r100);
        LinkedHashMap<String, String> r106 = (LinkedHashMap) r101;
        Intrinsics.checkNotNullParameter(r106, "headers");
        r105.f544631b = r106;
        r105.f544632c = r104;
        Intrinsics.checkNotNullParameter(r103, "hostNetworkDepend");
        g r107 = g.f548857a;
        RequestMethod r108 = RequestMethod.DELETE;
        r107.getClass();
        c(g.f(r108, r105, r103), r102);
    }

    public static void e(String r100, Map r101, String r102, byte[] r103, com.larus.live.impl.bridge.request.b r104, IHostNetworkDepend r105, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "targetUrl");
        Intrinsics.checkNotNullParameter(r101, "headers");
        Intrinsics.checkNotNullParameter(r102, "contentType");
        Intrinsics.checkNotNullParameter(r103, "postData");
        Intrinsics.checkNotNullParameter(r104, "callback");
        Intrinsics.checkNotNullParameter(r105, "hostNetworkDepend");
        LinkedHashMap<String, String> r106 = new LinkedHashMap();     // Catch: Throwable -> L5
        r106.putAll(r101);     // Catch: Throwable -> L5
        t56.c r107 = new t56.c(r100);     // Catch: Throwable -> L5
        Intrinsics.checkNotNullParameter(r106, "headers");     // Catch: Throwable -> L5
        r107.f544631b = r106;     // Catch: Throwable -> L5
        Intrinsics.checkNotNullParameter(r102, "contentType");     // Catch: Throwable -> L5
        r107.f544635f = r102;     // Catch: Throwable -> L5
        r107.f544632c = r110;     // Catch: Throwable -> L5
        r107.f544634e = r103;     // Catch: Throwable -> L5
        Intrinsics.checkNotNullParameter(r105, "hostNetworkDepend");     // Catch: Throwable -> L5
        g r108 = g.f548857a;     // Catch: Throwable -> L5
        RequestMethod r109 = RequestMethod.POST;     // Catch: Throwable -> L5
        r108.getClass();     // Catch: Throwable -> L5
        c(g.f(r109, r107, r105), r104);     // Catch: Throwable -> L5
        return;
    }
}
