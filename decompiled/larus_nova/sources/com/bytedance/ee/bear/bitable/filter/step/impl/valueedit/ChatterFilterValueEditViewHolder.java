package com.bytedance.ee.bear.bitable.filter.step.impl.valueedit;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity;
import com.bytedance.ee.bear.bitable.card.view.cell.chatter.SelectedChatterAdapter;
import com.bytedance.ee.bear.bitable.filter.model.EFilterOperator;
import com.bytedance.ee.bear.bitable.filter.model.FilterFieldOption;
import com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.ChatterFilterValueEditViewHolder.ChatterListResult;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes15.dex */
public abstract class ChatterFilterValueEditViewHolder<T extends IChatterEntity, P extends ChatterListResult<T>> extends n<T[]> {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ int f211911z = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f211912j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final EditText f211913k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f211914l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final View f211915m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final SpaceEmptyState f211916n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final LottieAnimationView f211917o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final RecyclerView f211918p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final RecyclerView f211919q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final SelectedChatterAdapter<T> f211920r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ChatterFilterValueEditViewHolder$mSuggestChatterAdapter$1 f211921s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final List<T> f211922t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final List<T> f211923u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final List<T> f211924v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public T[] f211925w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f211926x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f211927y;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u0016\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005R$\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/bitable/filter/step/impl/valueedit/ChatterFilterValueEditViewHolder$ChatterListResult;", "D", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/IChatterEntity;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "data", "", "getData", "()[Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/IChatterEntity;", "setData", "([Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/IChatterEntity;)V", "[Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/IChatterEntity;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class ChatterListResult<D extends IChatterEntity> implements NonProguard {
        private D[] data;

        public ChatterListResult() {
        }

        public final D[] getData() {
            return this.data;
        }

        public final void setData(D[] r100) {
            this.data = r100;
        }
    }

    public static final class a implements Function2<List<? extends T>, T, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatterFilterValueEditViewHolder<T, P> f211928a;

        public a(ChatterFilterValueEditViewHolder<T, P> r100) {
            this.f211928a = r100;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Object r100, Object r101) {
            List<? extends T> r102 = (List) r100;
            Intrinsics.checkNotNullParameter(r102, "list");
            Intrinsics.checkNotNullParameter((IChatterEntity) r101, MapController.ITEM_LAYER_TAG);
            ChatterFilterValueEditViewHolder<T, P> r103 = this.f211928a;
            r103.v(r102);
            r103.u(true);
            return Unit.INSTANCE;
        }
    }

    public static final class b implements Function4<List<? extends T>, T, T, Boolean, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatterFilterValueEditViewHolder<T, P> f211929a;

        public b(ChatterFilterValueEditViewHolder<T, P> r100) {
            this.f211929a = r100;
        }

        @Override // kotlin.jvm.functions.Function4
        public final Unit invoke(Object r100, Object r101, Object r102, Boolean r103) {
            List<? extends T> r104 = (List) r100;
            IChatterEntity r105 = (IChatterEntity) r101;
            Intrinsics.checkNotNullParameter(r104, "list");
            Intrinsics.checkNotNullParameter((IChatterEntity) r102, "clickedChatter");
            ChatterFilterValueEditViewHolder<T, P> r106 = this.f211929a;
            r106.v(r104);
            r106.u(true);
            return Unit.INSTANCE;
        }
    }

    public static final class c {
    }

    public static final class d<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d<T, R> f211930a = null;

        static {
            f211930a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            ChatterListResult r101 = (ChatterListResult) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            IChatterEntity[] r102 = r101.getData();
            if (r102 != null) goto L7;
            return null;
        L7:
            return ArraysKt.toList(r102);
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatterFilterValueEditViewHolder<T, P> f211931a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f211932b;

        public e(ChatterFilterValueEditViewHolder<T, P> r100, String r101) {
            this.f211931a = r100;
            this.f211932b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            List r101 = (List) r100;
            ChatterFilterValueEditViewHolder<T, P> r102 = this.f211931a;
            ((ArrayList) r102.f211922t).clear();
            if (r101 == null) goto L5;
            ArrayList r103 = (ArrayList) r102.f211922t;
            r103.addAll(r101);
        L5:
            r102.f211921s.A2(r102.f211922t);
            ChatterFilterValueEditViewHolder<T, P> r104 = this.f211931a;
            String r105 = this.f211932b;
            ((ArrayList) r104.f211924v).clear();
            Iterator r106 = ((ArrayList) r104.f211922t).iterator();
        L6:
            String r107 = null;
            boolean r108 = true;
            if (r106.hasNext() == false) goto L41;
            IChatterEntity r109 = (IChatterEntity) r106.next();
            if (r104.f211926x == true) goto L13;
            r107 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).a();
            if (r107 != null) goto L13;
            r107 = Locale.getDefault().getLanguage();
        L13:
            String r110 = r109.getLocalName(r107);
            if (Intrinsics.areEqual(Locale.CHINA.getLanguage(), r107) == true) goto L31;
            int r111 = com.bytedance.ee.bear.bitable.c.f207079a;
            int r112 = com.bytedance.ee.bear.bitable.n.f214744a;
            if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.use_mul_language_filter_user_enable") == false) goto L31;
            String r113 = r109.getLocalName(Locale.CHINA.getLanguage());
            if (r110 != null) goto L20;
        L22:
            boolean r114 = false;
        L23:
            if (r114 == true) goto L36;
            if (r113 != null) goto L26;
        L28:
            boolean r115 = false;
        L29:
            if (r115 == true) goto L36;
        L35:
            r108 = false;
            goto L36
        L26:
            if (StringsKt.contains(r113, r105, true) != true) goto L28;
            r115 = true;
        L36:
            if (r108 == true) goto L37;
            if (r109.isCurrentUser() == false) goto L6;
            ((ArrayList) r104.f211924v).add(r109);
            goto L6
        L37:
            ((ArrayList) r104.f211924v).add(r109);
            goto L6
        L20:
            if (StringsKt.contains(r110, r105, true) != true) goto L22;
            r114 = true;
        L31:
            if (r110 == null) goto L35;
            if (StringsKt.contains(r110, r105, true) != true) goto L35;
        L41:
            r104.f211921s.A2(r104.f211924v);
            ChatterFilterValueEditViewHolder<T, P> r116 = this.f211931a;
            if (r116.f211921s.getItemCount() <= 0) goto L45;
            r108 = false;
        L45:
            r116.p(r108, null);
            this.f211931a.u(false);
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatterFilterValueEditViewHolder<T, P> f211933a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f211934b;

        public f(ChatterFilterValueEditViewHolder<T, P> r100, String r101) {
            this.f211933a = r100;
            this.f211934b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.d("GroupFilterValueEditViewHolder", "loadAllSuggestChatters failed, " + ((Throwable) r100));
            ChatterFilterValueEditViewHolder<T, P> r101 = this.f211933a;
            r101.p(false, new com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.c(r101, this.f211934b));
        }
    }

    public static final class g implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatterFilterValueEditViewHolder f211935a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public g(ChatterFilterValueEditViewHolder r100) {
            this.f211935a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            this.f211935a.t(StringsKt.trim(String.valueOf(r100)).toString());
        }
    }

