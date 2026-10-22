package com.ss.android.ugc.route_monitor.impl;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import com.ss.android.ugc.route_monitor.utils.u;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class n {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f454487g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f454488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f454489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f454490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f454491d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f454492e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final JSONObject f454493f;

    public static final class a {
        @JvmStatic
        public static n a(View r110, long r111) {
            Context r100 = r110.getContext();
            Method r101 = View.class.getDeclaredMethod("getListenerInfo", new Class[0]);
            r101.setAccessible(true);
            Object r102 = r101.invoke(r110, new Object[0]);
            View.OnClickListener r103 = null;
            if (r102 == null) goto L5;
            View.OnClickListener r104 = (View.OnClickListener) u.c(r102, "mOnClickListener");
        L6:
            if (r104 == null) goto L8;
            com.ss.android.ugc.route_monitor.c.a().getClass();
            r103 = r104;
        L8:
            if (r103 != null) goto L11;
            r103 = r104;
        L11:
            ArrayList r105 = new ArrayList();
            ViewParent r106 = r110.getParent();
        L12:
            if (r106 == null) goto L17;
            String r107 = r106.getClass().getName();
            r105.add(r107);
            if (Intrinsics.areEqual(r107, "android.view.ViewRootImpl") == true) goto L17;
            r106 = r106.getParent();
        L17:
            String r108 = r110.getClass().getName();
            String r109 = "";
            if (r103 == null) goto L20;
            String r112 = r103.getClass().getName();
        L21:
            if (r100 == null) goto L23;
            String r113 = r100.getClass().getName();
        L24:
            r110.hashCode();
            JSONObject r114 = new JSONObject();
            if ((!Intrinsics.areEqual(r104, r103)) == false) goto L30;
            if (r104 == null) goto L28;
            r109 = r104.getClass().getName();
        L28:
            r114.put("origin_click_listener_proxy", r109);
        L30:
            return new n(r108, r112, r105, r113, r111, r114);
        L23:
            r113 = "";
            goto L24
        L20:
            r112 = "";
            goto L21
        L5:
            r104 = null;
            goto L6
        }
    }

    static {
    }

    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        r100.put("click_anchor_name", this.f454488a);
        r100.put("anchor_click_listener", this.f454489b);
        r100.put("anchor_parent_list", this.f454490c);
        r100.put("click_anchor_context", this.f454491d);
        r100.put("click_time", this.f454492e);
        r100.put("extra_data", this.f454493f);
        return r100;
    }

    public n(String r100, String r101, List r102, String r103, long r104, JSONObject r105) {
        this.f454488a = r100;
        this.f454489b = r101;
        this.f454490c = r102;
        this.f454491d = r103;
        this.f454492e = r104;
        this.f454493f = r105;
    }
}
