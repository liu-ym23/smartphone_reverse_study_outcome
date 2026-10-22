package di9;

import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: classes30.dex */
public final class c implements xe6.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f468865a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f468866a = null;

        static {
            int[] r100 = new int[NetworkUtils.NetworkType.values().length];
            r100[NetworkUtils.NetworkType.UNKNOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L35:
            r100[NetworkUtils.NetworkType.NONE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L51:
            r100[NetworkUtils.NetworkType.WIFI.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L39:
            r100[NetworkUtils.NetworkType.WIFI_24GHZ.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L43:
            r100[NetworkUtils.NetworkType.WIFI_5GHZ.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L29:
            r100[NetworkUtils.NetworkType.MOBILE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L45:
            r100[NetworkUtils.NetworkType.MOBILE_2G.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L47:
            r100[NetworkUtils.NetworkType.MOBILE_3G.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
        L37:
            r100[NetworkUtils.NetworkType.MOBILE_4G.ordinal()] = 9;     // Catch: NoSuchFieldError -> L25
        L41:
            r100[NetworkUtils.NetworkType.MOBILE_5G.ordinal()] = 10;     // Catch: NoSuchFieldError -> L26
        L31:
            r100[NetworkUtils.NetworkType.MOBILE_3G_H.ordinal()] = 11;     // Catch: NoSuchFieldError -> L27
        L33:
            r100[NetworkUtils.NetworkType.MOBILE_3G_HP.ordinal()] = 12;     // Catch: NoSuchFieldError -> L28
        L15:
            f468866a = r100;
        }
    }

    static {
        f468865a = new c();
    }

    public c() {
    }

    @Override // xe6.c
    public final String getNetworkType() {
        NetworkUtils.NetworkType r100 = NetworkUtils.getNetworkTypeFast(AppHost.f326268a.getApplication());
        if (r100 != null) goto L5;
        int r101 = -1;
    L6:
        switch(r101) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L8;
            case 8: goto L8;
            case 9: goto L8;
            case 10: goto L8;
            case 11: goto L8;
            case 12: goto L8;
            default: goto L7;
        };
    L7:
        return "other";
    L8:
        return OnekeyLoginConstants.NETWORK_TYPE_MOBILE_STR;
    L9:
        return "wifi";
    L10:
        return "none";
    L11:
        return null;
    L5:
        r101 = a.f468866a[r100.ordinal()];
        goto L6
    }
}
