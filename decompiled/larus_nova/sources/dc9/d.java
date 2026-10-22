package dc9;

import android.os.Build;
import com.bytedance.keva.Keva;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import hq9.t3;
import java.util.List;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f467894a = 0;

    static {
    }

    public static boolean a() {
        Lazy r100 = l.f467898a;
        boolean r101 = false;
        if (((t3) r100.getValue()).b() == true) goto L6;
        FLogger.f375446a.i("PadIdentifyUtils", "isPad: enablePadAdapter is false");
        return false;
    L6:
        if (AppHost.f326268a.isPlugin() == false) goto L8;
        FLogger.f375446a.i("PadIdentifyUtils", "isPad: isPlugin is false");
        return false;
    L8:
        Boolean r102 = l.f467902e;
        if (r102 == null) goto L12;
        return r102.booleanValue();
    L12:
        if (((t3) r100.getValue()).d() == false) goto L18;
        Keva r103 = l.f467899b;
        Lazy r104 = l.f467900c;
        if (r103.contains((String) r104.getValue()) == false) goto L18;
        Boolean r105 = Boolean.valueOf(r103.getBoolean((String) r104.getValue(), false));
        l.f467902e = r105;
        if (r105 != null) goto L30;
        return false;
    L30:
        return r105.booleanValue();
    L18:
        String r106 = Build.MODEL;
        int r107 = ((t3) r100.getValue()).c();
        if (r107 != 0) goto L22;
        r101 = ((List) l.f467901d.getValue()).contains(r106);
    L24:
        l.f467899b.storeBoolean((String) l.f467900c.getValue(), r101);
        l.f467902e = Boolean.valueOf(r101);
        return r101;
    L22:
        if (r107 != 1) goto L24;
        r101 = true;
        goto L24
    }
}
