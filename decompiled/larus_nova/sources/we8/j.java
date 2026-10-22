package we8;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.keva.Keva;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f559406a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList<a> f559407b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile int f559408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f559409d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f559410e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f559411f = null;

    public interface a {
        void a(int r100);
    }

    public static final class b implements f09.a.InterfaceC5845a {
        public b() {
        }

        public static void a(Activity r100) {
            int r101 = r100.getResources().getConfiguration().uiMode & 48;
            if (r101 == j.f559409d) goto L6;
            FLogger.f375446a.i("ThemeAdjustManager", "uiMode changed: " + r101);
            j.f559409d = r101;
            j.b();
            return;
        }

        @Override // f09.a.InterfaceC5845a
        public final void onPaused(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // f09.a.InterfaceC5845a
        public final void onPreDestroyed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // f09.a.InterfaceC5845a
        public final void onResumed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            a(r100);
        }

        @Override // f09.a.InterfaceC5845a
        public final void onStart(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // f09.a.InterfaceC5845a
        public final void onStopped(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // f09.a.InterfaceC5845a
        public final void onCreate(Activity r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            a(r100);
        }
    }

    static {
        Lazy r100 = LazyKt.lazy(new g());
        f559406a = r100;
        f559407b = new CopyOnWriteArrayList();
        Keva r101 = (Keva) r100.getValue();
        if (kga.b.a().e() == true) goto L13;
        int r102 = z2.f365865a.getDarkModeDefault();
        if (r102 == 0) goto L13;
        int r103 = 1;
        if (r102 != 1) goto L10;
    L14:
        f559408c = r101.getInt("dark_mode_flag_new", r103);
        f559409d = 16;
        f559410e = -1;
        f559411f = new b();
        return;
    L10:
        if (r102 != 2) goto L14;
        r103 = 2;
    L13:
        r103 = -1;
        goto L14
    }

    public static void b() {
        int r100 = f559408c;
        final int r101 = 2;
        if (r100 == (-1)) goto L11;
        if (r100 == 1) goto L9;
        if (r100 != 2) goto L9;
        r101 = 1;
    L15:
        if (r101 != f559410e) goto L17;
        return;
    L17:
        f559410e = r101;
        FLogger.f375446a.i("ThemeAdjustManager", "setAppLogDarkModeHeader: " + r101);
        t0.a(new i(r101));
        return;
    L9:
        r101 = 0;
        goto L15
    L11:
        if (f559409d == 16) goto L15;
        r101 = 3;
        goto L15
    }

    public static void a(final int r100) {
        if (r100 == f559408c) goto L6;
        FLogger.f375446a.i("ThemeAdjustManager", "saveDarkMode: " + r100);
        f559408c = r100;
        ((Keva) f559406a.getValue()).storeInt("dark_mode_flag_new", r100);
        b();
        t0.a(new h(r100));
        return;
    }
}
