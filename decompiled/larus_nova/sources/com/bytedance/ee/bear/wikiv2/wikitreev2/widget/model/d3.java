package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import android.text.TextUtils;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d3 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d3 f241798e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<j> f241799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f241800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Integer> f241801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, List<Integer>> f241802d;

    public static final class a {
    }

    static {
        f241798e = new d3();
    }

    public final void b() {
        Iterator<T> r100 = this.f241799a.iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L12;
        int r102 = r101 + 1;
        j r103 = (j) r100.next();
        Integer r104 = Integer.valueOf(r101);
        this.f241801c.put(r103.f241926n, r104);
        Map<String, List<Integer>> r105 = this.f241802d;
        LinkedHashMap r106 = (LinkedHashMap) r105;
        List<Integer> r107 = (List) r106.get(r103.f241914b);
        if (r107 != null) goto L8;
        r107 = new ArrayList();
        this.f241802d.put(r103.f241914b, r107);
    L8:
        r107.add(Integer.valueOf(r101));
        int r108 = r103.f241927o;
        if (r108 <= this.f241800b) goto L11;
        this.f241800b = r108;
    L11:
        r101 = r102;
        goto L4
    }

    public d3() {
        this.f241799a = new ArrayList();
        this.f241801c = new LinkedHashMap();
        this.f241802d = new LinkedHashMap();
    }

    public final void a(List<j> r100) {
        Intrinsics.checkNotNullParameter(r100, "uiList");
        ArrayList r101 = (ArrayList) this.f241799a;
        r101.addAll(r100);
    }

    public final boolean c(String r100) {
        Intrinsics.checkNotNullParameter(r100, WikiFolderPushPlugin.WIKI_TOKEN);
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L7:
        return false;
    L5:
        if (this.f241802d.containsKey(r100) == false) goto L7;
        return true;
    }

    public final int d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Integer r101 = (Integer) ((LinkedHashMap) this.f241801c).get(r100);
        if (r101 != null) goto L7;
        return -1;
    L7:
        return r101.intValue();
    }
}
