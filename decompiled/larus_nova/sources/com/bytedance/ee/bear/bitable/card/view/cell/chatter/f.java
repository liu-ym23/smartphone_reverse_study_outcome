package com.bytedance.ee.bear.bitable.card.view.cell.chatter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.ee.bear.at.AtObject;
import com.bytedance.ee.bear.atfinder.AtFinderResult;
import com.bytedance.ee.bear.atfinder.AtFinderViewModel;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity;
import com.bytedance.ee.bear.bitable.card.view.cell.CellEditDragView;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
public abstract class f<T extends IChatterEntity> extends hp4.g {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f207567x = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f207568m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f207569n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f207570o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f207571p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final f<T>.e f207572q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public a f207573r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public b f207574s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ArrayList<T> f207575t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f207576u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f207577v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f207578w;

    public interface a {
        void a(String r100, Boolean r101, Integer r102);

        void b(boolean r100);
    }

    public static final class b<T extends IChatterEntity> implements com.bytedance.ee.bear.atfinder.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<f<T>.e> f207579a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WeakReference<f<T>> f207580b;

        @Override // com.bytedance.ee.bear.atfinder.g
        public final void a() {
            f<T>.e r100 = this.f207579a.get();
            if (r100 == null) goto L6;
            r100.c();
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.ee.bear.atfinder.g
        public final void b(AtFinderResult r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            f<T> r101 = this.f207580b.get();
            if (r101 != 0) goto L5;
            return;
        L5:
            if (CollectionUtils.isEmpty(r100.list) == false) goto L8;
            tt5.a.k("ChatterSelectPresenter", "none chatters searched");
            r101.A(new ArrayList());
            return;
        L8:
            tt5.a.h("ChatterSelectPresenter", r100.list.size() + " chatters searched");
            ArrayList r102 = new ArrayList();
            Iterator<AtObject> r103 = r100.list.iterator();
        L10:
            if (r103.hasNext() == false) goto L14;
            AtObject r104 = r103.next();
            Intrinsics.checkNotNull(r104);
            IChatterEntity r105 = r101.x(r104);
            if (r105 == null) goto L10;
            r102.add(r105);
            goto L10
        L14:
            r101.A(r102);
        }

        public b(f<T>.e r100, f<T> r101) {
            Intrinsics.checkNotNullParameter(r101, "panel");
            this.f207579a = new WeakReference(r100);
            this.f207580b = new WeakReference(r101);
        }
    }

    public static final class c {
    }

