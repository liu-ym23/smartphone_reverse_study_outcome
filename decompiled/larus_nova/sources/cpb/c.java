package cpb;

import android.content.Context;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.log.LogLevel;
import java.util.Locale;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f464733a = 0;

    public static final class a {
        @JvmStatic
        public static void a(String r100, Context r101, Locale r102, Locale r103) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            d.b.a r104 = new d.b.a();     // Catch: Exception -> L16
            Intrinsics.checkNotNullParameter(r100, "scene");     // Catch: Exception -> L16
            r104.f464742d = r100;     // Catch: Exception -> L16
            if (r101 == null) goto L6;
            String r105 = z.b(r101);     // Catch: Exception -> L16
            Intrinsics.checkNotNullParameter(r105, "processName");     // Catch: Exception -> L16
            r104.f464739a = r105;     // Catch: Exception -> L16
        L6:
            if (r102 == null) goto L9;
            if (r103 == null) goto L9;
            Intrinsics.checkNotNullParameter(r103, "locale");     // Catch: Exception -> L16
            r104.f464740b = r103;     // Catch: Exception -> L16
            Intrinsics.checkNotNullParameter(r102, "locale");     // Catch: Exception -> L16
            r104.f464741c = r102;     // Catch: Exception -> L16
        L9:
            d.b r106 = new d.b(r104);     // Catch: Exception -> L16
            Intrinsics.checkNotNullParameter(LogLevel.INFO, "logLevel");     // Catch: Exception -> L16
            if (r106.f464738d == null) goto L12;
            boolean r107 = true;
        L13:
            if (r107 == false) goto L21;
            Log.i("LocaleWatchDog", r106.toString());     // Catch: Exception -> L16
            return;
        L21:
            return;
        L12:
            r107 = false;
        L16:
            e = move-exception;
            Log.e("LocaleWatchDog", "error: " + e.getMessage());
        }
    }

    static {
    }
}
