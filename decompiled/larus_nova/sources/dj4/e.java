package dj4;

import android.content.Context;
import androidx.core.view.GestureDetectorCompat;
import com.bytedance.creativex.mediaimport.widget.gesture.ScaleGestureLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f468911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f468912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final GestureDetectorCompat f468913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f468914d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final vhc.b f468915e;

    public e(Context r100, ScaleGestureLayout.b r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f468911a = r101;
        this.f468912b = true;
        a r102 = new a(this);
        b r103 = new b(this);
        d r104 = new d(this);
        c r105 = new c(this);
        GestureDetectorCompat r106 = new GestureDetectorCompat(r100, r103);
        this.f468913c = r106;
        this.f468914d = new i(r104);
        this.f468915e = new vhc.b(r100, r105);
        r106.setOnDoubleTapListener(r102);
    }
}
