package ys2;

import android.net.Uri;
import com.bytedance.android.livesdk.saas.impl.utils.DolphinConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements de1.b {
    public c() {
    }

    @Override // de1.b
    public final boolean e4(String r100) {
        boolean r101 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L37;
        b.a("isAllowHost=true <<< schema is null/empty");
        return true;
    L37:
        Uri r103 = UriProtector.parse(r100);     // Catch: Throwable -> L35
        String r104 = r103.getHost();
        if (r104 != null) goto L16;
    L19:
        boolean r105 = true;
    L20:
        if (r105 == false) goto L23;
        b.a("isAllowHost=true <<< host is null/empty");
        return true;
    L23:
        ArrayList<String> r106 = DolphinConfig.DEEP_LINK_CONFIG.getValue().a();
        if (r106 != null) goto L26;
    L28:
        r101 = false;
    L29:
        int r107 = b.f568987a;
        StringBuilder r108 = new StringBuilder("isAllowHost=");
        r108.append(r101);
        r108.append(" <<< host is ");
        r108.append(r104);
        r108.append(". uri=");
        String r109 = r103.toString();
        if (r109.length() <= 512) goto L33;
        r109 = r109.substring(0, 512) + "...(len=" + r109.length() + ")";
    L33:
        r108.append(r109);
        b.a(r108.toString());
        return r101;
    L26:
        if (r106.contains(r104) != true) goto L28;
    L16:
        if (r104.length() == 0) goto L19;
        r105 = false;
    L35:
        int r110 = b.f568987a;
        b.a("isAllowHost=true <<< invalid URI. ");
        return true;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r102 = false;
        goto L9
    }

    @Override // de1.b
    public final boolean r5(Uri r100) {
        if (DolphinConfig.DEEP_LINK_CONFIG.getValue().b() == true) goto L6;
        b.a("isFromDeepLink=false <<< settings.enable=false");
        return false;
    L6:
        de1.a.AbstractC5660a r101 = de1.a.f468049a;
        if (r101 == null) goto L9;
        Boolean r102 = r101.a(r100);
    L11:
        if (r102 == null) goto L14;
        int r103 = b.f568987a;
        b.a("isFromDeepLink=" + r102 + " <<< config from host");
        return r102.booleanValue();
    L14:
        int r104 = b.f568987a;
        b.a("isFromDeepLink=false <<< fallback via activity=null");
        return false;
    L9:
        r102 = null;
        goto L11
    }
}
