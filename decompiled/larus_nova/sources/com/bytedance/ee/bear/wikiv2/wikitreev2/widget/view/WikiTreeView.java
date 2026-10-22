package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.common.widget.InterceptableRecyclerView;
import com.bytedance.ee.bear.wikiv2.sidebar.wikitree.widget.view.SidebarTreeView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.WikiDividerDecoration;
import com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.WikiHoriScrollManager$initScrollViews$1$2;
import com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.WikiHorizontalScrollView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.WikiItemBackgroundDecoration;
import com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.WikiScrollTextView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikNodeType;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiHomePageV2;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.d3;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.oubowu.stickyitemdecoration.StickyHeadContainer;
import com.oubowu.stickyitemdecoration.StickyItemDecoration;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.larkicon.IconScene;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 ¸\u00012\u00020\u0001:\u0006¸\u0001¹\u0001º\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0081\u0001\u001a\u00020@H\u0016J\r\u0010\u0082\u0001\u001a\u00060$R\u00020\u0000H\u0016J\n\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0014J\t\u0010\u0085\u0001\u001a\u00020\u0007H\u0002J\n\u0010\u0086\u0001\u001a\u00030\u0084\u0001H\u0002J\u0014\u0010\u0087\u0001\u001a\u00030\u0084\u00012\b\u0010\u0088\u0001\u001a\u00030\u0089\u0001H\u0016J\u0012\u0010\u008a\u0001\u001a\u00030\u0084\u00012\b\u0010c\u001a\u0004\u0018\u00010dJ\n\u0010\u008b\u0001\u001a\u00030\u0084\u0001H\u0002J\u0011\u0010\u008c\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u008d\u0001\u001a\u00020.J\u001c\u0010\u008e\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u008f\u0001\u001a\u00020:2\t\b\u0002\u0010\u0090\u0001\u001a\u00020:J)\u0010\u0091\u0001\u001a\u00030\u0084\u00012\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010:2\t\u0010\u0092\u0001\u001a\u0004\u0018\u00010:2\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010:J\u0012\u0010\u0094\u0001\u001a\u00030\u0084\u00012\b\u0010\u0095\u0001\u001a\u00030\u0096\u0001J\u0011\u0010\u0097\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u008f\u0001\u001a\u00020:J\u001b\u0010\u0098\u0001\u001a\u00030\u0084\u00012\b\u0010\u0099\u0001\u001a\u00030\u009a\u00012\u0007\u0010\u009b\u0001\u001a\u00020@J\u0011\u0010\u009c\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u0090\u0001\u001a\u00020:J\u0013\u0010\u009c\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u009d\u0001\u001a\u00020\u0007H\u0002J\u001c\u0010\u009e\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u008f\u0001\u001a\u00020:2\t\b\u0002\u0010\u0090\u0001\u001a\u00020:J\t\u0010\u009f\u0001\u001a\u00020@H\u0002J\u001c\u0010 \u0001\u001a\u00030\u0084\u00012\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010:2\u0007\u0010¡\u0001\u001a\u00020@J\u001a\u0010¢\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u0090\u0001\u001a\u00020:2\u0007\u0010£\u0001\u001a\u00020@J#\u0010¤\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u0090\u0001\u001a\u00020:2\u0007\u0010¥\u0001\u001a\u00020\u00072\u0007\u0010¦\u0001\u001a\u00020@J\u0012\u0010§\u0001\u001a\u00020@2\u0007\u0010¨\u0001\u001a\u00020KH\u0004J\u0010\u0010©\u0001\u001a\u00020@2\u0007\u0010\u008f\u0001\u001a\u00020:J\u0013\u0010ª\u0001\u001a\u0005\u0018\u00010«\u00012\u0007\u0010\u009d\u0001\u001a\u00020\u0007J\u0012\u0010¬\u0001\u001a\u00030\u0084\u00012\b\u0010\u00ad\u0001\u001a\u00030®\u0001J\b\u0010¯\u0001\u001a\u00030\u0084\u0001J\u0012\u0010°\u0001\u001a\u00030\u0084\u00012\b\u0010\u00ad\u0001\u001a\u00030®\u0001J\b\u0010±\u0001\u001a\u00030\u0084\u0001J\u001c\u0010²\u0001\u001a\u00030\u0084\u00012\u0010\u0010³\u0001\u001a\u000b\u0012\u0005\u0012\u00030´\u0001\u0018\u00010IH\u0016J\u0010\u0010µ\u0001\u001a\t\u0012\u0005\u0012\u00030´\u00010IH\u0016J\u0014\u0010¶\u0001\u001a\u00020@2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010:H\u0002J\n\u0010·\u0001\u001a\u00030\u0084\u0001H\u0014R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00128FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00188FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001e8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0012\u0010#\u001a\u00060$R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020&X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020*X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u000104X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001a\u0010E\u001a\u00020@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010B\"\u0004\bG\u0010DR,\u0010H\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020@0J0IX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u0011\u0010P\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u001a\u0010S\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010R\"\u0004\bU\u0010VR\u001c\u0010W\u001a\u0004\u0018\u00010XX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u001a\u0010]\u001a\u00020:X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010<\"\u0004\b_\u0010>R\u000e\u0010`\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010c\u001a\u0004\u0018\u00010dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010e\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010fR\u000e\u0010g\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010h\u001a\u0004\u0018\u00010:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010<\"\u0004\bj\u0010>R\u001c\u0010k\u001a\u0004\u0018\u00010lX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR(\u0010r\u001a\u0004\u0018\u00010:2\b\u0010q\u001a\u0004\u0018\u00010:@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010<\"\u0004\bt\u0010>R\u001a\u0010u\u001a\u00020@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010B\"\u0004\bv\u0010DR\u001e\u0010w\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010f\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R\u0010\u0010|\u001a\u0004\u0018\u00010}X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010~\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\r\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0004\b~\u0010B¨\u0006»\u0001"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "recyclerViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/common/widget/InterceptableRecyclerView;", "getRecyclerViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/common/widget/InterceptableRecyclerView;", "setRecyclerViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/common/widget/InterceptableRecyclerView;)V", "stickyHeadContainerFromXml", "Lcom/oubowu/stickyitemdecoration/StickyHeadContainer;", "getStickyHeadContainerFromXml", "()Lcom/oubowu/stickyitemdecoration/StickyHeadContainer;", "setStickyHeadContainerFromXml", "(Lcom/oubowu/stickyitemdecoration/StickyHeadContainer;)V", "stickyHeadFromXml", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikItemRootView;", "getStickyHeadFromXml", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikItemRootView;", "setStickyHeadFromXml", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikItemRootView;)V", "stickyHeadHomePageFromXml", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikItemHomePageView;", "getStickyHeadHomePageFromXml", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikItemHomePageView;", "setStickyHeadHomePageFromXml", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikItemHomePageView;)V", "wikiAdapter", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeView$WikiAdapter;", "linearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getLinearLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "scrollManager", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/scroll/WikiHoriScrollManager;", "getScrollManager", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/scroll/WikiHoriScrollManager;", "wikiUIList", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/WikiUIList;", "getWikiUIList", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/WikiUIList;", "setWikiUIList", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/WikiUIList;)V", "listener", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeView$IListener;", "getListener", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeView$IListener;", "setListener", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeView$IListener;)V", "disableToken", "", "getDisableToken", "()Ljava/lang/String;", "setDisableToken", "(Ljava/lang/String;)V", "enableSwipeMenu", "", "getEnableSwipeMenu", "()Z", "setEnableSwipeMenu", "(Z)V", "enableDiffRender", "getEnableDiffRender", "setEnableDiffRender", "enableRootCheckers", "", "Lio/reactivex/functions/Function;", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/UITreeNode;", "getEnableRootCheckers", "()Ljava/util/List;", "setEnableRootCheckers", "(Ljava/util/List;)V", "indicatorPadding", "getIndicatorPadding", "()I", "titleRightMargin", "getTitleRightMargin", "setTitleRightMargin", "(I)V", "userComponentAbility", "Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "getUserComponentAbility", "()Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "setUserComponentAbility", "(Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;)V", "focusToken", "getFocusToken", "setFocusToken", "focusUid", "oldFocusUid", "oldFocus", "homePageV2", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/WikiHomePageV2;", "recyclerInitialPaddingTop", "Ljava/lang/Integer;", "stickyHomePageInsetTop", "source", "getSource", "setSource", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "setFragment", "(Landroidx/fragment/app/Fragment;)V", "value", "spaceId", "getSpaceId", "setSpaceId", "isMyLib", "setMyLib", "spaceType", "getSpaceType", "()Ljava/lang/Integer;", "setSpaceType", "(Ljava/lang/Integer;)V", "scrollToRunnable", "Ljava/lang/Runnable;", "isWikiRootCustomHomePageEnable", "isWikiRootCustomHomePageEnable$delegate", "Lkotlin/Lazy;", "isSidebarView", "getWikiAdapter", "initView", "", "computeStickyHomePageInsetTop", "applyStickyHomePageInsetIfNeeded", "initStickyHeadView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "updateHomePage", "refreshHomePageView", "setData", "data", "setFocus", WikiFolderPushPlugin.WIKI_TOKEN, "uid", "updateTitleAndIcon", "newTitle", "newIconInfo", "handlePushToken", com.bytedance.android.ec.core.event.a.VALUE_CLICK_TYPE, "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/Ok;", "scrollItemToCenterByToken", "scrollHorizontally", "scrollX", "", "dismiss", "scrollItemToCenter", "position", "setItemFocus", "disableNotifyAll", "setItemLoading", "isLoading", "setSwipeMenuOpen", "isOpen", "setMenuEnable", "menuId", "enable", "isItemEnable", "node", "isFocus", "getViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "addHeader", "view", "Landroid/view/View;", "removeHeader", "setFooter", "removeFooter", "setItemDecorations", "decors", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getDefaultItemDecorations", "isValidUid", "onDetachedFromWindow", "Companion", "WikiAdapter", "IListener", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class WikiTreeView extends FrameLayout {
    public static final /* synthetic */ int E = 0;
    public boolean A;
    public Integer B;
    public c C;
    public final Lazy D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InterceptableRecyclerView f242354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public StickyHeadContainer f242355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WikItemRootView f242356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WikItemHomePageView f242357d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WikiAdapter f242358e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinearLayoutManager f242359f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.a f242360g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d3 f242361h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f242362i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f242363j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f242364k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f242365l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<? extends Function<com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j, Boolean>> f242366m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f242367n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f242368o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ce5.a f242369p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f242370q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f242371r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f242372s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f242373t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public WikiHomePageV2 f242374u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Integer f242375v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f242376w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f242377x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Fragment f242378y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f242379z;

    @Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0096\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\u0015\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0000¢\u0006\u0002\b\u001bJ\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0018H\u0014J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0014J\u0018\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0002H\u0014J\u001e\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u000bJ\u0016\u0010(\u001a\u00020\u00142\u0006\u0010%\u001a\u00020)2\u0006\u0010#\u001a\u00020\u0002J\u0018\u0010*\u001a\u00020\u00142\u0006\u0010%\u001a\u00020+2\u0006\u0010#\u001a\u00020\u0002H\u0016J\u0018\u0010,\u001a\u00020\u00142\u0006\u0010%\u001a\u00020-2\u0006\u0010#\u001a\u00020\u0002H\u0016J.\u0010.\u001a\u00020\u00142\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002002\n\b\u0002\u00102\u001a\u0004\u0018\u0001032\n\b\u0002\u00104\u001a\u0004\u0018\u000103J\u0018\u00105\u001a\u0002032\u0006\u0010#\u001a\u00020\u00022\u0006\u00106\u001a\u00020\u000bH\u0016J\u0010\u00107\u001a\u0002032\u0006\u0010#\u001a\u00020\u0002H\u0016J\u0010\u00108\u001a\u0002032\u0006\u0010#\u001a\u00020\u0002H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u00069"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeView$WikiAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/UITreeNode;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "<init>", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeView;)V", "innerTreeIconFactory", "Lcom/bytedance/ee/bear/wikiv2/icon/WikiTreeIconFactory;", "getInnerTreeIconFactory", "()Lcom/bytedance/ee/bear/wikiv2/icon/WikiTreeIconFactory;", "innerSidebarEnable", "", "getInnerSidebarEnable", "()Z", "setInnerSidebarEnable", "(Z)V", "innerWikiCustomSpaceIconEnable", "getInnerWikiCustomSpaceIconEnable", "setInnerWikiCustomSpaceIconEnable", "setDefNewData", "", "data", "", "getParentViewWidth", "", "getItemHeight", "position", "getItemHeight$contentmanager_wiki_impl_v2_productionChinaRelease", "onCreateDefViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getDefItemViewType", "convert", "holder", "node", "bindRootView", "view", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikItemRootView;", "fromStikyHeader", "bindNoneView", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikItemNoneView;", "bindDirView", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikItemDirView;", "bindItemView", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikItemLeafView;", "notifyDiffDataSetChange", "olds", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/WikiUIList;", "news", "oldFocus", "", "newFocus", "getRootTitle", "isMyLib", "getNoneTitle", "getItemTitle", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public class WikiAdapter extends BaseQuickAdapter<com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j, BaseViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.ee.bear.wikiv2.icon.d f242380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f242381b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f242382c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ WikiTreeView f242383d;

        public static final class a implements com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.d.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ WikiTreeView f242384a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j f242385b;

            public a(WikiTreeView r100, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r101) {
                this.f242384a = r100;
                this.f242385b = r101;
            }

            @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.d.a
            public final void a(int r100, View r101) {
                b r102 = this.f242384a.getListener();
                if (r102 == null) goto L6;
                r102.a(this.f242385b, r100, r101);
                return;
            }
        }

        public static final class b implements com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.d.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ WikiTreeView f242386a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j f242387b;

            public b(WikiTreeView r100, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r101) {
                this.f242386a = r100;
                this.f242387b = r101;
            }

            @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.d.b
            public final void a(boolean r100) {
                b r101 = this.f242386a.getListener();
                if (r101 == null) goto L6;
                r101.b(this.f242387b, r100);
                return;
            }
        }

        public static final class c implements WikItemLeafView.e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ WikiTreeView f242388a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j f242389b;

            public c(WikiTreeView r100, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r101) {
                this.f242388a = r100;
                this.f242389b = r101;
            }

            @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView.e
            public final void a() {
                WikiTreeView r100 = this.f242388a;
                com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r101 = this.f242389b;
                r100.l(r101.f241914b, r101.f241926n);
                b r102 = this.f242388a.getListener();
                if (r102 == null) goto L6;
                r102.c(this.f242389b);
                return;
            }
        }

        public static final class d implements WikItemDirView.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ WikiTreeView f242390a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j f242391b;

            public d(WikiTreeView r100, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r101) {
                this.f242390a = r100;
                this.f242391b = r101;
            }

            @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemDirView.b
            public final void a(boolean r100) {
                b r101 = this.f242390a.getListener();
                if (r101 == null) goto L6;
                r101.f(this.f242391b, r100);
                return;
            }
        }

        public static final class e implements WikItemDirView.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ WikiTreeView f242392a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j f242393b;

            public e(WikiTreeView r100, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r101) {
                this.f242392a = r100;
                this.f242393b = r101;
            }

            @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemDirView.b
            public final void a(boolean r100) {
                b r101 = this.f242392a.getListener();
                if (r101 == null) goto L6;
                r101.f(this.f242393b, r100);
                return;
            }
        }

        public static final class f implements WikItemLeafView.e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f242394a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ WikiTreeView f242395b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j f242396c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ WikItemRootView f242397d;

            public f(Ref.BooleanRef r100, WikiTreeView r101, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r102, WikItemRootView r103) {
                this.f242394a = r100;
                this.f242395b = r101;
                this.f242396c = r102;
                this.f242397d = r103;
            }

            @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView.e
            public final void a() {
                if (this.f242394a.element == false) goto L7;
                WikiTreeView r100 = this.f242395b;
                com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r101 = this.f242396c;
                r100.l(r101.f241914b, r101.f241926n);
                b r102 = this.f242395b.getListener();
                if (r102 == null) goto L11;
                r102.c(this.f242396c);
                return;
            L11:
                return;
            L7:
                b r103 = this.f242395b.getListener();
                if (r103 == null) goto L13;
                r103.f(this.f242396c, !this.f242397d.f242217u);
                return;
            }
        }

        public WikiAdapter(WikiTreeView r100) {
            this.f242383d = r100;
            super(0);
            this.f242380a = new com.bytedance.ee.bear.wikiv2.icon.d();
            this.f242381b = qc5.a.h();
            this.f242382c = qc5.a.l();
        }

        public static String D2(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r100) {
            Intrinsics.checkNotNullParameter(r100, "node");
            int r101 = g.f242482a;
            Intrinsics.checkNotNullParameter(r100, "node");
            if (r100.f241924l == false) goto L9;
            if (r100.f241916d != 111) goto L7;
            String r102 = eu5.b.f474075a.getString(R.string.CreationDoc_Folder_KeyInvalid);
            Intrinsics.checkNotNull(r102);
            return r102;
        L7:
            String r103 = eu5.b.f474075a.getString(R.string.CreationDoc_Docs_KeyInvalid);
            Intrinsics.checkNotNull(r103);
            return r103;
        L9:
            if (TextUtils.isEmpty(r100.f241917e) == false) goto L11;
            String r104 = com.bytedance.ee.bear.list.t0.e(eu5.b.f474075a, r100.f241916d);
            Intrinsics.checkNotNull(r104);
            return r104;
        L11:
            String r105 = r100.f241917e;
            Intrinsics.checkNotNull(r105);
            return r105;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void E2(List<com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j> r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.mData = r100;
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        public final int getDefItemViewType(int r100) {
            return ((com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j) ListProtector.get(this.f242383d.getWikiUIList().f241799a, r100)).f241929q;
        }

        public final void A2(WikItemNoneView r100, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "node");
            Intrinsics.checkNotNullParameter(r101, "node");
            int r102 = g.f242482a;
            Intrinsics.checkNotNullParameter(r101, "node");
            if (TextUtils.equals("wikiroot%favorite", r101.f241918f) == false) goto L5;
            String r103 = eu5.b.f474075a.getString(R.string.CreationMobile_Wiki_NoPage_Placeholder);
            Intrinsics.checkNotNull(r103);
        L6:
            r100.setTitle(r103);
            r100.g(r101.f241927o, this.f242383d.getWikiUIList().f241800b);
            return;
        L5:
            r103 = eu5.b.f474075a.getString(R.string.CreationMobile_Wiki_NoSubpages_Placeholder);
            Intrinsics.checkNotNull(r103);
            goto L6
        }

        public void C2(BaseViewHolder r100, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r101) {
            Intrinsics.checkNotNullParameter(r100, "holder");
            Intrinsics.checkNotNullParameter(r101, "node");
            View r102 = r100.itemView;
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView");
            WikItemLeafView r103 = (WikItemLeafView) r102;
            r103.f();
            int r104 = r100.getItemViewType();
            if (r104 != WikNodeType.ROOT.getValue()) goto L6;
            B2((WikItemRootView) r103, r101, false);
            return;
        L6:
            if (r104 != WikNodeType.NONE.getValue()) goto L9;
            A2((WikItemNoneView) r103, r101);
            return;
        L9:
            if (r104 != WikNodeType.DIR.getValue()) goto L11;
            y2((WikItemDirView) r103, r101);
            return;
        L11:
            z2(r103, r101);
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        public /* bridge */ /* synthetic */ void convert(BaseViewHolder r100, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r101) {
            C2(r100, r101);
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        public BaseViewHolder onCreateDefViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            if (r101 != WikNodeType.ROOT.getValue()) goto L6;
            BaseViewHolder r102 = new BaseViewHolder(new WikItemRootView(this.f242383d.getContext()));
        L12:
            View r103 = r102.itemView;
            if ((r103 instanceof WikItemLeafView) == false) goto L15;
            WikItemLeafView r104 = (WikItemLeafView) r103;
        L16:
            if (r104 == null) goto L18;
            r104.setScrollManager(this.f242383d.getScrollManager());
        L18:
            return r102;
        L15:
            r104 = null;
            goto L16
        L6:
            if (r101 != WikNodeType.NONE.getValue()) goto L9;
            r102 = new BaseViewHolder(new WikItemNoneView(this.f242383d.getContext()));
            goto L12
        L9:
            if (r101 != WikNodeType.DIR.getValue()) goto L11;
            r102 = new BaseViewHolder(new WikItemDirView(this.f242383d.getContext()));
            goto L12
        L11:
            r102 = new BaseViewHolder(new WikItemLeafView(this.f242383d.getContext()));
            goto L12
        }

        public void y2(WikItemDirView r100, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "node");
            Gson r102 = dr5.a.f469776a;
            dr5.a.C5703a.a(r101, r100.getIndicatorView());
            z2(r100, r101);
        }

        public void z2(WikItemLeafView r100, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "node");
            r100.setIconPadding(0);
            com.bytedance.ee.bear.wikiv2.icon.d r102 = this.f242380a;
            com.bytedance.ee.bear.wikiv2.icon.c r103 = new com.bytedance.ee.bear.wikiv2.icon.c();
            WikiTreeView r104 = this.f242383d;
            String r105 = r101.f241914b;
            r104.getClass();
            Intrinsics.checkNotNullParameter(r105, WikiFolderPushPlugin.WIKI_TOKEN);
            boolean r106 = true;
            if (TextUtils.isEmpty(r104.f242370q) == false) goto L5;
        L7:
            boolean r107 = false;
        L8:
            r103.f240967a = r107;
            r103.f240968b = true;
            r103.f240969c = false;
            r103.f240970d = this.f242381b;
            r103.f240971e = this.f242382c;
            Unit r108 = Unit.INSTANCE;
            r102.a(r101, r100, r103, this.f242383d.getUserComponentAbility());
            r100.setTitle(D2(r101));
            r100.setTitleStyle(Typeface.DEFAULT);
            r100.g(r101.f241927o, this.f242383d.getWikiUIList().f241800b);
            r100.setFocus(TextUtils.equals(r101.f241914b, this.f242383d.getFocusToken()));
            r100.setSwipeMenuEnable(this.f242383d.getEnableSwipeMenu());
            r100.setMenuClickEnable(r101.f241931s);
            int r109 = this.f242383d.getTitleRightMargin();
            View r110 = r100.findViewById(R.id.title);
            if (r110 != null) goto L11;
        L13:
            r100.setSwipeMenuClickListener(new a(this.f242383d, r101));
            r100.setUserSwipeMenuListener(new b(this.f242383d, r101));
            r100.setItemClickListener(new c(this.f242383d, r101));
            if (r101.c() == false) goto L17;
            WikItemDirView r111 = (WikItemDirView) r100;
            r111.setLoading(false);
            r111.setExpand(r101.f241928p);
            r111.setExpandClickListener(new d(this.f242383d, r101));
        L17:
            if (this.f242383d.e(r101) == true) goto L21;
            r100.d();
            return;
        L21:
            if (r101.f241925m == true) goto L23;
        L24:
            ce5.a r112 = this.f242383d.getUserComponentAbility();
            if (r112 == null) goto L33;
            BenefitManagerAPI r113 = r112.f23452g;
            if (r113 == null) goto L33;
            BenefitStore r114 = r113.n1();
            if (r114 == null) goto L33;
            if (r114.hasBenefit("common_wiki_node_management") == true) goto L33;
        L34:
            if (r106 == false) goto L36;
        L39:
            r100.i(R.id.swipe_menu_add, false);
            return;
        L36:
            if (this.f242383d.g() == true) goto L38;
            return;
        L38:
            if (r101.f241933u == true) goto L39;
            return;
        L33:
            r106 = false;
            goto L34
        L23:
            if (r101.e() == true) goto L39;
        L11:
            if ((r110 instanceof WikiScrollTextView) == false) goto L13;
            ((WikiScrollTextView) r110).f241667b = r109;
            goto L13
        L5:
            if (TextUtils.equals(r104.f242370q, r105) == false) goto L7;
            r107 = true;
            goto L8
        }

        public final void B2(WikItemRootView r100, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "node");
            boolean r103 = com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a();
            if (r101.f241920h != 2) goto L17;
            if (r103 == false) goto L17;
            ce5.a r104 = this.f242383d.getUserComponentAbility();
            if (r104 == null) goto L14;
            BenefitManagerAPI r105 = r104.f23452g;
            if (r105 == null) goto L14;
            BenefitStore r106 = r105.n1();
            if (r106 == null) goto L14;
            if (r106.hasBenefit("common_wiki_node_management") == true) goto L14;
            boolean r107 = true;
        L15:
            if (r107 == true) goto L17;
            boolean r108 = true;
        L18:
            r100.setCreateButtonVisible(r108);
            r100.setIconPadding(this.f242383d.getIndicatorPadding());
            r100.setSwipeMenuEnable(false);
            boolean r109 = this.f242383d.A;
            Intrinsics.checkNotNullParameter(r101, "node");
            int r110 = g.f242482a;
            Intrinsics.checkNotNullParameter(r101, "node");
            if (r101.d() == false) goto L22;
            String r111 = eu5.b.f474075a.getString(R.string.CreationMobile_Wiki_Clipped_Tab);
            Intrinsics.checkNotNull(r111);
        L25:
            r100.setTitle(r111);
            com.bytedance.ee.bear.wikiv2.icon.d r112 = this.f242380a;
            com.bytedance.ee.bear.wikiv2.icon.c r113 = new com.bytedance.ee.bear.wikiv2.icon.c();
            r113.f240967a = false;
            r113.f240968b = false;
            r113.f240969c = false;
            r113.f240970d = this.f242381b;
            r113.f240971e = this.f242382c;
            Unit r114 = Unit.INSTANCE;
            r112.a(r101, r100, r113, this.f242383d.getUserComponentAbility());
            r100.setExpand(r101.f241928p);
            if (r102 == false) goto L28;
            int r115 = -1;
        L29:
            com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.a r116 = r100.f242238q;
            if (r116 == null) goto L34;
            WikiHorizontalScrollView r117 = r116.f241672b;
            if (r117 == null) goto L34;
            r100.setScrollX(-r117.getScrollX());
        L34:
            r100.k(r115);
            r100.setExpandClickListener(new e(this.f242383d, r101));
            Ref.BooleanRef r118 = new Ref.BooleanRef();
            r118.element = true;
            Iterator<Function<com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j, Boolean>> r119 = this.f242383d.getEnableRootCheckers().iterator();
        L36:
            if (r119.hasNext() == false) goto L41;
            if (r119.next().apply(r101).booleanValue() == true) goto L36;
            r118.element = false;
        L41:
            if (r118.element == false) goto L43;
            r100.setFocus(TextUtils.equals(r101.f241914b, this.f242383d.getFocusToken()));
        L43:
            r100.setItemClickListener(new f(r118, this.f242383d, r101, r100));
            return;
        L28:
            r115 = this.f242383d.getWikiUIList().d(r101.f241926n);
            goto L29
        L22:
            if (TextUtils.equals("wikiroot%shared", com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.c(r101.f241926n, 0)) == false) goto L24;
            r111 = eu5.b.f474075a.getString(R.string.LarkCCM_Common_Space_SharedWithMe);
            Intrinsics.checkNotNull(r111);
            goto L25
        L24:
            r111 = eu5.b.f474075a.getString(R.string.LarkCCM_CM_MyLib_TableOfContent_Title);
            Intrinsics.checkNotNull(r111);
        L14:
            r107 = false;
        L17:
            r108 = false;
            goto L18
        }
    }

    public static final class a {
    }

    public interface b {
        void a(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r100, int r101, View r102);

        void b(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r100, boolean r101);

        void c(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r100);

        void d(WikiHomePageV2 r100);

        void e(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r100);

        void f(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r100, boolean r101);

        void g(String r100, String r101);

        void h(View r100);

        void i(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r100, boolean r101);
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WikiTreeView f242398a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f242399b;

        @Override // java.lang.Runnable
        public final void run() {
            WikiTreeView r100 = this.f242398a;     // Catch: Throwable -> L4
            int r101 = this.f242399b;     // Catch: Throwable -> L4
            int r102 = WikiTreeView.E;     // Catch: Throwable -> L4
            r100.i(r101);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(WikiTreeView r100, int r101) {
            this.f242398a = r100;
            this.f242399b = r101;
        }
    }

    static {
    }

    public WikiTreeView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12, 0);
    }

    public WikiTreeView(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r110, 8, 0);
    }

    public List<RecyclerView.ItemDecoration> getDefaultItemDecorations() {
        return CollectionsKt.listOf(new RecyclerView.ItemDecoration[]{new WikiDividerDecoration(getContext()), new WikiItemBackgroundDecoration(getContext())});
    }

    public final void a() {
        ViewGroup.MarginLayoutParams r100 = null;
        if (this.f242375v != null) goto L9;
        InterceptableRecyclerView r101 = getRecyclerViewFromXml();
        if (r101 == null) goto L7;
        Integer r102 = Integer.valueOf(r101.getPaddingTop());
    L8:
        this.f242375v = r102;
        goto L9
    L7:
        r102 = null;
    L9:
        WikItemHomePageView r103 = getStickyHeadHomePageFromXml();
        int r104 = 0;
        if (r103 != null) goto L13;
    L11:
        int r105 = 0;
    L33:
        if (this.f242376w != r105) goto L35;
        return;
    L35:
        this.f242376w = r105;
        Integer r106 = this.f242375v;
        if (r106 == null) goto L38;
        int r107 = r106.intValue();
    L39:
        InterceptableRecyclerView r108 = getRecyclerViewFromXml();
        if (r108 == null) goto L54;
        InterceptableRecyclerView r109 = getRecyclerViewFromXml();
        if (r109 == null) goto L44;
        int r110 = r109.getPaddingLeft();
    L45:
        int r111 = r107 + this.f242376w;
        InterceptableRecyclerView r112 = getRecyclerViewFromXml();
        if (r112 == null) goto L48;
        int r113 = r112.getPaddingRight();
    L49:
        InterceptableRecyclerView r114 = getRecyclerViewFromXml();
        if (r114 == null) goto L52;
        r104 = r114.getPaddingBottom();
    L52:
        r108.setPadding(r110, r111, r113, r104);
        return;
    L48:
        r113 = 0;
        goto L49
    L44:
        r110 = 0;
        goto L45
    L54:
        return;
    L38:
        r107 = 0;
        goto L39
    L13:
        if (r103.getVisibility() == 8) goto L11;
        ViewGroup.LayoutParams r115 = r103.getLayoutParams();
        if ((r115 instanceof ViewGroup.MarginLayoutParams) == false) goto L18;
        r100 = (ViewGroup.MarginLayoutParams) r115;
    L18:
        if (r100 == null) goto L20;
        int r116 = r100.topMargin;
    L21:
        ViewGroup.LayoutParams r117 = r103.getLayoutParams();
        if (r117 == null) goto L24;
        int r118 = r117.height;
    L26:
        if (r103.getHeight() <= 0) goto L28;
        r118 = r103.getHeight();
    L31:
        r105 = r118 + r116;
        goto L33
    L28:
        if (r118 > 0) goto L31;
        r118 = r103.getMeasuredHeight();
        goto L31
    L24:
        r118 = 0;
        goto L26
    L20:
        r116 = 0;
        goto L21
    }

    public final boolean g() {
        return ((Boolean) this.D.getValue()).booleanValue();
    }

    public final List<Function<com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j, Boolean>> getEnableRootCheckers() {
        List r100 = this.f242366m;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("enableRootCheckers");
        return null;
    }

    public final InterceptableRecyclerView getRecyclerViewFromXml() {
        KeyEvent.Callback r100 = this.f242354a;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.recycler_view);
        this.f242354a = (InterceptableRecyclerView) r100;
    L6:
        return (InterceptableRecyclerView) r100;
    }

    public final StickyHeadContainer getStickyHeadContainerFromXml() {
        KeyEvent.Callback r100 = this.f242355b;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.sticky_head_container);
        this.f242355b = (StickyHeadContainer) r100;
    L6:
        return (StickyHeadContainer) r100;
    }

    public final WikItemRootView getStickyHeadFromXml() {
        KeyEvent.Callback r100 = this.f242356c;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.sticky_head);
        this.f242356c = (WikItemRootView) r100;
    L6:
        return (WikItemRootView) r100;
    }

    public final WikItemHomePageView getStickyHeadHomePageFromXml() {
        KeyEvent.Callback r100 = this.f242357d;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.sticky_home_page);
        this.f242357d = (WikItemHomePageView) r100;
    L6:
        return (WikItemHomePageView) r100;
    }

    public WikiAdapter getWikiAdapter() {
        return new WikiAdapter(this);
    }

    public void d() {
        c(getRecyclerViewFromXml());
        getRecyclerViewFromXml().setItemAnimator(new DefaultItemAnimator());
        getRecyclerViewFromXml().setLayoutManager(this.f242359f);
        getRecyclerViewFromXml().setAdapter(this.f242358e);
        InterceptableRecyclerView r100 = getRecyclerViewFromXml();
        if ((r100 instanceof CommonRecyclerView) == false) goto L5;
        r100.setSceneTag("bear_wiki_tree_view");
    L5:
        com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.a r101 = this.f242360g;
        r101.getClass();
        Intrinsics.checkNotNullParameter(this, RootDescription.ROOT_ELEMENT);
        r101.f241674d = this;
        r101.f241672b = (WikiHorizontalScrollView) findViewById(R.id.wiki_tree_scroll_view);
        final RecyclerView r102 = (RecyclerView) findViewById(R.id.recycler_view);
        r101.f241673c = r102;
        if (r102 == null) goto L11;
        r102.addOnLayoutChangeListener(new vq5.a(r102, r101, this));
        r102.addOnScrollListener(new WikiHoriScrollManager$initScrollViews$1$2(r102));
        SimpleItemAnimator r103 = (SimpleItemAnimator) r102.getItemAnimator();
        if (r103 == null) goto L11;
        r103.setSupportsChangeAnimations(false);
    L11:
        if (qc5.a.h() == true) goto L13;
    L17:
        WikiHorizontalScrollView r104 = r101.f241672b;
        if (r104 == null) goto L21;
        r104.setScrollChangeListener(new com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.b(r101));
        return;
    L21:
        return;
    L13:
        if ((r101.f241674d instanceof SidebarTreeView) == false) goto L17;
        WikiHorizontalScrollView r105 = r101.f241672b;
        if (r105 == null) goto L17;
        r105.setHorizontalScrollBarEnabled(false);
        goto L17
    }

    public final void h() {
        WikItemHomePageView r100 = getStickyHeadHomePageFromXml();
        if (r100 != null) goto L5;
        return;
    L5:
        UserSession r101 = null;
        if (g() == true) goto L9;
        this.f242374u = null;
        r100.setVisibility(8);
        return;
    L9:
        Integer r102 = this.B;
        if (r102 != null) goto L13;
    L14:
        if (r102 != null) goto L17;
    L19:
        boolean r103 = false;
    L21:
        if (r103 == false) goto L24;
        r100.setVisibility(8);
        a();
        return;
    L24:
        WikiHomePageV2 r104 = this.f242374u;
        if (r104 != null) goto L27;
    L40:
        r100.setVisibility(8);
        a();
        return;
    L27:
        if (r104.isValid() == false) goto L40;
        r100.setVisibility(0);
        r100.setTitle(r104.title);
        boolean r105 = TextUtils.equals(this.f242370q, r104.wikiToken);
        r100.setFocus(r105);
        a();
        if (qc5.a.h() == true) goto L34;
        if (r105 == true) goto L34;
        IconShape r106 = IconShape.SQUARE_OUTLINE;
    L35:
        IconShape r107 = r106;
        ImageView r108 = r100.getItemIcon();
        String r109 = r104.objToken;
        int r110 = r104.objType;
        Boolean r111 = Boolean.FALSE;
        obb.a r112 = new obb.a(r111, r111, null);
        r112.b(IconScene.WIKI);
        ce5.a r113 = this.f242369p;
        if (r113 == null) goto L38;
        r101 = r113.f23447b;
    L38:
        r112.f522636g = r101;
        Unit r114 = Unit.INSTANCE;
        mbb.c.d(r108, r109, r110, null, r107, r112);
        return;
    L34:
        r106 = IconShape.SQUARE;
        goto L35
    L17:
        if (r102.intValue() != 3) goto L19;
    L20:
        r103 = true;
        goto L21
    L13:
        if (r102.intValue() == 2) goto L20;
        goto L14
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c r100 = this.C;
        if (r100 == null) goto L6;
        removeCallbacks(r100);
        return;
    }

    public final String getDisableToken() {
        return this.f242363j;
    }

    public final boolean getEnableDiffRender() {
        return this.f242365l;
    }

    public final boolean getEnableSwipeMenu() {
        return this.f242364k;
    }

    public final String getFocusToken() {
        return this.f242370q;
    }

    public final Fragment getFragment() {
        return this.f242378y;
    }

    public final int getIndicatorPadding() {
        return this.f242367n;
    }

    public final LinearLayoutManager getLinearLayoutManager() {
        return this.f242359f;
    }

    public final b getListener() {
        return this.f242362i;
    }

    public final com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.a getScrollManager() {
        return this.f242360g;
    }

    public final String getSource() {
        return this.f242377x;
    }

    public final String getSpaceId() {
        return this.f242379z;
    }

    public final Integer getSpaceType() {
        return this.B;
    }

    public final int getTitleRightMargin() {
        return this.f242368o;
    }

    public final ce5.a getUserComponentAbility() {
        return this.f242369p;
    }

    public final d3 getWikiUIList() {
        return this.f242361h;
    }

    public final RecyclerView.ViewHolder b(int r100) {
        if (r100 < 0) goto L29;
        int r101 = r100 + this.f242358e.getHeaderLayoutCount();
        boolean r102 = false;
        if (g() == true) goto L7;
    L16:
        if (r102 == false) goto L21;
        InterceptableRecyclerView r103 = getRecyclerViewFromXml();
        if (r103 != null) goto L20;
        return null;
    L20:
        return r103.findViewHolderForAdapterPosition(r101);
    L21:
        int r104 = this.f242359f.findFirstVisibleItemPosition();
        if (r104 == (-1)) goto L29;
        int r105 = r101 - r104;
        if (r105 < 0) goto L29;
        View r106 = getRecyclerViewFromXml().getChildAt(r105);
        if (r106 == null) goto L29;
        return getRecyclerViewFromXml().getChildViewHolder(r106);
    L7:
        if (this.f242374u == null) goto L16;
        WikItemHomePageView r107 = getStickyHeadHomePageFromXml();
        if (r107 != null) goto L11;
    L13:
        boolean r108 = false;
    L14:
        if (r108 == false) goto L16;
        r102 = true;
        goto L16
    L11:
        if (r107.getVisibility() != 0) goto L13;
        r108 = true;
    L29:
        return null;
    }

    public void c(InterceptableRecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        getStickyHeadContainerFromXml().setDataCallback(new v1(this));
        WikItemHomePageView r101 = getStickyHeadHomePageFromXml();
        if (g() == false) goto L6;
        if (r101 == null) goto L6;
        r101.setVisibility(4);
        r101.setItemClickListener(new w1(this));
        r101.addOnLayoutChangeListener(new x1(this));
    L6:
        StickyItemDecoration r102 = new StickyItemDecoration(getStickyHeadContainerFromXml(), WikNodeType.ROOT.getValue());
        r102.f404351h = new y1(this);
        r100.addItemDecoration(r102);
    }

    public final boolean e(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r100) {
        Intrinsics.checkNotNullParameter(r100, "node");
        if (TextUtils.isEmpty(this.f242363j) == false) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L11;
        return false;
    L11:
        if (bx4.b.b(r100.f241914b) == false) goto L14;
        return true;
    L14:
        return r100.f241930r;
    L5:
        if (TextUtils.equals(this.f242363j, r100.f241914b) == false) goto L7;
        r101 = true;
        goto L8
    }

    public final boolean f(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L13;
        d3 r101 = this.f242361h;
        Intrinsics.checkNotNull(r100);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "uid");
        if (TextUtils.isEmpty(r100) == false) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r101.f241801c.containsKey(r100) == false) goto L9;
        r102 = true;
        goto L10
    L13:
        return false;
    }

    public final void i(int r100) {
        int r101 = this.f242358e.getHeaderLayoutCount() + r100;
        int r102 = getHeight();
        if (r102 <= 0) goto L6;
        this.f242358e.getClass();
        int r103 = (r102 / 2) - (cu5.c.a(48.0f) / 2);
        this.f242359f.scrollToPositionWithOffset(r101, r103);
        return;
    L6:
        tt5.a.h("Wiki_WikiTreeRvView", "WikiTreeRvView.scrollToCenter(), total height is 0, post delay");
        Runnable r104 = this.C;
        if (r104 == null) goto L9;
        removeCallbacks(r104);
    L9:
        c r105 = new c(this, r100);
        this.C = r105;
        post(r105);
    }

    public final void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        if (f(r100) == true) goto L5;
        return;
    L5:
        i(this.f242361h.d(r100));
    }

    public final void setData(d3 r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        d3 r101 = this.f242361h;
        this.f242361h = r100;
        this.f242358e.E2(r100.f241799a);
        d3 r102 = this.f242361h;
        if (r102.f241800b < 8) goto L5;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == false) goto L13;
        this.f242358e.notifyDataSetChanged();
        return;
    L13:
        WikiAdapter r104 = this.f242358e;
        String r105 = this.f242373t;
        String r106 = this.f242370q;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r101, "olds");
        Intrinsics.checkNotNullParameter(r102, "news");
        DiffUtil.calculateDiff(new WikiDiffCallback(r101, r102, r105, r106)).dispatchUpdatesTo(new WikiListUpdateCallback(r104));
        return;
    L5:
        if (r101.f241800b >= 8) goto L10;
        if (this.f242365l == false) goto L10;
        r103 = false;
        goto L11
    }

    public final void setDisableToken(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f242363j = r100;
    }

    public final void setEnableDiffRender(boolean r100) {
        this.f242365l = r100;
    }

    public final void setEnableRootCheckers(List<? extends Function<com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j, Boolean>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f242366m = r100;
    }

    public final void setEnableSwipeMenu(boolean r100) {
        this.f242364k = r100;
    }

    public final void setFocusToken(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f242370q = r100;
    }

    public final void setFooter(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        int r101 = this.f242358e.getFooterLayoutCount();
        tt5.a.h("Wiki_WikiTreeRvView", "setFooter. count= " + r101);
        if (r101 != 0) goto L6;
        this.f242358e.setFooterView(r100);
        this.f242358e.notifyDataSetChanged();
        return;
    }

    public final void setFragment(Fragment r100) {
        this.f242378y = r100;
    }

    public void setItemDecorations(List<? extends RecyclerView.ItemDecoration> r100) {
        if (r100 == null) goto L7;
        Iterator<? extends RecyclerView.ItemDecoration> r101 = r100.iterator();
    L5:
        if (r101.hasNext() == false) goto L7;
        RecyclerView.ItemDecoration r102 = r101.next();
        getRecyclerViewFromXml().addItemDecoration(r102);
    L7:
        Iterator<T> r103 = getDefaultItemDecorations().iterator();
    L9:
        if (r103.hasNext() == false) goto L13;
        RecyclerView.ItemDecoration r104 = (RecyclerView.ItemDecoration) r103.next();
        InterceptableRecyclerView r105 = getRecyclerViewFromXml();
        if (r105 == null) goto L9;
        r105.addItemDecoration(r104);
        goto L9
    }

    public final void setListener(b r100) {
        this.f242362i = r100;
    }

    public final void setMyLib(boolean r100) {
        this.A = r100;
    }

    public final void setRecyclerViewFromXml(InterceptableRecyclerView r100) {
        this.f242354a = r100;
    }

    public final void setSource(String r100) {
        this.f242377x = r100;
    }

    public final void setSpaceId(String r100) {
        this.f242379z = r100;
        WikiHorizontalScrollView r101 = this.f242360g.f241672b;
        if (r101 == null) goto L8;
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        r101.f241655e = r100;
        return;
    }

    public final void setSpaceType(Integer r100) {
        this.B = r100;
    }

    public final void setStickyHeadContainerFromXml(StickyHeadContainer r100) {
        this.f242355b = r100;
    }

    public final void setStickyHeadFromXml(WikItemRootView r100) {
        this.f242356c = r100;
    }

    public final void setStickyHeadHomePageFromXml(WikItemHomePageView r100) {
        this.f242357d = r100;
    }

    public final void setTitleRightMargin(int r100) {
        this.f242368o = r100;
    }

    public final void setUserComponentAbility(ce5.a r100) {
        this.f242369p = r100;
    }

    public final void setWikiUIList(d3 r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f242361h = r100;
    }

    public final void k(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r101, "uid");
        this.f242373t = this.f242370q;
        this.f242370q = r100;
        this.f242372s = this.f242371r;
        this.f242371r = r101;
        h();
        b r102 = this.f242362i;
        if (r102 == null) goto L6;
        r102.g(r100, r101);
        return;
    }

    public final void l(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r101, "uid");
        if (this.f242361h.c(r100) == true) goto L5;
        return;
    L5:
        k(r100, r101);
        if (ForsetiHelper.p() == true) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == true) goto L13;
        this.f242358e.notifyDataSetChanged();
        return;
    L13:
        if (TextUtils.isEmpty(this.f242372s) == true) goto L15;
        int r103 = this.f242361h.d(this.f242372s);
    L16:
        int r104 = this.f242361h.d(r101);
        int r105 = this.f242358e.getHeaderLayoutCount();
        if (r103 < 0) goto L19;
        this.f242358e.notifyItemChanged(r103 + r105);
    L19:
        if (r104 < 0) goto L23;
        this.f242358e.notifyItemChanged(r104 + r105);
        return;
    L23:
        return;
    L15:
        r103 = -1;
        goto L16
    L8:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.wiki_tree_disabled_notify_all") == false) goto L10;
        r102 = true;
        goto L11
    }

    public final void m(String r100, boolean r101) {
        if (f(r100) == true) goto L5;
        return;
    L5:
        d3 r102 = this.f242361h;
        Intrinsics.checkNotNull(r100);
        RecyclerView.ViewHolder r103 = b(r102.d(r100));
        if (r103 == null) goto L12;
        View r104 = r103.itemView;
        if ((r104 instanceof WikItemDirView) == false) goto L13;
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemDirView");
        ((WikItemDirView) r104).setLoading(r101);
        return;
    L13:
        return;
    }

    public final void n(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        if (f(r100) == true) goto L5;
        return;
    L5:
        RecyclerView.ViewHolder r102 = b(this.f242361h.d(r100));
        if (r102 == null) goto L15;
        KeyEvent.Callback r103 = r102.itemView;
        if ((r103 instanceof d) == false) goto L17;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.ISwipeMenuItem");
        d r104 = (d) r103;
        if (r101 == false) goto L13;
        r104.b();
        return;
    L13:
        r104.a();
        return;
    L17:
        return;
    }

    public WikiTreeView(Context r100, AttributeSet r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, r103);
        this.f242358e = getWikiAdapter();
        this.f242359f = new LinearLayoutManager(getContext());
        this.f242360g = new com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.a(this instanceof SidebarTreeView);
        d3 r104 = d3.f241798e;
        this.f242361h = d3.f241798e;
        this.f242363j = "";
        this.f242367n = r100.getResources().getDimensionPixelSize(R.dimen.space_kit_len_3);
        this.f242370q = "";
        this.f242371r = "";
        this.f242372s = "";
        this.f242373t = "";
        this.f242379z = "";
        this.D = LazyKt.lazy(WikiTreeView$isWikiRootCustomHomePageEnable$2.INSTANCE);
        LayoutInflater r105 = LayoutInflater.from(r100);
        int r106 = com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.a.f241670f;
        r105.inflate(R.layout.wiki_tree_view_scroll, this);
        d();
    }

    public /* synthetic */ WikiTreeView(Context r100, AttributeSet r101, int r102, int r103, int r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = 0;
    L5:
        this(r100, r101, r102, 0);
    }
}
