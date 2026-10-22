package com.ss.ugc.live.barrage.barrage;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Path> f458084a;

    public b() {
        PorterDuffXfermode r100 = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        Paint r101 = new Paint();
        r101.setColor(-1);
        r101.setAntiAlias(true);
        r101.setDither(true);
        r101.setXfermode(r100);
        this.f458084a = new ArrayList();
    }

    public final void update(List<? extends Path> r100) {
        ((ArrayList) this.f458084a).clear();
        ArrayList r101 = (ArrayList) this.f458084a;
        r101.addAll(r100);
    }
}
