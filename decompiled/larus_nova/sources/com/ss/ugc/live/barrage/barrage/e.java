package com.ss.ugc.live.barrage.barrage;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import com.ss.ugc.live.barrage.util.f;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes36.dex */
public class e extends AbsBarrage {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Context f458087q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Function3<Bitmap, Integer, Integer, Unit> f458088r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f458089s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f458090t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Bitmap f458091u;

    @Override // com.ss.ugc.live.barrage.barrage.AbsBarrage
    public void j() {
        Bitmap r100 = this.f458091u;
        if (r100 == null) goto L6;
        this.f458065m.f458070d.a(r100);
        return;
    }

    @Override // com.ss.ugc.live.barrage.barrage.AbsBarrage
    public final void k() {
        View r100 = this.f458090t;
        if (r100 == null) goto L5;
        q(r100);
        return;
    L5:
        int r101 = this.f458089s;
        if (r101 <= 0) goto L10;
        this.f458089s = r101;
        this.f458090t = null;
        q(LayoutInflater.from(this.f458087q).inflate(r101, null));
        return;
    }

    @Override // com.ss.ugc.live.barrage.barrage.AbsBarrage
    public final Bitmap h() {
        return this.f458091u;
    }

    @Deprecated(message = "Use non-arg updateView() instead")
    public final void q(View r100) {
        this.f458090t = r100;
        this.f458089s = -1;
        if (this.f458059g != AbsBarrage.State.PREPARING) goto L5;
    L6:
        AbsBarrage.b r101 = this.f458065m;
        olc.a r102 = r101.f458070d;
        r101.f458071e.execute(new f(r100, r102, this.f458088r));
        return;
    L5:
        if (this.f458059g == AbsBarrage.State.VISIBLE) goto L6;
    }

    public e(View r100, AbsBarrage.b r101) {
        super(r101);
        this.f458088r = new ViewWrapperBarrage$bitmapListener$1(this);
        this.f458089s = -1;
        this.f458090t = r100;
        this.f458087q = r100.getContext();
    }
}
