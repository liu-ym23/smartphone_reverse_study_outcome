package com.bytedance.ttnet;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.ttnet.utils.TTNetProtocolUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public class NQEManager {
    public static final int CAPTIVE_PORTAL = -2;
    public static final int EXCELLENT_4G = 8;
    public static final int FAKE = -1;
    public static final int GOOD_4G = 7;
    private static final String HEADER_EFFECTIVE_CONNECTION_TYPE = "ECT";
    private static final String HOST_NQE = "nqe";
    public static final int INVALID = -3;
    public static final int MODERATE_4G = 6;
    public static final int NORMAL_2G = 3;
    public static final int NORMAL_3G = 4;
    public static final int OFFLINE = 1;
    private static final String PATH_FORCE_GET = "/force_get";
    public static final int SLOW_2G = 2;
    public static final int SLOW_4G = 5;
    private static final String TAG = null;
    public static final int UNKNOWN = 0;
    private static Map<NQEObserver, Handler> sObservers;

    public interface NQEObserver {
        void onNetworkQualityTypeChanged(int r100);
    }

    public NQEManager() {
    }

    static {
        TAG = "NQEManager";
        sObservers = new HashMap();
    }

    public static /* synthetic */ int access$000(String r100) {
        return parseOrUnknown(r100);
    }

    private static void notifyNQTChanged(final int r100) {
        monitor-enter(NQEManager.class);
        Iterator<Map.Entry<NQEObserver, Handler>> r101 = sObservers.entrySet().iterator();     // Catch: Throwable -> L10
    L6:
        if (r101.hasNext() == false) goto L8;
        Map.Entry<NQEObserver, Handler> r102 = r101.next();     // Catch: Throwable -> L10
        final NQEObserver r103 = r102.getKey();     // Catch: Throwable -> L10
        r102.getValue().post(new AnonymousClass2(r103, r100));     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(NQEManager.class);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private static int parseOrUnknown(String r100) {
        return CastIntegerProtector.parseInt(r100);
    L4:
        return 0;
    }

    public static void unregNQEObserver(NQEObserver r100) {
        if (r100 == null) goto L12;
        monitor-enter(NQEManager.class);
        sObservers.remove(r100);     // Catch: Throwable -> L8
        monitor-exit(NQEManager.class);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L12:
        throw new NullPointerException("observer == null");
    }

    public static void getForceComputeNetworkQuality(final Handler r100, final NQEObserver r101) {
        if (r101 == null) goto L12;
        if (r100 != null) goto L13;
        r100 = new Handler(Looper.getMainLooper());
    L13:
        TTNetProtocolUtil.sendTTNetProtocolRequestAsync(HOST_NQE, PATH_FORCE_GET, null, null, new AnonymousClass1(r100, r101));     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        postResult(r100, r101, 0);
        return;
    L12:
        throw new NullPointerException("observer == null");
    }

    public static void regNQEObserver(NQEObserver r100, Handler r101) {
        if (r100 == null) goto L17;
        if (r101 == null) goto L15;
        monitor-enter(NQEManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sObservers.containsKey(r100) == true) goto L9;
        sObservers.put(r100, r101);     // Catch: Throwable -> L11
    L9:
        monitor-exit(NQEManager.class);     // Catch: Throwable -> L11
        return;
    L15:
        throw new NullPointerException("handler == null");
    L17:
        throw new NullPointerException("observer == null");
    }

    public static /* synthetic */ void access$100(Handler r100, NQEObserver r101, int r102) {
        postResult(r100, r101, r102);
    }

    private static void postResult(Handler r100, final NQEObserver r101, final int r102) {
        r100.post(new AnonymousClass3(r101, r102));
    }
}
