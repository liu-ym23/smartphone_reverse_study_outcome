package s4;

import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.bytedance.common.utility.NetworkUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f540524a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f540525a = null;

        static {
            int[] r100 = new int[NetworkUtils.NetworkType.values().length];
            r100[NetworkUtils.NetworkType.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L31:
            r100[NetworkUtils.NetworkType.MOBILE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L47:
            r100[NetworkUtils.NetworkType.MOBILE_2G.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L35:
            r100[NetworkUtils.NetworkType.MOBILE_3G.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L39:
            r100[NetworkUtils.NetworkType.MOBILE_3G_H.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L27:
            r100[NetworkUtils.NetworkType.MOBILE_3G_HP.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L41:
            r100[NetworkUtils.NetworkType.MOBILE_4G.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L43:
            r100[NetworkUtils.NetworkType.MOBILE_5G.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L33:
            r100[NetworkUtils.NetworkType.WIFI.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
        L37:
            r100[NetworkUtils.NetworkType.WIFI_24GHZ.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
        L29:
            r100[NetworkUtils.NetworkType.WIFI_5GHZ.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
        L14:
            f540525a = r100;
        }
    }

    static {
    }

    public static String a(NetworkUtils.NetworkType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        switch(a.f540525a[r100.ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L5;
            case 10: goto L5;
            case 11: goto L5;
            default: goto L4;
        };
    L4:
        return "unknown";
    L5:
        return "wifi";
    L6:
        return CJPayBasicUtils.NETWORK_MOBILE;
    L7:
        return CJPayBasicUtils.NETWORK_4G;
    L8:
        return CJPayBasicUtils.NETWORK_3G;
    L9:
        return CJPayBasicUtils.NETWORK_2G;
    L10:
        return "mobile";
    L11:
        return "none";
    }
}
