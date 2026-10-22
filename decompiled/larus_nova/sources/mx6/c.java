package mx6;

import android.view.View;
import com.bytedance.locallife.pdp.container.view.m;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import yw6.u;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements xl4.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f516259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f516260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ u f516261c;

    @Override // xl4.a.c
    public final void clickBubble() {
        Function1<? super View, Unit> r100 = this.f516259a.f516251g;
        if (r100 == null) goto L5;
        r100.invoke(this.f516260b);
    L5:
        m r101 = this.f516259a.f516246b;
        r101.a("merchant_share_bubble_click", MapsKt.plus(MapsKt.plus(r101.b(), this.f516259a.c(this.f516261c.i())), MapsKt.mapOf(TuplesKt.to("bubble_type", "1"))));
    }

    public c(a r100, View r101, u r102) {
        this.f516259a = r100;
        this.f516260b = r101;
        this.f516261c = r102;
    }
}
