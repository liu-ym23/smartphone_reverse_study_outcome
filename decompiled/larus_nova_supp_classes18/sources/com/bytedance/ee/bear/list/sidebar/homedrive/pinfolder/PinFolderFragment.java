package com.bytedance.ee.bear.list.sidebar.homedrive.pinfolder;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.pinview.PinFragment;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import cqa.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mc5.j;
import mc5.k;
import od5.d;
import od5.m;
import od5.t;
import wc5.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0003\u000e\u000f\u0010B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0014J\u0012\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\rH\u0016R\u0014\u0010\u0005\u001a\b\u0018\u00010\u0006R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/list/sidebar/homedrive/pinfolder/PinFolderFragment;", "Lcom/bytedance/ee/bear/list/pinview/PinFragment;", "Lcom/bytedance/ee/bear/list/homepage/IHomeSubFragment;", "<init>", "()V", "mView", "Lcom/bytedance/ee/bear/list/sidebar/homedrive/pinfolder/PinFolderFragment$PinFolderView;", "initMvp", "", "setRefreshLayout", "refreshLayout", "Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;", "onRefresh", "Lcom/scwang/smartrefresh/layout/api/RefreshLayout;", "PinFolderView", "PinFolderPresenter", "PinFolderModel", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PinFolderFragment extends PinFragment implements e {
    public b r;

    public final class PinFolderModel extends d {
        @Override // od5.d, com.bytedance.ee.bear.list.list.e
        public final LiveData<ArrayList<Document>> X() {
            return Transformations.map(((j) this.k.a(j.class)).c7(16), PinFolderFragment$PinFolderModel$getListLiveData$1.INSTANCE);
        }

        @Override // com.bytedance.ee.bear.list.list.a
        public final NetService.f h() {
            NetService.f r0 = new NetService.f("/space/api/explorer/v2/pin/list/");
            r0.b("obj_type", "0");
            return r0;
        }

        @Override // od5.d
        public final t t0() {
            return new SidebarPinFolderListCache(this.k);
        }

        @Override // od5.d, com.bytedance.ee.bear.list.list.a
        public final /* bridge */ /* synthetic */ k p() {
            return t0();
        }

        public PinFolderModel(LifeCycleFragment r2, Context r3, ce5.a r4) {
            Intrinsics.checkNotNullParameter(r4, "userComponentAbility");
            super(r2, r3, r4);
        }
    }

    public final class a extends od5.e {
        @Override // od5.e, com.bytedance.ee.bear.list.list.b
        public final String J8() {
            return "new_drive";
        }

        public a(b r2, PinFolderModel r3, Context r4, LifeCycleFragment r5, ce5.a r6) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "model");
            Intrinsics.checkNotNullParameter(r5, "fragment");
            Intrinsics.checkNotNullParameter(r6, "userComponentAbility");
            super(r2, r3, r4, r5, r6);
        }
    }

    public final class b extends m {
        @Override // od5.m, com.bytedance.ee.bear.list.list.c
        public final DiffUtil.Callback Q1(List<Document> r2, List<Document> r3) {
            return new PinFolderItemDiffCallback(r2, r3);
        }

        public b(Context r2, View r3, LifeCycleFragment r4, ce5.a r5) {
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "fragmentLifeCycle");
            Intrinsics.checkNotNullParameter(r5, "userComponentAbility");
            super(r2, r3, r4, r5);
        }
    }

    @Override // wc5.e
    public final /* synthetic */ void onPageSelected() {
    }

    @Override // com.bytedance.ee.bear.list.pinview.PinFragment
    public final void ca0() {
        ce5.a r5 = new ce5.a(this);
        b r1 = new b(getContext(), this.q, this, r5);
        this.r = r1;
        a r6 = new a(r1, new PinFolderModel(this, getContext(), r5), getContext(), this, r5);
        this.p = r6;
        r6.create();
    }

    public PinFolderFragment() {
    }

    @Override // wc5.e
    public final void Co(SmartRefreshLayout r2) {
        b r0 = this.r;
        if (r0 == null) goto L6;
        r0.j = r2;
        r0.z2();
        return;
    }

    @Override // wc5.e
    public final void d2(h r1) {
        od5.e r2 = this.p;
        if (r2 == null) goto L6;
        r2.onRefresh();
        return;
    }
}
