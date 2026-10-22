package com.larus.voicecall.impl.component.bottom.more_btn;

import androidx.fragment.app.Fragment;
import com.larus.av_call.util.RealtimeBottomMoreBtn;
import com.larus.voicecall.impl.continue_talk.u1;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class b extends com.larus.voicecall.impl.component.bottom.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f377233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t1a.b f377234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<RealtimeBottomMoreBtn> f377235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f377236d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public jd9.c f377237e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BottomMoreAction$ctx$1 f377238f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f377239g;

    public static final class a {
    }

    static {
    }

    public final void a() {
        if ((this.f377237e instanceof jd9.c.a) == true) goto L5;
    L7:
        final boolean r100 = false;
    L8:
        RealtimeBottomMoreBtn r101 = this.f377238f.getHostView();
        if (r101 == null) goto L12;
        r101.post(new com.larus.voicecall.impl.component.bottom.more_btn.a(r100, this));
        return;
    L12:
        return;
    L5:
        if (this.f377236d == 7) goto L7;
        r100 = true;
        goto L8
    }

    public b(w3a.k r100, Fragment r101, t1a.b r102, u1 r103) {
        Intrinsics.checkNotNullParameter(r102, "vCtx");
        Intrinsics.checkNotNullParameter(r103, "hViewProvider");
        super(r100);
        this.f377233a = r101;
        this.f377234b = r102;
        this.f377235c = r103;
        this.f377236d = -1;
        this.f377237e = jd9.c.e.f498761c;
        BottomMoreAction$ctx$1 r104 = new BottomMoreAction$ctx$1(this, r100);
        this.f377238f = r104;
        this.f377239g = new k(r104);
    }
}
