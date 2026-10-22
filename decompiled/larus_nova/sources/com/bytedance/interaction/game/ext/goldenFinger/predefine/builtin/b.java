package com.bytedance.interaction.game.ext.goldenFinger.predefine.builtin;

import com.bytedance.interaction.game.ext.goldenFinger.predefine.meta.MetaManager;
import com.larus.apm.impl.protector.RunnableProtector;
import j96.d;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BuiltInMetaManager f250899a;

    public b(BuiltInMetaManager r100) {
        this.f250899a = r100;
    }

    public final void a() {
        String r100 = this.f250899a.a();
        if (MetaManager.f250902i.get(r100) == null) goto L5;
        return;
    L5:
        long r101 = System.currentTimeMillis();
        BuiltInMetaManager r102 = this.f250899a;
        if (r102.f250891f == false) goto L8;
        String r103 = "offline/dino_sar_common_external/builtin_meta_debug.json";
    L9:
        d r104 = null;
        InputStream r105 = r102.f250889d.getAssets().open(r103);     // Catch: NullPointerException -> L18 IOException -> L20
        InputStreamReader r106 = new InputStreamReader(r105);     // Catch: NullPointerException -> L18 IOException -> L20
        BufferedReader r107 = new BufferedReader(r106);     // Catch: NullPointerException -> L18 IOException -> L20
        String r108 = "";
        StringBuffer r110 = new StringBuffer();     // Catch: NullPointerException -> L18 IOException -> L20
    L11:
        String r111 = r107.readLine();     // Catch: NullPointerException -> L18 IOException -> L20
        if (r111 == null) goto L14;
        r108 = r111;
    L14:
        if (r111 == null) goto L16;
        r110.append(r108);     // Catch: NullPointerException -> L18 IOException -> L20
        goto L11
    L16:
        String r109 = r110.toString();     // Catch: NullPointerException -> L18 IOException -> L20
        r105.close();     // Catch: NullPointerException -> L18 IOException -> L20
        r106.close();     // Catch: NullPointerException -> L18 IOException -> L20
        r107.close();     // Catch: NullPointerException -> L18 IOException -> L20
        int r112 = f96.a.f475971a;     // Catch: NullPointerException -> L18 IOException -> L20
        f96.a.a("interactive_predefine", "BuiltInMetaManager readMetaFileFromStream success", null);     // Catch: NullPointerException -> L18 IOException -> L20
    L23:
        if (r109 == null) goto L29;
        this.f250899a.getClass();
        int r113 = d.f497795c;
        JSONObject r114 = d.a.a(r109);
        if (r114 == null) goto L27;
        r104 = new d(r114);
    L27:
        if (r104 == null) goto L30;
        MetaManager.f250902i.put(r100, r104);
    L30:
        long r115 = System.currentTimeMillis() - r101;
        int r116 = f96.a.f475971a;
        f96.a.d("interactive_predefine", "BuiltInMetaManager readMetaFileSync call", MapsKt.mapOf(new Pair[]{TuplesKt.to("resFrom", "builtin"), TuplesKt.to("duration", Long.valueOf(r115))}));
        return;
    L29:
        int r117 = f96.a.f475971a;
        f96.a.a("interactive_predefine", "BuiltInMetaManager readMetaFileAsync call error,because readMetaFileFromStream is null", null);
        goto L30
    L20:
        e = move-exception;
        int r118 = f96.a.f475971a;
        f96.a.a("interactive_predefine", "BuiltInMetaManager readMetaFileFromStream error:" + e.getMessage(), null);
    L22:
        r109 = null;
    L18:
        e = move-exception;
        int r119 = f96.a.f475971a;
        f96.a.a("interactive_predefine", "BuiltInMetaManager readMetaFileFromStream error:" + e.getMessage(), null);
        goto L22
    L8:
        r103 = "offline/dino_sar_common_external/builtin_meta_online.json";
        goto L9
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
