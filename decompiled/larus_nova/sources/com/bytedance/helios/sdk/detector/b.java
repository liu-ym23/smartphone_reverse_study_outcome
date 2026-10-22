package com.bytedance.helios.sdk.detector;

import android.util.SparseArray;
import com.bytedance.helios.api.consumer.PrivacyEvent;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<ApiConfig> f245516a;

    public abstract int[] e();

    public abstract void g(PrivacyEvent r100);

    public b() {
        this.f245516a = new SparseArray();
    }

    static {
    }

    public final ApiConfig d(int r100) {
        return this.f245516a.get(r100);
    }

    public void f(PrivacyEvent r100, Throwable r101) {
        ApiConfig r102 = d(r100.f245366c);
        c(r101, getClass().getCanonicalName(), r100.f245367d, r102.f245515d + ".kt");
        r100.b(r101);
        g(r100);
    }

    public static void c(Throwable r100, String r101, String r102, String r103) {
        StackTraceElement[] r104 = r100.getStackTrace();
        StackTraceElement r105 = new StackTraceElement(r101, r102, r103, 0);
        StackTraceElement[] r106 = new StackTraceElement[r104.length + 1];
        r106[0] = r105;
        System.arraycopy(r104, 0, r106, 1, r104.length);
        r100.setStackTrace(r106);
    }
}
