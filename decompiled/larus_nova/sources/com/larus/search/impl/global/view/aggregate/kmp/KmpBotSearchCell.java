package com.larus.search.impl.global.view.aggregate.kmp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.flow.search.kmp.api.model.BotCreatorInfo;
import com.bytedance.flow.search.kmp.api.model.BotIconImageKmp;
import com.bytedance.flow.search.kmp.api.model.BotSearchResultItem;
import com.bytedance.flow.search.kmp.api.model.BotStatisticKmp;
import com.bytedance.flow.search.kmp.api.model.FlowSearchData;
import com.bytedance.flow.search.kmp.api.model.Position;
import com.bytedance.flow.search.kmp.api.model.RecommendBotKmp;
import com.bytedance.flow.search.kmp.api.model.SearchHighlightInfo;
import com.bytedance.flow.search.kmp.api.model.payload.BotPayload;
import com.larus.bmhome.bot.BotStatusCacheDelegate;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.bmhome.utils.a4;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.p0;
import com.larus.common_ui.dialog.u;
import com.larus.extension.aggregate_search_ui.api.BaseSearchListCell;
import com.larus.extension.aggregate_search_ui.api.kmp.KmpISearchEventTrackerAbility;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotStatistic;
import com.larus.nova.R;
import com.larus.search.impl.global.view.SearchResultItemView;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import v19.i5;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u001b\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J \u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J\u0012\u0010\u001e\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\fH\u0002J$\u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\"\u0018\u00010!2\u0010\u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010$\u0018\u00010!H\u0002J$\u0010%\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010&\u0018\u00010!2\u0010\u0010'\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010(\u0018\u00010!H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001c¨\u0006*"}, d2 = {"Lcom/larus/search/impl/global/view/aggregate/kmp/KmpBotSearchCell;", "Lcom/larus/extension/aggregate_search_ui/api/BaseSearchListCell;", "Lcom/larus/search/impl/global/view/aggregate/kmp/KmpBotSearchCellState;", "<init>", "()V", "layoutId", "", "getLayoutId", "()I", "resultItemView", "Lcom/larus/search/impl/global/view/SearchResultItemView;", "currentSourceData", "Lcom/bytedance/flow/search/kmp/api/model/FlowSearchData;", "currentPayload", "Lcom/bytedance/flow/search/kmp/api/model/payload/BotPayload;", "onViewCreated", "", "view", "Landroid/view/View;", "onBindView", "state", "position", "convertToGlobalItem", "Lcom/larus/search/impl/global/model/GlobalSearchResultItem;", "kmpItem", "Lcom/bytedance/flow/search/kmp/api/model/BotSearchResultItem;", "botEventHelper", "com/larus/search/impl/global/view/aggregate/kmp/KmpBotSearchCell$botEventHelper$1", "Lcom/larus/search/impl/global/view/aggregate/kmp/KmpBotSearchCell$botEventHelper$1;", "rebindCurrentView", "dispatchClickAction", "data", "mapHighlightInfos", "", "Lcom/larus/search/impl/global/model/SearchHighlightInfo;", "highlights", "Lcom/bytedance/flow/search/kmp/api/model/SearchHighlightInfo;", "mapPositions", "Lcom/larus/search/impl/global/model/Position;", "positions", "Lcom/bytedance/flow/search/kmp/api/model/Position;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpBotSearchCell extends BaseSearchListCell<com.larus.search.impl.global.view.aggregate.kmp.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f367740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SearchResultItemView f367741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FlowSearchData f367742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BotPayload f367743d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f367744e;

    public static final class a {
    }

    public static final class b implements SearchResultItemView.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KmpBotSearchCell f367745a;

        public static final class a implements p0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ RecommendBot f367746a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ KmpBotSearchCell f367747b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f367748c;

            @Override // com.larus.common_ui.dialog.p0
            public final void confirm() {
                BotStatusCacheDelegate r100 = BotStatusCacheDelegate.f296446b;
                String r101 = this.f367746a.o();
                if (r101 != null) goto L5;
                r101 = "";
            L5:
                r100.a(r101, false);
                KmpBotSearchCell r102 = this.f367747b;
                int r103 = this.f367748c;
                BotPayload r104 = r102.f367743d;
                FlowSearchData r105 = null;
                if (r104 == null) goto L12;
                ws9.b r106 = KmpBotSearchCell.c(r104.f243331j);
                SearchResultItemView r107 = r102.f367741b;
                if (r107 != null) goto L11;
                Intrinsics.throwUninitializedPropertyAccessException("resultItemView");
                r107 = null;
            L11:
                r107.a(r106, r103, r102.f367744e);
            L12:
                KmpBotSearchCell r108 = this.f367747b;
                FlowSearchData r109 = r108.f367742c;
                if (r109 == null) goto L15;
                r105 = FlowSearchData.a(r109, -2, null, 5);
            L15:
                KmpBotSearchCell.b(r108, r105);
            }

            public a(RecommendBot r100, KmpBotSearchCell r101, int r102) {
                this.f367746a = r100;
                this.f367747b = r101;
                this.f367748c = r102;
            }
        }

        /* JADX INFO: renamed from: com.larus.search.impl.global.view.aggregate.kmp.KmpBotSearchCell$b$b, reason: collision with other inner class name */
        public static final class C4481b implements u {
            public C4481b() {
            }

            @Override // com.larus.common_ui.dialog.u
            public final void cancel() {
            }
        }

        public b(KmpBotSearchCell r100) {
            this.f367745a = r100;
        }

        @Override // com.larus.search.impl.global.view.SearchResultItemView.b
        public final void a(RecommendBot r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            BotStatusCacheDelegate r102 = BotStatusCacheDelegate.f296446b;
            String r103 = r100.o();
            if (r103 != null) goto L5;
            r103 = "";
        L5:
            r102.a(r103, true);
            KmpBotSearchCell r104 = this.f367745a;
            BotPayload r105 = r104.f367743d;
            FlowSearchData r106 = null;
            if (r105 == null) goto L12;
            ws9.b r107 = KmpBotSearchCell.c(r105.f243331j);
            SearchResultItemView r108 = r104.f367741b;
            if (r108 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("resultItemView");
            r108 = null;
        L11:
            r108.a(r107, r101, r104.f367744e);
        L12:
            KmpBotSearchCell r109 = this.f367745a;
            FlowSearchData r110 = r109.f367742c;
            if (r110 == null) goto L15;
            r106 = FlowSearchData.a(r110, -1, null, 5);
        L15:
            KmpBotSearchCell.b(r109, r106);
        }

        @Override // com.larus.search.impl.global.view.SearchResultItemView.b
        public final void b(RecommendBot r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            RecyclerView r102 = this.f367745a.getParent();
            if (r102 == null) goto L5;
            Context r103 = r102.getContext();
        L7:
            if ((r103 instanceof FragmentActivity) == false) goto L9;
            FragmentActivity r104 = (FragmentActivity) r103;
        L10:
            if (r104 != null) goto L12;
            return;
        L12:
            a4.f314971a.getClass();
            a4.a(a4.f314972b);
            CommonDialog.a r105 = new CommonDialog.a();
            r105.i(r104.getString(R.string.larus_deleteChat_modalTitle_delete));
            r105.g(r104.getString(R.string.larus_bot_delete_chat_double_confirmation_text));
            CommonDialog.a.f(r105, new a(r100, this.f367745a, r101), r104.getString(R.string.larus_bot_delete_chat_double_confirmation_delete), false, 12);
            CommonDialog.a.e(r105, new C4481b(), r104.getString(R.string.larus_bot_delete_chat_double_confirmation_cancel), 4);
            CommonDialog r106 = r105.a();
            FragmentManager r107 = r104.getSupportFragmentManager();
            LandscapeRestrictionOperation r108 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r106, null, r108);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r107, r106, r108) == true) goto L21;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L18
        L16:
            r106.show(r107, null);
            return;
        L21:
            return;
        L9:
            r104 = null;
            goto L10
        L5:
            r103 = null;
            goto L7
        }

        @Override // com.larus.search.impl.global.view.SearchResultItemView.b
        public final void c(RecommendBot r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            KmpBotSearchCell r102 = this.f367745a;
            FlowSearchData r103 = r102.f367742c;
            FlowSearchData r104 = null;
            if (r103 == null) goto L5;
            r104 = FlowSearchData.a(r103, -3, null, 5);
        L5:
            KmpBotSearchCell.b(r102, r104);
        }

        @Override // com.larus.search.impl.global.view.SearchResultItemView.b
        public final void d(RecommendBot r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            KmpBotSearchCell r102 = this.f367745a;
            KmpBotSearchCell.b(r102, r102.f367742c);
        }
    }

    static {
    }

    public KmpBotSearchCell() {
        this.f367740a = R.layout.larus_item_search_bot_result;
        this.f367744e = new b(this);
    }

    @Override // com.larus.extension.aggregate_search_ui.api.BaseSearchListCell
    public final int getLayoutId() {
        return this.f367740a;
    }

    public static ws9.b c(BotSearchResultItem r410) {
        ArrayList r100 = null;
        if (r410 == null) goto L5;
        RecommendBotKmp r101 = r410.f243238a;
        if (r101 == null) goto L21;
        String r102 = r101.f243296a;
        String r103 = r101.f243297b;
        Integer r104 = r101.f243298c;
        BotIconImageKmp r105 = r101.f243300e;
        if (r105 == null) goto L11;
        BotIconImage r106 = new BotIconImage(r105.f243231a, r105.f243232b, r105.f243233c, r105.f243234d, null, 16, null);
    L12:
        String r110 = r101.f243302g;
        String r111 = r101.f243301f;
        BotCreatorInfo r107 = r101.f243299d;
        if (r107 == null) goto L15;
        com.larus.im.bean.bot.BotCreatorInfo r112 = new com.larus.im.bean.bot.BotCreatorInfo(r107.f243227a, r107.f243228b, null, 4, null);
    L16:
        BotStatisticKmp r108 = r101.f243303h;
        if (r108 == null) goto L19;
        BotStatistic r113 = new BotStatistic(r108.f243243a, r108.f243244b);
    L20:
        RecommendBot r109 = new RecommendBot(r102, r103, r104, null, r106, 0, 0, 0, r101.f243305j, r101.f243306k, null, r112, r113, null, r111, null, null, null, null, r101.f243304i, null, r110, null, null, null, null, null, null, null, null, null, null, null, null, false, null, -18966056, 8191);
    L22:
        List<SearchHighlightInfo> r114 = r410.f243239b;
        if (r114 == null) goto L50;
        List<SearchHighlightInfo> r115 = r114;
        ArrayList r116 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r115, 10));
        Iterator<T> r117 = r115.iterator();
    L26:
        if (r117.hasNext() == false) goto L48;
        SearchHighlightInfo r118 = (SearchHighlightInfo) r117.next();
        if (r118 == null) goto L30;
        String r119 = r118.f243316a;
    L31:
        if (r118 == null) goto L33;
        List<Position> r120 = r118.f243317b;
    L34:
        if (r120 == null) goto L46;
        List<Position> r121 = r120;
        ArrayList r122 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r121, 10));
        Iterator<T> r123 = r121.iterator();
    L37:
        if (r123.hasNext() == false) goto L47;
        Position r124 = (Position) r123.next();
        if (r124 == null) goto L41;
        Integer r125 = r124.f243292a;
    L42:
        if (r124 == null) goto L44;
        Integer r126 = r124.f243293b;
    L45:
        r122.add(new ws9.d(r125, r126));
        goto L37
    L44:
        r126 = null;
        goto L45
    L41:
        r125 = null;
    L47:
        r116.add(new ws9.e(r119, r122));
        goto L26
    L46:
        r122 = null;
        goto L47
    L33:
        r120 = null;
        goto L34
    L30:
        r119 = null;
        goto L31
    L48:
        r100 = r116;
    L50:
        return new ws9.b(r109, r100, r410.f243240c);
    L19:
        r113 = null;
        goto L20
    L15:
        r112 = null;
        goto L16
    L11:
        r106 = null;
        goto L12
    L21:
        r109 = null;
        goto L22
    L5:
        return new ws9.b(null, 7);
    }

    @Override // com.larus.extension.aggregate_search_ui.api.BaseSearchListCell, com.larus.list.arch.IFlowListCell
    public final void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        SearchResultItemView r101 = (SearchResultItemView) r100.findViewById(R.id.search_result_item_view);
        this.f367741b = r101;
        SearchResultItemView r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("resultItemView");
        r101 = null;
    L5:
        View r103 = r101.findViewById(R.id.avatar_parent);
        if (r103 == null) goto L12;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if (r104 == null) goto L11;
        r104.width = i5.d0();
        r104.height = i5.d0();
        r103.setLayoutParams(r104);
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L12:
        SearchResultItemView r105 = this.f367741b;
        if (r105 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("resultItemView");
        r105 = null;
    L15:
        View r106 = r105.findViewById(R.id.avatar);
        if (r106 == null) goto L22;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if (r107 == null) goto L21;
        r107.width = i5.d0();
        r107.height = i5.d0();
        r106.setLayoutParams(r107);
        goto L22
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L22:
        SearchResultItemView r108 = this.f367741b;
        if (r108 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("resultItemView");
        r108 = null;
    L25:
        View r109 = r108.findViewById(R.id.text_lay);
        if (r109 == null) goto L28;
        r109.setMinimumHeight(i5.g0());
        r109.setPadding(0, i5.Y(), 0, 0);
    L28:
        SearchResultItemView r110 = this.f367741b;
        if (r110 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("resultItemView");
        r110 = null;
    L31:
        View r111 = r110.findViewById(R.id.description);
        if (r111 == null) goto L38;
        r111.setVisibility(4);
        r111.setMinimumHeight(0);
        ViewGroup.LayoutParams r112 = r111.getLayoutParams();
        if (r112 == null) goto L37;
        r112.height = 0;
        r111.setLayoutParams(r112);
        goto L38
    L37:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L38:
        SearchResultItemView r113 = this.f367741b;
        if (r113 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("resultItemView");
        r113 = null;
    L41:
        View r114 = r113.findViewById(R.id.add_bot_lay);
        if (r114 == null) goto L48;
        ViewGroup.LayoutParams r115 = r114.getLayoutParams();
        if (r115 == null) goto L47;
        r115.width = i5.d0();
        r115.height = i5.d0();
        r114.setLayoutParams(r115);
        goto L48
    L47:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L48:
        SearchResultItemView r116 = this.f367741b;
        if (r116 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("resultItemView");
    L52:
        View r117 = r102.findViewById(R.id.add_bot);
        if (r117 == null) goto L59;
        ViewGroup.LayoutParams r118 = r117.getLayoutParams();
        if (r118 == null) goto L58;
        r118.width = i5.J();
        r118.height = i5.J();
        r117.setLayoutParams(r118);
        return;
    L58:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L59:
        return;
    L51:
        r102 = r116;
        goto L52
    }

    public static final void b(KmpBotSearchCell r100, FlowSearchData r101) {
        if (r101 != null) goto L4;
        r100.getClass();
        return;
    L4:
        BotPayload r102 = r100.f367743d;
        if (r102 == null) goto L9;
        t1a.b r103 = r102.f243290g;
        if (r103 == null) goto L9;
        KmpISearchEventTrackerAbility r104 = (KmpISearchEventTrackerAbility) r103.o(Reflection.getOrCreateKotlinClass(KmpISearchEventTrackerAbility.class));
    L10:
        if (r104 == null) goto L12;
        r104.trackSearchResultClick(r101);
    L12:
        BotPayload r105 = r100.f367743d;
        if (r105 == null) goto L17;
        r105.a(new aw5.a.b(r101));
        return;
    L17:
        return;
    L9:
        r104 = null;
        goto L10
    }

    @Override // com.larus.extension.aggregate_search_ui.api.BaseSearchListCell, com.larus.list.arch.IFlowListCell
    public final void onBindView(View r100, ei9.f r101, int r102) {
        com.larus.search.impl.global.view.aggregate.kmp.b r103 = (com.larus.search.impl.global.view.aggregate.kmp.b) r101;
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r103, "state");
        BotPayload r104 = r103.f367773a;
        this.f367742c = r104.f243291h;
        this.f367743d = r104;
        ws9.b r105 = c(r104.f243331j);
        SearchResultItemView r106 = this.f367741b;
        if (r106 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("resultItemView");
        r106 = null;
    L5:
        r106.a(r105, r102, this.f367744e);
    }
}
