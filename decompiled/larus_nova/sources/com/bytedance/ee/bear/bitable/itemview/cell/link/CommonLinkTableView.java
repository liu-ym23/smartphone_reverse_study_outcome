package com.bytedance.ee.bear.bitable.itemview.cell.link;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.bitable.card.view.cell.linktable.data.BitableLinkTableUpdateData;
import com.bytedance.ee.bear.bitable.card.view.cell.linktable.model.LinkTableDataModelManager;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.common.k;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
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
import com.bytedance.ee.bear.bitable.itemview.util.ItemViewLogger;
import com.bytedance.ee.bear.bitable.itemview.util.i;
import com.bytedance.ee.bear.bitable.itemview.util.l;
import com.bytedance.ee.bear.bitable.uikit.Action;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u0000 62\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u0005:\u000256B\u001d\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u001e\u001a\u00020\u001fH\u0014J\b\u0010 \u001a\u00020\u001fH\u0014J\u001c\u0010!\u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u0003H\u0016J\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u001fH&J\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020%H&J\b\u0010)\u001a\u00020*H&J\u0010\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020%H\u0016J\u0006\u0010-\u001a\u00020.J\u0006\u0010/\u001a\u000200J\u0006\u00101\u001a\u00020.J\u0006\u00102\u001a\u00020.J\u0006\u00103\u001a\u000204R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u00067"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/link/CommonLinkTableView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKit;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/link/LinkTableCellValue;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/linktable/model/TableDataModelCallback;", "Lcom/bytedance/ee/bear/bitable/common/TouchDetectListener;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "state", "Lcom/bytedance/ee/bear/bitable/itemview/cell/link/CommonLinkTableView$LinkTableState;", "getState", "()Lcom/bytedance/ee/bear/bitable/itemview/cell/link/CommonLinkTableView$LinkTableState;", "setState", "(Lcom/bytedance/ee/bear/bitable/itemview/cell/link/CommonLinkTableView$LinkTableState;)V", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "getHandler", "()Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "setHandler", "(Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;)V", "mDataModelDelegate", "Lcom/bytedance/ee/bear/bitable/card/view/cell/linktable/model/ILinkTableDataModelDelegate;", "getMDataModelDelegate", "()Lcom/bytedance/ee/bear/bitable/card/view/cell/linktable/model/ILinkTableDataModelDelegate;", "setMDataModelDelegate", "(Lcom/bytedance/ee/bear/bitable/card/view/cell/linktable/model/ILinkTableDataModelDelegate;)V", "onAttachedToWindow", "", "onDetachedFromWindow", "setData", "data", "onDataChangeV2", "onViewDataChange", "Lcom/bytedance/ee/bear/bitable/card/view/cell/linktable/data/BitableLinkTableViewData;", "updateOtherView", "updateNativeViewData", "mViewData", "getContainerType", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/MobileViewContainerType;", "beforeViewDataChange", "viewData", "isLoadViewData", "", "getVisibleRecordSize", "", "hasLinkVisiblePermission", "hasEditablePermission", "getEFieldUIType", "", "LinkTableState", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class CommonLinkTableView extends FrameLayout implements gv4.b<LinkTableCellValue>, tp4.f, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f213885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gv4.a f213886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public tp4.a f213887c;

    public static final class a extends gv4.e {
        @Override // gv4.e
        public final boolean b(Action r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            return false;
        }

        public a(Ref.ObjectRef<e> r100) {
            super(r100.element);
        }
    }

    public static final class b {
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f213888a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public m f213889b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public LinkTableCellValue f213890c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f213891d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f213892e;

        public c() {
            this.f213888a = true;
        }
    }

    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f213893a = null;

        static {
            int[] r100 = new int[EFieldUIType.values().length];
            r100[EFieldUIType.SINGLE_LINK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[EFieldUIType.DUPLEX_LINK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f213893a = r100;
        }
    }

    public static final class e implements gv4.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonLinkTableView f213894a;

        public e(CommonLinkTableView r100) {
            this.f213894a = r100;
        }

        @Override // gv4.a
        public final void a(Action r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            m r101 = this.f213894a.getState().f213889b;
            if (r101 == null) goto L6;
            r101.a(r100);
            return;
        }
    }

    static {
    }

    public void a(rp4.b r100) {
        Intrinsics.checkNotNullParameter(r100, "viewData");
    }

    @Override // tp4.f
    public final void d(rp4.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    public abstract void g(rp4.b r100);

    public abstract MobileViewContainerType getContainerType();

    public abstract void h();

    public final String getEFieldUIType() {
        LinkTableCellValue r100 = this.f213885a.f213890c;
        if (r100 == null) goto L5;
        EFieldUIType r101 = r100.getFieldUIType();
    L6:
        if (r101 != null) goto L8;
        int r102 = -1;
    L10:
        if (r102 != 1) goto L12;
        return "relation";
    L12:
        if (r102 == 2) goto L14;
        return "";
    L14:
        return "duplex_relation";
    L8:
        r102 = d.f213893a[r101.ordinal()];
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    public final int getVisibleRecordSize() {
        c r100 = this.f213885a;
        if (r100.f213892e == true) goto L11;
        LinkTableCellValue r101 = r100.f213890c;
        if (r101 == null) goto L11;
        if (r101 != null) goto L12;
        return 0;
    L12:
        return r101.getVisibleRecordSize();
    L11:
        return r100.f213891d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.ee.bear.bitable.itemview.b r100 = i.c(this);
        if (r100 == null) goto L6;
        r100.EB(this);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.ee.bear.bitable.itemview.b r100 = i.c(this);
        if (r100 == null) goto L6;
        r100.ES(this);
        return;
    }

    @Override // android.view.View
    public final gv4.a getHandler() {
        return this.f213886b;
    }

    public final tp4.a getMDataModelDelegate() {
        return this.f213887c;
    }

    public final c getState() {
        return this.f213885a;
    }

    public CommonLinkTableView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // tp4.f
    public final void c(rp4.b r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        a(r100);
        c r101 = this.f213885a;
        r101.f213889b = r100.f538849b;
        r101.f213892e = true;
        Integer r102 = r100.f538848a.getVisibleRecordNum();
        if (r102 != null) goto L10;
        LinkTableCellValue r103 = this.f213885a.f213890c;
        if (r103 == null) goto L8;
        r102 = Integer.valueOf(r103.getVisibleRecordSize());
    L9:
        if (r102 != null) goto L10;
        int r104 = 0;
    L12:
        r101.f213891d = r104;
        h();
        g(r100);
        return;
    L8:
        r102 = null;
    L10:
        r104 = r102.intValue();
        goto L12
    }

    @Override // tp4.f
    public final void e(LinkTableCellValue r110) {
        Intrinsics.checkNotNullParameter(r110, "data");
        this.f213885a.f213890c = r110;
        l.a("onDataChange>>> size:" + getVisibleRecordSize() + ". loaded:" + this.f213885a.f213892e, ItemViewLogger.ItemViewLinkTable, null, null, 12);
        h();
        if (this.f213885a.f213892e == true) goto L20;
        int r111 = getVisibleRecordSize();
        Context r100 = getContext();
        MobileViewContainerType r101 = getContainerType();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "containerType");
        int r112 = RangesKt.coerceAtMost(r111, 20);
        if (h18.f.a(r100) == false) goto L7;
        String r102 = "#1a1a1a";
    L8:
        BitableLinkTableUpdateData r103 = new BitableLinkTableUpdateData();
        r103.setVisibleRecordNum(Integer.valueOf(r112));
        BitableNativeViewData r104 = new BitableNativeViewData();
        r104.setContainerType(r101);
        r104.setSubViewType(SubViewType.NativeGrid);
        GridViewData r105 = new GridViewData();
        GridFieldHeaderData r106 = new GridFieldHeaderData();
        ArrayList<GridFieldData> r107 = new ArrayList();
        int r108 = 0;
    L10:
        if (r108 >= 3) goto L15;
        GridFieldData r113 = new GridFieldData();
        r113.setLoading(true);
        if (r108 != 0) goto L14;
        HighlightModel r114 = new HighlightModel();
        r114.setColorList(CollectionsKt.arrayListOf(new String[]{r102}));
        r113.setHighlightColorV2(r114);
    L14:
        r107.add(r113);
        r108 = r108 + 1;
        goto L10
    L15:
        r106.setFields(r107);
        r105.setFieldHeaderData(r106);
        r105.setPartial(true);
        UpdateStrategy r109 = new UpdateStrategy();
        r109.setStrategy("rebuild");
        r109.setSwitchView(true);
        r109.setPageSize(100);
        r109.setPreIndex(20);
        r109.setProcessDuration(1);
        r105.setUpdateStrategy(r109);
        GridSetting r115 = new GridSetting();
        r115.setShowAddCol(false);
        r115.setColWidth(new float[]{135.0f, 135.0f, 135.0f});
        r115.setMaxFixedRatio(0.95f);
        r115.setDefaultFixedRatio(0.35f);
        r115.setWideScreenDefaultFixedRatio(0.35f);
        r115.setMinFixedRatio(0.35f);
        r115.setWideScreenMinFixedRatio(0.25f);
        r105.setSetting(r115);
        RenderMeta r116 = new RenderMeta();
        r116.setType("Leaf");
        r116.setCount(r112);
        r116.setLoaded(true);
        r116.setGroupLength(0);
        r105.setRenderMeta(r116);
        r104.setData(r105);
        r103.setValue(r104);
        r103.setToolBarData(null);
        c(new rp4.b(r103, null));
        return;
    L7:
        r102 = "#ffffff";
        goto L8
    }

    public final void f(LinkTableCellValue r100) {
        if (r100 == null) goto L49;
        ItemViewLogger r101 = ItemViewLogger.ItemViewLinkTable;
        l.a("setData " + r100, r101, null, null, 12);
        tp4.a r102 = this.f213887c;
        boolean r103 = false;
        if (r102 == null) goto L23;
        if (r102.f(r100) == true) goto L13;
        l.a("setData not same", r101, null, null, 12);
        com.bytedance.ee.bear.bitable.itemview.b r104 = i.c(this);
        if (r104 == null) goto L12;
        LinkTableDataModelManager r105 = r104.fx();
        if (r105 == null) goto L12;
        r105.destroyLinkTableDataModel(r102);
    L12:
        this.f213887c = null;
        this.f213885a.f213888a = true;
        goto L23
    L13:
        com.bytedance.ee.bear.bitable.itemview.b r106 = i.c(this);
        if (r106 == null) goto L18;
        LinkTableDataModelManager r107 = r106.fx();
        if (r107 == null) goto L18;
        boolean r108 = r107.checkIsActiveModelNew(r102);
    L19:
        l.a("setData check active " + r108, r101, null, null, 12);
        tp4.a r109 = this.f213887c;
        if (r109 == null) goto L23;
        r109.d(r108);
    L18:
        r108 = false;
    L23:
        if (this.f213887c != null) goto L31;
        com.bytedance.ee.bear.bitable.itemview.b r110 = i.c(this);
        if (r110 == null) goto L29;
        LinkTableDataModelManager r111 = r110.fx();
        if (r111 == null) goto L29;
        tp4.a r112 = r111.createPureViewLinkTableDataModel(r100, getContainerType());
    L30:
        this.f213887c = r112;
    L29:
        r112 = null;
    L31:
        tp4.a r113 = this.f213887c;
        if (r113 == null) goto L34;
        r113.a(r100);
    L34:
        c r114 = this.f213885a;
        if (r114.f213888a == false) goto L50;
        r114.f213888a = false;
        tp4.a r115 = this.f213887c;
        if (r115 == null) goto L51;
        r115.e(this);
        com.bytedance.ee.bear.bitable.itemview.b r116 = i.c(this);
        if (r116 == null) goto L43;
        LinkTableDataModelManager r117 = r116.fx();
        if (r117 == null) goto L43;
        r103 = r117.checkIsActiveModelNew(r115);
    L43:
        l.a("setData attachView " + r103, r101, null, null, 12);
        r115.k(r103);
        com.bytedance.ee.bear.bitable.itemview.b r118 = i.c(this);
        if (r118 == null) goto L52;
        BitableAnalytic r119 = r118.q0();
        if (r119 == null) goto L53;
        String r120 = getEFieldUIType();
        HashMap r121 = new HashMap();
        r121.put("field_type", r120);
        r119.t("ccm_bitable_relation_field_card_inside_view", r121);
        return;
    L53:
        return;
    L52:
        return;
    L51:
        return;
    L50:
        return;
    }

    public final void setHandler(gv4.a r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f213886b = r100;
    }

    public final void setMDataModelDelegate(tp4.a r100) {
        this.f213887c = r100;
    }

    public final void setState(c r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f213885a = r100;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, com.bytedance.ee.bear.bitable.itemview.cell.link.CommonLinkTableView$e] */
    public CommonLinkTableView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f213885a = new c();
        Ref.ObjectRef r102 = new Ref.ObjectRef();
        r102.element = new e(this);
        this.f213886b = new a(r102);
    }
}
