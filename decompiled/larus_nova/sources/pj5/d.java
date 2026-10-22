package pj5;

import com.bytedance.ee.bear.more.fresh.DocDynamicChampionFragment;
import java.util.Calendar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DocDynamicChampionFragment f529470a;

    public d(DocDynamicChampionFragment r100) {
        this.f529470a = r100;
    }

    @Override // pj5.c
    public final void a(Calendar r100) {
        Intrinsics.checkNotNullParameter(r100, "calendar");
        DocDynamicChampionFragment r101 = this.f529470a;
        i r102 = r101.f234518p;
        int r103 = b.f529469a;
        String r104 = r101.da0(b.b(r100.getTime()));
        r102.getClass();
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r102.f529481e = r104;
        i r105 = this.f529470a.f234518p;
        r105.f529486j = r100.getTimeInMillis();
        DocDynamicChampionFragment r106 = this.f529470a;
        r106.ha0(r106.f234518p);
    }
}
