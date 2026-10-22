package com.bytedance.ee.bear.bitable.celleditor.editor.link;

import android.content.Context;
import android.graphics.Paint;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.style.CharacterStyle;
import android.view.LayoutInflater;
import android.view.View;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.SegmentModel;
import com.bytedance.ee.bear.bitable.card.view.cell.CellEditDragView;
import com.bytedance.ee.bear.bitable.card.view.cell.linktable.data.BitableLinkTableUpdateData;
import com.bytedance.ee.bear.bitable.celleditor.bean.CommonEditorModel;
import com.bytedance.ee.bear.bitable.celleditor.bean.ViewStatus;
import com.bytedance.ee.bear.bitable.celleditor.editor.BaseEditorPanel;
import com.bytedance.ee.bear.bitable.databinding.BitableCardLinkTablePickerPanelBinding;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BaseViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BitableNativeViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.GridSetting;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.GridViewData;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.bear.bitable.uikit.SearchAction;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SearchConfigIcon;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import db5.j;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
public final class LinkTableEditorPanel extends BaseEditorPanel<LinkEditorModel> {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ar4.a f209387p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final BitableCardLinkTablePickerPanelBinding f209388q;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkTableEditorPanel f209390a;

        public a(LinkTableEditorPanel r100) {
            this.f209390a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f209390a.f209388q.f210664o.setText("");
            LinkTableEditorPanel r101 = this.f209390a;
            r101.B(false, new View[]{r101.f209388q.f210652c});
            this.f209390a.hideKeyboard();
        }
    }

    public static final class b extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LinkTableEditorPanel f209391c;

        public b(LinkTableEditorPanel r100) {
            this.f209391c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            String r101 = this.f209391c.f209388q.f210664o.getText().toString();
            LinkTableEditorPanel r102 = this.f209391c;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r101, "searchContent");
            List<SegmentModel> r103 = com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.a.a(new db5.a(r101, new bo4.a[0], new j[0]));
            ar4.a r104 = r102.f209387p;
            r104.getClass();
            Intrinsics.checkNotNullParameter(r103, "text");
            ActionPayload r105 = new ActionPayload();
            r105.setAction("LinkAddRecordDirect");
            r105.setEditResult(r103);
            r104.a(r105);
            this.f209391c.hideKeyboard();
            this.f209391c.v("add");
        }
    }

    public static final class c implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkTableEditorPanel f209392a;

        public c(LinkTableEditorPanel r100) {
            this.f209392a = r100;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r100, boolean r101) {
            if (r101 == false) goto L5;
            this.f209392a.v("search");
            return;
        }
    }

    public static final class d implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkTableEditorPanel f209393a;

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public d(LinkTableEditorPanel r100) {
            this.f209393a = r100;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
            if (r100 == null) goto L5;
            String r104 = r100.toString();
            if (r104 == null) goto L5;
        L6:
            tt5.a.b("LinkTableEditorPanel", "onTextChanged, keyword = ".concat(r104));
            LinkTableEditorPanel r105 = this.f209393a;
            r105.getClass();
            Intrinsics.checkNotNullParameter(r104, "keyword");
            ar4.a r106 = r105.f209387p;
            r106.getClass();
            Intrinsics.checkNotNullParameter(r104, "keyword");
            r106.a(new SearchAction(null, "SearchLinkTable", r104));
            if (r100 != null) goto L9;
        L12:
            boolean r107 = true;
        L13:
            if (r107 == true) goto L15;
            this.f209393a.f209388q.f210661l.setText(r104);
            return;
        L15:
            LinkTableEditorPanel r108 = this.f209393a;
            r108.B(false, new View[]{r108.f209388q.f210651b});
            return;
        L9:
            if (r100.length() == 0) goto L12;
            r107 = false;
        L5:
            r104 = "";
            goto L6
        }
    }

    public static final class e extends CommonActionPanelLayout.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkTableEditorPanel f209394a;

        @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
        public final void c() {
            this.f209394a.dismiss();
            this.f209394a.v("confirm");
        }

        @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
        public final void a() {
            if (com.bytedance.ee.bear.bitable.c.o() == false) goto L6;
            this.f209394a.f209387p.d(true);
            return;
        }

        public e(LinkTableEditorPanel r100) {
            this.f209394a = r100;
        }
    }

    public static final class f extends CellEditDragView.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkTableEditorPanel f209395a;

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.CellEditDragView.c, com.bytedance.ee.bear.bitable.card.view.cell.CellEditDragView.b
        public final void W6() {
            this.f209395a.hideKeyboard();
        }

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.CellEditDragView.b
        public final void X6() {
            this.f209395a.dismiss();
        }

        public f(LinkTableEditorPanel r100) {
            this.f209395a = r100;
        }
    }

    public static final class g implements CellEditDragView.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkTableEditorPanel f209396a;

        public g(LinkTableEditorPanel r100) {
            this.f209396a = r100;
        }

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.CellEditDragView.a
        public final void a(int r100, int r101) {
            if (r101 >= r100) goto L7;
            LinkTableEditorPanel r102 = this.f209396a;
            if (r102.f486405i <= 0) goto L8;
            r102.hideKeyboard();
            return;
        L8:
            return;
        }
    }

    public static final class h {
    }

    public static final class i extends CharacterStyle {
        public i() {
        }

        @Override // android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            Intrinsics.checkNotNullParameter(r100, "tp");
            r100.setStyle(Paint.Style.FILL_AND_STROKE);
            r100.setStrokeWidth(1.0f);
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void f(boolean r100) {
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.BaseEditorPanel, hp4.g, com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void show() {
        this.f209388q.f210654e.m(false);
        super.show();
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.BaseEditorPanel, com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void destroy() {
        hideKeyboard();
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.BaseEditorPanel, hp4.g, up4.a
    public final void a(int r100) {
        this.f486405i = r100;
        if (r100 <= 0) goto L5;
        this.f209388q.f210654e.m(true);
        B(true, new View[]{this.f209388q.f210652c});
        return;
    L5:
        this.f209388q.f210664o.clearFocus();
    }

    @Override // hp4.g
    public final View q(Context r100) {
        return this.f486399c;
    }

    public LinkTableEditorPanel(hr4.a r100, ar4.a r101) {
        Intrinsics.checkNotNullParameter(r100, "mEditorContext");
        Intrinsics.checkNotNullParameter(r101, "mActionHandler");
        super(r100);
        this.f209387p = r101;
        BitableCardLinkTablePickerPanelBinding r102 = BitableCardLinkTablePickerPanelBinding.a(LayoutInflater.from(this.f486397a));
        this.f209388q = r102;
        this.f486399c = r102.f210650a;
        B(true, new View[]{r102.f210660k});
        B(false, new View[]{r102.f210661l});
        r102.f210652c.setOnClickListener(new a(this));
        r102.f210651b.setOnClickListener(new b(this));
        r102.f210664o.setOnFocusChangeListener(new c(this));
        r102.f210664o.addTextChangedListener(new d(this));
        CellEditDragView r103 = r102.f210654e;
        if (com.bytedance.ee.bear.bitable.c.o() == false) goto L5;
        r103.f(r103.getContext().getString(R.string.Bitable_Common_ButtonCancel), Integer.valueOf(R.color.text_title));
    L5:
        r103.h(r103.getContext().getString(R.string.Bitable_Common_ButtonDone), Integer.valueOf(R.color.primary_content_default));
        r103.setOnActionListener(new e(this));
        r103.setOnPositionChangeListener(new f(this));
        r103.setHeightChangedListener(new g(this));
        r102.f210660k.getGridView().getRecyclerView().addOnScrollListener(new AnonymousClass6(this));
        r102.f210664o.setText("");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A(LinkEditorModel r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "originData");
        List<? extends String> r102 = r100.getValue();
        if (r102 == null) goto L6;
        this.f209388q.f210660k.getGridView().getUpdateStrategy().m(r102);
        return;
    }

    public final void B(boolean r100, View... r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        View r104 = r101[r103];
        if (r100 == false) goto L7;
        int r105 = 0;
    L8:
        r104.setVisibility(r105);
        r103 = r103 + 1;
        goto L3
    L7:
        r105 = 8;
        goto L8
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void b(CommonEditorModel r110, String r111) {
        LinkEditorModel r112 = (LinkEditorModel) r110;
        Intrinsics.checkNotNullParameter(r112, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r111, "originData");
        BitableLinkTableUpdateData r100 = r112.getViewData();
        if (r100 == null) goto L27;
        BitableNativeViewData r101 = r100.getValue();
        if (r101 == null) goto L7;
        BaseViewData<?, ?> r102 = r101.getData();
    L9:
        if ((r102 instanceof GridViewData) == false) goto L11;
        GridViewData r103 = (GridViewData) r102;
    L12:
        if (r103 == null) goto L16;
        SimpleItemModel r104 = new SimpleItemModel();
        r104.setStyle("footerHide");
        r103.setFooter(r104);
        GridSetting r105 = r103.getSetting();
        if (r105 == null) goto L16;
        r105.setShowNoMarginDivider(true);
    L16:
        ar4.a r106 = this.f209387p;
        if (r106 == null) goto L19;
        m r107 = r106.f482819a;
    L20:
        Intrinsics.checkNotNullParameter(r100, "viewData");
        BitableNativeViewData r108 = r100.getValue();
        if (r108 == null) goto L27;
        ar4.a r109 = this.f209387p;
        if (r109 == null) goto L27;
        this.f209388q.f210660k.j(null, r108, r109, r107, true);
        SearchConfigIcon r113 = this.f209388q.f210663n;
        Icon r114 = r100.getSearchConfigIcon();
        gv4.d r115 = new gv4.d();
        r115.update(r107);
        Unit r116 = Unit.INSTANCE;
        r113.a(r114, r115);
        goto L27
    L19:
        r107 = null;
        goto L20
    L11:
        r103 = null;
        goto L12
    L7:
        r102 = null;
    L27:
        A(r112, r111);
        Integer r117 = r112.getStatus();
        if (r117 == null) goto L30;
        int r118 = r117.intValue();
    L31:
        String r119 = r112.getTitle();
        String r120 = "";
        if (r119 != null) goto L34;
        r119 = "";
    L34:
        SpannableStringBuilder r121 = new SpannableStringBuilder(r119);
        r121.setSpan(new i(), 0, r119.length(), 33);
        this.f209388q.f210654e.setTitle(r121);
        SimpleItemModel r122 = r112.getEmptyModel();
        if (r122 == null) goto L39;
        Icon r123 = r122.getIcon();
        if (r123 == null) goto L39;
        Integer r124 = r123.getImgRes(this.f486397a);
    L40:
        SimpleItemModel r125 = r112.getEmptyModel();
        if (r125 == null) goto L43;
        String r126 = r125.getText();
    L44:
        tt5.a.h("LinkTableEditorPanel", "updateLoadingState, " + r118);
        if (r118 != ViewStatus.LOADING.getValue()) goto L48;
        B(true, new View[]{this.f209388q.f210665p});
        BitableCardLinkTablePickerPanelBinding r127 = this.f209388q;
        B(false, new View[]{r127.f210651b, r127.f210655f});
        this.f209388q.f210666q.playAnimation();
    L62:
        Boolean r128 = r112.getAddable();
        if (r128 == null) goto L65;
        boolean r129 = r128.booleanValue();
    L66:
        Boolean r130 = r112.getShowAddRecordText();
        if (r130 == null) goto L69;
        boolean r131 = r130.booleanValue();
    L70:
        Boolean r132 = r112.getShowNoPermissionRecordTip();
        if (r132 == null) goto L73;
        boolean r133 = r132.booleanValue();
    L75:
        if (r118 != ViewStatus.LOADED.getValue()) goto L90;
        B(r133, new View[]{this.f209388q.f210662m});
        if (r129 == false) goto L80;
        this.f209388q.f210664o.setHint(R.string.Bitable_Relation_SearchOrAddRecord);
    L81:
        if (r129 == true) goto L83;
    L88:
        B(r131, new View[]{this.f209388q.f210661l});
        return;
    L83:
        if (this.f209388q.f210664o.getText().length() <= 0) goto L85;
        boolean r134 = true;
    L86:
        if (r134 == false) goto L88;
        tt5.a.h("LinkTableEditorPanel", "showAddNewRecordBtn");
        B(true, new View[]{this.f209388q.f210651b});
        goto L88
    L85:
        r134 = false;
        goto L86
    L80:
        this.f209388q.f210664o.setHint(R.string.Bitable_Relation_SearchRecord);
        goto L81
    L90:
        return;
    L73:
        r133 = false;
        goto L75
    L69:
        r131 = false;
        goto L70
    L65:
        r129 = false;
        goto L66
    L48:
        if (r118 != ViewStatus.SEARCHING.getValue()) goto L51;
        B(true, new View[]{this.f209388q.f210658i});
        BitableCardLinkTablePickerPanelBinding r135 = this.f209388q;
        B(false, new View[]{r135.f210657h, r135.f210655f});
        this.f209388q.f210659j.playAnimation();
        goto L62
    L51:
        if (r118 != ViewStatus.LOADED.getValue()) goto L54;
        this.f209388q.f210659j.cancelAnimation();
        this.f209388q.f210666q.cancelAnimation();
        BitableCardLinkTablePickerPanelBinding r136 = this.f209388q;
        B(false, new View[]{r136.f210658i, r136.f210665p, r136.f210655f});
        BitableCardLinkTablePickerPanelBinding r137 = this.f209388q;
        B(true, new View[]{r137.f210657h, r137.f210660k});
        goto L62
    L54:
        if (r118 != ViewStatus.ERROR.getValue()) goto L62;
        this.f209388q.f210659j.cancelAnimation();
        this.f209388q.f210666q.cancelAnimation();
        BitableCardLinkTablePickerPanelBinding r138 = this.f209388q;
        B(false, new View[]{r138.f210658i, r138.f210665p, r138.f210657h});
        B(true, new View[]{this.f209388q.f210655f});
        this.f209388q.f210654e.setTitle(null);
        SpaceEmptyState r139 = this.f209388q.f210656g;
        if (r124 == null) goto L58;
        r139.setImageRes(Integer.valueOf(r124.intValue()));
    L58:
        if (r126 == null) goto L61;
        r120 = r126;
    L61:
        r139.setDesc(r120);
        r139.setPrimaryText(null);
        goto L62
    L43:
        r126 = null;
    L39:
        r124 = null;
        goto L40
    L30:
        r118 = ViewStatus.LOADING.getValue();
        goto L31
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.BaseEditorPanel, com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final /* bridge */ /* synthetic */ void g(CommonEditorModel r100, String r101) {
        A((LinkEditorModel) r100, r101);
    }
}
