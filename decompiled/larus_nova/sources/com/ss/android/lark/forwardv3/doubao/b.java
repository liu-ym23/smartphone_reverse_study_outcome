package com.ss.android.lark.forwardv3.doubao;

import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.forwardv3.plugins.i;
import com.ss.android.lark.log.Log;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f425341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Boolean> f425342b;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.forwardv3.plugins.i
    public final void a(Intent r100) {
    }

    @Override // com.ss.android.lark.forwardv3.plugins.i
    public final i b(FragmentActivity r100, Fragment r101, View r102) {
        Intrinsics.checkNotNullParameter(r102, "pluginTarget");
        return this;
    }

    @Override // com.ss.android.lark.forwardv3.plugins.i
    public final void c() {
    }

    @Override // com.ss.android.lark.forwardv3.plugins.i
    public final void e(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
    }

    @Override // com.ss.android.lark.forwardv3.plugins.i
    public final void d() {
        if (this.f425342b.invoke().booleanValue() == true) goto L28;
        AtomicReference<com.ss.android.lark.forwardv3.doubao.a> r100 = c.f425343a;
        long r101 = this.f425341a;
        Intrinsics.checkNotNullParameter("forward session plugin destroy", "reason");
        AtomicReference<com.ss.android.lark.forwardv3.doubao.a> r102 = c.f425343a;
        com.ss.android.lark.forwardv3.doubao.a r103 = r102.get();
        boolean r104 = true;
        if (r103 != null) goto L7;
    L9:
        boolean r105 = false;
    L11:
        if (r105 == true) goto L18;
        StringBuilder r106 = new StringBuilder("skip clearing doubao forward session: reason=forward session plugin destroy, hasCurrent=");
        if (r103 != null) goto L16;
        r104 = false;
    L16:
        r106.append(r104);
        Log.i("NewForward", r106.toString());
        return;
    L18:
        if (r102.compareAndSet(r103, null) == true) goto L23;
        if (r102.get() == r103) goto L18;
        r104 = false;
    L23:
        Log.i("NewForward", "clear doubao forward session: reason=forward session plugin destroy, cleared=" + r104);
        return;
    L7:
        if (0 != r101) goto L9;
        r105 = true;
        goto L11
    }

    public b(long r100, Function0<Boolean> r101) {
        Intrinsics.checkNotNullParameter(r101, "isChangingConfigurations");
        this.f425341a = r100;
        this.f425342b = r101;
    }
}
