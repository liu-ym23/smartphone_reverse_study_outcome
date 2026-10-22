package com.bytedance.ee.bear.list.sidebar.homedrive.pinfolder.banner;

import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.homepage.banner.BaseBannerModel;
import com.bytedance.ee.bear.list.sidebar.homedrive.pinfolder.SidebarPinFolderListCache;
import com.bytedance.ee.bear.list.u;
import com.ss.android.lark.utils.ContextsKt;
import dd5.w0;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import mc5.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends BaseBannerModel<SidebarPinFolderListCache> {
    public final int h;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.list.sidebar.homedrive.pinfolder.banner.a$a, reason: collision with other inner class name */
    public static final class C0034a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            DocumentListInfo r3 = (DocumentListInfo) r2;
            Intrinsics.checkNotNullParameter(r3, "listInfo");
            this.a.C(r3.getDocumentList());
        }
    }

    public static final class c<T> implements Consumer {
        public static final c<T> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r3) {
            tt5.a.f("SidebarPinFolderBannerModel", (Throwable) r3, false);
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.BaseBannerModel
    public final k h() {
        return new SidebarPinFolderListCache(this.a);
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.BaseBannerModel, com.bytedance.ee.bear.list.homepage.banner.f
    public final boolean hasMore() {
        if (this.e.size() <= this.h) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.BaseBannerModel, com.bytedance.ee.bear.list.homepage.banner.f
    public final void m5() {
        if (j.a.a.getNetworkState().a() == true) goto L6;
        tt5.a.h("SidebarPinFolderBannerModel", "getListFromNet()...no net");
        return;
    L6:
        this.d = w().subscribe(new b(this), c.a);
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.BaseBannerModel
    public final u o() {
        return new u();
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.BaseBannerModel
    public final NetService.f p() {
        NetService.f r0 = new NetService.f("/space/api/explorer/v2/pin/list/");
        r0.b("obj_type", "0");
        return r0;
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.BaseBannerModel
    public final LiveData<ArrayList<Document>> k() {
        return s().c();
    }

    public a(Context r2, ce5.a r3) {
        Intrinsics.checkNotNullParameter(r3, "userComponentAbility");
        super(r3);
        this.g = Integer.MAX_VALUE;
        int r4 = w0.a;
        if (r2 == null) goto L5;
        Activity r5 = ContextsKt.findActivity(r2);
    L6:
        this.h = w0.a(r5);
        return;
    L5:
        r5 = null;
        goto L6
    }
}