    public final class d implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f<T> f207581a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "s");
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "s");
        }

        public d(f r100) {
            this.f207581a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            Intrinsics.checkNotNullParameter(r100, "s");
            String r101 = r100.toString();
            this.f207581a.C(r101);
            f<T>.e r102 = this.f207581a.f207572q;
            if (r102 == null) goto L12;
            ImageView r103 = r102.f207591j;
            if (r103 != null) goto L7;
            return;
        L7:
            if (TextUtils.isEmpty(r101) == false) goto L9;
            int r104 = 8;
        L10:
            r103.setVisibility(r104);
            return;
        L9:
            r104 = 0;
            goto L10
        }
    }

    public final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f207582a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CellEditDragView f207583b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f207584c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final View f207585d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final View f207586e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final TextView f207587f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final RecyclerView f207588g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final RecyclerView f207589h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final EditText f207590i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final ImageView f207591j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final FrameLayout f207592k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final BearLottieView f207593l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final SpaceEmptyState f207594m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final UDCheckBox f207595n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public ObjectAnimator f207596o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final SuggestChatterAdapter<T> f207597p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final SelectedChatterAdapter<T> f207598q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f207599r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f207600s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final /* synthetic */ f<T> f207601t;

        public final void c() {
            this.f207592k.setVisibility(0);
            this.f207593l.setVisibility(0);
            this.f207594m.setVisibility(8);
            this.f207593l.playAnimation();
            this.f207588g.setVisibility(8);
            d(true);
        }

        public final void b(List<? extends T> r110) {
            Intrinsics.checkNotNullParameter(r110, "list");
            this.f207597p.C2(r110);
            this.f207598q.setNewData(r110);
            if (this.f207598q.getItemCount() <= 0) goto L21;
            if (this.f207589h.getVisibility() == 0) goto L14;
            ObjectAnimator r111 = this.f207596o;
            if (r111 == null) goto L10;
            r111.end();
        L10:
            this.f207589h.setVisibility(0);
            ObjectAnimator r112 = ObjectAnimator.ofFloat(this.f207588g, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{-cu5.c.b(38), 0.0f}).setDuration(200);
            this.f207596o = r112;
            if (r112 == null) goto L14;
            r112.start();
        L14:
            if (this.f207599r == false) goto L17;
            this.f207599r = false;
        L19:
            this.f207600s = this.f207598q.getItemCount();
            return;
        L17:
            if (this.f207600s >= this.f207598q.getItemCount()) goto L19;
            this.f207589h.smoothScrollToPosition(this.f207598q.getItemCount() - 1);
            goto L19
        L21:
            if (this.f207589h.getVisibility() == 8) goto L32;
            ObjectAnimator r113 = this.f207596o;
            if (r113 == null) goto L26;
            r113.end();
        L26:
            this.f207589h.setVisibility(8);
            ObjectAnimator r114 = ObjectAnimator.ofFloat(this.f207588g, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{cu5.c.b(38), 0.0f}).setDuration(200);
            this.f207596o = r114;
            if (r114 == null) goto L31;
            r114.start();
            return;
        L31:
            return;
        }

        public final void d(boolean r100) {
            int r101 = 8;
            if (this.f207601t.f207578w == true) goto L5;
        L14:
            this.f207587f.setVisibility(8);
            return;
        L5:
            if (com.bytedance.ee.bear.bitable.c.w() == true) goto L14;
            TextView r102 = this.f207587f;
            if (r100 == true) goto L10;
            r101 = 0;
        L10:
            r102.setVisibility(r101);
            if (TextUtils.isEmpty(this.f207590i.getText()) == false) goto L13;
            this.f207587f.setText(R.string.Bitable_GroupChat_Recents_Title);
            return;
        L13:
            this.f207587f.setText(R.string.Bitable_GroupChat_Results_Text);
        }

        public e(final f r110, View r111) {
            Intrinsics.checkNotNullParameter(r111, "rootView");
            this.f207601t = r110;
            this.f207582a = r111;
            CellEditDragView r100 = (CellEditDragView) r111.findViewById(R.id.dragView);
            this.f207583b = r100;
            this.f207584c = r111.findViewById(R.id.rv_search_result_divider);
            this.f207585d = r111.findViewById(R.id.create_group_wrapper);
            this.f207586e = r111.findViewById(R.id.create_group);
            this.f207587f = (TextView) r111.findViewById(R.id.list_name);
            RecyclerView r101 = (RecyclerView) r111.findViewById(R.id.rv_search_result_users);
            this.f207588g = r101;
            RecyclerView r102 = (RecyclerView) r111.findViewById(R.id.rv_selected_users);
            this.f207589h = r102;
            EditText r103 = (EditText) r111.findViewById(R.id.et_search_user);
            this.f207590i = r103;
            ImageView r104 = (ImageView) r111.findViewById(R.id.iv_search_clear_icon);
            this.f207591j = r104;
            this.f207592k = (FrameLayout) r111.findViewById(R.id.fl_search_loading);
            this.f207593l = (BearLottieView) r111.findViewById(R.id.blv_search_user_loading);
            this.f207594m = (SpaceEmptyState) r111.findViewById(R.id.empty_state);
            LinearLayout r105 = (LinearLayout) r111.findViewById(R.id.ll_checkbox_container);
            UDCheckBox r106 = (UDCheckBox) r111.findViewById(R.id.cb_notify_checkbox);
            this.f207595n = r106;
            TextView r112 = (TextView) r111.findViewById(R.id.tv_hint_text);
            SuggestChatterAdapter<T> r107 = new SuggestChatterAdapter(null);
            this.f207597p = r107;
            SelectedChatterAdapter<T> r108 = new SelectedChatterAdapter(null);
            this.f207598q = r108;
            boolean r109 = true;
            this.f207599r = true;
            r100.setOnActionListener(new g(r110, this));
            int r113 = f.f207567x;
            r100.h(r110.f486397a.getString(R.string.Bitable_Common_ButtonDone), Integer.valueOf(R.color.text_link_hover));
            r100.setOnPositionChangeListener(new h(r110));
            r100.m(false);
            com.bytedance.ee.util.ui.l.b(r100, R.color.bg_body);
            r103.addTextChangedListener(new d(r110));
            r103.setOnFocusChangeListener(new j(r110));
            r103.setOnEditorActionListener(new k(r110));
            r104.setOnClickListener(new l(this));
            r104.setVisibility(8);
            LinearLayoutManager r114 = new LinearLayoutManager(r110.f486397a);
            r114.setOrientation(0);
            r102.setLayoutManager(r114);
            r102.setAdapter(r108);
            r108.f207541c = new m(this, r110);
            r101.setLayoutManager(new LinearLayoutManager(r110.f486397a));
            r101.setAdapter(r107);
            r107.f207553g = r110.f207571p;
            r107.f207552f = new n(r110, this);
            r101.addOnScrollListener(new MentionChatterSelectPanel$ViewsHolder$initSuggestListView$2(this, r110));
            if (r110.f207570o == true) goto L5;
        L7:
            r109 = false;
        L8:
            r106.setChecked(r109);
            if (r110.f207568m == true) goto L11;
        L16:
            r112.setVisibility(8);
            r105.setVisibility(8);
        L17:
            r105.setOnClickListener(new i(this));
            return;
        L11:
            if (com.bytedance.ee.bear.bitable.c.w() == true) goto L16;
            if (r110.f207569n == false) goto L15;
            r105.setVisibility(0);
            r112.setVisibility(8);
            goto L17
        L15:
            r105.setVisibility(8);
            r112.setVisibility(0);
            goto L17
        L5:
            if (com.bytedance.ee.bear.bitable.c.w() == true) goto L7;
            goto L7
        }

        public final void e(List<? extends T> r100, String r101, boolean r102) {
            tt5.a.h("ChatterSelectPresenter", "updateSelectedChatter>>> editCompleted " + r102 + " multi " + this.f207601t.f207576u);
            hp4.g.b r103 = this.f207601t.f486402f;
            if (r103 == null) goto L5;
            r103.c(r100);
        L5:
            f<T> r104 = this.f207601t;
            int r105 = r100.size() - this.f207601t.f207575t.size();
            r104.getClass();
            LinkedHashMap r106 = new LinkedHashMap();
            f<T>.e r107 = r104.f207572q;
            if (r107 == null) goto L10;
            EditText r108 = r107.f207590i;
            if (r108 == null) goto L10;
            Editable r109 = r108.getText();
        L11:
            r106.put(BitableAnalytic.EditParamKey.BITABLE_EDIT_SEARCH, String.valueOf(!TextUtils.isEmpty(r109)));
            r106.put(BitableAnalytic.EditParamKey.CLICK_DONE_BTN, "false");
            r106.put(BitableAnalytic.EditParamKey.IS_EDIT_PANEL_OPEN, String.valueOf(r104.f207576u));
            if (r105 < 0) goto L14;
            int r110 = RangesKt.coerceAtMost(r105, 1);
        L15:
            r106.put(BitableAnalytic.EditParamKey.CELL_ITEM_CHANGE, String.valueOf(r110));
            r106.put(BitableAnalytic.EditParamKey.DELETE_ITEM_SOURCE, r101);
            hp4.g.b r111 = r104.f486402f;
            if (r111 == null) goto L18;
            r111.d(r106, null);
        L18:
            f<T> r112 = this.f207601t;
            if (r112.f207576u == false) goto L22;
            b(r100);
            return;
        L22:
            if (r112.f207571p == true) goto L24;
            r112.dismiss();
            return;
        L24:
            if (r100.isEmpty() == false) goto L26;
            b(r100);
            return;
        L26:
            this.f207601t.dismiss();
            return;
        L14:
            r110 = -1;
        L10:
            r109 = null;
            goto L11
        }

        public static final void a(final e r100, final List r101, IChatterEntity r102, final String r103) {
            f<T> r104 = r100.f207601t;
            if (r104.f207576u == true) goto L5;
        L7:
            final boolean r105 = false;
        L8:
            r104.w(r102, new MentionChatterSelectPanel$ViewsHolder$innerUpdateSelectedChatter$1(r100, r101, r103, r105), r105);
            a r106 = r100.f207601t.f207573r;
            if (r106 == null) goto L12;
            r106.a("select_group", null, null);
            return;
        L12:
            return;
        L5:
            if (r104.f207578w == false) goto L7;
            r105 = true;
            goto L8
        }
    }

    static {
    }

    public void B() {
    }

    public void D() {
    }

    public abstract void w(T r100, Function0<Unit> r101, boolean r102);

    public abstract T x(AtObject r100);

    public abstract String y();

    @Override // hp4.g, com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void show() {
        kn4.f.a.C6577a r100 = kn4.f.a.f504223a;
        r100.f504225b = this.f207574s;
        f<T>.e r101 = this.f207572q;
        if (r101 == null) goto L10;
        EditText r102 = r101.f207590i;
        if (r102 == null) goto L10;
        Editable r103 = r102.getText();
        if (r103 == null) goto L10;
        String r104 = r103.toString();
        if (r104 == null) goto L10;
    L11:
        C(r104);
        a r105 = this.f207573r;
        if (r105 == null) goto L14;
        r105.b(this.f207576u);
    L14:
        super.show();
        ((CellEditDragView) this.f486399c.findViewById(R.id.dragView)).m(false);
        return;
    L10:
        r104 = "";
        goto L11
    }

    public final boolean z() {
        if (this.f207568m == false) goto L15;
        f<T>.e r100 = this.f207572q;
        if (r100 == null) goto L11;
        UDCheckBox r101 = r100.f207595n;
        if (r101 == null) goto L11;
        if (r101.isChecked() != true) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L16;
        return true;
    L16:
        return false;
    L11:
        r102 = false;
        goto L12
    L15:
        return false;
    }

    @Override // hp4.g
    public final void dismiss() {
        super.dismiss();
        final kn4.f.a.C6577a r100 = kn4.f.a.f504223a;
        b r101 = this.f207574s;
        if (r100.f504225b != r101) goto L6;
        r100.f504225b = null;
    L6:
        if (r100.f504224a == null) goto L8;
        com.bytedance.ee.util.ui.m.a(new kn4.c(r100));
    L8:
        r100.f504225b = null;
        r100.f504224a = null;
        f<T>.e r102 = this.f207572q;
        if (r102 == null) goto L13;
        ObjectAnimator r103 = r102.f207596o;
        if (r103 == null) goto L13;
        r103.cancel();
    L13:
        f<T>.e r104 = this.f207572q;
        if (r104 == null) goto L19;
        BearLottieView r105 = r104.f207593l;
        if (r105 == null) goto L20;
        r105.cancelAnimation();
        return;
    L20:
        return;
    }

    public final void A(ArrayList<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "chatterEntities");
        f<T>.e r101 = this.f207572q;
        if (r101 == null) goto L5;
        r101.f207593l.cancelAnimation();
        r101.f207592k.setVisibility(8);
        r101.f207593l.setVisibility(8);
        r101.f207588g.setVisibility(0);
        r101.f207594m.setVisibility(8);
        r101.d(false);
    L5:
        tt5.a.h("ChatterSelectPresenter", "handleSuggestedChatters size " + r100.size());
        if (r100.size() <= 0) goto L10;
        f<T>.e r102 = this.f207572q;
        if (r102 == null) goto L14;
        Intrinsics.checkNotNullParameter(r100, "list");
        r102.f207597p.A2(r100);
        return;
    L14:
        return;
    L10:
        f<T>.e r103 = this.f207572q;
        if (r103 == null) goto L16;
        r103.f207588g.setVisibility(8);
        r103.f207594m.setVisibility(0);
        return;
    }

    public void C(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        kn4.f.a.f504223a.a(r100);
    }

    @Override // hp4.g
    public final View q(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f486399c;
    }

    public final void E(String r100, boolean r101, List<? extends T> r102) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.f207577v = r100;
        this.f207576u = r101;
        if (r102 != null) goto L7;
        r102 = CollectionsKt.emptyList();
    L7:
        this.f207575t.clear();
        this.f207575t.addAll(r102);
        f<T>.e r103 = this.f207572q;
        if (r103 == null) goto L10;
        boolean r104 = this.f207576u;
        r103.f207598q.z2(r104);
        r103.f207597p.B2(r104);
    L10:
        f<T>.e r105 = this.f207572q;
        if (r105 == null) goto L13;
        r105.b(this.f207575t);
    L13:
        f<T>.e r106 = this.f207572q;
        if (r106 == null) goto L17;
        String r107 = this.f207577v;
        Intrinsics.checkNotNullParameter(r107, "title");
        r106.f207583b.setTitle(r107);
        return;
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [kn4.d] */
    public f(Context r100, final FragmentActivity r101, String r102, int r103, boolean r104, boolean r105, boolean r106, boolean r107) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "activity");
        Intrinsics.checkNotNullParameter(r102, "token");
        super(r100);
        this.f207568m = r104;
        this.f207569n = r105;
        this.f207570o = r106;
        this.f207571p = r107;
        this.f207575t = new ArrayList();
        this.f207577v = "";
        View r108 = LayoutInflater.from(r100).inflate(R.layout.bitable_card_user_list_container, null);
        this.f486399c = r108;
        f<T>.e r109 = new e(this, r108);
        this.f207572q = r109;
        if (ou5.a.e() == false) goto L5;
        String r110 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).a();
    L6:
        tt5.a.h("ChatterSelectPresenter", "language:" + r110);
        Intrinsics.checkNotNull(r110);
        Intrinsics.checkNotNullParameter(r110, "language");
        SuggestChatterAdapter<T> r111 = r109.f207597p;
        r111.getClass();
        Intrinsics.checkNotNullParameter(r110, "language");
        r111.f207548b = r110;
        SelectedChatterAdapter<T> r112 = r109.f207598q;
        r112.getClass();
        Intrinsics.checkNotNullParameter(r110, "language");
        r112.f207539a = r110;
        com.bytedance.ee.bear.document.at.m.a();
        final kn4.f.a.C6577a r113 = kn4.f.a.f504223a;
        final String r114 = y();
        r113.f504226c = r102;
        r113.f504227d = r103;
        r113.f504228e = r114;
        AtFinderViewModel r115 = (AtFinderViewModel) ViewModelProviders.of(r101).get(AtFinderViewModel.class);
        r113.f504224a = r115;
        r115.setSearchDelegate(kn4.f.f504221a.b());
        r113.f504229f = new kn4.d(r113);
        com.bytedance.ee.util.ui.m.a(new kn4.e(r113, r114, r101));
        this.f207574s = new b(this.f207572q, this);
        return;
    L5:
        r110 = r100.getResources().getConfiguration().locale.getLanguage();
        goto L6
    }
}
