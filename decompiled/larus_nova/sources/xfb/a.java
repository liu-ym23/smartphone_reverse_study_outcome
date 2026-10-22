package xfb;

import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.floating.enums.ShowPattern;
import com.ss.android.lark.floating.widget.appfloat.AppFloatManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final tfb.a.c f563552a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f563553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f563554c = null;

    /* JADX INFO: renamed from: xfb.a$a, reason: collision with other inner class name */
    public interface InterfaceC8230a {
        void a(boolean r100, String r101);
    }

    public static final class b implements InterfaceC8230a {
        public b() {
        }

        @Override // xfb.a.InterfaceC8230a
        public final void a(boolean r100, String r101) {
            a.f563553b = r100;
            if (r100 == false) goto L5;
            a.b(r101);
            return;
        L5:
            a.a();
        }
    }

    public a() {
    }

    static {
        f563554c = new b();
        tfb.a.b r100 = tfb.a.f545789a;
        tfb.a.c r101 = tfb.a.f545791c;
        f563552a = r101;
        if (r101 == null) goto L5;
        boolean r102 = AppLifecycle.a.f408803a.h();
    L6:
        f563553b = r102;
        return;
    L5:
        r102 = false;
        goto L6
    }

    public static final void a() {
        if (f563553b == true) goto L15;
        Iterator r100 = ((LinkedHashMap) com.ss.android.lark.floating.widget.appfloat.c.f421939b).entrySet().iterator();
    L7:
        if (r100.hasNext() == false) goto L19;
        Map.Entry r101 = (Map.Entry) r100.next();
        String r102 = (String) r101.getKey();
        vfb.a r103 = ((AppFloatManager) r101.getValue()).f421876b;
        if (r103.f554619n != ShowPattern.FOREGROUND) goto L11;
    L13:
        boolean r104 = false;
    L14:
        c(r104, r102);
        goto L7
    L11:
        if (r103.H == false) goto L13;
        r104 = true;
        goto L14
    L19:
        return;
    }

    public static final void b(String r100) {
        if (r100 == null) goto L13;
        Iterator r101 = ((LinkedHashMap) com.ss.android.lark.floating.widget.appfloat.c.f421939b).entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L22;
        Map.Entry r102 = (Map.Entry) r101.next();
        String r103 = (String) r102.getKey();
        vfb.a r104 = ((AppFloatManager) r102.getValue()).f421876b;
        if (r104.f554619n == ShowPattern.BACKGROUND) goto L9;
        if (r104.H == false) goto L6;
        c(!r104.F.contains(r100), r103);
        goto L6
    L9:
        c(false, r103);
        goto L6
    L22:
        return;
    }

    public static void c(boolean r100, String r101) {
        LinkedHashMap r102 = (LinkedHashMap) com.ss.android.lark.floating.widget.appfloat.c.f421939b;
        AppFloatManager r103 = (AppFloatManager) r102.get(r101);
        if (r103 == null) goto L7;
        vfb.a r104 = r103.f421876b;
        if (r104 == null) goto L7;
        boolean r105 = r104.H;
    L8:
        if (r101 != null) goto L10;
        r101 = "default";
    L10:
        AppFloatManager r106 = (AppFloatManager) r102.get(r101);
        if (r106 == null) goto L17;
        if (r100 == false) goto L14;
        int r107 = 0;
    L15:
        r106.h(r107, r105);
        Unit r108 = Unit.INSTANCE;
        return;
    L14:
        r107 = 8;
        goto L15
    L17:
        return;
    L7:
        r105 = true;
        goto L8
    }
}
