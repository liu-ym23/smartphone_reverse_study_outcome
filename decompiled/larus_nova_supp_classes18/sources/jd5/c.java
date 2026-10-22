package jd5;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.homepage.banner.BaseBannerModel;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.List;
import mc5.u1;
import uc5.e1;
import uc5.n3;
import uc5.o3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends BaseBannerModel<o3> {
    public FolderSortStrategy h;

    @Override // com.bytedance.ee.bear.list.homepage.banner.BaseBannerModel
    public final mc5.k h() {
        return new o3(this.a);
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.BaseBannerModel
    public final com.bytedance.ee.bear.list.u o() {
        return new e1("");
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.BaseBannerModel
    public final NetService.f p() {
        NetService.f r0 = new NetService.f("/api/explorer/folder/children/");
        r0.b("need_path", "1");
        r0.b("need_total", "1");
        r0.b("length", "100");
        r0.b(ResourceData.KEY_TYPE, String.valueOf(sbb.e.f.b));
        FolderSortStrategy r1 = this.h;
        if (r1 == null) goto L7;
        int r2 = r1.e;
        if (r2 == (-1)) goto L7;
        r0.b("rank", String.valueOf(r2));
        r0.b("asc", String.valueOf(this.h.f));
    L7:
        return r0;
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.BaseBannerModel
    public final Flowable<DocumentListInfo> w() {
        return Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).map(new a(this)).flatMap(new b(this));
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.BaseBannerModel
    public final LiveData<ArrayList<Document>> k() {
        o3 r0 = s();
        r0.getClass();
        tt5.a.h("PersonalRootListCache", "getPersonalFolderLiveData()...");
        LiveData<List<u1>> r1 = ((mc5.j) r0.a.a(mc5.j.class)).Rc("");
        final MediatorLiveData r2 = new MediatorLiveData();
        r2.addSource(r1, new n3(r2));
        return r2;
    }

    public c(ce5.a r1) {
        super(r1);
    }

    public static /* synthetic */ Flowable D(c r0) {
        return super.w();
    }
}
