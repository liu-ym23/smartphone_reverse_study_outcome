package qp9;

import android.content.Context;
import androidx.core.view.GestureDetectorCompat;
import com.larus.photopicker.v2.impl.others.scale.ScaleGestureLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f534392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f534393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final GestureDetectorCompat f534394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f534395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final rp9.c f534396e;

    public h(Context r100, ScaleGestureLayout.b r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f534392a = r101;
        this.f534393b = true;
        d r102 = new d(this);
        e r103 = new e(this);
        g r104 = new g(this);
        f r105 = new f(this);
        GestureDetectorCompat r106 = new GestureDetectorCompat(r100, r103);
        this.f534394c = r106;
        this.f534395d = new j(r104);
        this.f534396e = new rp9.c(r100, r105);
        r106.setOnDoubleTapListener(r102);
    }
}
