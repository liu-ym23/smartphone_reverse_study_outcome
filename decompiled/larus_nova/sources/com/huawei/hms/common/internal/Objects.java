package com.huawei.hms.common.internal;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public final class Objects {

    public static final class ToStringHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<String> f277104a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f277105b;

        public final String toString() {
            String r100 = this.f277105b.getClass().getSimpleName();
            StringBuilder r101 = new StringBuilder(100);
            r101.append(r100);
            r101.append('{');
            int r102 = this.f277104a.size();
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            r101.append((String) ListProtector.get(this.f277104a, r103));
            if (r103 >= (r102 - 1)) goto L7;
            r101.append(", ");
        L7:
            r103 = r103 + 1;
            goto L3
        L8:
            r101.append('}');
            return r101.toString();
        }

        private ToStringHelper(Object r100) {
            this.f277105b = Preconditions.checkNotNull(r100);
            this.f277104a = new ArrayList();
        }

        public /* synthetic */ ToStringHelper(Object r100, a r101) {
            this(r100);
        }

        public final ToStringHelper add(String r100, Object r101) {
            String r102 = (String) Preconditions.checkNotNull(r100);
            String r103 = String.valueOf(r101);
            StringBuilder r104 = new StringBuilder((r102.length() + r103.length()) + 1);
            r104.append(r102);
            r104.append(ContainerUtils.KEY_VALUE_DELIMITER);
            r104.append(r103);
            String r105 = r104.toString();
            this.f277104a.add(r105);
            return this;
        }
    }

    public static /* synthetic */ class a {
    }

    private Objects() {
        throw new AssertionError("Uninstantiable");
    }

    public static int hashCode(Object... r100) {
        return Arrays.hashCode(r100);
    }

    public static boolean isNull(Object... r100) {
        if (r100 != null) goto L5;
        return true;
    L5:
        int r101 = r100.length;
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L11;
        if (r100[r102] == null) goto L9;
        r102 = r102 + 1;
        goto L6
    L9:
        return true;
    L11:
        return false;
    }

    public static ToStringHelper toStringHelper(Object r100) {
        return new ToStringHelper(r100, null);
    }

    public static boolean equal(Object r100, Object r101) {
        if (r100 != r101) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
    L9:
        return false;
    L7:
        if (r100.equals(r101) == false) goto L9;
        return true;
    }
}
