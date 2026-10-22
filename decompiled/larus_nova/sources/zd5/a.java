package zd5;

import com.bytedance.ee.bear.document.a4;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.sort.FilterType;
import com.bytedance.ee.bear.list.w4;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public abstract class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a4 f571296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f571297b;

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
    }

    @Override // zd5.f
    public List<FilterType> G6() {
        ArrayList r100 = new ArrayList();
        r100.add(FilterType.ALL);
        r100.add(FilterType.DOC);
        r100.add(FilterType.SHEET);
        int r101 = qc5.a.f532475a;
        ce5.a r102 = new ce5.a();
        Intrinsics.checkNotNullParameter(r102, "userComponentAbility");
        boolean r103 = r102.f23449d.isCurrentEnable("ccm.mobile.slides_enabled");
        tt5.a.h("SpaceFeatureGatingV2", "isEnableSlides:" + r103);
        if (r103 == false) goto L5;
        r100.add(FilterType.SLIDES);
    L5:
        w4 r104 = w4.a();
        int r105 = sbb.e.f541298i.f541317b;
        if (((HashSet) r104.f229842a).contains(Integer.valueOf(r105)) == false) goto L9;
        r100.add(FilterType.BITABLE);
    L9:
        if (this.f571296a.a(sbb.e.f541300k.f541317b) == true) goto L11;
        r100.add(FilterType.MINDNOTE);
    L11:
        r100.add(FilterType.FILE);
        if (this.f571297b == false) goto L14;
        r100.add(FilterType.FOLDER);
    L14:
        return r100;
    }

    public a(boolean r100) {
        this.f571296a = (a4) org.koin.java.a.a(a4.class);
        this.f571297b = r100;
    }

    @Override // zd5.f
    public final void g0(FolderSortStrategy r100, ce5.a r101) {
        if (r100 == null) goto L5;
        ((mc5.j) r101.a(mc5.j.class)).D3(r100);
        return;
    }
}
