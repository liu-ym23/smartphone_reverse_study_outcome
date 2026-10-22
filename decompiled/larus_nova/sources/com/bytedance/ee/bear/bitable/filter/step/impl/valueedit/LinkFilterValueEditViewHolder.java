package com.bytedance.ee.bear.bitable.filter.step.impl.valueedit;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.ee.bear.bitable.BitableAsyncRequestBiz;
import com.bytedance.ee.bear.bitable.filter.model.EFilterOperator;
import com.bytedance.ee.bear.bitable.filter.model.FilterFieldOption;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larus.nova.R;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes15.dex */
public final class LinkFilterValueEditViewHolder extends n<String[]> {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f211945v = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f211946j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f211947k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final EditText f211948l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final View f211949m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final View f211950n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final SpaceEmptyState f211951o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final LottieAnimationView f211952p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final RecyclerView f211953q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final b f211954r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final List<LinkRecordOption> f211955s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final List<String> f211956t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String[] f211957u;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/bitable/filter/step/impl/valueedit/LinkFilterValueEditViewHolder$LinkRecordOption;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "text", "getText", "setText", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LinkRecordOption implements NonProguard {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private String f211958id;
        private String text;

        public LinkRecordOption() {
        }

        public final String getId() {
            return this.f211958id;
        }

        public final String getText() {
            return this.text;
        }

        public final void setId(String r100) {
            this.f211958id = r100;
        }

        public final void setText(String r100) {
            this.text = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/filter/step/impl/valueedit/LinkFilterValueEditViewHolder$LinkRecordOptionListResult;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "options", "", "Lcom/bytedance/ee/bear/bitable/filter/step/impl/valueedit/LinkFilterValueEditViewHolder$LinkRecordOption;", "getOptions", "()[Lcom/bytedance/ee/bear/bitable/filter/step/impl/valueedit/LinkFilterValueEditViewHolder$LinkRecordOption;", "setOptions", "([Lcom/bytedance/ee/bear/bitable/filter/step/impl/valueedit/LinkFilterValueEditViewHolder$LinkRecordOption;)V", "[Lcom/bytedance/ee/bear/bitable/filter/step/impl/valueedit/LinkFilterValueEditViewHolder$LinkRecordOption;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LinkRecordOptionListResult implements NonProguard {
        private LinkRecordOption[] options;

        public LinkRecordOptionListResult() {
        }

        public final LinkRecordOption[] getOptions() {
            return this.options;
        }

        public final void setOptions(LinkRecordOption[] r100) {
            this.options = r100;
        }
    }

    public static final class a {
    }

    public final class b extends RecyclerView.Adapter<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f211959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LinkFilterValueEditViewHolder f211960b;

        public final class a extends RecyclerView.ViewHolder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final TextView f211961a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final UDCheckBox f211962b;

            public a(View r100) {
                Intrinsics.checkNotNullParameter(r100, "itemView");
                super(r100);
                this.f211961a = (TextView) r100.findViewById(R.id.title_tv);
                this.f211962b = (UDCheckBox) r100.findViewById(R.id.check_box);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return ((ArrayList) this.f211959a).size();
        }

