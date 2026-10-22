package jg0;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import tf0.p;

/* JADX INFO: loaded from: classes46.dex */
public abstract class b<T> implements d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f498948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f498949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final xg0.a f498950c;

    public int b() {
        return 0;
    }

    @Override // jg0.d
    public void e(int r100, p r101, Object r102) {
        Intrinsics.checkNotNullParameter(r101, "action");
    }

    @Override // jg0.f
    public final void j(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // jg0.f
    public final View l() {
        ViewGroup r100 = this.f498948a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(RootDescription.ROOT_ELEMENT);
    L5:
        return r100;
    }

    public String c() {
        return getClass().getSimpleName();
    }

    public b(xg0.a r100) {
        this.f498950c = r100;
        if (r100 == null) goto L5;
        int r101 = r100.getFeedType();
    L6:
        this.f498949b = r101;
        return;
    L5:
        r101 = 0;
        goto L6
    }

    @Override // jg0.f
    public void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        View r101 = VerticalNitaInflate.a(c(), b(), r100, null, false);
        if (r101 == null) goto L7;
        ViewGroup r102 = (ViewGroup) r101;
        this.f498948a = r102;
        r102.setClipChildren(false);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}
