package gt5;

import android.text.TextUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.opmonitor.model.OPMonitorLogLevel;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements byb.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f482510a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f482511a = null;

        static {
            int[] r100 = new int[OPMonitorLogLevel.values().length];
            r100[OPMonitorLogLevel.DEBUG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[OPMonitorLogLevel.INFO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[OPMonitorLogLevel.WARN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[OPMonitorLogLevel.ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f482511a = r100;
        }
    }

    static {
        f482510a = new b();
    }

    public b() {
    }

    @Override // byb.c
    public final void a(OPMonitorLogLevel r100, String r101, String r102, int r103, String r104) {
        StringBuilder r105 = new StringBuilder();
        if (TextUtils.isEmpty(r101) == true) goto L6;
        r105.append("filePath: ");
        r105.append(r101);
        r105.append(", ");
    L6:
        if (TextUtils.isEmpty(r102) == true) goto L8;
        r105.append("func: ");
        r105.append(r102);
        r105.append(", ");
    L8:
        if (r103 <= 0) goto L10;
        r105.append("line: ");
        r105.append(r103);
        r105.append(", ");
    L10:
        r105.append(r104);
        if (r100 != null) goto L13;
        int r106 = -1;
    L15:
        if (r106 != 1) goto L17;
        Log.d("op_monitor", r105.toString());
        return;
    L17:
        if (r106 != 2) goto L19;
        Log.i("op_monitor", r105.toString());
        return;
    L19:
        if (r106 != 3) goto L21;
        Log.w("op_monitor", r105.toString());
        return;
    L21:
        if (r106 == 4) goto L23;
        Log.e("op_monitor", r105.toString());
        return;
    L23:
        Log.e("op_monitor", r105.toString());
        return;
    L13:
        r106 = a.f482511a[r100.ordinal()];
        goto L15
    }
}
