package es7;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.sysoptimizer.SmEditTextLeakOpt;
import com.douyin.janna.platform.HONORProcessor;
import com.douyin.janna.platform.VIVOProcessor;
import com.douyin.janna.platform.XMProcessor;
import com.douyin.janna.platform.c;
import com.douyin.janna.platform.f;
import com.douyin.janna.platform.i;
import com.huawei.hms.android.SystemUtils;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile b f473777c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f473778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.douyin.janna.platform.a f473779b;

    public b() {
    }

    public final void a(Context r100) {
        this.f473778a = r100;
        if (r100 != null) goto L6;
    L74:
        com.douyin.janna.platform.a r101 = this.f473779b;
        if (r101 == null) goto L78;
        r101.f();
        return;
    L78:
        return;
    L6:
        if (gs7.b.f482447a == (-1)) goto L8;
    L62:
        int r102 = gs7.b.f482447a;
        if (r102 == 1) goto L73;
        if (r102 == 2) goto L72;
        if (r102 == 3) goto L71;
        if (r102 == 4) goto L70;
        if (r102 == 6) goto L69;
        this.f473779b = new c(this.f473778a);
        goto L74
    L69:
        this.f473779b = new HONORProcessor(this.f473778a);
        goto L74
    L70:
        this.f473779b = new XMProcessor(this.f473778a);
        goto L74
    L71:
        this.f473779b = new VIVOProcessor(this.f473778a);
        goto L74
    L72:
        this.f473779b = new i(this.f473778a);
        goto L74
    L73:
        this.f473779b = new f(this.f473778a);
        goto L74
    L8:
        if (gs7.b.f482448b != (-2)) goto L10;
        gs7.b.f482448b = gs7.c.c("debug.janna.rom", -1);
    L10:
        int r103 = gs7.b.f482448b;
        if (r103 == (-1)) goto L13;
        gs7.b.f482447a = r103;
    L61:
        boolean r104 = hq7.a.f486512a;
        goto L62
    L13:
        String r105 = gs7.c.b("ro.product.brand");
        if (TextUtils.isEmpty(r105) == false) goto L16;
    L22:
        boolean r106 = false;
    L23:
        if (r106 == false) goto L25;
        gs7.b.f482447a = 2;
        goto L61
    L25:
        String r107 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r107) == false) goto L28;
    L30:
        boolean r108 = false;
    L31:
        if (r108 == false) goto L33;
        gs7.b.f482447a = 1;
        goto L61
    L33:
        String r109 = gs7.c.b("ro.vivo.os.name");
        if (TextUtils.isEmpty(r109) == false) goto L36;
    L38:
        boolean r110 = false;
    L39:
        if (r110 == false) goto L42;
        gs7.b.f482447a = 3;
        goto L61
    L42:
        if ((!TextUtils.isEmpty(gs7.c.b("ro.miui.ui.version.name"))) == false) goto L45;
        gs7.b.f482447a = 4;
        goto L61
    L45:
        if (TextUtils.isEmpty(r107) == false) goto L47;
    L49:
        boolean r111 = false;
    L50:
        if (r111 == false) goto L53;
        gs7.b.f482447a = 5;
        goto L61
    L53:
        if (TextUtils.isEmpty(r107) == false) goto L55;
    L57:
        boolean r112 = false;
    L58:
        if (r112 == false) goto L60;
        gs7.b.f482447a = 6;
        goto L61
    L60:
        gs7.b.f482447a = 0;
        goto L61
    L55:
        if (r107.contains(SystemUtils.PRODUCT_HONOR) == false) goto L57;
        r112 = true;
        goto L58
    L47:
        if (r107.contains(SmEditTextLeakOpt.SAMSUNG) == false) goto L49;
        r111 = true;
        goto L50
    L36:
        if (r109.toLowerCase().contains("funtouch") == false) goto L38;
        r110 = true;
        goto L39
    L28:
        if (r107.contains(SystemUtils.PRODUCT_HUAWEI) == false) goto L30;
        r108 = true;
        goto L31
    L16:
        if (r105.toLowerCase().contains(AppConstants.CHANNEL_OPPO) == false) goto L18;
    L21:
        r106 = true;
        goto L23
    L18:
        if (r105.toLowerCase().contains("realme") == true) goto L21;
        if (r105.toLowerCase().contains("oneplus") == false) goto L22;
        goto L21
    }
}
