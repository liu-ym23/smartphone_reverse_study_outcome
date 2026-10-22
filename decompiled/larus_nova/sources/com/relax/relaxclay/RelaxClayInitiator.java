package com.relax.relaxclay;

import android.content.Context;
import c5a.b;
import com.lynx.clay.embedding.engine.loader.FlutterLoader;
import com.lynx.clay.embedding.engine.loader.FrescoImageLoader;
import com.lynx.clay.embedding.engine.loader.ResourceLoaderImpl;
import com.relax.uirender.UIRenderRegistry;
import lpa.a;
import lpa.f;
import lpa.g;

/* JADX INFO: loaded from: classes34.dex */
public class RelaxClayInitiator {
    private static boolean inited;

    public RelaxClayInitiator() {
    }

    public static void init(Context r100) {
        init(r100, "");
    }

    public static void init(Context r100, String r101) {
        if (inited == false) goto L5;
        return;
    L5:
        Context r102 = r100.getApplicationContext();
        UIRenderRegistry.RenderType r103 = UIRenderRegistry.RenderType.CLAY;
        g r104 = new g();
        UIRenderRegistry.f405703a.put(r103, r104);
        FlutterLoader r105 = b.a().f22526a;
        if (r105.f380719a == true) goto L8;
        FlutterLoader.c r106 = new FlutterLoader.c();
        r106.f380727a = r101;
        r105.e(r102, r106);
    L8:
        FrescoImageLoader.Initialize(r102);
        if (f.f510276e != null) goto L11;
        a r107 = new a(r102);
        f.f510276e = r107;
        ResourceLoaderImpl.SetResourceLoader(r107);
    L11:
        inited = true;
    }
}
