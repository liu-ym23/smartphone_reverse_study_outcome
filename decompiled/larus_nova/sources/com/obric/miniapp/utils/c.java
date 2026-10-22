package com.obric.miniapp.utils;

import com.google.gson.JsonObject;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f398452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f398453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f398454c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f398455d = null;

    public static final class a implements k0.a {
        public a() {
        }

        @Override // com.obric.miniapp.utils.k0.a
        public final void a(boolean r100) {
            FLogger r101 = FLogger.f375446a;
            r101.i("AppletEventCenter", "Device sleeping state changed to: " + r100);
            if (Intrinsics.areEqual(c.f398453b, Boolean.valueOf(r100)) == true) goto L6;
            c.f398453b = Boolean.valueOf(r100);
            Lazy r102 = l3.d.f507201a;
            JsonObject r103 = new JsonObject();
            r103.addProperty("isSleepMode", Boolean.valueOf(r100));
            Unit r104 = Unit.INSTANCE;
            l3.d.c(new l3.a("onSleepChange", r103, 4));
            r101.d("AppletEventCenter", "Device sleeping change event sent: " + r100);
            return;
        }
    }

    public static final class b implements k0.b {
        public b() {
        }

        @Override // com.obric.miniapp.utils.k0.b
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "screenMode");
            FLogger r101 = FLogger.f375446a;
            r101.i("AppletEventCenter", "Screen mode changed to: ".concat(r100));
            if (Intrinsics.areEqual(c.f398452a, r100) == true) goto L6;
            c.f398452a = r100;
            Lazy r102 = l3.d.f507201a;
            JsonObject r103 = new JsonObject();
            r103.addProperty("screenMode", r100);
            Unit r104 = Unit.INSTANCE;
            l3.d.c(new l3.a("onScreenModeChange", r103, 4));
            r101.i("AppletEventCenter", "Screen mode change event sent: ".concat(r100));
            return;
        }
    }

    static {
        f398454c = new b();
        f398455d = new a();
    }
}
