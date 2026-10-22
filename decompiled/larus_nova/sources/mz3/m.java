package mz3;

import android.content.Context;
import android.widget.Scroller;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class m extends Scroller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f516492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f516493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f516494c;

    public static final class a {
    }

    static {
    }

    public m(Context r100) {
        l r101 = new l();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "interpolator");
        super(r100, r101);
        this.f516492a = r101;
        this.f516493b = 600;
    }

    public final void a(boolean r100) {
        this.f516494c = r100;
        this.f516492a.f516491d = r100;
    }

    @Override // android.widget.Scroller
    public final void startScroll(int r100, int r101, int r102, int r110, int r111) {
        if (this.f516494c == false) goto L5;
        super.startScroll(r100, r101, r102, r110, this.f516493b);
        return;
    L5:
        super.startScroll(r100, r101, r102, r110, 600);
    }
}
