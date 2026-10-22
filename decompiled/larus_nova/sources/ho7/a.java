package ho7;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Looper;
import com.bytedance.bpea.entry.common.DataType;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import oo7.k;

/* JADX INFO: loaded from: classes22.dex */
public final class a {
    public static void a(Context r110) {
        ClipboardManager r100 = f(r110);
        if (r100 == null) goto L29;
        ArrayList r101 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(101800);
        if (r102 == null) goto L7;
        f06.a[] r103 = r102.f479473i;
    L8:
        f06.a[] r104 = r103;
        int r105 = r104.length;
        int r106 = 0;
    L10:
        if (r106 >= r105) goto L17;
        f06.a r107 = r104[r106];
        int r113 = r106;
        int r114 = r105;
        f06.a[] r115 = r104;
        f06.d r108 = r107.preInvoke(101800, "android/content/ClipboardManager", "clearPrimaryClip", r100, r111, "void", r112);     // Catch: Exception -> L23
        if (r108.f474982a == true) goto L19;
        r101.add(r107);     // Catch: Exception -> L23
    L19:
        if (r108.f474982a == true) goto L30;
        r100.clearPrimaryClip();
        return;
    L30:
        return;
    L16:
        r106 = r113 + 1;
        r105 = r114;
        r104 = r115;
        goto L10
    L17:
        r108 = new f06.d(false, null);
        goto L19
    L7:
        r103 = ApiHookConfig.f245613d;
        goto L8
    }

    public static ClipData b(ClipboardManager r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        f06.d r112 = r100.b(101803, "android/content/ClipboardManager", "getPrimaryClip", r110, r101, "android.content.ClipData", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(101803, "android/content/ClipboardManager", "getPrimaryClip", r110, r101, null, r111, false);
        return (ClipData) r112.f474983b;
    L6:
        ClipData r113 = r110.getPrimaryClip();
        r100.a(101803, "android/content/ClipboardManager", "getPrimaryClip", r110, r101, r113, r111, true);
        return r113;
    }

    public static ClipDescription c(ClipboardManager r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(101809);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        f06.d r106 = r105.preInvoke(101809, "android/content/ClipboardManager", "getPrimaryClipDescription", r110, r111, "android.content.ClipDescription", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return (ClipDescription) r106.f474983b;
    L21:
        return r110.getPrimaryClipDescription();
    L14:
        r104 = r114 + 1;
        r103 = r115;
        goto L8
    L15:
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    public static boolean d(ClipboardManager r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(101805);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        f06.d r106 = r105.preInvoke(101805, "android/content/ClipboardManager", "hasPrimaryClip", r110, r111, "boolean", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return ((Boolean) r106.f474983b).booleanValue();
    L21:
        return r110.hasPrimaryClip();
    L14:
        r104 = r114 + 1;
        r103 = r115;
        goto L8
    L15:
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    public static ClipboardManager f(Context r100) {
        if (r100 != null) goto L11;
        return null;
    L11:
        return (ClipboardManager) r100.getSystemService(DataType.CLIPBOARD);
    L7:
        k.a("ClipboardHelper", "Can't create handler inside thread that has not called Looper.prepare() ");
        if (Looper.myLooper() != null) goto L14;
        Looper.prepare();
        return (ClipboardManager) r100.getSystemService(DataType.CLIPBOARD);
    L14:
        return null;
    }

    public static void e(ClipboardManager r110, ClipData r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(101807);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(101807, "android/content/ClipboardManager", "setPrimaryClip", r110, r101, "void", r112);     // Catch: Exception -> L21
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L21
    L17:
        if (r107.f474982a == false) goto L19;
        return;
    L19:
        r110.setPrimaryClip(r111);
        return;
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static void g(Context r100, CharSequence r101) {
        ClipboardManager r102 = f(r100);
        if (r102 == null) goto L12;
        ClipData r103 = ClipData.newPlainText("", r101);
        Intrinsics.checkNotNullParameter(r103, "clip");
        FLogger.f375446a.i("ClipboardManagerLancet", "hook setPrimaryClip");     // Catch: Exception -> L7
        e(r102, r103);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e, "setPrimaryClip Exception:");
        FLogger.f375446a.e("ClipboardManagerLancet", "setPrimaryClip Exception: " + e.getMessage());
        return;
    }
}
