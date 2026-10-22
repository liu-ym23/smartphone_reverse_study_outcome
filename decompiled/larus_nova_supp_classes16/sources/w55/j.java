package w55;

import com.bytedance.ee.bear.drive.config.fg.DriveOfficeConfig;
import com.bytedance.ee.plugin.common.log.PluginLog;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    public static final class a<T, R> implements Function {
        public static final a<T, R> a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r6) {
            Intrinsics.checkNotNullParameter((String) r6, "it");
            PluginLog.installLog(new i());
            long r0 = System.currentTimeMillis();
            boolean r7 = n.g().a.c();
            tt5.a.h("DrivePluginLog", "install plugin time: " + (System.currentTimeMillis() - r0));
            return Boolean.valueOf(r7);
        }
    }

    static {
    }

    public static Flowable b() {
        tt5.a.h("DrivePluginLog", "start init drive plugin ~");
        return Flowable.just("").observeOn(fo5.d.b()).map(a.a);
    }

    public static boolean a(uu5.i r7) {
        boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.drive.mira_plugin_opt");
        if (r7 != null) goto L5;
        return false;
    L5:
        if (r7.b() == true) goto L42;
        if (r0 == false) goto L44;
        w75.a r8 = (w75.a) r7.a();
        if (r8 == null) goto L12;
        String r2 = r8.f;
        if (r2 == null) goto L12;
    L17:
        tt5.a.h("DrivePluginLog", "hitPluginExt, optimise=" + r0 + ", ext=" + r2);
        DriveOfficeConfig r9 = o75.b.a().getDriveConfig().l;
        if (r9 == null) goto L24;
        boolean r10 = r9.useOffice();
        boolean r4 = i75.h.i(r2);
        tt5.a.h("DrivePluginLog", "hit Office Ext, useOffice=" + r10 + ", isMsOffice=" + r4);
        if (r10 == false) goto L24;
        if (r4 == false) goto L24;
        boolean r11 = true;
    L25:
        if (r11 == true) goto L39;
        DriveOfficeConfig r12 = o75.b.a().getDriveConfig().l;
        if (r12 == null) goto L37;
        Boolean r13 = r12.getUsePdf();
        if (r13 == null) goto L32;
        boolean r14 = r13.booleanValue();
    L33:
        boolean r3 = i75.h.k(r2);
        tt5.a.h("DrivePluginLog", "hit Pdf Ext, usePdf=" + r14 + ", isPdfExt=" + r3);
        if (r14 == false) goto L37;
        if (r3 == false) goto L37;
        boolean r16 = true;
    L38:
        if (r16 == true) goto L39;
        return false;
    L32:
        r14 = false;
    L37:
        r16 = false;
    L39:
        return true;
    L24:
        r11 = false;
    L12:
        if (r8 == null) goto L16;
        w75.b r17 = r8.c();
        if (r17 == null) goto L16;
        r2 = r17.k;
    L16:
        r2 = null;
        goto L17
    L44:
        return false;
    L42:
        return false;
    }
}
