package ewa;

import android.content.Context;
import android.os.Build;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import androidx.core.content.ContextCompat;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f474606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f474607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f474608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ewa.b f474609d;

    /* JADX INFO: renamed from: ewa.a$a, reason: collision with other inner class name */
    public static final class C5826a {
    }

    public final class b extends PhoneStateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f474610a;

        public b(a r100) {
            this.f474610a = r100;
        }

        @Override // android.telephony.PhoneStateListener
        @Deprecated(message = "Deprecated in Java")
        public final void onCallStateChanged(int r100, String r101) {
            a.a(this.f474610a, r100);
        }
    }

    public final class c extends TelephonyCallback implements TelephonyCallback.CallStateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f474611a;

        public c(a r100) {
            this.f474611a = r100;
        }

        @Override // android.telephony.TelephonyCallback.CallStateListener
        public final void onCallStateChanged(int r100) {
            a.a(this.f474611a, r100);
        }
    }

    static {
    }

    public final void d() {
        Object r100 = this.f474606a.getSystemService("phone");
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        TelephonyManager r101 = (TelephonyManager) r100;
        if (Build.VERSION.SDK_INT < 31) goto L10;
        c r102 = this.f474607b;
        if (r102 == null) goto L7;
        r101.unregisterTelephonyCallback(r102);
    L7:
        b r103 = this.f474608c;
        if (r103 == null) goto L13;
        r101.listen(r103, 0);
    L13:
        this.f474609d = null;
        this.f474607b = null;
        this.f474608c = null;
        return;
    L10:
        b r104 = this.f474608c;
        if (r104 == null) goto L13;
        r101.listen(r104, 0);
        goto L13
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f474606a = r100;
    }

    public final void b(ewa.b r100) {
        Intrinsics.checkNotNullParameter(r100, "phoneCallStateListener");
        if (this.f474607b == null) goto L5;
        return;
    L5:
        if (this.f474608c != null) goto L32;
        int r101 = Build.VERSION.SDK_INT;
        if (r101 > 30) goto L10;
    L13:
        boolean r102 = true;
    L15:
        if (r102 == true) goto L18;
        Log.i("PhoneCallStateListener", "there is no permission");
        return;
    L18:
        Object r103 = this.f474606a.getSystemService("phone");
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        TelephonyManager r104 = (TelephonyManager) r103;
        if (r101 < 31) goto L26;
        c r105 = new c(this);
        r104.registerTelephonyCallback(CoreThreadPool.getDefault().getUIExecutor(), r105);     // Catch: Throwable -> L23
    L25:
        this.f474607b = r105;
    L27:
        this.f474609d = r100;
        return;
    L23:
        th = move-exception;
        this.f474607b = null;
        Log.i("PhoneCallStateListener", "[registerTelephonyCallback]" + th);
        c(this, r104);
        goto L25
    L26:
        c(this, r104);
        goto L27
    L10:
        if (ContextCompat.checkSelfPermission(this.f474606a, "android.permission.READ_PHONE_STATE") == 0) goto L13;
        r102 = false;
        goto L15
    }

    public static final void a(a r100, int r101) {
        r100.getClass();
        if (r101 != 0) goto L5;
        ewa.b r102 = r100.f474609d;
        if (r102 == null) goto L18;
        r102.a(false);
        return;
    L18:
        return;
    L5:
        if (r101 != 1) goto L7;
    L9:
        ewa.b r103 = r100.f474609d;
        if (r103 == null) goto L16;
        r103.a(true);
        return;
    L16:
        return;
    L7:
        if (r101 == 2) goto L9;
    }

    public static final void c(a r100, TelephonyManager r101) {
        b r102 = new b(r100);
        r101.listen(r102, 32);     // Catch: Throwable -> L5
    L7:
        r100.f474608c = r102;
        return;
    L5:
        th = move-exception;
        Log.i("PhoneCallStateListener", "[registerRListener]" + th);
        goto L7
    }
}
