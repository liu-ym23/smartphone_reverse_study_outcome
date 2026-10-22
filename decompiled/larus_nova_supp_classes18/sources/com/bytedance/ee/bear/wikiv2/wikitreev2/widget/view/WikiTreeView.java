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
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import com.oubowu.stickyitemdecoration.StickyHeadContainer;
import com.oubowu.stickyitemdecoration.StickyItemDecoration;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.larkicon.IconScene;
import com.ss.android.lark.passportc.entity.UserSession;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 ¸\u00012\u00020\u0001:\u0006¸\u0001¹\u0001º\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0081\u0001\u001a\u00020@H\u0016J\r\u0010\u0082\u0001\u001a\u00060$R\u00020\u0000H\u0016J\n\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0014J\t\u0010\u0085\u0001\u001a\u00020\u0007H\u0002J\n\u0010\u0086\u0001\u001a\u00030\u0084\u0001H\u0002J\u0014\u0010\u0087\u0001\u001a\u00030\u0084\u00012\b\u0010\u0088\u0001\u001a\u00030\u0089\u0001H\u0016J\u0012\u0010\u008a\u0001\u001a\u00030\u0084\u00012\b\u0010c\u001a\u0004\u0018\u00010dJ\n\u0010\u008b\u0001\u001a\u00030\u0084\u0001H\u0002J\u0011\u0010\u008c\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u008d\u0001\u001a\u00020.J\u001c\u0010\u008e\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u008f\u0001\u001a\u00020:2\t\b\u0002\u0010\u0090\u0001\u001a\u00020:J)\u0010\u0091\u0001\u001a\u00030\u0084\u00012\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010:2\t\u0010\u0092\u0001\u001a\u0004\u0018\u00010:2\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010:J\u0012\u0010\u0094\u0001\u001a\u00030\u0084\u00012\b\u0010\u0095\u0001\u001a\u00030\u0096\u0001J\u0011\u0010\u0097\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u008f\u0001\u001a\u00020:J\u001b\u0010\u0098\u0001\u001a\u00030\u0084\u00012\b\u0010\u0099\u0001\u001a\u00030\u009a\u00012\u0007\u0010\u009b\u0001\u001a\u00020@J\u0011\u0010\u009c\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u0090\u0001\u001a\u00020:J\u0013\u0010\u009c\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u009d\u0001\u001a\u00020\u0007H\u0002J\u001c\u0010\u009e\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u008f\u0001\u001a\u00020:2\t\b\u0002\u0010\u0090\u0001\u001a\u00020:J\t\u0010\u009f\u0001\u001a\u00020@H\u0002J\u001c\u0010 \u0001\u001a\u00030\u0084\u00012\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010:2\u0007\u0010¡\u0001\u001a\u00020@J\u001a\u0010¢\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u0090\u0001\u001a\u00020:2\u0007\u0010£\u0001\u001a\u00020@J#\u0010¤\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u0090\u0001\u001a\u00020:2\u0007\u0010¥\u0001\u001a\u00020\u00072\u0007\u0010¦\u0001\u001a\u00020@J\u0012\u0010§\u0001\u001a\u00020@2\u0007\u0010¨\u0001\u001a\u00020KH\u0004J\u0010\u0010©\u0001\u001a\u00020@2\u0007\u0010\u008f\u0001\u001a\u00020:J\u0013\u0010ª\u0001\u001a\u0005\u0018\u00010«\u00012\u0007\u0010\u009d\u0001\u001a\u00020\u0007J\u0012\u0010¬\u0001\u001a\u00030\u0084\u00012\b\u0010\u00ad\u0001\u001a\u00030®\u0001J\b\u0010¯\u0001\u001a\u00030\u0084\u0001J\u0012\u0010°\u0001\u001a\u00030\u0084\u00012\b\u0010\u00ad\u0001\u001a\u00030®\u0001J\b\u0010±\u0001\u001a\u00030\u0084\u0001J\u001c\u0010²\u0001\u001a\u00030\u0084\u00012\u0010\u0010³\u0001\u001a\u000b\u0012\u0005\u0012\u00030´\u0001\u0018\u00010IH\u0016J\u0010\u0010µ\u0001\u001a\t\u0012\u0005\u0012\u00030´\u00010IH\u0016J\u0014\u0010¶\u0001\u001a\u00020@2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010:H\u0002J\n\u0010·\u0001\u001a\u00030\u0084\u0001H\u0014R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00128FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00188FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001e8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0012\u0010#\u001a\u00060$R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020&X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020*X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u000104X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001a\u0010E\u001a\u00020@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010B\"\u0004\bG\u0010DR,\u0010H\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020@0J0IX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u0011\u0010P\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u001a\u0010S\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010R\"\u0004\bU\u0010VR\u001c\u0010W\u001a\u0004\u0018\u00010XX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u001a\u0010]\u001a\u00020:X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010<\"\u0004\b_\u0010>R\u000e\u0010`\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010c\u001a\u0004\u0018\u00010dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010e\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010fR\u000e\u0010g\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010h\u001a\u0004\u0018\u00010:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010<\"\u0004\bj\u0010>R\u001c\u0010k\u001a\u0004\u0018\u00010lX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR(\u0010r\u001a\u0004\u0018\u00010:2\b\u0010q\u001a\u0004\u0018\u00010:@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010<\"\u0004\bt\u0010>R\u001a\u0010u\u001a\u00020@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010B\"\u0004\bv\u0010DR\u001e\u0010w\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010f\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R\u0010\u0010|\u001a\u0004\u0018\u00010}X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010~\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\r\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0004\b~\u0010B¨\u0006»\u0001"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "recyclerViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/common/widget/InterceptableRecyclerView;", "getRecyclerViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/common/widget/InterceptableRecyclerView;", "setRecyclerViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/common/widget/InterceptableRecyclerView;)V", "stickyHeadContainerFromXml", "Lcom/oubowu/stickyitemdecoration/StickyHeadContainer;", "getStickyHeadContainerFromXml", "()Lcom/oubowu/stickyitemdecoration/StickyHeadContainer;", "setStickyHeadContainerFromXml", "(Lcom/oubowu/stickyitemdecoration/StickyHeadContainer;)V", "stickyHeadFromXml", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikItemRootView;", "getStickyHeadFromXml", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikItemRootView;", "setStickyHeadFromXml", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikItemRootView;)V", "stickyHeadHomePageFromXml", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikItemHomePageView;", "getStickyHeadHomePageFromXml", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikItemHomePageView;", "setStickyHeadHomePageFromXml", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikItemHomePageView;)V", "wikiAdapter", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeView$WikiAdapter;", "linearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getLinearLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "scrollManager", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/scroll/WikiHoriScrollManager;", "getScrollManager", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/scroll/WikiHoriScrollManager;", "wikiUIList", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/WikiUIList;", "getWikiUIList", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/WikiUIList;", "setWikiUIList", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/WikiUIList;)V", "listener", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeView$IListener;", "getListener", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeView$IListener;", "setListener", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeView$IListener;)V", "disableToken", "", "getDisableToken", "()Ljava/lang/String;", "setDisableToken", "(Ljava/lang/String;)V", "enableSwipeMenu", "", "getEnableSwipeMenu", "()Z", "setEnableSwipeMenu", "(Z)V", "enableDiffRender", "getEnableDiffRender", "setEnableDiffRender", "enableRootCheckers", "", "Lio/reactivex/functions/Function;", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/UITreeNode;", "getEnableRootCheckers", "()Ljava/util/List;", "setEnableRootCheckers", "(Ljava/util/List;)V", "indicatorPadding", "getIndicatorPadding", "()I", "titleRightMargin", "getTitleRightMargin", "setTitleRightMargin", "(I)V", "userComponentAbility", "Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "getUserComponentAbility", "()Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "setUserComponentAbility", "(Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;)V", "focusToken", "getFocusToken", "setFocusToken", "focusUid", "oldFocusUid", "oldFocus", "homePageV2", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/WikiHomePageV2;", "recyclerInitialPaddingTop", "Ljava/lang/Integer;", "stickyHomePageInsetTop", "source", "getSource", "setSource", "fragment", "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "setFragment", "(Landroidx/fragment/app/Fragment;)V", "value", "spaceId", "getSpaceId", "setSpaceId", "isMyLib", "setMyLib", "spaceType", "getSpaceType", "()Ljava/lang/Integer;", "setSpaceType", "(Ljava/lang/Integer;)V", "scrollToRunnable", "Ljava/lang/Runnable;", "isWikiRootCustomHomePageEnable", "isWikiRootCustomHomePageEnable$delegate", "Lkotlin/Lazy;", "isSidebarView", "getWikiAdapter", "initView", "", "computeStickyHomePageInsetTop", "applyStickyHomePageInsetIfNeeded", "initStickyHeadView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "updateHomePage", "refreshHomePageView", "setData", WikiFolderPushPlugin.DATA, "setFocus", WikiFolderPushPlugin.WIKI_TOKEN, "uid", "updateTitleAndIcon", "newTitle", "newIconInfo", "handlePushToken", "ok", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/Ok;", "scrollItemToCenterByToken", "scrollHorizontally", "scrollX", "", "dismiss", "scrollItemToCenter", "position", "setItemFocus", "disableNotifyAll", "setItemLoading", "isLoading", "setSwipeMenuOpen", "isOpen", "setMenuEnable", "menuId", "enable", "isItemEnable", "node", "isFocus", "getViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "addHeader", "view", "Landroid/view/View;", "removeHeader", "setFooter", "removeFooter", "setItemDecorations", "decors", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getDefaultItemDecorations", "isValidUid", "onDetachedFromWindow", "Companion", "WikiAdapter", "IListener", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class WikiTreeView extends FrameLayout {
    public static final /* synthetic */ int E = 0;
    public boolean A;
    public Integer B;
    public c C;
    public final Lazy D;
    public InterceptableRecyclerView a;
    public StickyHeadContainer b;
    public WikItemRootView c;
    public WikItemHomePageView d;
    public final WikiAdapter e;
    public final LinearLayoutManager f;
    public final com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.a g;
    public d3 h;
    public b i;
    public String j;
    public boolean k;
    public boolean l;
    public List<? extends Function<com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j, Boolean>> m;
    public final int n;
    public int o;
    public ce5.a p;
    public String q;
    public String r;
    public String s;
    public String t;
    public WikiHomePageV2 u;
    public Integer v;
    public int w;
    public String x;
    public Fragment y;
    public String z;

    @Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0096\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\u0015\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0000¢\u0006\u0002\b\u001bJ\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0018H\u0014J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0014J\u0018\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0002H\u0014J\u001e\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u000bJ\u0016\u0010(\u001a\u00020\u00142\u0006\u0010%\u001a\u00020)2\u0006\u0010#\u001a\u00020\u0002J\u0018\u0010*\u001a\u00020\u00142\u0006\u0010%\u001a\u00020+2\u0006\u0010#\u001a\u00020\u0002H\u0016J\u0018\u0010,\u001a\u00020\u00142\u0006\u0010%\u001a\u00020-2\u0006\u0010#\u001a\u00020\u0002H\u0016J.\u0010.\u001a\u00020\u00142\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002002\n\b\u0002\u00102\u001a\u0004\u0018\u0001032\n\b\u0002\u00104\u001a\u0004\u0018\u000103J\u0018\u00105\u001a\u0002032\u0006\u0010#\u001a\u00020\u00022\u0006\u00106\u001a\u00020\u000bH\u0016J\u0010\u00107\u001a\u0002032\u0006\u0010#\u001a\u00020\u0002H\u0016J\u0010\u00108\u001a\u0002032\u0006\u0010#\u001a\u00020\u0002H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u00069"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeView$WikiAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/UITreeNode;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "<init>", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeView;)V", "innerTreeIconFactory", "Lcom/bytedance/ee/bear/wikiv2/icon/WikiTreeIconFactory;", "getInnerTreeIconFactory", "()Lcom/bytedance/ee/bear/wikiv2/icon/WikiTreeIconFactory;", "innerSidebarEnable", "", "getInnerSidebarEnable", "()Z", "setInnerSidebarEnable", "(Z)V", "innerWikiCustomSpaceIconEnable", "getInnerWikiCustomSpaceIconEnable", "setInnerWikiCustomSpaceIconEnable", "setDefNewData", "", WikiFolderPushPlugin.DATA, "", "getParentViewWidth", "", "getItemHeight", "position", "getItemHeight$contentmanager_wiki_impl_v2_productionChinaRelease", "onCreateDefViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getDefItemViewType", "convert", "holder", "node", "bindRootView", "view", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikItemRootView;", "fromStikyHeader", "bindNoneView", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikItemNoneView;", "bindDirView", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikItemDirView;", "bindItemView", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikItemLeafView;", "notifyDiffDataSetChange", "olds", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/WikiUIList;", "news", "oldFocus", "", "newFocus", "getRootTitle", "isMyLib", "getNoneTitle", "getItemTitle", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public class WikiAdapter extends BaseQuickAdapter<com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j, BaseViewHolder> {
        public final com.bytedance.ee.bear.wikiv2.icon.d a;
        public final boolean b;
        public final boolean c;
        public final /* synthetic */ WikiTreeView d;

        public static final class a implements com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.d.a {
            public final /* synthetic */ WikiTreeView a;
            public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j b;

            public a(WikiTreeView r1, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.d.a
            public final void a(int r3, View r4) {
                b r0 = this.a.getListener();
                if (r0 == null) goto L6;
                r0.a(this.b, r3, r4);
                return;
            }
        }

        public static final class b implements com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.d.b {
            public final /* synthetic */ WikiTreeView a;
            public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j b;

            public b(WikiTreeView r1, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.d.b
            public final void a(boolean r3) {
                b r0 = this.a.getListener();
                if (r0 == null) goto L6;
                r0.b(this.b, r3);
                return;
            }
        }

        public static final class c implements WikItemLeafView.e {
            public final /* synthetic */ WikiTreeView a;
            public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j b;

            public c(WikiTreeView r1, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView.e
            public final void a() {
                WikiTreeView r0 = this.a;
                com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r1 = this.b;
                r0.l(r1.b, r1.n);
                b r2 = this.a.getListener();
                if (r2 == null) goto L6;
                r2.c(this.b);
                return;
            }
        }

        public static final class d implements WikItemDirView.b {
            public final /* synthetic */ WikiTreeView a;
            public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j b;

            public d(WikiTreeView r1, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemDirView.b
            public final void a(boolean r3) {
                b r0 = this.a.getListener();
                if (r0 == null) goto L6;
                r0.f(this.b, r3);
                return;
            }
        }

        public static final class e implements WikItemDirView.b {
            public final /* synthetic */ WikiTreeView a;
            public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j b;

            public e(WikiTreeView r1, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemDirView.b
            public final void a(boolean r3) {
                b r0 = this.a.getListener();
                if (r0 == null) goto L6;
                r0.f(this.b, r3);
                return;
            }
        }

        public static final class f implements WikItemLeafView.e {
            public final /* synthetic */ Ref.BooleanRef a;
            public final /* synthetic */ WikiTreeView b;
            public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j c;
            public final /* synthetic */ WikItemRootView d;

            public f(Ref.BooleanRef r1, WikiTreeView r2, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r3, WikItemRootView r4) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView.e
            public final void a() {
                if (this.a.element == false) goto L7;
                WikiTreeView r0 = this.b;
                com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r1 = this.c;
                r0.l(r1.b, r1.n);
                b r2 = this.b.getListener();
                if (r2 == null) goto L11;
                r2.c(this.c);
                return;
            L11:
                return;
            L7:
                b r3 = this.b.getListener();
                if (r3 == null) goto L13;
                r3.f(this.c, !this.d.u);
                return;
            }
        }

        public WikiAdapter(WikiTreeView r1) {
            this.d = r1;
            super(0);
            this.a = new com.bytedance.ee.bear.wikiv2.icon.d();
            this.b = qc5.a.h();
            this.c = qc5.a.l();
        }

        public static String D2(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r2) {
            Intrinsics.checkNotNullParameter(r2, "node");
            int r1 = g.a;
            Intrinsics.checkNotNullParameter(r2, "node");
            if (r2.l == false) goto L9;
            if (r2.d != 111) goto L7;
            String r3 = eu5.b.a.getString(2131887107);
            Intrinsics.checkNotNull(r3);
            return r3;
        L7:
            String r4 = eu5.b.a.getString(2131887103);
            Intrinsics.checkNotNull(r4);
            return r4;
        L9:
            if (TextUtils.isEmpty(r2.e) == false) goto L11;
            String r5 = com.bytedance.ee.bear.list.t0.e(eu5.b.a, r2.d);
            Intrinsics.checkNotNull(r5);
            return r5;
        L11:
            String r6 = r2.e;
            Intrinsics.checkNotNull(r6);
            return r6;
        }

        public final void E2(List<com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j> r2) {
            Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.DATA);
            ((BaseQuickAdapter) this).mData = r2;
        }

        public final int getDefItemViewType(int r2) {
            return ((com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j) ListProtector.get(this.d.getWikiUIList().a, r2)).q;
        }

        public final void A2(WikItemNoneView r3, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r4) {
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "node");
            Intrinsics.checkNotNullParameter(r4, "node");
            int r1 = g.a;
            Intrinsics.checkNotNullParameter(r4, "node");
            if (TextUtils.equals("wikiroot%favorite", r4.f) == false) goto L5;
            String r0 = eu5.b.a.getString(2131887498);
            Intrinsics.checkNotNull(r0);
        L6:
            r3.setTitle(r0);
            r3.g(r4.o, this.d.getWikiUIList().b);
            return;
        L5:
            r0 = eu5.b.a.getString(2131887500);
            Intrinsics.checkNotNull(r0);
            goto L6
        }

        public void C2(BaseViewHolder r3, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r4) {
            Intrinsics.checkNotNullParameter(r3, "holder");
            Intrinsics.checkNotNullParameter(r4, "node");
            View r0 = ((RecyclerView.ViewHolder) r3).itemView;
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView");
            WikItemLeafView r1 = (WikItemLeafView) r0;
            r1.f();
            int r5 = r3.getItemViewType();
            if (r5 != WikNodeType.ROOT.getValue()) goto L6;
            B2((WikItemRootView) r1, r4, false);
            return;
        L6:
            if (r5 != WikNodeType.NONE.getValue()) goto L9;
            A2((WikItemNoneView) r1, r4);
            return;
        L9:
            if (r5 != WikNodeType.DIR.getValue()) goto L11;
            y2((WikItemDirView) r1, r4);
            return;
        L11:
            z2(r1, r4);
        }

        public /* bridge */ /* synthetic */ void convert(BaseViewHolder r1, Object r2) {
            C2(r1, (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j) r2);
        }

        public BaseViewHolder onCreateDefViewHolder(ViewGroup r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "parent");
            if (r3 != WikNodeType.ROOT.getValue()) goto L6;
            BaseViewHolder r4 = new BaseViewHolder(new WikItemRootView(this.d.getContext()));
        L12:
            View r5 = ((RecyclerView.ViewHolder) r4).itemView;
            if ((r5 instanceof WikItemLeafView) == false) goto L15;
            WikItemLeafView r6 = (WikItemLeafView) r5;
        L16:
            if (r6 == null) goto L18;
            r6.setScrollManager(this.d.getScrollManager());
        L18:
            return r4;
        L15:
            r6 = null;
            goto L16
        L6:
            if (r3 != WikNodeType.NONE.getValue()) goto L9;
            r4 = new BaseViewHolder(new WikItemNoneView(this.d.getContext()));
            goto L12
        L9:
            if (r3 != WikNodeType.DIR.getValue()) goto L11;
            r4 = new BaseViewHolder(new WikItemDirView(this.d.getContext()));
            goto L12
        L11:
            r4 = new BaseViewHolder(new WikItemLeafView(this.d.getContext()));
            goto L12
        }

        public void y2(WikItemDirView r2, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "node");
            Gson r0 = dr5.a.a;
            dr5.a.C0226a.a(r3, r2.getIndicatorView());
            z2(r2, r3);
        }

        public void z2(WikItemLeafView r8, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r9) {
            Intrinsics.checkNotNullParameter(r8, "view");
            Intrinsics.checkNotNullParameter(r9, "node");
            r8.setIconPadding(0);
            com.bytedance.ee.bear.wikiv2.icon.d r1 = this.a;
            com.bytedance.ee.bear.wikiv2.icon.c r2 = new com.bytedance.ee.bear.wikiv2.icon.c();
            WikiTreeView r3 = this.d;
            String r4 = r9.b;
            r3.getClass();
            Intrinsics.checkNotNullParameter(r4, WikiFolderPushPlugin.WIKI_TOKEN);
            boolean r6 = true;
            if (TextUtils.isEmpty(r3.q) == false) goto L5;
        L7:
            boolean r5 = false;
        L8:
            r2.a = r5;
            r2.b = true;
            r2.c = false;
            r2.d = this.b;
            r2.e = this.c;
            Unit r7 = Unit.INSTANCE;
            r1.a(r9, r8, r2, this.d.getUserComponentAbility());
            r8.setTitle(D2(r9));
            r8.setTitleStyle(Typeface.DEFAULT);
            r8.g(r9.o, this.d.getWikiUIList().b);
            r8.setFocus(TextUtils.equals(r9.b, this.d.getFocusToken()));
            r8.setSwipeMenuEnable(this.d.getEnableSwipeMenu());
            r8.setMenuClickEnable(r9.s);
            int r10 = this.d.getTitleRightMargin();
            Object r11 = r8.findViewById(2131388772);
            if (r11 != null) goto L11;
        L13:
            r8.setSwipeMenuClickListener(new a(this.d, r9));
            r8.setUserSwipeMenuListener(new b(this.d, r9));
            r8.setItemClickListener(new c(this.d, r9));
            if (r9.c() == false) goto L17;
            WikItemDirView r12 = (WikItemDirView) r8;
            r12.setLoading(false);
            r12.setExpand(r9.p);
            r12.setExpandClickListener(new d(this.d, r9));
        L17:
            if (this.d.e(r9) == true) goto L21;
            r8.d();
            return;
        L21:
            if (r9.m == true) goto L23;
        L24:
            ce5.a r13 = this.d.getUserComponentAbility();
            if (r13 == null) goto L33;
            BenefitManagerAPI r14 = r13.g;
            if (r14 == null) goto L33;
            BenefitStore r15 = r14.n1();
            if (r15 == null) goto L33;
            if (r15.hasBenefit("common_wiki_node_management") == true) goto L33;
        L34:
            if (r6 == false) goto L36;
        L39:
            r8.i(2131387817, false);
            return;
        L36:
            if (this.d.g() == true) goto L38;
            return;
        L38:
            if (r9.u == true) goto L39;
            return;
        L33:
            r6 = false;
            goto L34
        L23:
            if (r9.e() == true) goto L39;
        L11:
            if ((r11 instanceof WikiScrollTextView) == false) goto L13;
            ((WikiScrollTextView) r11).b = r10;
            goto L13
        L5:
            if (TextUtils.equals(r3.q, r4) == false) goto L7;
            r5 = true;
            goto L8
        }

        public final void B2(WikItemRootView r7, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r8, boolean r9) {
            Intrinsics.checkNotNullParameter(r7, "view");
            Intrinsics.checkNotNullParameter(r8, "node");
            boolean r1 = com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a();
            if (r8.h != 2) goto L17;
            if (r1 == false) goto L17;
            ce5.a r2 = this.d.getUserComponentAbility();
            if (r2 == null) goto L14;
            BenefitManagerAPI r3 = r2.g;
            if (r3 == null) goto L14;
            BenefitStore r4 = r3.n1();
            if (r4 == null) goto L14;
            if (r4.hasBenefit("common_wiki_node_management") == true) goto L14;
            boolean r5 = true;
        L15:
            if (r5 == true) goto L17;
            boolean r6 = true;
        L18:
            r7.setCreateButtonVisible(r6);
            r7.setIconPadding(this.d.getIndicatorPadding());
            r7.setSwipeMenuEnable(false);
            boolean r10 = this.d.A;
            Intrinsics.checkNotNullParameter(r8, "node");
            int r11 = g.a;
            Intrinsics.checkNotNullParameter(r8, "node");
            if (r8.d() == false) goto L22;
            String r0 = eu5.b.a.getString(2131887467);
            Intrinsics.checkNotNull(r0);
        L25:
            r7.setTitle(r0);
            com.bytedance.ee.bear.wikiv2.icon.d r12 = this.a;
            com.bytedance.ee.bear.wikiv2.icon.c r13 = new com.bytedance.ee.bear.wikiv2.icon.c();
            r13.a = false;
            r13.b = false;
            r13.c = false;
            r13.d = this.b;
            r13.e = this.c;
            Unit r14 = Unit.INSTANCE;
            r12.a(r8, r7, r13, this.d.getUserComponentAbility());
            r7.setExpand(r8.p);
            if (r9 == false) goto L28;
            int r15 = -1;
        L29:
            com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.a r16 = r7.q;
            if (r16 == null) goto L34;
            WikiHorizontalScrollView r17 = r16.b;
            if (r17 == null) goto L34;
            r7.setScrollX(-r17.getScrollX());
        L34:
            r7.k(r15);
            r7.setExpandClickListener(new e(this.d, r8));
            Ref.BooleanRef r18 = new Ref.BooleanRef();
            r18.element = true;
            Iterator<Function<com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j, Boolean>> r19 = this.d.getEnableRootCheckers().iterator();
        L36:
            if (r19.hasNext() == false) goto L41;
            if (((Boolean) r19.next().apply(r8)).booleanValue() == true) goto L36;
            r18.element = false;
        L41:
            if (r18.element == false) goto L43;
            r7.setFocus(TextUtils.equals(r8.b, this.d.getFocusToken()));
        L43:
            r7.setItemClickListener(new f(r18, this.d, r8, r7));
            return;
        L28:
            r15 = this.d.getWikiUIList().d(r8.n);
            goto L29
        L22:
            if (TextUtils.equals("wikiroot%shared", com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.c(r8.n, 0)) == false) goto L24;
            r0 = eu5.b.a.getString(2131888911);
            Intrinsics.checkNotNull(r0);
            goto L25
        L24:
            r0 = eu5.b.a.getString(2131888792);
            Intrinsics.checkNotNull(r0);
        L14:
            r5 = false;
        L17:
            r6 = false;
            goto L18
        }
    }

    public static final class a {
    }

    public interface b {
        void a(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r1, int r2, View r3);

        void b(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r1, boolean r2);

        void c(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r1);

        void d(WikiHomePageV2 r1);

        void e(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r1);

        void f(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r1, boolean r2);

        void g(String r1, String r2);

        void h(View r1);

        void i(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r1, boolean r2);
    }

    public static final class c implements Runnable {
        public final /* synthetic */ WikiTreeView a;
        public final /* synthetic */ int b;

        @Override // java.lang.Runnable
        public final void run() {
            WikiTreeView r0 = this.a;     // Catch: Throwable -> L4
            int r1 = this.b;     // Catch: Throwable -> L4
            int r2 = WikiTreeView.E;     // Catch: Throwable -> L4
            r0.i(r1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(WikiTreeView r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public WikiTreeView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 12, 0);
    }

    public WikiTreeView(Context r8, AttributeSet r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, r10, 8, 0);
    }

    public List<RecyclerView.ItemDecoration> getDefaultItemDecorations() {
        return CollectionsKt.listOf(new RecyclerView.ItemDecoration[]{new WikiDividerDecoration(getContext()), new WikiItemBackgroundDecoration(getContext())});
    }

    public final void a() {
        ViewGroup.MarginLayoutParams r1 = null;
        if (this.v != null) goto L9;
        CommonRecyclerView r0 = getRecyclerViewFromXml();
        if (r0 == null) goto L7;
        Integer r2 = Integer.valueOf(r0.getPaddingTop());
    L8:
        this.v = r2;
        goto L9
    L7:
        r2 = null;
    L9:
        WikItemHomePageView r3 = getStickyHeadHomePageFromXml();
        int r4 = 0;
        if (r3 != null) goto L13;
    L11:
        int r5 = 0;
    L33:
        if (this.w != r5) goto L35;
        return;
    L35:
        this.w = r5;
        Integer r6 = this.v;
        if (r6 == null) goto L38;
        int r7 = r6.intValue();
    L39:
        CommonRecyclerView r8 = getRecyclerViewFromXml();
        if (r8 == null) goto L54;
        CommonRecyclerView r9 = getRecyclerViewFromXml();
        if (r9 == null) goto L44;
        int r10 = r9.getPaddingLeft();
    L45:
        int r11 = r7 + this.w;
        CommonRecyclerView r12 = getRecyclerViewFromXml();
        if (r12 == null) goto L48;
        int r13 = r12.getPaddingRight();
    L49:
        CommonRecyclerView r14 = getRecyclerViewFromXml();
        if (r14 == null) goto L52;
        r4 = r14.getPaddingBottom();
    L52:
        r8.setPadding(r10, r11, r13, r4);
        return;
    L48:
        r13 = 0;
        goto L49
    L44:
        r10 = 0;
        goto L45
    L54:
        return;
    L38:
        r7 = 0;
        goto L39
    L13:
        if (r3.getVisibility() == 8) goto L11;
        ViewGroup.LayoutParams r15 = r3.getLayoutParams();
        if ((r15 instanceof ViewGroup.MarginLayoutParams) == false) goto L18;
        r1 = (ViewGroup.MarginLayoutParams) r15;
    L18:
        if (r1 == null) goto L20;
        int r16 = r1.topMargin;
    L21:
        ViewGroup.LayoutParams r17 = r3.getLayoutParams();
        if (r17 == null) goto L24;
        int r18 = r17.height;
    L26:
        if (r3.getHeight() <= 0) goto L28;
        r18 = r3.getHeight();
    L31:
        r5 = r18 + r16;
        goto L33
    L28:
        if (r18 > 0) goto L31;
        r18 = r3.getMeasuredHeight();
        goto L31
    L24:
        r18 = 0;
        goto L26
    L20:
        r16 = 0;
        goto L21
    }

    public final boolean g() {
        return ((Boolean) this.D.getValue()).booleanValue();
    }

    public final List<Function<com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j, Boolean>> getEnableRootCheckers() {
        List<? extends Function<com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j, Boolean>> r0 = this.m;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("enableRootCheckers");
        return null;
    }

    public final InterceptableRecyclerView getRecyclerViewFromXml() {
        CommonRecyclerView r0 = this.a;
        if (r0 != null) goto L6;
        r0 = findViewById(2131384076);
        this.a = (InterceptableRecyclerView) r0;
    L6:
        return (InterceptableRecyclerView) r0;
    }

    public final StickyHeadContainer getStickyHeadContainerFromXml() {
        StickyHeadContainer r0 = this.b;
        if (r0 != null) goto L6;
        r0 = findViewById(2131387356);
        this.b = r0;
    L6:
        return r0;
    }

    public final WikItemRootView getStickyHeadFromXml() {
        KeyEvent.Callback r0 = this.c;
        if (r0 != null) goto L6;
        r0 = findViewById(2131387355);
        this.c = (WikItemRootView) r0;
    L6:
        return (WikItemRootView) r0;
    }

    public final WikItemHomePageView getStickyHeadHomePageFromXml() {
        KeyEvent.Callback r0 = this.d;
        if (r0 != null) goto L6;
        r0 = findViewById(2131387358);
        this.d = (WikItemHomePageView) r0;
    L6:
        return (WikItemHomePageView) r0;
    }

    public WikiAdapter getWikiAdapter() {
        return new WikiAdapter(this);
    }

    public void d() {
        c(getRecyclerViewFromXml());
        getRecyclerViewFromXml().setItemAnimator(new DefaultItemAnimator());
        getRecyclerViewFromXml().setLayoutManager(this.f);
        getRecyclerViewFromXml().setAdapter(this.e);
        InterceptableRecyclerView r0 = getRecyclerViewFromXml();
        if ((r0 instanceof CommonRecyclerView) == false) goto L5;
        r0.setSceneTag("bear_wiki_tree_view");
    L5:
        com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.a r1 = this.g;
        r1.getClass();
        Intrinsics.checkNotNullParameter(this, "root");
        r1.d = this;
        r1.b = (WikiHorizontalScrollView) findViewById(2131393269);
        final RecyclerView r2 = findViewById(2131384076);
        r1.c = r2;
        if (r2 == null) goto L11;
        r2.addOnLayoutChangeListener(new vq5.a(r2, r1, this));
        r2.addOnScrollListener(new WikiHoriScrollManager$initScrollViews$1$2(r2));
        SimpleItemAnimator r3 = r2.getItemAnimator();
        if (r3 == null) goto L11;
        r3.setSupportsChangeAnimations(false);
    L11:
        if (qc5.a.h() == true) goto L13;
    L17:
        WikiHorizontalScrollView r4 = r1.b;
        if (r4 == null) goto L21;
        r4.setScrollChangeListener(new com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.b(r1));
        return;
    L21:
        return;
    L13:
        if ((r1.d instanceof SidebarTreeView) == false) goto L17;
        WikiHorizontalScrollView r5 = r1.b;
        if (r5 == null) goto L17;
        r5.setHorizontalScrollBarEnabled(false);
        goto L17
    }

    public final void h() {
        WikItemHomePageView r0 = getStickyHeadHomePageFromXml();
        if (r0 != null) goto L5;
        return;
    L5:
        UserSession r2 = null;
        if (g() == true) goto L9;
        this.u = null;
        r0.setVisibility(8);
        return;
    L9:
        Integer r1 = this.B;
        if (r1 != null) goto L13;
    L14:
        if (r1 != null) goto L17;
    L19:
        boolean r3 = false;
    L21:
        if (r3 == false) goto L24;
        r0.setVisibility(8);
        a();
        return;
    L24:
        WikiHomePageV2 r4 = this.u;
        if (r4 != null) goto L27;
    L40:
        r0.setVisibility(8);
        a();
        return;
    L27:
        if (r4.isValid() == false) goto L40;
        r0.setVisibility(0);
        r0.setTitle(r4.title);
        boolean r5 = TextUtils.equals(this.q, r4.wikiToken);
        r0.setFocus(r5);
        a();
        if (qc5.a.h() == true) goto L34;
        if (r5 == true) goto L34;
        IconShape r6 = IconShape.SQUARE_OUTLINE;
    L35:
        IconShape r8 = r6;
        ImageView r7 = r0.getItemIcon();
        String r9 = r4.objToken;
        int r10 = r4.objType;
        Boolean r11 = Boolean.FALSE;
        obb.a r12 = new obb.a(r11, r11, null);
        r12.b(IconScene.WIKI);
        ce5.a r13 = this.p;
        if (r13 == null) goto L38;
        r2 = r13.b;
    L38:
        r12.g = r2;
        Unit r14 = Unit.INSTANCE;
        mbb.c.d(r7, r9, r10, null, r8, r12);
        return;
    L34:
        r6 = IconShape.SQUARE;
        goto L35
    L17:
        if (r1.intValue() != 3) goto L19;
    L20:
        r3 = true;
        goto L21
    L13:
        if (r1.intValue() == 2) goto L20;
        goto L14
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c r0 = this.C;
        if (r0 == null) goto L6;
        removeCallbacks(r0);
        return;
    }

    public final String getDisableToken() {
        return this.j;
    }

    public final boolean getEnableDiffRender() {
        return this.l;
    }

    public final boolean getEnableSwipeMenu() {
        return this.k;
    }

    public final String getFocusToken() {
        return this.q;
    }

    public final Fragment getFragment() {
        return this.y;
    }

    public final int getIndicatorPadding() {
        return this.n;
    }

    public final LinearLayoutManager getLinearLayoutManager() {
        return this.f;
    }

    public final b getListener() {
        return this.i;
    }

    public final com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.a getScrollManager() {
        return this.g;
    }

    public final String getSource() {
        return this.x;
    }

    public final String getSpaceId() {
        return this.z;
    }

    public final Integer getSpaceType() {
        return this.B;
    }

    public final int getTitleRightMargin() {
        return this.o;
    }

    public final ce5.a getUserComponentAbility() {
        return this.p;
    }

    public final d3 getWikiUIList() {
        return this.h;
    }

    public final RecyclerView.ViewHolder b(int r5) {
        if (r5 < 0) goto L29;
        int r6 = r5 + this.e.getHeaderLayoutCount();
        boolean r2 = false;
        if (g() == true) goto L7;
    L16:
        if (r2 == false) goto L21;
        InterceptableRecyclerView r1 = getRecyclerViewFromXml();
        if (r1 != null) goto L20;
        return null;
    L20:
        return r1.findViewHolderForAdapterPosition(r6);
    L21:
        int r3 = this.f.findFirstVisibleItemPosition();
        if (r3 == (-1)) goto L29;
        int r7 = r6 - r3;
        if (r7 < 0) goto L29;
        View r8 = getRecyclerViewFromXml().getChildAt(r7);
        if (r8 == null) goto L29;
        return getRecyclerViewFromXml().getChildViewHolder(r8);
    L7:
        if (this.u == null) goto L16;
        WikItemHomePageView r4 = getStickyHeadHomePageFromXml();
        if (r4 != null) goto L11;
    L13:
        boolean r9 = false;
    L14:
        if (r9 == false) goto L16;
        r2 = true;
        goto L16
    L11:
        if (r4.getVisibility() != 0) goto L13;
        r9 = true;
    L29:
        return null;
    }

    public void c(InterceptableRecyclerView r4) {
        Intrinsics.checkNotNullParameter(r4, "recyclerView");
        getStickyHeadContainerFromXml().setDataCallback(new v1(this));
        WikItemHomePageView r0 = getStickyHeadHomePageFromXml();
        if (g() == false) goto L6;
        if (r0 == null) goto L6;
        r0.setVisibility(4);
        r0.setItemClickListener(new w1(this));
        r0.addOnLayoutChangeListener(new x1(this));
    L6:
        StickyItemDecoration r1 = new StickyItemDecoration(getStickyHeadContainerFromXml(), WikNodeType.ROOT.getValue());
        r1.h = new y1(this);
        r4.addItemDecoration(r1);
    }

    public final boolean e(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r5) {
        Intrinsics.checkNotNullParameter(r5, "node");
        if (TextUtils.isEmpty(this.j) == false) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L11;
        return false;
    L11:
        if (bx4.b.b(r5.b) == false) goto L14;
        return true;
    L14:
        return r5.r;
    L5:
        if (TextUtils.equals(this.j, r5.b) == false) goto L7;
        r0 = true;
        goto L8
    }

    public final boolean f(String r5) {
        if (TextUtils.isEmpty(r5) == true) goto L13;
        d3 r0 = this.h;
        Intrinsics.checkNotNull(r5);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, "uid");
        if (TextUtils.isEmpty(r5) == false) goto L7;
    L9:
        boolean r6 = false;
    L10:
        if (r6 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r0.c.containsKey(r5) == false) goto L9;
        r6 = true;
        goto L10
    L13:
        return false;
    }

    public final void i(int r3) {
        int r0 = this.e.getHeaderLayoutCount() + r3;
        int r1 = getHeight();
        if (r1 <= 0) goto L6;
        this.e.getClass();
        int r2 = (r1 / 2) - (cu5.c.a(48.0f) / 2);
        this.f.scrollToPositionWithOffset(r0, r2);
        return;
    L6:
        tt5.a.h("Wiki_WikiTreeRvView", "WikiTreeRvView.scrollToCenter(), total height is 0, post delay");
        Runnable r4 = this.C;
        if (r4 == null) goto L9;
        removeCallbacks(r4);
    L9:
        c r5 = new c(this, r3);
        this.C = r5;
        post(r5);
    }

    public final void j(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        if (f(r2) == true) goto L5;
        return;
    L5:
        i(this.h.d(r2));
    }

    public final void setData(d3 r6) {
        Intrinsics.checkNotNullParameter(r6, WikiFolderPushPlugin.DATA);
        d3 r0 = this.h;
        this.h = r6;
        this.e.E2(r6.a);
        d3 r7 = this.h;
        if (r7.b < 8) goto L5;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == false) goto L13;
        this.e.notifyDataSetChanged();
        return;
    L13:
        WikiAdapter r2 = this.e;
        String r3 = this.t;
        String r4 = this.q;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r0, "olds");
        Intrinsics.checkNotNullParameter(r7, "news");
        DiffUtil.calculateDiff(new WikiDiffCallback(r0, r7, r3, r4)).dispatchUpdatesTo(new WikiListUpdateCallback(r2));
        return;
    L5:
        if (r0.b >= 8) goto L10;
        if (this.l == false) goto L10;
        r1 = false;
        goto L11
    }

    public final void setDisableToken(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.j = r2;
    }

    public final void setEnableDiffRender(boolean r1) {
        this.l = r1;
    }

    public final void setEnableRootCheckers(List<? extends Function<com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j, Boolean>> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.m = r2;
    }

    public final void setEnableSwipeMenu(boolean r1) {
        this.k = r1;
    }

    public final void setFocusToken(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.q = r2;
    }

    public final void setFooter(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        int r0 = this.e.getFooterLayoutCount();
        tt5.a.h("Wiki_WikiTreeRvView", "setFooter. count= " + r0);
        if (r0 != 0) goto L6;
        this.e.setFooterView(r4);
        this.e.notifyDataSetChanged();
        return;
    }

    public final void setFragment(Fragment r1) {
        this.y = r1;
    }

    public void setItemDecorations(List<? extends RecyclerView.ItemDecoration> r3) {
        if (r3 == null) goto L7;
        Iterator<? extends RecyclerView.ItemDecoration> r4 = r3.iterator();
    L5:
        if (r4.hasNext() == false) goto L7;
        RecyclerView.ItemDecoration r0 = r4.next();
        getRecyclerViewFromXml().addItemDecoration(r0);
    L7:
        Iterator<T> r5 = getDefaultItemDecorations().iterator();
    L9:
        if (r5.hasNext() == false) goto L13;
        RecyclerView.ItemDecoration r1 = (RecyclerView.ItemDecoration) r5.next();
        InterceptableRecyclerView r2 = getRecyclerViewFromXml();
        if (r2 == null) goto L9;
        r2.addItemDecoration(r1);
        goto L9
    }

    public final void setListener(b r1) {
        this.i = r1;
    }

    public final void setMyLib(boolean r1) {
        this.A = r1;
    }

    public final void setRecyclerViewFromXml(InterceptableRecyclerView r1) {
        this.a = r1;
    }

    public final void setSource(String r1) {
        this.x = r1;
    }

    public final void setSpaceId(String r2) {
        this.z = r2;
        WikiHorizontalScrollView r0 = this.g.b;
        if (r0 == null) goto L8;
        if (r2 != null) goto L6;
        r2 = "";
    L6:
        r0.e = r2;
        return;
    }

    public final void setSpaceType(Integer r1) {
        this.B = r1;
    }

    public final void setStickyHeadContainerFromXml(StickyHeadContainer r1) {
        this.b = r1;
    }

    public final void setStickyHeadFromXml(WikItemRootView r1) {
        this.c = r1;
    }

    public final void setStickyHeadHomePageFromXml(WikItemHomePageView r1) {
        this.d = r1;
    }

    public final void setTitleRightMargin(int r1) {
        this.o = r1;
    }

    public final void setUserComponentAbility(ce5.a r1) {
        this.p = r1;
    }

    public final void setWikiUIList(d3 r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.h = r2;
    }

    public final void k(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r3, "uid");
        this.t = this.q;
        this.q = r2;
        this.s = this.r;
        this.r = r3;
        h();
        b r0 = this.i;
        if (r0 == null) goto L6;
        r0.g(r2, r3);
        return;
    }

    public final void l(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r4, "uid");
        if (this.h.c(r3) == true) goto L5;
        return;
    L5:
        k(r3, r4);
        if (ForsetiHelper.p() == true) goto L8;
    L10:
        boolean r5 = false;
    L11:
        if (r5 == true) goto L13;
        this.e.notifyDataSetChanged();
        return;
    L13:
        if (TextUtils.isEmpty(this.s) == true) goto L15;
        int r6 = this.h.d(this.s);
    L16:
        int r7 = this.h.d(r4);
        int r0 = this.e.getHeaderLayoutCount();
        if (r6 < 0) goto L19;
        this.e.notifyItemChanged(r6 + r0);
    L19:
        if (r7 < 0) goto L23;
        this.e.notifyItemChanged(r7 + r0);
        return;
    L23:
        return;
    L15:
        r6 = -1;
        goto L16
    L8:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.wiki_tree_disabled_notify_all") == false) goto L10;
        r5 = true;
        goto L11
    }

    public final void m(String r2, boolean r3) {
        if (f(r2) == true) goto L5;
        return;
    L5:
        d3 r0 = this.h;
        Intrinsics.checkNotNull(r2);
        RecyclerView.ViewHolder r4 = b(r0.d(r2));
        if (r4 == null) goto L12;
        View r5 = r4.itemView;
        if ((r5 instanceof WikItemDirView) == false) goto L13;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemDirView");
        ((WikItemDirView) r5).setLoading(r3);
        return;
    L13:
        return;
    }

    public final void n(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        if (f(r2) == true) goto L5;
        return;
    L5:
        RecyclerView.ViewHolder r4 = b(this.h.d(r2));
        if (r4 == null) goto L15;
        KeyEvent.Callback r5 = r4.itemView;
        if ((r5 instanceof d) == false) goto L17;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.ISwipeMenuItem");
        d r6 = (d) r5;
        if (r3 == false) goto L13;
        r6.b();
        return;
    L13:
        r6.a();
        return;
    L17:
        return;
    }

    public WikiTreeView(Context r2, AttributeSet r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4, r5);
        this.e = getWikiAdapter();
        this.f = new LinearLayoutManager(getContext());
        this.g = new com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.a(this instanceof SidebarTreeView);
        d3 r6 = d3.e;
        this.h = d3.e;
        this.j = "";
        this.n = r2.getResources().getDimensionPixelSize(2131168333);
        this.q = "";
        this.r = "";
        this.s = "";
        this.t = "";
        this.z = "";
        this.D = LazyKt.lazy(WikiTreeView$isWikiRootCustomHomePageEnable$2.INSTANCE);
        LayoutInflater r7 = LayoutInflater.from(r2);
        int r8 = com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.a.f;
        r7.inflate(2131568277, this);
        d();
    }

    public /* synthetic */ WikiTreeView(Context r1, AttributeSet r2, int r3, int r4, int r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = 0;
    L5:
        this(r1, r2, r3, 0);
    }
}
