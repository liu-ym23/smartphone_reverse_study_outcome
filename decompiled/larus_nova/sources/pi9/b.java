package pi9;

import android.content.Context;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.larus.live.impl.bridge.checkpermission.XCheckPermissionMethod;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public abstract class b extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f529399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final XBridgeMethod.Access f529400b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f529401a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ XBridgeMethod.Callback f529402b;

        public a(b r100, XBridgeMethod.Callback r101) {
            this.f529401a = r100;
            this.f529402b = r101;
        }

        public final void a(d r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "result");
            Intrinsics.checkNotNullParameter(r101, "msg");
            int r102 = d.f529405b;
            Intrinsics.checkNotNullParameter(r100, "data");
            if (r100.f529406a != null) goto L5;
            LinkedHashMap r103 = null;
        L9:
            if (r103 != null) goto L12;
            XCoreBridgeMethod.onFailure$default(this.f529401a, this.f529402b, -5, null, null, 12, null);
            return;
        L12:
            this.f529401a.onSuccess(this.f529402b, r103, r101);
            return;
        L5:
            LinkedHashMap r104 = new LinkedHashMap();
            String r105 = r100.f529406a;
            if (r105 == null) goto L8;
            r104.put("status", r105);
        L8:
            r103 = r104;
            goto L9
        }
    }

    public b() {
        this.f529399a = "x.checkPermission";
        this.f529400b = XBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final XBridgeMethod.Access getAccess() {
        return this.f529400b;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f529399a;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<c> provideParamModel() {
        return c.class;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<d> provideResultModel() {
        return d.class;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r210, XBridgeMethod.Callback r211, XBridgePlatformType r212) {
        Intrinsics.checkNotNullParameter(r210, "params");
        Intrinsics.checkNotNullParameter(r211, "callback");
        Intrinsics.checkNotNullParameter(r212, "type");
        int r100 = c.f529403b;
        Intrinsics.checkNotNullParameter(r210, "params");
        String r101 = s.f(r210, "permission", "");
        boolean r110 = false;
        boolean r102 = false;
        if (r101.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        LocationManager r111 = null;
        if (r103 == false) goto L9;
        c r104 = null;
    L10:
        if (r104 != null) goto L13;
        XCoreBridgeMethod.onFailure$default(this, r211, -3, null, null, 12, null);
        return;
    L13:
        a r112 = new a(this, r211);
        XCheckPermissionMethod r105 = (XCheckPermissionMethod) this;
        Intrinsics.checkNotNullParameter(r104, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Intrinsics.checkNotNullParameter(r212, "type");
        String r106 = r104.f529404a;
        if (r106 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("permission");
        r106 = null;
    L17:
        XCheckPermissionMethod.Permission.Companion.getClass();
        if (r106 != null) goto L97;
        XCheckPermissionMethod.Permission r107 = XCheckPermissionMethod.Permission.UNKNOWN;
    L24:
        if (r107 != XCheckPermissionMethod.Permission.UNKNOWN) goto L26;
        Intrinsics.checkNotNullParameter("Illegal permission", "msg");
        XCoreBridgeMethod.onFailure$default(r112.f529401a, r112.f529402b, -3, "Illegal permission", null, 8, null);
        return;
    L26:
        Context r108 = (Context) r105.provideContext(Context.class);
        if (r108 != null) goto L29;
        Intrinsics.checkNotNullParameter("Context not provided in host", "msg");
        XCoreBridgeMethod.onFailure$default(r112.f529401a, r112.f529402b, 0, "Context not provided in host", null, 8, null);
        return;
    L29:
        String r109 = "PERMITTED";
        if (r107 != XCheckPermissionMethod.Permission.NOTIFICATION) goto L41;
        r110 = NotificationManagerCompat.from(r108).areNotificationsEnabled();     // Catch: Exception -> L33
    L35:
        d r113 = new d();
        if (r110 == true) goto L39;
        r109 = "DENIED";
    L39:
        r113.f529406a = r109.toLowerCase();
        pi9.a.a(r112, r113);
        return;
    L33:
        e = move-exception;
        e.printStackTrace();
        goto L35
    L41:
        if (r107 != XCheckPermissionMethod.Permission.LOCATION) goto L67;
        if (Build.VERSION.SDK_INT < 28) goto L99;
        Object r114 = r108.getSystemService("location");
        if ((r114 instanceof LocationManager) == false) goto L47;
        r111 = (LocationManager) r114;
    L47:
        if (r111 == null) goto L54;
        r102 = r111.isLocationEnabled();
    L54:
        if (r102 == true) goto L57;
        d r115 = new d();
        r115.f529406a = "RESTRICTED".toLowerCase();
        pi9.a.a(r112, r115);
        return;
    L57:
        if (ContextCompat.checkSelfPermission(r108, "android.permission.ACCESS_COARSE_LOCATION") != (-1)) goto L59;
    L61:
        d r116 = new d();
        if (r110 == true) goto L65;
        r109 = "DENIED";
    L65:
        r116.f529406a = r109.toLowerCase();
        pi9.a.a(r112, r116);
        return;
    L59:
        if (ContextCompat.checkSelfPermission(r108, "android.permission.ACCESS_FINE_LOCATION") == (-1)) goto L61;
        r110 = true;
        goto L61
    L99:
        if (Settings.Secure.getInt(r108.getContentResolver(), LocationMonitorConst.LOCATION_MODE) == 0) goto L54;
        r102 = true;
    L52:
        e = move-exception;
        e.printStackTrace();
        goto L54
    L67:
        if (r107 != XCheckPermissionMethod.Permission.PHOTOALBUM) goto L74;
        int r117 = dj9.b.f468963a;
        Intrinsics.checkNotNullParameter(r108, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (Build.VERSION.SDK_INT >= 33) goto L71;
    L73:
        List<String> r118 = CollectionsKt.listOf("android.permission.READ_EXTERNAL_STORAGE");
    L76:
        if (r118.size() != 1) goto L82;
        String r119 = (String) CollectionsKt.first(r118);
        if (r119 != null) goto L80;
    L91:
        if (r110 == false) goto L93;
        d r120 = new d();
        r120.f529406a = "PERMITTED".toLowerCase();
        pi9.a.a(r112, r120);
        return;
    L93:
        d r121 = new d();
        r121.f529406a = "DENIED".toLowerCase();
        pi9.a.a(r112, r121);
        return;
    L80:
        if (ContextCompat.checkSelfPermission(r108, r119) == (-1)) goto L91;
    L90:
        r110 = true;
        goto L91
    L82:
        Iterator<String> r122 = r118.iterator();
    L84:
        if (r122.hasNext() == false) goto L90;
        String r123 = r122.next();
        if (r123 == null) goto L84;
        if (ContextCompat.checkSelfPermission(r108, r123) != (-1)) goto L84;
    L71:
        if (r108.getApplicationInfo().targetSdkVersion < 33) goto L73;
        r118 = CollectionsKt.listOf(new String[]{BaseConstants.PERMISSION_READ_MEDIA_IMAGES, BaseConstants.PERMISSION_READ_MEDIA_VIDEO});
        goto L76
    L74:
        r118 = r107.getPermission();
        goto L76
    L97:
        r107 = XCheckPermissionMethod.Permission.valueOf(r106.toUpperCase());     // Catch: Exception -> L21
    L21:
        r107 = XCheckPermissionMethod.Permission.UNKNOWN;
        goto L24
    L9:
        r104 = new c();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r104.f529404a = r101;
        goto L10
    L5:
        r103 = false;
        goto L6
    }
}