    static {
    }

    public abstract Class<P> r();

    public abstract String s();

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.i
    public final boolean b() {
        return !Arrays.equals(this.f211925w, (Object[]) c());
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.i
    public final View getView() {
        return this.f211912j;
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.n
    public final SpaceEmptyState i() {
        return this.f211916n;
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.n
    public final View j() {
        return this.f211915m;
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.n
    public final LottieAnimationView k() {
        return this.f211917o;
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.n
    public final RecyclerView l() {
        return this.f211919q;
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.n
    public final View m() {
        return this.f211912j;
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.n
    public final EditText n() {
        return this.f211913k;
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.n
    public final View o() {
        return this.f211914l;
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.a
    public final void h(Object r100) {
        T[] r101 = (T[]) ((IChatterEntity[]) r100);
        this.f211925w = r101;
        t("");
        if (r101 == null) goto L6;
        List<? extends T> r102 = ArraysKt.toList(r101);
        if (r102 == null) goto L6;
    L7:
        v(r102);
        return;
    L6:
        r102 = CollectionsKt.emptyList();
        goto L7
    }

    public final void t(String r100) {
        com.bytedance.ee.util.ui.j.d(this.f212004i, 200);
        Single<T> r101 = d(s(), r100, com.bytedance.ee.bear.bitable.filter.step.impl.c.f211908a, new ChatterFilterValueEditViewHolder$loadSuggestChatters$1(this));
        if (r101 == null) goto L10;
        Single<R> r102 = r101.map(d.f211930a);
        if (r102 == 0) goto L11;
        Single r103 = r102.observeOn(fo5.d.d());
        if (r103 == null) goto L12;
        r103.subscribe(new e(this, r100), new f(this, r100));
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void u(boolean r100) {
        boolean r101 = ((ArrayList) this.f211923u).isEmpty();
        RecyclerView r102 = this.f211918p;
        if (r101 == true) goto L5;
        int r103 = 0;
    L6:
        r102.setVisibility(r103);
        if (r101 == true) goto L11;
        if (r100 == false) goto L12;
        this.f211918p.smoothScrollToPosition(this.f211920r.getItemCount() - 1);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r103 = 8;
        goto L6
    }

    public final void v(List<? extends T> r100) {
        ((ArrayList) this.f211923u).clear();
        if (r100 != null) goto L5;
    L10:
        C2(this.f211923u);
        this.f211920r.setNewData(this.f211923u);
        return;
    L5:
        if (this.f211927y == false) goto L7;
    L9:
        ArrayList r101 = (ArrayList) this.f211923u;
        r101.addAll(r100);
        goto L10
    L7:
        if (r100.size() <= 1) goto L9;
        List<T> r102 = this.f211923u;
        ArrayList r103 = (ArrayList) r102;
        r103.add(ListProtector.get(r100, 0));
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.recyclerview.widget.RecyclerView$Adapter, com.bytedance.ee.bear.bitable.card.view.cell.chatter.SuggestChatterAdapter, com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.ChatterFilterValueEditViewHolder$mSuggestChatterAdapter$1] */
    public ChatterFilterValueEditViewHolder(Context r100, FilterFieldOption r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100, r110);
        View r101 = LayoutInflater.from(r100).inflate(R.layout.bitable_user_filter_value_view, null);
        this.f211912j = r101;
        EditText r102 = (EditText) r101.findViewById(R.id.search_et);
        this.f211913k = r102;
        this.f211914l = r101.findViewById(R.id.loading_state_layout);
        this.f211915m = r101.findViewById(R.id.loading_layout);
        this.f211916n = (SpaceEmptyState) r101.findViewById(R.id.empty_state);
        this.f211917o = (LottieAnimationView) r101.findViewById(R.id.loading_lottie);
        RecyclerView r103 = (RecyclerView) r101.findViewById(R.id.selected_users_rv);
        this.f211918p = r103;
        RecyclerView r104 = (RecyclerView) r101.findViewById(R.id.suggest_users_rv);
        this.f211919q = r104;
        SelectedChatterAdapter<T> r105 = new SelectedChatterAdapter(null);
        this.f211920r = r105;
        ?? r106 = new ChatterFilterValueEditViewHolder$mSuggestChatterAdapter$1(this);
        this.f211921s = r106;
        this.f211922t = new ArrayList();
        this.f211923u = new ArrayList();
        this.f211924v = new ArrayList();
        this.f211926x = com.bytedance.ee.bear.appsetting.c.a.f206237a.h("base.chatter.filtersearch.locale.disable");
        EFilterOperator.Companion.getClass();
        EFilterOperator r112 = EFilterOperator.a.a(r111);
        boolean r107 = true;
        if (r112 != EFilterOperator.Contains) goto L5;
    L14:
        this.f211927y = r107;
        r105.z2(r107);
        String r113 = r100.getResources().getConfiguration().locale.getLanguage();
        Intrinsics.checkNotNullParameter(r113, "language");
        r105.f207539a = r113;
        r105.f207541c = new a(this);
        LinearLayoutManager r114 = new LinearLayoutManager(r100);
        r114.setOrientation(0);
        r103.setLayoutManager(r114);
        r103.setAdapter(r105);
        r103.setNestedScrollingEnabled(false);
        r106.B2(r107);
        String r115 = r100.getResources().getConfiguration().locale.getLanguage();
        Intrinsics.checkNotNullParameter(r115, "language");
        r106.f207548b = r115;
        r106.f207552f = new b(this);
        r104.setLayoutManager(new LinearLayoutManager(r100));
        r104.setAdapter(r106);
        r102.addTextChangedListener(new g(this));
        return;
    L5:
        if (r112 == EFilterOperator.DoesNotContain) goto L14;
        if (r110 == null) goto L10;
        Boolean r116 = r110.getMultiple();
        if (r116 == null) goto L10;
        boolean r117 = r116.booleanValue();
    L11:
        if (r117 == true) goto L14;
        r107 = false;
    L10:
        r117 = true;
        goto L11
    }
}
