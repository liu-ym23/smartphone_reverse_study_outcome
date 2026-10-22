package com.bytedance.ee.bear.bitable.jsapi.common;

import android.app.Activity;
import android.os.Build;
import androidx.core.content.ContextCompat;
import androidx.core.location.LocationCompat;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ee.bear.bitable.jsapi.BitableJSApiErrorCode;
import com.bytedance.ee.bear.lark.dependency.r;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.supervisor.token.Token;
import com.larus.nova.R;
import com.ss.android.lark.location.dto.LarkLocation;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class LocationHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Token f214372a = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/jsapi/common/LocationHelper$GetLocationRequest;", "Lcom/bytedance/ee/util/io/NonProguard;", LocationMonitorConst.ACCURACY, "", "<init>", "(Ljava/lang/String;)V", "getAccuracy", "()Ljava/lang/String;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GetLocationRequest implements NonProguard {
        private final String accuracy;

        public final String getAccuracy() {
            return this.accuracy;
        }

        public GetLocationRequest(String r100) {
            this.accuracy = r100;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\r\u0018\u00002\u00020\u0001B5\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/bitable/jsapi/common/LocationHelper$OpenLocationRequest;", "Lcom/bytedance/ee/util/io/NonProguard;", "name", "", "address", "scale", "", "latitude", "", "longitude", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;DD)V", "getName", "()Ljava/lang/String;", "getAddress", "getScale", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLatitude", "()D", "getLongitude", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OpenLocationRequest implements NonProguard {
        private final String address;
        private final double latitude;
        private final double longitude;
        private final String name;
        private final Integer scale;

        public final String getAddress() {
            return this.address;
        }

        public final double getLatitude() {
            return this.latitude;
        }

        public final double getLongitude() {
            return this.longitude;
        }

        public final String getName() {
            return this.name;
        }

        public final Integer getScale() {
            return this.scale;
        }

        public OpenLocationRequest(String r100, String r101, Integer r102, double r103, double r104) {
            this.name = r100;
            this.address = r101;
            this.scale = r102;
            this.latitude = r103;
            this.longitude = r104;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/bitable/jsapi/common/LocationHelper$ReverseLocationRequest;", "Lcom/bytedance/ee/util/io/NonProguard;", "latitude", "", "longitude", "<init>", "(DD)V", "getLatitude", "()D", "getLongitude", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ReverseLocationRequest implements NonProguard {
        private final double latitude;
        private final double longitude;

        public final double getLatitude() {
            return this.latitude;
        }

        public final double getLongitude() {
            return this.longitude;
        }

        public ReverseLocationRequest(double r100, double r101) {
            this.latitude = r100;
            this.longitude = r101;
        }
    }

    public interface a {
        void a(JSONObject r100);

        void b(JSONObject r100);
    }

    public interface b {
        void a(JSONObject r100);

        void b(JSONObject r100);
    }

    public interface c {
        void a(JSONObject r100);

        void b(JSONObject r100);
    }

    public static final class d implements com.ss.android.lark.utils.h.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f214373a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ GetLocationRequest f214374b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f214375c;

        public static final class a implements com.ss.android.lark.location.service.g.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f214376a;

            /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.jsapi.common.LocationHelper$d$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C3061a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f214377a = null;

                static {
                    int[] r100 = new int[LarkLocation.CoordinateSystem.values().length];
                    r100[LarkLocation.CoordinateSystem.WGS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
                L9:
                    r100[LarkLocation.CoordinateSystem.GCJ.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
                L5:
                    f214377a = r100;
                }
            }

            public a(b r100) {
                this.f214376a = r100;
            }

            @Override // com.ss.android.lark.location.service.g.a
            public final void a(LarkLocation r100) {
                if (r100 != null) goto L8;
                tt5.a.d("NewLarkForm", "larkLocation is null");
                b r101 = this.f214376a;
                if (r101 == null) goto L41;
                JSONObject r102 = new JSONObject();
                BitableJSApiErrorCode r103 = BitableJSApiErrorCode.UNKNOWN;
                r102.put2("errCode", Integer.valueOf(r103.getCode()));
                r102.put2("errMsg", r103.getErrMsg());
                r101.b(r102);
                return;
            L41:
                return;
            L8:
                tt5.a.b("NewLarkForm", "larkLocation{address:" + r100.f431175a + ", province:" + r100.f431176b + ", city:" + r100.f431177c + ", district:" + r100.f431178d + ", street:" + r100.f431179e + ", errCode:" + r100.f431181g + "}, locationType:" + r100.f431182h + ", latitude:" + r100.getLatitude() + ", longitude:" + r100.getLongitude() + '}');
                if (r100.f431181g != 0) goto L27;
                b r104 = this.f214376a;
                if (r104 == null) goto L42;
                JSONObject r105 = new JSONObject();
                r105.put2("latitude", Double.valueOf(r100.getLatitude()));
                r105.put2("longitude", Double.valueOf(r100.getLongitude()));
                r105.put2("altitude", Double.valueOf(r100.getAltitude()));
                r105.put2("horizontalAccuracy", Float.valueOf(r100.getAccuracy()));
                if (Build.VERSION.SDK_INT < 26) goto L15;
                r105.put2(LocationCompat.EXTRA_VERTICAL_ACCURACY, Float.valueOf(r100.getVerticalAccuracyMeters()));
            L15:
                r105.put2("timestamp", Long.valueOf(r100.getTime()));
                LarkLocation.CoordinateSystem r106 = r100.f431184j;
                if (r106 != null) goto L18;
                int r107 = -1;
            L20:
                if (r107 != 1) goto L22;
                r105.put2("locationType", "wjs84");
            L26:
                r104.a(r105);
                return;
            L22:
                if (r107 == 2) goto L24;
                tt5.a.k("NewLarkForm", "larkLocation coordinateSystem default");
                Unit r108 = Unit.INSTANCE;
                goto L26
            L24:
                r105.put2("locationType", "gcj02");
                goto L26
            L18:
                r107 = C3061a.f214377a[r106.ordinal()];
                goto L20
            L42:
                return;
            L27:
                b r109 = this.f214376a;
                if (r109 == null) goto L44;
                JSONObject r110 = new JSONObject();
                int r111 = r100.f431181g;
                if (r111 != 40100) goto L32;
                BitableJSApiErrorCode r112 = BitableJSApiErrorCode.ADMIN_DISABLE_GPS;
                r110.put2("errCode", Integer.valueOf(r112.getCode()));
                r110.put2("errMsg", r112.getErrMsg());
            L39:
                r109.b(r110);
                return;
            L32:
                if (r111 != 40200) goto L34;
                BitableJSApiErrorCode r113 = BitableJSApiErrorCode.TOKEN_INVALID;
                r110.put2("errCode", Integer.valueOf(r113.getCode()));
                r110.put2("errMsg", r113.getErrMsg());
                goto L39
            L34:
                if (r111 == 40400) goto L36;
                BitableJSApiErrorCode r114 = BitableJSApiErrorCode.UNKNOWN;
                r110.put2("errCode", Integer.valueOf(r114.getCode()));
                r110.put2("errMsg", r114.getErrMsg());
                goto L39
            L36:
                BitableJSApiErrorCode r115 = BitableJSApiErrorCode.ADMIN_DISABLE_AMAP_SDK;
                r110.put2("errCode", Integer.valueOf(r115.getCode()));
                r110.put2("errMsg", r115.getErrMsg());
                tt5.a.h("NewLarkForm", "aMapLocation service is Disable");
                Unit r116 = Unit.INSTANCE;
                goto L39
            }
        }

        public d(Activity r100, GetLocationRequest r101, b r102) {
            this.f214373a = r100;
            this.f214374b = r101;
            this.f214375c = r102;
        }

        @Override // com.ss.android.lark.utils.h.e
        public final void a(boolean r100) {
            if (r100 == false) goto L9;
            r r101 = (r) org.koin.java.a.c(r.class, null, null, 6);
            Activity r102 = this.f214373a;
            Token r103 = LocationHelper.f214372a;
            GetLocationRequest r104 = this.f214374b;
            if (r104 == null) goto L7;
            String r105 = r104.getAccuracy();
            if (r105 == null) goto L7;
        L8:
            r101.g(r102, r103, r105, new a(this.f214375c));
            return;
        L7:
            r105 = "high";
            goto L8
        L9:
            b r106 = this.f214375c;
            if (r106 == null) goto L14;
            JSONObject r107 = new JSONObject();
            BitableJSApiErrorCode r108 = BitableJSApiErrorCode.LOCATION_PERMISSION_DENIED;
            r107.put2("errCode", Integer.valueOf(r108.getCode()));
            r107.put2("errMsg", r108.getErrMsg());
            r106.b(r107);
            return;
        }
    }

    static {
        f214372a = new Token("LARK-PSDA-bitable_form_auto_location_cell");
    }

    public static void b(Activity r100, OpenLocationRequest r110) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r110, "params");
        wb5.c r101 = new wb5.c(r110.getName(), r110.getAddress(), r110.getLatitude(), r110.getLongitude(), r110.getScale());
        ((r) org.koin.java.a.c(r.class, null, null, 6)).e(r100, f214372a, r101);
    }

    public static void a(Activity r110, GetLocationRequest r111, b r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        d r100 = new d(r110, r111, r112);
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, "callback");
        boolean r101 = false;
        if (ContextCompat.checkSelfPermission(r110, "android.permission.ACCESS_COARSE_LOCATION") != 0) goto L5;
        boolean r113 = true;
    L7:
        if (ContextCompat.checkSelfPermission(r110, "android.permission.ACCESS_FINE_LOCATION") != 0) goto L9;
        r101 = true;
    L9:
        if (r113 == false) goto L12;
        if (r101 == false) goto L12;
        r100.a(true);
        return;
    L12:
        HashMap r102 = new HashMap();
        if (r113 == true) goto L15;
        r102.put("android.permission.ACCESS_COARSE_LOCATION", r110.getString(R.string.Bitable_Field_LocationPermissionPopupTitle));
    L15:
        if (r101 == true) goto L17;
        r102.put("android.permission.ACCESS_FINE_LOCATION", r110.getString(R.string.Bitable_Field_LocationPermissionPopupTitle));
    L17:
        com.ss.android.lark.utils.h.e(r110, r100, com.ss.android.lark.utils.m.a(R.string.Bitable_Field_LocationPermissionPopupTitle, R.string.Bitable_Field_LocationPermissionPopupContentAndroid), f214372a, true, 2, 0, new com.ss.android.lark.utils.e(), new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"});
        return;
    L5:
        r113 = false;
        goto L7
    }
}
