package com.larus.dora.o.impl.diary.style;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.common.style.OStateGradientDrawable;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.lisitem.OUICardConstraintLayout;
import com.obric.oui.swipeaction.OSwipeLayout;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0015\u0016\u0017BC\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0011H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/dora/o/impl/diary/style/ODiaryStyleAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/dora/o/impl/diary/style/ODiaryStyleViewModel$StyleUiItem;", "Lcom/larus/dora/o/impl/diary/style/ODiaryStyleAdapter$StyleViewHolder;", "onItemClick", "Lkotlin/Function1;", "", "onEditClick", "onDeleteClick", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "openedItem", "Lcom/obric/oui/lisitem/OCardListItem;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "Companion", "StyleViewHolder", "DiffCallback", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ODiaryStyleAdapter extends ListAdapter<ODiaryStyleViewModel.d, StyleViewHolder> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f338586e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<ODiaryStyleViewModel.d, Unit> f338587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<ODiaryStyleViewModel.d, Unit> f338588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<ODiaryStyleViewModel.d, Unit> f338589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OCardListItem f338590d;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/dora/o/impl/diary/style/ODiaryStyleAdapter$StyleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BrowserDependency.UrlClickType.CARD, "Lcom/obric/oui/lisitem/OCardListItem;", "onItemClick", "Lkotlin/Function1;", "Lcom/larus/dora/o/impl/diary/style/ODiaryStyleViewModel$StyleUiItem;", "", "onEditClick", "onDeleteClick", "onSwipeOpened", "<init>", "(Lcom/obric/oui/lisitem/OCardListItem;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "boundItem", "bind", MapController.ITEM_LAYER_TAG, "cardPosition", "", "restoreContentColor", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class StyleViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ int f338591g = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OCardListItem f338592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function1<ODiaryStyleViewModel.d, Unit> f338593b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function1<ODiaryStyleViewModel.d, Unit> f338594c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Function1<ODiaryStyleViewModel.d, Unit> f338595d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Function1<OCardListItem, Unit> f338596e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ODiaryStyleViewModel.d f338597f;

        public StyleViewHolder(OCardListItem r100, Function1 r101, Function1 r102, Function1 r103, com.larus.dora.o.impl.diary.style.a r104) {
            Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
            Intrinsics.checkNotNullParameter(r101, "onItemClick");
            Intrinsics.checkNotNullParameter(r102, "onEditClick");
            Intrinsics.checkNotNullParameter(r103, "onDeleteClick");
            Intrinsics.checkNotNullParameter(r104, "onSwipeOpened");
            super(r100);
            this.f338592a = r100;
            this.f338593b = r101;
            this.f338594c = r102;
            this.f338595d = r103;
            this.f338596e = r104;
            ColorStateList r105 = ContextCompat.getColorStateList(r100.getContext(), R.color.dora_o_bg_card);
            if (r105 != null) goto L5;
            r105 = ColorStateList.valueOf(ContextCompat.getColor(r100.getContext(), R.color.dora_o_bg_card));
        L5:
            r100.setContentContainerBgColor(r105);
            r100.getContentContainer().setForeground(ContextCompat.getDrawable(r100.getContext(), R.drawable.dora_o_fg_card_press_overlay));
            u69.b.a(r100, 20);
            Resources r106 = r100.getResources();
            int r107 = (int) ((WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics()).density * 8) + 0.5f);
            OUICardConstraintLayout r108 = r100.getContentContainer();
            r108.setPaddingRelative(r108.getPaddingStart(), r107, r108.getPaddingEnd(), r107);
            LinearLayout r109 = r100.getTitleContainer();
            r109.setPaddingRelative(r109.getPaddingStart(), r109.getPaddingTop(), r107, r109.getPaddingBottom());
            LinearLayout r110 = r100.getTitleContainer();
            Resources r111 = r100.getResources();
            r110.setMinimumWidth(WindowDisplayMetricsOverride.apply(r111, r111.getDisplayMetrics()).widthPixels);
            r100.getTitleView().setMaxLines(1);
            View r112 = r100.findViewById(R.id.custom_end_mark);
            if (r112 == null) goto L13;
            ViewGroup.LayoutParams r113 = r112.getLayoutParams();
            if ((r113 instanceof ViewGroup.MarginLayoutParams) == false) goto L10;
            ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) r113;
        L11:
            if (r114 == null) goto L13;
            r114.setMarginEnd(r114.getMarginEnd() + r107);
            r112.setLayoutParams(r114);
            goto L13
        L10:
            r114 = null;
        L13:
            r100.setSwipeView(R.layout.dora_o_view_style_swipe_actions);
            OSwipeLayout r115 = r100.getSwipeLayout();
            ((ArrayList) r115.f403098p).add(new e(this));
            View r116 = r100.getSwipeView();
            if (r116 == null) goto L18;
            ImageView r117 = (ImageView) r116.findViewById(R.id.style_swipe_edit);
            if (r117 == null) goto L18;
            r117.setOnClickListener(new com.larus.dora.o.impl.diary.style.b(this));
        L18:
            View r118 = r100.getSwipeView();
            if (r118 == null) goto L23;
            ImageView r119 = (ImageView) r118.findViewById(R.id.style_swipe_delete);
            if (r119 == null) goto L23;
            r119.setOnClickListener(new c(this));
        L23:
            r100.setOnContentClickListener(new d(this));
        }
    }

    public static final class a {
    }

    public static final class b extends DiffUtil.ItemCallback<ODiaryStyleViewModel.d> {
        public b() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public final boolean areContentsTheSame(ODiaryStyleViewModel.d r100, ODiaryStyleViewModel.d r101) {
            ODiaryStyleViewModel.d r102 = r100;
            ODiaryStyleViewModel.d r103 = r101;
            Intrinsics.checkNotNullParameter(r102, "oldItem");
            Intrinsics.checkNotNullParameter(r103, "newItem");
            return Intrinsics.areEqual(r102, r103);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public final boolean areItemsTheSame(ODiaryStyleViewModel.d r100, ODiaryStyleViewModel.d r101) {
            ODiaryStyleViewModel.d r102 = r100;
            ODiaryStyleViewModel.d r103 = r101;
            Intrinsics.checkNotNullParameter(r102, "oldItem");
            Intrinsics.checkNotNullParameter(r103, "newItem");
            return Intrinsics.areEqual(r102.f338610a, r103.f338610a);
        }
    }

    static {
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        StyleViewHolder r112 = (StyleViewHolder) r110;
        Intrinsics.checkNotNullParameter(r112, "holder");
        ODiaryStyleViewModel.d r113 = getItem(r111);
        r112.getClass();
        Intrinsics.checkNotNullParameter(r113, MapController.ITEM_LAYER_TAG);
        r112.f338597f = r113;
        Context r100 = r112.f338592a.getContext();
        OCardListItem.h(r112.f338592a, 0);
        String r101 = r100.getString(R.string.larus_dora_personal_diary_personalized_title_cn);
        boolean r102 = true;
        if (r113.f338615f == true) goto L5;
    L7:
        boolean r103 = false;
    L8:
        OCardListItem r104 = r112.f338592a;
        if (r103 == false) goto L11;
        SpannableStringBuilder r105 = new SpannableStringBuilder(r113.f338611b);
        String r106 = tb2.c.DEFAULT_TEXT + r100.getString(R.string.larus_dora_personal_diary_personalized_tag_cn);
        int r107 = r105.length();
        r105.append(r106);
        Resources r108 = r100.getResources();
        r105.setSpan(new AbsoluteSizeSpan((int) TypedValue.applyDimension(2, 11.0f, WindowDisplayMetricsOverride.apply(r108, r108.getDisplayMetrics()))), r107, r105.length(), 33);
        r105.setSpan(new ForegroundColorSpan(ContextCompat.getColor(r100, R.color.dora_o_text_secondary)), r107, r105.length(), 33);
        CharSequence r109 = r105;
    L12:
        r104.setTitle(r109);
        OCardListItem r114 = r112.f338592a;
        if (r113.f338611b.length() <= 0) goto L15;
        boolean r115 = true;
    L16:
        r114.s(r115);
        r112.f338592a.setSubTitle(r113.f338612c);
        OCardListItem r116 = r112.f338592a;
        if (r113.f338612c.length() > 0) goto L20;
        r102 = false;
    L20:
        r116.q(r102);
        r112.f338592a.m(r113.f338614e);
        r112.f338592a.setEnableSwipe(r113.f338615f);
        r112.f338592a.t();
        OCardListItem r117 = r112.f338592a;
        OStateGradientDrawable r118 = r117.f401324g;
        if (r118 == null) goto L24;
        r118.setSolidColors(r117.getContentContainerBgColor());
    L24:
        r112.f338592a.getContentContainer().setSelected(false);
        return;
    L15:
        r115 = false;
        goto L16
    L11:
        r109 = r113.f338611b;
        goto L12
    L5:
        if (StringsKt.startsWith$default(StringsKt.trim(r113.f338611b).toString(), r101, false, 2, null) == true) goto L7;
        r103 = true;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.dora.o.impl.diary.style.a] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.dora_o_item_diary_style, r100, false);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.obric.oui.lisitem.OCardListItem");
        return new StyleViewHolder((OCardListItem) r102, this.f338587a, this.f338588b, this.f338589c, new com.larus.dora.o.impl.diary.style.a(this));
    }

    public ODiaryStyleAdapter(o r100, p r101, q r102) {
        Intrinsics.checkNotNullParameter(r100, "onItemClick");
        Intrinsics.checkNotNullParameter(r101, "onEditClick");
        Intrinsics.checkNotNullParameter(r102, "onDeleteClick");
        super(new b());
        this.f338587a = r100;
        this.f338588b = r101;
        this.f338589c = r102;
    }
}
