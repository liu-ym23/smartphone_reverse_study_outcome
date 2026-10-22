package qx9;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.sync.SyncSDK;
import com.larus.applog.api.IApplog;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f535168a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f535169b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f535170c;

    /* JADX INFO: loaded from: classes31.dex */
    public static final class a implements v48.e {
        public a() {
        }

        @Override // v48.e
        public final void onGetId(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_DID);
            Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_INSTALL_ID);
            Intrinsics.checkNotNullParameter(r102, "ssid");
            h.a();
        }
    }

    static {
        f535168a = new AtomicBoolean(false);
        f535169b = LazyKt.lazy(new qx9.a());
    }

    public static void a() {
        IApplog.Companion r100 = IApplog.f287053a;
        String r101 = r100.getDeviceId();
        String r102 = r100.getInstallId();
        if (o0.d(r101) == true) goto L5;
    L13:
        FLogger.f375446a.d("SyncSDKInitManager", "tryStart: deviceId or installId is empty, register OnGetAppLogIdListener");
        if (f535170c != null) goto L18;
        a r103 = new a();
        f535170c = r103;
        r100.j(r103);
        return;
    L18:
        return;
    L5:
        if (o0.d(r102) == false) goto L13;
        if (f535168a.compareAndSet(false, true) == false) goto L9;
        FLogger.f375446a.d("SyncSDKInitManager", "tryStart: start byte sync sdk: deviceId = " + r101 + ", installId = " + r102);
        SyncSDK.start(r101, r102);
    L9:
        a r104 = f535170c;
        if (r104 == null) goto L12;
        r100.k(r104);
    L12:
        f535170c = null;
    }
}
