package com.bytedance.ee.bear.bitable.celleditor.editor.select;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.ColorBean;
import com.bytedance.ee.bear.bitable.card.view.cell.CellEditDragView;
import com.bytedance.ee.bear.bitable.card.view.cell.select.SelectTagView;
import com.bytedance.ee.bear.bitable.card.view.cell.select.SelectTextView;
import com.bytedance.ee.bear.bitable.card.view.cell.select.a0;
import com.bytedance.ee.bear.bitable.card.view.cell.select.q;
import com.bytedance.ee.bear.bitable.card.view.cell.select.t;
import com.bytedance.ee.bear.bitable.celleditor.bean.CommonEditorModel;
import com.bytedance.ee.bear.bitable.celleditor.bean.ViewStatus;
import com.bytedance.ee.bear.bitable.celleditor.editor.BaseEditorPanel;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.databinding.BitableCardSelectEditPanelBinding;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.bear.bitable.uikit.SearchAction;
import com.bytedance.ee.bear.bitable.uikit.empty.EmptyData;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.style.BaseTagSize;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.ee.bear.facade.common.widget.RoundFrameLayout;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.bear.widgets.panel.InterceptTouchRecyclerView;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.bytedance.ee.util.ui.n;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.suite.lark.emm.design.edittext.SCEditText;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class i extends BaseEditorPanel<SelectEditorModel> {
    public final List<String> A;
    public List<? extends ColorBean> B;
    public final boolean C;
    public a0 D;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final hr4.a f209474p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.celleditor.editor.select.e f209475q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final BitableCardSelectEditPanelBinding f209476r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public q f209477s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final SelectEditAdapter f209478t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final PreviewItemAdapter f209479u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f209480v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f209481w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f209482x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f209483y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Map<String, SelectEditorModel.IEditorOption> f209484z;

    public static final class a implements SelectEditAdapter.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f209485a;

        public a(i r100) {
            this.f209485a = r100;
        }

        @Override // com.bytedance.ee.bear.bitable.celleditor.editor.select.SelectEditAdapter.a
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "optionId");
            this.f209485a.f209475q.f(r100);
            q r101 = this.f209485a.f209477s;
            if (r101 == null) goto L6;
            r101.y2(BitableAnalytic.SelectSceneEvent.BITABLE_OPTION_FIELD_PANEL_CLICK, BitableAnalytic.SelectSceneClickType.SELECT_OPTION);
            return;
        }

        @Override // com.bytedance.ee.bear.bitable.celleditor.editor.select.SelectEditAdapter.a
        public final void b(SelectEditorModel.IEditorOption r110) {
            i r100 = this.f209485a;
            r100.getClass();
            if (r110 == null) goto L8;
            String r101 = r110.getName();
            if (r101 == null) goto L8;
            String r102 = r101;
        L9:
            if (r110 == null) goto L14;
            String r103 = r110.getTextColor();
            if (r103 == null) goto L14;
            String r104 = r103;
        L15:
            if (r110 == null) goto L20;
            String r105 = r110.getColor();
            if (r105 == null) goto L20;
            String r106 = r105;
        L21:
            Context r107 = r100.f486397a;
            if (r110 == null) goto L24;
            String r108 = r110.getBorderColor();
        L25:
            a0 r109 = new a0(r107, r102, r104, r106, r108);
            com.bytedance.ee.bear.bitable.celleditor.editor.select.j r111 = new com.bytedance.ee.bear.bitable.celleditor.editor.select.j(r100, r110);
            Intrinsics.checkNotNullParameter(r111, "listener");
            r109.f208119m = r111;
            r109.f486401e = new com.bytedance.ee.bear.bitable.celleditor.editor.select.k(r100);
            r109.f208120n = r100.f209477s;
            r109.f486406j = r100.f209474p.f486866h;
            boolean r112 = !r100.f209482x;
            RoundFrameLayout r113 = (RoundFrameLayout) r109.f486399c.findViewById(R.id.deleteItem);
            if (r112 == false) goto L28;
            int r114 = 8;
        L29:
            r113.setVisibility(r114);
            r109.show();
            r100.D = r109;
            q r115 = r100.f209477s;
            if (r115 == null) goto L33;
            r115.y2(BitableAnalytic.SelectSceneEvent.BITABLE_OPTION_FIELD_PANEL_CLICK, BitableAnalytic.SelectSceneClickType.OPTION_MORE);
            return;
        L33:
            return;
        L28:
            r114 = 0;
            goto L29
        L24:
            r108 = null;
        L20:
            r106 = "";
        L14:
            r104 = "";
        L8:
            r102 = "";
            goto L9
        }
    }

    public static final class b implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f209486a;

        public b(i r100) {
            this.f209486a = r100;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r100, boolean r101) {
            TextView r102 = this.f209486a.f209476r.f210672b;
            int r103 = 0;
            if (r101 == false) goto L5;
            int r104 = 0;
        L6:
            r102.setVisibility(r104);
            i r105 = this.f209486a;
            AppCompatImageView r106 = r105.f209476r.f210675e;
            if (r101 == false) goto L9;
        L11:
            r103 = 8;
        L12:
            r106.setVisibility(r103);
            if (r101 == false) goto L22;
            i r107 = this.f209486a;
            if (r107.f209480v == true) goto L24;
            r107.f209480v = true;
            q r108 = r107.f209477s;
            if (r108 == null) goto L19;
            r108.y2(BitableAnalytic.SelectSceneEvent.BITABLE_OPTION_FIELD_PANEL_CLICK, "search");
        L19:
            SCEditText r109 = r107.f209476r.f210689s;
            if (r109.hasFocus() == true) goto L25;
            r109.requestFocus();
            return;
        L25:
            return;
        L24:
            return;
        L22:
            this.f209486a.D();
            return;
        L9:
            if (r105.f209481w == false) goto L11;
        L5:
            r104 = 8;
            goto L6
        }
    }

    public static final class c implements PreviewItemAdapter.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f209487a;

        public c(i r100) {
            this.f209487a = r100;
        }

        @Override // com.bytedance.ee.bear.bitable.celleditor.editor.select.PreviewItemAdapter.a
        public final void a(String r100) {
            if (r100 == null) goto L7;
            i r101 = this.f209487a;
            r101.f209475q.f(r100);
            q r102 = r101.f209477s;
            if (r102 == null) goto L8;
            r102.y2(BitableAnalytic.SelectSceneEvent.BITABLE_OPTION_FIELD_PANEL_CLICK, BitableAnalytic.SelectSceneClickType.SELECT_OPTION);
            return;
        L8:
            return;
        }
    }

    public static final class d extends CommonActionPanelLayout.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f209488a;

        @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
        public final void a() {
            this.f209488a.f209475q.d(true);
        }

        @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
        public final void c() {
            this.f209488a.v("confirm");
            this.f209488a.dismiss();
        }

        public d(i r100) {
            this.f209488a = r100;
        }
    }

    public static final class e extends CellEditDragView.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f209489a;

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.CellEditDragView.b
        public final void X6() {
            this.f209489a.dismiss();
        }

        public e(i r100) {
            this.f209489a = r100;
        }
    }

    public static final class f implements CellEditDragView.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f209490a;

        public f(i r100) {
            this.f209490a = r100;
        }

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.CellEditDragView.a
        public final void a(int r100, int r101) {
            if (r101 >= r100) goto L6;
            i r102 = this.f209490a;
            if (r102.f486405i <= 0) goto L6;
            r102.hideKeyboard();
        L6:
            i r103 = this.f209490a;
            r103.p(r103.f209476r.f210680j);
        }
    }

    public static final class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f209491a;

        public g(i r100) {
            this.f209491a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            i.A(this.f209491a, null, true);
            this.f209491a.v("add");
        }
    }

    public static final class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f209492a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f209493b;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ i f209494a;

            public a(i r100) {
                this.f209494a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f209494a.f209476r.f210689s.setText("");     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public h(i r100, View r101) {
            this.f209492a = r100;
            this.f209493b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            com.bytedance.ee.bear.bitable.celleditor.editor.select.e r101 = this.f209492a.f209475q;
            r101.getClass();
            ActionPayload r102 = new ActionPayload();
            r102.setAction("SelectAddOption");
            r101.a(r102);
            this.f209493b.post(new a(this.f209492a));
            q r103 = this.f209492a.f209477s;
            if (r103 == null) goto L5;
            r103.y2(BitableAnalytic.SelectSceneEvent.BITABLE_OPTION_FIELD_PANEL_CLICK, BitableAnalytic.SelectSceneClickType.CREATE_OPTION);
        L5:
            this.f209492a.v("add");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.celleditor.editor.select.i$i, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC3016i implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f209495a;

        public ViewOnClickListenerC3016i(i r100) {
            this.f209495a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f209495a.D();
        }
    }

    public static final class j implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f209496a;

        public j(i r100) {
            this.f209496a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f209496a.f209476r.f210689s.setText("");
        }
    }

    public /* synthetic */ class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f209497a = null;

        static {
            int[] r100 = new int[ViewStatus.values().length];
            r100[ViewStatus.LOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[ViewStatus.SEARCHING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[ViewStatus.LOADED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[ViewStatus.ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f209497a = r100;
        }
    }

    public static final class l implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f209498a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public l(i r100) {
            this.f209498a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            if (r100 == null) goto L10;
            boolean r101 = true;
            if (r100.length() <= 0) goto L7;
            boolean r102 = true;
        L8:
            if (r102 != true) goto L10;
        L11:
            if (r101 == false) goto L13;
            this.f209498a.f209476r.f210673c.setVisibility(0);
        L14:
            com.bytedance.ee.bear.bitable.celleditor.editor.select.e r103 = this.f209498a.f209475q;
            String r104 = String.valueOf(r100);
            r103.getClass();
            Intrinsics.checkNotNullParameter(r104, "keyword");
            r103.a(new SearchAction(null, "SelectSearchOption", r104));
            return;
        L13:
            this.f209498a.f209476r.f210673c.setVisibility(8);
            goto L14
        L7:
            r102 = false;
        L10:
            r101 = false;
            goto L11
        }
    }

    public static final class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f209499a;

        public m(i r100) {
            this.f209499a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f209499a.f209476r.f210686p.scrollToPosition(0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void f(boolean r100) {
    }

    public final void D() {
        if (this.f209480v == false) goto L8;
        this.f209480v = false;
        SCEditText r100 = this.f209476r.f210689s;
        r100.clearFocus();
        if (TextUtils.isEmpty(r100.getText()) == true) goto L7;
        r100.setText("");
    L7:
        hideKeyboard();
    L8:
        v("search");
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.BaseEditorPanel, com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void destroy() {
        a0 r100 = this.D;
        if (r100 == null) goto L5;
        r100.dismiss();
    L5:
        D();
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.BaseEditorPanel, hp4.g, com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void show() {
        super.show();
        this.f209476r.f210679i.n();
        this.f209476r.f210686p.post(new m(this));
    }

    public final HashMap<String, SelectEditorModel.IEditorOption> B(Map<String, SelectEditorModel.IEditorOption> r100) {
        if (this.C == false) goto L5;
        HashMap<String, SelectEditorModel.IEditorOption> r101 = new HashMap();
        Iterator<Map.Entry<String, SelectEditorModel.IEditorOption>> r102 = r100.entrySet().iterator();
    L8:
        if (r102.hasNext() == false) goto L12;
        Map.Entry<String, SelectEditorModel.IEditorOption> r103 = r102.next();
        String r104 = r103.getKey();
        SelectEditorModel.IEditorOption r105 = C(r103.getValue());
        if (r105 == null) goto L8;
        r101.put(r104, r105);
        goto L8
    L12:
        return r101;
    L5:
        return new HashMap(r100);
    }

    public final SelectEditorModel.IEditorOption C(SelectEditorModel.IEditorOption r100) {
        ColorBean r101 = null;
        Object r102 = null;
        if (r100 != null) goto L6;
        return null;
    L6:
        if (this.C == false) goto L34;
        String r103 = r100.getBorderColor();
        if (r103 != null) goto L10;
    L13:
        boolean r104 = true;
    L14:
        if (r104 == false) goto L34;
        Integer r105 = r100.getColorId();
        if (r105 == null) goto L27;
        r105.intValue();
        Iterator<T> r106 = this.B.iterator();
    L20:
        if (r106.hasNext() == false) goto L24;
        Object r107 = r106.next();
        if (TextUtils.equals(((ColorBean) r107).getId(), r105.toString()) == false) goto L20;
        r102 = r107;
    L24:
        r101 = (ColorBean) r102;
        if (r101 != null) goto L27;
        r101 = (ColorBean) CollectionsKt.getOrNull(this.B, r105.intValue());
    L27:
        SelectEditorModel.IEditorOption r108 = new SelectEditorModel.IEditorOption();
        r108.setId(r100.getId());
        r108.setName(r100.getName());
        r108.setColorId(r100.getColorId());
        r108.setColor(r100.getColor());
        r108.setTextColor(r100.getTextColor());
        if (r101 == null) goto L31;
        String r109 = r101.getBorderColor();
        if (r109 == null) goto L31;
    L32:
        r108.setBorderColor(r109);
        r108.setIconColor(r100.getIconColor());
        return r108;
    L31:
        r109 = r100.getBorderColor();
        goto L32
    L10:
        if (r103.length() == 0) goto L13;
        r104 = false;
    L34:
        return r100;
    }

    public final void E(SelectEditorModel r100) {
        HashMap<String, SelectEditorModel.IEditorOption> r101 = B(r100.getOptionDataMap());
        PreviewItemAdapter r102 = this.f209479u;
        List<? extends String> r103 = r100.getValue();
        if (r103 != null) goto L5;
        r103 = CollectionsKt.emptyList();
    L5:
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "selectOptionIds");
        Intrinsics.checkNotNullParameter(r101, "optionItemMap");
        ((ArrayList) r102.f209442a).clear();
        ArrayList r104 = (ArrayList) r102.f209442a;
        r104.addAll(r103);
        ((LinkedHashMap) r102.f209443b).clear();
        r102.f209443b.putAll(r101);
        this.f209479u.notifyDataSetChanged();
        SelectEditAdapter r105 = this.f209478t;
        List<String> r106 = r100.getOptionList();
        List<? extends String> r107 = r100.getValue();
        ((ArrayList) r105.f209448a).clear();
        ((ArrayList) r105.f209448a).addAll(r106);
        ((ArrayList) r105.f209450c).clear();
        if (hu5.a.d(r107) == true) goto L8;
        ((ArrayList) r105.f209450c).addAll(r107);
    L8:
        ((HashMap) r105.f209449b).clear();
        ((HashMap) r105.f209449b).putAll(r101);
        SelectEditAdapter r108 = this.f209478t;
        r108.f209452e = r100.getEnableMultiSelect();
        this.f209478t.notifyDataSetChanged();
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.BaseEditorPanel, hp4.g, up4.a
    public final void a(int r100) {
        this.f486405i = r100;
        if (r100 <= 0) goto L8;
        if (this.f209480v == false) goto L12;
        this.f209476r.f210679i.m(true);
    L12:
        p(this.f209476r.f210680j);
        return;
    L8:
        if (this.f209480v == false) goto L12;
        if (TextUtils.isEmpty(this.f209476r.f210689s.getText()) == false) goto L12;
        D();
        goto L12
    }

    @Override // hp4.g
    public final View q(Context r100) {
        return this.f486399c;
    }

    public i(hr4.a r100, com.bytedance.ee.bear.bitable.celleditor.editor.select.e r101) {
        Intrinsics.checkNotNullParameter(r100, "mEditorContext");
        Intrinsics.checkNotNullParameter(r101, "mActionHandler");
        super(r100);
        this.f209474p = r100;
        this.f209475q = r101;
        BitableCardSelectEditPanelBinding r102 = BitableCardSelectEditPanelBinding.a(LayoutInflater.from(this.f486397a));
        this.f209476r = r102;
        this.f209484z = new LinkedHashMap();
        this.A = new ArrayList();
        this.B = CollectionsKt.emptyList();
        boolean r103 = com.bytedance.ee.bear.bitable.c.B();
        this.C = r103;
        FrameLayout r104 = r102.f210671a;
        this.f486399c = r104;
        if (r103 == false) goto L5;
        SelectEditAdapter r105 = new SelectEditAdapterV2();
    L6:
        r105.setHasStableIds(true);
        r105.f209453f = new a(this);
        this.f209478t = r105;
        InterceptTouchRecyclerView r106 = r102.f210686p;
        r106.setSceneTag("select_edit_panel_rv");
        r106.setHasFixedSize(true);
        r106.setLayoutManager(new LinearLayoutManager(r106.getContext()));
        r106.setAdapter(r105);
        com.bytedance.ee.bear.bitable.m.s(r102.f210677g, n.c(16.0f), false);
        com.bytedance.ee.bear.bitable.m.s(r102.f210678h, n.c(16.0f), false);
        RecyclerView r107 = r102.f210685o;
        r107.setLayoutManager(new LinearLayoutManager(r107.getContext(), 0, false));
        if (r103 == false) goto L9;
        PreviewItemAdapter r108 = new PreviewItemAdapter.V2();
    L10:
        this.f209479u = r108;
        c r109 = new c(this);
        Intrinsics.checkNotNullParameter(r109, "actionListener");
        r108.f209444c = r109;
        r107.setAdapter(r108);
        CellEditDragView r110 = r102.f210679i;
        r110.setDividerVisible(false);
        r110.setTitleBarVisible(true);
        if (com.bytedance.ee.bear.bitable.c.o() == false) goto L13;
        r110.f(r110.getContext().getString(R.string.Bitable_Common_ButtonCancel), Integer.valueOf(R.color.text_title));
    L13:
        r110.h(r110.getContext().getString(R.string.Bitable_Common_ButtonDone), Integer.valueOf(R.color.primary_content_default));
        r110.setOnActionListener(new d(this));
        r110.setOnPositionChangeListener(new e(this));
        r110.setSlideView(r102.f210688r);
        r110.setSlideView(r102.f210680j);
        r110.k(r102.f210686p);
        r110.setHeightChangedListener(new f(this));
        r102.f210675e.setOnClickListener(new g(this));
        r102.f210676f.setOnClickListener(new h(this, r104));
        r102.f210672b.setVisibility(8);
        r102.f210672b.setOnClickListener(new ViewOnClickListenerC3016i(this));
        r102.f210673c.setOnClickListener(new j(this));
        r102.f210689s.addTextChangedListener(new l(this));
        r102.f210689s.setOnFocusChangeListener(new b(this));
        return;
    L9:
        r108 = new PreviewItemAdapter();
        goto L10
    L5:
        r105 = new SelectEditAdapter();
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void b(CommonEditorModel r100, String r110) {
        SelectEditorModel r101 = (SelectEditorModel) r100;
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r110, "originData");
        this.f209481w = r101.getCanEditOption();
        this.f209482x = r101.getShouldShowDelete();
        ((ArrayList) this.A).clear();
        List<ColorBean> r111 = r101.getColorList();
        if (r111 != null) goto L5;
        r111 = CollectionsKt.emptyList();
    L5:
        this.B = r111;
        ((LinkedHashMap) this.f209484z).clear();
        this.f209484z.putAll(B(r101.getOptionDataMap()));
        Integer r112 = r101.getRandomColorId();
        int r102 = 0;
        if (r112 == null) goto L8;
        int r113 = r112.intValue();
    L9:
        this.f209483y = r113;
        List<? extends String> r114 = r101.getValue();
        if (r114 == null) goto L12;
        ((ArrayList) this.A).addAll(r114);
    L12:
        boolean r115 = r101.getCanEditOption();
        boolean r103 = r101.getShouldShowMoreIcon();
        SCEditText r104 = this.f209476r.f210689s;
        Resources r105 = this.f486399c.getResources();
        if (r115 == false) goto L15;
        int r106 = R.string.Bitable_Option_SearchOrCreate;
    L16:
        r104.setHint(r105.getString(r106));
        BitableCardSelectEditPanelBinding r107 = this.f209476r;
        AppCompatImageView r108 = r107.f210675e;
        if (r107.f210689s.isFocused() == true) goto L20;
        if (r115 == false) goto L20;
        int r109 = 0;
    L21:
        r108.setVisibility(r109);
        SelectEditAdapter r116 = this.f209478t;
        boolean r117 = true;
        if (r115 == false) goto L25;
        if (r103 == false) goto L25;
        boolean r118 = true;
    L26:
        r116.f209451d = r118;
        r116.f209452e = true;
        if (r101.getEnableSelectPreviewShow() == false) goto L29;
        this.f209476r.f210685o.setVisibility(0);
        this.f209476r.f210678h.setVisibility(0);
    L30:
        SelectEditorModel.IEditorOption r119 = C(r101.getAddOrEditOption());
        if (r119 == null) goto L36;
        this.f209476r.f210676f.setVisibility(0);
        if (this.C == false) goto L35;
        this.f209476r.f210683m.setVisibility(8);
        this.f209476r.f210684n.setVisibility(0);
        SelectTagView r120 = this.f209476r.f210684n;
        r120.V1 = false;
        r120.U(BaseTagSize.LARGE);
        this.f209476r.f210684n.setData(r119.toOptionEntity());
        this.f209476r.f210684n.S(r119.getBorderColor());
    L37:
        E(r101);
        ViewStatus.a r121 = ViewStatus.Companion;
        Integer r122 = r101.getStatus();
        r121.getClass();
        if (r122 != null) goto L41;
    L43:
        if (r122 != null) goto L46;
    L48:
        if (r122 != null) goto L51;
    L53:
        if (r122 != null) goto L56;
    L58:
        ViewStatus r123 = ViewStatus.NONE;
    L59:
        EmptyData r124 = r101.getEmpty();
        int r125 = k.f209497a[r123.ordinal()];
        if (r125 == 1) goto L101;
        if (r125 == 2) goto L100;
        String r126 = null;
        if (r125 == 3) goto L79;
        if (r125 != 4) goto L102;
        this.f209476r.f210682l.setVisibility(8);
        this.f209476r.f210686p.setVisibility(8);
        this.f209476r.f210688r.setVisibility(8);
        this.f209476r.f210680j.setVisibility(0);
        if (r124 == null) goto L102;
        SpaceEmptyState r127 = this.f209476r.f210680j;
        Icon r128 = r124.getIcon();
        if (r128 == null) goto L71;
        Integer r129 = r128.getImgRes(r127.getContext());
    L72:
        r127.setImageRes(r129);
        String r130 = r124.getText();
        if (r130 != null) goto L75;
        r130 = "";
    L75:
        r127.setDesc(r130);
        SimpleItemModel r131 = r124.getButton();
        if (r131 == null) goto L78;
        r126 = r131.getText();
    L78:
        r127.setPrimaryText(r126);
        r127.setPrimaryClickListener(new com.bytedance.ee.bear.bitable.celleditor.editor.select.m(r124, this));
        goto L102
    L71:
        r129 = null;
    L102:
        this.f209476r.f210679i.setTitle(r101.getTitle());
        return;
    L79:
        if (r124 != null) goto L82;
        r117 = false;
    L82:
        this.f209476r.f210682l.setVisibility(8);
        this.f209476r.f210688r.setVisibility(0);
        InterceptTouchRecyclerView r132 = this.f209476r.f210686p;
        if (r117 == false) goto L85;
        int r133 = 8;
    L86:
        r132.setVisibility(r133);
        SpaceEmptyState r134 = this.f209476r.f210680j;
        if (r117 == true) goto L90;
        r102 = 8;
    L90:
        r134.setVisibility(r102);
        SpaceEmptyState r135 = this.f209476r.f210680j;
        if (r124 == null) goto L95;
        Icon r136 = r124.getIcon();
        if (r136 == null) goto L95;
        Integer r137 = r136.getImgRes(this.f486397a);
    L96:
        r135.setImageRes(r137);
        SpaceEmptyState r138 = this.f209476r.f210680j;
        if (r124 == null) goto L99;
        r126 = r124.getText();
    L99:
        r138.setDesc(r126);
        p(this.f209476r.f210680j);
    L95:
        r137 = null;
        goto L96
    L85:
        r133 = 0;
        goto L86
    L100:
        this.f209476r.f210680j.setVisibility(8);
        this.f209476r.f210686p.setVisibility(8);
        this.f209476r.f210688r.setVisibility(0);
        this.f209476r.f210682l.setVisibility(0);
        this.f209476r.f210681k.playAnimation();
        goto L102
    L101:
        this.f209476r.f210680j.setVisibility(8);
        this.f209476r.f210686p.setVisibility(8);
        this.f209476r.f210688r.setVisibility(8);
        this.f209476r.f210682l.setVisibility(0);
        this.f209476r.f210681k.playAnimation();
        goto L102
    L56:
        if (r122.intValue() != 4) goto L58;
        r123 = ViewStatus.ERROR;
        goto L59
    L51:
        if (r122.intValue() != 3) goto L53;
        r123 = ViewStatus.LOADED;
        goto L59
    L46:
        if (r122.intValue() != 2) goto L48;
        r123 = ViewStatus.SEARCHING;
        goto L59
    L41:
        if (r122.intValue() != 1) goto L43;
        r123 = ViewStatus.LOADING;
        goto L59
    L35:
        this.f209476r.f210683m.setVisibility(0);
        this.f209476r.f210684n.setVisibility(8);
        SelectTextView r139 = this.f209476r.f210683m;
        r139.V1 = false;
        r139.setText(r119.getName());
        this.f209476r.f210683m.Q(r119.getColor(), r119.getTextColor());
        goto L37
    L36:
        this.f209476r.f210676f.setVisibility(8);
        this.f209476r.f210683m.setVisibility(0);
        this.f209476r.f210684n.setVisibility(8);
        goto L37
    L29:
        this.f209476r.f210685o.setVisibility(8);
        this.f209476r.f210678h.setVisibility(8);
    L25:
        r118 = false;
    L20:
        r109 = 8;
        goto L21
    L15:
        r106 = R.string.Bitable_Option_Search;
        goto L16
    L8:
        r113 = 0;
        goto L9
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.BaseEditorPanel, com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void g(CommonEditorModel r100, String r101) {
        SelectEditorModel r102 = (SelectEditorModel) r100;
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "originData");
        E(r102);
    }

    public static final void A(i r100, String r101, boolean r102) {
        String r103 = null;
        if (r102 == false) goto L5;
        String r104 = r100.getContext().getResources().getString(R.string.Bitable_Option_CreateTitle);
        int r105 = r100.f209483y;
    L14:
        t r106 = new t(r100.f486397a, (ColorBean[]) r100.B.toArray(new ColorBean[0]), r105);
        r106.D(r104);
        r106.A(r103);
        com.bytedance.ee.bear.bitable.celleditor.editor.select.l r107 = new com.bytedance.ee.bear.bitable.celleditor.editor.select.l(r100, r101, r102);
        Intrinsics.checkNotNullParameter(r107, "listener");
        r106.f208177o = r107;
        r106.f208179q = r100.f209477s;
        r106.f486406j = r100.f209474p.f486866h;
        r106.show();
        if (r102 == false) goto L20;
        q r108 = r100.f209477s;
        if (r108 == null) goto L21;
        r108.y2(BitableAnalytic.SelectSceneEvent.BITABLE_OPTION_FIELD_PANEL_CLICK, "add");
        return;
    L21:
        return;
    L20:
        return;
    L5:
        r104 = r100.getContext().getResources().getString(R.string.Bitable_Option_Modify);
        SelectEditorModel.IEditorOption r109 = (SelectEditorModel.IEditorOption) ((LinkedHashMap) r100.f209484z).get(r101);
        if (r109 == null) goto L10;
        Integer r110 = r109.getColorId();
        if (r110 == null) goto L10;
        r105 = r110.intValue();
    L11:
        SelectEditorModel.IEditorOption r111 = (SelectEditorModel.IEditorOption) ((LinkedHashMap) r100.f209484z).get(r101);
        if (r111 == null) goto L14;
        r103 = r111.getName();
    L10:
        r105 = 0;
        goto L11
    }
}
