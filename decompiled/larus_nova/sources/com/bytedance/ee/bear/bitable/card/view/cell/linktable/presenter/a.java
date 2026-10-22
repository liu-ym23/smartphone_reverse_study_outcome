package com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.bitable.card.view.cell.link.BitableLinkRecordsFetchManager;
import com.bytedance.ee.bear.bitable.card.view.cell.linktable.data.BitableLinkTableUpdateData;
import com.bytedance.ee.bear.bitable.card.view.cell.linktable.data.OpenDiscussPanelType;
import com.bytedance.ee.bear.bitable.card.view.cell.linktable.model.LinkTableDataModelManager;
import com.bytedance.ee.bear.bitable.card.viewmodel.BitableCardViewModel;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.bytedance.ee.bear.bitable.common.model.field.FieldCompositeType;
import com.bytedance.ee.bear.bitable.common.widgets.HighlightModel;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BitableNativeViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.MobileViewContainerType;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.SubViewType;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.UpdateStrategy;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta.RenderMeta;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.GridSetting;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.GridViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.field.GridFieldData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.field.GridFieldHeaderData;
import com.bytedance.ee.bear.browser.plugin.q;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f207857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MobileViewContainerType f207858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final gp4.h f207859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f207860d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final tp4.a f207861e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BitableCardViewModel f207862f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinkTableDataModelManager f207863g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final BitableLinkRecordsFetchManager f207864h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public m f207865i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public rp4.a f207866j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f207867k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f207868l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f207869m;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.a$a, reason: collision with other inner class name */
    public static final class C2999a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f207870a = null;

        static {
            int[] r100 = new int[EFieldUIType.values().length];
            r100[EFieldUIType.SINGLE_LINK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[EFieldUIType.DUPLEX_LINK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f207870a = r100;
        }
    }

    static {
    }

    public abstract void a(rp4.b r100);

    public abstract void f(String r100, OpenDiscussPanelType r101);

    public abstract void g(rp4.a r100);

    public final String b() {
        rp4.a r100 = this.f207866j;
        if (r100 == null) goto L9;
        fp4.d r101 = r100.f538844a;
        if (r101 == null) goto L9;
        FieldCompositeType r102 = r101.f478257d;
        if (r102 == null) goto L9;
        EFieldUIType r103 = r102.getUiType();
    L10:
        if (r103 != null) goto L12;
        int r104 = -1;
    L14:
        if (r104 != 1) goto L16;
        return "relation";
    L16:
        if (r104 == 2) goto L18;
        return "";
    L18:
        return "duplex_relation";
    L12:
        r104 = b.f207870a[r103.ordinal()];
    L9:
        r103 = null;
        goto L10
    }

    public final int d() {
        int r100 = com.bytedance.ee.bear.bitable.c.f207079a;
        if (this.f207869m == true) goto L13;
        rp4.a r101 = this.f207866j;
        if (r101 == null) goto L13;
        if (r101 == null) goto L10;
        List<cp4.a> r102 = r101.f538846c;
        if (r102 == null) goto L10;
        return ((ArrayList) r102).size();
    L10:
        return 0;
    L13:
        return this.f207868l;
    }

    public final List<cp4.a> e() {
        rp4.a r100 = this.f207866j;
        if (r100 == null) goto L13;
        List<cp4.a> r101 = r100.f538846c;
        if (r101 == null) goto L13;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L19;
        Object r104 = r103.next();
        if (((cp4.a) r104).f464643j == false) goto L8;
        r102.add(r104);
        goto L8
    L19:
        return r102;
    L13:
        return new ArrayList();
    }

    public final void i() {
        int r100 = com.bytedance.ee.bear.bitable.c.f207079a;
        int r101 = this.f207867k;
        Context r102 = this.f207857a;
        UDToast.show(r102, r102.getResources().getQuantityString(R.plurals.Bitable_LinkField_MaxNumOfRecordsToBeLinked_Tooltip, r101, new Object[]{Integer.valueOf(r101)}));
    }

    public final rp4.b c() {
        int r100 = RangesKt.coerceAtMost(d(), 20);
        if (h18.f.a(this.f207857a) == false) goto L5;
        String r101 = "#1a1a1a";
    L6:
        BitableLinkTableUpdateData r102 = new BitableLinkTableUpdateData();
        r102.setVisibleRecordNum(Integer.valueOf(r100));
        BitableNativeViewData r103 = new BitableNativeViewData();
        r103.setContainerType(this.f207858b);
        r103.setSubViewType(SubViewType.NativeGrid);
        GridViewData r104 = new GridViewData();
        GridFieldHeaderData r105 = new GridFieldHeaderData();
        ArrayList<GridFieldData> r106 = new ArrayList();
        int r107 = 0;
    L8:
        if (r107 >= 3) goto L13;
        GridFieldData r110 = new GridFieldData();
        r110.setLoading(true);
        if (r107 != 0) goto L12;
        HighlightModel r111 = new HighlightModel();
        r111.setColorList(CollectionsKt.arrayListOf(new String[]{r101}));
        r110.setHighlightColorV2(r111);
    L12:
        r106.add(r110);
        r107 = r107 + 1;
        goto L8
    L13:
        r105.setFields(r106);
        r104.setFieldHeaderData(r105);
        r104.setPartial(true);
        UpdateStrategy r108 = new UpdateStrategy();
        r108.setStrategy("rebuild");
        r108.setSwitchView(true);
        r108.setPageSize(100);
        r108.setPreIndex(20);
        r108.setProcessDuration(1);
        r104.setUpdateStrategy(r108);
        GridSetting r109 = new GridSetting();
        r109.setShowAddCol(false);
        r109.setColWidth(new float[]{135.0f, 135.0f, 135.0f});
        r109.setMaxFixedRatio(0.95f);
        r109.setDefaultFixedRatio(0.35f);
        r109.setWideScreenDefaultFixedRatio(0.35f);
        r109.setMinFixedRatio(0.35f);
        r109.setWideScreenMinFixedRatio(0.25f);
        r104.setSetting(r109);
        RenderMeta r112 = new RenderMeta();
        r112.setType("Leaf");
        r112.setCount(r100);
        r112.setLoaded(true);
        r112.setGroupLength(0);
        r104.setRenderMeta(r112);
        r103.setData(r104);
        r102.setValue(r103);
        r102.setToolBarData(null);
        return new rp4.b(r102, null);
    L5:
        r101 = "#ffffff";
        goto L6
    }

    public void h(rp4.b r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        a(r100);
        this.f207865i = r100.f538849b;
        int r101 = com.bytedance.ee.bear.bitable.c.f207079a;
        this.f207869m = true;
        Integer r102 = r100.f538848a.getVisibleRecordNum();
        if (r102 == null) goto L5;
        int r103 = r102.intValue();
    L6:
        this.f207868l = r103;
        Integer r104 = r100.f538848a.getMaxLinkLimit();
        if (r104 == null) goto L9;
        int r105 = r104.intValue();
    L10:
        this.f207867k = r105;
        return;
    L9:
        r105 = 500;
        goto L10
    L5:
        r103 = e().size();
        goto L6
    }

    public a(Context r100, MobileViewContainerType r101, gp4.h r102, g r103, tp4.a r104) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r101, "mContainerType");
        Intrinsics.checkNotNullParameter(r102, "mCardDelegate");
        Intrinsics.checkNotNullParameter(r103, "mEditDelegate");
        Intrinsics.checkNotNullParameter(r104, "mDataModelDelegate");
        this.f207857a = r100;
        this.f207858b = r101;
        this.f207859c = r102;
        this.f207860d = r103;
        this.f207861e = r104;
        this.f207867k = 500;
        Fragment r105 = r102.getFragment();
        this.f207862f = (BitableCardViewModel) q.a(r105, BitableCardViewModel.class);
        this.f207863g = (LinkTableDataModelManager) q.a(r105, LinkTableDataModelManager.class);
        this.f207864h = (BitableLinkRecordsFetchManager) q.a(r105, BitableLinkRecordsFetchManager.class);
    }
}
