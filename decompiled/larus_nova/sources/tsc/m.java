package tsc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class m implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f547459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f547460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f547461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f547462d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f547463e;

    public static class a extends m implements l.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final a f547464f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List<a> f547465g;

        @Override // tsc.l
        public final l.a a() {
            return this;
        }

        @Override // tsc.l
        public final boolean isBlock() {
            return true;
        }

        @Override // tsc.l.a
        public final List<l.a> children() {
            List<a> r100 = this.f547465g;
            if (r100 != null) goto L6;
            return Collections.emptyList();
        L6:
            return Collections.unmodifiableList(r100);
        }

        public final String toString() {
            StringBuilder r100 = new StringBuilder("BlockImpl{name='");
            r100.append(this.f547459a);
            r100.append("', start=");
            r100.append(this.f547460b);
            r100.append(", end=");
            r100.append(this.f547462d);
            r100.append(", attributes=");
            r100.append(this.f547461c);
            r100.append(", parent=");
            a r101 = this.f547464f;
            if (r101 == null) goto L5;
            String r102 = r101.f547459a;
        L6:
            r100.append(r102);
            r100.append(", children=");
            r100.append(this.f547465g);
            r100.append('}');
            return r100.toString();
        L5:
            r102 = null;
            goto L6
        }

        @Override // tsc.m, tsc.l
        public final Map<String, String> b() {
            return this.f547461c;
        }

        @Override // tsc.l.a
        public final a parent() {
            return this.f547464f;
        }

        public final void c(int r100) {
            if (isClosed() == true) goto L10;
            this.f547462d = r100;
            List<a> r101 = this.f547465g;
            if (r101 == null) goto L12;
            Iterator r102 = ((ArrayList) r101).iterator();
        L8:
            if (r102.hasNext() == false) goto L13;
            ((a) r102.next()).c(r100);
            goto L8
        L13:
            return;
        L12:
            return;
        }

        public a(String r100, int r101, Map<String, String> r102, a r103) {
            super(r100, r101, r102);
            this.f547464f = r103;
        }
    }

    /* JADX INFO: loaded from: classes41.dex */
    public static class b extends m implements l.b {
        @Override // tsc.l
        public final boolean isBlock() {
            return false;
        }

        @Override // tsc.l
        public final l.a a() {
            throw new ClassCastException("Cannot cast Inline instance to Block");
        }

        public final String toString() {
            return "InlineImpl{name='" + this.f547459a + "', start=" + this.f547460b + ", end=" + this.f547462d + ", attributes=" + this.f547461c + '}';
        }

        public b(String r100, int r101, Map<String, String> r102) {
            super(r100, r101, r102);
        }
    }

    @Override // tsc.l
    public final boolean isClosed() {
        if (this.f547462d <= (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // tsc.l
    public Map<String, String> b() {
        return this.f547461c;
    }

    @Override // tsc.l
    public final int end() {
        return this.f547462d;
    }

    @Override // tsc.l
    public final String name() {
        return this.f547459a;
    }

    @Override // tsc.l
    public final int start() {
        return this.f547460b;
    }

    public m(String r100, int r101, Map<String, String> r102) {
        this.f547462d = -1;
        this.f547463e = "";
        this.f547459a = r100;
        this.f547460b = r101;
        this.f547461c = r102;
    }
}
