package com.bytedance.ee.bear.basesdk.config;

import android.R;
import android.app.Activity;
import android.graphics.RectF;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class LynxEntityWordRouteInterceptor implements com.bytedance.ee.bear.lynx.api.e {

    public static final class a {
    }

    static {
    }

    public LynxEntityWordRouteInterceptor() {
    }

    @Override // com.bytedance.ee.bear.lynx.api.e
    public final void a(Map<String, String> r110) {
        Intrinsics.checkNotNullParameter(r110, "parameterMaps");
        tt5.a.h("LynxEntityWordRouteInterceptor", "route.");
        Activity r100 = ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).getCurrentActivity();
        if ((r100 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r101 = (FragmentActivity) r100;
    L6:
        String r102 = r110.get("query");
        String r103 = r110.get("abbrId");
        String r104 = r110.get("token");
        String r105 = "";
        if (r104 != null) goto L9;
        r104 = "";
    L9:
        String r111 = r110.get("type");
        if (r111 == null) goto L13;
        r105 = r111;
    L13:
        if (r101 == null) goto L31;
        boolean r112 = true;
        if (r102 != null) goto L17;
    L20:
        boolean r106 = true;
    L21:
        if (r106 == true) goto L32;
        if (r103 != null) goto L24;
    L27:
        if (r112 == true) goto L33;
        RectF r107 = new RectF();
        View r108 = r101.findViewById(R.id.content);
        JSONObject r109 = new JSONObject();
        r109.put("ignore", false);
        JSONObject r113 = new JSONObject();
        r113.put("file_id", du5.b.g(r104));
        r113.put("file_type", r105);
        r109.put("analysisParams", r113);
        ((com.bytedance.ee.bear.lark.dependency.j) org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.j.class, null, null, 6)).b(new wb5.a(r102, r103, r107, r108, r109.toString()), new LynxEntityWordRouteInterceptor$route$1());
        return;
    L33:
        return;
    L24:
        if (r103.length() == 0) goto L27;
        r112 = false;
        goto L27
    L32:
        return;
    L17:
        if (r102.length() == 0) goto L20;
        r106 = false;
        goto L21
    L31:
        return;
    L5:
        r101 = null;
        goto L6
    }
}
