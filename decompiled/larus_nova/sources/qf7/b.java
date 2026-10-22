package qf7;

import android.content.ClipData;
import android.content.ClipboardManager;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.supervisor.token.Token;
import com.larus.platform.service.g;
import com.larus.utils.logger.FLogger;
import f06.d;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements c {
    public b() {
    }

    public static void f(ClipboardManager r110, ClipData r111) {
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
        d r107 = r106.preInvoke(101807, "android/content/ClipboardManager", "setPrimaryClip", r110, r101, "void", r112);     // Catch: Exception -> L21
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
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    @Override // qf7.c
    public final ClipData d(ClipboardManager r110, Token r111) {
        Intrinsics.checkNotNullParameter(r110, "manager");
        Intrinsics.checkNotNullParameter(r111, "token");
        f06.c r112 = new f06.c();
        Object[] r100 = new Object[0];
        f06.b r101 = new f06.b();
        d r113 = r112.b(101803, "android/content/ClipboardManager", "getPrimaryClip", r110, r100, "android.content.ClipData", r101);
        if (r113.f474982a == false) goto L5;
        r112.a(101803, "android/content/ClipboardManager", "getPrimaryClip", r110, r100, null, r101, false);
        return (ClipData) r113.f474983b;
    L5:
        ClipData r114 = r110.getPrimaryClip();
        r112.a(101803, "android/content/ClipboardManager", "getPrimaryClip", r110, r100, r114, r101, true);
        return r114;
    }

    @Override // qf7.c
    public final void a(ClipboardManager r100, ClipData r101, Token r102) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        Intrinsics.checkNotNullParameter(r101, "clip");
        Intrinsics.checkNotNullParameter(r102, "token");
        Intrinsics.checkNotNullParameter(r101, "clip");
        FLogger.f375446a.i("ClipboardManagerLancet", "hook setPrimaryClip");     // Catch: Exception -> L5
        f(r100, r101);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        g.f365738a.ensureNotReachHere(e, "setPrimaryClip Exception:");
        FLogger.f375446a.e("ClipboardManagerLancet", "setPrimaryClip Exception: " + e.getMessage());
    }
}
