package com.obric.oui.animation.easy;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements jla.b.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b<View> f398745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ jla.c<View> f398746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d f398747c;

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // jla.b.i
    public final void a(jla.b r100, boolean r101) {
        this.f398745a.f398740c.remove(this.f398746b);
        if (r100 == null) goto L8;
        ArrayList<jla.b.i> r102 = r100.f499588k;
        int r103 = r102.indexOf(this);
        if (r103 < 0) goto L8;
        ListProtector.set(r102, r103, null);
    L8:
        if (r100 == null) goto L13;
        d r104 = this.f398747c;
        ArrayList<jla.b.j> r105 = r100.f499589l;
        int r106 = r105.indexOf(r104);
        if (r106 < 0) goto L13;
        ListProtector.set(r105, r106, null);
    L13:
        b<View> r107 = this.f398745a;
        r107.f398744g = null;
        if (r107.f398740c.isEmpty() == false) goto L21;
        if (r101 == true) goto L22;
        b<View> r108 = this.f398745a;
        b.a<T> r109 = r108.f398743f;
        if (r109 == 0) goto L23;
        r109.c((b<T>) r108);
        return;
    L23:
        return;
    L22:
        return;
    }

    public c(b<View> r100, jla.c<View> r101, d r102) {
        this.f398745a = r100;
        this.f398746b = r101;
        this.f398747c = r102;
    }
}
