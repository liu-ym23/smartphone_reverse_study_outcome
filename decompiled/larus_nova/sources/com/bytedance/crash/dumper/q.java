package com.bytedance.crash.dumper;

import android.app.Activity;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.bytedance.crash.util.JSONWriter;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import java.io.BufferedWriter;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class q {
    public static void a(File r110) {
        JSONArray r100 = new JSONArray();
        ArrayList<WeakReference<Activity>> r101 = bi4.a.d().f19116h;
        BufferedWriter r102 = null;
        if (r101 != null) goto L5;
    L28:
        r100 = null;
    L29:
        if (r100 == null) goto L66;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r110, "viewTree.txt");
        r103.getParentFile().mkdirs();     // Catch: Throwable -> L39
        BufferedWriter r111 = new BufferedWriter(new PolarisFileWriterWrapper(r103, false));     // Catch: Throwable -> L38
        new JSONWriter(r111).a(r100);     // Catch: Throwable -> L35
        r111.flush();     // Catch: Throwable -> L35
        com.bytedance.crash.util.g.a(r111);     // Catch: Throwable -> L39
    L44:
        return;
    L35:
        r102 = r111;
    L36:
        com.bytedance.crash.util.g.a(r102);     // Catch: Throwable -> L39
    L67:
        return;
    L66:
        return;
    L5:
        if (r101.size() <= 0) goto L28;
        LinkedList r104 = new LinkedList();
        Iterator<WeakReference<Activity>> r105 = r101.iterator();
    L9:
        if (r105.hasNext() == false) goto L18;
        Activity r106 = r105.next().get();
        if (r106 == null) goto L9;
        Window r107 = r106.getWindow();
        if (r107 == null) goto L9;
        View r108 = r107.peekDecorView();
        if (r108 == null) goto L9;
        JSONObject r109 = new JSONObject();
        r104.add(new Pair(r108, r109));
        r100.put(r109);
    L18:
        if (r104.isEmpty() == true) goto L29;
        Pair r112 = (Pair) r104.pop();
        View r113 = (View) r112.first;
        JSONObject r114 = (JSONObject) r112.second;
        com.bytedance.crash.util.j.h(r114, "cls", String.valueOf(r113.getClass()));
        if ((r113 instanceof ViewGroup) == false) goto L18;
        ViewGroup r115 = (ViewGroup) r113;
        int r116 = r115.getChildCount();
        JSONArray r117 = new JSONArray();
        com.bytedance.crash.util.j.h(r114, "children", r117);
        int r118 = 0;
    L22:
        if (r118 >= r116) goto L18;
        View r119 = r115.getChildAt(r118);     // Catch: Throwable -> L27
        if (r119 == null) goto L26;
        JSONObject r120 = new JSONObject();     // Catch: Throwable -> L27
        r117.put(r120);     // Catch: Throwable -> L27
        r104.push(new Pair(r119, r120));     // Catch: Throwable -> L27
    L26:
        r118 = r118 + 1;
        goto L22
    }
}
