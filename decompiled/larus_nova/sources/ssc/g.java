package ssc;

import android.graphics.drawable.Drawable;
import lsc.h;
import lsc.t;
import lsc.u;
import lsc.x;

/* JADX INFO: loaded from: classes5.dex */
public final class g implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f543528a;

    public g(Drawable r100) {
        this.f543528a = r100;
    }

    @Override // lsc.x
    public final Object a(h r100, t r101) {
        u r102 = (u) r101;
        return new f(r100.f510591a, this.f543528a, ((Boolean) r102.b(e.f543522a, Boolean.FALSE)).booleanValue());
    }
}
