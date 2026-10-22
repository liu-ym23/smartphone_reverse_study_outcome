package eq4;

import db5.j;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class e extends db5.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public h[] f473487e;

    public static final class a {
    }

    static {
    }

    public e() {
        this("", new bo4.a[0], new j[0], new h[0]);
    }

    @Override // db5.a
    public final /* bridge */ /* synthetic */ db5.a a() {
        return b();
    }

    public final e b() {
        db5.a r100 = super.a();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.card.view.description.embedimage.DescriptionAtContent");
        e r101 = (e) r100;
        ArrayList r102 = new ArrayList();
        h[] r103 = this.f473487e;
        int r104 = r103.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L5;
        r102.add(r103[r105].a());
        r105 = r105 + 1;
        goto L3
    L5:
        r101.f473487e = (h[]) r102.toArray(new h[0]);
        return r101;
    }

    @Override // db5.a
    public final /* bridge */ /* synthetic */ Object clone() {
        return b();
    }

    public e(String r100, bo4.a[] r101, j[] r102, h[] r103) {
        Intrinsics.checkNotNullParameter(r101, "ats");
        Intrinsics.checkNotNullParameter(r102, "links");
        Intrinsics.checkNotNullParameter(r103, "embedImages");
        super(r100, r101, r102);
        this.f473487e = r103;
    }
}
