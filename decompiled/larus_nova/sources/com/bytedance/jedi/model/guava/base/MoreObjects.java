package com.bytedance.jedi.model.guava.base;

import com.alipay.sdk.m.n.a;
import com.bytedance.jedi.model.guava.annotations.NullableDecl;
import java.util.Arrays;

/* JADX INFO: loaded from: classes19.dex */
public final class MoreObjects {

    public static final class ToStringHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f251076a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ValueHolder f251077b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ValueHolder f251078c;

        public static final class ValueHolder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @NullableDecl
            public String f251079a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @NullableDecl
            public Object f251080b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @NullableDecl
            public ValueHolder f251081c;

            private ValueHolder() {
            }

            public /* synthetic */ ValueHolder(int r100) {
                this();
            }
        }

        public final String toString() {
            StringBuilder r100 = new StringBuilder(32);
            r100.append(this.f251076a);
            r100.append('{');
            ValueHolder r101 = this.f251077b.f251081c;
            String r102 = "";
        L3:
            if (r101 == null) goto L13;
            Object r103 = r101.f251080b;
            r100.append(r102);
            String r104 = r101.f251079a;
            if (r104 == null) goto L7;
            r100.append(r104);
            r100.append(a.f25612h);
        L7:
            if (r103 != null) goto L9;
        L11:
            r100.append(r103);
        L12:
            r101 = r101.f251081c;
            r102 = ", ";
            goto L3
        L9:
            if (r103.getClass().isArray() == false) goto L11;
            String r105 = Arrays.deepToString(new Object[]{r103});
            r100.append(r105, 1, r105.length() - 1);
            goto L12
        L13:
            r100.append('}');
            return r100.toString();
        }

        public ToStringHelper(String r100) {
            ValueHolder r101 = new ValueHolder(0);
            this.f251077b = r101;
            this.f251078c = r101;
            this.f251076a = r100;
        }

        public final void a(String r100, @NullableDecl Object r101) {
            ValueHolder r102 = new ValueHolder(0);
            this.f251078c.f251081c = r102;
            this.f251078c = r102;
            r102.f251080b = r101;
            r102.f251079a = r100;
        }
    }

    public static Object a(@NullableDecl Object r100) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new NullPointerException("Both parameters are null");
    }
}
