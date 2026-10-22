package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public final class dn {

    public static final class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f463342a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private List<String> f386a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private boolean f387a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f463343b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private boolean f388b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f463344c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        private boolean f389c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f463345d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f463346e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f463347f;

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f463344c >= 0) goto L6;
            b();
        L6:
            return this.f463344c;
        }

        public int e() {
            return this.f386a.size();
        }

        public a() {
            this.f463342a = 0;
            this.f389c = false;
            this.f463343b = 0;
            this.f463347f = false;
            this.f386a = Collections.emptyList();
            this.f463344c = -1;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int r100 = 0;
            if (m8944a() == false) goto L5;
            int r101 = c.b(1, c()) + 0;
        L7:
            if (m8946c() == false) goto L10;
            r101 = r101 + c.a(2, m8945b());
        L10:
            if (m8947d() == false) goto L13;
            r101 = r101 + c.a(3, d());
        L13:
            if (f() == false) goto L15;
            r101 = r101 + c.a(4, m8948e());
        L15:
            Iterator<String> r102 = m8943a().iterator();
        L17:
            if (r102.hasNext() == false) goto L19;
            r100 = r100 + c.a(r102.next());
            goto L17
        L19:
            int r103 = (r101 + r100) + (m8943a().size() * 1);
            this.f463344c = r103;
            return r103;
        L5:
            r101 = 0;
            goto L7
        }

        public int c() {
            return this.f463342a;
        }

        public int d() {
            return this.f463343b;
        }

        public boolean f() {
            return this.f463346e;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public List<String> m8943a() {
            return this.f386a;
        }

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public boolean m8945b() {
            return this.f389c;
        }

        /* JADX INFO: renamed from: c, reason: collision with other method in class */
        public boolean m8946c() {
            return this.f388b;
        }

        /* JADX INFO: renamed from: d, reason: collision with other method in class */
        public boolean m8947d() {
            return this.f463345d;
        }

        /* JADX INFO: renamed from: e, reason: collision with other method in class */
        public boolean m8948e() {
            return this.f463347f;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m8944a() {
            return this.f387a;
        }

        public static a b(b r100) {
            return new a().a(r100);
        }

        @Override // com.xiaomi.push.e
        public void a(c r100) {
            if (m8944a() == false) goto L6;
            r100.m8879b(1, c());
        L6:
            if (m8946c() == false) goto L9;
            r100.m8871a(2, m8945b());
        L9:
            if (m8947d() == false) goto L12;
            r100.m8866a(3, d());
        L12:
            if (f() == false) goto L14;
            r100.m8871a(4, m8948e());
        L14:
            Iterator<String> r101 = m8943a().iterator();
        L16:
            if (r101.hasNext() == false) goto L18;
            r100.m8870a(5, r101.next());
            goto L16
        }

        @Override // com.xiaomi.push.e
        public a a(b r100) {
        L2:
            int r101 = r100.m8831a();
            if (r101 == 0) goto L22;
            if (r101 != 8) goto L7;
            a(r100.c());
            goto L2
        L7:
            if (r101 != 16) goto L9;
            a(r100.m8837a());
            goto L2
        L9:
            if (r101 != 24) goto L11;
            b(r100.m8840b());
            goto L2
        L11:
            if (r101 != 32) goto L13;
            b(r100.m8837a());
            goto L2
        L13:
            if (r101 != 42) goto L15;
            a(r100.m8834a());
            goto L2
        L15:
            if (a(r100, r101) == true) goto L2;
            return this;
        L22:
            return this;
        }

        public a b(int r100) {
            this.f463345d = true;
            this.f463343b = r100;
            return this;
        }

        public a a(String r100) {
            if (r100 == null) goto L9;
            if (this.f386a.isEmpty() == false) goto L6;
            this.f386a = new ArrayList();
        L6:
            this.f386a.add(r100);
            return this;
        L9:
            throw null;
        }

        public a b(boolean r100) {
            this.f463346e = true;
            this.f463347f = r100;
            return this;
        }

        public static a a(byte[] r100) {
            return (a) new a().a(r100);
        }

        public a a(int r100) {
            this.f387a = true;
            this.f463342a = r100;
            return this;
        }

        public a a(boolean r100) {
            this.f388b = true;
            this.f389c = r100;
            return this;
        }

        @Override // com.xiaomi.push.e
        public /* bridge */ /* synthetic */ e a(b r100) {
            return a(r100);
        }
    }
}
