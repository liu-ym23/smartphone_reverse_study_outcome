package com.bytedance.locallife.live.lynx.syncjsb;

import com.bytedance.locallife.live.lynx.LiveLocalLifeLynxView;
import com.bytedance.locallife.live.util.w;
import com.bytedance.locallife.live.util.y;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f260599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LiveLocalLifeLynxView f260600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f260601c;

    public abstract String c();

    public abstract HashMap<String, Object> f(HashMap<String, Object> r100);

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        this.f260599a = r100;
    }

    public static HashMap b(String r100) {
        HashMap r101 = new HashMap();
        r101.put("code", 0);
        if (r100 == null) goto L5;
        r101.put("message", r100);
    L5:
        return r101;
    }

    public boolean a(String r100) {
        return Intrinsics.areEqual(c(), r100);
    }

    public HashMap<String, Object> e(HashMap<String, Object> r100) {
        if (r100 == null) goto L5;
        String r101 = w.f(r100, "containerID");
        if (r101 == null) goto L5;
    L6:
        this.f260601c = r101;
        m16.c r102 = c36.a.a(r101).a(LiveLocalLifeLynxView.class);
        if (r102 == null) goto L9;
        LiveLocalLifeLynxView r103 = (LiveLocalLifeLynxView) r102.provideInstance();
    L10:
        this.f260600b = r103;
        HashMap<String, Object> r104 = y.c(r100, "data");
        if (r104 != null) goto L14;
        return b("param is null");
    L14:
        return f(r104);
    L9:
        r103 = null;
    L5:
        r101 = "";
        goto L6
    }

    public static HashMap d(a r100, Map r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        r100.getClass();
        HashMap r103 = new HashMap();
        r103.put("code", 1);
        if (r101 == null) goto L8;
        r103.put("data", r101);
    L8:
        return r103;
    }
}
