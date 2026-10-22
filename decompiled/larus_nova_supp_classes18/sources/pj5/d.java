package pj5;

import com.bytedance.ee.bear.more.fresh.DocDynamicChampionFragment;
import java.util.Calendar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements c {
    public final /* synthetic */ DocDynamicChampionFragment a;

    public d(DocDynamicChampionFragment r1) {
        this.a = r1;
    }

    @Override // pj5.c
    public final void a(Calendar r4) {
        Intrinsics.checkNotNullParameter(r4, "calendar");
        DocDynamicChampionFragment r0 = this.a;
        i r1 = r0.p;
        int r2 = b.a;
        String r3 = r0.da0(b.b(r4.getTime()));
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r1.e = r3;
        i r5 = this.a.p;
        r5.j = r4.getTimeInMillis();
        DocDynamicChampionFragment r6 = this.a;
        r6.ha0(r6.p);
    }
}
