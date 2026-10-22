package com.bytedance.sync;

import java.util.ArrayList;
import java.util.List;
import yf7.h;
import yf7.n;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f270349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<n> f270350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<h> f270351c;

    /* JADX INFO: renamed from: com.bytedance.sync.a$a, reason: collision with other inner class name */
    public static class C3779a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f270352a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<n> f270353b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<h> f270354c;

        public final a b() {
            if (this.f270352a < 0) goto L7;
            return new a(this);
        L7:
            throw new IllegalArgumentException("bizId < 0");
        }

        public C3779a(long r100) {
            this.f270353b = new ArrayList();
            this.f270354c = new ArrayList();
            this.f270352a = r100;
        }

        public final void a(n r100) {
            ((ArrayList) this.f270353b).add(r100);
        }
    }

    public a(C3779a r100) {
        this.f270349a = r100.f270352a;
        this.f270350b = r100.f270353b;
        this.f270351c = r100.f270354c;
    }
}
