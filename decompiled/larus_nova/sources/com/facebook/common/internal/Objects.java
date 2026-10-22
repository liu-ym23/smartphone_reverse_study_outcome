package com.facebook.common.internal;

import com.alipay.sdk.m.n.a;
import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class Objects {

    /* JADX INFO: renamed from: com.facebook.common.internal.Objects$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes22.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: loaded from: classes22.dex */
    public static final class ToStringHelper {
        private final String className;
        private ValueHolder holderHead;
        private ValueHolder holderTail;
        private boolean omitNullValues;

        public static final class ValueHolder {

            @Nullable
            String name;
            ValueHolder next;

            @Nullable
            Object value;

            private ValueHolder() {
            }

            public /* synthetic */ ValueHolder(AnonymousClass1 r100) {
                this();
            }
        }

        public ToStringHelper omitNullValues() {
            this.omitNullValues = true;
            return this;
        }

        private ValueHolder addHolder() {
            ValueHolder r100 = new ValueHolder(null);
            this.holderTail.next = r100;
            this.holderTail = r100;
            return r100;
        }

        public String toString() {
            boolean r100 = this.omitNullValues;
            StringBuilder r101 = new StringBuilder(32);
            r101.append(this.className);
            r101.append('{');
            ValueHolder r102 = this.holderHead.next;
            String r103 = "";
        L3:
            if (r102 == null) goto L12;
            if (r100 == true) goto L6;
        L7:
            r101.append(r103);
            String r104 = r102.name;
            if (r104 == null) goto L10;
            r101.append(r104);
            r101.append(a.f25612h);
        L10:
            r101.append(r102.value);
            r103 = ", ";
        L11:
            r102 = r102.next;
            goto L3
        L6:
            if (r102.value == null) goto L11;
        L12:
            r101.append('}');
            return r101.toString();
        }

        private ToStringHelper(String r100) {
            ValueHolder r101 = new ValueHolder(null);
            this.holderHead = r101;
            this.holderTail = r101;
            this.omitNullValues = false;
            this.className = (String) Preconditions.checkNotNull(r100);
        }

        private ToStringHelper addHolder(@Nullable Object r100) {
            addHolder().value = r100;
            return this;
        }

        public ToStringHelper addValue(char r100) {
            return addHolder(String.valueOf(r100));
        }

        public ToStringHelper addValue(double r100) {
            return addHolder(String.valueOf(r100));
        }

        public ToStringHelper addValue(float r100) {
            return addHolder(String.valueOf(r100));
        }

        public ToStringHelper addValue(int r100) {
            return addHolder(String.valueOf(r100));
        }

        public ToStringHelper addValue(long r100) {
            return addHolder(String.valueOf(r100));
        }

        public ToStringHelper addValue(boolean r100) {
            return addHolder(String.valueOf(r100));
        }

        public ToStringHelper addValue(@Nullable Object r100) {
            return addHolder(r100);
        }

        public /* synthetic */ ToStringHelper(String r100, AnonymousClass1 r101) {
            this(r100);
        }

        private ToStringHelper addHolder(String r100, @Nullable Object r101) {
            ValueHolder r102 = addHolder();
            r102.value = r101;
            r102.name = (String) Preconditions.checkNotNull(r100);
            return this;
        }

        public ToStringHelper add(String r100, char r101) {
            return addHolder(r100, String.valueOf(r101));
        }

        public ToStringHelper add(String r100, double r101) {
            return addHolder(r100, String.valueOf(r101));
        }

        public ToStringHelper add(String r100, float r101) {
            return addHolder(r100, String.valueOf(r101));
        }

        public ToStringHelper add(String r100, int r101) {
            return addHolder(r100, String.valueOf(r101));
        }

        public ToStringHelper add(String r100, long r101) {
            return addHolder(r100, String.valueOf(r101));
        }

        public ToStringHelper add(String r100, boolean r101) {
            return addHolder(r100, String.valueOf(r101));
        }

        public ToStringHelper add(String r100, @Nullable Object r101) {
            return addHolder(r100, r101);
        }
    }

    private Objects() {
    }

    public static int hashCode(@Nullable Object... r100) {
        return Arrays.hashCode(r100);
    }

    private static String simpleName(Class<?> r100) {
        String r101 = r100.getName().replaceAll("\\$[0-9]+", "\\$");
        int r102 = r101.lastIndexOf(36);
        if (r102 != (-1)) goto L6;
        r102 = r101.lastIndexOf(46);
    L6:
        return r101.substring(r102 + 1);
    }

    public static ToStringHelper toStringHelper(Object r100) {
        return new ToStringHelper(simpleName(r100.getClass()), null);
    }

    public static ToStringHelper toStringHelper(Class<?> r100) {
        return new ToStringHelper(simpleName(r100), null);
    }

    public static ToStringHelper toStringHelper(String r100) {
        return new ToStringHelper(r100, null);
    }

    @CheckReturnValue
    public static boolean equal(@Nullable Object r100, @Nullable Object r101) {
        if (r100 == r101) goto L8;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.equals(r101) == false) goto L7;
    L8:
        return true;
    }

    public static <T> T firstNonNull(@Nullable T r100, @Nullable T r101) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        return (T) Preconditions.checkNotNull(r101);
    }
}
