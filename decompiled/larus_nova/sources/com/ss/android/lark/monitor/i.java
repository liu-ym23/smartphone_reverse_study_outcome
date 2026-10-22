package com.ss.android.lark.monitor;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f432397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f432398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f432399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f432400d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f432401e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f432402f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f432403g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f432404h;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f432405a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c f432406b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f432407c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f432408d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f432409e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public f f432410f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final List<String> f432411g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f432412h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f432413i;

        /* JADX INFO: renamed from: com.ss.android.lark.monitor.i$a$a, reason: collision with other inner class name */
        public class C5137a implements f {
            public C5137a() {
            }
        }

        public a(Context r100) {
            this.f432410f = new C5137a();
            this.f432411g = new ArrayList();
            this.f432412h = 5;
            this.f432413i = false;
            this.f432405a = r100;
        }
    }

    public i(a r100) {
        this.f432397a = r100.f432405a;
        c r101 = r100.f432406b;
        this.f432398b = r101;
        this.f432403g = r100.f432407c;
        f r102 = r100.f432410f;
        this.f432400d = r100.f432408d;
        this.f432401e = r100.f432409e;
        this.f432399c = r100.f432411g;
        this.f432402f = r100.f432412h;
        this.f432404h = r100.f432413i;
        if (r101 == null) goto L9;
        if (r102 == null) goto L7;
        return;
    L7:
        throw new IllegalArgumentException("time formater impl needed!");
    L9:
        throw new IllegalArgumentException("dependence impl not init!");
    }
}
