package com.oplus.ocs.base.utils;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class e {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Object f404312a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<String> f404313b;

        public final String toString() {
            StringBuilder r100 = new StringBuilder(100);
            r100.append(this.f404312a.getClass().getSimpleName());
            r100.append('{');
            int r101 = this.f404313b.size();
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L4;
            r100.append((String) ListProtector.get(this.f404313b, r102));
            if (r102 >= (r101 - 1)) goto L9;
            r100.append(", ");
        L9:
            r102 = r102 + 1;
            goto L3
        L4:
            r100.append('}');
            return r100.toString();
        }

        public a(Object r100) {
            this.f404312a = d.a(r100);
            this.f404313b = new ArrayList();
        }

        public final a a(String r100, Object r101) {
            this.f404313b.add(d.a(r100 + ContainerUtils.KEY_VALUE_DELIMITER + r101));
            return this;
        }
    }

    public static a a(Object r100) {
        return new a(r100);
    }

    public static boolean a(Object r100, Object r101) {
        if (r100 == r101) goto L9;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.equals(r101) == true) goto L12;
        return false;
    L12:
        return true;
    L9:
        return true;
    }
}
