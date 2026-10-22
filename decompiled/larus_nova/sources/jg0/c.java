package jg0;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class c<T> implements f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f498951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MicSeatScene f498952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final xg0.a f498953c;

    @Override // jg0.f
    public void j(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    public int o() {
        return 0;
    }

    @Override // jg0.f
    public void onDetach() {
    }

    @Override // jg0.f
    public final View l() {
        ViewGroup r100 = this.f498951a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(RootDescription.ROOT_ELEMENT);
    L5:
        return r100;
    }

    public final int n() {
        xg0.a r100 = this.f498953c;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getFeedType();
    }

    public final ViewGroup q() {
        ViewGroup r100 = this.f498951a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(RootDescription.ROOT_ELEMENT);
    L5:
        return r100;
    }

    public String p() {
        return getClass().getSimpleName();
    }

    @Override // jg0.f
    public void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        View r101 = VerticalNitaInflate.a(p(), o(), r100, null, false);
        if (r101 == null) goto L7;
        this.f498951a = (ViewGroup) r101;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final View m(int r100) {
        ViewGroup r101 = this.f498951a;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException(RootDescription.ROOT_ELEMENT);
    L6:
        return r101.findViewById(r100);
    }

    public c(MicSeatScene r100, xg0.a r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f498952b = r100;
        this.f498953c = r101;
    }
}
