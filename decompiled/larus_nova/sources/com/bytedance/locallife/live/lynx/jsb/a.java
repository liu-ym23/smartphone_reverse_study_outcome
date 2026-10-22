package com.bytedance.locallife.live.lynx.jsb;

import com.bytedance.locallife.live.lynx.LiveLocalLifeLynxView;
import com.bytedance.locallife.live.util.w;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f260564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f260565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LiveLocalLifeLynxView f260566c;

    public abstract String a();

    public abstract void d(HashMap<String, Object> r100, Function1<? super Map<String, ? extends Object>, Unit> r101);

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        this.f260564a = r100;
        this.f260565b = a();
    }

    public static void e(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        jv6.h r101 = com.bytedance.locallife.live.settings.c.f();
        if (r101 == null) goto L5;
        int r102 = r101.A();
    L6:
        if (r102 != 1) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        LinkedHashMap r104 = new LinkedHashMap();
        r104.put("code", 1);
        r100.invoke(r104);
        return;
    L12:
        return;
    L8:
        r103 = false;
        goto L9
    L5:
        r102 = 1;
        goto L6
    }

    public static void c(String r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        jv6.h r102 = com.bytedance.locallife.live.settings.c.f();
        boolean r103 = true;
        if (r102 == null) goto L5;
        int r104 = r102.A();
    L7:
        if (r104 == 1) goto L10;
        r103 = false;
    L10:
        if (r103 == false) goto L13;
        LinkedHashMap r105 = new LinkedHashMap();
        r105.put("code", 0);
        r105.put("message", r100);
        r101.invoke(r105);
        return;
    L13:
        return;
    L5:
        r104 = 1;
        goto L7
    }

    public void b(HashMap<String, Object> r100, Function1<? super Map<String, ? extends Object>, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        Map<String, m16.b> r102 = c36.a.f22277a;
        String r103 = w.f(r100, "containerID");
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        m16.c r104 = c36.a.a(r103).a(LiveLocalLifeLynxView.class);
        HashMap<String, Object> r105 = null;
        if (r104 == null) goto L8;
        LiveLocalLifeLynxView r106 = (LiveLocalLifeLynxView) r104.provideInstance();
    L9:
        this.f260566c = r106;
        if (r100 == null) goto L12;
        Object r107 = r100.get("data");
    L14:
        if ((r107 instanceof HashMap) == false) goto L16;
        r105 = (HashMap) r107;
    L16:
        if (r105 != null) goto L18;
        c("param is null", r101);
        return;
    L18:
        d(r105, r101);
        return;
    L12:
        r107 = null;
        goto L14
    L8:
        r106 = null;
        goto L9
    }
}
