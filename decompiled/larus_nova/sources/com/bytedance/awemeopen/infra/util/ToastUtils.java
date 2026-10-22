package com.bytedance.awemeopen.infra.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.bytedance.awemeopen.servicesapi.toast.AoToastService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes46.dex */
public final class ToastUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f198954a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f198955a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f198956b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f198957c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f198955a == r101.f198955a) goto L12;
            return false;
        L12:
            if (this.f198956b == r101.f198956b) goto L15;
            return false;
        L15:
            if (this.f198957c == r101.f198957c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f198955a * 31) + this.f198956b) * 31) + this.f198957c;
        }

        public final String toString() {
            return "GravityParams(gravity=" + this.f198955a + ", offsetX=" + this.f198956b + ", offsetY=" + this.f198957c + ')';
        }

        public a() {
            this.f198955a = 49;
            this.f198956b = 0;
            this.f198957c = 0;
        }
    }

    static {
        f198954a = LazyKt.lazy(ToastUtils$uiHandler$2.INSTANCE);
    }

    @JvmStatic
    public static final void b(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        d(r100, r100.getResources().getString(r101), 0, null);
    }

    @JvmStatic
    public static final void c(Context r100, CharSequence r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "text");
        d(r100, r101, 0, null);
    }

    @JvmStatic
    public static final void a(Context r100, CharSequence r101, int r102, a r103) {
        AoToastService r104 = (AoToastService) j64.a.a(AoToastService.class);
        if (r104 == null) goto L8;
        if (r103 != null) goto L6;
        r104.showToast(r100, r101.toString(), r102);
        return;
    L6:
        r104.G1(r100, r101.toString(), r102, r103.f198955a);
        return;
    L8:
        Toast r105 = Toast.makeText(r100, r101, r102);
        if (r103 == null) goto L11;
        r105.setGravity(r103.f198955a, r103.f198956b, r103.f198957c);
    L11:
        r105.show();
    }

    @JvmStatic
    public static final void d(Context r100, final CharSequence r101, int r102, final a r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "text");
        final Ref.IntRef r104 = new Ref.IntRef();
        boolean r105 = false;
        if (r102 != 1) goto L5;
        int r106 = 1;
    L6:
        r104.element = r106;
        if (Looper.myLooper() != Looper.getMainLooper()) goto L9;
        r105 = true;
    L9:
        final Context r107 = r100.getApplicationContext();
        if (r105 == true) goto L12;
        ((Handler) f198954a.getValue()).post(new n(r107, r101, r104, r103));
        return;
    L12:
        a(r107, r101, r104.element, r103);
        return;
    L5:
        r106 = 0;
        goto L6
    }
}
