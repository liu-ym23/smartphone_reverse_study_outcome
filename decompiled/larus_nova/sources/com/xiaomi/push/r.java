package com.xiaomi.push;

import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Collection;

/* JADX INFO: loaded from: classes41.dex */
public class r {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f464136a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private final StringBuilder f973a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f464137b;

        public a() {
            this(":", ",");
        }

        public String toString() {
            return this.f973a.toString();
        }

        public a(String r100, String r101) {
            this.f973a = new StringBuilder();
            this.f464136a = r100;
            this.f464137b = r101;
        }

        public a a(String r100, Object r101) {
            if (TextUtils.isEmpty(r100) == false) goto L5;
        L8:
            return this;
        L5:
            if (this.f973a.length() <= 0) goto L7;
            this.f973a.append(this.f464137b);
        L7:
            StringBuilder r102 = this.f973a;
            r102.append(r100);
            r102.append(this.f464136a);
            r102.append(r101);
            goto L8
        }
    }

    public static boolean a() {
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean a(Collection<?> r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.isEmpty() == true) goto L7;
        return false;
    }

    public static int a(String r100, int r101) {
        if (TextUtils.isEmpty(r100) == true) goto L9;
        return CastIntegerProtector.parseInt(r100);
    L10:
        return r101;
    L9:
        return r101;
    }

    public static int b(String r100, int r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r101;
    L5:
        return ((r100.hashCode() / 10) * 10) + r101;
    }

    public static long a(String r100, long r101) {
        if (TextUtils.isEmpty(r100) == true) goto L9;
        return CastLongProtector.parseLong(r100);
    L10:
        return r101;
    L9:
        return r101;
    }
}
