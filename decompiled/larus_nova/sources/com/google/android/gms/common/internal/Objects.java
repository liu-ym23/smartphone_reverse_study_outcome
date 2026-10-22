package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes23.dex */
public final class Objects {

    public static final class ToStringHelper {

        /* JADX INFO: renamed from: zza, reason: collision with root package name */
        private final List f274519zza;

        /* JADX INFO: renamed from: zzb, reason: collision with root package name */
        private final Object f274520zzb;

        public String toString() {
            StringBuilder r100 = new StringBuilder(100);
            r100.append(this.f274520zzb.getClass().getSimpleName());
            r100.append('{');
            int r101 = this.f274519zza.size();
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L8;
            r100.append((String) ListProtector.get(this.f274519zza, r102));
            if (r102 >= (r101 - 1)) goto L7;
            r100.append(", ");
        L7:
            r102 = r102 + 1;
            goto L3
        L8:
            r100.append('}');
            return r100.toString();
        }

        public /* synthetic */ ToStringHelper(Object r100, e r101) {
            Preconditions.checkNotNull(r100);
            this.f274520zzb = r100;
            this.f274519zza = new ArrayList();
        }

        public ToStringHelper add(String r100, Object r101) {
            Preconditions.checkNotNull(r100);
            this.f274519zza.add(r100 + ContainerUtils.KEY_VALUE_DELIMITER + String.valueOf(r101));
            return this;
        }
    }

    private Objects() {
        throw new AssertionError("Uninstantiable");
    }

    public static int hashCode(Object... r100) {
        return Arrays.hashCode(r100);
    }

    public static ToStringHelper toStringHelper(Object r100) {
        return new ToStringHelper(r100, null);
    }

    public static boolean checkBundlesEquality(Bundle r100, Bundle r101) {
        if (r100 == null) goto L19;
        if (r101 == null) goto L19;
        if (r100.size() == r101.size()) goto L9;
        return false;
    L9:
        Set<String> r102 = r100.keySet();
        if (r102.containsAll(r101.keySet()) == true) goto L12;
        return false;
    L12:
        Iterator<String> r103 = r102.iterator();
    L14:
        if (r103.hasNext() == false) goto L18;
        String r104 = r103.next();
        if (equal(r100.get(r104), r101.get(r104)) == true) goto L14;
        return false;
    L18:
        return true;
    L19:
        if (r100 != r101) goto L21;
        return true;
    L21:
        return false;
    }

    public static boolean equal(Object r100, Object r101) {
        if (r100 != r101) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (r100.equals(r101) == true) goto L13;
        return false;
    L13:
        return true;
    }
}
