package com.obric.matrix.sdk.push;

import android.content.Context;
import android.util.Log;
import com.obric.matrix.push.common.cross_process.CrossProcessService;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f397031a;

    public static final class a implements jka.a {
        public a() {
        }

        @Override // jka.a
        public final void onCallback(List<Object> r100) {
            String r101 = "sdk event: " + r100;
            int r102 = kka.b.f503830a;
            Intrinsics.checkNotNullParameter(r101, "msg");
            kka.b.a("", r101);
        }
    }

    public d() {
        this.f397031a = "PushImpl";
    }

    public static void a(Context r100) {
        Context r101 = r100.getApplicationContext();     // Catch: Throwable -> L4
        String r102 = r100.getPackageName();     // Catch: Throwable -> L4
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L4
        r103.put("package_name", r102);     // Catch: Throwable -> L4
        ArrayList r104 = new ArrayList();     // Catch: Throwable -> L4
        r104.add("push_sdk_register");     // Catch: Throwable -> L4
        r104.add(r103.toString());     // Catch: Throwable -> L4
        ika.a r105 = ika.a.f490286a;     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r101);     // Catch: Throwable -> L4
        jka.c r106 = r105.a(r101);     // Catch: Throwable -> L4
        CrossProcessService r107 = (CrossProcessService) r106;     // Catch: Throwable -> L4
        r107.b("sdk_event", r104, new a());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        kka.b.b(Log.getStackTraceString(th));
    }
}
