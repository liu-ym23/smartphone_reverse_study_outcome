package com.bytedance.reparo.core;

import com.bytedance.mira.plugin.core.func.soloader.SoLoader;
import com.bytedance.reparo.core.common.event.Event;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class PatchEventReporter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f267312a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static c f267313b;

    /* JADX INFO: loaded from: classes21.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface InstallStatus {
        public static final int INSTALL_FAILED = 0;
        public static final int INSTALL_SUCCESS = 1;
    }

    /* JADX INFO: loaded from: classes21.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface UpdateStatus {
        public static final int UPDATE_FAILED_INSTALL = 0;
        public static final int UPDATE_FAILED_PRELOAD = 1;
        public static final int UPDATE_SUCCESS = 2;
    }

    public class a implements v87.a {
        public a() {
        }

        @Override // v87.a
        public final void a(Event r100) {
            PatchEventReporter.f267313b.a(r100);
        }
    }

    public class b implements c {
        public b() {
        }

        @Override // com.bytedance.reparo.core.PatchEventReporter.c
        public final void a(Event r100) {
            if (r100.f267348g == false) goto L5;
            k.c("PatchEventReporter", r100.toString());
            return;
        L5:
            k.a("PatchEventReporter", r100.toString());
        }
    }

    public interface c {
        void a(Event r100);
    }

    static {
        f267312a = new a();
        f267313b = new b();
    }

    public static Event a(c97.h r100, int r101) {
        Event r102 = new Event();
        r102.f267342a = "PatchEventReporter";
        r102.f267344c = "patch_install";
        r102.f267355n = f267312a;
        if (r101 != 0) goto L5;
        r102.f267343b = 2;
        r102.f267348g = false;
    L6:
        r102.i("patch_version", w87.d.a(r100.f22889i));
        r102.i("patch_id", w87.d.a(r100.f22890j));
        r102.i(MonitorConstants.APP_INSTALL_STATUS, Integer.valueOf(r101));
        return r102;
    L5:
        r102.f267343b = 0;
        r102.f267348g = true;
        goto L6
    }

    public static Event b(c97.h r100, boolean r101) {
        Event r102 = new Event();
        r102.f267342a = "PatchEventReporter";
        r102.f267344c = "patch_load";
        r102.f267355n = f267312a;
        if (r101 == false) goto L5;
        r102.f267343b = 0;
        r102.f267348g = true;
    L6:
        r102.i("patch_version", w87.d.a(r100.f22889i));
        r102.i("patch_id", w87.d.a(r100.f22890j));
        r102.i("is_async", w87.d.a(Boolean.valueOf(r100.f22892l)));
        return r102;
    L5:
        r102.f267343b = 2;
        r102.f267348g = false;
        goto L6
    }

    public static Event c(boolean r100, List r101) {
        Event r102 = new Event();
        r102.f267342a = SoLoader.TAG;
        r102.f267344c = "so_md5_check";
        r102.f267355n = f267312a;
        if (r100 == false) goto L5;
        r102.f267343b = 0;
        r102.f267348g = true;
    L6:
        Integer r103 = Integer.valueOf(r101.size());
        if (r102.f267352k != null) goto L9;
        r102.f267352k = new HashMap();
    L9:
        r102.f267352k.put("so_list_size", r103);
        return r102;
    L5:
        r102.f267343b = 2;
        r102.f267348g = false;
        goto L6
    }

    public static Event d(c97.h r100, int r101) {
        Event r102 = new Event();
        r102.f267342a = "PatchEventReporter";
        r102.f267344c = "patch_update";
        r102.f267355n = f267312a;
        if (r101 != 2) goto L5;
        r102.f267343b = 0;
        r102.f267348g = true;
    L6:
        r102.i("patch_version", w87.d.a(r100.f22889i));
        r102.i("patch_id", w87.d.a(r100.f22890j));
        r102.i("update_status", Integer.valueOf(r101));
        return r102;
    L5:
        r102.f267343b = 2;
        r102.f267348g = false;
        goto L6
    }
}
