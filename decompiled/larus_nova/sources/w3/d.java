package w3;

import android.app.Activity;
import android.app.Application;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import androidx.core.content.ContextCompat;
import com.bytedance.ai.utils.g;
import com.bytedance.android.livehostapi.business.IHostShare;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.google.gson.JsonObject;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import f2.k;
import java.lang.ref.WeakReference;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f558094a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f558095b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Context f558096c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static c f558097d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static c f558098e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f558099f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static long f558100g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String[] f558101h = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f558102a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static WeakReference<Activity> f558103b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static Object f558104c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static Class<?> f558105d;

        static {
            f558102a = new a();
        }

        public a() {
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class a() throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r102 = Class.forName("android.app.Activity$ScreenCaptureCallback");     // Catch: Throwable -> L8
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a("android.app.Activity$ScreenCaptureCallback");     // Catch: Throwable -> L8
        L7:
            return r102;
        L8:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b("android.app.Activity$ScreenCaptureCallback");
        L12:
            throw th;
        L34:
            Class<?> r103 = Class.forName("android.app.Activity$ScreenCaptureCallback");     // Catch: Throwable -> L17
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a("android.app.Activity$ScreenCaptureCallback");     // Catch: Throwable -> L17
        L16:
            return r103;
        L17:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b("android.app.Activity$ScreenCaptureCallback");
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName("android.app.Activity$ScreenCaptureCallback");
        }

        public static void b(Activity r100) {
            if (Build.VERSION.SDK_INT < 34) goto L28;
            if (r100 == null) goto L30;
            WeakReference<Activity> r101 = f558103b;
            if (r101 == null) goto L9;
            Activity r102 = r101.get();
        L10:
            if (r102 == r100) goto L12;
        L14:
            c(null);
            Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L17
            Class<?> r104 = a();     // Catch: Throwable -> L17
            Object r105 = Proxy.newProxyInstance(r104.getClassLoader(), new Class[]{r104}, new w3.c());     // Catch: Throwable -> L17
            Activity.class.getMethod("registerScreenCaptureCallback", new Class[]{Executor.class, r104}).invoke(r100, new Object[]{r100.getMainExecutor(), r105});     // Catch: Throwable -> L17
            f558103b = new WeakReference(r100);     // Catch: Throwable -> L17
            f558104c = r105;     // Catch: Throwable -> L17
            f558105d = r104;     // Catch: Throwable -> L17
            Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
        L20:
            if (Result.m9456isSuccessimpl(r106) == false) goto L22;
            Unit r107 = (Unit) r106;
            g.f37637a.i("UserCaptureScreenEventHelper", "android screen capture callback registered");
        L22:
            Throwable r108 = Result.m9452exceptionOrNullimpl(r106);
            if (r108 == null) goto L29;
            g.f37637a.w("UserCaptureScreenEventHelper", "register android screen capture callback failed", r108);
            return;
        L29:
            return;
        L17:
            th = move-exception;
            Result.Companion r109 = Result.Companion;
            r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L20
        L12:
            if (f558104c == null) goto L14;
            return;
        L9:
            r102 = null;
            goto L10
        L30:
            return;
        }

        public static void c(Activity r100) {
            WeakReference<Activity> r101 = f558103b;
            if (r101 == null) goto L5;
            Activity r102 = r101.get();
        L6:
            if (r100 == null) goto L9;
            if (r102 == r100) goto L9;
            return;
        L9:
            Object r103 = f558104c;
            Class<?> r104 = f558105d;
            if (r102 == null) goto L23;
            if (r103 == null) goto L23;
            if (r104 == null) goto L23;
            Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L15
            Object r106 = Result.m9449constructorimpl(Activity.class.getMethod("unregisterScreenCaptureCallback", new Class[]{r104}).invoke(r102, new Object[]{r103}));     // Catch: Throwable -> L15
        L18:
            if (Result.m9456isSuccessimpl(r106) == false) goto L20;
            g.f37637a.i("UserCaptureScreenEventHelper", "android screen capture callback unregistered");
        L20:
            Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
            if (r107 == null) goto L23;
            g.f37637a.w("UserCaptureScreenEventHelper", "unregister android screen capture callback failed", r107);
        L15:
            th = move-exception;
            Result.Companion r108 = Result.Companion;
            r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        L23:
            f558103b = null;
            f558104c = null;
            f558105d = null;
            return;
        L5:
            r102 = null;
            goto L6
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f558106a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f558107b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f558108c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f558109d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f558106a, r101.f558106a) == true) goto L12;
            return false;
        L12:
            if (this.f558107b == r101.f558107b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f558108c, r101.f558108c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f558106a.hashCode() * 31;
            long r101 = this.f558107b;
            return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f558108c.hashCode();
        }

        public final String toString() {
            return "MediaImageSnapshot(uri=" + this.f558106a + ", dateAdded=" + this.f558107b + ", path=" + this.f558108c + ')';
        }

        public b(Uri r100, long r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            Intrinsics.checkNotNullParameter(r102, "path");
            this.f558106a = r100;
            this.f558107b = r101;
            this.f558108c = r102;
            this.f558109d = r100.toString();
        }
    }

    public static final class c extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f558110a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WeakReference<Context> f558111b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f558112c;

        @Override // android.database.ContentObserver
        public final void onChange(boolean r210) {
            super.onChange(r210);
            Context r100 = this.f558111b.get();
            if (r100 != null) goto L5;
            return;
        L5:
            int r101 = Build.VERSION.SDK_INT;
            if (r101 < 33) goto L8;
            String r102 = BaseConstants.PERMISSION_READ_MEDIA_IMAGES;
        L10:
            if (ContextCompat.checkSelfPermission(r100, r102) != 0) goto L12;
            boolean r103 = true;
        L14:
            if (r103 == false) goto L16;
            Uri r104 = this.f558110a;
            List r110 = CollectionsKt.mutableListOf(new String[]{DBDefinition.ID, "date_added", "_display_name"});
            if (r101 < 29) goto L22;
            r110.add(LynxEventReporter.PROP_NAME_RELATIVE_PATH);
        L105:
            Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L74
            Cursor r105 = a(r100.getContentResolver(), r104, (String[]) r110.toArray(new String[0]));     // Catch: Throwable -> L74
            if (r105 == null) goto L71;
            Cursor r112 = r105;     // Catch: Throwable -> L74
            Cursor r106 = r112;     // Catch: Throwable -> L64
            if (r106.moveToFirst() == true) goto L30;
            b r107 = null;
        L62:
            CloseableKt.closeFinally(r112, null);     // Catch: Throwable -> L74
        L72:
            Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L74
        L76:
            Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
            if (r109 == null) goto L80;
            g.f37637a.w("UserCaptureScreenEventHelper", "queryLatestImage failed, uri=" + r104, r109);
        L80:
            if (Result.m9455isFailureimpl(r108) == false) goto L82;
            r108 = null;
        L82:
            b r113 = (b) r108;
            if (r113 != null) goto L85;
            return;
        L85:
            long r114 = System.currentTimeMillis() - (r113.f558107b * 1000);
            if ((-6000) <= r114) goto L88;
        L90:
            boolean r115 = false;
        L91:
            if (r115 == false) goto L111;
            String r116 = r113.f558108c.toLowerCase(Locale.ROOT);
            String[] r117 = d.f558101h;
            int r118 = r117.length;
            int r119 = 0;
        L93:
            if (r119 >= r118) goto L98;
            if (StringsKt.contains$default(r116, r117[r119], false, 2, null) == true) goto L96;
            r119 = r119 + 1;
            goto L93
        L96:
            boolean r120 = true;
        L99:
            if (r120 == false) goto L112;
            d.a(d.f558094a, r113.f558109d);
            return;
        L112:
            return;
        L98:
            r120 = false;
            goto L99
        L111:
            return;
        L88:
            if (r114 >= 6001) goto L90;
            r115 = true;
            goto L91
        L30:
            int r121 = r106.getColumnIndex(DBDefinition.ID);     // Catch: Throwable -> L64
            long r122 = 0;
            if (r121 < 0) goto L33;
            long r123 = r106.getLong(r121);     // Catch: Throwable -> L64
        L34:
            int r124 = r106.getColumnIndex("date_added");     // Catch: Throwable -> L64
            if (r124 < 0) goto L37;
            r122 = r106.getLong(r124);     // Catch: Throwable -> L64
        L37:
            long r125 = r122;
            int r126 = r106.getColumnIndex("_display_name");     // Catch: Throwable -> L64
            if (r126 < 0) goto L41;
            String r127 = r106.getString(r126);     // Catch: Throwable -> L64
        L42:
            String r128 = "";
            if (r127 != null) goto L45;
            r127 = "";
        L45:
            if (r101 < 29) goto L54;
            int r129 = r106.getColumnIndex(LynxEventReporter.PROP_NAME_RELATIVE_PATH);     // Catch: Throwable -> L64
            if (r129 < 0) goto L49;
            String r130 = r106.getString(r129);     // Catch: Throwable -> L64
        L50:
            if (r130 == null) goto L53;
            r128 = r130;
        L53:
            r128 = r128.concat(r127);     // Catch: Throwable -> L64
        L61:
            r107 = new b(ContentUris.withAppendedId(r104, r123), r125, r128);     // Catch: Throwable -> L64
        L49:
            r130 = null;
            goto L50
        L54:
            int r131 = r106.getColumnIndex("_data");     // Catch: Throwable -> L64
            if (r131 < 0) goto L57;
            String r132 = r106.getString(r131);     // Catch: Throwable -> L64
        L58:
            if (r132 == null) goto L61;
            r128 = r132;
            goto L61
        L57:
            r132 = null;
            goto L58
        L41:
            r127 = null;
            goto L42
        L33:
            r123 = 0;
        L64:
            th = move-exception;
            throw th;     // Catch: Throwable -> L67
        L67:
            th = move-exception;
            CloseableKt.closeFinally(r112, th);     // Catch: Throwable -> L74
            throw th;     // Catch: Throwable -> L74
        L71:
            r107 = null;
        L74:
            th = move-exception;
            Result.Companion r133 = Result.Companion;
            r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L76
        L22:
            r110.add("_data");
            goto L105
        L16:
            if (this.f558112c == true) goto L110;
            g.f37637a.w("UserCaptureScreenEventHelper", "screen capture content observer skipped: missing image read permission");
            this.f558112c = true;
            return;
        L110:
            return;
        L12:
            r103 = false;
            goto L14
        L8:
            r102 = "android.permission.READ_EXTERNAL_STORAGE";
            goto L10
        }

        public c(Uri r100, WeakReference<Context> r101) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(new Handler(Looper.getMainLooper()));
            this.f558110a = r100;
            this.f558111b = r101;
        }

        public static Cursor a(ContentResolver r110, Uri r111, String[] r112) {
            f06.c r113 = new f06.c();
            Object[] r114 = {r111, r112, null, null, "date_added DESC"};
            f06.b r115 = new f06.b();
            f06.d r100 = r113.b(240004, "android/content/ContentResolver", "query", r110, r114, "android.database.Cursor", r115);
            if (r100.f474982a == false) goto L6;
            r113.a(240004, "android/content/ContentResolver", "query", r110, r114, null, r115, false);
            return (Cursor) r100.f474983b;
        L6:
            Cursor r101 = r110.query(r111, r112, null, null, "date_added DESC");
            r113.a(240004, "android/content/ContentResolver", "query", r110, r114, r101, r115, true);
            return r101;
        }
    }

    public d() {
    }

    static {
        f558094a = new d();
        f558095b = new Object();
        f558101h = new String[]{IHostShare.ShareType.SCREENSHOT, "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap", "截屏", "截图"};
    }

    public static void c() {
        Context r100 = k.a().getApplicationContext();
        Object r101 = f558095b;
        monitor-enter(r101);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (f558096c == null) goto L8;
        monitor-exit(r101);
        return;
    L8:
        f558096c = r100;     // Catch: Throwable -> L21
        d r102 = f558094a;     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r100);     // Catch: Throwable -> L21
        r102.getClass();     // Catch: Throwable -> L21
        b(r100);     // Catch: Throwable -> L21
        if (Build.VERSION.SDK_INT >= 34) goto L12;
    L18:
        a r103 = a.f558102a;     // Catch: Throwable -> L21
        Activity r104 = k.b();     // Catch: Throwable -> L21
        r103.getClass();     // Catch: Throwable -> L21
        a.b(r104);     // Catch: Throwable -> L21
        g.f37637a.i("UserCaptureScreenEventHelper", "start monitoring success");     // Catch: Throwable -> L21
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(r101);
        return;
    L12:
        if ((r100 instanceof Application) == false) goto L14;
        Application r106 = (Application) r100;     // Catch: Throwable -> L21
    L15:
        if (r106 == null) goto L18;
        r106.registerActivityLifecycleCallbacks(new e());     // Catch: Throwable -> L21
        goto L18
    L14:
        r106 = null;
        goto L15
    }

    public static void b(Context r100) {
        if (Build.VERSION.SDK_INT <= 28) goto L5;
        boolean r101 = true;
    L6:
        f558097d = new c(MediaStore.Images.Media.INTERNAL_CONTENT_URI, new WeakReference(r100));
        f558098e = new c(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new WeakReference(r100));
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L16
        ContentResolver r103 = r100.getContentResolver();     // Catch: Throwable -> L16
        Uri r104 = MediaStore.Images.Media.INTERNAL_CONTENT_URI;     // Catch: Throwable -> L16
        c r105 = f558097d;     // Catch: Throwable -> L16
        if (r105 == null) goto L14;
        r103.registerContentObserver(r104, r101, r105);     // Catch: Throwable -> L16
        ContentResolver r106 = r100.getContentResolver();     // Catch: Throwable -> L16
        Uri r107 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;     // Catch: Throwable -> L16
        c r108 = f558098e;     // Catch: Throwable -> L16
        if (r108 == null) goto L14;
        r106.registerContentObserver(r107, r101, r108);     // Catch: Throwable -> L16
    L14:
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L19:
        if (Result.m9456isSuccessimpl(r109) == false) goto L21;
        Unit r110 = (Unit) r109;
        g.f37637a.i("UserCaptureScreenEventHelper", "content observers registered");
    L21:
        Throwable r111 = Result.m9452exceptionOrNullimpl(r109);
        if (r111 == null) goto L27;
        g.f37637a.w("UserCaptureScreenEventHelper", "registerContentObservers failed", r111);
        return;
    L27:
        return;
    L16:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    L5:
        r101 = false;
        goto L6
    }

    public static final void a(d r100, String r101) {
        r100.getClass();
        long r102 = System.currentTimeMillis();
        Object r103 = f558095b;
        monitor-enter(r103);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (Intrinsics.areEqual(f558099f, r101) == false) goto L7;
    L12:
        monitor-exit(r103);
        return;
    L7:
        if ((r102 - f558100g) < 1000) goto L12;
        f558099f = r101;     // Catch: Throwable -> L14
        f558100g = r102;     // Catch: Throwable -> L14
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r103);
        g.f37637a.i("UserCaptureScreenEventHelper", "publish user capture screen event");
        Lazy r105 = l3.d.f507201a;
        l3.d.c(new l3.a("doubao.onUserCaptureScreen", new JsonObject(), 4));
    }
}
