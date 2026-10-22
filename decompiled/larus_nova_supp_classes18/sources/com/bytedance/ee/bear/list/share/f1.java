package com.bytedance.ee.bear.list.share;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.folder.FolderSort;
import com.bytedance.ee.bear.list.sort.FilterType;
import io.reactivex.Flowable;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f1 extends com.bytedance.ee.bear.list.list.a<y0> implements h0 {
    public boolean l;
    public final boolean m;

    @Override // com.bytedance.ee.bear.list.share.m0
    public final void K1(String r1) {
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final String P() {
        return "NewShareFolderModel";
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final String k() {
        return "/space/api/explorer/v2/share/folder/list/";
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final Flowable<DocumentListInfo> C() {
        return Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).map(new d1(this)).flatMap(new z0(this));
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final String L() {
        if (this.m == false) goto L6;
        return "hidden_shared_folder";
    L6:
        return "shared_folder_v2";
    }

    @Override // com.bytedance.ee.bear.list.share.h0
    public final Boolean P0() {
        return Boolean.valueOf(this.l);
    }

    @Override // com.bytedance.ee.bear.list.share.m0
    public final Flowable<Integer> R() {
        NetService.f r0 = new NetService.f("/api/explorer/share/folder/newlist/");
        r0.b("be_shared", String.valueOf(true));
        return ((NetService) org.koin.java.a.a(NetService.class)).Vc(new s2()).a(r0).map(new a1());
    }

    @Override // com.bytedance.ee.bear.list.list.e
    public final LiveData<ArrayList<Document>> X() {
        return Transformations.map(((mc5.j) this.k.a(mc5.j.class)).N5(this.m), new od5.c());
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final NetService.f h() {
        return t0(50, this.m, this.c);
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final com.bytedance.ee.bear.list.u o() {
        return new s2(this.m);
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final mc5.k p() {
        return new y0(this.m, this.k);
    }

    @Override // com.bytedance.ee.bear.list.share.m0
    public final void c(String r3) {
        tt5.a.h("NewShareFolderModel", "removeItem()...");
        ((y0) this.g).delete(r3);
    }

    public static NetService.f t0(int r8, boolean r9, FolderSortStrategy r10) {
        if (r10 != null) goto L11;
        if (r9 == false) goto L5;
        FolderSort r11 = FolderSort.NAME;
    L7:
        if (r9 == false) goto L9;
        String r0 = "hidden_shared_folder";
    L10:
        r10 = new FolderSortStrategy(r0, FilterType.ALL.getType(), "", "", r11.getRank(), r11.getAsc());
        goto L11
    L9:
        r0 = "shared_folder_v2";
        goto L10
    L5:
        r11 = FolderSort.SHARED_TIME;
    L11:
        NetService.f r1 = new NetService.f("/space/api/explorer/v2/share/folder/list/");
        r1.b("length", String.valueOf(r8));
        r1.b("rank", String.valueOf(r10.e));
        r1.b("asc", String.valueOf(r10.f));
        if (r9 == false) goto L14;
        String r12 = "1";
    L15:
        r1.b("hidden", r12);
        return r1;
    L14:
        r12 = "0";
        goto L15
    }

    public f1(LifeCycleFragment r1, Context r2, boolean r3, ce5.a r4) {
        super(r1, r2, r4);
        this.m = r3;
    }
}
