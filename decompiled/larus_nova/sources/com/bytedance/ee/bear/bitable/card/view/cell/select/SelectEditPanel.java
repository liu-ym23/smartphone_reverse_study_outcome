package com.bytedance.ee.bear.bitable.card.view.cell.select;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.card.model.enums.EItemViewSceneType;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.ColorBean;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.CommonActionType;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.RandomColorResult;
import com.bytedance.ee.bear.bitable.card.view.cell.CellEditDragView;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.databinding.BitableCardSelectEditPanelBinding;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.style.BaseTagSize;
import com.bytedance.ee.bear.facade.common.widget.RoundFrameLayout;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.bear.widgets.panel.InterceptTouchRecyclerView;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.emm.design.edittext.SCEditText;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public class SelectEditPanel extends hp4.g implements SelectEditAdapter.a {
    public int A;
    public Disposable B;
    public q C;
    public State D;
    public final c E;
    public c F;
    public final BitableCardSelectEditPanelBinding G;
    public boolean H;
    public final boolean I;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f208074m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ColorBean[] f208075n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f208076o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public gp4.h f208077p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public com.bytedance.ee.bear.bitable.card.model.stmodel.field.a f208078q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f208079r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public List<String> f208080s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f208081t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public SelectEditAdapter f208082u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f208083v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f208084w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public t f208085x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public a0 f208086y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public b f208087z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/select/SelectEditPanel$State;", "", "<init>", "(Ljava/lang/String;I)V", "LOADING", "LOADINGFINISH", "LOADINGERROR", "NOSTATE", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum State extends Enum<State> {
        public static final State LOADING = null;
        public static final State LOADINGERROR = null;
        public static final State LOADINGFINISH = null;
        public static final State NOSTATE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f208088a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f208089b = null;

        public static EnumEntries<State> getEntries() {
            return f208089b;
        }

        static {
            State r100 = new State("LOADING", 0);
            LOADING = r100;
            State r101 = new State("LOADINGFINISH", 1);
            LOADINGFINISH = r101;
            State r102 = new State("LOADINGERROR", 2);
            LOADINGERROR = r102;
            State r103 = new State("NOSTATE", 3);
            NOSTATE = r103;
            State[] r104 = {r100, r101, r102, r103};
            f208088a = r104;
            f208089b = EnumEntriesKt.enumEntries(r104);
        }

        public static State[] values() {
            return (State[]) f208088a.clone();
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public interface b {
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f208090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f208091b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f208092c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public View.OnClickListener f208093d;

        public c(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "errorInfo");
            this.f208090a = r100;
            this.f208091b = r101;
        }
    }

    public static final class d implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SelectEditPanel f208094a;

        public d(SelectEditPanel r100) {
            this.f208094a = r100;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r100, boolean r101) {
            TextView r102 = this.f208094a.G.f210672b;
            int r103 = 0;
            if (r101 == false) goto L5;
            int r104 = 0;
        L6:
            r102.setVisibility(r104);
            SelectEditPanel r105 = this.f208094a;
            AppCompatImageView r106 = r105.G.f210675e;
            if (r101 == false) goto L9;
        L11:
            r103 = 8;
        L12:
            r106.setVisibility(r103);
            if (r101 == false) goto L23;
            SelectEditPanel r107 = this.f208094a;
            if (r107.f208084w == true) goto L25;
            r107.f208084w = true;
            SCEditText r108 = r107.G.f210689s;
            if (r108.hasFocus() == true) goto L19;
            r108.requestFocus();
        L19:
            q r109 = r107.C;
            if (r109 == null) goto L22;
            r109.y2(BitableAnalytic.SelectSceneEvent.BITABLE_OPTION_FIELD_PANEL_CLICK, "search");
        L22:
            r107.v("search");
            return;
        L25:
            return;
        L23:
            this.f208094a.y();
            return;
        L9:
            if (r105.f208074m == false) goto L11;
        L5:
            r104 = 8;
            goto L6
        }
    }

    public static final class e extends CommonActionPanelLayout.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SelectEditPanel f208095a;

        @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
        public final void a() {
            SelectEditPanel r100 = this.f208095a;
            if (r100.f208081t == true) goto L9;
            hp4.g.b r101 = r100.f486402f;
            if (r101 == null) goto L7;
            r101.c(null);
        L7:
            r100.dismiss();
            return;
        }

        @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
        public final void c() {
            SelectEditPanel r100 = this.f208095a;
            r100.dismiss();
            r100.v("confirm");
        }

        public e(SelectEditPanel r100) {
            this.f208095a = r100;
        }
    }

    public static final class f implements CellEditDragView.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SelectEditPanel f208096a;

        public f(SelectEditPanel r100) {
            this.f208096a = r100;
        }

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.CellEditDragView.a
        public final void a(int r100, int r101) {
            if (r101 >= r100) goto L6;
            SelectEditPanel r102 = this.f208096a;
            if (r102.f486405i <= 0) goto L6;
            r102.hideKeyboard();
        L6:
            SelectEditPanel r103 = this.f208096a;
            r103.p(r103.G.f210680j);
        }
    }

    public static final class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SelectEditPanel f208097a;

        public g(SelectEditPanel r100) {
            this.f208097a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            SelectEditPanel r101 = this.f208097a;
            r101.getClass();
            t r102 = new t(r101.f486397a, r101.f208075n, r101.A);
            r102.D(r101.getContext().getResources().getString(R.string.Bitable_Option_CreateTitle));
            n0 r103 = new n0(r101);
            Intrinsics.checkNotNullParameter(r103, "listener");
            r102.f208177o = r103;
            r102.f208179q = r101.C;
            gp4.h r104 = r101.f208077p;
            if (r104 == null) goto L5;
            mr4.a r105 = r104.o();
        L6:
            r102.f486406j = r105;
            r102.show();
            r101.f208085x = r102;
            q r106 = r101.C;
            if (r106 == null) goto L9;
            r106.y2(BitableAnalytic.SelectSceneEvent.BITABLE_OPTION_FIELD_PANEL_CLICK, "add");
        L9:
            this.f208097a.v("add");
            return;
        L5:
            r105 = null;
            goto L6
        }
    }

    public static final class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SelectEditPanel f208098a;

        public h(SelectEditPanel r100) {
            this.f208098a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            SelectEditPanel r101 = this.f208098a;
            SelectEditPanel.w(r101, String.valueOf(r101.G.f210683m.getText()), this.f208098a.A, true);
            q r102 = this.f208098a.C;
            if (r102 == null) goto L5;
            r102.y2(BitableAnalytic.SelectSceneEvent.BITABLE_OPTION_FIELD_PANEL_CLICK, BitableAnalytic.SelectSceneClickType.CREATE_OPTION);
        L5:
            this.f208098a.v("add");
        }
    }

    public static final class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SelectEditPanel f208099a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f208100b;

        public i(SelectEditPanel r100, int r101) {
            this.f208099a = r100;
            this.f208100b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f208099a.G.f210686p.scrollToPosition(this.f208100b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void A() {
        View r100 = this.f486399c;
        SCEditText r101 = this.G.f210689s;
        Resources r102 = r100.getResources();
        if (this.f208074m == false) goto L5;
        int r103 = R.string.Bitable_Option_SearchOrCreate;
    L6:
        r101.setHint(r102.getString(r103));
        BitableCardSelectEditPanelBinding r104 = this.G;
        AppCompatImageView r105 = r104.f210675e;
        if (r104.f210689s.isFocused() == false) goto L9;
    L11:
        int r106 = 8;
    L12:
        r105.setVisibility(r106);
        return;
    L9:
        if (this.f208074m == false) goto L11;
        r106 = 0;
        goto L12
    L5:
        r103 = R.string.Bitable_Option_Search;
        goto L6
    }

    public final void B() {
        if (this.G.f210689s.getOnFocusChangeListener() == null) goto L6;
        tt5.a.h("SelectEditPanel", "setOnFocusChangeListener has listener");
        return;
    L6:
        this.G.f210689s.setOnFocusChangeListener(new d(this));
    }

    public void C() {
        if (this.I == false) goto L5;
        SelectEditAdapter r100 = new SelectEditAdapterV2();
    L7:
        if (this.f208074m == false) goto L16;
        gp4.h r101 = this.f208077p;
        if (r101 != null) goto L11;
    L13:
        boolean r102 = false;
    L14:
        if (r102 == true) goto L16;
        r100.f208065e = this.f208074m;
        goto L16
    L11:
        if (r101.N() != true) goto L13;
        r102 = true;
    L16:
        r100.setHasStableIds(true);
        r100.f208067g = this;
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f208082u = r100;
        InterceptTouchRecyclerView r103 = this.G.f210686p;
        r103.setSceneTag("select_edit_panel_rv");
        r103.setHasFixedSize(true);
        r103.setLayoutManager(new LinearLayoutManager(r103.getContext()));
        r103.setAdapter(z());
        CellEditDragView r104 = this.G.f210679i;
        r104.setTitleBarVisible(this.f208076o);
        if (this.f208076o == false) goto L19;
        r104.f(r104.getContext().getString(R.string.Doc_Block_Clear), Integer.valueOf(R.color.text_title));
        r104.setLeftTextVisible(false);
        r104.h(r104.getContext().getString(R.string.Bitable_Common_ButtonDone), Integer.valueOf(R.color.primary_content_default));
        r104.setOnActionListener(new e(this));
    L19:
        r104.setSlideView(this.G.f210688r);
        r104.setSlideView(this.G.f210680j);
        r104.k(this.G.f210686p);
        r104.setHeightChangedListener(new f(this));
        r104.setDividerVisible(false);
        this.G.f210672b.setVisibility(8);
        this.G.f210675e.setOnClickListener(new g(this));
        this.G.f210676f.setOnClickListener(new h(this));
        A();
        if (this.I == false) goto L24;
        this.G.f210683m.setVisibility(8);
        SelectTagView r105 = this.G.f210684n;
        r105.setVisibility(0);
        r105.V1 = false;
        r105.U(BaseTagSize.LARGE);
        return;
    L24:
        return;
    L5:
        r100 = new SelectEditAdapter();
        goto L7
    }

    public final void J() {
        State r100 = this.D;
        int r101 = 0;
        if (r100 != State.LOADING) goto L6;
        this.G.f210680j.setVisibility(8);
        this.G.f210686p.setVisibility(8);
        this.G.f210688r.setVisibility(8);
        this.G.f210682l.setVisibility(0);
        this.G.f210681k.playAnimation();
        return;
    L6:
        if (r100 != State.LOADINGFINISH) goto L49;
        com.bytedance.ee.bear.bitable.card.model.stmodel.field.a r102 = this.f208078q;
        boolean r103 = true;
        if (r102 == null) goto L18;
        List<com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a> r104 = r102.f207138n;
        if (r104 == null) goto L18;
        if (r104.isEmpty() != true) goto L14;
        boolean r105 = true;
    L15:
        if (r105 == true) goto L18;
        r103 = false;
        goto L18
    L14:
        r105 = false;
    L18:
        View r106 = this.f486399c;
        this.G.f210682l.setVisibility(8);
        RelativeLayout r107 = this.G.f210688r;
        if (r103 == true) goto L21;
    L23:
        int r108 = 0;
    L24:
        r107.setVisibility(r108);
        InterceptTouchRecyclerView r109 = this.G.f210686p;
        if (r103 == false) goto L27;
        int r110 = 8;
    L28:
        r109.setVisibility(r110);
        SpaceEmptyState r111 = this.G.f210680j;
        if (r103 == true) goto L32;
        r101 = 8;
    L32:
        r111.setVisibility(r101);
        this.G.f210680j.setImageRes(Integer.valueOf(R.drawable.ccm_empty_neutral_no_content));
        this.G.f210680j.setDesc(r106.getResources().getString(R.string.Bitable_Mobile_CannotEditOption));
        p(this.G.f210680j);
        if (this.f208084w == false) goto L38;
        if (TextUtils.isEmpty(this.G.f210689s.getText()) == true) goto L38;
        z().B2(this.G.f210689s.getText().toString());
    L38:
        if (this.f208074m == true) goto L40;
        return;
    L40:
        if (this.G.f210676f.getVisibility() != 8) goto L54;
        b r112 = this.f208087z;
        if (r112 == null) goto L46;
        BaseSelectCellViewHolder r113 = ((BaseSelectCellViewHolder.c) r112).f208047a;
        Single r114 = r113.K.fetchCommonData(CommonActionType.GET_RANDOM_COLOR, mu5.b.a(r113.Z4()), RandomColorResult.class);
        if (r114 == null) goto L46;
        Disposable r115 = r114.subscribe(new h0(this), i0.f208139a);
    L47:
        this.B = r115;
        return;
    L46:
        r115 = null;
        goto L47
    L54:
        return;
    L27:
        r110 = 0;
        goto L28
    L21:
        if (this.f208074m == true) goto L23;
        r108 = 8;
        goto L24
    L49:
        if (r100 != State.LOADINGERROR) goto L56;
        this.G.f210682l.setVisibility(8);
        this.G.f210686p.setVisibility(8);
        this.G.f210688r.setVisibility(8);
        this.G.f210680j.setVisibility(0);
        c r116 = this.F;
        this.G.f210680j.setImageRes(Integer.valueOf(r116.f208090a));
        this.G.f210680j.setDesc(r116.f208091b);
        this.G.f210680j.setPrimaryText(r116.f208092c);
        this.G.f210680j.setPrimaryClickListener(r116.f208093d);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.SelectEditAdapter.a
    public final void k() {
        v("select");
    }

    public final void y() {
        if (this.f208084w == false) goto L9;
        this.f208084w = false;
        SCEditText r100 = this.G.f210689s;
        r100.clearFocus();
        if (TextUtils.isEmpty(r100.getText()) == true) goto L7;
        r100.setText("");
    L7:
        hideKeyboard();
        return;
    }

    public final SelectEditAdapter z() {
        SelectEditAdapter r100 = this.f208082u;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("selectEditAdapter");
        return null;
    }

    @Override // hp4.g
    public final void dismiss() {
        super.dismiss();
        y();
        int r100 = com.bytedance.ee.bear.bitable.c.f207079a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.fix_itemview_oom") == false) goto L9;
        BitableCardSelectEditPanelBinding r101 = this.G;
        if (r101 == null) goto L9;
        SCEditText r102 = r101.f210689s;
        if (r102 == null) goto L9;
        r102.setOnFocusChangeListener(null);
    L9:
        Disposable r103 = this.B;
        if (r103 == null) goto L12;
        r103.dispose();
    L12:
        t r104 = this.f208085x;
        if (r104 == null) goto L15;
        r104.dismiss();
    L15:
        a0 r105 = this.f208086y;
        if (r105 == null) goto L19;
        r105.dismiss();
        return;
    }

    @Override // hp4.g, com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void show() {
        super.show();
        this.G.f210679i.n();
        E(this.f208083v);
        q r100 = this.C;
        if (r100 == null) goto L5;
        r100.J0(BitableAnalytic.SelectSceneEvent.BITABLE_OPTION_FIELD_PANEL_VIEW);
    L5:
        B();
    }

    public final void D(int r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put(BitableAnalytic.EditParamKey.BITABLE_EDIT_SEARCH, String.valueOf(!TextUtils.isEmpty(this.G.f210689s.getText())));
        r101.put(BitableAnalytic.EditParamKey.IS_EDIT_PANEL_OPEN, String.valueOf(this.f208081t));
        r101.put(BitableAnalytic.EditParamKey.CELL_ITEM_CHANGE, String.valueOf(r100));
        this.f486402f.d(r101, null);
    }

    public void E(int r100) {
        this.G.f210686p.post(new i(this, r100));
    }

    public final void F(boolean r100) {
        if (r100 == false) goto L4;
        this.G.f210676f.setVisibility(0);
        return;
    L4:
        this.G.f210676f.setVisibility(8);
    }

    public final void I(boolean r100) {
        this.f208074m = r100;
        A();
        if (r100 == false) goto L12;
        gp4.h r101 = this.f208077p;
        if (r101 == null) goto L9;
        boolean r102 = true;
        if (r101.N() != true) goto L9;
    L10:
        if (r102 == true) goto L12;
        z().f208065e = r100;
    L9:
        r102 = false;
    L12:
        z().notifyDataSetChanged();
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.SelectEditAdapter.a
    public final void e(SelectEditAdapter.b r100) {
        Intrinsics.checkNotNullParameter(r100, "optionEntity");
        a0 r101 = new a0(this.f486397a, r100.f207142b, r100.f207145e, r100.f207144d, r100.f207146f);
        m0 r102 = new m0(this, r100);
        Intrinsics.checkNotNullParameter(r102, "listener");
        r101.f208119m = r102;
        r101.f208120n = this.C;
        gp4.h r103 = this.f208077p;
        EItemViewSceneType r104 = null;
        if (r103 == null) goto L5;
        mr4.a r105 = r103.o();
    L6:
        r101.f486406j = r105;
        int r106 = com.bytedance.ee.bear.bitable.n.f214744a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.mobile.bitable.option_delete_fix.enable") == false) goto L31;
        gp4.h r107 = this.f208077p;
        if (r107 == null) goto L11;
        EItemViewSceneType r108 = r107.t();
    L12:
        boolean r109 = true;
        int r110 = 0;
        if (r108 == EItemViewSceneType.FAST_ADD_RECORD) goto L21;
        gp4.h r111 = this.f208077p;
        if (r111 == null) goto L18;
        r104 = r111.t();
    L18:
        if (r104 == EItemViewSceneType.SUBMIT_MODE) goto L21;
        boolean r112 = false;
    L22:
        if (r112 == false) goto L24;
    L27:
        RoundFrameLayout r113 = (RoundFrameLayout) r101.f486399c.findViewById(R.id.deleteItem);
        if (r109 == false) goto L30;
        r110 = 8;
    L30:
        r113.setVisibility(r110);
        goto L31
    L24:
        if (this.H == true) goto L27;
        r109 = false;
    L21:
        r112 = true;
        goto L22
    L11:
        r108 = null;
    L31:
        r101.show();
        this.f208086y = r101;
        q r114 = this.C;
        if (r114 == null) goto L35;
        r114.y2(BitableAnalytic.SelectSceneEvent.BITABLE_OPTION_FIELD_PANEL_CLICK, BitableAnalytic.SelectSceneClickType.OPTION_MORE);
        return;
    L35:
        return;
    L5:
        r105 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.SelectEditAdapter.a
    public final void j(boolean r100) {
        View r101 = this.f486399c;
        InterceptTouchRecyclerView r102 = this.G.f210686p;
        int r103 = 8;
        boolean r104 = false;
        if (r100 == false) goto L5;
        int r105 = 8;
    L6:
        r102.setVisibility(r105);
        SpaceEmptyState r106 = this.G.f210680j;
        if (r100 == false) goto L9;
        r103 = 0;
    L9:
        r106.setVisibility(r103);
        if (r100 == false) goto L29;
        com.bytedance.ee.bear.bitable.card.model.stmodel.field.a r107 = this.f208078q;
        if (r107 == null) goto L21;
        List<com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a> r108 = r107.f207138n;
        if (r108 == null) goto L21;
        if (r108 != null) goto L17;
    L19:
        boolean r109 = false;
    L20:
        if (r109 == true) goto L21;
    L22:
        if (r104 == false) goto L24;
        int r110 = R.drawable.ccm_empty_neutral_no_content;
    L25:
        if (r104 == false) goto L27;
        int r111 = R.string.Bitable_Mobile_CannotEditOption;
    L28:
        this.G.f210680j.setImageRes(Integer.valueOf(r110));
        this.G.f210680j.setDesc(r101.getResources().getString(r111));
        goto L29
    L27:
        r111 = R.string.Bitable_Option_NoOptionFound;
        goto L28
    L24:
        r110 = R.drawable.ccm_empty_neutral_search_failed;
        goto L25
    L17:
        if (r108.isEmpty() != true) goto L19;
        r109 = true;
    L21:
        r104 = true;
    L29:
        p(this.G.f210680j);
        return;
    L5:
        r105 = 0;
        goto L6
    }

    @Override // hp4.g
    public final View q(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f486399c;
    }

    public static final com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a x(SelectEditPanel r100, String r101) {
        com.bytedance.ee.bear.bitable.card.model.stmodel.field.a r102 = r100.f208078q;
        if (r102 == null) goto L12;
        List<com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a> r103 = r102.f207138n;
        if (r103 == null) goto L12;
        Iterator<T> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L12;
        com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a r105 = (com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a) r104.next();
        if (TextUtils.equals(r105.f207142b, r101) == false) goto L8;
        return r105;
    L12:
        return null;
    }

    public void G(com.bytedance.ee.bear.bitable.card.model.stmodel.field.a r110, List<String> r111) {
        this.f208081t = true;
        this.f208078q = r110;
        this.f208080s = r111;
        int r100 = 0;
        String r101 = null;
        if (r110 == null) goto L16;
        ArrayList r102 = new ArrayList();
        if (r111 == null) goto L17;
        int r103 = r110.f207138n.size();
        Iterator<String> r104 = r111.iterator();
    L9:
        if (r104.hasNext() == false) goto L17;
        String r105 = r104.next();
        int r106 = 0;
    L11:
        if (r106 >= r103) goto L9;
        if (TextUtils.equals(((com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a) ListProtector.get(r110.f207138n, r106)).f207141a, r105) == true) goto L14;
        r106 = r106 + 1;
        goto L11
    L14:
        r102.add(Integer.valueOf(r106));
    L17:
        if (r102 != null) goto L19;
    L21:
        this.f208083v = r100;
        z().f208066f = true;
        SelectEditAdapter r107 = z();
        if (r110 == null) goto L24;
        List<com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a> r108 = r110.f207138n;
    L25:
        r107.C2(r108, r111);
        z().notifyDataSetChanged();
        this.D = State.LOADINGFINISH;
        if (r110 == null) goto L29;
        r101 = r110.f478256c;
    L29:
        if (this.f208076o == false) goto L31;
        this.G.f210679i.setTitle(r101);
    L31:
        J();
        return;
    L24:
        r108 = null;
        goto L25
    L19:
        if (r102.size() <= 0) goto L21;
        r100 = ((Number) ListProtector.get(r102, 0)).intValue();
        goto L21
    L16:
        r102 = null;
        goto L17
    }

    public void H(com.bytedance.ee.bear.bitable.card.model.stmodel.field.a r100, String r101) {
        this.f208081t = false;
        this.f208078q = r100;
        this.f208079r = r101;
        if (r100 != null) goto L5;
        int r102 = 0;
    L15:
        if (r102 > 0) goto L18;
        r102 = 0;
    L18:
        this.f208083v = r102;
        z().f208066f = false;
        SelectEditAdapter r103 = z();
        String r104 = null;
        if (r100 == null) goto L21;
        List<com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a> r105 = r100.f207138n;
    L22:
        r103.C2(r105, CollectionsKt.arrayListOf(new String[]{r101}));
        z().notifyDataSetChanged();
        this.D = State.LOADINGFINISH;
        if (r100 == null) goto L26;
        r104 = r100.f478256c;
    L26:
        if (this.f208076o == false) goto L28;
        this.G.f210679i.setTitle(r104);
    L28:
        J();
        return;
    L21:
        r105 = null;
        goto L22
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L13;
        int r106 = r100.f207138n.size();
        r102 = 0;
    L8:
        if (r102 >= r106) goto L13;
        if (TextUtils.equals(((com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a) ListProtector.get(r100.f207138n, r102)).f207141a, r101) == true) goto L15;
        r102 = r102 + 1;
    L13:
        r102 = -1;
        goto L15
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.SelectEditAdapter.a
    public void l(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "optionId");
        hp4.g.b r102 = this.f486402f;
        if (r102 == null) goto L16;
        int r103 = 1;
        if (this.f208081t == false) goto L11;
        r102.c(z().f208064d);
        if (r101 == true) goto L10;
        r103 = -1;
    L10:
        D(r103);
        return;
    L11:
        if (r101 == true) goto L14;
        r100 = null;
    L14:
        r102.c(r100);
        D((!TextUtils.isEmpty(r100) ? 1 : 0) - (!TextUtils.isEmpty(this.f208079r) ? 1 : 0));
        dismiss();
        return;
    }

    public static final void w(SelectEditPanel r100, final String r101, final int r102, final boolean r103) {
        b r104 = r100.f208087z;
        if (r104 == null) goto L5;
        final BaseSelectCellViewHolder.c r105 = (BaseSelectCellViewHolder.c) r104;
        tt5.a.b("BaseSelectCellViewHolder", "onAddNewOption()... optionContent = " + r101 + ", optionColorId = " + r102);
        BaseSelectCellViewHolder r106 = r105.f208047a;
        int r107 = BaseSelectCellViewHolder.Q;
        JSONObject r108 = mu5.b.a(r106.Z4());
        r108.put2("total", 1);
        r105.f208047a.K.fetchCommonData(CommonActionType.GET_NEW_OPTION_ID, r108, String.class).subscribe(new o(r105, r101, r102, r103), new p());
    L5:
        r100.G.f210689s.setText("");
        if (r100.f208081t == true) goto L9;
        if (r103 == false) goto L9;
        r100.dismiss();
        return;
    L9:
        r100.G.f210686p.scrollToPosition(0);
    }

    public SelectEditPanel(Context r100, boolean r101, ColorBean[] r102, boolean r103, gp4.h r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f208074m = r101;
        this.f208075n = r102;
        this.f208076o = r103;
        this.f208077p = r104;
        this.D = State.NOSTATE;
        c r105 = new c(R.drawable.ccm_empty_neutral_no_content, "");
        this.E = r105;
        this.F = r105;
        BitableCardSelectEditPanelBinding r106 = BitableCardSelectEditPanelBinding.a(LayoutInflater.from(r100));
        this.G = r106;
        this.I = com.bytedance.ee.bear.bitable.c.B();
        this.f486399c = r106.f210671a;
        C();
        p0 r107 = (p0) this;
        r106.f210673c.setOnClickListener(new j0(r107));
        r106.f210672b.setOnClickListener(new k0(r107));
        r106.f210689s.addTextChangedListener(new l0(r107));
        B();
    }
}