        public b(LinkFilterValueEditViewHolder r100) {
            this.f211960b = r100;
            this.f211959a = new ArrayList();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            a r102 = (a) r100;
            Intrinsics.checkNotNullParameter(r102, "holder");
            if (r101 >= 0) goto L5;
            return;
        L5:
            if (r101 >= getItemCount()) goto L23;
            LinkFilterValueEditViewHolder r103 = this.f211960b;
            String r104 = (String) ListProtector.get(this.f211959a, r101);
            r102.f211962b.setChecked(((ArrayList) r103.f211956t).contains(r104));
            TextView r105 = r102.f211961a;
            Iterator r106 = ((ArrayList) r103.f211955s).iterator();
        L8:
            String r107 = null;
            if (r106.hasNext() == false) goto L13;
            Object r108 = r106.next();
            if (TextUtils.equals(((LinkRecordOption) r108).getId(), r104) == false) goto L8;
        L14:
            LinkRecordOption r109 = (LinkRecordOption) r108;
            if (r109 == null) goto L17;
            r107 = r109.getText();
        L17:
            r105.setText(r107);
            r102.itemView.setOnClickListener(new j(r102, r103, r104, this));
            return;
        L13:
            r108 = null;
            goto L14
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.bitable_link_filter_value_item, r100, false);
            Intrinsics.checkNotNull(r102);
            return new a(r102);
        }
    }

    public static final class c<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<T, R> f211963a = null;

        static {
            f211963a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            LinkRecordOptionListResult r101 = (LinkRecordOptionListResult) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            LinkRecordOption[] r102 = r101.getOptions();
            if (r102 != null) goto L7;
            return null;
        L7:
            return ArraysKt.toList(r102);
        }
    }

    public static final class d<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkFilterValueEditViewHolder f211964a;

        public d(LinkFilterValueEditViewHolder r100) {
            this.f211964a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            List r101 = (List) r100;
            Intrinsics.checkNotNullParameter(r101, "data");
            LinkFilterValueEditViewHolder r102 = this.f211964a;
            ArrayList r103 = new ArrayList();
            Iterator<T> r104 = r101.iterator();
        L4:
            if (r104.hasNext() == false) goto L8;
            T r105 = r104.next();
            if ((!CollectionsKt.contains(r102.f211956t, ((LinkRecordOption) r105).getId())) == false) goto L4;
            r103.add(r105);
            goto L4
        L8:
            return r103;
        }
    }

    public static final class e<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f211965a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LinkFilterValueEditViewHolder f211966b;

        public e(String r100, LinkFilterValueEditViewHolder r101) {
            this.f211965a = r100;
            this.f211966b = r101;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r110) {
            List r111 = (List) r110;
            Intrinsics.checkNotNullParameter(r111, "linkRecords");
            if (this.f211965a.length() != 0) goto L5;
            boolean r100 = true;
        L6:
            if (r100 == false) goto L41;
            List r101 = r111;
            ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
            Iterator<T> r103 = r101.iterator();
        L9:
            if (r103.hasNext() == false) goto L11;
            r102.add(((LinkRecordOption) r103.next()).getId());
            goto L9
        L11:
            List<String> r104 = this.f211966b.f211956t;
            ArrayList r105 = new ArrayList();
            Iterator r106 = ((ArrayList) r104).iterator();
        L13:
            if (r106.hasNext() == false) goto L17;
            Object r107 = r106.next();
            if ((!r102.contains((String) r107)) == false) goto L13;
            r105.add(r107);
            goto L13
        L17:
            tt5.a.b("LinkFilterValueEditViewHolder", "lackSelectedRecordIds, " + r105);
            if ((!r105.isEmpty()) == false) goto L41;
            Single r112 = Single.just(r111);
            LinkFilterValueEditViewHolder r108 = this.f211966b;
            r108.getClass();
            tt5.a.h("LinkFilterValueEditViewHolder", "loadSelectedLinkRecords");
            String r109 = r108.f211974c;
            String r113 = "";
            if (r109 != null) goto L22;
            String r114 = "";
        L23:
            String r115 = r108.f211975d;
            if (r115 != null) goto L26;
            String r116 = "";
        L27:
            FilterFieldOption r117 = r108.f211973b;
            if (r117 == null) goto L33;
            String r118 = r117.getId();
            if (r118 == null) goto L33;
            r113 = r118;
        L33:
            com.bytedance.ee.bear.bitable.a r119 = r108.f211978g;
            if (r119 == null) goto L38;
            Single<T> r120 = r119.a(BitableAsyncRequestBiz.Toolbar, "getFieldLinkByRecordIds", r114, r116, MapsKt.mapOf(new Pair[]{TuplesKt.to("fieldId", r113), TuplesKt.to("tableId", r116), TuplesKt.to("recordIds", r105)}), LinkFilterValueEditViewHolder$loadSelectedLinkRecords$1.INSTANCE);
            if (r120 == null) goto L38;
            Single<R> r121 = r120.map(m.f212003a);
        L48:
            return Single.zip(r112, r121, k.f212000a);
        L38:
            r121 = null;
            goto L48
        L26:
            r116 = r115;
            goto L27
        L22:
            r114 = r109;
        L41:
            return Single.just(r111);
        L5:
            r100 = false;
            goto L6
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkFilterValueEditViewHolder f211967a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f211968b;

        public f(LinkFilterValueEditViewHolder r100, String r101) {
            this.f211967a = r100;
            this.f211968b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            List r101 = (List) r100;
            tt5.a.h("LinkFilterValueEditViewHolder", "loadAllLinkRecords success");
            ((ArrayList) this.f211967a.f211955s).clear();
            if (r101 == null) goto L5;
            ArrayList r102 = (ArrayList) this.f211967a.f211955s;
            r102.addAll(r101);
        L5:
            LinkFilterValueEditViewHolder r103 = this.f211967a;
            String r104 = this.f211968b;
            r103.getClass();
            ArrayList r105 = new ArrayList();
            Iterator r106 = ((ArrayList) r103.f211955s).iterator();
        L6:
            boolean r107 = true;
            if (r106.hasNext() == false) goto L18;
            LinkRecordOption r108 = (LinkRecordOption) r106.next();
            String r109 = r108.getText();
            if (r109 != null) goto L11;
        L13:
            r107 = false;
        L14:
            if (r107 == false) goto L6;
            String r110 = r108.getId();
            if (r110 == null) goto L6;
            r105.add(r110);
            goto L6
        L11:
            if (StringsKt.contains(r109, r104, true) != true) goto L13;
        L18:
            b r111 = r103.f211954r;
            r111.getClass();
            Intrinsics.checkNotNullParameter(r105, "recordIds");
            ((ArrayList) r111.f211959a).clear();
            ((ArrayList) r111.f211959a).addAll(r105);
            r111.notifyDataSetChanged();
            LinkFilterValueEditViewHolder r112 = this.f211967a;
            if (r112.f211954r.getItemCount() <= 0) goto L22;
            r107 = false;
        L22:
            r112.p(r107, null);
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkFilterValueEditViewHolder f211969a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f211970b;

        public g(LinkFilterValueEditViewHolder r100, String r101) {
            this.f211969a = r100;
            this.f211970b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.e("LinkFilterValueEditViewHolder", "loadAllLinkRecords error", (Throwable) r100, false);
            LinkFilterValueEditViewHolder r101 = this.f211969a;
            r101.p(false, new l(r101, this.f211970b));
        }
    }

    public static final class h implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkFilterValueEditViewHolder f211971a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public h(LinkFilterValueEditViewHolder r100) {
            this.f211971a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            this.f211971a.s(StringsKt.trim(String.valueOf(r100)).toString());
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.i
    public final boolean b() {
        String[] r100 = this.f211957u;
        if ((!((ArrayList) this.f211956t).isEmpty()) == false) goto L5;
        String[] r101 = (String[]) ((ArrayList) this.f211956t).toArray(new String[0]);
    L7:
        return !Arrays.equals(r100, r101);
    L5:
        r101 = null;
        goto L7
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.a
    public final Object c() {
        if ((!((ArrayList) this.f211956t).isEmpty()) == true) goto L7;
        return null;
    L7:
        return (String[]) ((ArrayList) this.f211956t).toArray(new String[0]);
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.i
    public final View getView() {
        return this.f211947k;
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.n
    public final SpaceEmptyState i() {
        return this.f211951o;
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.n
    public final View j() {
        return this.f211950n;
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.n
    public final LottieAnimationView k() {
        return this.f211952p;
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.n
    public final RecyclerView l() {
        return this.f211953q;
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.n
    public final View m() {
        return this.f211947k;
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.n
    public final EditText n() {
        return this.f211948l;
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.n
    public final View o() {
        return this.f211949m;
    }

    public static final boolean r(LinkFilterValueEditViewHolder r100) {
        FilterFieldOption r101 = r100.f211973b;
        if (r101 == null) goto L5;
        boolean r102 = Intrinsics.areEqual(r101.getMultiple(), Boolean.FALSE);
    L6:
        if (r102 == true) goto L8;
        return false;
    L8:
        if (TextUtils.equals(r100.f211946j, EFilterOperator.Is.getValue()) == false) goto L10;
    L11:
        return true;
    L10:
        if (TextUtils.equals(r100.f211946j, EFilterOperator.IsNot.getValue()) == true) goto L11;
        return false;
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.a
    public final void h(Object r100) {
        String[] r101 = (String[]) r100;
        this.f211957u = r101;
        s("");
        ((ArrayList) this.f211956t).clear();
        if (r101 == null) goto L6;
        CollectionsKt.addAll(this.f211956t, r101);
        return;
    }

    public final void s(String r100) {
        com.bytedance.ee.util.ui.j.d(this.f212004i, 200);
        Single<String[]> r101 = d("getFieldLinkOptions", r100, false, LinkFilterValueEditViewHolder$loadLinkRecords$1.INSTANCE);
        if (r101 == null) goto L14;
        Single<R> r102 = r101.map(c.f211963a);
        if (r102 == 0) goto L15;
        Single r103 = r102.map(new d(this));
        if (r103 == null) goto L16;
        Single r104 = r103.flatMap(new e(r100, this));
        if (r104 == null) goto L17;
        Single r105 = r104.observeOn(fo5.d.d());
        if (r105 == null) goto L18;
        r105.subscribe(new f(this, r100), new g(this, r100));
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    public LinkFilterValueEditViewHolder(Context r100, FilterFieldOption r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100, r101);
        this.f211946j = r102;
        View r103 = LayoutInflater.from(r100).inflate(R.layout.bitable_link_filter_value_view, null);
        this.f211947k = r103;
        EditText r104 = (EditText) r103.findViewById(R.id.search_et);
        this.f211948l = r104;
        this.f211949m = r103.findViewById(R.id.loading_state_layout);
        this.f211950n = r103.findViewById(R.id.loading_layout);
        this.f211951o = (SpaceEmptyState) r103.findViewById(R.id.empty_state);
        this.f211952p = (LottieAnimationView) r103.findViewById(R.id.loading_lottie);
        RecyclerView r105 = (RecyclerView) r103.findViewById(R.id.recycler_view);
        this.f211953q = r105;
        b r106 = new b(this);
        this.f211954r = r106;
        this.f211955s = new ArrayList();
        this.f211956t = new ArrayList();
        r105.setLayoutManager(new LinearLayoutManager(r100));
        r105.setAdapter(r106);
        r104.addTextChangedListener(new h(this));
    }
}
