package ff0;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f476658a = 0;

    static {
    }

    public static void a(Context r110, String r111, PolarisFileWrapper r112) throws IOException {
        String[] r100 = r110.getAssets().list(r111);
        if (r100 != null) goto L6;
        return;
    L6:
        if (r112.exists() == true) goto L8;
        r112.mkdirs();
    L8:
        int r101 = r100.length;
        int r102 = 0;
    L9:
        if (r102 >= r101) goto L78;
        String r103 = r100[r102];
        if (r111.length() != 0) goto L13;
        boolean r104 = true;
    L14:
        if (r104 == false) goto L16;
        String r105 = r103;
    L17:
        String[] r106 = r110.getAssets().list(r105);
        if (r106 != null) goto L20;
    L26:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L73;
        InputStream r108 = r110.getAssets().open(r105);
        int r109 = r103.length();     // Catch: Throwable -> L43
        int r113 = 0;
    L31:
        if (r113 >= r109) goto L39;
        if (r103.charAt(r113) != '_') goto L35;
        boolean r114 = true;
    L36:
        if (r114 == true) goto L40;
        r113 = r113 + 1;     // Catch: Throwable -> L43
    L40:
        String r115 = r103.substring(0, r113);     // Catch: Throwable -> L43
        String r116 = r103.substring(r113 + 1, r103.length());     // Catch: Throwable -> L43
        PolarisFileWrapper r117 = new PolarisFileWrapper(r112, r115);     // Catch: Throwable -> L43
        if (r117.exists() == false) goto L45;
        com.ss.ugc.effectplatform.util.i r118 = com.ss.ugc.effectplatform.util.i.f458038a;     // Catch: Throwable -> L43
        String r119 = com.ss.ugc.effectplatform.util.i.d(r117.getAbsolutePath());     // Catch: Throwable -> L43
    L47:
        if (r117.exists() == false) goto L52;
        if (r119 == null) goto L52;
        if ((!Intrinsics.areEqual(r116, r119)) == true) goto L52;
    L62:
        Unit r120 = Unit.INSTANCE;     // Catch: Throwable -> L43
        CloseableKt.closeFinally(r108, null);
    L77:
        r102 = r102 + 1;
    L52:
        if (r117.exists() == false) goto L54;
        r117.delete();     // Catch: Throwable -> L43
    L54:
        r117.createNewFile();     // Catch: Throwable -> L43
        PolarisFileOutputStreamWrapper r121 = new PolarisFileOutputStreamWrapper(r117);     // Catch: Throwable -> L43
        byte[] r122 = new byte[1024];     // Catch: Throwable -> L64
    L57:
        int r123 = r108.read(r122);     // Catch: Throwable -> L64
        if (r123 == (-1)) goto L60;
        r121.write(r122, 0, r123);     // Catch: Throwable -> L64
        goto L57
    L60:
        r121.flush();     // Catch: Throwable -> L64
        Unit r124 = Unit.INSTANCE;     // Catch: Throwable -> L64
        CloseableKt.closeFinally(r121, null);     // Catch: Throwable -> L43
        goto L62
    L64:
        th = move-exception;
        throw th;     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        CloseableKt.closeFinally(r121, th);     // Catch: Throwable -> L43
        throw th;     // Catch: Throwable -> L43
    L45:
        r119 = null;
        goto L47
    L35:
        r114 = false;
        goto L36
    L39:
        r113 = -1;
    L43:
        th = move-exception;
        throw th;     // Catch: Throwable -> L70
    L70:
        th = move-exception;
        CloseableKt.closeFinally(r108, th);
        throw th;
    L73:
        PolarisFileWrapper r125 = new PolarisFileWrapper(r112, r103);
        if (r125.exists() == true) goto L76;
        r125.mkdirs();
    L76:
        a(r110, r105, r125);
        goto L77
    L20:
        if (r106.length != 0) goto L22;
        boolean r126 = true;
    L23:
        if (r126 == true) goto L26;
        r107 = false;
        goto L27
    L22:
        r126 = false;
        goto L23
    L16:
        r105 = r111 + '/' + r103;
        goto L17
    L13:
        r104 = false;
        goto L14
    }
}
