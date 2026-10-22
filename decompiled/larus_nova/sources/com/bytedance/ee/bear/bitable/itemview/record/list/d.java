package com.bytedance.ee.bear.bitable.itemview.record.list;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.bitable.itemview.cell.ItemViewRecordCellData;
import com.bytedance.ee.bear.bitable.itemview.record.ItemViewRecordData;
import com.bytedance.ee.bear.bitable.itemview.record.k;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f214139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f214140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f214141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gv4.a f214142d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<RenderItemKey> f214143e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super String, ItemViewRenderItemData<Object>> f214144f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function1<? super String, ItemViewRecordCellData> f214145g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public MutableLiveData<Integer> f214146h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public k f214147i;

    public d() {
        this.f214139a = "";
        this.f214141c = true;
        this.f214143e = new ArrayList();
    }

    public final void a(final ItemViewRecordData r100, k r101, gv4.a r102) {
        Intrinsics.checkNotNullParameter(r100, "record");
        this.f214139a = r100.getId();
        this.f214141c = r100.getUseNewLayout();
        this.f214142d = r102;
        this.f214143e = r100.getRenderList();
        this.f214140b = Integer.valueOf(r100.getGlobalIndex());
        this.f214147i = r101;
        this.f214144f = new ItemViewAdapterParams$build$1(r100);
        this.f214145g = new ItemViewAdapterParams$build$2(r100);
    }
}
