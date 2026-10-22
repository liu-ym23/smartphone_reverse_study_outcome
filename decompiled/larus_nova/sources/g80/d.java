package g80;

import android.content.ClipData;
import android.content.ClipboardManager;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.api.clipboard.ClipboardEntry;
import com.bytedance.bpea.entry.common.DataType;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d {
    static {
    }

    @JvmStatic
    public static final ClipData b(TokenCert r110) throws BPEAException {
        Object r100 = jc1.a.b().getSystemService(DataType.CLIPBOARD);
        if (r100 == null) goto L13;
        ClipboardManager r101 = (ClipboardManager) r100;
        if (LiveInfraSettingKeys.LIVE_BPEA_SWITCH.getValue().booleanValue() == false) goto L7;
        ClipboardEntry.f202182a.getClass();
        return ClipboardEntry.Companion.b(r101, r110);
    L7:
        f06.c r111 = new f06.c();
        Object[] r102 = new Object[0];
        f06.b r112 = new f06.b();
        f06.d r113 = r111.b(101803, "android/content/ClipboardManager", "getPrimaryClip", r101, r102, "android.content.ClipData", r112);
        if (r113.f474982a == false) goto L10;
        r111.a(101803, "android/content/ClipboardManager", "getPrimaryClip", r101, r102, null, r112, false);
        return (ClipData) r113.f474983b;
    L10:
        ClipData r114 = r101.getPrimaryClip();
        r111.a(101803, "android/content/ClipboardManager", "getPrimaryClip", r101, r102, r114, r112, true);
        return r114;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
    }

    public static void a(ClipboardManager r110, ClipData r111) {
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

    @JvmStatic
    public static final void c(ClipData r100, Cert r101) throws BPEAException {
        Intrinsics.checkNotNullParameter(r100, "clip");
        Object r102 = jc1.a.b().getSystemService(DataType.CLIPBOARD);
        if (r102 == null) goto L14;
        ClipboardManager r103 = (ClipboardManager) r102;
        if (LiveInfraSettingKeys.LIVE_BPEA_SWITCH.getValue().booleanValue() == false) goto L7;
        ClipboardEntry.f202182a.getClass();
        ClipboardEntry.Companion.c(r103, r100, r101);
        return;
    L7:
        Intrinsics.checkNotNullParameter(r100, "clip");
        FLogger.f375446a.i("ClipboardManagerLancet", "hook setPrimaryClip");     // Catch: Exception -> L10
        a(r103, r100);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e, "setPrimaryClip Exception:");
        FLogger.f375446a.e("ClipboardManagerLancet", "setPrimaryClip Exception: " + e.getMessage());
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
    }

    @JvmStatic
    public static final void d(CharSequence r210, TokenCert r211) throws BPEAException {
        Intrinsics.checkNotNullParameter(r210, "text");
        Object r100 = jc1.a.b().getSystemService(DataType.CLIPBOARD);
        if (r100 == null) goto L27;
        ClipboardManager r101 = (ClipboardManager) r100;
        if (LiveInfraSettingKeys.LIVE_BPEA_SWITCH.getValue().booleanValue() == false) goto L7;
        ClipboardEntry.f202182a.getClass();
        ClipboardEntry.Companion.d(r101, r210, r211);
        return;
    L7:
        ArrayList r110 = new ArrayList();
        Object[] r111 = {r210};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(101808);
        if (r102 == null) goto L10;
        f06.a[] r103 = r102.f479473i;
    L11:
        f06.a[] r104 = r103;
        int r105 = r104.length;
        int r106 = 0;
    L13:
        if (r106 >= r105) goto L20;
        f06.a r107 = r104[r106];
        int r113 = r106;
        int r114 = r105;
        f06.a[] r115 = r104;
        f06.d r108 = r107.preInvoke(101808, "android/content/ClipboardManager", "setText", r101, r111, "void", r112);     // Catch: Exception -> L28
        if (r108.f474982a == true) goto L22;
        r110.add(r107);     // Catch: Exception -> L28
    L22:
        if (r108.f474982a == true) goto L35;
        r101.setText(r210);
        return;
    L35:
        return;
    L19:
        r106 = r113 + 1;
        r105 = r114;
        r104 = r115;
        goto L13
    L20:
        r108 = new f06.d(false, null);
        goto L22
    L10:
        r103 = ApiHookConfig.f245613d;
        goto L11
    L27:
        throw new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
    }
}
