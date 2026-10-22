package com.bytedance.ies.xelement.picker.view;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f250282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<WheelView> f250283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<List<String>> f250284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Integer> f250285d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f86.e f250286e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d86.b f250287f;

    public e(View r100) {
        this.f250283b = new ArrayList();
        this.f250285d = new ArrayList();
        this.f250282a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.util.List<java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.util.ArrayList] */
    public final void a(List<Integer> r100) {
        if (this.f250284c != null) goto L7;
        ((ArrayList) this.f250285d).clear();
        return;
    L7:
        if (r100 != 0) goto L12;
        r100 = new ArrayList();
        int r101 = 0;
    L10:
        if (r101 >= this.f250284c.size()) goto L12;
        r100.add(0);
        r101 = r101 + 1;
    L12:
        Iterator r102 = r100.iterator();
    L14:
        if (r102.hasNext() == false) goto L20;
        if (((Integer) r102.next()) != null) goto L14;
        throw new IllegalArgumentException("index can not be null");
    L20:
        int r103 = 0;
    L22:
        if (r103 >= ((ArrayList) this.f250283b).size()) goto L35;
        WheelView r104 = (WheelView) ListProtector.get(this.f250283b, r103);
        if (r103 >= r100.size()) goto L33;
        int r105 = ((Integer) ListProtector.get(r100, r103)).intValue();
        List<List<String>> r106 = this.f250284c;
        if (r106 != null) goto L28;
    L32:
        ListProtector.set(r100, r103, 0);
        r104.setCurrentIndex(0);
    L34:
        r103 = r103 + 1;
        goto L22
    L28:
        if (r103 >= r106.size()) goto L32;
        if (r105 >= ((List) ListProtector.get(this.f250284c, r103)).size()) goto L32;
        r104.setCurrentIndex(r105);
        goto L34
    L33:
        r104.setCurrentIndex(0);
        goto L34
    L35:
        ((ArrayList) this.f250285d).clear();
        ((ArrayList) this.f250285d).addAll(r100);
    }
}
