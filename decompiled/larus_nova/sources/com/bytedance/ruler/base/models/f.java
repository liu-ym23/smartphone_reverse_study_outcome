package com.bytedance.ruler.base.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f267666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f267667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f267668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f267669d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<String> f267670e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f267671f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<String, ? extends Object> f267672g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Throwable f267673h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList<c> f267674i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<? extends Object> f267675j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f267676k;

    public final String toString() {
        StringBuilder r100 = new StringBuilder("[code = ");
        r100.append(this.f267668c);
        r100.append(", msg = ");
        r100.append(this.f267669d);
        r100.append(", error = ");
        r100.append(this.f267673h);
        r100.append(", strategyNames=");
        r100.append(this.f267670e);
        r100.append(", result = ");
        r100.append(this.f267674i);
        r100.append(", fffRuleResults=");
        r100.append(this.f267675j);
        r100.append(" params = ");
        Map<String, ? extends Object> r101 = this.f267672g;
        if (r101 == null) goto L5;
        String r102 = r101.toString();
    L6:
        r100.append(r102);
        r100.append(", performance = ");
        r100.append(this.f267671f);
        r100.append(", useFFF = ");
        r100.append(this.f267666a);
        r100.append(", useRuleFFF = ");
        r100.append(this.f267667b);
        r100.append(" useHardCode = ");
        r100.append(this.f267676k);
        r100.append(']');
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public f(int r100, String r101, List r102, Throwable r103, List r110, boolean r111, int r112) {
        if ((r112 & 1) == 0) goto L6;
        r100 = -1;
    L6:
        if ((r112 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r112 & 8) == 0) goto L12;
        r102 = new ArrayList();
    L12:
        if ((r112 & 16) == 0) goto L14;
        b r104 = new b(0);
    L16:
        if ((r112 & 64) == 0) goto L19;
        r103 = null;
    L19:
        if ((r112 & 128) == 0) goto L21;
        ArrayList<c> r105 = new ArrayList();
    L23:
        if ((r112 & 256) == 0) goto L26;
        r110 = new ArrayList();
    L26:
        if ((r112 & 512) == 0) goto L28;
        r111 = false;
    L28:
        this.f267668c = r100;
        this.f267669d = r101;
        this.f267670e = r102;
        this.f267671f = r104;
        this.f267672g = null;
        this.f267673h = r103;
        this.f267674i = r105;
        this.f267675j = r110;
        this.f267676k = r111;
        return;
    L21:
        r105 = null;
        goto L23
    L14:
        r104 = null;
        goto L16
    }
}
