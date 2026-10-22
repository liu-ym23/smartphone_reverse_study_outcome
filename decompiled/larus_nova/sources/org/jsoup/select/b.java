package org.jsoup.select;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.jsoup.nodes.Element;

/* JADX INFO: loaded from: classes42.dex */
public abstract class b extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<c> f526082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f526083b;

    public static final class a extends b {
        public final String toString() {
            return fwc.b.f(this.f526082a, "");
        }

        public a(Collection<c> r100) {
            this.f526082a.addAll(r100);
            this.f526083b = this.f526082a.size();
        }

        public a(c... r100) {
            this(Arrays.asList(r100));
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            int r102 = this.f526083b - 1;
        L3:
            if (r102 < 0) goto L9;
            if (((c) ListProtector.get(this.f526082a, r102)).a(r100, r101) == false) goto L6;
            r102 = r102 - 1;
            goto L3
        L6:
            return false;
        L9:
            return true;
        }
    }

    /* JADX INFO: renamed from: org.jsoup.select.b$b, reason: collision with other inner class name */
    public static final class C7095b extends b {
        public final String toString() {
            return fwc.b.f(this.f526082a, ", ");
        }

        public C7095b() {
        }

        public C7095b(c... r100) {
            List r101 = Arrays.asList(r100);
            if (this.f526083b <= 1) goto L5;
            this.f526082a.add(new a(r101));
        L6:
            this.f526083b = this.f526082a.size();
            return;
        L5:
            this.f526082a.addAll(r101);
            goto L6
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            int r102 = 0;
        L4:
            if (r102 >= this.f526083b) goto L10;
            if (((c) ListProtector.get(this.f526082a, r102)).a(r100, r101) == true) goto L7;
            r102 = r102 + 1;
            goto L4
        L7:
            return true;
        L10:
            return false;
        }
    }

    public b() {
        this.f526083b = 0;
        this.f526082a = new ArrayList();
    }
}
