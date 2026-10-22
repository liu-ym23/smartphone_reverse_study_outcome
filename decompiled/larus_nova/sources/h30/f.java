package h30;

import android.app.Activity;
import android.os.Build;
import com.bytedance.android.live.browser.jsbridge.newmethods.CheckPermissionResultModel;
import com.bytedance.android.live.browser.jsbridge.newmethods.RequestPermissionResultModel;
import com.bytedance.android.live.browser.jsbridge.newmethods.db;
import com.bytedance.android.live.browser.jsbridge.newmethods.s;
import com.bytedance.android.live.browser.jsbridge.newmethods.x1;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, List<String>> f483663a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f483664b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f483665c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f483666d = null;

    @XBridgeMethod(biz = "webcast", name = "checkPermission")
    public static final class a extends com.bytedance.android.live.browser.jsbridge.newmethods.a<x1, CheckPermissionResultModel> {
        public a() {
        }

        public static CheckPermissionResultModel j(String r100) {
            CheckPermissionResultModel r101 = new CheckPermissionResultModel();
            r101.a(CheckPermissionResultModel.Code.Success);
            r101.c(r100);
            r101.b("SUCCESS");
            return r101;
        }

        @Override // com.bytedance.ies.web.jsbridge2.f
        public final void invoke(Object r100, CallContext r101) {
            x1 r102 = (x1) r100;
            Intrinsics.checkNotNullParameter(r102, "params");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            Activity r103 = ContextUtil.contextToActivity(r101.getContext());
            if (r103 != null) goto L5;
            finishWithFailure();
            return;
        L5:
            String r104 = r102.a();
            if (Intrinsics.areEqual(r104, "notification") == false) goto L11;
            int r105 = c30.c.f22265a;
            if (c30.c.b(r103) == false) goto L10;
            finishWithResult(j(f.f483664b));
            return;
        L10:
            finishWithResult(j(f.f483665c));
            return;
        L11:
            Map<String, List<String>> r106 = f.f483663a;
            if (CollectionsKt.contains(r106.keySet(), r104) == false) goto L39;
            e r107 = new e(this);
            List<String> r108 = r106.get(r102.a());
            Intrinsics.checkNotNull(r108);
            Object[] r109 = r108.toArray(new String[0]);
            if (r109 == null) goto L37;
            String[] r110 = (String[]) r109;
            int r111 = Build.VERSION.SDK_INT;
            if (r111 < 23) goto L27;
            Map<String, p60.c> r112 = p60.e.f527862b;
            if (p60.e.a.f527864a.b() == true) goto L27;
            if (m60.b.a(r103, r110) == false) goto L23;
            r107.onPermissionGrant(r110);
            return;
        L23:
            if (m60.c.e(r103, r110) == false) goto L25;
            r107.a(r110);
            return;
        L25:
            r107.onPermissionDenied(r110);
            return;
        L27:
            if (n60.e.a.f518098a.b(r103, r110) == false) goto L29;
            r107.onPermissionGrant(r110);
            return;
        L29:
            if (r111 >= 23) goto L32;
            r107.onPermissionDenied(r110);
            return;
        L32:
            if (m60.c.e(r103, r110) == false) goto L34;
            r107.a(r110);
            return;
        L34:
            r107.onPermissionDenied(r110);
            return;
        L37:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        L39:
            throw new IllegalArgumentException("Unsupported permission operation");
        }
    }

    @XBridgeMethod(biz = "webcast", name = "requestPermission")
    public static final class b extends s<db, RequestPermissionResultModel> {
        public b() {
        }

        public static RequestPermissionResultModel j(String r100) {
            RequestPermissionResultModel r101 = new RequestPermissionResultModel();
            r101.a(RequestPermissionResultModel.Code.Success);
            r101.b("SUCCESS");
            r101.c(r100);
            return r101;
        }

        @Override // com.bytedance.ies.web.jsbridge2.f
        public final void invoke(Object r100, CallContext r101) {
            db r102 = (db) r100;
            Intrinsics.checkNotNullParameter(r102, "params");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            Activity r103 = ContextUtil.contextToActivity(r101.getContext());
            if (r103 != null) goto L5;
            finishWithFailure();
            return;
        L5:
            String r104 = r102.a();
            if (Intrinsics.areEqual(r104, "notification") == false) goto L11;
            int r105 = c30.c.f22265a;
            if (c30.c.b(r103) == false) goto L10;
            finishWithResult(j(f.f483664b));
            return;
        L10:
            d.a(r103, new g(this), new String[]{"notification"});
            return;
        L11:
            Map<String, List<String>> r106 = f.f483663a;
            if (CollectionsKt.contains(r106.keySet(), r104) == false) goto L20;
            h r107 = new h(this);
            List<String> r108 = r106.get(r102.a());
            Intrinsics.checkNotNull(r108);
            Object[] r109 = r108.toArray(new String[0]);
            if (r109 == null) goto L18;
            d.b(r103, r107, (String[]) r109);
            return;
        L18:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        L20:
            throw new IllegalArgumentException("Unsupported permission operation");
        }
    }

    static {
        Pair[] r100 = new Pair[8];
        r100[0] = TuplesKt.to("camera", CollectionsKt.listOf("android.permission.CAMERA"));
        r100[1] = TuplesKt.to("microphone", CollectionsKt.listOf("android.permission.RECORD_AUDIO"));
        if (Build.VERSION.SDK_INT >= 33) goto L5;
    L7:
        List r101 = CollectionsKt.listOf("android.permission.READ_EXTERNAL_STORAGE");
    L8:
        r100[2] = TuplesKt.to("photoAlbum", r101);
        r100[3] = TuplesKt.to("vibrate", CollectionsKt.listOf("android.permission.VIBRATE"));
        r100[4] = TuplesKt.to("location", CollectionsKt.listOf(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}));
        r100[5] = TuplesKt.to("write_calendar", CollectionsKt.listOf("android.permission.WRITE_CALENDAR"));
        r100[6] = TuplesKt.to("read_calendar", CollectionsKt.listOf("android.permission.READ_CALENDAR"));
        r100[7] = TuplesKt.to("calendar", CollectionsKt.listOf(new String[]{"android.permission.WRITE_CALENDAR", "android.permission.READ_CALENDAR"}));
        f483663a = MapsKt.mapOf(r100);
        f483664b = "permitted";
        f483665c = "undetermined";
        f483666d = "denied";
        return;
    L5:
        if (jc1.a.b().getApplicationInfo().targetSdkVersion < 33) goto L7;
        r101 = CollectionsKt.listOf(new String[]{BaseConstants.PERMISSION_READ_MEDIA_IMAGES, BaseConstants.PERMISSION_READ_MEDIA_VIDEO});
        goto L8
    }
}
