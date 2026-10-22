package vw8;

import android.text.style.ForegroundColorSpan;
import kotlin.jvm.internal.Intrinsics;
import lsc.m;
import lsc.y;
import lw8.d;
import msc.s;
import org.commonmark.node.BlockQuote;

/* JADX INFO: loaded from: classes26.dex */
public final class a implements m.c<BlockQuote> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f557449a;

    public a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "customMarkDownInfo");
        this.f557449a = r100;
    }

    @Override // lsc.m.c
    public final void a(m r100, uvc.b r101) {
        BlockQuote r102 = (BlockQuote) r101;
        Intrinsics.checkNotNullParameter(r100, "visitor");
        Intrinsics.checkNotNullParameter(r102, "blockQuote");
        r100.C(r102);
        int r103 = r100.length();
        r100.c(r102);
        lw8.a r104 = this.f557449a.f511073t;
        if (r104 == null) goto L7;
        Integer r105 = r104.f511051f;
        if (r105 == null) goto L7;
        int r106 = r105.intValue();
        y r107 = r100.builder();
        r107.setSpan(new ForegroundColorSpan(r106), r103, r107.length(), 33);
    L7:
        s r108 = r100.B().f510591a;
        lw8.a r109 = this.f557449a.f511073t;
        int r110 = 0;
        if (r109 == null) goto L12;
        Integer r111 = r109.f511049d;
        if (r111 == null) goto L12;
        int r112 = r111.intValue();
    L13:
        lw8.a r113 = this.f557449a.f511073t;
        if (r113 == null) goto L18;
        Integer r114 = r113.f511050e;
        if (r114 == null) goto L18;
        r110 = r114.intValue();
    L18:
        sw8.a r115 = new sw8.a(r108, r112, r110);
        y r116 = r100.builder();
        r116.setSpan(r115, r103, r116.length(), 33);
        r100.q(r102);
        return;
    L12:
        r112 = 0;
        goto L13
    }
}
