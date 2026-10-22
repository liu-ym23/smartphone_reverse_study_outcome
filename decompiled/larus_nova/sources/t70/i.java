package t70;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.lark.utils.statistics.PerfLog;
import j70.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public class i implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f544867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f544868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f544869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Class<? extends Widget> f544870d;

    @Override // j70.o
    public final ViewGroup e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }

    @Override // j70.o
    public final boolean g() {
        return false;
    }

    @Override // j70.o
    public final boolean i() {
        return false;
    }

    @Override // j70.o
    public /* synthetic */ w70.a j() {
        return null;
    }

    @Override // j70.o
    public final Object[] a() {
        return this.f544867a;
    }

    @Override // j70.o
    public final Class<? extends Widget> c() {
        return this.f544870d;
    }

    @Override // j70.o
    public final boolean f() {
        return this.f544869c;
    }

    @Override // j70.o
    public final boolean h() {
        return this.f544868b;
    }

    public final void d(Object[] r100) {
        Intrinsics.checkNotNullParameter(r100, "args");
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L20;
        Object r103 = r100[r102];
        if ((r103 instanceof String) == true) goto L19;
        if ((r103 instanceof Integer) == true) goto L19;
        if ((r103 instanceof Float) == true) goto L19;
        if ((r103 instanceof Double) == true) goto L19;
        if ((r103 instanceof Long) == true) goto L19;
        if ((r103 instanceof Boolean) == true) goto L19;
        if ((r103 instanceof Byte) == true) goto L19;
        boolean r104 = r103 instanceof Bundle;
    L19:
        r102 = r102 + 1;
        goto L3
    L20:
        this.f544867a = r100;
    }

    public i(boolean r100, boolean r101, Class r102) {
        Intrinsics.checkNotNullParameter(r102, "widgetClz");
        this.f544868b = r100;
        this.f544869c = r101;
        this.f544870d = r102;
    }
}
