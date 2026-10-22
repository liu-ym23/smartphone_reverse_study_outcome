package com.bytedance.awemeopen.infra.util;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class NetworkUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f198952a = 0;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/awemeopen/infra/util/NetworkUtils$NetworkType;", "", "", "value", "I", "getValue", "()I", UserProfileEvent.POSITION_NONE, "MOBILE", "MOBILE_2G", "MOBILE_3G", "WIFI", "MOBILE_4G", "MOBILE_5G", "ao_base_core_release"}, k = 1, mv = {1, 7, 1})
    public static final enum NetworkType extends Enum<NetworkType> {
        public static final NetworkType MOBILE = null;
        public static final NetworkType MOBILE_2G = null;
        public static final NetworkType MOBILE_3G = null;
        public static final NetworkType MOBILE_4G = null;
        public static final NetworkType MOBILE_5G = null;
        public static final NetworkType NONE = null;
        public static final NetworkType WIFI = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ NetworkType[] f198953a = null;
        private final int value;

        public static NetworkType valueOf(String r100) {
            return (NetworkType) r27.a.a(NetworkType.class, r100);
        }

        public static NetworkType[] values() {
            return (NetworkType[]) f198953a.clone();
        }

        static {
            NetworkType r100 = new NetworkType(UserProfileEvent.POSITION_NONE, 0, 0);
            NONE = r100;
            NetworkType r101 = new NetworkType("MOBILE", 1, 1);
            MOBILE = r101;
            NetworkType r102 = new NetworkType("MOBILE_2G", 2, 2);
            MOBILE_2G = r102;
            NetworkType r103 = new NetworkType("MOBILE_3G", 3, 3);
            MOBILE_3G = r103;
            NetworkType r104 = new NetworkType("WIFI", 4, 4);
            WIFI = r104;
            NetworkType r105 = new NetworkType("MOBILE_4G", 5, 5);
            MOBILE_4G = r105;
            NetworkType r110 = new NetworkType("MOBILE_5G", 6, 6);
            MOBILE_5G = r110;
            f198953a = new NetworkType[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public final int getValue() {
            return this.value;
        }

        public NetworkType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
    }

    @JvmStatic
    public static final NetworkType a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((r100 instanceof Activity) == false) goto L27;
        r100 = ((Activity) r100).getApplicationContext();
    L27:
        Object r101 = r100.getSystemService("connectivity");     // Catch: Throwable -> L25
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.net.ConnectivityManager");     // Catch: Throwable -> L25
        NetworkInfo r102 = ((ConnectivityManager) r101).getActiveNetworkInfo();     // Catch: Throwable -> L25
        if (r102 == null) goto L24;
        if (r102.isAvailable() == false) goto L24;
        int r103 = r102.getType();     // Catch: Throwable -> L25
        if (1 == r103) goto L28;
        if (r103 != 0) goto L34;
        Object r104 = r100.getSystemService("phone");     // Catch: Throwable -> L25
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.telephony.TelephonyManager");     // Catch: Throwable -> L25
        int r105 = ((TelephonyManager) r104).getNetworkType();     // Catch: Throwable -> L25
        if (r105 == 20) goto L33;
        switch(r105) {
            case 1: goto L32;
            case 2: goto L32;
            case 3: goto L31;
            case 4: goto L32;
            case 5: goto L31;
            case 6: goto L31;
            case 7: goto L32;
            case 8: goto L31;
            case 9: goto L31;
            case 10: goto L31;
            case 11: goto L32;
            case 12: goto L31;
            case 13: goto L30;
            case 14: goto L31;
            case 15: goto L31;
            default: goto L29;
        };     // Catch: Throwable -> L25
    L29:
        return NetworkType.MOBILE;
    L30:
        return NetworkType.MOBILE_4G;
    L31:
        return NetworkType.MOBILE_3G;
    L32:
        return NetworkType.MOBILE_2G;
    L33:
        return NetworkType.MOBILE_5G;
    L34:
        return NetworkType.MOBILE;
    L28:
        return NetworkType.WIFI;
    L24:
        return NetworkType.NONE;
    L26:
        return NetworkType.MOBILE;
    }

    @JvmStatic
    public static final boolean b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((r100 instanceof Activity) == false) goto L13;
        r100 = ((Activity) r100).getApplicationContext();
    L13:
        Object r101 = r100.getSystemService("connectivity");     // Catch: Exception -> L12
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.net.ConnectivityManager");     // Catch: Exception -> L12
        NetworkInfo r102 = ((ConnectivityManager) r101).getActiveNetworkInfo();     // Catch: Exception -> L12
        if (r102 == null) goto L15;
        if (r102.isAvailable() == false) goto L16;
        return true;
    L16:
        return false;
    L15:
        return false;
    L17:
        return false;
    }
}
