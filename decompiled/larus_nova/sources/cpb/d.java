package cpb;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.larksuite.framework.utils.x;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.log.LogLevel;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Locale;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f464734a = 0;

    public static final class a {
        @JvmStatic
        public static Locale a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            if (x.b() == false) goto L5;
            Locale r101 = r100.getResources().getConfiguration().getLocales().get(0);
            Intrinsics.checkNotNull(r101);
            return r101;
        L5:
            Locale r102 = r100.getResources().getConfiguration().locale;
            Intrinsics.checkNotNull(r102);
            return r102;
        }

        @JvmStatic
        public static c c(String r100, Application r101) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            Intrinsics.checkNotNullParameter(r101, "application");
            Locale r102 = a(r101);     // Catch: Exception -> L5
            c.a r103 = new c.a();     // Catch: Exception -> L5
            Intrinsics.checkNotNullParameter(r102, "locale");     // Catch: Exception -> L5
            r103.f464750c = r102;     // Catch: Exception -> L5
            String r104 = z.b(r101);     // Catch: Exception -> L5
            Intrinsics.checkNotNullParameter(r104, "processName");     // Catch: Exception -> L5
            r103.f464748a = r104;     // Catch: Exception -> L5
            Intrinsics.checkNotNullParameter(r100, "scene");     // Catch: Exception -> L5
            r103.f464752e = r100;     // Catch: Exception -> L5
            return new c(r103);
        L5:
            e = move-exception;
            Log.e("LocaleWatchDog", "error: " + e.getMessage());
            return new c(new c.a());
        }

        @JvmStatic
        public static c b(String r100, Activity r101, Application r102) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            Intrinsics.checkNotNullParameter(r101, "activity");
            Intrinsics.checkNotNullParameter(r102, "application");
        L9:
            e = move-exception;
            Log.e("LocaleWatchDog", "error: " + e.getMessage());
            return new c(new c.a());
        L4:
            if (x.b() == false) goto L6;
            Locale r103 = r101.getResources().getConfiguration().getLocales().get(0);     // Catch: Exception -> L9
            Locale r104 = r102.getResources().getConfiguration().getLocales().get(0);     // Catch: Exception -> L9
        L7:
            c.a r105 = new c.a();     // Catch: Exception -> L9
            Intrinsics.checkNotNullParameter(r103, "locale");     // Catch: Exception -> L9
            r105.f464749b = r103;     // Catch: Exception -> L9
            Intrinsics.checkNotNullParameter(r104, "locale");     // Catch: Exception -> L9
            r105.f464750c = r104;     // Catch: Exception -> L9
            String r106 = z.b(r102);     // Catch: Exception -> L9
            Intrinsics.checkNotNullParameter(r106, "processName");     // Catch: Exception -> L9
            r105.f464748a = r106;     // Catch: Exception -> L9
            String r107 = r101.getClass().getSimpleName();     // Catch: Exception -> L9
            Intrinsics.checkNotNullParameter(r107, "activityName");     // Catch: Exception -> L9
            r105.f464751d = r107;     // Catch: Exception -> L9
            Intrinsics.checkNotNullParameter(r100, "scene");     // Catch: Exception -> L9
            r105.f464752e = r100;     // Catch: Exception -> L9
            return new c(r105);
        L6:
            r103 = r101.getResources().getConfiguration().locale;     // Catch: Exception -> L9
            r104 = r102.getResources().getConfiguration().locale;     // Catch: Exception -> L9
            goto L7
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f464735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Locale f464736b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Locale f464737c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f464738d;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f464739a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Locale f464740b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Locale f464741c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public String f464742d;

            public a() {
            }
        }

        public final String toString() {
            String r100 = this.f464735a;
            String r101 = "";
            if (r100 != null) goto L6;
            r100 = "";
        L6:
            if (this.f464736b == null) goto L11;
            if (this.f464737c == null) goto L11;
            r101 = ", Locale change from " + this.f464736b + " to " + this.f464737c;
        L11:
            return "Locale(scene =" + this.f464738d + ", processName=" + r100 + ' ' + r101 + ')';
        }

        public b(a r100) {
            String r101 = r100.f464739a;
            Locale r102 = r100.f464740b;
            Locale r103 = r100.f464741c;
            String r104 = r100.f464742d;
            this.f464735a = r101;
            this.f464736b = r102;
            this.f464737c = r103;
            this.f464738d = r104;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f464743a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f464744b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Locale f464745c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Locale f464746d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f464747e;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f464748a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Locale f464749b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Locale f464750c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public String f464751d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public String f464752e;

            public a() {
            }
        }

        public final String toString() {
            String r100 = "";
            if (this.f464743a != null) goto L5;
            String r101 = "";
        L7:
            if (this.f464745c == null) goto L11;
            r100 = "activityLocale=" + this.f464745c + ',';
        L11:
            return "Locale(scene =" + this.f464747e + ", processName=" + this.f464744b + ", " + r101 + ' ' + r100 + " application_locale=" + this.f464746d + ')';
        L5:
            r101 = "activityName=" + this.f464743a + ',';
            goto L7
        }

        public c(a r100) {
            String r101 = r100.f464751d;
            String r102 = r100.f464748a;
            Locale r103 = r100.f464749b;
            Locale r104 = r100.f464750c;
            String r105 = r100.f464752e;
            this.f464743a = r101;
            this.f464744b = r102;
            this.f464745c = r103;
            this.f464746d = r104;
            this.f464747e = r105;
        }

        public final void a(LogLevel r100) {
            Intrinsics.checkNotNullParameter(r100, "logLevel");
            if (this.f464747e == null) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == false) goto L14;
            LogLevel r102 = LogLevel.INFO;
            if (r100 != r102) goto L11;
            Log.i("LocaleWatchDog", toString());
            return;
        L11:
            if (r100.compareTo(r102) >= 0) goto L16;
            Log.d("LocaleWatchDog", toString());
            return;
        L16:
            return;
        L14:
            return;
        L5:
            r101 = false;
            goto L6
        }
    }

    static {
    }
}
