package com.bytedance.ee.bear.middleground.like;

import com.bytedance.ee.bear.common.DisplayName;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public final List<a> a;
    public boolean b;

    public static class a {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public DisplayName g;
        public LikeListPuller.b h;
        public long i;
        public boolean j;

        public a() {
        }

        public final int hashCode() {
            return Objects.hash(new Object[]{this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, Long.valueOf(this.i), Boolean.valueOf(this.j)});
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if (r8 != null) goto L8;
        L33:
            return false;
        L8:
            if (a.class != r8.getClass()) goto L33;
            a r9 = (a) r8;
            if (this.i == r9.i) goto L13;
        L31:
            return false;
        L13:
            if (this.j != r9.j) goto L31;
            if (Objects.equals(this.a, r9.a) == false) goto L31;
            if (Objects.equals(this.b, r9.b) == false) goto L31;
            if (Objects.equals(this.c, r9.c) == false) goto L31;
            if (Objects.equals(this.d, r9.d) == false) goto L31;
            if (Objects.equals(this.e, r9.e) == false) goto L31;
            if (Objects.equals(this.g, r9.g) == false) goto L31;
            if (Objects.equals(this.h, r9.h) == false) goto L31;
            if (Objects.equals(this.f, r9.f) == false) goto L31;
            return true;
        }
    }

    public b() {
        this.a = new ArrayList();
        this.b = true;
    }
}
