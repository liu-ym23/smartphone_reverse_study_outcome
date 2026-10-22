package mx6;

import android.view.View;
import com.bytedance.locallife.pdp.container.view.m;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import yw6.u;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f516256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f516257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ u f516258c;

    @Override // mx6.a.b
    public void update(int r100) {
        if (this.f516256a.getVisibility() != 8) goto L8;
        if (r100 != 0) goto L8;
        a r101 = this.f516257b;
        if (r101.f516248d == true) goto L8;
        m r102 = r101.f516246b;
        r102.a("merchant_share_bubble_show", MapsKt.plus(MapsKt.plus(r102.b(), this.f516257b.c(this.f516258c.i())), MapsKt.mapOf(TuplesKt.to("bubble_type", "2"))));
    L8:
        this.f516256a.setVisibility(r100);
        this.f516257b.f516248d = true;
    }

    public b(View r100, a r101, u r102) {
        this.f516256a = r100;
        this.f516257b = r101;
        this.f516258c = r102;
    }
}
