package com.ss.android.lark.widget.photopickerimpl.view.large;

import androidx.viewpager.widget.ViewPager;
import com.ss.android.lark.widget.photopickerimpl.bean.Photo;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements a.b<Photo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a<Photo> f447865a;

    @Override // com.ss.android.lark.widget.photopickerimpl.view.large.a.b
    public final Photo a() {
        a<Photo> r100 = this.f447865a;
        LargeShowVPagerAdapter<DATA> r101 = r100.f447854i;
        if (r101 == 0) goto L11;
        List r102 = r101.f447847f;
        if (r102 == null) goto L11;
        ViewPager r103 = r100.f447855j;
        if (r103 == null) goto L9;
        int r104 = r103.getCurrentItem();
    L13:
        return (Photo) CollectionsKt.getOrNull(r102, r104);
    L9:
        r104 = 0;
    L11:
        return null;
    }

    @Override // com.ss.android.lark.widget.photopickerimpl.view.large.a.b
    public final void finish() {
        this.f447865a.i();
    }

    public b(a<Photo> r100) {
        this.f447865a = r100;
    }
}
