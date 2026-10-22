package moc;

import com.ss.android.lark.statistics.Statistics;
import kotlin.jvm.internal.Intrinsics;
import s5c.d;
import z5c.e;
import z5c.p2;
import z5c.p3;
import z5c.v1;
import z5c.w0;
import z5c.x0;
import z5c.y0;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f514621a = 0;

    static {
    }

    public static void a(String r100, String r101, String r102, boolean r103, boolean r104, s5c.a r105) {
        Intrinsics.checkNotNullParameter(r100, "functionKey");
        Intrinsics.checkNotNullParameter(r101, "functionScene");
        Intrinsics.checkNotNullParameter(r102, "functionCategory");
        Intrinsics.checkNotNullParameter(r105, "click");
        s5c.a r106 = p3.f570282c;
        r105.getClass();
        d r107 = d.b.b(r105, r106).plus(y0.f570408c.a(r100)).plus(x0.f570400d.a(r101)).plus(w0.f570393c.a(r102));
        if (r103 == false) goto L5;
        s5c.a r108 = e.f570186c;
    L6:
        d r109 = r107.plus(r108);
        if (r104 == false) goto L9;
        s5c.a r110 = v1.f570389d;
    L10:
        Statistics.sendEvent("common_pricing_popup_click", r109.plus(r110).plus(p2.f570281c).toJson());
        return;
    L9:
        r110 = v1.f570388c;
        goto L10
    L5:
        r108 = e.f570187d;
        goto L6
    }
}
