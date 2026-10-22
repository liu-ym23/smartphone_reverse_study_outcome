package com.larus.home.impl.main.side_bar.feed.cell;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.larus.home.impl.databinding.LarusItemSideBarProjectBinding;
import com.larus.home.impl.main.side_bar.data.SideBarItemType;
import com.larus.home.impl.main.side_bar.data.j0;
import com.larus.home.impl.main.side_bar.feed.arch.CardFeedSlot;
import com.larus.home.impl.main.side_bar.feed.arch.t;
import com.larus.home.impl.main.side_bar.feed.arch.w;
import com.larus.home.impl.main.side_bar.view.adapter.x0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 12\u00020\u0001:\u00011B\u008f\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0005\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012 \u0010\u0010\u001a\u001c\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\t0\u0005\u0012\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0010\u0010!\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0006\u0010\"\u001a\u00020\tJ\u0018\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0006H\u0002J\b\u0010&\u001a\u00020\tH\u0002J\u0010\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020\tH\u0002J\u0006\u0010+\u001a\u00020\tJ\u0012\u0010,\u001a\b\u0012\u0004\u0012\u00020\b0-*\u00020\u001eH\u0002J\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\b0/*\u00020\b2\u0006\u00100\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/larus/home/impl/main/side_bar/feed/cell/SideBarProjectHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/home/impl/databinding/LarusItemSideBarProjectBinding;", "onShowAllClick", "Lkotlin/Function3;", "", "", "Lcom/larus/home/impl/main/side_bar/data/SideBarItemConfig;", "", "onCreateConversationInProject", "Lkotlin/Function1;", "conversationBridge", "Lcom/larus/home/impl/main/side_bar/view/ISideBarConversationBridge;", "contentBridge", "Lcom/larus/home/impl/main/side_bar/view/ISideBarContentBridge;", "onConversationItemClicked", "onConversationItemShown", "Lkotlin/Function2;", "<init>", "(Lcom/larus/home/impl/databinding/LarusItemSideBarProjectBinding;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lcom/larus/home/impl/main/side_bar/view/ISideBarConversationBridge;Lcom/larus/home/impl/main/side_bar/view/ISideBarContentBridge;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;)V", "projectId", "projectHeaderView", "Landroid/view/View;", "getProjectHeaderView", "()Landroid/view/View;", "conversationFeedSource", "Lcom/larus/home/impl/main/side_bar/feed/arch/CardFeedSlot;", "bind", MapController.ITEM_LAYER_TAG, "Lcom/larus/home/impl/main/side_bar/view/group/datasource/im/SideBarProjectItemUiModel;", "selectionKey", "Lcom/larus/home/api/feed/FlowFeedSelectionKey;", "updateSelection", "recycle", "lifecycleDetail", "oldProjectId", "newProjectId", "updateTitleEndGradientVisibility", "bindProjectIcon", "isExpanded", "", "requestHostRecyclerViewLayout", "reportVisibleConversationCells", "toConversationItems", "", "toFlowFeedCard", "Lcom/larus/home/api/feed/FlowUIFeedCard;", "index", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SideBarProjectHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f344650f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusItemSideBarProjectBinding f344651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function3<String, Integer, j0, Unit> f344652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<String, Unit> f344653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f344654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CardFeedSlot f344655e;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f344656a = null;

        static {
            int[] r100 = new int[SideBarItemType.values().length];
            r100[SideBarItemType.CONVERSATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[SideBarItemType.SHOW_ALL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[SideBarItemType.COMPONENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f344656a = r100;
        }
    }

    static {
    }

    public final String T3(String r100, String r101) {
        return "holder=" + t.e(this) + " oldProject=" + t.d(r100) + " newProject=" + t.d(r101) + " bindingPosition=" + getBindingAdapterPosition() + " absolutePosition=" + getAbsoluteAdapterPosition() + " attached=" + this.itemView.isAttachedToWindow();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.larus.home.impl.main.side_bar.feed.cell.m] */
    public SideBarProjectHolder(LarusItemSideBarProjectBinding r110, Function3<? super String, ? super Integer, ? super j0, Unit> r111, Function1<? super String, Unit> r112, com.larus.home.impl.main.side_bar.view.c r113, com.larus.home.impl.main.side_bar.view.b r114, Function3<? super Integer, ? super j0, ? super String, Unit> r115, Function2<? super Integer, ? super j0, Unit> r210) {
        Intrinsics.checkNotNullParameter(r110, "binding");
        Intrinsics.checkNotNullParameter(r111, "onShowAllClick");
        Intrinsics.checkNotNullParameter(r112, "onCreateConversationInProject");
        Intrinsics.checkNotNullParameter(r113, "conversationBridge");
        Intrinsics.checkNotNullParameter(r114, "contentBridge");
        Intrinsics.checkNotNullParameter(r115, "onConversationItemClicked");
        Intrinsics.checkNotNullParameter(r210, "onConversationItemShown");
        super(r110.f344315a);
        this.f344651a = r110;
        this.f344652b = r111;
        this.f344653c = r112;
        this.f344654d = "";
        w r116 = new w();
        r116.a(new tb9.a(r113, r114, r115, r210, 0.5f));
        r116.a(new tb9.i(new l(this), r210));
        r116.a(new tb9.c(new m(this)));
        Unit r100 = Unit.INSTANCE;
        CardFeedSlot r101 = new CardFeedSlot("side_bar_project_conversations", r116, r114.getFragment(), r110.f344318d, new SideBarProjectHolder$conversationFeedSource$2(r114));
        this.f344655e = r101;
        x0.c(r110.f344319e, false);
        RecyclerView r102 = r110.f344318d;
        r102.setLayoutManager(new LinearLayoutManager(r102.getContext()));
        r102.setAdapter(r101.f344561i);
        r102.setItemAnimator(null);
        r102.setNestedScrollingEnabled(false);
        r102.setHasFixedSize(false);
    }
}
