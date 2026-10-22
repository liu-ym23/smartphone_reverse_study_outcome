package com.ss.android.lark.message.lynxcard.monitor;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.message.card.view.j;
import com.ss.android.lark.opmonitor.model.OPMonitorLogLevel;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class b extends OPMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final fyb.e f432222a = null;

    public static final class a implements byb.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f432223a = null;

        static {
            f432223a = new a();
        }

        public a() {
        }

        @Override // byb.d
        public final void a(String r100, HashMap<String, Object> r101, HashMap<String, Object> r102) {
            j.a(r100, new JSONObject(r102), new JSONObject(r101));
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.message.lynxcard.monitor.b$b, reason: collision with other inner class name */
    public static final class C5134b implements byb.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C5134b f432224a = null;

        /* JADX INFO: renamed from: com.ss.android.lark.message.lynxcard.monitor.b$b$a */
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f432225a = null;

            static {
                int[] r100 = new int[OPMonitorLogLevel.values().length];
                r100[OPMonitorLogLevel.ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r100[OPMonitorLogLevel.FATAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r100[OPMonitorLogLevel.WARN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r100[OPMonitorLogLevel.INFO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r100[OPMonitorLogLevel.DEBUG.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                f432225a = r100;
            }
        }

        static {
            f432224a = new C5134b();
        }

        public C5134b() {
        }

        @Override // byb.c
        public final void a(OPMonitorLogLevel r100, String r101, String r102, int r103, String r104) {
            StringBuilder r105 = new StringBuilder("filePath:");
            r105.append(r101);
            r105.append("\tfunction:");
            r105.append(r102);
            r105.append("\tline:");
            r105.append(r103);
            r105.append("\tcontent");
            r105.append(r104);
            if (r100 != null) goto L5;
            int r106 = -1;
        L7:
            if (r106 != 1) goto L9;
        L20:
            Log.e("op_monitor", r105.toString());
            return;
        L9:
            if (r106 == 2) goto L20;
            if (r106 != 3) goto L13;
            Log.w("op_monitor", r105.toString());
            return;
        L13:
            if (r106 != 4) goto L15;
            Log.i("op_monitor", r105.toString());
            return;
        L15:
            if (r106 == 5) goto L17;
            Log.d("op_monitor", r105.toString());
            return;
        L17:
            Log.d("op_monitor", r105.toString());
            return;
        L5:
            r106 = a.f432225a[r100.ordinal()];
            goto L7
        }
    }

    public static final class c {
        public static b a(ncb.c r100) {
            b r101 = new b(r100);
            r101.addCategoryValue("tenant_id", jrb.e.b(com.ss.android.lark.message.card.b.a().getLoginTenantId()));
            r101.addCategoryValue("user_id", jrb.e.b(com.ss.android.lark.message.card.b.a().getLoginUserId()));
            return r101;
        }
    }

    static {
        f432222a = new fyb.e(new dyb.a(a.f432223a, C5134b.f432224a));
    }

    public b(ncb.c r100) {
        super(f432222a, "op_open_card", r100);
    }
}
