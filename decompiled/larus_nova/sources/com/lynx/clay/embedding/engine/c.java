package com.lynx.clay.embedding.engine;

import android.content.Context;
import com.lynx.clay.embedding.engine.loader.FlutterLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, c> f380716b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<FlutterEngine> f380717a;

    static {
        f380716b = new HashMap();
    }

    public c(Context r100, String[] r101) {
        this.f380717a = new ArrayList();
        FlutterLoader r102 = c5a.b.a().f22526a;
        if (r102.f380719a == true) goto L6;
        r102.e(r100.getApplicationContext(), new FlutterLoader.c());
        r102.a(r100, r101);
        return;
    }
}
